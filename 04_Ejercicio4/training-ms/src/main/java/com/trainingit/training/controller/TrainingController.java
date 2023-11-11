package com.trainingit.training.controller;

import com.trainingit.training.model.Training;
import com.trainingit.training.service.TrainingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Mantenimiento de formaciones.")
@RequestMapping("/training")
@RestController
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @Operation(summary = "Lista todas las formaciones.")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Training> getTrainings() {
        return this.trainingService.getTrainings();
    }

    @Operation(summary = "Realiza el alta de una nueva formación.")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void newTraining(@io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Datos la formación.") @RequestBody Training training) {
        this.trainingService.newTraining(training);
    }

}
