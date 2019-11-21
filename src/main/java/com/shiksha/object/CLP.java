package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.Variables;

public class CLP {
	WebDriver driver;
	//CommonFunctions per = new CommonFunctions();
	private int select = 1;
	GenericFunction per;

	public CLP(WebDriver driver) {
		this.driver = driver;
		per = new GenericFunction(driver);
	}

	public int getFilterdCount(String type) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (type.equalsIgnoreCase("CTP"))
			return Integer.parseInt(driver.findElement(FetchData.readOR("CLP_Filter_Count")).getText());
		else
			return Integer.parseInt(driver.findElement(FetchData.readOR("Search_Filter_Count")).getText());
	}

	public List<String> getFilterTabs() {
		List<String> a = new ArrayList<String>();
		for (int i = 1; i <= 10; i++) {
			String s = driver.findElement(By.xpath(per.DynamicXpath("CLP_Filter", Integer.toString(i))))
					.findElement(By.tagName("a")).getText();
			a.add(s);
		}
		return a;
	}

	public boolean setFilter(String filterType) {
		boolean b = false;
		try {
			for (int i = 1; i <= 10; i++) {
				String s = driver.findElement(By.xpath(per.DynamicXpath("CLP_Filter", Integer.toString(i))))
						.findElement(By.tagName("a")).getText();
				// System.out.println(s);
				if (s.equalsIgnoreCase(filterType)) {
					select = i;
					b = true;
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
			By xpath = By.xpath(per.DynamicXpath("CLP_Filter", Integer.toString(select)));
			Variables.elementWait(driver, 5, xpath);
			List<WebElement> we = driver.findElement(xpath).findElements(By.tagName("li"));
			i = we.size();

			return i;
		} catch (Exception e) {

			throw e;
		}
	}

	public String filterSelect(int x, int z, ExtentTest child, String FilterTab) {
		try {
			setFilter(FilterTab);
			String xpath = per.DynamicXpath("CLP_Filter", Integer.toString(select)) + "//li[" + x + "]";

			if (!per.isAvailable(xpath))
				per.scrollUnTillVisible(xpath);

			per.scrollVerticalTo(300);
			WebElement temp = per.findElementByXpath(xpath);
			Thread.sleep(2000);

			String s = temp.findElement(By.tagName("label")).getText();

			if (!temp.findElement(By.tagName("a")).isSelected()) {
				temp.findElement(By.tagName("a")).click();
				per.wait_Till_Visible("//div[@class='srpOverlay']");

				per.childPass(child, "The Filter Has Been Selected Successfully : " + s);
				// per.pass(child, "The Filter Has Been Selected Successfully : " + s);
			} else {
				per.childPass(child, "The Filter already Selected : " + s);
				// per.pass(child, "The Filter already Selected : " + s);
			}
			return s;
		} catch (Exception e) {
			per.childFail(child, "The Filter Selection has been fail at : " + x);
			e.printStackTrace();
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return null;
	}

	public boolean verifiedSelected(String name) {

		try {
			boolean b = false;
			Thread.sleep(1000);
			String xpath = per.DynamicXpath("CTP_Selected_Filter_Single", name);
			System.out.println(xpath);
			if(per.isAvailable(xpath))
				b = true;
			System.out.println(b);
			return b;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}

	}

	public boolean removeFilter(String name, ExtentTest child) {
		String xpath = per.DynamicXpath("CTP_Selected_Filter_Single", name);
		if(per.isAvailable("//span[text()='Home']"))
			per.scrollTo(per.findElementByXpath("//span[text()='Home']"));
		per.scrollVerticalTo(-2000);
		if(per.findElementsByXpath(xpath).size()>0)
			per.findElementByXpath(xpath).click();
		else
			per.childInfo(child, "Pass Due to filter is not present to remove");
		per.wait_Till_Visible("//div[@class='srpOverlay']");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return !verifiedSelected(name);
	}
	public boolean isAnyFilterSelected() {
		
		per.wait_Till_Visible("//div[@class='srpOverlay']");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean b = false;
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("CLP_Selected_Filter"));
		if(per.isAvailable(xpath)) {
			System.out.println(per.findElementByXpath(xpath).getText());
			b = true;
		}
		
		System.out.println("Required filter Available: ---->"+b);
		return b;
	}
}
