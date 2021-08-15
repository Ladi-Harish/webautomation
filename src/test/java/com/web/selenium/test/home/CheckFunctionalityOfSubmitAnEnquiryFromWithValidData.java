package com.web.selenium.test.home;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.web.selenium.webautomation.BaseClass;
import com.web.selenium.webautomation.Constants;
import com.web.selenium.webautomation.XpathConstants;

/**
 * To test the functionality of Enquiry form by submitting with valid data.
 * 
 * @author Harish
 *
 */
public class CheckFunctionalityOfSubmitAnEnquiryFromWithValidData extends BaseClass {

	@Test
	public void toCheckFunctionalityOfSubmitAnEnquiryFrom() {
		// Verify visibility of submit button
		javascriptExecutorToScrollExactElementIntoView(XpathConstants.ENQUIRY_FORM_FRAME);
		switchToFrame(XpathConstants.ENQUIRY_FORM_FRAME);
		verifyIsDisplayed(XpathConstants.ENQUIRY_SUBMIT_BUTTON);

		// Click on submit without enter any input
		inspectElementAndClick(XpathConstants.ENQUIRY_SUBMIT_BUTTON);
		Assert.assertEquals(inspectElements(XpathConstants.INPUT_ERROR_LIST).size(), 8, "Not an expected errors count");

		// Input all fields in form
		explicitlyWait(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS, XpathConstants.ENQUIRY_NAME_INPUT);
		inputTheText(XpathConstants.ENQUIRY_NAME_INPUT, Constants.NAME);
		inputTheText(XpathConstants.ENQUIRY_EMAIL_INPUT, Constants.EMAIL);
		switchToFrame(XpathConstants.ENQUIRY_MOBILE_NUMBER_FRAME);
		inputTheText(XpathConstants.ENQUIRY_MOBILE_NUMBER_INPUT, Constants.PHONE_NUMBER);
		switchBackFromFrame();
		switchToFrame(XpathConstants.ENQUIRY_FORM_FRAME);
		inputTheText(XpathConstants.ENQUIRY_CITY_INPUT, Constants.CITY);
		getSelect(inspectElement(XpathConstants.ENQUIRY_PREFERRED_DESTINATION_INPUT))
				.selectByValue(Constants.PREFERRED_DESTINATION_1);
		getSelect(inspectElement(XpathConstants.ENQUIRY_NEAREST_OFFICE_INPUT))
				.selectByValue(Constants.NEAREST_OFFICE_1);
		inputTheText(XpathConstants.ENQUIRY_MESSAGE_INPUT, Constants.MESSAGE);

		// Click on T&C check box and verify
		switchToFrame(XpathConstants.ENQUIRY_T_AND_C_FRAME);
		javascriptExecutorClick(XpathConstants.ENQUIRY_T_AND_C_CHECK_BOX);
		verifyIsSelected(XpathConstants.ENQUIRY_T_AND_C_CHECK_BOX, "T&C");
		switchBackFromFrame();

		// Click on submit and verify
		switchToFrame(XpathConstants.ENQUIRY_FORM_FRAME);
		inspectElementAndClick(XpathConstants.ENQUIRY_SUBMIT_BUTTON);
		pause(8000);
		Assert.assertEquals(inspectElements(XpathConstants.INPUT_ERROR_LIST).size(), 1, "Not an expected errors count");
	}
}
