package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Common;

public class login_patient_MDL {
	protected WebDriver driver;

	public login_patient_MDL(WebDriver driver) {
		this.driver = driver;
	}

	public void URL_MDL_patient() {
		driver.get("https://mdl.webcraft4u.com/wp-admin/");
	}
	
	public void login_MDL_patient() {
		driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("ian@gkxim.com");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@id='user_pass']")).sendKeys("MDL2021!!");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//a[text()=\"My Doctors Live\"]")).click();
	}
}
