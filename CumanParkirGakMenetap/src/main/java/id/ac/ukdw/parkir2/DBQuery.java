/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.ukdw.parkir2;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Indcs
 */
public class DBQuery extends DBConnect {

    public DBQuery() {
        this.connect();
    }

    public void connect() {
        try {
            try {
                Class.forName("org.sqlite.JDBC");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
            }
            //String url = "E:\\yossie\\semester 5\\RPL\\Project\\Git\\CumaParkirGakMenetap\\CumanParkirGakMenetap\\parkir.db";
            con = DriverManager.getConnection("jdbc:sqlite:parkir.db");
            st = con.createStatement();
            System.out.println("connect");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void queryUp(String query) {
        try {
            ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet queryResult(String query) {
        try {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException E) {
            JOptionPane.showMessageDialog(null, "ERROR");
        }
        return rs;
    }

    public ResultSet login(String username, String password) {
        try {
            String query = "SELECT * from user WHERE username=? AND password=?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
//            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FAILED");
        }
        return rs;
    }

    public ResultSet Profilequery(String id) {
        try {
            String query = "SELECT * from user WHERE username=?";
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FAILED");
        }
        return rs;
    }

    public void insertUser(String username, String password, String level, String nama_depan, String nama_belakang, String alamat, String contact) {
        try {
            Statement statement;
            statement = con.createStatement();

//            String query = "INSERT INTO user ( username, password, level, nama_depan, nama_belakang, alamat, contact) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            String query2 = "INSERT INTO user ( username, password, level, nama_depan, nama_belakang, alamat, contact) VALUES ( '" + username + "', '" + password + "', '" + level + "', '" + nama_depan + "', '" + nama_belakang + "', '" + alamat + "', '" + contact + "') ";
            statement.executeUpdate(query2);
            System.out.println("berhasil nambah");
//            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
//            e.printStackTrace();

        }

    }

    public void deleteUser(String username) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "DELETE FROM `user` WHERE `username` = '" + username + "'";
            statement.executeUpdate(query);
            System.out.println("berhasilhapus");
//            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
//            e.printStackTrace();
        }

    }

    public ResultSet cariAkun(String username) {
        try {
            String query = "SELECT * from user WHERE username=?";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari Akun");
        }
        return rs;
    }

    public void updateBiayaMotorAwal(int awal) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE Tarif SET TarifMotorAwal = '" + awal + "' WHERE id=1";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void updateBiayaMobilAwal(int awal) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE Tarif SET TarifMobilAwal = '" + awal + "' WHERE id=1";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void updateBiayaMotorSelanjut(int selanjut) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE Tarif SET TarifMotorSelanjut = '" + selanjut + "' WHERE id=1";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void updateBiayaMobilSelanjut(int selanjut) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE Tarif SET TarifMobilSelanjut = '" + selanjut + "' WHERE id=1";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void updateSlotMotor(int slot) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE slotParkir SET Motor = '" + slot + "' ";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void updateSlotMobil(int slot) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE slotParkir SET Mobil = '" + slot + "' ";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void updateTotalBiaya(int biaya, String no_plat) throws SQLException {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE DataKendaraanParkir SET total_biaya = '" + biaya + "' WHERE no_plat='" + no_plat + "'";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdatebiaya");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public ResultSet Tarif() {
        try {
            String query = "SELECT * from Tarif WHERE id=1";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari Akun");
        }
        return rs;
    }

    public ResultSet slot() {
        try {
            String query = "SELECT * from Tarif";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari Akun");
        }
        return rs;
    }

    public ResultSet slotMotor() {
        try {
            String query = "SELECT SlotMotor from Tarif WHERE id=1";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari");
        }
        return rs;
    }

    public ResultSet cariKendaraan(String No_Plat) {
        try {
            String query = "SELECT * from DataKendaraanParkir WHERE no_plat=?";
            ps = con.prepareStatement(query);
            ps.setString(1, No_Plat);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari");
        }
        return rs;
    }

    public ResultSet selectJam() {
        try {
            String query = "SELECT strftime('%H:%M','now','localtime')";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
        return rs;
    }

    public ResultSet selectTgl() {
        try {
            String query = "SELECT strftime('%Y-%m-%d','now','localtime') ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal");
        }
        return rs;
    }

    public void inputKendaraan(String No_Plat, String jenis_kendaraan, String tgl_masuk, String jam_masuk) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query2 = "INSERT INTO DataKendaraanParkir (no_plat, tipe_kendaraan, tgl_masuk, jam_masuk) VALUES ( '" + No_Plat + "', '" + jenis_kendaraan + "', '" + tgl_masuk + "', '" + jam_masuk + "') ";
            statement.executeUpdate(query2);
            System.out.println("berhasil nambah");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void UpdateJamTGLKeluar(String No_Plat, String tgl_keluar, String jam_keluar) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE DataKendaraanParkir SET tgl_keluar = '" + tgl_keluar + "', jam_keluar = '" + jam_keluar + "' WHERE no_plat='" + No_Plat + "'";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }

    }

    public void UpdateBiaya(int totsemua, String No_Plat) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE DataKendaraanParkir SET total_biaya = '" + totsemua + "' WHERE no_plat='" + No_Plat + "'";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }

    }

