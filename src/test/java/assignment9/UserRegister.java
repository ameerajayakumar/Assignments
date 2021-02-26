package assignment9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.BaseTest;

public class UserRegister extends BaseTest {

	@Test(priority = 1)
	public void TestCase01() throws InterruptedException {
		setUp("firefox");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Opened URL!");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("studentdemoclass111@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();

		driver.findElement(By.id("id_gender2")).click();
		String fname = "Demo Student";
		driver.findElement(By.id("customer_firstname")).sendKeys(fname);
		driver.findElement(By.id("customer_lastname")).sendKeys("Selenium Class");
		driver.findElement(By.id("passwd")).sendKeys("Qwerty@123456");
		Select d = new Select(driver.findElement(By.id("days")));
		d.selectByValue("21");
		Select m = new Select(driver.findElement(By.id("months")));
		m.selectByValue("6");
		Select y = new Select(driver.findElement(By.id("years")));
		y.selectByValue("1984");
		driver.findElement(By.id("company")).sendKeys("Azonian");
		driver.findElement(By.id("address1")).sendKeys("Address line one");
		driver.findElement(By.id("address2")).sendKeys("Address line two");

		Select s = new Select(driver.findElement(By.id("id_state")));
		s.selectByVisibleText("Alaska");
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		driver.findElement(By.id("postcode")).sendKeys("00077");
		driver.findElement(By.id("phone_mobile")).sendKeys("82663962881");
		driver.findElement(By.id("alias")).sendKeys("queens@gmail.com");
		driver.findElement(By.id("submitAccount")).click();
		System.out.println("PAGE URL: " + driver.getCurrentUrl());
		String name = driver.findElement(By.className("account")).getText();
		if (name.contains(fname))
			System.out.println("User registeration successful!! :)");
		else
			System.out.println("User not registered!!! :(");

	}

	@Test(priority = 2)
	public void TestCase02() {
		setUp("chrome");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Opened URL!");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("studentdemo123");
		driver.findElement(By.id("SubmitCreate")).click();
		System.out.println(driver.findElement(By.xpath("//li[contains(text(),'Invalid email address.')]")).getText());
	}

	@Test(priority = 3)
	public void TestCase03() {
		setUp("chrome");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Opened URL!");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("studentdemo123@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		driver.findElement(By.id("submitAccount")).click();
		String ele = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		if(ele.contains("error"))
			System.out.println("Fill in Mandatory fields!!!");
		else
			System.out.println("Check the fields again!!!");
	}

	@Test(priority = 4)
	public void TestCase04() {
		setUp("chrome");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Opened URL!");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys("studentdemo123@gmail.com");
		driver.findElement(By.id("SubmitCreate")).click();
		driver.findElement(By.id("submitAccount")).click();
		String ele = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
		if(ele.contains("invalid"))
			System.out.println("Fill in Mandatory fields or Invalid field values- Check again!!!");
		else
			System.out.println("Check the fields again!!!");
	}
	
	//buy product
	@Test(priority = 5)
	public void TestCase05() {
		setUp("chrome");
		driver.get("http://automationpractice.com/index.php");
		System.out.println("Opened URL!");
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email")).sendKeys("studentdemoclass111@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Qwerty@123456");
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		driver.findElement(By.xpath("//a[@class='product-name'][contains(text(),'Blouse')]")).click();
		driver.findElement(By.className("icon-plus")).click();
		driver.findElement(By.id("color_8")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Add to cart')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.id("cgv")).click();
		driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
		driver.findElement(By.className("bankwire")).click();
		String expected="Here is a short summary of your order";
		String actual = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/div[1]/p[1]/strong[1]")).getText();
		if(actual.contains(expected))
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/form[1]/p[1]/button[1]/span[1]")).click();
		else
			Assert.fail("Order not confirmed- Summary missing!!!");
		System.out.println(driver.findElement(By.xpath("//p[@class='cheque-indent']")).getText());
	}
	
	//search product
		@Test(priority = 6)
		public void TestCase06() throws InterruptedException {
			setUp("chrome");
			driver.get("http://automationpractice.com/index.php");
			System.out.println("Opened URL!");
			driver.findElement(By.className("login")).click();
			driver.findElement(By.id("email")).sendKeys("studentdemoclass111@gmail.com");
			driver.findElement(By.id("passwd")).sendKeys("Qwerty@123456");
			driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
			driver.findElement(By.xpath("//img[@class='logo img-responsive']")).click();
			Thread.sleep(3000);
			Actions a = new Actions(driver);
			WebElement women =driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]"));
			a.moveToElement(women).perform();
			//a.moveToElement(women).moveToElement(women).click().perform();
			driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]")).click();
		
			a.moveToElement(driver.findElement(By.partialLinkText("Faded Short Sleeve T")));
			String search = driver.findElement(By.partialLinkText("Faded Short Sleeve T")).getText();
			driver.findElement(By.id("search_query_top")).sendKeys(search);
			driver.findElement(By.name("submit_search")).click();
			String actual = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")).getText();
			Assert.assertEquals(actual, search, "Searched item doesnt match listed one!");
		}
}
