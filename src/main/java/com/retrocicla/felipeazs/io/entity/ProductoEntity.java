package com.retrocicla.felipeazs.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class ProductoEntity implements Serializable {

	private static final long serialVersionUID = 9111711165715337808L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private int id;
	
	private String productoId;
	
	@Column(name = "descripcion", nullable=false)
    private String descripcion;
	
	@Column(name = "prenda", nullable=false)
    private String prenda;

    @Column(name = "talla", nullable=false)
    private String talla;
    
    @Column(name = "estilo", nullable=false)
    private String estilo;
    
    @Column(name = "color", nullable=false)
    private String color;  
    
    @Column(name = "patron", nullable=false)
    private String patron;  
    
    @Column(name = "genero", nullable=true)
    private String genero;
    
    @Column(name = "precio")
    private int precio;
    
    @Column(name="formato_precio", nullable=false)
    private String formato_precio;
        
    @Lob
    private String imageUrl;
    
    @Column(name="origen")
    private String origen;
        
    @Column(name="material")
    private String material;
    
    @Column(name = "estacion")
    private String estacion;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "stock")
    private int stock; 
    
    @Column
    private String fibra;
    
    private int algodon;
    
    private int poliester;
    
    private int spandex;
    
    private String codigo;
 
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getProductoId() {
		return productoId;
	}

	public void setProductoId(String productoId) {
		this.productoId = productoId;
	}

	public String getPrenda() {
		return prenda;
	}

	public void setPrenda(String prenda) {
		this.prenda = prenda;
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public String getEstilo() {
		return estilo;
	}	
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
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

	public String getEstacion() {
		return estacion;
	}

	public void setEstacion(String estacion) {
		this.estacion = estacion;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getPoliester() {
		return poliester;
	}

	public void setPoliester(int poliester) {
		this.poliester = poliester;
	}	
	
	
	
}
