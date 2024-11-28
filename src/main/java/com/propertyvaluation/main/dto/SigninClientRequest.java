package com.propertyvaluation.main.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class SigninClientRequest {
  private String username;
  private String password;
}
