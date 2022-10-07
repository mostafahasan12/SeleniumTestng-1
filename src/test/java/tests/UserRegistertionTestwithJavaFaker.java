package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;



import pages.HomePage1;
import pages.LoginPage1;
import pages.UserRegistrationPage1;

public class UserRegistertionTestwithJavaFaker  extends TestBase1
{
HomePage1 homeobject;
UserRegistrationPage1 registerobject; 
LoginPage1 loginobject;

Faker fakedata = new Faker();
String firstname = fakedata.name().firstName();
String lastname = fakedata.name().lastName();
String email = fakedata.internet().emailAddress();
String password = fakedata.number().digits(8).toString();

@Test (priority = 1 )

public void UserCanRegisterSuccssfully()
{
	homeobject = new HomePage1(driver);
	homeobject.openRegistrationPage();
	registerobject = new UserRegistrationPage1(driver);
	registerobject.userRegistration(firstname , lastname , email , password );
	System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
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
	loginobject.userLogin(email , password);
}
}
