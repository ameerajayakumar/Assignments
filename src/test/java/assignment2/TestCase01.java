package assignment2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase01 extends BaseTest {

	public boolean isElementpresent(By by) {
		try {
			driver.findElement(by);
			return true;

		} catch (Throwable t) {
			return false;
		}

	}

	@Test
	public void TestCaseOne() {
		WebDriverWait w = new WebDriverWait(driver, 8);

		System.out.println("Opening URL");
		driver.get("http://www.fb.com");

		System.out.println("Checking url- actual vs expected");
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");
		System.out.println("Checking if user registeration form is present");
		Assert.assertTrue(
				isElementpresent(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]/div/div[1]/div[1]/span")),
				"Create Account form not present!");
		System.out.println("Entering first name");
		driver.findElement(By.name("firstname")).sendKeys("Lily");
		System.out.println("Entering last name");
		driver.findElement(By.name("lastname")).sendKeys("Joseph Thomas");
		System.out.println("Entering phone number");
		driver.findElement(By.name("reg_email__")).sendKeys("+919588373899");
		System.out.println("Entering password");
		driver.findElement(By.name("reg_passwd__")).sendKeys("Lkjhgf@123456");
		Select day = new Select(driver.findElement(By.id("day")));
		System.out.println("Selecting date");
		day.selectByValue("19");
		Select month = new Select(driver.findElement(By.id("month")));
		System.out.println("Selecting month");
		month.selectByValue("6");
		Select year = new Select(driver.findElement(By.id("year")));
		System.out.println("Selecting year");
		year.selectByValue("1989");
		System.out.println("Selecting radio-gender");
		driver.findElement(By.id("u_0_6")).click();
		System.out.println("Clicking on Sign up button");
		driver.findElement(By.name("websubmit")).click();
		
		w.until(ExpectedConditions.or(ExpectedConditions.urlContains("checkpoint"),ExpectedConditions.urlContains("confirmmail")));
		System.out.println("User successfully created account in FB!");
	}
}
