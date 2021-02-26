package assignment7;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class DragnDrop extends BaseTest{
	

		@Test(priority = 1)
		public void openURL() {
			setUp("chrome");
			driver.get("http://jqueryui.com/droppable/");
			driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
			WebElement drag = driver.findElement(By.id("draggable"));
			WebElement drop = driver.findElement(By.id("droppable"));
			System.out.println(drop.getCssValue("color"));

			Actions a = new Actions(driver);
		//	a.dragAndDrop(drag, drop).perform();
			a.moveToElement(drag).clickAndHold().moveToElement(drop).release().perform();
			
			assertEquals(driver.findElement(By.xpath("//p[contains(text(),'Dropped!')]")).getText(), "Dropped!");
			System.out.println(drop.getCssValue("color"));
			
		}
}
