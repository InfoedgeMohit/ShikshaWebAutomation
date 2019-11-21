package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.shiksha.main.Objects;
import com.shiksha.resourses.CommonFunctions;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class CTA_Mobile {
	CommonFunctions CommonFunctions = new CommonFunctions();

	public String clickdownloadBrochure(ExtentTest t, WebDriver driver,
			String locator, String value, String ctaAction, String id1)
			throws Exception {
		String id = id1;
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			try {
				Variables.elementWait(driver, 3,
						FetchData.readOR("lcationlayerforcta"));
				WebDriver we = driver.findElement(FetchData
						.readOR("lcationlayerforcta"));
				executor.executeScript("arguments[0].click();", we);
			} catch (Exception e) {

			}

			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));
			CommonFunctions.scrollToElement(FetchData.getData(locator, value),
					driver);
			if (id.length() < 1)
				id = brochure_id(driver, locator, value);

			WebElement we = driver.findElement(FetchData
					.getData(locator, value));

			executor.executeScript("arguments[0].click();", we);

			// // Course Layer
			if (id.length() < 1) {
				try {
					String[] elem = Variables.objects.get("selecttopCourse");
					id = brochure_id(driver, elem[0], elem[1]);
					Variables.elementWait(driver, 5,
							FetchData.readOR("selecttopCourse"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("selecttopCourse")));

				} catch (Exception e) {

				}
			}
			// // Seelct client course in case of UILP

			CommonFunctions.pass(t, ctaAction + " passed");
		} catch (Exception e) {

			CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}
		return id;

	}

	public void clickcompare(ExtentTest t, WebDriver driver, String locator,
			String value, String ctaAction) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {

			Variables.elementWait(driver, 10,
					FetchData.getData(locator, "(" + value + ")[2]"));

			List<WebElement> childs1 = driver.findElements(FetchData.getData(
					locator, value));

			int count = 0;
			for (WebElement webElement : childs1) {
				try {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView();", webElement);
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,-200)", "");
					executor.executeScript("arguments[0].click();", webElement);
					count++;
					if (count > 3)
						break;
				} catch (Exception e) {
					break;
				}
			}
			CommonFunctions.pass(t, ctaAction + " passed");
		} catch (Exception e) {

			CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}

	}

	public void clickcompare_AMP(ExtentTest t, WebDriver driver,
			String locator, String value, String ctaAction) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			ScrollCTA(driver);
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));
			WebElement childs1 = driver.findElement(FetchData.getData(locator,
					value));
			executor.executeScript("arguments[0].click();", childs1);
			CommonFunctions.pass(t, ctaAction + " failed");

		} catch (Exception e) {
			CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}

	}

	public void clickApply(ExtentTest t, WebDriver driver, String locator,
			String value, String ctaAction) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));

			WebElement childs1 = driver.findElement(FetchData.getData(locator,
					value));

			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", childs1);
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			executor.executeScript("arguments[0].click();", childs1);

			CommonFunctions.pass(t, ctaAction + " passed");
		} catch (Exception e) {

			CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}

	}

	public void clickrecoCTA(ExtentTest t, WebDriver driver, String locator,
			String value, String ctaAction) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			if (ctaAction.contains("download")) {
				ScrollCTA(driver);
			}
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));

			WebElement childs1 = driver.findElement(FetchData.getData(locator,
					value));
			executor.executeScript("arguments[0].click();", childs1);

			CommonFunctions.pass(t, ctaAction + " passed");
		} catch (Exception e) {

			CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}

	}

	public void examPage(ExtentTest t, WebDriver driver, String locator,
			String value, String ctaAction) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		if (ctaAction.contains("Sticky")) {
			ScrollCTA(driver);
		}

		if (ctaAction.contains("Download_Sample_Paper")
				|| ctaAction.contains("Download_Perp_Guide")) {
			ArrayList<String> tabs2 = new ArrayList<String>(
					driver.getWindowHandles());
			if (tabs2.size() > 1) {
				driver.switchTo().window(tabs2.get(1));
				driver.close();
				driver.switchTo().window(tabs2.get(0));
			}
		}
		try {
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));

			WebElement childs1 = driver.findElement(FetchData.getData(locator,
					value));
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", childs1);
			executor.executeScript("arguments[0].click();", childs1);

			CommonFunctions.pass(t, ctaAction + " passed");
		} catch (Exception e) {
			CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}

	}

	public void prestepsApply(WebDriver driver) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("pre_stream"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_stream")));

			Thread.sleep(2000);
			Variables.elementWait(driver, 10, FetchData.readOR("pre_stream_1"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_stream_1")));

			Thread.sleep(2000);
			Variables.elementWait(driver, 10, FetchData.readOR("pre_course"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_course")));

			Variables.elementWait(driver, 10,
					FetchData.readOR("pre_course_spcl_1"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_course_spcl_1")));

			Variables.elementWait(driver, 10, FetchData.readOR("pre_done"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_done")));

			Thread.sleep(2000);
			Variables.elementWait(driver, 10, FetchData.readOR("pre_spcl"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_spcl")));

			Variables.elementWait(driver, 10,
					FetchData.readOR("pre_course_spcl_1"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_course_spcl_1")));

			Variables.elementWait(driver, 10, FetchData.readOR("pre_done"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_done")));

			Thread.sleep(2000);
			Variables.elementWait(driver, 10, FetchData.readOR("pre_edumode"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_edumode")));

			Variables.elementWait(driver, 10,
					FetchData.readOR("pre_course_spcl_1"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_course_spcl_1")));

			Variables.elementWait(driver, 10, FetchData.readOR("pre_done"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_done")));

			Variables.elementWait(driver, 10, FetchData.readOR("pre_next"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("pre_next")));

		} catch (Exception e) {
		}

	}

	public void clickcompare_sticky(ExtentTest t, WebDriver driver,
			String locator, String value, String ctaAction) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			ScrollCTA(driver);
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));
			WebElement childs1 = driver.findElement(FetchData.getData(locator,
					value));
			executor.executeScript("arguments[0].click();", childs1);

			String url = driver.getCurrentUrl();
			url = url.substring(0, url.indexOf(".com") + 4);
			driver.get(url
					+ "/business-management-studies/course/executive-pgpm-indian-institute-of-management-bangalore-bannerghatta-road-115020");
			ScrollCTA(driver);
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.getData(locator, value)));
			driver.get(url
					+ "/business-management-studies/course/executive-pgpm-indian-institute-of-management-bangalore-bannerghatta-road-1666");
			ScrollCTA(driver);
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.getData(locator, value)));
			CommonFunctions.pass(t, ctaAction + " passed");

		} catch (Exception e) {
			CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}

	}

	public void afterCompareAmp(WebDriver driver, String locator, String value)
			throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {

			String url = driver.getCurrentUrl();
			url = url.substring(0, url.indexOf(".com") + 4);
			driver.get(url
					+ "/business-management-studies/course/executive-pgpm-indian-institute-of-management-bangalore-bannerghatta-road-115020");
			ScrollCTA(driver);
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.getData(locator, value)));
			driver.get(url
					+ "/business-management-studies/course/executive-pgpm-indian-institute-of-management-bangalore-bannerghatta-road-1666");
			ScrollCTA(driver);
			Variables
					.elementWait(driver, 10, FetchData.getData(locator, value));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.getData(locator, value)));

			Thread.sleep(2000);
			
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("comparebtnonCTA")));
			// CommonFunctions.pass(t, ctaAction + " passed");

		} catch (Exception e) {
			// CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}

	}

	public void clickcompare_scroll(ExtentTest t, WebDriver driver,
			String locator1, String value1, String ctaAction) throws Exception {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			ScrollCTA(driver);
			Variables.elementWait(driver, 10,
					FetchData.getData(locator1, value1));
			WebElement childs1d = driver.findElement(FetchData.getData(
					locator1, value1));
			executor.executeScript("arguments[0].click();", childs1d);

			String value = ".//*[@id='course-compare-list']//label";
			String locator = "xpath";
			Variables.elementWait(driver, 10,
					FetchData.getData(locator, "(" + value + ")[2]"));

			List<WebElement> childs1 = driver.findElements(FetchData.getData(
					locator, value));

			int count = 0;
			for (WebElement webElement : childs1) {
				try {
					((JavascriptExecutor) driver).executeScript(
							"arguments[0].scrollIntoView();", webElement);
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,-200)", "");
					executor.executeScript("arguments[0].click();", webElement);
					count++;
					if (count > 3)
						break;
				} catch (Exception e) {
					break;
				}

			}
			CommonFunctions.pass(t, ctaAction + " passed");
		} catch (Exception e) {
			CommonFunctions.fail(driver, t, ctaAction + " failed");
			throw e;
		}

	}

	public String brochure_id(WebDriver driver, String locator, String value)
			throws Exception {
		String id = "";
		try {
			Variables.elementWait(driver, 3, FetchData.getData(locator, value));
			CommonFunctions.scrollToElement(FetchData.getData(locator, value),
					driver);
			WebElement we = driver.findElement(FetchData
					.getData(locator, value));
			String ee = we.getAttribute("id");

			id = ee.substring(ee.indexOf("_") + 1, ee.length());

			// System.out.println(ee);

		} catch (Exception e) {
			// throw e;
		}

		return id;

	}

	public String login(WebDriver driver, Objects obj) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			try {
				Variables.elementWait(driver, 10,
						FetchData.readOR("clickloginText_Mobile"));
				CommonFunctions.scrollToElement(
						FetchData.readOR("clickloginText_Mobile"), driver);
				WebElement we = driver.findElement(FetchData
						.readOR("clickloginText_Mobile"));

				executor.executeScript("arguments[0].click();", we);

			} catch (Exception e) {
				try {

					Variables.elementWait(driver, 10,
							FetchData.readOR("applylogin"));
					CommonFunctions.scrollToElement(
							FetchData.readOR("applylogin"), driver);
					WebElement we1 = driver.findElement(FetchData
							.readOR("applylogin"));
					JavascriptExecutor executor1 = (JavascriptExecutor) driver;
					executor1.executeScript("arguments[0].click();", we1);
				} catch (Exception ex) {
					throw ex;

				}
			}
			CommonFunctions.login_special(driver, "test1qa@gmail.com",
					"shiksha", obj);
			Thread.sleep(5000);
			try {
				try {
					Variables.elementWait(driver, 5,
							FetchData.readOR("clientcourse_deb"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("clientcourse_deb")));
					Variables.elementWait(driver, 5,
							FetchData.readOR("clientcourse_deb_1"));
					executor.executeScript("arguments[0].click();",
							driver.findElement(FetchData
									.readOR("clientcourse_deb_1")));
					Thread.sleep(2000);
				} catch (Exception e) {

				}
				try {
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_woekExp"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_woekExp")));
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_woekExp_2"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_woekExp_2")));
					Thread.sleep(2000);
				} catch (Exception e) {

				}

				try {
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_prefcity"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_prefcity")));
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_prefcity_2"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_prefcity_2")));
					Thread.sleep(2000);
				} catch (Exception e) {

				}
				try {

					Variables.elementWait(driver, 5,
							FetchData.readOR("login_locality"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_locality")));
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_locality_2"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_locality_2")));
					Thread.sleep(2000);
				} catch (Exception e) {

				}
				Variables.elementWait(driver, 5,
						FetchData.readOR("clientcourse_deb_2"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("clientcourse_deb_2")));
				Thread.sleep(2000);

			} catch (Exception e) {
				// // Do nothing
			}

		} catch (Exception e) {
			throw e;
		}

		return "test1qa@gmail.com";

	}

	public String[] signup(WebDriver driver, Objects obj) throws Exception {
		String email = "";
		String education = "false";
		String number = "false";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		CommonFunctions.acceptterms(driver);
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("clientcourse_deb"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("clientcourse_deb")));

			Variables.elementWait(driver, 5,
					FetchData.readOR("clientcourse_deb_1"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("clientcourse_deb_1")));

		} catch (Exception e) {
			// // Do nothing
		}

		try {
			email = CommonFunctions.RandomEmail("shikshatest.com");

			Variables.elementWait(driver, 20, FetchData.readOR("signupemail"));
			driver.findElement(FetchData.readOR("signupemail")).sendKeys(email);

			Variables.elementWait(driver, 50, FetchData.readOR("signuppass"));
			driver.findElement(FetchData.readOR("signuppass")).sendKeys(
					"shiksha");

			try {
				// // Optional Fields
				// // Work Ex
				Variables.elementWait(driver, 5,
						FetchData.readOR("signupworkex"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signupworkex")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signupworkexdrop"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("signupworkexdrop")));
			} catch (Exception e) {
			}

			try {
				// // Exams Taken
				Variables
						.elementWait(driver, 5, FetchData.readOR("signupexam"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signupexam")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signupexamdrop"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signupexamdrop")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signupexamselect"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("signupexamselect")));
				education = "true";

			} catch (Exception e) {
			}

			try {
				// // Locality
				Variables.elementWait(driver, 5,
						FetchData.readOR("signuplocality"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signuplocality")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signuplocalitydrop"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("signuplocalitydrop")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signuplocality1"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signuplocality1")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signuplocalitydrop1"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("signuplocalitydrop1")));
			} catch (Exception e) {
				// // do nothig
			}

			// //
			Variables.elementWait(driver, 10, FetchData.readOR("signupFName"));
			driver.findElement(FetchData.readOR("signupFName")).sendKeys(
					"Shiksha");

			Variables.elementWait(driver, 10, FetchData.readOR("signupLName"));
			driver.findElement(FetchData.readOR("signupLName"))
					.sendKeys("Test");

			Variables.elementWait(driver, 10, FetchData.readOR("signupmobile"));
			number = CommonFunctions.RandomNumber('9');
			driver.findElement(FetchData.readOR("signupmobile")).sendKeys(
					number);

			Variables.elementWait(driver, 10,
					FetchData.readOR("signuplocation"));

			WebElement we = driver.findElement(FetchData
					.readOR("signuplocation"));

			executor.executeScript("arguments[0].click();", we);

			Variables.elementWait(driver, 10,
					FetchData.readOR("signuplocation_2"));
			WebElement we1 = driver.findElement(FetchData
					.readOR("signuplocation_2"));
			executor.executeScript("arguments[0].click();", we1);
			try {
				Variables.elementWait(driver, 10,
						FetchData.readOR("signupbutton"));
				WebElement we2 = driver.findElement(FetchData
						.readOR("signupbutton"));
				executor.executeScript("arguments[0].click();", we2);
			} catch (Exception df) {
				try {
					Variables.elementWait(driver, 10,
							FetchData.readOR("signupbutton_2"));
					WebElement we2 = driver.findElement(FetchData
							.readOR("signupbutton_2"));
					executor.executeScript("arguments[0].click();", we2);
				} catch (Exception er) {
					throw er;
				}

			}

			try {
				Variables.elementWait(driver, 10,
						FetchData.readOR("loginDesktop_OTP"));
			}

			catch (Exception e) {

			}

		} catch (Exception e) {
			throw e;
		}

		String[] xs = new String[] { email, education, number };
		return xs;
	}

	public void verifyLayer(WebDriver driver, ExtentTest t, String cta,
			String data, String occlayer) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("headings_cta"));

			WebElement we = driver
					.findElement(FetchData.readOR("headings_cta"));

			String layer = we.getText();
			String layer2 = CommonFunctions.StaticData(data.toLowerCase());

			if (layer.equalsIgnoreCase(layer2))
				CommonFunctions.pass(t, "Verification for " + cta + " passed"
						+ " Actual : " + layer2 + " Expected : " + layer);
			else {
				if (occlayer.equalsIgnoreCase("y")) {
					CommonFunctions.fail(driver, t, "Verification for " + cta
							+ " failed" + " Actual : " + layer2
							+ " Expected : " + layer);
				}
			}
		} catch (Exception e) {
			if (occlayer.equalsIgnoreCase("y")) {
				CommonFunctions.fail(driver, t, "Verification for " + cta
						+ " failed");
				throw e;
			}
		}

	}

	public void verifyLayerCompare(WebDriver driver, ExtentTest t, String cta,
			String data) {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("headings_cta_compare"));

			WebElement we = driver.findElement(FetchData
					.readOR("headings_cta_compare"));

			String layer = we.getText();
			String layer2 = CommonFunctions.StaticData(data.toLowerCase());

			if (layer.equalsIgnoreCase(layer2))
				CommonFunctions.pass(t, "Verification for " + cta + " passed"
						+ " Actual : " + layer2 + " Expected : " + layer);
			else
				CommonFunctions.fail(driver, t, "Verification for " + cta
						+ " failed" + " Actual : " + layer2 + " Expected : "
						+ layer);

		} catch (Exception e) {

			CommonFunctions.fail(driver, t, "Verification for " + cta
					+ " failed");
			throw e;
		}

	}

	public void verifyLayerExamPage(WebDriver driver, ExtentTest t, String cta,
			String data) {

		try {
			Variables.elementWait(driver, 20,
					FetchData.readOR("heading_Exam_page"));
		} catch (Exception e) {

		}
		try {
			if (!data.toLowerCase().contains("download")) {
				String layer = driver.getCurrentUrl();

				if (layer.contains("/question-papers"))
					CommonFunctions.pass(t, "Verification for " + cta
							+ " passed" + " Actual : " + "/question-papers"
							+ " Expected : " + layer);
				else
					CommonFunctions.fail(driver, t, "Verification for " + cta
							+ " failed" + " Actual : " + "/question-papers"
							+ " Expected : " + layer);

			} else {
				WebElement we = driver.findElement(FetchData
						.readOR("heading_Exam_page"));

				String layer = we.getText();
				String layer2 = CommonFunctions.StaticData(data.toLowerCase());

				if (layer.equalsIgnoreCase(layer2))
					CommonFunctions.pass(t, "Verification for " + cta
							+ " passed" + " Actual : " + layer2
							+ " Expected : " + layer);
				else
					CommonFunctions.fail(driver, t, "Verification for " + cta
							+ " failed" + " Actual : " + layer2
							+ " Expected : " + layer);

			}

		} catch (Exception e) {
			CommonFunctions.fail(driver, t, "Verification for " + cta
					+ " failed");
			throw e;
		}

	}

	public void verifyLayerApply(WebDriver driver, ExtentTest t, String cta,
			String data) {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("headings_cta_apply"));

			WebElement weee = driver.findElement(FetchData
					.readOR("headings_cta_apply"));

			String layer = weee.getText();

			String layer2 = CommonFunctions.StaticData(data.toLowerCase());

			if (layer.equalsIgnoreCase(layer2))
				CommonFunctions.pass(t, "Verification for " + cta + " passed"
						+ " Actual : " + layer2 + " Expected : " + layer);
			else
				CommonFunctions.fail(driver, t, "Verification for " + cta
						+ " failed" + " Actual : " + layer2 + " Expected : "
						+ layer);

		} catch (Exception e) {

			CommonFunctions.fail(driver, t, "Verification for " + cta
					+ " failed");
			throw e;
		}

	}

	public void verifyLayerCTA(WebDriver driver, ExtentTest t, String cta,
			String data) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("headings_cta"));

			WebElement weee = driver.findElement(FetchData
					.readOR("headings_cta"));

			String layer = weee.getText();

			String layer2 = CommonFunctions.StaticData(data.toLowerCase());

			if (layer.equalsIgnoreCase(layer2))
				CommonFunctions.pass(t, "Verification for " + cta + " passed"
						+ " Actual : " + layer2 + " Expected : " + layer);
			else
				CommonFunctions.fail(driver, t, "Verification for " + cta
						+ " failed" + " Actual : " + layer2 + " Expected : "
						+ layer);

		} catch (Exception e) {

			CommonFunctions.fail(driver, t, "Verification for " + cta
					+ " failed");
			throw e;
		}

	}

	public boolean verifyDownloadonCTA(WebDriver driver, ExtentTest t) {
		boolean flag = false;
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("downloadonCTA"));
			WebElement we = driver.findElement(FetchData
					.readOR("downloadonCTA"));
			if (we.getText().equalsIgnoreCase("request brochure")) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", we);
				Thread.sleep(5000);
				WebElement we1 = driver.findElement(FetchData
						.readOR("downloadonCTA"));
				if (we1.getText().contains("Brochure Mailed")) {
					flag = true;
					CommonFunctions.pass(t,
							"Verification for download CTA on reco layer"
									+ " passed");
				} else {
					CommonFunctions.fail(driver, t,
							"Verification for download CTA on reco layer"
									+ " failed");
				}
			}

			else {
				CommonFunctions.fail(driver, t,
						"Verification for download CTA on reco layer"
								+ " failed");
			}

		} catch (Exception e) {
			CommonFunctions.fail(driver, t,
					"Verification for download CTA on reco layer" + " failed");
			// throw e;
		}
		return flag;
	}

	public boolean verifycompareonCTA(WebDriver driver, ExtentTest t) {
		boolean flag = false;
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("compareonCTA"));
			List<WebElement> we = driver.findElements(FetchData
					.readOR("compareonCTA"));
			
			
			for (WebElement webElement : we) {
				System.out.println(webElement.getText());
				if (webElement.getText().equalsIgnoreCase("COMPARE")) {
					webElement.click();
					Thread.sleep(5000);
					if (webElement.getText().equalsIgnoreCase("ADDED")) {
						// flag = true;
						CommonFunctions.pass(t,
								"Verification for compare CTA on reco layer"
										+ " passed");
					}

					else {
						if (driver.findElement(
								FetchData.readOR("comparebtnonCTA"))
								.isDisplayed()) {
							driver.findElement(
									FetchData.readOR("comparebtnonCTA"))
									.click();

							break;
						} else {
							continue;
						}
					}
				}

			}

			Variables.elementWait(driver, 10,
					FetchData.readOR("headings_cta_compare"));

			WebElement we1 = driver.findElement(FetchData
					.readOR("headings_cta_compare"));

			String layer = we1.getText();
			String layer2 = CommonFunctions.StaticData("compare".toLowerCase());

			if (layer.equalsIgnoreCase(layer2)) {
				CommonFunctions.pass(t,
						"Verification for compare CTA on reco layer"
								+ " passed");
				flag = true;
			} else
				CommonFunctions.fail(driver, t,
						"Verification for compare CTA on reco layer"
								+ " failed");
		} catch (Exception e) {
			CommonFunctions.fail(driver, t,
					"Verification for download CTA on reco layer" + " failed");
			// throw e;
		}
		return flag;
	}

	public boolean verifyShortlistonCTA(WebDriver driver, ExtentTest t) {
		boolean flag = false;
		try {
			Variables
					.elementWait(driver, 10, FetchData.readOR("shotlistonCTA"));
			WebElement we = driver.findElement(FetchData
					.readOR("shotlistonCTA"));
			if (we.getText().equalsIgnoreCase("shortlist")) {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", we);
				WebElement we1 = driver.findElement(FetchData
						.readOR("shotlistonCTA"));
				Thread.sleep(5000);
				if (we1.getText().contains("Shortlisted")) {
					flag = true;
					CommonFunctions.pass(t,
							"Verification for Shortlist CTA on reco layer"
									+ " passed");
				}

				else {
					CommonFunctions.fail(driver, t,
							"Verification for Shortlist CTA on reco layer"
									+ " failed");
				}
			}

			else {
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", we);
				Thread.sleep(5000);
				if (we.getText().equalsIgnoreCase("shortlist")) {
					// JavascriptExecutor executor = (JavascriptExecutor)
					// driver;
					executor.executeScript("arguments[0].click();", we);
					Thread.sleep(5000);
					WebElement we1 = driver.findElement(FetchData
							.readOR("shotlistonCTA"));
					if (we1.getText().contains("Shortlisted")) {
						flag = true;
						CommonFunctions.pass(t,
								"Verification for Shortlist CTA on reco layer"
										+ " passed");
					}

					else {
						CommonFunctions.fail(driver, t,
								"Verification for Shortlist CTA on reco layer"
										+ " failed");
					}
				}
			}

		} catch (Exception e) {
			CommonFunctions.fail(driver, t,
					"Verification for Shortlist CTA on reco layer" + " failed");
			// throw e;
		}
		return flag;
	}

	public void EnableStickyCTA(WebDriver driver) {
		try {
			Variables.elementWait(driver, 50,
					FetchData.readOR("SwipeToStickyCTA"));
			WebElement we = driver.findElement(FetchData
					.readOR("SwipeToStickyCTA"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", we);

		} catch (Exception e) {

			throw e;
		}

	}

	public void ScrollCTA(WebDriver driver) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,500)", "");
		} catch (Exception e) {

			throw e;
		}

	}

	public void careerCta(WebDriver driver) {
		try {
			Variables
					.elementWait(
							driver,
							10,
							By.xpath("(.//*[@id='initial-colleges-list']//li//div)[1]"));
			driver.findElement(
					By.xpath("(.//*[@id='initial-colleges-list']//li//div)[1]"))
					.click();
		} catch (Exception e) {
			throw e;
		}

	}

}
