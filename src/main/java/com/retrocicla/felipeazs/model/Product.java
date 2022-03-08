package com.retrocicla.felipeazs.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "product")
public class Product implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 9111711165715337808L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(name = "description", nullable=false)
    private String description;
	
	@Column(name = "wear", nullable=true)
    private String wear;

    @Column(name = "size", nullable=false)
    private String size;
    
    @Column(name = "style", nullable=true)
    private String style;
    
    @Column(name = "color", nullable=false)
    private String color;  
    
    @Column(name = "genre", nullable=true)
    private String genre;
    
    @Transient
    private int price;
    
    @Column(name="price", nullable=false)
    private String formatted_price;
        
    @Column(name = "imageUrl", nullable=false)
    private String image_url;
    
    @Column(name = "madeIn", nullable=false)
    private String made_in;
    
    @Column(name = "cotton", nullable=false)
    private int cotton;
    
    @Column(name = "spandex", nullable=false)
    private int spandex;
    
    @Column(name="material")
    private String material;
    
    @Column(name = "season", nullable=true)
    private String season;
    
    @Column(name = "type", nullable=false)
    private String type;

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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMade_in() {
		return made_in;
	}

	public void setMade_in(String made_in) {
		this.made_in = made_in;
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

	public ArrayList<String> listingWears(){
		ArrayList<String> wears = new ArrayList<>();
		wears.add("polera");
		wears.add("parka");
		wears.add("camisa");
		wears.add("pantalón");
		return  wears;
	}
	
	public ArrayList<String> listingStyles(){
		ArrayList<String> styles = new ArrayList<>();
		styles.add("deportivo");
		styles.add("casual");
		styles.add("outdoor");
		return  styles;
	}
	
	public ArrayList<String> listingSeasons(){
		ArrayList<String> styles = new ArrayList<>();
		styles.add("otoño-invierno");
		styles.add("primavera-verano");
		return  styles;
	}

	public ArrayList<String> listingMaterials(){
		ArrayList<String> materials = new ArrayList<>();
		materials.add("algodón");
		materials.add("spandex");
		return  materials;
	}
	
	public ArrayList<String> listingTypes(){
		ArrayList<String> types = new ArrayList<>();
		types.add("ropa");
		types.add("tela");
		return  types;
	}

	public ArrayList<String> listingColors(){
		ArrayList<String> colors = new ArrayList<>();
		colors.add("negro");
		colors.add("azul");
		return  colors;
	}
	
	public ArrayList<String> listingGenres(){
		ArrayList<String> genres = new ArrayList<>();
		genres.add("masculino");
		genres.add("femenino");
		genres.add("unisex");
		return  genres;
	}	
	    
}
