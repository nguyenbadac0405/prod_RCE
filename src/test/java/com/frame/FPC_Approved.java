package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class FPC_Approved {
	protected WebDriver driver;

	public FPC_Approved(WebDriver driver) {
		this.driver = driver;
	}
	
	public void FPC () {
//		Actions actions = new Actions(driver);
//		WebElement element = driver.findElement(By.className("d-block rce-btn py-2"));
//		actions.moveToElement(element).click().build().perform();
//		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[3]/div/button/div")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//textarea[@placeholder='Please type your reason…']")).sendKeys("test");
		driver.findElement(By.xpath(".//button[text()='Done']")).click();
		Common.waitSec(3);
		
		driver.findElement(By.xpath(".//span[text()='Assessment & Plan']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(1);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
	}
}
