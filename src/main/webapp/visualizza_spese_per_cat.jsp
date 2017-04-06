<%-- 
    Document   : visualizza_spese_per_cat
    Created on : 5-apr-2017, 12.26.18
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="CssFolder/Visualizza_Spese_Per_Cat.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>

        
        
        
        
        
        
         <div id="header">
            <div id="titolo">Tutte le tue transazioni a portata di click!</div>
        </div>




        <div id="maindiv">
            <div id="title">Visualizzazione per categorie</div>



            <div id="testo">


                <div id="container">
                    
                    <form  action="visualizza_spese_per_cat.jsp" method="GET">
                        <a id="CTitle">Selezionare una categoria.</a><br><br>
            <select name="categoria">
                <option>scegli una categoria</option>
                <c:forEach items="${categoriaSrv.findAll()}" var="cat">

                    <c:if test="${param.categoria eq cat.nome}">
                        <option value="${cat.id}" selected>   <c:out value="${cat.nome}"/>  </option>
                    </c:if>
                        
                    <c:if test="${param.categoria != cat.nome}">
                        <option value="${cat.id}" >   <c:out value="${cat.nome}"/>  </option>
                    </c:if>

                </c:forEach>
                        
            </select>
            <br> <br>
            <a id="CTitle">Selezionare un lasso di tempo</a> <br><br>
            <select name="tempo">

                <option>scegli un periodo di tempo</option>
                <option value="7gg" >7 Giorni</option>
                <option value="1mese" >1 Mese</option>
                <option value="tutto" >tutte</option>


            </select>
            <br> <br>


            <input type="submit" value="Invio" name="PulsanteInvio" style="width: 100px ; height: 25px ; font-size:medium">             
        </form>
                    
                </div>
            </div>
            
            
            
            
                <div id="container2">
                    <div id="testo2">
                        <table style="margin: 0 auto">

            <th >Categoria</th>
            <th id="last">Importo</th>
            <th id="last">Data Creazione</th>
            <th id="last">Descrizione</th>


            <c:forEach items="${speseSrv.scegli(param.tempo,param.categoria)}" var="spese"> 
                
                <tr>
                    <td >   <c:out value="${spese.categoria.nome}"/>  </td>
                    <td id="last" >   <c:out value="${spese.importo}"/>  </td>
                    <td id="last">   <c:out value="${spese.dataCreazione}"/>  </td>
                    <td id="last">   <c:out value="${spese.descrizione}"/>  </td>
                </tr>

            </c:forEach>

        </table>
                    </div>
                </div>
            
            <input type="button" class="button_active" style="position: absolute ; bottom: 10px; left: 50% ; margin-left: -81px ; font-weight: bold"  
                   value="Back To User Page" onclick="location.href = 'PP_Utente_Loggato.html';" />
            <form  action="utenteLog" method="POST">
                <input type="submit" value="Log Out" style="position: absolute ; right: 15px; bottom:15px; font-weight: bold">
            </form>
        </div>

        <div id="footer">

            <a id="left">Sito realizzato da Fabio & Luca presso Ghiglieno Digital (Ivrea)</a>

        </div>
        
        
    </body>
</html>
