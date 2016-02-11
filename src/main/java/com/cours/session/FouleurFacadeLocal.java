/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.session;

import com.cours.entities.Fouleur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author gassama
 */
@Local
public interface FouleurFacadeLocal {

    void create(Fouleur fouleur);

    void edit(Fouleur fouleur);

    void remove(Fouleur fouleur);

    Fouleur find(Object id);

    boolean findByPseudoPassword(String pseudo, String Password);
    
    List<Fouleur> findAll();

    List<Fouleur> findRange(int[] range);

    int count();
    
}
