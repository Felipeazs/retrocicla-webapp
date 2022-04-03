package com.retrocicla.felipeazs.ui.model.response;

import java.time.LocalDate;

public class CarritoRest {
	
	private LocalDate createdAt;
	private ProductoRest producto;
	private int quantity;
	private int price;
	private String totalPrice;
	private ClienteRest cliente;
	
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public ProductoRest getProducto() {
		return producto;
	}
	public void setProducto(ProductoRest  producto) {
		this.producto = producto;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ClienteRest getCliente() {
		return cliente;
	}
	public void setCliente(ClienteRest cliente) {
		this.cliente = cliente;
	} 

}