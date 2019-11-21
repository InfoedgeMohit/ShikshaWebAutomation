package com.shiksha.object;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class Call_Predictor {
	CommonFunctions CommonFunctions = new CommonFunctions();

	public Boolean Page1(WebDriver driver) {
		try {
			// // Select Category from Drop down
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Variables.elementWait(driver, 10,
					FetchData.readOR("call_catrgory_drop"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("call_catrgory_drop")));
			Variables.elementWait(driver, 10,
					FetchData.readOR("call_catrgory_general"));
			executor.executeScript("arguments[0].click();", driver
					.findElement(FetchData.readOR("call_catrgory_general")));
			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_Step_1_Button"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Step_1_Button")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean clickHere(WebDriver driver, String eligible, ExtentTest t) {
		boolean flag = false;
		System.out.println("f");
		try {
			// // Select Category from Drop down
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_Change_Here"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Change_Here")));
			Thread.sleep(5000);
			if (!eligible.equalsIgnoreCase("eligible")) {
				Page_CatScore(driver, "20", "20", "20", "20", "20");
				flag = CheckELigibility(driver, "", t, "CAT Score");
			} else {
				Page_CatScore(driver, "99", "99", "99", "99", "99");
				flag = CheckELigibility(driver, "eligible", t, "CAT Score");
			}
		} catch (Exception e) {
		}
		return flag;
	}

	public Boolean StartAgain(WebDriver driver, String Eligible, ExtentTest t) {
		Boolean flag = false;
		try {

			// // Select Category from Drop down
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_Start_Again"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Start_Again")));
			Thread.sleep(5000);
			Page1(driver);

			Page2(driver, "99", "99", "99");

			Page3(driver, "CAT SCORE");
			if (Eligible.equalsIgnoreCase("eligible")) {
				Page_CatScore(driver, "10", "10", "10", "10", "10");
				Variables.elementWait(driver, 10,
						FetchData.readOR("IIM_Click_Cut_Off"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("IIM_Click_Cut_Off")));
				flag = CheckELigibility(driver, "", t, "");
			} else {
				Page_CatScore(driver, "99", "99", "99", "99", "99");
				flag = CheckELigibility(driver, "eligible", t, "CAT Score");
			}
		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean banner(WebDriver driver) {
		Boolean flag = false;
		try {
			// // Select Category from Drop down
			Variables.elementWait(driver, 10, FetchData.readOR("IIM_Banner"));
			String text = driver.findElement(FetchData.readOR("IIM_Banner"))
					.getText();
			if (text.equalsIgnoreCase("Featured College")) {
				driver.switchTo().frame(0);
				if (driver.findElement(FetchData.readOR("IIM_Banner_Frame"))
						.isDisplayed()) {
					driver.switchTo().defaultContent();
					flag = true;

				}
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return flag;
	}

	public Boolean compare(WebDriver driver) {
		try {
			// // Select Category from Drop down
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			// Variables.elementWait(driver, 10,
			// FetchData.readOR("IIM_compare"));
			List<WebElement> we = driver.findElements(FetchData
					.readOR("IIM_compare"));
			for (WebElement webElement : we) {
				if (driver.findElement(FetchData.readOR("comparebtnonCTA"))
						.isDisplayed()) {
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("comparebtnonCTA")));
					break;
				}
				executor.executeScript("arguments[0].click();", webElement);
			}

			String text = driver.findElement(
					FetchData.readOR("headings_cta_compare")).getText();
			String layer2 = CommonFunctions.StaticData("Compare".toLowerCase());
			if (text.equalsIgnoreCase(layer2)) {
				driver.navigate().back();
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public Boolean CheckELigibility(WebDriver driver, String eligible,
			ExtentTest t, String eli) {
		Boolean flag = false;
		String text = "";
		try {
			if (eli.equalsIgnoreCase("CAT Score")) {
				if (eligible.equalsIgnoreCase("eligible")) {
					Variables.elementWait(driver, 10,
							FetchData.readOR("IIM_Eligible"));
					text = driver.findElement(FetchData.readOR("IIM_Eligible"))
							.getText();
					if (text.contains("You are Eligible for")
							&& text.contains("To know your chances (High or Low) of getting ")) {
						flag = true;
					}
				}

				else {
					Variables.elementWait(driver, 10,
							FetchData.readOR("IIM_Not_Eligible"));
					text = driver.findElement(
							FetchData.readOR("IIM_Not_Eligible")).getText();
					if (text.contains("You are not eligible for any of the IIMs")) {
						// flag = true;
						Variables.elementWait(driver, 10,
								FetchData.readOR("IIM_Click_Cut_Off"));
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						executor.executeScript("arguments[0].click();", driver
								.findElement(FetchData
										.readOR("IIM_Click_Cut_Off")));
						Variables.elementWait(driver, 10,
								FetchData.readOR("IIM_Eligible"));
						text = driver.findElement(
								FetchData.readOR("IIM_Eligible")).getText();
						if (text.contains("You are not Eligible for any IIMs")) {
							flag = true;
						}

					}
				}
			}

			else {
				if (eligible.equalsIgnoreCase("eligible")) {
					Variables.elementWait(driver, 10,
							FetchData.readOR("IIM_Eligible"));
					text = driver.findElement(FetchData.readOR("IIM_Eligible"))
							.getText();
					if (text.contains("Cut-off scores & eligibility are mentioned below. ")
							&& text.contains(" But to predict your IIM calls please fill your CAT score (actual or expected)")) {
						flag = true;
					}
				}

				else {
					Variables.elementWait(driver, 10,
							FetchData.readOR("IIM_Eligible"));
					text = driver.findElement(FetchData.readOR("IIM_Eligible"))
							.getText();
					if (text.contains("You are not Eligible for any IIMs. Eligibility are mentioned below.")) {
						flag = true;
					}
				}
			}

			CommonFunctions.info(t, "Actual : " + text);

		} catch (Exception e) {
			CommonFunctions.info(t, "Actual : " + text);
		}
		return flag;
	}

	public Boolean CheckELigibility_ForCAT(WebDriver driver, String eligible,
			ExtentTest t) {
		System.out.println("");
		Boolean flag = false;
		String text = "";
		try {
			if (eligible.equalsIgnoreCase("eligible")) {
				Variables.elementWait(driver, 10,
						FetchData.readOR("IIM_Eligible_Result"));
				text = driver.findElement(
						FetchData.readOR("IIM_Eligible_Result")).getText();
				if (text.contains("You are Eligible for ")
						&& text.contains("However, that does not ensure you a WAT/PI call.")) {
					flag = true;
				}
			}

			else {
				Variables.elementWait(driver, 10,
						FetchData.readOR("IIM_Not_Eligible"));
				text = driver.findElement(FetchData.readOR("IIM_Not_Eligible"))
						.getText();
				if (text.contains("We are Sorry! You are not eligible for any of the IIMs")) {
					flag = true;
				}
			}
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Click_Cut_Off")));
			CommonFunctions.info(t, "Actual : " + text);
		} catch (Exception e) {
			CommonFunctions.info(t, "Actual : " + text);
		}
		return flag;
	}

	public Boolean Page3(WebDriver driver, String category) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {

			// // Select Category from Drop down
			if (category.equalsIgnoreCase("CAT SCORE")) {
				Variables.elementWait(driver, 10,
						FetchData.readOR("IIM_CAT_Score"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("IIM_CAT_Score")));
			} else {
				Variables.elementWait(driver, 10,
						FetchData.readOR("IIM_Eligibility"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("IIM_Eligibility")));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean Page2(WebDriver driver, String marks_10, String marks_12,
			String marks_grad) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			// // 10th data
			Variables.elementWait(driver, 10, FetchData.readOR("IIM_10"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_10")));

			Variables.elementWait(driver, 10, FetchData.readOR("IIM_10_1"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_10_1")));

			Variables.elementWait(driver, 10, FetchData.readOR("IIM_10_2"));
			driver.findElement(FetchData.readOR("IIM_10_2")).clear();
			driver.findElement(FetchData.readOR("IIM_10_2")).sendKeys(marks_10);

			// // 12th data
			Variables.elementWait(driver, 10, FetchData.readOR("IIM_12_board"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_12_board")));

			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_12_board_2"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_12_board_2")));

			Variables
					.elementWait(driver, 10, FetchData.readOR("IIM_12_Stream"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_12_Stream")));

			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_12_Stream_2"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_12_Stream_2")));

			Variables.elementWait(driver, 10, FetchData.readOR("IIM_12_Marks"));
			driver.findElement(FetchData.readOR("IIM_12_Marks")).clear();
			driver.findElement(FetchData.readOR("IIM_12_Marks")).sendKeys(
					marks_12);

			// // Grad data
			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_Post_board"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Post_board")));

			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_Post_board_2"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Post_board_2")));

			Variables
					.elementWait(driver, 10, FetchData.readOR("IIM_Post_Year"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Post_Year")));

			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_Post_Year_2"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Post_Year_2")));

			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_Post_Marks"));
			driver.findElement(FetchData.readOR("IIM_Post_Marks")).clear();
			driver.findElement(FetchData.readOR("IIM_Post_Marks")).sendKeys(
					marks_grad);

			// // Submit button
			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_Step_2_Button"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_Step_2_Button")));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Boolean Page_CatScore(WebDriver driver, String vrc, String DIRL,
			String QA, String Tot, String toal) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("IIM_VRC"));
			driver.findElement(FetchData.readOR("IIM_VRC")).clear();
			driver.findElement(FetchData.readOR("IIM_VRC")).sendKeys(vrc);

			Variables.elementWait(driver, 10, FetchData.readOR("IIM_DILR"));
			driver.findElement(FetchData.readOR("IIM_DILR")).clear();
			driver.findElement(FetchData.readOR("IIM_DILR")).sendKeys(DIRL);

			Variables.elementWait(driver, 10, FetchData.readOR("IIM_QA"));
			driver.findElement(FetchData.readOR("IIM_QA")).clear();
			driver.findElement(FetchData.readOR("IIM_QA")).sendKeys(QA);

			Variables.elementWait(driver, 10, FetchData.readOR("IIM_TOT"));
			driver.findElement(FetchData.readOR("IIM_TOT")).clear();
			driver.findElement(FetchData.readOR("IIM_TOT")).sendKeys(Tot);

			Variables.elementWait(driver, 10, FetchData.readOR("IIM_TOTAL"));
			driver.findElement(FetchData.readOR("IIM_TOTAL")).clear();
			driver.findElement(FetchData.readOR("IIM_TOTAL")).sendKeys(toal);

			Variables.elementWait(driver, 10,
					FetchData.readOR("IIM_CAT_Predict"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("IIM_CAT_Predict")));

			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
