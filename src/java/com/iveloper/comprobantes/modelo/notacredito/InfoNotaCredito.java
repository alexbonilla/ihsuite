/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.notacredito;

import com.iveloper.comprobantes.modelo.TotalImpuesto;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alex
 */
@XmlType(propOrder = {
    "fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador", "razonSocialComprador", "identificacionComprador", "contribuyenteEspecial",
    "obligadoContabilidad", "rise", "codDocModificado", "numDocModificado", "fechaEmisionDocSustento", "totalSinImpuestos", "valorModificacion", "moneda", "totalImpuesto",
    "motivo"})
public class InfoNotaCredito {

    private String fechaEmision;
    private String dirEstablecimiento;
    private String tipoIdentificacionComprador;
    private String razonSocialComprador;
    private String identificacionComprador;
    private String contribuyenteEspecial;
    private String obligadoContabilidad;

    private String rise;
    private String codDocModificado;
    private String numDocModificado;
    private String fechaEmisionDocSustento;
    private BigDecimal totalSinImpuestos;
    private BigDecimal valorModificacion;
    private String moneda;
    private List<TotalImpuesto> totalImpuesto;
    private String motivo;

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
    public String getTipoIdentificacionComprador() {
        return tipoIdentificacionComprador;
    }

    /**
     *
     * @param tipoIdentificacionComprador
     */
    public void setTipoIdentificacionComprador(String tipoIdentificacionComprador) {
        this.tipoIdentificacionComprador = tipoIdentificacionComprador;
    }

    /**
     *
     * @return
     */
    public String getRazonSocialComprador() {
        return razonSocialComprador;
    }

    /**
     *
     * @param razonSocialComprador
     */
    public void setRazonSocialComprador(String razonSocialComprador) {
        this.razonSocialComprador = razonSocialComprador;
    }

    /**
     *
     * @return
     */
    public String getIdentificacionComprador() {
        return identificacionComprador;
    }

    /**
     *
     * @param identificacionComprador
     */
    public void setIdentificacionComprador(String identificacionComprador) {
        this.identificacionComprador = identificacionComprador;
    }

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
    public String getRise() {
        return rise;
    }

    /**
     *
     * @param rise
     */
    public void setRise(String rise) {
        this.rise = rise;
    }

    /**
     *
     * @return
     */
    public String getCodDocModificado() {
        return codDocModificado;
    }

    /**
     *
     * @param codDocModificado
     */
    public void setCodDocModificado(String codDocModificado) {
        this.codDocModificado = codDocModificado;
    }

    /**
     *
     * @return
     */
    public String getNumDocModificado() {
        return numDocModificado;
    }

    /**
     *
     * @param numDocModificado
     */
    public void setNumDocModificado(String numDocModificado) {
        this.numDocModificado = numDocModificado;
    }

    /**
     *
     * @return
     */
    public String getFechaEmisionDocSustento() {
        return fechaEmisionDocSustento;
    }

    /**
     *
     * @param fechaEmisionDocSustento
     */
    public void setFechaEmisionDocSustento(String fechaEmisionDocSustento) {
        this.fechaEmisionDocSustento = fechaEmisionDocSustento;
    }

    /**
     *
     * @return
     */
    public BigDecimal getTotalSinImpuestos() {
        return totalSinImpuestos;
    }

    /**
     *
     * @param totalSinImpuestos
     */
    public void setTotalSinImpuestos(BigDecimal totalSinImpuestos) {
        this.totalSinImpuestos = totalSinImpuestos;
    }

    /**
     *
     * @return
     */
    public BigDecimal getValorModificacion() {
        return valorModificacion;
    }

    /**
     *
     * @param valorModificacion
     */
    public void setValorModificacion(BigDecimal valorModificacion) {
        this.valorModificacion = valorModificacion;
    }

    /**
     *
     * @return
     */
    public String getMoneda() {
        return moneda;
    }

    /**
     *
     * @param moneda
     */
    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    /**
     *
     * @return
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     *
     * @param motivo
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     *
     * @return
     */
    @XmlElementWrapper(name = "totalConImpuestos")
    public List<TotalImpuesto> getTotalImpuesto() {
        return totalImpuesto;
    }

    /**
     *
     * @param totalImpuesto
     */
    public void setTotalImpuesto(List<TotalImpuesto> totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }
}
