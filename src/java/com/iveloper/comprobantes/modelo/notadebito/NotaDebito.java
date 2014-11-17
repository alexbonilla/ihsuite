/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.notadebito;


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
@XmlRootElement(name = "notaDebito")
@XmlType(propOrder = {
    "id", "version", "infoTributaria", "infoNotaDebito", "motivo", "campoAdicional"})
public class NotaDebito {

    /**
     *
     */
    protected InfoTributaria infoTributaria;

    /**
     *
     */
    protected InfoNotaDebito infoNotaDebito;

    /**
     *
     */
    protected List<Motivo> motivo;

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
    @XmlElementWrapper (name="infoAdicional")
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

    /**
     *
     * @return
     */
    public InfoNotaDebito getInfoNotaDebito() {
        return infoNotaDebito;
    }

    /**
     *
     * @param infoNotaDebito
     */
    public void setInfoNotaDebito(InfoNotaDebito infoNotaDebito) {
        this.infoNotaDebito = infoNotaDebito;
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
    @XmlElementWrapper(name="motivos")
    public List<Motivo> getMotivo() {
        return motivo;
    }

    /**
     *
     * @param motivo
     */
    public void setMotivo( List<Motivo> motivo) {
        this.motivo = motivo;
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
