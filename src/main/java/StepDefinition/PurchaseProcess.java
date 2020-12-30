package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import ProcessSteps.*;
import Utility.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class PurchaseProcess {
	
	WebDriver driver;
	SignIn objsignin;
	AddToCart ObjAddToCart;
	CheckOut ObjCheckOut;
	Login ObjLogin;
	
	@Given("^I Should Go sign up as a new user and sign in to Page$")
	public void i_Should_Go_sign_up_as_a_new_user_and_sign_in_to_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        
        objsignin = new SignIn(driver);
        objsignin.EnterEmailAddress(JSONReader.ReadJSONFile("email", "./Data/EnterEmailAddress.json"));
        objsignin.CreateAccount();
        
        String SelectTitle = (JSONReader.ReadJSONFile("Title", "./Data/Registerinfo.json")); 
		switch (SelectTitle)
		{
	    case "Mr.":
	    	objsignin.SetTitleMr();
	    	 break;
	    case "Mrs.":
	    	objsignin.SetTitleMrs();
	    	break;
		}
		
		objsignin.RegisterUser(JSONReader.ReadJSONFile("Firstname", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Lastname", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Password", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("DateofBirthDay", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("DateofBirthMonth", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("DateofBirthYear", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Company", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Address", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Address2", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("City", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("State", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("ZipCode", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Country", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Additionalinfo", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Homephone", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Mobilephone", "./Data/Registerinfo.json")
				,JSONReader.ReadJSONFile("Assignaddress", "./Data/Registerinfo.json"));
        
		
		objsignin.ClickSignOut();
        
        
        
        ObjLogin = new Login(driver);
        ObjLogin.EnterEmailAddress(JSONReader.ReadJSONFile("email", "./Data/EnterEmailAddress.json"));
        ObjLogin.EnterPassword(JSONReader.ReadJSONFile("Password", "./Data/Registerinfo.json"));
        ObjLogin.ClickSignin();  
        //ObjLogin.SigninUser(JSONReader.ReadJSONFile("email", "./Data/EnterEmailAddress.json"),JSONReader.ReadJSONFile("Password", "./Data/EnterEmailAddress.jsonn"));
        
		
	}

	@Given("^Direct to Dresses Tab and Select Items and add to Cart$")
	public void direct_to_Dresses_Tab_and_Select_Items_and_add_to_Cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
			ObjAddToCart  = new AddToCart(driver);
			
			ObjAddToCart.ClickDressTab();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ObjAddToCart.SelectChiffonDress();	

	 		ObjAddToCart.AddChiffonDressToCart();
			ObjAddToCart.ClickButtonContinueShopping();
			ObjAddToCart.ClickTShirtTab();
			ObjAddToCart.SelectTShortandAddtoCart();
			
			
	        //Instantiate Action Class        
	        Actions actions = new Actions(driver);
	        //Retrieve WebElement ' ' to perform mouse hover 
	    	WebElement CartMouseHover = driver.findElement(By.xpath("//a[@title='View my shopping cart']"));
	    	actions.moveToElement(CartMouseHover).perform();
	    	
	    	
			Assert.assertTrue(ObjAddToCart.VerifyCartChiffon().contains("Printed..."));
			
			Assert.assertTrue(ObjAddToCart.VerifyCartTShirt().contains("Faded Shor..."));
	} 

	@When("^I Go to check out in the drop down and Increase the quantity$")
	public void i_Go_to_check_out_in_the_drop_down_and_Increase_the_quantity() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ObjCheckOut  = new CheckOut(driver);
		ObjCheckOut.MouseHovertoCartForCheckout();
		ObjCheckOut.ClickCartCheckout();
		ObjCheckOut.IncreaseTheQuentity();
		
		Assert.assertTrue(ObjCheckOut.getCartTotalShipping().contains("$2.00"));

		Assert.assertEquals(ObjCheckOut.getCartTotal(), "$70.65");//(ObjCheckOut.getCartTotal().contains("$70.65"));
		
	}

	@Then("^I should Proceed with check out process and select Pay by check$")
	public void i_should_Proceed_with_check_out_process_and_select_Pay_by_check() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		ObjCheckOut  = new CheckOut(driver);
		ObjCheckOut.ClickProcessCheckOut();
		ObjCheckOut.ClickProcessCheckOut();
		
		ObjCheckOut.ClickCheckBoxTerms();
		ObjCheckOut.ClickProcessCheckOutFromShipping();
		ObjCheckOut.ClickPayByChecks();
		ObjCheckOut.ClickConfirmOrder();
		

	}

	@Then("^Verify the order is completed$")
	public void verify_the_order_is_completed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ObjCheckOut  = new CheckOut(driver);
		Assert.assertTrue(ObjCheckOut.VerifyClickConfirmOrder().contains("Your order on My Store is complete."));

	}


}
