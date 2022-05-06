package com.tasks.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.tasks.services.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private MyUserDetailsService mus;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(mus);	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests().antMatchers("/sendMail").permitAll()
		.and()
		.authorizeHttpRequests().antMatchers("/getAllUserByMailDesc").permitAll()
		.and()
		.authorizeHttpRequests().antMatchers("/authenticate").permitAll()
		.and()
		.authorizeHttpRequests().antMatchers("/hello").permitAll()
		.and()
		.authorizeHttpRequests().antMatchers("/admin/**").hasRole("ADMIN")
		.and()
		.authorizeHttpRequests().antMatchers("/user").hasAnyRole("USER","ADMIN")
		.anyRequest().authenticated();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}