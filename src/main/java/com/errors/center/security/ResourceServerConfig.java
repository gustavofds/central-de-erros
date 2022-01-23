package com.errors.center.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.GET,"/api/v1/logevent").authenticated()
            .antMatchers(HttpMethod.POST,"/api/v1/logevent").authenticated()
            .antMatchers(HttpMethod.GET,"/api/v1/logevent/{id}").authenticated()
            .antMatchers(HttpMethod.DELETE,"/api/v1/logevent/{id}").authenticated()
            .antMatchers(HttpMethod.GET,"/api/v1/logevent/filter").authenticated()
            .antMatchers(HttpMethod.GET, "/api/v1/type").authenticated()
            .antMatchers(HttpMethod.GET, "/api/v1/type/{id}").authenticated()
            .antMatchers(HttpMethod.PUT, "/api/v1/type/{id}").authenticated()
            .antMatchers(HttpMethod.POST, "/api/v1/type/{id}").authenticated()
            .antMatchers(HttpMethod.DELETE, "/api/v1/type/{id}").authenticated()
            .antMatchers(HttpMethod.POST, "/api/v1/user").permitAll();
    }
}
