<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>update de Libros</title>
</head>
<body>
	<div>
		<h2>Alta de libro</h2>
		<div>
			<form action="LoginServlet2?operacion=update" method="post">
				<table>
					<tr>
						<td>ISBN: </td><td><input type="text" name="isbn" value="${libro.isbn}" maxlength="20" size="20"></td>
						<td>Título: </td><td><input type="text" name="titulo" value="${libro.titulo}" maxlength="44" size="30"></td>
					</tr>
					<tr>
						<td>Descripcion: </td><td colspan="3"><textarea name="descripcion" cols="50">${libro.descripcion}</textarea></td>
					</tr>
					<tr>
						<td>Sinopsis: </td><td colspan="3"><textarea name="sinopsis" cols="50">${libro.sinopsis}</textarea></td>
					</tr>
					<tr>
						<td>Precio: </td><td><input type="text" name="precio" size="4" value="${libro.precio}"> Cantidad: <input type="text" name="cantidad" size="4" value="${libro.cantidad}"></td>
						<td>Imagen: </td><td><input type="file" name="imagen" value="${libro.imagen}"></td>
				</table>
				<input type="hidden" name="idLibro" value="${libro.idLibro }" />	
				<input type="hidden" name="operacion" value="update" />		
				<input type="submit" value="Enviar ">
			</form>
		</div> 
	</div>
</body>
</html>