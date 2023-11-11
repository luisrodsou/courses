package com.trainingit.courses.controller;

import com.trainingit.courses.model.entity.Course;
import com.trainingit.courses.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Mantenimiento de cursos.")
@RequestMapping("/course")
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(summary = "Lista todos los cursos.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourses() {
        return this.courseService.findCourses();
    }

    @Operation(summary = "Realiza el alta de un nuevo curso.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> createCourse(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos del curso.") @RequestBody Course course) {
        return this.courseService.createCourse(course);
    }

    @Operation(summary = "Elimina un curso a partir de su código.")
    @DeleteMapping(value = "/{courseCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> deleteCourse(@Parameter(description = "Código del curso.") @PathVariable String courseCode) {
        return this.courseService.deleteCourse(courseCode);
    }

    @Operation(summary = "Modifica la duración de un curso a partir de su código.")
    @PutMapping("/{courseCode}")
    public void updateCourseDuration(@Parameter(description = "Código del curso.") @PathVariable String courseCode, @Parameter(description = "Nueva duración del curso.") @RequestParam Integer duration) {
        this.courseService.updateCourseDuration(courseCode, duration);
    }

    @Operation(summary = "Recupera un curso a partir de su código.")
    @GetMapping(value = "/{courseCode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Course findCourse(@Parameter(description = "Código del curso.") @PathVariable String courseCode) {
        return this.courseService.findCourse(courseCode);
    }

    @Operation(summary = "Lista los cursos a partir de un intervalo de precios.")
    @GetMapping(value = "/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Course> findCourseByPriceRange(@Parameter(description = "Precio mínimo.") @RequestParam("min") Integer minPrice, @Parameter(description = "Precio máximo.") @RequestParam("max") Integer maxPrice) {
        return this.courseService.findCourseByPriceRange(minPrice, maxPrice);
    }

}
