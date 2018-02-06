<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>RESULTADO DE BUSQUEDA</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width">
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>  
        <link href="css/restaurante.css" rel="stylesheet" type="text/css" /> 
    </head>
    <body>
       <h1>RESULTADOS LIBROS</h1>
        <p>
        <ul>
        	<br>

        	<c:forEach items="${Listalibros}" var="libro" begin="0">
        		<p>----------------------------------------------------------------------------------------------------------------------------------------------</p>
        		<P>TITULO: ${libro.titulo}</P><br/>
        		<p>ISBN: ${libro.isbn} </p><br/>
   				<p>DESCRIPCION: ${libro.descripcion} </p><br/>
    			<p>PRECIO: ${libro.precio}€ </p><br/>
    			<p>SINOPSIS: ${libro.sinopsis} </p><br/>
        	</c:forEach>
        	
        </ul>

        </p>
    </body>
</html>
