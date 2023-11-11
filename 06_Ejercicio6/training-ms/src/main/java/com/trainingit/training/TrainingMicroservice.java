package com.trainingit.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = {"com.trainingit.training.controller", "com.trainingit.training.service"})
public class TrainingMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(TrainingMicroservice.class, args);
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
