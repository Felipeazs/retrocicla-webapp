package com.retrocicla.felipeazs.ui.model.response;

public enum ErrorMessages {
	
	MISSING_REQUIRED_FIELD("Para agregar un cliente debe ingresar todos los campos"),
	RECORDS_ALREADY_EXIST("Los datos ya existen en la base de datos"),
	INTERNAL_SERVER_ERROR("Error interno del servidor"),
	NO_RECORD_FOUND("El cliente no existe en nuestra base de datos"),
	AUTHENTICATION_FILED("La autenticación del cliente falló"),
	COULD_NOT_UPDATE_RECORD("Los datos no fueron actualizados"),
	COULD_NOT_DETELE_RECORD("Los datos no fueron eliminados"),
	EMAIL_ADDRESS_NOT_VERIFIED("El email no fue verificado");
	
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

