/**
 *
 * @author AKANE
 */
package App;


import Liste.ListProduit;
 import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class ContentProduit {
 
    public String id;
    public String prodId;
    public String prodName;
    public String quantite;

    public String FrsId;
    public String categorieId;
    public String souscategorieId;
    
   
    public String prix;

    public String userId;
    public String date;
   
    public String FrsNom;
    public String categorieName;
    public String souscategorieName;
   
    public String userName;
   
    public String FrsList;
    
    public ObservableList<ListProduit> contentProduitList = FXCollections.observableArrayList();   
}
