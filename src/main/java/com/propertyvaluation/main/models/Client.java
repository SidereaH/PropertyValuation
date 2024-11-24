package com.propertyvaluation.main.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Table;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "clients")
@AllArgsConstructor
@NoArgsConstructor

public class Client extends People {
  @Column(name = "count_of_apprailsals")
  private int countOfAppraisals;
}
