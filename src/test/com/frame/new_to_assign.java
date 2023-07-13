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
//		driver.findElement(By.xpath("/html/body/div/div[5]/div[2]/div[6]/div/div[3]/div/div/div/strong/span")).click();
//		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@name='data[service_type_confirm]']")).click();
//		driver.findElement(By.xpath("//*[@id='eg0f0th']/div[1]/label/input")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
//		System.out.println("check1");
		Common.waitSec(3);
	
		//booking info
		System.out.println("Check Booking Info");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[2]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[booking_information_confirm]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		
		Common.waitSec(5);
		
		//bill info(not)
		System.out.println("Check bill info");
		driver.findElement(By.xpath(".//div[text()='Payment method']")).click();
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
//		driver.findElement(By.xpath(".//div[text()='Payment method']")).sendKeys("cre", Keys.ENTER);
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Payment status']")).click();
		action.sendKeys(Keys.ENTER).build().perform();
//		driver.findElement(By.xpath(".//div[text()='Payment status']")).sendKeys("paid", Keys.ENTER);
		driver.findElement(By.xpath("//*[@class='form-check-input']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-md booking_info-formio-submit-button']")).click();
		
		//compliance
		System.out.println("Check Compliance");
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[4]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(5);
//		System.out.println("1/3");
//		driver.findElement(By.xpath("//*[@class='swal-button swal-button--confirm']")).click();
//		Common.waitSec(5);
		
		//qualifying 
		System.out.println("Check Qualifying");
		driver.findElement(By.xpath(".//*[text()='qualifying conditions']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Glaucoma']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
//		System.out.println("check again");
//		Common.waitSec(5);
		
		//select provider
		System.out.println("Assign Provider.");
		driver.findElement(By.xpath("//*[@id='rec-form-collapse']/div/div[10]/div/div/div/div[1]/div[2]/div/input")).sendKeys("dac", Keys.ENTER);
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='OK']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("----------------------------------Done Assign--------------------------------------");
		
		//save id case
//		WebElement id_case = driver.findElement(By.xpath(".//*[@data-icon='copy']"));
//		id = id_case.getAttribute("value");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[6]/div[2]/div[1]/div[1]/div/div[1]/span[1]/span/i/svg/path")).click();
//		System.out.println("check");
//		System.out.println(id);
	}
	
	public void new_to_assign_MDR_patient() {
		//service type
		System.out.println("Check Service Type");
//		driver.findElement(By.xpath("/html/body/div/div[5]/div[2]/div[6]/div/div[3]/div/div/div/strong/span")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@name='data[service_type_confirm]']")).click();
//		driver.findElement(By.xpath("//*[@id='eg0f0th']/div[1]/label/input")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
//		System.out.println("check1");
		Common.waitSec(3);
	
		//booking info
		System.out.println("Check Booking Info");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[2]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[booking_information_confirm]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(5);
		
		//bill info(not)
		System.out.println("Check Bill Info");
//		driver.findElement(By.xpath(".//div[text()='Payment method']")).click();
		Actions action = new Actions(driver);
//		action.sendKeys(Keys.ENTER).build().perform();
//		driver.findElement(By.xpath(".//div[text()='Payment method']")).sendKeys("cre", Keys.ENTER);
//		Common.waitSec(2);
//		driver.findElement(By.xpath(".//div[text()='Payment status']")).click();
//		action.sendKeys(Keys.ENTER).build().perform();
//		driver.findElement(By.xpath(".//div[text()='Payment status']")).sendKeys("paid", Keys.ENTER);
		driver.findElement(By.xpath("//*[@class='form-check-input']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-md booking_info-formio-submit-button']")).click();
		Common.waitSec(5);
		
		//compliance
		System.out.println("Check Compliance");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[4]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath("//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(5);
//		System.out.println("1/3");
//		driver.findElement(By.xpath("//*[@class='swal-button swal-button--confirm']")).click();
//		Common.waitSec(5);
		
		//qualifying 
		System.out.println("Check Qualifying");
		driver.findElement(By.xpath(".//*[text()='qualifying conditions']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Glaucoma']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
//		System.out.println("check again");
//		Common.waitSec(5);

		// current
		System.out.println("Check Current");
		driver.findElement(By.xpath(".//span[text()='current symptoms']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// social and family history
		System.out.println("Check Social and Family history");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[2]/div[1]/div[2]/label/input")).click();
//		System.out.println("1");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[3]/div[1]/div[2]/label/input")).click();
//		System.out.println("1");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[4]/div[1]/div[2]/label/input")).click();
//		System.out.println("1");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[5]/div[1]/div[2]/label/input")).click();
//		System.out.println("1");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[6]/div[1]/div[2]/label/input")).click();
//		System.out.println("1");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[7]/div[1]/div[2]/label/input")).click();
//		System.out.println("1");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[3]/div/div/div[1]/div[8]/div[1]/div[2]/label/input")).click();
//		System.out.println("1");
//		driver.findElement(By.xpath("//*[@id='e2mr6uj-e5z96nb--No']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// medical procedures and treatments
		System.out.println("Check medical procedures and treatments");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[8]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@value='Low Back surgery']")).click();
		driver.findElement(By.xpath("//*[@name='data[medical_procedures_and_treatments_list_other]']")).sendKeys("test");
		driver.findElement(By.xpath("//*[@value='Acupuncture']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// verification
		System.out.println("Check Verification");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[9]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[sales_compliance_verification_consent]']")).click();
//		driver.findElement(By.xpath("//*[@id='exc28o']/button")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
//		System.out.println("done1");
		Common.waitSec(3);
		
		//select provider
		System.out.println("Select Provider");
//		Actions action = new Actions(driver);
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[4]/div/div/div/div[9]/div/div/div/div[1]/div[2]/div/input")).sendKeys("dac");
//		action.sendKeys("dac").build().perform();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='OK']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("Done Assign");
		Common.waitSec(5);
		//save id case
//		WebElement id_case = driver.findElement(By.xpath(".//*[@data-icon='copy']"));
//		id = id_case.getAttribute("value");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[6]/div[2]/div[1]/div[1]/div/div[1]/span[1]/span/i/svg/path")).click();
//		System.out.println("check");
//		System.out.println(id);
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
		//compliance
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_treat_consent]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_bill_consent]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_consent]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
		Common.waitSec(3);
				
		//bill info
		System.out.println("Check Bill info");
		driver.findElement(By.xpath(".//span[text()='billing information']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//div[text()='Payment method']")).click();
		Common.waitSec(2);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
//		driver.findElement(By.xpath(".//div[text()='Payment method']")).sendKeys("cre", Keys.ENTER);
		Common.waitSec(1);
		driver.findElement(By.xpath(".//div[text()='Payment status']")).click();
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
////	driver.findElement(By.xpath(".//div[text()='Payment status']")).sendKeys("paid", Keys.ENTER);
//		driver.findElement(By.xpath("//*[@class='form-check-input']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-md booking_info-formio-submit-button']")).click();
			
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
		
		//compliance
		System.out.println("---------------------------------New to Assign---------------------------------------");
		System.out.println("Check Compliance");
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_name]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_gender]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_dob]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_patient_state]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_treat_consent]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_bill_consent]']")).click();
		driver.findElement(By.xpath(".//*[@name='data[compliance_verification_verified_consent]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
//		driver.findElement(By.xpath(".//button[text()='Create new']")).click();
//		Common.waitSec(3);
		
		//bill info
		System.out.println("Check Bill Info");
		driver.findElement(By.xpath(".//span[text()='billing information']")).click();
//		driver.findElement(By.xpath(".//div[text()='Payment method']")).click();
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.ENTER).build().perform();
////		driver.findElement(By.xpath(".//div[text()='Payment method']")).sendKeys("cre", Keys.ENTER);
//		Common.waitSec(2);
//		driver.findElement(By.xpath(".//div[text()='Payment status']")).click();
//		action.sendKeys(Keys.ENTER).build().perform();
////		driver.findElement(By.xpath(".//div[text()='Payment status']")).sendKeys("paid", Keys.ENTER);
//		driver.findElement(By.xpath("//*[@class='form-check-input']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@class='btn btn-primary btn-md booking_info-formio-submit-button']")).click();
		
		//select provider
		System.out.println("Select Provider");
		Actions action = new Actions(driver);
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[4]/div/div/div/div[9]/div/div/div/div[1]/div[2]/div/input")).sendKeys("dac");
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		driver.findElement(By.xpath(".//button[text()='OK']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//div[text()='Assign']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		Common.waitSec(1);
		System.out.println("--------------------------------Done Assign-----------------------------------");
	}
}


