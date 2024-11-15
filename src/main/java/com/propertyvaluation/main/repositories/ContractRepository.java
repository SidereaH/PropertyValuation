package com.propertyvaluation.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyvaluation.main.models.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {

}
