package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class new_to_assign {
	protected static WebDriver driver;
	public new_to_assign(WebDriver driver) {
		this.driver = driver;
	}
	
//	public String id;
	public void new_to_assign_MDR() {
		System.out.println("---------------------------------New to Assign------------------------------");
		//service type
		System.out.println("Check Servive type");
		driver.findElement(By.xpath("//*[@name='data[service_type_confirm]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
	
		//booking info
		System.out.println("Check Booking Info");
		driver.findElement(By.xpath("//*[@name='data[booking_information_confirm]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		
		Common.waitSec(5);
		
		//bill info(not)
		System.out.println("Check bill info");
		driver.findElement(By.xpath(".//div[text()='Payment method']")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Payment status']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath("//*[@class='form-check-input']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-md booking_info-formio-submit-button']")).click();

		Common.waitSec(5);
		
		//compliance
		System.out.println("Check Compliance");
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[4]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		//qualifying 
		System.out.println("Check Qualifying");
		driver.findElement(By.xpath(".//span[text()='Qualifying Conditions']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Glaucoma']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
//		System.out.println("check again");
//		Common.waitSec(5);
		
		//select provider
		System.out.println("Select Provider");
//		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"rec-form-collapse\"]/div/div[10]/div/div/div/div/div/div/input")).sendKeys("dac");
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
//		driver.findElement(By.xpath(".//button[text()='OK']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
//		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("-------------------------------Done Assign-------------------------------------");
		Common.waitSec(5);
	
	}
	
	public void new_to_assign_MDR_patient() {
		Actions action = new Actions(driver);
		System.out.println("---------------------------------New to Assign------------------------------");
		//service type
		System.out.println("Check Servive type");
		driver.findElement(By.xpath("//*[@name='data[service_type_confirm]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		//booking info
		System.out.println("Check Booking Info");
		driver.findElement(By.xpath("//*[@name='data[booking_information_confirm]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();

		Common.waitSec(5);

		//bill info(not)
		System.out.println("Check bill info");
		driver.findElement(By.xpath("//*[@class='form-check-input']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-md booking_info-formio-submit-button']")).click();

		Common.waitSec(5);

		//compliance
		System.out.println("Check Compliance");
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[4]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		//qualifying
		System.out.println("Check Qualifying");
		driver.findElement(By.xpath(".//span[text()='Qualifying Conditions']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Glaucoma']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// current
		driver.findElement(By.xpath(".//span[text()='Current Symptoms']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// social and family history
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[2]/div[1]/div[2]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[3]/div[1]/div[2]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[4]/div[1]/div[2]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[5]/div[1]/div[2]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[6]/div[1]/div[2]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[7]/div[1]/div[2]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[8]/div[1]/div[2]/label/input")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// verification
		driver.findElement(By.xpath(".//span[text()='Verification']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[sales_compliance_verification_consent]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		//select provider
		System.out.println("Select Provider");
//		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"rec-form-collapse\"]/div/div[10]/div/div/div/div/div/div/input")).sendKeys("dac");
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//button[text()='OK']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		Common.waitSec(1);
		System.out.println("-------------------------------Done Assign-------------------------------------");
		Common.waitSec(5);
	}
	
	public static String find_id() {
		WebElement id_case = driver.findElement(By.xpath("//*[@id='textCopied']"));
//		System.out.println(id_case.getAttribute("value"));
//		System.out.println("1");
		
//		System.out.println(id_case);
		String id = id_case.getAttribute("value");
		return id;
	}
	
	public void new_to_assign_MDL_intake() {

		//bill info
		Actions action = new Actions(driver);
		System.out.println("Check Bill info");

		driver.findElement(By.xpath(".//span[text()='Billing Information']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//div[text()='Payment method']")).click();
		Common.waitSec(1);
		System.out.println("test");
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(1);

		driver.findElement(By.xpath(".//div[text()='Payment status']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-md booking_info-formio-submit-button']")).click();

		//compliance
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		Common.waitSec(3);
		driver.findElement(By.name("data[compliance_verification_verified_patient_name]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_gender]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_dob]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_state]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_consent]")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		Common.waitSec(3);
				

			
		//select provider
		System.out.println("Select Provider");
//		Actions action = new Actions(driver);
		driver.findElement(By.xpath("//*[@id=\"rec-form-collapse\"]/div/div[10]/div/div/div/div/div/div/input")).sendKeys("dac");
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//button[text()='OK']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		Common.waitSec(1);
		System.out.println("-------------------------------Done Assign-------------------------------------");
		}

	
	public void new_to_assign_MDL_patient() {

		//bill info
		Actions action = new Actions(driver);
		System.out.println("Check Bill info");

		driver.findElement(By.xpath(".//span[text()='Billing Information']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-md booking_info-formio-submit-button']")).click();

		//compliance
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		Common.waitSec(3);
		driver.findElement(By.name("data[compliance_verification_verified_patient_name]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_gender]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_dob]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_state]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_consent]")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		Common.waitSec(3);



		//select provider
		System.out.println("Select Provider");
//		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		Common.waitSec(1);
		System.out.println("-------------------------------Done Assign-------------------------------------");
	}
	
	public void EEG_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[10]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[11]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[12]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[13]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[14]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_fulfill_communication_41589]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_willing_test_41589]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_gender_41589]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_dob_41589]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_state_41589]']")).click();
		
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		
		
		//select provider
		System.out.println("Select Provider");

		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[4]/div/div/div/div[9]/div/div/div/div[1]/div[2]/div/input")).sendKeys("dac");
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(2);
		
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}
	
	public void Covid_to_assign() {
		//compliance
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_treat_consent]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_bill_consent]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_consent]']")).click();
		driver.findElement(By.name("data[compliance_verification_verified_more_product_like][]")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		Common.waitSec(3);
		
		//selected provider
		System.out.println("Select Provider");
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[4]/div/div/div/div[9]/div/div/div/div[1]/div[2]/div/input")).sendKeys("Dac");
		Common.waitSec(13);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}
	
	public void Genetics_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[10]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[11]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[12]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[13]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[14]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_fulfill_communication_41589]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_willing_test_41589]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_gender_41589]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_dob_41589]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_state_41589]']")).click();

		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		
		
		//select provider
		System.out.println("Select Provider");

		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}
	
	public void CGM_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		driver.findElement(By.name("data[compliance_verification_verified_patient_name]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_previously_taken_genetic_test]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_previously_taken_genetic_test_1]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_fulfill_communication]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_willing_test]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_gender]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_dob]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_state]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_more_product_like][]")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		
		//selected provider
		System.out.println("Select Provider");


		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}
	
	public void Beauty_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//div[text()='Mark as Pending']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);
		//selected provider
		System.out.println("Select Provider");
		driver.findElement(By.xpath("/html/body/div/div[5]/div[2]/div[4]/div/div/div/div[10]/div/div/div/div[1]")).click();
		Common.waitSec(3);
		action.sendKeys("dac").build().perform();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}

	public void Monkeypox_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[5]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("/html/body/div/div[5]/div[3]/div[2]/div/div/div/div[1]/div[6]/div[1]/div[1]/label/input")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);


		//selected provider
		System.out.println("Select Provider");
//		Actions action = new Actions(driver);

		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}

	public void MDL_diagnosis_to_assign() {
		//compliance
		Actions action = new Actions(driver);
		driver.findElement(By.name("data[compliance_verification_verified_patient_name]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_previously_taken_genetic_test]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_previously_taken_genetic_test_1]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_fulfill_communication]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_willing_test]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_gender]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_dob]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_patient_state]")).click();
		driver.findElement(By.name("data[compliance_verification_verified_more_product_like][]")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(3);

		//selected provider
		System.out.println("Select Provider");


		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}

	public void weightloss_to_assign() {
		//selected provider
		System.out.println("Select Provider");
		Actions action = new Actions(driver);

		driver.findElement(By.xpath(".//div[text()='No Provider Available']")).click();
		Common.waitSec(2);
		action.sendKeys("dac").build().perform();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done Assign-----------------------------------");
		Common.waitSec(5);
	}

	public void genetic_cancel() {
		Actions action = new Actions(driver);
		driver.findElement(By.xpath(".//div[text()='Cancel']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Please select reason to cancel case']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Done']")).click();
	}
}


