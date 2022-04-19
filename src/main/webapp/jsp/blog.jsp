<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

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
					<img src="img/logo-menu.png" alt="logo" />
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
							<a class="nav-link text-white" href="/tienda">TIENDA</a>
						</li>
						<li class="nav-item">
							<a class="nav-link text-white" href="/donaciones">DONACIONES</a>
						</li>
						<li class="nav-item">
							<a class="nav-link text-white active" aria-current="page" href="/blog">BLOG</a>
						</li>
					</ul>
				</div>

				<!--Usuario y Carrito-->

				<div class="col-sm-12 col-md-2 d-flex align-items-center justify-content-end user">
					<div class="row">
						<div class="col bag">
							<a href="/carrito"><i class="bi bi-bag"></i></a>
							<div class="span text-center">${ tamano_carrito }</div>
						</div>
						<div class="col person">
							<a href="/login"><i class="bi bi-person-circle"></i></a>
						</div>
						<div class="col d-flex align-items-center justify-content-center">
							<c:if test="${ not empty cliente }">
								<a href="/logout"
									><div class="row">
										<div class="col-md-6 salir">
											<span class="text-white d-flex justify-content-start">Salir</span>
										</div>
									</div>
								</a>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</nav>
		<section class="container-fluid seccion-blog text-center pt-5">
			<div class="video-1">
				<p class="fw-bold fs-3">Qué vemos?</p>
				<iframe
					class="pb-5"
					src="https://www.youtube.com/embed/0HZl9_MhwFc"
					title="YouTube video player"
					frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen
				></iframe>
			</div>
			<div class="videos-2 pt-5 pb-5">
				<iframe
					width="290"
					height="175"
					src="https://www.youtube.com/embed/_4j_lAOniv8"
					title="YouTube video player"
					frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen
				></iframe>
				<iframe
					width="290"
					height="175"
					src="https://www.youtube.com/embed/LH2YTEvWVio"
					title="YouTube video player"
					frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen
				></iframe>
				<iframe
					width="290"
					height="175"
					src="https://www.youtube.com/embed/xmV34zEmWAI"
					title="YouTube video player"
					frameborder="0"
					allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
					allowfullscreen
				></iframe>
			</div>
		</section>
		<div class="seccion-catalogo">
			<p>Blog / Noticias</p>
			<div class="galeria js-flickity">
				<a href="noticias">
					<div class="galeria-cell">
						<img class="img-responsive" src="img/news-1.jpeg" alt="" />
						<i class="fa-solid fa-newspaper fa-2x"></i>
						<div class="item">
							<span>Vertederos</span>
							<strong>CNN</strong>
						</div>
					</div>
				</a>
				<div class="galeria-cell">
					<img src="img/news-2.avif" alt="" />
					<i class="fa-solid fa-newspaper fa-2x"></i>
					<div class="item">
						<span>Noticia 2</span>
						<strong>subtitulo</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/news-3.png" alt="" />
					<i class="fa-solid fa-newspaper fa-2x"></i>
					<div class="item">
						<span>Noticia 3</span>
						<strong>subtitulo</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/news-4.jpeg" alt="" />
					<i class="fa-solid fa-newspaper fa-2x"></i>
					<div class="item">
						<span>Noticia 4</span>
						<strong>subtitulo</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/news-5.jpeg" alt="" />
					<i class="fa-solid fa-newspaper fa-2x"></i>
					<div class="item">
						<span>Noticia 5</span>
						<strong>subtitulo</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/news-6.jpeg" alt="" />
					<i class="fa-solid fa-newspaper fa-2x"></i>
					<div class="item">
						<span>Noticia 6</span>
						<strong>subtitulo</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/news-7.webp" alt="" />
					<i class="fa-solid fa-newspaper fa-2x"></i>
					<div class="item">
						<span>Noticia 7</span>
						<strong>subtitulo</strong>
					</div>
				</div>
			</div>
		</div>
		<section class="seccion-bajada">
			<img src="img/reutiliza.png" alt="" />
			<div class="centro">
				<p>Ya estas registrado a nuestro newsletter?</p>
				<span
					>Se el primero en tener nuestros catálogos de productos, nuestras novedades. Obtén descuentos
					personalizados, invitaciones a eventos y más.
				</span>
				<div class="input">
					<input type="email" placeholder="CORREO ELECTRÃNICO" />
					<button class="button"><i class="fa-solid fa-chevron-right"></i></button>
				</div>
			</div>
			<img src="img/recicla.png" alt="" />
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
						<p>CONTÁCTANOS</p>
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
							<a href="">Términos y condiciones</a> | <a href="">Políica de reembolso</a> |
							<a href="politicas-privacidad">Política de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>