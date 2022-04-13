package com.retrocicla.felipeazs.ui.model.request;

import java.util.Set;

public class CarritoRequestModel {
	
	private String clienteId;
	private String nombre;
	private String apellido;
	private String rut;
	private String telefono;
	private String email;
	private String calle;
	private String ciudad;
	private String region;
	private Set<String> productoId;
	
	
	public String getClienteId() {
		return clienteId;
	}
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Set<String> getProductoId() {
		return productoId;
	}
	public void setProductoId(Set<String> productoId) {
		this.productoId = productoId;
	}
	
	

}
