package com.retrocicla.felipeazs.model.dto;

import java.time.LocalDate;

import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.ProductEntity;

public class CartDto {
	
	private LocalDate createdAt;
	private ProductEntity producto;
	private int quantity;
	private int price;
	private String totalPrice;
	private ClienteEntity cliente;
	
	public LocalDate getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	public ProductEntity getProducto() {
		return producto;
	}
	public void setProducto(ProductEntity producto) {
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
	public ClienteEntity getCliente() {
		return cliente;
	}
	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}
	
	

}
