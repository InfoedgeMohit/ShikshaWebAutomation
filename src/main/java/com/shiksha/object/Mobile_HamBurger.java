package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class Mobile_HamBurger {

	WebDriver driver;
	ExtentTest child1;
	List<Object> child = new ArrayList<Object>();


	public Mobile_HamBurger(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child1 = child;

		this.child.add(this.driver);
		this.child.add(this.child1);
	}
	CommonFunctions CommonFunctions = new CommonFunctions();
	public void clickHamburger(){
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("ham"));
			CommonFunctions.scrollToElement(FetchData.readOR("ham"),driver);
			driver.findElement(FetchData.readOR("ham")).click();
			CommonFunctions.pass(child, "\nClick Hamburger Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick Hamburger Failed");
			throw e;
		}
	}

	public void clickSpecialization(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("Specialization"));
			CommonFunctions.scrollToElement(FetchData.readOR("Specialization"),driver);
			driver.findElement(FetchData.readOR("Specialization")).click();
			CommonFunctions.pass(child, "\nclick Specialization Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick Specialization Failed");
			throw e;
		}
	}

	public void clickCourse(){
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("course"));
			CommonFunctions.scrollToElement(FetchData.readOR("course"),driver);
			driver.findElement(FetchData.readOR("course")).click();
			CommonFunctions.pass(child, "\nclick course Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick course Failed");
			throw e;
		}
	}

	public void clickRanking(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("ranking"));
			CommonFunctions.scrollToElement(FetchData.readOR("ranking"),driver);
			driver.findElement(FetchData.readOR("ranking")).click();
			CommonFunctions.pass(child, "\nclick ranking Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick ranking Failed");
			throw e;
		}
	}
	
	
	public void clickExamDetail(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("examdetail"));
			CommonFunctions.scrollToElement(FetchData.readOR("examdetail"),driver);
			driver.findElement(FetchData.readOR("examdetail")).click();
			CommonFunctions.pass(child, "\nclick exam detail Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick exam detail Failed");
			throw e;
		}
	}


	public List<WebElement> FetchListForSpecialization(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("SpecializationCategories"));
			CommonFunctions.pass(child, "\nFetchListForSpecialization Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForSpecialization Failed");
			throw e;
		}
	}

	public List<WebElement> FetchListForCourse(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("CourseCategories"));
			CommonFunctions.pass(child, "\nFetchListForCourse Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForCourse Failed");
			throw e;
		}
	}

	public List<WebElement> FetchListForRanking(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("RankingCategories"));
			CommonFunctions.pass(child, "\nFetchListForRanking Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForRanking Failed");
			throw e;
		}
	}

	public List<WebElement> FetchListForSpecializationSubMenu(String catId)
			throws Exception {
		try {
			String[] element = new String[2];
			element = Variables.objects.get("FinalSubElements");
			String xPath = element[1].replace("mycatid", catId);
			List<WebElement> speclilzation = driver.findElements(By
					.xpath(xPath));
			CommonFunctions.pass(child, "\nFinal Sub Elements speclization Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFinal Sub Elements speclization Failed");
			throw e;
		}
	}

	public List<WebElement> FetchListForCourseSubMenu(String catId)
			throws Exception {
		try {
			String[] element = new String[2];
			element = Variables.objects.get("FinalSubElementsCourse");
			String xPath = element[1].replace("mycatid", catId);
			List<WebElement> speclilzation = driver.findElements(By
					.xpath(xPath));
			CommonFunctions.pass(child, "\nFinal Sub Elements course Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFinal Sub Elements course Failed");
			throw e;
		}
	}

	public List<WebElement> FetchListForRankingSubMenu(String catId)
			throws Exception {
		try {
			String[] element = new String[2];
			element = Variables.objects.get("FinalSubElementsRanking");
			String xPath = element[1].replace("mycatid", catId);
			List<WebElement> speclilzation = driver.findElements(By
					.xpath(xPath));
			CommonFunctions.pass(child, "\nFinal Sub Elements ranking Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFinal Sub Elements ranking Failed");
			throw e;
		}
	}

	public List<WebElement> FetchListForSpeunCat(String catId, String subCat)
			throws Exception {
		List<WebElement> speclilzation = null;
		try {
			String[] element = new String[2];
			element = Variables.objects.get("FinalSubCatElements");
			String xPath = element[1].replace("mycatid", catId);
			xPath = xPath.replace("mysubcatid", subCat);
			speclilzation = driver.findElements(By.xpath(xPath));
			CommonFunctions.pass(child, "\nFinal Sub Elements Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFinal Sub Elements Failed");
			return speclilzation;
		}
	}

	public void clickElements(String we) throws Exception{
		try {
			Thread.sleep(2000);
			Variables.elementWait(driver, 10, By.xpath(we));
			CommonFunctions.scrollToElement(By.xpath(we),driver);
			driver.findElement(By.xpath(we)).click();
			CommonFunctions.pass(child, "\nclickElements for xpath Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclickElements for xpath Failed");
			throw e;
		}
	}

	public String clickElementsGetText(String we){
		try {
			Variables.elementWait(driver, 10, By.xpath(we));
			String stream = driver.findElement(By.xpath(we)).getText();
			CommonFunctions.scrollToElement(By.xpath(we),driver);
			CommonFunctions.pass(child, "\nclickElementsGetText Passed");
			return stream;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclickElementsGetText Failed");
			return "";
		}
	}

	public int getCatId(String we){
		try {
			Variables.elementWait(driver, 10, By.xpath(we));
			int catId = Integer.parseInt(driver.findElement(By.xpath(we))
					.getAttribute("catid"));
			CommonFunctions.pass(child, "\ngetCatId Passed");
			return catId;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ngetCatId Failed");
			return 0;
		}
	}

	public int getSubCatId(String we){
		try {
			Variables.elementWait(driver, 10, By.xpath(we));
			int catId = Integer.parseInt(driver.findElement(By.xpath(we))
					.getAttribute("subcatid"));
			CommonFunctions.pass(child, "\ngetSubCatId Passed");
			return catId;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ngetSubCatId Failed");
			return 0;
		}
	}

	public void clickLocation(){
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("selectLocation"));
			CommonFunctions.scrollToElement(FetchData.readOR("selectLocation"),driver);
			driver.findElement(FetchData.readOR("selectLocation")).click();
			CommonFunctions.info(child, "\nclickLocation Passed");
		} catch (Exception e) {
			CommonFunctions.info(child, "\nclickLocation Failed");
		}
	}

	public String returnTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("pageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle specilizationa and course  Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle specilization and course Failed");
			return "";
			// throw e;
		}
	}
	
	public String returnRankingTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("rankingpageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle ranking Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle ranking Failed");
			return "";
			// throw e;
		}
	}
	
	public String returncompareTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("comparepageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle compare Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle compare Failed");
			return "";
			// throw e;
		}
	}
	
	public String returnIIMTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("IIMpageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle IIM Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle IIM Failed");
			return "";
			// throw e;
		}
	}
	
	
	public String returnSalaryTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("SalarypageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle Salary Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle Salary Failed");
			return "";
			// throw e;
		}
	}
	
	public String returnQnABox(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("QnABox_Ask_Experts"));
			CommonFunctions.pass(child, "\nreturnTitle QnA Box Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle  QnA Box Failed");
			return "";
			// throw e;
		}
	}
	
	public String returnreviewTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("reviewpageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle reviews Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle reviews Failed");
			return "";
			// throw e;
		}
	}
	
	public String returnExamDatesTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("examDatePageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle examdates Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle examdates Failed");
			return "";
			// throw e;
		}
	}
	
	public void clickReviews(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("review"));
			CommonFunctions.scrollToElement(FetchData.readOR("review"),driver);
			driver.findElement(FetchData.readOR("review")).click();
			CommonFunctions.pass(child, "\nclick review Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick review Failed");
			throw e;
		}
	}
	
	public void clickExamDates(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("ExamDates"));
			CommonFunctions.scrollToElement(FetchData.readOR("ExamDates"),driver);
			driver.findElement(FetchData.readOR("ExamDates")).click();
			CommonFunctions.pass(child, "\nclick ExamDates Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick ExamDates Failed");
			throw e;
		}
	}
	
	public void clickpredictExamRank(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("PredictExamRank"));
			CommonFunctions.scrollToElement(FetchData.readOR("PredictExamRank"),driver);
			driver.findElement(FetchData.readOR("PredictExamRank")).click();
			CommonFunctions.pass(child, "\nclick predictExamRank Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick predictExamRank Failed");
			throw e;
		}
	}
	
	public void clickpredictcollegeRank(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("PredictcollegeRank"));
			CommonFunctions.scrollToElement(FetchData.readOR("PredictcollegeRank"),driver);
			driver.findElement(FetchData.readOR("PredictcollegeRank")).click();
			CommonFunctions.pass(child, "\nclick predictcollegeRank Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick predictcollegeRank Failed");
			throw e;
		}
	}

	public void clickaskcurrentstudents(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("askcurrentstudents"));
			CommonFunctions.scrollToElement(FetchData.readOR("askcurrentstudents"),driver);
			driver.findElement(FetchData.readOR("askcurrentstudents")).click();
			CommonFunctions.pass(child, "\nclick predictcollegeRank Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick predictcollegeRank Failed");
			throw e;
		}
	}

	
	public List<WebElement> FetchListForReview(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("ReviewCategories"));
			CommonFunctions.pass(child, "\nFetchListForReview Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForReview Failed");
			throw e;
		}
	}
	
	public List<WebElement> FetchListForExamDates(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("ExamDates_1"));
			CommonFunctions.pass(child, "\nFetchListForExamDates Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForExamDates Failed");
			throw e;
		}
	}


	public void clickCompare(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("compare"));
			CommonFunctions.scrollToElement(FetchData.readOR("compare"),driver);
			driver.findElement(FetchData.readOR("compare")).click();
			CommonFunctions.pass(child, "\nclick compare Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick compare Failed");
			throw e;
		}
	}
	
	public void clickIIM(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("IIM"));
			CommonFunctions.scrollToElement(FetchData.readOR("IIM"),driver);
			driver.findElement(FetchData.readOR("IIM")).click();
			CommonFunctions.pass(child, "\nclick iim call predictor Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick iim call predictor Failed");
			throw e;
		}
	}
	
	public void clickSalary(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("Salary"));
			CommonFunctions.scrollToElement(FetchData.readOR("Salary"),driver);
			driver.findElement(FetchData.readOR("Salary")).click();
			CommonFunctions.pass(child, "\nclick Salary Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick Salary Failed");
			throw e;
		}
	}
	
	public void clickAskExperts(){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("askshikshaexperts"));
			CommonFunctions.scrollToElement(FetchData.readOR("askshikshaexperts"),driver);
			driver.findElement(FetchData.readOR("askshikshaexperts")).click();
			CommonFunctions.pass(child, "\nclick ask experts Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick ask experts Failed");
			throw e;
		}
	}
	
	public List<WebElement> FetchListForExamDetail(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("examdetaillist"));
			CommonFunctions.pass(child, "\nFetchListForExamDetail Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForExamDetail Failed");
			throw e;
		}
	}
	
	public List<WebElement> FetchListForExamDetailSubMenu(String catId)
			throws Exception {
		try {
			String[] element = new String[2];
			element = Variables.objects.get("FinalSubElementsExamDetail");
			String xPath = element[1].replace("mycatid", catId);
			List<WebElement> speclilzation = driver.findElements(By
					.xpath(xPath));
			CommonFunctions.pass(child, "\nFinal Sub Elements examdetail Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFinal Sub Elements examdetail Failed");
			throw e;
		}
	}
	public String returnExamDetailTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("examdetailpageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle exam detail Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle exam detail  Failed");
			return "";
			// throw e;
		}
	}
	
	public void removelayer(){
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("layerclose"));
			driver.findElement(FetchData.readOR("layerclose")).click();
			CommonFunctions.pass(child, "\nclickLocation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclickLocation Failed");
		}
	}
	public List<WebElement> FetchListForPredictExamRank(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("Predict_Exam_Rank_1"));
			CommonFunctions.pass(child, "\nFetchListForPredictExamRank Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForPredictExamRank Failed");
			throw e;
		}
	}
	
	public List<WebElement> FetchListForPredictCollegeRank(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("Predict_College_Rank_1"));
			CommonFunctions.pass(child, "\nFetchListForPredictCollegeRank Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForPredictCollegeRank Failed");
			throw e;
		}
	}
	
	public List<WebElement> FetchListForCurrentStudents(){
		try {
			List<WebElement> speclilzation = driver.findElements(FetchData
					.readOR("askcurrentstudents_1"));
			CommonFunctions.pass(child, "\nFetchListForPredictCollegeRank Passed");
			return speclilzation;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFetchListForPredictCollegeRank Failed");
			throw e;
		}
	}
	
	public String returnPredictExamRankTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("predictexamPageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle exam rank Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle exam rank Failed");
			return "";
			// throw e;
		}
	}
	
	public String returnPredictCollegeRankTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("predictcollegePageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle college rank Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle college rank Failed");
			return "";
			// throw e;
		}
	}
	
	
	public String returnaskcurrentstudentTitle(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("askcurrentstudPageLoad"));
			CommonFunctions.pass(child, "\nreturnTitle ask current stud Passed");
			return driver.getCurrentUrl();
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nreturnTitle ask current stud Failed");
			return "";
			// throw e;
		}
	}
}
