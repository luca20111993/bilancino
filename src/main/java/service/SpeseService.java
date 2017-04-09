/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SessionStorage.SessionData;
import entity.Categorie;
import entity.FunzioniData;
import entity.Spese;
import entity.Utenti;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
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
@Named("speseSrv")
public class SpeseService {

    @PersistenceContext
    EntityManager em;

    @Inject
    SessionData utenteLogged;

    public List<Spese> findAll() {
        return em.createNamedQuery(Spese.FIND_ALL_SPESE, Spese.class).
                getResultList();
    }

    public List<Spese> scegli(String tempo, String cat_id) {
        if (tempo.isEmpty() || cat_id.isEmpty()) {
            System.out.println("parametri vuoti");
            return null;
        }
        System.out.println(tempo + "," + cat_id);
        if (tempo.equals("7gg")) {
            return findSpeseByCategoriaAnd7Gg(cat_id);
        } else if (tempo.equals("1mese")) {
            return findSpeseByCategoriaAnd1Mese(cat_id);
        } else if (tempo.equals("tutto")) {
            return findSpeseByCate(cat_id);
        } else {
            return null;
        }

    }

    /*public List <Spese> findSpeseByUsr( String usr){
        
        return em.createNamedQuery
                (Spese.FIND_ALL_SPESE_BY_USER , Spese.class)
                .setParameter("usr", usr).
                getResultList();
    }*/
    public List<Spese> findSpeseById( /*Long id*/) {

        Long ut = utenteLogged.getUtenteLogged().getId();

        return em.createNamedQuery(Spese.FIND_ALL_SPESE_BY_ID, Spese.class).
                setParameter("id", ut).
                getResultList();
    }

    public List<Spese> findSpese7Gg( /*Long id*/) {
        Utenti ut = utenteLogged.getUtenteLogged();
        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofDays(7);
        LocalDate minus = oggi.minus(p);

        System.out.println("La data menu 7 giorni è: " + minus);

        return em.createNamedQuery(Spese.FIND_ALL_SPESE_7_GG, Spese.class).
                setParameter("dat", dataoggi).
                setParameter("ut", ut).
                setParameter("dat2", FunzioniData.converti(minus)).
                getResultList();
    }

    public List<Spese> findSpese1Mese( /*Long id*/) {
        Utenti ut = utenteLogged.getUtenteLogged();
        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofMonths(1);
        LocalDate minus = oggi.minus(p);

        System.out.println("La data menu 31 giorni è: " + minus);

        /*Calendar cal = Calendar.getInstance();        
        cal.add(Calendar.DATE, -31);
        Date dateBefore31Days = cal.getTime();*/
        return em.createNamedQuery(Spese.FIND_ALL_SPESE_1_MESE, Spese.class).
                setParameter("dat", dataoggi).
                setParameter("ut", ut).
                setParameter("dat2", FunzioniData.converti(minus)).
                getResultList();
    }

    public List<Spese> findSpeseByCategoriaAnd7Gg(String cat) {

        Long cat_id = Long.parseLong(cat);
        Categorie c = em.find(Categorie.class, cat_id);
        Utenti ut = utenteLogged.getUtenteLogged();

        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofDays(7);
        LocalDate minus = oggi.minus(p);

        System.out.println("La data menu 31 giorni è: " + minus);

        return em.createNamedQuery(Spese.FIND_ALL_BY_CATEGORY_AND_7GG, Spese.class).
                setParameter("dat", dataoggi).
                setParameter("dat2", FunzioniData.converti(minus)).
                setParameter("ut", ut).
                setParameter("cat", c).
                getResultList();
    }

    public List<Spese> findSpeseByCategoriaAnd1Mese(String cat) {

        Long cat_id = Long.parseLong(cat);
        Categorie c = em.find(Categorie.class, cat_id);
        Utenti ut = utenteLogged.getUtenteLogged();

        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofMonths(1);
        LocalDate minus = oggi.minus(p);

        System.out.println("La data menu 31 giorni è: " + minus);

        return em.createNamedQuery(Spese.FIND_ALL_BY_CATEGORY_AND_1_MESE, Spese.class).
                setParameter("dat", dataoggi).
                setParameter("dat2", FunzioniData.converti(minus)).
                setParameter("ut", ut).
                setParameter("cat", c).
                getResultList();
    }

    public List<Spese> findSpeseByCate(String cat) {
        Utenti ut = utenteLogged.getUtenteLogged();
        Long cat_id = Long.parseLong(cat);
        Categorie c = em.find(Categorie.class, cat_id);
        return em.createNamedQuery(Spese.FIND_ALL_BY_CATEGORY, Spese.class).
                setParameter("cat", c).
                setParameter("ut", ut).
                getResultList();
    }

    //Metodo che usa FIND_LAST_SPESA
    public Spese findLastSpesa() {
        Utenti u = utenteLogged.getUtenteLogged();

        //Metodo che usa FIND_LAST_ID_SPESA
        /*
        Long idSpesa = em.createNamedQuery(Spese.FIND_LAST_ID_SPESA, Long.class).
        setParameter("ut", u).getSingleResult();
        return em.find(Spese.class, idSpesa);
         */
        List<Spese> result = em.createNamedQuery(Spese.FIND_LAST_SPESA, Spese.class)
                .setParameter("ut", u)
                .getResultList();
        return result.isEmpty() ? null : result.get(0);
    }

    public Spese save(Spese dasalvare) {
        return em.merge(dasalvare);
    }

    public void delete(Long id) {
        Spese find = em.find(Spese.class, id);
        em.remove(find);
    }

    //Qua mettiamo le SUMS
    public Spese sumAllSpese7GG() {
        Utenti ut = utenteLogged.getUtenteLogged();

        Date dataoggi = new Date();

        LocalDate oggi = LocalDate.now();
        Period p = Period.ofDays(7);
        LocalDate minus = oggi.minus(p);

        //return em.createNamedQuery(Spese.SUM_ALL_SPESE_7_GG).set 
        
        double res = em.createNamedQuery(Spese.SUM_ALL_SPESE_7_GG).
                setParameter("dat", dataoggi).
                setParameter("ut", ut).
                setParameter("dat2", FunzioniData.converti(minus)).
                getFirstResult();
        
        Spese s = new Spese(ut, null, res, "");
        
         return s;
         
         /*
         <c:forEach items="${speseSrv.sumAllSpese7GG}" var="bidibodibu">
                    <div><c:out value="${bidibodibu.importo}"/></div>
                    </c:forEach>
         */
                
    }
}
