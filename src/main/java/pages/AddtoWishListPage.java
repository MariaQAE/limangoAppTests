package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class AddtoWishListPage extends AbstractPage {

	final String appNameId = "de.limango.shop.alpha:id/";

	@FindBy(id = appNameId + "imageViewTab")
	public WebElement actionen;

	@FindBy(xpath = "//" + "android.widget.TextView[@text='Outlet']")
	public WebElement outletButton;

	@FindBy(xpath = "//" + "android.widget.TextView[@text='Damen']")
	public WebElement damenCategory;

	@FindBy(xpath = "//" + "android.widget.TextView[@text='Alle Kategorieprodukte']")
	public WebElement alleKategorieprodukteButton;

	@FindBy(id = appNameId + "item_container")
	public WebElement productContainer;

	@FindBy(id = appNameId + "buttonAddToShoppingCart")
	public WebElement addToCartButton;

	@FindBy(id = appNameId + "imageViewLike")
	public WebElement heartShabedButton;

	@FindBy(id = appNameId + "textViewProductSize")
	public WebElement productSize;

	@FindBy(id = appNameId + "textViewSizePopupAccept")
	public WebElement fertigSizeAcceptButton;

	@FindBy(id = appNameId + "imageViewBack")
	public WebElement backButton;

	@FindBy(id = appNameId + "textViewWishListItemsCount")
	public WebElement countWishLisRedIcon;

	@FindBy(id = appNameId + "textViewProducts")
	public WebElement produkteButton;

	@FindBy(id = appNameId + "layoutContainer")
	public WebElement layoutProductContainerInWishList;

	@FindBy(id = appNameId + "layoutRecyclerViewParent")
	public WebElement productsChooseLayout;


	public void chooseProduct() {
		actionen.click();
		element(outletButton).waitUntilVisible();
		outletButton.click();
		element(damenCategory).waitUntilVisible();
		damenCategory.click();
		element(alleKategorieprodukteButton).waitUntilVisible();
		alleKategorieprodukteButton.click();
		element(productContainer).waitUntilVisible();

	}
	public void addBulkProduct() {
		Integer count = 0;
		for (int j = 0; j < 3; j++) {
			for (int i = 0; i <= 3; i++) {
				if (count == 10) {
					break;
				}
				count++;
				WebElement indexedProduct = productsChooseLayout.findElement(By.xpath("//" + "android.widget.FrameLayout[@index=" + i +"]"));
				indexedProduct.click();
				element(addToCartButton).waitUntilVisible();
				heartShabedButton.click();
				element(productSize).waitUntilVisible();
				productSize.click();
				element(fertigSizeAcceptButton).waitUntilVisible();
				fertigSizeAcceptButton.click();
				element(backButton).waitUntilVisible();
				backButton.click();
			}
			this.scrollPageDown();
		}
	}

	public void wishListProductCount() {
		String wishItemsCount = countWishLisRedIcon.getText();
		countWishLisRedIcon.click();
		element(produkteButton).waitUntilVisible();
		produkteButton.click();
		Integer wishListItemsCount = utils().androidDriver().findElements(By.xpath("//" + "android.widget.LinearLayout")).size();
		System.out.println(wishListItemsCount);
		//Assert.assertEquals("Wish List Icon, there are not 10 Items in the Wish List: ", wishItemsCount, "10");
		Assert.assertEquals("Wish List Page, there are not 10 Items in the Wish List: ","10", wishListItemsCount.toString());
	}

	private void scrollPageDown() {
		setImplicitTimeout(1, TimeUnit.SECONDS);
		Dimension dimensions = getDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.9;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.01;
		int scrollEnd = screenHeightEnd.intValue();
		for (int i = 0; i < 2; i++) {
			utils().androidDriver().swipe(25, scrollStart, 25, scrollEnd, 1000);
		}
		resetImplicitTimeout();
	}
}