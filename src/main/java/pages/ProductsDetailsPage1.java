package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsDetailsPage1  extends PageBase1{

	public ProductsDetailsPage1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	 @FindBy(css = "strong.current-item")
	  public WebElement productnamebreadcrumb;
	  
	  @FindBy(css = "button.button-2.email-a-friend-button")
	  WebElement emailfriendbtn;
	  
	  @FindBy(id = "price-value-4")
	  public WebElement productpricelbl;
	  
	  @FindBy(linkText = "Add your review")
	  public WebElement addreviewLink;
	  
	  @FindBy (id = "add-to-wishlist-button-4")
	  WebElement wishListLink;
	  
	  @FindBy (css = "button.button-2.add-to-compare-list-button")
	  WebElement compareListLink;
	  
	  @FindBy(id = "add-to-cart-button-4")
	  WebElement AddToCartbtn;
	  
	  public void OpenSendEmail()
	  {
		  clickbutton(emailfriendbtn);
	  }
	  public void OpenReviewPage() {
		  clickbutton(addreviewLink);
	  }
	  
	  public void AddProductToWishlist() 
	  {
		  clickbutton(wishListLink);
	  }
	  
	  public void AddProductToCompareList() 
	  {
		  clickbutton(compareListLink);
	  }
	  
	  public void AddToCart()
	  {
		  clickbutton(AddToCartbtn);
	  } 
}
