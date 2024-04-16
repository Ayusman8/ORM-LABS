package com.tg.ormlabs.ORM_Lab_01.entities;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Trainer")
public class Trainer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Trainer_Id")
	private long trainerId;

	@Column(name = "Full_Name")
	private String fullName;

	@Column(name = "Email_Id")
	private String emailId;

	@Column(name = "Yearly_Target")
	private float yearlyTarget;

	@Column(name = "Age")
	private int age;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "Organization_Id"), name = "Organization_Id_FK")
	private Organization organization;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(foreignKey = @ForeignKey(name = "Profile_Id"), name = "Profile_Id_FK")
	PersonalProfile personalProfile;

	@OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Training> training;
	}
