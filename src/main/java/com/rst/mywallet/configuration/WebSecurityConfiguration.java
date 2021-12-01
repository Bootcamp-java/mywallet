package com.rst.mywallet.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.rst.mywallet.service.UserService;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	public UserDetailsService userDetailsService() {

		UserDetails user = User.builder().username("user").password(passwordEncoder().encode("secret")).roles("USER")
				.build();
		UserDetails userAdmin = User.builder().username("admin").password(passwordEncoder().encode("secret"))
				.roles("ADMIN").build();
		return new InMemoryUserDetailsManager(user, userAdmin);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/ oauth / token", "/ oauth / authorize **", "/ publishes").permitAll();
		// .anyRequest (). authenticated ();

		http.requestMatchers().antMatchers("/ private") // Deny access to "/ private"
				.and().authorizeRequests().antMatchers("/ private").access("hasRole ('USER')").and().requestMatchers()
				.antMatchers("/ admin") // Deny access to "/ admin"
				.and().authorizeRequests().antMatchers("/ admin").access("hasRole ('ADMIN')");
	}

}
