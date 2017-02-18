package tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import common.Application;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.pages.Pages;
import steps.LoginSteps;

@Story(Application.Limango.AddNumbers.class)
@RunWith(SerenityRunner.class)
public class LimangoPositiveScenarioLogInTest {

	@Managed(driver = "appium")
	public WebDriver driver;

	@ManagedPages
	public Pages pages;

	@Steps
	public LoginSteps loginSteps;

	@Test
	@Title("Log In Positive Scenario - Limango")
	public void login() {
		loginSteps.sendCredentialsKeys();
		loginSteps.startLogIn();
		loginSteps.verifyResult();
	}

	@Test
	@Title("Log In Show Password - Limango")
	public void loginWithShowPassword() {
		loginSteps.sendCredentialsKeys();
		loginSteps.verifyPassword();
		loginSteps.startLogIn();
		loginSteps.verifyResult();
	}
} 