<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%><%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<meta name="_csrf" content="${_csrf.token}" />
		<meta name="_csrf_header" content="${_csrf.headerName}" />
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
		<link rel="stylesheet" href="../css/flickity.css" />
		<link rel="stylesheet" href="../css/style.css" />
		<script src="../js/script.js"></script>
		<title>Catálogo</title>
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
					<img src="../img/logo-menu.png" alt="logo" />
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
		<section class="container-fluid bg-light seccion-registro-producto">
			<div class="row">
				<form method="GET" action="">
					<div class="row">
						<div class="col">
							<section class="">
								<p class="fs-4 fw-bold pb-4">Información del producto</p>
								<div class="row pb-2">
									<div class="col-3 formulario">
										<label for="">Tipo</label>
										<select class="form-select form-select-sm" name="tipo" id="">
											<option value="prenda">prenda</option>
											<option value="material">material</option>
										</select>
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-12 formulario">
										<label for="">Descripcion</label>
										<input
											name="descripcion"
											type="text"
											class="input form-control form-control-sm"
										/>
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-6 formulario">
										<label for="">Prenda</label>
										<select class="form-select form-select-sm" name="prenda" id="">
											<option value="pantalón">pantalón</option>
											<option value="polera">polera</option>
											<option value="camisa">camisa</option>
											<option value="chaleco">chaleco</option>
											<option value="polerón">polerón</option>
											<option value="blusa">blusa</option>
											<option value="falda">falda</option>
										</select>
									</div>
									<div class="col-6 formulario">
										<label for="">Género</label>
										<select class="form-select form-select-sm" name="genero" id="">
											<option value="femenino">femenino</option>
											<option value="masculino">masculino</option>
											<option value="unisex">unisex</option>
										</select>
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-3 formulario">
										<label for="">Talla</label>
										<select class="form-select form-select-sm" name="talla" id="">
											<option value="xs">xs</option>
											<option value="s">s</option>
											<option value="m">m</option>
											<option value="l">l</option>
											<option value="xl">xl</option>
											<option value="xxl">xxl</option>
											<option value="12">12</option>
											<option value="16">16</option>
											<option value="38">38</option>
											<option value="40">40</option>
											<option value="42">42</option>
											<option value="48">48</option>
											<option value="52">52</option>
										</select>
									</div>
									<div class="col-3 formulario">
										<label for="">Estilo</label>
										<select class="form-select form-select-sm" name="estilo" id="">
											<option value="casual">casual</option>
											<option value="outdoor">outdoor</option>
											<option value="deportivo">deportivo</option>
											<option value="formal">formal</option>
										</select>
									</div>
									<div class="col-3 formulario">
										<label for="">Color</label>
										<select class="form-select form-select-sm" name="color" id="">
											<option value="multicolor">multicolor</option>
											<option value="blanco">blanco</option>
											<option value="negro">negro</option>
											<option value="gris">gris</option>
											<option value="azul">azul</option>
											<option value="rojo">rojo</option>
											<option value="rosado">rosado</option>
											<option value="café">café</option>
											<option value="amarillo">amarillo</option>
											<option value="burdeo">burdeo</option>
											<option value="calipso">calipso</option>
											<option value="plateado">plateado</option>
										</select>
									</div>
									<div class="col-3 formulario">
										<label for="">Patrón</label>
										<select class="form-select form-select-sm" name="patron" id="">
											<option value="patrón">patrón</option>
											<option value="liso">liso</option>
										</select>
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-4 formulario">
										<label for="">Material</label>
										<select class="form-select form-select-sm" name="material" id="">
											<option value="algodón">algodón</option>
											<option value="lino">lino</option>
											<option value="poliester">poliester</option>
											<option value="spandex">spandex</option>
											<option value="viscosa">viscosa</option>
										</select>
									</div>
									<div class="col-4 formulario">
										<label for="">Fibra</label>
										<select class="form-select form-select-sm" name="fibra" id="">
											<option value="artificial">artificial</option>
											<option value="natural">natural</option>
										</select>
									</div>
									<div class="col-4 formulario">
										<label for="">Estación</label>
										<select class="form-select form-select-sm" name="estacion" id="">
											<option value="otoño-invierno">otoño-invierno</option>
											<option value="primavera-verano">primavera-verano</option>
										</select>
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-6 formulario">
										<label for="">Precio</label>
										<input name="precio" type="number" class="input form-control form-control-sm" />
									</div>
									<div class="col-3 formulario">
										<label for="">Stock</label>
										<input name="stock" type="number" class="input form-control form-control-sm" />
									</div>
									<div class="col-3 formulario">
										<label for="">Origen</label>
										<select class="form-select form-select-sm" name="origen" id="">
											<option value="Chile">Chile</option>
											<option value="China">China</option>
										</select>
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-12 formulario">
										<label for="">Imagen 1</label>
										<input name="imagen" type="text" class="input form-control form-control-sm" />
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-12 formulario">
										<label for="">Imagen 2</label>
										<input name="imagen" type="text" class="input form-control form-control-sm" />
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-12 formulario">
										<label for="">Imagen 3</label>
										<input name="imagen" type="text" class="input form-control form-control-sm" />
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-12 formulario">
										<label for="">Imagen 4</label>
										<input name="imagen" type="text" class="input form-control form-control-sm" />
									</div>
								</div>
								<div class="row pb-2">
									<div class="col-12 formulario">
										<label for="">Imagen 5</label>
										<input name="imagen" type="text" class="input form-control form-control-sm" />
									</div>
								</div>
								<div class="row justify-content-center">
									<div class="col-sm-6 col-md-4">
										<button
											type="button"
											class="button fs-5 p-2 mt-3"
											onclick="registrarProducto()"
										>
											Registrar
										</button>
									</div>
								</div>
							</section>
						</div>
					</div>
				</form>
			</div>
		</section>
		<footer class="footer">
			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-8 mb-4 seccion-superior">
						<div class="row">
							<div class="col-md-6">
								<img src="../img/logo-footer.png" alt="" class="img-responsive" />
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
							<a href="">Términos y condiciones</a> | <a href="">Polí­tica de reembolso</a> |
							<a href="../politicas-privacidad">Polí­tica de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
