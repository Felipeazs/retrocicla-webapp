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
					<i class="bi bi-bag"></i>
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
									<i class="fa-solid fa-chevron-right"></i
									><a href="/politicas-pago" class="fs-6">Políticas medios de pago</a>
								</dd>
								<hr />
								<dd>
									<i class="fa-solid fa-chevron-right active"></i
									><a href="/politicas-despacho" class="fs-6">Políticas de despacho</a>
								</dd>
								<hr />
							</dl>
						</div>
					</div>
				</div>
				<div class="col-md-9 contenido">
					<h3 class="fw-bold">Políticas de Despacho</h3>
					<p class="mb-3 mt-3 fw-bold">I. De los medios de despacho.</p>
					<p>
						Habiendo cumplido el usuario con notificar su domicilio postal, y a fin de cumplir con la parte
						final de nuestra obligación, RetroCicla podrá emplear uno o más de los siguientes servicios de
						envíos, cuyos costos serán publicados y actualizados en la plataforma tecnológica digital y
						estarán contenidos en los servicios ofrecidos o bien serán con cargo del usuario según se haya
						estipulado en el contrato que con la empresa se haya celebrado:
					</p>
					<ul class="ms-4">
						<li><p>Starken.</p></li>
						<li><p>Chilexpress.</p></li>
						<li><p>Correos de Chile.</p></li>
						<li>
							<p>Pymes de despacho en regiones.</p>
						</li>
					</ul>
					<p>
						RetroCicla les asegura que tanto el pago efectuado como los datos del usuario estarán protegidos
						mediante el uso de certificados SSL, asunto que fuera tratado en el punto V. de la Política de
						privacidad.
					</p>
					<p class="mb-3 mt-3">A. Caso especial de los contratos de tracto sucesivo.</p>
					<p>
						En el caso de los contratos que celebre la RetroCicla con una empresa o persona natural,
						mediante los cuales se pacten el uso de servicios periódicos, reiterativos, mes a mes o
						cualquiera otra acepción que indique que las obligaciones se generarán en diversas oportunidades
						tanto para la empresa como para el usuario, tales como las suscripciones especiales,
						aprovisionamientos mensuales u otros servicios que se deban repetir posteriormente, el usuario
						deberá optar por asociar la tarjeta de crédito que vaya a soportar el pago los días en que este
						se devengue.
					</p>
					<p class="mb-3 mt-3 fw-bold">II. De los plazos de entrega</p>
					<p>
						Considerando que, mientras persista la actual emergencia sanitaria producida por la pandemia de
						Covid19, los plazos podrán variar sutilmente, como RetroCicla informamos a nuestros usuarios que
						una vez celebrado el contrato y despachada la orden de envío al medio más idóneo a su ubicación
						o al sitio designado en el acuerdo, usted como usuario debería recibir su producto como máximo
						dentro de la tercera semana desde que se celebró el contrato, desde que se devengó el pago en su
						tarjeta de crédito, o bien desde la fecha que hayan acordado las partes en el contrato. Sin
						perjuicio de lo anterior y en la medida que las políticas de despacho de los medios empleados
						así lo permitan, RetroCicla contratará el servicio con seguimiento del envío, enviando el código
						de seguimiento al usuario una vez este haya sido proveído por la empresa de despacho.
					</p>
					<p class="mb-3 mt-3 fw-bold">III. De los seguros en el envío.</p>
					<p>
						Si el servicio contratado fuera de un valor importante o que la calidad y cantidad de los
						productos ofrecidos por la empresa así lo exigieran, RetroCicla podrá contratar un servicio de
						seguro que velen por la carga enviada. Sin perjuicio de lo anterior, si el usuario así lo estima
						conveniente, podrá aquel con cargo personal contratar un seguro que recaiga sobre la carga
						objeto del servicio ofrecido.
					</p>
					<p class="mb-3 mt-3 fw-bold">IV. De la responsabilidad en el envío.</p>
					<p>
						No obstante se deben respetar y cumplir los derechos y obligaciones que emanan directamente del
						contrato celebrado tanto respecto de la empresa como respecto del usuario, es menester
						considerar las siguientes situaciones
					</p>
					<ul class="ms-4">
						<li>
							<p>
								Contrato de ejecución instantánea: visto y escogido el servicio deseado en nuestra
								plataforma tecnológica digital, dentro de los tres días hábiles siguientes a haberse
								celebrado el contrato, le enviaremos un correo electrónico a la dirección virtual
								señalada en sus datos personales, informando los datos relativos al servicio contratado
								tales como el medio empleado para despachar el producto adquirido, el código de
								seguimiento en caso de tenerlo, entre otros.
							</p>
						</li>
						<li>
							<p>
								Servicio contratado durante un evento digital: si usted como usuario se beneficia de
								contratar nuestros servicios a un valor inferior debido a un evento digital como lo es
								el Cyberday o similares, deberá tener en cuenta que se respetará el proceso anterior
								salvo en lo que respecta al plazo de confirmación del servicio contratado, pasando de
								ser tres días hábiles desde la celebración del contrato a ocho días hábiles contados
								desde la celebración del mismo, lo anterior en consideración al aumento de la demanda y
								de los servicios contratados durante el periodo que comprenda el evento digital.
								Adicionalmente deberá tener presente que en atención a lo anterior, RetroCicla podrá
								enviarle un correo a su casilla electrónica informando una alteración en la fecha de
								envío dado los inconvenientes de la empresa de despacho a la cual se le había
								encomendado el envío del producto adquirido con la contratación del servicio producto de
								las eventuales cuarentenas decretadas u otras modificaciones producto del actuar público
								ante la presente situación de pandemia.
							</p>
						</li>
						<li>
							<p>
								En caso de tener dudas respecto a la aplicabilidad de los puntos anteriores a su
								situación personal, como empresa le sugerimos cordialmente que se ponga en contacto con
								nosotros mediante cualquiera de los medios señalados en el punto I. de las Políticas de
								contacto.
							</p>
						</li>
					</ul>
					<p>
						Finalmente, es necesario señalar que es de exclusiva responsabilidad de los usuarios señalar y
						actualizar su dirección postal dado que será esta la dirección que se considerará como válida al
						momento de encargar a la empresa de transporte envíe el producto objeto de nuestros servicios
						ofrecidos a sus hogares, en tal sentido RetroCicla no se hará responsable en el evento que
						ocurra una o más de las siguientes situaciones, debiendo ser el usuario quien pague por el
						reenvío del objeto materia del servicio ofrecido:
					</p>
					<ul class="ms-4">
						<li>
							<p>Ausencia del cliente al momento de la entrega.</p>
						</li>
						<li>
							<p>Dirección postal incorrecta.</p>
						</li>
						<li>
							<p>
								Negativa del usuario, familiar o conocido de aquel de aceptar el envío una vez que este
								haya llegado a su hogar.
							</p>
						</li>
						<li>
							<p>
								Cambio de domicilio que no haya sido notificado vía actualización de datos personales a
								la empresa.
							</p>
						</li>
					</ul>
					<p class="mb-3 mt-3 fw-bold">V. De los reembolsos.</p>
					<p>
						De forma similar a lo expresado en el punto II. de las Políticas de medios de pago, el usuario
						conservará siempre la facultad para dejar sin efecto el contrato celebrado, en la medida que
						cumpla ciertos requisitos.
					</p>
					<p class="mb-3 mt-3">A. Caso de los contratos de ejecución instantánea:</p>
					<p>
						En el caso en comento, para dejar sin efecto el contrato tanto el usuario como la empresa no
						deberán haber cumplido o haber dado principio al cumplimiento de su respectiva obligación
						contractual:
					</p>
					<ul class="ms-4">
						<li>
							<p>
								Si el usuario ha pagado el valor del servicio y RetroCicla no lo ha prestado al tiempo
								de la comunicación del cese de servicio, la empresa tendrá la obligación de enterar el
								total del valor pagado a la cuenta que haya designado el usuario.
							</p>
						</li>
						<li>
							<p>
								Si el usuario nada ha pagado y la empresa no ha dado comienzo a la ejecución del
								contrato, entonces aquel se dejará sin efecto de pleno derecho, extinguiendo las
								obligaciones y responsabilidades para ambas partes.
							</p>
						</li>
						<li>
							<p>
								Si RetroCicla ha principiado la ejecución de lo convenido y el usuario manifiesta su
								intención de cesar el acuerdo, este último sólo podrá recuperar hasta entre un 80% y un
								50% de lo pagado según sea el estado del servicio prestado.
							</p>
						</li>
						<li>
							<p>
								Si el servicio ofrecido por la empresa está pronto a concluir, el usuario no podrá dejar
								sin efecto el presente contrato.
							</p>
						</li>
					</ul>
					<p class="mb-3 mt-3">B. Caso de los contratos de tracto sucesivo:</p>
					<p>
						Dado que en estos contratos su obligación como usuario se devenga y paga automáticamente en el
						plazo acordado por las partes, entonces:
					</p>
					<ul class="ms-4">
						<li>
							<p>
								Si se ha materializado el pago del mes correspondiente, no se ha solicitado servicios
								concretos a la empresa, y usted como usuario ha manifestado su intención de no persistir
								conforme a lo señalado en el punto relativo a la Facultad de retracto, entonces el
								contrato será dejado convencionalmente sin efecto, sin perjuicio que se sigan las reglas
								de reembolso señalados en el punto a. de estas políticas de acuerdo al estado de los
								servicios prestados.
							</p>
						</li>
						<li>
							<p>
								Si ha manifestado su deseo de no perseverar en el contrato con RetroCicla pero ha
								enviado el correo fuera de plazo, o bien ha solicitado nuevos servicios a la empresa
								dentro del plazo posterior tras haberse devengado el pago, el contrato subsistirá y
								producirá todos sus efectos, no dando lugar al reembolso y obligando al usuario a pagar
								los servicios adeudados.
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
							<a href="pages/politicas-privacidad">Política de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>>
