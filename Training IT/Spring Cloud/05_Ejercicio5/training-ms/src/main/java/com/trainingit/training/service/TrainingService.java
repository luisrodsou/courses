package com.trainingit.training.service;

import com.trainingit.training.model.Training;

import java.util.List;

public interface TrainingService {

    List<Training> getTrainings();

    void newTraining(Training training);
    
}
