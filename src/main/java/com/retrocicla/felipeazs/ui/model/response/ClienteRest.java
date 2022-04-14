package com.retrocicla.felipeazs.ui.model.response;

import java.util.List;

public class ClienteRest {
	
	private String clienteId;
	private String nombre;
	private String apellido;
	private String email;
	private String rut;
	private String telefono;
	private List<DireccionRest> direcciones;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<DireccionRest> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<DireccionRest> direcciones) {
		this.direcciones = direcciones;
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
	

}
