package com.propertyvaluation.main.models;

import java.time.LocalDateTime;

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

@Entity
@Data
@Table(name = "clents")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PropertyTypes {
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "property_type_id")

  private Long propertyTypeId;

  @Column(name = "property_type_name")
  private String propertyTypeName;

  @Column
  private String description;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

}
