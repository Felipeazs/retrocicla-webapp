package com.retrocicla.felipeazs.exceptions;

import java.time.LocalDateTime;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.retrocicla.felipeazs.ui.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionsHandler implements ErrorController {
	
	@ExceptionHandler(value = { ClienteServiceException.class })
	public ResponseEntity<Object> handleClienteServiceException(ClienteServiceException ex, WebRequest request){
		
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getMessage());
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
	//Handler para cualquier otro tipo de excepcion no manejada
	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleOtherExceptions(Exception ex, WebRequest request){
		
		ErrorMessage errorMessage = new ErrorMessage(LocalDateTime.now(), ex.getMessage());
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);		
	}
	
}
