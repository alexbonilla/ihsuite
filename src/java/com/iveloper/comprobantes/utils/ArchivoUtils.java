/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.utils;


import com.iveloper.ihsuite.db.ihOperations;
import com.sun.xml.bind.marshaller.DataWriter;
import ec.gob.sri.comprobantes.ws.aut.Autorizacion;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.Writer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Alex
 */
public class ArchivoUtils {

    private static final String configuration_path = System.getProperty("confPath");

    public static byte[] convertirArchivoAByteArray(File file) throws IOException {
        byte[] buffer = new byte[(int) file.length()];
        InputStream ios = null;
        try {
            ios = new FileInputStream(file);
            if (ios.read(buffer) == -1) {
                throw new IOException("EOF reached while trying to read the whole file");
            }
        } catch (IOException ex) {
            buffer = null;
        } finally {
            try {
                if (ios != null) {
                    ios.close();
                }
            } catch (IOException e) {
            }
        }
        return buffer;
    }

    private static String seleccionaXsd(String tipo) {
        String nombreXsd = null;
        if (tipo.equals(TipoComprobanteEnum.FACTURA.getCode())) {
            nombreXsd = TipoComprobanteEnum.FACTURA.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getCode())) {
            nombreXsd = TipoComprobanteEnum.COMPROBANTE_DE_RETENCION.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.GUIA_DE_REMISION.getCode())) {
            nombreXsd = TipoComprobanteEnum.GUIA_DE_REMISION.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_CREDITO.getCode())) {
            nombreXsd = TipoComprobanteEnum.NOTA_DE_CREDITO.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.NOTA_DE_DEBITO.getCode())) {
            nombreXsd = TipoComprobanteEnum.NOTA_DE_DEBITO.getXsd();
        } else if (tipo.equals(TipoComprobanteEnum.LOTE.getCode())) {
            nombreXsd = TipoComprobanteEnum.LOTE.getXsd();
        }
        return nombreXsd;
    }

    public static String validarContraEsquema(ihOperations dbOperations, String tipoComprobante, InputStream xmlis) throws SQLException {
        String respuestaValidacion = null;
        String nombreXsd = seleccionaXsd(tipoComprobante);
        InputStream xsdis = dbOperations.getSchemaValidator(nombreXsd);
        ValidadorEstructuraDocumento validador = new ValidadorEstructuraDocumento(xsdis, xmlis);
        if (xmlis != null) {
            respuestaValidacion = validador.validacion();
        }
        return respuestaValidacion;
    }

    public static void convertirCadenaAArchivo(String ruta, String contenido) {
        FileOutputStream fop = null;
        File file;
        try {
            file = new File(ruta);
            fop = new FileOutputStream(file);
            if (!file.exists()) {
                file.createNewFile();
            }
            byte[] contentInBytes = contenido.getBytes();
            fop.write(contentInBytes);
            fop.flush();
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void guardarDocumento(Autorizacion autorizacion, String ruta) throws JAXBException, IOException {

        Autorizacion objAutorizacion = new Autorizacion();

        objAutorizacion.setComprobante((new StringBuilder()).append("<![CDATA[").append(autorizacion.getComprobante()).append("]]>").toString());
        objAutorizacion.setEstado(autorizacion.getEstado());
        objAutorizacion.setFechaAutorizacion(autorizacion.getFechaAutorizacion());
        objAutorizacion.setMensajes(autorizacion.getMensajes());
        objAutorizacion.setNumeroAutorizacion(autorizacion.getNumeroAutorizacion());

        JAXBContext jaxbContext = JAXBContext.newInstance(Autorizacion.class);
        Marshaller marshaller = jaxbContext.createMarshaller();

        // Set UTF-8 Encoding
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        //StringWriter stringWriter = new StringWriter();
        //PrintWriter printWriter = new PrintWriter(stringWriter);
        Writer writer = new FileWriter(ruta);
        DataWriter dataWriter = new DataWriter(writer, "UTF-8", new JaxbCharacterEscapeHandler());

        // Perform Marshalling operation
        marshaller.marshal(objAutorizacion, dataWriter);
        writer.close();

    }

    public static Document stringToDom(String xmlSource)
            throws SAXException, ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xmlSource)));
    }

    public static InputStream xmlStringToInputStream(String xmlString) throws TransformerConfigurationException, SAXException, TransformerException, ParserConfigurationException, IOException {
        Logger.getLogger(ArchivoUtils.class.getName()).log(Level.INFO, "Convirtiendo xmlString en InputStream.");
        Document xmlDoc = stringToDom(xmlString);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Source xmlSource = new DOMSource(xmlDoc);
        Result outputTarget = new StreamResult(outputStream);
        TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);
        InputStream is = new ByteArrayInputStream(outputStream.toByteArray());
        return is;
    }
    
    public static ByteArrayOutputStream xmlStringToByteArrayOutputStream(String xmlString) throws TransformerConfigurationException, SAXException, TransformerException, ParserConfigurationException, IOException {
        Logger.getLogger(ArchivoUtils.class.getName()).log(Level.INFO, "Convirtiendo xmlString en ByteArrayOutputStream.");
        Document xmlDoc = stringToDom(xmlString);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Source xmlSource = new DOMSource(xmlDoc);
        Result outputTarget = new StreamResult(outputStream);
        TransformerFactory.newInstance().newTransformer().transform(xmlSource, outputTarget);        
        return outputStream;
    }
}
