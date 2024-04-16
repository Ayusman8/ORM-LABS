package com.tg.ormlabs.ORM_Lab_01.service;

import java.util.List;

import com.tg.ormlabs.ORM_Lab_01.entities.PersonalProfile;
import com.tg.ormlabs.ORM_Lab_01.entities.Trainer;

public interface TraningServices {

	public Trainer addTrainer(Trainer trainer);
	public Trainer updateTrainer(Trainer trainer);
	public Trainer getTrainerByTrainerId(long trainerId);
	public Trainer getTrainerByEmailId(String emailId);
	public List<Trainer> getAllTrainers();
	public Trainer getTrainerByProfileFK(long profileFK);

	public PersonalProfile addTrainersPersonalProfile(PersonalProfile profile);
	public boolean editPersonalProfile(PersonalProfile profile);
	public boolean getTrainersPersonalProfile(long trainerId);
}
