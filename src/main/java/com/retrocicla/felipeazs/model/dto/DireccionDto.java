package com.retrocicla.felipeazs.model.dto;

public class DireccionDto {
	
	private long id;
	private String direccionId;
	private String calle;
	private String departamento;
	private String ciudad;
	private String region;
	private String tipo;
	private ClienteDto clienteDetails;
	
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
	public ClienteDto getClienteDetails() {
		return clienteDetails;
	}
	public void setClienteDetails(ClienteDto clienteDetails) {
		this.clienteDetails = clienteDetails;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

}
