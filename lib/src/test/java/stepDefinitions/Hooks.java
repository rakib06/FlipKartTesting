package stepDefinitions;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import base.Base;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks extends Base {
	
	@Before
	public void setup() {
		ChromeOptions option = new ChromeOptions(); 
		option.setHeadless(false);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(option);
		System.out.println(driver);
	}
	
	@After
	public void tearDown(Scenario scenario) {
		try {
			// String screenshotName= scenario.getName().replace("", "");
			if(scenario.isFailed()) {
				// https://stackoverflow.com/questions/55358873/adding-screenshot-after-every-step-in-cucumber-report-using-java
				scenario.write("this is my failure message");
				TakesScreenshot ts = (TakesScreenshot)driver;
				byte[]screenshot = ts.getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		driver.close();
	}
	

}
