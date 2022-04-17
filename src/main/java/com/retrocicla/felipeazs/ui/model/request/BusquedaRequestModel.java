package com.retrocicla.felipeazs.ui.model.request;

public class BusquedaRequestModel {
	
	private String genero;
	private String material;
	private String talla;
	private String color;
	private String patron;
	private String origen;
	private String tipo;
	private String prenda;
	
	public BusquedaRequestModel(String genero, String material, String talla, String color, String patron,
			String origen, String tipo, String prenda) {
		super();
		this.genero = genero;
		this.material = material;
		this.talla = talla;
		this.color = color;
		this.patron = patron;
		this.origen = origen;
		this.tipo = tipo;
		this.prenda = prenda;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public String getPatron() {
		return patron;
	}
	public void setPatron(String patron) {
		this.patron = patron;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String getPrenda() {
		return prenda;
	}
	public void setPrenda(String prenda) {
		this.prenda = prenda;
	}
	@Override
	public String toString() {
		return "genero: " + genero + " material: " + material + " talla: " + talla + " color: " + color + " patron: " + patron + " origen: " + origen + " tipo: " + tipo + " prenda: " + prenda;
	}
	
	
	
	
	
	
	

}
