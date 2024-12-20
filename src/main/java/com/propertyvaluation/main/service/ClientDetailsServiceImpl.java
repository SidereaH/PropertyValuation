package com.propertyvaluation.main.service;

import com.propertyvaluation.main.dto.SignupClientRequest;
import com.propertyvaluation.main.models.Client;
import com.propertyvaluation.main.security.ClientDetalesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.propertyvaluation.main.dal.DataAccessLayer;

@Service
public class ClientDetailsServiceImpl implements UserDetailsService {
  private final DataAccessLayer dataAccessLayer;

  @Autowired
  public ClientDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
    this.dataAccessLayer = dataAccessLayer;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Client user = dataAccessLayer.getUserFromDatabaseByUsername(username);
    if (user == null) return null;
    return ClientDetalesImpl.build(user);
  }

}
