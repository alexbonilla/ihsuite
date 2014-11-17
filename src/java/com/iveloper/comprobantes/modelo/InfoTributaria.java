/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iveloper.comprobantes.modelo;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alex
 */

@XmlType(propOrder = {
    "ambiente", "tipoEmision", "razonSocial", "nombreComercial", "ruc",
    "claveAcceso", "codDoc", "estab", "ptoEmi", "secuencial", "dirMatriz"})

public class InfoTributaria {

    /**
     *
     */
    protected String ambiente;

    /**
     *
     */
    protected String tipoEmision;

    /**
     *
     */
    protected String razonSocial;

    /**
     *
     */
    protected String nombreComercial;

    /**
     *
     */
    protected String ruc;

    /**
     *
     */
    protected String claveAcceso;

    /**
     *
     */
    protected String codDoc;

    /**
     *
     */
    protected String estab;

    /**
     *
     */
    protected String ptoEmi;

    /**
     *
     */
    protected String secuencial;

    /**
     *
     */
    protected String dirMatriz; 

    /**
     *
     * @return
     */
    public String getAmbiente() {
        return ambiente;
    }

    /**
     *
     * @param ambiente
     */
    public void setAmbiente(String ambiente) {
        this.ambiente = ambiente;
    }

    /**
     *
     * @return
     */
    public String getTipoEmision() {
        return tipoEmision;
    }

    /**
     *
     * @param tipoEmision
     */
    public void setTipoEmision(String tipoEmision) {
        this.tipoEmision = tipoEmision;
    }

    /**
     *
     * @return
     */
    public String getRazonSocial() {
        return razonSocial;
    }

    /**
     *
     * @param razonSocial
     */
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    /**
     *
     * @return
     */
    public String getNombreComercial() {
        return nombreComercial;
    }

    /**
     *
     * @param nombreComercial
     */
    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    /**
     *
     * @return
     */
    public String getRuc() {
        return ruc;
    }

    /**
     *
     * @param ruc
     */
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    /**
     *
     * @return
     */
    public String getClaveAcceso() {
        return claveAcceso;
    }

    /**
     *
     * @param claveAcceso
     */
    public void setClaveAcceso(String claveAcceso) {
        this.claveAcceso = claveAcceso;
    }

    /**
     *
     * @return
     */
    public String getCodDoc() {
        return codDoc;
    }

    /**
     *
     * @param codDoc
     */
    public void setCodDoc(String codDoc) {
        this.codDoc = codDoc;
    }

    /**
     *
     * @return
     */
    public String getEstab() {
        return estab;
    }

    /**
     *
     * @param estab
     */
    public void setEstab(String estab) {
        this.estab = estab;
    }

    /**
     *
     * @return
     */
    public String getPtoEmi() {
        return ptoEmi;
    }

    /**
     *
     * @param ptoEmi
     */
    public void setPtoEmi(String ptoEmi) {
        this.ptoEmi = ptoEmi;
    }

    /**
     *
     * @return
     */
    public String getSecuencial() {
        return secuencial;
    }

    /**
     *
     * @param secuencial
     */
    public void setSecuencial(String secuencial) {
        this.secuencial = secuencial;
    }

    /**
     *
     * @return
     */
    public String getDirMatriz() {
        return dirMatriz;
    }

    /**
     *
     * @param dirMatriz
     */
    public void setDirMatriz(String dirMatriz) {
        this.dirMatriz = dirMatriz;
    }        


    
}
