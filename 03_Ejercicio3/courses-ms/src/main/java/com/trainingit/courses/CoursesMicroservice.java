package com.trainingit.courses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.trainingit.courses.config", "com.trainingit.courses.controller",
        "com.trainingit.courses.service"})
@EnableJpaRepositories(basePackages = "com.trainingit.courses.model.repository")
@EntityScan(basePackages = "com.trainingit.courses.model.entity")
public class CoursesMicroservice {

    public static void main(String[] args) {
        SpringApplication.run(CoursesMicroservice.class, args);
    }

}
