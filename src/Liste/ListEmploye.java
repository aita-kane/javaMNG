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
public class ListEmploye {
    public String employeId;
    public String employeName; 

    public ListEmploye(String employeId, String employeName) {
        this.employeId = employeId;
        this.employeName = employeName;
    }

    public String getEmployeId() {
        return employeId;
    }

    public void setEmployeId(String employeId) {
        this.employeId = employeId;
    }

    public String getEmployeName() {
        return employeName;
    }

    public void setEmployeName(String employeName) {
        this.employeName = employeName;
    }
}
