package id.ac.ukdw.parkir2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import id.ac.ukdw.parkir2.setup.Laporan;
import id.ac.ukdw.parkir2.setup.SlotParkir;
import java.io.IOException;
import java.net.URL;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Indcs
 */
public class BerandaPetugasController implements Initializable {

    private int slotor;
    private int slotil;
    private int slotkeluar;
    private double totbiaya;
    @FXML
    private Label sisaMobil;
    @FXML
    private Label isiMobil;
    @FXML
    private Label isiMotor;
    @FXML
    private Label sisaMotor;
    @FXML
    private Label slotKapMob;
    @FXML
    private Label slotKapMot;
    @FXML
    private Button btnKendaraanKeluar1;
    @FXML
    private Pane pnlLaporan;
    @FXML
    private TableView<Laporan> tblLaporanPetugas;
    @FXML
    private TableColumn<Laporan, Integer> col_id;
    @FXML
    private TableColumn<Laporan, String> col_noplat;
    @FXML
    private TableColumn<Laporan, String> col_jk;
    @FXML
    private TableColumn<Laporan, String> col_tglmasuk;
    @FXML
    private TableColumn<Laporan, String> col_jammasuk;
    @FXML
    private TableColumn<Laporan, String> col_tglkluar;
    @FXML
    private TableColumn<Laporan, String> col_jamkluar;
    @FXML
    private TableColumn<Laporan, Integer> col_biaya;
    @FXML
    private TextField btnsearchLaporan;
    @FXML
    private DatePicker tgl_laporanpetugas;
    @FXML
    private Label pemasukan_laporan;

    public int getSlotil() {
        return slotil;
    }

    public void setSlotil(int slotil) {
        this.slotil = slotil;
    }

    public double getTotbiaya() {
        return totbiaya;
    }

    public void setTotbiaya(double totbiaya) {
        this.totbiaya = totbiaya;
    }
    private TextField txtInput1;
    private Label biaya1;
    @FXML
    private RadioButton rbMotor;
    @FXML
    private RadioButton rbMobil;
    @FXML
    private Button btnKendaraanMasuk;

    public int getSlotkeluar() {
        return slotkeluar;
    }

    public void setSlotkeluar(int slotkeluar) {
        this.slotkeluar = slotkeluar;
    }

    public int getSlotor() {
        return slotor;
    }

    public void setSlotor(int slotor) {
        this.slotor = slotor;
    }

    DBQuery db = new DBQuery();

    @FXML
    private Pane pnlKendaraanKeluar;

    @FXML
    private TextField txtCari1;

    @FXML
    private Button btnKendaraanKeluar;

    @FXML
    private Label lblPlat1;

    @FXML
    private Label lblJenKen1;

    @FXML
    private Label lblTglMasuk1;

    @FXML
    private Label lblJamMasuk1;

    @FXML
    private Label lblTglKeluar1;

    @FXML
    private Label lblJamKeluar1;

    @FXML
    private Label lblBiaya;

    @FXML
    private Pane pnlKendaraanMasuk;

    @FXML
    private Label lblPlat;

    @FXML
    private Label lblJenKen;

    @FXML
    private Label lblTglMasuk;

    @FXML
    private Label lblJamMasuk;

    @FXML
    private TextField txtInput;

    @FXML
    private Pane pnlBeranda;

    private Label tarifAwalMotor;

    private Label tarifAwalMobil;

    @FXML
    private Pane paneMenu;

    @FXML
    private Button btnBeranda;

    @FXML
    private Button btnKendMasuk;

    @FXML
    private Button btnKendKeluar;

    @FXML
    private Button btnLaporan;

    @FXML
    private Button btnKeluar;

    @FXML
    private Label lblNamaBeranda;

    @FXML
    private Label lblNamaBeranda1;
    private Label tarifLanjutMotor;
    private Label tarifLanjutMobil;
    private int totsemua;

    public int getTotsemua() {
        return totsemua;
    }

    public void setTotsemua(int totsemua) {
        this.totsemua = totsemua;
    }

