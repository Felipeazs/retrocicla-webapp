package com.retrocicla.felipeazs.model.dto;

import java.io.Serializable;

public class ProductDto implements Serializable {
	
	private static final long serialVersionUID = -5369572265095232666L;
	private String productid;		
    private String description;	
    private String wear;
    private String size;
    private String style;
    private String color; 
    private String genre;
    private int price;
    private String formatted_price;  
    private String imageUrl;
    private String madeIn;
    private int cotton;  
    private int spandex;
    private String material;  
    private String season;
    private String type; 
    private int stock;
    
	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public String getStyle() {
		return style;
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
	public String getMadeIn() {
		return madeIn;
	}
	public void setMade(String madeIn) {
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
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
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
