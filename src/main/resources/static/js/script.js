$(document).ready(function () {	
	
	$('#messageerrorprenda').hide();
	$('#messageerrortela').hide();
	$('#messageSuccess').hide();
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
	
	$('#selecttipoprenda').change(function(){		
		
		if ($('#selecttipoprenda').val() == 'prenda'){
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
	$('#agregarprendabutton').click(function(){
		
		if (!$('#descriptionropa').val() ||
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
			!$('#imageropa').val()){
							
			$('#messageerrorprenda').show();			
			
		} else {			
			$('#agregarprendasubmit').submit();
			$('#messageSuccess').show();	
		}
	})
	
	// Formulario agregar tela
	$('#agregartelabutton').click(function(){
		
		if (!$('#descriptiontela').val() ||
			!$('#sizetela').val() ||
			!$('#colortela').val() ||
			!$('#cottontela').val() ||
			!$('#spandextela').val() ||
			!$('#madeIntela').val() ||
			!$('#pricetela').val() ||
			!$('#imagetela').val()){
							
			$('#messageerrortela').show();			
			
		} else {			
			$('#agregartelasubmit').submit();
			$('#messageSuccess').show();	
		}
	})	
	
	// Seleccion de tipos en búsqueda avanzada
	$('#types').change(function(){	
		
		if ($('#types').val() == 'prenda'){
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
	})
	
})