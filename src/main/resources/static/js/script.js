$(document).ready(function () {	
	
	$('#messageerrorprenda').hide();
	$('#messageerrortela').hide();
	$('#messageSuccess').hide();
	$('#typeropa').val('prenda');

	
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
	
})