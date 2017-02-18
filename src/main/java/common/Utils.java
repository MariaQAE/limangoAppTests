package common;

import com.google.common.base.Predicate;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.WebDriverFacade;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Utils {

	public WebDriver driver;

	public abstract void removeApp();

	public abstract void hideKeyboard();

	public abstract void swipeDownToElement(WebElementFacade element);

	public abstract void swipeDown();

	public abstract IOSDriver<?> iOSDriver();

	public abstract AndroidDriver<?> androidDriver();

	public abstract void alertShouldBeDisplayed(String message);
	
	public abstract void slideRight();
	
	public Utils(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public void waitForAllListElements(List <WebElement> elements) {
		new FluentWait<WebDriver>(getDriver())
        .withTimeout(20, TimeUnit.SECONDS)
        .pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class)
        .until(new Predicate<WebDriver>() {

            public boolean apply(WebDriver d) {
            	System.out.println("1");
                return (elements.size() >= 1);
            }
        });
	}
	
	public static double extractNumberFromString(String line) {
		String filter = line.replaceAll(",", "");
		Pattern pattern = Pattern.compile("\\d+(?:\\.\\d+)?");
		ArrayList<Double> listBuffer = new ArrayList<Double>();
		Matcher matcher = pattern.matcher(filter);
		while (matcher.find()) {
			listBuffer.add(Double.parseDouble(matcher.group()));
		}
		if (listBuffer.size() == 1) {
			return listBuffer.get(0);
		} else {
			return listBuffer.get(1);
		}
	}

	public void closeApp() {
		appiumDriver().closeApp();
	}

	public void openApp() {
		appiumDriver().launchApp();
	}

	public boolean isElementVisible(WebElementFacade element) {
		try {
			return element.isVisible();
		} catch (NoSuchElementException exception) {
			return false;
		}
	}

	public boolean isElementPresent(WebElement el) {
		try {
			return ((WebElementFacade) el).isPresent();
		} catch (NoSuchElementException exception) {
			return false;
		}
	}

	public boolean isElementDisplayed(WebElement el) {
		try {
			WebElement element = el;
			return element.isDisplayed();
		} catch (NoSuchElementException exception) {
			return false;
		} catch (ElementNotVisibleException ex) {
			return false;
		}
	}

	public void doubleTapElement(MobileElement element) {
		int x, y;
		try {
			x = element.getCenter().getX();
			y = element.getCenter().getY();
			(appiumDriver()).tap(1, x, y, 100);
			try {
				Thread.sleep(80);
			} catch (Exception e1) {
			}
			(appiumDriver()).tap(1, x, y, 100);
			try {
				Thread.sleep(100);
			} catch (Exception e1) {
			}
		} catch (Exception e) {
		}
	}

	public void takeMultipleScreenShot(int numberOfScreenShots) {
		for (int i = 0; i < numberOfScreenShots; i++) {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("screenshots/toast" + i + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void cleanDirectory(String directory) {
		try {
			FileUtils.cleanDirectory(new File(directory));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void enterData(WebElementFacade el, String text) {
		el.waitUntilPresent();
		tapElement(el);
		el.sendKeys(text);
	}

	public void tapElement(WebElementFacade el) {
		el.waitUntilClickable();
		w(el).tap(1, 1000);
	}

	public void clickElement(WebElement el) {
		el.click();
	}

	public MobileElement w(WebElement el) {
		return (MobileElement) ((WebElementFacade) el).getWrappedElement();
	}

	@SuppressWarnings("unchecked")
	public AppiumDriver<WebElement> appiumDriver() {
		return (AppiumDriver<WebElement>) ((WebDriverFacade) driver).getProxiedDriver();
	}

	public void setContextToWebview() {
		int loops = 0;
		while (true) {
			loops++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(appiumDriver().getContextHandles().size() == 2 || loops == 5) {
				break;
			}
		}
		Set<String> contextNames = appiumDriver().getContextHandles();
		System.out.println(appiumDriver().getContextHandles());
		appiumDriver().context((String) contextNames.toArray()[1]);
	}

	public void setContextToNative() {
		Set<String> contextNames = appiumDriver().getContextHandles();
		appiumDriver().context((String) contextNames.toArray()[0]);
	}

	public void scrollToBottom() {
		setContextToWebview();
		((JavascriptExecutor) appiumDriver()).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		setContextToNative();
	}

	public void scrollToUP() {
		setContextToWebview();
		((JavascriptExecutor) appiumDriver()).executeScript("window.scrollTo(0, 0)");
		setContextToNative();
	}

	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) appiumDriver()).executeScript("arguments[0].scrollIntoView();", element);
	}

	public void back() {
		appiumDriver().navigate().back();
	}
}
