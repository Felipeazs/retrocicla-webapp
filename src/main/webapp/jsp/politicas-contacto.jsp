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
		</nav>
		<section class="container-flex seccion-politicas pb-5 bg-light">
			<div class="row">
				<div class="col-md-3 links">
					<div class="sub-columna-1">
						<h3 class="fw-bold">Políticas Retrocicla</h3>
						<div class="container">
							<dl>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right"></i
									><a href="/politicas-privacidad" class="fs-6">Políticas de privacidad</a>
								</dd>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right active"></i
									><a href="/politicas-contacto" class="fs-6">Políticas de contacto</a>
								</dd>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right"></i
									><a href="/politicas-pago" class="fs-6">Políticas medios de pago</a>
								</dd>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right"></i
									><a href="/politicas-despacho" class="fs-6">Políticas de despacho</a>
								</dd>
								<hr />
							</dl>
						</div>
					</div>
				</div>
				<div class="col-md-9 contenido">
					<h3 class="fw-bold">Políticas de Contacto</h3>
					<p class="mb-3 mt-3 fw-bold">I. De los canales de contacto.</p>
					<p>
						En el evento que usted como usuario presente alguna duda sobre la presente política de
						privacidad y otras políticas, las prácticas que efectúe la plataforma tecnológica digital o las
						relaciones Usuario – RetroCicla, podrá contactarse con la empresa haciendo uso de cualquiera de
						los siguientes medios:
					</p>
					<ul class="ms-4">
						<li><p>Facebook: @Retrocicla</p></li>
						<li><p>Instagram: @RetroCicla</p></li>
						<li><p>Página web: https://www.retrocicla.cl</p></li>
						<li>
							<p>WhatsApp: +56 9 ____________.</p>
						</li>
						<li>
							<p>Correo electrónico: retrocila@gmail.com</p>
						</li>
					</ul>
					<p class="mb-3 fw-bold">II. De los mensajes y respuestas.</p>
					<p>
						Como RetroCicla siempre estaremos dispuestos a recibir comentarios, sugerencias y dudas, las
						cuales responderemos dentro de un tiempo prudente. No obstante lo anterior, serán consideradas
						como no efectuados todos los comentarios que sean denigrantes para la empresa, sus miembros o
						sus aliados, aquellos que sean calificables como comentarios de odio, o cualquier forma de
						discurso de odio, entre otros, todos los cuales podrán ser borrados por cualquiera de los
						miembros de la empresa sin expresión de causa. En caso de reiteración de conducta, los miembros
						poseen la facultad inamovible de vetar permanentemente de los servicios al emisor de dichos
						comentarios así como aplicar todas las medidas que la plataforma y la ley le confieran a la
						empresa.
					</p>
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
