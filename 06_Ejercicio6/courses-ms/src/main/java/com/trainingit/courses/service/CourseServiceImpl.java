package com.trainingit.courses.service;

import com.trainingit.courses.model.entity.Course;
import com.trainingit.courses.model.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public List<Course> createCourse(Course course) {
        this.courseRepository.save(course);

        return this.courseRepository.findAll();
    }

    @Override
    public List<Course> deleteCourse(String courseCode) {
        this.courseRepository.deleteById(courseCode);

        return this.courseRepository.findAll();
    }

    @Override
    public void updateCourseDuration(String courseCode, Integer duration) {
        this.courseRepository.findById(courseCode).ifPresent(course -> course.setDuration(duration));
    }

    @Override
    public Course findCourse(String courseCode) {
        return this.courseRepository.findById(courseCode).orElse(null);
    }

    @Override
    public List<Course> findCourseByPriceRange(Integer minPrice, Integer maxPrice) {
        return this.courseRepository.findByPriceBetween(minPrice, maxPrice);
    }

}
