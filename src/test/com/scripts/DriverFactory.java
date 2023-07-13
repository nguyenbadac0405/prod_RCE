package com.scripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.Common;
import com.frame.approved_to_complete;
import com.frame.assign_provider;
import com.frame.assign_to_approved;
import com.frame.create_new_case_intake;
import com.frame.log_out;
import com.frame.new_to_assign;
import com.frame.provider_login;
import com.frame.pss_login;
import com.frame.search_case;

public class DriverFactory {
	WebDriver driver;
	
	pss_login pss_login;
//	GetDriver link;
	create_new_case_intake n_case;
	new_to_assign to_assign;
	assign_to_approved to_approved;
	approved_to_complete to_complete;
	search_case search;
	provider_login pro_login;
	log_out logout;
	assign_provider ass;
	public void setUpforTest() {
	}
	
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","E:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();	
		setUpforTest();
		
	}
	
	@AfterMethod
	public void tearDown() {
		Common.waitSec(2);
		driver.close();
	}
}
