package com.propertyvaluation.main.models;

import java.time.LocalDate;
import java.time.Year;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "contracts")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Contract {
  @Id
  @Column(name = "contract_id")
  private Long contractId;

  @Column(name = "contract_number")
  private String contractNumber;

  @ManyToOne
  @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne
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
  private LocalDate createdAt;
}
