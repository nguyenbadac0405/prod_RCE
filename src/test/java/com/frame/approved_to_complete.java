package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class approved_to_complete {
    protected WebDriver driver;

    public approved_to_complete(WebDriver driver) {
        this.driver = driver;
    }

    public void complete_case() {
        //complete case				 //*[@id="patient-dashboard"]/div[5]/div[2]/div[1]/div[3]/div[1]/div[3]/button
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//button[text()='Yes']")).click();
        System.out.println("----------------------PSS approved success----------------------------");
        String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
        System.out.println("------------------------------" +status+"------------------------------");
    }

    public void complete() {
        Actions action = new Actions(driver);
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//button[text()='Yes']")).click();
        System.out.println("----------------------PSS approved success----------------------------");
        Common.waitSec(3);
        driver.findElement(By.xpath(".//input[@name='ADMIN_MEDICAL-print_final_letter-check']")).click();
        Common.waitSec(3);
        driver.findElement(By.xpath(".//input[@name='ADMIN_MEDICAL-emailed_final_letter-check']")).click();
        Common.waitSec(3);

        driver.findElement(By.xpath(".//div[text()='Close Case']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();

        String status = driver.findElement(By.xpath("//*[@id='patient-dashboard']/div[5]/div[2]/div[1]/div[1]/div/div[1]/span[2]")).getText();
        System.out.println("------------------------------" +status+"------------------------------");

    }

    public void Covid_complete() {
        //to QC approve
        Actions action = new Actions(driver);
        driver.findElement(By.xpath(".//div[text()='Approve']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();

        //to awaiting result
        driver.findElement(By.xpath(".//div[text()='Forward']")).click();
        Common.waitSec(3);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

        //to sending result
        WebElement chooseFile = driver.findElement(By.xpath(".//input[@type='file']"));
        chooseFile.sendKeys("C:/Users/dac/Downloads/file.pdf");
        Common.waitSec(5);

        WebElement file = driver.findElement(By.xpath("/html/body/div/div[5]/div[2]/div[7]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]"));
        action.moveToElement(file).click().build().perform();
        Common.waitSec(1);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(5);

        WebElement sendmail = driver.findElement(By.xpath("//*[@id=\"patient-dashboard\"]/div[5]/div[2]/div[3]/div/button"));
        action.moveToElement(sendmail).click().build().perform();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//input[@placeholder='Email address']")).sendKeys("dac@gkim.vn");
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Send Smart Email ']")).click();
        Common.waitSec(10);

        driver.findElement(By.xpath(".//div[text()='Submit']")).click();
        Common.waitSec(2);
        action.sendKeys(Keys.ENTER).build().perform();
        Common.waitSec(3);

    }

    public void denied_approved(String id) {
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[1]/ul/li[2]/a/i")).click();
        Common.waitSec(10);
        driver.findElement(By.xpath(".//input[@placeholder='I want to search for…']")).sendKeys(id);
        Common.waitSec(5);
        driver.findElement(By.xpath(".//div[text()='Reject']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='Done']")).click();
        Common.waitSec(10);
    }
}