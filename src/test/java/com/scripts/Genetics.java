package com.scripts;

import com.frame.*;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

import java.awt.image.ColorModel;

public class Genetics extends DriverFactory {
	login login;
	GetDriver link;
	create_new_case_intake new_case_intake;
	new_to_assign to_assign;
	assign_to_approved to_approved;
	approved_to_complete to_complete;
	search_case search;
	log_out logout;
	assign_provider ass;
	ExcelHelpers excel;
	getInfo getinfo;
	approve_to_assign_follow_up to_AFU;
	billing billing;
	FPC_Approved fpc;

	render_name_medicare_ID render;
	

	@Override
	public void setUpforTest() {
		link = new GetDriver(driver);
		login = PageFactory.initElements(driver, login.class);
		new_case_intake = PageFactory.initElements(driver, create_new_case_intake.class);
		to_assign = PageFactory.initElements(driver, new_to_assign.class);
		to_approved = PageFactory.initElements(driver, assign_to_approved.class);
		to_complete = PageFactory.initElements(driver, approved_to_complete.class);
		search = PageFactory.initElements(driver, search_case.class);
		ass = PageFactory.initElements(driver, assign_provider.class);
		logout = PageFactory.initElements(driver, log_out.class);
		excel = new ExcelHelpers();
		getinfo = PageFactory.initElements(driver, getInfo.class);
		to_AFU = PageFactory.initElements(driver, approve_to_assign_follow_up.class);
		billing = PageFactory.initElements(driver, billing.class);
		fpc = PageFactory.initElements(driver, FPC_Approved.class);
		render = PageFactory.initElements(driver, render_name_medicare_ID.class);
	}

	
	@Test
	public void Genetics_create_case() throws Exception {
		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
//		String first_name = excel.getCellData("first_name", 1);
		String first_name = render.firtname();
//		String last_name = excel.getCellData("last_name", 1);
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = excel.getCellData("medicare_ID", 1);
		String medicare_ID = render.medicare_ID();
		String zipcode = excel.getCellData("zipcode", 1);

		login.URL_intake();
		
		login.intake("123456");
		Common.waitSec(6);
		new_case_intake.Genetics_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
		Common.waitSec(3);
		
		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: "+id);
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");
		if(status.equals("NEW")) {
			excel.setCellData("pass", 1, 1);
		}
		else {
			excel.setCellData("fail", 1, 1);
		}
		
	}

	@Test
	public void Genetics_new_to_assign() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_assign.Genetics_to_assign();	
		Common.waitSec(5);
		
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");
		if(status.equals("ASSIGNED")) {
			excel.setCellData("pass", 2, 1);
		}
		else {
			excel.setCellData("fail", 2, 1);
		}
	}
	
	@Test
	public void Genetics_assign_to_approve1() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
		login.provider("123456");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
		billing.billing();
		Common.waitSec(3);
		
		to_approved.Genetics_to_approve1(lab, type);
		Common.waitSec(3);
		
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");
		if(status.equals("APPROVED")) {
			excel.setCellData("pass", 3, 1);
		}
		else {
			excel.setCellData("fail", 3, 1);
		}
		
//		fpc.FPC();
//		Common.waitSec(3);
	}
	
	@Test
	public void Genetics_approve1_to_AFU() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_AFU.Genetics_to_RTS();
		Common.waitSec(3);
		
		logout.logout();
		Common.waitSec(5);
		login.intake("123456");
		Common.waitSec(5);
		search.search_from_intake(id);
		Common.waitSec(5);
		to_AFU.Genetics_to_Awating_Result();
		Common.waitSec(5);
		logout.logout();
		Common.waitSec(5);
		
		login.pss("111111");
		Common.waitSec(5);
		
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_AFU.Genetics_to_AFU();
		Common.waitSec(5);
		
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");
		if(status.equals("ASSIGNED FOLLOW UP")) {
			excel.setCellData("pass", 4, 1);
		}
		else {
			excel.setCellData("fail", 4, 1);
		}
		
			
	}

	@Test
	public void Genetics_to_aprrove3() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
		login.provider("123456");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_approved.to_approve3();
		Common.waitSec(3);
		
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");
		if(status.equals("APPROVED 3")) {
			excel.setCellData("pass", 5, 1);
		}
		else {
			excel.setCellData("fail", 5, 1);
		}
