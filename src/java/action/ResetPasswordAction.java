/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

/**
 *
 * @author dangxuananh1997
 */
public class ResetPasswordAction {
    
    //Inputs
    private String email;
    private String phone;
    
    //Outputs
    private String error;
    
    //Returns
    private final String SUCCESS = "success";
    private final String INPUT = "input";
    private final String FAIL = "fail";
    
    public ResetPasswordAction() {
    }
    
    public String execute() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
}
