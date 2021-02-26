package assignment8;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class GmailLogin extends BaseTest{
		

		@Test(priority = 1)
		public void openURL() {
			setUp("firefox");
			driver.get("http://gmail.com");
			driver.findElement(By.id("identifierId")).sendKeys("studentdemoclass111@gmail.com");
			driver.findElement(By.xpath("//div[@class='VfPpkd-RLmnJb']")).click();
			driver.findElement(By.name("password")).sendKeys("Democlass1!");
			driver.findElement(By.className("VfPpkd-RLmnJb")).click();
}}
