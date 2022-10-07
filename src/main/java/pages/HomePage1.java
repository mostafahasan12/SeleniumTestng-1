package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage1 extends PageBase1 {
	public HomePage1(WebDriver driver) {
		super(driver);	
		 jse = (JavascriptExecutor) driver;
		 action = new Actions(driver); 
	}
    @FindBy(linkText ="Register")
    WebElement registerlink;                
    
    @FindBy(linkText ="Log in")
    WebElement loginlink; 
    
    @FindBy (linkText = "Contact us")
    WebElement contacttxt;
     
    @FindBy(css ="a.ico-account")
	 WebElement MyaccountLink;
    
    @FindBy(id = "customerCurrency")
    WebElement currencydrl;
    
	@FindBy(linkText="Electronics")
	WebElement ElectronicsMenu; 
	
	@FindBy(linkText="Cell phones")
	WebElement CellMenu; 
    
    public void openRegistrationPage() 
    {
    	registerlink.click();
    }  
   
    public void openLoginpage() 
    {
    	registerlink.click();
    }  
    public void OpenMyaccountPage() 
    {
    	clickbutton(MyaccountLink);
    }

    public void openContactUsPage() 
    {
    	ScrollBottom();
    	clickbutton(contacttxt);
    }
    
    public void changeCurrency() 
    {
    	select = new Select(currencydrl);
    	select.selectByVisibleText("Euro");
    }
}
