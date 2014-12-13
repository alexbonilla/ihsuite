/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.portal.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexbonilla
 */
@Entity
@Table(name = "autorizaciones_mensajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AutorizacionesMensajes.findAll", query = "SELECT a FROM AutorizacionesMensajes a"),
    @NamedQuery(name = "AutorizacionesMensajes.findByClaveacceso", query = "SELECT a FROM AutorizacionesMensajes a WHERE a.claveacceso = :claveacceso"),
    @NamedQuery(name = "AutorizacionesMensajes.findByTipo", query = "SELECT a FROM AutorizacionesMensajes a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "AutorizacionesMensajes.findByMensaje", query = "SELECT a FROM AutorizacionesMensajes a WHERE a.mensaje = :mensaje"),
    @NamedQuery(name = "AutorizacionesMensajes.findByIdentificador", query = "SELECT a FROM AutorizacionesMensajes a WHERE a.identificador = :identificador"),
    @NamedQuery(name = "AutorizacionesMensajes.findByAutorizacionesMensajesId", query = "SELECT a FROM AutorizacionesMensajes a WHERE a.autorizacionesMensajesId = :autorizacionesMensajesId")})
public class AutorizacionesMensajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 49)
    @Column(name = "claveacceso")
    private String claveacceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "mensaje")
    private String mensaje;
    @Lob
    @Size(max = 65535)
    @Column(name = "infoadicional")
    private String infoadicional;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "identificador")
    private String identificador;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "autorizaciones_mensajes_id")
    private Integer autorizacionesMensajesId;

    public AutorizacionesMensajes() {
    }

    public AutorizacionesMensajes(Integer autorizacionesMensajesId) {
        this.autorizacionesMensajesId = autorizacionesMensajesId;
    }

    public AutorizacionesMensajes(Integer autorizacionesMensajesId, String claveacceso, String tipo, String mensaje, String identificador) {
        this.autorizacionesMensajesId = autorizacionesMensajesId;
        this.claveacceso = claveacceso;
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.identificador = identificador;
    }

    public String getClaveacceso() {
        return claveacceso;
    }

    public void setClaveacceso(String claveacceso) {
        this.claveacceso = claveacceso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getInfoadicional() {
        return infoadicional;
    }

    public void setInfoadicional(String infoadicional) {
        this.infoadicional = infoadicional;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Integer getAutorizacionesMensajesId() {
        return autorizacionesMensajesId;
    }

    public void setAutorizacionesMensajesId(Integer autorizacionesMensajesId) {
        this.autorizacionesMensajesId = autorizacionesMensajesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (autorizacionesMensajesId != null ? autorizacionesMensajesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AutorizacionesMensajes)) {
            return false;
        }
        AutorizacionesMensajes other = (AutorizacionesMensajes) object;
        if ((this.autorizacionesMensajesId == null && other.autorizacionesMensajesId != null) || (this.autorizacionesMensajesId != null && !this.autorizacionesMensajesId.equals(other.autorizacionesMensajesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iveloper.portal.entities.AutorizacionesMensajes[ autorizacionesMensajesId=" + autorizacionesMensajesId + " ]";
    }
    
}
