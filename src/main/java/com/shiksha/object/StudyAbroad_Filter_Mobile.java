package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.Variables;

public class StudyAbroad_Filter_Mobile {
	WebDriver driver;
	
	GenericFunction per;
	public StudyAbroad_Filter_Mobile(WebDriver driver) {
		this.driver = driver;
		per = new GenericFunction(driver);
	}
	public void click_CTP_Filter_Button() {
		Variables.elementWait(driver, 10, FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Button"));
		//System.out.println(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Button"));
		driver.findElement(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Button")).click();
	}
	
	public List<String> ctp_Filter_Tabs(){
		List<String> a = new ArrayList<String>();
		Variables.elementWait(driver, 10, FetchData.readOR("StudyAbroad_CTP_Filter_All_Mobile"));
		per = new GenericFunction(driver);
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_Filter_All_Mobile"));
		List<WebElement> wel = driver.findElements(By.xpath(xpath +"/nav/ul/li"));
		for(int i=0;i<wel.size();i++) {
			String s = wel.get(i).findElement(By.tagName("a")).getText();
			a.add(s);
		}
		return a;
	}
	public boolean click_CTP_FilterTab(String ft) {
		boolean b = false;
		try {
			per = new GenericFunction(driver);
			String xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_Filter_All_Mobile"))+"/nav/ul/li//a)";
			for(int i=1;i<=ctp_Filter_Tabs().size();i++) {
				String s = driver.findElement(By.xpath(xpath+"["+i+"]")).getText();
				if(s.contains("\n"))
					s = s.replaceAll("\n", " ");
				
				if(s.equalsIgnoreCase(ft)) {
					driver.findElement(By.xpath(xpath+"["+i+"]")).click();
					return true;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	public int notification_Count(String ft) {
		per = new GenericFunction(driver);
		String xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_Filter_All_Mobile"))+"/nav/ul/li/div/strong)";
		//System.out.println(xpath);
		String p = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_Filter_All_Mobile"))+"/nav/ul/li/a";
		for(int i=1;i<=5;i++) {
			
			String s = driver.findElement(By.xpath("("+p+")["+i+"]")).getText();
			if(s.contains("\n"))
				s = s.replaceAll("\n", " ");
			//System.out.println(s);
			if(s.equalsIgnoreCase(ft)) {
				String s1 = driver.findElement(By.xpath(xpath+"["+i+"]")).getText();
				try {
				return Integer.parseInt(s1);
				}catch(Exception e) {
					return 0;
				}
			}
		}
		return 0;
	}
	public int count_CTP_Filter() {
		
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Links"))+"//input[not(disabled)]";
		//System.out.println(xpath);
		return driver.findElements(By.xpath(xpath)).size();
	}
	
	public String click_CTP_Filter(int k,com.aventstack.extentreports.ExtentTest child) {
		
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Links"))+"["+k+"]";
		
		String txt ="";
		try {
			txt= driver.findElement(By.xpath(xpath+"/label/p")).getText();
			
			if(driver.findElements(By.xpath(xpath+"//input[not(@checked)]")).size()>0) {
				driver.findElement(By.xpath(xpath+"/label")).click();
			}
			per.childPass(child, "Filter "+txt+" selected successfully");
			//genric.pass(child, "Filter "+txt+" selected successfully");
		}catch(Exception e) {
			per.childFail(child, "Fail to select filter");
			//genric.fail(child, "Fail to select filter");
			throw e;
		}
		return txt;
	}
	public int click_Select_CTP_Filter_Exam_Accepted(int k) {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Links"))+"["+k+"]/div/select";
		driver.findElement(By.xpath(xpath)).click();
		int x = driver.findElements(By.xpath(xpath+"/option")).size();
		return x;
	}
	public String select_Option(int k,int l) {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Links"))+"["+k+"]/div/select/option";
		
		if(!driver.findElement(By.xpath(xpath+"["+l+"]")).isDisplayed()) {
			Actions ac = new Actions(driver);
			ac.moveToElement(driver.findElement(By.xpath(xpath+"[2]"))).build().perform();
			per.scrollTo(driver.findElement(By.xpath(xpath+"["+l+"]")));
		}
		String s =  driver.findElement(By.xpath(xpath+"["+l+"]")).getText();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 driver.findElement(By.xpath(xpath+"["+l+"]")).click();
		 return s;
	}

	public boolean ctp_Exam_Error_Displayed() {
		
		if(driver.findElements(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Exam_Error")).size()>0 && driver.findElement(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Exam_Error")).isDisplayed()) {
			if(driver.findElements(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Exam_Error_Ok")).size()>0 && driver.findElement(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Exam_Error_Ok")).isDisplayed())
			{
				driver.findElement(FetchData.readOR("StudyAbroad_CTP_Mobile_Filter_Exam_Error_Ok")).click();
				return true;
			}
			
		}
		
		return false;
	}
	public void click_Search_First_Ok() {
		System.out.println(driver.findElement(FetchData.readOR("StudyAbroad_Search_First_Ok")));
		if(driver.findElements(FetchData.readOR("StudyAbroad_Search_First_Ok")).size()>0 && driver.findElement(FetchData.readOR("StudyAbroad_Search_First_Ok")).isDisplayed())
			driver.findElement(FetchData.readOR("StudyAbroad_Search_First_Ok")).click();
	}
	public void click_Search_Filter_Btn() {
		Variables.elementWait(driver, 10, FetchData.readOR("StudyAbroad_Search_Filter"));
		WebElement we = driver.findElement(FetchData.readOR("StudyAbroad_Search_Filter"));
		//System.out.println(we.getText());
		we.click();
		
	}
	public List<String> search_Filter_Tabs(){
		
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_Tabs"));
		List<String> a = new ArrayList<String>();
		Variables.elementWait(driver, 10, By.xpath(xpath));
		List<WebElement> wes = driver.findElements(By.xpath(xpath));
		System.out.println(xpath);
		for(int i=0;i<wes.size();i++) {
			String s = wes.get(i).findElement(By.tagName("a")).getText();
			a.add(s);
			
		}
		return a;
	}
	public void click_Search_Filter_Tab(String ft) {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_Tabs"))+"//a[text()='"+ft+"']";
		if(driver.findElements(By.xpath(xpath)).size()>0 && driver.findElement(By.xpath(xpath)).isDisplayed()) {
			driver.findElement(By.xpath(xpath)).click();
			//System.out.println("Click");
		}
	}
	public boolean isSearchFilterTab_Displayed(String ft) {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_Tabs"))+"//a[text()='"+ft+"']";
		
		if(driver.findElements(By.xpath(xpath)).size()>0 && driver.findElement(By.xpath(xpath)).isDisplayed()) {
			System.out.println("------>"+driver.findElement(By.xpath(xpath)).getText());
			return true;
		}
		return false;
	}
	public boolean isSlider() {
		try {
			String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"//div[@class='sld-tab' and not(@style='display: none;')]";
			//System.out.println(xpath);
			if(driver.findElements(By.xpath(xpath)).size()>0 && driver.findElement(By.xpath(xpath)).isDisplayed()) {
				String s = xpath +"/div[@class='slider-div']/div[contains(@class,'ui-slider ui-slider-vertical ui-widget ui-widget-content ui-corner-all ui-state-disabled ui-slider-disabled')]";
				if(driver.findElements(By.xpath(s)).size()>0 && driver.findElement(By.xpath(s)).isDisplayed())
					return false;
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean isRadioSelect() {
		try {
			String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"/div[@class='ap-col']/ul/li/div/input[@type='radio']";
			if(driver.findElements(By.xpath(xpath)).size()>0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int count_Search_Radio_Option() {
		try {
			String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"/div[@class='ap-col']/ul/li//input[not(@disabled)]";
			return driver.findElements(By.xpath(xpath)).size();
		}catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
		
	}
	public String click_Search_Radio_Option(int k) {
		try {
			String xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"/div[@class='ap-col']/ul/li)["+k+"]";
			String s = driver.findElement(By.xpath(xpath)).getText();
			driver.findElement(By.xpath(xpath)).click();
			return s;
		}
		catch(Exception r) {
			r.printStackTrace();
		}
		return null;
	}
	
	public boolean isMultiSelect() {
		try {
			String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"/div[@class='ap-col']/ul/li/div/input[@type='checkbox']";
			if(driver.findElements(By.xpath(xpath)).size()>0)
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int count_Search_MultiSelect() {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"/div[@class='ap-col']/ul/li/div/input[not(@disabled)]";
		return driver.findElements(By.xpath(xpath)).size();
	}
	public String click_MultiSelect(int k,com.aventstack.extentreports.ExtentTest child) {
		try {
			String xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"/div[@class='ap-col']/ul/li)//input[not(@disabled)]["+k+"]/ancestor::li//label";
			String s = driver.findElement(By.xpath(xpath)).getText();
			System.out.println(xpath);
			if(!validateFilter(s.substring(0, s.indexOf("("))))
				driver.findElement(By.xpath(xpath)).click();
			per.childPass(child, "The filter selected successfully : "+s);
			//genric.pass(child, "The filter selected successfully : "+s);
			return s;
		}catch(Exception e) {
			
			throw e;
		}
	}
	public boolean isMultiLevelSelect() {
		try {
			Thread.sleep(1000);
			String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"/div[@class='accordion']//div[@class='sec-cont']";
			//System.out.println(xpath);
			if(driver.findElements(By.xpath(xpath)).size()>0 && driver.findElement(By.xpath(xpath)).isDisplayed())
				return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int count_Search_Upper_Level_Option(String ft) {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"[1]/div[@class='accordion'][1]/div//div[@class='spc-box']//input[not(@data-disabled)]";
		//System.out.println(xpath);
		if(ft.equalsIgnoreCase("Location"))
			xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_Location_Option"))+"/div[@class='accordion'][1]/div//div[@class='spc-box']//input[not(@data-disabled)]";
		
		driver.findElements(By.xpath(xpath));
		//System.out.println("------>"+we.size());
		return driver.findElements(By.xpath(xpath)).size();
	}
	public String optionUpperLevel(int k,String ft) {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"[1]/div[@class='accordion'][1]/div["+k+"]//div[contains(@class,'accr-a accSign')]/div";
		if(ft.equalsIgnoreCase("Location"))
			xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_Location_Option"))+"/div[@class='accordion'][1]/div["+k+"]//div[contains(@class,'accr-a accSign')]/div";
		//System.out.println(xpath);
		return driver.findElement(By.xpath(xpath)).getText();
	}
	public String click_optionLowerLevel(int k,int l,String ft,com.aventstack.extentreports.ExtentTest child) {
		try {
			String xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"[1]/div[@class='accordion'][1]/div["+k+"]/div[@class='sec-cont']//ul/li)["+l+"]";
			if(ft.equalsIgnoreCase("Location"))
				xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_Location_Option"))+"/div[@class='accordion'][1]/div["+k+"]/div[@class='sec-cont']//ul/li)["+l+"]";
			String s = driver.findElement(By.xpath(xpath)).getText();
			per.scrollVerticalTo(80);
			driver.findElement(By.xpath(xpath)).click();
			per.childPass(child, "Filter successfully selected : "+s);
			//genric.pass(child, "Filter successfully selected : "+s);
			return s;
			
		}catch(Exception e) {
			per.childFail(child, "Failed to select filter");
			//genric.fail(child, "Failed to select filter");
			throw e;
		}
	}
	public int count_Search_Lower_Level_Option(int k,String ft) {
		String xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"[1]/div[@class='accordion']/div["+k+"]/div[@class='sec-cont']//input[not(@disabled)])";
		//System.out.println(xpath);
		if(ft.equalsIgnoreCase("Location"))
			xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_Location_Option"))+"/div[@class='accordion']/div["+k+"]/div[@class='sec-cont']//input[not(@disabled)])";
		
		List<WebElement> we = driver.findElements(By.xpath(xpath));
		/*System.out.println(we.get(0).getAttribute("id"));
		System.out.println(we.get(1).getAttribute("id"));*/
		return we.size();
	}
	public String click_Lower_Count_Option(int k,int l) {
		String xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"/div[@class='accordion']/div["+k+"]/div[@class='sec-cont']//ul/li)["+l+"]/label";
		driver.findElement(By.xpath(xpath)).click();
		return driver.findElement(By.xpath(xpath)).getText();
	}
	public String getSearchSliderLimit() {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"//div[@class='slider-div']/div[@class='txtid']";
		String txt = driver.findElement(By.xpath(xpath.replaceAll("txtid", "dwn-range"))).getText();
		txt += "\n"+driver.findElement(By.xpath(xpath.replaceAll("txtid", "up-range"))).getText();
		return txt;
	}
	public boolean is_Filter_Displayed() {
		if(driver.findElements(FetchData.readOR("StudyAbroad_Search_Filter_Open")).size()>0 && driver.findElement(FetchData.readOR("StudyAbroad_Search_Filter_Open")).isDisplayed())
			return true;
		
		return false;
	}
	public String moveSliders(float up,float down,com.aventstack.extentreports.ExtentTest child) {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"//div[@class='slider-div']/div/span";
		try {
			Thread.sleep(1000);
			List<WebElement> wes = driver.findElements(By.xpath(xpath));
			System.out.println(wes.size());
			per.move_Up_Slider_Down(up, wes.get(1));
			
			Thread.sleep(1000);
			wes = driver.findElements(By.xpath(xpath));
			per.move_Down_Slider_up(down, wes.get(0));
			Thread.sleep(1000);
			
			String s = getSearchSliderLimit();
			s = s.replaceAll("\n", "-");
			per.childPass(child, "The range has been selected :"+s);
			//genric.pass(child, "The range has been selected :"+s);
			return s;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			per.childFail(child, "Fail to select range");
			//genric.fail(child, "Fail to select range");
			e.printStackTrace();
		}
		return null;
	}
	public boolean isSpecial() {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"[1]/div[@class='accordion']//div[@class='n-accordion n-accrWht']";
		//System.out.println(xpath);
		if(driver.findElements(By.xpath(xpath)).size()>0)
			return true;
		return false;
	}
	public int countSpecial() {
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"[1]/div[@class='accordion']//div[@class='n-accordion n-accrWht']//input[not(@disabled)]";
		return driver.findElements(By.xpath(xpath)).size();

	}
	public String click_Special(int k,com.aventstack.extentreports.ExtentTest child) {
		
		try{
			String xpath = "("+per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_Search_Filter_option"))+"[1]/div[@class='accordion']//div[@class='n-accordion n-accrWht'])["+k+"]";
			String s = driver.findElement(By.xpath(xpath)).getText();
			driver.findElement(By.xpath(xpath+"//input")).click();
			per.childPass(child, "The Filter selected successfully : "+s);
			//genric.pass(child, "The Filter selected successfully : "+s);
			return s;
		}catch(Exception e) {
			per.childFail(child, "Failed to Select filter");
			//genric.fail(child, "Failed to Select filter");
			throw e;
		}
		
	}
	
	public boolean validateFilter(String txt) {
		String xpath = per.DynamicXpath("StudyAbroad_Search_SelectedFilters", txt);
		if(driver.findElements(By.xpath(xpath)).size()>0)
			return true;
		return false;
	}
}
