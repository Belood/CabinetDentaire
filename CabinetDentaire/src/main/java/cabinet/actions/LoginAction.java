/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.models.LoginDAO;

/**
 *
 * @author assil
 */
public class LoginAction {
    private String username;
    private String password;
    LoginDAO loginDAO=new LoginDAO();

    public String getUserId() {
        return username;
    }

    public void setUserId(String userId) {
        this.username = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String execute()
    {
       if(loginDAO.validate(username, password)) 
       {
           return "success";
       }
       return "failure";
    }
    public String logout(){
        return "success";
    }
    
    
}
