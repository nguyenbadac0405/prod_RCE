package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Common;

public class assign_to_approved {
	protected WebDriver driver;

	public assign_to_approved(WebDriver driver) {
		this.driver = driver;
	}

	public void ass_to_app_MDR() {
		// find case by id
//		WebElement id_case = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[3]/div[1]/input"));
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[1]/div[3]/div[1]/input")).click();
//        Actions builder = new Actions(driver);
//        builder.keyDown(id_case, Keys.CONTROL).perform();
//        builder.sendKeys(id_case, "v").perform();
//        builder.keyUp(id_case, Keys.CONTROL).perform();
//		WebElement id_case = driver.findElement(By.xpath(".//*[@data-icon='copy']"));
//		String id = id_case.getAttribute("value");
		// get info of patient
		driver.findElement(By.xpath(".//span[text()='medical history']")).click();

		// medical history
		System.out.println("-----------------Assign to Approve-------------------------");
		System.out.println("Provider check Medical History");
		driver.findElement(By.xpath(".//span[text()='medical history']")).click();
		Common.waitSec(3);
//		System.out.println("check 1");
		driver.findElement(By.xpath("//*[@name='data[patient_personal_history_progress_note_phmx]']")).sendKeys("test");
//		System.out.println("check 2");
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);

		// family history
		System.out.println("Provider check Family History");		
		Common.waitSec(3);
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[5]/div/div[6]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[family_history_member_confirm_doctor]']")).click();
//		System.out.println("check 4");
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		
		// exiting medications
		System.out.println("Provider check Exiting Medications");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[4]/label/input")).click();
		driver.findElement(By.xpath("//input[@name='shipped']")).click();
//		System.out.println("check 3");
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[3]/div[3]/div[2]/div[5]/button")).click();
		Common.waitSec(3);


		// review of systems
		System.out.println("Provider Review of Systems");
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[5]/div/div[7]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[review_of_system_confirm]']")).click();
//		System.out.println("check 5");
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(5);

		// diagnosis
		System.out.println("Provider select Diagnosis");
		driver.findElement(By.xpath(".//span[text()='diagnosis']")).click();
//		System.out.println("check 6");
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@value='2 Year License']")).click();
		driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[3]/div[4]/div[2]/div/div[2]/div[1]/input")).sendKeys("a");
		Common.waitSec(2);
//		System.out.println("check 7");
		driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[3]/div[4]/div[2]/div/div[2]/div[2]/ul/li[1]")).click();
//		System.out.println("check 8");
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(2);
		// asseessment & plan
//		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[5]/div/div[12]/div/div/div/strong/span")).click();
		driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']")).sendKeys("There is all plan that the provider is setting for you.");
		System.out.println("Provider set Asseessment & Plan");
		Common.waitSec(3);
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);

		// approved
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[3]/div[1]/div[3]/button")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("-------------------------Done Approve----------------------------");
		Common.waitSec(5);

	}
	
	public void assign_to_approved_MDL() {
		System.out.println("-----------------Assign to Approve-------------------------");
		//patient's medical history
		System.out.println("Provider check Patient's Medical History");
		driver.findElement(By.xpath(".//span[text()=\"patient's medical history\"]")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@name='data[patient_personal_history_progress_note_phmx]']")).sendKeys("test");
//		System.out.println("check 2");
		driver.findElement(By.xpath("//*[@name='data[patient_personal_history_progress_note_confirm_doctor]']")).click();
		Common.waitSec(1);
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		
		// exiting medications
		System.out.println("Provider check Exiting Medications");
		driver.findElement(By.xpath("//*[@name='data[medication_confirm_patient]']")).sendKeys("test");
		driver.findElement(By.xpath("//*[@name='data[medication_note]']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@name='shipped']")).click();
//		System.out.println("check 3");
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(3);
		
		// diagnosis
		System.out.println("Provider set Diagnosis");
		driver.findElement(By.xpath(".//span[text()='diagnosis']")).click();
//		System.out.println("check 4");
		Common.waitSec(2);
//		driver.findElement(By.xpath("//*[@value='2 Year License']")).click();
		driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[3]/div[4]/div[2]/div/div[2]/div[1]/input")).sendKeys("a");
		Common.waitSec(3);
//		System.out.println("check 5");
		driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[3]/div[4]/div[2]/div/div[2]/div[2]/ul/li[3]")).click();
//		System.out.println("check 6");
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		Common.waitSec(2);
		driver.findElement(By.xpath(".//button[text()='Save']")).click();
		Common.waitSec(3);
		
		// review of systems
		System.out.println("Provider Review of Systems");
		driver.findElement(By.xpath("//input[@name='data[review_of_system_confirm]']")).click();
//		System.out.println("check 7");
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(2);
		
		//assessment & plan
		System.out.println("Provider set Assessment & Plan");
		driver.findElement(By.xpath("//*[@name='data[assessment_plan_plan]']")).sendKeys("There is all plan that the provider is setting for you.");
//		System.out.println("check 9");s
		Common.waitSec(2);
		driver.findElement(By.xpath("//*[@name='data[submit]']")).click();
		Common.waitSec(3);
		
		// approved
		driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[3]/div[1]/div[3]/button")).click();
		Common.waitSec(3);
		driver.findElement(By.xpath(".//button[text()='Yes']")).click();
		System.out.println("-------------------------Done Approve----------------------------");
		Common.waitSec(5);
	}
}