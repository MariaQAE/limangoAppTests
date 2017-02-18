package pages;

import common.Utils;
import io.appium.java_client.pagefactory.iOSFindBy;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class LoginPageIOS {

	public String email = "limangotestingautomation@gmail.com";

	public String password = "automation123123";

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	private WebElement logInButton;

	@iOSFindBy(accessibility = "back button")
	private WebElementFacade backButton;

	@iOSFindBy(className = "UIANavigationBar")
	private WebElement navigationBar;

	public void sendKeysToLogin() {
		element(logInButton).waitUntilVisible();
		logInButton.click();
		element(emailLogIn).waitUntilVisible();
		emailLogIn.click();
		emailLogIn.sendKeys(email);
		passwordLogIn.click();
		passwordLogIn.sendKeys(password);
		tapOnLoyout.click();
	}

	public void startLogIn() {
		element(logInButtonOnLogginPage).waitUntilVisible();
		logInButtonOnLogginPage.click();
	}

	public void verifyPassword() {
		verifyPassword.click();
		String passwordCheck = shownPassword.getText();
		System.out.println("Result: " + passwordCheck);
		Assert.assertTrue("Password cannot be seenz: ", passwordCheck.contentEquals(password));
	}


}
