$(document).ready(function() {

	$('#messageerrorprenda').hide();
	$('#messageerrortela').hide();
	$('#typeropa').val('prenda');
	$('#sizetelas').hide();
	$('[name=inputalertmsg]').hide();
	$('#hiddenaddress').hide();

	var wear = $('#wear').val();
	var style = $('#style').val();
	var genre = $('#genre').val();
	var season = $('#season').val();

	// Selección de formulario para agregar prenda o tela
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

	var tipo = $('#types').val();

	$('#types').change(function() {
		if (tipo === 'prenda') {
			$('#sizeropa').show();
			$('#sizetelas').hide();
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

	precio_total();

	var precios_totales = $('#format_precio_total').html();
	var formato_precio = formatter.format(precios_totales)
	$('#format_precio_total').html(formato_precio);

	var precios_envio = $('#format_precio_envio').html();
	var formato_precio = formatter.format(precios_envio)
	$('#format_precio_envio').html(formato_precio);

	var total_envio = $('#format_total_envio').html();
	var formato_precio = formatter.format(total_envio);
	$('#format_total_envio').html(formato_precio);

	$('.galeria-cell').mouseover(function() {
		$(this).find('i').css('display', 'inline');
	});

	$('.galeria-cell').mouseleave(function() {
		$(this).find('i').css('display', 'none');
	});

	$('.dropdown-submenu a.test').on('click', function() {
		$(this).next('ul').toggle();
	});

	var pathname = window.location.pathname;
	console.log(pathname);

	if (pathname === '/redirigiendo') {
		setTimeout(function() {
			window.location.href = "/";
		}, 3000);
	}

	var redirigir = $('#_carrito').html();
	console.log("tamaño carrito: " + redirigir);

	if (pathname === '/informacion-usuario' && redirigir == 0 ||
		pathname === '/carrito' && redirigir == 0 ||
		pathname === '/informacion-envio' && redirigir == 0 ||
		pathname === '/informacion-pago' && redirigir == 0) {
		setTimeout(function() {
			window.location.href = "/";
		}, 3000);
	}

	// Tootltips
	var tooltipTriggerList = [].slice.call(
		document.querySelectorAll('[data-bs-toggle="tooltip"]')
	);
	var tooltipList = tooltipTriggerList.map(function(tooltipTriggerEl) {
		return new bootstrap.Tooltip(tooltipTriggerEl);
	});

	//Modal
	var myModal = document.getElementById('myModal')
	var myInput = document.getElementById('myInput')	

	if (myModal) {
		myModal.addEventListener('shown.bs.modal', function() {
			myInput.focus()
		})
	}

	var location = window.location.pathname;
	var direcciones = $('#misdirecciones').val();

	if (location === '/checkout') {
		if (direcciones == 0) {
			selectCity(1);
			selectCity(2);
		}
	}

	//TENSOR-FLOW
	const image_drop_area = document.querySelector("#image_drop_area");
	const image = document.querySelector("#image");
	const description = document.getElementById("prediction");
	
	//const URL = "https://teachablemachine.withgoogle.com/models/Wkxz3KIZ8/";
	const URL = "/model/"

    let model, labelContainer, maxPredictions;

	if (image_drop_area){
		image_drop_area.addEventListener('dragover', (event) => {
		event.stopPropagation();
		event.preventDefault();
		event.dataTransfer.dropEffect = 'copy';
	});
		image_drop_area.addEventListener('drop', (event) => {
			event.stopPropagation();
			event.preventDefault();
			const fileList = event.dataTransfer.files;
			readImage(fileList[0]);
		});
	}
	readImage = (file) => {
		const reader = new FileReader();
		reader.addEventListener('load', (event) => {
			const dataUrl = event.target.result;
			const imageElement = new Image();
			imageElement.src = dataUrl;
			imageElement.onload = function() {
				image.setAttribute("src", this.src);
				image.setAttribute("height", "300px");
				image.setAttribute("width", "300px");

				classifyImage();
			};
			/*document.querySelector("#image_drop_area").style.backgroundImage = `url(${uploaded_image})`;*/
		});
	reader.readAsDataURL(file);
	}
	
	async function classifyImage() {
		const modelURL = URL + "model.json";
        const metadataURL = URL + "metadata.json";
        
        model = await tmImage.load(modelURL, metadataURL);
        maxPredictions = model.getTotalClasses();
        
        await predict();
		
	}
	
	async function predict() {
        // predict can take in an image, video or canvas html element
       const predictions = await model.predict(image);
       console.log(predictions);
       for (let i = 0; i < maxPredictions; i++) {
            const classPrediction = predictions[i].className + ": " + predictions[i].probability.toFixed(2);
            console.log(classPrediction);
       }     
        displayDescription(predictions);
    }
	
	function displayDescription(predictions) {
	  // Sort by probability
	  const result = predictions.sort((a, b) => a.probability - b.probability)[2];
	  console.log(result);
	  if (result.probability > 0.2) {
	    const probability = Math.round(result.probability * 100);
	    console.log("probabilidad: " + probability);
	
	    // Display result
	    description.innerText = `${probability}% shure this is a ${result.className.replace(
	      ",",
	      " or"
	    )} 🐶`;
	  } else description.innerText = "I am not shure what I should recognize 😢";
	}
	
	//FIN TENSOR-FLOW
});



function reset_radios() {
	$('input[type=radio]').prop('checked', false);
}
function precio_total() {
	var cantidad = $('#cantidad_input').val();
	var precio = $('#_precio').val();
	var total = 0;

	if (cantidad >= 1) {
		total = cantidad * precio;
	}

	$('#cantidad_carrito').html(cantidad);
	$('[name="precio"]').html(formatter.format(total));
	$('#total').val(formatter.format(total));
}
function restar_cantidad() {
	var cantidad = $('#cantidad_input').val();
	var precio = $('#_precio').val();
	var total = 0;

	if (cantidad >= 1) {
		cantidad--;
		total = cantidad * precio;

		$('[name="cantidad"]').val(cantidad);
		$('#cantidad_carrito').html(cantidad);
		$('[name="precio"]').html(formatter.format(total));
		$('#total').val(formatter.format(total));
	}
}
function sumar_cantidad() {
	var cantidad = $('#cantidad_input').val();
	var precio = $('#_precio').val();
	var total = 0;

	if (cantidad >= 0) {
		cantidad++;
		total = cantidad * precio;

		$('[name="cantidad"]').val(cantidad);
		$('#cantidad_carrito').html(cantidad);
		$('[name="precio"]').html(formatter.format(total));
		$('#total').val(formatter.format(total));
	}
}
function buscarProductos() {

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var tipo = $('[name="_tipo"]:checked').val();
	if (typeof tipo === 'undefined') {
		tipo = 'vacio';
	}

	var prenda = $('[name="_prenda"]:checked').val();
	if (typeof prenda === 'undefined') {
		prenda = 'vacio';
	}
	var genero = $('[name="_genero"]:checked').val();
	if (typeof genero === 'undefined') {
		genero = 'vacio';
	}

	var material = $('[name="_material"]:checked').val();
	if (typeof material === 'undefined') {
		material = 'vacio';
	}

	var talla = $('[name="_talla"]:checked').val();
	if (typeof talla === 'undefined') {
		talla = 'vacio';
	}

	var color = $('[name="_color"]:checked').val();
	if (typeof color === 'undefined') {
		color = 'vacio';
	}

	var patron = $('[name="_patron"]:checked').val();
	if (typeof patron === 'undefined') {
		patron = 'vacio';
	}

	var origen = $('[name="_origen"]:checked').val();
	if (typeof origen === 'undefined') {
		origen = 'vacio';
	}

	var data = {
		"genero": genero,
		"material": material,
		"talla": talla,
		"color": color,
		"patron": patron,
		"origen": origen,
		"tipo": tipo,
		"prenda": prenda
	};

	console.log(data);

	$.ajax({
		type: 'GET',
		url: '/productos/buscar',
		data: {
			"genero": genero,
			"material": material,
			"talla": talla,
			"color": color,
			"patron": patron,
			"origen": origen,
			"tipo": tipo,
			"prenda": prenda
		},
		dataType: 'json',
		contentType: "application/json; charset=utf-8",
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request");
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
				location.href = "/login";
			},
			403: function() {
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
			console.log(data);

			$('#productos_encontrados').empty();
			$('.sub-columna-2').empty();

			$('.sub-columna-2').append(
				'<h3 class="fw-bold">Todos</h3>');

			data.forEach(function(info) {
				$('#productos_encontrados').append(
					'<div class="col-md-4 galeria-materiales">' +
					'<a href="/item/' + info.productoId + '">' +
					'<div class="galeria-cell">' +
					'<img class="img-responsive"src="/img/catalogo/' + info.imageUrl[0] + '"alt=""/>' +
					'<i class="fa-solid fa-bag-shopping fa-2x"></i>' +
					'</div></a>' +
					'<div class="row">' +
					'<div class="col-sm-12 col-md-12 ps-4 item">' +
					'<div><span>' + info.descripcion + '</span></div>' +
					'<div>' +
					'<span class="fs-5">Material: </span><span>' + info.material + '</span>' +
					'</div><div>' +
					'<span class="fs-5">Talla: </span>' +
					'<span class="fs-5">' + info.talla + '</span>' +
					'</div><div>' +
					'<strong class="fs-3">' + info.formato_precio + '</strong>' +
					'</div></div></div>'

				);
			});
		}

	});

}

function agregarProductoDirecto() {

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var productoId = $('#productoId').val();
	var total = $('#total').val();
	var cantidad = $('#cantidad_input').val();
	var imageUrl = $('#imageUrl').val();
	var material = $('#material').val();
	var descripcion = $('#descripcion').val();

	var data = {
		"productoId": productoId,
		"total": total,
		"cantidad": cantidad,
		"imageUrl": imageUrl,
		"material": material,
		"descripcion": descripcion,
	};

	$.ajax({
		type: 'POST',
		url: '/carritos',
		data: JSON.stringify(data),
		dataType: 'json',
		contentType: "application/json; charset=utf-8",
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request");
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
				location.href = "/login";
			},
			403: function() {
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

			console.log(data.length);
			$('#producto_agregado').html("Producto agregado al carrito");
			$('#tamano_carrito').html(data.length);


		},

	});
}

function agregarProductoAlCarrito() {

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var productoId = $('#productoId').val();
	var total = $('#total').val();
	var cantidad = $('#cantidad_input').val();
	var imageUrl = $('#imageUrl').val();
	var material = $('#material').val();
	var descripcion = $('#descripcion').val();

	var data = {
		"productoId": productoId,
		"total": total,
		"cantidad": cantidad,
		"imageUrl": imageUrl,
		"material": material,
		"descripcion": descripcion,
	};

	$.ajax({
		type: 'POST',
		url: '/carritos',
		data: JSON.stringify(data),
		dataType: 'json',
		contentType: "application/json; charset=utf-8",
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request");
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
				location.href = "/login";
			},
			403: function() {
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
		success: function() {
			window.location.href = "/informacion-usuario";

		},

	});

}

function eliminarDelCarrito(productoId) {

	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	$.ajax({
		type: 'DELETE',
		url: '/carritos/' + productoId,
		data: {
			"productoId": productoId
		},
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);

		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request");
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function() {
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
		error: function() {
			//location.href = data.status
			console.log(data);
		},
		success: function() {
			location.reload();
		}
	});



}


function direccionCliente(clienteId) {

	var direcciones = $('#_direcciones').val();

	$.ajax({
		type: 'GET',
		url: '/clientes/' + clienteId,
		data: {
			cliente: clienteId,
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
				location.href = "/login";
			},
			403: function() {
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
		},
		success: function(data) {
			$('#_region').val('');
			data.direcciones.forEach(function(info) {
				if (info.tipo === direcciones) {
					$('#_region').val(info.region);
					$('#_calle').val(info.calle);
					$('#_ciudad').val(info.ciudad);
					$('#_departamento').val(info.departamento);
				}

			});


		},

	});
}

function registrarProducto() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");

	var descripcion = $('input[name="descripcion"]').val();
	var prenda = $('[name="prenda"] option:selected').val();
	var talla = $('[name="talla"] option:selected').val();
	var estilo = $('[name="estilo"] option:selected').val();
	var color = $('[name="color"] option:selected').val();
	var genero = $('[name="genero"] option:selected').val();
	var precio = $('input[name="precio"]').val();
	var material = $('[name="material"] option:selected').val();
	var fibra = $('[name="fibra"] option:selected').val();
	var estacion = $('[name="estacion"] option:selected').val();
	var tipo = $('[name="tipo"] option:selected').val();
	var stock = $('input[name="stock"]').val();
	var patron = $('[name="patron"] option:selected').val();
	var origen = $('[name="origen"] option:selected').val();

	var imagen = [];
	$('input[name="imagen"]').each(function() {
		if ($.trim(this.value).length) {
			imagen.push($(this).val());
		}
	});

	var data = {
		"descripcion": descripcion,
		"prenda": prenda,
		"talla": talla,
		"estilo": estilo,
		"color": color,
		"genero": genero,
		"precio": precio,
		"imageUrl": imagen,
		"material": material,
		"fibra": fibra,
		"estacion": estacion,
		"tipo": tipo,
		"stock": stock,
		"patron": patron,
		"origen": origen
	};

	console.log(data);

	$.ajax({
		type: 'POST',
		url: '/productos',
		data: JSON.stringify(data),
		dataType: 'json',
		contentType: "application/json; charset=utf-8",
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request");
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
				location.href = "/login";
			},
			403: function() {
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
			console.log(data);
			location.reload();

		},

	});
}



