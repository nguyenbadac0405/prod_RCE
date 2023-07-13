package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class pss_login {
	protected WebDriver driver;
	public pss_login(WebDriver driver) {
		this.driver = driver;	
	}
	
	@FindBy(name="username")
	public WebElement username;
	
	
	
	public void URL_intake() {
		driver.get("https://stag2-rce-dashboard.gkim.digital/");
	}
	
	public void login_intake(String password) 
	{
		username.sendKeys("dac+3@gkxim.com");
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+3@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("--------------------Login pss success.------------------------");
	}
	
}
