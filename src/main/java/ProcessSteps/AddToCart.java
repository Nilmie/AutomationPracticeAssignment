package ProcessSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class AddToCart {
	
	 WebDriver driver;
	 
	 By DressTab = By.xpath("(//a[@class='sf-with-ul'])[4]");
	 By AddChiffonToCart =  By.xpath("//span[text()='Add to cart']");
	 By ClickChiffonDress = By.xpath("(//img[@itemprop='image'])[5]");
	 By BtnContinueShopping = By.xpath("//span[text()[normalize-space()='Continue shopping']]");
	 By TShirtTab = By.xpath("(//a[@title='T-shirts'])[2]");
	 By ClickTShirt = By.xpath("//img[@alt='Faded Short Sleeve T-shirts']");
	 By AddTShirtToCart =  By.xpath("//span[text()='Add to cart']");
	 By CloseButton = By.xpath("//span[@title='Close window']");
	 
	 By CartChiffon = By.partialLinkText("Printed...");
	 By CartTShirt = By.partialLinkText("Faded Shor...");
	 By CartTotal = By.xpath("(//span[text()='$34.91'])[1]");
	 
	 
	    public AddToCart(WebDriver driver)
	    {
	   	 
	        this.driver = driver;

	    }
	    
	    public void ClickDressTab()
	    {
	    	driver.findElement(DressTab).click();
	    }
	    
	    public void SelectChiffonDress()
	    {
	    	driver.findElement(ClickChiffonDress).click();
	    }
	    
	    public void AddChiffonDressToCart()
	    {
	    	driver.findElement(AddChiffonToCart).click();
	    }
	    
	    public void ClickButtonContinueShopping()
	    {
	    	driver.findElement(BtnContinueShopping).click();
	    }
	    
	    
	    public void ClickTShirtTab()
	    {
	    	driver.findElement(TShirtTab).click();
	    }
	    
	    public void SelectTShortandAddtoCart()
	    {
	    	driver.findElement(ClickTShirt).click();
	    	driver.findElement(AddTShirtToCart).click();
	    	driver.findElement(CloseButton).click();
	    }
	    
	    public String VerifyCartChiffon()
	    {

	         return   driver.findElement(CartChiffon).getText();
	     	

	    }
	    
	    public String VerifyCartTShirt()
	    {

	         return   driver.findElement(CartTShirt).getText();

	    }
	    
	    public String VerifyCartTotal()
	    {

	         return   driver.findElement(CartTotal).getText();
	      
	    }
	    
	    
	   
	    

}
