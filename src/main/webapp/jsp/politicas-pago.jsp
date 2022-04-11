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
					<a href="carrito"><i class="bi bi-bag"></i></a>
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
									<i class="fa-solid fa-chevron-right"></i
									><a href="/politicas-contacto" class="fs-6">Políticas de contacto</a>
								</dd>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right active"></i
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
					<h3 class="fw-bold">Políticas de Medios de Pago</h3>
					<p class="mb-3 mt-3 fw-bold">I. De los medios de pago en general.</p>
					<p>
						Como contrapartida de la prestación de servicios que ofrece RetroCicla, el usuario podrá cumplir su
						obligación efectuando el pago adeudado por cualquiera de los siguientes medios habilitados en la
						plataforma:
					</p>
					<ul class="ms-4">
						<li><p>Sistema de pago por Redcompra.</p></li>
						<li><p>Asociación de Tarjetas de Crédito.</p></li>
						<li><p>Transferencia Bancaria a cuenta habilitada</p></li>
						<li>
							<p>Pago por link habilitado o código QR especialmente designado.</p>
						</li>
					</ul>
					<p>
						RetroCicla les asegura que tanto el pago efectuado como los datos del usuario estarán protegidos
						mediante el uso de certificados SSL, asunto que fuera tratado en el punto V. de la Política de
						privacidad.
					</p>
					<p class="mb-3 mt-3">A. Caso especial de los contratos de tracto sucesivo.</p>
					<p>
						En el caso de los contratos que celebre la RetroCicla con una empresa o persona natural, mediante
						los cuales se pacten el uso de servicios periódicos, reiterativos, mes a mes o cualquiera otra
						acepción que indique que las obligaciones se generarán en diversas oportunidades tanto para la
						empresa como para el usuario, tales como las suscripciones especiales, aprovisionamientos mensuales
						u otros servicios que se deban repetir posteriormente, el usuario deberá optar por asociar la
						tarjeta de crédito que vaya a soportar el pago los días en que este se devengue.
					</p>
					<p class="mb-3 mt-3">B. Caso general de los contratos de ejecución instantánea.</p>
					<p>
						En el caso de los contratos que sean celebrados de forma única, que devenguen sus efectos para una
						situación determinada, o bien que se desprenda del tenor de aquellos que sus efectos no serán
						reiterados en el tiempo, como lo es la compraventa de A kg de fibra o de X material, podrá el
						usuario hacer uso del pago vía tarjeta asociada al sistema de Redcompra, transferencia bancaria a la
						cuenta asociada a RetroCicla, e inclusive cumplir su obligación pagando mediante link de pago o
						código QR que contenga el valor del servicio contratado, siendo estos últimos proveídos por la
						empresa que ofrece sus servicios.
					</p>
					<p class="mb-3 mt-3 fw-bold">II. De la facultad de retracto.</p>
					<p>
						El usuario podrá dejar sin efecto el contrato celebrado con RetroCicla de forma unilateral siempre y
						cuando manifieste en tiempo y forma dicha intención.
					</p>
					<ul class="ms-4">
						<li>
							<p>
								Para estos efectos, el usuario deberá haber pagado el último servicio ofrecido por la
								empresa en los contratos de ejecución instantánea y posteriormente redactar y enviar con
								importancia alta un correo electrónico a la casilla de RetroCicla expresando su intención de
								no persistir en el contrato y las causas que motivaron dicha decisión; no deberá pagar
								ningún monto, sin embargo, en el evento que el servicio esté pendiente a su ejecución,
								debiendo en este último caso contactarse el usuario por la vía más expedita con la empresa a
								fin que aquella no persista con el servicio.
							</p>
						</li>
						<li>
							<p>
								En el caso de los contratos de tracto sucesivo, será menester que en caso que no haya usado
								los servicios que como empresa ofrecemos, el usuario redacte y envíe el correo mencionado
								anteriormente con a lo máximo con a lo máximo una semana hábil antes de que se devengue el
								próximo pago; de haber continuado usando estos servicios, el usuario deberá pagar su cuota
								mensual respectiva antes de solicitar el cese de los servicios y consecuentemente el pago de
								aquellos.
							</p>
						</li>
						<li>
							<p>
								No se entenderá que el usuario manifiesta su intención de desafiliación, no obstante haya
								enviado el citado correo, cuando ejecute actos que desprendan la intención de persistir en
								la prestación de servicios, tales como celebrar un acto de compraventa respecto a X cantidad
								de materiales, o bien A kg de determinada fibra, por mencionar algunos ejemplos.
							</p>
						</li>
					</ul>
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
							<a href="/politicas-privacidad">Política de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
