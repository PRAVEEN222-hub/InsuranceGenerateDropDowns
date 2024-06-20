package com.nt.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import com.nt.entity.InsurancePlans;

@Component
public class ExcelExport {
	
	//		List<InsurancePlans> record Bcz Ignore the data base calls
	public boolean exportExcel(HttpServletResponse response , 		List<InsurancePlans> record, File file)throws Exception {
		Workbook workbook = new HSSFWorkbook();
		Sheet createSheet = workbook.createSheet("Insurance-PlanData");
		Row headerRow = createSheet.createRow(0);
		headerRow.createCell(0).setCellValue("Insrance ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan startDate");
		headerRow.createCell(5).setCellValue("Plan EndDate");

		int dataRowIndex=1;
		for(InsurancePlans plan :record) {
			Row dataRow=createSheet.createRow(1);
			dataRow.createCell(0).setCellValue(plan.getUserId());
			dataRow.createCell(1).setCellValue(plan.getUserName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			//dataRow.createCell(3).setCellValue(plan.getPlanStatus()+"");
			if(null!=plan.getPlanStatus()) {
				dataRow.createCell(3).setCellValue(plan.getPlanStatus()+"");
			}
			else {
				dataRow.createCell(3).setCellValue("N/A");
			}
			dataRow.createCell(4).setCellValue(plan.getStartDate()+"");
			dataRow.createCell(5).setCellValue(plan.getEndDate());
			dataRowIndex++;
			//I want writedata In to file
			
			/*
			 * To read Data from not in the Browser
			 * FileOutputStream fos=new FileOutputStream(new File("plan.xls"));
			 * workbook.write(fos); 
			 * workbook.close();
			 */
			
			//this is given by in the Sysytem
			 FileOutputStream fos=new FileOutputStream(file);
			 workbook.write(fos);
			 fos.close();
			 //this is given op as browerser
			ServletOutputStream outputStream = response.getOutputStream();
			workbook.write(outputStream);
			workbook.close();
			
			
		}
		return false;
		
		
	}

}
