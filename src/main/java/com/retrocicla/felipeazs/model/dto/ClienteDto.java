package com.retrocicla.felipeazs.model.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class ClienteDto implements Serializable {
	
	private static final long serialVersionUID = 453541656116267450L;
	private String clienteId;
	private String nombre;
	private String apellido;
	private String email;
	private String rut;
	private String telefono;
	private String password;
	private String ecryptedPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus = false;
	private List<DireccionDto> direcciones;
	private Collection<String> roles;
		
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEcryptedPassword() {
		return ecryptedPassword;
	}
	public void setEcryptedPassword(String ecryptedPassword) {
		this.ecryptedPassword = ecryptedPassword;
	}
	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}
	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	
	}
	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}
	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}
	public List<DireccionDto> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(List<DireccionDto> direcciones) {
		this.direcciones = direcciones;
	}
	public Collection<String> getRoles() {
		return roles;
	}
	public void setRoles(Collection<String> roles) {
		this.roles = roles;
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
