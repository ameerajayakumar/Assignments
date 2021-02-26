package assignment5;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class Snapdeal extends BaseTest {

	// Assignment: https://qatechhub.com/selenium-assignment-4-login-snapdeal/

	@Test(priority = 1)
	public void openURL() {
		setUp("chrome");
		driver.get("https://www.snapdeal.com/");
	}

	@Test(priority = 2)
	public void testCase() throws InterruptedException {

		WebElement we = driver.findElement(
				By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]/a"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", we);
		loginUser();
		driver.switchTo().defaultContent();
		Thread.sleep(4000);
		WebElement username = driver
				.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div/span[1]"));
		System.out.println("User Logged in as : " + username.getText());

	}

	public void loginUser() {
		driver.switchTo().frame("loginIframe");
		driver.findElement(By.id("userName")).sendKeys("dafodilequeen@gmail.com");
		driver.findElement(By.id("checkUser")).click();
		driver.findElement(By.id("j_password_login_uc")).sendKeys("Lforluna1!");
		driver.findElement(By.id("submitLoginUC")).click();

	}

}
