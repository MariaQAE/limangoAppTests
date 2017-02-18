package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.ui.Sleeper;

public class LoginPage extends AbstractPage {

	public String email = "limangotestingautomation@gmail.com";

	public String password = "automation123123";

	final String appNameId = "de.limango.shop.alpha:id/";

	@FindBy(id = appNameId + "textViewLogin")
	public WebElement login;

	@FindBy(id = appNameId + "editTextEmail")
	public WebElement emailLogIn;

	@FindBy(id = appNameId + "layoutPasswordContainer")
	public WebElement passwordLogIn;

	@FindBy(id = appNameId + "editTextPassword")
	public WebElement shownPassword;

	@FindBy(id = appNameId + "textViewLogin")
	public WebElement logInButtonOnLogginPage;

	@FindBy(id = appNameId + "textViewTabName")
	public WebElement afterLogInResult;

	@FindBy(id = appNameId + "layoutContent")
	public WebElement tapOnLoyout;

	@FindBy(id = appNameId + "imageViewEye")
	public WebElement verifyPassword;


	public void sendKeysToLogin() {
		element(login).waitUntilVisible();
		login.click();
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

	public void loginResultCheck() {
		element(afterLogInResult).waitUntilVisible();
		Boolean res = afterLogInResult.isDisplayed();
		System.out.println("Result: " + res);
		Assert.assertTrue("User not logged in: ", res);
	}
}