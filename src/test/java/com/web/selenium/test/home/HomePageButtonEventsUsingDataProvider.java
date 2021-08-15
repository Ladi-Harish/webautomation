package com.web.selenium.test.home;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.web.selenium.webautomation.AttributeConstants;
import com.web.selenium.webautomation.BaseClass;
import com.web.selenium.webautomation.Constants;
import com.web.selenium.webautomation.AssertionConstants;
import com.web.selenium.webautomation.XpathConstants;

public class HomePageButtonEventsUsingDataProvider extends BaseClass {

	@Test(dataProvider = "getTestData")
	public void toCheckHomePageButtonsFunctionalities(String btnXpath, String pageTitle, String btnDefColor,
			String btnHoverColor, String btnText) {
		// Verify the button text
		explicitlyWait(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS, btnXpath);
		Assert.assertEquals(getText(btnXpath), btnText, "Not an expected page title");

		// Verify default colour of the button
		Assert.assertEquals(getCssValue(btnXpath, AttributeConstants.BACKGROUND_COLOR), btnDefColor,
				" not an expected default color of Booking Online Counselling Button");

		// hover on button and verify button colour change
		hoverOnElement(btnXpath);
		Assert.assertEquals(getCssValue(btnXpath, AttributeConstants.BACKGROUND_COLOR), btnHoverColor,
				" not an expected color after hover on Booking Online Counselling Button");

		// Click on button and verify the navigated page
		inspectElementAndClick(btnXpath);
		switchToOtherWinodwsByTitleContains(pageTitle);
		explicityWaitForElementTitleToBeContains(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS, pageTitle);
		Assert.assertTrue(getPageTitle().contains(pageTitle), "Not an expected title");

	}

	@DataProvider
	private Object[][] getTestData() {
		final Object[][] data = {
				{ XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON, AssertionConstants.BOOK_ONLINE_COUNSELLING_PAGE_TITLE,
						AssertionConstants.BOOK_ONLINE_COUNSELLING_DEFAULT_COLOR,
						AssertionConstants.BOOK_ONLINE_COUNSELLING_HOVER_COLOR,
						AssertionConstants.BOOK_ONLINE_COUNSELLING_TEXT },
				{ XpathConstants.UPCOMING_EVENTS_BUTTON, AssertionConstants.UPCOMING_EVENTS_PAGE_TITLE,
						AssertionConstants.UPCOMING_EVENTS_DEFAULT_COLOR,
						AssertionConstants.UPCOMING_EVENTS_HOVER_COLOR, AssertionConstants.UPCOMING_EVENTS_TEXT } };
		return data;
	}
}
