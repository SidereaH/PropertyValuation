package com.propertyvaluation.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyvaluation.main.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
