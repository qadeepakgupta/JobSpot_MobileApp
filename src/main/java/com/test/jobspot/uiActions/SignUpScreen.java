package com.test.jobspot.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 *
 */

public class SignUpScreen {

	public static final Logger	log	= Logger.getLogger(SignUpScreen.class.getName());
	WebDriver						driver;

	@FindBy(name = "Sign up")
	private WebElement signupPanelHeading;

	@FindBy(id = "global.edios.jobspot:id/firstName")
	private WebElement signupFirstname;

	@FindBy(id = "global.edios.jobspot:id/lastName")
	private WebElement signupLastname;

	@FindBy(id = "global.edios.jobspot:id/contactNumber")
	private WebElement signupMobileNo;

	@FindBy(id = "global.edios.jobspot:id/emailAddress")
	private WebElement signupEmailID;

	@FindBy(id = "global.edios.jobspot:id/gender")
	private WebElement gender;

	@FindBy(id = "global.edios.jobspot:id/createPassword")
	private WebElement password;

	@FindBy(id = "global.edios.jobspot:id/text_input_password_toggle")
	private WebElement passwordView;

	@FindBy(id = "global.edios.jobspot:id/confirmPassword")
	private WebElement confrimPassword;

	@FindBy(id = "global.edios.jobspot:id/text_input_password_toggle")
	private WebElement confrimPasswordView;

	@FindBy(id = "global.edios.jobspot:id/checkboxTermsConditions")
	private WebElement accpetCheckBox;

	@FindBy(id = "global.edios.jobspot:id/signUpButton")
	private WebElement signUpButton;

	public SignUpScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void signUpToApplication(String firstname, String lastname, String companyName, String emailID, String mobileNo)
			throws InterruptedException {

		signupFirstname.sendKeys(firstname);
		log.info("entered firstname:-" + firstname + "and object is " + signupFirstname.toString());

		signupLastname.sendKeys(lastname);
		log.info("entered lastname:-" + lastname + "and object is " + signupLastname.toString());

		signupEmailID.sendKeys(emailID);
		log.info("entered email ID:-" + emailID + "and object is " + signupEmailID.toString());

		signupMobileNo.sendKeys(mobileNo);
		log.info("entered mobile no.:-" + mobileNo + "and object is " + signupMobileNo.toString());


		signUpButton.click();
		log.info("clicked on sign up button and object is:- " + signUpButton.toString());
	}

	public void clickOnSignUpButton() {
		signUpButton.click();

	}


}
