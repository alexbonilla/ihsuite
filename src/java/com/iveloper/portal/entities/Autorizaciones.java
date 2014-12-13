/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.portal.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alexbonilla
 */
@Entity
@Table(name = "autorizaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Autorizaciones.findAll", query = "SELECT a FROM Autorizaciones a"),
    @NamedQuery(name = "Autorizaciones.findByClaveacceso", query = "SELECT a FROM Autorizaciones a WHERE a.claveacceso = :claveacceso"),
    @NamedQuery(name = "Autorizaciones.findByAutorizacion", query = "SELECT a FROM Autorizaciones a WHERE a.autorizacion = :autorizacion"),
    @NamedQuery(name = "Autorizaciones.findByFechaautorizacion", query = "SELECT a FROM Autorizaciones a WHERE a.fechaautorizacion = :fechaautorizacion"),
    @NamedQuery(name = "Autorizaciones.findByEstado", query = "SELECT a FROM Autorizaciones a WHERE a.estado = :estado"),
    @NamedQuery(name = "Autorizaciones.findByIdcliente", query = "SELECT a FROM Autorizaciones a WHERE a.idcliente = :idcliente"),
    @NamedQuery(name = "Autorizaciones.findByTipodocumento", query = "SELECT a FROM Autorizaciones a WHERE a.tipodocumento = :tipodocumento")})
public class Autorizaciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 49)
    @Column(name = "claveacceso")
    private String claveacceso;
    @Size(max = 37)
    @Column(name = "autorizacion")
    private String autorizacion;
    @Column(name = "fechaautorizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaautorizacion;
    @Lob
    @Size(max = 65535)
    @Column(name = "contenidoxml")
    private String contenidoxml;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "idcliente")
    private String idcliente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipodocumento")
    private int tipodocumento;

    public Autorizaciones() {
    }

    public Autorizaciones(String claveacceso) {
        this.claveacceso = claveacceso;
    }

    public Autorizaciones(String claveacceso, String estado, String idcliente, int tipodocumento) {
        this.claveacceso = claveacceso;
        this.estado = estado;
        this.idcliente = idcliente;
        this.tipodocumento = tipodocumento;
    }

    public String getClaveacceso() {
        return claveacceso;
    }

    public void setClaveacceso(String claveacceso) {
        this.claveacceso = claveacceso;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public Date getFechaautorizacion() {
        return fechaautorizacion;
    }

    public void setFechaautorizacion(Date fechaautorizacion) {
        this.fechaautorizacion = fechaautorizacion;
    }

    public String getContenidoxml() {
        return contenidoxml;
    }

    public void setContenidoxml(String contenidoxml) {
        this.contenidoxml = contenidoxml;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public int getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(int tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (claveacceso != null ? claveacceso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autorizaciones)) {
            return false;
        }
        Autorizaciones other = (Autorizaciones) object;
        if ((this.claveacceso == null && other.claveacceso != null) || (this.claveacceso != null && !this.claveacceso.equals(other.claveacceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iveloper.portal.entities.Autorizaciones[ claveacceso=" + claveacceso + " ]";
    }
    
}
