

<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>PAGINA PRINCIPAL</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!-- //for-mobile-apps -->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- font-awesome icons -->
<link href="css/font-awesome.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- //font-awesome icons -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link
	href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>


</head>

<body>
<!-- header -->
	<div class="agileits_header">
		<div class="w3l_offers">
			<a href="products.html">Ofertas de hoy!</a>
		</div>
		<div class="w3l_search">
			<form action="Menu" method="post">
				<input type="text" name="lib_titulo" value="Buscar por título o autor..." onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Buscar por título o autor...';}" required="">
				<input type="hidden" name="operacion" value="busqueda" />		
				<input type="submit" value="Buscar">
			</form>
		</div>
		<div class="product_list_header">  
			<form action="#" method="post" class="last">
                <fieldset>
                    <input type="hidden" name="cmd" value="_cart" />
                    <input type="hidden" name="display" value="1" />
                    <input type="submit" name="submit" value="Ver tu carrito" class="button" />
                </fieldset>
            </form>
		</div>
		<div class="w3l_header_right">
			<div class="w3l_offers">
				<a href="login.jsp">BackOffice</a>
			</div>
		</div>
		<div class="clearfix"> </div>
	</div>
<!-- script-for sticky-nav -->
	<script>
	$(document).ready(function() {
		 var navoffeset=$(".agileits_header").offset().top;
		 $(window).scroll(function(){
			var scrollpos=$(window).scrollTop(); 
			if(scrollpos >=navoffeset){
				$(".agileits_header").addClass("fixed");
			}else{
				$(".agileits_header").removeClass("fixed");
			}
		 });
		 
	});
	</script>
<!-- //script-for sticky-nav -->
	<div class="logo_products">
		<div class="container">
			<div class="w3ls_logo_products_left">
				<h1><a href="Menu?operacion=mostrarcategoria"><span>Libros</span>a Su Casa</a></h1>
			</div>
			<div class="w3ls_logo_products_left1">
				<ul class="special_items">
					<li><a href="events.html">Eventos</a><i>/</i></li>
					<li><a href="about.html">Sobre Nosotros</a><i>/</i></li>
					<li><a href="products.html">Ofertas</a><i>/</i></li>
					<li><a href="services.html">Servicios</a></li>
				</ul>
			</div>
			<div class="w3ls_logo_products_left1">
				<ul class="phone_email">
					<li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234 567</li>
					<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a href="mailto:store@grocery.com">store@grocery.com</a></li>
				</ul>
			</div>
			<div class="clearfix"> </div>
		</div>
	</div>
<!-- //header Este es el final del Header -->


<!-- banner -->
	<div class="banner">
		<div class="w3l_banner_nav_left">
			<nav class="navbar nav_bottom">
			 <!-- Brand and toggle get grouped for better mobile display -->
			  <div class="navbar-header nav_2">
				  <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
			   </div> 
			   <!-- Collect the nav links, forms, and other content for toggling -->
			   <!--  CATEGORIAS DESDE LA BASE DE DATOS -->
				<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
					<ul class="nav navbar-nav nav_1">
						<c:forEach items="${categorias}" var="categoria">
							<li><a href="Menu?operacion=busqueda&lib_categoria=${categoria}"><b>${categoria}</b></a></li>
						</c:forEach>
					
					</ul>
				 </div><!-- /.navbar-collapse -->
			</nav>
		</div>
		<div class="w3l_banner_nav_right">
			<section class="slider">
				<div class="flexslider">
					<ul class="slides">
						<li>
							<div class="w3l_banner_nav_right_banner">
								
								<div class="more">
									<!--  <a href="products.html" class="button--saqui button--round-l button--text-thick" data-text="Shop now">Shop now</a> -->
								</div>
							</div>
						</li>
						<li>
							<div class="w3l_banner_nav_right_banner1">
								<h3>&nbsp;<span>&nbsp;</span>&nbsp;</h3>
								<div class="more">
									<a href="products.html" class="button--saqui button--round-l button--text-thick" data-text="Shut up and take my money!">Shut up and take my money!</a>
								</div>
							</div>
						</li>
						<li>
							<div class="w3l_banner_nav_right_banner2">
								<h3>&nbsp;<i>&nbsp;</i> &nbsp;</h3>
								<div class="more">
									<a href="products.html" class="button--saqui button--round-l button--text-thick" data-text="Diezmar">Donar todo mi dinero.</a>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</section>
			<!-- flexSlider -->
				<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" property="" />
				<script defer src="js/jquery.flexslider.js"></script>
				<script type="text/javascript">
				$(window).load(function(){
				  $('.flexslider').flexslider({
					animation: "slide",
					start: function(slider){
					  $('body').removeClass('loading');
					}
				  });
				});
			  </script>
			<!-- //flexSlider -->
		</div>
		<div class="clearfix"></div>
	</div>
<!-- banner -->


<!-- 

	<h1>CATEGORÍAS DE LIBROS</h1>
>>>>>>> refs/remotes/origin/emmanuel
	<div id="wrapper">
		<ul>
			<c:forEach items="${categorias}" var="categoria">
<<<<<<< HEAD

				<li><a
					href="Menu?operacion=busqueda&lib_categoria=${categoria}">${categoria}</a></li>
=======
				<li><a href="Menu?operacion=busqueda&lib_categoria=${categoria}">${categoria}</a></li>
>>>>>>> refs/remotes/origin/emmanuel
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

 -->

</body>
</html>
