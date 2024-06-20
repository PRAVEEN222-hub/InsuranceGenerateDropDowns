package com.nt.comnd;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.InsurancePlans;
import com.nt.repo.IInsuranceRepo;
@Component
public class DataDs implements ApplicationRunner {
	  @Autowired
			private IInsuranceRepo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.deleteAll();
		
		InsurancePlans ip=new InsurancePlans();
		ip.setUserName("Cathy");
		ip.setPlanName("Food");
		ip.setPlanStatus("Approved");
		ip.setGender("Fe-Male");
		ip.setEndDate(LocalDate.now().plusMonths(2));
		ip.setStartDate(LocalDate.now().minusMonths(6));
		InsurancePlans ip1=new InsurancePlans();
		ip1.setUserName("Buttler");
		ip1.setPlanName("Madeicar");
		ip1.setPlanStatus("Approved");
		ip1.setGender("Male");
		ip1.setEndDate(LocalDate.now().plusMonths(2));
		ip1.setStartDate(LocalDate.now().minusMonths(6));
		InsurancePlans ip2=new InsurancePlans();
		ip2.setUserName("Leo");
		ip2.setPlanName("Madical");
		ip2.setPlanStatus("Terminate");
		ip2.setGender("Fe-Male");
		ip2.setEndDate(LocalDate.now().plusMonths(2));
		ip2.setStartDate(LocalDate.now().minusMonths(6));
	  
		List<InsurancePlans> asList = Arrays.asList(ip,ip1,ip2);
		repo.saveAll(asList);
	 

	}

}
