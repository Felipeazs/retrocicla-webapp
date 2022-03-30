package com.retrocicla.felipeazs.io.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autoridades")
public class AutoridadEntity implements Serializable{
	
	private static final long serialVersionUID = 1346268343793532418L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 20)
	private String nombre;
	
	@ManyToMany(mappedBy = "autoridades")
	private Collection<RolEntity> roles;

	public AutoridadEntity(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<RolEntity> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolEntity> roles) {
		this.roles = roles;
	}
	
	

}
