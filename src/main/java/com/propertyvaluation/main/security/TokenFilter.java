package com.propertyvaluation.main.security;

import java.io.IOException;
import java.rmi.ServerException;
import java.security.Security;

import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.couchbase.CouchbaseProperties.Io;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.rsocket.RSocketSecurity.JwtSpec;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends OncePerRequestFilter {
  @Autowired
  private JwtCore jwtCore;

  @Autowired
  private UserDetailsService userDetailsService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    String jwt = null;
    String username = null;
    UserDetails userDetails = null;
    UsernamePasswordAuthenticationToken authenticationToken = null;

    try {
      String headerAuth = request.getHeader("Authorization");
      if (headerAuth != null && headerAuth.startsWith("Bearer")) {
        jwt = headerAuth.substring(7);
      }
      if (jwt != null) {
        try {
          username = jwtCore.getUsernameFromJwt(jwt);
        } catch (ExpiredJwtException e) {

        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
          userDetails = userDetailsService.loadUserByUsername(username);
          authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null);
          SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        }
      }

    } catch (Exception exception) {
    }
    filterChain.doFilter(request, response);
  }

}
