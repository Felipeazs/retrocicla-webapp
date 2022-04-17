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
							<a class="nav-link text-white active" aria-current="page" href="/somos">SOMOS</a>
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
						<div class="bag">
							<a href="/carrito"><i class="bi bi-bag"></i></a>
							<div class="span text-center">${ tamano_carrito }</div>
						</div>
						<div class="person">
							<a href="/login"><i class="bi bi-person-circle"></i></a>
						</div>
					</div>
				</div>
				<div class="col d-flex align-items-center justify-content-center">
					<c:if test="${ not empty cliente }">
						<div class="row">
							<div class="col-md-6 salir">
								<a href="/logout"><span class="text-white d-flex justify-content-start">Salir</span></a>
							</div>
						</div>
					</c:if>
				</div>
			</div>
		</nav>
		<section class="container-fluid seccion-principal-somos">
			<div class="row upper-figure">
				<img class="image-1" src="img/somos-text.png" alt="" />
				<img class="image-2" src="img/somos.png" alt="" />
			</div>
		</section>
		<article>
			<div class="container-flluid seccion-secundaria-somos">
				<div class="row somos">
					<p>
						Somos una empresa liderada por <span>5 mujeres</span>, de la región de Valparaíso que se dedican
						a la gestión del reciclaje textil. A través de nuestra propuesta buscamos generar conciencia
						respecto a los <span>desechos textiles</span>, y a recuperar su valor.
					</p>
					<div class="container-fluid row imagenes">
						<div class="col"><img src="img/somos-1.png" alt="" /></div>
						<div class="col">
							<img src="img/somos-2.png" alt="" />
						</div>
						<div class="col">
							<img src="img/somos-3.png" alt="" />
						</div>
						<div class="col"><img src="img/somos-4.png" alt="" /></div>
						<div class="col"><img src="img/somos-5.png" alt="" /></div>
					</div>
				</div>
			</div>
		</article>
		<article class="container-fluid seccion-terciaria-somos">
			<img class="img-1" src="img/recupera-white.png" alt="" />
			<img class="img-4" src="img/clip.png" alt="" />
			<div class="mision">
				<p class="principal">Misión</p>
				<p>Crear un mundo más sostenible por medio de la recuperación textil.</p>
				<p class="principal">Visión</p>
				<p>
					Empresa líder en reciclaje textil en latinoamérica potencia la economía circular para la creación de
					un mundo más sostenible.
				</p>
				<p class="principal">Nuestros valores</p>
				<p>
					Amistad y compañerismo / Trabajo colaborativo / Desarrollo sostenible de la industria de la moda /
					Upcycling es una herramienta de cambio / Producción y consumo responsable / Consumidores
					responsables / Sociedad más consciente / Responsabilidad con el medio ambiente / Agentes de cambio,
					que revolucionan la industria / La moda del futuro es sustentable / La moda puede ser más
					transparente, responsable, colaborativa y genere salarios justos y equitativos.
				</p>
			</div>
			<img class="img-3" src="img/retrocicla-round.png" alt="" />
			<img class="img-2" src="img/upcycling.png" alt="" />
		</article>
		<div class="seccion-catalogo">
			<p>Equipo retrocicla</p>
			<div class="galeria js-flickity">
				<div class="galeria-cell">
					<img class="img-responsive" src="img/maru.jpeg" alt="" />
					<i class="fa-brands fa-linkedin-in fa-2x"></i>
					<div class="item equipo">
						<span>María Martínez</span>
						<strong>Depto. Operaciones</strong>
						<strong>Depto. Finanzas</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/erika.jpeg" alt="" />
					<i class="fa-brands fa-linkedin-in fa-2x"></i>
					<div class="item equipo">
						<span>Erika Parraguez</span>
						<strong>Depto. de Direccion Estratégica y Operaciones</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/darlyn.jpeg" alt="" />
					<i class="fa-brands fa-linkedin-in fa-2x"></i>
					<div class="item equipo">
						<span>Darlyn Riquelme</span>
						<strong>Depto. de Direccion Estratégica y Recursos humanos</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/millaray" alt="" />
					<i class="fa-brands fa-linkedin-in fa-2x"></i>
					<div class="item equipo">
						<span>Millaray Ponce</span>
						<strong>Depto. de Clientes y Marketing</strong>
					</div>
				</div>
				<div class="galeria-cell">
					<img src="img/alba.jpeg" alt="" />
					<i class="fa-brands fa-linkedin-in fa-2x"></i>
					<div class="item equipo">
						<span>Alba José</span>
						<strong>Depto. de Clientes y Marketing</strong>
					</div>
				</div>
			</div>
		</div>
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
							<a href="">Términos y condiciones</a> | <a href="">Poítica de reembolso</a> |
							<a href="pages/politicas-privacidad">Política de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
