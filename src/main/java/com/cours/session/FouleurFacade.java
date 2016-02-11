/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.session;

import com.cours.entities.Fouleur;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author gassama
 */
@Stateless
public class FouleurFacade extends AbstractFacade<Fouleur> implements FouleurFacadeLocal {

    @PersistenceContext(unitName = "com.mycompany_KGFACTORY_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FouleurFacade() {
        super(Fouleur.class);
    }

    
    
    @Override
    public boolean findByPseudoPassword(String pseudo, String Password) {
        
       Query query = em.createNativeQuery("SELECT * FROM Fouleur f WHERE f.pseudo = "+pseudo+" and f.password = "+Password);

           List<Fouleur> results = query.getResultList();

        if ( !results.isEmpty() ) {

           return true;

        }
        
        return false;
    }
    
}
