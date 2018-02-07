<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<title>LOGIN ADMINISTRADOR</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/restaurante.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<h1>INGRESE DATOS ADMINISTRADOR</h1>




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



</body>
</html>