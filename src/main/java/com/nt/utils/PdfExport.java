package com.nt.utils;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.entity.InsurancePlans;
@Component
public class PdfExport {
	
	
	public  boolean pdfGenerator(HttpServletResponse response,  List<InsurancePlans> plans) throws Exception {
		
		Document document=new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
	      document.open();
	      
	      Paragraph p=new Paragraph("Citizen Plan Info");
	      document.add(p);
	      PdfPTable table =new PdfPTable(6);
	      table.addCell("ID");
	      table.addCell("UserName");
	      table.addCell("PlanName");
	      table.addCell("Plan Status");
	      table.addCell("Start Date");
	      table.addCell("End Date");
	   
	      for(InsurancePlans plan :plans) {
	    	  table.addCell(String.valueOf(plan.getUserId()));
	          table.addCell(plan.getUserName());
	          table.addCell(plan.getPlanName());
	          table.addCell(plan.getPlanStatus());
	          table.addCell(plan.getStartDate()+"");
	          table.addCell(plan.getEndDate()+"");
	    	  
	      }
	      document.add(table);
	      document.close();
		return true;
	}
	

}
