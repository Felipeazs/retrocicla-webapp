package com.retrocicla.felipeazs.io.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "clientes")
public class ClienteEntity implements Serializable {

	private static final long serialVersionUID = -9204157251773026258L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String clienteId;
	
	@Column(nullable = false, length = 50)
	private String nombre;
	
	@Column(nullable = false, length = 50)
	private String apellido;
	
	@Column(nullable = false, length = 120, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String ecryptedPassword;
	
	private String emailVerificationToken;
	
	@Column(nullable = false)
	private Boolean emailVerificationStatus = false;
	
	@OneToMany(mappedBy = "clienteDetails", cascade = CascadeType.ALL)
	private List<DireccionEntity> direcciones; 

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public List<DireccionEntity> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<DireccionEntity> direcciones) {
		this.direcciones = direcciones;
	}

}
