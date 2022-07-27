package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.Base;

public class LoginPage extends Base {
	
	//static By loginBar = By.partialLinkText("/account/login");

	static By loginBar = By.xpath("//*[@id=\'container\']/div/div[1]/div[1]/div[2]/div[3]/div/div/div/a");
	static By fillEmail = By.xpath("//*[@type='text']//following::input[6]");
	static By fillPasword = By.xpath("//*[@type='text']//following::input[7]");
	static By loginBtn = By.xpath("//div/form/div[4]/button");
	static By popUpMsg = By.xpath("//div[@class='_2sKwjB']");
	
	public void clickLoginBar() throws InterruptedException {
		click(loginBar); 
	}
	
	public void enterEmail(String email) throws InterruptedException {
		sendKeys(fillEmail,email );
	}
	
	public void enterPassword(String pw) throws InterruptedException {
		sendKeys(fillPasword,pw );
		// driver.findElement(fillPasword).sendKeys(pw);
	}
	
	public void clickLoginBtn() throws InterruptedException {
		click(loginBtn);
		//driver.findElement(loginBtn).click();
	}
	
	public String getLogintext() {
		
		//wait.until(ExpectedConditions.visibilityOfElementLocated(popUpMsg));
		
		Alert alertDialog = driver.switchTo().alert();

		// Get the alert text
		String alertText = alertDialog.getText();
		
		return alertText;
	}
	
}