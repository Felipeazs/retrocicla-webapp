package com.retrocicla.felipeazs.exceptions;

public class ProductoServiceException extends RuntimeException {

	private static final long serialVersionUID = -4520565476900627406L;
	
	public ProductoServiceException (String message) {
		super(message);
	}

}
