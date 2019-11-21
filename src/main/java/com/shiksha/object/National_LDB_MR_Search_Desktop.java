package com.shiksha.object;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;


public class National_LDB_MR_Search_Desktop {

	WebDriver driver;
	ExtentTest child;

	public National_LDB_MR_Search_Desktop(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;
	}

	CommonFunctions CommonFunctions = new CommonFunctions();

	public void typeUserName(String strUserName) throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("ENT_Email"));
			driver.findElement(FetchData.readOR("ENT_Email")).sendKeys(
					strUserName);
			CommonFunctions.pass(child, "enter Client Email Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "enter Client Email Failed");
			throw e;
		}
	}

	public void typePassword(String password) throws Exception {
		try {
			driver.findElement(FetchData.readOR("ENT_Password")).sendKeys(
					password);
			CommonFunctions.pass(child, "enter Client ENT_Password Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "enter Client ENT_Password Failed");
			throw e;
		}
	}

	public void hitLoginButton() throws Exception {
		try {
			driver.findElement(FetchData.readOR("ENT_Login")).click();

			CommonFunctions.pass(child, "enter Client Login Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "enter Client Login Failed");
			throw e;
		}

	}
	

	public void selectInstitutes() throws Exception {

		try {
			Variables.elementWait(driver, 10,FetchData.readOR("select_Institutes"));
			driver.findElement(FetchData.readOR("select_Institutes")).click();

			CommonFunctions.pass(child, "Select Client Institute Passed");
			CommonFunctions.pass(child, "Actual Institute Selected"+driver.findElement(FetchData.readOR("select_Institutes")).getText());

		} catch (Exception e) {

			CommonFunctions.fail(child, "enter Client Institute Failed");
			throw e;
		}
	}

	public void selectCourses() throws Exception {

		try {
			Variables.elementWait(driver, 10,FetchData.readOR("select_Courses"));
			driver.findElement(FetchData.readOR("select_Courses")).click();
			CommonFunctions.pass(child, "select Client Course Passed");
			CommonFunctions.pass(child, "Actual Courses Selected"+driver.findElement(FetchData.readOR("select_Courses")).getText());

		} catch (Exception e) {

			CommonFunctions.fail(child, "select Client Course Failed");
			throw e;
		}
	}

	public void clickCalendar() throws Exception {
		try {
			Variables.elementWait(driver, 10,FetchData.readOR("click_Calendar"));
			driver.findElement(FetchData.readOR("click_Calendar")).click();
			CommonFunctions.pass(child, "click_Calendar Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "click_Calendar Failed");
			throw e;
		}
	}
	
	
	public void selectDate(String dd ,String  mm , String yy) throws Exception {
		try {
			Variables.elementWait(driver, 10,FetchData.readOR("click_Calendar"));
			driver.findElement(FetchData.readOR("click_Calendar")).click();
			
			String calYearText = driver.findElement(By.id("calendar_year_txt")).getText();	
			
			StringBuffer myBuffer = new StringBuffer(yy);
			String year = myBuffer.substring(0, 4);
			
			if(calYearText.equalsIgnoreCase(year)){
				System.out.println("True");
			}
			
	//		System.out.println("Month I need to select is ::" + mm);
			
			driver.findElement(By.id("monthSelect")).click();
	//		System.out.println("Month Drop Down clicked");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//div[contains(text(),'"+mm+"') and contains(@id,'monthDiv')]")).click();
			Thread.sleep(2000);
			
			List<WebElement> allDates =  driver.findElements(By.xpath(".//td[@class='calendar_week_column']/following-sibling::td"));
			
			Thread.sleep(2000);
			
		//	System.out.println("Value of dd is ::" + dd);
			 @SuppressWarnings("static-access")
			String date = CommonFunctions.getNumericValue(dd);
			 
//			String date = dd.split(".")[0];
		//	System.out.println("Date is ::" + date);
			
			for (int i=0 ; i<allDates.size();i++) {
			try {	
			//	System.out.println(allDates.get(i).getText());
				if(allDates.get(i).getText().equalsIgnoreCase(date)) {
					//System.out.println("I am in loop");
			//	System.out.println("Going to select date as :: " + date );
				driver.findElement(By.xpath(".//td[@class='calendar_week_column']/following-sibling::td[contains(text(),'"+date+"')]")).click();
				
				}
				//CommonFunctions.pass(child, "Select Date Passed");

			} catch (Exception e) {

			//	CommonFunctions.fail(child, "Select Date Failed");
				throw e;
			}
			}
			
			

			
			CommonFunctions.pass(child, "Select Date Passed");
			CommonFunctions.pass(child, "Expected Date:"+dd+"-"+mm+"-"+yy+"  Actual Date");
			
			CommonFunctions.pass(child, "Expected Date:"+driver.findElement(By.xpath(".//td[@class='calendar_week_column']/following-sibling::td[contains(text(),'"+date+"')]")).getText());

		} catch (Exception e) {

			CommonFunctions.fail(child, "Select Date Failed");
			throw e;
		}
	}
	
	
	

	public void pickDate() throws Exception {
		try {
			Variables.elementWait(driver, 10,FetchData.readOR("move_PreviousMonth"));
			driver.findElement(FetchData.readOR("move_PreviousMonth")).click();
			
			driver.findElement(FetchData.readOR("pick_Date")).click();
			CommonFunctions.pass(child, "pick_Date Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "pick_Date Failed");
			throw e;
		}
	}

	public void clickSearch() throws Exception {
		try {
			
			driver.findElement(FetchData.readOR("click_MR_Search")).click();

			CommonFunctions.pass(child, "Click Search Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Search Failed");
			throw e;
		}
	}

	public void verifyCount() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("check_Count"));
			Thread.sleep(1000);
			System.out.println("Total Count Appearing : "
					+ driver.findElement(FetchData.readOR("check_Count"))
							.getText());
			CommonFunctions.pass(child, "Total Count Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Total Count Failed");
			throw e;
		}
	}

	public void signOut() throws Exception {
		try {
			driver.findElement(FetchData.readOR("CLK_SignOut")).click();

			CommonFunctions.pass(child, "Client SignOut Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Client SignOut Failed");
			throw e;
		}

	}

	public void closeWindow() throws Exception {
		try {
			driver.close();
			CommonFunctions.pass(child, "Close Window Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Close Window Failed");
			throw e;
		}

	}

}
