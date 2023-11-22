package com.travelagency.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.travelagency.booking.config", "com.travelagency.booking.controller",
        "com.travelagency.booking.listener", "com.travelagency.booking.model.service"})
@EnableJpaRepositories(basePackages = "com.travelagency.booking.model.repository")
@EntityScan(basePackages = "com.travelagency.booking.model.repository.entity")
public class BookingMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(BookingMicroservice.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
