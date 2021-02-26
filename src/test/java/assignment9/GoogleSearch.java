package assignment9;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class GoogleSearch extends BaseTest{
	
	@Test(priority = 1)
	public void TestCase01() throws InterruptedException {
		setUp("firefox");
		driver.get("https://www.google.com/");
		System.out.println("Opened URL!");
		driver.findElement(By.name("q")).sendKeys("luna");
		WebDriverWait w = new WebDriverWait(driver, 5);
		w.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='erkvQe']//li")));
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='erkvQe']//li"));
		for(WebElement ww:list) {
			System.out.println(ww.getText());
		}
}
}
