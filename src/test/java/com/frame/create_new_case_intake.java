package com.frame;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import com.Common;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class create_new_case_intake {
	protected WebDriver driver;
	
	public create_new_case_intake(WebDriver driver) {
		this.driver = driver;
	}

	public void new_case_MDR_intake() {
		
		Actions action = new Actions(driver);
		System.out.println("----------------------Create New case MDR-------------------------");
		Common.waitSec(5);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {

			add_case.click();

		}

		Common.waitSec(3);
		// create draft
		// set business
		Common.waitSec(5);
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys("MDR");
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-7-input']")).sendKeys("Medical");
//		System.out.println("toi day di");
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-9-input']")).sendKeys("GKIM Test");
//		System.out.println("toi day luon");
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys("without");
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(2);
		
		// set state
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[3]/div/div/div/div[8]/div/div/div/div[1]/div[2]/div/input")).sendKeys("ok");
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("Done business and vertical");
		
		// info patient
		// name & gender
		System.out.println("Input information of Patient");
		String first_name = "Test "
				+ "";
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
//		System.out.println("toi day di pls");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		String last_name = "MDR";
		String full_name = first_name + " "+ last_name;
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);

		String name = driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).getAttribute("value") +" "+ driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).getAttribute("value");
		Common.waitSec(1);
		
		// date of birth.
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys("08/08/2004");
		Common.waitSec(1);
//		Common.waitSec(3);
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys("10010");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		String in_id = "6TR7FG7RT65";
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(in_id);
		Common.waitSec(1);

		// reason visit
		driver.findElement(By.xpath(".//span[text()='Reason of Visit']")).click();
		Common.waitSec(3);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("-------------Done Draft case---------------");

		
		Common.waitSec(3);
		
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		
		Common.waitSec(7);

		// draft to new
		// medical
		System.out.println("Draft to new");
		driver.findElement(By.xpath(".//span[text()='Medical History']")).click();
		driver.findElement(By.xpath("//*[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);

		// family
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[5]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_sale]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
//		System.out.println("toi day");

		// medication
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[4]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='shipped']")).click();
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
		Common.waitSec(3);

		// current
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[6]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// social and family history
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
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[8]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@value='Low Back surgery']")).click();
		driver.findElement(By.xpath("//*[@name='data[medical_procedures_and_treatments_list_other]']")).sendKeys("test");
		driver.findElement(By.xpath("//*[@value='Acupuncture']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// verification
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[6]/div/div[9]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[sales_compliance_verification_consent]']")).click();
//		driver.findElement(By.xpath("//*[@id='exc28o']/button")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
//		System.out.println("done");
		Common.waitSec(3);
		// copy id
//		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[1]/span/i/svg")).click();
		Common.waitSec(3);
		// submit
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[3]/div/div[3]/button")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath("//button[@class='swal-button swal-button--confirm']")).click();
		Common.waitSec(3);
		System.out.println("--------------------------Done new case.----------------------------");

	}

	public void create_new_case_MDL_intake() {
		System.out.println("------------------------------Create NEW case MDL------------------------------------");
		Common.waitSec(4);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
			add_case.click();
		}

		Common.waitSec(5);
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys("MDL", Keys.ENTER);
		Common.waitSec(1);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-7-input']")).sendKeys("Telemed", Keys.ENTER);
		Common.waitSec(1);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-9-input']")).sendKeys("GKIM", Keys.ENTER);
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys("single", Keys.ENTER);
		Common.waitSec(3);

		// set state
//		driver.findElement(By.xpath("//*[@id='react-select-12-input']")).sendKeys("mdl", Keys.ENTER);
//		System.out.println("da toi day");
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name & gender
		String first_name = "Test MDL";
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		String last_name = "from intake 1";
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
		// date of birth.
		String birthday = "07/29/2004";
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(birthday);
		Common.waitSec(3);
		
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys("10010");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		// ethnicity
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);
		// height & weight
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		String in_id = "6TR7FG7RT65";
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(in_id);
		Common.waitSec(1);

		// reason visit
		driver.findElement(By.xpath("//*[@name='data[patient_reason_of_visit]']")).sendKeys("test");
			
		Common.waitSec(3);			
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		System.out.println("-----------------Done draft case------------------");
		Common.waitSec(5);
		
		//draft to new
		
		//pcp
		System.out.println("-------------Draft to new----------------");
		driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(2);
		
		//patient medical history
		driver.findElement(By.xpath(".//*[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		
		//existing medications
		driver.findElement(By.xpath(".//*[@name='shipped']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(3);
		
		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("------------------------------Done new case.-----------------------------------");
		Common.waitSec(5);
	}
	
	
	public void EEG_create_new_case() {
		
		//draft case
		System.out.println("------------------------------Create NEW case------------------------------------");
		System.out.println("Set Business & Vertical");
		Common.waitSec(5);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
//			System.out.println("123");
			add_case.click();
//			System.out.println("toi day chua???");
		}

		// create draft
		// set business
		Common.waitSec(5);
		driver.findElement(By.xpath("//*[@id='react-select-5-input']")).sendKeys("eeg", Keys.ENTER);
		Common.waitSec(1);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys("v", Keys.ENTER);
//		System.out.println("toi day di");
		Common.waitSec(1);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-8-input']")).sendKeys("GKIM", Keys.ENTER);
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-10-input']")).sendKeys("eeg", Keys.ENTER);
		Common.waitSec(3);

		// set state
		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys("pa", Keys.ENTER);
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name
		System.out.println("Input Information");
		String first_name = "Test";
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
		
		String last_name = "EEG";
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
	
		// date of birth.
		String birthday = "07/29/2004";
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(birthday);
		Common.waitSec(3);

		
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		String in_id = "6TR7FG7RT65";
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(in_id);
		String insurance_id = driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).getAttribute("value");
		Common.waitSec(1);
		
		//gender & ethnicity
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);
		
		// height & weight
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);
				
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys("10010");
		Common.waitSec(1);
				
		//phone
		driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
		driver.findElement(By.xpath("//input[@name='data[patient_phone]']")).sendKeys("5864565645");

		// reason visit
