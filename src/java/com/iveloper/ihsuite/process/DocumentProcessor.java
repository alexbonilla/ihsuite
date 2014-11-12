/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.ihsuite.process;

import com.iveloper.comprobantes.modelo.factura.Factura;
import com.iveloper.comprobantes.modelo.ws.AutorizacionComprobantesWs;
import com.iveloper.comprobantes.modelo.ws.EnvioComprobantesWs;
import com.iveloper.comprobantes.utils.CertificadosSSL;
import com.iveloper.ihsuite.db.ihOperations;
import com.iveloper.ihsuite.entities.SuiteDocument;
import com.iveloper.ihsuite.utils.WSUtil;
import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import ec.gob.sri.comprobantes.ws.aut.Mensaje;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante;
import ec.gob.sri.comprobantes.ws.aut.RespuestaComprobante.Autorizaciones;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Alex
 */
public class DocumentProcessor implements Runnable {

    private int TIEMPO_ESPERA_SOLICITAR_AUTORIZACION = 3000;
    private SuiteDocument sdoc;
    private String ambiente;
    private ihOperations dbOperations;

    public SuiteDocument getSdoc() {
        return sdoc;
    }

    public void setSdoc(SuiteDocument sdoc) {
        this.sdoc = sdoc;
    }

    public String getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    public ihOperations getDbOperations() {
        return dbOperations;
    }

    public void setDbOperations(ihOperations dbOperations) {
        this.dbOperations = dbOperations;
    }

    @Override
    public void run() {
        completeProcess();
    }

