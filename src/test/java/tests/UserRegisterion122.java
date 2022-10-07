package tests;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.HomePage1;
import pages.LoginPage1;
import pages.UserRegistrationPage1;

public class UserRegisterion122 extends TestBase1{
	HomePage1 homeobject;
	UserRegistrationPage1 registerobject; 
    LoginPage1 loginobject;
	public Object sucessmessage;

	@Test (priority = 1 )
	public void UserCanRegisterSuccssfully()
	{
		homeobject = new HomePage1(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage1(driver);
		registerobject.userRegistration("mostafa", "hasan", "test5email@gmail.com", "12345678");
		Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
		}
	@Test (dependsOnMethods = {"UserCanRegisterSuccssfully"})
	public void RegisteredUserCanLogout() 
	    {
		registerobject.userlogout();
		}
	@Test (dependsOnMethods = {"RegisteredUserCanLogout"})
	public void RegisteredUserCanLogIn() 
	{
		homeobject.openLoginpage();
		loginobject = new LoginPage1(driver);
		loginobject.userLogin("test1778email@gmail.com", "7896564");
	}
}
