package com.senla.bolkunets.virtualtestlab.security.config;

import com.senla.bolkunets.virtualtestlab.security.filters.TokenAuthenticationFilter;
import com.senla.bolkunets.virtualtestlab.security.services.TokenAuthenticationService;
import com.senla.bolkunets.virtualtestlab.security.services.impl.TokenAuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.senla.bolkunets.virtualtestlab.security")
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;


    @Bean
    public TokenAuthenticationFilter getTokenAuthenticationFilter() {
        TokenAuthenticationFilter tokenAuthenticationFilter = new TokenAuthenticationFilter(tokenAuthenticationService);
        return tokenAuthenticationFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS,"/**").permitAll()
                .antMatchers("/users/**").hasAuthority(ROLE_ADMIN)
                .antMatchers("/result/admin/**").hasAuthority(ROLE_ADMIN)
                .antMatchers("/methodics/description/open/{idUser}").hasAuthority(ROLE_ADMIN)
                .antMatchers("/methodics/description/get/**").hasAuthority(ROLE_ADMIN)
                .antMatchers("/documents/create").hasAuthority(ROLE_ADMIN)
                .antMatchers("/documents/update").hasAuthority(ROLE_ADMIN)
                .antMatchers("/documents/delete").hasAuthority(ROLE_ADMIN)
                .antMatchers("/contact/create").hasAuthority(ROLE_ADMIN)
                .antMatchers("/contact/update").hasAuthority(ROLE_ADMIN)
                .antMatchers("/contact/delete").hasAuthority(ROLE_ADMIN)
                .antMatchers("/token/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilterAfter(getTokenAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable();
    }
}
