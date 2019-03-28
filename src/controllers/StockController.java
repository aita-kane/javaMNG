/**
 *
 * @author AKANE
 */
package controllers;

//import controllers debut
import controllers.stock.ContentStockController;

//import controllers fin
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import media.User;
import db.connexionDB;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXMLLoader;

// Controllers to import
/*import controller.application.stock.CurrentStoreController;
import controller.application.stock.ViewBrandController;
import controller.application.stock.ViewCatagoryController;
import controller.application.stock.ViewRMAController;
import controller.application.stock.ViewSupplyerController;
import controller.application.stock.ViewUnitController;*/
public class StockController {

    @FXML
    public BorderPane bpStore;

    @FXML
    private AnchorPane acHeadStore;
    @FXML
    private ToggleButton btnStock;
    @FXML
    private ToggleButton btnSupplyer;
    @FXML
    private ToggleButton btnBrands;
    @FXML
    private ToggleButton btnCatagory;
    @FXML
    private ToggleButton btnUnit;
    @FXML
    private ToggleButton btnRma;
    @FXML
    private ToggleButton btnRepoerts;
    @FXML
    private Label lblHeader;
    @FXML
    private StackPane spMainContent;

    private String usrId;

    private User userId;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        usrId = userId.getId();
        this.userId = userId;
    }

    connexionDB dbCon = new connexionDB();
    Connection con = dbCon.geConnection();
    PreparedStatement pst;
    ResultSet rs;

    public void initialize(URL url, ResourceBundle rb) {

        ToggleGroup toggleGroup = new ToggleGroup();
        btnStock.setSelected(true);
        btnStock.setToggleGroup(toggleGroup);
        btnSupplyer.setToggleGroup(toggleGroup);
        btnBrands.setToggleGroup(toggleGroup);
        btnCatagory.setToggleGroup(toggleGroup);
        btnUnit.setToggleGroup(toggleGroup);
        btnRma.setToggleGroup(toggleGroup);
        btnRepoerts.setToggleGroup(toggleGroup);

    }
// Voir view content Stock

    @FXML
    public void btnStockOnAction(ActionEvent event) throws IOException {
        
        lblHeader.setText("content stock  le tableau doit safficher");
        User media = new User();
    FXMLLoader fXMLLoader = new FXMLLoader();
 
    fXMLLoader.load(getClass().getResource("../views/produits/ContentStock.fxml").openStream());
        
     
    
 
   media.setId(usrId);
   ContentStockController csc = fXMLLoader.getController();
   csc.setMedia(userId);

 csc.viewDetails();
 csc.apCombobox.getStylesheets().add("../../views/assets/StoreCombobox.css");

 csc.settingPermission();
   StackPane acPane = fXMLLoader.getRoot();
 spMainContent.getChildren().clear();
 spMainContent.getChildren().add(acPane);

    }

    public void settingPermission() {
        con = dbCon.geConnection();
        try {
            pst = con.prepareStatement("select * from UserPermission where id=?");
            pst.setString(1, usrId);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(2) == 0 && rs.getInt(9) == 0) {
                    btnSupplyer.setDisable(true);
                }
                if (rs.getInt(4) == 0 && rs.getInt(10) == 0) {
                    btnBrands.setDisable(true);
                }
                if (rs.getInt(5) == 0 && rs.getInt(11) == 0) {
                    btnCatagory.setDisable(true);
                }
                if (rs.getInt(6) == 0 && rs.getInt(12) == 0) {
                    btnUnit.setDisable(true);
                }
                if (rs.getInt(14) == 0) {
                    btnRma.setDisable(true);
                } else {

                }
            }
        } catch (SQLException ex) {
            // Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnSupplyerOnAction(ActionEvent event) {
    }

    @FXML
    private void btnBrandsOnAction(ActionEvent event) {
    }

    @FXML
    private void btnCatagoryOnAction(ActionEvent event) {
    }

    @FXML
    private void btnUnitOnAction(ActionEvent event) {
    }

    @FXML
    private void btnRmaOnAction(ActionEvent event) {
    }

    @FXML
    private void btnRepoertsOnAction(ActionEvent event) {
    }

}
