package com.web.selenium.test.home;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.web.selenium.webautomation.BaseClass;
import com.web.selenium.webautomation.Constants;
import com.web.selenium.webautomation.XpathConstants;
import com.web.selenium.webautomation.AssertionConstants;
import com.web.selenium.webautomation.AttributeConstants;

/**
 * To test the functionalities of 'Book Online Counselling' button.
 * 
 * @author Harish
 *
 */
public class CheckFunctionalityOfBookOnlineCounsellingButtonTest extends BaseClass {

	@Test
	public void toCheckFunctionalityOfBookOnlineCounsellingButtonTest() {
		// Verify the button visibility and text
		explicitlyWait(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS, XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON);
		verifyIsDisplayed(XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON);
		Assert.assertEquals(getText(XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON),
				AssertionConstants.BOOK_ONLINE_COUNSELLING_TEXT, "Not an expected page title");

		// Verify default colour of the button
		Assert.assertEquals(
				getCssValue(XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON, AttributeConstants.BACKGROUND_COLOR),
				AssertionConstants.BOOK_ONLINE_COUNSELLING_DEFAULT_COLOR,
				" not an expected default color of Booking Online Counselling Button");

		// hover on button and verify button colour change
		hoverOnElement(XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON);
		Assert.assertEquals(
				getCssValue(XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON, AttributeConstants.BACKGROUND_COLOR),
				AssertionConstants.BOOK_ONLINE_COUNSELLING_HOVER_COLOR,
				" not an expected color after hover on Booking Online Counselling Button");

		// Click on button and verify the navigated page
		inspectElementAndClick(XpathConstants.BOOK_ONLINE_COUNSELLING_BUTTON);
		switchToOtherWinodwsByUrlContains(AssertionConstants.BOOK_ONLINE_COUNSELLING_PAGE);
		Assert.assertTrue(getCurrentUrl().contains(AssertionConstants.BOOK_ONLINE_COUNSELLING_PAGE),
				"not an expected title");
	}
}
