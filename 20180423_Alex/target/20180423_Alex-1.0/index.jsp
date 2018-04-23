<%-- 
    Document   : index
    Created on : 22-abr-2018, 23:45:23
    Author     : Alex
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mastermind</title>
        <link rel="stylesheet" type="text/css" href="CSS/estilos.css"/>
    </head>
    <body class="contenido">
        <h3 class="titulo">Mastermind. Juego de los muertos y los heridos</h3>
        <h3 class="subtitulo">Configuraci&oacute;n del juego</h3>
        
        <form action="controlador" method="post">
            <label for="digitos">Introduce la cantidad de d&iacute;gitos (de 2 a 9)</label> <input type="number" name="digitos" min="2" max="9" required="required"/>
            <br/><br>
            <input type="submit" name="configurar" value="Configurar"/> 
        </form>
        
    </body>
</html>
