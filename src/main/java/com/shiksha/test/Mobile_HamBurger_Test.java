package com.shiksha.test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.Mobile_HamBurger;
import com.shiksha.resourses.CommonFunctions;

public class Mobile_HamBurger_Test {
	Mobile_HamBurger specl = null;
	CommonFunctions CommonFunctions = new CommonFunctions();
	
	public void hamburger_College_Specialization(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child1 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			
			CommonFunctions.info(child1,"\n Hamburger for Specilization started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child1);
			driver.get(url);
			specl.clickHamburger();
			specl.clickSpecialization();
			List<WebElement> speclilzation = specl.FetchListForSpecialization();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickSpecialization();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				int catid = specl.getCatId("(" + xpath + ")[" + i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");

				List<WebElement> speclilzationsubMenu = specl
						.FetchListForSpecializationSubMenu(Integer
								.toString(catid));
				int j = 1;
				for (WebElement webElementsubMenu : speclilzationsubMenu) {
					driver.get(url);
					String xpath1 = CommonFunctions
							.createXpath(webElementsubMenu);
					specl.clickHamburger();
					specl.clickSpecialization();
					// // Click business
					specl.clickElements("(" + xpath + ")[" + i + "]");
					String subStream = specl.clickElementsGetText("(" + xpath1
							+ ")[" + j + "]");
					if (subStream.length() > 2) {
						int subcatid = specl.getSubCatId("(" + xpath1 + ")["
								+ j + "]");
						// // Click all business
						specl.clickElements("(" + xpath1 + ")[" + j + "]");
						specl.clickLocation();

						if (subcatid > 0) {
							List<WebElement> speclilzationfinalsubMenu = specl
									.FetchListForSpeunCat(
											Integer.toString(catid),
											Integer.toString(subcatid));
							int k = 1;
							if (speclilzationfinalsubMenu != null) {
								for (WebElement webElementsubMenu1 : speclilzationfinalsubMenu) {
									String xpath2 = CommonFunctions
											.createXpath(webElementsubMenu1);
									driver.get(url);
									specl.clickHamburger();
									specl.clickSpecialization();
									specl.clickElements("(" + xpath + ")[" + i
											+ "]");
									specl.clickElements("(" + xpath1 + ")[" + j
											+ "]");
									String subStream2 = specl
											.clickElementsGetText("(" + xpath2
													+ ")[" + k + "]");
									if (subStream2.length() > 2) {
										specl.clickElements("(" + xpath2 + ")["
												+ k + "]");
										specl.clickLocation();
										CommonFunctions.info(child1,stream + "+"
												+ subStream + "+" + subStream2
												+ specl.returnTitle() + "\n");
										System.out.println(stream + "+"
												+ subStream + "+" + subStream2
												+ "+" + specl.returnTitle()
												+ "\n");
									}
									k++;
								}
							}
						}
					}
					CommonFunctions.info(child1,stream + "+" + subStream + "+"
							+ specl.returnTitle() + "\n");
					System.out.println(stream + "+" + subStream + "+"
							+ specl.returnTitle() + "\n");
					j++;
					Thread.sleep(1000);
				}
				i++;
			}
			CommonFunctions
					.info(child1,"\n Hamburger for Specilization completed");
		} catch (Exception e) {
			CommonFunctions.info(child1,"\n Hamburger for Specilization Failed");
		}
		
		finally{
			CommonFunctions.closeChild(parent, child1, report);
		}
	}

