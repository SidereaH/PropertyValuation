package com.propertyvaluation.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.propertyvaluation.main.models.Position;
import com.propertyvaluation.main.repositories.PositionRepository;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/unauthorized")
public class MainController {
  private final PositionRepository positionRepository;

  public MainController(PositionRepository positionRepository) {
    this.positionRepository = positionRepository;
  }

  @PostMapping("/create/position")
  private ResponseEntity<Position> createPosition(@RequestBody Position position) {
    if (positionRepository.findByPositionName(position.getPositionName()) != null) {
      return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }
    Position savedPosition = positionRepository.saveAndFlush(position);
    return new ResponseEntity<>(savedPosition, HttpStatus.OK);
  }
}
