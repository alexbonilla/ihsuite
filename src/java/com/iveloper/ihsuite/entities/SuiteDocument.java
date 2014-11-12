/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.ihsuite.entities;

import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Alex
 */
public class SuiteDocument {

    private UUID DocumentId = UUID.randomUUID();
    private UUID LotId = UUID.randomUUID();
    private Date datecreated = new Date();
    private ByteArrayOutputStream bos;
    private String docAppRefCode;
    private String docTypeCode;
    private String docNum;
    private String reference;
    private byte[] docRef;
    private String notifyname;
    private String notifyemail;
    private String status;
    private Date statuschanged;

    public UUID getDocumentId() {
        return DocumentId;
    }

    public void setDocumentId(UUID DocumentId) {
        this.DocumentId = DocumentId;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public ByteArrayOutputStream getBos() {
        return bos;
    }

    public void setBos(ByteArrayOutputStream bos) {
        this.bos = bos;
    }

    public UUID getLotId() {
        return LotId;
    }

    public void setLotId(UUID LotId) {
        this.LotId = LotId;
    }

    public String getDocAppRefCode() {
        return docAppRefCode;
    }

    public void setDocAppRefCode(String docAppRefCode) {
        this.docAppRefCode = docAppRefCode;
    }

    public String getDocTypeCode() {
        return docTypeCode;
    }

    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    public String getDocNum() {
        return docNum;
    }

    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public byte[] getDocRef() {
        return docRef;
    }

    public void setDocRef(byte[] docRef) {
        this.docRef = docRef;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStatuschanged() {
        return statuschanged;
    }

    public void setStatuschanged(Date statuschanged) {
        this.statuschanged = statuschanged;
    }

}
