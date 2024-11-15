package com.propertyvaluation.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.propertyvaluation.main.models.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}