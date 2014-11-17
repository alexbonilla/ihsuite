/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo;

import java.math.BigDecimal;
import java.util.ArrayList;
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
    "codigoPrincipal", "codigoAuxiliar", "codigoInterno", "codigoAdicional", "descripcion", "cantidad", "precioUnitario",
    "descuento", "precioTotalSinImpuesto", "detAdicional", "impuesto"})
public class Detalle {

    private String codigoPrincipal;
    private String codigoAuxiliar;

    private String codigoInterno;
    private String codigoAdicional;

    private String descripcion;
    private BigDecimal cantidad;
    private BigDecimal precioUnitario;
    private BigDecimal descuento;
    private BigDecimal precioTotalSinImpuesto;
    private List<DetAdicional> detAdicional;
    private List<Impuesto> impuesto;

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
    public String getCodigoAuxiliar() {
        return codigoAuxiliar;
    }

    /**
     *
     * @param codigoAuxiliar
     */
    public void setCodigoAuxiliar(String codigoAuxiliar) {
        this.codigoAuxiliar = codigoAuxiliar;
    }

    /**
     *
     * @return
     */
    public String getCodigoPrincipal() {
        return codigoPrincipal;
    }

    /**
     *
     * @param codigoPrincipal
     */
    public void setCodigoPrincipal(String codigoPrincipal) {
        this.codigoPrincipal = codigoPrincipal;
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
    public BigDecimal getDescuento() {
        return descuento;
    }

    /**
     *
     * @param descuento
     */
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    /**
     *
     * @return
     */
    @XmlElementWrapper(name = "detallesAdicionales")
    public List<DetAdicional> getDetAdicional() {
        if (detAdicional == null) {
            detAdicional = new ArrayList<DetAdicional>();
        }
        return detAdicional;
    }

    /**
     *
     * @param detAdicional
     */
    public void setDetAdicional(List<DetAdicional> detAdicional) {
        this.detAdicional = detAdicional;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPrecioTotalSinImpuesto() {
        return precioTotalSinImpuesto;
    }

    /**
     *
     * @return
     */
    @XmlElementWrapper(name = "impuestos")
    public List<Impuesto> getImpuesto() {
        if (impuesto == null) {
            impuesto = new ArrayList<Impuesto>();
        }
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
     * @param precioTotalSinImpuesto
     */
    public void setPrecioTotalSinImpuesto(BigDecimal precioTotalSinImpuesto) {
        this.precioTotalSinImpuesto = precioTotalSinImpuesto;
    }

    /**
     *
     * @return
     */
    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     *
     * @param precioUnitario
     */
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
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

}
