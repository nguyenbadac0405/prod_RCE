package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class create_new_case_patient {
	
	protected static WebDriver driver;
	public create_new_case_patient(WebDriver driver) {
		this.driver = driver;
	}
	
	public void create_new_case_MDR_patient_1() {
		//login
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@class='bw-chatbox-btn']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//div[text()='Sign In to continue']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//input[@class='gkc-form-control ']")).sendKeys("dac+40@gkxim.com");
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/div/form/div[2]/div[1]/div/input")).sendKeys("dac");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/div/form/div[2]/div[2]/div/input")).sendKeys("ba");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/div/form/div[4]/input")).sendKeys("123456");
		Common.waitSec(3);
		action.sendKeys(Keys.TAB).build().perform();
		Common.waitSec(1);
		action.sendKeys(Keys.SPACE).build().perform();
//		driver.findElement(By.xpath(".//input[@type='checkbox']")).click();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//		js.executeScript("document.getElementByXpath(\".//input[@type='checkbox']\").setAttribute('value','true');");
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Create my account ']")).click();		
//		click.setAttribute("value", "true");
		Common.waitSec(30);
		
		//select medical
		driver.findElement(By.xpath(".//div[text()='Book new']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Medical Marijuana']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='This selection affects the regulation of consuming medical cannabis in particular state']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//h2[text()='Without Application Specialist']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(3);
	}
	public static String find_name_patient_MDR() {
		//patient info
		//input new first name
		Actions action = new Actions(driver);
		System.out.println("test1");
		WebElement first_name = driver.findElement(By.xpath("//*[@name='data[patient_first_name]']"));
		first_name.clear();
		Common.waitSec(1);
		first_name.sendKeys("test");
		Common.waitSec(1);
		//input new last name
		System.out.println("test2");
		WebElement last_name = driver.findElement(By.xpath("//*[@name='data[patient_last_name]']"));
		last_name.clear();
		Common.waitSec(1);
		last_name.sendKeys("MDR patient 1040");
		Common.waitSec(1);
		//get name patient
		String name = first_name.getAttribute("value") + " " + last_name.getAttribute("value");
		System.out.println(name);
		Common.waitSec(1);
		driver.findElement(By.xpath(".//span[text()='Male']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.TAB).build().perform();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@aria-label='August 2, 2004']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath(".//*[@name='data[patient_zip_code]']")).sendKeys("10010");
		Common.waitSec(5);
		driver.findElement(By.xpath(".//*[text()='Submit Form']")).click();
//		driver.findElement(By.xpath(".//button[text()='Submit Form']")).click();
//		driver.findElement(By.xpath(".//button[text()='Submit Form']")).click();
		Common.waitSec(1);
		System.out.println("done");
		return name;
	}
	public void create_new_case_MDR_patient_2() {
		Actions action = new Actions(driver);
		//payment
		driver.findElement(By.xpath(".//input[@value='NMI']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[1]/input")).sendKeys("dac");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[2]/input")).sendKeys("4532111111111112");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[3]/div[1]/div/input")).sendKeys("12");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[3]/div[2]/div/input")).sendKeys("23");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[3]/div[3]/div/input")).sendKeys("123");
		Common.waitSec(3);
//		driver.findElement(By.xpath(".//input[@value='AUTHORIZENET']")).click();
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/button/span")).click();
		System.out.println("done payment");
		Common.waitSec(10);
		
		//check booking schedule
		driver.findElement(By.xpath(".//input[@placeholder='Date, Month, Year']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//input[@placeholder='00:00']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/ul/li[45]")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div[2]/div/div/div[3]/button")).click();
		Common.waitSec(10);
	}
	
	public void create_new_case_MDL_patient_1() {
		//login
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@class='bw-chatbox-btn']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//div[text()='Sign In to continue']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//input[@class='gkc-form-control ']")).sendKeys("dac@gkxim.com");
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(1);
//		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/div/form/div[2]/div[1]/div/input")).sendKeys("dac");
//		Common.waitSec(1);
//		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/div/form/div[2]/div[2]/div/input")).sendKeys("ba");
//		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[2]/div/div/form/div[2]/input")).sendKeys("123456");
//		Common.waitSec(3);
//		action.sendKeys(Keys.TAB).build().perform();
//		Common.waitSec(1);
//		action.sendKeys(Keys.SPACE).build().perform();
//		driver.findElement(By.xpath("//*[@type='password']")).sendKeys("123456");
		action.sendKeys(Keys.ENTER).build().perform();
