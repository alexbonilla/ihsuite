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
@Table(name = "documents")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documents.findAll", query = "SELECT d FROM Documents d"),
    @NamedQuery(name = "Documents.findByDocumentid", query = "SELECT d FROM Documents d WHERE d.documentid = :documentid"),
    @NamedQuery(name = "Documents.findByLotid", query = "SELECT d FROM Documents d WHERE d.lotid = :lotid"),
    @NamedQuery(name = "Documents.findByDatecreated", query = "SELECT d FROM Documents d WHERE d.datecreated = :datecreated"),
    @NamedQuery(name = "Documents.findByDocapprefcode", query = "SELECT d FROM Documents d WHERE d.docapprefcode = :docapprefcode"),
    @NamedQuery(name = "Documents.findByDoctypecode", query = "SELECT d FROM Documents d WHERE d.doctypecode = :doctypecode"),
    @NamedQuery(name = "Documents.findByDocnum", query = "SELECT d FROM Documents d WHERE d.docnum = :docnum"),
    @NamedQuery(name = "Documents.findByNotifyname", query = "SELECT d FROM Documents d WHERE d.notifyname = :notifyname"),
    @NamedQuery(name = "Documents.findByNotifyemail", query = "SELECT d FROM Documents d WHERE d.notifyemail = :notifyemail"),
    @NamedQuery(name = "Documents.findByDocstatus", query = "SELECT d FROM Documents d WHERE d.docstatus = :docstatus"),
    @NamedQuery(name = "Documents.findByStatuschanged", query = "SELECT d FROM Documents d WHERE d.statuschanged = :statuschanged"),
    @NamedQuery(name = "Documents.findByDocautorizacion", query = "SELECT d FROM Documents d WHERE d.docautorizacion = :docautorizacion"),
    @NamedQuery(name = "Documents.findByDocautorizaciondate", query = "SELECT d FROM Documents d WHERE d.docautorizaciondate = :docautorizaciondate")})
public class Documents implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "documentid")
    private String documentid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "lotid")
    private String lotid;
    @Column(name = "datecreated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datecreated;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "document")
    private byte[] document;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "docapprefcode")
    private String docapprefcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "doctypecode")
    private String doctypecode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "docnum")
    private String docnum;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "reference")
    private String reference;
    @Lob
    @Column(name = "docref")
    private byte[] docref;
    @Size(max = 45)
    @Column(name = "notifyname")
    private String notifyname;
    @Size(max = 45)
    @Column(name = "notifyemail")
    private String notifyemail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "docstatus")
    private String docstatus;
    @Column(name = "statuschanged")
    @Temporal(TemporalType.TIMESTAMP)
    private Date statuschanged;
    @Size(max = 37)
    @Column(name = "docautorizacion")
    private String docautorizacion;
    @Column(name = "docautorizaciondate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docautorizaciondate;

    public Documents() {
    }

    public Documents(String documentid) {
        this.documentid = documentid;
    }

    public Documents(String documentid, String lotid, byte[] document, String docapprefcode, String doctypecode, String docnum, String reference, String docstatus) {
        this.documentid = documentid;
        this.lotid = lotid;
        this.document = document;
        this.docapprefcode = docapprefcode;
        this.doctypecode = doctypecode;
        this.docnum = docnum;
        this.reference = reference;
        this.docstatus = docstatus;
    }

    public String getDocumentid() {
        return documentid;
    }

    public void setDocumentid(String documentid) {
        this.documentid = documentid;
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public byte[] getDocument() {
        return document;
    }

    public void setDocument(byte[] document) {
        this.document = document;
    }

    public String getDocapprefcode() {
        return docapprefcode;
    }

    public void setDocapprefcode(String docapprefcode) {
        this.docapprefcode = docapprefcode;
    }

    public String getDoctypecode() {
        return doctypecode;
    }

    public void setDoctypecode(String doctypecode) {
        this.doctypecode = doctypecode;
    }

    public String getDocnum() {
        return docnum;
    }

    public void setDocnum(String docnum) {
        this.docnum = docnum;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public byte[] getDocref() {
        return docref;
    }

    public void setDocref(byte[] docref) {
        this.docref = docref;
    }

    public String getNotifyname() {
        return notifyname;
    }

    public void setNotifyname(String notifyname) {
        this.notifyname = notifyname;
    }

    public String getNotifyemail() {
        return notifyemail;
    }

    public void setNotifyemail(String notifyemail) {
        this.notifyemail = notifyemail;
    }

    public String getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(String docstatus) {
        this.docstatus = docstatus;
    }

    public Date getStatuschanged() {
        return statuschanged;
    }

    public void setStatuschanged(Date statuschanged) {
        this.statuschanged = statuschanged;
    }

    public String getDocautorizacion() {
        return docautorizacion;
    }

    public void setDocautorizacion(String docautorizacion) {
        this.docautorizacion = docautorizacion;
    }

    public Date getDocautorizaciondate() {
        return docautorizaciondate;
    }

    public void setDocautorizaciondate(Date docautorizaciondate) {
        this.docautorizaciondate = docautorizaciondate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (documentid != null ? documentid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documents)) {
            return false;
        }
        Documents other = (Documents) object;
        if ((this.documentid == null && other.documentid != null) || (this.documentid != null && !this.documentid.equals(other.documentid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iveloper.portal.entities.Documents[ documentid=" + documentid + " ]";
    }
    
}
