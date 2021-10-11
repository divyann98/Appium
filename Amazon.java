package com.appium.pa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Amazon 
{  
	@Test
	void AmazonApplication()
	{
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("platformName", "Android");
		dc.setCapability("Automation_Name", "UiAutomator2");
		dc.setCapability("appActivity", "com.amazon.mShop.splashscreen.StartupActivity");
		dc.setCapability("appPackage", "in.amazon.mShop.android.shopping");

		AndroidDriver<AndroidElement> and = new AndroidDriver<AndroidElement>(dc);

		and.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//Language Selection
		and.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Continue in English\"]")).click();

		//Sign in
		and.findElement(By.id("in.amazon.mShop.android.shopping:id/skip_sign_in_button")).click();

		WebDriverWait wait=new WebDriverWait(and, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")));
		//Search Box
		and.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).click();

		and.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Enter Data
		and.findElement(By.id("in.amazon.mShop.android.shopping:id/rs_search_src_text")).sendKeys("iphone 13");

		//Search
		and.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		and.findElement(By.xpath("//*[@text=\"iphone 13 mini 128\"]")).click();

		and.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Scroll Down
		and.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Apple iPhone 11 (128GB) - Purple" + "\").instance(0))")
		.click();

		//Location PinCode
		and.findElement(By.id("in.amazon.mShop.android.shopping:id/loc_ux_gps_enter_pincode")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("in.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1")));
		and.findElement(By.id("in.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1")).clear();

		and.findElement(By.id("in.amazon.mShop.android.shopping:id/loc_ux_pin_code_text_pt1")).sendKeys("571426");

		and.findElement(By.id("in.amazon.mShop.android.shopping:id/loc_ux_update_pin_code")).click();

		and.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Add to cart
		and.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ "Add to Cart" + "\").instance(0))")
		.click();
         //Done Add to cark
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@text=\"DONE\"]")));
		and.findElement(By.xpath("//*[@text=\"DONE\"]")).click();


		

	}
}
