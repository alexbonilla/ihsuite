/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.iveloper.comprobantes.modelo;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Alex
 */
@XmlType(propOrder = {
    "codigo", "codigoPorcentaje", "baseImponible", "tarifa", "valor"})
public class TotalImpuesto {

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
    protected BigDecimal baseImponible;

    /**
     *
     */
    protected BigDecimal tarifa;

    /**
     *
     */
    protected BigDecimal valor;
    
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
