/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.guiaremision;

import com.iveloper.comprobantes.modelo.DetAdicional;
import java.math.BigDecimal;
import java.util.List;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlRootElement(name = "detalle")
@XmlType(propOrder = {
    "codigoInterno", "codigoAdicional", "descripcion", "cantidad", 
    "detAdicional"})
public class GuiaDetalle {

    /**
     *
     */
    protected String codigoInterno;

    /**
     *
     */
    protected String codigoAdicional;

    /**
     *
     */
    protected String descripcion;

    /**
     *
     */
    protected BigDecimal cantidad;

    /**
     *
     */
    protected List<DetAdicional> detAdicional;

    /**
     *
     * @return
     */
    public BigDecimal getCantidad() {
        return cantidad;
    }

    /**
     *
     * @param cantidad
     */
    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    /**
     *
     * @return
     */
    public String getCodigoAdicional() {
        return codigoAdicional;
    }

    /**
     *
     * @param codigoAdicional
     */
    public void setCodigoAdicional(String codigoAdicional) {
        this.codigoAdicional = codigoAdicional;
    }

    /**
     *
     * @return
     */
    public String getCodigoInterno() {
        return codigoInterno;
    }

    /**
     *
     * @param codigoInterno
     */
    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    @XmlElementWrapper(name = "detallesAdicionales")
    public List<DetAdicional> getDetAdicional() {
        return detAdicional;
    }

    /**
     *
     * @param detAdicional
     */
    public void setDetAdicional(List<DetAdicional> detAdicional) {
        this.detAdicional = detAdicional;
    }
}
