package com.test.jobspot.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 *
 */

public class LoginScreen {

	public static final Logger log = Logger.getLogger(LoginScreen.class.getName());

	WebDriver driver;

	@FindBy(id = "global.edios.jobspot:id/skipIntro")
	private WebElement skip;

	@FindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private WebElement appPermissionAllow;

	@FindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	private WebElement appPermissionDeny;

	@FindBy(id = "global.edios.jobspot:id/mobileNumber")
	private WebElement loginMobileNumber;

	@FindBy(id = "global.edios.jobspot:id/signInPassword")
	private WebElement loginPassword;

	@FindBy(id = "global.edios.jobspot:id/signInButton")
	private WebElement loginButton;

	@FindBy(id = "global.edios.jobspot:id/signUpButton")
	private WebElement signUp;

	@FindBy(id = "global.edios.jobspot:id/forgotPasswordBtn")
	private WebElement forgetPassword;

	@FindBy(id = "global.edios.jobspot:id/text_input_password_toggle")
	private WebElement passwordView;

	public LoginScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void loginToApplication(String mobileNumber, String password) throws InterruptedException {
		if (skip.isEnabled() || skip.isDisplayed()) {
			Thread.sleep(2000);
			skip.click();
			log.info("clicked on skip link and object is:- " + skip.toString());
		} else {
			log.error("");
		}

		loginMobileNumber.sendKeys(mobileNumber);
		log.info("entered username:-" + mobileNumber + "and object is " + loginMobileNumber.toString());
		loginPassword.sendKeys(password);
		log.info("entered password:-" + password + "and object is " + loginPassword.toString());


		loginButton.click();
		log.info("clicked on login button and object is:- " + loginButton.toString());


	}


	public void loginToApp(String mobileNumber, String loginPassword) {
		loginMobileNumber.sendKeys(mobileNumber);
		this.loginPassword.sendKeys(loginPassword);
		loginButton.click();
	}

}
