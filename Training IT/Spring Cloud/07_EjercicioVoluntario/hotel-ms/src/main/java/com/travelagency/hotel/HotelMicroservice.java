package com.travelagency.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.travelagency.hotel.controller", "com.travelagency.hotel.model.service"})
@EnableJpaRepositories(basePackages = "com.travelagency.hotel.model.repository")
@EntityScan(basePackages = "com.travelagency.hotel.model.repository.entity")
public class HotelMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(HotelMicroservice.class, args);
    }

}
