package assignment3;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class LinksOnPage extends BaseTest{

	//Assignment: https://qatechhub.com/selenium-assignment-3/
	public List<WebElement> links;
	@Test(priority = 1)
	public void openURL() {
		setUp("chrome");
		driver.get("https://flipkart.com");
		driver.findElement(By.cssSelector("body > div.mCRfo9 > div > div > button")).click();
	}
	
	@Test(priority = 2)
	public void countURLs() {
		
		 links = driver.findElements(By.tagName("a"));
		System.out.println("Number of links on page: "+links.size());
		
	}
	
	@Test(priority = 3)
	public void printLinks() {
		
		for(WebElement we:links) {
			System.out.println("Link Text: "+ we.getText() + "   Link URL: "+we.getAttribute("href"));
		}
		
		
	}
	
}
