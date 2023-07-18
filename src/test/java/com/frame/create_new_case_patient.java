package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class create_new_case_patient {
	
	protected static WebDriver driver;
	public create_new_case_patient(WebDriver driver) {
		this.driver = driver;
	}
	
	public void create_new_case_MDR_patient_1() {
		//login
		System.out.println("---------------------Patient login-------------------------");
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@class='bw-chatbox-btn']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//div[text()='Sign In to continue']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//input[@class='gkc-form-control ']")).sendKeys("dac+46@gkxim.com");
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		
		
		
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/div/form/div[2]/div[1]/div/input")).sendKeys("dac");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/div/form/div[2]/div[2]/div/input")).sendKeys("ba");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div[3]/div/div/form/div[4]/input")).sendKeys("123456");
		Common.waitSec(3);
		action.sendKeys(Keys.TAB).build().perform();
		Common.waitSec(1);
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Create my account ']")).click();		
		System.out.println("--------------------------Patient login success---------------------------");
		Common.waitSec(30);
		
		//select medical
		System.out.println("--------------------------Create new case---------------------------------");
		
		driver.findElement(By.xpath(".//div[text()='Book new']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Medical Marijuana']")).click();
		Common.waitSec(2);
		System.out.println("Select medical");
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
		System.out.println("Input information");
		Actions action = new Actions(driver);
//		System.out.println("test1");
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
		last_name.sendKeys("MDR patient 1045");
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
//		System.out.println("done");
		return name;
	}
	public void create_new_case_MDR_patient_2() {
		Actions action = new Actions(driver);
		//payment
		System.out.println("Payment");
		driver.findElement(By.xpath(".//input[@value='NMI']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[1]/input")).sendKeys("dac");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[2]/input")).sendKeys("6011111111111117");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[3]/div[1]/div/input")).sendKeys("12");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[3]/div[2]/div/input")).sendKeys("23");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[3]/div[3]/div/input")).sendKeys("123");
		Common.waitSec(3);
//		driver.findElement(By.xpath(".//input[@value='AUTHORIZENET']")).click();
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/button/span")).click();
		System.out.println("Done Payment");
		Common.waitSec(10);
		
		//check booking schedule
		System.out.println("Select time booking");
		driver.findElement(By.xpath(".//input[@placeholder='Date, Month, Year']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//input[@placeholder='00:00']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/ul/li[45]")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div[2]/div/div/div[3]/button")).click();
		Common.waitSec(10);
		System.out.println("--------------------------Done new case---------------------------------");
	}
	
	public void create_new_case_MDL_patient_1() {
		//login
		System.out.println("--------------------------Patient login-----------------------------------");
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@class='bw-chatbox-btn']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//div[text()='Sign In to continue']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//input[@class='gkc-form-control ']")).sendKeys("dac+3@gkxim.com");
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
		Common.waitSec(60);
		System.out.println("--------------------------Patient login success-----------------------------------");
		//select medical
		System.out.println("--------------------------Patient start booking-----------------------------------");
		driver.findElement(By.xpath(".//div[text()='Book new']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//div[text()='Telemed']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//div[text()='This selection affects the regulation of consuming medical cannabis in particular state']")).click();
