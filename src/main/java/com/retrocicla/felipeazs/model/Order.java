package com.retrocicla.felipeazs.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@Column(name = "product", nullable = false)
    @ElementCollection
	private List<Integer> product = new ArrayList<Integer>(); 
	
	@ManyToOne
	@JoinColumn(name = "direccion_id", nullable = false)
	private Direccion direccion;
	
	@ManyToOne
	@JoinColumn(name = "facturacion_id")
	private Facturacion facturacion;
	
	@Column(name = "createdAt")
	private LocalDate cretedAt;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;
	
	@Column(name= "total")
	private int total;
	
	@Column(name = "observaciones")
	private String observaciones;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public List<Integer> getProduct() {
		return product;
	}

	public void setProduct(List<Integer> product) {
		this.product = product;
	}

	public LocalDate getCretedAt() {
		return cretedAt;
	}

	public void setCretedAt(LocalDate cretedAt) {
		this.cretedAt = cretedAt;
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Facturacion getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}	
	
	

}
