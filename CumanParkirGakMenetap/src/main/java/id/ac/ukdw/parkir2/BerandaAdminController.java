package id.ac.ukdw.parkir2;

import id.ac.ukdw.parkir2.setup.BiayaParkir;
import id.ac.ukdw.parkir2.setup.SlotParkir;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;

public class BerandaAdminController implements Initializable {

    DBQuery db;

    @FXML
    private Pane pnlLaporan;

    @FXML
    private Pane pnlHapusPetugas;

    @FXML
    private Label lblUser;

    @FXML
    private Label lblLevel;

    @FXML
    private Label lblNama_Depan;

    @FXML
    private Label lblNama_Belakang;

    @FXML
    private Label lblAlamat;

    @FXML
    private Label lblContact;

    @FXML
    private TextField txtCari;

    @FXML
    private Button btnCariAkun;

    @FXML
    private Button btnHapusAkun;

    @FXML
    private Pane pnlTambahPetugas;

    @FXML
    private TextField txtNamaDepan;

    @FXML
    private TextField txtNamaBelakang;

    @FXML
    private TextField txtUser;

    @FXML
    private TextField txtAlamat;

    @FXML
    private TextField txtContact;

    @FXML
    private Button btnSubmitTambah;

    @FXML
    private ImageView gbrSave;

    @FXML
    private PasswordField txtPass;

    @FXML
    private RadioButton rbAdmin;

    @FXML
    private RadioButton rbPetugas;

    @FXML
    private Pane pnlSunting;

    @FXML
    private TextField txtTarifSelanjutnya;

    @FXML
    private TextField txtTarifAwal;

    @FXML
    private TextField txtTarifSelanjutnyaMotor;

    @FXML
    private TextField txtTarifAwalMotor;

    @FXML
    private TextField txtSlotMobil;

    @FXML
    private TextField txtSlotMotor;

    @FXML
    private Pane pnlBeranda;

    @FXML
    private Label slotMotor;

    @FXML
    private Label slotMobil;

    @FXML
    private Label kenMasuk;

    @FXML
    private Label kenMasuk1;

    @FXML
    private Label kenMasuk11;

    @FXML
    private Label kenMasuk111;

    @FXML
    private Label kenMasuk112;

    @FXML
    private Label tarifAwalMotor;

    @FXML
    private Label tarifSelanjutnyaMotor;

    @FXML
    private Label tarifAwalMobil;

    @FXML
    private Label tarifSelanjutnyaMobil;

    @FXML
    private Pane paneMenu;

    @FXML
    private Button btnBeranda;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnHapus;

    @FXML
    private Button btnLaporan;

    @FXML
    private Button btnKeluar;

    @FXML
    private Button btnSunting;

    @FXML
    private Label lblNamaBeranda;

    @FXML
    private Label lblNamaBeranda1;
    @FXML
    private Label kenMasuk2;
    @FXML
    private LineChart<?, ?> grafikUang;

    @FXML
    private TextField searchThn;
    @FXML
    private BarChart<?, ?> grafikKend;
    @FXML
    private DatePicker searchTgl;

    @FXML
    public void btnBeranda(ActionEvent event) {
        pnlBeranda.toFront();
    }

    @FXML
    public void btnTambah(ActionEvent event) {
        pnlTambahPetugas.toFront();
    }

    @FXML
    public void btnHapus(ActionEvent event) {
        pnlHapusPetugas.toFront();
    }

