package com.frame;

import com.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login {
	protected WebDriver driver;
	public login(WebDriver driver) {
		this.driver = driver;	
	}
	
	@FindBy(name="username")
	public WebElement username;
	
	
	
	public void URL_intake() {
		driver.get("https://rcelive.gkim.digital/");
	}
	public void URL_MDL() {
		driver.get("https://mydoctorslive.com/gkim-telehealth/");
	}
	public void URL_MDR() {
		driver.get("https://mydoctorsreleaf.com/patient-profile/");
	}
	
	public void pss(String password) 
	{
		username.sendKeys("dac+3@gkxim.com");
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+3@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("--------------------Login PSS success.------------------------");
		Common.waitSec(3);
//		driver.findElement(By.xpath(".//div[@class='rce-pl-20 rce-pr-20 col d-flex flex-column']/div[2]/div[2]/div/div/div[1]/div[2]/button")).click();
	}

	public void intake(String password) 
	{
		username.sendKeys("dac+1@gkxim.com");
//		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+3@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("--------------------Login Intake success.------------------------");
	}
	public void provider(String password) {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+2@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("-------------------Provider login success---------------------");
	}

	public void MDL_patient() {
		driver.findElement(By.xpath(".//input[@autocomplete='new-password']")).sendKeys("dac+3@gkxim.com");
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div/div/div[2]/div/div/form/div[2]/div[2]/input")).sendKeys("123456789");
		driver.findElement(By.xpath(".//button[text()='Login']")).click();
	}

	public void change_link_to_pss() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://rcelive.gkim.digital/';");
	}

	public void MDR_patient() {
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[2]/i")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div/div/div[2]/div[1]/div/div")).click();
		Common.waitSec(3);

		driver.findElement(By.xpath(".//input[@autocomplete='new-password']")).sendKeys("dac+3@gkxim.com");
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[4]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div/div/form/div[2]/div[2]/input")).sendKeys("123456");
		driver.findElement(By.xpath(".//button[text()='Login']")).click();


	}
}
