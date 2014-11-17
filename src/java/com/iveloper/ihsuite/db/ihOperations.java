/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.ihsuite.db;

import com.iveloper.ihsuite.entities.Certificate;
import com.iveloper.ihsuite.entities.Lot;
import com.iveloper.ihsuite.entities.SuiteDocument;
import com.iveloper.ihsuite.utils.LotType;
import com.iveloper.ihsuite.utils.SriStatus;
import com.iveloper.ihsuite.ws.responses.DocFacInstance;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Alex
 */
public class ihOperations extends dbConnector {

    /**
     *
     * @param configuration_path
     * @throws IOException
     */
    public ihOperations(String configuration_path) throws IOException {
        super(configuration_path);
    }

    /**
     *
     * @param configuration_path
     * @param dbid
     * @throws IOException
     */
    public ihOperations(String configuration_path, String dbid) throws IOException {
        super(configuration_path, dbid);
    }

    /**
     *
     * @param configuration_path
     * @param dbid
     * @throws IOException
     */
    public ihOperations(String configuration_path, int dbid) throws IOException {
        super(configuration_path, dbid);
    }

    /**
     *
     * @param typeLot
     * @return
     * @throws SQLException
     */
    public Lot createLot(LotType typeLot) throws SQLException {

        Lot lot = new Lot();
        lot.setTypeLot(typeLot);
        CallableStatement cs = connection.prepareCall("call CREATE_LOT(?,?,?,?,?);");
        cs.setString(1, lot.getLotId().toString());
        cs.setString(2, lot.getLotNumber().toString());
        cs.setTimestamp(3, new Timestamp(lot.getDatecreated().getTime()));
        cs.setString(4, lot.getTypeLot().name());
        cs.setBoolean(5, lot.isOpen());
        int result = cs.executeUpdate();
        cs.close();
        return result == 1 ? lot : null;

    }

    /**
     *
     * @param doctype
     * @return
     * @throws SQLException
     */
    public InputStream getSchemaValidator(String doctype) throws SQLException {
        InputStream xsd = null;
        PreparedStatement ps = connection.prepareStatement("SELECT content FROM validators WHERE docname = ?;");
        ps.setString(1, doctype);
        ResultSet rs = ps.executeQuery();
        if (rs.first()) {
            byte[] xsdbytes = rs.getBytes("content");
            xsd = new ByteArrayInputStream(xsdbytes);
        }
        rs.close();
        ps.close();
        return xsd;
    }

    /**
     *
     * @param entity
     * @return
     * @throws SQLException
     */
    public Certificate getDigitalCertificate(String entity) throws SQLException {
        Certificate cert = new Certificate();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM certificates WHERE entity = ?;");
        ps.setString(1, entity);
        ResultSet rs = ps.executeQuery();
        if (rs.first()) {
            String name = rs.getString("name");
            byte[] content = rs.getBytes("content");
            String pass = rs.getString("pass");
            Date expirationDate = new Date(rs.getTimestamp("expirationDate").getTime());
            cert = new Certificate();
            cert.setEntity(entity);
            cert.setName(name);
            cert.setContent(new ByteArrayInputStream(content));
            cert.setPass(pass);
            cert.setExpirationDate(expirationDate);
        }
        rs.close();
        ps.close();
        return cert;
    }

    /**
     *
     * @param sdoc
     * @return
     * @throws SQLException
     */
    public int createSuiteDocument(SuiteDocument sdoc) throws SQLException {
//        param_documentid, param_lotid, param_datecreated, param_document, param_docapprefcode, 
//        param_doctypecode, param_docnum, param_reference, param_docref, param_notifyname, 
//        param_notifyemail, param_docstatus
        CallableStatement cs = connection.prepareCall("call CREATE_SUITEDOCUMENT(?,?,?,?,?,?,?,?,?,?,?,?);");
        cs.setString(1, sdoc.getDocumentId().toString());
        cs.setString(2, sdoc.getLotId().toString());
        cs.setTimestamp(3, new Timestamp(new Date().getTime()));
        cs.setBytes(4, sdoc.getBos().toByteArray());
        cs.setString(5, sdoc.getDocAppRefCode());
        cs.setString(6, sdoc.getDocTypeCode());
        cs.setString(7, sdoc.getDocNum());
        cs.setString(8, sdoc.getReference());
        cs.setBytes(9, sdoc.getDocRef());
        cs.setString(10, sdoc.getNotifyname());
        cs.setString(11, sdoc.getNotifyemail());
        cs.setString(12, sdoc.getStatus());
        int result = cs.executeUpdate();
        cs.close();
        return result;

    }

