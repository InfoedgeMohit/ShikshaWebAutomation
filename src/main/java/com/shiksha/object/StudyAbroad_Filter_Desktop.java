package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.ExtentTest;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.Variables;

public class StudyAbroad_Filter_Desktop {
	WebDriver driver;
	//CommonFunctions genric = new CommonFunctions();
	private int select =1;
	GenericFunction per;

	public List<String> getCTPFilterTabs(){
		List<String> a = new ArrayList<String>();
		Variables.elementWait(driver, 5, FetchData.readOR("StudyAbroad_CTP_Filter_All"));
		for(int i=1;i<=driver.findElements(FetchData.readOR("StudyAbroad_CTP_Filter_All")).size(); i++) {
			String s = driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filters_Heading", Integer.toString(i))))
					.findElement(By.tagName("strong")).getText();
			
			a.add(s);
		}
		return a;
	}
	public List<String> getFilterTabs() {
		List<String> a = new ArrayList<String>();
		Variables.elementWait(driver, 5, FetchData.readOR("StudyAbroad_Search_Filter_Tabs_All"));
		for (int i = 1; i < driver.findElements(FetchData.readOR("StudyAbroad_Search_Filter_Tabs_All")).size(); i++) {
				/*try {
					int x = 0;
					while(driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Tab", Integer.toString(i)))).size()==0 || !driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Tab", Integer.toString(i)))).isDisplayed())
					{	
						Thread.sleep(1000);
						if(x++>30)
							break;
						System.out.println(x);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				Variables.elementWait(driver, 3, By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Tab", Integer.toString(i))));
			String s = driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Tab", Integer.toString(i))))
					.findElement(By.tagName("h2")).getText();
			a.add(s);
		}
		return a;
	}
	public StudyAbroad_Filter_Desktop(WebDriver driver) {
		this.driver = driver;
		per = new GenericFunction(driver);
	}
	
	public boolean setCTPFilter(String filterType) {
		boolean b = false;
		
		for(int i=1;i<10;i++) {
			String s =driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filters_Heading", Integer.toString(i))))
					.findElement(By.tagName("strong")).getText();
			
			if (s.equalsIgnoreCase(filterType)) {
				select = i;
				b = true;
				//per.scrollTo(driver, driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filters_Heading", Integer.toString(i))))
				//		.findElement(By.tagName(tag)));
				break;
			}
		}
		return b;
	}
	public boolean setFilter(String filterType) {
		boolean b = false;
		try {
			for (int i = 1; i <= 10; i++) {
				String s = driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Tab", Integer.toString(i))))
						.findElement(By.tagName("h2")).getText();
				// System.out.println(s);
				if (s.equalsIgnoreCase(filterType)) {
					select = i;
					b = true;
					per.scrollTo(driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Tab", Integer.toString(i))))
						.findElement(By.tagName("h2")));
					break;
				}
			}

		} catch (Exception e) {

		}
		return b;
	}
	
	
	
	public boolean isMultiInnerSelect(String filterType) {
		setFilter(filterType);
		List<WebElement> wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li//i"));
		//System.out.println(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[contains(@class,'multiLi insideList')]");
		if(wes.size()==0)
			return false;
		else
			return true;
	}
	
	public int coutCTPFilter(String filterType) {
		//setCTPFilter(filterType);
		//System.out.println(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"//input[not(@disabled)]");
		return driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"//input[not(@disabled)]")).size();
	}
	public String select_CTP_Filter(int k,int y,ExtentTest child) {
		try {
			Thread.sleep(1000);
			if(!driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]")).isDisplayed())
			{
				Actions ac = new Actions(driver);
				ac.moveToElement(driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+y+"]"))).build().perform();
				per.scrollTo(driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]")));
			}
			String s =driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]")).getText();
			int x=0;
				while(driver.findElements(FetchData.readOR("SA_CTP_frame")).size()>0 && driver.findElement(FetchData.readOR("SA_CTP_frame")).isDisplayed())
				{
					Thread.sleep(1000);
					if(x++>50)
						break;
				}
			if(driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]//input[not(@checked)]")).size()>0)
				driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]/label/span")).click();
			per.childPass(child, "Filter "+s+" has been selected successfully");
			//per.pass(child, "Filter "+s+" has been selected successfully");
			return s;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			per.childFail(child, "Filter is not selected at position : "+k);
			//per.fail(child, "Filter is not selected at position : "+k);
			e.printStackTrace();
			return null;
		}
		
		
	}
	public boolean isCTP_Filter_Selected(String txt) {
		String xpath = per.DynamicXpath("StudyAbroad_CTP_Selected_Filter", txt);
		if(driver.findElements(By.xpath(xpath)).size()>0)
			return true;
		else
			return false;
	}
	public int click_Select_CTP_Filter_Exam_Accepted(int k) {
		//System.out.println("here");
		int x=0;
		try {
			while(driver.findElements(FetchData.readOR("SA_CTP_frame")).size()>0 && driver.findElement(FetchData.readOR("SA_CTP_frame")).isDisplayed())
				{
					Thread.sleep(1000);
					if(x++>50)
						break;
				}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]//select")).size()>0) {
			Variables.elementWait(driver, 10, By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]//select"));
			driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]//select")).click();
			return driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]//select/option")).size();
		}else
			return -99;
	}
	public String select_Option(int k,int l,ExtentTest child) {
		try {
			Thread.sleep(500);
			String s =driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]//select/option["+l+"]")).getText();
			driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_CTP_Filter_List", Integer.toString(select))+"["+k+"]//select/option["+l+"]")).click();
			per.childPass(child, "Filter has been selected from DropDown : " +s);
			//per.pass(child, "Filter has been selected from DropDown : " +s);
			return s;
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			per.childFail(child, "Failed to select filter from DropDown at : "+k);
			//per.fail(child, "Failed to select filter from DropDown at : "+k);
			e.printStackTrace();
			return null;
		}
		
	}
	public boolean ctp_Exam_Error_Displayed() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.findElements(FetchData.readOR("StudyAbroad_CTP_ExamAccept_ErrorMessage")).size()>0 && driver.findElement(FetchData.readOR("StudyAbroad_CTP_ExamAccept_ErrorMessage")).isDisplayed()) {
			String xpath = per.byXpath_To_StringXpath(FetchData.readOR("StudyAbroad_CTP_ExamAccept_ErrorMessage"));
			
			xpath = xpath+"//input[@style='display: inline-block;']";
			System.out.println(xpath);
			Variables.elementWait(driver, 10, By.xpath(xpath));
			driver.findElement(By.xpath(xpath)).click();
			return true;
		}
			
		else
			return false;
	}
	public int countMultiInnerSelect(String filterType) {
		int t = 0;
		if(select==1)
			t = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi insideList']")).size();
		else
			t = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi insideList ']")).size();
		//System.out.println(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[contains(@class,'multiLi insideList') and not(contains(@class,'disabled'))]");
		return t;
	}
	public String click_Open_SubLink(int k) {
		try {
			driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li["+k+"]//i")).click();
			String s = driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li["+k+"]//label")).getText();
			//per.pass(child, "Filtered successfully selected :"+s);
			return s;
		}catch(Exception e) {
			//per.fail(child, "Filtered Failed to selected at level 1");
			throw e;
		}
	}
	public int count_Inhert_Lnk(int k) {
		//System.out.println(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li["+k+"]//ul/li[not(contains(@class,'disabled'))]");
		return driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li["+k+"]//ul/li[not(contains(@class,'disabled'))]")).size();
	}
	public String click_SubLink(int k,int g,ExtentTest child) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li["+k+"]//ul/li["+g+"]")).click();
			String s = driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li["+k+"]//ul/li["+g+"]//label")).getText();
			per.childPass(child, "Filtered successfully selected :"+s);
			//per.pass(child, "Filtered successfully selected :"+s);
			return s;
		}
		catch(Exception e) {
			per.childFail(child, "Filtered Failed to select at level 2");
			//per.fail(child, "Filtered Failed to select at level 2");
			throw e;
		}
	}
	public boolean isMultiSelect(String filterType) {
		setFilter(filterType);
		List<WebElement> wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi ']"));
		//System.out.println(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi ']");
		if(wes.size()==0)
			return false;
		else
			return true;
	}
	public int countMultiSelect(String filterType) {
		List<WebElement> wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi ']"));
		return wes.size();
	}
	public String click_MultiSelect(int k,ExtentTest child) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("location.reload()");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Actions ac = new Actions(driver);
			Variables.elementWait(driver, 10,By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi '][1]"));
			ac.moveToElement(driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi '][1]"))).build().perform();
			per.scrollTo( driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi ']["+k+"]//label")));
			String s = driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi ']["+k+"]//label")).getText();
			driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi ']["+k+"]//label")).click();
			per.childPass(child, "Filtered successfully selected :"+s);
			//per.pass(child, "Filtered successfully selected :"+s);
			return s;
		
		}catch(Exception e) {
			per.childFail(child, "Filtered Failed to select");
			//per.fail(child, "Filtered Failed to select");
			throw e;
		}
	}
	
	
	
	public boolean isDropDown(String filterType) {
		setFilter(filterType);
		List<WebElement> wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div/select"));
		//System.out.println(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi ']");
		if(wes.size()==0)
			return false;
		else
			return true;
	}
	public void click_DropDown(String filterType) {
		setFilter(filterType);
		driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div")).click();
	}
	public int count_DropDown() {
		return  driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div/select/option")).size();
	}
	public String click_DropDown_Option(int k,ExtentTest child) {
		try {
			String s =  driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div/select/option["+k+"]")).getText();
			driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div/select/option["+k+"]")).click();
			per.childPass(child, "Filtered successfully selected :"+s);
			//per.pass(child, "Filtered successfully selected :"+s);
			return s;
		}catch(Exception e) {
			per.childFail(child, "Filtered Failed to select");
			//per.fail(child, "Filtered Failed to select");
			throw e;
		}
	}
	public boolean isSlider(String filterType) {
		List<WebElement> wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div[@class='slidePlace']"));
		//System.out.println(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/ul/li[@class='multiLi ']");
		if(wes.size()==0)
			return false;
		else
			return true;
	}
	public String setSlider(float left,float right,ExtentTest child) {
		try {
			List<WebElement> wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div[@class='slidePlace']/div[2]/span"));
			Actions ac = new Actions(driver);
			
			String s ="";
			
			float x = Float.parseFloat(wes.get(0).getAttribute("style").substring(wes.get(0).getAttribute("style").indexOf(":")+1,wes.get(0).getAttribute("style").length()-1).trim().replaceAll("%", ""));
			
			//System.out.println(left+"   ---> "+x);
			ac.clickAndHold(wes.get(0)).build().perform();
			int i = 0;
			while(x<left) {
	
				ac.moveByOffset(2, 0).build().perform();
				
				wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div[@class='slidePlace']/div[2]/span"));
				
				x = Float.parseFloat(wes.get(0).getAttribute("style").substring(wes.get(0).getAttribute("style").indexOf(":")+1,wes.get(0).getAttribute("style").length()-1).trim().replaceAll("%", ""));
				i++;
				if(i>20)
					break;
				//System.out.println(left+"   ---> "+x);
			}
			
			
			ac.release().build().perform();
			try {
				Thread.sleep(2000);
				wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div[@class='slidePlace']/div[2]/span"));
				per.scrollTo( wes.get(1));
				Thread.sleep(1000);
				x = Float.parseFloat(wes.get(1).getAttribute("style").substring(wes.get(1).getAttribute("style").indexOf(":")+1,wes.get(1).getAttribute("style").length()-1).trim().replaceAll("%", ""));
				ac.clickAndHold(wes.get(1)).build().perform();
	
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			x = Float.parseFloat(wes.get(1).getAttribute("style").substring(wes.get(1).getAttribute("style").indexOf(":")+1,wes.get(1).getAttribute("style").length()-1).trim().replaceAll("%", ""));
			//System.out.println(right+"   ---> "+x);
			i=0;
			while(x>right) {
				
				
				ac.moveByOffset(-2, 0).build().perform();
				
				
				wes = driver.findElements(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div[@class='slidePlace']/div[2]/span"));
				x = Float.parseFloat(wes.get(1).getAttribute("style").substring(wes.get(1).getAttribute("style").indexOf(":")+1,wes.get(1).getAttribute("style").length()-1).trim().replaceAll("%", ""));
				//System.out.println(right+"   ---> "+x);
				i++;
				if(i>20)
					break;
			}
			ac.release().build().perform();
			String limits = getSliderLimit();
			float leftL,rightL;
			String l1 = limits.substring(0,limits.indexOf("\n"));
			String l2 = limits.substring(limits.indexOf("\n")+1,limits.length());
			//System.out.println(l1);
			//System.out.println(l2);
			if(limits.contains(".")) {
				leftL = Float.parseFloat(l1.substring(l1.indexOf(" "), l1.indexOf(" L")+1));
				rightL = Float.parseFloat(l2.substring(l2.indexOf(" "), l2.indexOf(" L")+1));
			}
			else {
				if(l1.contains("%"))
					leftL = Float.parseFloat(l1.substring(0,l1.length()-1));
				else
					leftL = Float.parseFloat(l1.substring(0,2));
				
				if(l2.equalsIgnoreCase("100%"))
					rightL = Float.parseFloat(l2.substring(0,l2.length()-1));
				else
					rightL = Float.parseFloat(l2.substring(0,2));
			}
			
			
			if(l1.contains("%"))
				s = leftL +"% - "+rightL+"%";
			else
				s = leftL +" - "+rightL;
			
			if(s.contains(".0"))
				s= s.replaceAll(".0", "");
			
			per.childPass(child, "Range Set as :"+s);
			//per.pass(child, "Range Set as :"+s);
			return s;
		}catch(Exception e) {
			per.childFail(child, "Fail to set range");
			//per.fail(child, "Fail to set range");
			throw e;
		}
	}
	
	public String getSliderLimit() {
		return driver.findElement(By.xpath(per.DynamicXpath("StudyAbroad_Search_Filter_Content", Integer.toString(select))+"/div[@class='slidePlace']/div[1]")).getText();
	}
	
	public boolean is_Filter_Selected(String txt) {
		try {
			String xpath = per.DynamicXpath("StudyAbroad_Selected_Filters", txt);
			if(driver.findElement(By.xpath(xpath)).isDisplayed())
				return true;
			else
				return false;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public int displayed_Colleges() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String txt = driver.findElement(FetchData.readOR("StudyAbroad_College_Count")).getText();
		//txt = txt.substring(txt.indexOf("\n")+8, txt.length());
		txt = txt.substring(0,txt.indexOf(" "));
		return Integer.parseInt(txt);
		
	}
}
