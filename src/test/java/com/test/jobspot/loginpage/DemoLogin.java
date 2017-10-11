package com.test.jobspot.loginpage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoLogin {

	public WebDriver	driver;

	String				mobDeviceName	= "785f6754e8252d92";
	String				mobVersion		= "7.0";
	String				appPackageName	= "global.edios.jobspot";
	String				appActivityName	= "global.edios.jobspot.homeScreen.HomeActivity";

	Logger				logger			= Logger.getLogger(DemoLogin.class.getName());

	@BeforeTest
	public void setUp() throws MalformedURLException {
		PropertyConfigurator.configure("log4j.properties");

		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();

		// Set android deviceName desired capability. Set your device name.
		capabilities.setCapability("deviceName", mobDeviceName);

		// Set BROWSER_NAME desired capability. It's Android in our case here.
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

		// Set android VERSION desired capability. Set your mobile device's OS version.
		capabilities.setCapability(CapabilityType.VERSION, mobVersion);

		// Set android platformName desired capability. It's Android in our case here.
		capabilities.setCapability("platformName", "Android");

		// Set android appPackage desired capability. It is com.android.calculator2 for calculator application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appPackage", appPackageName);

		// Set android appActivity desired capability. It is com.android.calculator2.Calculator for calculator application.
		// Set your application's appPackage if you are using any other app.
		capabilities.setCapability("appActivity", appActivityName);

		// Created object of RemoteWebDriver will all set capabilities. Set appium server address and port number in URL string.
		// It will launch calculator app in android device.
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		logger.info("setUp() method completed successfully.");
	}

	@Test
	public void testLogin() {

	}

}
