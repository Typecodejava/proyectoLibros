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

		<c:choose>
			<c:when test="${Listalibros.isEmpty()}">
				<p>No se ha encontrado libro</p>
			</c:when>
			<c:otherwise>
				<c:forEach items="${Listalibros}" var="libro" begin="0">
					<p>----------------------------------------------------------------------------------------------------------------------------------------------</p>
					<li><P>TITULO: ${libro.titulo}</P>
						<p>ISBN: ${libro.isbn}</p>

						<p>DESCRIPCION: ${libro.descripcion}</p>

						<p>PRECIO: ${libro.precio}€</p>

						<p>SINOPSIS: ${libro.sinopsis}</p></li>
				</c:forEach>
			</c:otherwise>
		</c:choose>


	</ul>



</body>
</html>
