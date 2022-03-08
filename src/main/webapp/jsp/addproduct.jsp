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
			<div class="main-content page-m">
				<div class="section-content section-content-p30 e-spc">
					<div class="container-fluid">
						<div class="form-area">													
							<h3>Agregar producto</h3>
							<div class="row">
								<div class="col-md-2"><label>Tipo</label></div>	
									<div class="col-md-4">
										<div class="input-space">
											<select id="selecttipoprenda" name="tipoprenda">
												<option value="prenda">Prenda</option>
												<option value="tela">Tela</option>
											</select>
										</div>
									</div>	
							</div>					
								<div id="formularioprenda">
								<form:form 
								method="get" 
								modelAttribute="product"
								action="/addproductdb" 
								id="agregarprendasubmit">								
								<form:input 
									path="type" 
									type="hidden"
									id="typeropa"
									/>
									<div class="row">									
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Descripción</label></div>
										<div class="col-md-8">
											<div class="input-space">
												<form:input 
													path="description" 
													type="text"
													id="descriptionropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Tamaño</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="size" 
													type="text"
													id="sizeropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Prenda</label></div>
										<div class="col-md-4">
											<div class="input-space">
												<form:input 
													path="wear" 
													type="text"
													id="wearropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Estilo</label></div>
										<div class="col-md-4">
											<div class="input-space">
												<form:input 
													path="style" 
													type="text"
													id="styleropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Color</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="color" 
													type="text"
													id="colorropa"/>
											</div>
										</div>	
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Género</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="genre" 
													type="text"
													id="genreropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Temporada</label></div>
										<div class="col-md-4">
											<div class="input-space">
												<form:select 
													path="season" 
													type="text" 
													id="seasonropa">
													<form:option value="otoño-inviero"/>
													<form:option value="primavera-verano"/>
												</form:select>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>%Algodón</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="cotton" 
													type="text"
													id="cottonropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>%Spandex</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="spandex" 
													type="text"
													id="spandexropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Hecho en</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="made" 
													type="text"
													id="madeInropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Precio</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="price" 
													type="text"
													id="priceropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Imágen Url</label></div>
										<div class="col-md-12">
											<div class="input-space">
												<form:input 
													path="imageUrl" 
													type="text"
													id="imageropa"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="alert alert-danger mt-1" id="messageerrorprenda">
											Por favor, agregue todos los campos
										</div>								
									</div>
									<div class="text-center">
										<form:button type="button" id="agregarprendabutton" class="btn btn-info">Agregar</form:button>
									</div>
									</form:form>
								</div>	
							<div id="formulariotela">
							<form:form 
								method="get" 
								modelAttribute="product"
								action="/addproductdb" 
								id="agregartelasubmit">								
								<form:input 
									path="type" 
									type="hidden"
									id="typetela"
									/>
									<div class="row">									
										<div class="col-md-2"><label>Descripción</label></div>
										<div class="col-md-8">
											<div class="input-space">
												<form:input 
													path="description" 
													type="text"
													id="descriptiontela"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Tamaño</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="size" 
													type="text"
													id="sizetela"/>
											</div>
										</div>		
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Color</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="color" 
													type="text"
													id="colortela"/>
											</div>
										</div>				
										<div class="clearfix"></div>
										<div class="col-md-2"><label>%Algodón</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="cotton" 
													type="text"
													id="cottontela"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>%Spandex</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="spandex" 
													type="text"
													id="spandextela"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Hecho en</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="made" 
													type="text"
													id="madeIntela"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Precio</label></div>
										<div class="col-md-3">
											<div class="input-space">
												<form:input 
													path="price" 
													type="text"
													id="pricetela"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="col-md-2"><label>Imágen Url</label></div>
										<div class="col-md-12">
											<div class="input-space">
												<form:input 
													path="imageUrl" 
													type="text"
													id="imagetela"/>
											</div>
										</div>
										<div class="clearfix"></div>
										<div class="alert alert-danger mt-1" id="messageerrortela">
											Por favor, agregue todos los campos
										</div>
										<div class="text-center">
											<form:button type="button" id="agregartelabutton" class="btn btn-info">Agregar</form:button>
										</div>								
									</div>
									</form:form>
								</div>
								
							</div>
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