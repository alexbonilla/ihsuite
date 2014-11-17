/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.notadebito;

import java.math.BigDecimal;

/**
 *
 * @author Rolando
 */
public class Motivo {

    /**
     *
     */
    protected String razon;

    /**
     *
     */
    protected BigDecimal valor;

    /**
     *
     * @return
     */
    public String getRazon() {
        return razon;
    }

    /**
     *
     * @param razon
     */
    public void setRazon(String razon) {
        this.razon = razon;
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
