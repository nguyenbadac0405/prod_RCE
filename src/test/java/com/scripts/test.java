package com.scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;
import com.frame.CreateExcelfile;
import com.frame.GetDriver;
import com.frame.create_new_case_intake;
import com.frame.login;

public class test {
	login login;
	create_new_case_intake new_case;
	WebDriver driver;
	GetDriver link;
	CreateExcelfile excel;
	@Test
	public void test() {
		link = new GetDriver(driver);
		login = PageFactory.initElements(driver, login.class);
		new_case = PageFactory.initElements(driver, create_new_case_intake.class);
		// Using get() method to open a webpage
//		driver.get("https://anhtester.com");
		login.URL_intake();
		Common.waitSec(10);
		new_case.create_new_case_MDL_intake();
		Common.waitSec(10);
		// Closing the browser
//		driver.quit();

	}
	
	@Test
	public void test1() {
		excel = PageFactory.initElements(driver, CreateExcelfile.class);
		excel.excel();
	}
}
