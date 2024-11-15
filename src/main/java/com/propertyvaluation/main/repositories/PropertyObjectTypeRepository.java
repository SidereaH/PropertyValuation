package com.propertyvaluation.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyvaluation.main.models.PropertyObjectType;

public interface PropertyObjectTypeRepository extends JpaRepository<PropertyObjectType, Long> {

}
