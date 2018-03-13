/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cabinet.actions;

import cabinet.models.LoginDAO;
import java.util.Map;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author assil
 */
public class LoginAction implements SessionAware{
    private String username;
    private String password;
    LoginDAO loginDAO=new LoginDAO();
    private SessionMap<String,Object> sessionMap;

    

    public SessionMap<String, Object> getSessionMap() {
        return sessionMap;
    }
    
   

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String execute()
    {
       if(loginDAO.validate(getUsername(), getPassword())) 
       {
           
           sessionMap.put("login","true");
           sessionMap.put("username", getUsername());
           return "success";
       }
       return "failure";
    }
    public String logout(){
        
        if(sessionMap!=null)
        {
            sessionMap.invalidate();
            }
        return "success";
    }

    @Override
    public void setSession(Map<String, Object> map) {
        
        sessionMap=(SessionMap)map;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    
}
