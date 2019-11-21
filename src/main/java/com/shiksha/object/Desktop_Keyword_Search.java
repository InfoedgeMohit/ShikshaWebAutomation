package com.shiksha.object;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;



public class Desktop_Keyword_Search {
	WebDriver driver;
	CommonFunctions comn_fncts=new CommonFunctions();
	GenericFunction per=new GenericFunction(driver);

	
  public Desktop_Keyword_Search(WebDriver driver) {
		this.driver = driver;
	}
	
  public void click_Type(String s1)
  {
	  try {
		  String final_Type_Xpath="";
		  
		  final_Type_Xpath=comn_fncts.xpath_Dynamic("type_Xpath",s1);
		
		  driver.findElement(By.xpath(final_Type_Xpath)).click();
		  
		  Thread.sleep(500);
		
	  }
	  catch(Exception e)
	  {
		 
		  e.printStackTrace();
	  }
  }
  
  public void click_Search()
  {
	  try {
		  
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("type_Search")).click();
		  Thread.sleep(500);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
  }
  
  public void clear_Search()
  {
	  try {
		  
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("type_Search")).clear();
		  Thread.sleep(500);
		 
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
  }
  public void fill_Search(String keyword)
  {
	  try {
		  
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("type_Search")).sendKeys(keyword);
		  Thread.sleep(500);
		 
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
  }
  
  public void select_College(String keyword)
  {
	  try {
		  String final_Xpath=comn_fncts.xpath_Dynamic("select_First_Search", keyword);
		  Thread.sleep(500);
		  driver.findElement(By.xpath(final_Xpath)).click();
		  Thread.sleep(500);
	  }
	  catch (Exception e) {
			
			e.printStackTrace();
		}
	  
	  
	  
  } 
  public void click_Loc()
  {
	  try {
		  
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("loc_Xpath")).click();
		  Thread.sleep(500);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
  }
  public void clear_Loc()
  {
	  try {
		  
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("loc_Xpath")).clear();
		  Thread.sleep(500);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
  }
  public void fill_Loc(String location)
  {
	  try {
		  
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("loc_Xpath")).sendKeys(location);
		  Thread.sleep(500);
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
  }
  public void select_Loc(String top)
  
