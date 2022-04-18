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
		<section class="container-flex seccion-politicas pb-5 bg-light">
			<div class="row">
				<div class="col-md-3 links">
					<h3 class="fw-bold">Políticas Retrocicla</h3>
					<div class="container">
						<dl>
							<hr />
							<dd>
								<i class="fa-solid fa-chevron-right active"></i
								><a href="/politicas-privacidad" class="fs-6">Políticas de privacidad</a>
							</dd>
							<hr />
							<dd>
								<i class="fa-solid fa-chevron-right"></i
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
				<div class="col-md-9 contenido">
					<h3 class="fw-bold">Políticas de Privacidad</h3>
					<p class="mb-3 mt-3 fw-bold">I. De la identificación personal.</p>
					<p>
						RetroCicla podrá recopilar información relativa a la identificación personal de los usuarios
						empleando para ello una variedad de mecanismos, señalando a modo de ejemplo los siguientes:
					</p>
					<ul class="ms-4">
						<li><p>Cuando los usuarios visiten nuestra plataforma tecnológica digital;</p></li>
						<li><p>Cuando los usuarios hagan una solicitud o pedido en la citada plataforma;</p></li>
						<li><p>Cuando los usuarios completen alguno de nuestros formularios;</p></li>
						<li>
							<p>
								Cuando los usuarios hagan uso de las actividades, servicios, funciones o recursos que,
								como empresa, pongamos a su disposición en nuestra plataforma tecnológica digital.
							</p>
						</li>
					</ul>
					<p class="mb-3">
						Dentro de la información personal recabada, esta contemplará los datos relativos al nombre del
						usuario, el correo electrónico asociado para estar en contacto, el número de teléfono para
						similares fines, la dirección postal a la cual deba enviarse el producto o servicio adquirido y
						la información de la tarjeta de crédito que vaya a ser asociada para efectuar los pagos
						asociados a la contratación del servicio. Esta última será solicitada en la medida que el
						usuario manifieste inequívocamente su intención de materializar la adquisición del servicio que
						como empresa ofrecemos. Es menester hacer presente que en caso contrario, la información antes
						señalada sólo se remitirá al conteo de visitas efectuadas a la plataforma, o bien se reducirá a
						la información solicitada mediante formulario adjunto en la citada plataforma web.
					</p>
					<p class="mb-3 fw-bold">II. De la identificación no personal.</p>
					<p>
						RetroCicla podrá recopilar información relativa a la identificación no personal de los usuarios
						cuando aquellos interactúen con nuestro sitio web.
					</p>
					<p>
						La citada información podrá incluir el nombre del navegador por el cual se efectuó la
						interacción, el tipo de equipo empleado para ello y la información técnica del citado como lo es
						el sistema operativo del equipo, su proveedor de servicio de internet o información similar que
						permita adaptar nuestra plataforma tecnológica digital para brindar un mejor servicio a los
						usuarios.
					</p>
					<p class="mb-3 mt-3 fw-bold">III. De las cookies del navegador web.</p>
					<p>
						Nuestra plataforma tecnológica digital podrá hacer uso del sistema de cookies para mejorar las
						experiencias de los usuarios. A mayor abundamiento, el navegador web del usuario sitúa cookies
						seguras en su disco duro, las cuales son usadas para fines de registro y para rastrear
						información relativa a la interacción de algún sitio web. Debe hacerse presente que el usuario
						siempre tendrá la facultad para configurar su navegador web con la finalidad de rechazar las
						citadas o bien, para dicho sistema notifique las situaciones en que aquel estará enviando las ya
						señaladas cookies. No obstante lo anterior, como empresa debemos advertir que de seguir estas
						modalidades, el usuario deberá tener presente que algunas partes de este sitio web podrían dejar
						de funcionar correctamente. En este caso, es responsabilidad personal del usuario habilitar o
						configurar el sistema de cookies que le permitan hacer uso plenamente de la plataforma
						tecnológica digital proveída por nuestra empresa.
					</p>
					<p class="mb-3 mt-3 fw-bold">IV. Del uso de los datos recopilados.</p>
					<p>
						RetroCicla podrá recopilar y utilizar la información personal conferida de los usuarios en los
						puntos anteriores en los siguientes casos:
					</p>
					<ul class="ms-4">
						<li>
							<p>
								Para mejorar el servicio al cliente: La información conferida facultará a que la empresa
								pueda responder a sus solicitudes de servicio al cliente de forma eficaz, del mismo modo
								que nos permitirá como empresa mejorar las necesidades de soporte en la medida que ello
								sea necesario.
							</p>
						</li>
						<li>
							<p>
								Para mejorar la plataforma tecnológica digital: RetroCicla usará los datos
								proporcionados por los usuarios en a fin de hacer una retroalimentación eficiente que
								permita estar alerta ante cualquier defecto por nimio que sea y evitar complicaciones en
								los servicios ofrecidos.
							</p>
						</li>
						<li>
							<p>
								Para mejorar el cumplimiento de los servicios ofrecidos: La empresa utilizará la
								información personal conferida por los usuarios solamente cuando se materialice la
								adquisición del servicio. A fin de explicar el particular, sólo se compartirá la
								información con terceros en la medida que esto sea necesario para materializar la
								ejecución del contrato como lo es, por ejemplo, el conferir la dirección postal del
								usuario a la empresa de despacho contratada para hacer la entrega del producto. Para
								generar actividades en beneficio de los usuarios: RetroCicla hará uso de su información
								para notificarle de promociones, concursos, o encuestas de satisfacción de los servicios
								ofrecidos, así como eventualmente referir sitios ad-hoc a las preferencias de los
								usuarios.
							</p>
						</li>
						<li>
							<p>
								Para crear y personalizar el Newsletter enviado a los usuarios: Para ello la empresa
								podrá utilizar la dirección de correo electrónico proveída previamente por los usuarios
								con la finalidad de enviarles informaciones relativas a la empresa tales como la
								actualización de la política de privacidad y otras políticas, actualizaciones de los
								servicios ofrecidos y o el estado en que se encuentran, responder consultas efectuadas.
								Sin embargo y atendida la naturaleza de los Newsletter, será menester que el usuario de
								forma clara e inequívoca manifieste su intención de recibir este tipo de correo, sin
								perjuicio que en actos posteriores decida unilateralmente poner término a este servicio,
								el cual tendrá que ser informado mediante formulario o botón especialmente dispuesto en
								el mismo Newsletter enviado. Se hace presente que de manifestar el interés de no recibir
								estos correos, el usuario no podrá retractarse de su decisión salvo transcurridos 3
								meses desde que haya manifestado la intención de no recibir los Newsletter.
							</p>
						</li>
					</ul>
					<p class="mb-3 mt-3 fw-bold">V. De la protección de la información aportada.</p>
					<p>
						RetroCicla adoptará diversas prácticas de recopilación, almacenamiento y procesamiento de datos,
						por lo anterior, se tomarán las medidas de seguridad necesarias para proteger su información
						personal de accesos no autorizados, alteración, divulgación o destrucción de sus datos tales
						como nombre de usuario, contraseña, información de transacciones y otros datos almacenados en
						nuestro sitio web. Para asegurar lo anterior, el intercambio de los datos citados se llevará a
						cabo por medio de un canal digital protegido con el sistema de Secure Socket Layer (o SSL) que
						cifrará y protegerá mediante firmas digitales la información objeto del intercambio.
					</p>
					<p class="mb-3 mt-3 fw-bold">VI. De la difusión de la información aportada.</p>
					<p>
						RetroCicla no venderá, comercializará ni alquilará la información que sus usuarios le hayan
						conferido. A lo sumo, la empresa podrá compartir información no vinculada a la identificación
						personal de los usuarios, como lo es la información demográfica, con los socios comerciales,
						afiliados comerciales y anunciantes de RetroCicla a fin que estos últimos generen las propuestas
						o informaciones más personificadas que mejoren los servicios ofrecidos Kallvü podrá, pero solo
						en el evento de haber sido autorizados por ustedes, compartir su información personal con
						Proveedores de servicios que ayuden a operar nuestro negocio y sitio web; o administrar
						actividades a nuestro nombre, como el envío de Newsletter, Encuestas o similares.
					</p>
					<p class="mb-3 mt-3 fw-bold">VII. De los cambios a la política de privacidad.</p>
					<p>
						La empresa posee la facultad de modificar y actualizar la presente política de privacidad en
						todo momento; sin embargo, de hacerse efectivo, dicha modificación o actualización será
						debidamente notificada vía Newsletter a los usuarios registrados y publicado durante a lo menos
						una semana hábil en la plataforma tecnológica digital de RetroCicla. En atención a lo anterior,
						como empresa expresamos que es responsabilidad de los usuarios el revisar periódicamente sus
						Newsletter o en su defecto la plataforma digital de la empresa a fin de tomar conocimiento de
						los cambios que se efectúen en la presente política de privacidad y otras políticas puesto que
						en actos posteriores no podrá alegar el desconocimiento de las modificaciones o actualizaciones
						a las mismas a fin de hacer valer un cumplimiento imperfecto de la obligación de las partes
						contratantes o lisa y llanamente un incumplimiento de la misma. VIII. De la aceptación de la
						política de privacidad. Como empresa hacemos presente que por el mero hecho de usar la presente
						plataforma tecnológica digital, usted como usuario expresa de facto su aceptación a la presente
						política de privacidad y otras políticas. Del mismo modo, se considerará como aceptación tácita
						de la citada el hecho que como usuario siga haciendo uso de la siguiente plataforma tecnológica
						digital de forma posterior a la notificación y publicación de la modificación o actualización de
						los términos de la presente política de privacidad y otras políticas. Dado lo anterior,
						posterior a su publicación en la referida plataforma, el usuario no podrá alegar desconocimiento
						ni dejar sin efecto un servicio contratado en atención a la modificación de las presentes
						políticas, siendo exclusivamente responsable de los incumplimientos que en razón de su
						desconocimiento incurra.
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
							<a href="">Términos y condiciones</a> | <a href="">Política de reembolso</a> |
							<a href="pages/politicas-privacidad">Política de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
