package tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;


import pages.HomePage1;
import pages.ProductsDetailsPage1;
import pages.SearchPage1;
import pages.WishListPage;

public class AddProductsToWishlistTest  extends TestBase1 {
	HomePage1 homeobject;
	ProductsDetailsPage1 detailsobject;
	SearchPage1 searchobject;
	String productName = "Apple MacBook Pro 13-inch";	
	WishListPage wishlistobject;
	//	search for product
	@Test (priority = 1 )
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
	@Test (priority = 2 )
	public void UserCanAddProductToWishlist() 
	{
		detailsobject = new ProductsDetailsPage1(driver);
		detailsobject.AddProductToWishlist();
		driver.navigate().to("https://demo.nopcommerce.com"+"/wishlist");
		wishlistobject = new WishListPage(driver);
		assertTrue(wishlistobject.wishlistheader.isDisplayed());
		assertTrue(wishlistobject.productcell.getText().contains(productName));
	}
	@Test (priority = 3 )
	public void UserCanAddRemoveProductFromCart() 
	{
    wishlistobject.removeProductFromWishlist();
    assertTrue(wishlistobject.EmptyCartLabel.getText().contains("The wishlist is empty!"));
	}
}   
