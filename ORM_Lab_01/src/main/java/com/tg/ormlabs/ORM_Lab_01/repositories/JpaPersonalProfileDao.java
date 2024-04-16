package com.tg.ormlabs.ORM_Lab_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.ormlabs.ORM_Lab_01.entities.PersonalProfile;

public interface JpaPersonalProfileDao extends JpaRepository<PersonalProfile, Long>{

}
