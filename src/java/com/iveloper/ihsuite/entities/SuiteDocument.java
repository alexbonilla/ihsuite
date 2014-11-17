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

    /**
     *
     * @return
     */
    public UUID getDocumentId() {
        return DocumentId;
    }

    /**
     *
     * @param DocumentId
     */
    public void setDocumentId(UUID DocumentId) {
        this.DocumentId = DocumentId;
    }

    /**
     *
     * @return
     */
    public Date getDatecreated() {
        return datecreated;
    }

    /**
     *
     * @param datecreated
     */
    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    /**
     *
     * @return
     */
    public ByteArrayOutputStream getBos() {
        return bos;
    }

    /**
     *
     * @param bos
     */
    public void setBos(ByteArrayOutputStream bos) {
        this.bos = bos;
    }

    /**
     *
     * @return
     */
    public UUID getLotId() {
        return LotId;
    }

    /**
     *
     * @param LotId
     */
    public void setLotId(UUID LotId) {
        this.LotId = LotId;
    }

    /**
     *
     * @return
     */
    public String getDocAppRefCode() {
        return docAppRefCode;
    }

    /**
     *
     * @param docAppRefCode
     */
    public void setDocAppRefCode(String docAppRefCode) {
        this.docAppRefCode = docAppRefCode;
    }

    /**
     *
     * @return
     */
    public String getDocTypeCode() {
        return docTypeCode;
    }

    /**
     *
     * @param docTypeCode
     */
    public void setDocTypeCode(String docTypeCode) {
        this.docTypeCode = docTypeCode;
    }

    /**
     *
     * @return
     */
    public String getDocNum() {
        return docNum;
    }

    /**
     *
     * @param docNum
     */
    public void setDocNum(String docNum) {
        this.docNum = docNum;
    }

    /**
     *
     * @return
     */
    public String getReference() {
        return reference;
    }

    /**
     *
     * @param reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     *
     * @return
     */
    public byte[] getDocRef() {
        return docRef;
    }

    /**
     *
     * @param docRef
     */
    public void setDocRef(byte[] docRef) {
        this.docRef = docRef;
    }

    /**
     *
     * @return
     */
    public String getNotifyname() {
        return notifyname;
    }

    /**
     *
     * @param notifyname
     */
    public void setNotifyname(String notifyname) {
        this.notifyname = notifyname;
    }

    /**
     *
     * @return
     */
    public String getNotifyemail() {
        return notifyemail;
    }

    /**
     *
     * @param notifyemail
     */
    public void setNotifyemail(String notifyemail) {
        this.notifyemail = notifyemail;
    }

    /**
     *
     * @return
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     */
    public Date getStatuschanged() {
        return statuschanged;
    }

    /**
     *
     * @param statuschanged
     */
    public void setStatuschanged(Date statuschanged) {
        this.statuschanged = statuschanged;
    }

}
