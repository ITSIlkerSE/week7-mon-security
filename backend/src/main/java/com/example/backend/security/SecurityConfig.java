package com.example.backend.security;

import com.example.backend.service.AppUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final AppUserDetailService appUserDetailService;

    public SecurityConfig(AppUserDetailService appUserDetailService) {
        this.appUserDetailService = appUserDetailService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/api/ciao").authenticated()
                .antMatchers("/api/hello").permitAll()
                .antMatchers("/api/user/login").permitAll()
                .antMatchers("/api/vipUser/*").authenticated()
                .antMatchers("/api/admin").hasRole("admin")
                .and().httpBasic();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authorize) throws Exception {
        authorize.userDetailsService(appUserDetailService);
    }


}
