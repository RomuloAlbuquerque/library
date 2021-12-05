package com.project.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
	private Environment env; 
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };
	
	private static final String[] ALL_BOOKS = { "/allbooks/**" };
	
	private static final String[] CLIENT_BOOKS = { "/client/books/**" };
	
	private static final String[] ADMIN_BOOKS = { "/books/**" };
	
	private static final String[] USERS = {  "/users/**"  };

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
		
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
		//Permite h2-console
		if(Arrays.asList(env.getActiveProfiles()).contains("test")) {
			http.headers().frameOptions().disable();
		}
		
		http.authorizeRequests()
		.antMatchers(PUBLIC).permitAll()
		
		/*
		.antMatchers(HttpMethod.GET, ALL_BOOKS).permitAll()
		.antMatchers(HttpMethod.GET, CLIENT_BOOKS).permitAll()
		.antMatchers(HttpMethod.POST, ADMIN_BOOKS).permitAll()
		*/
		.antMatchers(HttpMethod.GET, ALL_BOOKS).hasAnyRole("CLIENT", "ADMIN")
		
		.antMatchers(HttpMethod.GET, CLIENT_BOOKS).hasAnyRole("CLIENT", "ADMIN")
		.antMatchers(HttpMethod.POST, CLIENT_BOOKS).hasAnyRole("CLIENT", "ADMIN")
		.antMatchers(HttpMethod.PUT, CLIENT_BOOKS).hasAnyRole("CLIENT", "ADMIN")
		.antMatchers(HttpMethod.DELETE, CLIENT_BOOKS).hasAnyRole("CLIENT", "ADMIN")
		
		.antMatchers(HttpMethod.GET, ADMIN_BOOKS).hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.POST, ADMIN_BOOKS).hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.PUT, ADMIN_BOOKS).hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, ADMIN_BOOKS).hasAnyRole("ADMIN")
		
		.antMatchers(HttpMethod.GET, USERS).hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, USERS).hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, USERS).hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, USERS).hasRole("ADMIN")
		
		//.antMatchers(CLIENT_OR_ADMIN).hasAnyRole("CLIENT", "ADMIN")
		//.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
		;
	}
	
}
