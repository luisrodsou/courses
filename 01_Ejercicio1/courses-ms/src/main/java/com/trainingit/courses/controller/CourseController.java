package com.trainingit.courses.controller;

import com.trainingit.courses.model.entity.Course;
import com.trainingit.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping(value = "/course", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourses() {
        return this.courseService.findCourses();
    }

    @PostMapping(value = "/course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> createCourse(@RequestBody Course course) {
        return this.courseService.createCourse(course);
    }

    @DeleteMapping(value = "/course/{courseCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> deleteCourse(@PathVariable String courseCode) {
        return this.courseService.deleteCourse(courseCode);
    }

    @PutMapping("/course/{courseCode}")
    public void updateCourseDuration(@PathVariable String courseCode, @RequestParam Integer duration) {
        this.courseService.updateCourseDuration(courseCode, duration);
    }

    @GetMapping(value = "/course/{courseCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course findCourse(@PathVariable String courseCode) {
        return this.courseService.findCourse(courseCode);
    }

    @GetMapping(value = "/course/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourseByPriceRange(@RequestParam("min") Integer minPrice, @RequestParam("max") Integer maxPrice) {
        return this.courseService.findCourseByPriceRange(minPrice, maxPrice);
    }

}
