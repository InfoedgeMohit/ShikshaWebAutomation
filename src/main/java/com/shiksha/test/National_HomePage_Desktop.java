package com.shiksha.test;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.Desktop_GNB;
import com.shiksha.object.Navigation_Desktop;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.ExcelReader;
import com.shiksha.resourses.GenericFunction;

public class National_HomePage_Desktop {
	WebDriver driver;
	CommonFunctions CommonFunctions = new CommonFunctions();
	Desktop_GNB gnb = null;

	@SuppressWarnings("unused")
	public void VaidateGNB(Objects obj) throws InterruptedException {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		ExtentTest child1 = CommonFunctions.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		CommonFunctions.info(child1, "\n Hamburger for Desktop GNB started for Url : " + url);

		String Layer1 = "";
		String Layer2 = "";
		String Layer3 = "";
		try {
			gnb = new Desktop_GNB(driver, child1);
			driver.get(url);
			List<WebElement> GNBLayer1 = gnb.GNB_Layer1_List();
			int i = 1;
			int a = GNBLayer1.size();
			for (WebElement webElement : GNBLayer1) {

				// // Layer 1 Name
				Layer1 = gnb.getElement(i);

				List<WebElement> GNBLayer2 = gnb.GNB_Layer2_List(i);

				int j = 1;
				for (WebElement webElement2 : GNBLayer2) {

					driver.get(url);

					// // Layer 2 mouse hover
					Layer2 = gnb.mouseHoverLevel2Click(i, j);

					// // Implement layer 2 mouse hover click
					System.out.print(Layer1 + "," + Layer2 + "," + driver.getCurrentUrl());
					CommonFunctions.info(child1, Layer1 + "," + Layer2 + "," + driver.getCurrentUrl());
					System.out.print("\n");
					/*
					 * if (gnb.verifyError1().equals("Fail") && gnb.verifyError2().equals("Fail") &&
					 * gnb.verifyLogo().equals("Pass")) { String key = Layer1 + "," + Layer2 + ",";
					 * String value = driver.getCurrentUrl(); value =
					 * value.substring(value.indexOf(".com") + 4); if
					 * (Variables.hamburgerSpcilization.get(key) .equalsIgnoreCase(value)) {
					 * CommonFunctions.pass(child1,Layer1 + "," + Layer2 + "," +
					 * driver.getCurrentUrl()); }
					 * 
					 * else { CommonFunctions.fail(child1,Layer1 + "," + Layer2 + "," +
					 * driver.getCurrentUrl()); }
					 * 
					 * } else { CommonFunctions.fail(child1,Layer1 + "," + Layer2 + "," +
					 * driver.getCurrentUrl()); }
					 */
					List<WebElement> GNBLayer3 = gnb.GNB_Layer3_List(i, j);

					int k = 1;
					for (WebElement webElement3 : GNBLayer3) {
						driver.get(url);
						// // Layer 3 mouse hover
						Layer3 = gnb.mouseHoverLevel3Click(i, j, k);
						Thread.sleep(1000);
						System.out.print(Layer1 + "," + Layer2 + "," + Layer3 + "," + driver.getCurrentUrl());
						CommonFunctions.info(child1,
								Layer1 + "," + Layer2 + "," + Layer3 + "," + driver.getCurrentUrl());
						System.out.print("\n");

						/*
						 * if (gnb.verifyError1().equals("Fail") && gnb.verifyError2().equals("Fail") &&
						 * gnb.verifyLogo().equals("Pass")) { String key1 = Layer1 + "," + Layer2 + ","
						 * + Layer3; String value1 = driver.getCurrentUrl(); value1 = value1
						 * .substring(value1.indexOf(".com") + 4); if
						 * (Variables.hamburgerSpcilization.get(key1) .equalsIgnoreCase(value1)) {
						 * CommonFunctions.pass(child1,Layer1 + "," + Layer2 + "," + Layer3 + "," +
						 * driver.getCurrentUrl());
						 * 
						 * }
						 * 
						 * else { CommonFunctions.fail(child1,Layer1 + "," + Layer2 + "," + Layer3 + ","
						 * + driver.getCurrentUrl()); } } else { CommonFunctions.fail(child1,Layer1 +
						 * "," + Layer2 + "," + driver.getCurrentUrl()); }
						 */
						k++;
					}
					Thread.sleep(1000);

					j++;
				}

				i++;
			}

			CommonFunctions.info(child1, "\n Hamburger for Desktop GNB Completed");

		}

		catch (Exception e) {
			CommonFunctions.info(child1, "\n Hamburger for Desktop GNB Failed");
		}

		finally {
			CommonFunctions.closeChild(parent, child1, report);
		}

	}

