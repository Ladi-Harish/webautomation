package com.web.selenium.test.home;

import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.WebElement;
import java.util.NoSuchElementException;
import com.web.selenium.webautomation.BaseClass;
import com.web.selenium.webautomation.Constants;
import com.web.selenium.webautomation.XpathConstants;
import com.web.selenium.webautomation.AssertionConstants;

/**
 * To check functionality of an Enquiry Form with invalid data.
 * 
 * @author Harish
 *
 */
public class CheckFunctionalityOfSubmitAnEnquiryWithInvalidData extends BaseClass {
	SoftAssert softAssert = new SoftAssert();

	@Test
	public void toCheckFunctionalityOfSubmitAnEnquiryWithInvalidData() {
		// Switch into enquiry form frame
		javascriptExecutorToScrollExactElementIntoView(XpathConstants.ENQUIRY_FORM_FRAME);
		switchToFrame(XpathConstants.ENQUIRY_FORM_FRAME);

		// Verify name input filed
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_NAME_INPUT, Constants.EMPTY_STRING,
				XpathConstants.ENQUIRY_NAME_FILED_ERROR, AssertionConstants.REQUIRED_FIELD_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_NAME_INPUT, Constants.SPACE_STRING,
				XpathConstants.ENQUIRY_NAME_FILED_ERROR, AssertionConstants.REQUIRED_FIELD_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_NAME_INPUT, Constants.NAME,
				XpathConstants.ENQUIRY_NAME_FILED_ERROR, null);

