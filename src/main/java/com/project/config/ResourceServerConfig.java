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
	
	private static final String[] CLIENT_OR_ADMIN = { "/books/**" };
	
	private static final String[] ADMIN = {  "/users/**"  };

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
		
		//.antMatchers(HttpMethod.GET, CLIENT_OR_ADMIN).permitAll()
		//.antMatchers(HttpMethod.POST, CLIENT_OR_ADMIN).permitAll()
		
		.antMatchers(HttpMethod.GET, CLIENT_OR_ADMIN).hasAnyRole("CLIENT", "ADMIN")
		.antMatchers(HttpMethod.POST, CLIENT_OR_ADMIN).hasAnyRole("CLIENT", "ADMIN")
		
		.antMatchers(HttpMethod.PUT, CLIENT_OR_ADMIN).hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, CLIENT_OR_ADMIN).hasRole("ADMIN")
		
		.antMatchers(HttpMethod.GET, ADMIN).hasRole("ADMIN")
		.antMatchers(HttpMethod.POST, ADMIN).hasRole("ADMIN")
		.antMatchers(HttpMethod.PUT, ADMIN).hasRole("ADMIN")
		.antMatchers(HttpMethod.DELETE, ADMIN).hasRole("ADMIN")
		
		//.antMatchers(CLIENT_OR_ADMIN).hasAnyRole("CLIENT", "ADMIN")
		//.antMatchers(ADMIN).hasRole("ADMIN")
		.anyRequest().authenticated();
		;
	}
	
}
