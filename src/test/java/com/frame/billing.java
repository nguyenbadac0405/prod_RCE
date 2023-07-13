package com.frame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Common;

public class billing {
    protected WebDriver driver;

    public billing(WebDriver driver) {
        this.driver = driver;
    }

    public void billing() {
        System.out.println("check billing");
        WebElement element = driver.findElement(By.className("gk-pos-relative"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();

        Common.waitSec(2);
        driver.findElement(By.xpath(".//*[@class='modal-content']/div[2]/div/div[2]/div/input")).sendKeys("1");
        Common.waitSec(1);
        driver.findElement(By.xpath(".//*[@class='modal-content']/div[2]/div/div[3]/div/input")).sendKeys("1");
        Common.waitSec(1);
        driver.findElement(By.xpath(".//button[text()='Save']")).click();
        Common.waitSec(2);
        driver.findElement(By.xpath(".//button[text()='OK']")).click();
        Common.waitSec(5);

    }
}
