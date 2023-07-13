package com.scripts;

import com.frame.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

public class EEG extends DriverFactory{
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
	}
	
	@Test
	public void EEG_create_case() throws Exception {
		excel.setExcelFile("src/test/resources/EEG.xlsx", "Sheet1");
		login.URL_intake();
		login.intake("123456");
		Common.waitSec(5);
		
		new_case_intake.EEG_create_new_case();
		Common.waitSec(3);
		
		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: "+id);
	}
	
	@Test
	public void EEG_new_to_assign() throws Exception {
		excel.setExcelFile("src/test/resources/EEG.xlsx", "Sheet1");
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_assign.EEG_to_assign();	
		Common.waitSec(5);
	}
	
	@Test
	public void EEG_assign_to_approve1() throws Exception {
		
		excel.setExcelFile("src/test/resources/EEG.xlsx", "Sheet1");
		login.URL_intake();
		login.provider("123456");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		billing.billing();
		Common.waitSec(3);
		
		to_approved.EEG_to_approve1();
		Common.waitSec(3);
		
		fpc.FPC();
		Common.waitSec(3);
		
	}
	
	@Test
	public void EEG_approve1_to_assign_follow_up() throws Exception {
		excel.setExcelFile("src/test/resources/EEG.xlsx", "Sheet1");
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_AFU.EEG_to_assign_follow_up();
		Common.waitSec(3);
	}
	
	@Test
	public void EEG_to_aprrove3() throws Exception {
		excel.setExcelFile("src/test/resources/EEG.xlsx", "Sheet1");
		login.URL_intake();
		login.provider("123456");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_approved.to_approve3();
		Common.waitSec(3);
		
//		fpc.FPC();
//		Common.waitSec(3);
	}
	
	@Test
	public void EEG_to_complete() throws Exception {
		excel.setExcelFile("src/test/resources/EEG.xlsx", "Sheet1");
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);
		
		String id = excel.getCellData("id", 1);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_complete.complete();
		Common.waitSec(5);
	}

	@Test
	public void EEG() throws Exception {

		//new
		excel.setExcelFile("src/test/resources/EEG.xlsx", "Sheet1");
		login.URL_intake();
		login.intake("123456");
		Common.waitSec(5);

		new_case_intake.EEG_create_new_case();
		Common.waitSec(3);

		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: "+id);

		logout.logout();
		Common.waitSec(5);

		//assign
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_assign.EEG_to_assign();
		Common.waitSec(5);

		logout.logout();
		Common.waitSec(5);

		//approve 1
		login.URL_intake();
		login.provider("123456");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		billing.billing();
		Common.waitSec(3);

		to_approved.EEG_to_approve1();
		Common.waitSec(3);

		logout.logout();
		Common.waitSec(5);

		//assign follow up
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_AFU.EEG_to_assign_follow_up();
		Common.waitSec(3);

		logout.logout();
		Common.waitSec(5);

		//complete
		login.URL_intake();
		login.pss("111111");
		Common.waitSec(5);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_complete.complete();
		Common.waitSec(5);
	}
	
	
}
