package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class Sanity_QA_Desktop {
	WebDriver driver;
	ExtentTest child1;
	List<Object> child = new ArrayList<Object>();
	Objects obj;
	CommonFunctions CommonFunctions;

	public Sanity_QA_Desktop(Objects objs, WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child1 = child;
		obj = objs;
		this.child.add(this.driver);
		this.child.add(this.child1);
		CommonFunctions = new CommonFunctions(obj);
	}

	public void clickReigstrationWidget() {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("registrationWidgetSignup"));
			// registrationWidgetSignup
			driver.findElement(FetchData.readOR("registrationWidgetSignup"))
					.click();
			CommonFunctions.pass(child,
					"Click on Registration or Login Widget Passed");
			CommonFunctions.pass(child,
					"Click on Registration or Login Widget Passed");
		} catch (Exception e) {
			// CommonFunctions.fail(child,
			// "Click on Registration or Login Widget Failed");
			CommonFunctions.fail(child,
					"Click on Registration or Login Widget Failed");
			throw e;
		}
	}

	public void clicksignupWidget() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("signUp_Tag"));
			// registrationWidgetSignup
			driver.findElement(FetchData.readOR("signUp_Tag")).click();
			CommonFunctions.pass(child,
					"Click on Registration or Login Widget Passed");
			CommonFunctions.pass(child,
					"Click on Registration or Login Widget Passed");
		} catch (Exception e) {
			// CommonFunctions.fail(child,
			// "Click on Registration or Login Widget Failed");
			CommonFunctions.fail(child,
					"Click on Registration or Login Widget Failed");
			throw e;
		}
	}

	public void Registration(Objects obj) throws Exception {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("loginInRHS"));
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("regisStream")).click();
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("regisStream_1")).click();

			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("bc")).click();
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("bc_2")).click();
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("bc")).click();

			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("et")).click();
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("et_2")).click();
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("et")).click();

			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("1_next")).click();

			CommonFunctions cc = new CommonFunctions();

			Thread.sleep(2000);
			Variables.elementWait(driver, 20, FetchData.readOR("reg_email"));

			String email = cc.RandomEmail("gmail.com");

			driver.findElement(FetchData.readOR("reg_email")).sendKeys(email);
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("reg_pass"))
					.sendKeys("shiksha");
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("reg_Fname")).sendKeys(
					"sdiadiyf");
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("reg_lname"))
					.sendKeys("fsdfsd");

			String mobile = cc.RandomNumber('7');

			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("reg_mobile")).sendKeys(mobile);

			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("reg_locality")).click();
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("reg_locality_2")).click();

			Thread.sleep(2000);

			CommonFunctions.acceptterms(driver);

			driver.findElement(FetchData.readOR("final_reg")).click();
			Thread.sleep(5000);
			if (obj.getdbPassword().length() > 1)
				cc.OTPVerification(driver, mobile, false, obj);
			else
				driver.navigate().refresh();

			Thread.sleep(2000);
			CommonFunctions.acceptCookie(driver);
			Variables.elementWait(driver, 20,
					FetchData.readOR("signoutUserMouseHover"));
			String abc = driver.findElement(
					FetchData.readOR("signoutUserMouseHover")).getText();

			if (abc.toLowerCase().contains("sdiadiyf"))
				CommonFunctions.pass(child,
						"Click on Registration or Login Widget Passed user email id : "
								+ email);

			else
				CommonFunctions.fail(child,
						"Click on Registration or Login Widget Failed");
		} catch (Exception e) {
			// CommonFunctions.fail(child,
			// "Click on Registration or Login Widget Failed");
			CommonFunctions.fail(child,
					"Click on Registration or Login Widget Failed");
			throw e;
		}
	}

	public void collegexp() {
		Boolean h = false;
		try {

			// Variables.elementWait(driver, 10, By.tagName("iframe"));
			List<WebElement> iframes = driver
					.findElements(By.tagName("iframe"));
			int i = -1;
			for (WebElement webElement : iframes) {
				System.out.println(webElement.getAttribute("id") + "/hgn");
				i++;
				try {
					driver.switchTo().frame(i);
					h = driver.findElement(FetchData.readOR("collegexp"))
							.isDisplayed();
					break;
				} catch (Exception e) {
					driver.switchTo().defaultContent();
					System.out.println(e.toString() + "ff");
					continue;
				}

			}

			driver.switchTo().defaultContent();
			if (h) {
				CommonFunctions.pass(child,
						"verification of collegexp widget passed " + h);

			}

			else {
				CommonFunctions.fail(child,
						"verification of collegexp widget failed");
			}
		} catch (Exception e) {
			// CommonFunctions.fail(child,
			// "Click on Registration or Login Widget Failed");
			CommonFunctions.fail(child,
					"verification of collegexp widget failed");
			// throw e;
		}
	}

	public void latestArticle() {
		try {
			Variables
					.elementWait(driver, 20, FetchData.readOR("latestArticle"));
			// registrationWidgetSignup
			String h = driver.findElement(FetchData.readOR("latestArticle"))
					.getText();
			if (h.length() > 0) {
				CommonFunctions.pass(child,
						"verification of latest article widget passed " + h);
			} else {
				CommonFunctions.fail(child,
						"verification of latest article widget failed");
			}
		} catch (Exception e) {
			// CommonFunctions.fail(child,
			// "Click on Registration or Login Widget Failed");
			CommonFunctions.fail(child,
					"verification of latest article widget failed");
			// throw e;
		}
	}

	public void rightSideLinks() {
		try {
			System.out.println("d");
			// String url = driver.getCurrentUrl();
			Variables.elementWait(driver, 20, FetchData.readOR("rhsLinks"));
			// registrationWidgetSignup

			List<WebElement> we = driver.findElements(FetchData
					.readOR("rhsLinks"));
			// driver.get(url);
			for (WebElement webElement : we) {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView();", webElement);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,-200)", "");

				String text = webElement.getText();
				webElement.click();
				String newurl = CommonFunctions.StaticData(text.toLowerCase());
				ArrayList<String> tabs2 = new ArrayList<String>(
						driver.getWindowHandles());

				driver.switchTo().window(tabs2.get(1));

				if (driver.getCurrentUrl().contains(newurl)) {
					CommonFunctions.pass(
							child,
							"Redicraction for " + text
									+ " verified. Redirected url : "
									+ driver.getCurrentUrl());
				} else {
					CommonFunctions.fail(
							child,
							"Redicraction for " + text
									+ " failed. Redirected url : "
									+ driver.getCurrentUrl());
				}
				driver.close();
				driver.switchTo().window(tabs2.get(0));

			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "Rhs redirection failed");
			// throw e;
		}
	}

	public void expertPannel() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("expertpannel"));
			driver.findElement(FetchData.readOR("expertpannel")).click();

			ArrayList<String> tabs2 = new ArrayList<String>(
					driver.getWindowHandles());

			driver.switchTo().window(tabs2.get(1));

			String newurl = CommonFunctions.StaticData("view experts panel");
			if (driver.getCurrentUrl().contains(newurl)) {
				CommonFunctions.pass(child, "Redicraction for "
						+ "view experts panel" + " verified. Redirected url : "
						+ driver.getCurrentUrl());
			} else {
				CommonFunctions.fail(child, "Redicraction for "
						+ "view experts panel" + " failed. Redirected url : "
						+ driver.getCurrentUrl());
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"Click on login on RHS Widget Layer Failed");
			// throw e;
		}
	}

	public void ClickQnATextBox(String question) {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("QnAInputBox"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("QnAInputBox")));

			driver.findElement(FetchData.readOR("QnAInputBox")).sendKeys(
					question);
			CommonFunctions.pass(child, "Question posting text " + question
					+ " Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Question posting text " + question
					+ " Failed");
			throw e;
		}
	}

	public void signout() {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("signoutUserMouseHover"));
			Thread.sleep(1000);
			Actions actions = new Actions(driver);
			WebElement mainMenu = driver.findElement(FetchData
					.readOR("signoutUserMouseHover"));
			actions.moveToElement(mainMenu).build().perform();
			Thread.sleep(1000);
			WebElement finalMenu = driver.findElement(FetchData
					.readOR("signoutuser"));
			actions.moveToElement(finalMenu).click().build().perform();
			CommonFunctions.pass(child, "Signout user Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Signout user Failed");
		}
	}

	public void ClickQnADescription() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("QnADetails"));
			driver.findElement(FetchData.readOR("QnADetails")).click();
			CommonFunctions.pass(child,
					"Click on login on RHS Widget Layer Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"Click on login on RHS Widget Layer Failed");
			throw e;
		}
	}

	public void ClickQnADescriptionDetails(String Description) {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("QnADescription"));
			driver.findElement(FetchData.readOR("QnADescription")).sendKeys(
					Description);
			CommonFunctions.pass(child, "Question posting text " + Description
					+ " Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Question posting text " + Description
					+ " Failed");
			throw e;
		}
	}

	public void clickNextButton() {
		try {

			Variables.elementWait(driver, 20, FetchData.readOR("nextButton"));
			driver.findElement(FetchData.readOR("nextButton")).click();
			CommonFunctions.pass(child, "Click Next button Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click Next button Failed");
			throw e;
		}
	}

	public void clickaddMoreTags() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("addmoretags"));
			driver.findElement(FetchData.readOR("addmoretags")).click();
			CommonFunctions.pass(child, "Click addmoretags Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click addmoretags Failed");
			throw e;
		}
	}

	public void clickTagSearch(String mba) {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("tagsearch"));
			driver.findElement(FetchData.readOR("tagsearch")).sendKeys(mba);
			CommonFunctions.pass(child, "search tag " + mba + " Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "search tag " + mba + " Failed");
		}
	}

	public void clicktag() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("search"));
			driver.findElement(FetchData.readOR("search")).click();
			CommonFunctions.pass(child, "Click tag Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click tag Failed");
		}
	}

	public void clicktagdone() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("doneqna"));
			driver.findElement(FetchData.readOR("doneqna")).click();
			CommonFunctions.pass(child, "Click done tags Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click done tags Failed");
		}
	}

	public void clickPostQnA() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("postQnA"));
			driver.findElement(FetchData.readOR("postQnA")).click();
			CommonFunctions.pass(child, "Click Post QnA Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click Post QnA Failed");
			throw e;
		}
	}

	public void verifyTags(String tags) {
		try {
			boolean flag = false;
			try {
				Variables.elementWait(driver, 20,
						FetchData.readOR("viewAllTags"));
				driver.findElement(FetchData.readOR("viewAllTags")).click();
				List<WebElement> we = driver.findElements(FetchData
						.readOR("verifyMoreTag"));
				for (WebElement webElement : we) {
					System.out.println(webElement.getText());
					if (webElement.getText().equalsIgnoreCase(tags)) {
						flag = true;
						break;
					}
				}
			} catch (Exception e) {
				Variables.elementWait(driver, 20,
						FetchData.readOR("verifyMbaTag"));
				List<WebElement> we = driver.findElements(FetchData
						.readOR("verifyMbaTag"));
				for (WebElement webElement : we) {
					System.out.println(webElement.getText());
					if (webElement.getText().equalsIgnoreCase(tags)) {
						flag = true;
						break;
					}
				}
			}

			if (flag == true) {
				CommonFunctions.pass(child, "Tags Verification " + tags
						+ " Passed");
			} else {
				CommonFunctions.fail(child, "Tags Verification " + tags
						+ " Failed");
			}

		} catch (Exception e) {
			CommonFunctions
					.fail(child, "Tags Verification " + tags + " Failed");
		}
	}

	public void verifyquestionTitle(String title) {
		try {
			Thread.sleep(10000);
			Variables.elementWait(driver, 20,
					FetchData.readOR("editoverflowlayer"));
			if (driver.findElement(FetchData.readOR("verifyquestionTitle"))
					.getText().equalsIgnoreCase(title)) {
				CommonFunctions.pass(child, "Question Title " + title
						+ " Passed");
			} else {
				CommonFunctions.fail(child, "Question Title " + title
						+ " failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "Question Title " + title + " failed");
		}
	}

	public void verifyDescription(String desc) {
		try {
			Thread.sleep(10000);
			Variables.elementWait(driver, 20,
					FetchData.readOR("editoverflowlayer"));
			if (driver.findElement(FetchData.readOR("verifyDescription"))
					.getText().equalsIgnoreCase(desc)) {
				CommonFunctions.pass(child, "Question Title " + desc
						+ " Passed");
			} else {
				CommonFunctions.fail(child, "Question Title " + desc
						+ " failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "Question Title " + desc + " failed");
		}
	}

	public void clickEditoverFlowLayer() {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("editoverflowlayer"));
			driver.findElement(FetchData.readOR("editoverflowlayer")).click();
			CommonFunctions.pass(child, "Question desc Verification Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Question desc Verification Failed");
			throw e;
		}
	}

	public void clickEditoverFlowLayerverity() {
		try {
			Variables.elementWait(driver, 2,
					FetchData.readOR("editoverflowlayer"));
			driver.findElement(FetchData.readOR("editoverflowlayer")).click();
			CommonFunctions.fail(child, "Verify later failed");

		} catch (Exception e) {
			CommonFunctions.pass(child, "Verify later passed");

		}
	}

	public void commentlater() {
		try {
			Variables
					.elementWait(driver, 20, FetchData.readOR("lateransewerr"));
			driver.findElement(FetchData.readOR("lateransewerr")).click();
			CommonFunctions.pass(child, "Anser later Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Anser later Failed");
			throw e;
		}
	}

	public void clickabuselayer() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("abuselayer"));
			driver.findElement(FetchData.readOR("abuselayer")).click();
			CommonFunctions.pass(child, "Click on report abuse Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on report abuse Failed");
			throw e;
		}
	}

	public void verifyclickabuselayer() {
		try {
			Variables.elementWait(driver, 2, FetchData.readOR("lateransewerr"));
			driver.findElement(FetchData.readOR("lateransewerr")).click();
			CommonFunctions.fail(child, "Verify report abuse failed");

		} catch (Exception e) {
			CommonFunctions.pass(child, "Verify report abuse passed");
		}
	}

	public void clickabuselayerother() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("abuselayer6"));
			driver.findElement(FetchData.readOR("abuselayer6")).click();
			CommonFunctions.pass(child,
					"Click on report abuse reason other Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child,
					"Click on report abuse reason other  Failed");
			throw e;
		}
	}

	public void clickabusedone() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("abusedone"));
			driver.findElement(FetchData.readOR("abusedone")).click();
			CommonFunctions.pass(child,
					"Click on report abuse reason other Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child,
					"Click on report abuse reason other  Failed");
			throw e;
		}
	}

	public void clickabuselayertext(String text) {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("abusetext"));
			driver.findElement(FetchData.readOR("abusetext")).sendKeys(text);
			CommonFunctions.pass(child,
					"Click on report abuse reason other Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child,
					"Click on report abuse reason other  Failed");
			throw e;
		}
	}

	public void clickEditoverFlowLayer2() {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("commentdeletelayer"));
			driver.findElement(FetchData.readOR("commentdeletelayer")).click();
			CommonFunctions.pass(child, "commentdeletelayer click Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "commentdeletelayer click Failed");
		}
	}

	public void checkPagination(String url) {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("Pagi_Tag"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Pagi_Tag")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-300)", "");
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("Pagi_Tag")).click();

			String newurl = driver.getCurrentUrl();

			if (newurl.equalsIgnoreCase(url + "-2")) {
				CommonFunctions.pass(child, "Pagination Passed");
			}

			else {
				CommonFunctions.fail(child, "Pagination Failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "Pagination  Failed");
		}
	}

	public void checkPagination2(String url) {
		try {
			driver.get(url);
			Variables.elementWait(driver, 20, FetchData.readOR("Pagi_Tag"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("Pagi_Tag")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-300)", "");
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("Pagi_Tag")).click();

			String newurl = driver.getCurrentUrl();

			if (newurl.equalsIgnoreCase(url + "/2")) {
				CommonFunctions.pass(child, "Pagination Passed");
			}

			else {
				CommonFunctions.fail(child, "Pagination Failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "Pagination  Failed");
		}
	}

	public void relatedTag() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("Related_Tag"));
			String text = driver.findElement(FetchData.readOR("Related_Tag"))
					.getText();

			if (text.length() > 1) {
				CommonFunctions.pass(child, "Pagination Passed");
			}

			else {
				CommonFunctions.fail(child, "Pagination Failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "Pagination  Failed");
		}
	}

	public void tagSearch() {
		try {
			Variables
					.elementWait(driver, 20, FetchData.readOR("AllTag_Search"));

			driver.findElement(FetchData.readOR("AllTag_Search")).sendKeys(
					"CAT");
			Variables.elementWait(driver, 20, FetchData.readOR("AllTag_CAT"));
			driver.findElement(FetchData.readOR("AllTag_CAT")).click();

			ArrayList<String> tabs2 = new ArrayList<String>(
					driver.getWindowHandles());

			driver.switchTo().window(tabs2.get(1));

			String text = driver.findElement(FetchData.readOR("AllTag_CAT_1"))
					.getText();

			if (text.toLowerCase().contains("cat")) {
				CommonFunctions.pass(child, "Tag Search Passed");
			} else {
				CommonFunctions.fail(child, "Tag Search Failed");
			}

			driver.close();
			driver.switchTo().window(tabs2.get(0));
		} catch (Exception e) {
			CommonFunctions.fail(child, "Tag Search Failed");
		}
	}

	public void contributor() {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("contributot_Tag"));
			String text = driver.findElement(
					FetchData.readOR("contributot_Tag")).getText();

			if (text.length() > 1) {
				CommonFunctions.pass(child, "Pagination Passed");
			}

			else {
				CommonFunctions.fail(child, "Pagination Failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "Pagination  Failed");
		}
	}

	public void deletecommentanswer() {
		try {

			Variables
					.elementWait(driver, 20, FetchData.readOR("commentdelete"));
			WebElement webElement = driver.findElement(FetchData
					.readOR("commentdelete"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", webElement);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-300)", "");
			webElement.click();
			CommonFunctions.pass(child, "commentdeletelayer click Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "commentdeletelayer click Failed");
		}
	}

	public void deletequestion() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("delques")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-500)", "");
			Variables.elementWait(driver, 20, FetchData.readOR("delques"));
			driver.findElement(FetchData.readOR("delques")).click();
			CommonFunctions.pass(child, "delques click Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "delques click Failed");
		}
	}

	public void closequestion() {
		try {
			Variables
					.elementWait(driver, 20, FetchData.readOR("commentdelete"));
			driver.findElement(FetchData.readOR("commentdelete")).click();
			CommonFunctions.pass(child, "close question click Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "close question click Failed");
		}
	}

	public void performAction() {
		try {
			Variables
					.elementWait(driver, 20, FetchData.readOR("performAction"));
			driver.findElement(FetchData.readOR("performAction")).click();
			CommonFunctions.pass(child, "performAction click Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "performAction click Failed");
		}
	}

	public void verify(String url) {
		try {
			String ufrl = driver.getCurrentUrl();
			if (url.equals(ufrl))
				CommonFunctions.pass(child, "verify question delete Passed");
			else
				CommonFunctions.fail(child, "verify question delete Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "verify question delete Failed");
		}
	}

	public void closeques() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("quesclosed"));
			String text = driver.findElement(FetchData.readOR("quesclosed"))
					.getText();
			if (text.toLowerCase().contains(
					"the question is closed for answering"))
				CommonFunctions.pass(child, "Question close Passed");
			else
				CommonFunctions.fail(child, "Question close Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "verify close Failed");
		}
	}

	public void clickEditTags() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("editTags"));
			driver.findElement(FetchData.readOR("editTags")).click();
			CommonFunctions.pass(child, "Question desc Verification Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Question desc Verification Failed");
			throw e;
		}
	}

	public void clickComment() {
		try {
			Variables
					.elementWait(driver, 20, FetchData.readOR("commentButton"));
			driver.findElement(FetchData.readOR("commentButton")).click();
			CommonFunctions.pass(child, "Click post comment Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Click post comment Failed");
			throw e;
		}
	}

	public void TypeComment(String comment) {
		try {

			Variables.elementWait(driver, 20, FetchData.readOR("typecomment"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("typecomment")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-500)", "");
			driver.findElement(FetchData.readOR("typecomment")).sendKeys(
					comment);
			CommonFunctions.pass(child, "Click post comment Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Click post comment Failed");
			throw e;
		}
	}

	public void clickQuestion() {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("editquestionana"));
			driver.findElement(FetchData.readOR("editquestionana")).click();
			CommonFunctions.pass(child, "Question desc Verification Passed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Question desc Verification Failed");
			throw e;
		}
	}

	public void verifyFollow() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("followButton")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");

			Variables.elementWait(driver, 20, FetchData.readOR("followButton"));
			if (driver.findElement(FetchData.readOR("followButton")).getText()
					.equalsIgnoreCase("unfollow")) {
				driver.findElement(FetchData.readOR("followButton")).click();

			}

			driver.findElement(FetchData.readOR("followButton")).click();

			if (driver.findElement(FetchData.readOR("followButton")).getText()
					.equalsIgnoreCase("unfollow")) {
				CommonFunctions.pass(child, "Click follow Passed");
				driver.findElement(FetchData.readOR("followButton")).click();
				if (driver.findElement(FetchData.readOR("followButton"))
						.getText().equalsIgnoreCase("follow")) {
					CommonFunctions.pass(child, "Click unfollow Passed");
				}

				else {
					CommonFunctions.fail(child, "Click follow failed");
				}

			} else {
				CommonFunctions.fail(child, "Click follow failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "Click follow Failed");
		}
	}

	public void verifyupvote() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("thumbsUpbutton")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			Variables.elementWait(driver, 20,
					FetchData.readOR("thumbsUpbutton"));

			if (driver.findElement(FetchData.readOR("thumbsUpbutton"))
					.getAttribute("class").equalsIgnoreCase("b-like")) {
				driver.findElement(FetchData.readOR("thumbsUpbutton")).click();
			}

			int count1 = Integer.parseInt(driver.findElement(
					FetchData.readOR("thumbsUpText")).getText());

			driver.findElement(FetchData.readOR("thumbsUpbutton")).click();
			int count2 = Integer.parseInt(driver.findElement(
					FetchData.readOR("thumbsUpText")).getText());

			if (count2 == count1 + 1 || count2 == count1 - 1) {
				driver.findElement(FetchData.readOR("thumbsUpbutton")).click();
				CommonFunctions.pass(child, "Upvote Passed old count : "
						+ count1 + " new count : " + count2);
			}

			else {
				CommonFunctions.fail(child, "Upvote failed old count : "
						+ count1 + " new count : " + count2);
			}

		} catch (NoSuchElementException ex) {
			CommonFunctions.error(child, "upvote Failed");
		}

		catch (Exception e) {
			CommonFunctions.fail(child, "upvote Failed");
		}
	}

	public void verifydownvote() {
		try {

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("thumbsdownbutton")));
			Variables.elementWait(driver, 20,
					FetchData.readOR("thumbsdownbutton"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");

			if (driver.findElement(FetchData.readOR("thumbsdownbutton"))
					.getAttribute("class").equalsIgnoreCase("b-dislike")) {
				driver.findElement(FetchData.readOR("thumbsdownbutton"))
						.click();
			}
			int count1 = Integer.parseInt(driver.findElement(
					FetchData.readOR("thumbsdownText")).getText());

			driver.findElement(FetchData.readOR("thumbsdownbutton")).click();
			int count2 = Integer.parseInt(driver.findElement(
					FetchData.readOR("thumbsdownText")).getText());

			if (count2 == count1 + 1 || count2 == count1 - 1) {
				CommonFunctions.pass(child, "Down vote Passed old count : "
						+ count1 + " new count : " + count2);
				driver.findElement(FetchData.readOR("thumbsdownbutton"))
						.click();
			}

			else {
				CommonFunctions.fail(child, "downvote failed old count : "
						+ count1 + " new count : " + count2);
			}

		} catch (NoSuchElementException ex) {
			CommonFunctions.error(child, "upvote Failed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "down vote Failed");
		}
	}

	public void clickFolowers() {
		try {
			Variables.elementWait(driver, 50, FetchData.readOR("followers"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("followers")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			Variables.elementWait(driver, 50, FetchData.readOR("followers"));
			driver.findElement(FetchData.readOR("followers")).click();
			CommonFunctions.pass(child, "Click Followers Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click Followerse Failed");
		}
	}

	public void clickFolowers_2() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("followers_1"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("followers_1")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			Variables.elementWait(driver, 10, FetchData.readOR("followers_1"));
			try {
				driver.findElement(FetchData.readOR("followers_1")).click();
				CommonFunctions.pass(child, "Click Followers Passed");
			} catch (Exception ex) {
				CommonFunctions.fail(child, "Click Followers Failed");
				throw ex;
			}
		} catch (Exception e) {
			CommonFunctions.error(child, "Click Followers Failed");
			throw e;
		}
	}

	public void verifyFolowers() {
		try {
			Variables.elementWait(driver, 50,
					FetchData.readOR("verifyFolowers"));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("verifyFolowers")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");

			if (!driver.findElement(FetchData.readOR("verifyFolowers"))
					.getText().isEmpty()) {
				CommonFunctions.pass(child, "Verify Followers Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Verify Followers Failed");
		}
	}

	public void clickFollowonLayer() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("clickFollowonLayer")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			Variables.elementWait(driver, 50,
					FetchData.readOR("clickFollowonLayer"));
			if (driver.findElement(FetchData.readOR("clickFollowonLayer"))
					.getText().equalsIgnoreCase("follow")) {
				driver.findElement(FetchData.readOR("clickFollowonLayer"))
						.click();
				if (driver.findElement(FetchData.readOR("clickFollowonLayer"))
						.getText().equalsIgnoreCase("unfollow")) {
					driver.findElement(FetchData.readOR("clickFollowonLayer"))
							.click();
					CommonFunctions.pass(child, "click follow on layer Passed");
				}

				else {
					CommonFunctions.fail(child, "click follow on layer Failed");
				}
			}

			else {
				driver.findElement(FetchData.readOR("clickFollowonLayer"))
						.click();
				if (driver.findElement(FetchData.readOR("clickFollowonLayer"))
						.getText().equalsIgnoreCase("follow")) {
					CommonFunctions.pass(child, "click follow on layer Passed");
				}

				else {
					CommonFunctions.fail(child, "click follow on layer Failed");
				}
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Verify Followers Failed");
		}
	}

	public void clickDiscussionTab() {
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("DiscussionTab"));
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("DiscussionTab")).click();
			CommonFunctions.pass(child, "click discussion tab Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "click discussion tab Failed");
		}
	}

	public void clickAnswerTab() {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("AnswerTab"));
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("AnswerTab")).click();
			CommonFunctions.pass(child, "click answer tab Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "click answer tab Failed");
		}
	}

	public void clickCommentAnswerButton() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("AnswerComment")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			Variables
					.elementWait(driver, 10, FetchData.readOR("AnswerComment"));
			driver.findElement(FetchData.readOR("AnswerComment")).click();
			CommonFunctions
					.pass(child, "click comment or answer button Passed");
		} catch (Exception e) {
			CommonFunctions
					.fail(child, "click comment or answer button Failed");
		}
	}

	public void typeDiscussionComment(String comment) {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("CommentDiscussionDescrition"));
			driver.findElement(FetchData.readOR("CommentDiscussionDescrition"))
					.sendKeys(comment);
			CommonFunctions.pass(child, "type comment " + comment + " Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "type comment " + comment + " failed");
		}
	}

	public void typeDiscussionComment2(String comment) {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("CommentDiscussionDescrition2"));
			driver.findElement(FetchData.readOR("CommentDiscussionDescrition2"))
					.sendKeys(comment);
			CommonFunctions.pass(child, "type comment " + comment + " Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "type comment " + comment + " failed");
		}
	}

	public void typeQuestionAnswer(String answer) {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("AnswerQuestionDescription"));
			driver.findElement(FetchData.readOR("AnswerQuestionDescription"))
					.sendKeys(answer);
			CommonFunctions.pass(child, "type answer " + answer + " Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "type answer " + answer + " failed");
		}
	}

	public void typeQuestionAnswer2(String answer) {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("AnswerQuestionDescription"));
			driver.findElement(FetchData.readOR("AnswerQuestionDescription"))
					.sendKeys(answer);
			CommonFunctions.pass(child, "type answer " + answer + " Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "type answer " + answer + " failed");
		}
	}

	public void clickPostAnswerComment() {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("CommentAnswerPostButton"));
			driver.findElement(FetchData.readOR("CommentAnswerPostButton"))
					.click();
			CommonFunctions.pass(child, "post comment or answer Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "post comment or answer Failed");
		}
	}

	public void verifyreply(String reply) {
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("verifyrepkty"));
			String text = driver.findElement(FetchData.readOR("verifyrepkty"))
					.getText();
			if (text.equalsIgnoreCase(text))
				CommonFunctions.pass(child, "Verify Reply Passed");

			else
				CommonFunctions.fail(child, "Verify Reply Failed");

		} catch (Exception e) {
			CommonFunctions.fail(child, "Verify Reply Failed");
			throw e;
		}
	}

	public void clickReply() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("verifyReply1")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-500)", "");
			Variables.elementWait(driver, 20, FetchData.readOR("verifyReply1"));
			driver.findElement(FetchData.readOR("verifyReply1")).click();
			CommonFunctions.pass(child, "post comment or answer Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "post comment or answer Failed");
		}
	}

	public void clickReply2() {
		try {
			Variables.elementWait(driver, 2, FetchData.readOR("verifyrepkty"));
			driver.findElement(FetchData.readOR("verifyrepkty")).click();
			CommonFunctions.fail(child, "Verify reply failed");
		} catch (Exception e) {
			CommonFunctions.pass(child, "Verify reply passed");
		}
	}

	public void clickPostAnswerComment2() {
		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("CommentAnswerPostButton2"));
			driver.findElement(FetchData.readOR("CommentAnswerPostButton2"))
					.click();
			CommonFunctions.pass(child, "post comment or answer Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "post comment or answer Failed");
		}
	}

	public void deleteCommentAnswer(int i) {
		try {
			int j = 0;
			boolean flag = false;
			Variables.elementWait(driver, 20,
					FetchData.readOR("deleteAnsComment"));
			List<WebElement> we = driver.findElements(FetchData
					.readOR("deleteAnsComment"));
			for (WebElement webElement : we) {
				if (i == j) {
					webElement.click();
					flag = true;
					break;
				}
				j++;

			}
			if (flag == true) {
				CommonFunctions.pass(child, "delete comment or answer Passed");
			}

			else {
				CommonFunctions.fail(child, " deletecomment or answer  Failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "delete comment or answer Failed");
		}
	}

	public void verifyCommentAnswerText(String text) {
		try {
			int i = 0;
			boolean flag = false;
			Variables.elementWait(driver, 20,
					FetchData.readOR("verifyCommentAnswerText"));
			List<WebElement> element = driver.findElements(FetchData
					.readOR("verifyCommentAnswerText"));

			for (WebElement webElement : element) {
				if (webElement.getText().equalsIgnoreCase(text)) {
					flag = true;
					deleteCommentAnswer(i);
					i++;
					break;
				}
			}

			if (flag == true) {
				CommonFunctions.pass(child, "comment or answer " + text
						+ " verification Passed");
			}

			else {
				CommonFunctions.fail(child, "comment or answer " + text
						+ " verification failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(child, "comment or answer " + text
					+ " verification failed");
			throw e;
		}
	}

	public void verifyCommentAnswerTexwt(String text) {
		try {
			int i = 0;
			boolean flag = false;
			Variables.elementWait(driver, 20,
					FetchData.readOR("verifyCommentAnswerText"));
			List<WebElement> element = driver.findElements(FetchData
					.readOR("verifyCommentAnswerText"));

			for (WebElement webElement : element) {
				if (webElement.getText().equalsIgnoreCase(text)) {
					flag = true;
					deleteCommentAnswer(i);
					i++;
					break;
				}
			}

			if (flag == true) {
				CommonFunctions.fail(child, "comment or answer " + text
						+ " verification failed");
			}

			else {
				CommonFunctions.pass(child, "comment or answer " + text
						+ " verification passed");
			}

		} catch (Exception e) {
			CommonFunctions.pass(child, "comment or answer " + text
					+ " verification failed");
		}
	}

	public void verifyViewMoreonDiscussion() {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("DiscussionViewMore")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-500)", "");
			Variables.elementWait(driver, 20,
					FetchData.readOR("DiscussionViewMore"));
			if (driver.findElement(FetchData.readOR("DiscussionViewMore"))
					.getAttribute("style").isEmpty()) {
				driver.findElement(FetchData.readOR("DiscussionViewMore"))
						.click();

				if (!driver.findElement(FetchData.readOR("DiscussionViewMore"))
						.getAttribute("style").isEmpty())
					CommonFunctions.pass(child,
							"verifyViewMoreonDiscussion Passed");

				else {
					CommonFunctions.fail(child,
							"verifyViewMoreonDiscussion Passed");
				}
			} else {
				CommonFunctions
						.fail(child, "verifyViewMoreonDiscussion Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "verifyViewMoreonDiscussion Failed");
		}
	}

}
