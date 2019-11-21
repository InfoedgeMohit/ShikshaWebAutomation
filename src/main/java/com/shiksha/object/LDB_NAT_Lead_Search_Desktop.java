package com.shiksha.object;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class LDB_NAT_Lead_Search_Desktop {
	
	WebDriver driver;
	ExtentTest child;
	
	public LDB_NAT_Lead_Search_Desktop(WebDriver driver,ExtentTest child)
	{
		this.driver = driver;
		this.child = child;
	}
	
	CommonFunctions CommonFunctions = new CommonFunctions();
	
	
	 /* Select Stream for National Lead Search */
	 public void selectStream(String stream)throws Exception 
		 {	
			 
				  
				 try
				 {
					Variables.elementWait(driver, 10,FetchData.readOR("select_Stream"));
					WebElement we =   driver.findElement(FetchData.readOR("select_Stream"));
					Select se=new Select(we);
					se.selectByValue(stream);
					CommonFunctions.pass(child, "Select Stream Passed");

					} catch (Exception e) {

						CommonFunctions.fail(child, "Select Stream Failed");
						throw e;
					}
	 }
	 /* Select Sub Stream for National Lead Search */
		 public void selectSubstream()throws Exception 
		 {	
			 
				  
				 try
				 {
				
					 Variables.elementWait(driver, 10,FetchData.readOR("select_Substream"));
					 driver.findElement(FetchData.readOR("select_Substream")).click();
					 CommonFunctions.pass(child, "Select Sub Stream Passed");

					} catch (Exception e) {

						CommonFunctions.fail(child, "Select Sub Stream  Failed");
						throw e;
					}
	 }
		 /* Click calendar to select from date for National Lead Search */
	public void clickCalendar()throws Exception 
	{
		try{
			Thread.sleep(500);
			//Variables.elementWait(driver, 10,FetchData.readOR("click_Calendar"));
			driver.findElement(FetchData.readOR("click_Calendar")).click();
			CommonFunctions.pass(child, "Click Calendar Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Calendar Failed");
			throw e;
		}
	}
	
	 /* pick date from calendar to select from date for National Lead Search */
	
	public void pickDate()throws Exception {
		try{
			Variables.elementWait(driver, 10,FetchData.readOR("move_PreviousMonth"));
			driver.findElement(FetchData.readOR("move_PreviousMonth")).click();
			driver.findElement(FetchData.readOR("pick_Date")).click();
			CommonFunctions.pass(child, "Pick from Date Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Pick From Date Failed");
			throw e;
		}
	}
	 /* Click Search button to get LDB Search result for National Lead  */
	public void clickSearch()throws Exception {
		try{
			Variables.elementWait(driver, 10,FetchData.readOR("click_Search"));
			driver.findElement(FetchData.readOR("click_Search")).click();
			Variables.elementWait(driver, 10,FetchData.readOR("check_Count"));
			CommonFunctions.pass(child, "Click Search Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Search Failed");
			throw e;
		}
	}
	public void verifyCount()throws Exception {
		try{
			System.out.println("Total Count Appearing : "+driver.findElement(FetchData.readOR("check_Count")).getText());
			CommonFunctions.pass(child, "Verify Count Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Verify Count Failed");
			throw e;
		}
	}
	
	public void verifyStream()throws Exception {
		try{
			if(driver.findElement(FetchData.readOR("check_Count")).getText()!="0"){
			System.out.println("Stream of Lead : "+driver.findElement(FetchData.readOR("checkStream")).getText());
			CommonFunctions.pass(child, ">> Passed");
			}
			if(driver.findElement(FetchData.readOR("check_Count")).getText()=="0"){
			System.out.println("No matching leads found");
			CommonFunctions.pass(child, ">>0 Result case for stream-> Passed");			
			}

		} catch (Exception e) {

			CommonFunctions.fail(child, ">> Failed");
			throw e;
		}
	}
	
	public void verifySubstream()throws Exception {
		try{
			if(driver.findElement(FetchData.readOR("check_Count")).getText()!="0"){
			System.out.println("Substream of Lead : "+driver.findElement(FetchData.readOR("checkSubstream")).getText());
			CommonFunctions.pass(child, ">> Passed");
		} 
			if(driver.findElement(FetchData.readOR("check_Count")).getText()=="0"){
				System.out.println("No matching leads found");
				CommonFunctions.pass(child, ">>0 Result case for substream-> Passed");			
				}
		}
			catch (Exception e) {

			CommonFunctions.fail(child, ">>  Failed");
			throw e;
		}
	}
	
	
	public void selectDate(String dd ,String  mm , String yy) throws Exception {
		try {
			Variables.elementWait(driver, 10,FetchData.readOR("click_Calendar"));
			driver.findElement(FetchData.readOR("click_Calendar")).click();
			
			String calYearText = driver.findElement(By.id("calendar_year_txt")).getText();	
			
			StringBuffer myBuffer = new StringBuffer(yy);
			String year = myBuffer.substring(0, 4);
			
			if(calYearText.equalsIgnoreCase(year)){
				System.out.println("True");
			}
			
	//		System.out.println("Month I need to select is ::" + mm);
			
			driver.findElement(By.id("monthSelect")).click();
	//		System.out.println("Month Drop Down clicked");
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//div[contains(text(),'"+mm+"') and contains(@id,'monthDiv')]")).click();
			Thread.sleep(2000);
			
			List<WebElement> allDates =  driver.findElements(By.xpath(".//td[@class='calendar_week_column']/following-sibling::td"));
			
			Thread.sleep(2000);
			
		//	System.out.println("Value of dd is ::" + dd);
			 @SuppressWarnings("static-access")
			String date = CommonFunctions.getNumericValue(dd);
			 
//			String date = dd.split(".")[0];
		//	System.out.println("Date is ::" + date);
			
			for (int i=0 ; i<allDates.size();i++) {
			try {	
			//	System.out.println(allDates.get(i).getText());
				if(allDates.get(i).getText().equalsIgnoreCase(date)) {
					//System.out.println("I am in loop");
			//	System.out.println("Going to select date as :: " + date );
				driver.findElement(By.xpath(".//td[@class='calendar_week_column']/following-sibling::td[contains(text(),'"+date+"')]")).click();
				}
				//CommonFunctions.pass(child, "Select Date Passed");

			} catch (Exception e) {

			//	CommonFunctions.fail(child, "Select Date Failed");
				throw e;
			}
			}
			
			

			
			CommonFunctions.pass(child, "Select Date Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Select Date Failed");
			throw e;
		}
	}
	
	public  int verifyResult(){
		try{
			Variables.elementWait(driver, 10,FetchData.readOR("check_Count"));
			if(	driver.findElement(By.id("search_result_display_array_content_div")).getText().contains("Searched Criteria +++ ")==true)
				return 0;
			else
				return 1;
			// driver.findElement(FetchData.readOR("CRF_clickSubmit")).click();
			
			
		}
		catch(Exception e){
			// Do nothing
		}
		return 0;
	}
	
	public void signOut(){
		 try{
				driver.findElement(FetchData.readOR("CLK_SignOut")).click();
						
				CommonFunctions.pass(child, "Click SignOut Passed");

			} catch (Exception e) {

				CommonFunctions.fail(child, "Click SignOut Failed");
				throw e;
			}
		 
	 }
	public void closeWindow(){
		try{
			driver.close();
			CommonFunctions.pass(child, "Close Window Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Close Window Failed");
			throw e;
		}
		
	}
	
	 

}
