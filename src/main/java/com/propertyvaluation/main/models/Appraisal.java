package com.propertyvaluation.main.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "appraisals")
public class Appraisal {
  @Column(name = "appraisal_id")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long appraisalId;
  @ManyToOne
  @JoinColumn(name = "contract_id")
  private Contract contract;

  @ManyToOne
  @JoinColumn(name = "object_id")
  private PropertyObject object;
  @ManyToOne
  @JoinColumn(name = "apprasial_type")
  private AppraisalType appraisalType;

}
