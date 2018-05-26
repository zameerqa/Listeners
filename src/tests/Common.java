package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {
	

	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser){

		if(browser.equals("firefox")){
		driver=new FirefoxDriver();
		}
		else if(browser.equals("chrome")){

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}
	@AfterMethod
	public void tearDown() throws Exception{
		Thread.sleep(5000);
		//driver.quit();
	}
}