	public void GNBValidate(Objects obj) throws InterruptedException {
		/*
		 * ExtentReports report = obj.getReport(); ExtentTest parent = obj.getParent();
		 */
		String url = obj.getURL();

		String xls = "//Desktop//GNB DataSet";

		WebDriver driver = obj.getDriver();
		GenericFunction per = new GenericFunction(driver);

		com.aventstack.extentreports.ExtentTest parent = obj.getNewParent();
		gnb = new Desktop_GNB(driver, url);
		// System.out.println(driver);
		com.aventstack.extentreports.ExtentTest child = null;

		try {
			driver.get(url);
			int rowCount = ExcelReader.getRows(xls);
			String L1p = null;
			String L2p = null;
			System.out.println(rowCount);

			HashMap<String, Integer> h = new HashMap<String, Integer>();
			for (int i = 1; i <= rowCount; i++) {
				System.out.println(i);
				// // Level 1 of GNG
				String L1 = ExcelReader.genericReadData(xls, i, "L1");

				/*
				 * if(!L1.equalsIgnoreCase("more courses")) continue;
				 */

				if(L1.equalsIgnoreCase("more courses"))
					continue;

				// // Level 2 of GNG
				String L2 = ExcelReader.genericReadData(xls, i, "L2");
				// // Level 3 of GNG
				String L3 = ExcelReader.genericReadData(xls, i, "L3");
				// // URL of GNG
				String urlxl = ExcelReader.genericReadData(xls, i, "LNK");
				String url2 = "";

				if (L1.equalsIgnoreCase(L1p) && L2.equalsIgnoreCase(L2p)) {
					if (h.containsKey(L3)) {

						int hm = h.get(L3);
						h.put(L3, hm + 1);
					} else {
						h.put(L3, 0);

					}
				} else {
					h = new HashMap<String, Integer>();
					h.put(L3, 0);
				}

				driver.get(url);

				child = per.createChild(parent, L1 + "<br>" + L2);

				System.out.println(L1);
				System.out.println(L2);
				System.out.println(L3);
				per.childInfo(child, url);
				// CommonFunctions.info(child, url);
				gnb.howerLvl1(L1, child);

				L1p = L1;
				L2p = L2;

				if (L1.equalsIgnoreCase("More Courses") && !gnb.is_L2_Visible(L2)) {
					gnb.Click_GNB_More(child);
					Thread.sleep(1000);
					// System.out.println("Clicked");
				}
				if (!(L2.equalsIgnoreCase("Abroad Counseling Service") || L2.equalsIgnoreCase("IIM Call Predictor"))) {
					if (!(L1.equalsIgnoreCase("Study Abroad") && L2.equalsIgnoreCase("Colleges")))
						gnb.howerLvl2(L1, L2, L3, child);

					// Thread.sleep(3000);

				} else
					gnb.clickLvl2(L2, child);

				// System.out.println("here");
				Thread.sleep(1000);

				if (!(L3.equalsIgnoreCase("")))
					gnb.clickLvl3(L1, L2, L3, h.get(L3), child);

				// System.out.println("here");

				gnb.footer_Available(child);
				url2 = driver.getCurrentUrl();

				url2 = url2.replaceAll(url.substring(0, url.length() - 1), "");

				per.childInfo(child, "Expected Url : " + urlxl + "<br>Obtained Url : " + url2);
				// CommonFunctions.info(child1, "Expected Url : " + urlxl
				// + "<br>Obtained Url : " + url2);

				if (urlxl.equalsIgnoreCase(url2)) {
					System.out.println("Pass");
					per.childPass(child, "Url Verified");
					// CommonFunctions.pass(child, "Url Verified");
				} else {

					System.out.println("Fail");
					System.out.println("data : " + urlxl);
					System.out.println("Screen " + url2);
					per.childFail(child, "Url not Verified");
					// CommonFunctions.fail(child, "Url not Verified");
				}

				// CommonFunctions.closeChild(parent, child1, report);

			}

		} catch (Exception e) {
			// CommonFunctions.closeChild(parent, child1, report);

			e.printStackTrace();
		}

	}