    private void completeProcess() {
        try {
            dbOperations.connect();
            RespuestaSolicitud resultadoRecepcion = enviarComprobante(sdoc, ambiente);
            Logger.getLogger(DocumentProcessor.class.getName()).log(Level.INFO, "Estado de documento: {0}.", resultadoRecepcion.getEstado());
            Logger.getLogger(DocumentProcessor.class.getName()).log(Level.INFO, "Detalle: {0}.", EnvioComprobantesWs.obtenerMensajeRespuesta(resultadoRecepcion));
            dbOperations.updateSuiteDocumentStatus(sdoc.getDocumentId().toString(), resultadoRecepcion.getEstado());
            String claveacceso = getClaveAcceso(sdoc);
            if (resultadoRecepcion.getEstado().equals("RECIBIDA")) {
                Thread.sleep(TIEMPO_ESPERA_SOLICITAR_AUTORIZACION);
                Autorizacion autComprobanteIndividual = autorizarComprobanteIndividual(claveacceso, ambiente);
                byte[] documento = convertAutorizacionToByteArrayOutputStream(autComprobanteIndividual).toByteArray();
                if (autComprobanteIndividual.getEstado().equals("AUTORIZADO")) {
                    String docAutorizacion = autComprobanteIndividual.getNumeroAutorizacion();
                    Date docAutorizacionDate = autComprobanteIndividual.getFechaAutorizacion().toGregorianCalendar().getTime();
                    dbOperations
                            .updateSuiteDocumentAutorizacion(sdoc.getDocumentId().toString(), documento, autComprobanteIndividual.getEstado(), docAutorizacion, docAutorizacionDate);
                } else {
                    dbOperations.updateSuiteDocumentContent(sdoc.getDocumentId().toString(), documento, autComprobanteIndividual.getEstado());
                }

                verifyAuthorizationLog(autComprobanteIndividual);
            }
            dbOperations.disconnect();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DocumentProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(DocumentProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verifyAuthorization() {
        try {
            dbOperations.connect();
            String claveacceso = getClaveAcceso(sdoc);
            Autorizacion autComprobanteIndividual = autorizarComprobanteIndividual(claveacceso, ambiente);
            byte[] documento = convertAutorizacionToByteArrayOutputStream(autComprobanteIndividual).toByteArray();
            if (autComprobanteIndividual.getEstado().equals("AUTORIZADO")) {
                String docAutorizacion = autComprobanteIndividual.getNumeroAutorizacion();
                Date docAutorizacionDate = autComprobanteIndividual.getFechaAutorizacion().toGregorianCalendar().getTime();
                dbOperations
                        .updateSuiteDocumentAutorizacion(sdoc.getDocumentId().toString(), documento, autComprobanteIndividual.getEstado(), docAutorizacion, docAutorizacionDate);
            } else {
                dbOperations.updateSuiteDocumentContent(sdoc.getDocumentId().toString(), documento, autComprobanteIndividual.getEstado());
            }

            dbOperations.disconnect();
            verifyAuthorizationLog(autComprobanteIndividual);
        } catch (SQLException | JAXBException | IOException | SAXException | ParserConfigurationException | ClassNotFoundException ex) {
            Logger.getLogger(DocumentProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void verifyAuthorizationLog(Autorizacion aut) {
        Logger.getLogger(DocumentProcessor.class.getName()).log(Level.INFO, "Estado de documento: {0}", aut.getEstado());

        StringBuilder msgAutorizacion = new StringBuilder();
        String estado = aut.getEstado().toUpperCase();
        if (estado.compareTo("AUTORIZADO") == 0) {
            msgAutorizacion.append(estado);
        } else {
            List<Mensaje> mensajes = aut.getMensajes().getMensaje();
            for (Mensaje mensaje : mensajes) {
                msgAutorizacion.append("NO AUTORIZADO").append(".").append(mensaje.getTipo()).append(".").append(mensaje.getIdentificador()).append(".").append(mensaje.getMensaje()).append(".").append(mensaje.getInformacionAdicional()).append("\n");
            }
        }
        Logger.getLogger(DocumentProcessor.class.getName()).log(Level.INFO, "Detalles: {0}", msgAutorizacion.toString());
    }

    public RespuestaSolicitud enviarComprobante(SuiteDocument sdoc, String ambiente) throws MalformedURLException, Exception {
        CertificadosSSL.instalarCertificados();
        EnvioComprobantesWs ec = new EnvioComprobantesWs(WSUtil.devuelveUrlWs(ambiente, "RecepcionComprobantes"));
        RespuestaSolicitud response = ec.enviarComprobante(sdoc.getBos());
        return response;
    }

    public Autorizacion autorizarComprobanteIndividual(String claveDeAcceso, String tipoAmbiente) throws JAXBException, IOException {
        CertificadosSSL.instalarCertificados();
        RespuestaComprobante respuesta = (new AutorizacionComprobantesWs(WSUtil.devuelveUrlWs(tipoAmbiente, "AutorizacionComprobantes"))).llamadaWSAutorizacionInd(claveDeAcceso);
        Autorizaciones autorizaciones = respuesta.getAutorizaciones();
        ArrayList<Autorizacion> autorizacionesList = new ArrayList(autorizaciones.getAutorizacion());
        Autorizacion aut = null;
        for (Autorizacion autorizacion : autorizacionesList) {
            aut = autorizacion;
        }
        return aut;
    }

    public String getClaveAcceso(SuiteDocument sdoc) throws JAXBException, SAXException, IOException, ParserConfigurationException {
        String claveacceso = null;
        switch (sdoc.getDocTypeCode()) {
            case "01":
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setNamespaceAware(true);
                DocumentBuilder db = dbf.newDocumentBuilder();
                Document doc = db.parse(new InputSource(new ByteArrayInputStream(sdoc.getBos().toByteArray())));

                JAXBContext jaxbContext = JAXBContext.newInstance(new Class[]{Factura.class});
                Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

                Factura factura = (Factura) unmarshaller.unmarshal(doc);
                claveacceso = factura.getInfoTributaria().getClaveAcceso();
                break;
        }
        Logger.getLogger(DocumentProcessor.class.getName()).log(Level.INFO, "Clave de acceso: {0}", claveacceso);
        return claveacceso;
    }

    public ByteArrayOutputStream convertAutorizacionToByteArrayOutputStream(Autorizacion aut) {
        try {
            com.iveloper.comprobantes.autorizacion.Autorizacion autorizacion = new com.iveloper.comprobantes.autorizacion.Autorizacion();
            String comprobante = aut.getComprobante();
            comprobante = comprobante.replaceAll("&lt;", "<").replaceAll("&gt;", ">");
            autorizacion.setComprobante((new StringBuilder()).append("<![CDATA[").append(comprobante).append("]]>").toString());
            autorizacion.setEstado(aut.getEstado());
            autorizacion.setFechaAutorizacion(aut.getFechaAutorizacion());
            autorizacion.setMensajes(aut.getMensajes());
            autorizacion.setNumeroAutorizacion(aut.getNumeroAutorizacion());
            JAXBContext context = JAXBContext.newInstance(new Class[]{com.iveloper.comprobantes.autorizacion.Autorizacion.class});
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(bos, "UTF-8");
            marshaller.marshal(autorizacion, out);
            //out = new OutputStreamWriter(new FileOutputStream("C:\\Users\\Alex\\Documents\\aut.xml"), "UTF-8");
            //marshaller.marshal(autorizacion, out);
            out.close();

            return bos;
        } catch (JAXBException | IOException ex) {
            Logger.getLogger(DocumentProcessor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
