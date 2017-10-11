package com.test.jobspot.loginpage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.jobspot.testBase.TestBase;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 06-09-2017
 * 
 */

public class TC001_VerifyLoginLogout extends TestBase {

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginLogout.class.getName());

	@BeforeClass
	public void setUp() throws IOException {
		launchApp();
		log.info("ending setUp() method.");
	}

	@Test
	public void testLogin() throws InterruptedException {
		try {
			log.info("============= Starting testLogin() Test =============");

			driver.findElement(By.xpath("//android.widget.TextView[@text='Skip' and @index='2']")).click();


			/*
			 * LoginScreen lPage = new LoginScreen(driver); Thread.sleep(2000); lPage.loginToApplication("7696217663", "deepak123"); Thread.sleep(2000);
			 */
			log.info("============= Finished testLogin() Test =============");
		} catch (Exception e) {
			log.error("Exception is: " + e.getMessage());
			Assert.fail();
		}
	}

}
