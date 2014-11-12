/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.ihsuite.ws.responses;

import com.iveloper.ihsuite.utils.SriStatus;
import com.iveloper.ihsuite.utils.SriTipoComprobante;
import com.iveloper.ihsuite.utils.SriTypeEmission;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Alex
 */
public class wsResponseData extends wsResponseBase {

    private String DocumentAutorizacion;
    private Date DocumentAutorizacionDate;
    private String DocumentClave;
    private List<wsResponseDocumentEvent> DocumentEvents;
    private String DocumentId;
    private DocFacInstance DocumentInstance;
    private boolean DocumentNotified;
    private String DocumentReference;
    private SriStatus DocumentStatus;
    private SriTipoComprobante DocumentType;
    private SriTypeEmission DocumentTypeEmision;

    public String getDocumentAutorizacion() {
        return DocumentAutorizacion;
    }

    public void setDocumentAutorizacion(String DocumentAutorizacion) {
        this.DocumentAutorizacion = DocumentAutorizacion;
    }

    public Date getDocumentAutorizacionDate() {
        return DocumentAutorizacionDate;
    }

    public void setDocumentAutorizacionDate(Date DocumentAutorizacionDate) {
        this.DocumentAutorizacionDate = DocumentAutorizacionDate;
    }

    public String getDocumentClave() {
        return DocumentClave;
    }

    public void setDocumentClave(String DocumentClave) {
        this.DocumentClave = DocumentClave;
    }

    public List<wsResponseDocumentEvent> getDocumentEvents() {
        return DocumentEvents;
    }

    public void setDocumentEvents(List<wsResponseDocumentEvent> DocumentEvents) {
        this.DocumentEvents = DocumentEvents;
    }

    public String getDocumentId() {
        return DocumentId;
    }

    public void setDocumentId(String DocumentId) {
        this.DocumentId = DocumentId;
    }

    public DocFacInstance getDocumentInstance() {
        return DocumentInstance;
    }

    public void setDocumentInstance(DocFacInstance DocumentInstance) {
        this.DocumentInstance = DocumentInstance;
    }

    public boolean isDocumentNotified() {
        return DocumentNotified;
    }

    public void setDocumentNotified(boolean DocumentNotified) {
        this.DocumentNotified = DocumentNotified;
    }

    public String getDocumentReference() {
        return DocumentReference;
    }

    public void setDocumentReference(String DocumentReference) {
        this.DocumentReference = DocumentReference;
    }

    public SriStatus getDocumentStatus() {
        return DocumentStatus;
    }

    public void setDocumentStatus(SriStatus DocumentStatus) {
        this.DocumentStatus = DocumentStatus;
    }

    public SriTipoComprobante getDocumentType() {
        return DocumentType;
    }

    public void setDocumentType(SriTipoComprobante DocumentType) {
        this.DocumentType = DocumentType;
    }

    public SriTypeEmission getDocumentTypeEmision() {
        return DocumentTypeEmision;
    }

    public void setDocumentTypeEmision(SriTypeEmission DocumentTypeEmision) {
        this.DocumentTypeEmision = DocumentTypeEmision;
    }

    
}
