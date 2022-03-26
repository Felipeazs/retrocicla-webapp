package com.retrocicla.felipeazs.io.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "direcciones")
public class DireccionEntity implements Serializable {

	private static final long serialVersionUID = 2630756352103916307L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(length = 30, nullable = false)
	private String direccionId;
	
	@Column(length = 35, nullable = false)
	private String calle;
	
	@Column(length = 35, nullable = false)
	private String ciudad;
	
	@Column(length = 35, nullable = false)
	private String region;
	
	@Column(length = 25, nullable = false)
	private String tipo;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClienteEntity clienteDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDireccionId() {
		return direccionId;
	}

	public void setDireccionId(String direccionId) {
		this.direccionId = direccionId;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ClienteEntity getClienteDetails() {
		return clienteDetails;
	}

	public void setClienteDetails(ClienteEntity clienteDetails) {
		this.clienteDetails = clienteDetails;
	}
	
	

}
