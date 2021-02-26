package assignment4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class TestCaseEbay extends BaseTest {

	// Assignment: https://qatechhub.com/selenium-assignment-4/

	@Test(priority = 1)
	public void openURL() {
		setUp("chrome");
		driver.get("https://in.ebay.com/");
	}

	@Test(priority = 2)
	public void searchProduct() {
		driver.findElement(By.id("gh-ac")).sendKeys("Apple watches");
		Select s = new Select(driver.findElement(By.id("gh-cat")));
		s.selectByValue("281");
		driver.findElement(By.id("gh-btn")).click();
	}

	@Test(priority = 3)
	public void testCase01() {
		
		printSearchResult();
		printNthResult();
		printAllResults();
		printAllResultsScrollDown();
	}

	public void printSearchResult() {

		System.out.println("Search result: Product name:  "
				+ driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/a/h3")).getText());
	}

	public void printNthResult() {

		getNthResult(15);
	}

	public void printAllResults() {

		List<WebElement> list = driver.findElements(By.xpath("//*[@id='srp-river-results']/ul/li"));
		System.out.println("All Search Results: ");
		for (WebElement we : list) {

			System.out.println(we.getText());
		}
	}

	public void getNthResult(int n) {
		String xpath = "//*[@id=\"srp-river-results\"]/ul/li[" + n + "]/div/div[2]/a/h3";
		System.out.println("Result of " + n + "th product :  " + driver.findElement(By.xpath(xpath)).getText());

	}
	
	public void printAllResultsScrollDown() {
		List<WebElement> list = driver.findElements(By.xpath("//*[@id='srp-river-results']/ul/li"));
		Actions a = new Actions(driver);
		for (WebElement we : list) {
			a.moveToElement(we).perform();
			System.out.println(we.getText());
		}
		
	}

}
