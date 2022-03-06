package com.retrocicla.felipeazs.model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	
	@Column(name = "description")
    private String description;
	
	@Column(name = "wear")
    private String wear;

    @Column(name = "size")
    private String size;
    
    @Column(name = "style")
    private String style;
    
    @Column(name = "color")
    private String color;  
    
    @Column(name = "genre")
    private String genre;

    @Column(name = "price")
    private Double price;
    
    @Column(name = "imageUrl")
    private String image_url;
    
    @Column(name = "madeIn")
    private String made_in;
    
    @Column(name = "cotton")
    private int cotton;
    
    @Column(name = "spandex")
    private int spandex;
    
    @Column(name = "season")
    private String season;

    

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
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
	
	public ArrayList<String> listingWears(){
		ArrayList<String> wears = new ArrayList<>();
		wears.add("polera");
		wears.add("pantalón");
		return  wears;
	}
	
	public ArrayList<String> listingStyles(){
		ArrayList<String> styles = new ArrayList<>();
		styles.add("Deportivo");
		styles.add("Casual");
		return  styles;
	}
	
	
	    
}
