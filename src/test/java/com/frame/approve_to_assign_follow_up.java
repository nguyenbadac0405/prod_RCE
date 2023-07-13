package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class approve_to_assign_follow_up {
	protected WebDriver driver;

	public approve_to_assign_follow_up(WebDriver driver) {
		this.driver = driver;
	}
	
	public void EEG_to_assign_follow_up() {
		Actions action = new Actions(driver);
//		to awaiting result 
		driver.findElement(By.xpath(".//div[text()='Approve']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//input[@value='Yes']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(10);
		//to result available
		WebElement chooseFile = driver.findElement(By.xpath(".//input[@type='file']"));
		chooseFile.sendKeys("C:/Users/dac/Downloads/file.pdf");
		Common.waitSec(5);
		//to assign follow up
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[8]/div/div[2]/div[2]/div/div[2]/div/div")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//div[text()='Forward']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		
		
	}
	
	public void Genetics_to_RTS() {
		Actions action = new Actions(driver);
//		to awaiting result 
		driver.findElement(By.xpath(".//div[text()='Approve']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//input[@value='Yes']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(10);
	}
	
	public void Genetics_to_Awating_Result() {
		Actions action = new Actions(driver);
		driver.findElement(By.id("shipped-check")).click();
		Common.waitSec(3);
		driver.findElement(By.id("kit-returned-check")).click();
		Common.waitSec(3);
		driver.findElement(By.name("is-completed")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//div[text()='Sent to Lab']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
	}

	public void Genetics_to_AFU() {
		//to result available
		Actions action = new Actions(driver);
		WebElement chooseFile = driver.findElement(By.xpath(".//input[@type='file']"));
		chooseFile.sendKeys("C:/Users/dac/Downloads/file.pdf");
		Common.waitSec(5);
		//to assign follow up
		WebElement element = driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[2]/div[7]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]"));
		action.moveToElement(element).click().build().perform();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//div[text()='Forward']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
	}
	
	
	
	
	
}
