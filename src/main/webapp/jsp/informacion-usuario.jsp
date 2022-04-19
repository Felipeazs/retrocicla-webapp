<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %><%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

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

		<!--Input información usuario-->

		<div class="container-flex seccion-informacion bg-light pb-5">
			<div class="seccion-informacion">
				<div class="row primera">
					<div class="col-md-2 text-center">
						<img src="img/logo-carrito.png" alt="" style="width: 50%" />
					</div>
					<div class="col d-flex align-items-center">
						<span>Carrito</span>
						|<span style="color: #00ff99">Información</span> |<span>Envíos</span> |<span>Pagos</span>
					</div>
				</div>
			</div>
			<c:choose>
				<c:when test="${ tamano_carrito != '0' }">
					<form method="GET" action="/informacion-envio">
						<div class="row">
							<div class="col-md-7">
								<section class="">
									<p class="fs-4 fw-bold">Información de contacto</p>
									<div class="row pb-2">
										<div class="col-6 formulario">
											<label for="">Nombre</label>
											<input
												path="nombre"
												name="nombre"
												value="${ cliente.nombre }"
												type="text"
												class="input form-control form-control-sm"
											/>
										</div>
										<div class="col-6 formulario">
											<label for="">Apellido</label>
											<input
												path="apellido"
												name="apellido"
												value="${ cliente.apellido }"
												type="text"
												class="input form-control form-control-sm"
											/>
										</div>
									</div>
									<div class="row pb-2">
										<div class="col-6 formulario">
											<label for="">Rut*</label>
											<input
												path="rut"
												name="rut"
												value="${ cliente.rut }"
												type="text"
												class="input form-control form-control-sm"
											/>
										</div>
										<div class="col-6 formulario">
											<label for="">Teléfono*</label>
											<input
												path="telefono"
												name="telefono"
												value="${ cliente.telefono }"
												type="text"
												class="input form-control form-control-sm"
											/>
										</div>
									</div>
									<div class="row pb-2">
										<div class="col-12 formulario">
											<label for="">Correo electrónico*</label>
											<input
												path="email"
												name="email"
												value="${ cliente.email }"
												type="email"
												class="input form-control form-control-sm"
											/>
										</div>
									</div>
									<input type="checkbox" class="me-2" /><span class="fw-bold"
										>Enviarme novedades y ofertas por correo electrónico</span
									>
									<p class="fs-4 fw-bold mt-3">Dirección de envío</p>
									<div class="row pb-2">
										<label for="" class="fw-bold">Mis direcciones guardadas</label>
										<div class="col-md-4 formulario">
											<select
												class="input form-select"
												onchange="direccionCliente('${ cliente.clienteId }')"
												id="_direcciones"
											>
												<c:forEach items="${ cliente.direcciones }" var="d">
													<option value="${ d.tipo }">${ d.tipo }</option>
												</c:forEach>
											</select>
										</div>
										<div class="col fw-bold d-flex align-items-end formulario">
											<a href="">Editar o agregar direccion</a>
										</div>
									</div>
									<div class="row pb-2">
										<div class="col-6 formulario">
											<label for="">País</label>
											<input
												name="pais"
												type="text"
												value="Chile"
												class="input form-control form-control-sm"
											/>
										</div>
										<div class="col-6 formulario">
											<label for="">Región</label>
											<input
												name="region"
												type="text"
												class="input form-control form-control-sm"
												value="${ cliente.direcciones[0].region }"
												id="_region"
											/>
										</div>
									</div>
									<div class="row pb-2">
										<div class="col-12 formulario">
											<label for="">Dirección</label>
											<input
												name="calle"
												type="text"
												class="input form-control form-control-sm"
												value="${ cliente.direcciones[0].calle}"
												id="_calle"
											/>
										</div>
									</div>
									<div class="row pb-2">
										<div class="col-md-6 formulario">
											<label for="">Departamento, casa, local, etc.</label>
											<input
												name="departamento"
												type="text"
												class="input form-control form-control-sm"
												value="${ cliente.direcciones[0].departamento}"
												id="_departamento"
											/>
										</div>
										<div class="col-md-6 formulario">
											<label for="">Comuna, Ciudad</label>
											<input
												name="ciudad"
												type="text"
												class="input form-control form-control-sm"
												value="${ cliente.direcciones[0].ciudad}"
												id="_ciudad"
											/>
										</div>
									</div>
									<div class="row justify-content-center">
										<div class="col-sm-6 col-md-4">
											<button type="submit" class="button fs-5 p-2 mt-3">Continuar</button>
										</div>
										<div class="col-sm-6 col-md-3">
											<a href=""><button class="button2 fs-5 p-2 mt-3">Volver</button></a>
										</div>
									</div>
								</section>
							</div>
							<div class="col-md-5 derecha">
								<div class="row pb-2 justify-content-start">
									<div class="col-sm-6 col-md-6 formulario">
										<label for="">Cupón</label>
										<input type="text" class="input form-control form-control-sm" disabled />
									</div>
									<div class="col-sm-6 col-md-2">
										<button class="button fs-6 p-2 mt-4">Usar</button>
									</div>
								</div>
								<hr />
								<c:forEach items="${ productos }" var="p">
									<div class="container">
										<div class="row ps-2">
											<div class="col-4">
												<div class="col m-0 p-0">
													<img src="${ p.imageUrl }" alt="" class="float-start" />
												</div>
											</div>
											<div class="col-4 info-detalle">
												<div>
													<p class="col m-0 p-0">${ p.material }</p>
													<p>${ p.cantidad } unidades</p>
												</div>
											</div>
											<div class="col-4 text-end info-detalle">
												<div class="col pe-2">
													<p>${ p.total }</p>
													<i
														class="trash fa-regular fa-trash-can mt-3"
														data-bs-toggle="modal"
														data-bs-target="#exampleModal"
													></i>
													<!-- Modal -->
													<div
														class="modal fade"
														id="exampleModal"
														tabindex="-1"
														aria-labelledby="exampleModalLabel"
														aria-hidden="true"
													>
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabel">
																		Mensaje
																	</h5>
																	<button
																		type="button"
																		class="btn-close"
																		data-bs-dismiss="modal"
																		aria-label="Close"
																	></button>
																</div>
																<div class="modal-body">
																	Está seguro que desea eliminar el producto de su
																	carrito?
																</div>
																<div class="row">
																	<div class="modal-footer">
																		<div class="col-3">
																			<button
																				type="button"
																				class="button2"
																				data-bs-dismiss="modal"
																			>
																				No
																			</button>
																		</div>
																		<div class="col-3">
																			<button
																				type="button"
																				class="button"
																				onclick="eliminarDelCarrito('${ p.productoId }')"
																			>
																				Si
																			</button>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
										<hr />
									</div>
								</c:forEach>
								<div class="container fw-bold fs-6">
									<div class="row justify-content-between">
										<div class="col-4">
											<p>SubTotal</p>
											<p>Envío</p>
										</div>
										<div class="col-2">
											<c:set value="${ 0 }" var="total"></c:set>
											<c:forEach items="${ productos }" var="pt">
												<c:set
													value="${ total + (pt.cantidad * pt.precio) }"
													var="total"
												></c:set>
											</c:forEach>
											<p id="format_precio_total">${ total }</p>
											<c:set value="${ 3990 }" var="envio"></c:set>
											<p id="format_precio_envio" class="text-center">${ envio }</p>
										</div>
									</div>
									<div class="col">
										<p class="fs-6">*Calculado en el próximo paso.</p>
									</div>
									<hr />
									<div class="row justify-content-between">
										<div class="col-4">
											<p>Total</p>
										</div>
										<div class="col-2">
											<c:set value="${ total + envio }" var="total_envio"></c:set>
											<p id="format_total_envio">${ total_envio }</p>
										</div>
									</div>
								</div>
								<div class="text-center mt-5">
									<img src="img/retrocicla-round.png" alt="" style="width: 35%" />
								</div>
							</div>
						</div>
					</form>
				</c:when>
				<c:otherwise>
					<section class="container-fluid seccion-principal-redirigir">
						<div class="row text-center bg-light">
							<div class="loader d-flex justify-content-center"></div>
							<h1 class="fw-bold">Usted no tienen elementos en su carrito...</h1>
							<h4 id="redirigir" style="font-family: 'Metropolis'; font-size: 18px">
								Espera un momento mientras te redireccionamos al inicio...
							</h4>
							<a href="/" class="text-decoration-none">
								<h6 style="color: #00ff99; font-size: 18px">Regresar al inicio</h6>
							</a>
						</div>
					</section>
				</c:otherwise>
			</c:choose>
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