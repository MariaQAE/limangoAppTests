package tests;

import common.Application;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.AddToWishListSteps;
import steps.LoginSteps;
import steps.SearchBarWorksCorrectlySteps;

@Story(Application.Limango.AddNumbers.class)
@RunWith(SerenityRunner.class)
public class SearchBarWorksCorrectlyTest {

	@Managed(driver = "appium")
	public WebDriver driver;

	@ManagedPages
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Steps
	public AddToWishListSteps addToWishListSteps;

	@Steps
	public SearchBarWorksCorrectlySteps searchBarWorksCorrectlyTestSteps;



	@Test
	@Title("Add to cart Scenario - Limango")
	public void AddToWishList() {
		loginSteps.sendCredentialsKeys();
		loginSteps.startLogIn();
		loginSteps.verifyResult();
		searchBarWorksCorrectlyTestSteps.goToWishList();
		searchBarWorksCorrectlyTestSteps.markenButton();
	}
} 