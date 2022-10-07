package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage1 extends HomePage1 {
	public LoginPage1(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Email")
	WebElement emailtxtbox;
	
	@FindBy(id = "Password")
	WebElement passwordtxtbox;
	
	@FindBy(linkText ="Log in")
	WebElement loginbtn;
	
	public void userLogin(String email , String password) 
	{
		setElementText(emailtxtbox ,"");
		setElementText(passwordtxtbox ,"");
		clickbutton(loginbtn);
	}
}