    @FXML
    public void btnSubmitTambah(ActionEvent event) throws SQLException {
        String username = txtUser.getText();
        String password = txtPass.getText();
        String level;
        String nama_depan = txtNamaDepan.getText();
        String nama_belakang = txtNamaBelakang.getText();
        String alamat = txtAlamat.getText();
        String contact = txtContact.getText();
        if (rbAdmin.isSelected()) {
            level = rbAdmin.getText();
        } else {
            level = rbPetugas.getText();
        }
        Alert alert = new Alert(Alert.AlertType.ERROR);
        ResultSet rs = db.cariAkun(username);
        //ResultSet rs = db.akunDahAda(username);
        if (rs.next()) {
            String user = rs.getString(2);
            if (user.equals(username)) {
                alert.setHeaderText("INSERT GAGAL");
                alert.setContentText("Username Sudah Ada");
                alert.showAndWait();
                //refreshTambahPetugas();    
            }
        } else {
            if (username.equals("") && password.equals("")) {
                alert.setHeaderText("Tambah Petugas Gagal");
                alert.setContentText("nama pengguna dan kata sandi tidak boleh kosong");
                alert.showAndWait();
            } else if (username.equals("")) {
                alert.setHeaderText("Tambah Petugas Gagal");

                alert.setContentText("nama pengguna masih kosong");
                alert.showAndWait();
            } else if (password.equals("")) {

                alert.setHeaderText("Tambah Petugas Gagal");
                alert.setContentText("kata sandi masih kosong");
                alert.showAndWait();
            } else {
                db.insertUser(username, password, level, nama_depan, nama_belakang, alamat, contact);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("INSERT SUCCESS");
                alert.setContentText("Karyawan has been added");
                alert.showAndWait();
                //refreshTambahPetugas();
                rs.close();
            }

        }

    }

    public void refreshTambahPetugas() {
        this.txtUser = new TextField();
        this.txtPass = new PasswordField();
//        this.txtLevel = new TextField();
        this.txtNamaDepan = new TextField();
        this.txtNamaBelakang = new TextField();
        this.txtAlamat = new TextField();
        this.txtContact = new TextField();
    }

