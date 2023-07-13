package com.scripts;
import org.openqa.selenium.support.PageFactory;

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

public class MDR extends DriverFactory {

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
	
	public void MDR_create_new_case() {
		pss_login.URL_intake();
		
		pss_login.login_intake("111111");
	}
}
