package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.SearchBarWorksCorrectlyPage;

public class SearchBarWorksCorrectlySteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    SearchBarWorksCorrectlyPage searchBarWorksCorrectlyPage;


    @Step("Choose Product")
    public void goToWishList() {
        searchBarWorksCorrectlyPage.clickOnHeartShapedProduct();
    }


    @Step("Search by Brand")
    public void markenButton() {
        searchBarWorksCorrectlyPage.markenScreen();
    }
}

