package com.tg.ormlabs.ORM_Lab_01.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Personal_Profile")
public class PersonalProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Profile_Id")
	private long profileId;
	
	@Column(name = "Mobile_No")
	private long mobileNumber;
	
	@Column(name = "Is_Relocate")
	private boolean isRelocate;
	
	@Column(name = "Date_Of_Birth")
	private String dateOfBirth;
}
