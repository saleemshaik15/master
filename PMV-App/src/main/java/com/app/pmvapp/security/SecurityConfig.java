package com.app.pmvapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(@Lazy UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/user/login").hasAnyAuthority("ROLE_ADMIN","ROLE_ENG","ROLE_DRIVER","ROLE_MANAGER")
                .antMatchers(HttpMethod.POST,"/car/create").hasAuthority("ROLE_ADMIN")
                .antMatchers(HttpMethod.GET,"/car/all").hasAnyAuthority("ROLE_ENG","ROLE_ADMIN")
                .antMatchers(HttpMethod.POST,"/ticket/create").hasAuthority("ROLE_ENG")
                .antMatchers(HttpMethod.GET,"/ticket/driver/{driver_id}").hasAuthority("ROLE_DRIVER")
                .antMatchers(HttpMethod.GET,"/ticket/driver/{driver_id}").access("@userSecurity.hasUserId(authentication,#driver_id)")
                .antMatchers(HttpMethod.GET,"/ticket/report/{year}").hasAuthority("ROLE_MANAGER");

        http.cors().configure(http);
        http.csrf().disable();
        super.configure(http);


    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v3/api-docs/**",
                "/swagger-ui/**","/user/create/**");
    }
}
