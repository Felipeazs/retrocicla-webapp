<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

<!DOCTYPE html>
<html>
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
		<link rel="stylesheet" href="css/flickity.css" />
		<link rel="stylesheet" href="css/style.css" />
		<script src="js/script.js"></script>
		<title>Retrocicla</title>
	</head>
	<body>
		<!-- Header -->

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

		<!-- Navegador -->

		<nav class="container-fluid">
			<div class="row nav">
				<div class="col-sm-12 col-md-3 logo">
					<img src="img/logo-menu.png" alt="logo" />
				</div>
				<div class="col-md-6">
					<ul class="nav align-items-center justify-content-center fs-5">
						<li class="nav-item">
							<a class="nav-link active text-white" aria-current="page" href="/">INICIO</a>
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
							<a class="nav-link text-white" href="/blog">BLOG</a>
						</li>
					</ul>
				</div>
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

		<!-- Carousel inicial -->

		<section>
			<div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button
						type="button"
						data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0"
						class="active"
						aria-current="true"
						aria-label="Slide 1"
					></button>
					<button
						type="button"
						data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1"
						aria-label="Slide 2"
					></button>
					<button
						type="button"
						data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="2"
						aria-label="Slide 3"
					></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/index-1.png" class="d-block w-100" alt="imagen-carousel-1" />
						<div class="texto">
							<p class="p-0 m-0">ACABEMOS</p>
							<p class="fs-2 p-0 m-0">con el ciclo destinado a los textiles</p>
						</div>
					</div>
					<div class="carousel-item">
						<img src="img/somos.png" class="d-block w-100" alt="imagen-carousel-2" />
					</div>
					<div class="carousel-item">
						<img src="img/index-2.png" class="d-block w-100" alt="imagen-carousel-3" />
						<div class="texto">
							<p class="p-0 m-0">Reciclemos</p>
							<p class="fs-2 p-0 m-0">no tires tu ropa, dónala</p>
							<div class="row">
								<div class="col-6">
									<a href="/donaciones"><button class="boton text-center p-2">Donaciones</button></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<button
					class="carousel-control-prev"
					type="button"
					data-bs-target="#carouselExampleIndicators"
					data-bs-slide="prev"
				>
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button
					class="carousel-control-next"
					type="button"
					data-bs-target="#carouselExampleIndicators"
					data-bs-slide="next"
				>
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</section>

		<!-- Somos -->

		<article class="container-fluid">
			<div class="row seccion-secundaria-index">
				<p class="text-white">
					Somos un emprendimiento liderado por mujeres que quieren cambiar la
					<span>industria textil</span> por medio de la <span>economÃ­a circular</span>. Nuestra labor es
					apoyar a los emprendimientos de <span>upcycler</span> y crear conciencia medioambiental en los
					jÃ³venes.
				</p>
				<div class="row d-flex justify-content-center">
					<div class="col-md-3">
						<a href="/somos"><button type="button" class="btn btn-success mt-5 boton">Conócenos</button></a>
					</div>
				</div>
			</div>
		</article>

		<!-- Donaciones -->

		<div class="container-fluid">
			<div class="row seccion-terciaria-index">
				<div class="col-sm-12 col-md-5 d-flex justify-content-center">
					<img src="img/img-1.png" alt="" />
				</div>
				<div class="col-sm-12 col-md-7 text-center d-flex align-items-center">
					<div class="mensaje">
						<img src="img/img-2.png" alt="" />
						<p>No sabes donde donar?</p>
						<div class="row d-flex justify-content-center">
							<div class="col-md-4">
								<button type="button" class="btn btn-success boton">Más Info.</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Catálogo -->

		<div class="seccion-catalogo">
			<a href="/tienda"><p class="text-center">Tienda / Catálogo</p></a>
			<div class="container galeria">
				<div class="row d-flex justify-content-center">
					<div class="col-md-3 galeria-cell">
						<img class="img-responsive" src="img/algodon-2.jpg" alt="" />
						<div class="item">
							<span class="fs-3">Tipo de prenda</span>
						</div>
					</div>
					<div class="col-md-3 galeria-cell">
						<img src="img/seda-1.jpg" alt="" />

						<div class="item">
							<span class="fs-3">Materiales</span>
						</div>
					</div>
					<div class="col-md-3 galeria-cell">
						<img src="img/tejidos.jpg" alt="" />
						<div class="item">
							<span class="fs-3">Accesorios</span>
						</div>
					</div>
					<div class="col-md-3 galeria-cell">
						<img src="img/jacketDenim2.jpg" alt="" />
						<div class="item">
							<span class="fs-3">Servicios</span>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Video -->

		<div class="container-fluid seccion-video d-flex align-items-center">
			<div class="row p-5">
				<div class="col-sm-12 col-md-5 d-flex justify-content-center">
					<iframe
						width="560"
						height="315"
						src="https://www.youtube.com/embed/8m5d1pVFZNA"
						title="YouTube video player"
						frameborder="0"
						allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
						allowfullscreen
					></iframe>
				</div>
				<div class="col-sm-12 col-md-7 d-flex justify-content-center content">
					<div class="contaier-fluid text-center">
						<div class="row mensaje">
							<img src="img/recupera.png" alt="" />
							<p>Revisaste nuestro blog?</p>
						</div>
						<div class="row d-flex justify-content-center">
							<div class="col-md-4">
								<button type="button" class="btn btn-success boton">Más Info.</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

		<!-- Blog Noticias -->

		<div class="seccion-catalogo">
			<p class="text-center">Blog / Noticias</p>
			<div class="galeria js-flickity">
				<div class="galeria-cell">
					<img class="img-responsive" src="img/news-1.jpeg" alt="" />
					<i class="fa-solid fa-newspaper fa-2x"></i>
					<div class="item">
						<span>Noticia 1</span>
						<strong>subtitulo</strong>
					</div>
				</div>
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

		<!-- Newsletter -->

		<section class="container-fluid seccion-bajada">
			<img src="img/reutiliza.png" alt="" />
			<div class="centro">
				<p>Ya estas registrado a nuestro newsletter?</p>
				<span
					>Se el primero en tener nuestros catálogos de productos, nuestras novedades. Obtén descuentos
					personalizados, invitaciones a eventos y más.
				</span>
				<div class="input">
					<input type="email" placeholder="CORREO ELECTRÓNICO" />
					<button class="button"><i class="fa-solid fa-chevron-right"></i></button>
				</div>
			</div>
			<img src="img/recicla.png" alt="" />
		</section>

		<!-- Apoyos -->

		<section class="container-fluid seccion-apoyo">
			<div class="row">
				<p>Proyecto apoyado por:</p>
				<div class="row marca">
					<div class="col-sm-12 col-md-4 d-flex justify-content-center">
						<img src="img/corfo.png" alt="" />
					</div>
					<div class="col-sm-12 col-md-4 d-flex justify-content-center">
						<img src="img/chrysalis.png" height="40" alt="" />
					</div>
					<div class="col-sm-12 col-md-4 d-flex justify-content-center">
						<img src="img/gene.png" alt="" />
					</div>
				</div>
			</div>
		</section>

		<!-- Footer -->

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

			<!-- Términos y condiciones -->

			<div class="container-fluid seccion-inferior">
				<div class="row text-center">
					<div class="col-md-4">
						<p>Copyright retrocicla.cl</p>
					</div>
					<div class="col-md-8 d-flex justify-content-end">
						<div>
							<a href="">Términos y condiciones</a> | <a href="">Política de reembolso</a> |
							<a href="/politicas-privacidad">Política de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
