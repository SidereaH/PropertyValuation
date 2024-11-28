package com.propertyvaluation.main.security;

import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class JwtCore {
  @Value("$propertyvaluation.app.secret")
  private String secret;
  @Value("$propertyvaluation.app.lifeTime")
  private int lifeTime;

    public String generateToken(UserDetails userDetails) {
      return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
              .setExpiration(new Date((new Date().getTime() + lifeTime)))
              .signWith(SignatureAlgorithm.HS256, secret)
              .compact();
    }
    public String getUsernameFromJwt(String token) {
      return null;
    }

  }