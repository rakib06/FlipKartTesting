package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Base {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	public static WebElement get_element(By by) throws InterruptedException {
		WebElement element;
		wait = new WebDriverWait(driver,20);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		Thread.sleep(1000);
		return element;
	}
	
	public static void click(By by) throws InterruptedException {
		get_element(by).click();
	}
	
	public static void sendKeys(By by, String value) throws InterruptedException {
		
		get_element(by).sendKeys( value );
	}
	
	public static boolean isDisplayed(By by) throws InterruptedException{
		//WebElement element = browser.findElement( by );
		return get_element(by).isDisplayed();
	}
	
	public static boolean isEnabled(By by) throws InterruptedException{
		//WebElement element = browser.findElement( by );
		return get_element(by).isEnabled();
	}
	
	public static String getText(By by) throws InterruptedException{
		return get_element(by).getText();
	}

	public static void navigateURL(String url) {
		driver.get( url );
	}
	
	
	

	
}