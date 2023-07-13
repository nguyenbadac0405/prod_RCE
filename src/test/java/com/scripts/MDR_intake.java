package com.scripts;
import com.frame.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

public class MDR_intake extends DriverFactory {

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
		billing = PageFactory.initElements(driver, billing.class);
		fpc = PageFactory.initElements(driver, FPC_Approved.class);
	}
	
	@Test
	public void MDR_create_new_case() throws Exception  {
		
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		login.URL_intake();
		
		login.pss("111111");
		Common.waitSec(10);
		
		new_case_intake.new_case_MDR_intake();
		Common.waitSec(5);
		
		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);

	}
	
	@Test
	public void MDR_new_to_assign() throws Exception {
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);
		
		login.URL_intake();		
		
		login.pss("111111");
		Common.waitSec(15);
		
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_assign.new_to_assign_MDR();
		Common.waitSec(10);
		
	}
	
	@Test
	public void MDR_assign_to_approve() throws Exception {
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);
		
		login.URL_intake();
		
		login.provider("123456");
		Common.waitSec(15);
		search.search_from_intake(id);
		Common.waitSec(5);

		billing.billing();
		Common.waitSec(3);
		
		to_approved.ass_to_app_MDR();
		Common.waitSec(10);
		
//		fpc.FPC();
//		Common.waitSec(3);
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

		Common.waitSec(10);
		
	}
	@Test
	void MDR_intake() throws Exception {
		excel.setExcelFile("src/test/resources/MDR.xlsx", "Sheet1");
		login.URL_intake();

		login.pss("111111");
		Common.waitSec(10);

		new_case_intake.new_case_MDR_intake();
		Common.waitSec(5);

		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0); //done new

		search.search_from_intake(id);
		Common.waitSec(5);

		to_assign.new_to_assign_MDR();
		Common.waitSec(10);

		logout.logout(); //done assign

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
