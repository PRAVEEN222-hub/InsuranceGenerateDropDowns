package com.nt.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.entity.InsurancePlans;
import com.nt.fbind.SearchOperation;

public interface InsurancePlanMgmtService {
	
	public List<String> getPlanNames();
	public List<String> getPlanStatus();
	public List<InsurancePlans>  search (SearchOperation reuest);
	
	public boolean expoertExcel(HttpServletResponse response)  throws Exception;
	
	public boolean exportPdf(HttpServletResponse response)throws Exception;

}
