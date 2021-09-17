/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.parkir2.setup;

/**
 *
 * @author Stefanus
 */
public class SlotParkir {

    public void setSlotMotor(int slotMotor) {
        this.slotMotor = slotMotor;
    }

    public void setSlotMobil(int slotMobil) {
        this.slotMobil = slotMobil;
    }

    /**
     * @return the slotMotor
     */
    public int getSlotMotor() {
        return slotMotor;
    }

    /**
     * @return the slotMobil
     */
    public int getSlotMobil() {
        return slotMobil;
    }

    private int slotMotor ;
    private int slotMobil ;
    
}
