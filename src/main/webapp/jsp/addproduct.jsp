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
						<li><a href="#">Ropa</a></li>
						<li><a href="#">Telas</a></li>
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
			<div class="main-content page-m">
				<div class="section-content section-content-p30 e-spc">
					<div class="container-fluid">

						<div class="form-area">
							<h3>Agregar producto</h3>
							<form:form 
								method="get" 
								modelAttribute="product"
								action="/addproductdb" 
								id="agregarproductsubmit">
								<div class="row">
									<div class="col-md-2"><label>Descripción</label></div>
									<div class="col-md-8">
										<div class="input-space">
											<form:input 
												path="description" 
												type="text"
												id="description"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Tamaño</label></div>
									<div class="col-md-3">
										<div class="input-space">
											<form:input 
												path="size" 
												type="text"
												id="size"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Prenda</label></div>
									<div class="col-md-4">
										<div class="input-space">
											<form:select 
												path="wear" 
												type="text"
												id="wear">
												<form:options items="${ wear }"/>
											</form:select>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Estilo</label></div>
									<div class="col-md-4">
										<div class="input-space">
											<form:select 
												path="wear" 
												type="text" 
												id="style">
												<form:options items="${ styles }"/>
											</form:select>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Color</label></div>
									<div class="col-md-3">
										<div class="input-space">
											<form:input 
												path="color" 
												type="text"
												id="color"/>
										</div>
									</div>	
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Género</label></div>
									<div class="col-md-3">
										<div class="input-space">
											<form:input 
												path="genre" 
												type="text"
												id="genre"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Temporada</label></div>
									<div class="col-md-4">
										<div class="input-space">
											<form:input 
												path="season"
												type="text"
												id="season"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>%Algodón</label></div>
									<div class="col-md-3">
										<div class="input-space">
											<form:input 
												path="cotton" 
												type="text"
												id="cotton"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>%Spandex</label></div>
									<div class="col-md-3">
										<div class="input-space">
											<form:input 
												path="spandex" 
												type="text"
												id="spandex"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Hecho en</label></div>
									<div class="col-md-3">
										<div class="input-space">
											<form:input 
												path="made_in" 
												type="text"
												id="madeIn"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Precio</label></div>
									<div class="col-md-3">
										<div class="input-space">
											<form:input 
												path="price" 
												type="text"
												id="price"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="col-md-2"><label>Imágen Url</label></div>
									<div class="col-md-12">
										<div class="input-space">
											<form:input 
												path="image_url" 
												type="text"
												id="image"/>
										</div>
									</div>
									<div class="clearfix"></div>
									<div class="alert alert-danger mt-1" id="message">
										Por favor, agregue todos los campos
									</div>								
								</div>
								<div class="text-center">
									<form:button type="button" id="agregarbutton" class="btn btn-info">Agregar</form:button>
								</div>
							</form:form>
						</div>
					</div>
				</div>
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