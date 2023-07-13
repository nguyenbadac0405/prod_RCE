package com.scripts;

import com.frame.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

public class RCE_Core_intake extends DriverFactory {
	
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
	approve_to_assign_follow_up to_AFU;
	@Override
	public void setUpforTest() {
		link = new GetDriver(driver);
		pss_login = PageFactory.initElements(driver, login.class);
		new_case_intake = PageFactory.initElements(driver, create_new_case_intake.class);
		to_assign = PageFactory.initElements(driver, new_to_assign.class);
		to_approved = PageFactory.initElements(driver, assign_to_approved.class);
		to_complete = PageFactory.initElements(driver, approved_to_complete.class);
		search = PageFactory.initElements(driver, search_case.class);
		
		ass = PageFactory.initElements(driver, assign_provider.class);
		logout = PageFactory.initElements(driver, log_out.class);
		excel = new ExcelHelpers();
		to_AFU = PageFactory.initElements(driver, approve_to_assign_follow_up.class);
		
	}

	@Test
	public void MDR_core() throws Exception {
		
		excel.setExcelFile("src/test/resources/test.xlsx", "Sheet1");
		
//		MDR_core = new MDR_core(driver);
		login.URL_intake();
		
		login.pss("111111");
		Common.waitSec(10);

		new_case_intake.new_case_MDR_intake();
		Common.waitSec(5);
//		System.out.println("xong new case");

		to_assign.new_to_assign_MDR();
//		System.out.println("xong assign");
		Common.waitSec(7);

		String id = to_assign.find_id();
		Common.waitSec(3);
		System.out.println("Case_ID: "+id);
		excel.setCellData(id, 1, 0);

		logout.logout();
		Common.waitSec(15);

		login.provider("123456");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_approved.ass_to_app_MDR();
//		System.out.println("xong approved");
		Common.waitSec(10);

		logout.logout();
		Common.waitSec(20);

		login.pss("111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_complete.complete_case();
		Common.waitSec(10);

	}

	@Test
	public void MDL_core() {
		
		login.URL_intake();

		login.pss("111111");
		Common.waitSec(10);

		new_case_intake.create_new_case_MDL_intake();
		Common.waitSec(5);
//		System.out.println("xong new case");

		to_assign.new_to_assign_MDL_intake();
//		System.out.println("xong assign");
		Common.waitSec(5);

		String id = to_assign.find_id();
		Common.waitSec(3);
		System.out.println("Case_ID: " +id);

		logout.logout();
		Common.waitSec(5);

		login.provider("123456");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_approved.assign_to_approved_MDL();
		Common.waitSec(5);

		logout.logout();
		Common.waitSec(5);

		login.pss("111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_complete.complete_case();
		Common.waitSec(5);
	}
	
	@Test
	public void EEG() {
		Actions action = new Actions(driver);
		login.URL_intake();
		login.intake("123456");
		Common.waitSec(5);
		new_case_intake.Covid_create_new_case();
		
		String id = to_assign.find_id();
		Common.waitSec(5);
		
		logout.logout();
		Common.waitSec(5);

		login.pss("111111");
		Common.waitSec(5);
		
		search.search_from_intake(id);
		
//		search.search_from_intake("CA-R2M0JO25");
		Common.waitSec(5);
		to_assign.Covid_to_assign();
		Common.waitSec(5);
		logout.logout();
		Common.waitSec(5);
//		pro_login.login("123456");
//		to_approved.Covid_to_approve();
//		to_AFU.EEG_to_assign_follow_up();
		to_complete.Covid_complete();
////		
		Common.waitSec(10);
		
		
		
	}

	
}
