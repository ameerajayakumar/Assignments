package assignment9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class AboutMe extends BaseTest {

	@Test(priority = 1)
	public void TestCase01() throws InterruptedException {
		setUp("firefox");
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		System.out.println("Opened URL!");
		driver.findElement(By.name("firstname")).sendKeys("Rich");
		driver.findElement(By.name("lastname")).sendKeys("Stan");
		driver.findElement(By.id("sex-0")).click();
		driver.findElement(By.id("exp-6")).click();
		driver.findElement(By.id("datepicker")).sendKeys("17/09/2020");
		driver.findElement(By.cssSelector("#profession-1")).click();
		driver.findElement(By.id("tool-0")).click();
		driver.findElement(By.id("tool-2")).click();
		Select s = new Select(driver.findElement(By.id("continents")));
		s.selectByVisibleText("Australia");
		Select s1 = new Select(driver.findElement(By.id("selenium_commands")));
		s1.selectByVisibleText("WebElement Commands");
		s1.selectByVisibleText("Switch Commands");
		
		driver.findElement(By.xpath("//a[contains(text(),'Click here to Download File')]")).click();
		System.out.println("Page URL: "+driver.getCurrentUrl());
		driver.navigate().back();
		Thread.sleep(10000);

	}
}