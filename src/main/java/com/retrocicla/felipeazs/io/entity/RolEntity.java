package com.retrocicla.felipeazs.io.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class RolEntity implements Serializable {
	
	private static final long serialVersionUID = 2646464945583928542L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false, length = 20)
	private String nombre;
	
	@ManyToMany(mappedBy = "roles")
	private Collection<ClienteEntity> clientes;
	
	@ManyToMany(
			cascade = { CascadeType.PERSIST }, 
			fetch = FetchType.EAGER)
	@JoinTable(
			name = "roles_autoridades", 
			joinColumns = @JoinColumn(
					name = "roles_id",
					referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name = "autoridades_id", 
					referencedColumnName = "id"))		
	private Collection<AutoridadEntity> autoridades;

	public RolEntity() {
		super();
	}

	public RolEntity(String nombre) {
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

	public Collection<ClienteEntity> getClientes() {
		return clientes;
	}

	public void setClientes(Collection<ClienteEntity> clientes) {
		this.clientes = clientes;
	}

	public Collection<AutoridadEntity> getAutoridades() {
		return autoridades;
	}

	public void setAutoridades(Collection<AutoridadEntity> autoridades) {
		this.autoridades = autoridades;
	}
	
	

}
