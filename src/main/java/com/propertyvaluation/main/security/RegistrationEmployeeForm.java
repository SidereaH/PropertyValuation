package com.propertyvaluation.main.security;

import java.time.LocalDate;

import lombok.*;
import com.propertyvaluation.main.models.Position;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.propertyvaluation.main.models.Employees;

@Data
@AllArgsConstructor
public class RegistrationEmployeeForm extends RegistrationForm {
  private LocalDate hireDate;
  private Position position;

  public Employees toEmployee(PasswordEncoder encoder) {
    return new Employees(
        getLastName(),
        getFirstName(),
        getMiddleName(),
        getBirthDate(),
        getPhone(),
        getEmail(),
        encoder.encode(getPassword()),
        getHireDate(),
        getPosition());
  }
  // return new Employees(
  // super.getLastName(),
  // super.getFirstName(),
  // super.getMiddleName(),
  // super.getBirthDate(),
  // super.getPhone(),
  // super.getEmail(),
  // encoder.encode(super.getPassword()),
  // LocalDate.now(),
  // this.getHireDate(),
  // this.getPosition());
  // }
}
