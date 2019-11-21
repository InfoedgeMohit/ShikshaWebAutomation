package com.shiksha.test;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.CTA_Desktop;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.CommonFunctions;


public class National_CTA_Desktop  {

	String url = "https://shiksha.com";

	static String a[] = new String[40];
	static String b[] = new String[40];

	CommonFunctions CommonFunction = new CommonFunctions();

	public void clp_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/mba/course/-1653";
		driver.get(url + "/mba/course/-1653" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "CLP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void clp_DEB_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/mba/course/-1653";
		
		driver.get(url + "/mba/course/-1653" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "DEB", "CLP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void clp_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/mba/course/-1653";
		
		driver.get(url + "/mba/course/-1653" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.info(child1, "Url entered is ::" + url);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "CLP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void clp_Shortlist_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/mba/course/-1653";
		
		driver.get(url + "/mba/course/-1653" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.info(child1, "Url entered is ::" + url);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "shortlist", "CLP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void clp_SCD(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/mba/course/-1653";
		
		driver.get(url + "/mba/course/-1653" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "SCD", "CLP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void clp_SCD_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/mba/course/-1653";
		
		driver.get(url + "/mba/course/-1653" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "SCD", "CLP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void clp_DEB_alsoViewed(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/mba/course/-1653";

		driver.get(url + "/mba/course/-1653" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB_alsoViewed", "CLP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void clp_DEB_alsoViewed_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/mba/course/-1653" ;

		driver.get(url + "/mba/course/-1653" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "DEB_alsoViewed", "CLP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}


	public void ilp_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318" ;
		
		driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ILP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	
	public void ilp_DEB_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318" ;
		
		driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "DEB", "ILP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318";

		driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "ILP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	
	public void ilp_Shortlist_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318" ;

		driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "Shortlist", "ILP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_SCD(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318" ;

		driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "SCD", "ILP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ilp_SCD_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318" ;

		driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "SCD", "ILP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ilp_DEB_alsoViewed(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318" ;
		
		
		try {
			driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
			CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
			CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "deb_AlsoViewed", "ILP",child1);
			//CommonFunction.closeChild(parent, child1, report);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			CommonFunction.closeChild(parent, child1, report);
		}
	}
	
	public void ilp_DEB_alsoViewed_Login(Objects obj) {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318";
		
		
		try {
			driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
			CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
			CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "deb_AlsoViewed", "ILP",child1);
			//CommonFunction.closeChild(parent, child1, report);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			CommonFunction.closeChild(parent, child1, report);
		}
	}

	public void ilp_DEB_SimilarInstitutes(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318" ;
		
		driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "similarDEB", "ILP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_DEB_SimilarInstitutes_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318" ;
		
		driver.get(url + "/college/-318" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "similarDEB", "ILP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ilp_ReviewPage_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318/reviews" ;
		
		driver.get(url + "/college/-318/reviews" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "deb", "ILP-ReviewPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void ilp_ReviewPage_DEB_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318/reviews" ;
		
		driver.get(url + "/college/-318/reviews" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "deb", "ILP-ReviewPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_ReviewPage_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318/reviews" ;
		
		driver.get(url + "/college/-318/reviews" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ILP-ReviewPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void ilp_ReviewPage_Shortlist_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318/reviews" ;
		
		driver.get(url + "/college/-318/reviews" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "shortlist", "ILP-ReviewPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_Admission_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/admission" + CommonFunction.OTPDisable;

		driver.get(url + "/college/-318/admission" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "deb", "ilp-admissionPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void ilp_Admission_DEB_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/admission" + CommonFunction.OTPDisable;

		driver.get(url + "/college/-318/admission" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "deb", "ilp-admissionPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_Admission_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318/admission" + CommonFunction.OTPDisable;
		
		driver.get(url + "/college/-318/admission" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ilp-admissionPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ilp_Admission_Shortlist_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318/admission";
		
		driver.get(url + "/college/-318/admission" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "shortlist", "ilp-admissionPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	
	public void ilp_scholarships_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/scholarships" ;
		

		driver.get(url + "/college/-318/scholarships" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ilp-scholarshipPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ilp_scholarships_DEB_login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/scholarships" ;
		

		driver.get(url + "/college/-318/scholarships" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "DEB", "ilp-scholarshipPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	
	public void ilp_scholarships_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/scholarships" ;

		driver.get(url + "/college/-318/scholarships" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ilp-scholarshipPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void ilp_scholarships_Shortlist_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/scholarships" ;

		driver.get(url + "/college/-318/scholarships" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "shortlist", "ilp-scholarshipPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_Articles_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/articles" ;

		driver.get(url + "/college/-318/articles" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ilp-ArticlesPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void ilp_Articles_DEB_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/articles" ;

		driver.get(url + "/college/-318/articles" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "DEB", "ilp-ArticlesPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	

	public void ilp_Articles_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/articles" ;

		driver.get(url + "/college/-318/articles" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ilp-ArticlesPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	public void ilp_Articles_Shortlist_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/articles" ;

		driver.get(url + "/college/-318/articles" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "shortlist", "ilp-ArticlesPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_Questions_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/questions" ;

		driver.get(url + "/college/-318/questions" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ilp-questionsPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}
	
	
	public void ilp_Questions_DEB_login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-318/questions" ;

		driver.get(url + "/college/-318/questions" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "DEB", "ilp-questionsPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_Questions_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318/questions" ;
		
		driver.get(url + "/college/-318/questions" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ilp-questionsPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ilp_Questions_Shortlist_Login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-318/questions" ;
		
		driver.get(url + "/college/-318/questions" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "shortlist", "ilp-questionsPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	
	public void ulp_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642" ;

		driver.get(url + "/college/-24642" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ULP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}


	public void ulp_DEB_login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642" ;

		driver.get(url + "/college/-24642" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "DEB", "ULP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ulp_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642" ;

		driver.get(url + "/college/-24642" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "ulp",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ulp_Shortlist_login(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642" ;

		driver.get(url + "/college/-24642" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALogIn(driver, "Pune", "laxminagar", "Shortlist", "ulp",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	
	public void ulp_SCD(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-24642" ;
		
		driver.get(url + "/college/-24642" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "SCD", "ulp",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_DEB_alsoViewed(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642" ;

		driver.get(url + "/college/-24642" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "deb_AlsoViewed", "UlP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_ReviewPage_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642/reviews" ;

		driver.get(url + "/college/-24642/reviews" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "deb", "ULP-ReviewPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_ReviewPage_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642/reviews" ;

		driver.get(url + "/college/-24642/reviews" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ULP-ReviewPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_Admission_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642/admission" ;

		driver.get(url + "/college/-24642/admission" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ulp-admissionPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_Admission_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642/admission" ;

		driver.get(url + "/college/-24642/admission" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ulp-admissionPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_scholarships_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642/scholarships" ;

		driver.get(url + "/college/-24642/scholarships" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ulp-scholarshipPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_scholarships_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642/scholarships" ;

		driver.get(url + "/college/-24642/scholarships" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ulp-scholarshipPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_Articles_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642/articles" ;

		driver.get(url + "/college/-24642/articles" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ulp-ArticlesPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_Articles_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/college/-24642/articles" ;

		driver.get(url + "/college/-24642/articles" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ulp-ArticlesPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}


	public void ulp_Questions_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-24642/questions" ;
		
		driver.get(url + "/college/-24642/questions" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ulp-questionsPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_Questions_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/college/-24642/questions" ;
		
		driver.get(url + "/college/-24642/questions" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "ulp-questionsPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void rankingPage_InstitueType_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/mba/ranking/top-mba-colleges-in-india/2-2-0-0-0" + CommonFunction.OTPDisable;

		driver.get(url + "/mba/ranking/top-mba-colleges-in-india/2-2-0-0-0" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "rankingPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void rankingPage_InstitueType_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/mba/ranking/top-mba-colleges-in-india/2-2-0-0-0" + CommonFunction.OTPDisable;
		
		driver.get(url + "/mba/ranking/top-mba-colleges-in-india/2-2-0-0-0" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "rankingPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void rankingPage_CourseType_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/design/fashion-design/ranking/top-fashion-design-colleges-in-india/94-2-0-0-0" + CommonFunction.OTPDisable;
		
		driver.get(url + "/design/fashion-design/ranking/top-fashion-design-colleges-in-india/94-2-0-0-0" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "rankingPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void rankingPage_CourseType_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/design/fashion-design/ranking/top-fashion-design-colleges-in-india/94-2-0-0-0" ;

		driver.get(url + "/design/fashion-design/ranking/top-fashion-design-colleges-in-india/94-2-0-0-0" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortList", "rankingPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void CategoryPage_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url + "/b-tech/colleges/b-tech-colleges-bangalore" ;

		driver.get(url + "/b-tech/colleges/b-tech-colleges-bangalore" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "CTP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void CategoryPage_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url + "/b-tech/colleges/b-tech-colleges-bangalore" + CommonFunction.OTPDisable;
		
		driver.get(url + "/b-tech/colleges/b-tech-colleges-bangalore" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "CTP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	//	+ more code :

	public void Category_Page_More_DEB(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url+"/mba/colleges/mba-colleges-chennai";
		
		driver.get(url+"/mba/colleges/mba-colleges-chennai"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CTA_Desktop cta_desktop = new CTA_Desktop(driver, child1);
		int collegeIdOfMoreCourseButtonUpdated = cta_desktop.Category_Page_More();
		CommonFunction.waitForFixTime(2000);
		driver.findElement(By.xpath("(.//span[@instid='"+collegeIdOfMoreCourseButtonUpdated+"'])[2]")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "CTP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void Category_Page_More_Shortlist(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url+"/mba/colleges/mba-colleges-chennai";
		
		driver.get(url+"/mba/colleges/mba-colleges-chennai"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CTA_Desktop cta_desktop = new CTA_Desktop(driver, child1);
		int collegeIdOfMoreCourseButtonUpdated = cta_desktop.Category_Page_More();
		CommonFunction.waitForFixTime(2000);
		driver.findElement(By.xpath("(.//a[@instid="+collegeIdOfMoreCourseButtonUpdated+"]//span[contains(@class,'tup-view-details')])[2]")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "CTP",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ILP_All_Course_Page_DEB_Top(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url+"/university/university-of-delhi-318/courses";
		
		driver.get(url+"/university/university-of-delhi-318/courses"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		driver.findElement(FetchData.readOR("acp_deb_top")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ILP_All_Course_Page_DEB(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/university/university-of-delhi-318/courses";

		driver.get(url+"/university/university-of-delhi-318/courses"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		driver.findElement(FetchData.readOR("acp_deb_First")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ILP_All_Course_Page_Shortlist(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/university/university-of-delhi-318/courses";

		driver.get(url+"/university/university-of-delhi-318/courses"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		driver.findElement(FetchData.readOR("acp_shortlist_first")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ULP_All_Course_Page_DEB_Top(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/university/university-of-delhi-24642/courses";
		

		driver.get(url+"/university/university-of-delhi-24642/courses"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		driver.findElement(FetchData.readOR("ulp_deb_top")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ULP_All_Course_Page_DEB(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/university/university-of-delhi-24642/courses";

		driver.get(url+"/university/university-of-delhi-24642/courses"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		driver.findElement(FetchData.readOR("ulp_deb_first")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ULP_All_Course_Page_Shortlist(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/university/university-of-delhi-24642/courses";

		driver.get(url+"/university/university-of-delhi-24642/courses"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		driver.findElement(FetchData.readOR("ulp_shortlist")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void CollegePredictorLaunchPage_DEB(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/b-tech/resources/kcet-college-predictor";

		driver.get(url+"/b-tech/resources/kcet-college-predictor"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("CollegePredictor_LaunchPage_Scroll1")), driver);
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("CP_LaunchPage_DEB")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "CollegePredictorLaunchPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void CollegePredictorLaunchPage_Shortlist(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/b-tech/resources/kcet-college-predictor";

		driver.get(url+"/b-tech/resources/kcet-college-predictor"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("CollegePredictor_LaunchPage_Scroll1")), driver);
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("CP_LaunchPage_Shortlist")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "shortlist", "CollegePredictorLaunchPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void University_Cutoff_Page_DEB(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/university/university-of-delhi-24642/cutoff";

		driver.get(url+"/university/university-of-delhi-24642/cutoff"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("ulp_CutOffPage_Scroll")), driver);
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("ulp_CutOffPage_DEB")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "CutOffPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void University_Cutoff_Page_Shortlist(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/university/university-of-delhi-24642/cutoff";

		driver.get(url+"/university/university-of-delhi-24642/cutoff"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("ulp_CutOffPage_Scroll")), driver);
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("ulp_CutoffPage_Shortlist")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "CutOffPage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_AdmissionPage_ShortlistBellybutton(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/university/university-of-delhi-318/admission";

		driver.get(url+"/university/university-of-delhi-318/admission"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("ilp_admissionPage_ShortlistBelly_Scroll")), driver);
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("ilp_admissionPage_ShortlistBellyButton")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "AdmissionPage_Shortlistbellybutton",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void SRP_Page_Shortlist(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url+"/university/university-of-delhi-318/admission";
		
		driver.get(url+"/university/university-of-delhi-318/admission"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		driver.findElement(FetchData.readOR("SearchCollege_TextBox")).sendKeys("MBA");
		driver.findElement(FetchData.readOR("submit_forSearch")).click();
		CommonFunction.waitForElement(driver, ".//h1[@class='searchHead']");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("currentUrl is :: " + currentUrl);
		driver.get(currentUrl+CommonFunction.OTPDisable);
		CommonFunction.waitForFixTime(3000);
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("SearchPage_Scroll1")), driver);
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("SRP_Shortlist")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ComparePage_DEB(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/resources/college-comparison-iim-ahemdabad-vs-iim-bangalore-1653-1688";

		driver.get(url+"/resources/college-comparison-iim-ahemdabad-vs-iim-bangalore-1653-1688"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		driver.findElement(FetchData.readOR("ComparePage_DEB")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "ComparePage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ComparePage_Shortlist(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/resources/college-comparison-iim-ahemdabad-vs-iim-bangalore-1653-1688";

		driver.get(url+"/resources/college-comparison-iim-ahemdabad-vs-iim-bangalore-1653-1688"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("ComparePage_ShortlistScroll")), driver);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("ComparePage_Shortlist")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "ComparePage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ComparePage_AskNow(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = url+"/resources/college-comparison-iim-ahemdabad-vs-iim-bangalore-1653-1688";

		driver.get(url+"/resources/college-comparison-iim-ahemdabad-vs-iim-bangalore-1653-1688"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("ComparePage_AskNowScroll")), driver);
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("ComparePage_AskNow")).click();
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("Compare_Page_AskNow_SendKeys")).sendKeys("Which one is good....... Mtech or MBA ? Please suggest");
		driver.findElement(FetchData.readOR("ComparePage_QuestionPost")).click();
		CommonFunction.waitForFixTime(2000);
		driver.findElement(FetchData.readOR("Compare_Page_FinalQuestionPost")).click();
		//		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "AskNow", "ComparePage",child1,obj);
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "AskNow", "ComparePage",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_getCourseDetailsWidget_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = "https://shiksha.com/college/indian-institute-of-management-ahmedabad-vastrapur-307";
		
		
		driver.get("https://shiksha.com/college/indian-institute-of-management-ahmedabad-vastrapur-307"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		try {
			CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("scroll_GetDetails")), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(1000);
		driver.findElement(FetchData.readOR("ilp_GetCourseDetails_DEB")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ilp_getCourseDetailsWidget_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		
		String updatedURL = "https://shiksha.com/college/indian-institute-of-management-ahmedabad-vastrapur-307";

		driver.get("https://shiksha.com/college/indian-institute-of-management-ahmedabad-vastrapur-307"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		try {
			CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("scroll_GetDetails")), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(1000);
		driver.findElement(FetchData.readOR("ilp_GetCourseDetails_Shortlist")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_getCourseDetailsWidget_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = "https://shiksha.com/university/university-of-delhi-24642";
		
		driver.get("https://shiksha.com/university/university-of-delhi-24642"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		try {
			CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("scroll_GetDetails")), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(1000);
		driver.findElement(FetchData.readOR("ulp_GetCourseDetialsWidget_DEB")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void ulp_getCourseDetailsWidget_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = "https://shiksha.com/university/university-of-delhi-24642";
		
		driver.get("https://shiksha.com/university/university-of-delhi-24642"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		try {
			CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("scroll_GetDetails")), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(1000);
		driver.findElement(FetchData.readOR("ulp_GetCourseDetails_Shortlist")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void clp_getCourseDetailsWidget_DEB(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = "https://shiksha.com/animation/animation-film-making/course/dfskjdfjgd-indian-institute-of-management-ahmedabad-vastrapur-1653";
		
		driver.get("https://shiksha.com/animation/animation-film-making/course/dfskjdfjgd-indian-institute-of-management-ahmedabad-vastrapur-1653"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		try {
			CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("scroll_GetDetails")), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(1000);
		driver.findElement(FetchData.readOR("clp_GetCourseDetails_DEB")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "DEB", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void clp_getCourseDetailsWidget_Shortlist(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		//		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = "https://shiksha.com/animation/animation-film-making/course/dfskjdfjgd-indian-institute-of-management-ahmedabad-vastrapur-1653";
		
		driver.get("https://shiksha.com/animation/animation-film-making/course/dfskjdfjgd-indian-institute-of-management-ahmedabad-vastrapur-1653"+CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		try {
			CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("scroll_GetDetails")), driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		CommonFunction.waitForFixTime(2000);
		CommonFunction.scroll_Above(driver);
		CommonFunction.waitForFixTime(1000);
		driver.findElement(FetchData.readOR("clp_GetCourseDetails_Shortlist")).click();
		CommonFunction.CTALoggedOut(driver, "Pune", "laxminagar", "Shortlist", "",child1);
		CommonFunction.closeChild(parent, child1, report);
	}

	public void CategoryPage_ShowDataInTableButton(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		int count = 2;
		String url1 = url+"/mba/colleges/mba-colleges-india-4?pn=4&ts=22";
		String url2 = url + "/b-tech/colleges/b-tech-colleges-chennai";

		for (int numURl =1;numURl<=count;numURl++) {

			switch (numURl) {
			case 1:
				driver.get(url1);				
				break;
			case 2:
				driver.get(url2);				
				break;
			default:
				break;
			}


			String currentURl = driver.getCurrentUrl();

			int numLinks = driver.findElements(By.xpath(".//a[@class='tuple-institute-name']")).size();

			System.out.println("Num links are :: " + numLinks);

			for (int i= 1; i <=numLinks; i++) {
				a[i] =  driver.findElement(By.xpath("(.//a[@class='tuple-institute-name'])["+i+"]")).getText();
				System.out.println(a[i] + "\n");
			}

			CommonFunction.scrollToElementUsingWebElement(driver.findElement(By.xpath(".//a[contains(text(),'Show Data')]")), driver);
			CommonFunction.waitForFixTime(3000);
			CommonFunction.scroll_Above(driver);
			CommonFunction.waitForFixTime(1000);
			driver.findElement(By.xpath(".//a[contains(text(),'Show Data')]")).click();

			System.out.println("\n" + "Starting Layer -----------------------------");

			for (int j=1;j<=numLinks;j++) {

				b[j] = driver.findElement(By.xpath("(.//*[@id='search-container-wrapper']//td[1])["+j+"]")).getText();
				System.out.println(b[j]+ "\n");
			}

			CommonFunction.info(child1, "Going to verify for URL :: " + currentURl);

			for(int k=1;k<=numLinks;k++) {
				if(a[k].equalsIgnoreCase(b[k])) {
					System.out.println("Pass at ::" + a[k]);
					CommonFunction.pass(child1, "Pass for tuple number : " + k);
				}
				else {
					System.out.println("Fail at ::  " + a[k]);
				}
			}
			CommonFunction.closeChild(parent, child1, report);
		}
	}

	public void cutOffPage_cutOffFilter(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunction.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		String updatedURL = url+"/university/university-of-delhi-24642/cutoff";
				
		driver.get(url+"/university/university-of-delhi-24642/cutoff" + CommonFunction.OTPDisable);
		CommonFunction.info(child1, "Entered URL is ::" + updatedURL);
		// Opening CutOff Filter Drop-down
		driver.findElement(By.xpath(".//li[@class='cutOff-blc']//span")).click();
		List<WebElement> allCutOffFilterValues = driver.findElements(By.xpath(".//a[@class='filterCutoff']"));
		int NumOfcutOffValuesInFilter = allCutOffFilterValues.size();

		for (int cutOffFilterLoop=1; cutOffFilterLoop<NumOfcutOffValuesInFilter;cutOffFilterLoop++) 
		{
			CommonFunctions.elementWait(driver, 5, By.xpath(".//li[@class='cutOff-blc']//p"));
			if(cutOffFilterLoop>1) {
				CommonFunction.scrollToElementUsingWebElement(driver.findElement(By.xpath(".//label[contains(text(),'Cut-Off')]")), driver);
				CommonFunction.scroll_Above(driver);
				driver.findElement(By.xpath(".//li[@class='cutOff-blc']//p")).click();
			}

			try {
				if(driver.findElement(By.xpath("(.//li[@class='cutOff-blc']//a)["+(cutOffFilterLoop+1)+"]")).isSelected())
				{
					// Do nothing
				}
			}
			catch (Exception e) {
				CommonFunction.scrollToElementUsingWebElement(driver.findElement(By.xpath("(.//li[@class='cutOff-blc']//a)["+(cutOffFilterLoop+1)+"]")), driver);
				CommonFunction.scroll_Above(driver);
				CommonFunction.waitForFixTime(1000);
			}

			WebElement filterValue = driver.findElement(By.xpath("(.//li[@class='cutOff-blc']//a)["+(cutOffFilterLoop+1)+"]"));
			String filterValueInString = filterValue.getText();
			CommonFunction.info(child1, "Checking for CutOff Filter value as : " + filterValueInString);
			System.out.println("filterValueInString is :: " + filterValueInString);
			String filterValueLowerLimit = filterValueInString.split("%", 2)[0];
			System.out.println("filterValueLowerLimit is :: " + filterValueLowerLimit);
			int FinalfilterValueLowerLimitInInteger = Integer.parseInt(filterValueLowerLimit);
			System.out.println("FinalfilterValueLowerLimitInInteger is :: " + FinalfilterValueLowerLimitInInteger);
			filterValue.click();

			CommonFunction.waitForFixTime(2000);
			while(driver.findElements(By.xpath(".//div//a[@id='loadMore']")).size()>0)  {
				CommonFunction.scrollToElementUsingWebElement(driver.findElement(By.xpath(".//div//a[@id='loadMore']")), driver);
				CommonFunction.waitForFixTime(2000);
				CommonFunction.scroll_Above(driver);
				CommonFunction.waitForFixTime(2000);
				try {
					if(driver.findElement(By.xpath(".//div//a[@id='loadMore']")).isEnabled()) {
						driver.findElement(By.xpath(".//div//a[@id='loadMore']")).click();
						System.out.println("Load More Clicked");
						CommonFunction.waitForFixTime(2000);
					}
				}
				catch (Exception e) {
					break;
				}
			}

			List<WebElement> tuplesOnPage = driver.findElements(By.xpath(".//div[@class='cutOff-tuple-cont']"));

			int allTuplesCountOnPage = tuplesOnPage.size();

			for (int loop=1;loop<=allTuplesCountOnPage ; loop++) {

				List<WebElement> cutOffRoundsInOneTuple = driver.findElements(By.xpath("(.//div[@class='cutOff-tuple-cont'])["+loop+"]//ul[@class='cutOff-Rounds']/li"));

				int countOfcutOffRoundsInOneTuple = cutOffRoundsInOneTuple.size();

				int compareValue = 0;

				for (int roundCount=1; roundCount <= countOfcutOffRoundsInOneTuple ; roundCount++) {
					String text = "";
					text = driver.findElement(By.xpath("((.//div[@class='cutOff-tuple-cont'])["+loop+"]//ul[@class='cutOff-Rounds']/li//span)["+roundCount+"]")).getText();
					text = text.split("%", 2)[0];
					System.out.println("Text is :: " + text);
					if(!(text.contains("-"))) {
						int cutOffValueInRound = CommonFunction.getFirstIntegerValueFromString(text);
						System.out.println("cutOffValueInRound is " + cutOffValueInRound );
						if(cutOffValueInRound>=FinalfilterValueLowerLimitInInteger) {
							compareValue++;
						}
					}
				}
				if(compareValue>0) {
					CommonFunction.pass(child1, "Pass for tuple " + loop + " as atleast one of its rounds is having cutoff which falls under the cut-off filter selected range.");
					System.out.println("Pass -----> " + "Reason : Tuple " + loop + " is having at least one round's cutoff which falls under the cut-off filter selected range.");
				}
				else {
					System.out.println("Fail -----> " + "Reason : Tuple Number " + loop + "should not be displayed");
					//CommonFunction.fail(child1, "Fail for tuple " + loop + " as atleast one of its rounds is not having cutoff which falls under the cut-off filter selected range.");
				}
			}
		}
		CommonFunction.closeChild(parent, child1, report);
	}
}
