package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class create_new_case_intake {
	protected WebDriver driver;
	
	public create_new_case_intake(WebDriver driver) {
		this.driver = driver;
	}

	public void new_case_MDR_intake() {
		Actions action = new Actions(driver);
		System.out.println("----------------------Create New case MDR-------------------------");
		Common.waitSec(2);
		WebElement add_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
//			System.out.println("123");
			add_case.click();
//			System.out.println("toi day chua???");
		}

//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span/span")).click();
		// create draft
		// set business
		Common.waitSec(5);
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys("MDR");
//		System.out.println("toi day roi ne`");
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
		driver.findElement(By.xpath("//*[@id='react-select-9-input']")).sendKeys("GKIM");
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
//		WebElement state = driver.findElement(By.xpath("//*[@id='react-select-13-input']"));

//		if (state.isDisplayed()) {
//			state.sendKeys("Cali",Keys.ENTER);
//		}
//		else {
//			driver.findElement(By.xpath("//*[@id='react-select-12-input']")).sendKeys("Cali",Keys.ENTER);
//		}
//		try {
//			driver.findElement(By.xpath("//*[@id='react-select-13-input']")).sendKeys("Cali",Keys.ENTER);
//			} 
//		catch (NoSuchElementException e) {
//			driver.findElement(By.xpath("//*[@id='react-select-12-input']")).sendKeys("Cali",Keys.ENTER);
//			}
		driver.findElement(By.xpath("//*[@id='react-select-12-input']")).sendKeys("ok");
		Common.waitSec(1);
		action.sendKeys(Keys.ENTER).build().perform();
		System.out.println("Done business and vertical");
		
		// info patient
		// name & gender
		System.out.println("Input information of Patient");
		String first_name = "Test MDR";
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
//		System.out.println("toi day di pls");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		String last_name = "from intake 1";
		String full_name = first_name + " "+ last_name;
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		
//		System.out.println("nghi cai");
		String name = driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).getAttribute("value") +" "+ driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).getAttribute("value");
		Common.waitSec(1);
		
		// date of birth.
		String birthday = "29/07/2004";
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(birthday);
//		System.out.println("di ne`");
		String DOB = driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).getAttribute("value");
		Common.waitSec(1);
//		driver.findElement(By.xpath("//*[@aria-label='July 24, 2004']")).click();
//		Common.waitSec(3);
		// zip code & street
		driver.findElement(By.xpath("//*[@name='data[patient_zip_code]']")).sendKeys("10010");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_address]']")).sendKeys("q2");
		Common.waitSec(2);
		System.out.println("-------------Done Draft case---------------");
		// ethnicity
//		driver.findElement(By.xpath("//*[@value='Asian']")).click();
//		Common.waitSec(3);
		// height & weight
//		driver.findElement(By.xpath("//*[@name='data[patient_height]']")).sendKeys("5.75");
//		Common.waitSec(3);
//		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
//		Common.waitSec(3);
		// medicare
//		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
//		Common.waitSec(3);
//		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
//		Common.waitSec(3);
//		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys("1TY2TR3GC08");
//		Common.waitSec(3);

		// reason visit
//		driver.findElement(By.xpath("//*[@name='data[patient_reason_of_visit]']")).sendKeys("test");
//		Common.waitSec(3);
//		
		//so sanh info
		System.out.println("--------Patient Info------");
		System.out.println("Patient name input: "+ full_name);
		System.out.println("Patient's name is displayed: " +name);
		
		System.out.println("Date of birth input: "+birthday);
		System.out.println("Date of birth is displayed: "+ DOB);
		
//		System.out.println("Insurance ID input: " +in_id);
//		System.out.println("Insurance ID is displayed: "+insurance_id);
		
		Common.waitSec(3);
		
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		
		Common.waitSec(7);

		// draft to new
		// medical
		System.out.println("Draft to new");
		driver.findElement(By.xpath(".//span[text()='medical history']")).click();
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
		Common.waitSec(2);
		WebElement add_case = driver
				.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span"));
		if (add_case.isDisplayed()) {
//			System.out.println("123");
			add_case.click();
//			System.out.println("toi day chua???");
		}

//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[1]/div[1]/h2/span/span")).click();
		// create draft
		// set business
		Common.waitSec(5);
		driver.findElement(By.xpath("//*[@id='react-select-6-input']")).sendKeys("MDL", Keys.ENTER);
//		System.out.println("toi day roi ne`");
		Common.waitSec(1);

		// set medical service
		driver.findElement(By.xpath("//*[@id='react-select-7-input']")).sendKeys("Telemed", Keys.ENTER);
