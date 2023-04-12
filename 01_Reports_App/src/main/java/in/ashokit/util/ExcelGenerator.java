package in.ashokit.util;

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

import in.ashokit.entity.CitizenPlan;

@Component
public class ExcelGenerator {

	 
	public void generate(HttpServletResponse response, List<CitizenPlan> records, File file) throws Exception{
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(0).setCellValue("Citizen Name");
		headerRow.createCell(0).setCellValue("Plan Name");
		headerRow.createCell(0).setCellValue("Plan Status");
		headerRow.createCell(0).setCellValue("Plan Start Date");
		headerRow.createCell(0).setCellValue("Plan End Date");
		headerRow.createCell(0).setCellValue("Benefit Amt");

		int dataRowIndex = 1;

		for (CitizenPlan plan : records) {
			Row dateRow = sheet.createRow(dataRowIndex);
			dateRow.createCell(0).setCellValue(plan.getCitizenId());
			dateRow.createCell(1).setCellValue(plan.getCitizenName());
			dateRow.createCell(2).setCellValue(plan.getPlanName());
			dateRow.createCell(3).setCellValue(plan.getPlanStatus());
			if (null != plan.getPlanStartDate()) {
				dateRow.createCell(4).setCellValue(plan.getPlanStartDate() + "");

			} else {
				dateRow.createCell(4).setCellValue("N/A");
			}

			if (null != plan.getPlanEndDate()) {
				dateRow.createCell(5).setCellValue(plan.getPlanEndDate() + "");
			} else {
				dateRow.createCell(5).setCellValue("N/A");

			}

			if (null != plan.getBenefitAmt()) {
				dateRow.createCell(6).setCellValue(plan.getBenefitAmt());
			} else {
				dateRow.createCell(6).setCellValue("N/A");
			}

			dataRowIndex++;
		}
		
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		fos.close();
			

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}
}
