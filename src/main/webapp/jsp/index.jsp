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
				<a href="home.html"> <img src="assets/images/logo.png"
					alt="luv2shop" class="img-responsive">
				</a>
			</div>
			<div class="menu-sidebar-content js-scrollbar1">
				<nav class="navbar-sidebar">
					<ul class="list-unstyled navbar-list">
						<li><a href="#">Books</a></li>
						<li><a href="#">Coffee Mugs</a></li>
						<li><a href="#">Mouse Pads</a></li>
						<li><a href="#">Luggage Tags</a></li>
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
								<button class="au-btn-submit" type="submit">Search</button>
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
						<div class="row">

							<div class="col-md-3">
								<div class="product-box">
									<a href="product-detail.html"> <img
										src="assets/images/products/placeholder.png"
										class="img-responsive">
									</a> <a href="product-detail.html">
										<h1>Lorem ipsum dolor sit amet</h1>
									</a>
									<h2>Duis aute irure dolor in reprehenderit in voluptate</h2>
									<div class="price">19.22 $</div>
									<a href="#" class="primary-btn">Add to cart</a>
								</div>
							</div>



						</div>
					</div>
				</div>

				<!-- END MAIN CONTENT-->

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