package com.propertyvaluation.main.controllers;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.propertyvaluation.main.dal.DataAccessLayer;
import com.propertyvaluation.main.models.Employees;
import com.propertyvaluation.main.models.Position;

@RestController
// @CrossOrigin("http://localhost:8080/")
@RequestMapping("/unauthorized")
public class MainController {
  private final DataAccessLayer dataAccessLayer;

  public MainController(DataAccessLayer dataAccessLayer) {
    this.dataAccessLayer = dataAccessLayer;
  }

  @PostMapping("/create/employee")
  public ResponseEntity<String> createEmployee(@RequestBody Employees employee) {
    dataAccessLayer.createEmployee(employee);
    return ResponseEntity.ok("employee created");
  }

  @PostMapping("/create/position")
  public ResponseEntity<String> createEmployee(@RequestBody Position position) {
    dataAccessLayer.createPosition(position);
    return ResponseEntity.ok("position created");
  }
}
