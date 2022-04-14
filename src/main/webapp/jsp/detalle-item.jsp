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
		<link rel="stylesheet" href="../css/flickity.css" />
		<link rel="stylesheet" href="../css/style.css" />
		<script src="../js/script.js"></script>
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
				<div class="col-sm-12 col-md-2 d-flex align-items-center justify-content-end user">
					<a href="cliente"><i class="bi bi-person-circle"></i></a>
					<a href="carrito"><i class="bi bi-bag"></i></a>
				</div>
			</div>
		</nav>
		<section class="container-fluid seccion-materiales bg-light">
			<div class="row">
				<div class="col-md-3 sub-columna-1">
					<h3 class="fw-bold">Teinda Retrocicla</h3>
					<hr />

					<dl>
						<dt>Materiales</dt>
						<dd><i class="fa-solid fa-chevron-right active"></i><button>Fibras Naturales</button></dd>
						<dd><i class="fa-solid fa-chevron-right"></i><button>Fibras Sintéticas</button></dd>
						<dd><i class="fa-solid fa-chevron-right"></i><button>Fibras Artificiales</button></dd>
						<dd><i class="fa-solid fa-chevron-right"></i><button>Fibras Origen Animal</button></dd>
					</dl>

					<hr />
					<a href="">Accesorios </a>
					<hr />
					<a href="">Servicios</a>
					<hr />
				</div>
				<div class="col">
					<p>
						<a href="/catalogo/${ item.tipo }">${ item.tipo }</a> /
						<a href="/catalogo/${ item.prenda }_${ item.genero }">${ item.prenda } ${ item.genero }</a> /
						<a href="/catalogo/${ item.estilo }"> ${ item.estilo } </a> /
						<a href="/catalogo/${ item.fibra }">fibra ${ item.fibra }</a> /
						<a href="/catalogo/${ item.material }">${ item.material }</a>
					</p>
					<hr />
					<div class="row">
						<div class="col-md-6 sub-columna-2">
							<div>
								<img src="${ item.imageUrl }" alt="" />
							</div>
						</div>

						<div class="col-6-md-6 sub-columna-3">
							<div class="row">
								<div class="evaluacion d-flex">
									<div>
										<i class="fa-solid fa-star"></i>
									</div>
									<div>
										<i class="fa-solid fa-star"></i>
									</div>
									<div>
										<i class="fa-solid fa-star"></i>
									</div>
									<div>
										<i class="fa-solid fa-star-half-stroke"></i>
									</div>
									<div>
										<i class="fa-regular fa-star"></i>
									</div>
								</div>

								<div class="item fs-5 d-flex justify-content-between">
									<span class="text-start">Marca</span>
									<strong class="text-end" name="precio"> ${ item.formato_precio } </strong>
								</div>
								<div class="item d-flex justify-content-between">
									<span>Talla: ${ item.tamano } </span>
									<span>${ item.material }</span>
								</div>
								<div class="item d-flex justify-content-between m-2">
									<div class="sub-item d-flex justify-content-between">
										<button type="button" class="izq" onclick="restar_cantidad()">-</button>
										<input
											name="cantidad"
											type="number"
											value="1"
											id="cantidad_input"
											oninput="precio_total()"
										/>
										<button type="button" class="der" onclick="sumar_cantidad()">+</button>
									</div>
									<button class="carrito">Carrito</button>
								</div>
								<div class="item text-center m-1 boton">
									<button
										class="fs-6 p-3"
										type="button"
										data-bs-toggle="offcanvas"
										data-bs-target="#offcanvasRight"
										aria-controls="offcanvasRight"
									>
										Comprar ahora
									</button>
									<div
										class="offcanvas offcanvas-end"
										tabindex="-1"
										id="offcanvasRight"
										aria-labelledby="offcanvasRightLabel"
									>
										<div class="offcanvas-header">
											<h5 id="offcanvasRightLabel" class="fw-bold">Agregar al carrito...</h5>
											<button
												type="button"
												class="btn-close text-reset"
												data-bs-dismiss="offcanvas"
												aria-label="Close"
											></button>
										</div>
										<div class="offcanvas-body">
											<div class="container">
												<div class="row">
													<div class="col m-0 p-0">
														<img
															name="iamgeUrl"
															src="${ item.imageUrl }"
															alt=""
															class="float-start"
														/>
													</div>
													<div class="container col m-2 p-0">
														<p class="fs-6 text-start p-0 m-0">Marca</p>
														<p class="fs-6 text-start p-0 m-0">
															Precio: ${ item.formato_precio }
														</p>
														<p class="fs-6 text-start p-0 m-0">Talla: ${ item.tamano }</p>
														<p class="fs-6 text-start p-0 m-0">
															Material: Fibra ${ item.fibra }
														</p>
														<p class="fs-6 text-start p-0 mt-3">
															Cantidad: <span id="cantidad_carrito">1</span>
														</p>
														<input type="hidden" value="${ item.precio }" id="_precio" />
														<p class="fs-6 text-start p-0 mt-3">
															total: <span name="precio"></span>
														</p>
													</div>
												</div>
											</div>
											<div class="row ms-5 pt-2 align-center">
												<div class="col-3">
													<a href="carrito">
														<button class="carrito border border-2 mt-2">
															<i
																class="fa-solid fa-cart-shopping pt-1"
																style="color: #2f355b"
															></i>
														</button>
													</a>
												</div>
												<div class="col-5">
													<form action="/informacion-usuario" method="get">
														<input
															name="productoId"
															type="hidden"
															value="${ item.productoId }"
														/>
														<input name="total" type="hidden" id="total" value="" />
														<input
															name="cantidad"
															type="hidden"
															value="1"
															id="cantidad_input"
														/>
														<input
															name="imageUrl"
															type="hidden"
															value="${ item.imageUrl }"
														/>
														<input
															name="material"
															type="hidden"
															value="${ item.material }"
														/>
														<input
															name="descripcion"
															type="hidden"
															value="${ item. descripcion }"
														/>
														<button
															class="carrito border border-2 mt-2"
															style="background-color: #00ff99"
														>
															Finalizar
														</button>
													</form>
												</div>
											</div>
										</div>
									</div>
								</div>
								<hr />
								<p class="fs-6 text-start">Descripción</p>
								<span name="descripcion" class="fw-bold">${ item.descripcion }</span>
								<hr />
								<p class="fs-6 text-start">Testimonios</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section class="galeria-detalle pt-5 pb-2">
			<p class="text-center fs-4 fw-bold">Materiales / Fibras Naturales</p>
			<div class="galeria js-flickity m-5">
				<div class="galeria-cell">
					<img class="img-responsive" src="../img/algodon-2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
				</div>
				<div class="galeria-cell">
					<img src="../img/seda-1.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
				</div>
				<div class="galeria-cell">
					<img src="../img/tejidos.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
				</div>
				<div class="galeria-cell">
					<img src="../img/jacketDenim2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
				</div>
				<div class="galeria-cell">
					<img src="../img/lino.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
				</div>
				<div class="galeria-cell">
					<img src="../img/Poliester.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
				</div>
				<div class="galeria-cell">
					<img src="../img/lana-2.jpg" alt="" />
					<i class="fa-solid fa-bag-shopping fa-2x"></i>
				</div>
			</div>
		</section>
		<section class="galeria-detalle testimonio pt-1 pb-5">
			<p class="text-center fs-4 fw-bold">Testimonios</p>
			<div class="galeria js-flickity m-5">
				<div class="galeria-cell">
					<div class="item">
						<div class="text-center p-5 text-break">
							blablabalbalbalblalblfdlgksjdfgsdfgkljshdflkjgshdfkjgjsdfg
							asdasdfasdjfhgasdjkhfgalskjdfhlasdjhlfkjahsldkfjhasdklj
						</div>
					</div>
				</div>
				<div class="galeria-cell">
					<div class="item">
						<div class="text-center p-5 text-break">
							blablabalbalbalblalblfdlgksjdfgsdfgkljshdflkjgshdfkjgjsdfg
							asdasdfasdjfhgasdjkhfgalskjdfhlasdjhlfkjahsldkfjhasdklj
						</div>
					</div>
				</div>
				<div class="galeria-cell">
					<div class="item"></div>
				</div>
				<div class="galeria-cell">
					<div class="item"></div>
				</div>
				<div class="galeria-cell">
					<div class="item"></div>
				</div>
				<div class="galeria-cell">
					<div class="item"></div>
				</div>
				<div class="galeria-cell">
					<div class="item"></div>
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
							<a href="/politicas-privacidad">Política de privacidad</a>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>
</html>
