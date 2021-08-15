package com.web.selenium.webautomation;

public class XpathConstants {

	// Home page
	public static final String BOOK_ONLINE_COUNSELLING_BUTTON = "//a[contains(@class, 'onlineSession')]";
	public static final String UPCOMING_EVENTS_BUTTON = "//*[@id='rightMenu']/*[@id='main-menu9']/a";

	// ChatBot
	public static final String CHAT_BOX_FRAME = "//iframe[@id='live-chat-widget-iframe']";
	public static final String CHAT_BOX_START_BUTTON = "//*[@data-testid='start-button']//*[@fill-rule='evenodd']";
	public static final String CHAT_BOX_WINDOW = "//*[@id='chat-widget-container']//*[@data-testid='home-header']";
	public static final String CHAT_BOX_CLOSE_BUTTON = "//*[@data-testid='start-button']//*[@id='close-icon']";

	// Enquiry form
	public static final String ENQUIRY_FORM_FRAME = "//iframe[@id='211393235839460']";
	public static final String ENQUIRY_T_AND_C_FRAME = "//*[@id='customFieldFrame_17']";
	public static final String ENQUIRY_MOBILE_NUMBER_FRAME = "//*[@id='customFieldFrame_15']";
	public static final String ENQUIRY_NAME_INPUT = "//*[@id='input_1']";
	public static final String ENQUIRY_EMAIL_INPUT = "//*[@id='input_18']";
	public static final String ENQUIRY_MOBILE_NUMBER_INPUT = "//*[@id='phone']";
	public static final String ENQUIRY_CITY_INPUT = "//*[@id='input_4']";
	public static final String ENQUIRY_PREFERRED_DESTINATION_INPUT = "//*[@id='input_5']";
	public static final String DYNAMIC_ENQUIRY_PREFERRED_DESTINATION_OPTION = "//*[@id='input_5']/option[@value='%s']";
	public static final String ENQUIRY_NEAREST_OFFICE_INPUT = "//*[@id='input_6']";
	public static final String ENQUIRY_MESSAGE_INPUT = "//*[@id='input_10']";
	public static final String ENQUIRY_T_AND_C_CHECK_BOX = "//*[@id='userInput']";
	public static final String ENQUIRY_SUBMIT_BUTTON = "//*[@id='input_19']";
	public static final String INPUT_ERROR_LIST = "//*[@class='form-error-message']";
	public static final String ENQUIRY_NAME_FILED_ERROR = "//*[@id='cid_1']/*[@class='form-error-message']";
	public static final String ENQUIRY_EMAIL_FILED_ERROR = "//*[@id='cid_18']/*[@class='form-error-message']";
	public static final String ENQUIRY_MOBILE_NUMBER_CONFIRM_ERROR = "//*[@id='errors']";
	public static final String ENQUIRY_MOBILE_NUMBER_CONFIRM = "//*[@id='send_btn']";
	public static final String ENQUIRY_CITY_FILED_ERROR = "//*[@id='cid_4']/*[@class='form-error-message']";
	public static final String ENQUIRY_PREFERRED_DESTINATION_FILED_ERROR = "//*[@id='cid_5']/*[@class='form-error-message']";
	public static final String ENQUIRY_NEAREST_OFFICE_FILED_ERROR = "//*[@id='cid_6']/*[@class='form-error-message']";
	public static final String ENQUIRY_MESSAGE_FILED_ERROR = "//*[@id='cid_10']/*[@class='form-error-message']";
	public static final String ENQUIRY_CHECK_BOX_ERROR = "//*[@id='cid_17']/*[@class='form-error-message']";
}
