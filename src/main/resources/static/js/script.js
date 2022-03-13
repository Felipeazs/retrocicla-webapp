$(document).ready(function() {
	
	$('#messageerrorprenda').hide();
	$('#messageerrortela').hide();
	$('#typeropa').val('prenda');
	$('#sizetelas').hide();

	var sizetelas = $('#sizetelas').val();
	var sizeropa = $('#sizeropa').val();
	var wear = $('#wear').val();
	var style = $('#style').val();
	var genre = $('#genre').val();
	var season = $('#season').val();

	// Selección de formulario para agrgar prenda o tela
	$('#formulariotela').hide();

	$('#selecttipoprenda').change(function() {
		if ($('#selecttipoprenda').val() == 'prenda') {
			$('#formularioprenda').show();
			$('#typeropa').val('prenda');
			$('#formulariotela').hide();
		} else {
			$('#formulariotela').show();
			$('#typetela').val('tela');
			$('#formularioprenda').hide();
		}
	});

	// Formulario agregar prenda
	$('#agregarprendabutton').click(function() {
		if (
			!$('#descriptionropa').val() ||
			!$('#sizeropa').val() ||
			!$('#wearropa').val() ||
			!$('#styleropa').val() ||
			!$('#colorropa').val() ||
			!$('#genreropa').val() ||
			!$('#seasonropa').val() ||
			!$('#cottonropa').val() ||
			!$('#spandexropa').val() ||
			!$('#madeInropa').val() ||
			!$('#priceropa').val() ||
			!$('#imageropa').val()
		) {
			$('#messageerrorprenda').show();
		} else {
			$('#agregarprendasubmit').submit();
		}
	});

	// Formulario agregar tela
	$('#agregartelabutton').click(function() {
		if (
			!$('#descriptiontela').val() ||
			!$('#sizetela').val() ||
			!$('#colortela').val() ||
			!$('#cottontela').val() ||
			!$('#spandextela').val() ||
			!$('#madeIntela').val() ||
			!$('#pricetela').val() ||
			!$('#imagetela').val()
		) {
			$('#messageerrortela').show();
		} else {
			$('#agregartelasubmit').submit();
		}
	});

	// Seleccion de tipos en búsqueda avanzada
	$('#types').change(function() {
		if ($('#types').val() == 'prenda') {
			$('#sizeropa').show();
			$('#sizetelas').hide();
			$('#sizetelas').val('');
			$('#sizeropa').val(sizeropa);
			$('#wear').attr('disabled', false);
			$('#wear').val(wear);
			$('#genre').attr('disabled', false);
			$('#genre').val(genre);
			$('#style').attr('disabled', false);
			$('#style').val(style);
			$('#season').attr('disabled', false);
			$('#season').val(season);
		} else {
			$('#sizeropa').hide();
			$('#sizetelas').show();
			$('#sizetelas').val(sizetelas);
			$('#sizeropa').val('');
			$('#genre').attr('disabled', true);
			$('#genre').val('');
			$('#style').attr('disabled', true);
			$('#style').val('');
			$('#season').attr('disabled', true);
			$('#season').val('');
			$('#wear').attr('disabled', true);
			$('#wear').val('');
		}
	});

	// Tootltips
	var tooltipTriggerList = [].slice.call(
		document.querySelectorAll('[data-bs-toggle="tooltip"]')
	);
	var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
		return new bootstrap.Tooltip(tooltipTriggerEl);
	});
});

