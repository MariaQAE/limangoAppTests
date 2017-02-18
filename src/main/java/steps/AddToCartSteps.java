package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.AddtoCartPage;

public class AddToCartSteps extends ScenarioSteps {

    private static final long serialVersionUID = 1L;

    AddtoCartPage addtoCartPage;


    @Step("Choose Product")
    public void chooseProduct() {
        addtoCartPage.chooseProduct();
    }

    @Step("Verify Product Size")
    public void verifyProductSize() {
        addtoCartPage.verifyIfProductHasSize();
    }

    @Step("Choose Size")
    public void chooseSizeForAProduct() {
        addtoCartPage.chooseSize();
    }

    @Step("Product added to cart View product in the Cart")
    public void productAddedInCart() {
        addtoCartPage.productAddedToCart();
    }
}

