package com.propertyvaluation.main.service;

import com.propertyvaluation.main.dto.SignupRequest;
import com.propertyvaluation.main.models.Client;
import com.propertyvaluation.main.security.UserDetalesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.propertyvaluation.main.dal.DataAccessLayer;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  private final DataAccessLayer dataAccessLayer;

  @Autowired
  public UserDetailsServiceImpl(DataAccessLayer dataAccessLayer) {
    this.dataAccessLayer = dataAccessLayer;
  }

  public String newUser(SignupRequest signupRequest) {
    Client client = new Client();
    client.setLastName(signupRequest.getLastName());
    client.setFirstName(signupRequest.getFirstName());
    client.setMiddleName(signupRequest.getMiddleName());
    client.setBirthDate(signupRequest.getBirthDate());
    client.setPhone(signupRequest.getPhone());
    client.setEmail(signupRequest.getEmail());
    client.setPassword(signupRequest.getPassword());
    return dataAccessLayer.newUserToDatabase(client);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Client user = dataAccessLayer.getUserFromDatabaseByUsername(username);
    if (user == null) return null;
    return UserDetalesImpl.build(user);
  }
}
