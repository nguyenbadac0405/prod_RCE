package com.scripts;

import com.frame.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

public class MDL_patient extends DriverFactory {

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
		pss_login = PageFactory.initElements(driver, login.class);
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
		login = PageFactory.initElements(driver, login.class);
		billing = PageFactory.initElements(driver, billing.class);
	}
	@Test
	public void MDL_patient_new_case() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");

		login.URL_MDL();
		Common.waitSec(3);
		login.MDL_patient();
		Common.waitSec(15);
		new_case_patient.MDL_patient_new_case();
		Common.waitSec(20);
		String case_ID = new_case_patient.MDL_ID().substring(9);
		System.out.println(case_ID);

		excel.setCellData(case_ID, 1, 0);
		Common.waitSec(3);
		
	}
	@Test
	public void MDL_patient_to_assign() throws Exception {
		login.URL_intake();

		login.pss("111111");
		Common.waitSec(5);
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		String name = excel.getCellData("name", 1);
		System.out.println("Patient's name is: "+name);

		search.search_from_intake(name);
		Common.waitSec(5);

		to_assign.new_to_assign_MDL_patient();
		Common.waitSec(5);

		String id = to_assign.find_id();
		Common.waitSec(3);
		System.out.println("Case_ID: " +id );
		excel.setCellData(id, 1, 0);
	}

	@Test
	public void MDL_patient_to_approve() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);

		pss_login.URL_intake();

		login.provider("123456");
		Common.waitSec(15);
		search.search_from_intake(id);
		Common.waitSec(5);

		to_approved.assign_to_approved_MDL();
		Common.waitSec(10);

	}

	@Test
	public void complete() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);

		login.URL_intake();

		login.pss("111111");
		Common.waitSec(15);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_complete.complete_case();
		String[] info = getinfo.get_Info_MDL();
		excel.setCellData(info[0] + " " + info[1], 1, 1);
		excel.setCellData(info[0], 1, 2);
		excel.setCellData(info[1], 1, 3);
		excel.setCellData(info[2], 1, 4);
		excel.setCellData(info[3], 1, 5);
		excel.setCellData(info[4], 1, 6);
		excel.setCellData(info[5], 1, 7);
		excel.setCellData(info[6], 1, 8);
		Common.waitSec(10);

	}

	@Test
	void testlogin() throws Exception {
		login.URL_MDL();
		Common.waitSec(3);
		login.MDL_patient();
		Common.waitSec(15);
		new_case_patient.MDL_patient_new_case();
		Common.waitSec(20);
		String case_ID = new_case_patient.MDL_ID().substring(9);
		System.out.println(case_ID);
	}

	@Test
	void MDL_patient() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");

		login.URL_MDL();
		Common.waitSec(3);
		login.MDL_patient();
		Common.waitSec(15);
		new_case_patient.MDL_patient_new_case();
		Common.waitSec(30);
		String id = new_case_patient.MDL_ID().substring(9);
		System.out.println(id);

		excel.setCellData(id, 1, 0);
		Common.waitSec(3);

		login.change_link_to_pss();
		Common.waitSec(5);

		login.pss("111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_assign.new_to_assign_MDL_patient();
		Common.waitSec(10);

		logout.logout(); //done assign

		login.provider("123456");
		Common.waitSec(15);
		search.search_from_intake(id);
		Common.waitSec(5);

		billing.billing();
		Common.waitSec(3);

		to_approved.assign_to_approved_MDL();
		Common.waitSec(10);

//		to_approved.patient_rate();
		Common.waitSec(3);

		logout.logout(); //done approved

		login.pss("111111");
		Common.waitSec(15);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_complete.complete_case();
	}

	@Test
	void weightloss() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");

		login.URL_MDL();
		Common.waitSec(10);

		Common.waitSec(3);
		login.MDL_patient();
		Common.waitSec(15);
		new_case_patient.weightloss();
		Common.waitSec(120);
		String id = new_case_patient.weightloss_ID().substring(9);
		System.out.println(id);

		excel.setCellData(id, 1, 0);
		Common.waitSec(3);

		login.change_link_to_pss();
		Common.waitSec(5);

		login.pss("111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_assign.weightloss_to_assign();
		Common.waitSec(10);

		logout.logout(); //done assign

		login.provider("123456");
		Common.waitSec(15);
		search.search_from_intake(id);
		Common.waitSec(5);


		to_approved.weightloss_to_approve();
		Common.waitSec(10);

//		to_approved.patient_rate();
		Common.waitSec(3);

		logout.logout(); //done approved

		login.pss("111111");
		Common.waitSec(15);

		search.search_from_intake(id);
		Common.waitSec(5);

		driver.findElement(By.xpath(".//span[text()='Patient Information']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//span[text()='Billing Information']")).click();
		Common.waitSec(3);

		to_complete.complete_case();
		Common.waitSec(3);

	}
	@Test
	public void weightloss_new_case() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		login.URL_MDL();
		Common.waitSec(3);
		login.MDL_patient();
		Common.waitSec(15);
		new_case_patient.weightloss();
		Common.waitSec(30);
		String id = new_case_patient.MDL_ID().substring(9);
		System.out.println(id+ "done");
		excel.setCellData(id, 1, 0);

	}

	@Test
	public void weighloss_assign() throws Exception {
		login.URL_intake();

		login.pss("111111");
		Common.waitSec(5);
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_assign.weightloss_to_assign();
		Common.waitSec(10);
	}

	@Test
	public void weightloss_approved() throws Exception {
		login.URL_intake();

		login.provider("123456");
		Common.waitSec(5);

		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_approved.weightloss_to_approve();
		Common.waitSec(3);
	}

	@Test
	public void changeprice() throws Exception {
		login.URL_ADMIN();
		Common.waitSec(3);
		login.admin();
		Common.waitSec(3);

		login.change_price();
		Common.waitSec(3);

	}

	@Test
	public void backprice() throws Exception {
		login.URL_ADMIN();
		Common.waitSec(3);
		login.admin();
		Common.waitSec(3);

		login.back_price();
		Common.waitSec(3);

	}

	@Test
	public void check_ID() throws Exception {
		login.URL_MDL();
		Common.waitSec(3);

		login.MDL_patient();
		Common.waitSec(60);
		WebElement ID = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/ul/li[1]"));

		String case_ID = ID.getText();
		String id = case_ID.substring(9);
		System.out.println(id);
		Common.waitSec(3);
	}
}
