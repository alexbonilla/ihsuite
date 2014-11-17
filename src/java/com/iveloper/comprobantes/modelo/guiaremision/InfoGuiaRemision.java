/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.comprobantes.modelo.guiaremision;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Rolando
 */
@XmlRootElement(name = "infoGuiaRemision")
@XmlType(propOrder = {
    "dirEstablecimiento", "dirPartida", "razonSocialTransportista",
    "tipoIdentificacionTransportista", "rucTransportista",
    "rise", "obligadoContabilidad", "contribuyenteEspecial", "fechaIniTransporte", 
    "fechaFinTransporte", "placa"})
public class InfoGuiaRemision {

    /**
     *
     */
    protected String dirEstablecimiento;

    /**
     *
     */
    protected String dirPartida;

    /**
     *
     */
    protected String razonSocialTransportista;

    /**
     *
     */
    protected String tipoIdentificacionTransportista;

    /**
     *
     */
    protected String rucTransportista;

    /**
     *
     */
    protected String rise;

    /**
     *
     */
    protected String obligadoContabilidad;

    /**
     *
     */
    protected String contribuyenteEspecial;

    /**
     *
     */
    protected String fechaIniTransporte;

    /**
     *
     */
    protected String fechaFinTransporte;

    /**
     *
     */
    protected String placa;

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
    public String getDirPartida() {
        return dirPartida;
    }

    /**
     *
     * @param dirPartida
     */
    public void setDirPartida(String dirPartida) {
        this.dirPartida = dirPartida;
    }

    /**
     *
     * @return
     */
    public String getFechaFinTransporte() {
        return fechaFinTransporte;
    }

    /**
     *
     * @param fechaFinTransporte
     */
    public void setFechaFinTransporte(String fechaFinTransporte) {
        this.fechaFinTransporte = fechaFinTransporte;
    }

    /**
     *
     * @return
     */
    public String getFechaIniTransporte() {
        return fechaIniTransporte;
    }

    /**
     *
     * @param fechaIniTransporte
     */
    public void setFechaIniTransporte(String fechaIniTransporte) {
        this.fechaIniTransporte = fechaIniTransporte;
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
    public String getPlaca() {
        return placa;
    }

    /**
     *
     * @param placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     *
     * @return
     */
    public String getRazonSocialTransportista() {
        return razonSocialTransportista;
    }

    /**
     *
     * @param razonSocialTransportista
     */
    public void setRazonSocialTransportista(String razonSocialTransportista) {
        this.razonSocialTransportista = razonSocialTransportista;
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
    public String getRucTransportista() {
        return rucTransportista;
    }

    /**
     *
     * @param rucTransportista
     */
    public void setRucTransportista(String rucTransportista) {
        this.rucTransportista = rucTransportista;
    }

    /**
     *
     * @return
     */
    public String getTipoIdentificacionTransportista() {
        return tipoIdentificacionTransportista;
    }

    /**
     *
     * @param tipoIdentificacionTransportista
     */
    public void setTipoIdentificacionTransportista(String tipoIdentificacionTransportista) {
        this.tipoIdentificacionTransportista = tipoIdentificacionTransportista;
    }
}
