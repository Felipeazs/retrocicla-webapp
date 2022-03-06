//package com.retrocicla.felipeazs.service;
//
//import com.retrocicla.model.Client;
//import com.retrocicla.repository.ClientRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//
//@Service
//public class ClientDetailsService implements UserDetailsService {
//
//    @Autowired
//    private ClientRepository repo;
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//
//        Client client = repo.findByEmail(email);
//        if (client == null) throw new UsernameNotFoundException(email);
//
//        ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
//        roles.add(new SimpleGrantedAuthority(client.getRole()));
//
//        UserDetails userDt = new User(client.getEmail(), client.getEncryptedPass(), roles);
//
//        return userDt;
//    }
//}