    /**
     *
     * @param documentid
     * @param status
     * @return
     * @throws SQLException
     */
    public int updateSuiteDocumentStatus(String documentid, String status) throws SQLException {
        CallableStatement cs = connection.prepareCall("call UPDATE_SUITEDOCUMENT_STATUS(?,?,?);");
        cs.setString(1, documentid);
        cs.setString(2, status);
        cs.setTimestamp(3, new Timestamp(new Date().getTime()));
        int result = cs.executeUpdate();
        cs.close();
        return result;

    }

    /**
     *
     * @param documentid
     * @param document
     * @param status
     * @return
     * @throws SQLException
     */
    public int updateSuiteDocumentContent(String documentid, byte[] document, String status) throws SQLException {
        System.out.println("Document size " + document.length);
        CallableStatement cs = connection.prepareCall("call UPDATE_SUITEDOCUMENT_CONTENT(?,?,?);");
        cs.setString(1, documentid);
        cs.setBytes(2, document);
        cs.setString(3, status);
        int result = cs.executeUpdate();
        cs.close();
        return result;

    }

    /**
     *
     * @param documentid
     * @param document
     * @param status
     * @param documentAutorizacion
     * @param documentAutorizacionDate
     * @return
     * @throws SQLException
     */
    public int updateSuiteDocumentAutorizacion(String documentid, byte[] document, String status, String documentAutorizacion, Date documentAutorizacionDate) throws SQLException {
        System.out.println("Document size " + document.length);
        CallableStatement cs = connection.prepareCall("call UPDATE_SUITEDOCUMENT_AUTORIZACION(?,?,?,?,?);");
        cs.setString(1, documentid);
        cs.setBytes(2, document);
        cs.setString(3, status);
        cs.setString(4, documentAutorizacion);
        cs.setTimestamp(5, new Timestamp(documentAutorizacionDate.getTime()));
        int result = cs.executeUpdate();
        cs.close();
        return result;
    }

    /**
     *
     * @param documentid
     * @return
     * @throws SQLException
     */
    public DocFacInstance getDocFacInstance(String documentid) throws SQLException {
        //documentid, lotid, datecreated, document, 
        //docapprefcode , doctypecode, docnum, reference,
        //docref, notifyname, notifyemail, docstatus, 
        //statuschanged, docautorizacion, docautorizaciondate  
        DocFacInstance document = new DocFacInstance();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM documents WHERE documentid = ?;");
        ps.setString(1, documentid);
        ResultSet rs = ps.executeQuery();
        boolean result=false;
        if (rs.first()) {            
            String lotid = rs.getString("lotid");
            Date datecreated = new Date(rs.getTimestamp("datecreated").getTime());
            byte[] documentBytes = rs.getBytes("document");
            String docapprefcode = rs.getString("docapprefcode");
            String doctypecode = rs.getString("doctypecode");
            String docnum = rs.getString("docnum");
            String reference = rs.getString("reference");
            byte[] docref = rs.getBytes("docref");
            String notifyname = rs.getString("notifyname");
            String notifyemail = rs.getString("notifyemail");
            SriStatus docstatus = SriStatus.retornaSriStatus(rs.getString("docstatus"));
            Date statuschanged = rs.getTimestamp("statuschanged")==null?null:new Date(rs.getTimestamp("statuschanged").getTime());
            String docautorizacion = rs.getString("docautorizacion");
            Date docautorizaciondate = rs.getTimestamp("docautorizaciondate")==null?null:new Date(rs.getTimestamp("docautorizaciondate").getTime());

            document.setDocumentid(UUID.fromString(documentid));
            document.setLotid(UUID.fromString(lotid));
            document.setDatecreated(datecreated);
            document.setDocument(documentBytes);
            document.setDocapprefcode(docapprefcode);
            document.setDoctypecode(doctypecode);
            document.setDocnum(docnum);
            document.setReference(reference);
            document.setDocref(docref);
            document.setNotifyname(notifyname);
            document.setNotifyemail(notifyemail);
            document.setDocstatus(docstatus);
            document.setStatuschanged(statuschanged);
            document.setDocautorizacion(docautorizacion);
            document.setDocautorizaciondate(docautorizaciondate);
            result = true;
            
        }
        rs.close();
        ps.close();
        return result?document:null;
    }

}
