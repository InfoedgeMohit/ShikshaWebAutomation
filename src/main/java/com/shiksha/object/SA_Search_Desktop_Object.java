package com.shiksha.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class SA_Search_Desktop_Object {

	CommonFunctions CommonFunctions = new CommonFunctions();
	String finalResult;
	WebDriver driver;
	ExtentTest child;

	public SA_Search_Desktop_Object(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;

	}

	public void OpenSearchLayer() throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("OpenSearchLayer"));
			driver.findElement(FetchData.readOR("OpenSearchLayer")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw e; // // Do nothing
		}
	}

	public void ClickOnSearchTextBox() {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("OpenSearchLayer"));
			driver.findElement(FetchData.readOR("OpenSearchLayer")).click();
		} catch (Exception e) {
		}
	}

	public void TypeCourseText(String TypeText) throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("ClickOnSearchBox"));
			driver.findElement(FetchData.readOR("ClickOnSearchBox")).sendKeys(
					TypeText);

		} catch (Exception e) {
			throw e; // // Do nothing
		}
	}

	public void selectCourseFromSuggestor(String TypeText) {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("waitCourseSuggestorLayer"));
			Thread.sleep(2000);
			List<WebElement> courseList = driver.findElements(By
					.xpath(".//span[@class='getName']"));
			int NumberOfElements = courseList.size();
			System.out.println("NumberOfElements is :: " + NumberOfElements);

			for (int i = 0; i < NumberOfElements; i++) {
				System.out.println(courseList.get(i).getText());
				System.out.println("TypeText here is :: " + TypeText);
				if (TypeText.equalsIgnoreCase(courseList.get(i).getText())) {
					System.out.println("CourseName matched is :: "
							+ courseList.get(i).getText());
					courseList.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void TypeLocationText(String Location) throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("SelectLocation"));
			driver.findElement(FetchData.readOR("SelectLocation")).sendKeys(
					Location);
		} catch (Exception e) {
			// throw e; // // Do nothing
		}
	}

	public void selectLocationFromSuggestor(String Location) {
		try {

			Variables.elementWait(driver, 10,
					FetchData.readOR("waitLocationSuggestorLayer"));

			java.util.List<WebElement> allLocations = driver.findElements(By
					.xpath(".//*[@id='locSuggs']/ul/li/div/span[1]"));
			int sizeOfLocationList = allLocations.size();

			for (int loop = 0; loop < sizeOfLocationList; loop++) {
				if (Location.equalsIgnoreCase(allLocations.get(loop).getText())) {
					allLocations.get(loop).click();
					break;
				}
			}
		} catch (Exception e) {
			// throw e; // // Do nothing
		}
	}

	public void SelectFeesLeft() throws Exception {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("SelectFees"));
			WebElement slider = driver.findElement(By
					.xpath(".//*[@id='feeSlider']/span[1]"));
			slider.click();
			slider.sendKeys(Keys.ARROW_RIGHT);
			slider.sendKeys(Keys.ARROW_RIGHT);
			slider.sendKeys(Keys.ARROW_RIGHT);
			// Variables.elementWait(driver, 10,
			// FetchData.readOR("SelectFees"));
			// driver.findElement(FetchData.readOR("SelectFees")).sendKeys(
			// SelectFees);

		} catch (Exception e) {
			System.out.println(e.toString());
			throw e; // // Do nothing
		}
	}

	public void SelectFeesRight() throws Exception {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("SelectFees"));
			WebElement slider = driver.findElement(By
					.xpath(".//*[@id='feeSlider']/span[2]"));
			slider.click();
			slider.sendKeys(Keys.ARROW_LEFT);
			slider.sendKeys(Keys.ARROW_LEFT);
			slider.sendKeys(Keys.ARROW_LEFT);
			// Variables.elementWait(driver, 10,
			// FetchData.readOR("SelectFees"));
			// driver.findElement(FetchData.readOR("SelectFees")).sendKeys(
			// SelectFees);

		} catch (Exception e) {
			System.out.println(e.toString());
			throw e; // // Do nothing
		}
	}

	// Get fees details
	public void SelectedFees() throws Exception {
		try {
			String leftslider = driver.findElement(
					By.xpath("(//span[@class='leftLabel'])[1]")).getText();
			System.out.println("Left slider fees" + leftslider);
			String rightslider = driver.findElement(
					By.xpath("(//span[@class='rightLabel'])[1]")).getText();
			System.out.print("Right slider fees" + rightslider);
		} catch (Exception e) {
			throw e; // // Do nothing
		}
	}

	public void HitSearch() throws Exception {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("HitSearch"));
			driver.findElement(FetchData.readOR("HitSearch")).click();

		} catch (Exception e) {
			throw e; // // Do nothing
		}
	}

	// Have to discuss
	public void FeesrightSlider(String rightFees) throws Exception {
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("FeesRightSlider"));
			driver.findElement(FetchData.readOR("FeesRightSlider")).click();

		} catch (Exception e) {
			throw e; // // Do nothing
		}
	}

	public void SelectExam(String exam) throws Exception {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("SelectExam"));
			driver.findElement(FetchData.readOR("SelectExam")).click();

			List<WebElement> wef = driver.findElements(FetchData
					.readOR("SelectExamfromlist"));

			for (WebElement webElement : wef) {
				// System.out.println(webElement.getText());
				if (webElement.getText().equalsIgnoreCase(exam)) {
					webElement.click();
					break;
				}
			}

		} catch (Exception e) {
			// throw e; // // Do nothing
		}
	}

	public void SelectExamLeft() throws Exception {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("SelectFees"));
			WebElement slider = driver.findElement(By
					.xpath(".//*[@id='examScoreSlider']/span[1]"));
			slider.click();
			slider.sendKeys(Keys.ARROW_RIGHT);
			slider.sendKeys(Keys.ARROW_RIGHT);
			slider.sendKeys(Keys.ARROW_RIGHT);

		} catch (Exception e) {
			System.out.println(e.toString());
			throw e; // // Do nothing
		}
	}

	public void SelectExamRight() throws Exception {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("SelectFees"));
			WebElement slider = driver.findElement(By
					.xpath(".//*[@id='examScoreSlider']/span[2]"));
			slider.click();
			slider.sendKeys(Keys.ARROW_LEFT);
			slider.sendKeys(Keys.ARROW_LEFT);
			slider.sendKeys(Keys.ARROW_LEFT);

		} catch (Exception e) {
			System.out.println(e.toString());
			throw e; // // Do nothing
		}
	}

	public void SelectedExamRange() throws Exception {
		try {
			String Examleftslider = driver.findElement(
					By.xpath("(//span[@class='leftLabel'])[2]")).getText();
			System.out.println("Left slider Exam score" + Examleftslider);
			String Examrightslider = driver.findElement(
					By.xpath("(//span[@class='leftLabel'])[2]")).getText();
			System.out.println("Right slider Exam score" + Examrightslider);
		} catch (Exception e) {
			throw e; // // Do nothing
		}
	}
	
	
	
}