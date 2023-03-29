package com.sda.onlineshopjavaremotero46.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
@Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/register").permitAll();
            auth.requestMatchers("/home").hasAnyRole("SELLER", "BUYER");
            auth.requestMatchers("/addProduct").hasRole("SELLER");
            auth.requestMatchers("/product/*").hasAnyRole("SELLER", "BUYER");
            auth.requestMatchers("/cart").hasRole("BUYER");
        }).httpBasic();
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .and()
                .cors().disable().authorizeHttpRequests()
                .and()
                .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home");
        return httpSecurity.build();
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(
                "/img/**", "/css/**", "/js/**", "/vendors/**"
        );
    }
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
    return new BCryptPasswordEncoder();
    }
}
