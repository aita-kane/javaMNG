/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Liste.ListEmploye;
import java.sql.*;


/**
 *
 * @author user
 */
public class Users {
  
    public ObservableList<String> allUser = FXCollections.observableArrayList();

    public String id;
    public String UsrName;
    public String NomComplet;
    public String email;
  public String contact;
    public String password;
    public String status;
   public String date;
    public String creatorId;
    
  public ObservableList<ListEmploye> employeList = FXCollections.observableArrayList();
  
}
