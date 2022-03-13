package glue;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ComposePage;
import pages.HomePage;
import pages.LoginPage;
import pages.LogoutPage;

public class StepDef 
{
	//declare objects as global to use in all step definition methods
	public RemoteWebDriver driver;
	public HomePage obj1;
	public LoginPage obj2;
	public ComposePage obj3;
	public LogoutPage obj4;
	
	@Given("open {string} browser")
	public void method1(String bn)
	{
		if(bn.equalsIgnoreCase("Chrome"))		
		{
			WebDriverManager.chromedriver().setup();
 			//define objects
			driver = new ChromeDriver();
	        obj1 = new HomePage(driver);
	        obj2 = new LoginPage(driver);
	        obj3 = new ComposePage(driver);
	        obj4 = new LogoutPage(driver);
		}
		
	}
	
    @Given("launch site using {string}")
    public void method2(String url) throws Exception
    {
    	driver.get(url);
        Thread.sleep(5000);

    }
    
    @When("do login using {string} and {string} credentials")
    public void method3(String un,String pwd) throws Exception
    {
    
        obj1.fillUserName(un);
        obj1.clickHomeNext();
        obj2.fillPassword(pwd);
        obj2.clickLoginNext();
    }
    
    @Then("compose is displayed")
    public void method4()
    {
    	if(obj3.isComposeDisplayed())
    	{
    		System.out.println("Compose is displayed");
    	}
    	else
    	{
    		System.out.println("Compose is not displayed");
    		System.exit(0);
    	
    	}
}
    @When ("click on compose and fill fields and send mail and check response")
    public void method5(DataTable dt) throws Exception
    {
    	//Take data from DataTable 
    	List<Map<String,String>> l=dt.asMaps();
    	for(int i=0; i<l.size(); i++)
    	{
    		//Click on Compose
    		obj3.clickCompose();
    		//fill fields
    		obj3.fillTo(l.get(i).get("to"));
    		obj3.fillsubject(l.get(i).get("subject"));
    		obj3.fillBody(l.get(i).get("body"));
    		obj3.fillFilePath(l.get(i).get("attachment"));
    		//Send mail
    		obj3.clickSend();
    		System.out.println(obj3.getOutputMsg());
    		
    		
    	}	
    
    	}
    @When ("do logout")
    public void method6() throws Exception
    {
    	obj4.clickProfilePic();
    	driver.switchTo().frame(2);
    	obj4.clickSignout();
    	driver.switchTo().defaultContent();
    	Thread.sleep(5000);
    	
    }
    
    @Then("login page should be redisplayed")
    public void method7() throws Exception
    {
    	if(obj4.isLoginReDisplayed())
    	{
    		System.out.println("Successful logout");
    	}
    	else
    	{
    		System.out.println("Unsuccessful logout");
    		System.exit(0);
    	}
    }
    @When("close site")
    public void method8()
    {
    	driver.close();
    }
}

