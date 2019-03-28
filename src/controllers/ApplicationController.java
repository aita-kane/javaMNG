
package controllers;
import App.Users;
import db.connexionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import media.User;
import models.userModel;

/**
 *
 * @author AKANE
 */
public class ApplicationController {

    @FXML
    private AnchorPane acMain;
    @FXML
    private AnchorPane acDashBord;
    @FXML
    private ScrollPane leftSideBarScroolPan;
    @FXML
    private Button btnHome;
    @FXML
    private ImageView imgHomeBtn;
    @FXML
    private Button btnStore;
    @FXML
    private ImageView imgStoreBtn;
    @FXML
    private Button btnEmploye;
    @FXML
    private ImageView imgEmployeBtn;
    @FXML
    private Button btnSell;
    @FXML
    private ImageView imgSellBtn;
    @FXML
    private BorderPane appContent;
    @FXML
    private AnchorPane acHead;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label lblUsrNamePopOver;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblRoleAs;
    @FXML
    private Hyperlink hlEditUpdateAccount;
    @FXML
    private Button btnLogOut;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Label lblUsrName;
    @FXML
    private ToggleButton sideMenuToogleBtn;
    @FXML
    private ImageView imgMenuBtn;
    @FXML
    private Label lblUserId;
    @FXML
    private StackPane acContent;
    
    
    String usrName;
    String id;

    connexionDB dbCon = new connexionDB();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
   //App users 
    Users users = new Users();
    
    //User DB
    userModel userDB = new userModel();

    //media User
    private User user;

    //getter media user
    public User getUsrName() {
        return user;
    }
    
    //setter media user
    public void setUsrName(User user) {
        lblUserId.setText(user.getId());
        lblUsrName.setText(user.getUser());
        id = user.getId();
        usrName = user.getUser();

        this.user= user;
    }
   
    
//Image debut
/* Image menuImage = new Image("/views/images/menu.png");
 Image menuImageRed = new Image("/views/images/menuRed.png");
    Image image;*/
    
     String style1 = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:none";

    String activeStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:#FF4E3C";
    /*
     Image home = new Image("home.png");
    Image homeRed = new Image("/views/images/homeRed.png");
    Image stock = new Image("/views/images/stock.png");
    Image stockRed = new Image("/views/images/stockRed.png");
    Image sell = new Image("/views/images/sell2.png");
    Image sellRed = new Image("/views/images/ell2Red.png");
    Image employe = new Image("/views/images/employe.png");
    Image employeRed = new Image("/views/images/employeRed.png");*/
   

 //Image fin
    
    
 // Voir view Store
    
     @FXML
    private void btnStoreOnClick(ActionEvent event) throws IOException {
        storeActive();
        //StockController sc = new StockController();
        User usr = new User();
        FXMLLoader fXMLLoader = new FXMLLoader();
        fXMLLoader.load(getClass().getResource("/views/Stock.fxml").openStream());
        usr.setId(id);
        StockController stockController = fXMLLoader.getController();
     
       stockController.setUserId(usr);
 //stockController.btnStockOnAction(event);
     
   
     stockController.settingPermission();
     AnchorPane acPane = fXMLLoader.getRoot();

        acContent.getChildren().clear();

       acContent.getChildren().add(acPane);
    }
    
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
 
    

    
    
    
    
    

    

 
    
   
  // Permission aux users  
    public void permission() {
        con = dbCon.geConnection();

        try {
            pst = con.prepareStatement("SELECT * FROM UserPermission where UserId=?");
            pst.setString(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {
                if (rs.getInt(12) == 0) {
                    btnEmploye.setDisable(true);
                }
               /* if (rs.getInt(15) == 0) {
                    btnSell.setDisable(true);
                } else {

                }*/
            }
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewDetails() {
        users.id = id;
       
        userDB.selectedView(users);
   
       
        lblFullName.setText(users.NomComplet);
        lblUsrNamePopOver.setText(users.UsrName);
    }
    
    
     private void storeActive() {
      //  imgHomeBtn.setImage(home);
      //  imgStoreBtn.setImage(stockRed);
      //  imgSellBtn.setImage(sell);
      //  imgEmployeBtn.setImage(employe);
       
        btnHome.setStyle(style1);
        btnStore.setStyle(activeStyle);
        btnSell.setStyle(style1);
        btnEmploye.setStyle(style1);
       
    }
    
    
    
    
    
    
    
    
    
 //Crochet applicationController   
}
