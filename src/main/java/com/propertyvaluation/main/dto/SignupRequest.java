package com.propertyvaluation.main.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;
@Data
public class SignupRequest {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String password;
}