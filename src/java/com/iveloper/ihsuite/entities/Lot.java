/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iveloper.ihsuite.entities;

import com.iveloper.ihsuite.utils.LotType;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author Alex
 */
public class Lot {

    private UUID LotId = UUID.randomUUID();
    private UUID LotNumber = UUID.randomUUID();
    private Date datecreated = new Date();
    private LotType typeLot = LotType.Unitario;
    private boolean open = true;

    /**
     *
     * @return
     */
    public UUID getLotId() {
        return LotId;
    }

    /**
     *
     * @param LotId
     */
    public void setLotId(UUID LotId) {
        this.LotId = LotId;
    }

    /**
     *
     * @return
     */
    public UUID getLotNumber() {
        return LotNumber;
    }

    /**
     *
     * @param LotNumber
     */
    public void setLotNumber(UUID LotNumber) {
        this.LotNumber = LotNumber;
    }

    /**
     *
     * @return
     */
    public Date getDatecreated() {
        return datecreated;
    }

    /**
     *
     * @param datecreated
     */
    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    /**
     *
     * @return
     */
    public LotType getTypeLot() {
        return typeLot;
    }

    /**
     *
     * @param typeLot
     */
    public void setTypeLot(LotType typeLot) {
        this.typeLot = typeLot;
    }

    /**
     *
     * @return
     */
    public boolean isOpen() {
        return open;
    }

    /**
     *
     * @param open
     */
    public void setOpen(boolean open) {
        this.open = open;
    }

}