    @FXML
    public void btnLogout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        stage.setScene(new Scene(root));
    }

    @FXML
    private void btnCariAkun(ActionEvent event) throws SQLException {
        String username = txtCari.getText();
        ResultSet rs = db.cariAkun(username);
        if (rs.next()) {
            String uname = rs.getString(2);
            String level = rs.getString(4);
            String nm_dpn = rs.getString(5);
            String nm_blkng = rs.getString(6);
            String alamat = rs.getString(7);
            String contact = rs.getString(8);
            lblUser.setText(username);
            lblLevel.setText(level);
            lblNama_Depan.setText(nm_dpn);
            lblNama_Belakang.setText(nm_blkng);
            lblAlamat.setText(alamat);
            lblContact.setText(contact);

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Gagal Mencari User");
            alert.setContentText(".............");
            alert.showAndWait();

        }
    }

    @FXML
    private void btnHapusAkun(ActionEvent event) throws SQLException {
        String username = txtCari.getText();
        db.deleteUser(username);
//        JOptionPane.YES_NO_CANCEL_OPTIO
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Karyawan Berhasil di delete");
        alert.setContentText("DELETE");
        alert.showAndWait();
    }

    @FXML
    private void bntSunting(ActionEvent event) {
        pnlSunting.toFront();
    }
    BiayaParkir biaya = new BiayaParkir();

    @FXML
    private void btnSaveTarifAwalMobil(ActionEvent event) throws SQLException {

        //tarif awal mobil
        String tarifAwalMobil = txtTarifAwal.getText();
        int awal = Integer.parseInt(tarifAwalMobil);
        biaya.setBiayaMobil(awal);
        db.updateBiayaMobilAwal(awal);
        this.tarifAwalMobil.setText(tarifAwalMobil);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("TARIF BERHASIL DIUPDATE");
        alert.setContentText("Tarif Parkir Satu jam Pertama = " + awal);
        alert.showAndWait();
        txtTarifAwal.setText("");

    }

    @FXML
    private void btnSaveTarifSelanjutnyaMobil(ActionEvent event) throws SQLException {
        String tarifSelanjutMobil = txtTarifSelanjutnya.getText();
        int selanjut = Integer.parseInt(tarifSelanjutMobil);
        biaya.setBiayaSejamMobil(selanjut);
        db.updateBiayaMobilAwal(selanjut);

        this.tarifSelanjutnyaMobil.setText(tarifSelanjutMobil);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("TARIF BERHASIL DIUPDATE");
        alert.setContentText("Tarif Parkir Satu jam Selanjutnya = " + selanjut);
        alert.showAndWait();
        txtTarifSelanjutnya.setText("");

    }
    SlotParkir Slot = new SlotParkir();

    @FXML
    private void btnSlotMobil(ActionEvent event) {
        //slot
        String slotMobil = txtSlotMobil.getText();
        int slot = Integer.parseInt(slotMobil);
        Slot.setSlotMobil(slot);
        db.updateSlotMobil(slot);
        this.slotMobil.setText("/ " + slotMobil);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("TARIF BERHASIL DIUPDATE");
        alert.setContentText("Slot Parkir = " + slot);
        alert.showAndWait();
        txtSlotMobil.setText("");
    }

    @FXML
    private void btnSlotMotor(ActionEvent event) {
        String slotMotor = txtSlotMotor.getText();
        int slot = Integer.parseInt(slotMotor);
        //Slot.setSlotMobil(slot);
        db.updateSlotMotor(slot);
        this.slotMotor.setText("/ " + slotMotor);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("TARIF BERHASIL DIUPDATE");
        alert.setContentText("Slot Parkir = " + slot);
        alert.showAndWait();
        txtSlotMotor.setText("");
    }

    @FXML
    private void btnTarifAwalMotor(ActionEvent event) throws SQLException {
        String tarifAwalMotor = txtTarifAwalMotor.getText();
        int awal = Integer.parseInt(tarifAwalMotor);
        biaya.setBiayaMotor(awal);
        db.updateBiayaMotorAwal(awal);
        ResultSet rs = db.Tarif();
        if (rs.next()) {
            int aa = rs.getInt(1);
            String ab = String.valueOf(aa);
            this.tarifAwalMotor.setText(ab);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("TARIF BERHASIL DIUPDATE");
        alert.setContentText("Tarif Parkir Satu jam Selanjutnya = " + awal);
        alert.showAndWait();
        txtTarifAwalMotor.setText("");

    }

    @FXML
    private void btnTarifSelanjutnyaMotor(ActionEvent event) throws SQLException {
        String tarifSelanjutnyaMotor = txtTarifSelanjutnyaMotor.getText();
        int selanjut = Integer.parseInt(tarifSelanjutnyaMotor);
        biaya.setBiayaSejamMotor(selanjut);
        db.updateBiayaMotorSelanjut(selanjut);
        ResultSet rs = db.Tarif();
        if (rs.next()) {
            int aa = rs.getInt(2);
            String ab = String.valueOf(aa);
            this.tarifSelanjutnyaMotor.setText(ab);
        }
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("TARIF BERHASIL DIUPDATE");
        alert.setContentText("Tarif Parkir Satu jam Selanjutnya = " + selanjut);
        alert.showAndWait();
        txtTarifSelanjutnyaMotor.setText("");

    }

    @FXML
    private void btnLaporan(ActionEvent event) {
        pnlLaporan.toFront();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        db = new DBQuery();
        ResultSet rs = db.Tarif();
        ResultSet sr = db.slotSebenarnya();
        try {
            if (rs.next()) {
                int aMotor = rs.getInt(1);
                int MotorS = rs.getInt(2);
                int aMobil = rs.getInt(4);
                int MobilS = rs.getInt(5);
                //int SlotMob = rs.getInt(6);
                //int SlotMot = rs.getInt(7);
                String tarifAwalMotor = String.valueOf(aMotor);
                String tarifAwalMobil = String.valueOf(aMobil);
                String tarifMotorSelanjut = String.valueOf(MotorS);
                String tarifMobilSelanjut = String.valueOf(MobilS);

                this.tarifAwalMotor.setText(tarifAwalMotor);
                this.tarifSelanjutnyaMotor.setText(tarifMotorSelanjut);
                this.tarifAwalMobil.setText(tarifAwalMobil);
                this.tarifSelanjutnyaMobil.setText(tarifMobilSelanjut);
                //this.slotMobil.setText("/ " +slotMobil);
                //this.slotMotor.setText("/ " +slotMotor);
            }

            if (sr.next()) {
                int slotMotor = sr.getInt(1);
                int slotMobil = sr.getInt(2);
                String SlotMobil = String.valueOf(slotMobil);
                String SlotMotor = String.valueOf(slotMotor);
                this.slotMobil.setText(SlotMobil);
                this.slotMotor.setText(SlotMotor);
            }
            sr.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BerandaAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void KeepData(String username) throws SQLException {
        ResultSet rs = db.Profilequery(username);
        lblNamaBeranda.setText(rs.getString(5));
    }

    @FXML
    private void showChartUang() throws SQLException {
        XYChart.Series seriesMot = new XYChart.Series();
        XYChart.Series seriesMob = new XYChart.Series();
        grafikUang.getData().clear();
        String tahun = searchThn.getText();
        ObservableList<Integer> pemasukanMot = db.hitungUangMasukMot(tahun);
        ObservableList<Integer> pemasukanMob = db.hitungUangMasukMob(tahun);

        seriesMot.getData().add(new XYChart.Data("January", pemasukanMot.get(0)));
        seriesMot.getData().add(new XYChart.Data("February", pemasukanMot.get(1)));
        seriesMot.getData().add(new XYChart.Data("Maret", pemasukanMot.get(2)));
        seriesMot.getData().add(new XYChart.Data("April", pemasukanMot.get(3)));
        seriesMot.getData().add(new XYChart.Data("Mei", pemasukanMot.get(4)));
        seriesMot.getData().add(new XYChart.Data("Juni", pemasukanMot.get(5)));
        seriesMot.getData().add(new XYChart.Data("Juli", pemasukanMot.get(6)));
        seriesMot.getData().add(new XYChart.Data("Agustus", pemasukanMot.get(7)));
        seriesMot.getData().add(new XYChart.Data("September", pemasukanMot.get(8)));
        seriesMot.getData().add(new XYChart.Data("Oktober", pemasukanMot.get(9)));
        seriesMot.getData().add(new XYChart.Data("November", pemasukanMot.get(10)));
        seriesMot.getData().add(new XYChart.Data("December", pemasukanMot.get(11)));
        seriesMot.setName("Motor");
        
         seriesMob.getData().add(new XYChart.Data("January", pemasukanMob.get(0)));
        seriesMob.getData().add(new XYChart.Data("February", pemasukanMob.get(1)));
        seriesMob.getData().add(new XYChart.Data("Maret", pemasukanMob.get(2)));
        seriesMob.getData().add(new XYChart.Data("April", pemasukanMob.get(3)));
        seriesMob.getData().add(new XYChart.Data("Mei", pemasukanMob.get(4)));
        seriesMob.getData().add(new XYChart.Data("Juni", pemasukanMob.get(5)));
        seriesMob.getData().add(new XYChart.Data("Juli", pemasukanMob.get(6)));
        seriesMob.getData().add(new XYChart.Data("Agustus", pemasukanMob.get(7)));
        seriesMob.getData().add(new XYChart.Data("September", pemasukanMob.get(8)));
        seriesMob.getData().add(new XYChart.Data("Oktober", pemasukanMob.get(9)));
        seriesMob.getData().add(new XYChart.Data("November", pemasukanMob.get(10)));
        seriesMob.getData().add(new XYChart.Data("December", pemasukanMob.get(11)));
        seriesMob.setName("Mobil");
        
        grafikUang.getData().addAll(seriesMot);
        grafikUang.getData().addAll(seriesMob);
    }

    @FXML
    private void showGrafKend() throws SQLException {
        XYChart.Series series = new XYChart.Series();
        grafikKend.getData().clear();
        String tanggal = searchTgl.getValue().toString();
        ObservableList<Integer> kendaraan = db.hitungKendaraan(tanggal);

        series.getData().add(new XYChart.Data("Mobil", kendaraan.get(0)));
        series.getData().add(new XYChart.Data("Motor", kendaraan.get(1)));

        grafikKend.getData().addAll(series);
    }
}
