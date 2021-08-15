package com.web.selenium.test.home;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.web.selenium.webautomation.AttributeConstants;
import com.web.selenium.webautomation.BaseClass;
import com.web.selenium.webautomation.Constants;
import com.web.selenium.webautomation.AssertionConstants;
import com.web.selenium.webautomation.XpathConstants;

/**
 * To test the functionalities of 'Upcoming Events' button.
 * 
 * @author Harish
 *
 */
public class CheckFunctionalityOfUpcomingEventsButton extends BaseClass {

	@Test
	public void toCheckFunctionalityOfUpcomingEventsButton() {
		// Verify the button visibility and text
		explicitlyWait(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS, XpathConstants.UPCOMING_EVENTS_BUTTON);
		verifyIsDisplayed(XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON);
		Assert.assertEquals(getText(XpathConstants.UPCOMING_EVENTS_BUTTON), AssertionConstants.UPCOMING_EVENTS_TEXT,
				"Not an expected page title");

		// Verify default colour of the button
		Assert.assertEquals(getCssValue(XpathConstants.UPCOMING_EVENTS_BUTTON, AttributeConstants.BACKGROUND_COLOR),
				AssertionConstants.UPCOMING_EVENTS_DEFAULT_COLOR,
				" not an expected default color of Upcoming events Button");

		// hover on button and verify button colour change
		hoverOnElement(XpathConstants.UPCOMING_EVENTS_BUTTON);
		Assert.assertEquals(getCssValue(XpathConstants.UPCOMING_EVENTS_BUTTON, AttributeConstants.BACKGROUND_COLOR),
				AssertionConstants.UPCOMING_EVENTS_HOVER_COLOR,
				" not an expected color after hover on Upcoming events Button");

		// Click on button and verify the navigated page
		inspectElementAndClick(XpathConstants.UPCOMING_EVENTS_BUTTON);
		Assert.assertTrue(getPageTitle().contains(AssertionConstants.UPCOMING_EVENTS_PAGE_TITLE),
				"not an expected title");
	}

}
