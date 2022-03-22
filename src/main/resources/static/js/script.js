$(document).ready(function(e) {

	

	$('#messageerrorprenda').hide();
	$('#messageerrortela').hide();
	$('#typeropa').val('prenda');
	$('#sizetelas').hide();
	$('[name=inputalertmsg]').hide();
	$('#hiddenaddress').hide();

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
		
		e.preventDefault();
	});

	// Tootltips
	var tooltipTriggerList = [].slice.call(
		document.querySelectorAll('[data-bs-toggle="tooltip"]')
	);
	var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
		return new bootstrap.Tooltip(tooltipTriggerEl);
	});
	
	var location = window.location.pathname;
	var direcciones = $('#misdirecciones').val();
		
	if (location === '/checkout'){			
		if (direcciones == 0) {	
			selectCity(1);
			selectCity(2);
		}
	}
});

function btnregistrar(){
	if ($('#pass').val() != $('#pass2').val()){
		$('#alertregistrar').show();
	} else {
		$('#btnregistrar').submit();
	}
}

function checkinputrequirements(id) {
	
	document.addEventListener('keyup', (event) => {
		const keyCode = event.code;
		const keyName = event.key;
		
		const regex = new RegExp('[a-z0-9._%+-]+@[a-z-0-9.-]+\\.[a-z]{2,4}$');

		var input = $('#inputtext-' + id).val();		
		
		if (id === 'email'){
			var rex = regex.test(input);		
			if (!rex){
				$('#inputalertmsg-' + id).show();
			} else {
				$('#inputalertmsg-' + id).hide();
			}
		} else {
			if (input.length < 2 || (input.length < 2 && keyCode === 'Backspace')) {
				$('#inputalertmsg-' + id).show();
			} else {
				$('#inputalertmsg-' + id).hide();
			}
		}
	});
}

