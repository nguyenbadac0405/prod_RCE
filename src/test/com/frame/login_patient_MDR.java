package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Common;

public class login_patient_MDR {
	protected WebDriver driver;

	public login_patient_MDR(WebDriver driver) {
		this.driver = driver;
	}

	public void URL_MDR_patient() {
		driver.get("https://gtmw.pl/wp-admin");
	}
	
	public void login_MDR_patient() {
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("loc@gkim.digital");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys("xi!zpYZ0UCHy37FdP1WY!P4f");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//a[text()=\"My Doctor's Releaf\"]")).click();
	}
	
}
