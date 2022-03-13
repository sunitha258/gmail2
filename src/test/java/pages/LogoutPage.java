package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage 
{
	//Define Element locators
	@FindBy(xpath="//a[starts-with(@aria-label,'Google Account')]/img") 
    public WebElement profilepic;
	//sign out
	@FindBy(linkText="Sign out") public WebElement signout;
	
	//@FindBy(xpath="//div[text()='Use another account']") public WebElement relogin;
	@FindBy(xpath="//span[text()='Choose an account']") public WebElement relogin;
	//constructor method
	public LogoutPage(RemoteWebDriver driver)
			{
				
				PageFactory.initElements(driver,this);
			}
			    //Operational and observation methods
			
			public void clickProfilePic() throws Exception
			{
				profilepic.click();
				Thread.sleep(5000);
			}
		   public void clickSignout() throws Exception
		   
		   {
			   signout.click();
			   Thread.sleep(5000);
		   }
		   public boolean isLoginReDisplayed() //throws Exception
			{
			 // relogin.click();
			  //Thread.sleep(5000);
			  
				if(relogin.isDisplayed())
					
				{
					return(true);
					
				}
				else
				{
					return(false);
					
				}
		   
		   }

}
			