    @FXML
    public void btnBeranda(ActionEvent event) throws SQLException {
        pnlBeranda.toFront();
        ResultSet slot = db.slot();
        ResultSet slotNyata = db.slotSebenarnya();
        int sisamotor = 0;
        int sisamobil = 0;
        int slotMot = 0;
        int slotMob = 0;
        int isimotor;
        int isimobil;

        int kapMobil = slotNyata.getInt(2);
        int kapMotor = slotNyata.getInt(1);

        sisamotor = slot.getInt(7);
        sisamobil = slot.getInt(6);

        slotMot = slotNyata.getInt(1);
        slotMob = slotNyata.getInt(2);

        isimotor = slotMot - sisamotor;
        isimobil = slotMob - sisamobil;

        slotKapMob.setText(String.valueOf(kapMobil));
        slotKapMot.setText(String.valueOf(kapMotor));

        isiMotor.setText(String.valueOf(isimotor));
        isiMobil.setText(String.valueOf(isimobil));
        sisaMotor.setText(String.valueOf(sisamotor));
        sisaMobil.setText(String.valueOf(sisamobil));
        slot.close();
        slotNyata.close();

    }

    @FXML
    public void btnKendKeluar(ActionEvent event) {
        pnlKendaraanKeluar.toFront();
    }

    @FXML
    public void btnKendMasuk(ActionEvent event) {
        pnlKendaraanMasuk.toFront();
    }

