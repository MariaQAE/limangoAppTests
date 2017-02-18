package pages;

import common.Utils;
import common.UtilsAndroid;
import common.UtilsIOS;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;

public class AbstractPage extends PageObject {

	public Utils utils() {
		if (((WebDriverFacade) getDriver()).getProxiedDriver() instanceof IOSDriver) {
			return new UtilsIOS(getDriver());
		} else {
			return new UtilsAndroid(getDriver());
		}
	}
}