package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class PWA {
	WebDriver driver;
	ExtentTest child1;
	List<Object> child = new ArrayList<Object>();
	
	public PWA(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child1 = child;

		this.child.add(this.driver);
		this.child.add(this.child1);
	}

	CommonFunctions CommonFunctions = new CommonFunctions();

	public boolean CheckTopSection() {
		boolean flag = false;
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("TopSection"));
			flag = driver.findElement(FetchData.readOR("TopSection"))
					.isDisplayed();
			CommonFunctions.info(child,
					"\nTop Section Found : Verification Started");
			flag = true;
		} catch (Exception e) {
			CommonFunctions.info(child, "\nTop Section not Found");
		}
		return flag;
	}

	public void VerifyInstituteName(String instituteName, String id) {
		try {

			String name = driver.findElement(FetchData.readOR("instituteName"))
					.getText();
			if (name.equals(instituteName)
					&& driver.findElement(FetchData.readOR("instituteName"))
							.getAttribute("href").contains(id))
				CommonFunctions.pass(child, "institute name " + instituteName
						+ " verification passed" + "\nActual : "
						+ instituteName + "\nExpected : " + name);
			else
				CommonFunctions.fail(child, "institute name " + instituteName
						+ " verification failed" + "\nActual : "
						+ instituteName + "\nExpected : " + name);
		} catch (Exception e) {
			CommonFunctions.error(child, "institute name " + instituteName
					+ " verification failed" + "\nActual : " + instituteName
					+ "\nExpected : Throws exception" + e.toString());
		}
	}

	public void VerifyAllML(int dbCount, String name, String CityId,
			String LocId, String isMain) {
		Boolean flag = false;
		try {
			try {
				driver.findElement(FetchData.readOR("clickChangeBranch"))
						.click();
			} catch (Exception e) {

			}
			// // Expand ALL Localities if Exist
			List<WebElement> weLocalities = driver.findElements(FetchData
					.readOR("expandAllML"));
			for (WebElement webElement : weLocalities) {
				webElement.click();
			}

			List<WebElement> weLocations = driver.findElements(FetchData
					.readOR("getALLML"));
			if (dbCount == weLocations.size()) {
				for (WebElement webElement : weLocations) {
					String MLName = webElement.getText();
					String MLURL = webElement.getAttribute("href");
					if (isMain.equals("1")) {
						if (MLName.contains(name)) {
							flag = true;
							break;
						}
					}

					else {
						if (LocId.length() > 1) {
							if (MLName.contains(name) && MLURL.contains(LocId)
									&& MLURL.contains(CityId)) {
								flag = true;
								break;
							}

						} else if (MLName.contains(name)
								&& MLURL.contains(CityId)) {
							flag = true;
							break;
						}
					}
				}

			}

			else {
				CommonFunctions.fail(child,
						"Multi Location Count not Matched, Please verify");
			}
			if (flag)
				CommonFunctions.pass(child, "ML NAME" + name + " Locality id: "
						+ LocId + " city id: " + CityId
						+ " verification Passed");
			else
				CommonFunctions.fail(child, "ML NAME" + name + " Locality id: "
						+ LocId + " city id: " + CityId
						+ " verification failed");
		} catch (Exception e) {
			CommonFunctions.error(child, "Verify All ML failed");
		} finally {
			LayerClose();
		}
	}

	public void VerifyDateForTopSection() {
		try {
			String topSectionDate = driver.findElement(
					FetchData.readOR("topsectiondate")).getText();
			String topSectionDateText = driver.findElement(
					FetchData.readOR("topsectiondatetext")).getText();
			String belowSectionDateText = driver.findElement(
					FetchData.readOR("topimpdates_Expectedtext")).getText();
			String belowSectionDate = driver.findElement(
					FetchData.readOR("topimpdates_ExpectedDates")).getText();

			if (topSectionDate.contains(belowSectionDate)
					&& topSectionDateText
							.equalsIgnoreCase(belowSectionDateText))
				CommonFunctions.pass(child,
						"Top Section Date verification passed"
								+ "\nExpected : " + belowSectionDate + ","
								+ belowSectionDateText + "\nActual : "
								+ topSectionDate + "," + topSectionDateText);
			else
				CommonFunctions.fail(child,
						"Top Section Date verification failed"
								+ "\nExpected : " + belowSectionDate + ","
								+ belowSectionDateText + "\nActual : "
								+ topSectionDate + "," + topSectionDateText);
		} catch (ElementNotFoundException e) {
			CommonFunctions.fail(child, "Top Section Date verification failed");
		}

		catch (Exception e) {
			CommonFunctions.info(child, "Top Section Date verification failed");
		}
	}

	public void VerifyAffiliatedTo(String name, String id, String scope,
			String univurl, String listing_type) {
		String name1 = "";
		try {
			Boolean flag = false;
			name1 = driver.findElement(FetchData.readOR("AffiliatedTo"))
					.getText();
			String url = "";
			if (listing_type.equalsIgnoreCase("university_national")) {
				url = driver.findElement(FetchData.readOR("AffiliatedTo"))
						.getAttribute("href");
				if (url.contains(univurl) && scope.equalsIgnoreCase("domestic")
						&& url.contains(id))
					flag = true;
			}

			else if (listing_type.equalsIgnoreCase("university")) {
				url = driver.findElement(FetchData.readOR("AffiliatedTo"))
						.getAttribute("href");
				if (url.contains(univurl) && scope.equalsIgnoreCase("abroad"))
					flag = true;
			} else if (id.equalsIgnoreCase("")
					&& listing_type.equalsIgnoreCase("")) {
				name = "Affiliated to " + name;
				flag = true;
			}
			if (name1.equals(name) && flag == true)
				CommonFunctions.pass(child,
						"Verification of Affilited university Passed "
								+ "\nExpected : " + name + "\nActual : "
								+ name1);
			else
				CommonFunctions.fail(child,
						"Verification of Affilited university failed "
								+ "\nExpected : " + name + "\nActual : "
								+ name1);
		} catch (Exception e) {
			CommonFunctions.error(child,
					"Verification of Affilited university failed "
							+ "\nExpected : " + name + "\nActual : " + name1);
		}
	}

	public void VerifyFeesAndLevel(String feeLevel) {
		boolean flag = false;
		try {
			String text = "";
			List<WebElement> we = driver.findElements(FetchData
					.readOR("courseDetails"));
			for (WebElement ww : we) {
				text = ww.getText();

				if (text.contains(feeLevel)) {
					flag = true;
					break;
				}
			}
			if (flag)
				CommonFunctions.pass(child, "Fees or level  " + feeLevel
						+ "verification passed" + "\nExpected : " + feeLevel
						+ "\nActual : " + text);
			else
				CommonFunctions.fail(child, "Fees or level  " + feeLevel
						+ "verification failed" + "\nExpected : " + feeLevel
						+ "\nActual : " + text);
		} catch (Exception e) {
			CommonFunctions.error(child, "Fees or level  " + feeLevel
					+ "verification throws exception " + e.toString()
					+ "\nExpected : " + feeLevel);
		}
	}

	public void VerifyFeesDisclamar(String fee, String feeLevel) {
		boolean flag = false;
		try {
			List<WebElement> we = driver.findElements(FetchData
					.readOR("iconLayer"));
			for (WebElement w : we) {
				w.click();
				if (driver.findElement(FetchData.readOR("durationTextMatch"))
						.getText().equals(feeLevel)) {
					flag = true;
					LayerClose();
					break;
				}
				LayerClose();
			}
			if (flag)
				CommonFunctions.pass(child, "Fees disclamar"
						+ "verification passed");
			else
				CommonFunctions.fail(child, "Fees disclamar"
						+ "verification failed");
		} catch (Exception e) {
			CommonFunctions.error(child, "Fees disclamar verification failed");
		}

	}

	public void LayerClose() {
		try {
			driver.findElement(FetchData.readOR("layerclose_pwa")).click();
			// CommonFunctions.info(child, "LayerClose passed");
		} catch (Exception e) {
			// CommonFunctions.info(child, "LayerClose failed");
		}
	}

	public int VerifyData(String name) {
		boolean flag = false;
		int i = 1;
		try {
			List<WebElement> we = driver.findElements(FetchData
					.readOR("courseDetails"));
			for (WebElement ww : we) {
				String text = ww.getText();
				String REGEX = "^[A-Za-z]{3}\\s[0-9]*$";
				String REGEX2 = "^[A-Za-z]{3}\\s[0-9]*\\s[A-Za-z]*$";
				Pattern p = Pattern.compile(REGEX);
				Pattern p2 = Pattern.compile(REGEX2);
				Matcher m = p.matcher(text);
				Matcher m2 = p2.matcher(text);
				if (m.matches() || m2.matches()) {
					i--;
				}
				if (text.contains(name)) {
					flag = true;
					break;
				}
				i++;
			}
			if (flag)
				CommonFunctions.pass(child, "Data " + name
						+ "verification passed");
			else
				CommonFunctions.fail(child, "Data " + name
						+ "verification failed");
		} catch (Exception e) {
			CommonFunctions
					.error(child, "Data " + name + "verification failed");
		}
		return i;
	}

	public void VerifyDataLayer(int count, String name, int row,
			String section, int datarow1) {
		try {
			int rownum = 1;

			List<WebElement> we = null;
			if (count == 1 && !section.equalsIgnoreCase("medium")) {
				we = driver.findElements(FetchData.readOR("iconLayer"));
			} else {
				we = driver.findElements(FetchData.readOR("moreLayer"));
			}
			for (WebElement ww : we) {
				if (row == rownum) {
					ww.click();
					// // Verify Heading
					List<WebElement> we1 = driver.findElements(FetchData
							.readOR("dataOnLayerHeading"));
					int dataRow = 1;
					for (WebElement ww1 : we1) {
						if (dataRow == datarow1) {
							if (ww1.getText().contains(name)) {
								CommonFunctions.pass(child, "data heading: "
										+ name + " for section : " + section
										+ " verification passed");
								// // Verify Inner Data
								if (section.equals("recognition")
										|| section
												.equalsIgnoreCase("accreditation")) {
									// // Inner Data to be verified

									List<WebElement> we22 = driver
											.findElements(FetchData
													.readOR("dataOnLayer"));
									int roes = 1;
									for (WebElement ww21 : we22) {
										if (roes == datarow1) {
											String innerData = ww21.getText();
											String data = CommonFunctions
													.StaticData(name);
											if (innerData.contains(data)) {
												CommonFunctions
														.pass(child,
																"data heading: "
																		+ name
																		+ " for section : "
																		+ section
																		+ "Expected data : "
																		+ data
																		+ " verification passed");
											} else {
												CommonFunctions
														.fail(child,
																"data heading: "
																		+ name
																		+ " for section : "
																		+ section
																		+ "Expected data : "
																		+ data
																		+ " verification failed");
											}
											break;
										}
										roes++;
									}
								}
							} else {
								CommonFunctions.fail(child, "data heading: "
										+ name + " for section : " + section
										+ " verification failed");
							}
							break;
						}
						dataRow++;
					}
					break;
				}

				rownum++;
			}

		} catch (Exception e) {
			CommonFunctions.error(child, "data  " + name + " for section : "
					+ section + " verification failed");
		}
	}

	public void VerifyCourseName(String courseName) {
		try {
			String name = driver.findElement(FetchData.readOR("PWAcourseName"))
					.getText();
			if (name.equals(courseName))
				CommonFunctions.pass(child, "course name : " + courseName
						+ " verification passed" + "\nActual : " + courseName
						+ "\nExpected : " + name);
			else
				CommonFunctions.fail(child, "course name : " + courseName
						+ " verification failed" + "\nActual : " + courseName
						+ "\nExpected : " + name);
		} catch (Exception e) {
			CommonFunctions.error(child, "course name : " + courseName
					+ " verification passed" + "\nActual : " + courseName
					+ "\nExpected : throws exception" + e.toString());
		}
	}

	public void VerifyCaption(String caption, String verify) {
		boolean flag = false;
		try {
			String text = "";
			List<WebElement> we = driver.findElements(FetchData
					.readOR("coursecaption"));
			for (WebElement ww : we) {
				text = ww.getText();
				if (caption.contains(text)) {
					flag = true;
					break;
				}
			}
			if (flag)
				CommonFunctions.pass(child, "Verify : " + verify + "Passed"
						+ "\nExpected : " + caption + "\nActual : " + text);

			else if (caption.contains("certificate"))
				CommonFunctions.pass(child, "Verify : " + verify + "Passed"
						+ "\nExpected : " + caption + "\nActual : " + text);

			else
				CommonFunctions.fail(child, "Verify : " + verify + "failed"
						+ "\nExpected : " + caption + "\nActual : " + text);
		} catch (Exception e) {
			CommonFunctions.error(child, "Verify : " + verify + "Passed"
					+ "\nExpected : " + caption + "\nActual : throws exception"
					+ e.toString());
		}
	}

	public void VerifyDurationDisclamar(String name) {
		try {
			driver.findElement(FetchData.readOR("durationDisclamarSign"))
					.click();
			String text = driver.findElement(
					FetchData.readOR("durationTextMatch")).getText();
			if (text.equals(name)) {
				CommonFunctions.pass(child, "Duration disclamar passed"
						+ "\nExpected :" + name + "\nActual : " + text);

			} else
				CommonFunctions.fail(child, "Duration disclamar failed"
						+ "\nExpected :" + name + "\nActual : " + text);
		} catch (Exception e) {
			CommonFunctions.error(child,
					"Duration disclamar throws exception : " + e.toString()
							+ "\nExpected :" + name);
		} finally {
			LayerClose();
		}
	}

	public boolean CheckCourseStructure() {
		boolean flag = false;
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("courseStructureSection"));
			flag = driver.findElement(
					FetchData.readOR("courseStructureSection")).isDisplayed();
			CommonFunctions.info(child, "\ncourseStructureSection Found");
			flag = true;
		} catch (Exception e) {
			CommonFunctions.info(child, "\ncourseStructureSection not Found");
		}
		return flag;
	}

	public boolean CheckViewAllCourseButton() {
		boolean flag = false;
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver
							.findElement(FetchData
									.readOR("courseStructureViewAllButton")));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
			driver.findElement(FetchData.readOR("courseStructureViewAllButton"))
					.click();
			CommonFunctions.info(child,
					"\nView All Course Structure Found and clicked");
			flag = true;
		} catch (Exception e) {
			CommonFunctions
					.info(child, "\nView All Course Structure not Found");
		}
		return flag;
	}

	public void VerifyCoursesOnLayer(ArrayList<String> courses) {
		try {
			List<WebElement> we = driver.findElements(FetchData
					.readOR("allCourseOnLayer"));
			ArrayList<String> mainPage = new ArrayList<String>();

			for (WebElement webElement : we) {
				mainPage.add(webElement.getText());

			}
			if (mainPage.equals(courses))
				CommonFunctions.pass(child,
						"\nCourses on all Course Structure layer matched");
			else
				CommonFunctions.fail(child,
						"\nCourses on all Course Structure layer not matched");

		} catch (Exception e) {
			CommonFunctions.error(child,
					"\nCourses on all Course Structure layer not matched");
		} finally {
			LayerClose();
		}
	}

	public void VerifyCoursesOnPage(ArrayList<String> courses) {
		try {
			List<WebElement> we = driver.findElements(FetchData
					.readOR("allCourseOnPage"));
			ArrayList<String> mainPage = new ArrayList<String>();
			for (WebElement webElement : we) {
				mainPage.add(webElement.getText());
			}
			if (courses.containsAll(mainPage))
				CommonFunctions.pass(child,
						"\nCourses on all Course Structure layer matched");
			else
				CommonFunctions.fail(child,
						"\nCourses on all Course Structure layer not matched");

		} catch (Exception e) {
			CommonFunctions.error(child,
					"\nCourse8s on all Course Structure layer not matched");
		}
	}

	public void VerifyHeadingsOnLayer(String period) {
		int count = 0;
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("layerclose_pwa"));
			List<WebElement> we = driver.findElements(FetchData
					.readOR("allHeadingOnLayer"));
			for (WebElement webElement : we) {
				if (webElement.getText().toLowerCase().contains(period)) {
					count++;
				}
			}
			if (count == we.size()) {
				CommonFunctions.pass(child,
						"\nHeading on all Course Structure layer matched"
								+ "\nExpected : " + period);
			} else {
				CommonFunctions.fail(child,
						"\nHeading on all Course Structure layer not matched"
								+ "\nExpected : " + period);
			}
		} catch (Exception e) {
			CommonFunctions.error(child,
					"\nHeading on all Course Structure layer not matched"
							+ "\nExpected : " + period);
		}

	}

	public void CheckCourseHeading(String period) {
		try {
			String text = driver.findElement(
					FetchData.readOR("courseStructureHeading")).getText();
			if (text.contains(period))
				CommonFunctions.pass(child, "\nStructure Heading " + period
						+ " Found" + "\nExpected : " + period + "\nActual : "
						+ text);

		} catch (Exception e) {
			if (period.equalsIgnoreCase("program"))
				CommonFunctions.pass(child, "\nStructure Heading " + period
						+ " Found" + "\nExpected : " + period
						+ " So No heading would exist");

			else
				CommonFunctions.fail(child, "\nStructure Heading " + period
						+ " Found" + "\nExpected : " + period
						+ " throws exception " + e.toString());
		}

	}

}
