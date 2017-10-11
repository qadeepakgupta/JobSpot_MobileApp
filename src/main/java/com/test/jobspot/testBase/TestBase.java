package com.test.jobspot.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;

import com.test.jobspot.excelReader.Excel_Reader;

/**
 * 
 * @author Deepak Gupta
 * @Created Date 31-07-2017
 *
 */
public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public WebDriver	driver;
	Excel_Reader		excel;

	public Properties OR = new Properties();


	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/test/jobspot/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);

	}


	public void launchApp() throws IOException {
		try {

			String log4jConfPath = "log4j.properties";
			PropertyConfigurator.configure(log4jConfPath);
			loadData();

			// Created object of DesiredCapabilities class.
			DesiredCapabilities capabilities = new DesiredCapabilities();

			// Set android deviceName desired capability. Set your device name.
			capabilities.setCapability("deviceName", OR.getProperty("mobDeviceName"));
			log.info("Device Name is : " + OR.getProperty("mobDeviceName"));

			// Set BROWSER_NAME desired capability. It's Android in our case here.
			capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");

			// Set android VERSION desired capability. Set your mobile device's OS version.
			capabilities.setCapability(CapabilityType.VERSION, OR.getProperty("mobVersion"));
			log.info("Version number is :" + OR.getProperty("mobVersion"));

			// Set android platformName desired capability. It's Android in our case here.
			capabilities.setCapability("platformName", "Android");

			// Set android appPackage desired capability. It is com.android.calculator2 for calculator application.
			// Set your application's appPackage if you are using any other app.
			capabilities.setCapability("appPackage", OR.getProperty("appPackageName"));
			log.info("Package Name is :" + OR.getProperty("appPackageName"));

			// Set android appActivity desired capability. It is com.android.calculator2.Calculator for calculator application.
			// Set your application's appPackage if you are using any other app.
			capabilities.setCapability("appActivity", OR.getProperty("appActivityName"));
			log.info("Activity Name is :" + OR.getProperty("appActivityName"));

			// Created object of RemoteWebDriver will all set capabilities. Set appium server address and port number in URL string.
			// It will launch calculator app in android device.
			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			log.info("------ launchApp() method running successfully. ------");
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String[][] getData(String excelName, String sheetName) {
		String path = System.getProperty("user.dir") + "/src/main/java/com/test/jobspot/data/" + excelName;
		excel = new Excel_Reader(path);
		String[][] data = excel.getDataFromSheet(sheetName, excelName);
		return data;
	}


	@AfterClass(alwaysRun = true)
	public void endTest() throws InterruptedException {
		driver.quit();
	}


}
