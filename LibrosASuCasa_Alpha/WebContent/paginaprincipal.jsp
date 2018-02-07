<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>BUSQUEDA POR TITULO</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/restaurante.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<h1>CATEGORÍAS DE LIBROS</h1>
	<div id="wrapper">
		<ul>
			<c:forEach items="${categorias}" var="categoria">

				<li><a
					href="Menu?operacion=busqueda&lib_categoria=${categoria}">${categoria}</a></li>
			</c:forEach>
		</ul>
		<div id="header">



			<h1>BUSQUEDA DE LIBRO POR TITULO :)</h1>

		</div>
		<div id="main">
			<form action="Menu" method="post">
				<fieldset>
					<legend>TÍTULO</legend>
					<p>
						<label for="nombre">Indique Título de libro a Buscar:</label> <input
							type="text" id="lib_titulo" name="lib_titulo" required="required" />
					<p>
						<input type="hidden" name="operacion" value="busqueda" /> <input
							type="submit" value="Enviar" />
					</p>
				</fieldset>
			</form>

			<form action="Menu" method="post">
				<fieldset>
					<legend>AUTOR</legend>
					<p>
						<label for="nombre">Indique Autor del libro a Buscar:</label> <input
							type="text" id="lib_autor" name="lib_autor" required />
					</p>
					<p>
						<input type="hidden" name="operacion" value="busqueda" /> <input
							type="submit" value="Enviar" />
					</p>
				</fieldset>
			</form>
		</div>



		<p>
		<h2>Login Admin using HttpSession</h2>
		<a href="login.jsp">Login</a>
		</p>


	</div>
	</div>
</body>
</html>