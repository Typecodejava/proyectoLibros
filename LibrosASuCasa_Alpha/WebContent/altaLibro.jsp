<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta de Libros</title>
</head>
<body>
	<div>
		<h2>Alta de libro</h2>
		<div>
			<form action="LoginServlet?operacion=alta" method="post">
				<table>
					<tr>
						<td>ISBN: </td><td><input type="text" name="isbn" maxlength="20" size="20"></td>
						<td>Título: </td><td><input type="text" name="titulo" maxlength="44" size="30"></td>
					</tr>
					<tr>
						<td>Descripcion: </td><td colspan="3"><textarea name="descripcion" cols="50"></textarea></td>
					</tr>
					<tr>
						<td>Sinopsis: </td><td colspan="3"><textarea name="sinopsis" cols="50"></textarea></td>
					</tr>
					<tr>
						<td>Precio: </td><td><input type="text" name="precio" maxlength="5" size="4"></td>
						<td>Cantidad: </td><td><input type="text" name="cantidad" maxlength="6" size="4"></td>
				</table>
			</form>
		</div>
	</div>
</body>
</html>