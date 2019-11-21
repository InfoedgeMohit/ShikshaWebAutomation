package com.shiksha.test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.SA_CTA_Desktop_Object;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.ExcelReader;
import com.shiksha.resourses.FetchData;

public class SA_CTA_Desktop {

	SA_CTA_Desktop_Object CTA = null;
	public String finalUrl = "";
	CommonFunctions CommonFunctions = new CommonFunctions();

	public void SA_CategoryPage_DownloadBrochure(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site

		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "be-btech-in-abroad-dc11510";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "be-btech-in-abroad-dc11510";
		}

		// // Category Page Download Brochure CTA
		ExtentTest child1 = CommonFunctions.createChild(report,
				"DownloadBrochure CTA",
				"Test Case CategoryPage_DownloadBrochure CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child1);
			driver.get(finalUrl);

			// //DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child1,
						"CategoryPage_DownloadBrochure CTA Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.CategoryPage_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.planradiobutton();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child1, report);

		}
	}

	public void SA_CategoryPage_DownloadBrochure_LoggedIn(Objects obj)
			throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site

		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "be-btech-in-abroad-dc11510";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "be-btech-in-abroad-dc11510";
		}

		// // Category Page Download Brochure CTA
		ExtentTest child2 = CommonFunctions.createChild(report,
				"DownloadBrochure CTA",
				"Test Case CategoryPage_DownloadBrochure CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child2);
			driver.get(finalUrl);

			// //DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child2,
						"CategoryPage_DownloadBrochure CTA Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.CategoryPage_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.already_registered();
				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child2, report);

		}
	}

	public void SA_CategoryPage_RMC(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site

		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "bachelors-of-business-in-abroad-cl1239";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "bachelors-of-business-in-abroad-cl1239";
		}
		// // Category Page RMC CTA
		ExtentTest child3 = CommonFunctions.createChild(report, "RMC CTA",
				"Test Case CategoryPage_RMC CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child3);
			driver.get(finalUrl);

			// //RMC CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child3,
						"CategoryPage_RMC CTA Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.CategoryPage_RMC();
				CTA.header_RateMyChance();
				CTA.planradiobutton();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp_RMC();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child3, report);

		}

	}

	public void SA_CategoryPage_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "be-btech-in-abroad-dc11510";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "be-btech-in-abroad-dc11510";
		}
		// // Category Page Shortlist CTA
		ExtentTest child4 = CommonFunctions
				.createChild(report, "Shortlist CTA",
						"Test Case CategoryPage_Shortlist CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child4);
			driver.get(finalUrl);

			// //Shortlist CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child4,
						"CategoryPage_Shortlist Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Categorypage_shortlist();
				CTA.header_Shortlist();
				CTA.planradiobutton();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child4, report);

		}

	}

	public void SA_CategoryPage_Shortlist_LoggedIn(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "be-btech-in-abroad-dc11510";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "be-btech-in-abroad-dc11510";
		}
		// // Category Page Shortlist CTA
		ExtentTest child5 = CommonFunctions
				.createChild(report, "Shortlist CTA",
						"Test Case CategoryPage_Shortlist CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child5);
			driver.get(finalUrl);

			// //Shortlist CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child5,
						"CategoryPage_Shortlist Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Categorypage_shortlist();
				CTA.header_Shortlist();
				CTA.already_registered();
				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child5, report);

		}

	}

	public void SA_CategoryPage_Compare(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "be-btech-in-abroad-dc11510";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "be-btech-in-abroad-dc11510";
		}
		// // Category Page Compare CTA
		ExtentTest child6 = CommonFunctions.createChild(report, "Compare CTA",
				"Test Case CategoryPage_Compare CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child6);
			driver.get(finalUrl);

			// // Compare CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child6,
						"CategoryPage_Compare Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Categorypage_compare();
				CTA.Compare2();
				CTA.Compare();
				CTA.header_Compare();
				CTA.planradiobutton();
				CTA.countries();
				CTA.levelradiobutton_Bachelors();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child6, report);
		}

	}

	public void SA_CategoryPage_Compare_loggedIn(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "be-btech-in-abroad-dc11510";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "be-btech-in-abroad-dc11510";
		}
		// // Category Page Compare CTA
		ExtentTest child7 = CommonFunctions.createChild(report, "Compare CTA",
				"Test Case CategoryPage_Compare CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child7);
			driver.get(finalUrl);

			// // Compare CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child7,
						"CategoryPage_Compare Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Categorypage_compare();
				CTA.Compare2();
				CTA.Compare();
				CTA.header_Compare();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child7, report);
		}

	}

	public void SA_CoursePage_InlineDB(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		// // Course Page InlineDB CTA
		ExtentTest child8 = CommonFunctions.createChild(report, "InlineDB CTA",
				"Test Case CoursePage_InlineDB CTA Started");
		try {

			CTA = new SA_CTA_Desktop_Object(driver, child8);
			driver.get(finalUrl);

			// //Inline DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child8,
						"CoursePage_InlineDB Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Inlineform();
				CTA.planradiobutton();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		}

		catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child8, report);
		}

	}

	public void SA_CoursePage_InlineDB_loggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		// // Course Page InlineDB CTA
		ExtentTest child9 = CommonFunctions.createChild(report, "InlineDB CTA",
				"Test Case CoursePage_InlineDB CTA Started");
		try {

			CTA = new SA_CTA_Desktop_Object(driver, child9);
			driver.get(finalUrl);

			// //Inline DownloadBrochure CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child9,
						"CoursePage_InlineDB Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.CourseInlineform();
				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		}

		catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child9, report);
		}

	}

	public void SA_CoursePage_DownloadBrochure_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		// // Course Page DownloadBrochure CTA
		ExtentTest child10 = CommonFunctions.createChild(report,
				"DownloadBrochure CTA",
				"Test Case CoursePage_DownloadBrochure CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child10);
			driver.get(finalUrl);

			// //DownloadBrochure CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child10,
						"CoursePage_DownloadBrochure Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Courselogin_downloadBrochure();
				CTA.header_DownloadBrochure();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child10, report);
		}

	}

	public void SA_CoursePage_DownloadBrochure(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		// // Course Page DownloadBrochure CTA
		ExtentTest child11 = CommonFunctions.createChild(report,
				"DownloadBrochure CTA",
				"Test Case CoursePage_DownloadBrochure CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child11);
			driver.get(finalUrl);

			// //DownloadBrochure CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child11,
						"CoursePage_DownloadBrochure Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Courselogin_downloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.planradiobutton();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child11, report);
		}

	}

	public void SA_CoursePage_Compare_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		// // Course Page Compare CTA
		ExtentTest child12 = CommonFunctions.createChild(report, "Compare CTA",
				"Test Case CoursePage_Compare CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child12);
			driver.get(finalUrl);

			// //Compare CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child12,
						"CoursePage_Compare Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Courselogin_Compare();
				CTA.Compare2();
				CTA.Compare();
				CTA.header_Compare();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child12, report);
		}

	}

	public void SA_CoursePage_Compare(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		// // Course Page Compare CTA
		ExtentTest child13 = CommonFunctions.createChild(report, "Compare CTA",
				"Test Case CoursePage_Compare CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child13);
			driver.get(finalUrl);

			// //Compare CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child13,
						"CoursePage_Compare Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Courselogin_Compare();
				CTA.Compare2();
				CTA.Compare();
				CTA.header_Compare();

				CTA.planradiobutton();
				CTA.countries();
				CTA.levelradiobutton_Bachelors();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child13, report);
		}

	}

	public void SA_CoursePage_Shortlist_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}
		// // Course Page Shortlist CTA
		ExtentTest child14 = CommonFunctions.createChild(report,
				"Shortlist CTA",
				"Test Case CoursePageCoursepage_Shortlist CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child14);
			driver.get(finalUrl);

			// //Shortlist CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child14,
						"CoursePage_Shortlist Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Courselogin_shortlist();
				CTA.header_Shortlist();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child14, report);
		}

	}

	public void SA_CoursePage_Shortlist(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}
		// // Course Page Shortlist CTA
		ExtentTest child15 = CommonFunctions.createChild(report,
				"Shortlist CTA",
				"Test Case CoursePageCoursepage_Shortlist CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child15);
			driver.get(finalUrl);

			// //Shortlist CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child15,
						"CoursePage_Shortlist Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Courselogin_shortlist();
				CTA.header_Shortlist();
				CTA.planradiobutton();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child15, report);
		}

	}

	public void SA_CoursePage_RMC(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "usa/universities/eastern-michigan-university/bachelors-in-electronic-engineering-technology";
		}

		// // Course Page RMC CTA
		ExtentTest child16 = CommonFunctions.createChild(report, "RMC CTA",
				"Test Case CoursePage_RMC CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child16);
			driver.get(finalUrl);

			// //RMC CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child16,
						"CoursePage_RMC Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.RMC_Coursepage();
				CTA.header_RateMyChance();
				CTA.planradiobutton();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp_RMC();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child16, report);
		}

	}

	public void SA_HomePage_DownloadGuide(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu;
		}

		// // Home Page DownloadGuide CTA
		ExtentTest child18 = CommonFunctions.createChild(report,
				"Downloadguide CTA",
				"Test Case HomePage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child18);
			driver.get(finalUrl);

			// //DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child18,
						"HomePage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.downloadguide();
				CTA.header_DownloadGuide();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child18, report);
		}

	}

	public void SA_HomePage_DownloadGuide_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu;
		}

		// // Home Page DownloadGuide CTA
		ExtentTest child19 = CommonFunctions.createChild(report,
				"Downloadguide CTA",
				"Test Case HomePage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child19);
			driver.get(finalUrl);

			// //DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child19,
						"HomePage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.downloadguide();
				CTA.header_DownloadGuide();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				;
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child19, report);
		}

	}



	public void SA_UniversityPage_InlineDB(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "usa/universities/eastern-michigan-university";
		}

		// //UniversityPage Inline Download Brochure CTA
		ExtentTest child21 = CommonFunctions.createChild(report,
				"InlineDB CTA",
				"Test Case UniversityPage_Inline DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child21);
			driver.get(finalUrl);

			// //Inline DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child21,
						"UniversityPage_Inline DB Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Inlineform();
				CTA.planradiobutton();
				CTA.selectCourse();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		}

		catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child21, report);
		}

	}

	public void SA_UniversityPage_InlineDB_loggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "usa/universities/eastern-michigan-university";
		}

		// //UniversityPage Inline Download Brochure CTA
		ExtentTest child22 = CommonFunctions.createChild(report,
				"InlineDB CTA",
				"Test Case UniversityPage_Inline DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child22);
			driver.get(finalUrl);

			// //Inline DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child22,
						"UniversityPage_Inline DB Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.CourseInlineform();
				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.selectCourse();
				CTA.SignUp();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		}

		catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child22, report);
		}

	}

	public void SA_UniversityPage__email(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "usa/universities/eastern-michigan-university";
		}

		// //UniversityPage EmailMe CTA
		ExtentTest child23 = CommonFunctions.createChild(report, "email CTA",
				"Test Case UniversityPage_EmailMe CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child23);
			driver.get(finalUrl);

			// //EmailMe CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child23,
						"UniversityPage_EmailMe Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Universitylogin_EmailDeatils();
				CTA.header_DownloadBrochure();
				CTA.planradiobutton();
				CTA.selectCourse();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child23, report);
		}

	}

	public void SA_UniversityPage__email_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities/eastern-michigan-university";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "usa/universities/eastern-michigan-university";
		}

		// //UniversityPage EmailMe CTA
		ExtentTest child24 = CommonFunctions.createChild(report, "email CTA",
				"Test Case UniversityPage_EmailMe CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child24);
			driver.get(finalUrl);

			// //EmailMe CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child24,
						"UniversityPage_EmailMe Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Universitylogin_EmailDeatils();
				CTA.header_DownloadBrochure();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.selectCourse();
				WebElement myElement = driver.findElement(FetchData
						.readOR("SignUp"));
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView();", myElement);
				CTA.SignUp();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child24, report);
		}

	}

	public void Scholarship_categoryPage_DB(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "/scholarships/australia-cp";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "/scholarships/australia-cp";
		}

		// // Scholarship Category page Download Brochure CTA
		ExtentTest child25 = CommonFunctions
				.createChild(report, "ScholarshipDB CTA",
						"Test Case ScholarshipCategoryPage_Download Brochure CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child25);
			driver.get(finalUrl);

			// //Download Brochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child25,
						"ScholarshipCategoryPage_Download Brochure Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Scholarship_categoryPage_DB();
				CTA.header_ScholsrhipDB();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_Scholarship();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child25, report);
		}

	}

	public void Scholarship_categoryPage_DB_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "/scholarships/australia-cp";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "/scholarships/australia-cp";
		}

		// // Scholarship Category page Download Brochure CTA
		ExtentTest child26 = CommonFunctions
				.createChild(report, "ScholarshipDB CTA",
						"Test Case ScholarshipCategoryPage_Download Brochure CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child26);
			driver.get(finalUrl);

			// //Download Brochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child26,
						"ScholarshipCategoryPage_Download Brochure Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Scholarship_categoryPage_DB();
				CTA.header_ScholsrhipDB();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.SignUp_Scholarship_loggedIn();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child26, report);
		}

	}

	public void ScholarshipDP_Apply_Sidebar(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page Apply Now CTA on sidebar
		ExtentTest child27 = CommonFunctions.createChild(report,
				"ScholarshipAP_Apply_Sidebar CTA",
				"Test Case ScholarshipDetailPage_Sidebar ApplyNow CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child27);
			driver.get(finalUrl);

			// //Sidebar ApplyNow CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child27,
						"ScholarshipDetailPage_Sidebar ApplyNow Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_Apply_Sidebar();
				CTA.header_ScholsrhiApply();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.Scholarship_Layer();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				driver.navigate().back();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child27, report);
		}

	}

	public void ScholarshipDP_Apply_Sidebar_loggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page Apply Now CTA on sidebar
		ExtentTest child28 = CommonFunctions.createChild(report,
				"ScholarshipAP_Apply_Sidebar CTA",
				"Test Case ScholarshipDetailPage_Sidebar ApplyNow CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child28);
			driver.get(finalUrl);

			// //Sidebar ApplyNow CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child28,
						"ScholarshipDetailPage_Sidebar ApplyNow Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_Apply_Sidebar();
				CTA.header_ScholsrhiApply();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.Scholarship_Layerlogin();
				driver.navigate().back();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child28, report);
		}

	}

	public void ScholarshipDP_DB_Sidebar(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page Download Brochure CTA on sidebar
		ExtentTest child29 = CommonFunctions.createChild(report,
				"ScholarshipAP_DB_Sidebar CTA",
				"Test Case ScholarshipDetailPage_Sidebar DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child29);
			driver.get(finalUrl);

			// //Sidebar DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child29,
						"ScholarshipDetailPage_Sidebar DB Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_DB_Sidebar();
				CTA.header_ScholsrhipDB();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_Scholarship();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child29, report);
		}
	}

	public void ScholarshipDP_DB_Sidebar_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page Download Brochure CTA on sidebar
		ExtentTest child30 = CommonFunctions.createChild(report,
				"ScholarshipAP_DB_Sidebar CTA",
				"Test Case ScholarshipDetailPage_Sidebar DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child30);
			driver.get(finalUrl);

			// //Sidebar DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child30,
						"ScholarshipDetailPage_Sidebar DB Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_DB_Sidebar();
				CTA.header_ScholsrhipDB();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.SignUp_Scholarship_loggedIn();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child30, report);
		}
	}

	public void ScholarshipDP_DB_belly(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page Download Brochure CTA on belly
		ExtentTest child31 = CommonFunctions.createChild(report,
				"ScholarshipAP_DB_belly CTA",
				"Test Case ScholarshipDetailPage_Belly DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child31);
			driver.get(finalUrl);

			// Belly DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child31,
						"ScholarshipDetailPage_Belly DB Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_DB_belly();
				CTA.header_ScholsrhipDB();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_Scholarship();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child31, report);
		}
	}

	public void ScholarshipDP_DB_belly_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page Download Brochure CTA on belly
		ExtentTest child32 = CommonFunctions.createChild(report,
				"ScholarshipAP_DB_belly CTA",
				"Test Case ScholarshipDetailPage_Belly DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child32);
			driver.get(finalUrl);

			// Belly DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child32,
						"ScholarshipDetailPage_Belly DB Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_DB_belly();
				CTA.header_ScholsrhipDB();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.SignUp_Scholarship_loggedIn();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child32, report);
		}
	}

	public void ScholarshipDP_Apply_belly(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page ApplyNow CTA on belly
		ExtentTest child33 = CommonFunctions.createChild(report,
				"ScholarshipAP_Apply_belly CTA",
				"Test Case ScholarshipDetailPage_Sidebar DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child33);
			driver.get(finalUrl);

			// //Belly ApplyNow CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child33,
						"ScholarshipDetailPage_Sidebar DB Test Case  for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_Apply_belly();
				CTA.header_ScholsrhiApply();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.Scholarship_Layer();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				driver.navigate().back();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child33, report);
		}
	}

	public void ScholarshipDP_Apply_belly_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page ApplyNow CTA on belly
		ExtentTest child34 = CommonFunctions.createChild(report,
				"ScholarshipAP_Apply_belly CTA",
				"Test Case ScholarshipDetailPage_Sidebar DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child34);
			driver.get(finalUrl);

			// //Belly ApplyNow CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child34,
						"ScholarshipDetailPage_Sidebar DB Test Case  for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_Apply_belly();
				CTA.header_ScholsrhiApply();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Scholarship_Layerlogin();
				driver.navigate().back();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child34, report);
		}
	}

	public void ScholarshipDP_Apply_bottom(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page ApplyNow CTA at bottom
		ExtentTest child35 = CommonFunctions.createChild(report,
				"ScholarshipAP_Apply_bottom CTA",
				"Test Case ScholarshipDetailPage_Bottom ApplyNow CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child35);
			driver.get(finalUrl);

			// //Bottom ApplyNow CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child35,
						"ScholarshipDetailPage_Bottom ApplyNow  Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_Apply_bottom();
				CTA.header_ScholsrhiApply();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.Scholarship_Layer();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				driver.navigate().back();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child35, report);
		}
	}

	public void ScholarshipDP_Apply_bottom_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page ApplyNow CTA at bottom
		ExtentTest child36 = CommonFunctions.createChild(report,
				"ScholarshipAP_Apply_bottom CTA",
				"Test Case ScholarshipDetailPage_Bottom ApplyNow CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child36);
			driver.get(finalUrl);

			// //Bottom ApplyNow CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child36,
						"ScholarshipDetailPage_Bottom ApplyNow  Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_Apply_bottom();
				CTA.header_ScholsrhiApply();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);
				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.Scholarship_Layerlogin();
				driver.switchTo().window(parentid);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child36, report);
		}
	}

	public void ScholarshipDP_DB_bottom_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page Download Brochure CTA at bottom
		ExtentTest child37 = CommonFunctions.createChild(report,
				"ScholarshipAP_DB_bottom CTA",
				"Test Case ScholarshipDetailPage_Bottom DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child37);
			driver.get(finalUrl);

			// //Bottom DownloadBrochure CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child37,
						"ScholarshipDetailPage_Bottom DB Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_DB_bottom();
				CTA.header_ScholsrhipDB();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_Scholarship();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child37, report);
		}
	}

	public void ScholarshipDP_DB_bottom(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "scholarships/support-scholarships-for-young-women-masters";
		}

		// // Scholarship Detail Page Download Brochure CTA at bottom
		ExtentTest child38 = CommonFunctions.createChild(report,
				"ScholarshipAP_DB_bottom CTA",
				"Test Case ScholarshipDetailPage_Bottom DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child38);
			driver.get(finalUrl);

			// //Bottom DownloadBrochure CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child38,
						"ScholarshipDetailPage_Bottom DB Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ScholarshipAP_DB_bottom();
				CTA.header_ScholsrhipDB();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_Scholarship();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child38, report);
		}
	}

	public void SA_Exampage_Rightside_ParentDG(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Download Guide CTA
		ExtentTest child39 = CommonFunctions.createChild(report,
				"SA_Exampage_DownloadGuide CTA",
				"Test Case ExamPage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child39);
			driver.get(finalUrl);

			// // DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child39,
						"ExamPage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_DownloadGuide();
				CTA.header_DownloadGuide();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child39, report);
		}
	}

	public void SA_Exampage_Rightside_ParentDG_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Download Guide CTA
		ExtentTest child40 = CommonFunctions.createChild(report,
				"SA_Exampage_DownloadGuide CTA",
				"Test Case ExamPage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child40);
			driver.get(finalUrl);

			// // DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child40,
						"ExamPage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_DownloadGuide();
				CTA.header_DownloadGuide();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child40, report);
		}
	}

	public void SA_Exampage_Comment(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Comment section CTA
		ExtentTest child41 = CommonFunctions.createChild(report,
				"SA_Exampage_Comment CTA",
				"Test Case ExamPage_CommentSection CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child41);
			driver.get(finalUrl);

			// //CommentSection CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child41,
						"ExamPage_CommentSection Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_Comment(ExcelReader.getData(i, "Comment",
						"Registeration"));
				CTA.header_Comment();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child41, report);
		}
	}

	public void SA_Exampage_Comment_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Comment section CTA
		ExtentTest child42 = CommonFunctions.createChild(report,
				"SA_Exampage_Comment CTA",
				"Test Case ExamPage_CommentSection CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child42);
			driver.get(finalUrl);

			// //CommentSection CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child42,
						"ExamPage_CommentSection Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_Comment(ExcelReader.getData(i, "Comment",
						"Registeration"));
				CTA.header_Comment();
				CTA.planradiobutton();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child42, report);
		}
	}

	public void SA_ApplyContent_DownloadGuide(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "sop-statement-of-purpose-applycontent1701";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "sop-statement-of-purpose-applycontent1701";
		}

		// // Apply Content Page download guide right widget
		ExtentTest child43 = CommonFunctions.createChild(report,
				"SA_ApplyContent_DownloadGuide CTA",
				"Test Case SA_ApplyContent_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child43);
			driver.get(finalUrl);

			// //Right side DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child43,
						"SA_ApplyContent_DownloadGuide Test Casefor iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Applycontent_DownloadGuide();
				CTA.header_DownloadGuide();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.bookedexamdate();
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
			    CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child43, report);
		}
	}

	public void SA_ApplyContent_DownloadGuide_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "sop-statement-of-purpose-applycontent1701";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "sop-statement-of-purpose-applycontent1701";
		}

		// // Apply Content Page download guide right widget
		ExtentTest child44 = CommonFunctions.createChild(report,
				"SA_ApplyContent_DownloadGuide CTA",
				"Test Case SA_ApplyContent_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child44);
			driver.get(finalUrl);

			// //Right side DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child44,
						"SA_ApplyContent_DownloadGuide Test Casefor iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Applycontent_DownloadGuide();
				CTA.header_DownloadGuide();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child44, report);
		}
	}

	public void SA_ApplyContent_DG_belly(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "sop-statement-of-purpose-applycontent1701";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "sop-statement-of-purpose-applycontent1701";
		}

		// // Apply Content Page download guide belly
		ExtentTest child45 = CommonFunctions.createChild(report,
				"SA_ApplyContent_DG_belly CTA",
				"Test Case SA_ApplyContent_DG_belly CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child45);
			driver.get(finalUrl);

			// //belly DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child45,
						"SA_ApplyContent_DG_belly Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Applycontent_DownloadGuideBelly();
				CTA.header_DownloadGuide();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child45, report);
		}
	}

	public void SA_ApplyContent_DG_belly_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "sop-statement-of-purpose-applycontent1701";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "sop-statement-of-purpose-applycontent1701";
		}

		// // Apply Content Page download guide belly
		ExtentTest child46 = CommonFunctions.createChild(report,
				"SA_ApplyContent_DG_belly CTA",
				"Test Case SA_ApplyContent_DG_belly CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child46);
			driver.get(finalUrl);

			// //belly DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child46,
						"SA_ApplyContent_DG_belly Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Applycontent_DownloadGuideBelly();
				CTA.header_DownloadGuide();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child46, report);
		}
	}

	public void SA_ApplyContent_Comment(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "sop-statement-of-purpose-applycontent1701";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "sop-statement-of-purpose-applycontent1701";
		}

		// // Apply Content Page Comment section
		ExtentTest child47 = CommonFunctions.createChild(report,
				"SA_ApplyContent_Comment CTA",
				"Test Case SA_ApplyContent_Comment CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child47);
			driver.get(finalUrl);

			// //Comment section in loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child47,
						"SA_ApplyContent_Comment Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ApplyContentPage_Comment(ExcelReader.getData(i, "Comment",
						"Registeration"));
				CTA.header_Comment();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child47, report);
		}
	}

	public void SA_ApplyContent_Comment_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "sop-statement-of-purpose-applycontent1701";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "sop-statement-of-purpose-applycontent1701";
		}

		// // Apply Content Page Comment section
		ExtentTest child48 = CommonFunctions.createChild(report,
				"SA_ApplyContent_Comment CTA",
				"Test Case SA_ApplyContent_Comment CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child48);
			driver.get(finalUrl);

			// //Comment section in loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child48,
						"SA_ApplyContent_Comment Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.ApplyContentPage_Comment(ExcelReader.getData(i, "Comment",
						"Registeration"));
				CTA.header_Comment();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child48, report);
		}
	}

	public void SA_ArticlePage_Comment(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "top-courses-in-new-zealand-articlepage-192";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "top-courses-in-new-zealand-articlepage-192";
		}

		// // Article Page Comment section
		ExtentTest child49 = CommonFunctions.createChild(report,
				"SA_ArticlePage_Comment CTA",
				"Test Case SA_ArticlePage_Comment CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child49);
			driver.get(finalUrl);

			// //Comment section in loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child49,
						"SA_ArticlePage_Comment Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ArticlePage_Comment(ExcelReader.getData(i, "Comment",
						"Registeration"));
				CTA.header_Comment();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child49, report);
		}
	}

	public void SA_ArticlePage_Comment_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "top-courses-in-new-zealand-articlepage-192";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "top-courses-in-new-zealand-articlepage-192";
		}

		// // Article Page Comment section
		ExtentTest child50 = CommonFunctions.createChild(report,
				"SA_ArticlePage_Comment CTA",
				"Test Case SA_ArticlePage_Comment CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child50);
			driver.get(finalUrl);

			// //Comment section in loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child50,
						"SA_ArticlePage_Comment Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ArticlePage_Comment(ExcelReader.getData(i, "Comment",
						"Registeration"));
				CTA.header_Comment();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child50, report);
		}
	}

	public void SA_GuidePage_DGRightSide_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		// // Guide Page Download Guide CTA at right side widget
		ExtentTest child51 = CommonFunctions.createChild(report,
				"SA_GuidePage_DGRightSide CTA",
				"Test Case SA_GuidePage_DGRightSide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child51);
			driver.get(finalUrl);

			// //Right Side bar Download Guide CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child51,
						"SA_GuidePage_DGRightSide Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.GuidePage_DownloadGuide_right();
				CTA.header_DownloadGuide();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child51, report);
		}
	}

	public void SA_GuidePage_DGRightSide(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		// // Guide Page Download Guide CTA at right side widget
		ExtentTest child52 = CommonFunctions.createChild(report,
				"SA_GuidePage_DGRightSide CTA",
				"Test Case SA_GuidePage_DGRightSide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child52);
			driver.get(finalUrl);

			// //Right Side bar Download Guide CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child52,
						"SA_GuidePage_DGRightSide Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.GuidePage_DownloadGuide_right();
				CTA.header_DownloadGuide();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
			    CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child52, report);
		}
	}

	public void SA_GuidePage_DGBelly(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		// // Guide Page Download Guide CTA belly
		ExtentTest child53 = CommonFunctions.createChild(report,
				"SA_GuidePage_DGBelly CTA",
				"Test Case SA_GuidePage_DGBelly CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child53);
			driver.get(finalUrl);

			// //Belly Download Guide CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child53,
						"SA_GuidePage_DGBelly Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GuidePage_DownloadGuide_belly();
				CTA.header_DownloadGuide();

				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child53, report);
		}
	}

	public void SA_GuidePage_DGBelly_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		// // Guide Page Download Guide CTA belly
		ExtentTest child54 = CommonFunctions.createChild(report,
				"SA_GuidePage_DGBelly CTA",
				"Test Case SA_GuidePage_DGBelly CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child54);
			driver.get(finalUrl);

			// //Belly Download Guide CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child54,
						"SA_GuidePage_DGBelly Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GuidePage_DownloadGuide_belly();
				CTA.header_DownloadGuide();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child54, report);
		}
	}

	public void SA_GuidePage_Comment(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		// // Guide Page Comment section CTA
		ExtentTest child55 = CommonFunctions.createChild(report,
				"SA_GuidePage_Comment CTA",
				"Test Case SA_GuidePage_Comment CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child55);
			driver.get(finalUrl);

			// //Comment section CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child55,
						"SA_GuidePage_Comment Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GuidePage_Comment(ExcelReader.getData(i, "Comment",
						"Registeration"));
				CTA.header_Comment();

				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child55, report);
		}
	}

	public void SA_GuidePage_Comment_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "student-guide-to-the-united-states-of-america-usa-guidepage-15";
		}

		// // Guide Page Comment section CTA
		ExtentTest child56 = CommonFunctions.createChild(report,
				"SA_GuidePage_Comment CTA",
				"Test Case SA_GuidePage_Comment CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child56);
			driver.get(finalUrl);

			// //Comment section CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child56,
						"SA_GuidePage_Comment Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GuidePage_Comment(ExcelReader.getData(i, "Comment",
						"Registeration"));
				CTA.header_Comment();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child56, report);
		}
	}

	public void SA_CourseRanking_DB(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "top-mba-colleges-in-usa-abroadranking30";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "top-mba-colleges-in-usa-abroadranking30";
		}

		// // Course Ranking Page DB CTA
		ExtentTest child57 = CommonFunctions.createChild(report,
				"SA_CourseRanking_DB CTA",
				"Test Case SA_CourseRanking_DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child57);
			driver.get(finalUrl);

			// //Download Brochure CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child57,
						"SA_CourseRanking_DB Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Ranking_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.planradiobutton();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child57, report);
		}
	}

	public void SA_CourseRanking_DB_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "top-mba-colleges-in-usa-abroadranking30";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "top-mba-colleges-in-usa-abroadranking30";
		}

		// // Course Ranking Page DB CTA
		ExtentTest child58 = CommonFunctions.createChild(report,
				"SA_CourseRanking_DB CTA",
				"Test Case SA_CourseRanking_DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child58);
			driver.get(finalUrl);

			// //Download Brochure CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child58,
						"SA_CourseRanking_DB Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Ranking_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child58, report);
		}
	}

	public void SA_UniversityRanking_DB(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "top-universities-in-abroad-abroadranking32";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "top-universities-in-abroad-abroadranking32";
		}

		// // University Ranking Page DB CTA
		ExtentTest child59 = CommonFunctions.createChild(report,
				"SA_UniversityRanking_DB CTA",
				"Test Case SA_UniversityRanking_DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child59);
			driver.get(finalUrl);

			// //Download Brochure CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child59,
						"SA_UniversityRanking_DB for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Ranking_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.planradiobutton();
				CTA.selectCourse();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child59, report);
		}
	}

	public void SA_UniversityRanking_DB_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "top-universities-in-abroad-abroadranking32";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "top-universities-in-abroad-abroadranking32";
		}

		// // University Ranking Page DB CTA
		ExtentTest child60 = CommonFunctions.createChild(report,
				"SA_UniversityRanking_DB CTA",
				"Test Case SA_UniversityRanking_DB CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child60);
			driver.get(finalUrl);

			// //Download Brochure CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child60,
						"SA_UniversityRanking_DB for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Ranking_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.selectCourse();
				CTA.SignUp();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child60, report);
		}
	}

	public void SA_DHL_TOP(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply/shipment";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply/shipment";
		}

		// // DHL Page Book Your Pickup CTA Top CTA
		ExtentTest child61 = CommonFunctions.createChild(report,
				"SA_DHL_TOP CTA", "Test Case SA_DHL_TOP CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child61);
			driver.get(finalUrl);

			// //Book Your Pickup CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child61,
						"SA_DHL_TOP Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Book_Pickup1();
				CTA.header_Signup();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton__Masters();
				CTA.bookedexamdate();
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.DHL_Page();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child61, report);
		}
	}

	public void SA_DHL_TOP_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply/shipment";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply/shipment";
		}

		// // DHL Page Book Your Pickup CTA Top CTA
		ExtentTest child62 = CommonFunctions.createChild(report,
				"SA_DHL_TOP CTA", "Test Case SA_DHL_TOP CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child62);
			driver.get(finalUrl);

			// //Book Your Pickup CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child62,
						"SA_DHL_TOP Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Book_Pickup1();
				CTA.header_Signup();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.DHL_Page();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child62, report);
		}
	}

	public void SA_DHL_Bottom(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply/shipment";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply/shipment";
		}

		// // DHL Page Book Your Pickup CTA Bottom CTA
		ExtentTest child63 = CommonFunctions.createChild(report,
				"SA_DHL_Bottom CTA", "Test Case SA_DHL_Bottom CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child63);
			driver.get(finalUrl);

			// //Book Your Pickup CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child63,
						"SA_DHL_Bottom Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Book_Pickup2();
				CTA.header_Signup();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.DHL_Page();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child63, report);
		}
	}

	public void SA_DHL_Bottom_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply/shipment";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply/shipment";
		}

		// // DHL Page Book Your Pickup CTA Bottom CTA
		ExtentTest child64 = CommonFunctions.createChild(report,
				"SA_DHL_Bottom CTA", "Test Case SA_DHL_Bottom CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child64);
			driver.get(finalUrl);

			// //Book Your Pickup CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child64,
						"SA_DHL_Bottom Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Book_Pickup2();
				CTA.header_Signup();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.DHL_Page();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child64, report);
		}
	}

	public void SA_ComparePage_Signup(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "comparepage-195580-196231";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "comparepage-195580-196231";
		}
		// // Compare Page Signup CTA
		ExtentTest child65 = CommonFunctions.createChild(report,
				"SA_ComparePage_Signup CTA",
				"Test Case SA_ComparePage_Signup CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child65);
			driver.get(finalUrl);

			// //Signup CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child65,
						"SA_ComparePage_Signup Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Addcourse();
				CTA.header_Compare();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child65, report);
		}
	}

	public void SA_ComparePage_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "comparepage-195580-196231";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "comparepage-195580-196231";
		}
		// // Compare Page Signup CTA
		ExtentTest child66 = CommonFunctions.createChild(report,
				"SA_ComparePage_Signup CTA",
				"Test Case SA_ComparePage_Signup CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child66);
			driver.get(finalUrl);

			// //Signup CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child66,
						"SA_ComparePage_Signup Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Addcourse();
				CTA.header_Compare();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child66, report);
		}
	}

	public void SA_ApplyGAFPEC_Top(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply";
		}

		// // Apply Page GAFPEC CTA
		ExtentTest child67 = CommonFunctions.createChild(report,
				"SA_ApplyGAFPEC_Top CTA",
				"Test Case SA_ApplyGAFPEC_Top CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child67);
			driver.get(finalUrl);

			// // GAFPEC CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child67,
						"SA_ApplyGAFPEC_Top Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GAFPEC();
				CTA.GAFPEC_Proceed();
				CTA.header_Signup();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton__Masters();
				CTA.bookedexamdate();
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Examupload("D:\\GIT\\Qa-Automation\\src\\test\\resources\\brochure.pdf");
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child67, report);
		}
	}

	public void SA_ApplyGAFPEC_Top_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply";
		}

		// // Apply Page GAFPEC CTA
		ExtentTest child68 = CommonFunctions.createChild(report,
				"SA_ApplyGAFPEC_Top CTA",
				"Test Case SA_ApplyGAFPEC_Top CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child68);
			driver.get(finalUrl);

			// // GAFPEC CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child68,
						"SA_ApplyGAFPEC_Top Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GAFPEC();
				CTA.GAFPEC_Proceed();
				CTA.header_Signup();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Examupload("D:\\GIT\\Qa-Automation\\src\\test\\resources\\brochure.pdf");
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child68, report);
		}
	}

	public void SA_ApplyGAFPEC_Middle(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply";
		}

		// // Apply Page GAFPEC Overlay CTA
		ExtentTest child69 = CommonFunctions.createChild(report,
				"SA_ApplyGAFPEC_Overlay CTA",
				"Test Case SA_ApplyGAFPEC_Overlay CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child69);
			driver.get(finalUrl);

			// // GAFPEC Overlay CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child69,
						"SA_ApplyGAFPEC_Overlay Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GAFPEC_Middle();
				CTA.GAFPEC_Proceed();
				CTA.header_Signup();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton__Masters();
				CTA.bookedexamdate();
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Examupload("D:\\GIT\\Qa-Automation\\src\\test\\resources\\brochure.pdf");
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child69, report);
		}
	}

	public void SA_ApplyGAFPEC_Middle_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply";
		}

		// // Apply Page GAFPEC Overlay CTA
		ExtentTest child70 = CommonFunctions.createChild(report,
				"SA_ApplyGAFPEC_Overlay CTA",
				"Test Case SA_ApplyGAFPEC_Overlay CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child70);
			driver.get(finalUrl);

			// // GAFPEC Overlay CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child70,
						"SA_ApplyGAFPEC_Overlay Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GAFPEC_Middle();
				CTA.GAFPEC_Proceed();
				CTA.header_Signup();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Examupload("D:\\GIT\\Qa-Automation\\src\\test\\resources\\brochure.pdf");
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child70, report);
		}
	}

	public void SA_ApplyGAFPEC_Bottom(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply";
		}

		// // Apply Page GAFPEC Overlay CTA
		ExtentTest child71 = CommonFunctions.createChild(report,
				"SA_ApplyGAFPEC_Overlay CTA",
				"Test Case SA_ApplyGAFPEC_Overlay CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child71);
			driver.get(finalUrl);

			// // GAFPEC Overlay CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child71,
						"SA_ApplyGAFPEC_Overlay Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GAFPEC_Bottom();
				CTA.GAFPEC_Proceed();
				CTA.header_Signup();
				CTA.planradiobutton();
				CTA.countries_3();
				CTA.levelradiobutton__Masters();
				CTA.bookedexamdate();
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Examupload("D:\\GIT\\Qa-Automation\\src\\test\\resources\\brochure.pdf");
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child71, report);
		}
	}

	public void SA_ApplyGAFPEC_Bottom_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "apply";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "apply";
		}

		// // Apply Page GAFPEC Overlay CTA
		ExtentTest child72 = CommonFunctions.createChild(report,
				"SA_ApplyGAFPEC_Overlay CTA",
				"Test Case SA_ApplyGAFPEC_Overlay CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child72);
			driver.get(finalUrl);

			// // GAFPEC Overlay CTA in LoggedOut state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child72,
						"SA_ApplyGAFPEC_Overlay Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.GAFPEC_Bottom();
				CTA.GAFPEC_Proceed();
				CTA.header_Signup();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Examupload("D:\\GIT\\Qa-Automation\\src\\test\\resources\\brochure.pdf");
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child72, report);
		}
	}

	public void SA_UniversitySearchPage_DownloadBrochure(Objects obj)
			throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=harvard&u[]=100&qer=yes&tid=474427&ref=homePage";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=harvard&u[]=100&qer=yes&tid=474427&ref=homePage";
		}

		// // University Search Page Download Brochure CTA
		ExtentTest child73 = CommonFunctions
				.createChild(report,
						"SA_UniversitySearchPage_DownloadBrochure CTA",
						"Test Case SA_UniversitySearchPage_DownloadBrochure CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child73);
			driver.get(finalUrl);

			// //DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child73,
						"SA_UniversitySearchPage_DownloadBrochure Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.UniversitySearchPage_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.planradiobutton();
				CTA.selectCourse();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child73, report);

		}
	}

	public void SA_UniversitySearchPage_DownloadBrochure_LoggedIn(Objects obj)
			throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=harvard&u[]=100&qer=yes&tid=474427&ref=homePage";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=harvard&u[]=100&qer=yes&tid=474427&ref=homePage";
		}

		// // University Search Page Download Brochure CTA
		ExtentTest child74 = CommonFunctions
				.createChild(report,
						"SA_UniversitySearchPage_DownloadBrochure CTA",
						"Test Case SA_UniversitySearchPage_DownloadBrochure CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child74);
			driver.get(finalUrl);

			// //DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child74,
						"SA_UniversitySearchPage_DownloadBrochure Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.UniversitySearchPage_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.selectCourse();
				CTA.SignUp();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child74, report);

		}
	}

	public void SA_CourseSearchPage_DownloadBrochure(Objects obj)
			throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site

		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
			;
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		// // Search Page Download Brochure CTA
		ExtentTest child75 = CommonFunctions.createChild(report,
				"DownloadBrochure CTA",
				"Test Case SA_SearchPage_DownloadBrochure CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child75);
			driver.get(finalUrl);

			// //DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child75,
						"SA_SearchPage_DownloadBrochure CTA Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.SearchPage_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.planradiobutton();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child75, report);

		}
	}

	public void SA_CourseSearchPage_DownloadBrochure_LoggedIn(Objects obj)
			throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site

		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
			;
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		// // Search Page Download Brochure CTA
		ExtentTest child76 = CommonFunctions.createChild(report,
				"DownloadBrochure CTA",
				"Test Case SA_SearchPage_DownloadBrochure CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child76);
			driver.get(finalUrl);

			// //DownloadBrochure CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child76,
						"SA_SearchPage_DownloadBrochure CTA Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.SearchPage_DownloadBrochure();
				CTA.header_DownloadBrochure();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child76, report);

		}
	}

	public void SA_CourseSearchPage_RMC(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site

		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		// // Search Page RMC CTA
		ExtentTest child78 = CommonFunctions.createChild(report, "RMC CTA",
				"Test Case SA_SearchPage_RMC CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child78);
			driver.get(finalUrl);

			// //RMC CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child78,
						"SA_SearchPage_RMC CTA Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.SearchPage_RMC();
				CTA.header_RateMyChance();
				CTA.planradiobutton();
				CTA.examselectionNO();
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp_RMC();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child78, report);

		}

	}

	public void SA_CourseSearchPage_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		// // Search Page Shortlist CTA
		ExtentTest child79 = CommonFunctions.createChild(report,
				"Shortlist CTA",
				"Test Case SA_SearchPage_Shortlist CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child79);
			driver.get(finalUrl);

			// //Shortlist CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child79,
						"SA_SearchPage_Shortlist Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Searchpage_shortlist();
				CTA.header_Shortlist();
				CTA.planradiobutton();
				CTA.levelradiobutton_Bachelors();
				CTA.examselectionNO();
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child79, report);

		}

	}

	public void SA_CourseSearchPage_Shortlist_LoggedIn(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		// // Search Page Shortlist CTA
		ExtentTest child80 = CommonFunctions.createChild(report,
				"Shortlist CTA",
				"Test Case SA_SearchPage_Shortlist CTA Started");

		try {
			CTA = new SA_CTA_Desktop_Object(driver, child80);
			driver.get(finalUrl);

			// //Shortlist CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child80,
						"SA_SearchPage_Shortlist Test Case for iteration : "
								+ i + " with url : " + "<br/> " + finalUrl);
				CTA.Searchpage_shortlist();
				CTA.header_Shortlist();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child80, report);

		}

	}

	public void SA_CourseSearchPage_Compare(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site

		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}
		// // Search Page Compare CTA
		ExtentTest child81 = CommonFunctions.createChild(report, "Compare CTA",
				"Test Case SA_SearchPage_Compare CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child81);
			driver.get(finalUrl);

			// // Compare CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child81,
						"SA_SearchPage_Compare Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Searchpage_compare();
				CTA.Compare2();
				CTA.Compare();
				CTA.header_Compare();
				CTA.planradiobutton();
				CTA.countries();
				CTA.levelradiobutton_Bachelors();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child81, report);
		}

	}

	public void SA_CourseSearchPage_Compare_loggedIn(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// // URL to abroad site

		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad."
					+ uuu
					+ "search-abroad/?q=management&c[]=239&qer=yes&tid=1034033&ref=searchPage";
		}
		// // Search Page Compare CTA
		ExtentTest child82 = CommonFunctions.createChild(report, "Compare CTA",
				"Test Case SA_SearchPage_Compare CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child82);
			driver.get(finalUrl);

			// // Compare CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child82,
						"SA_SearchPage_Compare Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.Searchpage_compare();
				CTA.Compare2();
				CTA.Compare();
				CTA.header_Compare();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child82, report);
		}

	}
	
	public void SA_Exampage_Rightside_childDG(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Download Guide CTA
		ExtentTest child83 = CommonFunctions.createChild(report,
				"SA_Exampage_DownloadGuide CTA",
				"Test Case ExamPage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child83);
			driver.get(finalUrl);

			// // DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child83,
						"ExamPage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_childDownloadGuide();
				CTA.header_DownloadGuide();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child83, report);
		}
	}

	public void SA_Exampage_Rightside_childDG_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Download Guide CTA
		ExtentTest child84 = CommonFunctions.createChild(report,
				"SA_Exampage_DownloadGuide CTA",
				"Test Case ExamPage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child84);
			driver.get(finalUrl);

			// // DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child84,
						"ExamPage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_childDownloadGuide();
				CTA.header_DownloadGuide();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child84, report);
		}
	}
	
	public void SA_Exampage_Inline_childDG(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Download Guide CTA
		ExtentTest child83 = CommonFunctions.createChild(report,
				"SA_Exampage_DownloadGuide CTA",
				"Test Case ExamPage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child83);
			driver.get(finalUrl);

			// // DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child83,
						"ExamPage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_childDownloadGuideInline();
				CTA.header_DownloadGuide();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child83, report);
		}
	}

	public void SA_Exampage_Inline_childDG_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Download Guide CTA
		ExtentTest child84 = CommonFunctions.createChild(report,
				"SA_Exampage_DownloadGuide CTA",
				"Test Case ExamPage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child84);
			driver.get(finalUrl);

			// // DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child84,
						"ExamPage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_childDownloadGuideInline();
				CTA.header_DownloadGuide();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child84, report);
		}
	}

	
	public void SA_Exampage_Inline_parentDG(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Download Guide CTA
		ExtentTest child83 = CommonFunctions.createChild(report,
				"SA_Exampage_DownloadGuide CTA",
				"Test Case ExamPage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child83);
			driver.get(finalUrl);

			// // DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child83,
						"ExamPage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_parentDownloadGuideInline();
				CTA.header_DownloadGuide();
				CTA.planradiobutton();
				CTA.countries_2();
				CTA.levelradiobutton__Masters();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.MasterDetails();
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.number(mobilenumber);
				CTA.SignUp_DG();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child83, report);
		}
	}

	public void SA_Exampage_Inline_parentDG_LoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/" + "exams/ielts";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu + "exams/ielts";
		}

		// // Exam Page Download Guide CTA
		ExtentTest child84 = CommonFunctions.createChild(report,
				"SA_Exampage_DownloadGuide CTA",
				"Test Case ExamPage_DownloadGuide CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child84);
			driver.get(finalUrl);

			// // DownloadGuide CTA in Loggedout state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child84,
						"ExamPage_DownloadGuide Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.ExamPage_parentDownloadGuideInline();
				CTA.header_DownloadGuide();
				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.Logoclick();
				CTA.Logout();
			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child84, report);
		}
	}

	
	public void SA_AlluniversityCountryPage__DB(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "usa/universities";
		}

		// //UniversityPage EmailMe CTA
		ExtentTest child23 = CommonFunctions.createChild(report, "email CTA",
				"Test Case UniversityPage_EmailMe CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child23);
			driver.get(finalUrl);

			// //EmailMe CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child23,
						"UniversityPage_EmailMe Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.SA_AlluniversityCountryPage__DB();
				CTA.header_DownloadBrochure();
				CTA.planradiobutton();
				CTA.selectCourse();
				CTA.examscore(ExcelReader.getData(i, "Examscore",
						"Registeration"));
				CTA.Bachelors_Deatils(ExcelReader.getData(i, "SchoolName",
						"Registeration"));
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration"));
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.International_number(mobilenumber);
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child23, report);
		}

	}

	public void SA_AlluniversityCountryPage__DBLoggedIn(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		// //URL to abroad site
		if (obj.getdbUserName().length() == 0) {
			finalUrl = "https://studyabroad.shiksha.com/"
					+ "usa/universities";
		}

		else {
			String str = url;
			int index = str.indexOf("//") + 2;
			String uuu = str.substring(index);
			finalUrl = "https://studyabroad." + uuu
					+ "usa/universities";
		}

		// //UniversityPage EmailMe CTA
		ExtentTest child24 = CommonFunctions.createChild(report, "email CTA",
				"Test Case UniversityPage_EmailMe CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child24);
			driver.get(finalUrl);

			// //EmailMe CTA in LoggedIn state
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child24,
						"UniversityPage_EmailMe Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.SA_AlluniversityCountryPage__DB();
				CTA.header_DownloadBrochure();

				CTA.already_registered();

				Set<String> ids = driver.getWindowHandles();
				Iterator<String> it = ids.iterator();
				@SuppressWarnings("unused")
				String parentid = it.next();
				String childid = it.next();
				driver.switchTo().window(childid);

				CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
				CTA.password(ExcelReader
						.getData(i, "Password", "Registeration"));
				CTA.login_submit();
				CTA.selectCourse();
				WebElement myElement = driver.findElement(FetchData
						.readOR("SignUp"));
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView();", myElement);
				CTA.SignUp();
				CTA.Thankyoupage();
				CTA.Logoclick();
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child24, report);
		}

	}
}