function addproducttocart(id) {

	$.ajax({
		type: 'POST',
		url: '/api/product/' + id,
		data: {
			id: id
		},
		statusCode: {
			200: function(){
				console.log("http status code 200: succesful request")
			},
			404: function() {
				console.log("http status code 404: page not found");
			},
			405: function(){
				console.log("Bad HTTP request");
			},
			500: function() {
				console.log("http status code 500: error interno del servidor");
			}
		},
		success: function(data) {
									
			var totalAmount = 0;
			var totalQuantity = 0;
			
			data.forEach(function(data) {
				
				if (data.quantity >= data.product.stock){
					$('#addproducttocartbutton').prop('disabled', true);
				} 
				
				totalAmount = totalAmount + (data.product.price * data.quantity);
				totalQuantity = totalQuantity + data.quantity;			
					
			});
	
			$('[name=feedback-totalprice]').html(formatter.format(totalAmount));
			$('#feedback-totalquantity').html(totalQuantity);
		},
		error: function(data) {
			console.log('ERROR: ', data);
		},
	});

}

function addcartproductitem(id) {

	addproducttocart(id);

	$.ajax({
		type: 'PUT',
		url: '/api/product/add/' + id,
		data: {
			id: id
		},
		statusCode: {
			200: function(){
				console.log("http status code 200: succesful request")
			},
			404: function() {
				console.log("http status code 404: page not found");
			},
			405: function(){
				console.log("Bad HTTP request");
			},
			500: function() {
				console.log("http status code 500: server error");
			}
		},
		success: function(data) {
			
			if (data.quantity > 1) {
				$('#removecartbutton' + data.product.id).prop('disabled', false);
			}
			
			if (data.quantity >= data.product.stock){
				$('#addcartbutton' + data.product.id).prop('disabled', true);
			}	
			
			var totalAmount = data.totalPrice;
			var totalQuantity = data.quantity;
			var itemid = data.id;

			$('#feedback-price' + itemid).html(totalAmount);
			$('#feedback-quantity' + itemid).html(totalQuantity);
		},
		error: function() {
			console.log('ERROR: ', id);
		},
	});

}

function removecartproductitem(id) {

	$.ajax({
		type: 'PUT',
		url: '/api/product/remove/' + id,
		data: {
			id: id
		},
		statusCode: {
			200: function(){
				console.log("http status code 200: succesful request")
			},
			404: function() {
				console.log("http status code 404: page not found");
			},
			405: function(){
				console.log("Bad HTTP request");
			},
			500: function() {
				console.log("http status code 500: server error");
			}
		},
		success: function(data) {
			var totalAmount = 0;
			var totalQuantity = 0;

			data.forEach(function(data) {
				totalAmount = totalAmount + (data.product.price * data.quantity);
				totalQuantity = totalQuantity + data.quantity;				
				
				$('[name=feedback-totalprice]').html(formatter.format(totalAmount));
				$('#feedback-totalquantity').html(totalQuantity);
				
				if (data.quantity == 1){
					$('#removecartbutton' + data.product.id).prop('disabled', true);
				} else if (data.quantity == 0) {
					location.reload();
				}
							
				if (data.quantity <= data.product.stock){
					$('#addcartbutton' + data.product.id).prop('disabled', false);
				}
							
				var itemAmount = data.totalPrice;
				var itemQuantity = data.quantity;
				var itemid = data.id;
	
				$('#feedback-price' + itemid).html(itemAmount);
				$('#feedback-quantity' + itemid).html(itemQuantity);
			});

		},
		error: function(data) {
			console.log('ERROR: ', data);
			location.reload();
		},
	});

}

function deletecartproduct(id){
	
	$.ajax({
		type: 'DELETE',
		url: '/api/product/' + id,
		data: {
			id: id
		},
		statusCode: {
			200: function(){
				console.log("http status code 200: succesful request")
			},
			404: function() {
				console.log("http status code 404: page not found");
			},
			405: function(){
				console.log("Bad HTTP request");
			},
			500: function() {
				console.log("http status code 500: server error");
			}
		},
		success: function() {			
			if(window.confirm("Está seguro que desea eliminar este producto de su carrito?")){
				location.reload();
			}
			
		},
		error: function(id) {
			console.log('ERROR: ', id);
			location.reload();
		},
	});
	
}

var formatter = new Intl.NumberFormat('es-CL', {
	style: 'currency',
	currency: 'CLP',
	maximumFractionDigits: 0
});


