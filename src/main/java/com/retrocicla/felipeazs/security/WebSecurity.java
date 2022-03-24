package com.retrocicla.felipeazs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.retrocicla.felipeazs.service.ClienteSecurityService;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
    private ClienteSecurityService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;  
    
    public WebSecurity(ClienteSecurityService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	protected void configure(HttpSecurity http) throws Exception {   
        http 	
        .csrf().disable()
		.authorizeRequests()
		.antMatchers(
				HttpMethod.POST, SecurityConstants.SIGN_UP_URL)
		.permitAll()
		.anyRequest()
		.authenticated()
		.and().addFilter(getAuthenticationFilter())
		.addFilter(new AuthorizationFilter(authenticationManager()))
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS); //Elimina las cookies generadas
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
        
    }
	
	//Modifica la URL del login
	public AuthenticationFilter getAuthenticationFilter() throws Exception {
		final AuthenticationFilter filter = new AuthenticationFilter(authenticationManager());
		filter.setFilterProcessesUrl("/clientes/login");
		
		return filter;
	}

//	@Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/*", "/js/**", "/img/**");
//    }
    


}
