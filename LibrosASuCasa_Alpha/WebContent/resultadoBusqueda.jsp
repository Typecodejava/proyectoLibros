<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<head>
<title>RESULTADOS DE BÚSQUEDA</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Grocery Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript">
	
	
	
	
	
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } 







</script>
<!-- //for-mobile-aaaapps ppp-->
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<link rel="stylesheet" href="css/bootstrap.min.css">
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
<!-- header -->
<div class="agileits_header">
	<div class="w3l_offers">
		<a href="Menu?operacion=mostrarlibro&idlibro=4"">Ofertas de hoy!</a>
	</div>
	<div class="w3l_search">
		<form action="Menu" method="post">
			<input type="text" name="lib_titulo"
				value="Buscar por título o autor..." onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Buscar por título o autor...';}"
				required=""> <input type="hidden" name="operacion"
				value="busqueda" /> <input type="submit" value="Buscar">
		</form>
	</div>
	<div class="product_list_header">
		<form action="#" method="post" class="last">
			<fieldset>
				<input type="hidden" name="cmd" value="_cart" /> <input
					type="hidden" name="display" value="1" /> <input type="submit"
					name="submit" value="Ver tu carrito" class="button" />
			</fieldset>
		</form>
	</div>
	<div class="w3l_header_right">
		<div class="w3l_offers">
			<a href="login.jsp">BackOffice</a>
		</div>
	</div>
	<div class="clearfix"></div>
</div>
<!-- script-for sticky-nxzcszdczscav -->
<script>
	$(document).ready(function() {
		var navoffeset = $(".agileits_header").offset().top;
		$(window).scroll(function() {
			var scrollpos = $(window).scrollTop();
			if (scrollpos >= navoffeset) {
				$(".agileits_header").addClass("fixed");
			} else {
				$(".agileits_header").removeClass("fixed");
			}
		});

	});
</script>
<!-- //script-for sticky-nav -->

<div class="logo_products">
	<div class="container">
		<div class="w3ls_logo_products_left">
			<h1>
				<a href="Menu?operacion=mostrarcategoria"><span>Libros</span>a
					Su Casa</a>
			</h1>
		</div>
		<div class="w3ls_logo_products_left1">
			<ul class="special_items">
				<li><a href="Menu?operacion=mostrarcontacto">Eventos</a><i>/</i></li>
				<li><a href="Menu?operacion=mostrarcontacto">Sobre Nosotros</a><i>/</i></li>
				<li><a href="Menu?operacion=mostrarcontacto">Ofertas</a><i>/</i></li>
				<li><a href="Menu?operacion=mostrarcontacto">Servicios</a></li>
			</ul>
		</div>
		<div class="w3ls_logo_products_left1">
			<ul class="phone_email">
				<li><i class="fa fa-phone" aria-hidden="true"></i>(+0123) 234
					567</li>
				<li><i class="fa fa-envelope-o" aria-hidden="true"></i><a
					href="mailto:store@grocery.com">store@grocery.com</a></li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
</div>

<!-- //header Este es el final del Header -->
<!-- products-breadcrumb -->
<div class="products-breadcrumb">
	<div class="container">
		<ul>
			<li><i class="fa fa-home" aria-hidden="true"></i><a
				href="Menu?operacion=mostrarcategorias">Home</a><span>|</span></li>
			<li>Listado de libros</li>
		</ul>
	</div>
</div>
<!-- //products-breadcrumb -->
<div class="banner">

	<div class="w3l_banner_nav_left">
		<nav class="navbar nav_bottom">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header nav_2">
				<button type="button" class="navbar-toggle collapsed navbar-toggle1"
					data-toggle="collapse" data-target="#bs-megadropdown-tabs">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<!--  CATEGORIAS DESDE LA BASE DE DATOS -->
			<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
				<ul class="nav navbar-nav nav_1">
					<c:forEach items="${categorias}" var="categoria">
						<li><a
							href="Menu?operacion=busqueda&lib_categoria=${categoria}"><b>${categoria}</b></a></li>
					</c:forEach>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>
	</div>

	<div class="w3l_banner_nav_right">
		<section class="slider">
			<div class="flexslider">
				<c:choose>
					<c:when test="${Listalibros.isEmpty()}">
						<h5><p> No se ha encontrado libro</p></h5>
					</c:when>
					<c:otherwise>

						<c:forEach items="${Listalibros}" var="libro" begin="0">
							<div class="row">
								<div class="col-2">
									<br> <img src="<c:url value='${libro.imagen }'/>"
										height="200" width="150" /> <br>
								</div>

								<div class="col-5">
									<p>--------------------------------------------------------------------------------------------</p>

									<p>
										<a href="Menu?operacion=mostrarlibro&idlibro=${libro.idLibro}"><b>TITULO:
												${libro.titulo}</b></a>
									</p>
									<p>ISBN: ${libro.isbn}</p>
									<p>${libro.autor}</p>
								</div>
								<div class="col-5">
									<p>precio: ${libro.precio }€</p>
									<form action="/Menu">
										<input type="hidden" name="operacion" value="anadircarrito">
										<input type="hidden" name="idLibro" value="${idLibro}">
										<input type="submit" value="Comprar" />
									</form>

								</div>
							</div>
						</c:forEach>

					</c:otherwise>
				</c:choose>

			</div>
		</section>
		
		<br><br>
		
		<!-- flexSlider -->
		<link rel="stylesheet" href="css/flexslider.css" type="text/css"
			media="screen" property="" />
		<script defer src="js/jquery.flexslider.js"></script>
		<script type="text/javascript">
			$(window).load(function() {
				$('.flexslider').flexslider({
					animation : "slide",
					start : function(slider) {
						$('body').removeClass('loading');
					}
				});
			});
		</script>
		<!-- //flexSlider -->
	</div>
	<div class="clearfix"></div>
