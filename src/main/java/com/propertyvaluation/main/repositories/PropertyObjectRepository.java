package com.propertyvaluation.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyvaluation.main.models.PropertyObject;

public interface PropertyObjectRepository extends JpaRepository<PropertyObject, Long> {

}
