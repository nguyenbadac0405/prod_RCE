package com.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;
import com.frame.GetDriver;
import com.frame.approved_to_complete;
import com.frame.assign_provider;
import com.frame.assign_to_approved;
import com.frame.create_new_case_intake;
import com.frame.create_new_case_patient;
import com.frame.log_out;
import com.frame.login_patient_MDL;
import com.frame.login_patient_MDR;
import com.frame.new_to_assign;
import com.frame.provider_login;
import com.frame.pss_login;
import com.frame.search_case;

public class RCE_core_patient extends DriverFactory {
	
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
	create_new_case_patient new_case_patient;
	login_patient_MDR login_MDR;
	login_patient_MDL login_MDL;
	

	@Override
	public void setUpforTest() {
		link = new GetDriver(driver);
		pss_login = PageFactory.initElements(driver, pss_login.class);
//		new_case_intake = PageFactory.initElements(driver, create_new_case_intake.class);
		new_case_patient = PageFactory.initElements(driver, create_new_case_patient.class);
		to_assign = PageFactory.initElements(driver, new_to_assign.class);
		to_approved = PageFactory.initElements(driver, assign_to_approved.class);
		to_complete = PageFactory.initElements(driver, approved_to_complete.class);
		search = PageFactory.initElements(driver, search_case.class);
		pro_login = PageFactory.initElements(driver, provider_login.class);
		ass = PageFactory.initElements(driver, assign_provider.class);
		logout = PageFactory.initElements(driver, log_out.class);
		login_MDR = PageFactory.initElements(driver, login_patient_MDR.class);
		login_MDL = PageFactory.initElements(driver, login_patient_MDL.class);
//		new_case_patient = PageFactory.initElements(driver, create_new_case_patient.class);
	}
	
	@Test
	public void MDR_patient() {
		login_MDR.URL_MDR_patient();
		
		login_MDR.login_MDR_patient();
		Common.waitSec(3);
		
		new_case_patient.create_new_case_MDR_patient_1();
		Common.waitSec(3);
		
		String name = new_case_patient.find_name_patient_MDR();
		new_case_patient.create_new_case_MDR_patient_2();
		Common.waitSec(3);
		
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.CONTROL)
		
//		pss_login.URL_intake();
		
		new_case_patient.change_link_to_pss();
		Common.waitSec(10);
		
		pss_login.login_intake("111111");
		Common.waitSec(5);
		
		search.search_from_intake(name);
		Common.waitSec(5);
		
		to_assign.new_to_assign_MDR_patient();
		Common.waitSec(5);
		
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
		System.out.println("xong approved");
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
	public void MDL_patient() {
		login_MDL.URL_MDL_patient();
		
		login_MDL.login_MDL_patient();
		Common.waitSec(3);
		
		new_case_patient.create_new_case_MDL_patient_1();
		Common.waitSec(3);
		
		String name = new_case_patient.find_name_patient_MDL();
		new_case_patient.create_new_case_MDL_patient_2();
		Common.waitSec(3);
		
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.CONTROL)
		
//		pss_login.URL_intake();
		
		new_case_patient.change_link_to_pss();
		
		pss_login.login_intake("111111");
		Common.waitSec(5);
		
		search.search_from_intake(name);
		Common.waitSec(5);
		
		to_assign.new_to_assign_MDL_patient();
		Common.waitSec(5);
		
		String id = to_assign.find_id();
		Common.waitSec(3);
		System.out.println("Case_ID: " +id );

		logout.logout();
		Common.waitSec(15);

		pro_login.login("123456");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(10);

		to_approved.assign_to_approved_MDL();
//		System.out.println("xong approved");
		Common.waitSec(10);

		logout.logout();
		Common.waitSec(20);

//		pss_login.login_intake("111111");
		Common.waitSec(10);

		search.search_from_intake(id);
		Common.waitSec(5);

		to_complete.complete_case();
		Common.waitSec(5);
		
	}
	
	@Test
	public void test() {
		pss_login.URL_intake();
		Actions action = new Actions(driver);
		pss_login.login_intake("111111");
		Common.waitSec(10);
		
		String id = "CA-D4KUJX0L";
		search.search_from_intake(id);
		Common.waitSec(30);
		
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[4]/div/div/div/div[9]/div/div/div/div[1]/div[2]/div/input")).sendKeys("dac");
//		action.sendKeys("dac").build().perform();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='OK']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("done");
		Common.waitSec(10);
		
	}
}