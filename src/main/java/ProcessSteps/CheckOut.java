package ProcessSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class CheckOut {
	
	 WebDriver driver;
	 
	 By ClickButtonCart = By.xpath("//span[text()[normalize-space()='Check out']]");
	 By ClickAddButton = By.xpath("(//i[@class='icon-plus'])[2]");
	 By CartTotal = By.xpath("//span[text()='$70.65']");
	 By CartShipping = By.id("total_shipping");
	 By ClickProceedCheckout = By.xpath("//span[text()='Proceed to checkout']");
	 By ClickProceedCheckoutFromShipping = By.xpath("(//button[@type='submit']//span)[2]");
	 
	 By CheckBoxTerms = By.id("cgv");
	 By ClickPaybycheck   = By.xpath("//a[@title='Pay by check.']");
	 By ConfirmOrder	= By.xpath("//span[text()='I confirm my order']");
	 
	 By ShowCompleteMessage  = By.xpath("//p[text()='Your order on My Store is complete.']");

	 ////button[contains(@class,'button btn')]//span[1]
	//button[contains(@class,'button btn')]//span[1]
	 
	    public CheckOut(WebDriver driver)
	    
	    {
	        this.driver = driver;

	    }
	    
	    public void ClickCartCheckout()
	    {
	    	driver.findElement(ClickButtonCart).click();
	    }
	    
	    public void MouseHovertoCartForCheckout()
	    {	
	        Actions actions = new Actions(driver);
	        //Retrieve WebElement ' ' to perform mouse hover 
	    	WebElement CartMouseHover = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
	    	actions.moveToElement(CartMouseHover).perform();
	    	System.out.println("Done Mouse hover on Cart");
	    	
	    }
	    
	    public void IncreaseTheQuentity()
	    {	
			Actions action = new Actions(driver);
			WebElement Increase =driver.findElement(ClickAddButton);
			action.doubleClick(Increase).perform();
			
	    }

		public String getCartTotal()
		{
		    return   driver.findElement(CartTotal).getText();

		}
		
		public String getCartTotalShipping()
		{
		    return   driver.findElement(CartShipping).getText();

		}
		
	    public void ClickProcessCheckOut()
	    {
	    	driver.findElement(ClickProceedCheckout).click();
	    }
	    
	    public void ClickProcessCheckOutFromShipping()
	    {
	    	driver.findElement(ClickProceedCheckoutFromShipping).click();
	    }
	    
	    public void ClickCheckBoxTerms()
	    {

	        // Selecting CheckBox		
	        WebElement CheckBoxTerms = driver.findElement(By.xpath("//input[@type='checkbox']"));							

	        // This will Toggle the Check box 		
	        CheckBoxTerms.click();	
	    }
	    
	    public void ClickPayByChecks()
	    {
	    	driver.findElement(ClickPaybycheck).click();
	    }
	    
	    public void ClickConfirmOrder()
	    {
	    	driver.findElement(ConfirmOrder).click();
	    }
	    
	    
	    public String VerifyClickConfirmOrder()
	    {

		    return   driver.findElement(ShowCompleteMessage).getText();
	    }
}
