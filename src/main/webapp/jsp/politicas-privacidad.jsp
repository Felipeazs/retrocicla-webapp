<!DOCTYPE html>
<html lang="es">
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
						<h3 class="fw-bold">Pol�ticas Retrocicla</h3>
						<div class="container">
							<dl>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right active"></i
									><a href="/politicas-privacidad" class="fs-6">Pol�ticas de privacidad</a>
								</dd>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right"></i
									><a href="/politicas-contacto" class="fs-6">Pol�ticas de contacto</a>
								</dd>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right"></i
									><a href="/politicas-pago" class="fs-6">Pol�ticas medios de pago</a>
								</dd>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right"></i
									><a href="/politicas-despacho" class="fs-6">Pol�ticas de despacho</a>
								</dd>
								<hr />
							</dl>
						</div>				
				</div>
				<div class="col-md-9 contenido">
					<h3 class="fw-bold">Pol�ticas de Privacidad</h3>
					<p class="mb-3 mt-3 fw-bold">I. De la identificaci�n personal.</p>
					<p>
						RetroCicla podr� recopilar informaci�n relativa a la identificaci�n personal de los usuarios
						empleando para ello una variedad de mecanismos, se�alando a modo de ejemplo los siguientes:
					</p>
					<ul class="ms-4">
						<li><p>Cuando los usuarios visiten nuestra plataforma tecnol�gica digital;</p></li>
						<li><p>Cuando los usuarios hagan una solicitud o pedido en la citada plataforma;</p></li>
						<li><p>Cuando los usuarios completen alguno de nuestros formularios;</p></li>
						<li>
							<p>
								Cuando los usuarios hagan uso de las actividades, servicios, funciones o recursos que, como
								empresa, pongamos a su disposici�n en nuestra plataforma tecnol�gica digital.
							</p>
						</li>
					</ul>
					<p class="mb-3">
						Dentro de la informaci�n personal recabada, esta contemplar� los datos relativos al nombre del
						usuario, el correo electr�nico asociado para estar en contacto, el n�mero de tel�fono para similares
						fines, la direcci�n postal a la cual deba enviarse el producto o servicio adquirido y la informaci�n
						de la tarjeta de cr�dito que vaya a ser asociada para efectuar los pagos asociados a la contrataci�n
						del servicio. Esta �ltima ser� solicitada en la medida que el usuario manifieste inequ�vocamente su
						intenci�n de materializar la adquisici�n del servicio que como empresa ofrecemos. Es menester hacer
						presente que en caso contrario, la informaci�n antes se�alada s�lo se remitir� al conteo de visitas
						efectuadas a la plataforma, o bien se reducir� a la informaci�n solicitada mediante formulario
						adjunto en la citada plataforma web.
					</p>
					<p class="mb-3 fw-bold">II. De la identificaci�n no personal.</p>
					<p>
						RetroCicla podr� recopilar informaci�n relativa a la identificaci�n no personal de los usuarios
						cuando aquellos interact�en con nuestro sitio web.
					</p>
					<p>
						La citada informaci�n podr� incluir el nombre del navegador por el cual se efectu� la interacci�n,
						el tipo de equipo empleado para ello y la informaci�n t�cnica del citado como lo es el sistema
						operativo del equipo, su proveedor de servicio de internet o informaci�n similar que permita adaptar
						nuestra plataforma tecnol�gica digital para brindar un mejor servicio a los usuarios.
					</p>
					<p class="mb-3 mt-3 fw-bold">III. De las cookies del navegador web.</p>
					<p>
						Nuestra plataforma tecnol�gica digital podr� hacer uso del sistema de cookies para mejorar las
						experiencias de los usuarios. A mayor abundamiento, el navegador web del usuario sit�a cookies
						seguras en su disco duro, las cuales son usadas para fines de registro y para rastrear informaci�n
						relativa a la interacci�n de alg�n sitio web. Debe hacerse presente que el usuario siempre tendr� la
						facultad para configurar su navegador web con la finalidad de rechazar las citadas o bien, para
						dicho sistema notifique las situaciones en que aquel estar� enviando las ya se�aladas cookies. No
						obstante lo anterior, como empresa debemos advertir que de seguir estas modalidades, el usuario
						deber� tener presente que algunas partes de este sitio web podr�an dejar de funcionar correctamente.
						En este caso, es responsabilidad personal del usuario habilitar o configurar el sistema de cookies
						que le permitan hacer uso plenamente de la plataforma tecnol�gica digital prove�da por nuestra
						empresa.
					</p>
					<p class="mb-3 mt-3 fw-bold">IV. Del uso de los datos recopilados.</p>
					<p>
						RetroCicla podr� recopilar y utilizar la informaci�n personal conferida de los usuarios en los
						puntos anteriores en los siguientes casos:
					</p>
					<ul class="ms-4">
						<li>
							<p>
								Para mejorar el servicio al cliente: La informaci�n conferida facultar� a que la empresa
								pueda responder a sus solicitudes de servicio al cliente de forma eficaz, del mismo modo que
								nos permitir� como empresa mejorar las necesidades de soporte en la medida que ello sea
								necesario.
							</p>
						</li>
						<li>
							<p>
								Para mejorar la plataforma tecnol�gica digital: RetroCicla usar� los datos proporcionados
								por los usuarios en a fin de hacer una retroalimentaci�n eficiente que permita estar alerta
								ante cualquier defecto por nimio que sea y evitar complicaciones en los servicios ofrecidos.
							</p>
						</li>
						<li>
							<p>
								Para mejorar el cumplimiento de los servicios ofrecidos: La empresa utilizar� la informaci�n
								personal conferida por los usuarios solamente cuando se materialice la adquisici�n del
								servicio. A fin de explicar el particular, s�lo se compartir� la informaci�n con terceros en
								la medida que esto sea necesario para materializar la ejecuci�n del contrato como lo es, por
								ejemplo, el conferir la direcci�n postal del usuario a la empresa de despacho contratada
								para hacer la entrega del producto. Para generar actividades en beneficio de los usuarios:
								RetroCicla har� uso de su informaci�n para notificarle de promociones, concursos, o
								encuestas de satisfacci�n de los servicios ofrecidos, as� como eventualmente referir sitios
								ad-hoc a las preferencias de los usuarios.
							</p>
						</li>
						<li>
							<p>
								Para crear y personalizar el Newsletter enviado a los usuarios: Para ello la empresa podr�
								utilizar la direcci�n de correo electr�nico prove�da previamente por los usuarios con la
								finalidad de enviarles informaciones relativas a la empresa tales como la actualizaci�n de
								la pol�tica de privacidad y otras pol�ticas, actualizaciones de los servicios ofrecidos y o
								el estado en que se encuentran, responder consultas efectuadas. Sin embargo y atendida la
								naturaleza de los Newsletter, ser� menester que el usuario de forma clara e inequ�voca
								manifieste su intenci�n de recibir este tipo de correo, sin perjuicio que en actos
								posteriores decida unilateralmente poner t�rmino a este servicio, el cual tendr� que ser
								informado mediante formulario o bot�n especialmente dispuesto en el mismo Newsletter
								enviado. Se hace presente que de manifestar el inter�s de no recibir estos correos, el
								usuario no podr� retractarse de su decisi�n salvo transcurridos 3 meses desde que haya
								manifestado la intenci�n de no recibir los Newsletter.
							</p>
						</li>
					</ul>
					<p class="mb-3 mt-3 fw-bold">V. De la protecci�n de la informaci�n aportada.</p>
					<p>
						RetroCicla adoptar� diversas pr�cticas de recopilaci�n, almacenamiento y procesamiento de datos, por
						lo anterior, se tomar�n las medidas de seguridad necesarias para proteger su informaci�n personal de
						accesos no autorizados, alteraci�n, divulgaci�n o destrucci�n de sus datos tales como nombre de
						usuario, contrase�a, informaci�n de transacciones y otros datos almacenados en nuestro sitio web.
						Para asegurar lo anterior, el intercambio de los datos citados se llevar� a cabo por medio de un
						canal digital protegido con el sistema de Secure Socket Layer (o SSL) que cifrar� y proteger�
						mediante firmas digitales la informaci�n objeto del intercambio.
					</p>
					<p class="mb-3 mt-3 fw-bold">VI. De la difusi�n de la informaci�n aportada.</p>
					<p>
						RetroCicla no vender�, comercializar� ni alquilar� la informaci�n que sus usuarios le hayan
						conferido. A lo sumo, la empresa podr� compartir informaci�n no vinculada a la identificaci�n
						personal de los usuarios, como lo es la informaci�n demogr�fica, con los socios comerciales,
						afiliados comerciales y anunciantes de RetroCicla a fin que estos �ltimos generen las propuestas o
						informaciones m�s personificadas que mejoren los servicios ofrecidos Kallv� podr�, pero solo en el
						evento de haber sido autorizados por ustedes, compartir su informaci�n personal con Proveedores de
						servicios que ayuden a operar nuestro negocio y sitio web; o administrar actividades a nuestro
						nombre, como el env�o de Newsletter, Encuestas o similares.
					</p>
					<p class="mb-3 mt-3 fw-bold">VII. De los cambios a la pol�tica de privacidad.</p>
					<p>
						La empresa posee la facultad de modificar y actualizar la presente pol�tica de privacidad en todo
						momento; sin embargo, de hacerse efectivo, dicha modificaci�n o actualizaci�n ser� debidamente
						notificada v�a Newsletter a los usuarios registrados y publicado durante a lo menos una semana h�bil
						en la plataforma tecnol�gica digital de RetroCicla. En atenci�n a lo anterior, como empresa
						expresamos que es responsabilidad de los usuarios el revisar peri�dicamente sus Newsletter o en su
						defecto la plataforma digital de la empresa a fin de tomar conocimiento de los cambios que se
						efect�en en la presente pol�tica de privacidad y otras pol�ticas puesto que en actos posteriores no
						podr� alegar el desconocimiento de las modificaciones o actualizaciones a las mismas a fin de hacer
						valer un cumplimiento imperfecto de la obligaci�n de las partes contratantes o lisa y llanamente un
						incumplimiento de la misma. VIII. De la aceptaci�n de la pol�tica de privacidad. Como empresa
						hacemos presente que por el mero hecho de usar la presente plataforma tecnol�gica digital, usted
						como usuario expresa de facto su aceptaci�n a la presente pol�tica de privacidad y otras pol�ticas.
						Del mismo modo, se considerar� como aceptaci�n t�cita de la citada el hecho que como usuario siga
						haciendo uso de la siguiente plataforma tecnol�gica digital de forma posterior a la notificaci�n y
						publicaci�n de la modificaci�n o actualizaci�n de los t�rminos de la presente pol�tica de privacidad
						y otras pol�ticas. Dado lo anterior, posterior a su publicaci�n en la referida plataforma, el
						usuario no podr� alegar desconocimiento ni dejar sin efecto un servicio contratado en atenci�n a la
						modificaci�n de las presentes pol�ticas, siendo exclusivamente responsable de los incumplimientos
						que en raz�n de su desconocimiento incurra.
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
							<a href="">T�rminos y condiciones</a> | <a href="">Pol�tica de reembolso</a> |
							<a href="pages/politicas-privacidad">Pol�tica de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
