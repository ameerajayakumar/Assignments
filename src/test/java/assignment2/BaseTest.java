package assignment2;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

//Practice assignment: https://qatechhub.com/selenium-assignment-2/

public class BaseTest {

	public static WebDriver driver;

	@BeforeSuite
	public void setUp() {

		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		}
	}

	@AfterSuite
	public void tearDown() {

		driver.quit();

	}

}
