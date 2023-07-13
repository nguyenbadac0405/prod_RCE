package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class provider_login {
	protected WebDriver driver;

	public provider_login(WebDriver driver) {
		this.driver = driver;
	}

//	@FindBy(name="identifier")
//	public WebElement usernameMail;

	public void URL() {
		driver.get("https://stag2-rce-dashboard.gkim.digital/");
//		driver.get("https://www.google.com/");
//		WebDriverWait wait = new WebDriverWait(driver, 10);  // you can reuse this one
//
//		WebElement elem = driver.findElement(By.id("myInvisibleElement"));
//		elem.click();
//		wait.until(ExpectedConditions.visibilityOf(elem));

	}

	public void login(String password) {
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("dac+2@gkxim.com");
		driver.findElement(By.xpath("//*[@id='pwd']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='submit_login']/div/div[4]/button")).click();
		System.out.println("-------------------Provider login success---------------------");

	}
}