function submitnewpassword() {

	var urlParams = new URLSearchParams(location.search);

	if (!urlParams.has('token') || isEmpty(urlParams.get('token'))) {
		alert("El token no existe");
		return;
	}

	var tokenValue = urlParams.get('token');

	var password1 = $('#password1').val();
	var password2 = $('#password2').val();

	if (isEmpty(password1)) {
		alert("Ingrese la nueva contraseña");
		return;
	}

	if (password1 !== password2) {
		alert("Las contraseñas no coinciden");
		return
	}

	$.ajaxSetup({
		"contentType": "application/json"
	});

	var data = {
		"token": tokenValue,
		"password": password1
	};

	$.post(
		'/clientes/password-reset', JSON.stringify(data))
		.done(function(response) {
			$('#password1').val('');
			$('#password2').val('');

			if (response.operationResult === 'SUCCESS') {
				$('#successful-result').attr('style', 'display: block');
			} else {
				$('#unsuccessful-result').attr('style', 'display: block');
			}

		});

}

function isEmpty(str) {
	return (!str || 0 === str.trim().length);
}

function btnregistrar() {
	if ($('#pass').val() != $('#pass2').val()) {
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

		if (id === 'email') {
			var rex = regex.test(input);
			if (!rex) {
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

function actualizarProductoEnCarrito(id) {

	$.ajax({
		type: 'POST',
		url: 'sdfsdf/sdfsdf',
		data: {
			id: id
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
				window.location.href = "/login";
			},
			403: function() {
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
		error: function(XMLHttpRequest, textStatus, errorThrown) {
			console.log(XMLHttpRequest);
			console.log(textStatus);
			console.log(errorThrown);
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





function obtenerCantidadYPrecioTotal(clienteId) {

	$.ajax({
		type: 'GET',
		url: '/carrito/' + clienteId,
		data: {
			cliente: clienteId,
		},
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
				location.href = "/login";
			},
			403: function() {
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
		},
		success: function(data) {

			console.log(data)

			$('[name=feedback-totalprice]').html(data.totalprice);
			$('#feedback-totalquantity').html(data.quantity);
		},

	});
}

function removecartproductitem(id) {

	console.log(id);

	$.ajax({
		type: 'PUT',
		url: '/carrito/restar/' + id,
		data: {
			producto: id
		},
		statusCode: {
			0: function() {
				console.log("failed to load resource");
			},
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
				window.location.href = "/login";
			},
			403: function() {
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
			if (data.status == 401) {
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


function selectCity(n) {

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
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function() {
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

			data.forEach(function(data) {
				$('#selectcityoption-' + n).append('<option value =' + data.id + '>' + data.name + '</option>');
			});
		},
	});
}

function getRegions() {

	$.ajax({
		type: 'GET',
		url: '/api/regiones',
		statusCode: {
			200: function() {
				console.log("Status code 200: succesful request")
			},
			401: function() {
				console.log("Status code 401: Usuario no autenticado");
			},
			403: function() {
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

			$('#selectRegion-2').empty();

			data.forEach(function(data) {
				$('#selectRegion-2').append('<option value =' + data.id + '>' + data.name + '</option>');
			});
		},
	});
}

function mostrardireccion() {

	var input = $('input:checked').val();

	if (input == 'on') {
		$('#hiddenaddress').show();
	} else {
		$('#hiddenaddress').hide();
	}


}

function copyPasteShippingAddress() {

	var input = $('input:checked').val();
	var city = $('#selectcityoption-1 option:selected').html();
	var region = $('#selectRegion-1 option:selected').html();
	var calle = $('#inputtext-3').val();
	var direccionid = $('#selectaddress').val();
	var ciudad = $('#selectcityoption-1').val();


	if (ciudad === null && input == 'on') {
		$.ajax({
			type: 'GET',
			url: `/api/address/${direccionid}`,
			data: {
				id: direccionid,
			},
			success: function(data) {

				$('#selectRegion-2').empty();
				$('#selectRegion-2').append('<option value="' + data.region + '"></option>');

				$('#selectcityoption-2').empty();
				$('#selectcityoption-2').append('<option>' + data.ciudad + '</option>');

				$('#inputtext-6').val(data.calle);
			},
			error: function(data) {
				console.log(data.status);
			}

		});
	} else if (ciudad != null && input == 'on') {
		$('#selectRegion-2').empty();
		$('#selectRegion-2').append('<option>' + region + '</option>');

		$('#selectcityoption-2').empty();
		$('#selectcityoption-2').append('<option>' + city + '</option>');

		$('#inputtext-6').val(calle);

	} else {
		getRegions();
	}

}

function addaddress(id) {

	var region, ciudad, calle, nombre;

	region = $('#selectRegion-1').val();
	ciudad = $('#selectcityoption-1').val();
	calle = $('#inputtext-3').val();

	if (id == 1) {
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
		success: function() {

			location.reload();

		},
		error: function(data) {
			console.log(data.status);
		}

	})
}

function btncomprar() {

}

var formatter = new Intl.NumberFormat('es-CL', {
	style: 'currency',
	currency: 'CLP',
	maximumFractionDigits: 0
});
