package assignment9;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class Amazon extends BaseTest {

	@Test(priority = 1)
	public void TestCase01() {
		setUp("chrome");
		driver.get("https://www.amazon.in");
		System.out.println("Opened URL!");
		String HomeTitle = driver.getTitle().toString();
		System.out.println("Page Title: " + HomeTitle);
		driver.findElement(By.linkText("Amazon Pay")).click();
		System.out.println("Page Title: " + driver.getTitle());
		driver.navigate().back();
		Assert.assertEquals(HomeTitle, driver.getTitle(), "Titles are not equal");
		System.out.println("Titles match!");
	}

	@Test(priority = 2)
	public void TestCase02() {
		driver.get("https://www.techlistic.com/");
		System.out.println("Opened URL!");
		driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Java')]")).click();
		System.out.println("Page Title: " + driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Selenium')]")).click();
		System.out.println("Page Title: " + driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'Blogs')]")).click();
		System.out.println("Page Title: " + driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.xpath("//div[@class='overflowable-contents']//a[contains(text(),'TestNG')]")).click();
		System.out.println("Page Title: " + driver.getTitle());

	}

	@Test(priority = 3)
	public void TestCase03() {
		driver.get("https://www.amazon.in");
		System.out.println("Opened URL!");
		String HomeTitle = driver.getTitle().toString();
		System.out.println("Page Title: " + HomeTitle);
		driver.findElement(By.linkText("Amazon Pay")).click();
		Assert.assertEquals("Amazon Pay", driver.getTitle(), "Titles are not equal");
		driver.navigate().back();
		Assert.assertEquals(HomeTitle, driver.getTitle(), "Titles are not equal");
		System.out.println("Titles match");

	}

}
