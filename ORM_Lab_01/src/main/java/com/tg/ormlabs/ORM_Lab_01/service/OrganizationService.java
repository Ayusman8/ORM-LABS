package com.tg.ormlabs.ORM_Lab_01.service;

import java.util.List;

import com.tg.ormlabs.ORM_Lab_01.entities.Organization;

public interface OrganizationService {

	public Organization addOrganization(Organization organization);
	public Organization editOrganization(Organization organization);
	public Organization getOrganizationById(long organizationId);
	public Organization getOrganizationByName(String organizationName);
	public List<Organization> getAllOrganizations();
}