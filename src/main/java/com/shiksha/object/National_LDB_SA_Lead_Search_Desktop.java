package com.shiksha.object;

import org.openqa.selenium.WebDriver;








import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class National_LDB_SA_Lead_Search_Desktop {
	
	WebDriver driver;
	ExtentTest child;
	
	public National_LDB_SA_Lead_Search_Desktop(WebDriver driver,ExtentTest child)
	{
		this.driver = driver;
		this.child = child;
	}
	
	CommonFunctions CommonFunctions = new CommonFunctions();
	


	public void clickCalendar() throws Exception {
		try{
			Variables.elementWait(driver, 10,FetchData.readOR("click_Calendar_sa"));
			driver.findElement(FetchData.readOR("click_Calendar_sa")).click();
			 CommonFunctions.pass(child, "Click Calendar From Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Calendar From Failed");
			throw e;
		}
	}  
	
	public void clickCalendarTo() throws Exception {
		try{
			Variables.elementWait(driver, 10,FetchData.readOR("click_CalendarTo"));
			driver.findElement(FetchData.readOR("click_CalendarTo")).click();
		//	System.out.println("Click To Date");
			 CommonFunctions.pass(child, "Click Calendar To Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Calendar To Failed");
			throw e;
		}
	}
	
	
	
	public void pickDate() throws Exception{
		try{
			driver.findElement(FetchData.readOR("move_PreviousMonth")).click();
			driver.findElement(FetchData.readOR("pick_Date")).click();
			 CommonFunctions.pass(child, "Click Date Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Date Failed");
			throw e;
		}
	}
	
	public void clickSearch() throws Exception {
		try{
			driver.findElement(FetchData.readOR("click_Search_sa_search")).click();
			Variables.elementWait(driver, 10,FetchData.readOR("check_Count"));
			 CommonFunctions.pass(child, "Click Search Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Search Failed");
			throw e;
		}
	}
	// Create a Genie
	public void verifyCount()throws Exception {
		try{
			
			System.out.println("Total Count Appearing : "+driver.findElement(FetchData.readOR("check_Count")).getText());
			 CommonFunctions.pass(child, "Verify Count Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Verify Count Failed");
			throw e;
		}
	}
	
	
	
	
	public void signOut() throws Exception {
		 try{
				driver.findElement(FetchData.readOR("CLK_SignOut")).click();
						
				 CommonFunctions.pass(child, "enter Client Email Passed");

			} catch (Exception e) {

				CommonFunctions.fail(child, "enter Client Email Failed");
				throw e;
			}
		 
	 }
	
	public void closeWindow(){
		try{
			driver.close();
		}
		
		catch(Exception e){
			// Do nothing
		}
		
	}
	 

}
