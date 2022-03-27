package com.retrocicla.felipeazs.io.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "password_reset_token")
public class PasswordResetTokenEntity implements Serializable{

	private static final long serialVersionUID = -6282409085105134148L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String token;
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private ClienteEntity clienteDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public ClienteEntity getClienteDetails() {
		return clienteDetails;
	}

	public void setClienteDetails(ClienteEntity clienteDetails) {
		this.clienteDetails = clienteDetails;
	}
	
	
	
	

}
