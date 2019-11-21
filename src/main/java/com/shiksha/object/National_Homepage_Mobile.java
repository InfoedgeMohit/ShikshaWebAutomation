package com.shiksha.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.Variables;

public class National_Homepage_Mobile {
	WebDriver driver;
	//CommonFunctions per = new CommonFunctions();
	GenericFunction per;
	public National_Homepage_Mobile(WebDriver driver) {
		this.driver = driver;
		per = new GenericFunction(driver);
	}
	public boolean first_Cross_Visible() {
		if(driver.findElements(FetchData.readOR("Mobile_firstCross")).size()>0 && driver.findElement(FetchData.readOR("Mobile_firstCross")).isDisplayed())
			return true;
		else
			return false;
	}
	public void click_FirstCross() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Mobile_firstCross"));
			driver.findElement(FetchData.readOR("Mobile_firstCross")).click();
		}catch(Exception ex) {
			throw ex;
		}
	}
	public void click_Hamburger(ExtentTest child1)
	{
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Mobile_ham"));
			driver.findElement(FetchData.readOR("Mobile_ham")).click();
			per.childPass(child1, "Click on Hamburger Successed");
			//per.pass(child1, "Click on Hamburger Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Click on Hamburger Failed");
			//per.fail(child1, "Click on Hamburger Failed");
			throw ex;
		}
	}
	public void click_Stream_Selector(String txt,ExtentTest child1) {
		try {
			Thread.sleep(500);
			String xpath = per.DynamicXpath("Mobile_Select_Stream", txt);		
			Variables.elementWait(driver, 10,By.xpath(xpath));
			WebElement we = driver.findElement(By.xpath(xpath));
			we.isDisplayed();
			we.click();
			per.childPass(child1, "Click on Stream Selector Successed");
			//per.pass(child1, "Click on Stream Selector Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Click on Stream Selector Failed");
			//per.fail(child1, "Click on Stream Selector Failed");

			try {
				throw ex;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void click_Specilization(String txt,ExtentTest child1) {
		try {
			Thread.sleep(500);
			login_Lnk_Displayed();
			String xpath = per.DynamicXpath("Mobile_specilization", txt);			
			
			
			while(driver.findElements(By.xpath(xpath)).size()==0 && !driver.findElement(By.xpath(xpath)).isDisplayed())
				click_Stream_Selector("Select Stream", child1);
			
			WebElement we = driver.findElement(By.xpath(xpath));
			Variables.elementWait(driver, 4,By.xpath(xpath));
			we.click();
			//per.pass(child1, "Stream "+txt+" Selection Successed");
			per.childPass(child1, "Stream "+txt+" Selection Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Stream "+txt+" Selection Failed");
			//per.fail(child1, "Stream "+txt+" Selection Failed");
			try {
				throw ex;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void click_Ham_Lvl2(String txt,ExtentTest child1) {
		try {
			Thread.sleep(500);
			login_Lnk_Displayed();
			String xpath = per.DynamicXpath("Mobile_Ham_Lvl2", txt);			
			Variables.elementWait(driver, 10,By.xpath(xpath));
			WebElement we = driver.findElement(By.xpath(xpath));
			if(!we.isDisplayed())
				per.scrollTo(we);
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//per.pass(child1, "Click on "+txt+" Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Click on "+txt+" Failed");
			//per.fail(child1, "Click on "+txt+" Failed");
			try {
				throw ex;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void click_Ham_Lvl3(String txt,ExtentTest child1) {
		try {
			Thread.sleep(1000);
			String xpath = per.DynamicXpath("Mobile_Ham_Lvl3", txt);
			
			WebElement we = driver.findElement(By.xpath(xpath));
			if(!we.isDisplayed())
				per.scrollTo( we);
			
			Variables.elementWait(driver, 10,By.xpath(xpath));
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//per.pass(child1, "Click on "+txt+" Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Click on "+txt+" Failed");
			//per.fail(child1, "Click on "+txt+" Failed");
			try {
				throw ex;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void PWA_Hab_BackDisplay() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Mobile_PWA_Ham_Back"));
			
			driver.findElements(FetchData.readOR("Mobile_PWA_Ham_Back")).get(driver.findElements(FetchData.readOR("Mobile_PWA_Ham_Back")).size()-1);
		}catch(Exception e) {
			throw e;
		}
	}
	public void click_Ham_PWA_Lvl3(String txt,ExtentTest child1) {
		try {
			String xpath = per.DynamicXpath("Mobile_Ham_PWA_Lvl3", txt);
			Thread.sleep(500);
			List<WebElement> wez = driver.findElements(By.xpath(xpath));
			WebElement we = wez.get(wez.size()-1);
			if(!we.isDisplayed())
				per.scrollTo( we);
			PWA_Hab_BackDisplay();
			Variables.elementWait(driver, 10,By.xpath(xpath));
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//per.pass(child1, "Click on "+txt+" Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Click on "+txt+" Failed");
			//per.fail(child1, "Click on "+txt+" Failed");
			try {
				throw ex;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public void click_PWA_Location(String txt,ExtentTest child1) {
		try {
			
			String xpath = per.DynamicXpath("Mobile_PWA_Location_List", txt);
			fill_PWA_Location(txt);
			Thread.sleep(500);
			WebElement we = driver.findElement(By.xpath(xpath));
			if(!we.isDisplayed())
				per.scrollTo( we);
			//PWA_Hab_BackDisplay();
			Variables.elementWait(driver, 10,By.xpath(xpath));
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//per.pass(child1, "Click on "+txt+" Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Click on "+txt+" Failed");
			//per.fail(child1, "Click on "+txt+" Failed");
			try {
				throw ex;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean PWA_location_Visible() {
		try {
			Thread.sleep(500);
			if(driver.findElements(FetchData.readOR("PWA_Location")).size()>0)
				return true;
			else
				return false;
		}catch(Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}
	public void fill_PWA_Location(String txt) {
		try {
			Variables.elementWait(driver, 10,FetchData.readOR("PWA_Location_Search"));
			driver.findElement(FetchData.readOR("PWA_Location_Search")).sendKeys(txt);
		}catch(Exception e) {
			throw e;
		}
	}
	public void click_Ham_Lvl4(String txt,ExtentTest child1) {
		try {
			String xpath = per.DynamicXpath("Mobile_Ham_Lvl4", txt);	
			Thread.sleep(500);
			List<WebElement> l = driver.findElements(By.xpath(xpath));
			WebElement we = l.get(l.size()-1);
			if(!we.isDisplayed())
				per.scrollTo( we);
			Variables.elementWait(driver, 10,By.xpath(xpath));
			
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//per.pass(child1, "Click on "+txt+" Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Click on "+txt+" Failed");
			//per.fail(child1, "Click on "+txt+" Failed");
			try {
				throw ex;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public boolean isCheckBoxLocationIsPresent()
	{
		//Variables.elementWait(driver, 10, FetchData.readOR("Mobile_CheckBox_Location_Tab"));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(driver.findElements(FetchData.readOR("Mobile_CheckBox_Location_Tab")).size()==0)
			return false;
		else
			return true;
	}
	public boolean isRadioBoxLocationIsPresent()
	{
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// 
			e.printStackTrace();
		}
		//Variables.elementWait(driver, 10, FetchData.readOR("Mobile_RadioBox_Location_Tab"));
		if(driver.findElements(FetchData.readOR("Mobile_RadioBox_Location_Tab")).size()==0)
			return false;
		else
			return true;
	}
	public boolean isNormal_Location() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// 
			e.printStackTrace();
		}
		//Variables.elementWait(driver, 10, FetchData.readOR("Mobile_RadioBox_Location_Tab"));
		if(driver.findElements(FetchData.readOR("Mobile_Normal_Location")).size()==0)
			return false;
		else
			return true;
	}
	public void click_location(String txt,ExtentTest child1) {
		try {
			driver.findElement(FetchData.readOR("Mobile_Location_Txt")).sendKeys(txt);
			String xpath = per.DynamicXpath("Mobile_Location", txt);			
			WebElement we = driver.findElement(By.xpath(xpath));
			
			if(!we.isDisplayed())
				per.scrollTo( we);
			
			Variables.elementWait(driver, 10,By.xpath(xpath));
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//per.pass(child1, "Click on "+txt+" Successed");	
		}catch(Exception ex) {
			per.childFail(child1, "Click on "+txt+" Failed");
			//per.fail(child1, "Click on "+txt+" Failed");	
			try {
				throw ex;
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
	}
	public void PWA_Fill_Location_CheckBox(String txt,ExtentTest child1) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("PWA_CheckBox_Location_Search"));
			driver.findElement(FetchData.readOR("PWA_CheckBox_Location_Search")).sendKeys(txt);
			per.childPass(child1, "Location filled "+txt+" Successed");
			//per.pass(child1, "Location filled "+txt+" Successed");
		}catch(Exception e) {
			per.childFail(child1, "Location filled "+txt+" Failed");
			//per.fail(child1, "Location filled "+txt+" Failed");
			throw e;
		}
	}
	public void click_location_CheckBox(String txt,ExtentTest child1) {
		try {
			String xpath = per.DynamicXpath("Mobile_Checkbox_Location", txt);			
			
			Variables.elementWait(driver, 10,By.xpath(xpath));
			driver.findElement(FetchData.readOR("Mobile_Location_CheckBox_Search")).sendKeys(txt);
			WebElement we = driver.findElement(By.xpath(xpath));
			if(!we.isDisplayed())
				per.scrollTo( we);
			
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//per.pass(child1, "Click on "+txt+" Successed");	
		}catch(Exception ex) {
			per.childFail(child1, "Click on "+txt+" Failed");
			//per.fail(child1, "Click on "+txt+" Failed");	
			throw ex;
		}
	}
	public void PWA_Click_location_CheckBox(String txt,ExtentTest child1) {
		try {
			String xpath = per.DynamicXpath("PWA_CheckBox_Location", txt);			
			WebElement we = driver.findElement(By.xpath(xpath));
			Variables.elementWait(driver, 10,By.xpath(xpath));
			
			if(!we.isDisplayed())
				per.scrollTo(we);
			
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//per.pass(child1, "Click on "+txt+" Successed");	
		}catch(Exception ex) {
			//per.fail(child1, "Click on "+txt+" Failed");
			per.childFail(child1, "Click on "+txt+" Failed");
			throw ex;
		}
	}
	public void click_Location_Submit(ExtentTest child1) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Mobile_CheckBox_Location_Submit"));
			driver.findElement(FetchData.readOR("Mobile_CheckBox_Location_Submit")).click();
			//per.pass(child1, "Click on Submit Successed");
			per.childPass(child1, "Click on Submit Successed");
		}catch(Exception ex) {
			per.childFail(child1, "Click on Submit Failed");
			//per.fail(child1, "Click on Submit Failed");	
			throw ex;
		}
	}
	public void footer_Displayed() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Mobile_Mobile_footer"));
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("Mobile_Mobile_footer")).isDisplayed();
		}catch(Exception ex) {
			try {
				throw ex;
			} catch (Exception e) {
				// 
				e.printStackTrace();
			}
		}
	}
	public void user_Icon_Displayed() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Mobile_Ham_UserIcon"));
			driver.findElement(FetchData.readOR("Mobile_Ham_UserIcon"));
		}catch(Exception ex) {
			throw ex;
		}
	}
	public void login_Lnk_Displayed() {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("Mobile_Ham_Login"));
			driver.findElement(FetchData.readOR("Mobile_Ham_Login")).getText();
			
		}catch(Exception ex) {
			throw ex;
		}
	}
	
	public void click_L1_Category(String txt,ExtentTest child) {
		try {
			Thread.sleep(1000);
			String xpath = per.DynamicXpath("category_L1", txt);
			if(per.isAvailable(xpath)) {
				per.findElementByXpath(xpath).click();
			per.childPass(child, "clicked on "+txt);
				//per.pass(child, "clicked on "+txt);
			}
			else
				per.childFail(child, "Fail to click on "+txt);
				//per.fail(child, "Fail to click on "+txt);
		} catch (InterruptedException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void click_L2_Category(String txt,ExtentTest child,int k) {
		try {
			Thread.sleep(1000);
			String xpath = per.DynamicXpath("category_L2", txt)+"["+k+"]";
			System.out.println(xpath);
			if(per.isAvailable(xpath)) {
				per.findElementByXpath(xpath).click();
				per.childPass(child, "clicked on "+txt);
				//per.pass(child, "clicked on "+txt);
			}
			else
				per.childFail(child, "Fail to click on "+txt);
				//per.fail(child, "Fail to click on "+txt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void click_L3_Category(String txt,ExtentTest child) {
		try {
			Thread.sleep(1000);
			String xpath = per.DynamicXpath("category_L3", txt);
		try {
			Variables.elementWait(driver, 10, By.xpath(xpath));
		}
			catch(Exception e)
		{
		}
			if(per.isAvailable(per.byXpath_To_StringXpath(FetchData.readOR("category_Input_Type"))))
			{
				driver.findElement(FetchData.readOR("category_Input_Type")).click();
				driver.findElement(FetchData.readOR("category_Input_Type")).sendKeys(txt);
			}
			if(per.isAvailable(xpath)) {
				per.findElementByXpath(xpath).click();
				per.childPass(child, "clicked on "+txt);
				//per.pass(child, "clicked on "+txt);
			}
			else
				per.childFail(child, "Fail to click on "+txt);
				//per.fail(child, "Fail to click on "+txt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
