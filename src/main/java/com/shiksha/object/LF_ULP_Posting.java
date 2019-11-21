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

public class LF_ULP_Posting {

	WebDriver driver;
	ExtentTest child1;
	List<Object> child = new ArrayList<Object>();

	public LF_ULP_Posting(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child1 = child;

		this.child.add(this.driver);
		this.child.add(this.child1);
	}

	CommonFunctions CommonFunctions = new CommonFunctions();

	public void univName(String name) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("UnivName"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("UnivName")));
			driver.findElement(FetchData.readOR("UnivName")).sendKeys(name);
			CommonFunctions.pass(child, "\nunivName Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivName Failed");
			throw e;
		}
	}

	public void selectCity(String city) throws Exception {
		try {
			Thread.sleep(5000);
			WebElement we = driver.findElement(FetchData.readOR("univCity"));
			Select se = new Select(we);
			se.selectByVisibleText(city);
			CommonFunctions.pass(child, "\nselectCity Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselectCity Failed");
			throw e;
		}
	}

	public void univAbbreviation(String abbreviation) {
		try {
			driver.findElement(FetchData.readOR("univabb")).sendKeys(
					abbreviation);
			CommonFunctions.pass(child, "\nunivAbbreviation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivAbbreviation Failed");
		}
	}

	public void univsynAdd() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univsynomymadd")));
			driver.findElement(FetchData.readOR("univsynomymadd")).click();
			CommonFunctions.pass(child, "\nunivsynAdd Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivsynAdd Failed");
		}
	}

	public void univSyn1(String synonym) {
		try {
			driver.findElement(FetchData.readOR("univsynomym1")).sendKeys(
					synonym);
			CommonFunctions.pass(child, "\nunivSyn1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivSyn1 Failed");
		}
	}

	public void univSyn2(String synonym) {
		try {
			driver.findElement(FetchData.readOR("univsynomym2")).sendKeys(
					synonym);
			CommonFunctions.pass(child, "\nunivSyn2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivSyn2 Failed");
		}
	}

	public void univSyn3(String synonym) {
		try {
			driver.findElement(FetchData.readOR("univsynomym3")).sendKeys(
					synonym);
			CommonFunctions.pass(child, "\nunivSyn3 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivSyn3 Failed");
		}
	}

	public void univEstdYear(String year) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univEstdYear")));
			driver.findElement(FetchData.readOR("univEstdYear")).sendKeys(year);
			CommonFunctions.pass(child, "\nunivEstdYear Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivEstdYear Failed");
		}
	}

	public void univUnivYear(String year) {
		try {
			driver.findElement(FetchData.readOR("univUnivYear")).sendKeys(year);
			CommonFunctions.pass(child, "\nunivUnivYear Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivUnivYear Failed");
		}
	}

	public void univType(String type) {
		try {
			WebElement we = driver.findElement(FetchData.readOR("univType"));
			Select se = new Select(we);
			se.selectByValue(type);
			CommonFunctions.pass(child, "\nunivType Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivType Failed");
			throw e;
		}
	}

	public void univOwnership() {
		try {
			driver.findElement(FetchData.readOR("univownership")).click();
			CommonFunctions.pass(child, "\nunivOwnership Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivOwnership Failed");
		}
	}

	public void univOpen() {
		try {
			driver.findElement(FetchData.readOR("univOpen")).click();
			CommonFunctions.pass(child, "\nunivOpen Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivOpen Failed");
		}
	}

	public void univUGC() {
		try {
			driver.findElement(FetchData.readOR("univUGC")).click();
			CommonFunctions.pass(child, "\nunivUGC Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivUGC Failed");
		}
	}

	public void univAIU() {
		try {
			driver.findElement(FetchData.readOR("univAIU")).click();
			CommonFunctions.pass(child, "\nunivAIU Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivAIU Failed");
		}
	}

	public void univNationalImp() {
		try {
			driver.findElement(FetchData.readOR("univNationalImp")).click();
			CommonFunctions.pass(child, "\nunivNationalImp Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivNationalImp Failed");
		}
	}

	public void univAccredation(String accredation) {
		try {
			WebElement we = driver.findElement(FetchData
					.readOR("univaccredatin"));
			Select se = new Select(we);
			se.selectByValue(accredation);
			CommonFunctions.pass(child, "\nunivAccredation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivAccredation Failed");
		}
	}

	public void facultyAddMore() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univfacultyAddMore")));
			driver.findElement(FetchData.readOR("univfacultyAddMore")).click();
			CommonFunctions.pass(child, "\nfacultyAddMore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfacultyAddMore Failed");
		}
	}

	public void faculty2(String accreditation) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univfaculty2")));
			WebElement we = driver
					.findElement(FetchData.readOR("univfaculty2"));
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
					driver.findElement(FetchData.readOR("univfaculty1")));
			WebElement we = driver
					.findElement(FetchData.readOR("univfaculty1"));
			Select se = new Select(we);
			se.selectByVisibleText(accreditation);
			CommonFunctions.pass(child, "\nfaculty1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2 Failed");
			throw e;
		}
	}

	public void faculty1Name(String Name) {
		try {
			driver.findElement(FetchData.readOR("univfaculty1name")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nfaculty1Name Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1Name Failed");
			throw e;
		}
	}

	public void faculty1designation(String Name) {
		try {
			driver.findElement(FetchData.readOR("univfaculty1designation"))
					.sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty1Name Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1Name Failed");
			throw e;
		}
	}

	public void faculty1education(String Name) {
		try {
			driver.findElement(FetchData.readOR("univfaculty1education"))
					.sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty1education Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1education Failed");
		}
	}

	public void faculty1high(String Name) {
		try {
			driver.findElement(FetchData.readOR("univfaculty1high")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nfaculty1high Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty1high Failed");
		}
	}

	public void faculty2Name(String Name) {
		try {
			driver.findElement(FetchData.readOR("univfaculty2name")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nfaculty2Name Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2Name Failed");
			throw e;
		}
	}

	public void faculty2designation(String Name) {
		try {
			driver.findElement(FetchData.readOR("univfaculty2designation"))
					.sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty2designation Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2Name Failed");
			throw e;
		}
	}

	public void faculty2education(String Name) {
		try {
			driver.findElement(FetchData.readOR("univfaculty2education"))
					.sendKeys(Name);
			CommonFunctions.pass(child, "\nfaculty2education Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2education Failed");
		}
	}

	public void faculty2high(String Name) {
		try {
			driver.findElement(FetchData.readOR("univfaculty2high")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nfaculty2high Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfaculty2high Failed");
		}
	}

	public void facultyHighlights(String high) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("univfacultyHighlights")));
			driver.findElement(FetchData.readOR("univfacultyHighlights"))
					.sendKeys(high);
			CommonFunctions.pass(child, "\nfacultyHighlights Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nfacultyHighlights Failed");
		}
	}

	public void Library() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univlibrary")));
			driver.findElement(FetchData.readOR("univlibrary")).click();
			CommonFunctions.pass(child, "\nLibrary Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nLibrary Failed");
		}
	}

	public void wifi() {
		try {
			driver.findElement(FetchData.readOR("univwifi")).click();
			CommonFunctions.pass(child, "\nwifi Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nwifi Failed");
		}
	}

	public void store() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univstore")));
			driver.findElement(FetchData.readOR("univstore")).click();
			CommonFunctions.pass(child, "\nstore Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "\nstore Failed");
		}
	}

	public void cafe() {
		try {
			driver.findElement(FetchData.readOR("univcafe")).click();
			CommonFunctions.pass(child, "\nunivcafe Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivcafe Failed");
		}
	}

	public void shuttle() {
		try {
			driver.findElement(FetchData.readOR("univshuttle")).click();
			CommonFunctions.pass(child, "\nunivshuttle Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivshuttle Failed");
		}
	}

	public void audi() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univaudi")));
			driver.findElement(FetchData.readOR("univaudi")).click();
			CommonFunctions.pass(child, "\nunivaudi Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivaudi Failed");
		}
	}

	public void hospital() {
		try {
			driver.findElement(FetchData.readOR("univhospital")).click();
			CommonFunctions.pass(child, "\nhospital Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nhospital Failed");
		}
	}

	public void sports() {
		try {
			driver.findElement(FetchData.readOR("univsports")).click();
			CommonFunctions.pass(child, "\nsports Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nsports Failed");
		}
	}

	public void gym() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univgym")));
			driver.findElement(FetchData.readOR("univgym")).click();
			CommonFunctions.pass(child, "\ngym Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ngym failed");
		}
	}

	public void libHigh(String Name) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univlibhigh")));
			driver.findElement(FetchData.readOR("univlibhigh")).sendKeys(Name);
			CommonFunctions.pass(child, "\nlibHigh Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nlib high failed");
		}
	}

	public void gymHigh(String Name) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univGymhigh")));
			driver.findElement(FetchData.readOR("univGymhigh")).sendKeys(Name);
			CommonFunctions.pass(child, "\ngymHigh Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ngymHigh failed");
		}
	}

	public void ac() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univac")));
			driver.findElement(FetchData.readOR("univac")).click();
			CommonFunctions.pass(child, "\nunivac Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivac failed");
		}
	}

	public void labs() {
		try {
			driver.findElement(FetchData.readOR("univlabs")).click();
			CommonFunctions.pass(child, "\nlabs Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nlabs failed");
		}
	}

	public void researchAddMore() {
		try {
			((JavascriptExecutor) driver)
					.executeScript("arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("univresearchAddMore")));
			driver.findElement(FetchData.readOR("univresearchAddMore")).click();
			CommonFunctions.pass(child, "\nresearchAddMore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nresearchAddMore failed");
		}
	}

	public void researchText1(String research) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univresearchText1")));
			driver.findElement(FetchData.readOR("univresearchText1")).sendKeys(
					research);
			CommonFunctions.pass(child, "\nresearchText1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nresearchText1 failed");
		}
	}

	public void researchText2(String research) {
		try {
			driver.findElement(FetchData.readOR("univresearchText2")).sendKeys(
					research);
			CommonFunctions.pass(child, "\nresearchText2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nresearchText2 failed");
		}
	}

	public void researchText3(String research) {
		try {
			driver.findElement(FetchData.readOR("univresearchText3")).sendKeys(
					research);
			CommonFunctions.pass(child, "\nresearchText3 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nresearchText3 failed");
		}
	}

	public void eventAddMore() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univEventAddMore")));
			driver.findElement(FetchData.readOR("univEventAddMore")).click();
			CommonFunctions.pass(child, "\neventAddMore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\neventAddMore failed");
		}
	}

	public void selectevent1(String Event1) {
		try {

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univEvent1")));
			WebElement we = driver.findElement(FetchData.readOR("univEvent1"));
			Select se = new Select(we);
			se.selectByVisibleText(Event1);
			CommonFunctions.pass(child, "\nselectevent1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselectevent1 failed");
		}
	}

	public void selectevent2(String Event1) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univEvent2")));
			WebElement we = driver.findElement(FetchData.readOR("univEvent2"));
			Select se = new Select(we);
			se.selectByVisibleText(Event1);
			CommonFunctions.pass(child, "\nselectevent2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nselectevent2 failed");
		}
	}

	public void Event1Name(String Name) {
		try {
			driver.findElement(FetchData.readOR("univEvent1Name")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nEvent1Name Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent1Name failed");
		}
	}

	public void Event2Name(String Name) {
		try {
			driver.findElement(FetchData.readOR("univEvent2Name")).sendKeys(
					Name);
			CommonFunctions.pass(child, "\nEvent2Name Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent2Name failed");
		}
	}

	public void Event1Description(String Name) {
		try {
			driver.findElement(FetchData.readOR("univEvent1Description"))
					.sendKeys(Name);
			CommonFunctions.pass(child, "\nEvent1Description Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent1Description failed");
		}
	}

	public void Event2Description(String Name) {
		try {
			driver.findElement(FetchData.readOR("univEvent2Description"))
					.sendKeys(Name);
			CommonFunctions.pass(child, "\nEvent2Description Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nEvent2Description failed");
		}
	}

	public void uspAddMore() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univUSPAddMore")));
			driver.findElement(FetchData.readOR("univUSPAddMore")).click();
			CommonFunctions.pass(child, "\nuspAddMore Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nuspAddMore failed");
		}
	}

	public void USP1(String USP) {
		try {
			driver.findElement(FetchData.readOR("univUSP1")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP1 failed");
		}
	}

	public void USP2(String USP) {
		try {
			driver.findElement(FetchData.readOR("univUSP2")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP2 failed");
		}
	}

	public void USP3(String USP) {
		try {
			driver.findElement(FetchData.readOR("univUSP3")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP3 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP3 failed");
		}
	}

	public void USP4(String USP) {
		try {
			driver.findElement(FetchData.readOR("univUSP4")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP4 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP4 failed");
		}
	}

	public void USP5(String USP) {
		try {
			driver.findElement(FetchData.readOR("univUSP5")).sendKeys(USP);
			CommonFunctions.pass(child, "\nUSP5 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nUSP5 failed");
		}
	}

	public void uploadBrochure(String path) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("browseuniv")));
			driver.findElement(FetchData.readOR("browseuniv")).click();
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
			if (driver.findElement(FetchData.readOR("brochureCheck"))
					.isDisplayed()) {
				CommonFunctions.pass(child, "\nuploadBrochure Passed");
			}

			else {
				CommonFunctions.fail(child, "\nuploadBrochure Failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "\nuploadBrochure Failed");
		}
	}

	public void clickUplaodLogo(String path) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univuploadLogo")));
			driver.findElement(FetchData.readOR("univuploadLogo")).click();
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

			if (driver.findElement(FetchData.readOR("logoCheck")).isDisplayed()) {
				CommonFunctions.pass(child, "\nupload logo Passed");
			} else {
				CommonFunctions.fail(child, "\nupload logo Failed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nupload logo  Failed");
		}
	}

	public void enterTitle(String title) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("univuploadmediatitle")));
			driver.findElement(FetchData.readOR("univuploadmediatitle"))
					.sendKeys(title);
			CommonFunctions.pass(child, "\nenterTitle Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nenterTitle Failed");
		}
	}

	public void clickUpload(int i) {
		try {
			driver.findElement(FetchData.readOR("univupload")).click();
			Thread.sleep(10000);
			switch (i) {
			case 1:
				if (driver.findElement(FetchData.readOR("photoCheck1"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nuplaodMedia Passed");
				} else {
					CommonFunctions.fail(child, "\nuplaodMedia Failed");
				}
				break;
			case 2:
				if (driver.findElement(FetchData.readOR("photoCheck2"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nuplaodMedia Passed");
				} else {
					CommonFunctions.fail(child, "\nuplaodMedia Failed");
				}
				break;
			case 3:
				if (driver.findElement(FetchData.readOR("photoCheck3"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nuplaodMedia Passed");
				} else {
					CommonFunctions.fail(child, "\nuplaodMedia Failed");
				}
				break;
			default:
				CommonFunctions.fail(child, "\nuplaodMedia Failed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nclickUpload Failed");
		}
	}

	public void uplaodMedia(String path) {
		try {
			driver.findElement(FetchData.readOR("univuploadmedia")).click();
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
					driver.findElement(FetchData.readOR("univvideotitle")));
			driver.findElement(FetchData.readOR("univvideotitle")).sendKeys(
					title);
			CommonFunctions.pass(child, "\nentervideoTitle Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nentervideoTitle Failed");
		}
	}

	public void entervideourl(String title) {
		try {
			driver.findElement(FetchData.readOR("univvideourl"))
					.sendKeys(title);
			Thread.sleep(10000);
			CommonFunctions.pass(child, "\nentervideourl Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nentervideourl Failed");
		}
	}

	public void videoUpload(int i) {
		try {
			driver.findElement(FetchData.readOR("univvideoupload")).click();
			Thread.sleep(10000);
			switch (i) {
			case 1:
				if (driver.findElement(FetchData.readOR("videoCheck1"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nvideoUpload Passed");
				} else {
					CommonFunctions.fail(child, "\nvideoUpload Failed");
				}
				break;
			case 2:
				if (driver.findElement(FetchData.readOR("videoCheck2"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nvideoUpload Passed");
				} else {
					CommonFunctions.fail(child, "\nvideoUpload Failed");
				}
				break;
			case 3:
				if (driver.findElement(FetchData.readOR("videoCheck3"))
						.isDisplayed()) {
					CommonFunctions.pass(child, "\nvideoUpload Passed");
				} else {
					CommonFunctions.fail(child, "\nvideoUpload Failed");
				}
				break;
			default:
				CommonFunctions.fail(child, "\nvideoUpload Failed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nvideoUpload Failed");
		}
	}

	public void photoLocationSelect() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("univselectPhotoLocation")));
			driver.findElement(FetchData.readOR("univselectPhotoLocation"))
					.click();
			CommonFunctions.pass(child, "\nphotoLocationSelect Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nphotoLocationSelect Failed");
		}
	}

	public void photoLocation() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("univselectPhotobutton")));
			driver.findElement(FetchData.readOR("univselectPhotobutton"))
					.click();
			CommonFunctions.pass(child, "\nphotoLocationSelect Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nphotoLocationSelect Failed");
		}
	}

	public void videoLocationSelect() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("univselectvideoLocation")));
			driver.findElement(FetchData.readOR("univselectvideoLocation"))
					.click();
			CommonFunctions.pass(child, "\nunivselectvideoLocation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nunivselectvideoLocation Failed");
		}
	}

	public void videoLocation() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("univselectvideobutton")));
			driver.findElement(FetchData.readOR("univselectvideobutton"))
					.click();
			CommonFunctions.pass(child, "\nvideoLocation Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nvideoLocation Failed");
		}
	}

	public void scholarshipAddMOre() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("univscholarshipAddMore")));
			driver.findElement(FetchData.readOR("univscholarshipAddMore"))
					.click();
			CommonFunctions.pass(child, "\nscholarshipAddMOre Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarshipAddMOre Failed");
		}
	}

	public void scholarshipdesc1(String scholarship) {
		try {
			driver.findElement(FetchData.readOR("univscholarshipform1"))
					.sendKeys(scholarship);
			CommonFunctions.pass(child, "\nscholarshipdesc1 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarshipdesc1 Failed");
		}
	}

	public void scholarshipdesc2(String scholarship) {
		try {
			driver.findElement(FetchData.readOR("univscholarshipform2"))
					.sendKeys(scholarship);
			CommonFunctions.pass(child, "\nscholarshipdesc2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarshipdesc2 Failed");
		}
	}

	public void scholarshipdesc3(String scholarship) {
		try {
			driver.findElement(FetchData.readOR("univscholarshipform3"))
					.sendKeys(scholarship);
			CommonFunctions.pass(child, "\nscholarshipdesc3 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarshipdesc3 Failed");
		}
	}

	public void scholarship1(String scholarship) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("univscholarship1")));
			WebElement we = driver.findElement(FetchData
					.readOR("univscholarship1"));
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
					driver.findElement(FetchData.readOR("univscholarship3")));
			WebElement we = driver.findElement(FetchData
					.readOR("univscholarship3"));
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
					driver.findElement(FetchData.readOR("univscholarship2")));
			WebElement we = driver.findElement(FetchData
					.readOR("univscholarship2"));
			Select se = new Select(we);
			se.selectByVisibleText(scholarship);
			CommonFunctions.pass(child, "\nscholarship2 Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\nscholarship2 Failed");
		}
	}

	public void recruitingcompanies(String company) {
		try {
			driver.findElement(FetchData.readOR("univrecrutingcompanies"))
					.click();
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("univrecrutingcompany"))
					.clear();
			driver.findElement(FetchData.readOR("univrecrutingcompany"))
					.sendKeys(company);
			Thread.sleep(5000);
			CommonFunctions.pass(child, "\nrecruitingcompanies Passed");
		} catch (Exception e) {
			// CommonFunctions.fail(child, "\nrecruitingcompanies Failed");
		}
	}

	public void selectcompany() {
		try {
			driver.findElement(FetchData.readOR("univselectcompany")).click();
			Thread.sleep(5000);
			CommonFunctions.pass(child, "\nselectcompany Passed");
		} catch (Exception e) {
			//CommonFunctions.fail(child, "\nselectcompany Failed");
		}
	}

	public void comments(String Comments) {
		try {
			driver.findElement(FetchData.readOR("postInstitutecomments"))
					.sendKeys(Comments);
			driver.findElement(FetchData.readOR("postunivcomments")).sendKeys(
					Comments);
			CommonFunctions.pass(child, "\ncomments Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\ncomments Failed");
			throw e;
		}
	}

	public void publishUniversity() {
		try {
			driver.findElement(FetchData.readOR("publishuniv")).click();
			CommonFunctions.pass(child, "\npublish univ Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "\npublish univ Failed");
			throw e;
		}
	}

	public String getunivId() {
		String alert1 = "";
		String text = "";
		try {
			Thread.sleep(15000);
			Alert alert = driver.switchTo().alert();
			alert1 = alert.getText();
			text = alert1.substring(alert1.indexOf(':') + 1).trim();
			alert.accept();
			Thread.sleep(5000);
		} catch (Exception e) {
			// // Do nothing
		}

		return text;
	}

}
