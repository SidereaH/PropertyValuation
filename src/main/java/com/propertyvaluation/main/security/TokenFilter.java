package com.propertyvaluation.main.security;

import java.io.IOException;
import java.rmi.ServerException;
import java.security.Security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class TokenFilter extends OncePerRequestFilter {
  @Autowired
  private JwtCore jwtCore;
  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    String jwt = null;
    String username = null;
    UserDetails userDetails = null;
    UsernamePasswordAuthenticationToken auth = null;
    try {
      String headerAuth = request.getHeader("Authorization");
      if (headerAuth != null && headerAuth.startsWith("Bearer ")){
        jwt = headerAuth.substring(7);
      }
      if (jwt != null) {
        try {
          username = jwtCore.getUserNameFromJwt(jwt);
        }
        catch(ExpiredJwtException e){
          //TODO
        }
        if(username != null && SecurityContextHolder.getContext().getAuthentication() == null){
          userDetails = userDetailsService.loadUserByUsername(username);
          auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
          SecurityContextHolder.getContext().setAuthentication(auth);
          log.info("Проверка токена: {}", jwt);
          log.info("Имя пользователя из токена: {}", username);
          log.info("Роли пользователя: {}", userDetails.getAuthorities());

        }
      }
    }
    catch (Exception e) {
      //TODO
    }
    filterChain.doFilter(request, response);
  }
}

