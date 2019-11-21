package com.shiksha.test;


import java.util.HashMap;

import org.openqa.selenium.WebDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.SA_CTA_Desktop_Object;

import com.shiksha.object.SA_GNB_Footer;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.ExcelReader;
import com.shiksha.resourses.GenericFunction;


public class SA_HomePage_Desktop {

	SA_CTA_Desktop_Object CTA = null;
	public String finalUrl = "";
	CommonFunctions CommonFunctions = new CommonFunctions();
	
	public void SA_HomePage_SignUp(Objects obj) {

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

		// // Home Page TopSignup CTA
		ExtentTest child17 = CommonFunctions.createChild(report,
				"Top Signup CTA", "Test Case HomePage_TopSignup CTA Started");

		try {

			CTA = new SA_CTA_Desktop_Object(driver, child17);
			driver.get(finalUrl);

			// //TopSignup CTA
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child17,
						"HomePage_TopSignup Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.clickSignUp();
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
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child17, report);
		}
		
	}
		public void SA_HomePage_TopLogin(Objects obj) {

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

			// // Home Page TopLogin CTA
			ExtentTest child20 = CommonFunctions.createChild(report,
					"TopLogin CTA", "Test Case HomePage_TopLogin CTA Started");

			try {

				CTA = new SA_CTA_Desktop_Object(driver, child20);
				driver.get(finalUrl);

				// //TopLogin CTA
				for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
					CommonFunctions.info(child20,
							"HomePage_TopLogin Test Case for iteration : " + i
									+ " with url : " + "<br/> " + finalUrl);
					CTA.logIn();
					CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
					CTA.password(ExcelReader
							.getData(i, "Password", "Registeration"));
					CTA.login_submit();
					CTA.Logout();

				}
			} catch (Exception e) {
			} finally {
				CommonFunctions.closeChild(parent, child20, report);
			}

		}
		public void SA_Footer_Links(Objects obj) throws Exception {

			WebDriver driver = obj.getDriver();
			String xls = "//Desktop//SA_Footer_Links";

			String url = obj.getURL();
			GenericFunction per = new GenericFunction(driver);
			
			com.aventstack.extentreports.ExtentTest parent=obj.getNewParent();

			CommonFunctions cm = new CommonFunctions();
			url = cm.studyAbroadUrl(url);
			driver.get(url);
			SA_GNB_Footer page = new SA_GNB_Footer(driver);

			try {

				for (int i = 1; i <= ExcelReader.getRows(xls); i++) {
					try {

						String curl = "";
						String data = ExcelReader.genericReadData(xls, i, "Footer name");
						String lnk = ExcelReader.genericReadData(xls, i, "Footer Links");
						System.out.println(data + "------>" + lnk);
						String input = ExcelReader.genericReadData(xls, i, "Input type");
						com.aventstack.extentreports.ExtentTest child = per.createChild(parent, data);
						per.childInfo(child, url);
						if (input.equalsIgnoreCase("Link")) {
							curl = per.toRelativeURL(page.click_SA_Footer(data, child));

							lnk = per.toRelativeURL(lnk);
							per.childInfo(child, "Expected url: " + lnk + "<br> Actual Url: " + curl);
							if (curl.equalsIgnoreCase(lnk))
								per.childPass(child, "url validated successfully");
							else
								per.childFail(child, "Failed to verify url");
						} else {
							if (lnk.equalsIgnoreCase(" For Advertising/Sales Enquiries ")) {
								page.click_Enterprise_Login(lnk, child);
							} else if (page.is_contactus_Footer_Available(lnk))
								per.childPass(child, data + " info is available: " + lnk);
							else
								per.childFail(child, data + " info is not available: " + lnk);
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		

		}

		public void SA_GNB_Links(Objects obj) throws Exception {

			WebDriver driver = obj.getDriver();
			String xls = "//Desktop//SA_GNB";
			SA_GNB_Footer page = new SA_GNB_Footer(driver);
			String url = obj.getURL();
			CommonFunctions cm = new CommonFunctions();
			url = cm.studyAbroadUrl(url);
			GenericFunction per = new GenericFunction(driver);
			
			com.aventstack.extentreports.ExtentTest parent=obj.getNewParent();

			HashMap<String, HashMap<String, Integer>> index = new HashMap<String, HashMap<String, Integer>>();
			
			try {
				for (int i = 1; i <= ExcelReader.getRows(xls); i++) {
					try {
						driver.get(url);
						String lvl1 = ExcelReader.genericReadData(xls, i, "Lvl1");
						
						String lnk = ExcelReader.genericReadData(xls, i, "Link");
						String lvl2 = ExcelReader.genericReadData(xls, i, "Lvl2");
						String lvl3 = ExcelReader.genericReadData(xls, i, "Lvl3");
						int siz = 1;
						com.aventstack.extentreports.ExtentTest child = per.createChild(parent,
								lvl1 + "<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + lvl3);
						per.childInfo(child, url);
						per.childInfo(child, "<b>Dataset</b><br>Level 1 : " + lvl1 + "<br>Level 2 : " + lvl2
								+ "<br>Level 3 : " + lvl3 + "<br>Expected Url : " + per.toRelativeURL(lnk));
						if (index.containsKey(lvl1)) {
							HashMap<String, Integer> in = index.get(lvl1);
							if (in.containsKey(lvl3)) {
								int getint = in.get(lvl3) + 1;
								siz = getint;
								in.put(lvl3, getint);
							} else {
								in.put(lvl3, 1);
							}
						} else {
							HashMap<String, Integer> in = new HashMap<String, Integer>();
							in.put(lvl3, 1);
							index.put(lvl1, in);
						}
						
						page.hover_Lvl1_GNB(lvl1,child);
						String curl = per.toRelativeURL(page.get_Link(lvl3, siz,child));
						
						System.out.println(curl);
						lnk = per.toRelativeURL(lnk);
						per.childInfo(child, "Expected Url : "+lnk+"<br>Obtained Url : "+curl);
						if (lnk.equalsIgnoreCase(curl))
							per.childPass(child, "Url validated successfully");
						else
							per.childFail(child, "Fail to validate url");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}
