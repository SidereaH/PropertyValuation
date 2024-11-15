package com.propertyvaluation.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyvaluation.main.models.Appraisal;

public interface AppraisalRepository extends JpaRepository<Appraisal, Long> {

}
