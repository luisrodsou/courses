package com.trainingit.courses.model.repository;

import com.trainingit.courses.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {

    List<Course> findByPriceBetween(Integer minPrice, Integer maxPrice);

}
