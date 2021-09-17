/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.parkir2.setup;

import id.ac.ukdw.parkir2.DBQuery;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Stefanus
 */
public class Laporan {

    /**
     * @param no_plat the no_plat to set
     */
    public void setNo_plat(String no_plat) {
        this.no_plat = no_plat;
    }

    /**
     * @param tipe_kendaraan the tipe_kendaraan to set
     */
    public void setTipe_kendaraan(String tipe_kendaraan) {
        this.tipe_kendaraan = tipe_kendaraan;
    }

    /**
     * @param tgl_masuk the tgl_masuk to set
     */
    public void setTgl_masuk(String tgl_masuk) {
        this.tgl_masuk = tgl_masuk;
    }

    /**
     * @param jam_masuk the jam_masuk to set
     */
    public void setJam_masuk(String jam_masuk) {
        this.jam_masuk = jam_masuk;
    }

    /**
     * @param tgl_keluar the tgl_keluar to set
     */
    public void setTgl_keluar(String tgl_keluar) {
        this.tgl_keluar = tgl_keluar;
    }

    /**
     * @param jam_keluar the jam_keluar to set
     */
    public void setJam_keluar(String jam_keluar) {
        this.jam_keluar = jam_keluar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo_plat() {
        return no_plat;
    }

    public void setNo_plat(SimpleStringProperty no_plat) {
        this.setNo_plat(no_plat);
    }

    public String getTipe_kendaraan() {
        return tipe_kendaraan;
    }

    public void setTipe_kendaraan(SimpleStringProperty tipe_kendaraan) {
        this.setTipe_kendaraan(tipe_kendaraan);
    }

    public String getTgl_masuk() {
        return tgl_masuk;
    }

    public void setTgl_masuk(SimpleStringProperty tgl_masuk) {
        this.setTgl_masuk(tgl_masuk);
    }

    public String getJam_masuk() {
        return jam_masuk;
    }

    public void setJam_masuk(SimpleStringProperty jam_masuk) {
        this.setJam_masuk(jam_masuk);
    }

    public String getTgl_keluar() {
        return tgl_keluar;
    }

    public void setTgl_keluar(SimpleStringProperty tgl_keluar) {
        this.setTgl_keluar(tgl_keluar);
    }

    public String getJam_keluar() {
        return jam_keluar;
    }

    public void setJam_keluar(SimpleStringProperty jam_keluar) {
        this.setJam_keluar(jam_keluar);
    }

    public int getBiaya() {
        return biaya;
    }

    public void setBiaya(int biaya) {
        this.biaya = biaya;
    }

    DBQuery db = new DBQuery();
    
    private Integer id;
    private String no_plat;
    private String tipe_kendaraan;
    private String tgl_masuk;
    private String jam_masuk;
    private String tgl_keluar;
    private String jam_keluar;
    private Integer biaya;
    
    public Laporan() {
//        this(0, "","", "", "", "", 0);
    }
    
    public Laporan(int id, String no_plat, String tipe_kendaraan, String tgl_masuk, String jam_masuk, String tgl_keluar, String jam_keluar, int biaya) {
        this.id = id;
        this.no_plat = no_plat;
        this.tipe_kendaraan = tipe_kendaraan;
        this.tgl_masuk = tgl_masuk;
        this.tgl_keluar = tgl_keluar;
        this.jam_masuk = jam_masuk;
        this.jam_keluar = jam_keluar;
        this.biaya = biaya;
    }
    
}
