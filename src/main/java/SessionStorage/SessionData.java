/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionStorage;

import entity.Utenti;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author tss
 */
@SessionScoped
public class SessionData implements Serializable{
    
    
    private Utenti utenteLogged;

    public Utenti getUtenteLogged() {
        return utenteLogged;
    }

    public void setUtenteLogged(Utenti utenteLogged) {
        this.utenteLogged = utenteLogged;
    }
    
    
    
}
