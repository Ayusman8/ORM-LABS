package com.tg.ormlabs.ORM_Lab_01.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tg.ormlabs.ORM_Lab_01.repositories.JpaOrganizationDao;
import com.tg.ormlabs.ORM_Lab_01.entities.Organization;
import com.tg.ormlabs.ORM_Lab_01.service.OrganizationService;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Service
public class OrganizationServiceImpl implements OrganizationService{

	
	@Autowired
	private JpaOrganizationDao jpaOrganizationDao;
	@Autowired
	private EntityManager entityManager;
	
	@Override
	public Organization addOrganization(Organization organization) {
		
		return jpaOrganizationDao.save(organization);
	}

	@Override
	public Organization editOrganization(Organization organization) {

		Organization updatedOrganization = jpaOrganizationDao.findById(organization.getOrganizationId()).orElse(null);
		if (updatedOrganization != null) {
			return jpaOrganizationDao.save(organization);
		} else {
			return null;
		}
		
	}

	@Override
	public Organization getOrganizationById(long organizationId) {

		return this.jpaOrganizationDao.findById(organizationId).orElse(null);
	}

	@Override
	public Organization getOrganizationByName(String organizationName) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Organization> cq = cb.createQuery(Organization.class);
		Root<Organization> root = cq.from(Organization.class);
		cq.where(cb.equal(root.get("organizationName"), organizationName));
		CriteriaQuery<Organization> result = cq.select(root);
		TypedQuery<Organization> typedQuery = entityManager.createQuery(result);
		
		return typedQuery.getSingleResult();
	}

	@Override
	public List<Organization> getAllOrganizations() {

		return jpaOrganizationDao.findAll();
	}

	
}
