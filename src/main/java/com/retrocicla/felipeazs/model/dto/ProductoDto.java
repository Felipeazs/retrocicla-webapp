package com.retrocicla.felipeazs.model.dto;

import java.io.Serializable;
import java.util.List;

public class ProductoDto implements Serializable {
	
	private static final long serialVersionUID = -5369572265095232666L;
	private String productoId;		
    private String descripcion;	
    private String prenda;
    private String talla;
    private String estilo;
    private String color; 
    private String genero;
    private String patron;
    private int precio;
    private String formato_precio;  
    private List<String> imageUrl;
    private String origen;
    private String material;  
    private String estacion;
    private String tipo; 
    private int stock;
    private String fibra;
    private int algodon;  
    private int spandex;
    private int poliester;
    private String codigo;
    
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
	public List<String> getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(List<String> imageUrl) {
		this.imageUrl = imageUrl;
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
	
	
	public int getPoliester() {
		return poliester;
	}
	public void setPoliester(int poliester) {
		this.poliester = poliester;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	@Override
	public String toString() {
		return "genero: " + genero + " material: " + material + " talla: " + talla + " color: " + color + " patron: " + patron + " origen: " + origen + " tipo: " + tipo + " prenda: " + prenda;
	}
    

}
