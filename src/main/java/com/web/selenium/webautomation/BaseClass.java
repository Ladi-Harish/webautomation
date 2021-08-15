package com.web.selenium.webautomation;

import java.util.List;
import org.testng.Assert;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * This is Base of all test class.
 * 
 * @author Harish
 *
 */
public class BaseClass {
	private Properties config;
	protected static String siteUrl;
	private static WebDriver driver;

	/**
	 * Preconditions for test methods.
	 */
	@BeforeMethod(alwaysRun = true)
	public void preConditions() {
		try {
			config = new Properties();
			config.load(getClass().getClassLoader().getResourceAsStream(Constants.CONFIG_FILE));
		} catch (NullPointerException | IOException npe) {
			Assert.fail("Config file not found or problem while reading config");
		}
		setChromeDriveBasedOnOs();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS);
		setSiteUrl();
		driver.get(siteUrl);

		// wait for elements to be load
		implicitlyWait(Constants.DEFAULT_IMPLICIT_WAIT_TIME_SECONDS);
	}

	/**
	 * Set chrome driver as per system OS.
	 */
	private void setChromeDriveBasedOnOs() {
		String osType = System.getProperty("os.name").toLowerCase();
		if (osType.trim().contains(Constants.WINDOWS_OS_CONSTANT)) {
			System.setProperty(Constants.CHROME_DRIVER_SET_PROPERTY, Constants.CHROME_DRIVER_WIN_PATH);
		} else if (osType.trim().contains(Constants.MAC_OS_CONSTANT)) {
			System.setProperty(Constants.CHROME_DRIVER_SET_PROPERTY, Constants.CHROME_DRIVER_MAC_PATH);
		} else {
			System.setProperty(Constants.CHROME_DRIVER_SET_PROPERTY, Constants.CHROME_DRIVER_LIN_PATH);
		}
	}

	/**
	 * To set siteUrl.
	 */
	private void setSiteUrl() {
		siteUrl = System.getProperty(Constants.URL_KEY);
		if (siteUrl == null || siteUrl.trim().equals(Constants.EMPTY_STRING)) {
			siteUrl = config.getProperty("siteUrl").trim();
		}
		if (siteUrl == null || siteUrl.trim().equals(Constants.EMPTY_STRING)) {
			Assert.fail("Either the set the properties file or pass siteUrl value through command.");
		}
	}

	/**
	 * End Conditions for test method.
	 */
	@AfterMethod(alwaysRun = true)
	public void endConditions() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Get the JavascriptExecutor driver.
	 * 
	 * @return
	 */
	public JavascriptExecutor getJavaScriptDriver() {
		return ((JavascriptExecutor) driver);
	}

	/**
	 * This method is used to wait the page to be loaded
	 *
	 * @param milliSeconds This parameter provides the time in milliseconds
	 */
	public void implicitlyWait(int milliSeconds) {
		driver.manage().timeouts().implicitlyWait(milliSeconds, TimeUnit.SECONDS);
	}

	/**
	 * Inspect element.
	 * 
	 * @param xPath
	 * @return
	 */
	public WebElement inspectElement(String xPath) {
		return driver.findElement(By.xpath(xPath));
	}

	/**
	 * Inspect list of elements.
	 * 
	 * @param xPath
	 * @return
	 */
	public List<WebElement> inspectElements(String xPath) {
		return driver.findElements(By.xpath(xPath));
	}

	/**
	 * Inspect and click on the element.
	 * 
	 * @param xpath
	 */
	public void inspectElementAndClick(String xpath) {
		WebElement element = inspectElement(xpath);
		String elementText = element.getText();
		elementText = (elementText != null) ? elementText : "element";
		element.click();
		System.out.println("Clicked on " + elementText);
	}

	/**
	 * Wait until element found.
	 * 
	 * @param seconds
	 * @param xPath
	 */
	public void explicitlyWait(int seconds, String xPath) {
		new WebDriverWait(driver, seconds).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
	}

	/**
	 * Wait until element to be clickable.
	 * 
	 * @param seconds
	 * @param xPath
	 */
	public void explicitlyWaitForElementToBeClickable(int seconds, String xPath) {
		new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(inspectElement(xPath)));
	}

	/**
	 * Wait until title to be found
	 * 
	 * @param seconds
	 * @param title
	 */
	public void explicityWaitForElementTitleToBeContains(int seconds, String title) {
		new WebDriverWait(driver, seconds).until(ExpectedConditions.titleContains(title));
	}

	/**
	 * Wait until element to be invisible.
	 * 
	 * @param seconds
	 * @param xPath
	 */
	public void explicityWaitForElementInvisibility(int seconds, String xPath) {
		new WebDriverWait(driver, seconds).until(ExpectedConditions.invisibilityOf(inspectElement(xPath)));
	}

	/**
	 * Wait until element to be visible.
	 * 
	 * @param seconds
	 * @param xPath
	 */
	public void explicityWaitForElementvisibility(int seconds, String xPath) {
		new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(inspectElement(xPath)));
	}

	/**
	 * Wait for expected URL
	 * 
	 * @param seconds
	 * @param expectedUrl
	 */
	public void explicitWaitForUrlContains(int seconds, String expectedUrl) {
		new WebDriverWait(driver, seconds).until(ExpectedConditions.urlContains(expectedUrl));
		System.out.println("Current URL: " + driver.getCurrentUrl());
	}

	/**
	 * To get current URL.
	 * 
	 * @return current URL
	 */
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}

	/**
	 * Hover on element.
	 * 
	 * @param xPath
	 * @return
	 */
	public String hoverOnElement(String xPath) {
		Actions action = new Actions(driver);
		WebElement element = inspectElement(xPath);
		action.moveToElement(element).build().perform();
		System.out.println("Hovered the mouse on " + element.getText());
		return element.getText();
	}

	/**
	 * To inspect and get CSS value of the element.
	 * 
	 * @param xPath
	 * @param attributeName
	 * @return
	 */
	public String getCssValue(String xPath, String attributeName) {
		return inspectElement(xPath).getCssValue(attributeName);
	}

	/**
	 * To inspect and get text of the element.
	 * 
	 * @param xPath
	 * @return text of the element.
	 */
	public String getText(String xPath) {
		return inspectElement(xPath).getText();
	}

	/**
	 * To get page title.
	 * 
	 * @return title of the page.
	 */
	public String getPageTitle() {
		return driver.getTitle();
	}

	/**
	 * Switch to other window using url.
	 * 
	 * @param winondwUrl
	 */
	public void switchToOtherWinodwsByUrlContains(String winondwUrl) {
		for (String winHandle : driver.getWindowHandles()) {
			if (driver.switchTo().window(winHandle).getCurrentUrl().contains(winondwUrl)) {
				break;
			}
		}
	}

	/**
	 * Switch to other window using title.
	 * 
	 * @param winondwTitle
	 */
	public void switchToOtherWinodwsByTitleContains(String winondwTitle) {
		for (String winHandle : driver.getWindowHandles()) {
			if (driver.switchTo().window(winHandle).getTitle().contains(winondwTitle)) {
				break;
			}
		}
	}

	/**
	 * To switch into frame by using path.
	 * 
	 * @param xPath
	 */
	public void switchToFrame(String xPath) {
		driver.switchTo().frame(inspectElement(xPath));
	}

	/**
	 * This method is to switch the driver to the current html page from frame
	 */
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}

	/**
	 * To verify element is visible.
	 * 
	 * @param xPath
	 */
	public void verifyIsDisplayed(String xPath) {
		List<WebElement> elements = inspectElements(xPath);
		Assert.assertTrue(elements.size() > 0, " element is not displayed.");
		System.out.println(elements.get(0).getText() + " is visiable.");
	}

	/**
	 * To verify element is invisible.
	 * 
	 * @param xPath
	 * @param name
	 */
	public void verifyIsNotDisplayed(String xPath, String name) {
		List<WebElement> elements = inspectElements(xPath);
		Assert.assertTrue(elements.size() == 0, name + " Not expected to found element.");
		System.out.println(name + " not found as expected.");
	}

	/**
	 * Input the text.
	 * 
	 * @param xPath
	 * @param text
	 */
	public void inputTheText(String xPath, String text) {
		inspectElement(xPath).sendKeys(text);
	}

	/**
	 * To verify filed is checked/selected.
	 * 
	 * @param xPath
	 * @param name
	 */
	public void verifyIsSelected(String xPath, String name) {
		Assert.assertTrue(inspectElement(xPath).isSelected(), name + " not Checked/Selected");
		System.out.println(name + " is Selected/Checked");
	}

	/**
	 * To verify filed is checked/selected.
	 * 
	 * @param xPath
	 * @param name
	 */
	public void verifyIsNotSelected(String xPath, String name) {
		Assert.assertFalse(inspectElement(xPath).isSelected(), name + " is Checked/Selected that not expected");
		System.out.println(name + " is not Selected/Checked as expected.");
	}

	/**
	 * To scroll element to be view.
	 * 
	 * @param xPath
	 */
	public void javascriptExecutorToScrollExactElementIntoView(String xPath) {
		getJavaScriptDriver().executeScript("arguments[0].scrollIntoView(true);", inspectElement(xPath));
		System.out.println("Scrolled the Element into View");
	}

	/**
	 * JavaScript Executor click.
	 * 
	 * @param xPath
	 */
	public void javascriptExecutorClick(String xPath) {
		getJavaScriptDriver().executeScript("arguments[0].click();", inspectElement(xPath));
		System.out.println("Click on " + getText(xPath));
	}

	/**
	 * Thread sleep in milliseconds
	 */
	public void pause(long milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Format a string by passing dynamic arguments.
	 * 
	 * @param format
	 * @param args
	 * @return
	 */
	public String formatString(String format, Object... args) {
		return String.format(format, args);
	}

	/**
	 * get select instance.
	 * 
	 * @param dropDownelement
	 * @return
	 */
	public Select getSelect(WebElement element) {
		return new Select(element);
	}

	/**
	 * Get the selected option from drop down.
	 * 
	 * @param element
	 * @return
	 */
	public String getSelectedOption(WebElement element) {
		WebElement selectedElement = getSelect(element).getFirstSelectedOption();
		String selectedOption = selectedElement.getText();
		return selectedOption;
	}
}