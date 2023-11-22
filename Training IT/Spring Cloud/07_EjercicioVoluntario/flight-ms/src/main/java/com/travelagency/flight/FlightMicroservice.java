package com.travelagency.flight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.travelagency.flight.controller", "com.travelagency.flight.listener",
        "com.travelagency.flight.model.service"})
@EnableJpaRepositories(basePackages = "com.travelagency.flight.model.repository")
@EntityScan(basePackages = "com.travelagency.flight.model.repository.entity")
public class FlightMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(FlightMicroservice.class, args);
    }

}
