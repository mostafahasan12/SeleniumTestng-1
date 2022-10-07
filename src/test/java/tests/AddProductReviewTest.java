package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailPage1;
import pages.HomePage1;
import pages.LoginPage1;
import pages.ProductPageReview;
import pages.ProductsDetailsPage1;
import pages.SearchPage1;
import pages.UserRegistrationPage1;


public class AddProductReviewTest extends TestBase1 {
	HomePage1 homeobject;
	UserRegistrationPage1 registerobject; 
	LoginPage1 loginobject;
	ProductsDetailsPage1 detailsobject;
	SearchPage1 searchobject;
    String   productName = "Apple MacBook Pro 13-inch";
	ProductPageReview reviewobject;
	EmailPage1  emailobject;
	
//	1 - user registertion
	@Test (priority = 1 )
	public void UserCanRegisterSuccssfully()
	{
		homeobject = new HomePage1(driver);
		homeobject.openRegistrationPage();
		registerobject = new UserRegistrationPage1(driver);
		registerobject.userRegistration("mostafa", "hasan", "test218email@gmail.com", "12345678");
		Assert.assertTrue(registerobject.sucessmessage.getText().contains("Your registration completed"));
		}
//	2- search for product
	@Test (priority = 2 )
	public void UserCanSearchWithAutoSugguest() 
	{
		try {
			searchobject = new SearchPage1(driver);
			searchobject.ProductSearchUsingAutoSuggest("MacB");
			detailsobject = new ProductsDetailsPage1(driver);
			Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
		} catch (Exception e) {
			System.out.println("Error occured " + e.getMessage());
		}
	}
	
//	3- Email to friend
	@Test (priority = 3)
	public void RegisteredUserCanReviewForproduct() 
	{
		detailsobject.OpenReviewPage();
		reviewobject = new ProductPageReview(driver);
		reviewobject.AddProductReview("New Review", "the product is good");
		Assert.assertTrue(reviewobject.reviewNotification.getText()
				.contains("Product review is successfully added."));
	}	
//	4- user logout 	
	@Test (priority = 4)
	public void RegisteredUserCanLogout() 
	    {
		registerobject.userlogout();
		}
}
