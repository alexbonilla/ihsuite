/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.portal.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "resumenes_facturas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResumenesFacturas.findAll", query = "SELECT r FROM ResumenesFacturas r"),
    @NamedQuery(name = "ResumenesFacturas.findByClaveacceso", query = "SELECT r FROM ResumenesFacturas r WHERE r.claveacceso = :claveacceso"),
    @NamedQuery(name = "ResumenesFacturas.findByNumfactura", query = "SELECT r FROM ResumenesFacturas r WHERE r.numfactura = :numfactura"),
    @NamedQuery(name = "ResumenesFacturas.findByFechaemision", query = "SELECT r FROM ResumenesFacturas r WHERE r.fechaemision = :fechaemision"),
    @NamedQuery(name = "ResumenesFacturas.findByIdcliente", query = "SELECT r FROM ResumenesFacturas r WHERE r.idcliente = :idcliente"),
    @NamedQuery(name = "ResumenesFacturas.findByImportetotal", query = "SELECT r FROM ResumenesFacturas r WHERE r.importetotal = :importetotal"),
    @NamedQuery(name = "ResumenesFacturas.findByEstado", query = "SELECT r FROM ResumenesFacturas r WHERE r.estado = :estado")})
public class ResumenesFacturas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 49)
    @Column(name = "claveacceso")
    private String claveacceso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 37)
    @Column(name = "numfactura")
    private String numfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechaemision")
    @Temporal(TemporalType.DATE)
    private Date fechaemision;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "idcliente")
    private String idcliente;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "importetotal")
    private BigDecimal importetotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;

    public ResumenesFacturas() {
    }

    public ResumenesFacturas(String claveacceso) {
        this.claveacceso = claveacceso;
    }

    public ResumenesFacturas(String claveacceso, String numfactura, Date fechaemision, String idcliente, BigDecimal importetotal, String estado) {
        this.claveacceso = claveacceso;
        this.numfactura = numfactura;
        this.fechaemision = fechaemision;
        this.idcliente = idcliente;
        this.importetotal = importetotal;
        this.estado = estado;
    }

    public String getClaveacceso() {
        return claveacceso;
    }

    public void setClaveacceso(String claveacceso) {
        this.claveacceso = claveacceso;
    }

    public String getNumfactura() {
        return numfactura;
    }

    public void setNumfactura(String numfactura) {
        this.numfactura = numfactura;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public String getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(String idcliente) {
        this.idcliente = idcliente;
    }

    public BigDecimal getImportetotal() {
        return importetotal;
    }

    public void setImportetotal(BigDecimal importetotal) {
        this.importetotal = importetotal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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
        if (!(object instanceof ResumenesFacturas)) {
            return false;
        }
        ResumenesFacturas other = (ResumenesFacturas) object;
        if ((this.claveacceso == null && other.claveacceso != null) || (this.claveacceso != null && !this.claveacceso.equals(other.claveacceso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iveloper.portal.entities.ResumenesFacturas[ claveacceso=" + claveacceso + " ]";
    }
    
}
