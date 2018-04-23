<%-- 
    Document   : jugar
    Created on : 23-abr-2018, 1:18:11
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
        <h3 class="subtitulo">Registro de jugadas</h3>
        
        <c:set var="digitos" scope="session" value="${digitos}"/>
        
        <form action="controlador" method="post">
            <label for="digitos">Introduce un n&uacute;mero: </label> 
            
            <c:forEach var="i" begin="0" end="${digitos-1}">
                <input type="number" name="num${i}" min="0" max="9" required="required"/>       
            </c:forEach>
            
            <c:if test="${muertos!=null}">
                <p class="mensaje">Has encontrado ${heridos} heridos y ${muertos} muertos.</p>
            </c:if>
                
            <br/><br>
            <input type="submit" name="enviar" value="Enviar"/> 
        </form>
        
    </body>
</html>