//		Common.waitSec(1);
//		driver.findElement(By.xpath(".//button[text()='Create my account ']")).click();	
		Common.waitSec(30);
		//select medical
		driver.findElement(By.xpath(".//div[text()='Book new']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//div[text()='Telemed']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//div[text()='This selection affects the regulation of consuming medical cannabis in particular state']")).click();
//		action.sendKeys(Keys.ENTER).build().perform();
		
		Common.waitSec(1);
		driver.findElement(By.xpath(".//h2[text()='Single Consultation']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(3);
	}
	public static String find_name_patient_MDL() {
		Actions action = new Actions(driver);
		//patient info
		//input new first name
		WebElement first_name = driver.findElement(By.xpath("//*[@name='data[patient_first_name]']"));
		first_name.clear();
		Common.waitSec(1);
		first_name.sendKeys("test");
		Common.waitSec(1);
		//input new last name
		WebElement last_name = driver.findElement(By.xpath("//*[@name='data[patient_last_name]']"));
		last_name.clear();
		Common.waitSec(1);
		last_name.sendKeys("MDL patient 125");
		Common.waitSec(1);
		String id = first_name.getAttribute("value") + " " + last_name.getAttribute("value");
		//dob
		action.sendKeys(Keys.TAB).build().perform();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//span[@aria-label='August 2, 2004']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//span[text()='Male']")).click();
		Common.waitSec(1);
//		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
//		Common.waitSec(1);
//		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys("10010");
//		Common.waitSec(1);
//		action.sendKeys(Keys.TAB).build().perform();
//		action.sendKeys(Keys.SPACE).build().perform();
//		driver.findElement(By.xpath(".//span[text()='Asian']")).click();
		Common.waitSec(3);
//		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
//		Common.waitSec(3);
		System.out.println("1");
//		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("152");
//		Common.waitSec(3);
		System.out.println("1");
		
//		Common.waitSec(3);
		
//		driver.findElement(By.xpath(".//span[text()='Medicare']")).click();
//		Common.waitSec(1);
//		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).click();
//		Common.waitSec(1);
//		driver.findElement(By.xpath("//*[@name='data[patient_reason_of_visit]']")).sendKeys("test");
//		Common.waitSec(100);
		System.out.println("check");
//		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		System.out.println("done");
		//get name patient
		
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Next']")).click();
		return id;
	}
	public void create_new_case_MDL_patient_2() {
		Actions action = new Actions(driver);
		//medical infomation
		driver.findElement(By.xpath(".//span[text()='Addiction']")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div/ul/li[2]/button")).click();
//		driver.findElement(By.xpath(".//input[@value='NMI']")).click();
		System.out.println("check1");
		Common.waitSec(2);
		
		//payment
		driver.findElement(By.xpath("//*[@class='bw-form-control generic-payment-field generic-payment-card-number']")).sendKeys("4532111111111112");
//		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[2]/input")).sendKeys("3001111111111116");
		driver.findElement(By.xpath("//*[@class='bw-form-control generic-payment-field generic-payment-month']")).sendKeys("12");
		driver.findElement(By.xpath("//*[@class='bw-form-control generic-payment-field generic-payment-year']")).sendKeys("23");
		driver.findElement(By.xpath("//*[@class='bw-form-control generic-payment-field generic-payment-cvv']")).sendKeys("123");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/button/span")).click();
		Common.waitSec(2);
		
		//set schedule
		driver.findElement(By.xpath(".//input[@placeholder='Date, Month, Year']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//input[@placeholder='00:00']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/ul/li[45]")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div[2]/div/div/div[3]/button")).click();
		Common.waitSec(10);
	}
	
	public void change_link_to_pss() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://stag2-rce-dashboard.gkim.digital/';");
		
	}
}
