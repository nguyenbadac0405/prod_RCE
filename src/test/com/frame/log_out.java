package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;
import com.frame.pss_login;
import com.frame.approved_to_complete;
import com.frame.assign_provider;
import com.frame.assign_to_approved;
import com.frame.create_new_case_intake;
import com.frame.new_to_assign;
import com.frame.provider_login;
import com.frame.search_case;
import com.frame.GetDriver;

public class log_out {
	protected WebDriver driver;
	public log_out(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logout() {
		driver.findElement(By.xpath("//*[@id='logout-menu']")).click();
//		Common.waitSec(30);
	}
}
