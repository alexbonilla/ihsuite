/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.utils;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Rolando
 */
public class ValidadorEstructuraDocumento {

    private StreamSource archivoXSD;
    private StreamSource archivoXML;

    public ValidadorEstructuraDocumento(InputStream strArchivoXSD, InputStream strArchivoXML) {
        this.archivoXSD = new StreamSource(strArchivoXSD);
        this.archivoXML = new StreamSource(strArchivoXML);
    }

    public String validacion() {
        validarArchivo(archivoXSD, "archivoXSD");
        validarArchivo(archivoXML, "archivoXML");
        String mensaje = null;
        SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        Schema schema;
        try {
            schema = schemaFactory.newSchema(archivoXSD);
        } catch (SAXException e) {
            throw new IllegalStateException("Existe un error en la sintaxis del esquema", e);
        }
        Validator validator = schema.newValidator();
        try {
            validator.validate(archivoXML);
        } catch (SAXException | IOException e) {
            return e.getMessage();
        }
        return mensaje;
    }

    protected void validarArchivo(StreamSource archivo, String nombre)
            throws IllegalStateException {
//        if (null == archivo || archivo.length() <= 0L) {
        if (null == archivo) {
            throw new IllegalStateException((new StringBuilder()).append(nombre).append(" es nulo o esta vacio").toString());
        } else {
            return;
        }
    }
}
