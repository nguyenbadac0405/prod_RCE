package com.scripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;
import com.frame.GetDriver;
import com.frame.approved_to_complete;
import com.frame.assign_provider;
import com.frame.assign_to_approved;
import com.frame.create_new_case_intake;
import com.frame.log_out;
import com.frame.new_to_assign;
import com.frame.provider_login;
import com.frame.pss_login;
import com.frame.search_case;

public class RCE_Core_intake extends DriverFactory {
	
	pss_login pss_login;
	GetDriver link;
	create_new_case_intake new_case_intake;
	new_to_assign to_assign;
	assign_to_approved to_approved;
	approved_to_complete to_complete;
	search_case search;
	provider_login pro_login;
	log_out logout;
	assign_provider ass;

	@Override
	public void setUpforTest() {
		link = new GetDriver(driver);
		pss_login = PageFactory.initElements(driver, pss_login.class);
		new_case_intake = PageFactory.initElements(driver, create_new_case_intake.class);
		to_assign = PageFactory.initElements(driver, new_to_assign.class);
		to_approved = PageFactory.initElements(driver, assign_to_approved.class);
		to_complete = PageFactory.initElements(driver, approved_to_complete.class);
		search = PageFactory.initElements(driver, search_case.class);
		pro_login = PageFactory.initElements(driver, provider_login.class);
		ass = PageFactory.initElements(driver, assign_provider.class);
		logout = PageFactory.initElements(driver, log_out.class);
		
	}

	@Test
	public void MDR_core() {
	
		
		pss_login.URL_intake();
		
		pss_login.login_intake("111111");
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

		logout.logout();
		Common.waitSec(15);

		pro_login.login("123456");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_approved.ass_to_app_MDR();
//		System.out.println("xong approved");
		Common.waitSec(10);

		logout.logout();
		Common.waitSec(20);

		pss_login.login_intake("111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_complete.complete_case();
		Common.waitSec(10);

	}

	@Test
	public void MDL_core() {
		
		pss_login.URL_intake();

		pss_login.login_intake("111111");
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

		pro_login.login("123456");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_approved.assign_to_approved_MDL();
//		System.out.println("xong approved");
		Common.waitSec(5);

		logout.logout();
		Common.waitSec(5);

		pss_login.login_intake("111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_complete.complete_case();
		Common.waitSec(5);
	}

	
}
