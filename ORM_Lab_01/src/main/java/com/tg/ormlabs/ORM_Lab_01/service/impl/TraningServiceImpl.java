package com.tg.ormlabs.ORM_Lab_01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.ormlabs.ORM_Lab_01.entities.PersonalProfile;
import com.tg.ormlabs.ORM_Lab_01.entities.Trainer;
import com.tg.ormlabs.ORM_Lab_01.repositories.JpaPersonalProfileDao;
import com.tg.ormlabs.ORM_Lab_01.repositories.JpaTrainerDao;
import com.tg.ormlabs.ORM_Lab_01.service.TraningServices;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


@Service
public class TraningServiceImpl implements TraningServices{

	@Autowired
	private JpaTrainerDao jpaTrainerDao;
	@Autowired
	private JpaPersonalProfileDao jpaPersonalProfileDao;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Trainer addTrainer(Trainer trainer) {
		
		return jpaTrainerDao.save(trainer);
	}

	@Override
	public Trainer updateTrainer(Trainer trainer) {
		
		Trainer updatedTrainer = jpaTrainerDao.findById(trainer.getTrainerId()).orElse(null);
		if (updatedTrainer != null) {
			return jpaTrainerDao.save(trainer);
		} else {
			return null;
		}
	}

	@Override
	public Trainer getTrainerByTrainerId(long trainerId) {
		
		return this.jpaTrainerDao.findById(trainerId).orElse(null);
	}

	@Override
	public Trainer getTrainerByEmailId(String emailId) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Trainer> cq = cb.createQuery(Trainer.class);
		Root<Trainer> root = cq.from(Trainer.class);
		cq.where(cb.equal(root.get("emailId"), emailId));
		CriteriaQuery<Trainer> result = cq.select(root);
		TypedQuery<Trainer> typedQuery = entityManager.createQuery(result);
		return typedQuery.getSingleResult();
	}
	
	@Override
	public Trainer getTrainerByProfileFK(long profileFK) {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Trainer> cq = cb.createQuery(Trainer.class);
		Root<Trainer> root = cq.from(Trainer.class);
		cq.where(cb.equal(root.get("Profile_Id_FK"), profileFK));
		CriteriaQuery<Trainer> result = cq.select(root);
		TypedQuery<Trainer> typedQuery = entityManager.createQuery(result);
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Trainer> getAllTrainers() {

		return jpaTrainerDao.findAll();
	}

	@Override
	public PersonalProfile addTrainersPersonalProfile(PersonalProfile profile) {
		return jpaPersonalProfileDao.save(profile);
	}

	@Override
	public boolean editPersonalProfile(PersonalProfile profile) {

		return false;
	}

	@Override
	public boolean getTrainersPersonalProfile(long trainerId) {

		return false;
	}

}
