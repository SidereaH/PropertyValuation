package com.propertyvaluation.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyvaluation.main.models.AppraisalType;

public interface AppraisalTypeRepository extends JpaRepository<AppraisalType, Long> {

}
