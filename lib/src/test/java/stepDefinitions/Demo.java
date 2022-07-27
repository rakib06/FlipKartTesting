package stepDefinitions;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	public static WebDriver driver;
	@Test
	@Given ("I want to open the browser")
	public void methodA() {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://google.com");
		
	}
	
	@Test
	@Then ("Close the browser")
	public void methodB() {
		driver.close();
	}

}
