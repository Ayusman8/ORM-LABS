package com.tg.ormlabs.ORM_Lab_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.ormlabs.ORM_Lab_01.entities.Trainer;

public interface JpaTrainerDao extends JpaRepository<Trainer, Long>{

}
