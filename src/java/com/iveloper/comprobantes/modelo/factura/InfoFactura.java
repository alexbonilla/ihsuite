/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iveloper.comprobantes.modelo.factura;

import com.iveloper.comprobantes.modelo.TotalImpuesto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alex
 */
@XmlType(propOrder = {
    "fechaEmision", "dirEstablecimiento", "contribuyenteEspecial",
    "obligadoContabilidad", "tipoIdentificacionComprador", "guiaRemision",
    "razonSocialComprador", "identificacionComprador", "totalSinImpuestos",
    "totalDescuento", "totalImpuesto", "propina", "importeTotal", "moneda"})
public class InfoFactura {
    private String fechaEmision;
    private String dirEstablecimiento;
    private String contribuyenteEspecial;
    private String obligadoContabilidad;
    private String tipoIdentificacionComprador;
    private String guiaRemision;
    private String razonSocialComprador;
    private String identificacionComprador;
    private BigDecimal totalSinImpuestos;
    private BigDecimal totalDescuento;
    private List<TotalImpuesto> totalImpuesto;
    private BigDecimal propina;
    private BigDecimal importeTotal;
    private String moneda;

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
    public String getGuiaRemision() {
        return guiaRemision;
    }

    /**
     *
     * @param guiaRemision
     */
    public void setGuiaRemision(String guiaRemision) {
        this.guiaRemision = guiaRemision;
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
    public BigDecimal getTotalDescuento() {
        return totalDescuento;
    }

    /**
     *
     * @param totalDescuento
     */
    public void setTotalDescuento(BigDecimal totalDescuento) {
        this.totalDescuento = totalDescuento;
    }
    
    /**
     *
     * @return
     */
    @XmlElementWrapper(name = "totalConImpuestos")
    public List<TotalImpuesto> getTotalImpuesto() {
        if (totalImpuesto == null) {
            totalImpuesto = new ArrayList<TotalImpuesto>();
        }
        return totalImpuesto;
    }

    /**
     *
     * @param totalImpuesto
     */
    public void setTotalConImpuesto(List<TotalImpuesto> totalImpuesto) {
        this.totalImpuesto = totalImpuesto;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPropina() {
        return propina;
    }

    /**
     *
     * @param propina
     */
    public void setPropina(BigDecimal propina) {
        this.propina = propina;
    }

    /**
     *
     * @return
     */
    public BigDecimal getImporteTotal() {
        return importeTotal;
    }

    /**
     *
     * @param importeTotal
     */
    public void setImporteTotal(BigDecimal importeTotal) {
        this.importeTotal = importeTotal;
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
    
    
}
