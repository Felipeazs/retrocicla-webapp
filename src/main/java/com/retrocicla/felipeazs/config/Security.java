package com.retrocicla.felipeazs.config;

import com.retrocicla.felipeazs.service.ClientDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter {

    @Autowired
    private ClientDetailsService userService;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    protected void configure(HttpSecurity http) throws Exception {   
        http 	
        .csrf().disable()
		.authorizeRequests()
		.antMatchers(
				"/",
				"/searchproduct",
				"/ropaspage", 
				"/telaspage",
				"/productdetails",
				"/tienda",
				"/registro",
				"/registrarcliente",							
				"/404", "/405", "/500").permitAll()		
		.antMatchers(	
				"/cartdetails",
				"/checkout",
				"/api/**")
		.hasAnyAuthority("cliente", "admin")	
		.antMatchers("/addproduct", "/addproductpage", "/addproductdb")
		.hasAnyAuthority("admin")
		.anyRequest()
		.authenticated()
		.and()
        .httpBasic()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/index");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/*", "/js/**", "/img/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(encoder);
        
    }
    
    


}
