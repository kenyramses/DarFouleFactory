/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.beans;

import com.cours.session.FouleurFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gassama
 */
@ManagedBean
@Named(value = "loginTurkeur")
@Dependent
public class LoginTurkeur {

    private String username;
    private String password;
    @EJB
    FouleurFacadeLocal ffi;
      /**
     * Creates a new instance of Login
     */
    public LoginTurkeur() {
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String validateUsernamePassword() {
        
        if (ffi.findByPseudoPassword(username, password)) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("pseudo", "");
            return "Acceuil_fouleur";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return "login_turkeur";
        }
    }
    
     /*
    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        return "login";
    }*/
    
}
