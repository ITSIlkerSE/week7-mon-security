package com.example.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/user/*").authenticated()
                .antMatchers("/api/vipUser/*").authenticated()
                .antMatchers("/api/admin").hasRole("admin")
                .and().httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authorize) throws Exception {
        authorize.inMemoryAuthentication()
                .withUser("Ilker Y.")
                .password(passwordEncoder().encode("Gurke64"))
                .roles("admin");
    }








}
