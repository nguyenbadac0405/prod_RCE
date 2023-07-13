package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Common;

public class assign_provider {
	protected WebDriver driver;

	public assign_provider() {
		this.driver = driver;
	}
	
	public void assign() {
		driver.findElement(By.xpath("//*[@id='react-select-34-input']")).sendKeys("thang", Keys.ENTER, Keys.ENTER);
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[3]/div[2]/div[3]/button/div")).click();
		Common.waitSec(3);
		((WebElement) driver).sendKeys(Keys.ENTER);
		System.out.println("done");
	}
}
