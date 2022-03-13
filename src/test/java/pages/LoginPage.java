package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//Define Element locators
		@FindBy(name="password") public WebElement password;
		@FindBy(xpath="//span[text()='Next']/..") public WebElement loginNext;
		//Constructor method
		public LoginPage(RemoteWebDriver driver)
		{
			//Connect "driver" object to above defined locators
			PageFactory.initElements(driver, this);
		}
		    //Operational and observation methods
		public void fillPassword(String x)
		{
			//Locate element and operate
			password.sendKeys(x);
		}
		public void clickLoginNext() throws Exception
		{
			loginNext.click();
			Thread.sleep(5000);
			
		}
			

}
