package com.retrocicla.felipeazs.ui.model.request;

public class CartRequestModel {
	
	private String producto_id;
	private int quantity;
	private int price;
	private String cliente_id;	
	
	public String getPoducto_id() {
		return producto_id;
	}
	public void setProducto_id(String producto_id) {
		this.producto_id = producto_id;
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
	public String getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(String cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	

}
