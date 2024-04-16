package com.tg.ormlabs.ORM_Lab_01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.ormlabs.ORM_Lab_01.entities.Trainer;
import com.tg.ormlabs.ORM_Lab_01.entities.Training;
import com.tg.ormlabs.ORM_Lab_01.repositories.JpaTrainingDao;
import com.tg.ormlabs.ORM_Lab_01.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService{

	@Autowired
	JpaTrainingDao jpaTrainingDao;
	
	@Override
	public long addTraining(Training training) {
		jpaTrainingDao.save(training);
		return training.getTrainingId();
	}

	@Override
	public boolean editTraining(Training training) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Training getTrainingById(long trainingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addTrainerToTraining(Trainer trainer, Training training) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Trainer getTrainerOfTraining(long trainingId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Training> getTrainingsByClient(String clientName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Training> getTrainingsByTrainerEmail(String emailId) {
		// TODO Auto-generated method stub
		return null;
	}

}
