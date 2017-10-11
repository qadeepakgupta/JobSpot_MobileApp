package com.test.jobspot.signuppage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.jobspot.testBase.TestBase;
import com.test.jobspot.uiActions.SignUpScreen;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 * 
 */

public class TC001_VerifySignUpBlankSubmit extends TestBase {

	public static final Logger	log	= Logger.getLogger(TC001_VerifySignUpBlankSubmit.class.getName());
	SignUpScreen						signupPage;

	@BeforeClass
	public void setUp() throws IOException {
		launchApp();
	}

	@Test
	public void testSignUpBlankSubmit() throws InterruptedException {
		try {
			log.info("============= Starting testSignUpBlankSubmit() Test =============");
			Thread.sleep(1000);
			signupPage = new SignUpScreen(driver);
			signupPage.clickOnSignUpButton();
			Thread.sleep(1000);

			log.info("=============  Finished testSignUpBlankSubmit() Test =============");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			Assert.fail(); 

		}
	}

}
