

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="CssFolder/Inserisci_CategoriaCss.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>


        <div id="header">
            <div id="titolo">Tutte le tue transazioni a portata di click!</div>
        </div>



        <div id="maindiv">
            <div id="title">Pagina di registrazione al bilancino.</div>



            <div id="testo">


                <div id="container">
                    <form method="POST" action="AddCategoria">

                        <br>

                        <div>
                            <a id="CTitle">Inserire il nome della nuova categoria da aggiungere</a>
                            <br>
                            <a id="SmallTitle">Gentilmente fare attenzione a maiuscole e minuscole</a>
                            <br><br>
                        </div>
                        <input type ="text" style="width: 200px ; text-align: center "   size="20" value="" placeholder="Inserire Categoria Desiderata" name="categoria" >
                        <br><BR>

                        <input type="submit" value="Invio" name="pulsanteInvio" style="width: 100px ; height: 25px ; font-size:medium"> 

                    </form>
                </div>
            </div>
            <div id="testo3">


                <div id="container">
                    <form method="POST" action="RemoveCategoria">

                        <br>

                        <div>
                            <a id="CTitle">Inserire il nome della categoria da <u>cancellare</u></a>
                            <br>
                            <a id="SmallTitle">Gentilmente fare attenzione a maiuscole e minuscole</a>
                            <br><br>
                        </div>
                        <input type ="text" style="width: 200px ; text-align: center "   size="20" value="" placeholder="Inserire Categoria Desiderata" name="categoriaC" >
                        <br><BR>

                        <input type="submit" value="Invio" name="pulsanteInvio" style="width: 100px ; height: 25px ; font-size:medium"> 

                    </form>
                </div>
            </div>
            
            
            <div id="testo2">
                <br>
                <a id="CTitle">Lista delle categorie già esistenti</a>
                <br><br>
                <c:forEach items="${categoriaSrv.findByUt()}" var="cat">

                    <div><c:out value="${cat.nome}"/> </div>
                    


                </c:forEach>
                
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
