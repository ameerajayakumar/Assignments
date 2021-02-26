package assignment6;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class Flipkart extends BaseTest{
	@Test(priority = 1)
	public void openURL() {
		setUp("chrome");
		driver.get("https://flipkart.com");
		driver.findElement(By.xpath("//input[@class='_2zrpKA _1dBPDZ']")).sendKeys("dafodaileq@gmail.com");
		driver.findElement(By.xpath("//input[@class='_2zrpKA _3v41xv _1dBPDZ']")).sendKeys("Lforluna1!@2");
		driver.findElement(By.xpath("//button[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
	}

}
