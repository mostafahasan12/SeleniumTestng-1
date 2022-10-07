package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage1;
import pages.ProductsDetailsPage1;
import pages.SearchPage1;



public class ChangeCurrencyTest extends TestBase1 {
HomePage1 homeobject;
ProductsDetailsPage1 detailsobject;
SearchPage1 searchobject;

String productName = "Apple MacBook Pro 13-inch";


@Test (priority = 1)
public void UserCanChangeCurrency()
{
	homeobject = new HomePage1(driver);
	homeobject.changeCurrency();
	}
@Test (priority = 2)
public void UserCanSearchWithAutoSugguest() 
{
	try {
		searchobject = new SearchPage1(driver);
		searchobject.ProductSearchUsingAutoSuggest("MacB");
		detailsobject = new ProductsDetailsPage1(driver);
		Assert.assertEquals(detailsobject.productnamebreadcrumb.getText(), productName);
		Assert.assertTrue(detailsobject.productpricelbl.getText().contains("€"));
	} catch (Exception e) {
		System.out.println("Error occured " + e.getMessage());
	}	
}
}
