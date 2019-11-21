package com.shiksha.test;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.National_ULP;
import com.shiksha.resourses.ExcelReader;
import com.shiksha.resourses.GenericFunction;

public class National_ULP_Mobile {

	public void National_AMP_ULP_Mobile(Objects obj) throws InterruptedException {
		WebDriver driver = obj.getDriver();
		GenericFunction per = new GenericFunction(driver);
		// ExtentReports report = obj.getReport();
		// ExtentTest parent = obj.getParent();
		ExtentTest parent = obj.getNewParent();
		National_ULP page = new National_ULP(driver);
		String xls = "//Mobile//ULP_ILP_Ids";
		String url = obj.getURL();
		// driver.get(url);
		Thread.sleep(1000);
		try {
			HashMap<String, ExtentTest> childs = new HashMap<String, ExtentTest>();
			for (int i = 1; i <= ExcelReader.getRows(xls); i++) {
				try {

					int id = per.findInt(ExcelReader.genericReadData(xls, i, "ids"));
					String xlurl = ExcelReader.genericReadData(xls, i, "url");
					/*
					 * if(id!=57357) continue;
					 */
					String tempurl = url + "university/amp/-" + id;
					driver.get(tempurl);
					System.out.println(tempurl);
					Thread.sleep(1000);
					// System.out.println(driver.findElements(By.tagName("iframe")).size());
					
					// HashMap<String, List<String>> hm = page.ScholerShipSection();
					// HashMap<String,List<String>> db = page.ScholerShipDB(id, obj,xlurl);
					// System.out.println("FrontEnd");
					 
					/* for(String key : hm.keySet()) {
					 
					 System.out.println(key); List<String> temp = hm.get(key); for(String s: temp)
					 { System.out.println(s); } System.out.println(temp.size()); }
					  
					  System.out.println("BackEnd"); for(String key :db.keySet()) {
					  System.out.println(key); List<String> temp = db.get(key); for(String s: temp)
					  { System.out.println(s); } }*/
					 

					HashMap<String, List<String>> hm = page.AddmissionSection();
					hm.putAll(page.TopSectionData());
					hm.putAll(page.HighlightSection());
					hm.putAll(page.ScholerShipSection());
					String turl = driver.getCurrentUrl();
					hm.putAll(page.GallerySection());
					hm.putAll(page.FacilitySection());
					hm.putAll(page.EventSection());
					HashMap<String, List<String>> db = page.AdmissionDB(id, obj, turl);
					db.putAll(page.HighlightDB(id, obj));
					db.putAll(page.TopSectionDB(id, obj));
					db.putAll(page.ScholerShipDB(id, obj,xlurl));
					db.putAll(page.GalleryDB(id, obj));
					db.putAll(page.FacilityDB(id, obj));
					db.putAll(page.EventDB(id, obj));

					// validation
					page.validation(hm, db, childs, parent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Done");
		Thread.sleep(2000);
	}

	public void National_PWA_UPL_Mobile(Objects obj) throws InterruptedException {
		WebDriver driver = obj.getDriver();
		GenericFunction per = new GenericFunction(driver);
		// ExtentReports report = obj.getReport();
		// ExtentTest parent = obj.getParent();
		ExtentTest parent = obj.getNewParent();
		National_ULP page = new National_ULP(driver);
		String xls = "//Mobile//ULP_ILP_Ids";
		// String url = obj.getURL();

		Thread.sleep(1000);
		try {
			driver.get(obj.getURL());
			page.click_PWA_Cookie_Button();
			HashMap<String, ExtentTest> childs = new HashMap<String, ExtentTest>();
			ExtentTest pageStatusChilds = per.createChild(parent, "Page Status");
			for (int i = 1; i <= ExcelReader.getRows(xls); i++) {
				try {
					int id = per.findInt(ExcelReader.genericReadData(xls, i, "ids"));
					String tempurl = obj.getURL()+"college/-" + id;
					String xlurl = ExcelReader.genericReadData(xls, i, "url");
					driver.get(tempurl);
					System.out.println(i);
					System.out.println(tempurl);
					per.sleep(500);
					per.childInfo(pageStatusChilds, driver.getCurrentUrl());
					page.waitFor_Download_Brochure(pageStatusChilds);
					// System.out.println(driver.findElements(By.tagName("iframe")).size());
					 /*HashMap<String, List<String>> hm = page.GallerySection_PWA();
					 HashMap<String, List<String>> db = page.GalleryDB(id, obj);
*/
					
					/*  System.out.println("FrontEnd");
					  
					  for(String key : hm.keySet()) {
					  
					  System.out.println(key); List<String> temp = hm.get(key); for(String s: temp)
					  { System.out.println("--->"+s); } System.out.println(temp.size()); }*/
					  
					 /* 
					 * System.out.println("BackEnd"); for(String key :db.keySet()) {
					 * System.out.println(key); List<String> temp = db.get(key); for(String s: temp)
					 * { System.out.println("---->"+s); } System.out.println(temp.size());}
					 */

					HashMap<String, List<String>> hm = page.TopSection_PWA();
						hm.putAll(page.FacilitySectionPWA());
						hm.putAll(page.EventSection_PWA());
						hm.putAll(page.AddmissionSection_PWA());
						hm.putAll(page.HighlightSection_PWA());
						hm.putAll(page.ScholerShipSection_PWA());
						hm.putAll(page.GallerySection_PWA());
					HashMap<String, List<String>> db = page.TopSectionDB(id, obj);
						db.putAll(page.FacilityDB(id, obj));
						db.putAll(page.EventDB(id, obj));
						db.putAll(page.AdmissionDB_PWA(id, obj, ExcelReader.genericReadData(xls, i, "url")));
						db.putAll(page.HighlightDB(id, obj));
						db.putAll(page.ScholerShipDB(id, obj, xlurl));
						db.putAll(page.GalleryDB(id, obj));
						if(db.containsKey("TopSection : Autonomous Institute"))
							db.remove("TopSection : Autonomous Institute");
					// Validation Start
					page.validation(hm, db, childs, parent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Thread.sleep(10000);
	}
}
