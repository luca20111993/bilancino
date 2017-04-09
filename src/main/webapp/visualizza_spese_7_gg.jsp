<%-- 
    Document   : BilancinoUtente
    Created on : 3-apr-2017, 9.40.54
    Author     : tss
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CssFolder/Spese_7_ggCss.css" rel="stylesheet" type="text/css"/>
        <title>Elenco Transazioni Utente</title>
    </head>
    
    <body>
        
        
        <div id="header">
            <div id="titolo">Tutte le tue transazioni a portata di click!</div>
        </div>
        
        
        
        
        
        <div id="maindiv">
            
            <div id="title">Le spese degli ultimi 7 giorni!</div>



            <div id="testo">


                <div id="container">
                    
                    <table style="margin: 0 auto">
            
            <th>Categoria</th>
            <th id="last">Importo</th>
            <th id="last">Data Creazione</th>
            <th id="last">Descrizione</th>
            
            <!--  
            
                Ci permette di visualizzare le transazioni del tipo.
            
            -->
            <c:forEach items="${speseSrv.findSpese7Gg()}" var="spese">
              
            <tr>
                <td id="first">   <c:out value="${spese.categoria.nome}"/>  </td>
                <td id="last">   <c:out value="${spese.importo}"/>  </td>
                <td id="last">   <c:out value="${spese.dataCreazione}"/>  </td>
                <td id="last">   <c:out value="${spese.descrizione}"/>  </td>
                
            </tr>
            </c:forEach>
        </table>
                </div>
                
                
            </div>
            
            
            
            
            
            <input type="button" class="button_active" style="position: absolute ; bottom: 10px; left: 50% ; margin-left: -81px ; font-weight: bold"  
                    value="Back To User Page" onclick="location.href='PP_Utente_Loggato.html';" />
<form  action="utenteLog" method="POST">
            <input type="submit" value="Log Out" style="position: absolute ; right: 15px; bottom:15px; font-weight: bold">
        </form>
        </div>

        <div id="footer">

            <a id="left">Sito realizzato da Fabio & Luca presso Ghiglieno Digital (Ivrea)</a>

        </div>
    </body>
</html>