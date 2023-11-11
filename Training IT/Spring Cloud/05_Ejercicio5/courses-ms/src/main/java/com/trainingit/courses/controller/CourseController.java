package com.trainingit.courses.controller;

import com.trainingit.courses.model.entity.Course;
import com.trainingit.courses.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Value("${eureka.instance.instance-id}")
    private String instance;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Course>> findCourses() {
        HttpHeaders responseHeaders = new HttpHeaders();

        // Se añade la cabecera instance a la respuesta para saber qué instancia ha respondido a la petición
        responseHeaders.set("instance", instance);

        return ResponseEntity.ok().headers(responseHeaders).body(this.courseService.findCourses());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
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

    @GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourseByPriceRange(@RequestParam("min") Integer minPrice, @RequestParam("max") Integer maxPrice) {
        return this.courseService.findCourseByPriceRange(minPrice, maxPrice);
    }

}
