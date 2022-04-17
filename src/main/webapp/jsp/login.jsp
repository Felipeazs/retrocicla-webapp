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
							<a href="/login"><i class="bi bi-person-circle active"></i></a>
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
		<section class="container-flex seccion-usuario pt-5">
			<div class="row">
				<div class="col-sm-12 col-md-6 acceder">
					<h4 class="fw-bold">Acceder</h4>
					<form action="/login" method="POST">
						<div class="container pt-3">
							<div class="row pb-3">
								<label for="">Correo electrónico</label>
								<input type="text" name="username" class="form-control" id="usuario" placeholder="" />
							</div>
							<div class="row pb-3">
								<label for="">Contraseña</label>
								<input
									type="password"
									name="password"
									class="form-control"
									id="password"
									placeholder=""
								/>
							</div>
							<c:if test="${ param.error != null }">
								<p>*Usuario y/o contraseña incorrectos</p>
							</c:if>
							<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }" />
							<div class="text-center">
								<button class="boton fs-6 p-2">Acceder</button>
								<a href="">
									<p class="p-3">Olvidaste la contraseña?</p>
								</a>
							</div>
						</div>
					</form>
				</div>
				<div class="col-md-6 acceder pb-5">
					<h4 class="fw-bold">Regístrate</h4>
					<div class="container pt-3 pb-3">
						<div class="row pb-3">
							<label for="">Nombre de usuario</label>
							<input type="text" />
						</div>
						<div class="row pb-3">
							<label for="">Correo electrónico</label>
							<input type="text" />
						</div>
						<div class="row pb-3">
							<label for="">Contraseña</label>
							<input type="text" />
						</div>
						<div class="row pb-3">
							<label for="">Repita la Contraseña</label>
							<input type="text" />
						</div>
						<p class="pb-3">
							Sus datos personales se utilizarán para respaldar su experiencia en este sitio web, para
							administrar el acceso a su cuenta y para otros fines descritos en nuestra política de
							privacidad.
						</p>
						<div class="row text-center">
							<a href="/registrado"><button class="boton fs-6 p-2">Regístrate</button></a>
							<div class="col"><input type="checkbox" /> <span>Únete a nuestro newsletter</span></div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="seccion-bajada">
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
							<a href="/politicas-privacidad">Política de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
