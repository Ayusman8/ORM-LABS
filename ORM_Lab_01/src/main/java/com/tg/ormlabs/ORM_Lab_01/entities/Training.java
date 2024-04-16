package com.tg.ormlabs.ORM_Lab_01.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Training")
public class Training {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Traning_Id")
	private long trainingId;
	
	@Column(name = "Start_date")
	private String startDate;
	
	@Column(name = "End_Date")
	private String endDate;
	
	@Column(name = "Client_Name")
	private String clientName;
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Trainer_Id_FK", foreignKey = @ForeignKey(name = "Trainer_Id"))
    private Trainer trainer;
    
//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(foreignKey = @ForeignKey(name = "Trainer_Id"), name = "Trainer_Id_FK")
//	Trainer trainer;
}
