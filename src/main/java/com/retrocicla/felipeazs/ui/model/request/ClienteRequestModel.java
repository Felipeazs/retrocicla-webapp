package com.retrocicla.felipeazs.ui.model.request;

import java.util.List;

public class ClienteRequestModel {
	
	private String nombre;
	private String apellido;
	private String rut;
	private String telefono;
	private String email;
	private String password;
	private List<DireccionRequestModel> direcciones;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<DireccionRequestModel> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<DireccionRequestModel> direcciones) {
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
