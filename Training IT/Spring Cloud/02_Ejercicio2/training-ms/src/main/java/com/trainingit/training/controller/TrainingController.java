package com.trainingit.training.controller;

import com.trainingit.training.model.Training;
import com.trainingit.training.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @GetMapping(value = "/training", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Training> getTrainings() {
        return this.trainingService.getTrainings();
    }

    @PostMapping(value = "/training", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newTraining(@RequestBody Training training) {
        this.trainingService.newTraining(training);
    }

}
