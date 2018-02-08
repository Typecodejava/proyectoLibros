<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>RESULTADO DE BUSQUEDA</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
	<h1>LIBROS CON COINCIDENCIA</h1>




	<ul style="list-style-type: circle">

						<P>TITULO: ${libro.titulo}</P>
						
						<p>ISBN: ${libro.isbn}</p>

						<p>DESCRIPCION: ${libro.descripcion}</p>

						<p>PRECIO: ${libro.precio}€</p>

						<p>SINOPSIS: ${libro.sinopsis}</p></li>


	</ul>

