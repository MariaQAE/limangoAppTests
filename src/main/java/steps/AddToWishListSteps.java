package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.AddtoWishListPage;

public class AddToWishListSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    AddtoWishListPage addtoWishListPage;


    @Step("Choose Product")
    public void chooseProduct() {
        addtoWishListPage.chooseProduct();
    }

    @Step("Add Bulk Product")
    public void addBulkProduct() {
        addtoWishListPage.addBulkProduct();
    }

    @Step("Choose Size")
    public void wishListProductCount() {
        addtoWishListPage.wishListProductCount();
    }
}

