package com.example.EmploymentManagementSystem.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.EmploymentManagementSystem.model.Employee;
import com.example.EmploymentManagementSystem.model.PaySlip;
import com.example.EmploymentManagementSystem.repository.PaySlipRepository;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PaySlipService {

	@Autowired
	EmployeeService employeeService;
//	@Autowired
//	PaySlip paySlip;
	@Autowired
	EmployeeService empService;
	@Autowired
	PaySlipRepository paySlipRepository;

	public void processPayment() {
		List<Employee> empList = employeeService.getEmployees();
		List<PaySlip> p = new ArrayList<>();
		for(Employee e: empList) {
			if (e.isActive()) {
				PaySlip paySlip = new PaySlip();
				int basicSalary = e.getSalary().getBasicSalary();
				paySlip.setBasicSalary(basicSalary);
				int hra = basicSalary * 50 / 100;
				paySlip.setHouseRentallowance(hra);
				int da = basicSalary * 4 / 100;
				paySlip.setDearnessAllowance(da);
				int pf = basicSalary * 12 / 100;
				paySlip.setProvidentFund(pf);

				int proTax = calProTax(basicSalary);
				paySlip.setProfessionalTax(proTax);
				Integer netSalary = basicSalary + hra + da - pf + proTax;

				paySlip.setNetSalary(netSalary);
				paySlip.setEmployeeId(e.getId());
				p.add(paySlip);
				

			}
		}
		paySlipRepository.saveAll(p);

	}

	public Integer calProTax(Integer basicSalary) {
		if (basicSalary > 15000) {
			return 200;
		} else {
			return 0;
		}

	}

	// getpayslips
	public List<PaySlip> getPaySlips() {
		return paySlipRepository.findAll();
	}

	// get single payslip
	public PaySlip getPaySlip(Long id) {
		return paySlipRepository.findById(id).orElseThrow();
	}

	public void paySlipPDFGenerator(PaySlip paySlip) throws DocumentException, FileNotFoundException {
		
		Employee emp = empService.getEmployee(paySlip.getEmployeeId());
		
		OutputStream file = new FileOutputStream(new File("C:\\Users\\DEMO\\Desktop\\results.pdf"));
		Paragraph para;
		Document document = new Document();
		PdfWriter.getInstance(document, file);

		document.open();
		Font font1 = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);

		para = new Paragraph("Simplify 3x", font1);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		para = new Paragraph(
				"1st Block, Plot No # 406, 2nd floor, 7th Main, Hennur Road, Hennur Bagalur Rd, Banaswadi, "
						+ "Bengaluru, Karnataka 560043, India",
				font1);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);

		Calendar cal = Calendar.getInstance();
		Date d = new java.util.Date(cal.getTimeInMillis());
		String month = new SimpleDateFormat("MMMM").format(d);
		int year = cal.get(Calendar.YEAR);

		para = new Paragraph("Pay-slip for the month of " + month + " " + year, font1);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		document.add(Chunk.NEWLINE);

		PdfPTable table = new PdfPTable(3);
		table.getDefaultCell().setBorder(0);

		table.addCell(new Phrase("Name of Employee ", FontFactory.getFont(FontFactory.COURIER, 10)));
		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER, 10)));
		table.addCell(new Phrase(emp.getName(), FontFactory.getFont(FontFactory.COURIER, 10)));
		
		table.addCell(new Phrase("Email Address ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER,10)));
 		table.addCell(new Phrase(emp.getEmail(), FontFactory.getFont(FontFactory.COURIER,10))); 
 		
 		document.add(table);
 		
 		document.add(Chunk.NEWLINE);
 		
 		PdfPTable table1 = new PdfPTable(4);
 		
 		table1.getDefaultCell().setBorderWidth(1);
 		
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase("INCOME", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
 		table1.addCell(new Phrase("AMOUNT ", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
 		table1.addCell(new Phrase("DEDUCTIONS", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
 		table1.addCell(new Phrase("AMOUNT", FontFactory.getFont(FontFactory.COURIER_BOLD,10)));
 		
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase("Basic Salary", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase(String.valueOf(paySlip.getBasicSalary())));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase("Provident Fund ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase(String.valueOf(paySlip.getProvidentFund())));
 		
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase("Dearness Allowance ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase(String.valueOf(paySlip.getDearnessAllowance())));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase("Professional Tax", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase(String.valueOf(paySlip.getProfessionalTax())));
 		
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase("House Rent Allowance", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase(String.valueOf(paySlip.getHouseRentallowance())));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
 		
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase("Special Pay ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase("0 ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
 		
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
 		table1.addCell(new Phrase(" ", FontFactory.getFont(FontFactory.COURIER,10)));
 		table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
 		table1.addCell(new Phrase("", FontFactory.getFont(FontFactory.COURIER,10)));
 		
 		table1.addCell("  ");
        table1.addCell("  ");
        table1.addCell("  ");
        table1.addCell("  ");
        
        table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        table1.addCell(new Phrase("Total 	Earnings  ", FontFactory.getFont(FontFactory.COURIER,10)));
        table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
        table1.addCell(new Phrase(String.valueOf((paySlip.getBasicSalary() +paySlip.getDearnessAllowance()+
        		paySlip.getHouseRentallowance()))));
    	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
    	table1.addCell(new Phrase("Total Deductions ", FontFactory.getFont(FontFactory.COURIER,10)));
    	table1.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
    	table1.addCell(new Phrase(String.valueOf((paySlip.getProfessionalTax() + paySlip.getProvidentFund()))));
    	
    	document.add(table1);
    	
    	PdfPTable table3 = new PdfPTable(1);
    	
    	table3.addCell(new Phrase("Net Salary ", FontFactory.getFont(FontFactory.COURIER, 10)));
		table3.addCell(new Phrase(":", FontFactory.getFont(FontFactory.COURIER, 10)));
		table3.addCell(new Phrase(String.valueOf(paySlip.getNetSalary()), FontFactory.getFont(FontFactory.COURIER, 10)));
    	
    	document.add(table3);
    	document.close();
    	}
	
	
	public String generatePaySlip(Long id) throws Exception, DocumentException {
		PaySlip ps =getPaySlip(id);
		paySlipPDFGenerator(ps);
		return "Success";
		
	}

}
