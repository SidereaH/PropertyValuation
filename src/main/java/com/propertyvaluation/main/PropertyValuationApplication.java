package com.propertyvaluation.main;

import com.propertyvaluation.main.models.Client;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class PropertyValuationApplication {
  public static ApplicationContext context;
  public static Client currentClient = null;
  public static void main(String[] args) {
    SpringApplication.run(PropertyValuationApplication.class, args);
  }

}
