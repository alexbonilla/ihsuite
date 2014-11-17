/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.retencion;

import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlType(propOrder = {
    "fechaEmision", "dirEstablecimiento", "contribuyenteEspecial",
    "obligadoContabilidad", "tipoIdentificacionSujetoRetenido",
    "razonSocialSujetoRetenido", "identificacionSujetoRetenido", "periodoFiscal"})
public class InfoCompRetencion {

    /**
     *
     */
    protected String fechaEmision;

    /**
     *
     */
    protected String dirEstablecimiento;

    /**
     *
     */
    protected String contribuyenteEspecial;

    /**
     *
     */
    protected String obligadoContabilidad;

    /**
     *
     */
    protected String tipoIdentificacionSujetoRetenido;

    /**
     *
     */
    protected String razonSocialSujetoRetenido;

    /**
     *
     */
    protected String identificacionSujetoRetenido;

    /**
     *
     */
    protected String periodoFiscal;

    /**
     *
     * @return
     */
    public String getContribuyenteEspecial() {
        return contribuyenteEspecial;
    }

    /**
     *
     * @param contribuyenteEspecial
     */
    public void setContribuyenteEspecial(String contribuyenteEspecial) {
        this.contribuyenteEspecial = contribuyenteEspecial;
    }

    /**
     *
     * @return
     */
    public String getDirEstablecimiento() {
        return dirEstablecimiento;
    }

    /**
     *
     * @param dirEstablecimiento
     */
    public void setDirEstablecimiento(String dirEstablecimiento) {
        this.dirEstablecimiento = dirEstablecimiento;
    }

    /**
     *
     * @return
     */
    public String getFechaEmision() {
        return fechaEmision;
    }

    /**
     *
     * @param fechaEmision
     */
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    /**
     *
     * @return
     */
    public String getIdentificacionSujetoRetenido() {
        return identificacionSujetoRetenido;
    }

    /**
     *
     * @param identificacionSujetoRetenido
     */
    public void setIdentificacionSujetoRetenido(String identificacionSujetoRetenido) {
        this.identificacionSujetoRetenido = identificacionSujetoRetenido;
    }

    /**
     *
     * @return
     */
    public String getObligadoContabilidad() {
        return obligadoContabilidad;
    }

    /**
     *
     * @param obligadoContabilidad
     */
    public void setObligadoContabilidad(String obligadoContabilidad) {
        this.obligadoContabilidad = obligadoContabilidad;
    }

    /**
     *
     * @return
     */
    public String getPeriodoFiscal() {
        return periodoFiscal;
    }

    /**
     *
     * @param periodoFiscal
     */
    public void setPeriodoFiscal(String periodoFiscal) {
        this.periodoFiscal = periodoFiscal;
    }

    /**
     *
     * @return
     */
    public String getRazonSocialSujetoRetenido() {
        return razonSocialSujetoRetenido;
    }

    /**
     *
     * @param razonSocialSujetoRetenido
     */
    public void setRazonSocialSujetoRetenido(String razonSocialSujetoRetenido) {
        this.razonSocialSujetoRetenido = razonSocialSujetoRetenido;
    }

    /**
     *
     * @return
     */
    public String getTipoIdentificacionSujetoRetenido() {
        return tipoIdentificacionSujetoRetenido;
    }

    /**
     *
     * @param tipoIdentificacionSujetoRetenido
     */
    public void setTipoIdentificacionSujetoRetenido(String tipoIdentificacionSujetoRetenido) {
        this.tipoIdentificacionSujetoRetenido = tipoIdentificacionSujetoRetenido;
    }
}
