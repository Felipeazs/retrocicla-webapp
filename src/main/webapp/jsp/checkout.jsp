<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://www.springframework.org/tags/form"
prefix="form"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
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
							<li>
								<a href="/addproductpage">Agregar producto</a>
							</li>
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
								<div class="cart-area d-n">									
									<a href="/cartdetails">
										<div class="total">									    
									    	<strong name="feedback-totalprice">${ totalamount }</strong>					    	
									      	<span id="feedback-totalquantity">${ totalquantity }</span>	
									      </div>								   
									    <i class="fa fa-shopping-cart" aria-hidden="true"></i>
									    
									</a>
								</div>
							</div>
						</nav>						
					</div>
				</header>
				<!-- END HEADER DESKTOP-->

				<!-- MAIN CONTENT-->
				<div class="main-content page-m">
				  <div class="section-content section content-p30">
				    <div class="container-fluid">
				      <form>
				        <!-- customer form -->
				        <div class="form-area">
				          <h3>Datos del Cliente</h3>
				          <div class="row">
				            <div class="col-md-2"><label>Nombre</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <input
				                  type="text"
				                  onkeydown=""
				                  id="inputtext"
				                />
				                <div class="alert alert-danger mt-1" id="inputalertmsg">
				                  <div id="requiredalert">
				                    First Name is required
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>
				          <div class="row">
				            <div class="col-md-2"><label>Apellido</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <input
				                  type="text"
				                  onkeydown="checkinputrequirements(${2})"
				                  id="inputtext${2}"
				                />
				                <div class="alert alert-danger mt-1" id="inputalertmsg2">
				                  <div>
				                    Last Name is required
				                  </div>				
				                  <div>
				                    Last Name must be at least 2 characters long
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>
				          <div class="row">
				            <div class="col-md-2"><label>Email</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <input
				                  type="text"
				                />
				                <div class="alert alert-danger mt-1">
				                  <div>Email is required</div>
				
				                  <div>
				                    Email must be a valid email address format
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>
				        </div>
				        <!-- Shipping Address -->
				        <div formGroupName="shippingAddress" class="form-area">
				        <h3>Dirección de despacho</h3>
				        <div class="row">
				            <div class="col-md-2"><label>Región</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <select>
				                  <option>
				                    {{ state.name }}
				                  </option>
				                </select>
				                <div class="alert alert-danger mt-1">
				                  <div>
				                    State is required
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>
				          <div class="row">
				            <div class="col-md-2"><label>Ciudad</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <input type="text" />
				                <div class="alert alert-danger mt-1">
				                  <div>
				                    City is required
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>				          
				          <div class="row">
				            <div class="col-md-2"><label>Calle</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <input
				                  type="text"
				                />
				                <div class="alert alert-danger mt-1">
				                  <div>
				                    Street is required
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>
				          </div>				          
				        <!-- check box shipping/billing address-->
				        <div class="input-space">
				          <label class="au-checkbox">
				            <input
				              type="checkbox"
				              (change)="copyShippingAddressToBillingAddress($event)"
				            />
				            <span class="au-checkmark"></span> Billing Address same as Shipping
				            Address
				          </label>
				        </div>
				        
				        <!-- Billing Address -->
				        <div formGroupName="billingAddress" class="form-area">
				        <h3>Dirección de facturación</h3>
				        <div class="row">
				            <div class="col-md-2"><label>Región</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <select>
				                  <option>
				                    {{ state.name }}
				                  </option>
				                </select>
				                <div class="alert alert-danger mt-1">
				                  <div>
				                    State is required
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>
				          <div class="row">
				            <div class="col-md-2"><label>Ciudad</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <input type="text" />
				                <div class="alert alert-danger mt-1">
				                  <div>
				                    City is required
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>				          
				          <div class="row">
				            <div class="col-md-2"><label>Calle</label></div>
				            <div class="col-md-9">
				              <div class="input-space">
				                <input
				                  type="text"
				                />
				                <div class="alert alert-danger mt-1">
				                  <div>
				                    Street is required
				                  </div>
				                </div>
				              </div>
				            </div>
				          </div>
				          </div>
				        <!-- Credit Card Info -->
				        
				        <!-- Order details -->
				        <div class="form-area">
				          <h3>Revisa tu orden</h3>
				          <p>Cantidad de productos:	${ totalquantity }</p>				     
				          <p>Precio total: ${ totalamount }</p>
				        </div>
				        <!-- Submit -->
				        <div class="text-center">
				          <button type="submit" class="btn btn-info">Comprar</button>
				        </div>
				      </form>
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
