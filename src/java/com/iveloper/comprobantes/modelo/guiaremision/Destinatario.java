/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.guiaremision;

import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlRootElement(name = "destinatario")
@XmlType(propOrder = {
    "identificacionDestinatario", "razonSocialDestinatario", "dirDestinatario",
    "motivoTraslado", "docAduaneroUnico", "codEstabDestino",
    "ruta", "codDocSustento", "numDocSustento",
    "numAutDocSustento", "fechaEmisionDocSustento", "detalle"})
public class Destinatario {

    /**
     *
     */
    protected String identificacionDestinatario;

    /**
     *
     */
    protected String razonSocialDestinatario;

    /**
     *
     */
    protected String dirDestinatario;

    /**
     *
     */
    protected String motivoTraslado;

    /**
     *
     */
    protected String docAduaneroUnico;

    /**
     *
     */
    protected String codEstabDestino;

    /**
     *
     */
    protected String ruta;

    /**
     *
     */
    protected String codDocSustento;

    /**
     *
     */
    protected String numDocSustento;

    /**
     *
     */
    protected String numAutDocSustento;

    /**
     *
     */
    protected String fechaEmisionDocSustento;

    /**
     *
     */
    protected List<GuiaDetalle> detalle;

    /**
     *
     * @return
     */
    public String getCodDocSustento() {
        return codDocSustento;
    }

    /**
     *
     * @param codDocSustento
     */
    public void setCodDocSustento(String codDocSustento) {
        this.codDocSustento = codDocSustento;
    }

    /**
     *
     * @return
     */
    public String getCodEstabDestino() {
        return codEstabDestino;
    }

    /**
     *
     * @param codEstabDestino
     */
    public void setCodEstabDestino(String codEstabDestino) {
        this.codEstabDestino = codEstabDestino;
    }

    /**
     *
     * @return
     */
    @XmlElementWrapper(name = "detalles")
    public List<GuiaDetalle> getDetalle() {
        return detalle;
    }

    /**
     *
     * @param detalle
     */
    public void setDetalle(List<GuiaDetalle> detalle) {
        this.detalle = detalle;
    }

    /**
     *
     * @return
     */
    public String getDirDestinatario() {
        return dirDestinatario;
    }

    /**
     *
     * @param dirDestinatario
     */
    public void setDirDestinatario(String dirDestinatario) {
        this.dirDestinatario = dirDestinatario;
    }

    /**
     *
     * @return
     */
    public String getDocAduaneroUnico() {
        return docAduaneroUnico;
    }

    /**
     *
     * @param docAduaneroUnico
     */
    public void setDocAduaneroUnico(String docAduaneroUnico) {
        this.docAduaneroUnico = docAduaneroUnico;
    }

    /**
     *
     * @return
     */
    public String getFechaEmisionDocSustento() {
        return fechaEmisionDocSustento;
    }

    /**
     *
     * @param fechaEmisionDocSustento
     */
    public void setFechaEmisionDocSustento(String fechaEmisionDocSustento) {
        this.fechaEmisionDocSustento = fechaEmisionDocSustento;
    }

    /**
     *
     * @return
     */
    public String getIdentificacionDestinatario() {
        return identificacionDestinatario;
    }

    /**
     *
     * @param identificacionDestinatario
     */
    public void setIdentificacionDestinatario(String identificacionDestinatario) {
        this.identificacionDestinatario = identificacionDestinatario;
    }

    /**
     *
     * @return
     */
    public String getMotivoTraslado() {
        return motivoTraslado;
    }

    /**
     *
     * @param motivoTraslado
     */
    public void setMotivoTraslado(String motivoTraslado) {
        this.motivoTraslado = motivoTraslado;
    }

    /**
     *
     * @return
     */
    public String getNumAutDocSustento() {
        return numAutDocSustento;
    }

    /**
     *
     * @param numAutDocSustento
     */
    public void setNumAutDocSustento(String numAutDocSustento) {
        this.numAutDocSustento = numAutDocSustento;
    }

    /**
     *
     * @return
     */
    public String getNumDocSustento() {
        return numDocSustento;
    }

    /**
     *
     * @param numDocSustento
     */
    public void setNumDocSustento(String numDocSustento) {
        this.numDocSustento = numDocSustento;
    }

    /**
     *
     * @return
     */
    public String getRazonSocialDestinatario() {
        return razonSocialDestinatario;
    }

    /**
     *
     * @param razonSocialDestinatario
     */
    public void setRazonSocialDestinatario(String razonSocialDestinatario) {
        this.razonSocialDestinatario = razonSocialDestinatario;
    }

    /**
     *
     * @return
     */
    public String getRuta() {
        return ruta;
    }

    /**
     *
     * @param ruta
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
