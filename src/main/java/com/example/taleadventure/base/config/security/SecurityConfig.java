package com.example.taleadventure.base.config.security;

import com.example.taleadventure.base.config.login.AuthTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final AuthTokenProvider authTokenProvider;

    @Override
    public void configure(WebSecurity web) throws Exception{
        web.ignoring().antMatchers("/auth/**","/v2/api-docs","/configuration/**","/swagger*/**","/webjars/**","/v3/api-docs/**","/swagger-ui/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        JwtAuthenticationFilter jwtAuthFilter = new JwtAuthenticationFilter(authTokenProvider);

        http.httpBasic().disable();

        http.authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/member/**","/chapter/**","/home/**","/talebook/**","/word/**").permitAll()
                .anyRequest().authenticated().and()
                .headers()
                .frameOptions()
                .sameOrigin().and()
                .cors().and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
