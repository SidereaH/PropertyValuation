package com.propertyvaluation.main.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SigninRequest {

  private String lastName;
  private String firstName;
  private String middleName;
  private LocalDate birthDate;
  private String phone;
  private String email;
  private String password;
}
