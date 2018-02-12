<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>LOGIN ADMINISTRADOR</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/restaurante.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
</head>

<body>
	<div class="logindiv">
		<h2>INGRESE DATOS ADMINISTRADOR</h2>
		<form action="LoginServlet" method="post">
			<fieldset>
				<legend>LOGIN</legend>
				<p>
					Name: <input type="text" name="name"><br>
					<br> Password: <input type="password" name="password"><br>
					<br> <input type="submit" value="enviar">
			</fieldset>
		</form>

		<P>${Error}</P>


		<p>
			<a href="paginaprincipal.jsp">Volver a la pagina principal</a>
		</p>
	</div>


</body>
</html>