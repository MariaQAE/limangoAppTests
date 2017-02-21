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

public class LoginPageIOS extends AbstractPage {

	public String email = "limangotestingautomation@gmail.com";

	public String password = "automation123123";

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[1]")
	public WebElement logInButton;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIATextField[1]/UIATextField[1]")
	public WebElementFacade emialInput;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIASecureTextField[1]/UIASecureTextField[1]")
	public WebElement passwordInput;

	@iOSFindBy(xpath = "//UIAApplication[1]/UIAWindow[1]/UIAButton[5]")
	public WebElement logInButtonOnLogginPage;

	public void sendKeysToLogin() {
//		element(logInButton).waitUntilVisible();
//		logInButton.click();
//		element(emialInput).waitUntilVisible();
		emialInput.click();
		emialInput.sendKeys(email);
		passwordInput.click();
		passwordInput.sendKeys(password);

	}

	public void startLogIn() {
		element(logInButtonOnLogginPage).waitUntilVisible();
		logInButtonOnLogginPage.click();
	}

}
