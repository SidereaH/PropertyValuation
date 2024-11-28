package com.propertyvaluation.main.security;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

@Component
public class JwtCore {

  @Value("${propval.app.secret}")
  private String secret;
  @Value("${propval.app.lifetime}")
  private int lifetime;

  public String generateToken(Authentication authentication) {
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    return Jwts.builder().setSubject((userDetails.getUsername())).setIssuedAt(new Date())
            .setExpiration(new Date((new Date()).getTime() + lifetime))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
  }
  public String generateToken(UserDetails userDetails){
    return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
            .setExpiration(new Date((new Date().getTime() + lifetime)))
            .signWith(SignatureAlgorithm.HS256, secret)
            .compact();
  }
  public String getUserNameFromJwt(String token) {
    return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
  }
}

