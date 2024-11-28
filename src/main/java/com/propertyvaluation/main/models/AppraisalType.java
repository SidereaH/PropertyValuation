package com.propertyvaluation.main.models;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "appraisal_types")
@AllArgsConstructor
public class AppraisalType {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "appraisal_type_id")
  private Long appraisalTypeId;

  @Column(name = "appraisal_type_name")
  private String appraisalTypeName;

  @Column
  private String description;

  @Column(name = "created_at")
  private LocalDate createdAt = LocalDate.now();

}
