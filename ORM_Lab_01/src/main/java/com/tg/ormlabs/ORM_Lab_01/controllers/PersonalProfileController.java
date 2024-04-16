package com.tg.ormlabs.ORM_Lab_01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.ormlabs.ORM_Lab_01.entities.PersonalProfile;
import com.tg.ormlabs.ORM_Lab_01.entities.Trainer;
import com.tg.ormlabs.ORM_Lab_01.repositories.JpaTrainerDao;
import com.tg.ormlabs.ORM_Lab_01.service.TraningServices;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping
public class PersonalProfileController {

	@Autowired
	TraningServices service;
	@Autowired
	private JpaTrainerDao jpaTrainerDao;
	
	@PostMapping("/addpersonalprofiile")
    public ResponseEntity<String> handleData(@RequestBody PersonalProfile profile) {
        try {
        	Trainer trainer = service.getTrainerByProfileFK(profile.getProfileId());
        	if(trainer==null) {
        		service.addTrainersPersonalProfile(profile);
        	}else {
        		trainer.setPersonalProfile(profile);
    			jpaTrainerDao.save(trainer);
        	}
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error saving data: " + e.getMessage());
        }
    }
}
