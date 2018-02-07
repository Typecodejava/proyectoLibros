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
					<tr>Título: </tr><tr><input type="text" name="titulo" size=44></tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>