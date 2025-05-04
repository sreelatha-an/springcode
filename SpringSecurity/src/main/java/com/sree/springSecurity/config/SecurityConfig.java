package com.sree.springSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private JWTFilter jwtFilter;
	
	
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		//provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(10));
		return provider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {

		return config.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
		
		
		httpSec.csrf(csrfCustomizer -> csrfCustomizer.disable())
			.authorizeHttpRequests(request -> request
												.requestMatchers("register","login").permitAll()
												.anyRequest().authenticated())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.addFilterBefore(jwtFilter,UsernamePasswordAuthenticationFilter.class);
		
		
		return httpSec.build();
	}
	
	/*
	  @Bean 
	  public SecurityFilterChain securityFilterChain(HttpSecurity httpSec)
	  throws Exception {
	  
	  httpSec.csrf(csrfCustomizer -> csrfCustomizer.disable()); //disabling CSRF
	  httpSec.authorizeHttpRequests(request ->
	  request.anyRequest().authenticated());// enable the security for all  requests. 
	  //httpSec.formLogin(Customizer.withDefaults()); //need to provide  formlogin 
	  httpSec.httpBasic(Customizer.withDefaults());// popup not loginform with httpBasics for the login. 
	  httpSec.sessionManagement(session ->  session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); 
	  // to create  a stateless sessions for the rest apis. 
	  // when we have stateless we dont  need formlogin as we need to send credentials in every restapi call
	  
	  
	  return httpSec.build(); }
	 */
	
	
	/*
	  @Bean public UserDetailsService getUserDetailsService() { 
		  UserDetails usr1 =  User.withDefaultPasswordEncoder() .username("sreelatha")
				  					.password("sree@1234") .roles("USER") .build();
	  
		  UserDetails usr2 = User.withDefaultPasswordEncoder() .username("admin")
				  					.password("admin@1234") .roles("ADMIN") .build();
	  
	  
		  return new InMemoryUserDetailsManager(usr1,usr2); 
	 }										
	 */
	
}
