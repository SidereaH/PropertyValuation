package com.propertyvaluation.main.models;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "contracts")
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
  @Id
  @Column(name = "contract_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long contractId;

  @Column(name = "contract_number")
  private String contractNumber;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "employee_id")
  private Employees employee;

  @Column(name = "contract_date")
  private LocalDate contractDate;

  @Column(name = "completion_date")
  private LocalDate completionDate;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private Status status;

  public enum Status {
    DRAFT("Черновик"), INPROCESS("Начато"), COMPLETED("Выполнено");

    private final String description;

    Status(String description) {
      this.description = description;
    }

    public String getDescription() {
      return description;
    }
  }

  @Column(name = "total_cost")
  private Long totalCost;

  @Column(name = "payment_status")
  private boolean paymentStatus;

  @Column(name = "created_at")
  private LocalDate createdAt = LocalDate.now();
}
