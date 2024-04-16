package com.tg.ormlabs.ORM_Lab_01.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.ormlabs.ORM_Lab_01.entities.Organization;

public interface JpaOrganizationDao extends JpaRepository<Organization, Long>{

}
