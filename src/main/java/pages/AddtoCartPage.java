package pages;

import net.thucydides.core.pages.PageObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddtoCartPage extends AbstractPage {

	final String appNameId = "de.limango.shop.alpha:id/";

	@FindBy(id = appNameId + "imageViewTab")
	public WebElement actionen;

	@FindBy(id = appNameId + "layoutMainInfo")
	public WebElement productMainInfoFromLeft;

	@FindBy(id = "simpleDraweeViewCampaign")
	public WebElement productCompaign;

	@FindBy(id = appNameId + "imageViewProductPhoto")
	public WebElement productPicture;

	@FindBy(id = appNameId + "productSimpleDraweeView")
	public WebElement productDetailViewImage;

	@FindBy(id = appNameId + "buttonAddToShoppingCart")
	public WebElement addToCartButton;

	@FindBy(id = appNameId + "textViewProductSize")
	public WebElement productSize;

	@FindBy(id = appNameId + "imageViewSelected")
	public WebElement tickForChosenSize;

	@FindBy(id = appNameId + "textViewSizePopupAccept")
	public WebElement fertigSizeAcceptButton;

	@FindBy(id = appNameId + "textViewAddedToCart")
	public WebElement productAddedToCartMessage;

	@FindBy(id = appNameId + "buttonCheckShoppingBag")
	public WebElement buttonCheckShoppingBag;

	@FindBy(id = appNameId + "fragmentShoppingBag")
	public WebElement shoppingBagScreen;


	public void chooseProduct() {
		actionen.click();
		element(productMainInfoFromLeft).waitUntilVisible();
		productCompaign.click();
		element(productPicture).waitUntilVisible();
		productPicture.click();
		element(productDetailViewImage).waitUntilVisible();
		addToCartButton.click();
	}

	public void verifyIfProductHasSize() {
		element(productSize).waitUntilVisible();
		Boolean res = productSize.isDisplayed();
		System.out.println("Result: " + res);
		Assert.assertTrue("Product does not have a size: ", res);
	}

	public void chooseSize() {
		productSize.click();
		element(tickForChosenSize).waitUntilVisible();
		fertigSizeAcceptButton.click();
		element(addToCartButton).waitUntilVisible();
		addToCartButton.click();
	}

	public void productAddedToCart() {
		buttonCheckShoppingBag.click();
		element(shoppingBagScreen).waitUntilVisible();
		Boolean res = shoppingBagScreen.isDisplayed();
		System.out.println("Result: " + res);
		Assert.assertTrue("Product is not added to cart: ", res);
	}

}