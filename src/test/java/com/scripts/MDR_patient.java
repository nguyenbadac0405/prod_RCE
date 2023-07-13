package com.scripts;

import com.frame.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

public class MDR_patient extends DriverFactory {

	login login;
	GetDriver link;
	create_new_case_intake new_case_intake;
	new_to_assign to_assign;
	assign_to_approved to_approved;
	approved_to_complete to_complete;
	search_case search;
	log_out logout;
	assign_provider ass;
	create_new_case_patient new_case_patient;
	login_patient_MDR login_MDR;
	login_patient_MDL login_MDL;
	ExcelHelpers excel;
	getInfo getinfo;
	

	@Override
	public void setUpforTest() {
		link = new GetDriver(driver);
		login = PageFactory.initElements(driver, login.class);
//		new_case_intake = PageFactory.initElements(driver, create_new_case_intake.class);
		new_case_patient = PageFactory.initElements(driver, create_new_case_patient.class);
		to_assign = PageFactory.initElements(driver, new_to_assign.class);
		to_approved = PageFactory.initElements(driver, assign_to_approved.class);
		to_complete = PageFactory.initElements(driver, approved_to_complete.class);
		search = PageFactory.initElements(driver, search_case.class);
		ass = PageFactory.initElements(driver, assign_provider.class);
		logout = PageFactory.initElements(driver, log_out.class);
		login_MDR = PageFactory.initElements(driver, login_patient_MDR.class);
		login_MDL = PageFactory.initElements(driver, login_patient_MDL.class);
//		new_case_patient = PageFactory.initElements(driver, create_new_case_patient.class);
		excel = new ExcelHelpers();
		getinfo = PageFactory.initElements(driver, getInfo.class);
	}
	
	@Test
	public void MDR_patient_new_case() throws Exception {
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		
		login_MDR.URL_MDR_patient();
		
		login_MDR.login_MDR_patient();
		Common.waitSec(5);
		
		new_case_patient.create_new_case_MDR_patient_1();
		Common.waitSec(3);
		
		String name = new_case_patient.find_name_patient_MDR();
		excel.setCellData(name, 1, 1);
		new_case_patient.create_new_case_MDR_patient_2();
		Common.waitSec(3);
		
	}
	@Test
	public void MDR_patient_to_assign() throws Exception {
		login.URL_intake();
		
		login.pss("111111");
		Common.waitSec(5);
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_assign.new_to_assign_MDR_patient();
		Common.waitSec(5);

	}
	
	@Test
	public void MDR_patient_to_approve() throws Exception {
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);
		
		login.URL_intake();
		
		login.provider("123456");
		Common.waitSec(15);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_approved.ass_to_app_MDR();
		Common.waitSec(10);
		
	}
	
	@Test
	public void complete() throws Exception {
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);
		
		login.URL_intake();		
		
		login.pss("111111");
		Common.waitSec(15);
		
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_complete.complete_case();
		String[] info = getinfo.get_Info_MDR();
		excel.setCellData(info[0] + " " + info[1], 1, 1);
		excel.setCellData(info[0], 1, 2);
		excel.setCellData(info[1], 1, 3);
		excel.setCellData(info[2], 1, 4);
		excel.setCellData(info[3], 1, 5);
		excel.setCellData(info[4], 1, 6);
		excel.setCellData(info[5], 1, 7);
//		excel.setCellData(info[6], 1, 8);
		Common.waitSec(10);
		
	}

	@Test
	public void test_MDR() {
		login.URL_MDR();
		Common.waitSec(5);
		login.MDR_patient();
		Common.waitSec(10);
		System.out.println("done");
		String id = new_case_patient.MDR_ID().substring(9);
		System.out.println(id);
	}

	@Test
	void MDR_patient() throws Exception {
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		login.URL_MDR();
		Common.waitSec(5);
		login.MDR_patient();
		Common.waitSec(10);
		System.out.println("done");
		new_case_patient.MDR_patient_new_case();
		Common.waitSec(10);
		String id = new_case_patient.MDR_ID().substring(9);
		System.out.println(id);

		login.change_link_to_pss();

		login.pss("111111");
		Common.waitSec(10);
		search.search_from_intake(id);
		to_assign.new_to_assign_MDR_patient();
		logout.logout();

		login.provider("123456");
		Common.waitSec(15);
		search.search_from_intake(id);
		Common.waitSec(5);

		billing.billing();
		Common.waitSec(3);

		to_approved.ass_to_app_MDR();
		Common.waitSec(10);

		logout.logout(); //done approved

		login.pss("111111");
		Common.waitSec(15);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_complete.complete_case();

	}
}