	public void Category_Desktop(Objects obj) throws InterruptedException {
		WebDriver driver = obj.getDriver();

		// CommonFunctions cmn = new CommonFunctions();
		GenericFunction per = new GenericFunction(driver);
		// com.aventstack.extentreports.ExtentReports report = per.getReport(obj);

		com.aventstack.extentreports.ExtentTest parent = obj.getNewParent();
		String url = obj.getURL();
		String sheetpath = "//Desktop//Category_Desktop";

		String l1 = "", l2 = "", lnk = "";
		Navigation_Desktop page = new Navigation_Desktop(driver);
		HashMap<String, Integer> index = new HashMap<String, Integer>();
		try {
			for (int i = 1; i <= ExcelReader.getRows(sheetpath); i++) {
				try {
					driver.get(url);
					Thread.sleep(2000);
					l1 = ExcelReader.genericReadData(sheetpath, i, "L1");
					l2 = ExcelReader.genericReadData(sheetpath, i, "L2");
					lnk = ExcelReader.genericReadData(sheetpath, i, "LNK");
					System.out.println(l1);
					System.out.println(l2);
					com.aventstack.extentreports.ExtentTest child = per.createChild(parent, l2);
					per.childInfo(child, url);
					per.childInfo(child,
							"Dataset" + "<br>Level 1 :" + l1 + "<br>Level 2 :" + l2 + "<br>Expected Url: " + lnk);
					page.click_L1(l1);
					int in = 1;
					if (index.containsKey(l2))
						in = index.get(l2) + 1;
					index.put(l2, in);

					String curl = page.click_L2(l2, in);
					curl = per.toRelativeURL(curl);
					curl = curl.substring(1, curl.length());
					per.childInfo(child, "Actual Url: " + curl);
					per.childInfo(child, "Expected Url and Expected Url are matching.");
					System.out.println("From Excel" + lnk);
					System.out.println("From page  " + curl);
					if (lnk.equalsIgnoreCase(curl))
						per.childPass(child, "Url has been verified");
					else
						per.childFail(child, "url has not been verified");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// per.closeReport(report);
	}

	public void Homepage_Miscellaneous(Objects obj) throws InterruptedException {
		WebDriver driver = obj.getDriver();
		//GenericFunction per = new GenericFunction(driver);
		String url = obj.getURL();
		driver.get(url);
		com.aventstack.extentreports.ExtentTest parent = obj.getNewParent();
		//Navigation_Desktop page = new Navigation_Desktop(driver);
		Featured_Articles(driver, url,parent);
		driver.get(url);
		Featured_Colleges(driver,url,parent);
		driver.get(url);
		Social_Links(driver,url,parent);
		driver.get(url);
		Careers_After_12th(driver, url,parent);
	}

	private void Featured_Articles(WebDriver driver, String url,com.aventstack.extentreports.ExtentTest parent) {

		Navigation_Desktop page = new Navigation_Desktop(driver);
		GenericFunction per=new GenericFunction(driver);
		com.aventstack.extentreports.ExtentTest child=per.createChild(parent, "Featured Articles");
		per.childInfo(child, url);
		int siz = 0;
		try {
			Thread.sleep(1000);

			siz = page.Count_Of_Articles();

			for (int i = 0; i < siz; i++) {
				String Homepage_Article = page.scroll_click_Articles(i,child);

				String Heading_Article_Page = page.Article_Page_Heading(child);
				driver.get(url);

				if (Heading_Article_Page.contains(Homepage_Article))
					per.childPass(child,"Pass");
				else
					per.childFail(child, "Fail");

			}
			String Article_All = page.view_All_Article(child);
			System.out.println(Article_All);
			per.childInfo(child, Article_All);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void Featured_Colleges(WebDriver driver, String url,com.aventstack.extentreports.ExtentTest parent) {
		Navigation_Desktop page = new Navigation_Desktop(driver);
		GenericFunction per=new GenericFunction(driver);
		com.aventstack.extentreports.ExtentTest child=per.createChild(parent, "Featured Colleges");
		per.childInfo(child, url);
		int siz = 0;
		try {
			Thread.sleep(1000);
			siz = page.count_Of_Featured_Colleges();
			for (int i = 0; i < siz; i++) {
				String Validation_Txt_Featured_Clg =page.click_Featured_Colleges(i,child);
				driver.get(url);
				System.out.println(Validation_Txt_Featured_Clg);
				if (!Validation_Txt_Featured_Clg.equalsIgnoreCase(""))
					per.childPass(child,"Pass");
				else
					per.childFail(child, "Fail");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void Social_Links(WebDriver driver, String url,com.aventstack.extentreports.ExtentTest parent) {
		Navigation_Desktop page = new Navigation_Desktop(driver);
		GenericFunction per=new GenericFunction(driver);
		com.aventstack.extentreports.ExtentTest child=per.createChild(parent, "Social Links");
		per.childInfo(child, url);
		int siz = 0;
		try {
			Thread.sleep(1000);
			siz = page.No_Of_Social_Links();
			for (int i = 0; i < siz; i++) {
				String curl = page.click_Social_Links_Fb_Tw_G(i,child);
				System.out.println(curl);
				per.childInfo(child, curl);
				if(!curl.equalsIgnoreCase(""))
					per.childPass(child, "Pass");
				else
					per.childFail(child, "Fail");
				driver.get(url);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void Careers_After_12th(WebDriver driver,String url,com.aventstack.extentreports.ExtentTest parent) {
		Navigation_Desktop page = new Navigation_Desktop(driver);
		GenericFunction per=new GenericFunction(driver);
		com.aventstack.extentreports.ExtentTest child=per.createChild(parent, "Careers After 12th");
		per.childInfo(child, url);
		int siz=0;
		try {
			Thread.sleep(1000);
			page.ScrollTo_CareersAfter12th();
			siz=page.No_Of_Careers_After_12th();
			System.out.println(siz);
			
			for(int i=0;i<siz;i++) {
				page.ScrollTo_CareersAfter12th();
				String Career_Stream_Homepage=page.click_Careers_After_12th(i,child);
				
				System.out.println(Career_Stream_Homepage);
				per.childInfo(child, "Careers_Stream_Homepage : "+Career_Stream_Homepage);
				String Career_Stream_Nextpage=page.Validation_Career_Text();
				per.childInfo(child, "Careers_Stream_Nextpage : "+Career_Stream_Nextpage);
				System.out.println(Career_Stream_Nextpage);
				driver.get(url);
				if(Career_Stream_Homepage.equalsIgnoreCase("ARTS & HUMANITIES") && Career_Stream_Nextpage.equalsIgnoreCase("Humanities/Arts"))
					per.childPass(child, "Pass");
				else if(Career_Stream_Homepage.equalsIgnoreCase(Career_Stream_Nextpage)) 
					per.childPass(child, "Pass");
				
				else
					per.childFail(child, "Fail");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
