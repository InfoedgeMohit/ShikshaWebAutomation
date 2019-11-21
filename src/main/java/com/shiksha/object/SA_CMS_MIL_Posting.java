package com.shiksha.object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class SA_CMS_MIL_Posting {

	CommonFunctions CommonFunctions = new CommonFunctions();

	WebDriver driver;
	ExtentTest child;

	public SA_CMS_MIL_Posting(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;

	}

	public void typeUserName(String strUserName) throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("MILCMS_Email"));
			driver.findElement(FetchData.readOR("MILCMS_Email")).sendKeys(
					strUserName);
			CommonFunctions.pass(child, "\nEnter email id Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEnter email id Failed");
			throw e; // // Do nothing
		}
	}

	public void typePassword(String password) {
		try {
			driver.findElement(FetchData.readOR("MILCMS_Pass")).sendKeys(
					password);
			CommonFunctions.pass(child, "\nType Password for CMS admin Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nType Password for CMS admin Failed");
			throw e; // // Do nothing
		}
	}

	public void hitLoginButton() {
		try {
			driver.findElement(FetchData.readOR("MILCMS_Login")).click();
			CommonFunctions.pass(child, "\nClick on Login Button Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick on Login Button Failed");
			throw e; // // Do nothing
		}

	}

	public void hitPostForClient() throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_PostForClient"));
			driver.findElement(FetchData.readOR("MILCMS_PostForClient"))
					.click();
			CommonFunctions.pass(child, "\nClick on Post For Client Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick on Post For Client Failed");
			throw e; // // Do nothing
		}

	}

	public void EnterClientid(String clientid) {
		try {
			driver.findElement(FetchData.readOR("MILCMS_Clientid")).sendKeys(
					clientid);
			CommonFunctions.pass(child,
					"\nEnter Client id who have subscription Passed");
		}

		catch (Exception e) {
			CommonFunctions.fail(child,
					"\nEnter Client id who have subscription Failed");
			throw e; // // Do nothing
		}

	}

	public void hitSearchButton() {
		try {

			driver.findElement(FetchData.readOR("MILCMS_Search")).click();
			CommonFunctions.pass(child, "\nClick on Search Button Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick on Search Button Failed");
			throw e; // // Do nothing
		}

	}

	public void SelectRadio() throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_SelectRadio"));
			driver.findElement(FetchData.readOR("MILCMS_SelectRadio")).click();
			CommonFunctions.pass(child, "\nSelect listing id Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect listing id Failed");
			throw e; // // Do nothing
		}

	}

	public void SelectUnset() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("MILCMS_Unset"));
			driver.findElement(FetchData.readOR("MILCMS_Unset")).click();
			CommonFunctions.pass(child,
					"\nSelect Unset to remove the MIL Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"\nSelect Unset to remove the MIL Failed");
			throw e; // // Do nothing
		}

	}

	public void Clickdropdown() throws Exception {

		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_Clickdropdown"));
			driver.findElement(FetchData.readOR("MILCMS_Clickdropdown"))
					.click();
			CommonFunctions.pass(child, "\nClick on dropdown Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick on dropdown Failed");
			throw e; // // Do nothing
		}
	}

	public void SelectAbroad() throws Exception {

		try {
			WebElement we = driver.findElement(FetchData
					.readOR("MILCMS_SelectAbroad"));
			Select se = new Select(we);
			se.selectByValue("abroad");
			CommonFunctions
					.pass(child, "\nSelect Abroad from drop down Passed");
		} catch (Exception e) {
			CommonFunctions
					.fail(child, "\nSelect Abroad from drop down Failed");
			throw e; // // Do nothing
		}
	}

	public void SelectListing() throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_Selectlisting"));
			driver.findElement(FetchData.readOR("MILCMS_Selectlisting"))
					.click();
			CommonFunctions.pass(child,
					"\nSelect Listing id radio button Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"\nSelect Listing id radio button Failed");
			throw e; // // Do nothing
		}

	}

	public void HitUnset() throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_HitUnset"));
			driver.findElement(FetchData.readOR("MILCMS_HitUnset")).click();
			CommonFunctions.pass(child, "\nClick on Unset button Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick on Unset button Failed");
			throw e; // // Do nothing
		}

	}

	public void SelectClientid() throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_SelectClientid"));
			driver.findElement(FetchData.readOR("MILCMS_SelectClientid"))
					.click();
			CommonFunctions.pass(child, "\nSelect Client id Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect Client id Failed");
			throw e; // // Do nothing
		}

	}

	public void SetMain() {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_SetMain"));
			// Thread.sleep(3000);
			driver.findElement(FetchData.readOR("MILCMS_SetMain")).click();
			CommonFunctions.pass(child, "\nClick on Set Main Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick on Set Main Failed");
			throw e; // // Do nothing
		}

	}

	public void SelectSubscription(String Subscription) throws Exception {

		try {
			WebElement we = driver.findElement(FetchData
					.readOR("MILCMS_SelectSubscription"));
			Select se1 = new Select(we);
			se1.selectByValue(Subscription);
			CommonFunctions.pass(child, "\nSelect Subscription id Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect Subscription id Failed");
			throw e; // // Do nothing
		}
	}

	public void ChooseCountry(String Country) throws Exception {

		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_ChooseCountry"));
			WebElement we = driver.findElement(FetchData
					.readOR("MILCMS_ChooseCountry"));
			Select se2 = new Select(we);
			se2.selectByVisibleText("Canada");
			CommonFunctions.pass(child,
					"\nChoose Country from drop down Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"\nChoose Country from drop down Failed");
			throw e; // // Do nothing
		}
	}

	public void ChooseCategory(String Category) throws Exception {

		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_ChooseCategory"));
			WebElement we = driver.findElement(FetchData
					.readOR("MILCMS_ChooseCategory"));
			Select se3 = new Select(we);
			se3.selectByVisibleText("Science");
			CommonFunctions.pass(child,
					"\nChoose Catagory from drop down Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"\nChoose Catagory from drop down Failed");
			throw e; // // Do nothing
		}
	}

	public void SetKeyPage() throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("MILCMS_ChooseCategory"));
			System.out.println(FetchData.readOR("MILCMS_SetKeyPage"));
			driver.findElement(
					By.xpath(".//*[@id='mainCollegeLinkDiv']/button")).click();
			driver.switchTo().alert().accept();
			CommonFunctions.pass(child, "\nClick on SetKeyPage Passed");

			// driver.findElement(FetchData.readOR("MILCMS_SetKeyPage")).click();

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick on SetKeyPage Failed");
			throw e; // // Do nothing
		}

	}
}