	public void hamburger_College_Course(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child2 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child2,"\n Hamburger for course started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child2);
			driver.get(url);
			specl.clickHamburger();
			specl.clickCourse();
			List<WebElement> speclilzation = specl.FetchListForCourse();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickCourse();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				int catid = specl.getCatId("(" + xpath + ")[" + i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");
				List<WebElement> speclilzationsubMenu = specl
						.FetchListForCourseSubMenu(Integer.toString(catid));
				int j = 1;
				for (WebElement webElementsubMenu : speclilzationsubMenu) {
					driver.get(url);
					String xpath1 = CommonFunctions
							.createXpath(webElementsubMenu);
					specl.clickHamburger();
					specl.clickCourse();
					// // Click business
					specl.clickElements("(" + xpath + ")[" + i + "]");
					String subStream = specl.clickElementsGetText("(" + xpath1
							+ ")[" + j + "]");
					// // Click all business
					specl.clickElements("(" + xpath1 + ")[" + j + "]");
					specl.clickLocation();
					CommonFunctions.info(child2,stream + "+" + subStream + "+"
							+ specl.returnTitle() + "\n");
					System.out.println(stream + "+" + subStream + "+"
							+ specl.returnTitle() + "\n");
					j++;
				}
				i++;
				Thread.sleep(1000);
			}
			CommonFunctions
					.info(child2,"\n Hamburger for course completed");
		} catch (Exception e) {
			CommonFunctions.info(child2,"\n Hamburger for course Failed");
		}
		