//		fpc.FPC();
		Common.waitSec(3);
	}
	
	@Test
	public void Genetics_to_complete() throws Exception {
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_complete.complete();
		Common.waitSec(5);
		
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");
		if(status.equals("COMPLETED BY PSS")) {
			excel.setCellData("pass", 6, 1);
		}
		else {
			excel.setCellData("fail", 6, 1);
		}
	}

	@Test
	public void genetics() throws  Exception {
		//create new case
		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
//		String first_name = excel.getCellData("first_name", 1);
		String first_name = render.firtname();
//		String last_name = excel.getCellData("last_name", 1);
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = excel.getCellData("medicare_ID", 1);
		String medicare_ID = render.medicare_ID();
		String zipcode = excel.getCellData("zipcode", 1);

		login.URL_intake();

		login.intake("123456");
		Common.waitSec(6);
		new_case_intake.Genetics_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
		Common.waitSec(3);

		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: "+id);
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");

		//new to assign
		logout.logout();
		Common.waitSec(5);
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_assign.Genetics_to_assign();
		Common.waitSec(5);

		//assign to approve 1
		logout.logout();
		Common.waitSec(5);

		login.provider("123456");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);
		billing.billing();
		Common.waitSec(3);

		to_approved.Genetics_to_approve1(lab, type);
		Common.waitSec(3);

		to_approved.patient_rate();
		Common.waitSec(3);

		//approve 1 to AFU
		logout.logout();
		Common.waitSec(5);
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_AFU.Genetics_to_RTS();
		Common.waitSec(3);

		logout.logout();
		Common.waitSec(5);
		login.intake("123456");
		Common.waitSec(5);
		search.search_from_intake(id);
		Common.waitSec(5);
		to_AFU.Genetics_to_Awating_Result();
		Common.waitSec(5);
		logout.logout();
		Common.waitSec(5);

		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_AFU.Genetics_to_AFU();
		Common.waitSec(5);

		//AFU to approve 3

		logout.logout();
		Common.waitSec(5);
		login.provider("123456");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_approved.to_approve3();
		Common.waitSec(3);

		to_approved.patient_rate();
		Common.waitSec(3);

		// approved 3 to complete
		logout.logout();
		Common.waitSec(5);
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_complete.complete();
		Common.waitSec(5);
	}
	@Test
	public void cancel() throws Exception {
		//create new case
		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
//		String first_name = excel.getCellData("first_name", 1);
		String first_name = render.firtname();
//		String last_name = excel.getCellData("last_name", 1);
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = excel.getCellData("medicare_ID", 1);
		String medicare_ID = render.medicare_ID();
		String zipcode = excel.getCellData("zipcode", 1);

		login.URL_intake();

		login.intake("123456");
		Common.waitSec(6);
		new_case_intake.Genetics_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
		Common.waitSec(3);

		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: "+id);
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");

		//new to assign
		logout.logout();
		Common.waitSec(5);
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_assign.Genetics_to_assign();
		Common.waitSec(5);

		to_assign.genetic_cancel();
		Common.waitSec(10);
	}

	@Test
	public void denied() throws Exception {
		//create new case
		Actions action = new Actions(driver);
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet1");
		String business = excel.getCellData("business", 1);
		String vertical = excel.getCellData("vertical", 1);
		String MG = excel.getCellData("MG", 1);
		String lab = excel.getCellData("lab", 1);
		String type = excel.getCellData("type", 1);
//		String first_name = excel.getCellData("first_name", 1);
		String first_name = render.firtname();
//		String last_name = excel.getCellData("last_name", 1);
		String last_name = render.lastname();
		String DOB = excel.getCellData("DOB", 1);
//		String medicare_ID = excel.getCellData("medicare_ID", 1);
		String medicare_ID = render.medicare_ID();
		String zipcode = excel.getCellData("zipcode", 1);

		login.URL_intake();

		login.intake("123456");
		Common.waitSec(6);
		new_case_intake.Genetics_create_new_case(business, vertical, MG, lab, type, first_name, last_name, DOB, medicare_ID, zipcode);
		Common.waitSec(3);

		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: "+id);
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		excel.setExcelFile("src/test/resources/Genetics.xlsx", "Sheet2");

		//new to assign
		logout.logout();
		Common.waitSec(5);
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_assign.Genetics_to_assign();
		Common.waitSec(5);

		//assign to approve 1
		logout.logout();
		Common.waitSec(5);

		login.provider("123456");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);
		billing.billing();
		Common.waitSec(3);

		to_approved.genetic_denied(lab, type);
		Common.waitSec(3);

		to_approved.patient_rate();
		Common.waitSec(3);


		logout.logout();

		login.pss("111111");
		Common.waitSec(5);

		to_complete.denied_approved(id);

		logout.logout();
		Common.waitSec(5);
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);
	}
	@Test
	public void MG_PSS_dashboard() throws Exception {
		//login intake
		login.URL_intake();
		Common.waitSec(5);
		login.intake("123456");
		Common.waitSec(5);

		login.MG_dashboard();

		Common.waitSec(10);

		login.change_link_to_pss();
		Common.waitSec(10);

		logout.logout();
		Common.waitSec(5);

		login.pss("111111");
		Common.waitSec(10);

		login.PSS_dashboard();
		Common.waitSec(10);

	}

}
