/**
 *
 * @author AKANE
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class connexionDB {

    public Connection con;
    
public Connection geConnection() {
     
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/ge2019", "AKMW", "testtest");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(connexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
