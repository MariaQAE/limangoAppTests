package steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.LoginPage;
import pages.LoginPageIOS;

public class LoginSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;

	LoginPage loginPage;
	LoginPageIOS loginPageIOS;


	@Step("Send Keys to Login")
	public void sendCredentialsKeys() {
		loginPage.sendKeysToLogin();
	}

	@Step("Start LogIn")
	public void startLogIn() {
		loginPage.startLogIn();
	}
	
	@Step("Verify Result")
	public void verifyResult() {
		loginPage.loginResultCheck();
	}

	@Step("verify password")
	public void verifyPassword() {
		loginPage.verifyPassword();
	}

	@Step("Start LogIn")
	public void startLogInIOS() {
		loginPageIOS.sendKeysToLogin();
	}

	@Step("Verify Result")
	public void verifyResultIOS() {
		loginPageIOS.startLogIn();
	}

}

