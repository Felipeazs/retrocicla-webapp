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
	
	@Column(name = "description", nullable=false)
    private String description;
	
	@Column(name = "wear", nullable=false)
    private String wear;

    @Column(name = "size", nullable=false)
    private String size;
    
    @Column(name = "style", nullable=false)
    private String style;
    
    @Column(name = "color", nullable=false)
    private String color;  
    
    @Column(name = "genre", nullable=true)
    private String genre;
    
    @Column(name = "unformatted_price")
    private int price;
    
    @Column(name="price", nullable=false)
    private String formatted_price;
        
    @Lob
    private String imageUrl;
    
    @Column(name="madeIn")
    private String madeIn;
    
    private int cotton;
    
    private int spandex;
    
    @Column(name="material")
    private String material;
    
    @Column(name = "season", nullable=false)
    private String season;
    
    @Column(name = "type", nullable=false)
    private String type;
    
    @Column(name = "stock", nullable=false)
    private int stock; 
 
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

	public String getWear() {
		return wear;
	}

	public void setWear(String wear) {
		this.wear = wear;
	}

	public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getFormatted_price() {
		return formatted_price;
	}

	public void setFormatted_price(String formatted_price) {
		this.formatted_price = formatted_price;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(String madeIn) {
		this.madeIn = madeIn;
	}

	public int getCotton() {
		return cotton;
	}

	public void setCotton(int cotton) {
		this.cotton = cotton;
	}

	public int getSpandex() {
		return spandex;
	}

	public void setSpandex(int spandex) {
		this.spandex = spandex;
	}

	public String getStyle() {
		return style;
	}	

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}		    
}
