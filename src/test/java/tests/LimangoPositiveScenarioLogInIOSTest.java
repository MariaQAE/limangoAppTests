package tests;

import common.Application;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.*;
import net.thucydides.core.pages.Pages;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.LoginSteps;

@Story(Application.Limango.AddNumbers.class)
@RunWith(SerenityRunner.class)
public class LimangoPositiveScenarioLogInIOSTest {

	@Managed(driver = "appium")
	public WebDriver driver;

	@ManagedPages
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Test
	@Title("Log In Positive Scenario - Limango")
	public void login() {
		loginSteps.startLogInIOS();
		loginSteps.verifyResultIOS();
	}

//	@Test
//	@Title("Log In Show Password - Limango")
//	public void loginWithShowPassword() {
//		loginSteps.sendCredentialsKeys();
//		loginSteps.verifyPassword();
//		loginSteps.startLogIn();
//		loginSteps.verifyResult();
//	}
} 