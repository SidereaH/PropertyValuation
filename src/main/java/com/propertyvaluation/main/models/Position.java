package com.propertyvaluation.main.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "positions")
public class Position {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "position_id")
  private Long positionId;

  @Column(name = "position_name")
  private String positionName;

  @Column(name = "position_created_at")
  private LocalDate createdAt = LocalDate.now();
}
