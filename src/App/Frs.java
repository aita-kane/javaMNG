/**
 *
 * @author AKANE
 */
package App;

import Liste.ListFrs;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Frs {
    
        public String id;
    public String FrsNom;
    public String FrsTel;
    public String FrsAddress;
    public String FrsDescription;
    public String creatorId;
    public String date;

//    public List<ListFrs> rowFrs;
    public ObservableList<ListFrs> FrsDetails = FXCollections.observableArrayList();



}
