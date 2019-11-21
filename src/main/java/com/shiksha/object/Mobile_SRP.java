package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.Variables;

public class Mobile_SRP {

	WebDriver driver;
	//CommonFunctions per = new CommonFunctions();
	GenericFunction per;
	private int select = 1;

	public Mobile_SRP(WebDriver driver) {
		this.driver = driver;
		per = new GenericFunction(driver);
	}

	public void click_Filter_Link() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Mobile_Filter_Link"));
			driver.findElement(FetchData.readOR("Mobile_Filter_Link")).click();
		} catch (Exception e) {
			throw e;
		}
	}

	public List<String> getFilterTabs() {
		List<String> a = new ArrayList<String>();
		Variables.elementWait(driver, 5, FetchData.readOR("Mobile_Filters_All"));
		for (int i = 1; i <= driver.findElements(FetchData.readOR("Mobile_Filters_All")).size(); i++) {
			Variables.elementWait(driver, 3, By.xpath(per.DynamicXpath("Mobile_Filters", Integer.toString(i))));
			String s = driver.findElement(By.xpath(per.DynamicXpath("Mobile_Filters", Integer.toString(i))))
					.findElement(By.tagName("a")).getText();
			a.add(s);
		}
		return a;
	}

	public boolean setFilter(String filterType) {
		boolean b = false;
		try {
			for (int i = 1; i <= 10; i++) {
				String s = driver.findElement(By.xpath(per.DynamicXpath("Mobile_Filters", Integer.toString(i))))
						.findElement(By.tagName("a")).getText();
				// System.out.println(s);
				if (s.equalsIgnoreCase(filterType)) {
					select = i;
					b = true;
					driver.findElement(By.xpath(per.DynamicXpath("Mobile_Filters", Integer.toString(i)))).click();
					break;
				}
			}

		} catch (Exception e) {

		}
		return b;
	}

	public int getFilterCount() {
		int i = 0;
		try {
			By xpath = By.xpath(per.DynamicXpath("Mobile_Filter_Specific", Integer.toString(select))
					+ "//input[not(@disabled='disabled')]");
			// Variables.elementWait(driver, 5, xpath);
			List<WebElement> we = driver.findElements(xpath);
			i = we.size();
			//per.childInfo(child, "Total Filters in the Location Tab:" + i);
			//per.info(child, "Total Filters in the Location Tab:" + i);
			return i;
		} catch (Exception e) {
			//per.info(child, "Total Filters in the Location Tab:" + i);
			throw e;
		}
	}

	public void click_Apply_Filter() {
		try {

			Variables.elementWait(driver, 5, FetchData.readOR("Apply_Filter_Btn"));
			driver.findElement(FetchData.readOR("Apply_Filter_Btn")).click();

		} catch (Exception e) {
			throw e;
		}
	}

	public int count_College() {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("Count_College"));
			String s = driver.findElement(FetchData.readOR("Count_College")).getText();
			return Integer.parseInt(s.substring(0, s.indexOf(" C")));
		} catch (Exception e) {
			throw e;
		}
	}

	public void click_FilteredMore() {
		try {
			if (driver.findElements(FetchData.readOR("Filtered_More_Lnk")).size() > 0
					&& driver.findElement(FetchData.readOR("Filtered_More_Lnk")).isDisplayed()) {
				Variables.elementWait(driver, 5, FetchData.readOR("Filtered_More_Lnk"));
				driver.findElement(FetchData.readOR("Filtered_More_Lnk")).click();
			}
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean clearAllVerify(ExtentTest child) {

		if (driver.findElements(FetchData.readOR("Selected_Filters")).size() != 0) {
			per.childFail(child, "Selected Filter Menu is not Empty");
			//per.fail(child, "Selected Filter Menu is not Empty");
			return false;

		}

		if (driver.findElements(FetchData.readOR("Selcted_Noticification")).size() != 0) {
			per.childFail(child, "Selected Filter Notification is not Empty");
			//per.fail(child, "Selected Filter Notification is not Empty");
			return false;
		}
		per.childPass(child, "Selected Filter Menu is Empty");
		//per.pass(child, "Selected Filter Menu is Empty");
		per.childPass(child, "Selected Filter Notification is Empty");
		//per.pass(child, "Selected Filter Notification is Empty");

		return true;
	}

	public boolean isFilterSelected(String txt) {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("Selected_Filters"));
			List<WebElement> w = driver.findElements(FetchData.readOR("Selected_Filters"));
			for (WebElement we : w) {
				String s = we.getText();

				if (s.contains("×"))
					s = s.substring(0, s.indexOf("×"));
				// System.out.println(s);
				if (s.trim().equalsIgnoreCase(txt))
					return true;
			}
			return false;

		} catch (Exception e) {
			throw e;
		}
	}

	public String selectFilter(int x, int z, ExtentTest child) {
		try {
			By xpath = By.xpath(per.DynamicXpath("Mobile_Filter_Specific", Integer.toString(select)));
			Actions ac = new Actions(driver);
			ac.moveToElement(driver.findElements(xpath).get(z - 1)).build().perform();
			WebElement we = driver.findElements(xpath).get(x - 1);
			per.scrollTo(we);
			String s = we.getText();
			// System.out.println(driver.findElements(xpath).get(z-1).getText());
			// System.out.println(we);
			we.click();
			per.childPass(child, "Filter Clicked Successfully : " + s);
			//per.pass(child, "Filter Clicked Successfully : " + s);
			return s;
		} catch (Exception e) {
			per.childFail(child, "Fail To select filter at " + x);
			//per.fail(child, "Fail To select filter at " + x);
			throw e;
		}
	}

	public void click_Clear_All(ExtentTest child) {
		try {
			Variables.elementWait(driver, 5, FetchData.readOR("Clear_All"));
			driver.findElement(FetchData.readOR("Clear_All")).click();
			per.childPass(child, "Clicked on Clear all link Success");
			//per.pass(child, "Clicked on Clear all link Success");
		} catch (Exception e) {
			per.childFail(child, "Clicked on Clear all link Failed");
			//per.fail(child, "Clicked on Clear all link Failed");
			throw e;
		}
	}

	public void click_CTP_Filter_Btn() {
		try {
			Thread.sleep(2000);
			Variables.elementWait(driver, 10, FetchData.readOR("CTP_Mobile_Filter_Btn"));
			driver.findElement(FetchData.readOR("CTP_Mobile_Filter_Btn")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> get_CTP_FilterTabs() {
		List<String> li = new ArrayList<String>();
		try {
			Variables.elementWait(driver, 40, FetchData.readOR("CTP_Mobile_Filter_Tabs"));
			List<WebElement> wes = driver.findElements(FetchData.readOR("CTP_Mobile_Filter_Tabs"));
			for (WebElement we : wes)
				li.add(we.findElement(By.tagName("a")).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	public boolean click_CTP_FilterTab(String ft) {
		String xpath = per.DynamicXpath("CTP_Mobile_Filter_Tab_Specify", ft);
		if (per.isAvailable(xpath)) {

			per.findElementByXpath(xpath).click();

			return true;
		} else {
			return false;
		}
	}

	public int count_CTP_Filters() {

		return driver.findElements(FetchData.readOR("CTP_Mobile_Filters")).size();
	}

	public String selectFilter(int sel,ExtentTest child) {
		String filter = null;
		try {
			WebElement we = driver.findElements(FetchData.readOR("CTP_Mobile_Filters")).get(sel);
			filter = we.getText();
			we.click();
			per.childPass(child, "Filter Selected Successfully : "+filter);
		} catch (Exception e) {
			per.childFail(child, "Failed to select filter");
			e.printStackTrace();
		}
		return filter;
	}

	public void click_AllFilter_CTP() {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("CTP_Mobile_Selected_Filter")) + "/a";

		if (per.isAvailable(xpath))
			per.findElementByXpath(xpath).click();

	}

	public void click_CTP_ApplyFilter_Btn(ExtentTest child) {
		try {
			Variables.elementWait(driver, 30, FetchData.readOR("CTP_Mobile_ApplyFilter_Btn"));
			driver.findElement(FetchData.readOR("CTP_Mobile_ApplyFilter_Btn")).click();
			per.childPass(child, "Click on ApplyFilter Successfully");
		}catch(Exception e) {
			per.childFail(child, "Fail to Click Apply Filter");
			throw e;
		}
	}

	public String getCTP_SelectedFilterCount() {
		String data = "";
		try {
			Thread.sleep(2000);
			Variables.elementWait(driver, 10, FetchData.readOR("CTP_Mobile_Filter_Btn"));
			String xpath = per.byXpath_To_StringXpath(FetchData.readOR("CTP_Mobile_Filter_Btn")) + "/span";
			data = per.findElementByXpath(xpath).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public boolean isCTPFilterSelected(String txt) {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("CTP_Mobile_Selected_Filter"))
				+ "//div[@class='select-box' and text()='" + txt + "']";
		if (per.isAvailable(xpath))
			return true;
		else
			return false;
	}
	public void click_Homepage_Search(ExtentTest child)
	{
		try {
			Thread.sleep(500);
			driver.findElement(FetchData.readOR("search_homepage")).click();
			Thread.sleep(2000);
			System.out.println("Clicked on Homepage search successfully");
			per.childPass(child, "Clicked on Homepage search successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Fail to click on Homepage search");
			per.childFail(child, "Fail to click on Homepage search");
		}
	}

	public void click_Search(String txt,ExtentTest child)
	{
		try {
			Thread.sleep(500);
			driver.findElement(FetchData.readOR("input_search_mobile")).click();
			Thread.sleep(1000);
			System.out.println("clicked on input search layer");
			per.childPass(child, "clicked on input search layer");
			driver.findElement(FetchData.readOR("input_search_mobile")).clear();
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("input_search_mobile")).sendKeys(txt);
			Thread.sleep(2000);
			System.out.println("Text entered is: "+txt);
			per.childPass(child, "Text entered is: "+txt);
		}
		catch(Exception e)
		{
			System.out.println("Fail to click on input search layer");
			per.childFail(child, "Fail to click on input search layer");
			e.printStackTrace();
		}
	}
	public void click_Search_Suggestion(String txt,ExtentTest child)
	{
		try {
			Thread.sleep(500);
			String xpath=per.DynamicXpath("select_Input_List", txt);
			driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(2000);
			System.out.println("Input is selected as : "+txt);
			per.childPass(child, "Input is selected as : "+txt);
		}
		catch(Exception e)
		{
			System.out.println("Fail to select from suggestion");
			per.childFail(child, "Fail to select from suggestion");
			e.printStackTrace();
		}
	}
	public void click_Stream(ExtentTest child)
	{
		try {
			Thread.sleep(500);
			driver.findElement(FetchData.readOR("choosing_stream")).click();
			Thread.sleep(1000);
			System.out.println("Successfully clicked on stream");
			per.childPass(child, "Successfully clicked on stream");
			
		}
		catch(Exception e)
		{
			System.out.println("Fail to click stream");
			per.childFail(child, "Fail to click stream");
			e.printStackTrace();
		}
	}
	public void choose_Stream(String txt,ExtentTest child)
	{
		try {
			Thread.sleep(500);
			String xpath=per.DynamicXpath("stream_drplist", txt);
			driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(1000);
			System.out.println("Stream selected as: "+txt);
			per.childPass(child, "Stream selected as: "+txt);
		}
		catch(Exception e)
		{
			System.out.println("Fail to select stream");
			per.childFail(child, "Fail to select stream");
			e.printStackTrace();
		}
	}
	public void click_Course(ExtentTest child)
	{
		try {
			Thread.sleep(500);
			driver.findElement(FetchData.readOR("choosing_course")).click();
			Thread.sleep(1000);
			System.out.println("Successfully clicked on course");
			per.childPass(child, "Successfully clicked on course");
		}
		catch(Exception e)
		{
			System.out.println("Fail to click course");
			per.childFail(child, "Fail to click course");
			e.printStackTrace();
		}
	}
	public void choose_Course(String txt,ExtentTest child)
	{
		try {
			Thread.sleep(500);
			String xpath=per.DynamicXpath("stream_drplist", txt);
			driver.findElement(By.xpath(xpath)).click();
			Thread.sleep(1000);
			System.out.println("Course selected as: "+txt);
			per.childPass(child, "Course selected as: "+txt);
		}
		catch(Exception e)
		{
			System.out.println("Fail to select course");
			per.childFail(child, "Fail to select course");
			e.printStackTrace();
		}
	}
	public void click_Search_Btn(ExtentTest child)
	{
		try {
			Thread.sleep(500);
			driver.findElement(FetchData.readOR("Search_Btn")).click();
			Thread.sleep(1000);
			System.out.println("Successfully clicked on search button");
			per.childPass(child, "Successfully clicked on search button");
		}
		catch(Exception e)
		{
			System.out.println("Fail to click search button");
			per.childFail(child, "Fail to click search button");
			e.printStackTrace();
		}
	}
	public void click_Enter(ExtentTest child)
	{
		try {
		
			Thread.sleep(1000);
			//driver.findElement(FetchData.readOR("input_search_mobile")).click();
			driver.findElement(FetchData.readOR("input_search_mobile")).sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			System.out.println("Successfully pressed ENTER");
			per.childPass(child, "Successfully pressed ENTER");
		
		}
		catch(Exception e)
		{
			System.out.println("Fail to press ENTER");
			per.childFail(child, "Fail to press ENTER");
			e.printStackTrace();
		}
	}
}
