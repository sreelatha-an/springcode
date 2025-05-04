package com.sree.springOAuth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringConfig {

	
	public SecurityFilterChain getSecurityFltrChain(HttpSecurity httpSecurity) throws Exception {
		
		httpSecurity.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());
		httpSecurity.oauth2Login(Customizer.withDefaults());
		return httpSecurity.build();
	}
	
}
