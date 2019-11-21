package com.shiksha.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;

public class Navigation_Desktop {

	CommonFunctions cmn_fncts = new CommonFunctions();
	WebDriver driver;
	GenericFunction per;

	public Navigation_Desktop(WebDriver driver) {
		this.driver = driver;
		per = new GenericFunction(driver);
	}

	public void click_L1(String txt) {
		try {
			String xpath = cmn_fncts.DynamicXpath("category_Dsktp_L1", txt);
			System.out.println(xpath);
			WebElement we = driver.findElement(By.xpath(xpath));
			System.out.println(we.getText());
			cmn_fncts.scrollTo(driver, we);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-50)");
			Thread.sleep(2000);
			we.click();

			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String click_L2(String txt, int l) {
		String ret = "";
		try {
			String xpath = cmn_fncts.DynamicXpath("category_Dsktp_L2", txt) + "[" + l + "]";
			if (!per.isAvailable(xpath)) {

				driver.findElement(FetchData.readOR("nextpage")).click();
				Thread.sleep(1000);
			}
			driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(1000);
			ret = driver.getCurrentUrl();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ret;
	}

	public int Count_Of_Articles() {
		int a = 0;
		try {

			List<WebElement> we = driver.findElements(FetchData.readOR("National_Homepage_Articles"));
			a = we.size();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public String scroll_click_Articles(int i,ExtentTest child) {
		String article = "";
		try {

			cmn_fncts.scrollTo(driver, driver.findElement(FetchData.readOR("View_All_Articles")));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-350)");
			Thread.sleep(1000);
			WebElement we = driver.findElement(FetchData.readOR("National_Homepage_Articles"));
			String xpath = cmn_fncts.createXpath(we);
			xpath = xpath + "[" + (i + 1) + "]";
			System.out.println(xpath);
			we = driver.findElement(By.xpath(xpath));
			while (!per.isAvailable(xpath)) {
				try {
					driver.findElement(FetchData.readOR("Rght_arow1")).click();
					Thread.sleep(2000);
				per.childPass(child, "Clicked on Right Arrow");
				}catch(Exception e) {
					per.childFail(child, "Fail to click on Right Arrow");
					e.printStackTrace();
				}
				
			}

			article = we.getText();
			if (article.contains("...")) {
				article = article.substring(0, article.length() - 4);
			}
			System.out.println(article);
			try {
			we.click();
			per.childPass(child, "Clicked on Article : "+article);
			}catch (Exception e) {
				per.childFail(child, "Fail to click on : "+article);
				e.printStackTrace();
			}
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();

		}
		return article;
	}

	public String Article_Page_Heading(ExtentTest child) {
		String article = "";
		try {

			System.out.println(FetchData.readOR("Heading_Article_Page"));
			article = driver.findElement(FetchData.readOR("Heading_Article_Page")).getText();
			per.childInfo(child, "Heading Article page : "+article);
			System.out.println(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return article;
	}

	public String view_All_Article(ExtentTest child) {
		String curl = "";
		try {
			cmn_fncts.scrollTo(driver, driver.findElement(FetchData.readOR("View_All_Articles")));
			Thread.sleep(1000);
			try {
			driver.findElement(FetchData.readOR("View_All_Articles")).click();
			Thread.sleep(1000);
			per.childPass(child, "Successfully clicked on View All Articles Button");
			}catch(Exception e) {
				per.childFail(child, "Fail to click on View All Articles Button");
				e.printStackTrace();
			}
			
			curl = driver.getCurrentUrl();
			curl = per.toRelativeURL(curl);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return curl;
	}

	public int count_Of_Featured_Colleges() {
		int a = 0;
		try {

			List<WebElement> we = driver.findElements(FetchData.readOR("Homepage_Featured_Colleges"));
			a = we.size();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public String click_Featured_Colleges(int i,ExtentTest child) {
		String txt = "";
		try {

			cmn_fncts.scrollTo(driver, driver.findElement(FetchData.readOR("View_All_Articles")));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-1500)");
			Thread.sleep(1000);
			WebElement we = driver.findElement(FetchData.readOR("Homepage_Featured_Colleges"));
			String xpath = cmn_fncts.createXpath(we);
			xpath = xpath + "[" + (i + 1) + "]";
			System.out.println(xpath);
			we = driver.findElement(By.xpath(xpath));
			try {
			we.click();
			per.childPass(child, "Successfully clicked on Featured College : "+(i+1));
			}catch(Exception e) {
				per.childFail(child, "Fail to click on Featured College : "+(i+1));
				e.printStackTrace();
			}
		
			Thread.sleep(2000);
			String temp = we.getAttribute("target");
			//we.click();
			// Thread.sleep(2000);
			if (temp.equalsIgnoreCase("_blank")) {
				String currentHandel = driver.getWindowHandle();
				for (String s : driver.getWindowHandles()) {
					if (!s.equalsIgnoreCase(currentHandel)) {
						driver.switchTo().window(s);
						Thread.sleep(2000);
						txt = driver.findElement(FetchData.readOR("Validation_Text_Featured_Colleges")).getText();
						per.childInfo(child, "Featured College Heading : "+txt);
						driver.close();
						driver.switchTo().window(currentHandel);
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return txt;
	}

	
	public int No_Of_Social_Links() {
		int a = 0;
		try {

			List<WebElement> we = driver.findElements(FetchData.readOR("Social_Links_Fb_Tw_G+"));
			a = we.size();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public String click_Social_Links_Fb_Tw_G(int i,ExtentTest child) {
		String curl = "";
		try {

			cmn_fncts.scrollTo(driver, driver.findElement(FetchData.readOR("View_All_Articles")));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,700)");
			Thread.sleep(1000);
			WebElement we = driver.findElement(FetchData.readOR("Social_Links_Fb_Tw_G+"));
			String xpath = cmn_fncts.createXpath(we);
			xpath = xpath + "[" + (i + 1) + "]";
			System.out.println(xpath);
			we = driver.findElement(By.xpath(xpath));
			try {
			we.click();
			per.childPass(child, "Successfully clicked on Social Link : "+(i+1));
			}catch(Exception e) {
				per.childFail(child, "Fail to click on Spcial Link : "+(i+1));
				e.printStackTrace();
			}
			Thread.sleep(2000);
			curl = driver.getCurrentUrl();
			per.childInfo(child, curl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return curl;
	}

	public int No_Of_Careers_After_12th() {
		int a = 0;
		try {
			List<WebElement> we = driver.findElements(FetchData.readOR("Careers_After_12th"));
			a = we.size();
			per.scrollVerticalTo(-4000);
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}

	public void ScrollTo_CareersAfter12th() {
		try {
			cmn_fncts.scrollTo(driver, driver.findElement(FetchData.readOR("View_All_Articles")));
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-850)");
			Thread.sleep(1000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String click_Careers_After_12th(int i,ExtentTest child) {
		String Career_Stream_Homepage = "";
		try {
			WebElement we = driver.findElement(FetchData.readOR("Careers_After_12th"));
			String xpath = cmn_fncts.createXpath(we);
			xpath = xpath + "[" + (i + 1) + "]";
			System.out.println(xpath);
			we = driver.findElement(By.xpath(xpath));
			Career_Stream_Homepage = we.getText();
			try {
			we.click();
			per.childPass(child, "Successfully clicked on Career after 12th : "+(i+1));
			}catch(Exception e) {
				per.childFail(child, "Fail to click on Career after 12th : "+(i+1));
				e.printStackTrace();
			}
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return Career_Stream_Homepage;
	}

	public String Validation_Career_Text() {
		String Career_Stream_Nextpage = "";
		try {
			Career_Stream_Nextpage = driver.findElement(FetchData.readOR("Career_Stream_Nxt_Page")).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Career_Stream_Nextpage;
	}
}