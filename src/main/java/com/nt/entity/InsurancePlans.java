package com.nt.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Insurance_Plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsurancePlans {
	@Id
	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer userId;
      private String userName;
	private String planName;
	private String planStatus;
	private String gender;
	private Double benfitAmt;
	private LocalDate startDate;
	private LocalDate endDate;
	
	
}
