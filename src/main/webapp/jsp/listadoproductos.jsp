<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="css/style.css" />
<script src="js/script.js"></script>

<title>Retrocicla</title>
</head>
<body>
	<div class="page-wrapper">

		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar d-none d-lg-block">
			<div class="logo">
				<a href="/"> <img src="assets/images/logo.png"
					alt="logo-retrocicla" class="img-responsive">
				</a>
			</div>
			<div class="menu-sidebar-content js-scrollbar1">
				<nav class="navbar-sidebar">
					<ul class="list-unstyled navbar-list">
						<li><a href="/ropaspage">Ropa</a></li>
						<li><a href="/telaspage">Telas</a></li>
						<li><a href="/addproductpage">Agregar producto</a></li>
					</ul>
				</nav>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop">
				<div class="section-content section-content-p30">
					<div class="container-fluid">
						<div class="header-wrap">
							<form class="form-header" onsubmit="return false;" method="GET">
								<input class="au-input au-input-xl" type="text" name="search"
									placeholder="Search for data ..." />
								<button class="au-btn-submit" type="submit">Buscar</button>
							</form>
							<div class="cart-area d-n">
								<a href="shopping-detail.html">
									<div class="total">
										0 <span> 0</span>
									</div> <i class="fa fa-shopping-cart" aria-hidden="true"></i>
								</a>
							</div>
						</div>
						<div class="account-wrap"></div>
					</div>
				</div>
			</header>
			<!-- END HEADER DESKTOP-->

			<!-- MAIN CONTENT-->
			<div class="main-content">
				<div class="section-content section-content-p30">
					<div class="container-fluid">
						<c:if test="${ not empty productssize }">
							<div class="alert alert-danger">
								<c:choose>
									<c:when test="${ productssize > 1}">
										${ productssize } elementos fueron encontrados
									</c:when>
									<c:otherwise>
										${ productssize } elemento fue encontrado
									</c:otherwise>
								</c:choose>	
							</div>
						</c:if>
						<c:if test="${ empty products }">
							<div class="alert alert-danger" id="messageError">
								No se encontró ningún producto con esas características
							</div>
						</c:if>
						<div class="row">
							<c:forEach items="${ products }" var="p">
								<div class="col-md-2">
									<div class="product-box">										
											<a href=""> 
												<img src=${ p.imageUrl} class="img-responsive"> 
											</a>
											<h1>${ p.description }</h1>
											<c:if test="${ p.wear ne 'indefinido' }">
												<h2>Prenda: ${ p.wear }</h2>	
											</c:if>																				
											<h2>Tamaño: ${ p.size }</h2>
											<c:if test="${ p.style ne 'indefinido' }">
												<h2>Estilo: ${ p.style }</h2>
											</c:if>
											<c:if test="${ p.genre ne 'indefinido' }">
												<h2>Género: ${ p.genre }</h2>
											</c:if>
											<h2>Color: ${ p.color }</h2>
											<c:if test="${ p.season ne 'indefinido' }">
												<h2>Temporada: ${ p.season }</h2>
											</c:if>
											<h2>Composición:</h2>
											<c:if test="${ p.cotton > 0 }">
												<h2 class="comp">${ p.cotton }% algodón</h2>
											</c:if>
											<c:if test="${ p.spandex > 0 }">
												<h2 class="comp">${ p.spandex }% spandex</h2>
											</c:if>
											<h2>Hecho en ${ p.made }</h2>											
											<div class="price">
												<h2>Precio:</h2>
												${ p.formatted_price }</div>
											<a href="#" class="primary-btn">Agregar al carrito</a>
										</div>										
									</div>
								</c:forEach>								
						</div>
					</div>
					</div>
				</div>

				<!-- END MAIN CONTENT-->

			</div>
		</div>
	

	<!-- END PAGE CONTAINER-->


	<footer>
		<ul>
			<li><a href="#">About Us</a></li>
			<li><a href="#">Contact Us</a></li>
			<li><a href="#">Help</a></li>
		</ul>
	</footer>
</body>

</html>