//		System.out.println("toi day di");
		Common.waitSec(1);

		// set MG
		driver.findElement(By.xpath("//*[@id='react-select-9-input']")).sendKeys("GKIM", Keys.ENTER);
//		System.out.println("toi day luon");
		Common.waitSec(2);

		// set service type
		driver.findElement(By.xpath("//*[@id='react-select-11-input']")).sendKeys("single", Keys.ENTER);
		Common.waitSec(3);

		// set state
//		WebElement state = driver.findElement(By.xpath("//*[@id='react-select-13-input']"));

//		if (state.isDisplayed()) {
//			state.sendKeys("Cali",Keys.ENTER);
//		}
//		else {
//			driver.findElement(By.xpath("//*[@id='react-select-12-input']")).sendKeys("Cali",Keys.ENTER);
//		}
//		try {
//			driver.findElement(By.xpath("//*[@id='react-select-13-input']")).sendKeys("Cali",Keys.ENTER);
//			} 
//		catch (NoSuchElementException e) {
//			driver.findElement(By.xpath("//*[@id='react-select-12-input']")).sendKeys("Cali",Keys.ENTER);
//			}
		driver.findElement(By.xpath("//*[@id='react-select-12-input']")).sendKeys("mdl", Keys.ENTER);
//		System.out.println("da toi day");
		System.out.println("Done Business and Vertical");
		Common.waitSec(2);

		// info patient
		// name & gender
		String first_name = "Test MDL";
		driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).sendKeys(first_name);
//		first_name.clear();
//		Common.waitSec(1);
//		first_name.sendKeys("Test MDL");
//		System.out.println("toi day di pls");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@value='Male']")).click();
		Common.waitSec(1);
		String last_name = "from intake 1";
		driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).sendKeys(last_name);
		String full_name = first_name + " " + last_name;
//		last_name.clear();
//		Common.waitSec(1);
//		last_name.sendKeys("from intake 1");
//		System.out.println("nghi cai");
		Common.waitSec(1);
		String name = driver.findElement(By.xpath("//*[@name='data[patient_first_name]']")).getAttribute("value")+ " " + driver.findElement(By.xpath("//*[@name='data[patient_last_name]']")).getAttribute("value");
		// date of birth.
		String birthday = "07/29/2004";
		driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).sendKeys(birthday);
//		System.out.printlns("di ne`");
		String DOB = driver.findElement(By.xpath("//*[@class='form-group has-feedback formio-component formio-component-datetime formio-component-patient_dob  required']/div[1]/div/input[2]")).getAttribute("value");
		Common.waitSec(3);
//		driver.findElement(By.xpath("//*[@aria-label='July 24, 2004']")).click();
//		Common.waitSec(3);
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
		String height = driver.findElement(By.xpath("//*[@name='data[patient_height]']")).getAttribute("value");
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).sendKeys("146");
		String weight = driver.findElement(By.xpath("//*[@name='data[patient_weight]']")).getAttribute("value");
		Common.waitSec(1);
		// medicare
		driver.findElement(By.xpath("//*[@name='data[patient_no_secondary_insurance]']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@value='Medicare']")).click();
		Common.waitSec(2);
		String in_id = "6TR7FG7RT65";
		driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).sendKeys(in_id);
		String insurance_id = driver.findElement(By.xpath("//*[@name='data[patient_primary_insurance_id]']")).getAttribute("value");
		Common.waitSec(1);

		// reason visit
		driver.findElement(By.xpath("//*[@name='data[patient_reason_of_visit]']")).sendKeys("test");
		System.out.println("-----------------Done draft case------------------");
		
		//so sanh info
		System.out.println("--------Patient Info------");
		System.out.println("Patient name input: "+ full_name);
		System.out.println("Patient's name is displayed: " +name);
		
		System.out.println("Date of birth input: "+birthday);
		System.out.println("Date of birth is displayed: "+ DOB);
		
		System.out.println("Insurance ID input: " +in_id);
		System.out.println("Insurance ID is displayed: "+insurance_id);
		
		Common.waitSec(3);
//				
		// submit
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		
		Common.waitSec(5);
		
		//draft to new
		
		//pcp
		System.out.println("-------------Draft to new----------------");
		driver.findElement(By.xpath(".//span[text()='primary care provider']")).click();
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
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(2);
		
		//submit
		driver.findElement(By.xpath(".//div[text()='Submit']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("------------------------------Done new case.-----------------------------------");
		Common.waitSec(5);
	}

}
