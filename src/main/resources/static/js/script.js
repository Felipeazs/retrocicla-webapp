$(document).ready(function () {	
	
	$('#tipoprenda').change(function(){
		if ($('#tipoprenda').val() == 'prenda'){
		$('#formularioprenda').show();
		console.log("mostrar");
		} else {
			$('#formularioprenda').hide();
			console.log("esconder");
		}
	});
	
		
	// Formulario agregar prenda	
	$('#messageError').hide();
	$('#messageSuccess').hide();
	
	$('#agregarbutton').click(function(){
		
		if (!$('#description').val() ||
			!$('#size').val() ||
			!$('#wear').val() ||
			!$('#style').val() ||
			!$('#color').val() ||
			!$('#genre').val() ||
			!$('#season').val() ||
			!$('#cotton').val() ||
			!$('#spandex').val() ||
			!$('#madeIn').val() ||
			!$('#price').val() ||
			!$('#image').val()){
							
			$('#messageError').show();			
			
		} else {
			$('#agregarproductsubmit').submit();
			console.log("Success!");
			$('#messageSuccess').show();	
		}
	})
	
})