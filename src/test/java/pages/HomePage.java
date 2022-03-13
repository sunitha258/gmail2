package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	//Define Element locators
	@FindBy(name="identifier") public WebElement userName;
	@FindBy(xpath="//span[text()='Next']/..") public WebElement homeNext;
	//Constructor method
	public HomePage(RemoteWebDriver driver)
	{
		//Connect "driver" object to above defined locators
		PageFactory.initElements(driver, this);
	}
	//Operational and observation methods
	public void fillUserName(String x)
	{
		//Locate and operate element
		userName.sendKeys(x);
		
	}
	public void clickHomeNext() throws Exception
	{
		homeNext.click();
		Thread.sleep(5000);
		
	}

}
