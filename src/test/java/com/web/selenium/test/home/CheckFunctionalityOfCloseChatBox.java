package com.web.selenium.test.home;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.web.selenium.webautomation.AssertionConstants;
import com.web.selenium.webautomation.BaseClass;
import com.web.selenium.webautomation.Constants;
import com.web.selenium.webautomation.XpathConstants;

/**
 * To test the functionalities of close icon of chat box.
 * 
 * @author Harish
 *
 */
public class CheckFunctionalityOfCloseChatBox extends BaseClass {

	@Test
	public void toCheckFunctionalityOfCloseChatBox() throws InterruptedException {
		// Switch to chat box frame and chat box icon visible
		switchToFrame(XpathConstants.CHAT_BOX_FRAME);
		explicitlyWaitForElementToBeClickable(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS,
				XpathConstants.CHAT_BOX_START_BUTTON);
		verifyIsDisplayed(XpathConstants.CHAT_BOX_START_BUTTON);

		// Click to open chat box and verify page not changed
		inspectElementAndClick(XpathConstants.CHAT_BOX_START_BUTTON);
		Assert.assertTrue(getPageTitle().contains(AssertionConstants.HOME_PAGE_TITLE), " Not an expected page.");

		// Verify close icon is Displayed
		explicitlyWait(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS, XpathConstants.CHAT_BOX_CLOSE_BUTTON);
		verifyIsDisplayed(XpathConstants.CHAT_BOX_CLOSE_BUTTON);

		// Click on close icon of chat box and verify
		inspectElementAndClick(XpathConstants.CHAT_BOX_CLOSE_BUTTON);
		explicityWaitForElementInvisibility(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS,
				XpathConstants.CHAT_BOX_WINDOW);
		verifyIsNotDisplayed(XpathConstants.CHAT_BOX_WINDOW, "Chat Box");
		verifyIsNotDisplayed(XpathConstants.CHAT_BOX_WINDOW, "Chat Box close icon");
	}
}
