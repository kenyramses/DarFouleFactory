/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cours.session;

import com.cours.entities.Fouleur;
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

    
    public Fouleur findByPseudoPassword(String pseudo, String Password) {
        Fouleur f = (Fouleur)em.createNamedQuery("findByPseudoandPassword").getSingleResult();
        return  f;
     }
    
}
