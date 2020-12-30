package ProcessSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SignIn {
	
	 WebDriver driver;
	 
	 By EmailAddress = By.id("email_create");
	 By BtnCreateAccount = By.xpath("//span[text()[normalize-space()='Create an account']]");
	
	 By BtnRegister = By.xpath("//span[text()='Register']");
	 By TitleMr = By.id("id_gender1");
	 By TitleMrs = By.id("id_gender2");
	 By Signout = By.linkText("Sign out");
	 
	 
	    public SignIn(WebDriver driver)
	    {
	    	this.driver = driver;

	
	    }
	    
	    public void EnterEmailAddress(String email)
	    {
	    	driver.findElement(EmailAddress).sendKeys(email);
	    }
	    
		public void CreateAccount()
		{

			    	driver.findElement(BtnCreateAccount).click();
		}
		
		public void ClickRegister()
		{

			    	driver.findElement(BtnRegister).click();
		}
		
	    public void SetTitleMr()
	    {

	           driver.findElement(TitleMr).click();

		 }
	    
	    public void SetTitleMrs()
	    {

	           driver.findElement(TitleMrs).click();

		 }
		
		public void EnterPersonalInformation(String Firstname, String Lastname, String Password, String DateofBirthDay,	String DateofBirthMonth, String DateofBirthYear ,String Company,	
				String Address,	String Address2,String City ,String State ,	String ZipCode,	String Country, String Additionalinfo,	String Homephone , String Mobilephone, 	String Assignaddress)
		{
			
			   By cusfirstname = By.id("customer_firstname");
			   driver.findElement(cusfirstname).sendKeys(Firstname);
			    
			   By cuslastname = By.id("customer_lastname");
			   driver.findElement(cuslastname).sendKeys(Lastname);
			   
			   //By cusemail = By.id("email");
			   // driver.findElement(cusemail).sendKeys(Email);
			   
			   By cuspasswd = By.id("passwd");
			   driver.findElement(cuspasswd).sendKeys(Password);
			   
			   Select cusDateofBirthDay = new Select(driver.findElement(By.name("days")));
			   cusDateofBirthDay.selectByVisibleText (DateofBirthDay); 
						    
			   Select cusDateofBirthMonth = new Select(driver.findElement(By.name("months")));
			   cusDateofBirthMonth.selectByVisibleText (DateofBirthMonth); 
						    
			   Select cusDateofBirthYear = new Select(driver.findElement(By.name("years")));
			   cusDateofBirthYear.selectByVisibleText (DateofBirthYear); 
			   
			  // By cusAddressFirstname = By.id("firstname");
			  // driver.findElement(cusAddressFirstname).sendKeys(AddressFirstname);
			    
			  // By cusAddressLastname = By.id("lastname");
			  // driver.findElement(cusAddressLastname).sendKeys(AddressLastname);
			   
			   By cusCompany = By.id("company");
			   driver.findElement(cusCompany).sendKeys(Company);
			   
			   By cusAddress = By.id("address1");
			   driver.findElement(cusAddress).sendKeys(Address);
			   
			   By cusAddress2 = By.id("address2");
			   driver.findElement(cusAddress2).sendKeys(Address2);
			   
			   By cusCity = By.id("city");
			   driver.findElement(cusCity).sendKeys(City);
			   
			   Select cusState = new Select(driver.findElement(By.name("id_state")));
			   cusState.selectByVisibleText(State);  
			   
			   By cusZipCode = By.id("postcode");
			   driver.findElement(cusZipCode).sendKeys(ZipCode);
			   
			   Select cusCountry = new Select(driver.findElement(By.name("id_country")));
			   cusCountry.selectByVisibleText(Country);  
			   
			   By cusAdditionalinfo = By.id("other");
			   driver.findElement(cusAdditionalinfo).sendKeys(Additionalinfo);
			   
			   By cusHomephone = By.id("phone");
			   driver.findElement(cusHomephone).sendKeys(Homephone);
			   
			   By cusMobilephone = By.id("phone_mobile");
			   driver.findElement(cusMobilephone).sendKeys(Mobilephone);
			   
			   By cusAssignaddress = By.id("alias");
			   driver.findElement(cusAssignaddress).clear();
			   driver.findElement(cusAssignaddress).sendKeys(Assignaddress);

	   
		}

		   public void RegisterUser(String Firstname, String Lastname,  String Password, String DateofBirthDay,	String DateofBirthMonth, String DateofBirthYear, String Company,	
					String Address,	String Address2,String City ,String State ,	String ZipCode,	String Country, String Additionalinfo,	String Homephone , String Mobilephone, 	String Assignaddress)

		   {
			   this.EnterPersonalInformation(Firstname, Lastname, Password, DateofBirthDay,	DateofBirthMonth, DateofBirthYear, Company,	Address,	Address2, City ,State ,	ZipCode, Country, Additionalinfo, Homephone , Mobilephone, 	Assignaddress);
		
		        this.ClickRegister();        
		   }
		   
		 
			public void ClickSignOut()
			{

				    	driver.findElement(Signout).click();
			}
		   
}
