package com.nt.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.InsurancePlans;


public interface IInsuranceRepo extends JpaRepository<InsurancePlans, Integer> {
	
	@Query("select distinct(planName) from InsurancePlans")
	                                                                     
	public List<String> getPlanName();
	
	@Query("select distinct(planStatus) from InsurancePlans")
	public List<String> getPlanStatus();

}
