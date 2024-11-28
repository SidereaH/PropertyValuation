package com.propertyvaluation.main.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "people")
public abstract class People{
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "people_id")
  private Long peopleId;

  @Column
  private String username;
  @Column(name = "last_name")
  private String lastName;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "middle_name")
  private String middleName;

  @Column(name = "birth_date")
  private LocalDate birthDate;

  private String phone;
  private String email;
  private String password;

  @Column(name = "created_at")
  private LocalDate createdAt = LocalDate.now();

  // No-argument constructor

  public People(
      String lastName, String firstName, String middleName, LocalDate birthDate,
      String phone, String email, String password) {
    this.lastName = lastName;
    this.firstName = firstName;
    this.middleName = middleName;
    this.birthDate = birthDate;
    this.phone = phone;
    this.email = email;
    this.password = password;
  }
}