  {
	  try {
		  String final_Xpath="";
		  final_Xpath=comn_fncts.xpath_Dynamic("select_First_Loc", top);
		  Thread.sleep(500);
		  driver.findElement(By.xpath(final_Xpath)).click();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public void click_Specialization()
  {
	  try {
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("specialization_Xpath")).click();
		  Thread.sleep(500);
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public void select_Specialization(String special)
  {
	  try {
		  Thread.sleep(500);
		  String final_Xpath="";
		  final_Xpath=comn_fncts.xpath_Dynamic("select_Specialization", special);
		  Thread.sleep(500);
		  driver.findElement(By.xpath(final_Xpath)).click();
		  Thread.sleep(500);
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public void click_Exams_Accepted()
  {
	  try {
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("exams_Accepted_Xpath")).click();
		  Thread.sleep(500);
	  }
	  
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public void select_Exams_Accepted(String accept)
  {
	  try {
		  Thread.sleep(500);
		  String final_Xpath="";
		  final_Xpath=comn_fncts.xpath_Dynamic("select_Exams_Accepted", accept);
		  driver.findElement(By.xpath(final_Xpath)).click();
		  Thread.sleep(500);
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public void click_Fees()
  {
	  try {
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("fees_Xpath")).click();
		  Thread.sleep(500);
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public void select_Fees(String fees)
  {
	  try {
		  Thread.sleep(500);
		  String final_Xpath="";
		  final_Xpath=comn_fncts.xpath_Dynamic("select_Fees", fees);
		  driver.findElement(By.xpath(final_Xpath)).click();
		  Thread.sleep(500);
		  
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  public void click_Submit_College(String l1)
  {
	  try {
		  Thread.sleep(500);
		 
		  if(l1.equalsIgnoreCase("colleges"))
			  driver.findElement(FetchData.readOR("btn_College")).click();
		  else {
			  /*String final_xpath=comn_fncts.xpath_Dynamic("submit_Btn",l1.substring(0,l1.length()-1));
			  System.out.println(final_xpath);*/
			  String final_xpath= comn_fncts.xpath_Dynamic("submit_Btn","submit_"+l1.substring(0,l1.length()-1));
			  driver.findElement(By.xpath(final_xpath)).click();
	
		  }
		  Thread.sleep(1000);
	
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
  }
  
  public void click_Type_Input(String placeholder, String value,com.aventstack.extentreports.ExtentTest child)
  {
	  try {
		  String final_Xpath=comn_fncts.xpath_Dynamic("input_Search", placeholder);
		  
		  driver.findElement(By.xpath(final_Xpath)).click();
		  Thread.sleep(500);
		  driver.findElement(By.xpath(final_Xpath)).clear();
		  Thread.sleep(500);
		  driver.findElement(By.xpath(final_Xpath)).sendKeys(value);
		  Thread.sleep(500);
		  
		// comn_fncts.pass(child, "Successfully clicked on :"+placeholder);
		  per.childPass(child, value);
		 //comn_fncts.pass(child,value);
	  }
	  
	  catch (Exception e) {
			//comn_fncts.fail(child, "Fail to click on "+placeholder);
		  per.childFail(child, value);
			//comn_fncts.fail(child,value);
			e.printStackTrace();
		}
  }
  public void select_Type_Input(String top,com.aventstack.extentreports.ExtentTest child)
  {
	  try {
		  String final_Xpath=comn_fncts.xpath_Dynamic("selecting_input", top);
		  driver.findElement(By.xpath(final_Xpath)).click();
		  Thread.sleep(500);
		  per.childPass(child, "selected from suggestion:"+ top);
		 // comn_fncts.pass(child,"selected from suggestion:"+ top);
		 
	  }
	  
	  catch (Exception e) {
		  per.childFail(child, "Fail to select from suggestion");
			//comn_fncts.fail(child, "Fail to select from suggestion");
			e.printStackTrace();
		}
  }
public void click_Drpdwn(String drplist,String drpselect,com.aventstack.extentreports.ExtentTest child)
{
	try {
		Thread.sleep(500);
		String final_Xpath=comn_fncts.xpath_Dynamic("drpdwn", drplist);
		driver.findElement(By.xpath(final_Xpath)).click();
		Thread.sleep(500);
		String drp_Xpath=comn_fncts.xpath_Dynamic("selecting_drpdwn", drpselect);
		
		driver.findElement(By.xpath(drp_Xpath)).click();
		Thread.sleep(500);
		per.childPass(child, drplist);
		// comn_fncts.pass(child,drplist);
		per.childPass(child, drpselect);
		 //comn_fncts.pass(child,drpselect);
		
	}
	catch(Exception e)
	{
		per.childFail(child, drplist);
		//comn_fncts.fail(child,drplist);
		per.childFail(child, drpselect);
		//comn_fncts.fail(child,drpselect);
		e.printStackTrace();
	}
}
public void selectLocation(com.aventstack.extentreports.ExtentTest child)
{
	  try {
		 
		 // driver.findElement(By.xpath(final_Xpath)).click();
		  Thread.sleep(500);
		  driver.findElement(FetchData.readOR("select_First_Loc")).click();
		  //comn_fncts.pass(child, "Successfully Selected from Location");
	  }
	  
	  catch (Exception e) {
		  per.childFail(child, "Fail to select from location");
			//comn_fncts.fail(child, "Fail to select from location");
			e.printStackTrace();
		}
}

public void hoverAt(int i, int j) {
	Actions action=new Actions(driver);
	action.moveByOffset(i,j).build().perform();
	
	
	
}
 
}
