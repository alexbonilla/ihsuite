/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.ihsuite.ws.responses;

import com.iveloper.ihsuite.utils.SriStatus;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Alex
 */
public class DocFacInstance {
//documentid, lotid, datecreated, document, 
//docapprefcode , doctypecode, docnum, reference,
//docref, notifyname, notifyemail, docstatus, 
//statuschanged, docautorizacion, docautorizaciondate    
    private UUID documentid;
    private UUID lotid;
    private Date datecreated;
    private byte[] document;
    private String docapprefcode;
    private String doctypecode;
    private String docnum;
    private String reference;
    private byte[] docref;
    private String notifyname;
    private String notifyemail;
    private SriStatus docstatus;
    private Date statuschanged;
    private String docautorizacion;
    private Date docautorizaciondate;

    public UUID getDocumentid() {
        return documentid;
    }

    public void setDocumentid(UUID documentid) {
        this.documentid = documentid;
    }

    public UUID getLotid() {
        return lotid;
    }

    public void setLotid(UUID lotid) {
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

    public SriStatus getDocstatus() {
        return docstatus;
    }

    public void setDocstatus(SriStatus doctatus) {
        this.docstatus = doctatus;
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
        
}
