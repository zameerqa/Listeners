package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FacebookPage extends Common {

	@Test
	public void google() {

		driver.get("https://www.facebook.com/");
	}
}
