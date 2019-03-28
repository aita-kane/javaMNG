/**
 *
 * @author AKANE
 */
package ValidationModel;

import App.ContentProduit;
import models.ProduitModel;
import db.connexionDB;
import db.sql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;


public class validContentProduit {
     connexionDB dbCon = new connexionDB();
    Connection con = dbCon.geConnection();
    PreparedStatement pst;
    ResultSet rs;
    
    
    sql sql = new sql();
    ProduitModel prodM = new ProduitModel();
    
    
    
    
    
}
