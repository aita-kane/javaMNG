/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package media;

/**
 *
 * @author user
 */
public class User {
       String Id;
   String usrName;

    public User() {
    }

    public User(String Id) {
        this.Id = Id;
    }

    public User(String id, String usrName) {
        this.Id = id;
        this.usrName = usrName;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getUser() {
        return usrName;
    }

    public void setUser(String usrName) {
        this.usrName = usrName;
    }
}
