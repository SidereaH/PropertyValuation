package com.propertyvaluation.main.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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

}
