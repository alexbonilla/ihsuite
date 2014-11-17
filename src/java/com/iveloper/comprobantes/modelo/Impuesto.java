/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlType(propOrder = {
    "codigo", "codigoPorcentaje", "tarifa", "baseImponible", "valor"})
public class Impuesto {

    /**
     *
     */
    protected String codigo;

    /**
     *
     */
    protected String codigoPorcentaje;

    /**
     *
     */
    protected BigDecimal tarifa;

    /**
     *
     */
    protected BigDecimal baseImponible;

    /**
     *
     */
    protected BigDecimal valor;

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
    public String getCodigoPorcentaje() {
        return codigoPorcentaje;
    }

    /**
     *
     * @param codigoPorcentaje
     */
    public void setCodigoPorcentaje(String codigoPorcentaje) {
        this.codigoPorcentaje = codigoPorcentaje;
    }

    /**
     *
     * @return
     */
    public BigDecimal getTarifa() {
        return tarifa;
    }

    /**
     *
     * @param tarifa
     */
    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    /**
     *
     * @return
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
