package com.shiksha.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.SA_Search_Mobile;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.ExcelReader;


public class SA_Search_Mobile_Test {

	String url = "";
	public String FinalUrl = "";
	CommonFunctions CommonFunctions = new CommonFunctions();
	String srpTitle = ""; 
	

	public void AbroadSearchMobile(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
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

		for (int i = 0; i < ExcelReader.getRows("SA_Search_Mobile"); i++) {

			ExtentTest child1 = CommonFunctions.createChild(
					report,
					"Search for Criteria : "
							+ ExcelReader.getData(i, "Search Criteria",
									"SA_Search_Mobile"), "");
			CommonFunctions.info(
					child1,
					"Search Criteria :"
							+ ExcelReader.getData(i, "Search Criteria",
									"SA_Search_Mobile")
							+ "<br/> With Keyword : "
							+ ExcelReader.getData(i, "Keyword", "SA_Search_Mobile")
							+ "<br/> With Type of Search : "
							+ ExcelReader.getData(i, "Search type", "SA_Search_Mobile")
							+ "<br/> for location : "
							+ ExcelReader.getData(i, "Location", "SA_Search_Mobile")
							+ "<br/> Fees selected : "
							+ ExcelReader.getData(i, "Cost", "SA_Search_Mobile")
							+ "<br/> Exam : "
							+ ExcelReader.getData(i, "Exam Name", "SA_Search_Mobile")
							);

		
			try {
			
				//ExtentTest child1 = null;
				SA_Search_Mobile SASM = new SA_Search_Mobile(driver, child1);
			//	CommonFunctions.info(child1, "ACTUAL URL : " + url);
				driver.get(FinalUrl);
				SASM.OpenSearchLayer();
				SASM.TypeCourseText(ExcelReader.getData(i, "Keyword",
						"SA_Search_Mobile"));
				SASM.selectCourseFromSuggestor(ExcelReader.getData(i, "Keyword",
						"SA_Search_Mobile"));
				SASM.TypeLocationText(ExcelReader.getData(i, "Location",
						"SA_Search_Mobile"));
				SASM.selectLocationFromSuggestor(ExcelReader.getData(i,
						"Location", "SA_Search_Mobile"));
				try {
				SASM.SelectFeesLeft();
				SASM.SelectFeesRight();
				SASM.SelectedFees();
				} catch (Exception e) {
				}

				try {
				SASM.SelectExam(ExcelReader.getData(i, "Exam Name",
						"SA_Search_Mobile"));
				SASM.SelectExamLeft();
				SASM.SelectExamRight();
				SASM.TypeCourseText(ExcelReader.getData(i, "Solr url",
						"SA_Search_Mobile"));
				}

				catch (Exception e) {
				}
				try {
					SASM.SelectUniversityLevel(ExcelReader.getData(i, "Level",
							"SA_Search_Mobile"));
//					SASM.SelectExamLeft();
//					SASM.SelectExamRight();
					}

					catch (Exception e) {
					}
				SASM.HitSearch();
				Thread.sleep(3000);
				String mobilesrpURl = driver.getCurrentUrl();
				CommonFunctions.info(child1, "Actual url is :: " + mobilesrpURl);
				CommonFunctions.info(child1, "Expected url is :: " 
						+ ExcelReader.getData(i, "Expected URL",
								"SA_Search_Mobile"));
				srpTitle = driver.findElement(By.xpath("//div[@class='rsPge-tit']")).getText();
				srpTitle=srpTitle.split(" ")[0];
				System.out.println("srpTitle is ::" + srpTitle);
				CommonFunctions.info(child1, "Count on SRP is :: " + srpTitle);
				
				System.out.println("Getting Page Source-------");
				String SOLRCOUNT = PageSource.getSOLRCount(ExcelReader.getData(i, "Solr_url","SA_Search"), driver, "int", "name", "ngroups");
				
				System.out.println("SOLRCOUNT is ::" + SOLRCOUNT);
				CommonFunctions.info(child1, "Count on SOLR is :: " + SOLRCOUNT);
				if(SOLRCOUNT.equalsIgnoreCase(srpTitle)) {
					System.out.println("Yes I did it..........................");
				}
				driver.get(FinalUrl);
				Thread.sleep(2000);

			} catch (Exception e) {
				continue;
			} finally {
				CommonFunctions.closeChild(parent, child1, report);
				// SAS.ClickOnSearchTextBox();
				// CommonFunctions.closeChild(parent, child2, report);
			}
		}
		}
				
}