</div>


<!-- newsletter -->
<div class="newsletter">
	<div class="container">
		<div class="w3agile_newsletter_left">
			<h3>sign up for our newsletter</h3>
		</div>
		<div class="w3agile_newsletter_right">
			<form action="#" method="post">
				<input type="email" name="Email" value="Email"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Email';}" required="">
				<input type="submit" value="subscribe now">
			</form>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!-- //newsletter -->





<!-- footer -->
<div class="footer">
	<div class="container">
		<div class="col-md-3 w3_footer_grid">
			<h3>information</h3>
			<ul class="w3_footer_grid_list">
				<li><a href="events.html">Events</a></li>
				<li><a href="about.html">About Us</a></li>
				<li><a href="products.html">Best Deals</a></li>
				<li><a href="services.html">Services</a></li>
				<li><a href="short-codes.html">Short Codes</a></li>
			</ul>
		</div>
		<div class="col-md-3 w3_footer_grid">
			<h3>policy info</h3>
			<ul class="w3_footer_grid_list">
				<li><a href="faqs.html">FAQ</a></li>
				<li><a href="privacy.html">privacy policy</a></li>
				<li><a href="privacy.html">terms of use</a></li>
			</ul>
		</div>
		<div class="col-md-3 w3_footer_grid">
			<h3>what in stores</h3>
			<ul class="w3_footer_grid_list">
				<li><a href="pet.html">Pet Food</a></li>
				<li><a href="frozen.html">Frozen Snacks</a></li>
				<li><a href="kitchen.html">Kitchen</a></li>
				<li><a href="products.html">Branded Foods</a></li>
				<li><a href="household.html">Households</a></li>
			</ul>
		</div>
		<div class="col-md-3 w3_footer_grid">
			<h3>twitter posts</h3>
			<ul class="w3_footer_grid_list1">
				<li><label class="fa fa-twitter" aria-hidden="true"></label><i>01
						day ago</i><span>Non numquam <a href="#">http://sd.ds/13jklf#</a>
						eius modi tempora incidunt ut labore et <a href="#">http://sd.ds/1389kjklf#</a>quo
						nulla.
				</span></li>
				<li><label class="fa fa-twitter" aria-hidden="true"></label><i>02
						day ago</i><span>Con numquam <a href="#">http://fd.uf/56hfg#</a>
						eius modi tempora incidunt ut labore et <a href="#">http://fd.uf/56hfg#</a>quo
						nulla.
				</span></li>
			</ul>
		</div>
		<div class="clearfix"></div>
		<div class="agile_footer_grids">
			<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
				<div class="w3_footer_grid_bottom">
					<h4>100% secure payments</h4>
					<img src="images/card.png" alt=" " class="img-responsive" />
				</div>
			</div>
			<div class="col-md-3 w3_footer_grid agile_footer_grids_w3_footer">
				<div class="w3_footer_grid_bottom">
					<h5>connect with us</h5>
					<ul class="agileits_social_icons">
						<li><a href="#" class="facebook"><i
								class="fa fa-facebook" aria-hidden="true"></i></a></li>
						<li><a href="#" class="twitter"><i class="fa fa-twitter"
								aria-hidden="true"></i></a></li>
						<li><a href="#" class="google"><i
								class="fa fa-google-plus" aria-hidden="true"></i></a></li>
						<li><a href="#" class="instagram"><i
								class="fa fa-instagram" aria-hidden="true"></i></a></li>
						<li><a href="#" class="dribbble"><i
								class="fa fa-dribbble" aria-hidden="true"></i></a></li>
					</ul>
				</div>
			</div>
			<div class="clearfix"></div>
		</div>
		<div class="wthree_footer_copy">
			<p>
				© 2016 Grocery Store. All rights reserved | Design by <a
					href="http://w3layouts.com/">W3layouts</a>
			</p>
		</div>
	</div>
</div>
<!-- //footer -->
<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>
<script>
	$(document).ready(function() {
		$(".dropdown").hover(function() {
			$('.dropdown-menu', this).stop(true, true).slideDown("fast");
			$(this).toggleClass('open');
		}, function() {
			$('.dropdown-menu', this).stop(true, true).slideUp("fast");
			$(this).toggleClass('open');
		});
	});
</script>
<!-- here stars scrolling icon -->
<script type="text/javascript">
	$(document).ready(function() {
		/*
			var defaults = {
			containerID: 'toTop', // fading element id
			containerHoverID: 'toTopHover', // fading element hover id
			scrollSpeed: 1200,
			easingType: 'linear' 
			};
		 */

		$().UItoTop({
			easingType : 'easeOutQuart'
		});

	});
</script>
<!-- //here ends scrolling icon -->
<script src="js/minicart.js"></script>
<script>
	paypal.minicart.render();

	paypal.minicart.cart
			.on(
					'checkout',
					function(evt) {
						var items = this.items(), len = items.length, total = 0, i;

						// Count the number of each item in the cart
						for (i = 0; i < len; i++) {
							total += items[i].get('quantity');
						}

						if (total < 3) {
							alert('The minimum order quantity is 3. Please add more to your shopping cart before checking out');
							evt.preventDefault();
						}
					});
</script>


</body>
</html>
