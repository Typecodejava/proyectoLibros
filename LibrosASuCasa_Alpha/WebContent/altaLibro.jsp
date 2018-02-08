<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			<form action="AdminMenu?operacion=alta" method="post">
				<table border=1>
					<tr>
						<td>ISBN: </td><td><input type="text" name="isbn" maxlength="20" size="20"></td>
						<td>Título: </td><td><input type="text" name="titulo" maxlength="44" size="30"></td>
						<td>Descripcion: </td><td><input type="text" name="titulo" size="60"></td>
						<td>Sinopsis: </td><td><input type="text" name="titulo" maxlength="44"></td>
						<td>Precio: </td><td><input type="text" name="titulo" maxlength="44"></td>
						<td>Cantidad: </td><td><input type="text" name="titulo" maxlength="44"></td>
				</table>
			</form>
		</div>
	</div>
</body>
</html>