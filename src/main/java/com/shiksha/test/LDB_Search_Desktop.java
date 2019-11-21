package com.shiksha.test;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.National_LDB_MR_Search_Desktop;
import com.shiksha.object.LDB_NAT_Lead_Search_Desktop;
import com.shiksha.object.LDB_SA_Lead_Search_Desktop;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.ExcelReader;


public class LDB_Search_Desktop  {
	
	National_LDB_MR_Search_Desktop mrs = null;	
	LDB_NAT_Lead_Search_Desktop nls=null;
	LDB_SA_Lead_Search_Desktop sls=null;
	CommonFunctions CommonFunctions = new CommonFunctions();
	
	// @SuppressWarnings("unused")
	public void MR_Search(Objects obj) throws Exception
	{	
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		
		ExtentTest child1 = CommonFunctions.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		for (int i = 0; i < ExcelReader.getRows("MR"); i++) {
			
		try	{
			//// Object of MR SEARCH CLASS
			mrs = new National_LDB_MR_Search_Desktop(driver, child1);
			CommonFunctions.info(child1,"National-> Matched Response Search");
			CommonFunctions.info(child1,"Actual URL ->"+url+"enterprise/Enterprise/");
			
			//// 
			driver.get(url
					+ "enterprise/Enterprise/");
			CommonFunctions.loginCMS(driver, url, "dr.sreedharan@indiraiibm.edu.in", "shiksha");	
	

		//// Open MR Search url
	//	mrs.openMRPage();
	//	mrs.openMRPage(ExcelReader.getData(i, "MR", "URL"));
		driver.get(url
				+ ExcelReader.getData(i, "URL", "MR"));


		
	// Select institutes
		mrs.selectInstitutes();
	
	//Select Courses
		mrs.selectCourses();
			
	//Select  Date
	mrs.selectDate(ExcelReader.getData(i, "Date", "MR"),ExcelReader.getData(i, "Month", "MR"),ExcelReader.getData(i, "Year", "MR"));
		
	//Click Search
		mrs.clickSearch();
		
	// Verify Result
		mrs.verifyCount();  

		
		// mrs.signOut();
		// mrs.closeWindow();
	
	}
		
	
	
	catch(Exception e)
	{
		e.printStackTrace();
	  //// do nothing
	}
		finally{
			CommonFunctions.closeChild(parent, child1, report);
		}
		}
	
	} // function LDB_MR_Search ends here
	

	
	
	/////// National Lead Search starts here //////////////////////
	
// 	@SuppressWarnings("unused")
	public void LDB_Nat_Search(Objects obj) throws Exception
	{	
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		
		ExtentTest child1 = CommonFunctions.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		for (int i = 0; i < ExcelReader.getRows("LDB"); i++) {
		
		try{
			nls = new LDB_NAT_Lead_Search_Desktop(driver, child1);
			CommonFunctions.info(child1,"national_search");
			driver.get(url
					+ "enterprise/Enterprise/");

	

			CommonFunctions.loginCMS(driver, url, "dr.sreedharan@indiraiibm.edu.in", "shiksha");	
		
		//// Open LDB Search url
		
		driver.get(url + "enterprise/enterpriseSearch/index");
		
		
	// Select stream for LDB Search
	nls.selectStream("3");
		
	// Select Substream for LDB Search
	nls.selectSubstream();
		
	//Select  Date
		nls.selectDate(ExcelReader.getData(i, "Date", "LDB"),ExcelReader.getData(i, "Month", "LDB"),ExcelReader.getData(i, "Year", "LDB"));
		
	
	//Click Search
	nls.clickSearch();
		
	// Verify Result	
	// nls.verifyResult();
		nls.verifyCount();
	//	nls.closeWindow();
		}
	
	
	
	
	catch(Exception e)
	{
		e.printStackTrace();
	  //// do nothing
	}
		finally {
			CommonFunctions.closeChild(parent, child1, report);
		}
		}
	} // function LDB_Nat_Search ends here
	

	
	/* function LDB_SA_Search starts here*/
	
	public void SA_Lead_Search(Objects obj) throws Exception
	{	
		ExtentReports report = obj.getReport();
//		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		
		ExtentTest child1 = CommonFunctions.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		for (int i = 0; i < ExcelReader.getRows("LDBSA"); i++) {
		
		try{
			sls = new LDB_SA_Lead_Search_Desktop(driver, child1);
			CommonFunctions.info(child1,"SA Lead Search");
			sls.openEnterprise(url, "enterprise/Enterprise");		
			
		//// Client Login
			CommonFunctions.loginCMS(driver, url, "dr.sreedharan@indiraiibm.edu.in", "shiksha");	
			
		//// Open LDB Search Page
		sls.openSALeadSearchPanel(url);
		
		//Click Calendar
	//	sls.clickCalendar();
	
		// Pick Date from Calendar
	//	sls.pickDate();
		sls.selectFromDate(ExcelReader.getData(i, "Date", "LDBSA"),ExcelReader.getData(i, "Month", "LDBSA"),ExcelReader.getData(i, "Year", "LDBSA"));
		
		//Click Calendar
		sls.clickCalendarTo();
			sls.pickDate();
		
	//Click Search
			sls.clickSearch();
			
	// Verify Count
		sls.verifyCount();
	
	}
	
	
	catch(Exception e)
	{
		e.printStackTrace();
	  //// do nothing
	}
		
		
		

	} // function LDB_SA_Lead_Search ends here
	
	}
	
}