//		action.sendKeys(Keys.ENTER).build().perform();
		
		Common.waitSec(1);
		System.out.println("Select Medical");
		driver.findElement(By.xpath(".//h2[text()='Single Consultation']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(3);
	}
	public static String find_name_patient_MDL() {
		Actions action = new Actions(driver);
		//patient info
		//input new first name
		System.out.println("Input Information");
		WebElement first_name = driver.findElement(By.xpath("//*[@name='data[patient_first_name]']"));
		first_name.clear();
		Common.waitSec(1);
		first_name.sendKeys("test");
		Common.waitSec(1);
		//input new last name
		WebElement last_name = driver.findElement(By.xpath("//*[@name='data[patient_last_name]']"));
		last_name.clear();
		Common.waitSec(1);
		last_name.sendKeys("MDL patient 136");
		Common.waitSec(1);
		String id = first_name.getAttribute("value") + " " + last_name.getAttribute("value");
		//dob
		action.sendKeys(Keys.TAB).build().perform();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//span[@aria-label='August 2, 2004']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//span[text()='Male']")).click();
		Common.waitSec(1);
		
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Next']")).click();
		return id;
	}
	public void create_new_case_MDL_patient_2() {
		Actions action = new Actions(driver);
		//medical infomation
		System.out.println("Medical Information");
		driver.findElement(By.xpath(".//span[text()='Addiction']")).click();
		driver.findElement(By.xpath("/html/body/div[4]/div[3]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div/ul/li[2]/button")).click();
//		driver.findElement(By.xpath(".//input[@value='NMI']")).click();
//		System.out.println("check1");
		Common.waitSec(2);
		
		//payment
		System.out.println("Payment");
		driver.findElement(By.xpath("//*[@class='bw-form-control generic-payment-field generic-payment-card-number']")).sendKeys("4532111111111112");
//		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[3]/div[2]/input")).sendKeys("3001111111111116");
		driver.findElement(By.xpath("//*[@class='bw-form-control generic-payment-field generic-payment-month']")).sendKeys("12");
		driver.findElement(By.xpath("//*[@class='bw-form-control generic-payment-field generic-payment-year']")).sendKeys("23");
		driver.findElement(By.xpath("//*[@class='bw-form-control generic-payment-field generic-payment-cvv']")).sendKeys("123");
		driver.findElement(By.xpath("//*[@id='dcrootID']/div[3]/div[1]/div[2]/div[2]/div/div/div[2]/button")).click();
		Common.waitSec(2);
		
		//set schedule
		System.out.println("Select booking time");
		driver.findElement(By.xpath(".//input[@placeholder='Date, Month, Year']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//input[@placeholder='00:00']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div/div/div[2]/div[2]/div/ul/li[45]")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[3]/div[1]/div[2]/div[2]/div/div/div[3]/button")).click();
		Common.waitSec(10);
		System.out.println("--------------------------Done new case-----------------------------------");
	}
	
	public void change_link_to_pss() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location='https://stag2-rce-dashboard.gkim.digital/';");
		
	}

	public void MDL_patient_new_case() {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div/div/div/div[1]/div[4]/div/div/div[4]/div/div/div")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Book Now']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Next']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Submit']")).click();
		Common.waitSec(2);
		WebElement coupon = driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[4]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div[4]/div[2]/input"));
		coupon.sendKeys("RH2BYI");
		coupon.sendKeys(Keys.SPACE);
		Common.waitSec(1);
		coupon.sendKeys(Keys.BACK_SPACE);
		Common.waitSec(10);
		driver.findElement(By.xpath(".//span[text()='Pay']")).click();
		Common.waitSec(20);

		System.out.println("Select booking time");
		driver.findElement(By.xpath(".//input[@placeholder='Date, Month, Year']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//input[@placeholder='00:00']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//li[text()='8:00 PM']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Confirm']")).click();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(10);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(10);
		System.out.println("--------------------------Done new case-----------------------------------");

	}
	public String MDL_ID() {
		WebElement ID = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/ul/li[2]"));

		String case_ID = ID.getText();
		return case_ID;
	}

	public String weightloss_ID() {
		WebElement ID = driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/ul/li[1]"));

		String case_ID = ID.getText();
		return case_ID;
	}

	public void MDR_patient_new_case() {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//div[@class='gk-service-inner mobile-style']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Book Now']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[@class='gk-main-placeholder-text']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(10);
		WebElement coupon = driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[4]/div[1]/div[2]/div[2]/div/div/div[1]/div[2]/div/div[2]/div[2]/div[5]/div[2]/input"));
		coupon.sendKeys("TFL9X1");
		coupon.sendKeys(Keys.SPACE);
		Common.waitSec(1);
		coupon.sendKeys(Keys.BACK_SPACE);
		Common.waitSec(10);
		driver.findElement(By.xpath(".//span[text()='Pay']")).click();
		Common.waitSec(3);

		System.out.println("Select booking time");
		driver.findElement(By.xpath(".//input[@placeholder='Date, Month, Year']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//input[@placeholder='00:00']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//li[text()='9:00 PM']")).click();
		Common.waitSec(2);

		driver.findElement(By.xpath(".//button[text()='Confirm']")).click();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(10);
//		driver.findElement(By.xpath(".//button[text()='Save']")).click();
//		Common.waitSec(10);
		System.out.println("--------------------------Done new case-----------------------------------");
	}

	public String MDR_ID() {
		WebElement ID = driver.findElement(By.xpath("//*[@id=\"bwpBookings\"]/div[2]/div[2]/div/div[2]/div[1]/div/div/ul/li[2]"));

		String case_ID = ID.getText();
		return case_ID;
	}

	public void weightloss() {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div/div/div/div[1]/div[4]/button[2]")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div/div/div/div[1]/div[4]/div/div/div[5]/div/div/div/img")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Book Now']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Continue']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Next']")).click();
		Common.waitSec(2);
		driver.findElement(By.name("data[screening_questionnaire_question_weight]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_height]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_bp]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_bp_1]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_pulse]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_bmi]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_1]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_2]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_3]")).sendKeys("1");
		driver.findElement(By.name("data[screening_questionnaire_question_4]")).sendKeys("1");

		Common.waitSec(10);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(506, 732)", "");
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		WebElement etm1 = driver.findElement(By.xpath("/html/body/div[2]/div[7]/div[1]/div[2]/div/div/div/div[2]/div/div/div/div/div/div/div[13]/div[1]/div[1]/label/span"));
//		action.moveToElement(etm1).build().perform();
//		wait.until(ExpectedConditions.elementToBeClickable(etm1));
//		driver.findElement((By) etm1).click();
//		etm1.click();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);
		Common.waitSec(2);
		//check box 1
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		//chcek box 2
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		driver.findElement(By.name("data[screening_questionnaire_question_22_other]")).sendKeys("1");
		Common.waitSec(2);

		//check box 3
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);


		//last
		driver.findElement(By.name("data[screening_questionnaire_question_29_other]")).sendKeys("1");
		action.sendKeys(Keys.TAB).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();
		Common.waitSec(2);


		//submit
		driver.findElement(By.xpath(".//button[text()='Submit']")).click();
		Common.waitSec(2);

		driver.findElement(By.className("bw-checkbox-input")).click();
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[7]/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[1]/input")).sendKeys("4584401112661786");
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[7]/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[1]/div/input")).sendKeys("10");
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[7]/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys("25");
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[7]/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[2]/div[2]/div[2]/div[3]/div/input")).sendKeys("040");
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id=\"dcrootID\"]/div[7]/div[1]/div[2]/div[2]/div[2]/button/span")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//div[text()='Select time slot']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Schedule Call']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(10);

	}

}
