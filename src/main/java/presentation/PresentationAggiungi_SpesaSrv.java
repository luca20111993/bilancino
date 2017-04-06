/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import SessionStorage.SessionData;
import entity.Categorie;
import entity.Spese;
import entity.Utenti;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.CategorieService;
import service.SpeseService;

/**
 *
 * @author tss
 */
@WebServlet(urlPatterns = "/AddSpesa")
public class PresentationAggiungi_SpesaSrv extends HttpServlet {

    @Inject
    SpeseService speseservice;

    @Inject
    SessionData utenteLogged;

    @Inject
    CategorieService categorieservice;

    @Override
    public void init() throws ServletException {
        super.init();

        System.out.println("init().... -- Srv_Addspesa");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy().... -- Srv_Addspesa");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Utenti u = utenteLogged.getUtenteLogged();

        //System.out.println("SONO QUAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + a);
        String catId = req.getParameter("categoria");
        System.out.println("---- " + catId);
        Categorie c = categorieservice.findById(Long.parseLong(catId));

        //Categorie c = new Categorie();
        //c.setNome(req.getParameter("categoria"));
        //c.setUtente(u);
        Double i = Double.parseDouble(req.getParameter("importo"));
        String d = req.getParameter("descrizione");

        Spese s = new Spese();
        s.setUtente(u);
        s.setCategoria(c);
        s.setImporto(i);
        s.setDescrizione(d);

        speseservice.save(s);
        resp.sendRedirect("Inserimento_Spesa.jsp");
    }

}
