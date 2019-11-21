package com.shiksha.object;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class SA_GNB_Mob {
	CommonFunctions CommonFunctions = new CommonFunctions();

	WebDriver driver;
	ExtentTest child;

	public SA_GNB_Mob(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;

	}
	public void ClickonMenu() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Menu"));
			driver.findElement(FetchData.readOR("Menu")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw e; // // Do nothing
		}
	}
}
