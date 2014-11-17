/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.retencion;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlType(propOrder = {
    "codigo", "codigoRetencion", "baseImponible", "porcentajeRetener", "valorRetenido", 
    "codDocSustento", "numDocSustento", "fechaEmisionDocSustento"})
public class Impuesto {

    /**
     *
     */
    protected String codigo;

    /**
     *
     */
    protected String codigoRetencion;

    /**
     *
     */
    protected BigDecimal baseImponible;

    /**
     *
     */
    protected BigDecimal porcentajeRetener;

    /**
     *
     */
    protected BigDecimal valorRetenido;

    /**
     *
     */
    protected String codDocSustento;

    /**
     *
     */
    protected String numDocSustento;

    /**
     *
     */
    protected String fechaEmisionDocSustento;

    /**
     *
     * @return
     */
    public BigDecimal getBaseImponible() {
        return baseImponible;
    }

    /**
     *
     * @param baseImponible
     */
    public void setBaseImponible(BigDecimal baseImponible) {
        this.baseImponible = baseImponible;
    }

    /**
     *
     * @return
     */
    public String getCodDocSustento() {
        return codDocSustento;
    }

    /**
     *
     * @param codDocSustento
     */
    public void setCodDocSustento(String codDocSustento) {
        this.codDocSustento = codDocSustento;
    }

    /**
     *
     * @return
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public String getCodigoRetencion() {
        return codigoRetencion;
    }

    /**
     *
     * @param codigoRetencion
     */
    public void setCodigoRetencion(String codigoRetencion) {
        this.codigoRetencion = codigoRetencion;
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
    public String getNumDocSustento() {
        return numDocSustento;
    }

    /**
     *
     * @param numDocSustento
     */
    public void setNumDocSustento(String numDocSustento) {
        this.numDocSustento = numDocSustento;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPorcentajeRetener() {
        return porcentajeRetener;
    }

    /**
     *
     * @param porcentajeRetener
     */
    public void setPorcentajeRetener(BigDecimal porcentajeRetener) {
        this.porcentajeRetener = porcentajeRetener;
    }

    /**
     *
     * @return
     */
    public BigDecimal getValorRetenido() {
        return valorRetenido;
    }

    /**
     *
     * @param valorRetenido
     */
    public void setValorRetenido(BigDecimal valorRetenido) {
        this.valorRetenido = valorRetenido;
    }
}
