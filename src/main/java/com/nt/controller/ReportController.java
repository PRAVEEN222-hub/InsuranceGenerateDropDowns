package com.nt.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.entity.InsurancePlans;
import com.nt.fbind.SearchOperation;
import com.nt.service.InsurancePlanMgmtService;

@Controller
public class ReportController {
	
	@Autowired
	private InsurancePlanMgmtService service;
	
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment;filename=plans.pdf");
		service.exportPdf(response);
	}
	
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response)throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename=plans.xlsx");
		service.expoertExcel(response);
	}
	
	
	@PostMapping("/search")
	//to add action="search" search url
	public String searchHandler( Model model, SearchOperation req) {	
		System.out.println(req);
	  List<InsurancePlans> plans = service.search(req);	  
	  model.addAttribute("plans", plans);
		init(model);		
		return "index";
	}
	
	
	@GetMapping("/home")
	//to send the the data model to ui	
	public String getHomePage(Model model) {	
		//how to send binding object to ui
	//	model.addAttribute("sh",so);
		init(model);
		return "index";
	}
	private void init(Model model) {
		model.addAttribute("sh",new SearchOperation());
		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
	}
	
}

