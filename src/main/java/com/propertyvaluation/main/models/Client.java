package com.propertyvaluation.main.models;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "clients")
public class Client extends People {
  @Column(name = "count_of_apprailsals")
  private int countOfAppraisals;



}
