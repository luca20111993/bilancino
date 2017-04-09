/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SessionStorage.SessionData;
import entity.Categorie;
import entity.Utenti;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Stateless
@Named("categoriaSrv")

public class CategorieService {

    @PersistenceContext
    EntityManager em;

    @Inject
    SessionData utenteloggato;
    public List<Categorie> findAll() {
        return em.createNamedQuery(Categorie.FIND_ALL_CATEGORIE).getResultList();
    }

    public Categorie save(Categorie dasalvare) {
        return em.merge(dasalvare);
    }

    //Prima prova per cancellare una categoria.
    /*public void daCancellare (Categorie daCancellare){
         System.out.println("Richiesta cancellazione elemento : " + daCancellare);
         
         Categorie find = em.find(Categorie.class , daCancellare.getId());
         if(find != null ){
         em.remove(daCancellare);
         } else {
             System.out.println("Elemento non trovato");
         }
          
     }*/
    public Categorie findByNome(String nome) {
        return em.createNamedQuery(Categorie.FIND_CATEGORIE_BY_NOME2, Categorie.class)
                .setParameter("nome", nome)
                .getSingleResult();
    }
    
    public List <Categorie>findByUt(){
        Utenti ut = utenteloggato.getUtenteLogged();
        
        return em.createNamedQuery(Categorie.FIND_CATEGORIE_BYUTENTE , Categorie.class).
                setParameter("ut", ut).getResultList();
    
    }

    public Categorie findById(Long id) {
        return em.find(Categorie.class, id);
    }

    public void delete(String id) {
        Categorie find = em.find(Categorie.class, id);

        em.remove(find);

    }
}
