package com.trainingit.training.service;

import com.trainingit.training.model.Course;
import com.trainingit.training.model.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    private static final String COURSE_PATH = "/course";

    @Autowired
    private RestTemplate restTemplate;

    @Value("${rest.client.courses-ms.url}")
    private String coursesMsUrl;

    @Override
    public List<Training> getTrainings() {
        final Course[] courses = this.restTemplate.getForObject(this.coursesMsUrl + COURSE_PATH, Course[].class);
        final List<Training> trainings = new ArrayList<>();

        if (courses != null) {
            Arrays.stream(courses).forEach(course -> trainings.add(this.getTrainingFromCourse(course)));
        }

        return trainings;
    }

    @Override
    public void newTraining(Training training) {
        if (!this.existsCourseByName(training.getCourse())) {
            this.restTemplate.postForLocation(this.coursesMsUrl + COURSE_PATH, this.getCourseFromTraining(training));
        }
    }

    private Training getTrainingFromCourse(Course course) {
        final Training training = new Training();

        training.setCourse(course.getName());
        training.setSubjects(course.getDuration() != null && course.getDuration() >= 50 ? 10 : 5);
        training.setPrice(course.getPrice());

        return training;
    }

    private boolean existsCourseByName(String courseName) {
        final Course[] courses = this.restTemplate.getForObject(this.coursesMsUrl + COURSE_PATH, Course[].class);

        return courses != null && Arrays.stream(courses).anyMatch(course -> course.getName().equals(courseName));
    }

    private Course getCourseFromTraining(Training training) {
        Course course = new Course();

        course.setName(training.getCourse());
        course.setPrice(training.getPrice());
        course.setDuration(training.getSubjects() * 10);
        course.setCourseCode(training.getCourse().substring(0, 3) + course.getDuration());

        return course;
    }

}
