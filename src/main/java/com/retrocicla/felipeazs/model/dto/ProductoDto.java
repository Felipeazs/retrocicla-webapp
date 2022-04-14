package com.retrocicla.felipeazs.model.dto;

import java.io.Serializable;

public class ProductoDto implements Serializable {
	
	private static final long serialVersionUID = -5369572265095232666L;
	private String productoId;		
    private String descripcion;	
    private String prenda;
    private String tamano;
    private String estilo;
    private String color; 
    private String genero;
    private int precio;
    private String formato_precio;  
    private String imageUrl;
    private String hechoEn;
    private String material;  
    private String estacion;
    private String tipo; 
    private int stock;
    private String fibra;
    private int algodon;  
    private int spandex;
    
	public String getProductoId() {
		return productoId;
	}
	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getPrenda() {
		return prenda;
	}
	public void setPrenda(String prenda) {
		this.prenda = prenda;
	}
	public String getTamano() {
		return tamano;
	}
	public void setTamano(String tamano) {
		this.tamano = tamano;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getFormato_precio() {
		return formato_precio;
	}
	public void setFormato_precio(String formato_precio) {
		this.formato_precio = formato_precio;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getHechoEn() {
		return hechoEn;
	}
	public void setHechoEn(String hechoEn) {
		this.hechoEn = hechoEn;
	}
	public int getAlgodon() {
		return algodon;
	}
	public void setAlgodon(int algodon) {
		this.algodon = algodon;
	}
	public int getSpandex() {
		return spandex;
	}
	public void setSpandex(int spandex) {
		this.spandex = spandex;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getEstacion() {
		return estacion;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getFibra() {
		return fibra;
	}
	public void setFibra(String fibra) {
		this.fibra = fibra;
	}
	
    
    

}
