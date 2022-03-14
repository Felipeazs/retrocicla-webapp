package com.retrocicla.felipeazs.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "checkorder")
public class Order implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1595203398992918048L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "checkorder_id")
	private List<Cart> cart;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "facturacion")
	private String facturacion;
	
	@Column(name = "createdAt")
	private String cretedAt;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Cart> getCart() {
		return cart;
	}

	public void setCart(List<Cart> cart) {
		this.cart = cart;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCretedAt() {
		return cretedAt;
	}

	public void setCretedAt(String cretedAt) {
		this.cretedAt = cretedAt;
	}

	public String getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(String facturacion) {
		this.facturacion = facturacion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	
	

}
