package com.retrocicla.felipeazs.Exceptions;

public enum ErrorMessages {
	
	MISSING_WEAR_REQUIRED_FIELD("Para agregar una prenda a la base de datos, debe ingresar todos los campos");
	
	private String errorMessage;
	
	ErrorMessages(String errorMessage){
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	

}
