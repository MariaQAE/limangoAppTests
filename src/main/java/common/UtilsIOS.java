package common;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UtilsIOS extends Utils {

	WebDriver driver;

	public UtilsIOS(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Override
	@SuppressWarnings("unchecked")
	public IOSDriver<IOSElement> iOSDriver() {
		return (IOSDriver<IOSElement>) ((WebDriverFacade) driver).getProxiedDriver();
	}

	public void alertShouldBeDisplayed(String message) {
		boolean containMessage = false;
		WebElement alert = getDriver().findElement(By.className("UIAAlert"));
		Assert.assertTrue(alert.isDisplayed());
		List<WebElement> texts = alert.findElements(By.className("UIAStaticText"));
		for (WebElement text : texts) {
			if (text.getText().equalsIgnoreCase(message)) {
				containMessage = true;
			}
		}
		Assert.assertTrue("Alert message is not displayed", containMessage);
	}

	@Override
	public void removeApp() {
		iOSDriver().removeApp("com.namshi.iosapp");
	}

	@Override
	public void hideKeyboard() {
		if (isElementDisplayed(appiumDriver().findElementByClassName("UIAKeyboard"))) {
			iOSDriver().getKeyboard().sendKeys(Keys.RETURN);
		}
	}

	public void swipeLeft() {
		Dimension dimensions = appiumDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getWidth() * 0.003;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getWidth() * 0.45;
		int scrollEnd = screenHeightEnd.intValue();
		iOSDriver().swipe(scrollStart, 15, scrollEnd, 15, 1000);
	}

	@Override
	public void swipeDownToElement(WebElementFacade el) {
		Dimension dimensions = appiumDriver().manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.80;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.45;
		int scrollEnd = screenHeightEnd.intValue();
		int screenHeight = dimensions.getHeight();
		for (int i = 0; i < screenHeight; i++) {
			if (isElementVisible(el)) {
				break;
			}
			iOSDriver().swipe(10, scrollStart, 10, scrollEnd, 1000);
		}
	}

	@Override
	public void swipeDown() {
		Dimension size;
		size = appiumDriver().manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.45);
		int startx = size.width / 2;
		iOSDriver().swipe(startx, starty, startx, endy, 1000);
	}

	@Override
	public AndroidDriver<?> androidDriver() {
		return null;
	}

	@Override
	public void slideRight() {
    	Dimension dimensions = appiumDriver().manage().window().getSize();
        Double screenHeightStart = dimensions.getWidth() * 0.003;
        int scrollStart = screenHeightStart.intValue();
        Double screenHeightEnd = dimensions.getWidth() * 0.45;
        int scrollEnd = screenHeightEnd.intValue();
        iOSDriver().swipe(scrollStart, 15, scrollEnd, 15, 1000);
	}
}
