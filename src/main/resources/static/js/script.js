$(document).ready(function () {	
	
	$('#message').hide();
	
	$('#agregarbutton').click(function(){
		
		if (!$('#description').val()){
							
			$('#message').show();
			
			console.log($('#description').val());
			console.log($('#style').val());
			
		} else {
			$('#agregarproductsubmit').submit();
		}
	})
	
})

 
/*||
			$.trim($('#size').html())=='' ||
			$.trim($('#wear').html())=='' ||
			$.trim($('#style').html())=='' ||
			$.trim($('#color').html())=='' ||
			$.trim($('#genre').html())=='' ||
			$.trim($('#season').html())=='' ||
			$.trim($('#cotton').html())=='' ||
			$.trim($('#spandex').html())=='' ||
			$.trim($('#madeIn').html())=='' ||
			$.trim($('#price').html())=='' ||
			$.trim($('#image').html())==''*/