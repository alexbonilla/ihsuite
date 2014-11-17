/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo;

import javax.xml.bind.annotation.XmlAttribute;

/**
 *
 * @author Rolando
 */
public class DetAdicional {

    /**
     *
     */
    protected String nombre;

    /**
     *
     */
    protected String valor;

    /**
     *
     * @return
     */
    @XmlAttribute(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return
     */
    @XmlAttribute(name = "valor")
    public String getValor() {
        return valor;
    }

    /**
     *
     * @param valor
     */
    public void setValor(String valor) {
        this.valor = valor;
    }
}
