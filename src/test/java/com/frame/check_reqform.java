package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class check_reqform {
	protected WebDriver driver;

	public check_reqform(WebDriver driver) {
		this.driver = driver;
	}

	public void reqform() {
		try

		{
			if (driver.findElement(By.xpath(".//span[text()='Genetics Reqform']")).isDisplayed()) {
				System.out.println("Genetics Reqform is displayed");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Genetics Reqform is not displayed");
		}
		try {
			if (driver.findElement(By.xpath(".//span[text()='Consent']")).isDisplayed()) {
				System.out.println("Consent is displayed");
			}

		} catch (NoSuchElementException e) {
			System.out.println("Consent is not displayed");
		}
		try {
			if (driver.findElement(By.xpath(".//span[text()='Progress Note']")).isDisplayed()) {
				System.out.println("Progress Note is displayed");
			}

		} catch (NoSuchElementException e) {
			System.out.println("Progress Note is not displayed");
		}
		try {
			if (driver.findElement(By.xpath(".//span[text()='Medication']")).isDisplayed()) {
				System.out.println("Medication is displayed");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Medication is not displayed");
		}
		try {
			if (driver.findElement(By.xpath(".//span[text()='Release of Medical Records']")).isDisplayed()) {
				System.out.println("Release of Medical Records is displayed");
			}

		} catch (NoSuchElementException e) {
			System.out.println("Release of Medical Records is not displayed");
		}
		try {
			if (driver.findElement(By.xpath(".//span[text()='Final Letter']")).isDisplayed()) {
				System.out.println("Final Letter is displayed");
			}

		} catch (NoSuchElementException e) {
			System.out.println("Final Letter is not displayed");
		}
		try {
			if (driver.findElement(By.xpath(".//span[text()='First Letter']")).isDisplayed()) {
				System.out.println("First Letter is displayed");
			} else {
				System.out.println("First Letter is not displayed");
			}
		} catch (NoSuchElementException e) {
		}
		try {
			if (driver.findElement(By.xpath(".//span[text()='LOMN']")).isDisplayed()) {
				System.out.println("LOMN is displayed");
			}
		} catch (NoSuchElementException e) {
			System.out.println("LOMN is not displayed");
		}

	}
}
