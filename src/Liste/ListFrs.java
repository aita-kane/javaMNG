
/**
 *
 * @author AKANE
 */

package Liste;


public class ListFrs {
    
    
    
    public String FrsId;
    public String FrsNom;
    public String FrsTel;
    public String FrsAddress;
    public String FrsDescription;
    public String creatorId;
    public String dateAjout;

    public ListFrs(String FrsId, String FrsNom) {
        this.FrsId = FrsId;
        this.FrsNom = FrsNom;
    }
     public ListFrs(String FrsId, String FrsNom, String FrsTel, String FrsAddress, String FrsDescription, String DateAjout) {
        this.FrsId = FrsId;
        this.FrsNom = FrsNom;
        this.FrsTel = FrsTel;
        this.FrsAddress = FrsAddress;
        this.FrsDescription = FrsDescription;
        this.dateAjout = DateAjout;
    }

    public void setFrsAddress(String FrsAddress) {
        this.FrsAddress = FrsAddress;
    }



    public String getFrsTel() {
        return FrsTel;
    }

    public String getFrsAddress() {
        return FrsAddress;
    }

    public String getFrsDescription() {
        return FrsDescription;
    }

    public String getDateAjout() {
        return dateAjout;
    }

    public String getFrsId() {
        return FrsId;
    }

    public void setFrsId(String FrsId) {
        this.FrsId = FrsId;
    }

    public String getFrsNom() {
        return FrsNom;
    }

    public void setFrsNom(String FrsNom) {
        this.FrsNom = FrsNom;
    }

    
    
// crocher classe Liste    
}
