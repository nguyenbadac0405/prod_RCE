package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Common;

public class getInfo {
	protected static WebDriver driver;

	public getInfo(WebDriver driver) {
		this.driver = driver;
	}
	
	public static String[] get_Info_MDR() {
		
		driver.findElement(By.xpath(".//span[text()='patient information']")).click();
		Common.waitSec(2);
		String[] info = new String[7];
		info[0] = driver.findElement(By.xpath("//input[@name='data[patient_first_name]']")).getAttribute("value");
		info[1] = driver.findElement(By.xpath("//input[@name='data[patient_last_name]']")).getAttribute("value");
		info[2] = driver.findElement(By.xpath("//input[@name='data[patient_dob]']")).getAttribute("value");
		info[3] = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div[2]/div/div/div[1]/div[5]/div[1]/div[1]/label/input")).getAttribute("value");
		info[4] = driver.findElement(By.xpath("//input[@name='data[patient_address]']")).getAttribute("value");
		info[5] = driver.findElement(By.xpath("//input[@name='data[patient_zip_code]']")).getAttribute("value");
//		info[6] = driver.findElement(By.xpath("//input[@name='data[patient_primary_insurance_id]']")).getAttribute("value");
		return info;
	}
	
public static String[] get_Info_MDL() {
		
		driver.findElement(By.xpath(".//span[text()='patient information']")).click();
		Common.waitSec(2);
		String[] info = new String[7];
		info[0] = driver.findElement(By.xpath("//input[@name='data[patient_first_name]']")).getAttribute("value");
		info[1] = driver.findElement(By.xpath("//input[@name='data[patient_last_name]']")).getAttribute("value");
		info[2] = driver.findElement(By.xpath("//input[@name='data[patient_dob]']")).getAttribute("value");
		info[3] = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div[2]/div/div/div[1]/div[5]/div[1]/div[1]/label/input")).getAttribute("value");
		info[4] = driver.findElement(By.xpath("//input[@name='data[patient_address]']")).getAttribute("value");
		info[5] = driver.findElement(By.xpath("//input[@name='data[patient_zip_code]']")).getAttribute("value");
		info[6] = driver.findElement(By.xpath("//input[@name='data[patient_primary_insurance_id]']")).getAttribute("value");
		return info;
	}
}