//		driver.findElement(By.xpath("//*[@name='data[patient_reason_of_visit]']")).sendKeys("test");
		System.out.println("-----------------Done draft case------------------");
		
		Common.waitSec(3);
//				
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		
//		draft to new
		//pcp
		System.out.println("-------------Draft to new----------------");
		System.out.println("Check PCP");
		driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(2);
		
		//Ambulatory EEG
		System.out.println("Check Ambulatory EEG");
		driver.findElement(By.xpath("//input[@name='data[ambulatory_eeg_length_confirm]']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		
		//Medical History
		System.out.println("Check Medical History");
		driver.findElement(By.xpath("//input[@name='data[patient_personal_history_medical_management_consideration]']")).sendKeys("test");
		Common.waitSec(1);
		driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		
		//Family History
		System.out.println("Check Family History");
		driver.findElement(By.xpath(".//span[text()='Family History']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		
		//Medication
		System.out.println("Check Medication");
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
		Common.waitSec(3);
		
		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
//		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("------------------------------Done new case.-----------------------------------");
		Common.waitSec(5);
	}
	
	public void Covid_create_new_case() {
		Actions action = new Actions(driver);
		//draft case
		System.out.println("------------------------------Create NEW case------------------------------------");
		
		Common.waitSec(5);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
			add_case.click();
		}
		System.out.println("Set Business & Vertical");
		// create draft
		// set business
		Common.waitSec(5);
		driver.findElement(By.xpath("//*[@id='react-select-5-input']")).sendKeys("covid", Keys.ENTER);
//		System.out.println("toi day roi ne`");
		Common.waitSec(1);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys("covid", Keys.ENTER);
//		System.out.println("toi day di");
		Common.waitSec(1);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-8-input']")).sendKeys("test", Keys.ENTER);
//		System.out.println("toi day luon");
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-10-input']")).sendKeys("covid", Keys.ENTER);
		Common.waitSec(3);

		// set state

		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys("covid", Keys.ENTER);
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name
		System.out.println("Input Information");
		String first_name = "Test";
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
			
		String last_name = "Covid";
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
		// date of birth.
		String birthday = "07/29/2004";
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(birthday);
//		System.out.printlns("di ne`");
		Common.waitSec(3);
		driver.findElement(By.xpath(".//input[@name='data[patient_order_id]']")).sendKeys("123");
		driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[3]/div[2]/div[2]/div/div/div[1]/div[7]/div[1]/div[1]/label/input")).click();
//		Common.waitSec(3);
				
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		String in_id = "1TE2TR3DC70";
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(in_id);
		Common.waitSec(1);
				
		//gender & ethnicity
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);
				
		// height & weight
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);
				
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys("10010");
		Common.waitSec(1);
				
		//phone
		driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
		driver.findElement(By.xpath("//input[@name='data[patient_phone]']")).sendKeys("5864565645");
		Common.waitSec(3);
			
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		System.out.println("-----------------Done draft case------------------");
		Common.waitSec(5);
		
		//draft to new
		//test requirement
		System.out.println("Check Test Requirement");
		driver.findElement(By.xpath(".//span[text()='Test Requirements']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//input[@name='data[test_requirements_test_ordered][]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		
		//Medications
		System.out.println("Check Medications");
		driver.findElement(By.xpath(".//span[text()='Medications']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(3);
		
		//verification
		System.out.println("Check Verification");
		driver.findElement(By.xpath(".//input[@name='data[sales_agent_verification_consent]']")).click();
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		
		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
//		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("-----------------------------------------Done new case---------------------------------------------");
	}
	
	public void Genetics_create_new_case(String business, String vertical, String MG, String type, String lab, String first_name, String last_name, String DOB, String medicare_ID, String zipcode) {
		Actions action = new Actions(driver);
		//draft case
		System.out.println("------------------------------Create NEW case------------------------------------");
		
		Common.waitSec(10);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
			add_case.click();
		}

		// create draft
		// set business
		Common.waitSec(5);
		System.out.println("Set Business & Vertical");
		driver.findElement(By.xpath("//*[@id='react-select-5-input']")).sendKeys(business, Keys.ENTER);
		Common.waitSec(2);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys(vertical, Keys.ENTER);
		Common.waitSec(2);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-7-input']")).sendKeys(MG, Keys.ENTER);
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-9-input']")).sendKeys(type, Keys.ENTER);
		Common.waitSec(3);

		// set state
		driver.findElement(By.xpath("//*[@id='react-select-10-input']")).sendKeys(lab, Keys.ENTER);
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name
		System.out.println("Input Information");
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
		// date of birth.
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(DOB);
		Common.waitSec(1);
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(medicare_ID);
		Common.waitSec(1);
		
		//gender & ethnicity
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);
		
		// height & weight
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);
				
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys(zipcode);
		Common.waitSec(1);
				
		//phone
		driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
		driver.findElement(By.xpath("//input[@name='data[patient_phone]']")).sendKeys("5864565645");
		Common.waitSec(3);	
					
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		System.out.println("-----------------Done draft case------------------");
		System.out.println(lab);
		//draft to new
		
		//TEST TYPE CGX
		if (type.equals("CGX")) {
			//LAB CGX 1
			if (lab.equals("CGX - R&D")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Medical History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
			}
			
			//LAB 2
			if (lab.equals("CGX - Biogroup")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test Requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_checkbox]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medical History
				driver.findElement(By.xpath(".//span[text()='Medical History']")).click();

				Common.waitSec(2);
				System.out.println("Check Medical History");
				driver.findElement((By.name("data[medical_history_patient_cancer1]"))).sendKeys("test");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[submit]")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//span[text()='Family History']")).click();
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.name("data[family_history_member_1_cancer_type]")).sendKeys("test");
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);

				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.name("data[submit]")).click();
				Common.waitSec(3);
			}
			
			//LAB CGX 3
			if (lab.equals("CGX - Brookside")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);

				//Test Requirement
				driver.findElement(By.name("data[test_requirements_breast_cancer]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medical History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}

			//LAB CGX 4
			if (lab.equals("CGX_Chromlabs")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);

				//Test Requirement
				driver.findElement(By.name("data[test_requirements_comprehensive_cancer]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_lynch_syndrome]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_ovarian_cancer]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}

			//LAB CGX 5
			if (lab.equals("CGX_Home Genetics August 2022")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);

				//Test Requirement
				driver.findElement(By.name("data[test_requirements_44]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_pancreatic_cancer]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_lynch_cancer]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
		}
		
		//LAB CARDIO
		if (lab.equals("Cardio")) {
			// LAB CARDIO 1
			if (type.equals("Cardio - ALIGN")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@name='data[test_requirements_primary_genes_117]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//patient's persional History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}	
			//LAB CARDIO 2
			if (type.equals("CARDIO_DIAX")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@value='HEF']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@value='APOE']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@value='FXN']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//patient's persional History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
			}	
			
			//LAB CARDIO 3
			if (type.equals("Cardio - LIMITLESS")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@value='Seq & Del/Dup']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@value='Diagnostic']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@value='Presymptomatic']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//patient's persional History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
			}	
			
			//LAB CARDIO 4
			if (type.equals("Cardio - PRINCIPLE")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@name='data[test_requirements_hereditary_cardio]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@name='data[test_requirements_actionable_cardio]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//input[@name='data[test_requirements_hereditary2_cardio]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//patient's persional History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}	
			// LAB CARDIO 5
			if (type.equals("Cardio - PRINCIPLE")) {
				// pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);

				// Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//input[@name='data[test_requirements_hereditary_cardio]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);

				// patient's persional History
				System.out.println("Patient's persional History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);

				// Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);

				// Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);

				// Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);

			}
			
		}
		if (type.equals("PGX")) {
			if (lab.equals("PGX_ADVANTA")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath(".//*[@value='ADRA2A']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//*[@value='CYP1A2']")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//medical History
				System.out.println("Check Medical History");
				driver.findElement(By.xpath("//input[@name='data[patient_personal_history_progress_note_confirm_2_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
			
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
//				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
//				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
			}
			else {System.out.println("fail pgx");}
		}
		if (type.equals("Pulmonary")) {
			if (lab.equals("Pulmonary AdvaGenix")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Patient's medical History
				System.out.println("Check Patient's Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);

			
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
			
		}
		if (type.equals("Diabetes")) {
			//LAB DIABETES 1
			if (lab.equals("Diabetes - INFINITY")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_name]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_test_options][]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
			
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
//				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
			
			//LAB DIABETES 2
			if (lab.equals("DIABETES - ADL")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_name]")).click();
				Common.waitSec(1);
				driver.findElement(By.name("data[test_requirements_test_options][]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
			
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
//				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
		}
		if (type.equals("Immunodeficiency")) {
			if (lab.equals("Immunodeficiency - Biogroup")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_checkbox]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Patient's medical History
				System.out.println("Check Patient's Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				driver.findElement(By.xpath(".//span[text()='Family History']")).click();
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//*[@value='Yes']")).click();
				driver.findElement(By.name("data[family_history_member_indications][]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
		}
		
		if (type.equals("NEUROCOGNITIVE")) {
			if (lab.equals("Neurocognitive-Diax")) {
				//pcp
				System.out.println("-------------Draft to new----------------");
				System.out.println("Check PCP");
				driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
				Common.waitSec(2);
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(2);
				
				//medical History
				System.out.println("Check Medical History");
				driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Test requirement
				System.out.println("Check Test Requirement");
				driver.findElement(By.name("data[test_requirements_1967]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(2);
				
				//Family History
				System.out.println("Check Family History");
				driver.findElement(By.xpath(".//input[@name='data[family_history_member_1_name]']")).sendKeys("daddy");
				Common.waitSec(2);
				driver.findElement(By.xpath(".//*[@class='form-control ui fluid selection dropdown']")).click();
				Common.waitSec(1);
				action.sendKeys(Keys.ENTER).build().perform();
				Common.waitSec(1);
				driver.findElement(By.xpath(".//input[@value='Male']")).click();
				driver.findElement(By.xpath("//input[@name='data[family_history_member_confirm_sale]']")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
				
				//Medication
				System.out.println("Check Medication");
				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
//				driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
				driver.findElement(By.xpath(".//button[text()='Save']")).click();
				Common.waitSec(3);
				
				//Verification
				driver.findElement(By.name("data[sales_agent_verification_consent]")).click();
				driver.findElement(By.name("data[sales_agent_verification_patient_consent]")).click();
				Common.waitSec(1);
				driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
				Common.waitSec(3);
			}
			
		}
		
		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done new case.-----------------------------------");
		Common.waitSec(5);
		
		//reqform
				
	}
	
	public void CGM_create_new_case(String business, String vertical, String MG, String type, String lab, String first_name, String last_name, String DOB, String medicare_ID, String zipcode) {
		Actions action = new Actions(driver);
		//draft case
		System.out.println("------------------------------Create NEW case------------------------------------");
		
		Common.waitSec(10);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
			add_case.click();
		}

		// create draft
		// set business
		Common.waitSec(5);
		System.out.println("Set Business & Vertical");
		driver.findElement(By.xpath("//*[@id='react-select-5-input']")).sendKeys(business, Keys.ENTER);
		Common.waitSec(2);

//		// set medical service
//		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys(vertical, Keys.ENTER);
//		Common.waitSec(2);
//
//		// set MG
//		driver.findElement(By.xpath("//*[@id='react-select-8-input']")).sendKeys(MG, Keys.ENTER);
//		Common.waitSec(2);
//
//		// set service type
//		driver.findElement(By.xpath("//*[@id='react-select-10-input']")).sendKeys(type, Keys.ENTER);
//		Common.waitSec(3);
//
//		// set state
//		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys(lab, Keys.ENTER);
//		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name
		System.out.println("Input Information");
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
		// date of birth.
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(DOB);
		Common.waitSec(1);
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(medicare_ID);
		Common.waitSec(1);
		
		//gender & ethnicity
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);
		
		// height & weight
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);
				
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys(zipcode);
		Common.waitSec(3);
				
		//phone
		driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
		driver.findElement(By.xpath("//input[@name='data[patient_phone]']")).sendKeys("5864565645");
		Common.waitSec(3);	
					
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		System.out.println("-----------------Done draft case------------------");
		System.out.println(lab);
		Common.waitSec(5);
		//draft to new
		System.out.println("-------------Draft to new----------------");
		//pcp
		System.out.println("Check PCP");
		driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(2);
		
		//order detail
		System.out.println("Check Order Detail");
		driver.findElement(By.name("data[test_requirements_current_insulin][]")).click();
		driver.findElement(By.name("data[test_requirements_perday]")).sendKeys("12");
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);	
		
		//medical history
		System.out.println("Check Medical History");
		driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(2);
		
		//medication
		System.out.println("Check Medication");
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(3);
		
		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("------------------------------Done new case.-----------------------------------");
		Common.waitSec(5);		
	}
	
	public void Beauty_create_new_case(String business, String vertical, String MG, String type, String lab, String first_name, String last_name, String DOB, String zipcode) {
		Actions action = new Actions(driver);
		//draft case
		System.out.println("------------------------------Create NEW case------------------------------------");
		
		Common.waitSec(10);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
			add_case.click();
		}

		// create draft
		// set business
		Common.waitSec(5);
		System.out.println("Set Business & Vertical");
		driver.findElement(By.xpath("//*[@id='react-select-5-input']")).sendKeys(business, Keys.ENTER);
		Common.waitSec(2);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys(vertical, Keys.ENTER);
		Common.waitSec(2);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-8-input']")).sendKeys(MG, Keys.ENTER);
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-10-input']")).sendKeys(type, Keys.ENTER);
		Common.waitSec(3);

		// set state
		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys(lab, Keys.ENTER);
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name
		System.out.println("Input Information");
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
				
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys(zipcode);
		Common.waitSec(1);
				
		//phone
		driver.findElement(By.xpath("//input[@name='data[patient_phone]']")).sendKeys("5864565645");
		Common.waitSec(3);	
		
		//email
		driver.findElement(By.name("data[patient_email]")).sendKeys("nhuttest82@yopmail.com");
					
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		System.out.println("-----------------Done draft case------------------");
		//draft to new
		System.out.println("-------------Draft to new----------------");
		Common.waitSec(3);

	}
	public void beauty_booking() {
		driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[2]/div[2]/div/button")).click();
		Common.waitSec(3);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			if (driver.findElement(By.xpath("//*[@id=\"templateBody\"]/table/tbody/tr/td/table/tbody/tr[11]/td/table/tbody/tr/td/div")).isDisplayed())
				System.out.println("true");
		}
		catch (NoSuchElementException ex) {
			System.out.println("false");
		}
		WebElement link_booking = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"templateBody\"]/table/tbody/tr/td/table/tbody/tr[11]/td/table/tbody/tr/td/div/a")));
		link_booking.getAttribute("href");
		driver.findElement(By.xpath(".//button[text()='Send Smart Email ']")).click();
		Common.waitSec(10);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String link = link_booking.getAttribute("href");
		System.out.println(link);

		js.executeScript("window.location='https://yopmail.com/';");
		Common.waitSec(5);
		driver.findElement(By.id("login")).sendKeys("nhuttest82");
		Common.waitSec(2);
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(10);


		js.executeScript("window.location='open_booking_button.getAttribute(\"href\")';");
		Common.waitSec(10);

		driver.findElement(By.xpath("/html/body/div[2]/div[6]/div[1]/div[2]/div[2]/div/div[2]/div/div/div[1]/div[6]/div[1]/div/input[2]")).sendKeys("07/01/2005");
		Common.waitSec(2);

		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(7);

		driver.findElement(By.xpath(".//span[text()='Yes']")).click();

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();

		Common.waitSec(2);

		action.sendKeys(Keys.TAB).build().perform();
		action.sendKeys(Keys.SPACE).build().perform();

		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(5);

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
		driver.findElement(By.xpath(".//button[text()='Confirm time']")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Confirm time']")).click();
		Common.waitSec(3);

	}

	public void Monkeypox_create_new_case(String business, String vertical, String MG, String type, String lab, String first_name, String last_name, String DOB, String medicare_ID, String zipcode) {
		Actions action = new Actions(driver);
		//draft case
		System.out.println("------------------------------Create NEW case------------------------------------");

		Common.waitSec(10);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
			add_case.click();
		}

		// create draft
		// set business
		Common.waitSec(5);
		System.out.println("Set Business & Vertical");
		driver.findElement(By.xpath("//*[@id='react-select-5-input']")).sendKeys(business, Keys.ENTER);
		Common.waitSec(2);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys(vertical, Keys.ENTER);
		Common.waitSec(2);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-8-input']")).sendKeys(MG, Keys.ENTER);
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-10-input']")).sendKeys(type, Keys.ENTER);
		Common.waitSec(3);

		// set state
		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys(lab, Keys.ENTER);
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name
		System.out.println("Input Information");
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
		// date of birth.
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(DOB);
		Common.waitSec(1);
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(medicare_ID);
		Common.waitSec(1);

		//gender & ethnicity
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);

		// height & weight
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);

		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys(zipcode);
		Common.waitSec(1);

		//phone
		driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
		driver.findElement(By.xpath("//input[@name='data[patient_phone]']")).sendKeys("5864565645");
		Common.waitSec(3);

		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		System.out.println("-----------------Done draft case------------------");
		System.out.println(lab);
		//draft to new
		//Check Test Requirements
		System.out.println("Check Test Requirements");
		driver.findElement(By.xpath(".//span[text()='Test Requirements']")).click();
		Common.waitSec(3);
		driver.findElement(By.name("data[test_requirements_comprehensive_monkeypox][]")).click();
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);

		//Medical history
		System.out.println("Check Medical History");
		driver.findElement(By.name("data[patient_personal_history_medical_management_consideration]")).sendKeys("test");
		driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);

		//Family History
		driver.findElement(By.name("data[family_history_member_confirm_sale]")).click();
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);

		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		System.out.println("------------------------------Done new case.-----------------------------------");
	}

	public void MDL_diagnosis_create_new_case(String business, String vertical, String MG, String type, String lab, String first_name, String last_name, String DOB, String medicare_ID, String zipcode) {
		Actions action = new Actions(driver);
		//draft case
		System.out.println("------------------------------Create NEW case------------------------------------");

		Common.waitSec(10);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
			add_case.click();
		}

		// create draft
		// set business
		Common.waitSec(5);
		System.out.println("Set Business & Vertical");
		driver.findElement(By.xpath("//*[@id='react-select-5-input']")).sendKeys(business, Keys.ENTER);
		Common.waitSec(2);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys(vertical, Keys.ENTER);
		Common.waitSec(2);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-8-input']")).sendKeys(MG, Keys.ENTER);
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-10-input']")).sendKeys(type, Keys.ENTER);
		Common.waitSec(3);

		// set state
		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys(lab, Keys.ENTER);
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name
		System.out.println("Input Information");
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		Common.waitSec(1);
		// date of birth.
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(DOB);
		Common.waitSec(1);
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(medicare_ID);
		Common.waitSec(1);

		//gender & ethnicity
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Asian']")).click();
		Common.waitSec(1);

		// height & weight
		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		Common.waitSec(1);

		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys(zipcode);
		Common.waitSec(1);

		//phone
		driver.findElement(By.xpath("//input[@value='Cell Phone']")).click();
		driver.findElement(By.xpath("//input[@name='data[patient_phone]']")).sendKeys("5864565645");
		Common.waitSec(3);

		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		System.out.println("-----------------Done draft case------------------");
		System.out.println(lab);

		//draft to new
		//check PCP
		driver.findElement(By.xpath(".//span[text()='Primary Care Provider']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//*[@name='data[pcp_no_pcp_certification]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(5);

		//Medical history
		System.out.println("Check Medical History");
		driver.findElement(By.name("data[patient_personal_history_medical_management_consideration]")).sendKeys("test");
		driver.findElement(By.name("data[patient_personal_history_progress_note_confirm_2_sale]")).click();
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);

		//Check Test Requirements
		System.out.println("Check Test Requirements");
		Common.waitSec(3);
		driver.findElement(By.name("data[test_requirements_tests][]")).click();
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);


		//Family History
		driver.findElement(By.name("data[family_history_member_confirm_sale]")).click();
		driver.findElement(By.name("data[submit]")).click();
		Common.waitSec(3);

		//check medications
		System.out.println("Check Medication");
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(5);

		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(2);
		action.sendKeys(Keys.ENTER).build().perform();
		Common.waitSec(5);
		System.out.println("------------------------------Done new case.-----------------------------------");
	}
}
