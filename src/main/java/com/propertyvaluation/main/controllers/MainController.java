package com.propertyvaluation.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.propertyvaluation.main.dal.DataAccessLayer;
import com.propertyvaluation.main.models.Employees;
import com.propertyvaluation.main.models.Position;
import com.propertyvaluation.main.models.*;

@RestController
// @CrossOrigin("http://localhost:8080/")
@RequestMapping("/unauthorized")
public class MainController {
  private final DataAccessLayer dataAccessLayer;

  public MainController(DataAccessLayer dataAccessLayer) {
    this.dataAccessLayer = dataAccessLayer;
  }

  @PostMapping
  public ResponseEntity<Appraisal> createAppraisal(@RequestBody Appraisal appraisal) {
    dataAccessLayer.createAppraisal(appraisal);
    return ResponseEntity.status(HttpStatus.CREATED).body(appraisal);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Appraisal> getAppraisal(@PathVariable Long id) {
    Appraisal appraisal = dataAccessLayer.readAppraisal(id);
    return appraisal != null
        ? ResponseEntity.ok(appraisal)
        : ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<Appraisal> updateAppraisal(@RequestBody Appraisal appraisal) {
    dataAccessLayer.updateAppraisal(appraisal);
    return ResponseEntity.ok(appraisal);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAppraisal(@PathVariable Long id) {
    dataAccessLayer.deleteAppraisal(id);
    return ResponseEntity.ok().build();
  }

  // Контроллер для AppraisalType
  @PostMapping
  public ResponseEntity<AppraisalType> createAppraisalType(@RequestBody AppraisalType appraisalType) {
    dataAccessLayer.createAppraisalType(appraisalType);
    return ResponseEntity.status(HttpStatus.CREATED).body(appraisalType);
  }

  @GetMapping("/{id}")
  public ResponseEntity<AppraisalType> getAppraisalType(@PathVariable Long id) {
    AppraisalType appraisalType = dataAccessLayer.readAppraisalType(id);
    return appraisalType != null
        ? ResponseEntity.ok(appraisalType)
        : ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<AppraisalType> updateAppraisalType(@RequestBody AppraisalType appraisalType) {
    dataAccessLayer.updateAppraisalType(appraisalType);
    return ResponseEntity.ok(appraisalType);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteAppraisalType(@PathVariable Long id) {
    dataAccessLayer.deleteAppraisalType(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<Client> createClient(@RequestBody Client client) {
    dataAccessLayer.createClient(client);
    return ResponseEntity.status(HttpStatus.CREATED).body(client);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Client> getClient(@PathVariable Long id) {
    Client client = dataAccessLayer.readClient(id);
    return client != null
        ? ResponseEntity.ok(client)
        : ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<Client> updateClient(@RequestBody Client client) {
    dataAccessLayer.updateClient(client);
    return ResponseEntity.ok(client);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
    dataAccessLayer.deleteClient(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<Contract> createContract(@RequestBody Contract contract) {
    dataAccessLayer.createContract(contract);
    return ResponseEntity.status(HttpStatus.CREATED).body(contract);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Contract> getContract(@PathVariable Long id) {
    Contract contract = dataAccessLayer.readContract(id);
    return contract != null
        ? ResponseEntity.ok(contract)
        : ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<Contract> updateContract(@RequestBody Contract contract) {
    dataAccessLayer.updateContract(contract);
    return ResponseEntity.ok(contract);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
    dataAccessLayer.deleteContract(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<Employees> createEmployee(@RequestBody Employees employee) {
    dataAccessLayer.createEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED).body(employee);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Employees> getEmployee(@PathVariable Long id) {
    Employees employee = dataAccessLayer.readEmployee(id);
    return employee != null
        ? ResponseEntity.ok(employee)
        : ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<Employees> updateEmployee(@RequestBody Employees employee) {
    dataAccessLayer.updateEmployee(employee);
    return ResponseEntity.ok(employee);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
    dataAccessLayer.deleteEmployee(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<Position> createPosition(@RequestBody Position position) {
    dataAccessLayer.createPosition(position);
    return ResponseEntity.status(HttpStatus.CREATED).body(position);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Position> getPosition(@PathVariable Long id) {
    Position position = dataAccessLayer.readPosition(id);
    return position != null
        ? ResponseEntity.ok(position)
        : ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<Position> updatePosition(@RequestBody Position position) {
    dataAccessLayer.updatePosition(position);
    return ResponseEntity.ok(position);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePosition(@PathVariable Long id) {
    dataAccessLayer.deletePosition(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<PropertyObject> createPropertyObject(@RequestBody PropertyObject propertyObject) {
    dataAccessLayer.createPropertyObject(propertyObject);
    return ResponseEntity.status(HttpStatus.CREATED).body(propertyObject);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PropertyObject> getPropertyObject(@PathVariable Long id) {
    PropertyObject propertyObject = dataAccessLayer.readPropertyObject(id);
    return propertyObject != null
        ? ResponseEntity.ok(propertyObject)
        : ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<PropertyObject> updatePropertyObject(@RequestBody PropertyObject propertyObject) {
    dataAccessLayer.updatePropertyObject(propertyObject);
    return ResponseEntity.ok(propertyObject);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePropertyObject(@PathVariable Long id) {
    dataAccessLayer.deletePropertyObject(id);
    return ResponseEntity.ok().build();
  }

  @PostMapping
  public ResponseEntity<PropertyTypes> createPropertyType(@RequestBody PropertyTypes propertyType) {
    dataAccessLayer.createPropertyType(propertyType);
    return ResponseEntity.status(HttpStatus.CREATED).body(propertyType);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PropertyTypes> getPropertyType(@PathVariable Long id) {
    PropertyTypes propertyType = dataAccessLayer.readPropertyType(id);
    return propertyType != null
        ? ResponseEntity.ok(propertyType)
        : ResponseEntity.notFound().build();
  }

  @PutMapping
  public ResponseEntity<PropertyTypes> updatePropertyType(@RequestBody PropertyTypes propertyType) {
    dataAccessLayer.updatePropertyType(propertyType);
    return ResponseEntity.ok(propertyType);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePropertyType(@PathVariable Long id) {
    dataAccessLayer.deletePropertyType(id);
    return ResponseEntity.ok().build();
  }
}
