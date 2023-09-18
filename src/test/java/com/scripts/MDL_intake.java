package com.scripts;
import com.frame.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;

public class MDL_intake extends DriverFactory {

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
	public void MDL_create_new_case() throws Exception  {
		
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		login.URL_intake();
		
		login.pss("111111");
		Common.waitSec(10);
		
		new_case_intake.create_new_case_MDL_intake();
		Common.waitSec(5);
		
		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: "+id);

	}
	
	@Test
	public void MDL_new_to_assign() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);
		
		login.URL_intake();		
		
		login.pss("111111");
		Common.waitSec(15);
		
		search.search_from_intake(id);
		Common.waitSec(5);
		
		to_assign.new_to_assign_MDL_intake();
		Common.waitSec(10);
		
	}
	
	@Test
	public void MDL_assign_to_approve() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		String id = excel.getCellData("id", 1);

		login.URL_intake();

		login.provider("123456");
		Common.waitSec(15);
		search.search_from_intake(id);
		Common.waitSec(5);
		
		billing.billing();
		Common.waitSec(3);
		
		to_approved.assign_to_approved_MDL();
		Common.waitSec(10);
		
//		fpc.FPC();
//		Common.waitSec(3);
		
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
//		Common.waitSec(10);
		
	}
	@Test
	void MDL_intake() throws Exception {
		excel.setExcelFile("src/test/resources/MDL.xlsx", "Sheet1");
		login.URL_intake();

		login.pss("111111");
		Common.waitSec(10);

		new_case_intake.create_new_case_MDL_intake();
		Common.waitSec(5);

		String id = to_assign.find_id();
		excel.setCellData(id, 1, 0);
		System.out.println("Case-ID: "+id);

		logout.logout(); //done new

		login.pss("111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_assign.new_to_assign_MDL_intake();
		Common.waitSec(10);

		logout.logout(); //done assign

		login.provider("123456");
		Common.waitSec(15);
		search.search_from_intake(id);
		Common.waitSec(10);

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


	
}
