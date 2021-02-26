package assignment1;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

//Practice assignment: https://qatechhub.com/selenium-assignment-1

public class BaseTest {

	public WebDriver driver;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		}
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
