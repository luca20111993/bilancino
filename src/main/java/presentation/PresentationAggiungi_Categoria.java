/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import service.CategorieService;

/**
 *
 * @author tss
 */

@WebServlet (urlPatterns = "/AddCategoria")
public class PresentationAggiungi_Categoria extends HttpServlet{
    
    @Inject
    CategorieService categorieservice;
    
    
    
    
}
