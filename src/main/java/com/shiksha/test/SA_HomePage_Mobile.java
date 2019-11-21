package com.shiksha.test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.SA_CTA_Mobile_Object;
import com.shiksha.object.SA_GNB_Footer;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.ExcelReader;
import com.shiksha.resourses.GenericFunction;

public class SA_HomePage_Mobile {
	
	SA_CTA_Mobile_Object CTA = null;
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
		ExtentTest child1 = CommonFunctions.createChild(report,
				"Top Signup CTA", "Test Case HomePage_TopSignup CTA Started");

		try {

			CTA = new SA_CTA_Mobile_Object(driver, child1);
			driver.get(finalUrl);

			// //TopSignup CTA
			for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
				CommonFunctions.info(child1,
						"HomePage_TopSignup Test Case for iteration : " + i
								+ " with url : " + "<br/> " + finalUrl);
				CTA.clickSignUp();
				CTA.header_Signup();
				String mobilenumber = ExcelReader.getData(i, "MobNumber",
						"Registeration");
				CTA.PersonalInfo_Section(
						ExcelReader.getData(i, "Firstname", "Registeration"),
						ExcelReader.getData(i, "Lastname", "Registeration") , (mobilenumber)) ;
				CTA.planradiobutton();
				CTA.City();
				CTA.countries();
				CTA.Courseselection();
				CTA.MasterDetails();
				CTA.bookedexamdate();
				CTA.SignUp();
				CTA.OTPVerification_Abroad(driver, obj, mobilenumber);
				CTA.Logout();

			}
		} catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child1, report);
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
			ExtentTest child2 = CommonFunctions.createChild(report,
					"TopLogin CTA", "Test Case HomePage_TopLogin CTA Started");

			try {

				CTA = new SA_CTA_Mobile_Object(driver, child2);
				driver.get(finalUrl);

				// //TopLogin CTA
				for (int i = 0; i < ExcelReader.getRows("Registeration"); i++) {
					CommonFunctions.info(child2,
							"HomePage_TopLogin Test Case for iteration : " + i
									+ " with url : " + "<br/> " + finalUrl);
					CTA.clickSignUp();
					CTA.logIn();
					CTA.emailid(ExcelReader.getData(i, "EmailID", "Registeration"));
					CTA.password(ExcelReader
							.getData(i, "Password", "Registeration"));
					CTA.login_submit();
					CTA.Logout();

				}
			} catch (Exception e) {
			} finally {
				CommonFunctions.closeChild(parent, child2, report);
			}

		}

		public void SA_Footer_Links_Mobile(Objects obj) throws Exception {
			WebDriver driver = obj.getDriver();
			GenericFunction per = new GenericFunction(driver);

			String xls = "//Mobile//SA_Footer_Links_Mobile";
			
			com.aventstack.extentreports.ExtentTest parent = obj.getNewParent();
			String url = obj.getURL();

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
						String lvl1 = ExcelReader.genericReadData(xls, i, "Lvl1");
						String Input = ExcelReader.genericReadData(xls, i, "Input type");
						com.aventstack.extentreports.ExtentTest child = per.createChild(parent, data);
						per.childInfo(child, url);

						if (Input.equalsIgnoreCase("Link")) {
							lnk = per.toRelativeURL(lnk);
							page.click_Mobile_Lvl1_Footer(lvl1, child);
							curl = per.toRelativeURL(page.click_SA_Footer_Mobile(data, child));
							if (data.equalsIgnoreCase("Study in USA"))
								page.click_Logo();

							per.childInfo(child, "Expected url: " + lnk + "<br> Actual Url: " + curl);
							if (curl.equalsIgnoreCase(lnk))
								per.childPass(child, "url validated successfully");
							else
								per.childFail(child, "Failed to verify url");
						} else {
							page.click_Contact_Us_Mobile(data, lnk, child);

						}

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}

		public void GNB_Links(Objects obj) throws Exception {

			WebDriver driver = obj.getDriver();
			String xls = "//Mobile//SA_GNB";
			SA_GNB_Footer page = new SA_GNB_Footer(driver);
			String url = obj.getURL();
			CommonFunctions cm = new CommonFunctions();
			url = cm.studyAbroadUrl(url);
			driver.get(url);
			GenericFunction per = new GenericFunction(driver);
			
			com.aventstack.extentreports.ExtentTest parent =obj.getNewParent();
			HashMap<String, HashMap<String, Integer>> index = new HashMap<String, HashMap<String, Integer>>();
			try {
				Thread.sleep(2000);
				page.click_Hamburger_SA();
				Thread.sleep(1000);
				String prev_L1="";
				for (int i = 1; i <= ExcelReader.getRows(xls); i++) {
					try {
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
						page.click_Lvl1_GNB(lvl1,lvl2,prev_L1,siz,child);
						page.click_Lvl2_GNB(lvl2,lvl3,siz,child);
						
					String curl=page.get_GNB_Url(lvl3,siz,child);
					curl=per.toRelativeURL(curl);
					lnk=per.toRelativeURL(lnk);
						System.out.println("-------->"+curl);
						per.childInfo(child, "Expected Url : "+lnk+"<br>Obtained Url : "+curl);
						System.out.println("Lnk from excel----------->"+lnk);
						System.out.println("Current url ----------->"+curl);
						if (lnk.equalsIgnoreCase(curl))
						{
							
							System.out.println("Pass");
							per.childPass(child, "Url validated successfully");
						}
						else {
							System.out.println("Fail");
							per.childFail(child, "Fail to validate url");
						}
						prev_L1=lvl1;
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}


}
