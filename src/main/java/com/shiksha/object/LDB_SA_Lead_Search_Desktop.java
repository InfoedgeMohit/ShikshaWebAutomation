package com.shiksha.object;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;








import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class LDB_SA_Lead_Search_Desktop {
	
	WebDriver driver;
	ExtentTest child;
	
	public LDB_SA_Lead_Search_Desktop(WebDriver driver,ExtentTest child)
	{
		this.driver = driver;
		this.child = child;
	}
	
	CommonFunctions CommonFunctions = new CommonFunctions();
	
public void openEnterprise(String url,String aurl) throws Exception{
		
		try{
			Thread.sleep(1000);
			driver.get(url	+ aurl);
			CommonFunctions.pass(child, "Enterprise Login URL "+url+aurl+ " ->Passed");		
		}
		catch(Exception e) {
			CommonFunctions.fail(child, "Open Enterprise Login Page Failed");
			throw e;
		}
	}

	public void openSALeadSearchPanel(String url){
		try{
		driver.get(url+ "enterprise/enterpriseSearch/index");
		driver.get(url
				+ "enterprise/shikshaDB/index?course_name=Study Abroad&sa_course=MBA&sa_course_type=popular&show=true");
		CommonFunctions.pass(child, "Client Landing on Search Panel ->Passed");
		}
		catch(Exception e){
			CommonFunctions.fail(child, "Client Landing on Search Panel Failed");
			throw e;
		}
		
	}

	public void clickCalendar() throws Exception {
		try{
			Variables.elementWait(driver, 10,FetchData.readOR("click_Calendar_sa"));
			driver.findElement(FetchData.readOR("click_Calendar_sa")).click();
			 CommonFunctions.pass(child, "Click Calendar for selecting from date -> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Calendar for selecting from date Failed");
			throw e;
		}
	}  
	
	public void selectFromDate(String dd ,String  mm , String yy) throws Exception {
		try {
			Variables.elementWait(driver, 10,FetchData.readOR("click_Calendar_sa"));
			driver.findElement(FetchData.readOR("click_Calendar_sa")).click();
			String calYearText = driver.findElement(By.id("calendar_year_txt")).getText();	
			StringBuffer myBuffer = new StringBuffer(yy);
			String year = myBuffer.substring(0, 4);
			if(calYearText.equalsIgnoreCase(year)){
				System.out.println("True");
			}			
			driver.findElement(By.id("monthSelect")).click();
			//Thread.sleep(2000);
			Variables.elementWait(driver, 0,By.xpath(".//div[contains(text(),'"+mm+"') and contains(@id,'monthDiv')]"));
			driver.findElement(By.xpath(".//div[contains(text(),'"+mm+"') and contains(@id,'monthDiv')]")).click();
			Thread.sleep(2000);
			
			List<WebElement> allDates =  driver.findElements(By.xpath(".//td[@class='calendar_week_column']/following-sibling::td"));
			
			Thread.sleep(2000);

			 @SuppressWarnings("static-access")
			String date = CommonFunctions.getNumericValue(dd);

			
			for (int i=0 ; i<allDates.size();i++) {
			try {	
				if(allDates.get(i).getText().equalsIgnoreCase(date)) {
					driver.findElement(By.xpath(".//td[@class='calendar_week_column']/following-sibling::td[contains(text(),'"+date+"')]")).click();
				}
				//CommonFunctions.pass(child, "Select Date Passed");

			} catch (Exception e) {

			//	CommonFunctions.fail(child, "Select Date Failed");
				throw e;
			}
			}
			CommonFunctions.pass(child, "Select From Date,"+dd+mm+yy +"-> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Select From Date Failed");
			throw e;
		}
	}
	
	
	public void clickCalendarTo() throws Exception {
		try{
			Variables.elementWait(driver, 10,FetchData.readOR("click_CalendarTo"));
			driver.findElement(FetchData.readOR("click_CalendarTo")).click();
			 CommonFunctions.pass(child, "Click Calendar To Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Calendar To Failed");
			throw e;
		}
	}
	
	
	
	public void pickDate() throws Exception{
		try{
			// driver.findElement(FetchData.readOR("move_PreviousMonth")).click();
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
