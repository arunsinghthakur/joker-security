package com.joker.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authorizeRequests().anyRequest().authenticated();
	}
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenServices(tokenServices());
	}
	
	@Bean
	public ResourceServerTokenServices tokenServices() {
		RemoteTokenServices remoteTokenServices = new RemoteTokenServices();
		remoteTokenServices.setClientId("joker");
		remoteTokenServices.setClientSecret("joker-secret");
		remoteTokenServices.setCheckTokenEndpointUrl("http://localhost:9000/joker-auth-server/oauth/check_token");
		return remoteTokenServices;
	}
}
