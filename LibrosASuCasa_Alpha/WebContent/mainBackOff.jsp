<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administration Main Page</title>
</head>
<body>
	<div>
		<h2>Administration Main Page</h2>
			<h3>Bienvenid@: ${nombre}</h3>
			<h4>Administración de Libros</h4>
			
			<c:if test="${libros.isEmpty()}">
				<p>Actualmenten no hay ningún libro en la Base asdfasdfasdfde Datos.</p>
			</c:if>
			
			<c:if test="!${libros.isEmpty()}">
				<p>Estupendo, hay libros en la Base de Datos.</p>
			</c:if>
			
			
			<c:choose>
				<c:when test="${libros.isEmpty()}">
					<p>Actualmenten no hay ningún libro en la Base de Datos.</p>
				</c:when>
				
				
				
			<c:otherwise>
			<div name="tabla">
				<table border="1">
					<thead><tr>
						<th>idLibros</th><th>ISBN</th><th>Título</th><th>Precio</th><th>Cantidad</th><th>Modificar</th><th>Eliminar</th>
					</tr></thead>
					<tbody>
                        <c:forEach var="libros" items="${libros}">
                            <tr>
                            	<td>${libros.idLibro}</td>
                                <td>${libros.isbn}</td>
                                <td>${libros.titulo}</td>
                                <td>${libros.precio}</td>
                                <td>${libros.cantidad}</td>
                                <td><a href="LoginServlet2?operacion=mostrarupdate&idlibro=${libros.idLibro}">Modificar</a></td>
                                <td><a href="LoginServlet2?operacion=baja&idlibro=${libros.idLibro}">Eliminar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    
				</table>
			</div>
			</c:otherwise>
			
			</c:choose>
	</div>
	<div>
		<a href="LoginServlet2?operacion=mostraralta">Añadir libro a la base de datos.</a>
	</div>
</body>
</html>