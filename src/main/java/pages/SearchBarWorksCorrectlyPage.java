package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchBarWorksCorrectlyPage extends AbstractPage {

    public String searchInputKeyWords = "Lin";


    final String appNameId = "de.limango.shop.alpha:id/";

    @FindBy(xpath = "//" + "android.widget.TextView[@text='Favoriten']")
    public WebElement heartShapedButton;

    @FindBy(id = appNameId + "textViewBrands")
    public WebElement markenButton;

    @FindBy(id = appNameId + "textViewAddItems")
    public WebElement markenHinzufButton;

    @FindBy(id = appNameId + "editTextSearch")
    public WebElement searchInputBar;

    @FindBy(id = appNameId + "textViewBrandTitle")
    public WebElement brandTitle;

    @FindBy(id = appNameId + "recyclerView")
    public WebElement resultListOfBrands;




    public void clickOnHeartShapedProduct() {
        element(heartShapedButton).waitUntilVisible();
        heartShapedButton.click();
    }

    public void markenScreen() {
        markenButton.click();
        markenHinzufButton.click();
        element(searchInputBar).waitUntilVisible();
        searchInputBar.click();
        searchInputBar.sendKeys(searchInputKeyWords);
        element(brandTitle).waitUntilVisible();
        WebElement indexBrand = resultListOfBrands.findElement(By.xpath("//" + "android.widget.TextView[@index=0]"));
        String findBrandName = indexBrand.getText();
        System.out.println(findBrandName);
        Boolean compareSearchResultsWithBrandName = findBrandName.toLowerCase().contains(searchInputKeyWords.toLowerCase());
        System.out.println(compareSearchResultsWithBrandName);
        Assert.assertTrue("Search Result does not correspond to Search Criteria", compareSearchResultsWithBrandName);
    }
}