package com.shiksha.test;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;

import com.shiksha.object.National_ReviewPosting_Desktop;

import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.ExcelReader;

// import com.shiksha.resourses.Generic_Methods;

public class National_Review_Desktop  {
	
	National_ReviewPosting_Desktop crf = null;
	National_ReviewPosting_Desktop rrf = null;
	
	CommonFunctions CommonFunctions = new CommonFunctions();

	
	// @SuppressWarnings("unused")
	public void ReviewPosting(Objects obj) throws Exception
	{
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		ExtentTest child1 = CommonFunctions.createChild(report, obj.getcomponentDescription(),obj.getcomponentDetailDescription());
		for (int i = 0; i < ExcelReader.getRows("ReviewPosting"); i++) {
		try
		{
		
		crf = new National_ReviewPosting_Desktop(driver, child1);
		
		
		
	crf.openReviewPostingForm(url,"college-review-form");
	crf.typeInstituteName("Ma");
	crf.selectInstitute();
	crf.selectCourse();
	crf.selectYear();
	crf.enterPlacement(ExcelReader.getData(i, "Placement", "ReviewPosting"));
	crf.enterInfra(ExcelReader.getData(i, "Infra", "ReviewPosting"));
	crf.enterFaculty(ExcelReader.getData(i, "Faculty", "ReviewPosting"));
	crf.enterOther(ExcelReader.getData(i, "Others", "ReviewPosting"));
	crf.enterTitle(ExcelReader.getData(i, "Title", "ReviewPosting"));
	crf.selectRating();
	crf.selectRecommend();
	crf.enterFname(ExcelReader.getData(i, "Fname", "ReviewPosting"));
	crf.enterLname(ExcelReader.getData(i, "Lname", "ReviewPosting"));
	//crf.enterEmail("reviewform@"+CommonFunctions.TimeStamp()+".pc"); //pc_reviewrating@test.104
	crf.enterEmail(); //pc_reviewrating@test.104
	crf.enterSocial(ExcelReader.getData(i, "SocialProfileURL", "ReviewPosting"));
	crf.enterMobile();
	crf.clickSubmit();
	crf.verifyThankyou(ExcelReader.getData(i, "Fname", "ReviewPosting"));
	//crf.closeWindow();

	} 
		catch (Exception e) {
			System.out.println(e.toString());
		}
		

	finally {
		CommonFunctions.closeChild(parent, child1, report);
	}
		}
}
	
	//////////////////////// Review rating form starts here //////////////////////////////////
	
//	@SuppressWarnings("unused")
	public void ReviewRating(Objects obj) throws Exception
	{
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();	
		
		ExtentTest child1 = CommonFunctions.createChild(report, obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		for (int i = 0; i < ExcelReader.getRows("ReviewPosting"); i++) {
		try
		{
		
			rrf = new National_ReviewPosting_Desktop(driver, child1);
		CommonFunctions.info(child1,"posting");
		
//		driver.get(url
//				+ "college-review-rating-form");
	rrf.openReviewPostingForm(url,"college-review-rating-form");
	rrf.typeInstituteName("In");
	rrf.selectInstitute();
	rrf.selectCourse();
	rrf.selectYear();
	rrf.enterPlacement(ExcelReader.getData(i, "Placement", "ReviewPosting"));
	rrf.enterInfra(ExcelReader.getData(i, "Infra", "ReviewPosting"));
	rrf.enterFaculty(ExcelReader.getData(i, "Faculty", "ReviewPosting"));
	rrf.enterOther(ExcelReader.getData(i, "Others", "ReviewPosting"));
	rrf.enterTitle(ExcelReader.getData(i, "Title", "ReviewPosting"));
	rrf.selectRating();
	rrf.selectRecommend();
	Thread.sleep(2000);
	rrf.enterFname(ExcelReader.getData(i, "Fname", "ReviewPosting"));
	rrf.enterLname(ExcelReader.getData(i, "Lname", "ReviewPosting"));
	rrf.enterEmail(); //pc_reviewrating@test.104
	rrf.enterSocial(ExcelReader.getData(i, "SocialProfileURL", "ReviewPosting"));
	rrf.enterMobile();
	rrf.clickSubmit();
	rrf.verifyThankyou(ExcelReader.getData(i, "Fname", "ReviewPosting"));

	} 
		catch (Exception e) {
		System.out.println(e.toString());
	}

	finally {
		CommonFunctions.closeChild(parent, child1, report);
	}
		}
}
	
	
	
	}


