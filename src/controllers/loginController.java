/*
author: AKANE
 */
package controllers;

import App.Users;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import db.connexionDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.StageStyle;
import media.User;

/**
 *
 * @author AKANE
 */
public class loginController implements Initializable {

    Users users = new Users();

    private PreparedStatement pst;
    private Connection con;
    private ResultSet rs;

    @FXML
    private JFXTextField txtUsr;
    @FXML
    private JFXPasswordField txtPwd;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private Label lb_Erreur;

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        BooleanBinding boolenBinding = txtUsr.textProperty().isEmpty()
                .or(txtPwd.textProperty().isEmpty());

        btnLogin.disableProperty().bind(boolenBinding);

    }

    
     @FXML
    private void btnLogIn(ActionEvent event) throws IOException{
        
        connexionDB dbCon = new connexionDB();

        con = dbCon.geConnection();

        if (con != null) {
            User media = new User();

            // ApplicationController apController = new ApplicationController();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/views/Application.fxml"));
            loader.load();
            Parent parent = loader.getRoot();
            Scene adminPanelScene = new Scene(parent);
            Stage adminPanelStage = new Stage();
            adminPanelStage.setMaximized(true);

            if (isValidCondition()) {
                try {
                    pst = con.prepareStatement("SELECT * FROM user where UsrName=? and Password=? and Status=1");
                    pst.setString(1, txtUsr.getText());
                    pst.setString(2, txtPwd.getText());
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        User usr = new User(rs.getString(1), rs.getString(2));
                        ApplicationController apControl = loader.getController();
                        apControl.setUsrName(usr);
                        // apControl.btnHomeOnClick(event);
                        apControl.permission();
                        apControl.viewDetails();
                        adminPanelStage.setScene(adminPanelScene);
                        adminPanelStage.getIcons().add(new Image("/views/images/icon.png"));
                        adminPanelStage.setTitle(rs.getString(3));
                        adminPanelStage.show();

                        Stage stage = (Stage) btnLogin.getScene().getWindow();
                        stage.close();
                    } else {
                        System.out.println("Mot de passe non trouvé.");
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("Password Not Match");
                        alert.setHeaderText("Erreur : Les informations saisies n'existent pas dans la base.");
                        alert.setContentText("Nom d'utilisateur ou mot de passe incorrect. Veuillez réessayer.");
                        alert.initStyle(StageStyle.UNDECORATED);
                        alert.showAndWait();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(loginController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error : Server Not Found");
            alert.setContentText("Make sure your mysql is Start properly, \n");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();
        }
    }

    private boolean isValidCondition() {
        boolean validCondition = false;
        if (txtUsr.getText().trim().isEmpty()
                || txtPwd.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING :");
            alert.setHeaderText("WARNING !!");
            alert.setContentText("Please Fill Text Field And Password Properly");
            alert.initStyle(StageStyle.UNDECORATED);
            alert.showAndWait();

            validCondition = false;
        } else {
            validCondition = true;
        }
        return validCondition;
    }

   
}
