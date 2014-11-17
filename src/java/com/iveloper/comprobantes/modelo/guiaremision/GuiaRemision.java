/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.guiaremision;

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
@XmlRootElement(name = "guiaRemision")
@XmlType(propOrder = {
    "id", "version", "infoTributaria", "infoGuiaRemision", "destinatario", "campoAdicional"})
public class GuiaRemision {

    /**
     *
     */
    protected InfoTributaria infoTributaria;

    /**
     *
     */
    protected InfoGuiaRemision infoGuiaRemision;

    /**
     *
     */
    protected List<Destinatario> destinatario;

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
     */
    protected List<CampoAdicional> campoAdicional;

    /**
     *
     * @return
     */
    @XmlElementWrapper(name="destinatarios")
    public List<Destinatario> getDestinatario() {
        return destinatario;
    }

    /**
     *
     * @param destinatario
     */
    public void setDestinatarios(List<Destinatario> destinatario) {
        this.destinatario = destinatario;
    }

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
    public InfoGuiaRemision getInfoGuiaRemision() {
        return infoGuiaRemision;
    }

    /**
     *
     * @param infoGuiaRemision
     */
    public void setInfoGuiaRemision(InfoGuiaRemision infoGuiaRemision) {
        this.infoGuiaRemision = infoGuiaRemision;
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

    /**
     *
     * @return
     */
    @XmlElementWrapper(name = "infoAdicional")
    public List<CampoAdicional> getCampoAdicional() {
        return campoAdicional;
    }

    /**
     *
     * @param campoAdicional
     */
    public void setCampoAdicional(List<CampoAdicional> campoAdicional) {
        this.campoAdicional = campoAdicional;
    }    
}
