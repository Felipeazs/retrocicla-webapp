package com.retrocicla.felipeazs.exceptions;

public class ProductServiceException extends RuntimeException {

	private static final long serialVersionUID = -4520565476900627406L;
	
	public ProductServiceException (String message) {
		super(message);
	}

}
