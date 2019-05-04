package Test;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


import PadgeObjects.LoginPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;
	


	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		
	}
	
	
	@Test
	public void login() {
		LoginPageObjects login = new LoginPageObjects(driver);
		login.email.sendKeys("Tester");
		login.password.sendKeys("test");
		login.LogIn.click();
	}
	


	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
}