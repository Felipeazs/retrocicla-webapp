package com.retrocicla.felipeazs.exceptions;

public class CartServiceException extends RuntimeException {

	private static final long serialVersionUID = -4520565476900627406L;
	
	public CartServiceException (String message) {
		super(message);
	}

}
