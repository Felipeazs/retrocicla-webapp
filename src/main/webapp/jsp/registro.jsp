<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<!-- JQuery -->
		<script
			src="https://code.jquery.com/jquery-3.6.0.min.js"
			integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
			crossorigin="anonymous"
		></script>
		<!-- CSS only -->
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
			crossorigin="anonymous"
		/>
		<!-- Google Fonts -->
		<link rel="preconnect" href="https://fonts.googleapis.com" />
		<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
		<link
			href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap"
			rel="stylesheet"
		/>
		<!-- Bootstrap icons -->
		<link
			rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css"
		/>		
		<!-- Font Awesome -->
		<script src="https://kit.fontawesome.com/8df927e57d.js" crossorigin="anonymous"></script>
		
		<link rel="stylesheet" href="css/style.css" />
		<script src="js/script.js"></script>

		<title>Retrocicla</title>
	</head>
	<body>
		<div class="page-wrapper">
			<!-- MENU SIDEBAR-->
			<aside class="menu-sidebar d-none d-lg-block">
				<div class="logo">
					<a href="/">
						<img
							src="img/logo1.png"
							alt="logo-retrocicla"
							class="img-responsive"
						/>
					</a>
				</div>
				<div class="menu-sidebar-content js-scrollbar1">
					<nav class="navbar-sidebar">
						<ul class="list-unstyled navbar-list">
							<li><a href="/ropaspage">Ropa</a></li>
							<li><a href="/telaspage">Telas</a></li>
							<li><a href="/addproductpage">Agregar producto</a></li>
							<li><a href="/logout">Cerrar sesi??n</a></li>
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
						<nav class="navbar navbar-expand-lg navbar-dark">
							<div class="container-fluid">
								<div
									class="collapse navbar-collapse"
									id="navbarNav"
								>
									<ul class="navbar-nav">
										<li class="nav-item">
											<a
												class="nav-link active text-decoration-underline"
												aria-current="page"
												href="/"
												>Home</a
											>
										</li>
										<li class="nav-item">
											<a class="nav-link" href="#"
												>Tienda</a
											>
										</li>
										<li class="nav-item">
											<a class="nav-link" href="#"
												>Quienes somos</a
											>
										</li>
										<li class="nav-item">
											<a class="nav-link" href="#"
												>Blog</a
											>
										</li>

										<li class="nav-item">
											<a class="nav-link" href="#"
												>Nuestros clientes</a
											>
										</li>
										<li class="nav-item">
											<a class="nav-link" href="#"
												>Quieres donar?</a
											>
										</li>
									</ul>
								</div>
							</div>
						</nav>
					</div>
				</header>
				<!-- END HEADER DESKTOP-->

				<!-- MAIN CONTENT-->
				<div class="main-content">
					<div class="row">
						<div class="section-content section-content-p30">
							<div class="detail-section">
								<div class="container-fluid">
								<form:form 
			                		action="/registrarcliente" 
			                		method="post"
			                		modelAttribute="cliente">
			                		<div class="row g-1 align-items-center">
										  <label for="nombre" class="form-label">Nombre</label>
										  <form:input 
										  	path="nombre" 
										  	type="text" 
										  	class="form-control" 							  	
										  	/>
									</div>
									
									<%-- <form:input path="cliente.nombre" type="text"
												onkeyup="checkinputrequirements(${1})" id="inputtext-1" />
											<div class="alert alert-danger mt-1" id="inputalertmsg-1"
												name="inputalertmsg">
												<div>Su nombre es requerido y debe tener al menos 2
													caracteres.</div>
											</div> --%>
									
									
									<div class="row g-1 align-items-center">
										  <label for="apellido" class="form-label">Apellido</label>
										  <form:input 
										  	path="apellido" 
										  	type="text" 
										  	class="form-control" 							  	
										  	/>
									</div>
									
									<%-- <form:input path="cliente.apellido" type="text"
												onkeyup="checkinputrequirements(${2})" id="inputtext-2" />
											<div class="alert alert-danger mt-1" id="inputalertmsg-2"
												name="inputalertmsg">
												<div>Su apellido es requerido y debe tener al menos 2
													caracteres.</div>
											</div> --%>
											
											
									<div class="row g-1 align-items-center">
										  <label for="email" class="form-label">Email</label>
										  <form:input 
										  	path="email" 
										  	type="email" 
										  	class="form-control" 							  	
										  	/>
									</div>
									
									<%-- <form:input path="cliente.email" type="text"
												onkeyup="checkinputrequirements('email')"
												id="inputtext-email" />
											<div class="alert alert-danger mt-1" id="inputalertmsg-email"
												name="inputalertmsg">
												<div>Su email es requerido y debe tener formato v??lido</div>
											</div> --%>
											
											
									<div class="row g-1 align-items-center">
										  <label for="pass" class="form-label">Contrase??a</label>
										  <form:input 
										  	path="password" 
										  	type="password" 
										  	class="form-control" 
										  	id="pass"
										  	/>
									</div>	
									<div class="row g-1 align-items-center">
										  <label for="pass2" class="form-label">Repite la contrase??a</label>
										  <form:input 
										  	path="" 
										  	type="password" 
										  	class="form-control"
										  	id="pass2"							  	
										  	/>
										  
									</div>
									<div class="alert alert-danger mt-1" id="alertregistrar"
										name="inputalertmsg">
										<div>Las contrase??as no coinciden</div>
									</div>	
									<div style="text-align:center">					
										<br>
											<button onclick="btnregistrar()" id="btnregistrar"
											class="btn btn-primary">
												Registrar
											</button>
									</div>
								</form:form>
								
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

		<!-- JavaScript Bundle with Popper -->
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
			crossorigin="anonymous"
		></script>
	</body>
</html>
