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
<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet" />

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
						<li><a href="/addproductpage">Agregar</a></li>
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
					<div class="alert alert-danger mt-1" id="messageSuccess">
										Elemento agregado correctamente
									</div>
						<div class="row">
							<div class="s007">
						      <form:form
						      	method="get" 
								modelAttribute="product"
								action="/searchproduct" 
								id="">
						        <div class="inner-form">
						          <div class="basic-search">
						            <div class="input-field">
						              <div class="icon-wrap">
						                <svg version="1.1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="20" height="20" viewBox="0 0 20 20">
						                  <path d="M18.869 19.162l-5.943-6.484c1.339-1.401 2.075-3.233 2.075-5.178 0-2.003-0.78-3.887-2.197-5.303s-3.3-2.197-5.303-2.197-3.887 0.78-5.303 2.197-2.197 3.3-2.197 5.303 0.78 3.887 2.197 5.303 3.3 2.197 5.303 2.197c1.726 0 3.362-0.579 4.688-1.645l5.943 6.483c0.099 0.108 0.233 0.162 0.369 0.162 0.121 0 0.242-0.043 0.338-0.131 0.204-0.187 0.217-0.503 0.031-0.706zM1 7.5c0-3.584 2.916-6.5 6.5-6.5s6.5 2.916 6.5 6.5-2.916 6.5-6.5 6.5-6.5-2.916-6.5-6.5z"></path>
						                </svg>
						              </div>
						              <input id="search" type="text" placeholder="Buscar..." />
						              <div class="result-count">
						                <span>108 </span>results</div>
						            </div>
						          </div>
						          <div class="advance-search">
						            <span class="desc">Búsqueda avanzada</span>
						            <div class="row">
						              <div class="input-field">
						              <div><label>Tela/Ropa</label></div>
						                <div class="input-select">
						                  <form:select 
						                  	class="form-select"
						                  	path="style">						                    
							                    <form:options items="${ types }"/>						                   
						                  </form:select>
						                </div>
						              </div>
						              <div class="input-field">
						              <div><label>Material</label></div>
						                <div class="input-select">
						                  <form:select 
						                  	class="form-select" 
						                  	path="material"
						                  	type="text">
						                    	<form:options items="${ materials }"/>						                    
						                  </form:select>
						                </div>
						              </div>
						              <div class="input-field">
						              <div><label>Prenda</label></div>
						                <div class="input-select">
						                  <form:select 
						                  	class="form-select"
						                  	path="wear">
						                    	<form:options items="${ wear }"/>
						                  </form:select>
						                </div>
						              </div>						              						              
						            </div>
						            <div class="row second">	
						            <div class="input-field">
						              	<div><label>Color</label></div>
							                <div class="input-select">
						                  <form:select 
						                  	class="form-select"
						                  	path="color">
						                    	<form:options items="${ colors }"/>
						                  </form:select>
						                </div>
						              </div>					            	
						              <div class="input-field">
						              <div><label>Tamaño</label></div>
						                <div class="input-select">
							                 <div>
							                  	<form:input 
							                  		type="text" 
							                  		class="form-control"
							                  		path="size"/>						                    
							              	</div>
						                </div>
						              </div>
						              <div class="input-field">
						                <div><label>Estilo</label></div>
						                <div class="input-select">
						                  <form:select 
						                  	class="form-select"
						                  	path="style">
						                    	<form:options items="${ styles }"/>
						                  </form:select>
						                </div>
						              </div>
						              </div>
						            <div class="row third">
							            <div class="input-field">
							                <div><label>Género</label></div>
							                <div class="input-select">
							                <form:select 
							                  	class="form-select"
							                  	path="genre">
							                    	<form:options items="${ genres }"/>
							                  </form:select>
							                </div>
						              </div>
							            <div class="input-field">
							                <div><label>Temporada</label></div>
							                <div class="input-select">
							                   <form:select 
								                  class="form-select"
								                  path="season">
								                    <form:options items="${ seasons }"/>
								               </form:select>
							                </div>
							                </div>
							              </div>
							             <div class="input-field">
							                <div><label>Hecho en</label></div>
							                <div class="input-select">
							                  <select class="form-select">
							                    <option>China</option>
							                    <option>Chile</option>					                    
							                  </select>
							                </div>
							              </div>						              
						            </div>
						            <div class="row">
						            	<div class="input-field">
						                	<button class="btn btn-success">Buscar</button>						             
						              	</div>
						            </div>
						          </div>						        
						      </form:form>
						    </div>
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