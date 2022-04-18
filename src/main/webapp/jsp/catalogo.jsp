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
		<section class="container-fluid seccion-materiales bg-light">
			<div class="row">
				<!--Buscador Avanzado-->
				<div class="col-md-3 sub-columna-1">
					<h3 class="fw-bold">Teinda Retrocicla</h3>
					<hr />
					<button
						class="btn btn-primary"
						type="button"
						data-bs-toggle="collapse"
						data-bs-target=".multi-collapse"
						aria-expanded="false"
						aria-controls="tipo prenda genero talla color material patron origen "
					>
						Búsqueda avanzada
					</button>
					<dl>
						<dd>
							<p>
								<a
									class="btn btn-transparent fs-6"
									data-bs-toggle="collapse"
									href="#tipo"
									role="button"
									aria-expanded="false"
									aria-controls="tipo"
								>
									<i class="fa-solid fa-chevron-right"></i>
									Tipo
								</a>
							</p>
							<div class="collapse multi-collapse" id="tipo">
								<div class="card card-body">
									<label for="_prenda"
										><input type="radio" value="prenda" id="_prenda" name="_tipo" /> Prenda
									</label>
									<label for="_material"
										><input type="radio" value="material" id="_material" name="_tipo" />
										Material
									</label>
								</div>
							</div>
						</dd>
						<dd>
							<p>
								<a
									class="btn btn-transparent fs-6"
									data-bs-toggle="collapse"
									href="#prenda"
									role="button"
									aria-expanded="false"
									aria-controls="prenda"
								>
									<i class="fa-solid fa-chevron-right"></i>
									Prenda
								</a>
							</p>
							<div class="collapse multi-collapse" id="prenda">
								<div class="card card-body">
									<label for="_pantalon"
										><input type="radio" value="pantalón" id="_pantalon" name="_prenda" />
										Pantalón
									</label>
									<label for="_polera"
										><input type="radio" value="polera" id="_polera" name="_prenda" />
										Polera
									</label>
									<label for="_camisa"
										><input type="radio" value="camisa" id="_camisa" name="_prenda" />
										Camisa
									</label>
									<label for="_chaleco"
										><input type="radio" value="chaleco" id="_chaleco" name="_prenda" />
										Chaleco
									</label>
									<label for="_blusa"
										><input type="radio" value="blusa" id="_blusa" name="_prenda" />
										Blusa
									</label>
									<label for="_falda"
										><input type="radio" value="falda" id="_falda" name="_prenda" />
										Falda
									</label>
								</div>
							</div>
						</dd>

						<dd>
							<p>
								<a
									class="btn btn-transparent fs-6"
									data-bs-toggle="collapse"
									href="#genero"
									role="button"
									aria-expanded="false"
									aria-controls="genero"
								>
									<i class="fa-solid fa-chevron-right"></i>
									Género
								</a>
							</p>
							<div class="collapse multi-collapse" id="genero">
								<div class="card card-body">
									<label for="_femenino"
										><input type="radio" value="femenino" id="_femenino" name="_genero" />
										Femenino</label
									>
									<label for="_masculino"
										><input type="radio" value="masculino" id="_masculino" name="_genero" />
										Masculino</label
									>
									<!-- <label for="_unisex"
										><input type="radio" value="unisex" id="_unisex" name="_genero" /> Unisex</label
									> -->
								</div>
							</div>
						</dd>
						<dd>
							<p>
								<a
									class="btn btn-transparent fs-6"
									data-bs-toggle="collapse"
									href="#talla"
									role="button"
									aria-expanded="false"
									aria-controls="talla"
								>
									<i class="fa-solid fa-chevron-right"></i>
									Talla
								</a>
							</p>
							<div class="collapse multi-collapse" id="talla">
								<div class="card card-body">
									<label for="_s"><input type="radio" value="s" id="_s" name="_talla" /> s </label>
									<label for="_m"><input type="radio" value="m" id="_m" name="_talla" /> m </label>
									<label for="_l"><input type="radio" value="l" id="_m" name="_talla" /> l </label>
									<label for="_12"
										><input type="radio" value="12" id="_12" name="_talla" /> 12
									</label>
									<label for="_16"
										><input type="radio" value="16" id="_16" name="_talla" /> 16
									</label>
									<label for="_38"
										><input type="radio" value="38" id="_38" name="_talla" /> 38
									</label>
									<label for="_40"
										><input type="radio" value="40" id="_40" name="_talla" /> 40
									</label>
									<label for="_42"
										><input type="radio" value="42" id="_342" name="_talla" /> 42
									</label>
									<label for="_48"
										><input type="radio" value="48" id="_48" name="_talla" /> 48
									</label>
									<label for="_52"
										><input type="radio" value="52" id="_52" name="_talla" /> 52
									</label>
								</div>
							</div>
						</dd>
						<dd>
							<p>
								<a
									class="btn btn-transparent fs-6"
									data-bs-toggle="collapse"
									href="#color"
									role="button"
									aria-expanded="false"
									aria-controls="color"
								>
									<i class="fa-solid fa-chevron-right"></i>
									Color
								</a>
							</p>
							<div class="collapse multi-collapse" id="color">
								<div class="card card-body">
									<label for="_multicolor"
										><input type="radio" value="multicolor" id="_multicolor" name="_color" />
										Multicolor</label
									>
									<label for="_negro"
										><input type="radio" value="negro" id="_negro" name="_color" /> Negro</label
									>
									<label for="_blanco"
										><input type="radio" value="blanco" id="_blanco" name="_color" /> Blanco</label
									>
									<label for="_azul"
										><input type="radio" value="azul" id="_azul" name="_color" /> Azul</label
									>
									<label for="_rosado"
										><input type="radio" value="rosado" id="_rosado" name="_color" /> Rosado</label
									>
									<label for="_burdeo"
										><input type="radio" value="burdeo" id="_burdeo" name="_color" /> Burdeo</label
									>
									<label for="_calipso"
										><input type="radio" value="calipso" id="_calipso" name="_color" />
										Calipso</label
									>
									<label for="_plateado"
										><input type="radio" value="plateado" id="_plateado" name="_color" />
										Plateado</label
									>

									<!-- <label for="_cafe"
										><input type="radio" value="café" id="_cafe" name="_color" /> Café</label
									> -->
								</div>
							</div>
						</dd>
						<dd>
							<p>
								<a
									class="btn btn-transparent fs-6"
									data-bs-toggle="collapse"
									href="#material"
									role="button"
									aria-expanded="false"
									aria-controls="material"
								>
									<i class="fa-solid fa-chevron-right"></i>
									Material
								</a>
							</p>
							<div class="collapse multi-collapse" id="material">
								<div class="card card-body">
									<label for="_algodón"
										><input type="radio" value="algodón" id="_algodón" name="_material" />
										Algodón</label
									>
									<label for="_poliester"
										><input type="radio" value="poliester" id="_poliester" name="_material" />
										Poliester</label
									>
									<label for="_spandex"
										><input type="radio" value="spandex" id="_spandex" name="_material" />
										Spandex</label
									>
								</div>
							</div>
						</dd>
						<dd>
							<p>
								<a
									class="btn btn-transparent fs-6"
									data-bs-toggle="collapse"
									href="#patron"
									role="button"
									aria-expanded="false"
									aria-controls="patron"
								>
									<i class="fa-solid fa-chevron-right"></i>
									Patrón
								</a>
							</p>
							<div class="collapse multi-collapse" id="patron">
								<div class="card card-body">
									<label for="_patron"
										><input type="radio" value="patrón" id="_patron" name="_patron" /> Patrón
									</label>
									<label for="_liso"
										><input type="radio" value="liso" id="_liso" name="_patron" /> Liso
									</label>
								</div>
							</div>
						</dd>
						<dd>
							<p>
								<a
									class="btn btn-transparent fs-6"
									data-bs-toggle="collapse"
									href="#origen"
									role="button"
									aria-expanded="false"
									aria-controls="origen"
								>
									<i class="fa-solid fa-chevron-right"></i>
									Origen
								</a>
							</p>
							<div class="collapse multi-collapse" id="origen">
								<div class="card card-body">
									<label for="_china"
										><input type="radio" value="china" id="_china" name="_origen" /> China
									</label>
									<label for="_chile"
										><input type="radio" value="chile" id="_chile" name="_origen" /> Chile
									</label>
								</div>
							</div>
						</dd>
					</dl>
					<hr />
					<!-- <a href="" class="text-decoration-underline">Accesorios </a>
					<hr />
					<a href="" class="text-decoration-underline">Servicios</a>
					<hr /> -->
					<button class="btn btn-outline-primary text-align-center" onclick="buscarProductos()">
						Buscar
					</button>
					<hr />
				</div>

				<!--Catálogo -->

				<div class="col">
					<div class="sub-columna-2">
						<h3 class="fw-bold">${ titulo }</h3>
					</div>
					<hr />
					<c:choose>
						<c:when test="${ not empty productos }">
							<div id="productos_encontrados" class="row">
								<c:forEach items="${ productos }" var="p">
									<div class="col-sm-12 col-md-6 col-lg-6 col-xl-4 galeria-materiales">
										<a href="/item/${ p.productoId }">
											<div class="galeria-cell">
												<img
													id="p_imageUrl"
													class="img-responsive"
													src="${ p.imageUrl }"
													alt=""
												/>
												<i class="fa-solid fa-bag-shopping fa-2x"></i>
											</div>
										</a>
										<div class="row">
											<div class="col-sm-12 col-md-12 ps-4 item">
												<div><span>${ p.descripcion }</span></div>
												<div>
													<span class="fs-6">Material: </span><span>${ p.material }</span>
												</div>
												<div>
													<span class="fs-5">Talla: </span>
													<span class="fs-5">${ p.talla }</span>
												</div>
												<div>
													<strong class="fs-3">${ p.formato_precio }</strong>
												</div>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</c:when>
						<c:otherwise>
							<p>No se encontró ningún artículo</p>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</section>
		<section class="container-fluid seccion-bajada-tienda">
			<div class="row">
				<div class="col-sm-12 col-md-6">
					<div class="row align-items-center">
						<div class="col-md-3"><img src="../img/clip.png" alt="clip" /></div>
						<div class="col-md-9 text-white ps-5 pe-5 text-center">
							<p>No encuentras lo que necesitas? Contáctanos!!</p>
						</div>
					</div>
				</div>
				<div class="col-sm-12 col-md-6">
					<div class="row">
						<div class="col-sm-12 col-md-9">
							<div class="row">
								<div class="col-sm-12"><input type="text" placeholder="Nombre" /></div>
								<div class="col-sm-12"><input type="email" placeholder="Correo electrónico" /></div>
								<div class="col-sm-12">
									<textarea rows="4" cols="20" placeholder="Escribe aquí..."></textarea>
								</div>
								<div class="col-sm-12 text-center">
									<button><i class="fa-solid fa-chevron-right"></i></button>
								</div>
							</div>
						</div>
						<div class="col-sm-12 col-md-3">
							<img src="../img/retrocicla-round.png" alt="retrocicla-round" />
						</div>
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
