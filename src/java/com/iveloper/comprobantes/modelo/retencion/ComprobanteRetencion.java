/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.retencion;

import com.iveloper.comprobantes.modelo.CampoAdicional;
import com.iveloper.comprobantes.modelo.InfoTributaria;
import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlRootElement(name = "comprobanteRetencion")
@XmlType(propOrder = {
    "id", "version", "infoTributaria", "infoCompRetencion", "impuesto", "campoAdicional"})
public class ComprobanteRetencion {

    /**
     *
     */
    protected InfoTributaria infoTributaria;

    /**
     *
     */
    protected InfoCompRetencion infoCompRetencion;

    /**
     *
     */
    protected List<Impuesto> impuesto;

    /**
     *
     */
    protected List<CampoAdicional> campoAdicional;

    /**
     *
     */
    protected String id;

    /**
     *
     */
    protected String version;

    /**
     *
     * @return
     */
    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @XmlElementWrapper(name="impuestos")
    public List<Impuesto> getImpuesto() {
        return impuesto;
    }

    /**
     *
     * @param impuesto
     */
    public void setImpuesto(List<Impuesto> impuesto) {
        this.impuesto = impuesto;
    }

    /**
     *
     * @return
     */
    public List<CampoAdicional> getCampoAdicional() {
        return campoAdicional;
    }

    /**
     *
     * @param campoAdicional
     */
    @XmlElementWrapper(name="infoAdicional")
    public void setCampoAdicional(List<CampoAdicional> campoAdicional) {
        this.campoAdicional = campoAdicional;
    }

    /**
     *
     * @return
     */
    public InfoCompRetencion getInfoCompRetencion() {
        return infoCompRetencion;
    }

    /**
     *
     * @param infoCompRetencion
     */
    public void setInfoCompRetencion(InfoCompRetencion infoCompRetencion) {
        this.infoCompRetencion = infoCompRetencion;
    }

    /**
     *
     * @return
     */
    public InfoTributaria getInfoTributaria() {
        return infoTributaria;
    }

    /**
     *
     * @param infoTributaria
     */
    public void setInfoTributaria(InfoTributaria infoTributaria) {
        this.infoTributaria = infoTributaria;
    }

    /**
     *
     * @return
     */
    @XmlAttribute(name = "version")
    public String getVersion() {
        return version;
    }

    /**
     *
     * @param version
     */
    public void setVersion(String version) {
        this.version = version;
    }
}