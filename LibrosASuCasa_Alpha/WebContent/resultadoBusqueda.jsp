<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>RESULTADO DE BUSQUEDA</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/restaurante.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<h1>LIBROS CON COINCIDENCIA</h1>




	<ul style="list-style-type: circle">

		<c:forEach items="${Listalibros}" var="libro" begin="0">
			<p>----------------------------------------------------------------------------------------------------------------------------------------------</p>
			<li><P>TITULO: ${libro.titulo}</P>

				<p>ISBN: ${libro.isbn}</p>

				<p>DESCRIPCION: ${libro.descripcion}</p>

				<p>PRECIO: ${libro.precio}€</p>

				<p>SINOPSIS: ${libro.sinopsis}</p></li>
		</c:forEach>
	</ul>



</body>
</html>
