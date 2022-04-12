package com.retrocicla.felipeazs.model;

public enum Fibra {
	
	NATURALES("Natural"),
	SINTETICA("Sintéticas"),
	ARTIFICIALES("Artificiales"),
	ANIMAL("Origen Animal");
	
	private String fibra;
	
	private Fibra(String fibra) {
		this.fibra = fibra;
	}

	public String getFibra() {
		return fibra;
	}

	public void setFibra(String fibra) {
		this.fibra = fibra;
	}
	
	

}
