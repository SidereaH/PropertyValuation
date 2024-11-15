package com.propertyvaluation.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyvaluation.main.models.Position;

public interface PositionRepository extends JpaRepository<Position, Long> {

}
