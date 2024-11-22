package com.propertyvaluation.main.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class People {

  @Column(name = "last_name")
  private String lastName;
  @Column(name = "first_name")
  private String firstName;
  @Column(name = "middle_name")
  private String middleName;
  @Column(name = "birth_date")
  private LocalDate birthDate;
  @Column(name = "phone")
  private String phone;
  @Column(name = "email")
  private String email;
  @Column(name = "created_at")
  private LocalDate createdAt = LocalDate.now();
}
