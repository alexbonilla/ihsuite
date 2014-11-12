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

    public UUID getLotId() {
        return LotId;
    }

    public void setLotId(UUID LotId) {
        this.LotId = LotId;
    }

    public UUID getLotNumber() {
        return LotNumber;
    }

    public void setLotNumber(UUID LotNumber) {
        this.LotNumber = LotNumber;
    }

    public Date getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Date datecreated) {
        this.datecreated = datecreated;
    }

    public LotType getTypeLot() {
        return typeLot;
    }

    public void setTypeLot(LotType typeLot) {
        this.typeLot = typeLot;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

}
