package com.shiksha.test;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.SA_CMS_MIL_Posting;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.ExcelReader;

public class SA_CMS_Scripts {

	String url = "";
	public String FinalUrl = "";
	CommonFunctions CommonFunctions = new CommonFunctions();
	SA_CMS_MIL_Posting mil = null;

	public void PostForClient(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		ExtentTest child1 = CommonFunctions.createChild(report, "MIL",
				"Client login");

		ExtentTest child2 = CommonFunctions.createChild(report, "MIL",
				"MIL Posting");

		String str = url;
		str = str.replace("www", "enterprise");
		FinalUrl = str;
		for (int i = 0; i < ExcelReader.getRows("MIL_SA"); i++) {

			try {
				mil = new SA_CMS_MIL_Posting(driver, child1);
				//String path;

				// SA_CMS_MIL_Posting mil = new SA_CMS_MIL_Posting(driver);
				// // Open Url
				driver.get(FinalUrl + "/enterprise/Enterprise/loginEnterprise");

				// // Type UserName
				mil.typeUserName(ExcelReader.getData(i, "UserName", "MIL_SA"));

				// // Type Passwordx
				mil.typePassword(ExcelReader.getData(i, "Password", "MIL_SA"));

				// // Click Login Button to login
				mil.hitLoginButton();

				// //
				mil.hitPostForClient();
				mil.EnterClientid(ExcelReader.getData(i, "Clientid", "MIL_SA"));
				mil.hitSearchButton();
				mil.SelectRadio();
				// mil.SelectUnset();
				mil.SelectClientid();

				mil = new SA_CMS_MIL_Posting(driver, child2);

				mil.SetMain();
				mil.SelectAbroad();
				// mil.Clickdropdown();
				mil.SelectListing();
				// Selecting subscription from dropdown
				mil.SelectSubscription(ExcelReader.getData(i, "Subscriptionid",
						"MIL_SA"));
				mil.ChooseCountry(ExcelReader.getData(i, "SelectCountry",
						"MIL_SA"));
				mil.ChooseCategory(null);
				mil.SetKeyPage();
				// mil.HitUnset();
				mil.hitPostForClient();
				mil.EnterClientid(ExcelReader.getData(i, "Clientid", "MIL_SA"));
				mil.hitSearchButton();
				mil.SelectRadio();
				// mil.SelectClientid();
				// mil.Clickdropdown();
				mil.SelectUnset();
				mil.SelectAbroad();

			}

			catch (Exception e) {
				e.printStackTrace();
				// // do nothing
			} finally {
				CommonFunctions.closeChild(parent, child1, report);
				CommonFunctions.closeChild(parent, child2, report);
			}
		}
		// CommonFunctions.closeChild(parent, child1);
		// CommonFunctions.closeExtinctReport(parent, report);
	}

}
