/**
 *
 * @author AKANE
 */
package models;

import java.sql.*;

import App.Users;
import App.Frs;
import db.connexionDB;
import java.util.logging.Level;
import java.util.logging.Logger;


public class userModel {
    
     connexionDB dbCon = new connexionDB();
    Connection con;
 
    PreparedStatement pst;
    ResultSet rs;
    
    
    
 public void selectedView(Users users) {
        con = dbCon.geConnection();
        try {
            pst = con.prepareCall("SELECT * from User where id=?");
            pst.setString(1, users.id);
            rs = pst.executeQuery();
            while (rs.next()) {
              
                users.id = rs.getString(1);
                users.UsrName = rs.getString(2);
                users.NomComplet = rs.getString(3);
                users.email = rs.getString(4);
                users.contact = rs.getString(5);
                users.password = rs.getString(6);
                users.status = rs.getString(7);
              users.date = rs.getString(8);
                users.creatorId = rs.getString(9);

            }
            rs.close();
            pst.close();
            con.close();

        } catch (SQLException ex) {
            Logger.getLogger(Frs.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
