package assignment1;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCases extends BaseTest {

	public void getTitle(WebDriver d) {

		Assert.assertEquals(driver.getTitle(), "QA Automation Tools Trainings and Tutorials | QA Tech Hub",
				"Title found is not as expected! ");
		System.out.println("Test Passed - title equal");
	}

	@Test
	public void TestCaseOne() {
		
		driver.get("http://qatechhub.com");
		getTitle(driver);
		System.out.println("Navigating to Facebook url");
		driver.get("https://www.facebook.com");
		System.out.println("Navigating to previous page");
		driver.navigate().back();
		System.out.println("Page URL: " + driver.getCurrentUrl());
		System.out.println("Navigating to next page");
		driver.navigate().forward();
		System.out.println("Refreshing current page");
		driver.navigate().refresh();
	}

}
