package tests;

import common.Application;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.LoginSteps;
import steps.AddToCartSteps;

@Story(Application.Limango.AddNumbers.class)
@RunWith(SerenityRunner.class)
public class LimagoAddToCartProductTest {

	@Managed(driver = "appium")
	public WebDriver driver;

	@ManagedPages
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public AddToCartSteps addToCartSteps;

	@Test
	@Title("Add to cart Scenario - Limango")
	public void AddToCart() {
		loginSteps.sendCredentialsKeys();
		loginSteps.startLogIn();
		loginSteps.verifyResult();
		addToCartSteps.chooseProduct();
		addToCartSteps.verifyProductSize();
		addToCartSteps.chooseSizeForAProduct();
		addToCartSteps.productAddedInCart();

	}
} 