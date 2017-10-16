/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action.admin;

/**
 *
 * @author dangxuananh1997
 */
public class ViewAddUserAction {
    
    private final int tab = 6;            //Tab number
    
    public ViewAddUserAction() {
    }
    
    public String execute() throws Exception {
        return "success";
    }

    public int getTab() {
        return tab;
    }
    
}
