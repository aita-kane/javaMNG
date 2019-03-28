/**
 *
 * @author AKANE
 */
package models;

import App.ContentProduit;
import Liste.ListProduit;
import db.connexionDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.stage.StageStyle;



public class ProduitModel {
    
    connexionDB dbCon = new connexionDB ();
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    

    
    
    
    
}
