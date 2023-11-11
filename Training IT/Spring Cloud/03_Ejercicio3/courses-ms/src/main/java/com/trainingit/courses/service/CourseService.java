package com.trainingit.courses.service;

import com.trainingit.courses.model.entity.Course;

import java.util.List;

public interface CourseService {

    List<Course> findCourses();

    List<Course> createCourse(Course course);

    List<Course> deleteCourse(String courseCode);

    void updateCourseDuration(String courseCode, Integer duration);

    Course findCourse(String courseCode);

    List<Course> findCourseByPriceRange(Integer minPrice, Integer maxPrice);

}
