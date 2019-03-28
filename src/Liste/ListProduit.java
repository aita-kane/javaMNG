/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Liste;

/**
 *
 * @author user
 */
public class ListProduit {
     public String id;
    public String produitId;
    public String produitName;
    public String quantite;
  
    public String LivrePar;
    public String categorie;
    public String souscategorie;
    public String prix;
    public String user;
    public String date;

    public ListProduit(String id, String produitId, String produitName, String quantite, String LivrePar, String categorie, String souscategorie, String prix, String user, String date) {
        this.id = id;
        this.produitId = produitId;
        this.produitName = produitName;
        this.quantite = quantite;
        
        this.LivrePar = LivrePar;
        this.categorie = categorie;
        this.souscategorie = souscategorie;
      
        this.prix = prix;
       
        this.user = user;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduitId() {
        return produitId;
    }

    public void setProduitId(String produitId) {
        this.produitId = produitId;
    }

    public String getProduitName() {
        return produitName;
    }

    public void setProduitName(String produitName) {
        this.produitName = produitName;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    
    public String getLivrePar() {
        return LivrePar;
    }

    public void setLivrePar(String LivrePar) {
        this.LivrePar = LivrePar;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getSouscategorie() {
        return souscategorie;
    }

    public void setSouscategorie(String souscategorie) {
        this.souscategorie = souscategorie;
    }

  
    public void setPrix(String prix) {
        this.prix = prix;
    }

    public String getPrix() {
        return prix;
    }

  
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