    @FXML
    public void btnLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        db = new DBQuery();
        ResultSet slot = db.slot();
        ResultSet slotNyata = db.slotSebenarnya();
        int sisamotor = 0;
        int sisamobil = 0;
        int slotMot = 0;
        int slotMob = 0;
        int isimotor;
        int isimobil;
        int kapMobil = 0;
        int kapMotor = 0;
        try {
            if (slot.next()) {
                sisamotor = slot.getInt(7);
                sisamobil = slot.getInt(6);
            }
            if (slotNyata.next()) {
                kapMobil = slotNyata.getInt(2);
                kapMotor = slotNyata.getInt(1);
                slotMot = slotNyata.getInt(1);
                slotMob = slotNyata.getInt(2);
            }

            isimotor = slotMot - sisamotor;
            isimobil = slotMob - sisamobil;

            slotKapMob.setText(String.valueOf(kapMobil));
            slotKapMot.setText(String.valueOf(kapMotor));

            isiMotor.setText(String.valueOf(isimotor));
            isiMobil.setText(String.valueOf(isimobil));
            sisaMotor.setText(String.valueOf(sisamotor));
            sisaMobil.setText(String.valueOf(sisamobil));
            slot.close();
            slotNyata.close();
        } catch (SQLException ex) {
            Logger.getLogger(BerandaPetugasController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void btnLoad(ActionEvent event) throws IOException {
        DateFormat jamFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
    }

    @FXML
    private void btnKendaraanMasuk(ActionEvent event) throws SQLException {
        String No_Plat = txtInput.getText();
        ResultSet jammasuk = db.selectJam();
        ResultSet tglmasuk = db.selectTgl();
        String jenis_kendaraan = "";

        ResultSet slot = db.slot();
        int count;

        if (rbMotor.isSelected()) {
            jenis_kendaraan = rbMotor.getText();
//            count = slot.getInt(7);
        } else if (rbMobil.isSelected()) {
            jenis_kendaraan = rbMobil.getText();
//            count = slot.getInt(6);
        }
        String jam_masuk = null;
        String tgl_masuk = null;
        if (jammasuk.next()) {
            jam_masuk = jammasuk.getString(1);
        }
        if (tglmasuk.next()) {
            tgl_masuk = tglmasuk.getString(1);
        }

        if (jenis_kendaraan.equals("Motor") || jenis_kendaraan.equals("MOTOR")) {
            count = slot.getInt(7);
            db.inputKendaraan(No_Plat, jenis_kendaraan, tgl_masuk, jam_masuk);
            count = count + 1;
            setSlotor(getSlotor() + 1);

            db.petugasSlotMotor(count);
            System.out.println("kendaraan masuk ke-" + getSlotor());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Berhasil Ditambah Kendaraan");
            alert.setContentText("kendaraan masuk ke-" + getSlotor());
            alert.showAndWait();
//            isiMobil.setText(String.valueOf(count));
        } else if (jenis_kendaraan.equals("Mobil") || jenis_kendaraan.equals("MOBIL")) {
            count = slot.getInt(6);
            db.inputKendaraan(No_Plat, jenis_kendaraan, tgl_masuk, jam_masuk);
            count = count + 1;
            setSlotil(getSlotil() + 1);

            db.petugasSlotMobil(count);
            System.out.println("kendaraan masuk ke-" + getSlotil());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Berhasil Ditambah Kendaraan");
            alert.setContentText("kendaraan masuk ke-" + getSlotil());
            alert.showAndWait();
//            isiMobil.setText(String.valueOf(count));
        }

        txtInput.setText("");
        jammasuk.close();
        tglmasuk.close();
        slot.close();

    }

    @FXML
    private void btnKendaraanKeluar1(ActionEvent event) throws SQLException {
        String No_Plat = txtCari1.getText();
//        db.updateTotalBiaya(totsemua, No_Plat);
        ResultSet slot = db.slot();

        int count;
        String jk = lblJenKen1.getText();
        String tgl_masuk = lblTglMasuk1.getText();
        String jam_masuk = lblJamMasuk1.getText();
        String tgl_keluar = lblTglKeluar1.getText();
        String jam_keluar = lblJamKeluar1.getText();
        String biaya = lblBiaya.getText();

        if (jk.equals("Motor") || jk.equals("MOTOR")) {
            count = slot.getInt(7);
            //db.kendaraanKeluar(No_Plat, tgl_keluar, jam_keluar);
            count = count - 1;
            setSlotkeluar(getSlotkeluar() + 1);

            db.petugasSlotMotor(count);
            db.hapusdatakendaraan(No_Plat);
            db.masukkelaporan(No_Plat, jk, tgl_masuk, jam_masuk, tgl_keluar, jam_keluar, biaya);
            System.out.println("kendaraan keluar ke-" + getSlotkeluar());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Berhasil Diupdate");
            alert.setContentText("kendaraan keluar ke-" + getSlotkeluar());
            alert.showAndWait();
        } else if (jk.equals("Mobil") || jk.equals("MOBIL")) {
            count = slot.getInt(6);
            //db.kendaraanKeluar(No_Plat, tgl_keluar, jam_keluar);
            count = count - 1;
            setSlotkeluar(getSlotkeluar() + 1);

            db.petugasSlotMobil(count);
            db.hapusdatakendaraan(No_Plat);
            db.masukkelaporan(No_Plat, jk, tgl_masuk, jam_masuk, tgl_keluar, jam_keluar, biaya);
            System.out.println("kendaraan keluar ke-" + getSlotkeluar());

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Berhasil Diupdate");
            alert.setContentText("kendaraan keluar ke-" + getSlotkeluar());
            alert.showAndWait();
        }

        txtCari1.setText("");

        slot.close();

    }

    @FXML
    private void btnCariKendaraanKeluar(ActionEvent event) throws SQLException {

        String no_plat = txtCari1.getText();
        String No_Plat = txtCari1.getText();
        ResultSet tarif = db.Tarif();
        int awalMotor = tarif.getInt(1);
        int awalMobil = tarif.getInt(4);
        int lanjutMotor = tarif.getInt(2);
        int lanjutMobil = tarif.getInt(5);
        tarif.close();
        ResultSet jamkeluar = db.selectJam();
        ResultSet tglkeluar = db.selectTgl();
        String jam_keluar = null;
        String tgl_keluar = null;
        if (jamkeluar.next()) {
            jam_keluar = jamkeluar.getString(1);
        }
        if (tglkeluar.next()) {
            tgl_keluar = tglkeluar.getString(1);
        }

        db.UpdateJamTGLKeluar(No_Plat, tgl_keluar, jam_keluar);
        ResultSet rs = db.cariKendaraan(no_plat);
        String tgl1 = null;
        String tgl2 = null;
        int pukul1;
        int pukul2;
        if (rs.next()) {
            String noplat = rs.getString(1);
            String tipe_kendaraan = rs.getString(2);
            String tgl_masuk = rs.getString(3);
            String jam_masuk = rs.getString(4);
            String tglKeluar = rs.getString(5);
            String jamKeluar = rs.getString(6);
            String total = rs.getString(7);
            tgl1 = rs.getString(3);
            tgl2 = rs.getString(5);
            pukul1 = rs.getInt(4);
            pukul2 = rs.getInt(6);
            lblPlat1.setText(noplat);
            lblJenKen1.setText(tipe_kendaraan);
            lblTglMasuk1.setText(tgl_masuk);
            lblJamMasuk1.setText(jam_masuk);
            lblTglKeluar1.setText(tglKeluar);
            lblJamKeluar1.setText(jamKeluar);
//            lblBiaya.setText(total);
            totbiaya = pukul2 - pukul1;
            int biayatot = pukul2 - pukul1;
            if (tipe_kendaraan.equals("MOTOR") || tipe_kendaraan.equals("Motor")) {
                if (tgl1.equals(tgl2)) {
                    if (biayatot == 1) {
                        totsemua = (int) (totbiaya * awalMotor);
                        int semuatot = biayatot * awalMotor;
                        db.updateTotalBiaya(semuatot, no_plat);
//                String tot=jam.getString(7);
                        lblBiaya.setText(String.valueOf(semuatot));

                    } else if (biayatot > 1 && biayatot <= 2) {

                        totsemua = (int) ((totbiaya * lanjutMotor) + awalMotor);
                        int semuatot = (lanjutMotor) + awalMotor;
                        db.updateTotalBiaya(semuatot, no_plat);
//                String tot = jam.getString(7);
                        lblBiaya.setText(String.valueOf(semuatot));
                    } else if (biayatot > 2) {
                        totsemua = (int) ((totbiaya * lanjutMotor) + awalMotor);
                        int semuatot = (biayatot * lanjutMotor) + awalMotor - lanjutMotor;
                        db.updateTotalBiaya(semuatot, no_plat);
//                String tot = jam.getString(7);
                        lblBiaya.setText(String.valueOf(semuatot));
                    } else {
                        int semuatot = awalMotor;
                        db.updateTotalBiaya(semuatot, no_plat);
//                String tot=jam.getString(7);
                        lblBiaya.setText(String.valueOf(semuatot));
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Tanggal beda gan");
                    alert.setContentText(".............");
                    alert.showAndWait();
                }
            } else if (tipe_kendaraan.equals("MOBIL") || tipe_kendaraan.equals("Mobil")) {
                if (tgl1.equals(tgl2)) {
                    if (biayatot == 1) {
                        totsemua = (int) (totbiaya * awalMobil);
                        int semuatot = biayatot * awalMobil;
                        db.updateTotalBiaya(semuatot, no_plat);
//                String tot=jam.getString(7);
                        lblBiaya.setText(String.valueOf(semuatot));

                    } else if (biayatot > 1 && biayatot <= 2) {
                        totsemua = (int) ((totbiaya * lanjutMotor) + awalMotor);
                        int semuatot = (lanjutMotor) + awalMotor;
                        db.updateTotalBiaya(semuatot, no_plat);
//                String tot = jam.getString(7);
                        lblBiaya.setText(String.valueOf(semuatot));
                    } else if (biayatot > 2) {
                        totsemua = (int) ((totbiaya * lanjutMobil) + awalMobil);
                        int semuatot = (biayatot * lanjutMobil) + awalMobil - lanjutMobil;
                        db.updateTotalBiaya(semuatot, no_plat);
//                String tot = jam.getString(7);
                        lblBiaya.setText(String.valueOf(semuatot));
                    } else {
                        int semuatot = awalMobil;
                        db.updateTotalBiaya(semuatot, no_plat);
//                String tot=jam.getString(7);
                        lblBiaya.setText(String.valueOf(semuatot));

                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Tanggal beda gan");
                    alert.setContentText(".............");
                    alert.showAndWait();
                }
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Gagal Mencari Kendaraan");
            alert.setContentText(".............");
            alert.showAndWait();

        }
        jamkeluar.close();
        tglkeluar.close();
        rs.close();
    }

    public void KeepData(String username) throws SQLException {
        ResultSet rs = db.Profilequery(username);
        lblNamaBeranda.setText(rs.getString(5));
        rs.close();
    }

    @FXML
    private void btnLaporan(ActionEvent event) throws SQLException, ClassNotFoundException {
        pnlLaporan.toFront();
        col_id.setCellValueFactory(new PropertyValueFactory("id"));
        col_noplat.setCellValueFactory(new PropertyValueFactory("no_plat"));
        col_jk.setCellValueFactory(new PropertyValueFactory("tipe_kendaraan"));
        col_tglmasuk.setCellValueFactory(new PropertyValueFactory("tgl_masuk"));
        col_jammasuk.setCellValueFactory(new PropertyValueFactory("jam_masuk"));
        col_tglkluar.setCellValueFactory(new PropertyValueFactory("tgl_keluar"));
        col_jamkluar.setCellValueFactory(new PropertyValueFactory("jam_keluar"));
        col_biaya.setCellValueFactory(new PropertyValueFactory("biaya"));

        ObservableList<Laporan> data = FXCollections.observableArrayList();
        int totalhsl = 0;

        ResultSet rs = db.laporanLiat();
        ResultSet qw = db.biayalaporanS();
        while (rs.next()) {
            Laporan lp = new Laporan();
            lp.setId(rs.getInt(1));
            lp.setNo_plat(rs.getString(2));
            lp.setTipe_kendaraan(rs.getString(3));
            lp.setTgl_masuk(rs.getString(4));
            lp.setJam_masuk(rs.getString(5));
            lp.setTgl_keluar(rs.getString(6));
            lp.setJam_keluar(rs.getString(7));
            lp.setBiaya(rs.getInt(8));
            data.add(lp);
        }
        tblLaporanPetugas.setItems(data);
        totalhsl = qw.getInt(1);
        pemasukan_laporan.setText(String.valueOf(totalhsl));
        rs.close();
        qw.close();
    }

    @FXML
    private void btnsearchlaporan() throws SQLException {
        col_id.setCellValueFactory(new PropertyValueFactory("id"));
        col_noplat.setCellValueFactory(new PropertyValueFactory("no_plat"));
        col_jk.setCellValueFactory(new PropertyValueFactory("tipe_kendaraan"));
        col_tglmasuk.setCellValueFactory(new PropertyValueFactory("tgl_masuk"));
        col_jammasuk.setCellValueFactory(new PropertyValueFactory("jam_masuk"));
        col_tglkluar.setCellValueFactory(new PropertyValueFactory("tgl_keluar"));
        col_jamkluar.setCellValueFactory(new PropertyValueFactory("jam_keluar"));
        col_biaya.setCellValueFactory(new PropertyValueFactory("biaya"));

        ObservableList<Laporan> data = FXCollections.observableArrayList();
        int totalhsl = 0;

        String search = btnsearchLaporan.getText();
        ResultSet rs = db.laporanno_plat(search);
        ResultSet qw = db.biayalaporan(search);
        while (rs.next()) {
            Laporan lp = new Laporan();
            lp.setId(rs.getInt(1));
            lp.setNo_plat(rs.getString(2));
            lp.setTipe_kendaraan(rs.getString(3));
            lp.setTgl_masuk(rs.getString(4));
            lp.setJam_masuk(rs.getString(5));
            lp.setTgl_keluar(rs.getString(6));
            lp.setJam_keluar(rs.getString(7));
            lp.setBiaya(rs.getInt(8));
            data.add(lp);

        }

        tblLaporanPetugas.setItems(data);
        totalhsl = qw.getInt(1);
        pemasukan_laporan.setText(String.valueOf(totalhsl));
        rs.close();
        qw.close();
    }

    @FXML
    private void btn_tgl_petugas(ActionEvent event) throws SQLException {

        String tgl = tgl_laporanpetugas.getValue().toString();

//        if (tgl.equals("")) {
//            col_id.setCellValueFactory(new PropertyValueFactory("id"));
//            col_noplat.setCellValueFactory(new PropertyValueFactory("no_plat"));
//            col_jk.setCellValueFactory(new PropertyValueFactory("tipe_kendaraan"));
//            col_tglmasuk.setCellValueFactory(new PropertyValueFactory("tgl_masuk"));
//            col_jammasuk.setCellValueFactory(new PropertyValueFactory("jam_masuk"));
//            col_tglkluar.setCellValueFactory(new PropertyValueFactory("tgl_keluar"));
//            col_jamkluar.setCellValueFactory(new PropertyValueFactory("jam_keluar"));
//            col_biaya.setCellValueFactory(new PropertyValueFactory("biaya"));
//
//            ObservableList<Laporan> data = FXCollections.observableArrayList();
//            int totalhsl = 0;
//
//            ResultSet rs = db.laporanLiat();
//            ResultSet qw = db.biayalaporanS();
//            while (rs.next()) {
//                Laporan lp = new Laporan();
//                lp.setId(rs.getInt(1));
//                lp.setNo_plat(rs.getString(2));
//                lp.setTipe_kendaraan(rs.getString(3));
//                lp.setTgl_masuk(rs.getString(4));
//                lp.setJam_masuk(rs.getString(5));
//                lp.setTgl_keluar(rs.getString(6));
//                lp.setJam_keluar(rs.getString(7));
//                lp.setBiaya(rs.getInt(8));
//                data.add(lp);
//            }
//            tblLaporanPetugas.setItems(data);
//            totalhsl = qw.getInt(1);
//            pemasukan_laporan.setText(String.valueOf(totalhsl));
//            rs.close();
//            qw.close();
//        } else {
            col_id.setCellValueFactory(new PropertyValueFactory("id"));
            col_noplat.setCellValueFactory(new PropertyValueFactory("no_plat"));
            col_jk.setCellValueFactory(new PropertyValueFactory("tipe_kendaraan"));
            col_tglmasuk.setCellValueFactory(new PropertyValueFactory("tgl_masuk"));
            col_jammasuk.setCellValueFactory(new PropertyValueFactory("jam_masuk"));
            col_tglkluar.setCellValueFactory(new PropertyValueFactory("tgl_keluar"));
            col_jamkluar.setCellValueFactory(new PropertyValueFactory("jam_keluar"));
            col_biaya.setCellValueFactory(new PropertyValueFactory("biaya"));

            ObservableList<Laporan> data = FXCollections.observableArrayList();
            int totalhsl = 0;

            ResultSet rs = db.tglLaporan(tgl);
            ResultSet qw = db.biaya_tgl(tgl);
            while (rs.next()) {
                Laporan lp = new Laporan();
                
                lp.setId(rs.getInt(1));
                lp.setNo_plat(rs.getString(2));
                lp.setTipe_kendaraan(rs.getString(3));
                lp.setTgl_masuk(rs.getString(4));
                lp.setJam_masuk(rs.getString(5));
                lp.setTgl_keluar(rs.getString(6));
                lp.setJam_keluar(rs.getString(7));
                lp.setBiaya(rs.getInt(8));
//            totalhsl = rs.getInt(8);
//            totalhsl += totalhsl;
                data.add(lp);

            }
            tblLaporanPetugas.setItems(data);
            totalhsl = qw.getInt(1);
            pemasukan_laporan.setText(String.valueOf(totalhsl));
            rs.close();
            qw.close();
//        }
    }
}
