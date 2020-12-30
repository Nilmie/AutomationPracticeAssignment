package ProcessSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	 WebDriver driver;
	 
	 By EmailAddress = By.id("email");
	 By LoginPassword = By.id("passwd");
	 By SignIn = By.xpath("//span[text()[normalize-space()='Sign in']]");
	 
	    public Login(WebDriver driver)
	    {
	    	this.driver = driver;

	
	    }
	    
	    public void EnterEmailandPassword(String email, String Password )
	    {
	    	
			By LoginEmail = By.id("email");
			driver.findElement(LoginEmail).sendKeys(email);
			
			By LoginPassword = By.id("passwd");
			driver.findElement(LoginPassword).sendKeys(Password);
			
			
	    }
	    
	    public void EnterEmailAddress(String email)
	    {
	    	driver.findElement(EmailAddress).sendKeys(email);
	    }
	    
	    
	    public void EnterPassword(String Password)
	    {
	    	driver.findElement(LoginPassword).sendKeys(Password);
	    }
	    

		public void ClickSignin()
		{

			    	driver.findElement(SignIn).click();
		}
	    
		 public void SigninUser (String email, String Password )
		 {
			 this.EnterEmailandPassword(email,Password );
			 this.ClickSignin();  
		 }
}
