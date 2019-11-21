package com.shiksha.object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;

public class SA_GNB_Footer {
	WebDriver driver;
	GenericFunction per;
	public SA_GNB_Footer(WebDriver driver)
	{
		this.driver=driver;
		per=new GenericFunction(driver);
	}
	CommonFunctions CommonFunctions=new CommonFunctions();
	public String click_SA_Footer(String txt, com.aventstack.extentreports.ExtentTest child) {
		String url = "";
		try {

			String xpath = CommonFunctions.DynamicXpath("SA_Footer_Links", txt);
			System.out.println(xpath);
			WebElement we = per.findElementByXpath(xpath);

			per.scroll_To_Footer(we);
			Thread.sleep(3000);
			we.click();
			Thread.sleep(2000);
			url = driver.getCurrentUrl();
			per.childPass(child, "click on " + txt);

		} catch (Exception e) {
			e.printStackTrace();
			per.childFail(child, "fail to click on " + txt);
		}
		return url;

	}

	public void click_Mobile_Lvl1_Footer(String txt, com.aventstack.extentreports.ExtentTest child) {
		try {
			String xpath = CommonFunctions.DynamicXpath("Mobile_Footer_Lvl1", txt);
			WebElement we = per.findElementByXpath(xpath);

			per.scroll_To_Footer(we);
			Thread.sleep(2000);

			per.findElementByXpath(xpath).click();
			Thread.sleep(1000);
			per.childPass(child, "click on " + txt);

		} catch (Exception e) {
			e.printStackTrace();
			per.childFail(child, "fail to click on " + txt);
		}
	}

	public String click_SA_Footer_Mobile(String txt, com.aventstack.extentreports.ExtentTest child) {
		String url = "";
		try {

			String xpath = CommonFunctions.DynamicXpath("SA_Footer_Links", txt);
			System.out.println(xpath);
			WebElement we = per.findElementByXpath(xpath);

			we.click();
			Thread.sleep(2000);
			url = driver.getCurrentUrl();
			Thread.sleep(3000);
			per.childPass(child, "click on " + txt);

		} catch (Exception e) {
			e.printStackTrace();
			per.childFail(child, "fail to click on " + txt);
		}
		return url;

	}

