package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Common;
import com.frame.pss_login;
import com.frame.approved_to_complete;
import com.frame.assign_to_approved;
import com.frame.create_new_case_intake;
import com.frame.new_to_assign;
import com.frame.GetDriver;

public class search_case {
	protected WebDriver driver;

	public search_case(WebDriver driver) {
		this.driver = driver;
	}
	
	public void search_from_intake(String id) {
//		String id = new_to_assign.find_id();
//		WebElement id_case = driver.findElement(By.xpath("//input[@class='rc-search']"));
		driver.findElement(By.xpath("//input[@class='rc-search']")).sendKeys(id);
//		Actions builder = new Actions(driver);
//		builder.keyDown(id_case, Keys.CONTROL).perform();
//		builder.sendKeys(id_case, "v").perform();
//		builder.keyUp(id_case, Keys.CONTROL).perform();
		
	}
	
	
}
