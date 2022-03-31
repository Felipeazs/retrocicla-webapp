package com.retrocicla.felipeazs.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.retrocicla.felipeazs.io.entity.AutoridadEntity;
import com.retrocicla.felipeazs.io.entity.ClienteEntity;
import com.retrocicla.felipeazs.io.entity.RolEntity;


public class ClientePrincipal implements UserDetails {

	private static final long serialVersionUID = -6911531710695082525L;
	
	ClienteEntity clienteEntity;

	public ClientePrincipal(ClienteEntity clienteEntity) {
		this.clienteEntity = clienteEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<GrantedAuthority> autoridades = new ArrayList<>();
		List<AutoridadEntity> autoridadesEnt = new ArrayList<>();
		
		Collection<RolEntity> roles = clienteEntity.getRoles();
		
		if (roles == null) return autoridades;
		
		roles.forEach((role) -> {
			autoridades.add(new SimpleGrantedAuthority(role.getNombre()));
			autoridadesEnt.addAll(role.getAutoridades());
		});
		
		autoridadesEnt.forEach((autoridadEnt) -> {
			autoridades.add(new SimpleGrantedAuthority(autoridadEnt.getNombre()));
		});
		
		
		return autoridades;
	}

	@Override
	public String getPassword() {
		return this.clienteEntity.getEcryptedPassword();
	}

	@Override
	public String getUsername() {
		return this.clienteEntity.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.clienteEntity.getEmailVerificationStatus();
	}

}
