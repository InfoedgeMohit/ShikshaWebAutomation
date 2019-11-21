package com.shiksha.object;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class LF_CLP_Posting {

	WebDriver driver;
	ExtentTest child1;

	List<Object> child = new ArrayList<Object>();

	public LF_CLP_Posting(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child1 = child;

		this.child.add(this.driver);
		this.child.add(this.child1);

	}

	CommonFunctions CommonFunctions = new CommonFunctions();

	public void typeInstituteId(String id) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("InstituteId"));
			driver.findElement(FetchData.readOR("InstituteId")).sendKeys(id);
			CommonFunctions.pass(child, "\nType Institute Id Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nType Institute Id Failed");
			throw e;
		}
	}

	public void clickGoButton() {
		try {
			driver.findElement(FetchData.readOR("Go!")).click();
			CommonFunctions.pass(child, "\nClick Go button passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick Go button Failed");
			throw e;
		}
	}

	public void clickToSelectInstitute() {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("selectInstitute"));
			driver.findElement(FetchData.readOR("selectInstitute")).click();
			CommonFunctions.pass(child, "\nSelect Institute Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect Institute Failed");
			throw e;
		}
	}

	public void selectCredential(String Degrre) {
		try {
			driver.findElement(FetchData.readOR("credential")).sendKeys(Degrre);
			CommonFunctions.pass(child, "\nSelect Credential Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect Credential Failed");
			throw e;
		}
	}

	public void selectCourseLevel(String level) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("course_level")));
			driver.findElement(FetchData.readOR("course_level"))
					.sendKeys(level);
			CommonFunctions.pass(child, "\nSelect Level Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect Level Failed");
			throw e;
		}
	}

	public void selectStream(String stream) {
		try {
			driver.findElement(FetchData.readOR("hierarchy_stream")).sendKeys(
					stream);
			CommonFunctions.pass(child, "\nSelect Stream Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect Stream Failed");
			throw e;
		}
	}

	public void selectCourse(String course) {
		try {
			Thread.sleep(3000);
			driver.findElement(FetchData.readOR("course_CLP")).sendKeys(course);
			CommonFunctions.pass(child, "\nSelect Course Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect Course Failed");
			// // Do nothing
		}
	}

	public void typeCourseName(String courseName) {
		try {
			driver.findElement(FetchData.readOR("courseName")).sendKeys(
					courseName);
			CommonFunctions.pass(child, "\nWrite Course Name Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nWrite Course Name Failed");
			throw e;
		}
	}

	public void typeDuration(String duration) {
		try {
			driver.findElement(FetchData.readOR("courseDuration")).sendKeys(
					duration);
			CommonFunctions.pass(child, "\nDuration Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nDuration Failed");
			throw e;
		}
	}

	public void clickApprovingBodies() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("selectApproved")));
			driver.findElement(FetchData.readOR("selectApproved")).click();
			CommonFunctions.pass(child, "\nApproving Bodies Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nApproving Bodies Failed");
		}
	}

	public void selectApprovingBody1() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("selectApprovingBody1")));
			driver.findElement(FetchData.readOR("selectApprovingBody1"))
					.click();
			CommonFunctions.pass(child, "\nApproving Bodies 1 selected Passed");
		} catch (Exception e) {

		}
	}

	public void selectApprovingBody2() {
		try {
			driver.findElement(FetchData.readOR("selectApprovingBody2"))
					.click();
			CommonFunctions.pass(child, "\nApproving Bodies 2 selected Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nApproving Bodies 2 selected Failed");
		}
	}

	public void selectApprovingBody3() {
		try {
			driver.findElement(FetchData.readOR("selectApprovingBody3"))
					.click();
			CommonFunctions.pass(child, "\nApproving Bodies 3 selected Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nApproving Bodies 3 selected Failed");
		}
	}

	public void clickAffiliation() {
		try {

			driver.findElement(FetchData.readOR("affiliationlabel")).click();
			CommonFunctions.pass(child, "\nAffiliation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nAffiliation Failed");
		}
	}

	public void selectDomestic() {
		try {
			driver.findElement(FetchData.readOR("AffiliationDomestic")).click();
			CommonFunctions.pass(child, "\nAffiliation Domestic/Abroad Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nAffiliation Domestic/Abroad Failed");
		}
	}

	public void typeUnivId(String id) {
		try {
			driver.findElement(FetchData.readOR("AffiliationUnivId")).sendKeys(
					id);
			CommonFunctions.pass(child, "\nAffiliation Univ id Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nAffiliation univ id Failed");
		}
	}

	public void clickGoToSelectUniv() {
		try {
			driver.findElement(FetchData.readOR("AffiliationUnivGo")).click();
			CommonFunctions.pass(child, "\nAffiliation Univ Passed");
			Thread.sleep(2000);
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nAffiliation univ Failed");
		}
	}

	public void clickMedium() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Medium")));
			driver.findElement(FetchData.readOR("Medium")).click();
			CommonFunctions.pass(child, "\nclick medium Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclick medium Failed");
		}
	}

	public void selectMedium1() {
		try {
			driver.findElement(FetchData.readOR("Medium1")).click();
			CommonFunctions.pass(child, "\nSelect medium 1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect medium 1 Failed");
		}
	}

	public void selectMedium2() {
		try {
			driver.findElement(FetchData.readOR("Medium2")).click();
			CommonFunctions.pass(child, "\nSelect medium 1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect medium 1 Failed");
		}
	}

	public void selectMedium3() {
		try {
			driver.findElement(FetchData.readOR("Medium3")).click();
			CommonFunctions.pass(child, "\nSelect medium 1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect medium 1 Failed");
		}
	}

	public void clickLabelDiffLabel() {
		try {
			driver.findElement(FetchData.readOR("difflevel")).click();

		} catch (Exception e) {
			// // Do nothing
		}
	}

	public void selectDiffLabelBegneer() {
		try {
			driver.findElement(FetchData.readOR("Beginner")).click();
			CommonFunctions.pass(child, "\nSelect diff level Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSelect diff level failed");
		}
	}

	public void clickUSPAddmore() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("uspaddmore"));
			driver.findElement(FetchData.readOR("uspaddmore")).click();
			CommonFunctions.pass(child, "\nAdd More USP Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nAdd More USP failed");
		}
	}

	public void typeUSP1(String usp1) {
		try {
			driver.findElement(FetchData.readOR("usp1")).sendKeys(usp1);
			CommonFunctions.pass(child, "\n USP 1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP 1 failed");
		}
	}

	public void typeUSP2(String usp2) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("usp2"));
			driver.findElement(FetchData.readOR("usp2")).sendKeys(usp2);
			CommonFunctions.pass(child, "\n USP 2 Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP 2 failed");
		}
	}

	public void typeUSP3(String usp3) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("usp3"));
			driver.findElement(FetchData.readOR("usp3")).sendKeys(usp3);
			CommonFunctions.pass(child, "\n USP 3 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP 3 failed");
		}
	}

	public void clickeventaddmore() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("eventaddmore"));
			driver.findElement(FetchData.readOR("eventaddmore")).click();
			CommonFunctions.pass(child, "\nEvent Add More Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent Add More failed");
		}
	}

	public void clickevent1(String eventtype1) {
		try {
			WebElement we = driver.findElement(FetchData.readOR("eventtype1"));
			Select se = new Select(we);
			se.selectByVisibleText(eventtype1);
			CommonFunctions.pass(child, "\nEvent 1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent 1 failed");
			throw e;
		}
	}

	public void clickevent2(String eventtype2) {
		try {
			WebElement we = driver.findElement(FetchData.readOR("eventtype2"));
			Select se = new Select(we);
			se.selectByVisibleText(eventtype2);
			CommonFunctions.pass(child, "\nEvent 2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent 2 failed");
			throw e;
		}
	}

	public void typeeventDesc1(String eventdesc1) {
		try {
			driver.findElement(FetchData.readOR("eventdesc1")).sendKeys(
					eventdesc1);
			CommonFunctions.pass(child, "\nEvent 1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent 1 failed");
			throw e;
		}
	}

	public void typeeventDesc2(String eventdesc2) {
		try {
			driver.findElement(FetchData.readOR("eventdesc2")).sendKeys(
					eventdesc2);
			CommonFunctions.pass(child, "\nEvent 2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent 2 failed");
			throw e;
		}
	}

	public void coursestructure1(String coursestructure1) {
		try {
			driver.findElement(FetchData.readOR("coursestructure1")).sendKeys(
					coursestructure1);
			CommonFunctions.pass(child, "\nCourse structure 1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nCourse structure 1 failed");
		}
	}

	public void coursestructure2(String coursestructure2) {
		try {
			driver.findElement(FetchData.readOR("coursestructure2")).sendKeys(
					coursestructure2);
			CommonFunctions.pass(child, "\nCourse structure 2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nCourse structure 2 failed");
		}
	}

	public void clickUploadBrochure() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("browse")));
			driver.findElement(FetchData.readOR("browse")).click();
			CommonFunctions.pass(child, "\nBrochure Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nBrochure failed");

		}
	}

	public void uploadBrochurePath(String path) throws AWTException {
		Robot robot = new Robot();
		try {

			String text = path;
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			Thread.sleep(10000);
			if (driver.findElement(FetchData.readOR("brochureCheckCourse"))
					.isDisplayed()) {
				CommonFunctions.pass(child, "\nuploadBrochure Passed");
			}

			else {
				CommonFunctions.fail(child, "\nuploadBrochure Failed");
			}
		} catch (Exception e) {
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			CommonFunctions.fail(child, "\nBrochure failed");
		}
	}

	public void selectCourseFeeYear(int index) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("courseFeeYear")));
			WebElement we = driver.findElement(FetchData
					.readOR("courseFeeYear"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\nFee Year Uploaded");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nFee Year failed");
		}
	}

	public void clickAddMoreToAddMoreFees() {
		try {
			driver.findElement(FetchData.readOR("coursefeeAddMore")).click();
			CommonFunctions.pass(child, "\nAdd More Fees Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nAdd More Fees failed");
		}
	}

	public void enterDataInFields() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("coursefeeData[2]")));
			for (int i = 2; i < 5; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("coursefeeData[" + i + "]"));
				for (WebElement e : elements) {
					int fees = (i * 100000);
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\nEnter Fees Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEnter Fees Failed");
			throw e;
		}
	}

	public void enterDataInFieldsOTP() {
		try {
			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("coursefeeDataOTP[2]")));
			for (int i = 2; i < 5; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("coursefeeDataOTP[" + i + "]"));
				for (WebElement e : elements) {
					int fees = (i * 100000);
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\nOTP Fees Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nOTP Fees Failed");
		}
	}

	public void clickHostel() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("hostel"));
			driver.findElement(FetchData.readOR("hostel")).click();
			CommonFunctions.pass(child, "\nClick Hostel Passed");
		} catch (Exception e) {
			CommonFunctions.pass(child, "\nClick Hostel Failed");
		}
	}

	public void clicktution() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("tution"));
			driver.findElement(FetchData.readOR("tution")).click();
			CommonFunctions.pass(child, "\nClick Tution Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick Tution Failed");
		}
	}

	public void disclamar() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("disclamar")));
			Variables.elementWait(driver, 10, FetchData.readOR("disclamar"));
			driver.findElement(FetchData.readOR("disclamar")).click();
			CommonFunctions.pass(child, "\nClick Disclamar Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick Disclamar Failed");
		}
	}

	public void clickLibrary() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("library_CLP"));
			driver.findElement(FetchData.readOR("library_CLP")).click();
			CommonFunctions.pass(child, "\nClick library Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nClick library failed");
		}
	}

	public void hostelFees() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("hostelFees[2]")));
			for (int i = 2; i < 5; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("hostelFees[" + i + "]"));
				for (WebElement e : elements) {
					int fees = (i * 100000);
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\nhostel fees Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nhostel fees failed");
		}
	}

	public void typeFeeOtherInfo(String info) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("feesotherinfo")));
			Variables
					.elementWait(driver, 10, FetchData.readOR("feesotherinfo"));
			driver.findElement(FetchData.readOR("feesotherinfo"))
					.sendKeys(info);
			CommonFunctions.pass(child, "\nother fees info Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nother fees info Failed");
		}
	}

	public void selectEligibilityYear(int index) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("eligibilityYear"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\nEligibiliy Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEligibiliy Failed");
		}
	}

	public void clickAddMoreToAddMoreExam() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("addMoreToAddExam")));
			Variables.elementWait(driver, 10,
					FetchData.readOR("addMoreToAddExam"));
			driver.findElement(FetchData.readOR("addMoreToAddExam")).click();
			CommonFunctions.pass(child, "\nAdd Exam Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nAdd Exam failed");
		}
	}

	public void selectExam1(String exam1) {
		try {
			WebElement we = driver.findElement(FetchData.readOR("selectExam1"));
			Select se = new Select(we);
			se.selectByVisibleText(exam1);
			CommonFunctions.pass(child, "\n Exam 1 Passed");
		} catch (Exception e) {
			CommonFunctions.pass(child, "\n Exam 1 Failed");
		}
	}

	public void selectExam2(String exam2) {
		try {
			WebElement we = driver.findElement(FetchData.readOR("selectExam2"));
			Select se = new Select(we);
			se.selectByVisibleText(exam2);
			CommonFunctions.pass(child, "\n Exam 2 Passed");
		} catch (Exception e) {
			CommonFunctions.pass(child, "\n Exam 2 Failed");
		}
	}

	public void selectExamUnit1(String exam1) {
		try {
			WebElement we = driver.findElement(FetchData.readOR("examUnit1"));
			Select se = new Select(we);
			se.selectByVisibleText(exam1);
			CommonFunctions.pass(child, "\n Exam unit 1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n Exam unit 1 falied");
		}
	}

	public void selectExamUnit2(String exam2) {
		try {
			WebElement we = driver.findElement(FetchData.readOR("examUnit2"));
			Select se = new Select(we);
			se.selectByVisibleText(exam2);
			CommonFunctions.pass(child, "\n Exam unit 2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nExam unit 2 falied");
		}
	}

	public void eligibility_10() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Eligibilty_10_2")));
			for (int i = 2; i < 5; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("Eligibilty_10_" + i));
				for (WebElement e : elements) {
					int fees = (100 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\n10th Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n10th Failed");
		}
	}

	public void eligibility_12() {
		try {
			for (int i = 2; i < 5; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("Eligibilty_12_" + i));
				for (WebElement e : elements) {
					int fees = (10 - i);
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\n12th Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n12th Failed");
		}
	}

	public void eligibility_Grad() {
		try {
			for (int i = 2; i < 5; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("Eligibilty_Grad_" + i));
				for (WebElement e : elements) {
					int fees = (600 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\nGrad Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nGrad Failed");
		}
	}

	public void ScoreType12(String score_12) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("ScoreType_12")));
			WebElement we = driver
					.findElement(FetchData.readOR("ScoreType_12"));
			Select se = new Select(we);
			se.selectByVisibleText(score_12);
			CommonFunctions.pass(child, "\n12th Score passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n12th Score failed");
		}
	}

	public void ScoreTypeGrad(String score_Grad) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("ScoreType_Grad")));
			WebElement we = driver.findElement(FetchData
					.readOR("ScoreType_Grad"));
			Select se = new Select(we);
			se.selectByVisibleText(score_Grad);
			CommonFunctions.pass(child, "\nGrad Score passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nGrad Score failed");
		}

	}

	public void outof_12(String outoff) {
		try {
			driver.findElement(FetchData.readOR("12outof")).sendKeys(outoff);
			CommonFunctions.pass(child, "\n12 out off passed");
		} catch (Exception e) {
			CommonFunctions.pass(child, "\n12 out off failed");
			throw e;
		}
	}

	public void outof_Grad(String outoff) {
		try {
			driver.findElement(FetchData.readOR("gradoutof")).sendKeys(outoff);
			CommonFunctions.pass(child, "\ngrad out off passed");
		} catch (Exception e) {
			CommonFunctions.pass(child, "\ngrad out off failed");
			throw e;
		}
	}

	public void anyother_10(String other) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("other_10"));
			driver.findElement(FetchData.readOR("other_10")).sendKeys(other);
			CommonFunctions.pass(child, "\n10 any other passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n10 any other failed");
		}
	}

	public void anyother_12(String other) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("other_12"));
			driver.findElement(FetchData.readOR("other_12")).sendKeys(other);
			CommonFunctions.pass(child, "\n12 any other passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n12 any other failed");
		}
	}

	public void anyother_Grad(String other) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("other_grad"));
			driver.findElement(FetchData.readOR("other_grad")).sendKeys(other);
			CommonFunctions.pass(child, "\ngrad any other passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ngrad any other failed");
		}
	}

	public void anyother_req(String other) {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("anyotherEligibility"));
			driver.findElement(FetchData.readOR("anyotherEligibility"))
					.sendKeys(other);
			CommonFunctions.pass(child, "\nany other passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nany other failed");
		}
	}

	public void mandatorySelect() {
		try {
			driver.findElement(FetchData.readOR("mandatorysubjects")).click();
			CommonFunctions.pass(child, "\nmandatory subject passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmandatory subject failed");
		}
	}

	public void mandatoryAgriculture() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Agriculture"));
			driver.findElement(FetchData.readOR("Agriculture")).click();
			CommonFunctions.pass(child, "\nmandatory subject 1 passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmandatory subject 1 failed");
		}
	}

	public void mandatoryArts() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Arts"));
			driver.findElement(FetchData.readOR("Arts")).click();
			CommonFunctions.pass(child, "\nmandatory subject 2 passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmandatory subject 1 failed");
		}
	}

	public void selectBaseCourse(String exam2) {
		try {
			WebElement we = driver.findElement(FetchData.readOR("baseCourse"));
			Select se = new Select(we);
			se.selectByVisibleText(exam2);
			CommonFunctions.pass(child, "\nbase course  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nbase course  failed");
		}
	}

	public void enterExam1() {
		try {
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("Exam1_" + i));
				for (WebElement e : elements) {
					int fees = (100 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nExam 1  failed");
		}
	}

	public void enterExam2() {
		try {
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("Exam2_" + i));
				for (WebElement e : elements) {
					int fees = i * 100;
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\nExam 2  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nExam 1  failed");
		}
	}

	public void minEx(String minex) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("minex")));
			driver.findElement(FetchData.readOR("minex")).sendKeys(minex);
			CommonFunctions.pass(child, "\nmin exp passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmin exp failed");
		}
	}

	public void maxEx(String maxEx) {
		try {
			driver.findElement(FetchData.readOR("maxex")).sendKeys(maxEx);
			CommonFunctions.pass(child, "\nmax exp passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmax exp failed");
		}
	}

	public void maxage(String maxage) {
		try {
			driver.findElement(FetchData.readOR("maxage")).sendKeys(maxage);
			CommonFunctions.pass(child, "\nmax age passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmax age failed");
		}
	}

	public void minage(String minage) {
		try {
			driver.findElement(FetchData.readOR("minage")).sendKeys(minage);
			CommonFunctions.pass(child, "\nmin age passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmin age failed");
		}
	}

	public void international(String international) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("International")));
			driver.findElement(FetchData.readOR("International")).sendKeys(
					international);
			CommonFunctions.pass(child, "\nInternational passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nInternational failed");
		}
	}

	public void cutoff_science() {
		try {
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("cutoff_science_" + i));
				for (WebElement e : elements) {
					int fees = (100 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\ncut off data science passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncut off data science failed");
		}
	}

	public void cutoff_Commerce() {
		try {
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("cutoff_Commerce_" + i));
				for (WebElement e : elements) {
					int fees = (100 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\ncut off data commerce passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncut off data commerce failed");
		}
	}

	public void selectCutoffExam(int index) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("cutoff_exam")));
			WebElement we = driver.findElement(FetchData.readOR("cutoff_exam"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\ncut off exam passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncut off exam Failed");
		}
	}

	public void selectCutoffExamYear(int index) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("cutoff_examyear"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\ncut off year passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncut off year Failed");
		}
	}

	public void cutoff_allIndia() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("cutoff_allIndia_2")));
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("cutoff_allIndia_" + i));
				for (WebElement e : elements) {
					int fees = (100 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\ncut off all india passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncut off all india Failed");
		}
	}

	public void cutoff_homestate() {
		try {
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("cutoff_home_" + i));
				for (WebElement e : elements) {
					int fees = (100 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\ncut off all home passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncut off all home Failed");
		}
	}

	public void cutoff_relatedState() {
		try {
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("cutoff_related_" + i));
				for (WebElement e : elements) {
					int fees = (100 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\ncut off all related passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncut off all related Failed");
		}
	}

	public void cutoff_otherState() {
		try {
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("cutoff_otherstate_" + i));
				for (WebElement e : elements) {
					int fees = (100 - (i * 10));
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\ncut off all other passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncut off all other Failed");
		}
	}

	public void relatedstatebutton() {
		try {
			driver.findElement(FetchData.readOR("relatedstatebutton")).click();
			CommonFunctions.pass(child, "\nrelated state  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nrelated state Failed");
		}
	}

	public void selectState1() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("selectState1"));
			driver.findElement(FetchData.readOR("selectState1")).click();
			CommonFunctions.pass(child, "\nrelated state 1 passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nrelated state 1 Failed");
		}
	}

	public void cutoff_collapse() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("cutoffcollapse")));
			driver.findElement(FetchData.readOR("cutoffcollapse")).click();
		} catch (Exception e) {
			throw e;
		}
	}

	public void selectState2() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("selectState2"));
			driver.findElement(FetchData.readOR("selectState2")).click();
			CommonFunctions.pass(child, "\nrelated state 2 passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nrelated state 1 Failed");
		}
	}

	public void seats_collapse() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("seatscollapse")));
			driver.findElement(FetchData.readOR("seatscollapse")).click();
			CommonFunctions.pass(child, "\nSeat collapse passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nSeat collapse failed");
			throw e;
		}
	}

	public void seats_total(String seats) {
		try {
			driver.findElement(FetchData.readOR("TotalSeats")).sendKeys(seats);
			CommonFunctions.pass(child, "\nTotal seats passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nTotal Seats failed");
		}
	}

	public void seats_category() {
		try {
			for (int i = 1; i < 4; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("seats_" + i));
				for (WebElement e : elements) {
					int fees = i * 20;
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\nTotal category seat passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nTotal category  seat failed");
		}
	}

	public void seats_exam() {
		try {
			for (int i = 1; i < 3; i++) {
				List<WebElement> elements = driver.findElements(FetchData
						.readOR("examseat_" + i));
				for (WebElement e : elements) {
					int fees = i * 20;
					e.click();
					e.sendKeys(Integer.toString(fees));
				}
			}
			CommonFunctions.pass(child, "\nTotal exams seats passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nTotal exams seat failed");
		}
	}

	public void seats_homestate(String seats) {
		try {
			driver.findElement(FetchData.readOR("homestate_seats")).sendKeys(
					seats);
			CommonFunctions.pass(child, "\nTotal state seats passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nTotal state  seat failed");
		}
	}

	public void seats_relatedstate(String seats) {
		try {
			driver.findElement(FetchData.readOR("relatedstate_seats"))
					.sendKeys(seats);
			CommonFunctions.pass(child, "\nrelated state seats passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nrelated state seats failed");
		}
	}

	public void seats_otherstate(String seats) {
		try {
			driver.findElement(FetchData.readOR("otherstate_seats")).sendKeys(
					seats);
			CommonFunctions.pass(child, "\nother state seats passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nother state seats failed");
		}
	}

	public void seats_RelatedStatesSelect() {
		try {
			driver.findElement(FetchData.readOR("seats_relatedState")).click();
			CommonFunctions.pass(child, "\nrelated state passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nrelated state  failed");
		}
	}

	public void seats_RelatedStatesSelect_1() {
		try {
			driver.findElement(FetchData.readOR("seats_relatedState_1"))
					.click();
			CommonFunctions.pass(child, "\nrelated state 1 passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nrelated state  1 failed");
		}
	}

	public void seats_RelatedStatesSelect_2() {
		try {
			driver.findElement(FetchData.readOR("seats_relatedState_2"))
					.click();
			CommonFunctions.pass(child, "\nrelated state 2 passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nrelated state  2 failed");
		}
	}

	public void placements_collapse() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("placementscollapse")));
			driver.findElement(FetchData.readOR("placementscollapse")).click();
			CommonFunctions.pass(child, "\nPlacement Collapse Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nPlacement Collapse failed");
			throw e;
		}
	}

	public void placementExamYear(int index) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("placementsyear"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\nPlacement Year Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nPlacement Year failed");
		}
	}

	public void placementcourse(String course) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("placementcourse"));
			Select se = new Select(we);
			se.selectByVisibleText(course);
			CommonFunctions.pass(child, "\nPlacement course Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nPlacement course failed");
			throw e;
		}
	}

	public void placements_batchpercent(String percent) {
		try {
			driver.findElement(FetchData.readOR("batchpercent")).sendKeys(
					percent);
			CommonFunctions.pass(child, "\n% batch Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n% batch Failed");
		}
	}

	public void placements_minsal(String sal) {
		try {
			driver.findElement(FetchData.readOR("minsal")).sendKeys(sal);
			CommonFunctions.pass(child, "\nmin sal Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmin sal Failed");
		}
	}

	public void placements_mediansal(String sal) {
		try {
			driver.findElement(FetchData.readOR("mediansal")).sendKeys(sal);
			CommonFunctions.pass(child, "\nmedian sal Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmedian sal Failed");
		}
	}

	public void placements_avgsal(String sal) {
		try {
			driver.findElement(FetchData.readOR("avgsal")).sendKeys(sal);
			CommonFunctions.pass(child, "\navg sal Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\navg sal Failed");
		}
	}

	public void placements_maxsal(String sal) {
		try {
			driver.findElement(FetchData.readOR("maxsal")).sendKeys(sal);
			CommonFunctions.pass(child, "\nmax sal Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nmax sal Failed");
		}
	}

	public void placements_offers(String offer) {
		try {
			driver.findElement(FetchData.readOR("intloffers")).sendKeys(offer);
			CommonFunctions.pass(child, "\ninternational offers Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ninternational offers Failed");
		}
	}

	public void placements_offers_sal(String sal) {
		try {
			driver.findElement(FetchData.readOR("intlofferssal")).sendKeys(sal);
			CommonFunctions.pass(child, "\ninternational sal Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ninternational sal Failed");
		}
	}

	public void placements_report() {
		try {
			driver.findElement(FetchData.readOR("uploadplacementreport"))
					.click();
			CommonFunctions.pass(child, "\nPlacement reports passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nPlacement reports Failed");
		}
	}

	public void placementsCompanies() {
		WebElement clickAdd = driver.findElement(FetchData
				.readOR("addcompanies"));
		try {
			WebElement we = driver.findElement(FetchData.readOR("companies"));
			Select se = new Select(we);

			List<WebElement> elements = se.getOptions();
			for (WebElement e : elements) {
				e.click();
				clickAdd.click();
			}

			CommonFunctions.pass(child, "\nPlacement companines passed");
		} catch (Exception e) {
			//CommonFunctions.fail(child, "\nPlacement companines failed");
		}
	}

	public void internship_expand() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("internshipcollapse")));
			driver.findElement(FetchData.readOR("internshipcollapse")).click();
			CommonFunctions.pass(child, "\nInternship expand passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nInternship expand failed");
			throw e;
		}
	}

	public void intern_year(int index) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("internshipbatch"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\nInternship year passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nInternship year failed");
		}
	}

	public void internship_sal_max(String sal) {
		try {
			driver.findElement(FetchData.readOR("internshipmaxsal")).sendKeys(
					sal);
			CommonFunctions.pass(child, "\nInternship max sal passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nInternship max sal failed");
		}
	}

	public void internship_sal_min(String sal) {
		try {
			driver.findElement(FetchData.readOR("internshipminsal")).sendKeys(
					sal);
			CommonFunctions.pass(child, "\nInternship min sal passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nInternship min sal failed");
		}
	}

	public void internship_sal_median(String sal) {
		try {
			driver.findElement(FetchData.readOR("internshipmediansal"))
					.sendKeys(sal);
			CommonFunctions.pass(child, "\nInternship median sal passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nInternship median sal failed");
		}
	}

	public void internship_sal_avg(String sal) {
		try {
			driver.findElement(FetchData.readOR("internshipavgsal")).sendKeys(
					sal);
			CommonFunctions.pass(child, "\nInternship avg sal passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nInternship avg sal failed");
		}
	}

	public void uplaodinternship() {
		try {
			driver.findElement(FetchData.readOR("uploadintershipreport"))
					.click();
			CommonFunctions.pass(child, "\nInternship upload passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nInternship upload failed");
		}
	}

	public void courseLocations() {

		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("addlocations")));
			Variables.elementWait(driver, 10, FetchData.readOR("addlocations"));
			WebElement clickAdd = driver.findElement(FetchData
					.readOR("addlocations"));
			WebElement we = driver.findElement(FetchData.readOR("locations"));
			Select se = new Select(we);

			List<WebElement> elements = se.getOptions();
			for (WebElement e : elements) {
				e.click();
				clickAdd.click();
			}

			CommonFunctions.pass(child, "\nall location selected passed");
		} catch (Exception e) {
			//CommonFunctions.fail(child, "\nall location selected failed");
		}
	}

	public void selectAllGallery() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("gallery")));
			Variables.elementWait(driver, 10, FetchData.readOR("gallery"));
			driver.findElement(FetchData.readOR("gallery")).click();
			CommonFunctions.pass(child, "\ngallery selected passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\ngallery selected failed");
		}
	}

	public void comments(String comments) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("comments")));
			Variables.elementWait(driver, 10, FetchData.readOR("comments"));
			driver.findElement(FetchData.readOR("comments")).sendKeys(comments);
			CommonFunctions.pass(child, "\ncomments passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncomments failed");
			throw e;
		}
	}

	public void publishCourse() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("publish"));
			driver.findElement(FetchData.readOR("publish")).click();
			CommonFunctions.pass(child, "\npublish passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\npublish failed");
			throw e;
		}
	}

	public String courseId() {
		String text = "";
		String text1 = "";
		try {
			Variables.elementWait(driver, 50, FetchData.readOR("courseId"));
			text = driver.findElement(FetchData.readOR("courseId")).getText();
			int index = text.indexOf(":") + 1;
			int last = text.length();
			text1 = text.substring(index, last).trim();
			System.out.print(text1);
			CommonFunctions.pass(child, "\nfatch course passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfetch course failed");
		}
		return text1;
	}

	public void partnerCollapse() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("partnercollapse")));
			driver.findElement(FetchData.readOR("partnercollapse")).click();
			CommonFunctions.pass(child, "\nPartner collapse passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nPartner collapse failed");
			throw e;
		}
	}

	public void partnerYes() {
		try {
			driver.findElement(FetchData.readOR("partneryes")).click();
			CommonFunctions.pass(child, "\nPartner yes passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nPartner yes failed");
		}
	}

	public void partner_duration1(String duration) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("duration_1"));
			driver.findElement(FetchData.readOR("duration_1")).sendKeys(
					duration);
			CommonFunctions.pass(child, "\nPartner duration 1  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nPartner duration  1 failed");
		}
	}

	public void partner_duration2(String duration) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("duration_2"));
			driver.findElement(FetchData.readOR("duration_2")).sendKeys(
					duration);
			CommonFunctions.pass(child, "\nPartner duration 2  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nPartner duration 2  failed");
		}
	}

	public void partner_univid(String duration) {
		try {
			driver.findElement(FetchData.readOR("univ_id")).sendKeys(duration);
			CommonFunctions.pass(child, "\nuniv id  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nuniv id failed");
		}
	}

	public void partner_clickId() {
		try {
			driver.findElement(FetchData.readOR("univ_id_go")).click();
			CommonFunctions.pass(child, "\nclick go  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclock go failed");
		}
	}

	public void datescollapse() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("datescollapse")));
			driver.findElement(FetchData.readOR("datescollapse")).click();
			CommonFunctions.pass(child, "\ndate collapse  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ndate collapse  failed");
			throw e;
		}
	}

	public void dates_application_month(String month) {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("date_application_month"));
			WebElement we = driver.findElement(FetchData
					.readOR("date_application_month"));

			Select se = new Select(we);
			se.selectByVisibleText(month);
			CommonFunctions.pass(child, "\napplication  month  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\napplication  month failed");
		}
	}

	public void dates_application_year(int index) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("date_application_year"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\napplication  year  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\napplication  year failed");
		}
	}

	public void dates_submit_month(String month) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("date_submit_month"));
			Select se = new Select(we);
			se.selectByVisibleText(month);
			CommonFunctions.pass(child, "\nsubmit month  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nsubmit month failed");
		}
	}

	public void dates_submit_year(int index) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("date_submit_year"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\nsubmit year  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nsubmit year failed");
		}
	}

	public void dates_Commencement_month(String month) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("date_Commencement_month"));
			Select se = new Select(we);
			se.selectByVisibleText(month);
			CommonFunctions.pass(child, "\ncommencement month  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncommencement month failed");
		}
	}

	public void dates_Commencement_year(int index) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("date_Commencement_year"));
			Select se = new Select(we);
			se.selectByIndex(index);
			CommonFunctions.pass(child, "\ncommencement year  passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncommencement year failed");
		}
	}
}
