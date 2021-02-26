package assignment9;

import org.testng.annotations.Test;

import utilities.BaseTest;

public class GoDaddy extends BaseTest{

	@Test(priority = 1)
	public void openURL() {
		setUp("firefox");
		driver.get("https://www.godaddy.com/");
		System.out.println("Opened URL!");
	}

	@Test(priority = 5)
	public void maximizeWindow() {
	
		driver.manage().window().maximize();
		System.out.println("Mazimized window!");

	}
	
	@Test(priority = 3)
	public void getTitle() {
	
		System.out.println("Page Title: "+driver.getTitle());

	}
	
	@Test(priority = 4)
	public void getPageURL() {
	
		System.out.println("Page URL: "+driver.getCurrentUrl());

	}
	
	@Test(priority = 2)
	public void getPageSource() {
	
		System.out.println("Page Source printing: "+driver.getPageSource());

	}
}
