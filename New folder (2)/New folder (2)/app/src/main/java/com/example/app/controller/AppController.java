package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.model.Details;
import com.example.app.service.InvoiceDetailsService;

@RestController
@RequestMapping("/service")
public class AppController {
	@Autowired
	private InvoiceDetailsService invoiceDetailseService;

	@GetMapping("/")
	public String hi() {
		return "Hi";
	}
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("attachments") MultipartFile attachments) {
		try {
			invoiceDetailseService.store(attachments);
			return ResponseEntity.status(HttpStatus.OK).body("Done");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Not done");
		}
	}

	@GetMapping("/getInvioce")
	public ResponseEntity<Object> getInVoice() {
		List<Details> invoiceDetails = invoiceDetailseService.getInvoiceDetails();
		return  new ResponseEntity<Object>(invoiceDetails, HttpStatus.OK);
	}

}
