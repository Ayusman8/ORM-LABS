package com.tg.ormlabs.ORM_Lab_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.ormlabs.ORM_Lab_01.entities.Training;

public interface JpaTrainingDao extends JpaRepository<Training, Long>{

}