    public ResultSet slotSebenarnya() {
        try {
            String query = "SELECT * from slotParkir ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari slot");
        }
        return rs;
    }

    public void petugasSlotMotor(int count) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE Tarif SET SlotMotor = '" + count + "' ";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void petugasSlotMobil(int count) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "UPDATE Tarif SET SlotMobil = '" + count + "' ";
            statement.executeUpdate(query);
            System.out.println("berhasildiupdate");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void hapusdatakendaraan(String no_plat) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query = "DELETE FROM DataKendaraanParkir WHERE no_plat = '" + no_plat + "'";
            statement.executeUpdate(query);
            System.out.println("berhasildikeluarkankendaraan");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }
    }

    public void masukkelaporan(String No_Plat, String jenis_kendaraan, String tgl_masuk, String jam_masuk, String tgl_keluar, String jam_keluar, String biaya) {
        try {
            Statement statement;
            statement = con.createStatement();
            String query2 = "INSERT INTO laporan_parkir (id, no_plat, tipe_kendaraan, tgl_masuk, jam_masuk, tgl_keluar, jam_keluar, total_biaya) VALUES ( null,'" + No_Plat + "', '" + jenis_kendaraan + "', '" + tgl_masuk + "', '" + jam_masuk + "', '" + tgl_keluar + "', '" + jam_keluar + "', '" + biaya + "') ";
            statement.executeUpdate(query2);
            System.out.println("berhasil nambah laporan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "FAILED");
        }

    }

    public ObservableList hitungUangMasukMot(String tahun) throws SQLException {
        ObservableList<Integer> pemasukanMot = FXCollections.observableArrayList();

        for (int i = 1; i < 13; i++) {
            String query;
            if (i < 10) {
                query = "SELECT SUM(`total_biaya`)FROM laporan_parkir  WHERE ((strftime('%Y', `tgl_keluar`) = '" + tahun + "' AND strftime('%m', `tgl_keluar`) = '0" + i + "')) AND `tipe_kendaraan` = 'Motor'";
            } else {
                query = "SELECT SUM(`total_biaya`)FROM laporan_parkir  WHERE ((strftime('%Y', `tgl_keluar`) = '" + tahun + "' AND strftime('%m', `tgl_keluar`) = '" + i + "')) AND `tipe_kendaraan` = 'Motor'";
            }
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            pemasukanMot.add(rs.getInt(1));
        }
        return pemasukanMot;
    }

    public ObservableList hitungUangMasukMob(String tahun) throws SQLException {
        ObservableList<Integer> pemasukanMob = FXCollections.observableArrayList();

        for (int i = 1; i < 13; i++) {
            String query;
            if (i < 10) {
                query = "SELECT SUM(`total_biaya`)FROM laporan_parkir  WHERE ((strftime('%Y', `tgl_keluar`) = '" + tahun + "' AND strftime('%m', `tgl_keluar`) = '0" + i + "')) AND `tipe_kendaraan` = 'Mobil'";
            } else {
                query = "SELECT SUM(`total_biaya`)FROM laporan_parkir  WHERE ((strftime('%Y', `tgl_keluar`) = '" + tahun + "' AND strftime('%m', `tgl_keluar`) = '" + i + "')) AND `tipe_kendaraan` = 'Mobil'";
            }
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            pemasukanMob.add(rs.getInt(1));
        }
        return pemasukanMob;
    }

    public ResultSet laporanno_plat(String search) {
        try {
            String query = "SELECT * from laporan_parkir where no_plat like '%" + search + "%' OR tipe_kendaraan like '%" + search + "%'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari slot");
        }
        return rs;
    }

    public ResultSet tglLaporan(String tgl) {
        try {
            String query = "SELECT * from laporan_parkir where tgl_masuk = '" + tgl + "' OR tgl_keluar = '" + tgl + "'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari slot");
        }
        return rs;
    }

    public ResultSet biaya_tgl(String tgl) {
        try {
            String query = "SELECT SUM(total_biaya) from laporan_parkir where tgl_masuk = '" + tgl + "' OR tgl_keluar = '" + tgl + "'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari slot");
        }
        return rs;
    }

    public ResultSet biayalaporan(String search) {
        try {
            String query = "SELECT SUM(total_biaya) from laporan_parkir where no_plat like '%" + search + "%' OR tipe_kendaraan like '%" + search + "%'";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari slot");
        }
        return rs;
    }

    public ResultSet biayalaporanS() {
        try {
            String query = "SELECT SUM(total_biaya) from laporan_parkir";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari slot");
        }
        return rs;
    }

    public ResultSet laporanLiat() {
        try {
            String query = "SELECT * from laporan_parkir ";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Gagal Mencari slot");
        }
        return rs;
    }

    public ObservableList hitungKendaraan(String tanggal) throws SQLException {
        ObservableList<Integer> kendaraan = FXCollections.observableArrayList();

        String query;
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                query = "SELECT count(`tipe_kendaraan`) FROM laporan_parkir WHERE `tgl_keluar`='" + tanggal + "' AND `tipe_kendaraan`='Mobil'";
            } else {
                query = "SELECT count(`tipe_kendaraan`) FROM laporan_parkir WHERE `tgl_keluar`='" + tanggal + "' AND `tipe_kendaraan`='Motor'";
            }
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            kendaraan.add(rs.getInt(1));
        }
        return kendaraan;
    }
}
