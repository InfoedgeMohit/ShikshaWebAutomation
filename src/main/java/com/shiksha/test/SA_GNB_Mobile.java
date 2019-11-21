package com.shiksha.test;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.SA_GNB_Mob;
import com.shiksha.resourses.CommonFunctions;


public class SA_GNB_Mobile {

	String url = "";
	public String FinalUrl = "";
	CommonFunctions CommonFunctions = new CommonFunctions();
	String srpTitle = "";
	
	public void AbroadGNB(Objects obj) throws Exception {
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		if (obj.getdbUserName().length() == 0) {
            FinalUrl = "https://studyabroad.shiksha.com/";
      }

      else {
            String str = url;
            int index = str.indexOf("//") + 2;
            String uuu = str.substring(index);
            FinalUrl = "https://studyabroad." + uuu
                        + "";
      }
		driver.get(FinalUrl);
		try {
			ExtentTest child1 = null;
			SA_GNB_Mob SGM = new SA_GNB_Mob(driver, child1);
			
			driver.get(FinalUrl);
			SGM.ClickonMenu();
			Thread.sleep(10000);
		}
			catch (Exception e) {
			}
	}
}
