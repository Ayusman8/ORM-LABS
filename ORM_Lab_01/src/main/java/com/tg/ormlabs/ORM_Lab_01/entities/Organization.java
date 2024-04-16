package com.tg.ormlabs.ORM_Lab_01.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Organization")
public class Organization {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Organization_Id")
	private long organizationId;
	@Column(name = "Organization_Name")
	private String organizationName;
	@Column(name = "Website")
	private String website;
	@Column(name = "Contact_Number")
	private long contactNumber;
}
