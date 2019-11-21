package com.shiksha.object;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.Database;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class SA_CTA_Desktop_Object {

	WebDriver driver;
	ExtentTest child;
	CommonFunctions CommonFunctions = new CommonFunctions();

	public SA_CTA_Desktop_Object(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;
	}	

	public void clickSignUp() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("signup_button"));
			driver.findElement(FetchData.readOR("signup_button")).click();
			CommonFunctions.pass(child, "Click on Signup Widget Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on Signup Widget Failed");
			throw e;
		}

	}

	public void planradiobutton() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("planradiobutton"));
			driver.findElement(FetchData.readOR("planradiobutton")).click();
			driver.findElement(FetchData.readOR("Cookie_OKK")).click();
			CommonFunctions.pass(child, "Click on planradiobutton Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on planradiobutton Failed");
			throw e;
		}
	}

	public void levelradiobutton_Bachelors() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("levelradiobutton_Bachelors"));
			driver.findElement(FetchData.readOR("levelradiobutton_Bachelors"))
					.click();
			Variables.elementWait(driver, 10, FetchData.readOR("course"));
			driver.findElement(FetchData.readOR("course")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("bachelorcourse"));
			driver.findElement(FetchData.readOR("bachelorcourse")).click();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-100)", "");
			Variables.elementWait(driver, 10, FetchData.readOR("checkforspecilization"));
			CommonFunctions.pass(child,
					"Click on levelradiobutton_Bachelors Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"Click on levelradiobutton_Bachelors Failed");
			throw e;
		}
	}

	public void countries() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("country"));
			driver.findElement(FetchData.readOR("country")).click();
			driver.findElement(FetchData.readOR("countryselection1")).click();
			driver.findElement(FetchData.readOR("ok-btn")).click();
			CommonFunctions.pass(child, "countries selection Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "countries selection Failed");
			throw e;	
		}
		}


	public void bookedexamdate() throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("bookedExamDate")));
			Variables.elementWait(driver, 10, FetchData.readOR("bookedExamDate"));
			driver.findElement(FetchData.readOR("bookedExamDate")).click();
			CommonFunctions.pass(child, "bookedexamdate Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "bookedexamdate Failed");
			throw e;
		}
	}

	public void Bachelors_Deatils(String Sname) throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("schoolname"));
			driver.findElement(FetchData.readOR("schoolname")).sendKeys(Sname);
			driver.findElement(FetchData.readOR("currentclass")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("Classselection"));
			driver.findElement(FetchData.readOR("Classselection")).click();
			driver.findElement(FetchData.readOR("Board")).click();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,20)", "");
			Variables.elementWait(driver, 10, FetchData.readOR("BoardSelection"));
			driver.findElement(FetchData.readOR("BoardSelection")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("CGPA"));
			driver.findElement(FetchData.readOR("CGPA")).click();
			JavascriptExecutor jse1 = (JavascriptExecutor) driver;
			jse1.executeScript("window.scrollBy(0,80)", "");
			Variables.elementWait(driver, 10, FetchData.readOR("CGPASelection"));
			driver.findElement(FetchData.readOR("CGPASelection")).click();

			CommonFunctions.pass(child, "Bachelors_Deatils Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Bachelors_Deatils Failed");
			throw e;
		}
	}

	public void PersonalInfo_Section(String fname, String lname)
			throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("firstname"));
			driver.findElement(FetchData.readOR("firstname")).sendKeys(fname);
			Variables.elementWait(driver, 10, FetchData.readOR("lastname"));
			driver.findElement(FetchData.readOR("lastname")).sendKeys(lname);
			String t = new SimpleDateFormat("yyyyMMddHHmmss")
					.format(new Timestamp(System.currentTimeMillis()));
			String email1 = "test_" + t + "@gmail.com";
			driver.findElement(FetchData.readOR("email")).sendKeys(email1);
			driver.findElement(FetchData.readOR("cityfield")).click();
			driver.findElement(FetchData.readOR("cityfield")).click();
			driver.findElement(FetchData.readOR("cityfield")).click();
			driver.findElement(FetchData.readOR("city")).click();
			CommonFunctions.pass(child, "PersonalInfo_Section Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "PersonalInfo_Section Failed");
			throw e;
		}
	}

	public void number(String mobnumber) throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("number"));
			driver.findElement(FetchData.readOR("number")).sendKeys(mobnumber);
			CommonFunctions.pass(child, "number Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "number Failed");
			throw e;
		}

	}

	public void SignUp() throws Exception {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("SignUp"));
			driver.findElement(FetchData.readOR("SignUp")).click();
			CommonFunctions.pass(child, "SignUp Passed");		
		} catch (Exception e) {
			CommonFunctions.fail(child, "SignUp Failed");
			throw e;
		}

	}

	public void Logout() throws Exception {
		try {	
			Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-1000)");
			Variables.elementWait(driver, 90, FetchData.readOR("user_button"));
			driver.findElement(FetchData.readOR("user_button")).click();
			/*Variables.elementWait(driver, 90, FetchData.readOR("Logout"));
			driver.findElement(FetchData.readOR("Logout")).click();*/
			CommonFunctions.pass(child, "Logout Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Logout Failed");
			throw e;
		}

	}

	public void downloadguide() throws Exception {
		try {
			Thread.sleep(2000);
           WebElement myElement1 = driver.findElement(By
					.xpath(".//*[@id='prevButton']"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement1);
			Variables.elementWait(driver, 10, FetchData.readOR("Download_Guide"));
			driver.findElement(FetchData.readOR("Download_Guide")).click();
			CommonFunctions.pass(child, "downloadguide Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "downloadguide Failed");
			throw e;
		}
	}

	public void Categorypage_shortlist() throws Exception {
		try {
			WebElement myElement = driver.findElement(FetchData
					.readOR("scrolling"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			Variables.elementWait(driver, 10, FetchData.readOR("Categorypage_shortlist"));
			driver.findElement(FetchData.readOR("Categorypage_shortlist"))
					.click();
			CommonFunctions.pass(child, "Categorypage_shortlist Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Categorypage_shortlist Failed");
			throw e;
		}

	}

	public void CategoryPage_DownloadBrochure() throws Exception {
		try {
			
			WebElement myElement = driver.findElement(FetchData
					.readOR("scrolling"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			
			Variables.elementWait(driver, 30, FetchData.readOR("CategoryPage_DownloadBrochure"));
			driver.findElement(
					FetchData.readOR("CategoryPage_DownloadBrochure")).click();
					
			CommonFunctions.pass(child, "CategoryPage_DownloadBrochure Passed");

		} catch (Exception e) {
			e.printStackTrace();
			CommonFunctions.fail(child, "CategoryPage_DownloadBrochure Failed");
			throw e;
		}
	}

	public void Categorypage_compare() throws Exception {
		try {
			WebElement myElement = driver.findElement(FetchData
					.readOR("scrolling"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			Variables.elementWait(driver, 10, FetchData.readOR("Categorypage_compare"));
			driver.findElement(FetchData.readOR("Categorypage_compare"))
					.click();
			CommonFunctions.pass(child, "Categorypage_compare Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Categorypage_compare Failed");
			throw e;
		}

	}

	public void Compare2() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Compare2"));
			driver.findElement(FetchData.readOR("Compare2")).click();
			CommonFunctions.pass(child, "Compare2 Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Compare2 Failed");
			throw e;
		}

	}

	public void Compare() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Compare"));
			driver.findElement(FetchData.readOR("Compare")).click();
			CommonFunctions.pass(child, "Compare Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Compare Failed");
			throw e;
		}

	}

	public void Logoclick() throws Exception {
		try {
			Variables.elementWait(driver, 90, FetchData.readOR("Logo_click"));
			driver.findElement(FetchData.readOR("Logo_click")).click();
			CommonFunctions.pass(child, "Logoclick Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Logoclick Failed");
			throw e;
		}

	}

	public void ScholarshipAP_Apply_Sidebar() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("ScholarshipAP_Apply_Sidebar"));
			driver.findElement(FetchData.readOR("ScholarshipAP_Apply_Sidebar"))
					.click();
			CommonFunctions.pass(child, "ScholarshipAP_Apply_Sidebar Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "ScholarshipAP_Apply_Sidebar Failed");
			throw e;
		}

	}

	public void CourseInlineform() throws Exception {
		try {
			WebElement myElement = driver.findElement(FetchData
					.readOR("courseinline"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-200)");
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("courseinline")).click();
			CommonFunctions.pass(child, "CourseInlineform Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "CourseInlineform Failed");
			throw e;
		}
	}
	
	public void Inlineform() throws Exception {
		try {
			WebElement myElement = driver.findElement(FetchData
					.readOR("courseinline"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-200)");
			CommonFunctions.pass(child, "CourseInlineform Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "CourseInlineform Failed");
			throw e;
		}
	}
	
	public void selectCourse() throws Exception {
		try {
			Variables.elementWait(driver, 50, FetchData.readOR("selectcourse"));
			driver.findElement(FetchData.readOR("selectcourse")).click();
			List<WebElement> courses = driver.findElements(FetchData.readOR("selectcourse_inline"));
			courses.get(0).click();
			CommonFunctions.pass(child, "selectCourse Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "selectCourse Failed");
			throw e;
		}
	}

	public void CategoryPage_RMC() throws Exception {
		try {
			WebElement myElement = driver.findElement(FetchData
					.readOR("scrolling"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			Variables.elementWait(driver, 10, FetchData.readOR("CategoryPage_RMC"));
			driver.findElement(FetchData.readOR("CategoryPage_RMC")).click();
			CommonFunctions.pass(child, "CategoryPage_RMC Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "CategoryPage_RMC Failed");
			throw e;
		}
	}
	
	
	public void examselectionNO() throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("examselectionNO")));
			Variables.elementWait(driver, 10, FetchData.readOR("examselectionNO"));
			driver.findElement(FetchData.readOR("examselectionNO")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("Validpassport"));
			driver.findElement(FetchData.readOR("Validpassport")).click();
			CommonFunctions.pass(child, "examselectionNO Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "examselectionNO Failed");
			throw e;
		}
	}


	public void examscore(String score) throws Exception {
		try {
			driver.findElement(FetchData.readOR("examselectionYES")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("examscore"));
			driver.findElement(FetchData.readOR("examscore")).click();
			driver.findElement(FetchData.readOR("examscore_entered")).sendKeys(
					score);
			CommonFunctions.pass(child, "examscore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "examscore Failed");
			throw e;
		}
	}

	public void International_number(String mobnumber) throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Country_dropdown"));
			driver.findElement(FetchData.readOR("Country_dropdown")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("International_country"));
			List<WebElement> country = driver.findElements(FetchData
					.readOR("International_country"));
			country.get(3).click();
			driver.findElement(FetchData.readOR("number")).sendKeys(mobnumber);
			CommonFunctions.pass(child, "International_number Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "International_number Failed");
			throw e;
		}

	}

	public void logIn() throws Exception {
		try {
			
			Variables.elementWait(driver, 10, FetchData.readOR("logIn"));
			driver.findElement(FetchData.readOR("logIn")).click();
			CommonFunctions.pass(child, "logIn Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "logIn Failed");
			throw e;
		}

	}

	public void emailid(String emailid) throws Exception {
		try {
			
			Variables.elementWait(driver, 10, FetchData.readOR("emailid"));
			driver.findElement(FetchData.readOR("emailid")).sendKeys(emailid);
			CommonFunctions.pass(child, "emailid Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "emailid Failed");
			throw e;
		}
	}

	public void password(String password) throws Exception {
		try {
			
			Variables.elementWait(driver, 10, FetchData.readOR("password"));
			driver.findElement(FetchData.readOR("password")).sendKeys(password);
			CommonFunctions.pass(child, "password Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "password Failed");
			throw e;
		}
	}

	public void login_submit() throws Exception {
		try {
			Variables.elementWait(driver, 60, FetchData.readOR("login_submit"));
			driver.findElement(FetchData.readOR("login_submit")).click();
			CommonFunctions.pass(child,
					"login_submit Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "login_submit Failed");
			throw e;
		}
	}

	public void Courselogin_downloadBrochure() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Courselogin_downloadBrochure"));
			driver.findElement(FetchData.readOR("Courselogin_downloadBrochure"))
					.click();
			CommonFunctions.pass(child, "Courselogin_downloadBrochure Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "Courselogin_downloadBrochure Failed");
			throw e;
		}
	}

	public void already_registered() throws Exception {
		try {
			driver.findElement(FetchData.readOR("alreadyregistered")).click();
			CommonFunctions.pass(child, "already_registered Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "already_registered Failed");
			throw e;
		}
	}

	public void Courselogin_Compare() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Courselogin_Compare"));
			driver.findElement(FetchData.readOR("Courselogin_Compare")).click();
			CommonFunctions.pass(child, "Courselogin_Compare Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "Courselogin_Compare Failed");
			throw e;
		}
	}

	public void Courselogin_shortlist() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Courselogin_shortlist"));
			driver.findElement(FetchData.readOR("Courselogin_shortlist"))
					.click();
			CommonFunctions.pass(child, "Courselogin_shortlist Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "Courselogin_shortlist Failed");
			throw e;
		}
	}

	public void Universitylogin_EmailDeatils() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Universitylogin_EmailDeatils"));
			driver.findElement(FetchData.readOR("Universitylogin_EmailDeatils"))
					.click();
			CommonFunctions.pass(child, "Universitylogin_EmailDeatils Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "Universitylogin_EmailDeatils Failed");
			throw e;
		}
	}
	
	public void SA_AlluniversityCountryPage__DB() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("SA_AlluniversityCountryPage__DB"));
			driver.findElement(FetchData.readOR("SA_AlluniversityCountryPage__DB"))
					.click();
			CommonFunctions.pass(child, "Universitylogin_EmailDeatils Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "Universitylogin_EmailDeatils Failed");
			throw e;
		}
	}

	public void RMC_Coursepage() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("RMC_Coursepage"));
			driver.findElement(FetchData.readOR("RMC_Coursepage")).click();
			CommonFunctions.pass(child, "RMC_Coursepage Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "RMC_Coursepage Failed");
			throw e;
		}
	}

	public void ScholarshipAP_DB_Sidebar() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("ScholarshipAP_DB_Sidebar"));
			driver.findElement(FetchData.readOR("ScholarshipAP_DB_Sidebar"))
					.click();
			CommonFunctions.pass(child, "ScholarshipAP_DB_Sidebar Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ScholarshipAP_DB_Sidebar Failed");
			throw e;
		}
	}

	public void levelradiobutton__Masters() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("levelradiobutton__Masters"));
			driver.findElement(FetchData.readOR("levelradiobutton__Masters"))
					.click();
			Variables.elementWait(driver, 10, FetchData.readOR("course"));
			driver.findElement(FetchData.readOR("course")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("mastercourse"));
			driver.findElement(FetchData.readOR("mastercourse")).click();
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-100)", "");
			Variables.elementWait(driver, 10, FetchData.readOR("checkforspecilization"));
			CommonFunctions.pass(child, "levelradiobutton__Masters Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "levelradiobutton__Masters Failed");
			throw e;
		}
	}

	public void countries_2() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("country"));
			driver.findElement(FetchData.readOR("country")).click();
			driver.findElement(FetchData.readOR("countryselection1")).click();
			driver.findElement(FetchData.readOR("countryselection2")).click();
			driver.findElement(FetchData.readOR("ok-btn")).click();
			CommonFunctions.pass(child, "countries_2 Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "countries_2 Failed");
			throw e;
		}
	}

	public void MasterDetails() throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Graduation_Stream")));
			driver.findElement(FetchData.readOR("Graduation_Stream")).click();
			Variables.elementWait(driver, 20, FetchData.readOR("StreamSelection"));
			driver.findElement(FetchData.readOR("StreamSelection")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("Graduation_Percentage"));
			driver.findElement(FetchData.readOR("Graduation_Percentage"))
					.click();
			Variables.elementWait(driver, 10, FetchData.readOR("PercentageSelection"));
			driver.findElement(FetchData.readOR("PercentageSelection")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("workexperience"));
			driver.findElement(FetchData.readOR("workexperience")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("experienceSelection"));
			driver.findElement(FetchData.readOR("experienceSelection")).click();

			CommonFunctions.pass(child, "MasterDetails Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "MasterDetails Failed");
			throw e;
		}
	}

	public void countries_3() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("country"));
			driver.findElement(FetchData.readOR("country")).click();
			driver.findElement(FetchData.readOR("countryselection1")).click();
			driver.findElement(FetchData.readOR("countryselection2")).click();
			driver.findElement(FetchData.readOR("countryselection3")).click();
			driver.findElement(FetchData.readOR("ok-btn")).click();
			CommonFunctions.pass(child, "countries_3 Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "countries_3 Failed");
			throw e;
		}
	}

	public void ScholarshipAP_DB_belly() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1300)");
			Variables.elementWait(driver, 10, FetchData.readOR("ScholarshipAP_DB_belly"));
			driver.findElement(FetchData.readOR("ScholarshipAP_DB_belly"))
					.click();
			CommonFunctions.pass(child, "ScholarshipAP_DB_belly Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ScholarshipAP_DB_belly Failed");
			throw e;
		}
	}

	public void ScholarshipAP_Apply_belly() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1300)");
			driver.findElement(FetchData.readOR("ScholarshipAP_Apply_belly"))
					.click();
			CommonFunctions.pass(child, "ScholarshipAP_Apply_belly Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ScholarshipAP_Apply_belly Failed");
			throw e;
		}
	}

	public void ScholarshipAP_Apply_bottom() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2800)");
			driver.findElement(FetchData.readOR("ScholarshipAP_Apply_bottom"))
					.click();
			CommonFunctions.pass(child, "ScholarshipAP_Apply_bottom Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ScholarshipAP_Apply_bottom Failed");
			throw e;
		}
	}

	
	
	public void ScholarshipAP_DB_bottom() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2800)");
			driver.findElement(FetchData.readOR("ScholarshipAP_DB_bottom"))
					.click();
			CommonFunctions.pass(child, "ScholarshipAP_DB_bottom Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ScholarshipAP_DB_bottom Failed");
			throw e;
		}
	}

	public void header_ScholsrhipDB() throws Exception {
		try {
			String expectedMessage = "Download Scholarship Brochure";
			String message = driver.findElement(
					FetchData.readOR("header_ScholsrhipDB")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_ScholsrhipDB Passed");
			} else {
				
				CommonFunctions.fail(child, "header_ScholsrhipDB Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}

	public void header_ScholsrhiApply() throws Exception {
		try {
			String expectedMessage = "Signup to apply for Scholarship";
			String message = driver.findElement(
					FetchData.readOR("header_ScholsrhiApply")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_ScholsrhiApply Passed");
			} else {
				
				CommonFunctions.fail(child, "header_ScholsrhiApply Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}

	public void header_DownloadBrochure() throws Exception {
		try {
			String expectedMessage = "Download Brochure";
			String message = driver.findElement(
					FetchData.readOR("header_DownloadBrochure")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_DownloadBrochure Passed");
			} else {
				
				CommonFunctions.fail(child, "header_DownloadBrochure Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}

	public void header_RateMyChance() throws Exception {
		try {
			String expectedMessage = "Rate your chances";
			String message = driver.findElement(
					FetchData.readOR("header_RateMyChance")).getText();
			if (message.contains(expectedMessage)) {
			
				CommonFunctions.pass(child, "header_RateMyChance Passed");
			} else {
				
				CommonFunctions.fail(child, "header_RateMyChance Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}

	public void header_Shortlist() throws Exception {
		try {
			String expectedMessage = "Save Courses";
			String message = driver.findElement(
					FetchData.readOR("header_Shortlist")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_Shortlist Passed");
			} else {
				
				CommonFunctions.fail(child, "header_Shortlist Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}

	public void header_Compare() throws Exception {
		try {
			String expectedMessage = "Signup to compare colleges";
			String message = driver.findElement(
					FetchData.readOR("header_Compare")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_Compare Passed");
			} else {
				
				CommonFunctions.fail(child, "header_Compare Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}

	public void header_Signup() throws Exception {
		try {
			String expectedMessage = "Signup to get started";
			String message = driver.findElement(
					FetchData.readOR("header_Signup")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_Signup Passed");
			} else {
				
				CommonFunctions.fail(child, "header_Signup Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}

	public void header_DownloadGuide() throws Exception {
		try {
			String expectedMessage = "Download Guide";
			String message = driver.findElement(
					FetchData.readOR("header_DownloadGuide")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_DownloadGuide Passed");
			} else {
			
				CommonFunctions.fail(child, "header_DownloadGuide Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}

	public void Scholarship_categoryPage_DB() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Scholarship_categoryPage_DB"));
			driver.findElement(FetchData.readOR("Scholarship_categoryPage_DB"))
					.click();
			CommonFunctions.pass(child, "Scholarship_categoryPage_DB Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Scholarship_categoryPage_DB Failed");
			throw e;
		}
	}

	public void ExamPage_DownloadGuide() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("ExamPage_DownloadGuide"));
			driver.findElement(FetchData.readOR("ExamPage_DownloadGuide"))
					.click();
			CommonFunctions.pass(child, "ExamPage_DownloadGuide Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ExamPage_DownloadGuide Failed");
			throw e;
		}
	}
	
	public void ExamPage_childDownloadGuide() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("ExamPage_Child"));
			driver.findElement(FetchData.readOR("ExamPage_Child"))
					.click();
			Variables.elementWait(driver, 10, FetchData.readOR("ExamPage_DownloadGuide"));
			driver.findElement(FetchData.readOR("ExamPage_DownloadGuide"))
					.click();
			CommonFunctions.pass(child, "ExamPage_childDownloadGuide Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ExamPage_childDownloadGuide Failed");
			throw e;
		}
	}
	
	public void ExamPage_childDownloadGuideInline() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("ExamPage_Child"));
			driver.findElement(FetchData.readOR("ExamPage_Child"))
					.click();
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("ExamPage_childDownloadGuideInline")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)");
			Variables.elementWait(driver, 10, FetchData.readOR("Applycontent_DownloadGuideBelly"));
			driver.findElement(FetchData.readOR("Applycontent_DownloadGuideBelly"))
					.click();
			CommonFunctions.pass(child, "ExamPage_childDownloadGuideInline Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ExamPage_childDownloadGuideInline Failed");
			throw e;
		}
	}
	
	public void ExamPage_parentDownloadGuideInline() throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("ExamPage_childDownloadGuideInline")));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,-100)");
			Variables.elementWait(driver, 10, FetchData.readOR("Applycontent_DownloadGuideBelly"));
			driver.findElement(FetchData.readOR("Applycontent_DownloadGuideBelly"))
					.click();
			CommonFunctions.pass(child, "ExamPage_childDownloadGuideInline Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ExamPage_childDownloadGuideInline Failed");
			throw e;
		}
	}

	public void ExamPage_Comment(String Comment) throws Exception {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Exampagescroll")));
			driver.findElement(FetchData.readOR("ExamPage_Comment")).sendKeys(
					Comment);
			driver.findElement(FetchData.readOR("ExamPage_Submit")).click();
			CommonFunctions.pass(child, "ExamPage_Comment Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ExamPage_Comment Failed");
			throw e;
		}
	}

	public void header_Comment() throws Exception {
		try {
			String expectedMessage = "Signup to add a comment";
			Variables.elementWait(driver, 10, FetchData.readOR("header_Comment"));
			String message = driver.findElement(
					FetchData.readOR("header_Comment")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_Comment Passed");
			} else {
				
				CommonFunctions.fail(child, "header_Comment Failed");
			}

		}

		catch (Exception e) {

			throw e;
		}
	}
	
	public void SignUp_RMC() throws Exception {
		try {
			Variables.elementWait(driver, 30, FetchData.readOR("SignUp"));
			driver.findElement(FetchData.readOR("SignUp")).click();
			Variables.elementWait(driver, 90, FetchData.readOR("ThankyoupageRMC"));
			CommonFunctions.pass(child, "SignUp_RMC Passed");
			
		} catch (Exception e) {
			CommonFunctions.fail(child, "SignUp_RMC Failed");
			throw e;
		}

	}
	
	public void Thankyoupage() throws Exception {
		try {
			Thread.sleep(2000);
			Variables.elementWait(driver, 90, FetchData.readOR("Thankyoupage"));
			CommonFunctions.pass(child, "Thankyoupage Passed");
			} catch (Exception e) {
			CommonFunctions.fail(child, "Thankyoupage Failed");
			throw e;
		}

	}
	
	
	public void SignUp_DG() throws Exception {
		try {
			driver.findElement(FetchData.readOR("SignUp_DG")).click();
			Variables.elementWait(driver, 90, FetchData.readOR("ThankyoupageDG"));
			CommonFunctions.pass(child, "SignUp_DG Passed");
			
		} catch (Exception e) {
			CommonFunctions.fail(child, "SignUp_DG Failed");
			throw e;
		}

	}
	
public void SignUp_Scholarship() throws Exception {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("SignUp"));
			driver.findElement(FetchData.readOR("SignUp")).click();
			Variables.elementWait(driver, 90, FetchData.readOR("Thankyoupage"));
			CommonFunctions.pass(child, "SignUp_Scholarship Passed");
			} catch (Exception e) {
			CommonFunctions.fail(child, "SignUp_Scholarship Failed");
			throw e;
		}

	}

public void SignUp_Scholarship_loggedIn() throws Exception {
	try {
		Variables.elementWait(driver, 90, FetchData.readOR("Thankyoupage"));
		CommonFunctions.pass(child, "SignUp_Scholarship Passed");
		} catch (Exception e) {
		CommonFunctions.fail(child, "SignUp_Scholarship Failed");
		throw e;
	}

}


public void Scholarship_Layer() throws Exception {
	try {
		Variables.elementWait(driver, 20, FetchData.readOR("SignUp"));
		driver.findElement(FetchData.readOR("SignUp")).click();
		Variables.elementWait(driver, 90, FetchData.readOR("scholarshiplayer"));
		CommonFunctions.pass(child, "SignUp_Scholarship Passed");
		} catch (Exception e) {
		CommonFunctions.fail(child, "SignUp_Scholarship Failed");
		throw e;
	}

}

public void Scholarship_Layerlogin() throws Exception {
	try {
		Variables.elementWait(driver, 30, FetchData.readOR("login_submit"));
		driver.findElement(FetchData.readOR("login_submit")).click();
		Thread.sleep(5000);
		CommonFunctions.pass(child, "SignUp_Scholarshiplogin Passed");
		} catch (Exception e) {
		CommonFunctions.fail(child, "SignUp_Scholarshiplogin Failed");
		throw e;
	}

}

public void login_Scholarship() throws Exception {
	try {
		Variables.elementWait(driver, 30, FetchData.readOR("login_submit"));
		driver.findElement(FetchData.readOR("login_submit")).click();
		Variables.elementWait(driver, 90, FetchData.readOR("Thankyoupage"));
		CommonFunctions.pass(child,
				"login_submit Passed");
	} catch (Exception e) {
		CommonFunctions.fail(child, "login_submit Failed");
		throw e;
	}
}

public void Applycontent_DownloadGuide() throws Exception {
	try {
		Variables.elementWait(driver, 10, FetchData.readOR("Applycontent_DownloadGuide"));
		driver.findElement(FetchData.readOR("Applycontent_DownloadGuide"))
				.click();
		CommonFunctions.pass(child, "Applycontent_DownloadGuide Passed");
	} catch (Exception e) {
		CommonFunctions.fail(child, "Applycontent_DownloadGuide Failed");
		throw e;
	}
}

public void Applycontent_DownloadGuideBelly() throws Exception {
	try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
		Variables.elementWait(driver, 10, FetchData.readOR("Applycontent_DownloadGuideBelly"));
		driver.findElement(FetchData.readOR("Applycontent_DownloadGuideBelly"))
				.click();
		CommonFunctions.pass(child, "Applycontent_DownloadGuideBelly Passed");
	} catch (Exception e) {
		CommonFunctions.fail(child, "Applycontent_DownloadGuideBelly Failed");
		throw e;
	}
}


public void ApplyContentPage_Comment(String Comment) throws Exception {
	try {
		WebElement myElement = driver.findElement(FetchData
				.readOR("ApplyContentPage_Comment"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", myElement);
		driver.findElement(FetchData.readOR("ApplyContentPage_Comment")).sendKeys(
				Comment);
		driver.findElement(FetchData.readOR("ExamPage_Submit")).click();
		CommonFunctions.pass(child, "ApplyContentPage_Comment Passed");
	} catch (Exception e) {
		CommonFunctions.fail(child, "ApplyContentPage_Comment Failed");
		throw e;
	}
}
	
	public void ArticlePage_Comment(String Comment) throws Exception {
		try {
			WebElement myElement = driver.findElement(FetchData
					.readOR("ArticlePage_Comment"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			driver.findElement(FetchData.readOR("ArticlePage_Comment")).sendKeys(
					Comment);
			driver.findElement(FetchData.readOR("ExamPage_Submit")).click();
			CommonFunctions.pass(child, "ArticlePage_Comment Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ArticlePage_Comment Failed");
			throw e;
		}
}
	
	public void GuidePage_DownloadGuide_right() throws Exception {
		try {
			WebElement myElement = driver.findElement(FetchData
					.readOR("GuidePage_DGRight"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			Variables.elementWait(driver, 10, FetchData.readOR("GuidePage_DGRight"));
			driver.findElement(FetchData.readOR("GuidePage_DGRight"))
					.click();
			CommonFunctions.pass(child, "GuidePage_DGRight Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "GuidePage_DGRight Failed");
			throw e;
		}
	}
	
	public void GuidePage_DownloadGuide_belly() throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,2000)");
			Variables.elementWait(driver, 10, FetchData.readOR("GuidePage_DGBelly"));
			driver.findElement(FetchData.readOR("GuidePage_DGBelly"))
					.click();
			CommonFunctions.pass(child, "GuidePage_DGBelly Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "GuidePage_DGBelly Failed");
			throw e;
		}
	}
	
public void GuidePage_Comment(String Comment) throws Exception {
	try {
			WebElement myElement = driver.findElement(FetchData
					.readOR("GuidePage_Comment"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", myElement);
			driver.findElement(FetchData.readOR("GuidePage_Comment")).sendKeys(
					Comment);
			driver.findElement(FetchData.readOR("ExamPage_Submit")).click();
			CommonFunctions.pass(child, "ArticlePage_Comment Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "ArticlePage_Comment Failed");
			throw e;
		}
}
	
public void Ranking_DownloadBrochure() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("CategoryPage_DownloadBrochure"));
			driver.findElement(
					FetchData.readOR("CategoryPage_DownloadBrochure")).click();
			CommonFunctions.pass(child, "Ranking_DownloadBrochure Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Ranking_DownloadBrochure Failed");
			throw e;
		}
	}
	
public void GAFPEC() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("GAFPEC"));
			driver.findElement(
					FetchData.readOR("GAFPEC")).click();
			CommonFunctions.pass(child, "GAFPEC Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "GAFPEC Failed");
			throw e;
		}
	}
	
public void GAFPEC_Proceed() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("GAFPEC_Proceed"));
			driver.findElement(
					FetchData.readOR("GAFPEC_Proceed")).click();
			CommonFunctions.pass(child, "GAFPEC_Proceed Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "GAFPEC_Proceed Failed");
			throw e;
		}
	}
	
public void Book_Pickup1() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Book_Pickup1"));
			driver.findElement(
					FetchData.readOR("Book_Pickup1")).click();
			CommonFunctions.pass(child, "Book_Pickup1 Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Book_Pickup1 Failed");
			throw e;
		}
}	

public void DHL_Page() throws Exception {
			try {
				Variables.elementWait(driver, 70, FetchData.readOR("DHL_Page"));
				CommonFunctions.pass(child, "DHL_Page Passed");

			} catch (Exception e) {
				CommonFunctions.fail(child, "DHL_Page Failed");
				throw e;
			}
	}
	
public void Book_Pickup2() throws Exception {
	try {
		WebElement myElement = driver.findElement(FetchData
				.readOR("Book_Pickup2"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", myElement);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
		Variables.elementWait(driver, 10, FetchData.readOR("Book_Pickup2"));
		driver.findElement(
				FetchData.readOR("Book_Pickup2")).click();
		CommonFunctions.pass(child, "Book_Pickup2 Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "Book_Pickup2 Failed");
		throw e;
	}
}	

public void Addcourse() throws Exception {
	try {
		Variables.elementWait(driver, 10, FetchData.readOR("Addcourse"));
		driver.findElement(
				FetchData.readOR("Addcourse")).click();
		CommonFunctions.pass(child, "Addcourse Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "Addcourse Failed");
		throw e;
	}
}	

public void Examupload(String upload) throws Exception {
	try {
		Variables.elementWait(driver, 90, FetchData.readOR("uploadDropdown"));
		driver.findElement(
				FetchData.readOR("uploadDropdown")).click();
		Variables.elementWait(driver, 90, FetchData.readOR("uploadDropdown_selection"));
		driver.findElement(
				FetchData.readOR("uploadDropdown_selection")).click();
		Variables.elementWait(driver, 90, FetchData.readOR("Examupload"));
	    driver.findElement(
				FetchData.readOR("Examupload")).sendKeys(upload);
	    uploadFile(upload);
		Variables.elementWait(driver, 90, FetchData.readOR("overlay_wait"));
		driver.findElement(
				FetchData.readOR("overlay_done")).click();
		CommonFunctions.pass(child, "Examupload Passed");
} catch (Exception e) {
		CommonFunctions.fail(child, "Examupload Failed");
		throw e;
	}
}	

public void UniversitySearchPage_DownloadBrochure() throws Exception {
	try {
		Variables.elementWait(driver, 10, FetchData.readOR("UniversitySearchPage_DownloadBrochure"));
		driver.findElement(
				FetchData.readOR("UniversitySearchPage_DownloadBrochure")).click();
		CommonFunctions.pass(child, "UniversitySearchPage_DownloadBrochure Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "UniversitySearchPage_DownloadBrochure Failed");
		throw e;
	}
}

public void uploadFile(String filePath) {
    try {
          String text = filePath;
          StringSelection stringSelection = new StringSelection(text);
          Clipboard clipboard = Toolkit.getDefaultToolkit()
                      .getSystemClipboard();
          clipboard.setContents(stringSelection, stringSelection);
          Robot robot = new Robot();
          Thread.sleep(5000);
          robot.keyPress(KeyEvent.VK_CONTROL);
          robot.keyPress(KeyEvent.VK_V);
          robot.keyRelease(KeyEvent.VK_V);
          robot.keyRelease(KeyEvent.VK_CONTROL);
          Thread.sleep(5000);
          robot.keyPress(KeyEvent.VK_ENTER);
          robot.keyRelease(KeyEvent.VK_ENTER);

          
    } catch (Exception e) {

    }
}


public void GAFPEC_Middle() throws Exception {
	try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Variables.elementWait(driver, 10, FetchData.readOR("GAFPEC_Middle"));
		driver.findElement(
				FetchData.readOR("GAFPEC_Middle")).click();
		CommonFunctions.pass(child, "GAFPEC_Middle Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "GAFPEC_Middle Failed");
		throw e;
	}
}

public void GAFPEC_Bottom() throws Exception {
	try {

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();",
				driver.findElement(FetchData.readOR("GAFPEC_Bottom")));
		Variables.elementWait(driver, 10, FetchData.readOR("GAFPEC_Bottom"));
		driver.findElement(
				FetchData.readOR("GAFPEC_Bottom")).click();
		CommonFunctions.pass(child, "GAFPEC_Bottom Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "GAFPEC_Bottom Failed");
		throw e;
	}
}

public void SearchPage_DownloadBrochure() throws Exception {
	try {
		Variables.elementWait(driver, 10, FetchData.readOR("SearchPage_DownloadBrochure"));
		driver.findElement(
				FetchData.readOR("SearchPage_DownloadBrochure")).click();
		CommonFunctions.pass(child, "SearchPage_DownloadBrochure Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "SearchPage_DownloadBrochure Failed");
		throw e;
	}
}

public void SearchPage_RMC() throws Exception {
	try {
		Variables.elementWait(driver, 10, FetchData.readOR("SearchPage_RMC"));
		driver.findElement(FetchData.readOR("SearchPage_RMC")).click();
		CommonFunctions.pass(child, "SearchPage_RMC Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "SearchPage_RMC Failed");
		throw e;
	}
}

public void Searchpage_shortlist() throws Exception {
	try {
		Variables.elementWait(driver, 10, FetchData.readOR("Searchpage_shortlist"));
		driver.findElement(FetchData.readOR("Searchpage_shortlist"))
				.click();
		CommonFunctions.pass(child, "Searchpage_shortlist Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "Searchpage_shortlist Failed");
		throw e;
	}

}

public void Searchpage_compare() throws Exception {
	try {

		Variables.elementWait(driver, 10, FetchData.readOR("Searchpage_compare"));
		driver.findElement(FetchData.readOR("Searchpage_compare"))
				.click();
		CommonFunctions.pass(child, "Searchpage_compare Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "Searchpage_compare Failed");
		throw e;
	}

}

public void OTPVerification_Abroad(WebDriver driver,  Objects obj,String mobilenumber) throws Exception {
    try {
          Variables.elementWait(driver, 10,
                      FetchData.readOR("SAloginDesktop_OTP"));
          Database db  = new Database();
          ResultSet rs = db.executeDbQuery("select OTP from OTPVerification where mobile="+mobilenumber+" order by id desc limit 1;", obj);
          rs.next();
     
          driver.findElement(FetchData.readOR("SAloginDesktop_OTP")).sendKeys(rs.getString("OTP"));

          Variables.elementWait(driver, 10,
                      FetchData.readOR("SADesktop_OTPVerifyButton"));
          WebElement we = driver.findElement(FetchData
                      .readOR("SADesktop_OTPVerifyButton"));
          JavascriptExecutor executor = (JavascriptExecutor) driver;
          executor.executeScript("arguments[0].click();", we);
          }

    catch (Exception e) {
    	e.printStackTrace();
    }
}


}
