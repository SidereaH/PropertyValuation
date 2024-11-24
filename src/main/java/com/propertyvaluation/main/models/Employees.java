package com.propertyvaluation.main.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "employees")
public class Employees extends People {

  @Column(name = "hire_date")
  private final LocalDate hireDate;

  @ManyToOne
  @JoinColumn(name = "position_id")
  private final Position position;

  public Employees(
      String lastName, String firstName, String middleName, LocalDate birthDate,
      String phone, String email, String password,
      LocalDate hireDate, Position position) {
    super(lastName, firstName, middleName, birthDate, phone, email, password);
    this.hireDate = hireDate;
    this.position = position;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Arrays.asList(new SimpleGrantedAuthority("ROLE_EMPL"));
  }

}