		finally{
			CommonFunctions.closeChild(parent, child2, report);
		}
	}

	public void hamburger_College_Ranking(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child3 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child3,"\n Hamburger for ranking started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child3);
			driver.get(url);
			specl.clickHamburger();
			specl.clickRanking();
			List<WebElement> speclilzation = specl.FetchListForRanking();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickRanking();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				int catid = specl.getCatId("(" + xpath + ")[" + i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");

				List<WebElement> speclilzationsubMenu = specl
						.FetchListForRankingSubMenu(Integer.toString(catid));
				int j = 1;
				for (WebElement webElementsubMenu : speclilzationsubMenu) {
					driver.get(url);
					String xpath1 = CommonFunctions
							.createXpath(webElementsubMenu);
					specl.clickHamburger();
					specl.clickRanking();
					// // Click business
					specl.clickElements("(" + xpath + ")[" + i + "]");
					String subStream = specl.clickElementsGetText("(" + xpath1
							+ ")[" + j + "]");
					// // Click all business
					specl.clickElements("(" + xpath1 + ")[" + j + "]");
					specl.clickLocation();
					CommonFunctions.info(child3,stream + "+" + subStream + "+"
							+ specl.returnRankingTitle() + "\n");
					System.out.println(stream + "+" + subStream + "+"
							+ specl.returnRankingTitle() + "\n");

					j++;
				}
				i++;
				Thread.sleep(1000);
			}
			CommonFunctions
					.info(child3, "\n Hamburger for ranking completed");
		} catch (Exception e) {
			CommonFunctions.info(child3,"\n Hamburger for ranking Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child3, report);

		}
	}

	public void hamburger_College_Reviews(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child4 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child4, "\n Hamburger for reviews started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child4);
			driver.get(url);
			specl.clickHamburger();
			specl.clickReviews();
			List<WebElement> speclilzation = specl.FetchListForReview();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickReviews();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");

				i++;
				CommonFunctions.info(child4,stream + "+"
						+ specl.returnreviewTitle() + "\n");
				System.out.println(stream + "+" + specl.returnreviewTitle()
						+ "\n");
				Thread.sleep(1000);
			}
			CommonFunctions
					.info(child4,"\n Hamburger for reviews completed");
		} catch (Exception e) {
			CommonFunctions.info(child4,"\n Hamburger for reviews Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child4, report);
		}
	}

	public void hamburger_College_compare(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child5 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child5, "\n Hamburger for compare started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child5);
			driver.get(url);
			specl.clickHamburger();
			specl.clickCompare();
			CommonFunctions.info(child5,specl.returncompareTitle() + "\n");
			System.out.println(specl.returncompareTitle() + "\n");
			Thread.sleep(1000);
			CommonFunctions.info(child5,"\n Hamburger for compare completed");
		} catch (Exception e) {
			CommonFunctions.info(child5,"\n Hamburger for compare Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child5, report);
		}
	}
	
	public void hamburger_College_ExamDetail(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child6 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child6, "\n Hamburger for exam detail started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child6);
			driver.get(url);
			specl.clickHamburger();
			specl.clickRanking();
			List<WebElement> speclilzation = specl.FetchListForExamDetail();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickExamDetail();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				int catid = specl.getCatId("(" + xpath + ")[" + i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");

				List<WebElement> speclilzationsubMenu = specl
						.FetchListForExamDetailSubMenu(Integer.toString(catid));
				int j = 1;
				for (WebElement webElementsubMenu : speclilzationsubMenu) {
					driver.get(url);
					String xpath1 = CommonFunctions
							.createXpath(webElementsubMenu);
					specl.clickHamburger();
					specl.clickExamDetail();
					// // Click business
					specl.clickElements("(" + xpath + ")[" + i + "]");
					String subStream = specl.clickElementsGetText("(" + xpath1
							+ ")[" + j + "]");
					// // Click all business
					specl.clickElements("(" + xpath1 + ")[" + j + "]");
					specl.clickLocation();
					CommonFunctions.info(child6, stream + "+" + subStream + "+"
							+ specl.returnExamDetailTitle() + "\n");
					System.out.println(stream + "+" + subStream + "+"
							+ specl.returnExamDetailTitle() + "\n");
					j++;
				}
				i++;
				Thread.sleep(1000);
			}
			CommonFunctions.info(child6, "\n Hamburger for exam detail completed");
		} catch (Exception e) {
			CommonFunctions.info(child6, "\n Hamburger for exam detail Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child6, report);
		}
	}
	
	public void hamburger_Exam_Dates(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child7 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child7,"\n Hamburger for exam dates started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child7);
			driver.get(url);
			specl.clickHamburger();
			specl.clickExamDates();
			List<WebElement> speclilzation = specl.FetchListForExamDates();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickExamDates();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");
				specl.removelayer();
				i++;
				CommonFunctions.info(child7,stream + "+"
						+ specl.returnExamDatesTitle() + "\n");
				System.out.println(stream + "+" + specl.returnExamDatesTitle()
						+ "\n");
				Thread.sleep(1000);
			}
			CommonFunctions.info(child7,"\n Hamburger for exam dates completed");
		} catch (Exception e) {
			CommonFunctions.info(child7,"\n Hamburger for exam dates Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child7, report);
		}
	}
	
	public void hamburger_Predict_Exam_Rank(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child8 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child8,"\n Hamburger for exam rank started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child8);
			driver.get(url);
			specl.clickHamburger();
			specl.clickpredictExamRank();
			List<WebElement> speclilzation = specl.FetchListForPredictExamRank();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickpredictExamRank();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");
				i++;
				CommonFunctions.info(child8,stream + "+"
						+ specl.returnPredictExamRankTitle() + "\n");
				System.out.println(stream + "+" + specl.returnPredictExamRankTitle()
						+ "\n");
				Thread.sleep(1000);
			}
			CommonFunctions.info(child8,"\n Hamburger for exam rank completed");
		} catch (Exception e) {
			CommonFunctions.info(child8,"\n Hamburger for exam rank Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child8, report);
		}
	}

	public void hamburger_Predict_College_Rank(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child9 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child9, "\n Hamburger for college rank started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child9);
			driver.get(url);
			specl.clickHamburger();
			specl.clickpredictcollegeRank();
			List<WebElement> speclilzation = specl.FetchListForPredictCollegeRank();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickpredictcollegeRank();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");
				i++;
				CommonFunctions.info(child9,stream + "+"
						+ specl.returnPredictCollegeRankTitle() + "\n");
				System.out.println(stream + "+" + specl.returnPredictCollegeRankTitle()
						+ "\n");
				Thread.sleep(2000);
			}
			CommonFunctions.info(child9,"\n Hamburger for college rank completed");
		} catch (Exception e) {
			CommonFunctions.info(child9,"\n Hamburger for college rank Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child9, report);
		}
	}	
	
	public void hamburger_IIM_Call_Predictor(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child10 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child10,"\n Hamburger for IIM_Call_Predictor started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child10);
			driver.get(url);
			specl.clickHamburger();
			specl.clickIIM();
			CommonFunctions.info(child10,specl.returnIIMTitle() + "\n");
			System.out.println(specl.returnIIMTitle() + "\n");
			Thread.sleep(1000);
			CommonFunctions.info(child10,"\n Hamburger for IIM_Call_Predictor completed");
		} catch (Exception e) {
			CommonFunctions.info(child10,"\n Hamburger for IIM_Call_Predictor Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child10, report);
		}
	}
	
	public void hamburger_Check_Salary(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child11 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child11, "\n Hamburger for Check_Salary started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child11);
			driver.get(url);
			specl.clickHamburger();
			specl.clickSalary();
			CommonFunctions.info(child11, specl.returnSalaryTitle() + "\n");
			System.out.println(specl.returnSalaryTitle() + "\n");
			Thread.sleep(1000);
			CommonFunctions.info(child11, "\n Hamburger for Check_Salary completed");
		} catch (Exception e) {
			CommonFunctions.info(child11, "\n Hamburger for Check_Salary Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child11, report);
		}

	}
	
	public void hamburger_Ask_Shiskha_Experts(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child12 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child12,"\n Hamburger for Ask_Shiskha_Experts started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child12);
			driver.get(url);
			specl.clickHamburger();
			specl.clickAskExperts();
			CommonFunctions.info(child12,specl.returnQnABox() + "\n");
			System.out.println(specl.returnQnABox() + "\n");
			Thread.sleep(1000);
			CommonFunctions.info(child12,"\n Hamburger for Ask_Shiskha_Experts completed");
		} catch (Exception e) {
			CommonFunctions.info(child12,"\n Hamburger for Ask_Shiskha_Experts Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child12, report);
		}
	}
	
	public void hamburger_Current_Students(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child13 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child13, "\n Hamburger for ask current students started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child13);
			driver.get(url);
			specl.clickHamburger();
			specl.clickaskcurrentstudents();
			List<WebElement> speclilzation = specl.FetchListForCurrentStudents();
			int i = 1;
			for (WebElement webElement : speclilzation) {
				driver.get(url);
				String xpath = CommonFunctions.createXpath(webElement);
				specl.clickHamburger();
				specl.clickaskcurrentstudents();
				// // click specilizatin
				String stream = specl.clickElementsGetText("(" + xpath + ")["
						+ i + "]");
				specl.clickElements("(" + xpath + ")[" + i + "]");
				i++;
				CommonFunctions.info(child13, stream + "+"
						+ specl.returnaskcurrentstudentTitle() + "\n");
				System.out.println(stream + "+" + specl.returnaskcurrentstudentTitle()
						+ "\n");
				Thread.sleep(2000);
			}
			CommonFunctions.info(child13, "\n Hamburger for ask current students completed");
		} catch (Exception e) {
			CommonFunctions.info(child13, "\n Hamburger for ask current students Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child13, report);
		}
	}
	
	public void hamburger_News_Articles(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver  = obj.getDriver();
		ExtentTest child14 = CommonFunctions.createChild(report,obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());
		try {
			CommonFunctions.info(child14, "\n Hamburger for News_Articles started");
			// ExcelReader.readHamburgerExcel("");
			specl = new Mobile_HamBurger(driver,child14);
			driver.get(url);
			specl.clickHamburger();
			specl.clickAskExperts();
			CommonFunctions.info(child14, specl.returnQnABox() + "\n");
			System.out.println(specl.returnQnABox() + "\n");
			Thread.sleep(1000);
			CommonFunctions.info(child14, "\n Hamburger for News_Articles completed");
		} catch (Exception e) {
			CommonFunctions.info(child14, "\n Hamburger for News_Articles Failed");
		}
		finally{
			CommonFunctions.closeChild(parent, child14, report);
		}
	}
	
}