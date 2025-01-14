package com.CrudOperations.CrudOperations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;

@Configuration
public class Config {

	@Bean
	public PasswordEncoder passwordEncoder() {

		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		UserDetails admin = User.builder().username("aman").password(passwordEncoder().encode("1234")).roles("ADMIN")
				.build();

		UserDetails user = User.builder().username("rahul").password(passwordEncoder().encode("rahul")).roles("USER")
				.build();
		return new InMemoryUserDetailsManager(admin, user);

	}

	@Bean
	public SecurityFilterChain securityfilterChain(HttpSecurity security) throws Exception {

		return security.csrf(csrf -> csrf.disable())

				.authorizeHttpRequests(authorize -> authorize.
						
						 requestMatchers(HttpMethod.GET, "/teams").hasAnyRole("USER", "ADMIN") // Get all teams
		                .requestMatchers(HttpMethod.GET, "/teams/{id}").hasAnyRole("USER", "ADMIN") // Get team by ID
		                .requestMatchers(HttpMethod.POST, "/teams").hasRole("ADMIN") // Insert team data
		                .requestMatchers(HttpMethod.PUT, "/teams/{id}").hasRole("ADMIN") // Update team data
		                .requestMatchers(HttpMethod.DELETE, "/teams/{id}").hasRole("ADMIN") // Delete team data						
						)
                  
				.httpBasic(Customizer.withDefaults()).build();
	}

}
