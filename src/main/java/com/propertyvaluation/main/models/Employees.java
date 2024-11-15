package com.propertyvaluation.main.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "employees")
public class Employees {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "employee_id")
  private Long employeeId;
  @Column(name = "hire_date")
  private LocalDate hireDate;

  @ManyToOne
  @JoinColumn(name = "position_id")
  private Position position;

}
