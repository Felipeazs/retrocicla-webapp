package com.retrocicla.felipeazs.service;

import com.retrocicla.felipeazs.model.Cliente;
import com.retrocicla.felipeazs.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ClientDetailsService implements UserDetailsService {

    @Autowired
    private ClienteRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Cliente cliente = repo.findByEmail(email);
        if (cliente == null) throw new UsernameNotFoundException(email);

        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(cliente.getRol()));

        UserDetails userDt = new User(cliente.getEmail(), cliente.getEncpass(), roles);

        return userDt;
    }
}
