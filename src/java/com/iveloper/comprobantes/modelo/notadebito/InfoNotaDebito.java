/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.notadebito;

import com.iveloper.comprobantes.modelo.Impuesto;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlType(propOrder = {
    "fechaEmision", "dirEstablecimiento", "tipoIdentificacionComprador",
    "razonSocialComprador", "identificacionComprador", "contribuyenteEspecial",
    "obligadoContabilidad", "rise", "codDocModificado", "numDocModificado", "fechaEmisionDocSustento",
    "totalSinImpuestos", "impuesto", "valorTotal"})
public class InfoNotaDebito {

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
    protected String tipoIdentificacionComprador;

    /**
     *
     */
    protected String razonSocialComprador;

    /**
     *
     */
    protected String identificacionComprador;

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
    protected String rise;

    /**
     *
     */
    protected String codDocModificado;

    /**
     *
     */
    protected String numDocModificado;

    /**
     *
     */
    protected String fechaEmisionDocSustento;

    /**
     *
     */
    protected BigDecimal totalSinImpuestos;

    /**
     *
     */
    protected List<Impuesto> impuesto;

    /**
     *
     */
    protected BigDecimal valorTotal;

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
    @XmlElementWrapper(name = "impuestos")
    public List<Impuesto> getImpuesto() {
        return impuesto;
    }

    /**
     *
     * @param impuesto
     */
    public void setImpuesto(List<Impuesto> impuesto) {
        this.impuesto = impuesto;
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
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     *
     * @param valorTotal
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }
}