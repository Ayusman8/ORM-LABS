package com.tg.ormlabs.ORM_Lab_01.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tg.ormlabs.ORM_Lab_01.entities.Organization;
import com.tg.ormlabs.ORM_Lab_01.service.OrganizationService;

@RestController
@RequestMapping
public class OrganizationController {

	@Autowired
	OrganizationService service;
	
	@PostMapping("/addorganization")
    public ResponseEntity<String> handleData(@RequestBody Organization organization) {
        try {
        	service.addOrganization(organization);
            return ResponseEntity.ok("Data saved successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error saving data: " + e.getMessage());
        }
    }
}
