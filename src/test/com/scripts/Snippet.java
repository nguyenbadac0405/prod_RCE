package com.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Snippet {
	@Test
	public void testUploadFile1() throws InterruptedException {
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://www.file.io/");
	
		  Thread.sleep(2000);
		
		  By divFileUpload = By.xpath("//div[@class='actions']");
		  By inputFileUpload = By.xpath("//div[@class='actions']/input");
		
		  driver.findElement(inputFileUpload).sendKeys(System.getProperty("user.dir") + "/src/test/resources/testdatafile/DOCX_File_01.docx");
		
		  Thread.sleep(4000);
	}
}

