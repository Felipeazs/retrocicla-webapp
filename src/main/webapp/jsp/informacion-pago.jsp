<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

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
					<a href="cliente"><i class="bi bi-person-circle"></i></a>
					<a href="carrito"><i class="bi bi-bag active"></i></a>
				</div>
			</div>
		</nav>
		<div class="container-flex seccion-informacion bg-light pb-5">
			<div class="seccion-informacion">
				<div class="row primera">
					<div class="col-md-2 text-center">
						<img src="img/logo-carrito.png" alt="" style="width: 50%" />
					</div>
					<div class="col d-flex align-items-center">
						<span>Carrito</span>
						|<span>Información</span> |<span>Envíos</span> |<span style="color: #00ff99">Pagos</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-7">					
					<section class="mt-3">
						<p class="fs-5 mb-4 fw-bold">Información contacto</p>
						<div class="mb-2 pago">Contacto: Felipe Zapata S.</div>
						<div class="mb-2 pago">email: felipeazs@gmail.com</div>
						<div class="mb-2 pago">Enviar a: Marte 2183, Quilpué, Valparaíso</div>
						<div class="mb-2 pago">Envío: Retiro en tienda.</div>
						<div class="">
							<p class="fs-4 fw-bold mt-4">Método de pago</p>
						</div>
						<div class="col-md-6 mb-2 envios">
							<div class="formulario">
								<input type="radio" class="form-check-input" id="radio" name="radio1" checked />
								<label for="" class="form-check-label">Web pay</label>
							</div>							
						</div>
						<span class="fw-bold pago-span"
							>Luego de hacer un clic en “Finalizar”, serás redirigido a Pago Fácil - WebpayPlus para
							completar tu compra de forma segura.</span>
						
						<div class="col-md-6 mb-2 envios">
							<div class="formulario">
								<input type="radio" class="form-check-input" id="radio" name="radio1" />
								<label for="" class="form-check-label">Transferencia bancario</label>
							</div>
						</div>
						<span class="fw-bold pago-span"
							>Pago a través de transfarencia. No olvides sacarle un pantallazo o anotar los datos de
							transferencia que a parecen a continuación
						</span>
						<p class="fs-4 fw-bold mt-3">Dirección de facturación</p>
						<div class="col-md-6 mb-2 envios">
							<div class="formulario">
								<input type="radio" class="form-check-input" id="radio" name="radio2" checked />
								<label for="" class="form-check-label">Misma direccion de envío</label>
							</div>
						</div>
						<div class="col-md-6 mb-2 envios">
							<div class="formulario">
								<input type="radio" class="form-check-input" id="radio" name="radio2" />
								<label for="" class="form-check-label"
									>Usar una direccion de facturación distinta</label
								>
							</div>
						</div>
						<div class="row justify-content-start">
							<div class="col-md-3">
								<a href="redirigiendo"><button class="boton fs-6 p-2 mt-3">Continuar</button></a>
							</div>
							<div class="col-md-2">
								<a href="informacion-envio"><button class="boton fs-6 p-2 mt-3 bg-transparent">Volver</button></a>
								
							</div>
						</div>
					</section>
				</div>
				<div class="col-md-5 derecha">
					<div class="container">
						<div class="row justify-content-start">
							<div class="col-md-6 formulario">
								<label for="">Cupón</label>
								<input type="text" class="input form-control form-control-sm" />
							</div>
							<div class="col-md-6">
								<button class="boton fs-6 p-2 mt-4">Usar</button>
							</div>
						</div>
					</div>
					<hr />
					<div class="container-fluid">
						<div class="container">
							<div class="row">
								<div class="col-4">
									<img src="img/fibra-natural-1.png" alt="" />
								</div>
								<div class="col-4 info-detalle">
									<p>Algodón</p>
									<p>3 unidades</span>
								</div>
								<div class="col-4 info-detalle d-flex justify-content-end">
									<p>$32.970</p>
								</div>
							</div>
						</div>
					</div>
					<hr>
					<div class="container-fluid fw-bold fs-6">
						<div class="container">
							<div class="row justify-content-between ">
								<div class="col-4">
									<p>SubTotal</p>
									<p class="">Envío</p>
								</div>
								<div class="col-2">
									<p>$32.970</p>
									<p>$5.800</p>
								</div>
							</div>
						</div>
						<hr>
						<div class="container">
							<div class="row justify-content-between">
								<div class="col-4">
									<p>Total</p>
								</div>
								<div class="col-2">
									<p>$38.770</p>
								</div>
							</div>
						</div>
					</div>
					<div class="text-center mt-5"><img src="img/retrocicla-round.png" alt="" style="width: 35%;"></div>				
				</div>
			</div>
		</div>
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
