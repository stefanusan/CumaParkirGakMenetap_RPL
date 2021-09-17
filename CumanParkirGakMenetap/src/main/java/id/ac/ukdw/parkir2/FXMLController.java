package id.ac.ukdw.parkir2;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    private DBQuery db;

    @FXML
    TextField Uname;

    @FXML
    PasswordField Pass;

    @FXML
    private Label lblerror;

    @FXML
    private Button btnLogin;

    @FXML
    private void btnLogin(ActionEvent event) throws IOException, SQLException {
        String user = Uname.getText();
        String pass = Pass.getText();
        ResultSet rs = db.login(user, pass);
        if (rs.next()) {
            String level = rs.getString(4);
            if (level.equals("petugas") || level.equals("Petugas")) {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/BerandaPetugas.fxml"));
                Parent Main = loader.load();
                BerandaPetugasController control = loader.getController();
                control.KeepData(user);
                Scene scene = new Scene(Main);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                rs.close();
                stage.show();

            } else if (level.equals("admin") || level.equals("Admin")) {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/BerandaAdmin.fxml"));
                Parent Main = loader.load();
                BerandaAdminController control = loader.getController();
                control.KeepData(user);
                Scene scene = new Scene(Main);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.setResizable(false);
                rs.close();
                stage.show();

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            if (user.equals("") && pass.equals("")) {
                alert.setHeaderText("Login Gagal");
                alert.setContentText("nama pengguna dan kata sandi tidak boleh kosong");
                alert.showAndWait();
            } else if (user.equals("")) {
                alert.setHeaderText("Login Gagal");
                alert.setContentText("nama pengguna masih kosong");
                alert.showAndWait();
            } else if (pass.equals("")) {

                alert.setHeaderText("Login Gagal");
                alert.setContentText("kata sandi masih kosong");
                alert.showAndWait();
            } else {

                alert.setHeaderText("Login Gagal");
                alert.setContentText("nama pengguna dan kata sandi tidak cocok");
                alert.showAndWait();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        db = new DBQuery();
        db.connect();
    }
}