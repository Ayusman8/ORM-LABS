package com.tg.ormlabs.ORM_Lab_01.service;

import java.util.List;

import com.tg.ormlabs.ORM_Lab_01.entities.Trainer;
import com.tg.ormlabs.ORM_Lab_01.entities.Training;

public interface TrainingService {
	
	public long addTraining(Training training);
	public boolean editTraining(Training training);
	public Training getTrainingById(long trainingId);
	public boolean addTrainerToTraining(Trainer trainer, Training training);
	public Trainer getTrainerOfTraining(long trainingId);
	public List<Training> getTrainingsByClient(String clientName);
	public List<Training> getTrainingsByTrainerEmail(String emailId);
}
