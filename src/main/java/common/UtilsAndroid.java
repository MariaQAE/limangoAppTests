package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UtilsAndroid extends Utils {

	WebDriver driver;

	public UtilsAndroid(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@SuppressWarnings("unchecked")
	public AndroidDriver<AndroidElement> androidDriver() {
		return (AndroidDriver<AndroidElement>) ((WebDriverFacade) driver).getProxiedDriver();
	}

	@Override
	public void hideKeyboard() {
		androidDriver().hideKeyboard();
	}

	@Override
	public void removeApp() {
		// androidDriver().removeApp("com.namshi.android");
	}

	@Override
	public void swipeDownToElement(WebElementFacade element) {
		Dimension dimensions = appiumDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.80;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.45;
		int scrollEnd = screenHeightEnd.intValue();
		int height = dimensions.getHeight();
		for (int i = 0; i < height; i++) {
			if (isElementVisible(element)) {
				break;
			}
			androidDriver().swipe(10, scrollStart, 10, scrollEnd, 1000);
		}
	}

	@Override
	public void swipeDown() {
		Dimension size;
		size = appiumDriver().manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.45);
		int startx = size.width / 2;
		androidDriver().swipe(startx, starty, startx, endy, 1000);
	}

	@Override
	public IOSDriver<?> iOSDriver() {
		return null;
	}

	@Override
	public void alertShouldBeDisplayed(String message) {

	}

	@Override
	public void slideRight() {
		Dimension dimensions = appiumDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getWidth() * 0.003;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getWidth() * 0.45;
		int scrollEnd = screenHeightEnd.intValue();
		androidDriver().swipe(scrollStart, 15, scrollEnd, 15, 1000);
	}
}
