/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.ihsuite.entities;

import java.io.InputStream;
import java.util.Date;

/**
 *
 * @author Alex
 */
public class Certificate {

    private String entity;
    private String name;
    private InputStream content;
    private String pass;
    private Date expirationDate;

    /**
     *
     * @return
     */
    public String getEntity() {
        return entity;
    }

    /**
     *
     * @param entity
     */
    public void setEntity(String entity) {
        this.entity = entity;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public InputStream getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(InputStream content) {
        this.content = content;
    }

    /**
     *
     * @return
     */
    public String getPass() {
        return pass;
    }

    /**
     *
     * @param pass
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     *
     * @return
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     *
     * @param expirationDate
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

}
