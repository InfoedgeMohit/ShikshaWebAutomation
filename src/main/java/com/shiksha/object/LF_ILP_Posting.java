package com.shiksha.object;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class LF_ILP_Posting {

	WebDriver driver;
	ExtentTest child1;
	List<Object> child = new ArrayList<Object>();

	public LF_ILP_Posting(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child1 = child;

		this.child.add(this.driver);
		this.child.add(this.child1);

	}
	CommonFunctions CommonFunctions = new CommonFunctions();
	public void typeUniv(String univ){
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("univId"));
			driver.findElement(FetchData.readOR("univId")).sendKeys(univ);
			CommonFunctions.pass(child, "\nType univ Id Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nType univ Id Failed");
			throw e;
		}
	}

	public void clickunivgo(){
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("univGo"));
			driver.findElement(FetchData.readOR("univGo")).click();
			CommonFunctions.pass(child, "\nuniv Go Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nuniv Go Failed");
			throw e;
		}
	}

	public void selectUniv(){
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("univselect"));
			driver.findElement(FetchData.readOR("univselect")).click();
			CommonFunctions.pass(child, "\nSelect univ Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselect univ Failed Failed");
			throw e;
		}
	}

	public void selectinsName(String insName){
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("insName"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("insName")));
			driver.findElement(FetchData.readOR("insName")).sendKeys(insName);
			CommonFunctions.pass(child, "\nType ins id Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nType ins id Failed");
			throw e;
		}
	}

	public void selectCity(String city) throws Exception{
		try {
			Thread.sleep(2000);
			WebElement we = driver.findElement(FetchData.readOR("selectCity"));
			Select se = new Select(we);
			se.selectByVisibleText(city);
			CommonFunctions.pass(child, "\nselect city Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselect city Failed");
			throw e;
		}
	}

	public void selectshortName(String shtname) {
		try {
			driver.findElement(FetchData.readOR("shortname")).sendKeys(shtname);
			CommonFunctions.pass(child, "\nselect short name Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselect short name Failed");
		}
	}

	public void selectabbreviation(String abbreviation) {
		try {
			driver.findElement(FetchData.readOR("abbreviation")).sendKeys(
					abbreviation);
			CommonFunctions.pass(child, "\nselect abbreviation Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselect abbreviation Failed");
		}
	}

	public void synonymAddMore() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("synonymAddMore")));
			driver.findElement(FetchData.readOR("synonymAddMore")).click();
			CommonFunctions.pass(child, "\nselect synonym add more Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselect select synonym add more Failed");
		}
	}

	public void synonym1(String synonym1) {
		try {
			driver.findElement(FetchData.readOR("synonym1")).sendKeys(synonym1);
			CommonFunctions.pass(child, "\ntype synonym 1 Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\ntype synonym 1 Failed");
		}
	}

	public void synonym2(String synonym2) {
		try {
			driver.findElement(FetchData.readOR("synonym2")).sendKeys(synonym2);
			CommonFunctions.pass(child, "\ntype synonym 2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ntype synonym 2 Failed");
		}
	}

	public void establishment_year(String establishment_year) {
		try {
			driver.findElement(FetchData.readOR("establishment_year"))
					.sendKeys(establishment_year);
			CommonFunctions.pass(child, "\ntype establishment_year Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ntype establishment_year Failed");
		}
	}

	public void ownership() {
		try {
			driver.findElement(FetchData.readOR("ownership")).click();
			CommonFunctions.pass(child, "\nownership Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nownership Failed");
		}
	}

	public void isAutonomous() {
		try {
			driver.findElement(FetchData.readOR("isAutonomous")).click();
			CommonFunctions.pass(child, "\nisAutonomous Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nisAutonomous Failed");
		}
	}

	public void isNationalImportance() {
		try {
			driver.findElement(FetchData.readOR("isNationalImportance"))
					.click();
			CommonFunctions.pass(child, "\nisNationalImportance Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nisNationalImportance Failed");
		}
	}

	public void accreditation(String accreditation) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("accreditation"));
			Select se = new Select(we);
			se.selectByVisibleText(accreditation);
			CommonFunctions.pass(child, "\naccreditation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\naccreditation Failed");
		}
	}

	public void facultyAddMore() {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("facultyAddMore"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("facultyAddMore")));
			driver.findElement(FetchData.readOR("facultyAddMore")).click();
			CommonFunctions.pass(child, "\nfacultyAddMore Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfacultyAddMore Failed");
		}
	}

	public void faculty2(String accreditation) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("faculty2")));
			WebElement we = driver.findElement(FetchData.readOR("faculty2"));
			Select se = new Select(we);
			se.selectByVisibleText(accreditation);
			CommonFunctions.pass(child, "\nfaculty2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2 Failed");
			throw e;
		}
	}

	public void faculty1(String accreditation) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("faculty1")));
			WebElement we = driver.findElement(FetchData.readOR("faculty1"));
			Select se = new Select(we);
			se.selectByVisibleText(accreditation);
			CommonFunctions.pass(child, "\nfaculty1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1 Failed");
			throw e;
		}
	}

	public void faculty1Name(String Name) {
		try {
			driver.findElement(FetchData.readOR("faculty1name")).sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty1Name Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1Name Failed");
			throw e;
		}
	}

	public void faculty1designation(String Name) {
		try {
			driver.findElement(FetchData.readOR("faculty1designation"))
					.sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty1designation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1designation Failed");
			throw e;
		}
	}

	public void faculty1education(String Name) {
		try {
			driver.findElement(FetchData.readOR("faculty1education")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nfaculty1education Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1education Failed");
		}
	}

	public void faculty1high(String Name) {
		try {
			driver.findElement(FetchData.readOR("faculty1high")).sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty1high Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1high Failed");
		}
	}

	public void faculty2Name(String Name) {
		try {
			driver.findElement(FetchData.readOR("faculty2name")).sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty2name Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2name Failed");
			throw e;
		}
	}

	public void faculty2designation(String Name) {
		try {
			driver.findElement(FetchData.readOR("faculty2designation"))
					.sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty2designation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2designation Failed");
			throw e;
		}
	}

	public void faculty2education(String Name) {
		try {
			driver.findElement(FetchData.readOR("faculty2education")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nfaculty2education Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2education Failed");
		}
	}

	public void faculty2high(String Name) {
		try {
			driver.findElement(FetchData.readOR("faculty2high")).sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty2high Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2high Failed");
		}
	}

	public void facultyHighlights(String high) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("facultyHighlights")));
			driver.findElement(FetchData.readOR("facultyHighlights")).sendKeys(
					high);
			CommonFunctions.pass(child, "\nfacultyHighlights Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfacultyHighlights Failed");
		}
	}

	public void Library() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("library")));
			driver.findElement(FetchData.readOR("library")).click();
			CommonFunctions.pass(child, "\nLibrary Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nLibrary Failed");
		}
	}

	public void wifi() {
		try {
			driver.findElement(FetchData.readOR("wifi")).click();
			CommonFunctions.pass(child, "\nwifi Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nwifi Failed");
		}
	}

	public void store() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("store")));
			driver.findElement(FetchData.readOR("store")).click();
			CommonFunctions.pass(child, "\nstore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nstore Failed");
		}
	}

	public void cafe() {
		try {
			driver.findElement(FetchData.readOR("cafe")).click();
			CommonFunctions.pass(child, "\ncafe Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncafe Failed");
		}
	}

	public void shuttle() {
		try {
			driver.findElement(FetchData.readOR("shuttle")).click();
			CommonFunctions.pass(child, "\nshuttle Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nshuttle Failed");
		}
	}

	public void audi() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("audi")));
			driver.findElement(FetchData.readOR("audi")).click();
			CommonFunctions.pass(child, "\naudi Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\naudi Failed");
		}
	}

	public void hospital() {
		try {
			driver.findElement(FetchData.readOR("hospital")).click();
			CommonFunctions.pass(child, "\nhospital Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nhospital Failed");
		}
	}

	public void sports() {
		try {
			driver.findElement(FetchData.readOR("sports")).click();
			CommonFunctions.pass(child, "\nsports Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nsports Failed");
		}
	}

	public void gym() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("gym")));
			driver.findElement(FetchData.readOR("gym")).click();
			CommonFunctions.pass(child, "\ngym Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ngym Failed");
		}
	}

	public void libHigh(String Name) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("libhigh")));
			driver.findElement(FetchData.readOR("libhigh")).sendKeys(Name);
			CommonFunctions.pass(child, "\nlibhigh Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nlibhigh Failed");
		}
	}

	public void gymHigh(String Name) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Gymhigh")));
			driver.findElement(FetchData.readOR("Gymhigh")).sendKeys(Name);
			CommonFunctions.pass(child, "\nGymhigh Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nGymhigh Failed");
		}
	}

	public void ac() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("ac")));
			driver.findElement(FetchData.readOR("ac")).click();
			CommonFunctions.pass(child, "\nac Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nac Failed");
		}
	}

	public void labs() {
		try {
			driver.findElement(FetchData.readOR("labs")).click();
			CommonFunctions.pass(child, "\nlabs Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nlabs Failed");
		}
	}

	public void researchAddMore() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("researchAddMore")));
			driver.findElement(FetchData.readOR("researchAddMore")).click();
			CommonFunctions.pass(child, "\nresearchAddMore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nresearchAddMore Failed");
		}
	}

	public void researchText1(String research) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("researchText1")));
			driver.findElement(FetchData.readOR("researchText1")).sendKeys(
					research);
			CommonFunctions.pass(child, "\nresearchText1 Passed");

		} catch (Exception e) {

		}
	}

	public void researchText2(String research) {
		try {
			driver.findElement(FetchData.readOR("researchText2")).sendKeys(
					research);
			CommonFunctions.pass(child, "\nresearchText2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nresearchText2 Failed");
		}
	}

	public void researchText3(String research) {
		try {
			driver.findElement(FetchData.readOR("researchText3")).sendKeys(
					research);
			CommonFunctions.pass(child, "\nresearchText3 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nresearchText3 Failed");
		}
	}

	public void eventAddMore() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("EventAddMore")));
			driver.findElement(FetchData.readOR("EventAddMore")).click();
			CommonFunctions.pass(child, "\nEventAddMore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEventAddMore Failed");
		}
	}

	public void selectevent1(String Event1) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Event1")));
			WebElement we = driver.findElement(FetchData.readOR("Event1"));
			Select se = new Select(we);
			se.selectByVisibleText(Event1);
			CommonFunctions.pass(child, "\nselectevent1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselectevent1 Failed");
			throw e;
		}
	}

	public void selectevent2(String Event1) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Event2")));
			WebElement we = driver.findElement(FetchData.readOR("Event2"));
			Select se = new Select(we);
			se.selectByVisibleText(Event1);
			CommonFunctions.pass(child, "\nselectevent2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselectevent2 Failed");
			throw e;
		}
	}

	public void Event1Name(String Name) {
		try {
			driver.findElement(FetchData.readOR("Event1Name")).sendKeys(Name);
			CommonFunctions.pass(child, "\nEvent1Name Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent1Name Failed");
			throw e;
		}
	}

	public void Event2Name(String Name) {
		try {
			driver.findElement(FetchData.readOR("Event2Name")).sendKeys(Name);
			CommonFunctions.pass(child, "\nEvent2Name Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent2Name Failed");
			throw e;
		}
	}

	public void Event1Description(String Name) {
		try {
			driver.findElement(FetchData.readOR("Event1Description")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nEvent1Description Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent1Description Failed");
			throw e;
		}
	}

	public void Event2Description(String Name) {
		try {
			driver.findElement(FetchData.readOR("Event2Description")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nEvent2Description Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent2Description Failed");
			throw e;
		}
	}

	public void uspAddMore() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("USPAddMore")));
			driver.findElement(FetchData.readOR("USPAddMore")).click();
			CommonFunctions.pass(child, "\nUSPAddMore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSPAddMore Failed");
		}
	}

	public void USP1(String USP) {
		try {
			driver.findElement(FetchData.readOR("USP1")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP1 Failed");
		}
	}

	public void USP2(String USP) {
		try {
			driver.findElement(FetchData.readOR("USP2")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP2 Failed");
		}
	}

	public void USP3(String USP) {
		try {
			driver.findElement(FetchData.readOR("USP3")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP3 Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP3 Failed");
		}
	}

	public void USP4(String USP) {
		try {
			driver.findElement(FetchData.readOR("USP4")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP4 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP4 Failed");
		}
	}

	public void USP5(String USP) {
		try {
			driver.findElement(FetchData.readOR("USP5")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP5 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP5 Failed");
		}
	}

	public void uploadBrochure(String path) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("browseInstitute")));
			driver.findElement(FetchData.readOR("browseInstitute")).click();
			String text = path;
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(10000);
			if(driver.findElement(FetchData.readOR("brochureCheckInstitute")).isDisplayed())
			{
				CommonFunctions.pass(child, "\nuploadBrochure Passed");
			}
			
			else
			{
				CommonFunctions.fail(child, "\nuploadBrochure Failed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nuploadBrochure Failed");
		}
	}

	public void selectMLCity(String city) {
		try {
			WebElement we = driver
					.findElement(FetchData.readOR("selectMLCity"));
			Select se = new Select(we);
			se.selectByVisibleText(city);
			CommonFunctions.pass(child, "\nselectMLCity Passed" + city);
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselectMLCity Failed" + city);
		}
	}

	public void clickAdd() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("AddMLCity")));
			driver.findElement(FetchData.readOR("AddMLCity")).click();
			CommonFunctions.pass(child, "\nclickAdd ML city Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclickAdd ML city Failed");
		}
	}

	public void clickUplaodLogo(String path) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("uploadLogo")));
			driver.findElement(FetchData.readOR("uploadLogo")).click();
			String text = path;
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(10000);
			if(driver.findElement(FetchData.readOR("logoCheckInstitute")).isDisplayed())
			{
				CommonFunctions.pass(child, "\nupload logo Passed");
			}
			else{	
			CommonFunctions.fail(child, "\nupload logo Failed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nupload logo  Failed");
		}
	}

	public void enterTitle(String title) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("uploadmediatitle")));
			driver.findElement(FetchData.readOR("uploadmediatitle")).sendKeys(
					title);
			CommonFunctions.pass(child, "\nenterTitle Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nenterTitle Failed");
		}
	}

	public void clickUpload(int i) {
		try {
			driver.findElement(FetchData.readOR("upload")).click();
			Thread.sleep(10000);
			switch (i) {
			case 1:
				if (driver.findElement(FetchData.readOR("insphotoCheck1"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nuplaodMedia Passed");
				} else {
					CommonFunctions.fail(child, "\nuplaodMedia Failed");
				}
				break;
			case 2:
				if (driver.findElement(FetchData.readOR("insphotoCheck2"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nuplaodMedia Passed");
				} else {
					CommonFunctions.fail(child, "\nuplaodMedia Failed");
				}
				break;
			case 3:
				if (driver.findElement(FetchData.readOR("insphotoCheck3"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nuplaodMedia Passed");
				} else {
					CommonFunctions.fail(child, "\nuplaodMedia Failed");
				}
				break;
				default : 
					CommonFunctions.fail(child, "\nuplaodMedia Failed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclickUpload Failed");
		}
	}

	public void uplaodMedia(String path) {
		try {
			driver.findElement(FetchData.readOR("uploadmedia")).click();
			String text = path;
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(10000);
			CommonFunctions.pass(child, "\nuplaodMedia Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nuplaodMedia Failed");
		}
	}

	public void entervideoTitle(String title) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("videotitle")));
			driver.findElement(FetchData.readOR("videotitle")).sendKeys(title);
			CommonFunctions.pass(child, "\nentervideoTitle Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nentervideoTitle Failed");
		}
	}

	public void entervideourl(String title) {
		try {
			driver.findElement(FetchData.readOR("videourl")).sendKeys(title);
			Thread.sleep(30000);
			CommonFunctions.pass(child, "\nentervideourl Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nentervideourl Failed");
		}
	}

	public void videoUpload(int i) {
		try {
			driver.findElement(FetchData.readOR("videoupload")).click();
			Thread.sleep(10000);
			switch (i) {
			case 1:
				if (driver.findElement(FetchData.readOR("insvideoCheck1"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nvideoUpload Passed");
				} else {
					CommonFunctions.fail(child, "\nvideoUpload Failed");
				}
				break;
			case 2:
				if (driver.findElement(FetchData.readOR("insvideoCheck2"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nvideoUpload Passed");
				} else {
					CommonFunctions.fail(child, "\nvideoUpload Failed");
				}
				break;
			case 3:
				if (driver.findElement(FetchData.readOR("insvideoCheck3"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nvideoUpload Passed");
				} else {
					CommonFunctions.fail(child, "\nvideoUpload Failed");
				}
				break;
				default : 
					CommonFunctions.fail(child, "\nvideoUpload Failed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nvideoUpload Failed");
		}
	}

	public void scholarshipAddMOre() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("scholarshipAddMore")));
			driver.findElement(FetchData.readOR("scholarshipAddMore")).click();
			CommonFunctions.pass(child, "\nscholarshipAddMOre Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarshipAddMOre Failed");
		}
	}

	public void scholarshipdesc1(String scholarship) {
		try {
			driver.findElement(FetchData.readOR("scholarshipform1")).sendKeys(
					scholarship);
			CommonFunctions.pass(child, "\nscholarshipdesc1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarshipdesc1 Failed");
		}
	}

	public void scholarshipdesc2(String scholarship) {
		try {
			driver.findElement(FetchData.readOR("scholarshipform2")).sendKeys(
					scholarship);
			CommonFunctions.pass(child, "\nscholarshipdesc2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarshipdesc2 Failed");
		}
	}

	public void scholarshipdesc3(String scholarship) {
		try {
			driver.findElement(FetchData.readOR("scholarshipform3")).sendKeys(
					scholarship);
			CommonFunctions.pass(child, "\nscholarshipdesc3 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarshipdesc3 Failed");
		}
	}

	public void scholarship1(String scholarship) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("scholarship1")));
			WebElement we = driver
					.findElement(FetchData.readOR("scholarship1"));
			Select se = new Select(we);
			se.selectByVisibleText(scholarship);
			CommonFunctions.pass(child, "\nscholarship1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarship1 Failed");
		}
	}

	public void scholarship3(String scholarship) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("scholarship3")));
			WebElement we = driver
					.findElement(FetchData.readOR("scholarship3"));
			Select se = new Select(we);
			se.selectByVisibleText(scholarship);
			CommonFunctions.pass(child, "\nscholarship3 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarship3 Failed");
		}
	}

	public void scholarship2(String scholarship) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("scholarship2")));
			WebElement we = driver
					.findElement(FetchData.readOR("scholarship2"));
			Select se = new Select(we);
			se.selectByVisibleText(scholarship);
			CommonFunctions.pass(child, "\nscholarship2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarship2 Failed");
		}
	}

	public void recruitingcompanies(String company) {
		try {
			driver.findElement(FetchData.readOR("recrutingcompanies")).click();
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("recrutingcompany")).clear();
			driver.findElement(FetchData.readOR("recrutingcompany")).sendKeys(
					company);
			Thread.sleep(5000);
			CommonFunctions.pass(child, "\nrecruitingcompanies Passed");
		} catch (Exception e) {
			//CommonFunctions.fail(child, "\nrecruitingcompanies Failed");
		}
	}

	public void selectcompany() {
		try {
			driver.findElement(FetchData.readOR("selectcompany")).click();
			Thread.sleep(5000);
			CommonFunctions.pass(child, "\nselectcompany Passed");
		} catch (Exception e) {
			//CommonFunctions.fail(child, "\nselectcompany Failed");
		}
	}

	public void comments(String Comments){
		try {
			driver.findElement(FetchData.readOR("postInstitutecomments"))
					.sendKeys(Comments);
			CommonFunctions.pass(child, "\ncomments Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncomments Failed");
			throw e;
		}
	}

	public void publishInstitute(){
		try {
			driver.findElement(FetchData.readOR("publishinstitute")).click();
			CommonFunctions.pass(child, "\npublishInstitute Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\npublishInstitute Failed");
			throw e;
		}
	}

	public String getInstituteId() {

		String alert1 = "";
		String text = "";
		try {
			Thread.sleep(15000);
			Alert alert = driver.switchTo().alert();
			alert1 = alert.getText();
			text = alert1.substring(alert1.indexOf(':') + 1).trim();
			alert.accept();
			Thread.sleep(5000);
			return text;

		} catch (Exception e) {
			return text;
			// // Do nothing
		}
	}
}
