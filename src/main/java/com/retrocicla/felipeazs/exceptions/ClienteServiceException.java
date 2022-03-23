package com.retrocicla.felipeazs.exceptions;

public class ClienteServiceException extends RuntimeException {

	private static final long serialVersionUID = -3247316911954932661L;
	
	public ClienteServiceException (String message) {
		super(message);
	}

}