function addproducttocart(id) {
	
	$.ajax({
		type: 'POST',
		url: '/api/product/' + id,
		data: {
			id: id
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function(){
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function(){
				console.log("Status code 403: usuario no autorizado");
			},
			404: function() {
				console.log("Status code 404: page not found");				
			},
			405: function() {
				console.log("Status code 405: Bad HTTP request");
			},
			500: function() {
				console.log("Status code 500: server error");
			}
		},
		error: function(XMLHttpRequest, textStatus, errorThrown){
                            console.log(XMLHttpRequest);
                            console.log(textStatus);
                            console.log(errorThrown);
		
//		function(data) {
//			if (data.status == 401){
//				location.href = "/login"
//			}
					
		},
		success: function(data) {
			
			var totalAmount = 0;
			var totalQuantity = 0;			

			data.forEach(function(data) {

				if (data.quantity >= data.product.stock) {
					$('#addproducttocartbutton').prop('disabled', true);
				}

				totalAmount = totalAmount + (data.product.price * data.quantity);
				totalQuantity = totalQuantity + data.quantity;

			});

			$('[name=feedback-totalprice]').html(formatter.format(totalAmount));
			$('#feedback-totalquantity').html(totalQuantity);
		},
		
	});

}

function addcartproductitem(id) {

	//addproducttocart(id);

	$.ajax({
		type: 'PUT',
		url: '/api/product/add/' + id,
		data: {
			id: id
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function(){
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function(){
				console.log("Status code 403: usuario no autorizado");
			},
			404: function() {
				console.log("Status code 404: page not found");				
			},
			405: function() {
				console.log("Status code 405: Bad HTTP request");
			},
			500: function() {
				console.log("Status code 500: server error");
			}
		},
		error: function(data) {
			console.log(data);
			//location.href = data.status			
		},
		success: function(data) {
			
			console.log(data.status);
			
			if (data.quantity > 1) {
				$('#removecartbutton' + data.product.id).prop('disabled', false);
			}

			if (data.quantity >= data.product.stock) {
				$('#addcartbutton' + data.product.id).prop('disabled', true);
			}

			var totalAmount = data.totalPrice;
			var totalQuantity = data.quantity;
			var itemid = data.id;

			$('#feedback-price' + itemid).html(totalAmount);
			$('#feedback-quantity' + itemid).html(totalQuantity);
		},
		
	});

}

function removecartproductitem(id) {
	
	console.log(id);

	$.ajax({
		type: 'PUT',
		url: '/api/product/remove/' + id,
		data: {
			id: id
		},
		statusCode: {
			0: function() {
				console.log("failed to load resource");
			},
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function(){
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function(){
				console.log("Status code 403: usuario no autorizado");
			},
			404: function() {
				console.log("Status code 404: page not found");				
			},
			405: function() {
				console.log("Status code 405: Bad HTTP request");
			},
			500: function() {
				console.log("Status code 500: server error");
			}
		},
		error: function(data) {
			if (data.status == 401){
				location.href = "/login"
			}
			console.log(data);
			//location.href = data.status			
		},
		success: function(data) {
			var totalAmount = 0;
			var totalQuantity = 0;

			data.forEach(function(data) {
				totalAmount = totalAmount + (data.product.price * data.quantity);
				totalQuantity = totalQuantity + data.quantity;

				$('[name=feedback-totalprice]').html(formatter.format(totalAmount));
				$('#feedback-totalquantity').html(totalQuantity);

				if (data.quantity == 1) {
					$('#removecartbutton' + data.product.id).prop('disabled', true);
				} else if (data.quantity == 0) {
					location.reload();
				}

				if (data.quantity <= data.product.stock) {
					$('#addcartbutton' + data.product.id).prop('disabled', false);
				}

				var itemAmount = data.totalPrice;
				var itemQuantity = data.quantity;
				var itemid = data.id;

				$('#feedback-price' + itemid).html(itemAmount);
				$('#feedback-quantity' + itemid).html(itemQuantity);
			});
		},
		
	});

}

function deletecartproduct(id) {

	$.ajax({
		type: 'DELETE',
		url: '/api/product/' + id,
		data: {
			id: id
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function(){
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function(){
				console.log("Status code 403: usuario no autorizado");
			},
			404: function() {
				console.log("Status code 404: page not found");				
			},
			405: function() {
				console.log("Status code 405: Bad HTTP request");
			},
			500: function() {
				console.log("Status code 500: server error");
			}
		},
		error: function(data) {
			location.href = data.status			
		},
		success: function() {
			if (window.confirm("Está seguro que desea eliminar este producto de su carrito?")) {
				location.reload();
			}

		},
		
	});
}

function selectCity(n){
	
	var id = $('#selectRegion-' + n).val();	
	
	console.log(id);
	
	$.ajax({
		type: 'GET',
		url: '/api/regiones/' + id,
		data: {
			id: id
		},	
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function(){
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function(){
				console.log("Status code 403: usuario no autorizado");
			},
			404: function() {
				console.log("Status code 404: page not found");				
			},
			405: function() {
				console.log("Status code 405: Bad HTTP request");
			},
			500: function() {
				console.log("Status code 500: server error");
			}
		},
		error: function(data) {
			location.href = data.status			
		},		
		success: function(data) {				
			$('#selectcityoption-' + n).prop('disabled', false);	
			$('#selectcityoption-' + n).empty();
							
			data.forEach(function(data){
				$('#selectcityoption-' + n).append('<option value =' + data.id + '>' + data.name + '</option>');
			});			
		},		
	});	
}

function getRegions(){
	
	$.ajax({
		type: 'GET',
		url: '/api/regiones',
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function(){
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function(){
				console.log("Status code 403: usuario no autorizado");
			},
			404: function() {
				console.log("Status code 404: page not found");				
			},
			405: function() {
				console.log("Status code 405: Bad HTTP request");
			},
			500: function() {
				console.log("Status code 500: server error");
			}
		},
		error: function(data) {
			location.href = data.status			
		},				
		success: function(data){
			
			$('#selectRegion-2').empty();
						
			data.forEach(function(data){
					$('#selectRegion-2').append('<option value =' + data.id + '>' + data.name + '</option>');
			});
		},
	});
}

function mostrardireccion(){
	
	var input = $('input:checked').val();
	
	if (input == 'on'){	
		$('#hiddenaddress').show();
	} else {
		$('#hiddenaddress').hide();
	}
	
	
}

function copyPasteShippingAddress(){
	
	var input = $('input:checked').val();
	var city = $('#selectcityoption-1 option:selected').html();
	var region = $('#selectRegion-1 option:selected').html();
	var calle = $('#inputtext-3').val();	
	var direccionid = $('#selectaddress').val();
	var ciudad = $('#selectcityoption-1').val();
		
	
	if (ciudad === null && input == 'on'){
		$.ajax({
			type: 'GET',
			url: `/api/address/${direccionid}`,
			data: {
				id: direccionid,
			},
			success: function(data){
								
				$('#selectRegion-2').empty();
				$('#selectRegion-2').append('<option value="' + data.region + '"></option>');
				
				$('#selectcityoption-2').empty();
				$('#selectcityoption-2').append('<option>' + data.ciudad + '</option>');
								
				$('#inputtext-6').val(data.calle);			
			},
			error: function(data){
				console.log(data.status);
			}
		
		});
	} else if (ciudad != null && input == 'on'){		
		$('#selectRegion-2').empty();
		$('#selectRegion-2').append('<option>' + region + '</option>');
		
		$('#selectcityoption-2').empty();
		$('#selectcityoption-2').append('<option>' + city + '</option>');
				
		$('#inputtext-6').val(calle);	
	
	} else {
		getRegions();
	}
	
}

function addaddress(id){
	
	var region, ciudad, calle, nombre;
	
	region = $('#selectRegion-1').val();
	ciudad = $('#selectcityoption-1').val();
	calle = $('#inputtext-3').val();
	
	if (id == 1){		
		nombre = $('#inputtext-4').val();
	} else {		
		nombre = $('#inputtext-5').val();
	}	
	
	console.log(`region: ${region}, ciudad: ${ciudad}, calle: ${calle}, nombre: ${nombre}`);
	
	$.ajax({
		type: 'POST',
		url: `/api/add/address/${region}/${ciudad}/${calle}/${nombre}`,
		data: {
			region: region,
			ciudad: ciudad,
			calle: calle,
			nombre: nombre
		},
		success: function(){
			
			location.reload();
			
		},
		error: function(data){
			console.log(data.status);
		}				
			
	})
	
	
}

var formatter = new Intl.NumberFormat('es-CL', {
	style: 'currency',
	currency: 'CLP',
	maximumFractionDigits: 0
});


