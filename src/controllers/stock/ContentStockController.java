/**
 * FXML Controller class
 *
 * @author AKANE
 */
package controllers.stock;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import App.ContentProduit;
import Liste.ListProduit;
import models.ProduitModel;
import media.User;
import db.connexionDB;
import db.sql;
import ValidationModel.validContentProduit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;




public class ContentStockController implements Initializable {
    
    // App ContentProduit
    ContentProduit prodC = new ContentProduit();
    
    // Model Produit
    ProduitModel prodM = new ProduitModel();
    
    //Validation model Produit
    validContentProduit vCP = new validContentProduit();
    
    
    private String usrId;

    private User media;
    
    
   

    @FXML
    private AnchorPane spProductContent;
    @FXML
    private TextField tfSearch;
    @FXML
    private Button btnRefresh;
    @FXML
    public AnchorPane apCombobox;
    @FXML
    private ComboBox<?> cbSoteViewSupplyer;
    @FXML
    private ComboBox<?> cbSoteViewBrands;
    @FXML
    private ComboBox<?> cbSoteViewCatagory;
    @FXML
    private ComboBox<?> cbSoteViewRMA;
    @FXML
    private Button btnAddNew;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;
   @FXML
    private TableView<ListProduit> tblViewCurrentStore;
    @FXML
    private MenuItem miSellSelected;
    @FXML
    private TableColumn<?, ?> tblClmProductId;
    @FXML
    private TableColumn<?, ?> tblClmProductName;
    @FXML
    private TableColumn<?, ?> tblClmProductquantity;
    @FXML
    private TableColumn<?, ?> tblClmProductUnit;
    @FXML
    private TableColumn<?, ?> tblClmProductRMA;
    @FXML
    private TableColumn<?, ?> tblClmProductSupplyer;
    @FXML
    private TableColumn<?, ?> tblClmProductBrand;
    @FXML
    private TableColumn<?, ?> tblClmProductCatagory;
    @FXML
    private TableColumn<?, ?> tblClmProductPursesPrice;
    @FXML
    private TableColumn<?, ?> tblClmProductSellPrice;
    @FXML
    private TableColumn<?, ?> tblClmProductdate;
    @FXML
    private TableColumn<?, ?> tblClmProductAddBy;
    @FXML
    private TableColumn<?, ?> tblClmProductdescription;
    
    
    
    

    String FrsId;
    String FrsName;
    String categorieId;
    String categorieName;
    String souscategorieId;
    String souscategorieName;
   

    sql sql = new sql();
    
  

    public User getMedia() {
        return media;
    }

    public void setMedia(User media) {
        usrId = media.getId();
        this.media = media;
    }

    connexionDB dbCon = new connexionDB();
    Connection con = dbCon.geConnection();
    PreparedStatement pst;
    ResultSet rs;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void tfSearchOnKeyRelese(KeyEvent event) {
    }

    @FXML
    private void btnRefreshOnACtion(ActionEvent event) {
    }

    @FXML
    private void cbSoteViewSupplyerOnClick(MouseEvent event) {
    }

    @FXML
    private void cbSoteViewSupplyerOnAction(ActionEvent event) {
    }

    @FXML
    private void cbSoteViewBrandOnClick(MouseEvent event) {
    }

    @FXML
    private void cbSoteViewBrandOnAction(ActionEvent event) {
    }

    @FXML
    private void cbSoteViewCatagoryOnClick(MouseEvent event) {
    }

    @FXML
    private void cbSoteViewCatagoryOnAction(ActionEvent event) {
    }

    @FXML
    private void cbSoteViewRMAOnClick(MouseEvent event) {
    }

    @FXML
    private void cbSoteViewRMAOnAction(ActionEvent event) {
    }

    @FXML
    private void btnAddNewOnAction(ActionEvent event) {
    }

    @FXML
    private void btnUpdateOnAction(ActionEvent event) {
    }

    @FXML
    private void btnDeleteOnAction(ActionEvent event) {
    }

    @FXML
    private void miSellSelectedOnAction(ActionEvent event) {
    }

    @FXML
    private void tblViewCurrentStoreOnClick(MouseEvent event) {
    }

    @FXML
    private void tblViewCurrentStoreOnScroll(ScrollEvent event) {
    }
    
    
     public void viewDetails() {
        System.out.println("CLIC Voir DETAILS PRODUITS");
        tblViewCurrentStore.setItems(prodC.contentProduitList);
        tblClmProductId.setCellValueFactory(new PropertyValueFactory<>("productId"));
        tblClmProductName.setCellValueFactory(new PropertyValueFactory<>("productName"));
        tblClmProductquantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tblClmProductdescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        tblClmProductSupplyer.setCellValueFactory(new PropertyValueFactory<>("suppliedBy"));
        tblClmProductBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        tblClmProductCatagory.setCellValueFactory(new PropertyValueFactory<>("catagory"));
        tblClmProductUnit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        tblClmProductPursesPrice.setCellValueFactory(new PropertyValueFactory<>("pursesPrice"));
        tblClmProductSellPrice.setCellValueFactory(new PropertyValueFactory<>("sellPrice"));
        tblClmProductRMA.setCellValueFactory(new PropertyValueFactory<>("rma"));
        tblClmProductAddBy.setCellValueFactory(new PropertyValueFactory<>("user"));
        tblClmProductdate.setCellValueFactory(new PropertyValueFactory<>("date"));
        
        // Methode modele pour voir les 10 premiers
       // currentProductGetway.viewFistTen(productCurrent);
    }
    
      public void settingPermission() {
        con = dbCon.geConnection();
        try {
            pst = con.prepareStatement("select * from UserPermission where id=?");
            pst.setString(1, usrId);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(8) == 0) {
                    btnUpdate.setDisable(true);
                    btnDelete.setDisable(true);
                }
                if (rs.getInt(3) == 0) {
                    btnAddNew.setDisable(true);
                }
                if (rs.getInt("SellProduct") == 0) {
                    miSellSelected.setDisable(true);
                } else {

                }
            }
        } catch (SQLException ex) {
           // Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      
      // crochet classe
}
