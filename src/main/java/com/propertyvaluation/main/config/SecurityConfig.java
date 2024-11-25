package com.propertyvaluation.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.WebExpressionAuthorizationManager;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.propertyvaluation.main.dal.DataAccessLayer;
import com.propertyvaluation.main.models.People;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();

  }

  @Bean
  public UserDetailsService userDetailsService(DataAccessLayer dataAccessLayer) {
    return email -> {
      People user = dataAccessLayer.getPeopleByMail(email);
      if (user != null)
        return user;
      throw new UsernameNotFoundException("User ‘" + email + "’ not found");
    };
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/clients", "/api/employees", "/api/positions", "")
            .access(new WebExpressionAuthorizationManager("hasRole('USER')"))
            .requestMatchers("/", "/**")
            .access(new WebExpressionAuthorizationManager("permitAll()")))
        .formLogin(form -> form
            .loginPage("/login"))
        // .oauth2Login(auth -> auth
        // .loginPage("/login"))
        .logout(log -> log
            .logoutSuccessUrl("/"))
        .build();
  }

}
