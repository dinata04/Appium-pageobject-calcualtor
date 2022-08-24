package com.juaracoding.appium;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.appium.pages.Calculator;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestCalculator { 

	private static AndroidDriver<MobileElement> driver;
	private Calculator calculator;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "M2101K7AG");
		capabilities.setCapability("uuid", "34b7b93a");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "11.0");
		capabilities.setCapability("appPackage", "com.google.android.calculator");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
//		capabilities.setCapability("appWaitDuration", "600");
//		capabilities.setCapability("adbExecTimeout", "600");
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); 
	}
	
	@BeforeMethod
	public void pageObject() {
		calculator = new Calculator(driver);
	}
	
	@Test
	public void testAdd() {
		calculator.calcAdd();
		System.out.println("Hasil = "+calculator.getTxtResult());
		assertEquals(calculator.getTxtResult(), "3");
		calculator.clear();
	}
	
	@Test
	public void testMul() {
		calculator.calcMul();
		System.out.println("Hasil = "+calculator.getTxtResult());
		assertEquals(calculator.getTxtResult(), "1");
		calculator.clear();
	}
	
	@Test
	public void testdiv() {
		calculator.calcDiv();
		System.out.println("Hasil = "+calculator.getTxtResult());
		assertEquals(calculator.getTxtResult(), "2");
		calculator.clear();
	}
	
	@Test
	public void testEq() {
		calculator.calcEq();
		System.out.println("Hasil = "+calculator.getTxtResult());
		assertEquals(calculator.getTxtResult(), "8");
		calculator.clear();
	}
	
	
	@AfterClass
	public void closeApp() {
		driver.quit();
	}
	
}
