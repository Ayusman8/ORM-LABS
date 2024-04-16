package com.tg.ormlabs.ORM_Lab_01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.ormlabs.ORM_Lab_01.entities.PersonalProfile;
import com.tg.ormlabs.ORM_Lab_01.entities.Trainer;
import com.tg.ormlabs.ORM_Lab_01.service.TraningServices;


@RestController
@RequestMapping
public class TrainerController {

	@Autowired
	TraningServices service;
	
	@PostMapping("/addtrainer")
    public ResponseEntity<String> handleData(@RequestBody Trainer trainer) {
        try {
        	service.addTrainer(trainer);
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error saving data: " + e.getMessage());
        }
    }
}
