package com.propertyvaluation.main.security;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationForm {
  private String lastName;
  private String firstName;
  private String middleName;
  private LocalDate birthDate;
  private String phone;
  private String email;
  private String password;
}
