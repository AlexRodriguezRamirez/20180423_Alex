<%-- 
    Document   : finalizar
    Created on : 23-abr-2018, 5:20:33
    Author     : Alex
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mastermind</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        
        <c:set var="adivina" scope="session" value="${adivina}"/>
        <p><c:out value="${adivina}"/></p>
        <h3 class="titulo">Mastermind. Juego de los muertos y los heridos</h3>
        <h3 class="subtitulo">Juego finalizado</h3>
        
        <c:set var="digitos" scope="session" value="${digitos}"/>
        
        <form action="repetir" method="post">
            
            <p class="mensaje">¡ENHORABUENA! Ha acertado el n&uacute;mero ${adivina}</p>
            <p>¿Quiere jugar otra vez?</p>
               
            <br/><br>
            <input type="submit" name="si" value="Si"/>
            <input type="submit" name="no" value="No"/> 
        </form>
        
    </body>
</html>