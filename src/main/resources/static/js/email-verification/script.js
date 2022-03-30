
 $(document).ready(function() {

    // Email-verification
        var urlParams = new URLSearchParams(location.search); 
        var verification_page = window.location.href.indexOf("email-verification");
                
        if (urlParams.has('token') && verification_page > -1){ //Busca en la url el nombre token
            
            verifyToken(urlParams.get('token'));
        }
 });


function verifyToken(tokenValue){
	
    $.get(
        '/clientes/email-verification', 
        { token: tokenValue }
        ).done(function (response) {    
                        
            if (response.operationResult === 'SUCCESS'){                    
                $('#successful-result').attr('style', 'display: block');                        
            } else {
                $('#unsuccessful-result').attr('style', 'display: block');
            }       
    	});
}