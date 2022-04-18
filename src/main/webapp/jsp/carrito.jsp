<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> <%@ taglib
uri="http://www.springframework.org/tags/form" prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>

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
		<section class="container-flex text-center seccion-carrito bg-light">
			<div class="row">
				<p class="fs-4 fw-bold mt-5 mb-5">Carrito de compras</p>
				<div class="col-md-12 mb-5">
					<c:choose>
					<c:when test="${ not empty productos }">
					<table class="table text-center">
						<thead>
							<tr>
								<th>Producto</th>
								<th>Precio</th>
								<th>Cantidad</th>
								<th>SubTotal</th>
								<th>Eliminar</th>
							</tr>
						</thead>
						<tbody>
							<c:set value="${ 0 }" var="total"></c:set>
							<c:set value="${ 0 }" var="cantidad"></c:set>
							<c:forEach items="${ productos }" var="p">
								<c:set value="${ total + (p.precio * p.cantidad) }" var="total"></c:set>	
								<c:set value="${ cantidad + p.cantidad }" var="cantidad"></c:set>	
								<input 
									type="hidden"
									value="${ p.productoId }"
									id="productoId">
								<tr>
									<td>
										<img src="${ p.imageUrl }" alt="" height="100" width="100" />
										Descripcion
									</td>
									<td id="format_precio_carrito_${ p.productoId }">${ p.precio }</td>
									<td>${ p.cantidad }</td>
									<td>${ p.total }</td>
									<td>
										<i class="trash fa-regular fa-trash-can" 
											data-bs-toggle="modal"
											data-bs-target="#exampleModal"></i>
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
									</td>
								</tr>								
								<script>
									var precio_carrito = $('#format_precio_carrito_${ p.productoId }').html();
									console.log(precio_carrito);
									var formato_precio = formatter.format(precio_carrito)
									$('#format_precio_carrito_${ p.productoId }').html(formato_precio);
								</script>
							</c:forEach>
							<tr>							
								<td></td>								
								<td class="fw-bold text-center">Subtotal</td>															
								<td>${ cantidad }</td>
								<td class="fw-bold" id="format_precio_total">${ total }</td>
							</tr>
							
						</tbody>
					</table>
					<p class="fs-4 fw-bold mt-5 mb-3">Agregar comentarios a la compra</p>
					<div class="textarea">
						<textarea></textarea>
						<p>
							Al hacer clic en “Finalizar compra”, aceptas los términos y condiciones, política de
							reembolso y privacidad de Retrocicla.
						</p>
					</div>				
					<div class="container">
						<div class="row d-flex justify-content-center">
							<div class="col-md-3">									
								<a href="/informacion-usuario"><button class="boton fs-6 p-2">Finalizar compra</button>	</a>							
							</div>
						</div>
					</div>
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
