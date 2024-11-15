package com.propertyvaluation.main.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;

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
@Table(name = "property_object")
public class PropertyObject {
  @Id
  @Column(name = "object_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long objectId;
  @JoinColumn(name = "property_type")
  @ManyToOne
  private PropertyTypes propertyType;

  @Column(name = "address")
  private String address;

  @Column(name = "cadastral_number")
  private String cadastralNumber;

  @Column(name = "total_area")
  private double totalArea;

  @Column(name = "construction_year")
  private Year constructionYear;

  @Column(name = "floor")
  private int floor;

  @Column(name = "total_floors")
  private int totalFloors;

  @Column(name = "additional_info")
  private String additionalInfo;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

}
