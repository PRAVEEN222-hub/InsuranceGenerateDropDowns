package com.nt.service;


import java.io.File;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.entity.InsurancePlans;
import com.nt.fbind.SearchOperation;
import com.nt.repo.IInsuranceRepo;
import com.nt.utils.EmailUtils;
import com.nt.utils.ExcelExport;
import com.nt.utils.PdfExport;

@Service
public class IInsurancePlanMngmtserviceImpl implements InsurancePlanMgmtService {
	@Autowired
	private EmailUtils utils;
	
	@Autowired
	private IInsuranceRepo repo;
	//EXcel, Pdf are Called Helper Class
	//All class write in sevice it is diffclut so we use class
	//wt is difference btn helper class and services
	@Autowired
	private ExcelExport excel;
	
	@Autowired
	private PdfExport pdf;
	
@Override
public List<String> getPlanNames() {
	
	return repo.getPlanName() ;
}

@Override
public List<String> getPlanStatus() {

	return repo.getPlanStatus();
}

@Override
public List<InsurancePlans> search(SearchOperation reuest) {
	InsurancePlans entity=new InsurancePlans();
	if(null !=reuest.getPlanName()  && "".equals(reuest.getPlanName())) {
		entity.setPlanName(reuest.getPlanName());
	}
	if(null !=reuest.getPlanStatus() && !"".equals(reuest.getPlanStatus())) {
		entity.setPlanStatus(reuest.getPlanStatus());
	}
	if(null !=reuest.getGender() && !"".equals(reuest.getGender())) {
		entity.setGender(reuest.getGender());
	}
	if(null !=reuest.getStartDate() && !"".equals(reuest.getStartDate())) {
		
		String startDate=reuest.getStartDate();
		DateTimeFormatter formater=DateTimeFormatter.ofPattern(startDate);
				LocalDate localdate=LocalDate.parse(startDate, formater);
		entity.setStartDate(localdate);
	}
	if(null !=reuest.getEndDate() && !"".equals(reuest.getEndDate())) {
		String endDate=reuest.getEndDate();
		DateTimeFormatter formater=DateTimeFormatter.ofPattern(endDate);
		LocalDate localdate=LocalDate.parse(endDate, formater);
		
		entity.setEndDate(localdate);
	}
  return repo.findAll(Example.of(entity));
  
}@Override
public boolean expoertExcel(HttpServletResponse response ) throws Exception {
	File f=new File("plans.xls");
    List<InsurancePlans> plan = repo.findAll();
    excel.exportExcel(response, plan, f);
    
    String subject="Welcome to Reatime";
    String body="<h1> IT Is Insurance Project <h1>";
    String to="praveen7815926604@gmail.com";
    File fo=new File("plans.xls");
    utils.sendEmail(subject, body, to,fo);
	f.delete();
	return true;
}
@Override
public boolean exportPdf(HttpServletResponse response) throws Exception {
	List<InsurancePlans> plan = repo.findAll();
	
	pdf.pdfGenerator(response, plan);
	
	return true;


}
}
