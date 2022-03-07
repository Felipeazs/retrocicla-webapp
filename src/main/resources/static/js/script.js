$(document).ready(function () {	
	
	$('#message').hide();
	
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
							
			$('#message').show();
			
			console.log($('#season').val());
			
		} else {
			$('#agregarproductsubmit').submit();
		}
	})
	
})