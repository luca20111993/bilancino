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
        <link href="CssFolder/Inserimento_SpesaCss.css" rel="stylesheet" type="text/css"/>
        <title>Elenco Transazioni Utente</title>
    </head>
    <body>


        <div id="header">
            <div id="titolo">Tutte le tue transazioni a portata di click!</div>
        </div>




        <div id="maindiv">
            <div id="title">Pagina di aggiunta spesa.</div>



            <div id="testo">


                <div id="container">
                    <form  action="AddSpesa" method="POST">

                        <a id="CTitle">Scegliere Categoria</a> <br>
                        <select  style="margin-top: 5px; width: 200px;text-align: center"name="categoria">
                            <c:forEach items="${categoriaSrv.findAll()}" var="cat">


                                <option value="${cat.id}" >   <c:out value="${cat.id}"/>  </option>


                            </c:forEach>
                        </select>
                        <br>
                        <br>
                        <br>
                        <a id="CTitle">Inserire Importo</a><br>

                        <input type ="text" style="margin-top: 5px;width: 200px ;text-align: center"   size="20" value="" placeholder="importo/00" name="importo" >

                        <br>
                        <br>
                        <br>
                        <a id="CTitle">Inserire descrizione</a><br>

                        <input type ="text" style="margin-top: 5px;width: 200px;text-align: center "   size="255" value="" placeholder="Inserire descrizione!" name="descrizione" >
                        <br>
                        <br>
                        <br>
                        <input type="submit" value="Invio" name="pulsanteInvio" style="width: 100px ; height: 25px ; font-size:medium"> 


                    </form>
                </div>
            </div>


            <div id="container2">
            <div id="testo2">
                
                <a id="CTitle">Ultima spesa registrata</a>
                <br><br>
                <c:set var="spe" value="${speseSrv.findLastSpesa()}"/>

                <div  style="margin-top: 5px;">Categoria : <c:out value="${spe.categoria.id}"/> </div>
                <div style="margin-top: 5px;">Importo : <c:out value="${spe.importo}"/> </div> 
                <div style="margin-top: 5px;">Data: <c:out value="${spe.dataCreazione}"/> </div>
                <div style="margin-top: 5px;">Descrizione : <c:out value="${spe.descrizione}"/> </div>


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
