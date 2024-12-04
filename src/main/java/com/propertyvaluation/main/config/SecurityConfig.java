package com.propertyvaluation.main.config;

import com.propertyvaluation.main.models.Client;
import com.propertyvaluation.main.security.TokenFilter;
import com.propertyvaluation.main.service.ClientDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.propertyvaluation.main.dal.DataAccessLayer;
import com.propertyvaluation.main.models.People;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  @Autowired
  private ClientDetailsServiceImpl clientService;

  @Autowired
  @Lazy
  private TokenFilter tokenFilter;

  public SecurityConfig(){

  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
    return authenticationConfiguration.getAuthenticationManager();
  }
  @Bean
  @Primary
  public AuthenticationManagerBuilder configureAuthenticationManagerBuilder(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
    authenticationManagerBuilder.userDetailsService(clientService).passwordEncoder(passwordEncoder());

    return authenticationManagerBuilder;
  }



  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     http
            .csrf(AbstractHttpConfigurer::disable)
            .cors(httpSecurityCorsConfigurer ->
                    httpSecurityCorsConfigurer.configurationSource(request ->
                            new CorsConfiguration().applyPermitDefaultValues())
            )
            .exceptionHandling(exception -> exception
                    .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
            .sessionManagement(session -> session
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )
          .authorizeHttpRequests(auth -> auth
              .requestMatchers("/authorized/*")
              .fullyAuthenticated()
              .anyRequest().permitAll())
             .addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
     return http.build();
  }

}
