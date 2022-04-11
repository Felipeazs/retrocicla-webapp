<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<!--JQuery-->
		<script
			src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous"
		></script>
		<!--Bootstrap-->
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
			crossorigin="anonymous"
		/>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
			crossorigin="anonymous"
		></script>
		<!--Bootstrap iconos-->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css" />
		<!--Flickity gallery-->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flickity/1.0.0/flickity.css" />
		<script src="https://cdnjs.cloudflare.com/ajax/libs/flickity/1.0.0/flickity.pkgd.js"></script>
		<!--FontAwesome-->
		<link
			rel="stylesheet"
			href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css"
			integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g=="
			crossorigin="anonymous"
			referrerpolicy="no-referrer"
		/>
		<!---->
		<link rel="stylesheet" href="css/flickity.css" />
		<link rel="stylesheet" href="css/style.css" />
		<script src="js/script.js"></script>
		<title>Retrocicla</title>
	</head>
	<body>
		<header class="container-fluid">
			<div class="row header d-flex justify-content-between">
				<div
					class="col-xs-4 col-sm-5 col-md-4 d-flex justify-content-start header align-items-center header-inicio"
				>
					<i class="bi bi-envelope"></i>
					<p>retrocicla@gmail.com</p>
				</div>
				<div class="col-md-4 text-center align-items-center header-centro">
					<p>Upcycling Chile</p>
				</div>
				<div
					class="col-xs-3 col-sm-5 col-md-4 d-flex justify-content-center align-items-center header header-final"
				>
					<i class="bi bi-whatsapp pe-3"></i>
					<i class="bi bi-instagram pe-3"></i>
					<i class="bi bi-facebook"></i>
				</div>
			</div>
		</header>
		<nav class="container-fluid">
			<div class="row nav">
				<div class="col-sm-12 col-md-3 logo">
					<img src="/img/logo-menu.png" alt="logo" />
				</div>
				<div class="col-md-6">
					<ul class="nav align-items-center justify-content-center fs-5">
						<li class="nav-item">
							<a class="nav-link text-white" href="/">INICIO</a>
						</li>
						<li class="nav-item">
							<a class="nav-link text-white" href="/somos">SOMOS</a>
						</li>
						<li class="nav-item">
							<a class="nav-link text-white active" aria-current="page" href="/tienda">TIENDA</a>
						</li>
						<li class="nav-item">
							<a class="nav-link text-white" href="/donaciones">DONACIONES</a>
						</li>
						<li class="nav-item">
							<a class="nav-link text-white" href="/blog">BLOG</a>
						</li>
					</ul>
				</div>
				<div class="col-sm-12 col-md-2 d-flex align-items-center justify-content-end user">
					<a href="cliente.html"><i class="bi bi-person-circle"></i></a>
					<i class="bi bi-bag"></i>
				</div>
			</div>
		</nav>
		<div class="container-fluid seccion-tienda">
			<div class="row d-flex justify-content-center">
				<div class="col-md-3"><input type="text" placeholder="BUSCA EN NUESTRA TIENDA" /></div>
				<div class="col-md-1 text-center">
					<button class="button"><i class="fa-solid fa-chevron-right"></i></button>
				</div>
			</div>
		</div>
		<div class="seccion-catalogo">
			<a href="/materiales">
				<p>Tipo de prenda</p>
			</a>
			<div class="galeria js-flickity">
				<div class="galeria-cell">
					<img class="img-responsive" src="/img/algodon-2.jpg" alt="" />
					<!-- <i class="fa-solid fa-bag-shopping fa-2x"></i> -->
					<div class="item">
						<span class="fs-3">Poleras</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/jacketDenim2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Chaquetas</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/pantalon.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Pantalones</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/falda.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Faldas</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/polerones.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Polerones</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/lana-2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Chalecos</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/camisa.webp" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Camisas</span>
					</div>
				</div>
			</div>
		</div>
		<div class="seccion-catalogo">
			<p>Materiales</p>
			<div class="galeria js-flickity">
				<div class="galeria-cell">
					<img class="img-responsive" src="/img/" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Algodón</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/seda-1.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Seda</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/tejidos.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Tejidos</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Denim</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/lino.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
					<span class="fs-3">Lino</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/Poliester.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Poliester</span>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/lana-2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span class="fs-3">Lana</span>
					</div>
				</div>
			</div>
		</div>
		<div class="seccion-catalogo">
			<p>Accesorios</p>
			<div class="galeria js-flickity">
				<div class="galeria-cell">
					<img class="img-responsive" src="/img/algodon-2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span>item 1</span>
						<strong>$10.990</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/seda-1.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span>item 2</span>
						<strong>$10.990</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/tejidos.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span>item 3</span>
						<strong>$10.990</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/jacketDenim2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span>item 4</span>
						<strong>$10.990</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/lino.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span>item 5</span>
						<strong>$10.990</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/Poliester.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span>item 6</span>
						<strong>$10.990</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="/img/lana-2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
					<div class="item">
						<span>item 7</span>
						<strong>$10.990</strong>
					</div>
				</div>
			</div>
		</div>
		<section class="container-fluid seccion-bajada-tienda">
			<div class="row">
				<div class="col-sm-12 col-md-6">
					<div class="row align-items-center">
						<div class="col-md-3"><img src="/img/clip.png" alt="clip" /></div>
						<div class="col-md-9 text-white ps-5 pe-5 text-center">
							<p>No encuentras lo que necesitas? Contáctanos!!</p>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-6">
					<div class="row">
						<div class="col-sm-12 col-md-9">
							<div class="row">
								<div class="col-sm-12"><input type="text" placeholder="Nombre" /></div>
								<div class="col-sm-12"><input type="email" placeholder="Correo electrÃ³nico" /></div>
								<div class="col-sm-12">
									<textarea rows="4" cols="20" placeholder="Escribe aquí..."></textarea>
								</div>
								<div class="col-sm-12 text-center">
									<button><i class="fa-solid fa-chevron-right"></i></button>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-3">
							<img src="/img/retrocicla-round.png" alt="retrocicla-round" />
						</div>
					</div>
				</div>
			</div>
		</section>
		<footer class="footer">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-8 mb-4 seccion-superior">
						<div class="row">
							<div class="col-md-6">
								<img src="img/logo-footer.png" alt="" class="img-responsive" />
							</div>
							<div class="col-sm-12 col-md-6 text-center mt-5">
								<p>HORARIOS</p>
								<p>Lunes a Viernes de 10 a 18 hrs</p>
							</div>
						</div>
					</div>
					<div class="col-sm-12 col-md-4 d-flex justify-content-center align-items-center seccion-final">
						<p>CONTÁCTANOS</p>
						<div class="iconos">
							<i class="bi bi-envelope ps-3 pe-3"></i>
							<i class="bi bi-whatsapp pe-3"></i>
							<i class="bi bi-instagram pe-3"></i>
							<i class="bi bi-facebook pe-3"></i>
						</div>
					</div>
				</div>
			</div>
			<hr />
			<div class="container-fluid seccion-inferior">
				<div class="row text-center">
					<div class="col-md-4">
						<p>Copyright retrocicla.cl</p>
					</div>
					<div class="col-md-8 d-flex justify-content-end">
						<div>
							<a href="">Términos y condiciones</a> | <a href="">Política de reembolso</a> |
							<a href="pages/politicas-privacidad.html">Polí­tica de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
