package com.example.app.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.model.Details;
import com.example.app.repo.InvoiceDetailsREpo;

@Service
public class InvoiceDetailsService {

	@Autowired
	private InvoiceDetailsREpo invoiceDetailsREpo;

	public String store(MultipartFile attachments) throws IOException {
		File convFile = new File(attachments.getOriginalFilename());
		convFile.createNewFile();
		FileOutputStream fos = new FileOutputStream(convFile);
		fos.write(attachments.getBytes());
		fos.close();
		FileInputStream inputStream = new FileInputStream(convFile);
		Workbook workbook = WorkbookFactory.create(inputStream);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> iterator = sheet.iterator();
		int i =0;
		for (Row row : sheet) {
			i++;
			if(i!=0) {
			Details save = invoiceDetailsREpo.save(new Details(
			row.getCell(0).toString(),
			row.getCell(1).toString(),
			row.getCell(2).toString()));
			}
		}
		return "Done";
	}

	public List<Details> getInvoiceDetails() {
		return invoiceDetailsREpo.findAll();
	}
}
