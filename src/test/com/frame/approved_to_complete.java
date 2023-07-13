package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Common;

public class approved_to_complete {
	protected WebDriver driver;

	public approved_to_complete(WebDriver driver) {
		this.driver = driver;
	}

	public void complete_case() {
		//complete case				 //*[@id="patient-dashboard"]/div[5]/div[2]/div[1]/div[3]/div[1]/div[3]/button	
		driver.findElement(By.xpath(".//div[text()='Approve']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("----------------------PSS approved success----------------------------");
		String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
		System.out.println("------------------------------" +status+"------------------------------");
	}
}
