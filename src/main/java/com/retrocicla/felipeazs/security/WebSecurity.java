package com.retrocicla.felipeazs.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.retrocicla.felipeazs.io.repository.ClienteRepository;
import com.retrocicla.felipeazs.service.ClienteSecurityService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)// Method security
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
    private ClienteSecurityService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;  
    private final ClienteRepository clienteRepo;
    
    public WebSecurity(ClienteSecurityService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder, ClienteRepository clienteRepo) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.clienteRepo = clienteRepo;
	}

	protected void configure(HttpSecurity http) throws Exception {   
        http 	 
        //.csrf().disable()
		.authorizeRequests()		
		.antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
		.antMatchers(HttpMethod.GET, SecurityConstants.VERIFICATION_EMAIL_URL).permitAll()
		.antMatchers(HttpMethod.GET, SecurityConstants.GET_PRODUCTS_URL).permitAll()
		.antMatchers(HttpMethod.POST, SecurityConstants.PASSWORD_RESET_REQUEST_URL).permitAll()
		.antMatchers(HttpMethod.POST, SecurityConstants.PASSWORD_RESET_URL).permitAll()
		.antMatchers(HttpMethod.GET, "/productos/**").permitAll()
		//.antMatchers(HttpMethod.DELETE, "/clientes/**").hasRole("ADMIN")
		.antMatchers("/swagger-ui/**", "/api-docs")
		.permitAll()
		.antMatchers("/css/**", "/js/**", "/img/**")
		.permitAll()
		.antMatchers(
				"/",
				"/somos",
				"/tienda",	
				"/catalogo/**",
				"/busqueda-avanzada",
				"/item/**",
				"/detalle-item",
				"/donaciones",
				"/blog",
				"/noticias",
				"/politicas-privacidad",
				"/politicas-contacto",
				"/politicas-pago",
				"/politicas-despacho",
				"/email-verification", 
				"/password-reset", 
				"/password-reset-request").permitAll()
		.antMatchers(
				"/producto/{productoId}", 
				"/informacion-usuario", 
				"/informacion-envio", 
				"/informacion-pago", 
				"/redirigiendo", 
				"/carrito/**").hasAnyAuthority("READ_AUTORIDAD")
		.antMatchers("/registrar-producto").hasAnyAuthority("WRITE_AUTORIDAD")
		.antMatchers(HttpMethod.POST, "/carritos/**").hasAnyAuthority("READ_AUTORIDAD")
		.antMatchers(HttpMethod.DELETE, "/carritos/${productoId}").hasAnyAuthority("WRITE_AUTORIDAD")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic()
		.and()
        .formLogin().loginPage("/login")
        //.successHandler(successLoginHandler())
        .permitAll()
        .and()
        .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login");
//		.and()
//		.and().addFilter(getAuthenticationFilter())
//		.addFilter(new AuthorizationFilter(authenticationManager(), clienteRepo))
//		.sessionManagement()
//		.sessionCreationPolicy(SessionCreationPolicy.STATELESS); //Elimina las cookies generadas
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
	
	private SuccessLoginHandler successLoginHandler() {
        return new SuccessLoginHandler();
    }
}
