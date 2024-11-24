package com.propertyvaluation.main.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class Client extends People {
  @Column(name = "count_of_apprailsals")
  private int countOfAppraisals;

  public Client(
      String lastName, String firstName, String middleName, LocalDate birthDate,
      String phone, String email, String password, int countOfAppraisals) {
    super(lastName, firstName, middleName, birthDate, phone, email, password);
    this.countOfAppraisals = countOfAppraisals;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
  }
}