	public void click_Logo() {
		try {
			WebElement we2 = driver.findElement(FetchData.readOR("SA_Logo"));
			we2.click();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean is_contactus_Footer_Available(String txt) {

		String xpath = CommonFunctions.DynamicXpath("contact_Us_Footer", txt);
		try {
			per.scroll_To_Footer(per.findElementByXpath(xpath));
			Thread.sleep(1500);
			if (per.isAvailable(xpath))
				return true;
			else
				return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void click_Enterprise_Login(String txt, com.aventstack.extentreports.ExtentTest child) {
		try {
			String xpath = CommonFunctions.DynamicXpath("Enterprise_Login", txt);

			if (per.isAvailable(xpath)) {
				per.scroll_To_Footer(per.findElementByXpath(xpath));
				Thread.sleep(1000);
				per.findElementByXpath(xpath).click();
				Thread.sleep(1000);
				per.childPass(child, "clicked on: " + txt);
			}
		} catch (Exception e) {
			e.printStackTrace();
			per.childFail(child, "fail to click on: " + txt);
		}
	}

	public void click_Contact_Us_Mobile(String txt, String tx, com.aventstack.extentreports.ExtentTest child) {
		try {
			String xpath = CommonFunctions.DynamicXpath("contact_Us_Footer", txt);
			per.scroll_To_Footer(per.findElementByXpath(xpath));
			Thread.sleep(2000);
			per.findElementByXpath(xpath).click();
			Thread.sleep(1000);
			per.childPass(child, "clicked on: " + txt);
			String path = CommonFunctions.DynamicXpath("contact_Us_Footer", txt);
			if (per.isAvailable(path)) {
				System.out.println(txt + "info is available: " + tx);
				per.childPass(child, txt + "info is available: " + tx);
			}

		} catch (Exception e) {
			e.printStackTrace();
			per.childFail(child, "Fail to click on: " + txt);
			per.childFail(child, txt + "info is not avaiable: " + tx);
		}

	}

	public void hover_Lvl1_GNB(String txt, com.aventstack.extentreports.ExtentTest child) {
		try {
			String xpath = CommonFunctions.DynamicXpath("Gnb_Lvl1", txt);
			WebElement we = per.findElementByXpath(xpath);
			System.out.println(xpath);
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			action.moveToElement(we).build().perform();
			Thread.sleep(1500);
			System.out.println("hover done " +txt);
			per.childPass(child, "Hover successful on " + txt);
		} catch (Exception e) {
			System.out.println("Fail to Hover  "+txt);
			per.childFail(child, "Failed to hover " + txt);
			e.printStackTrace();
		}
	}

	public String get_Link(String txt, int l, com.aventstack.extentreports.ExtentTest child) {
		String xpath = CommonFunctions.DynamicXpath("Gnb_Lvl3_optional", txt) + "["+l+"]";
		
		String ret = "";
		try {
			Thread.sleep(2000);
			if (per.isAvailable(xpath)) {
				System.out.println(xpath);
				ret = per.findElementByXpath(xpath).getAttribute("href");
				}
			else {
				Thread.sleep(2000);
				xpath = CommonFunctions.DynamicXpath("Gnb_Lvl3", txt) + "["+l+"]";
				System.out.println(xpath);
				ret = per.findElementByXpath(xpath).getAttribute("href");
			
			}
			Thread.sleep(500);
			per.childPass(child, "Url captured successfully");
		} catch (Exception e) {
			System.out.println("failed here "+txt);
			per.childFail(child, "failed to capture url");
			e.printStackTrace();
		}
		return ret;

	}

	public void click_Hamburger_SA() {
		try {
			driver.findElement(FetchData.readOR("hamburger_GNB_SA")).click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void click_Lvl1_GNB(String txt, String lvl2, String prev_L1, int l, com.aventstack.extentreports.ExtentTest child) {
		try {

			String xpath = CommonFunctions.DynamicXpath("Gnb_Lvl1", txt);
			String lvl2_xpath = CommonFunctions.DynamicXpath("Gnb_Lvl2", lvl2);
			if (!per.isAvailable(lvl2_xpath) || !prev_L1.equalsIgnoreCase(txt)) {
				per.findElementByXpath(xpath).click();
				Thread.sleep(1000);
			}
			per.childPass(child, "Clicked on :" + txt);
		} catch (Exception e) {
			per.childFail(child, "Fail to click on : " + txt);
			e.printStackTrace();
		}

	}

	public void click_Lvl2_GNB(String txt, String lvl3, int l, com.aventstack.extentreports.ExtentTest child) {
		try {

			String xpath = CommonFunctions.DynamicXpath("Gnb_Lvl2", txt);
			String lvl3_xpath = CommonFunctions.DynamicXpath("Gnb_Lvl3_Mobile", lvl3) + "[" + l + "]";
			if (!per.isAvailable(lvl3_xpath)) {
				per.findElementByXpath(xpath).click();
				Thread.sleep(1000);
			}
			per.childPass(child, "Clicked on :" + txt);
		} catch (Exception e) {
			per.childFail(child, "Fail to click on : " + txt);
			e.printStackTrace();
		}

	}

	public String get_GNB_Url(String txt, int l, com.aventstack.extentreports.ExtentTest child) {
		String link = "";
		try {
			Thread.sleep(500);
			String xpath = CommonFunctions.DynamicXpath("Gnb_Lvl3_Mobile_optional]", txt) + "[" + l + "]";

			if (per.isAvailable(xpath)) {
				System.out.println(xpath);
				link = per.findElementByXpath(xpath).getAttribute("href");
			} else {
				xpath = CommonFunctions.DynamicXpath("Gnb_Lvl3_Mobile", txt) + "[" + l + "]";
				link = per.findElementByXpath(xpath).getAttribute("href");
			}
			per.childPass(child, "Url captured successfully");
		} catch (Exception e) {
			per.childFail(child, "failed to capture url");
			e.printStackTrace();
		}
		return link;
	}
}
