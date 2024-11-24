package com.propertyvaluation.main.models;

import java.time.LocalDate;

import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class People implements UserDetails {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "people_id")
  private Long peopleId;

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

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public String getPassword() {
    return getPassword();
  }

  @Override
  public String getUsername() {
    return getEmail();
  }

}