		// Verify the email field
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_EMAIL_INPUT, Constants.EMPTY_STRING,
				XpathConstants.ENQUIRY_EMAIL_FILED_ERROR, AssertionConstants.REQUIRED_FIELD_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_EMAIL_INPUT, Constants.SPACE_STRING,
				XpathConstants.ENQUIRY_EMAIL_FILED_ERROR, AssertionConstants.REQUIRED_FIELD_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_EMAIL_INPUT, Constants.INVALID_EMAIL_1,
				XpathConstants.ENQUIRY_EMAIL_FILED_ERROR, AssertionConstants.INVALID_EMAIL_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_EMAIL_INPUT, Constants.INVALID_EMAIL_2,
				XpathConstants.ENQUIRY_EMAIL_FILED_ERROR, AssertionConstants.INVALID_EMAIL_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_EMAIL_INPUT, Constants.INVALID_EMAIL_3,
				XpathConstants.ENQUIRY_EMAIL_FILED_ERROR, AssertionConstants.INVALID_EMAIL_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_EMAIL_INPUT, Constants.INVALID_EMAIL_4,
				XpathConstants.ENQUIRY_EMAIL_FILED_ERROR, AssertionConstants.INVALID_EMAIL_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_EMAIL_INPUT, Constants.EMAIL,
				XpathConstants.ENQUIRY_EMAIL_FILED_ERROR, null);

		// Verify the phone number field
		switchToFrame(XpathConstants.ENQUIRY_MOBILE_NUMBER_FRAME);
		validErrorByConfirmingMobileNumber(XpathConstants.ENQUIRY_MOBILE_NUMBER_INPUT, Constants.EMPTY_STRING,
				XpathConstants.ENQUIRY_MOBILE_NUMBER_CONFIRM_ERROR, AssertionConstants.EMPTY_MOBILE_NUMBER_ERROR);
		validErrorByConfirmingMobileNumber(XpathConstants.ENQUIRY_MOBILE_NUMBER_INPUT, Constants.SPACE_STRING,
				XpathConstants.ENQUIRY_MOBILE_NUMBER_CONFIRM_ERROR, AssertionConstants.EMPTY_MOBILE_NUMBER_ERROR);
		validErrorByConfirmingMobileNumber(XpathConstants.ENQUIRY_MOBILE_NUMBER_INPUT, Constants.INVALID_STRING,
				XpathConstants.ENQUIRY_MOBILE_NUMBER_CONFIRM_ERROR, AssertionConstants.INVALID_MOBILE_NUMBER_ERROR);
		validErrorByConfirmingMobileNumber(XpathConstants.ENQUIRY_MOBILE_NUMBER_INPUT, Constants.INVALID_PHONE_NUMBER_1,
				XpathConstants.ENQUIRY_MOBILE_NUMBER_CONFIRM_ERROR,
				formatString(AssertionConstants.DYNAMIC_INVALID_MOBILE_NUMBER_ERROR, Constants.INVALID_PHONE_NUMBER_1));
		validErrorByConfirmingMobileNumber(XpathConstants.ENQUIRY_MOBILE_NUMBER_INPUT, Constants.INVALID_PHONE_NUMBER_2,
				XpathConstants.ENQUIRY_MOBILE_NUMBER_CONFIRM_ERROR,
				formatString(AssertionConstants.DYNAMIC_INVALID_MOBILE_NUMBER_ERROR, Constants.INVALID_PHONE_NUMBER_2));
		switchBackFromFrame();

		// Verify the City field
		switchToFrame(XpathConstants.ENQUIRY_FORM_FRAME);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_CITY_INPUT, Constants.EMPTY_STRING,
				XpathConstants.ENQUIRY_CITY_FILED_ERROR, AssertionConstants.REQUIRED_FIELD_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_CITY_INPUT, Constants.SPACE_STRING,
				XpathConstants.ENQUIRY_CITY_FILED_ERROR, AssertionConstants.REQUIRED_FIELD_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_CITY_INPUT, Constants.INVALID_PHONE_NUMBER_2,
				XpathConstants.ENQUIRY_CITY_FILED_ERROR, AssertionConstants.CONTAINS_LETTERS_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_CITY_INPUT, Constants.CITY,
				XpathConstants.ENQUIRY_CITY_FILED_ERROR, null);

		// Verify Preferred Destination filed
		inspectElementAndClick(XpathConstants.ENQUIRY_SUBMIT_BUTTON);
		softAssert.assertEquals(getText(XpathConstants.ENQUIRY_PREFERRED_DESTINATION_FILED_ERROR),
				AssertionConstants.REQUIRED_FIELD_ERROR, "Require error not found for 'Preferred Destination.");
		selectAndVerifyOptionInDropDownByText(XpathConstants.ENQUIRY_PREFERRED_DESTINATION_INPUT,
				Constants.PREFERRED_DESTINATION_1);
		selectAndVerifyOptionInDropDownByText(XpathConstants.ENQUIRY_PREFERRED_DESTINATION_INPUT,
				Constants.PREFERRED_DESTINATION_2);

		// Verify Nearest Office
		inspectElementAndClick(XpathConstants.ENQUIRY_SUBMIT_BUTTON);
		softAssert.assertEquals(getText(XpathConstants.ENQUIRY_NEAREST_OFFICE_FILED_ERROR),
				AssertionConstants.REQUIRED_FIELD_ERROR, "Require error not found for 'Preferred Destination.");
		selectAndVerifyOptionInDropDownByText(XpathConstants.ENQUIRY_NEAREST_OFFICE_INPUT, Constants.NEAREST_OFFICE_1);
		selectAndVerifyOptionInDropDownByText(XpathConstants.ENQUIRY_NEAREST_OFFICE_INPUT, Constants.NEAREST_OFFICE_2);

		// Verify message field
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_MESSAGE_INPUT, Constants.EMPTY_STRING,
				XpathConstants.ENQUIRY_MESSAGE_FILED_ERROR, AssertionConstants.REQUIRED_FIELD_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_MESSAGE_INPUT, Constants.SPACE_STRING,
				XpathConstants.ENQUIRY_MESSAGE_FILED_ERROR, AssertionConstants.REQUIRED_FIELD_ERROR);
		validErrorBySubmittingInput(XpathConstants.ENQUIRY_MESSAGE_INPUT, Constants.MESSAGE,
				XpathConstants.ENQUIRY_MESSAGE_FILED_ERROR, null);

		// Verify T&C check box
		inspectElementAndClick(XpathConstants.ENQUIRY_SUBMIT_BUTTON);
		softAssert.assertEquals(getText(XpathConstants.ENQUIRY_CHECK_BOX_ERROR),
				AssertionConstants.REQUIRED_FIELD_ERROR, "Require error not found for 'Preferred Destination.");
		switchToFrame(XpathConstants.ENQUIRY_T_AND_C_FRAME);
		verifyIsNotSelected(XpathConstants.ENQUIRY_T_AND_C_CHECK_BOX, "T&C");
		javascriptExecutorClick(XpathConstants.ENQUIRY_T_AND_C_CHECK_BOX);
		verifyIsSelected(XpathConstants.ENQUIRY_T_AND_C_CHECK_BOX, "T&C");
		switchBackFromFrame();

		// Assert if any test fail error
		softAssert.assertAll();
	}

	/**
	 * Verify the error by submitting input.
	 * 
	 * @param inputXpath
	 * @param inputText
	 * @param errorXpath
	 * @param errorMsg
	 */
	private void validErrorBySubmittingInput(String inputXpath, String inputText, String errorXpath, String errorMsg) {
		inputTheText(inputXpath, inputText);
		inspectElementAndClick(XpathConstants.ENQUIRY_SUBMIT_BUTTON);
		if (errorMsg != null) {
			softAssert.assertEquals(getText(errorXpath), errorMsg, "Error while this input " + inputText);
		} else {
			List<WebElement> elements = inspectElements(errorXpath);
			softAssert.assertTrue(elements.size() == 0, " Not expected to found element.");
			System.out.println("Error not found as expected.");
		}
		System.out.println("Verified with this input " + inputText);
		inspectElement(inputXpath).clear();
	}

	/**
	 * Validate error by confirm phone number input.
	 * 
	 * @param inputXpath
	 * @param inputText
	 * @param errorXpath
	 * @param errorMsg
	 * @throws InterruptedException
	 */
	private void validErrorByConfirmingMobileNumber(String inputXpath, String inputText, String errorXpath,
			String errorMsg) {
		inputTheText(inputXpath, inputText);
		inspectElementAndClick(XpathConstants.ENQUIRY_MOBILE_NUMBER_CONFIRM);
		explicityWaitForElementvisibility(Constants.DEFAULT_EXPLICIT_WAIT_TIME_SECONDS, errorXpath);
		softAssert.assertEquals(getText(errorXpath), errorMsg, "Error while this input " + inputText);
		System.out.println("Verified with this input " + inputText);
		pause(8000);
		inspectElement(inputXpath).clear();
	}

	/**
	 * Select and verify option in dropdown.
	 * 
	 * @param xPath
	 * @param textOptionToSelect
	 */
	public void selectAndVerifyOptionInDropDownByText(String xPath, String option) {
		try {
			WebElement element = inspectElement(xPath);
			getSelect(element).selectByValue(option);
			// Verifying the option is selected in the dropdown or not
			String selectedOption = getSelectedOption(element);
			softAssert.assertEquals(selectedOption, option, selectedOption + " is not an expected option.");
		} catch (NoSuchElementException e) {
			System.out.println("Dropdown Value not Found. " + e);
		}
	}
}
