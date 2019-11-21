package com.shiksha.object;

import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
// import com.shiksha.resourses.Generic_Methods;
import com.shiksha.resourses.Variables;


public class National_ReviewPosting_Desktop {


	WebDriver driver;
	ExtentTest child;

	public National_ReviewPosting_Desktop(WebDriver driver,ExtentTest child) {
		this.driver = driver;
		this.child = child;
	}

	CommonFunctions CommonFunctions = new CommonFunctions();
	
	public void openReviewPostingForm(String url,String aurl) throws Exception{
		
		try{
			Thread.sleep(1000);
			driver.get(url	+ aurl);
			CommonFunctions.pass(child, "URL to Open Collge Review Form "+url+aurl+ " ->Passed");		
		}
		catch(Exception e) {
			CommonFunctions.fail(child, "URL to open College Review form Failed");
			throw e;
		}
	}
	
	
	

	public void typeInstituteName(String strInstName)throws Exception
	{	
		try
		{
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("CRF_Institute")).sendKeys(strInstName);
			CommonFunctions.pass(child, "Type initials of Institute Name as "+"'"+strInstName+"'"+" -> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "TypeInstituteName Failed");
			throw e;
		}
	}



	public void selectInstitute() throws Exception{
		try{
			Thread.sleep(1000);
			List<WebElement> autotext = driver.findElements(By.className("suggestion-box-normal-option"));
			String instName=autotext.get(2).getText();
			autotext.get(2).click();
			
			//System.out.println(autotext.get(2).getText());
			CommonFunctions.pass(child, "Select second Institute from Auto Suggester, '"+instName+"' Selected -> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "select Institute Failed");
			throw e;
		}
	}


	public void selectCourse()throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR("CRF_selectCourse"));
			WebElement we =   driver.findElement(FetchData.readOR("CRF_selectCourse"));
			Select se=new Select(we);
			se.selectByIndex(1);
			WebElement option = se.getFirstSelectedOption();
			String courseName= option.getText();
			CommonFunctions.pass(child, "Select Course from course dropdown,'"+courseName+"' Selected -> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Select Course Failed");
			throw e;
		}
	}

	public void selectYear()throws Exception{
		try{
			WebElement we =   driver.findElement(FetchData.readOR("CRF_selectYear"));
			Select se=new Select(we);
			se.selectByIndex(1);
			WebElement option = se.getFirstSelectedOption();
			String year= option.getText();
			//se.selectByVisibleText("B.Des. in Fashion Design");
			CommonFunctions.pass(child, "Select year from dropdown,'"+year+"' Selected -> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Select Year Failed");
			throw e;
		}
	}

	public void enterPlacement(String Placement)throws Exception{
		try{
			
			driver.findElement(FetchData.readOR("CRF_enterPlacement")).sendKeys(Placement);;

			CommonFunctions.pass(child, "Enter Placement description -> Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "enter Placement Failed");
			throw e;
		}
	}

	public void enterInfra(String Infra)throws Exception{
		try{
			
			driver.findElement(FetchData.readOR("CRF_enterInfra")).sendKeys(Infra);;
			CommonFunctions.pass(child, "Enter Infrastructure description ->Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Enter Infra Failed");
			throw e;
		}
	}

	public void enterFaculty(String Faculty)throws Exception{
		try{
			driver.findElement(FetchData.readOR("CRF_enterFaculty")).sendKeys(Faculty);;
			CommonFunctions.pass(child, "Enter Faculty description -> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Enter Faculty Failed");
			throw e;
		}
	}

	public void enterOther(String Other)throws Exception{
		try{
			driver.findElement(FetchData.readOR("CRF_enterOther")).sendKeys(Other);
			CommonFunctions.pass(child, "Enter Other Details -> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Enter Other Details Failed");
			throw e;
		}
	}

	public void enterTitle(String Title)throws Exception{
		try{

			driver.findElement(FetchData.readOR("CRF_enterTitle")).sendKeys(Title);
			CommonFunctions.pass(child, "Enter Title  as 'College Review form on Desktop' -> Passed");

		} catch (Exception e) {

			CommonFunctions.fail(child, "Enter title Failed");
			throw e;
		}
	}

	public void selectRating()throws Exception{
		try{

			CommonFunctions.scrollToElementUsingWebElement(driver.findElement(By.id("1_3")), driver);
			CommonFunctions.scroljl_Above(driver);

			driver.findElement(By.id("1_3")).click();
			driver.findElement(By.id("2_3")).click();
			if(driver.findElement(By.id("3_3")).isDisplayed()==true){
				driver.findElement(By.id("3_4")).click();
			}

			if(driver.findElement(By.id("4_3")).isDisplayed()==true){
				driver.findElement(By.id("4_3")).click();
			}


			if(driver.findElement(By.id("5_3")).isDisplayed()==true){
				driver.findElement(By.id("5_3")).click();
			}


			if(driver.findElements(By.id("6_3")).size()>0){
				driver.findElement(By.id("6_3")).click();
				System.out.println("6th selected");
			}

			CommonFunctions.pass(child, "Select Rating using star parameters->Passed");			
		} catch (Exception e) {
			CommonFunctions.fail(child, "Select Rating Failed");
			throw e;
		}
	} 


	public void selectRecommend()throws Exception{
		try{
			// Thread.sleep(1000);
			driver.findElement(FetchData.readOR("CRF_selectRecommend")).click();
			CommonFunctions.pass(child, "Select Recommend Institute from radio button as Yes -> Passed");
			Thread.sleep(1000);
		} catch (Exception e) {
			CommonFunctions.fail(child, "Select Recommend Failed");
			throw e;
		}
	}

	public void enterFname(String fname)throws Exception{
		try{

			driver.findElement(FetchData.readOR("CRF_enterFname")).sendKeys(fname);
			//System.out.println("First Name entered");

			CommonFunctions.pass(child, "Enter First Name as ->"+fname+" -> Passed");		
		} catch (Exception e) {
			System.out.println("I am in Catch Block");
			CommonFunctions.fail(child, "Enter first Name Failed");
			throw e;
		}
	}

	public void enterLname(String lname)throws Exception{
		try{
			//Variables.elementWait(driver, 0,FetchData.readOR("CRF_enterLname"));
			driver.findElement(FetchData.readOR("CRF_enterLname")).sendKeys(lname);
			CommonFunctions.pass(child, "Enter Last Name as ->"+lname+" -> Passed");	

		} catch (Exception e) {

			CommonFunctions.fail(child, "Enter Last Name-> Failed");
			throw e;
		}
	}


	
	public void enterEmail()throws Exception{
		try{
			String email=CommonFunctions.RandomEmail("alimtest");
			driver.findElement(FetchData.readOR("CRF_enterEmail")).sendKeys(email);

			CommonFunctions.pass(child, "Enter Email as "+email+"-> Passed");			
		} catch (Exception e) {

			CommonFunctions.fail(child, "Enter Email Failed");
			throw e;
		}
	}
	


	public void enterSocial(String social)throws Exception{
		try{
			//Variables.elementWait(driver, 0,FetchData.readOR("CRF_enterSocial"));
			driver.findElement(FetchData.readOR("CRF_enterSocial")).sendKeys(social);

			CommonFunctions.pass(child, "Enter Social Profile URL as "+social+" -> Passed");		
		} catch (Exception e) {

			CommonFunctions.fail(child, "Enter Social Profile URL Failed");
			throw e;
		}
	}

	public void enterMobile()throws Exception{
		try{
			Random rnd = new Random();
			int n = rnd.nextInt(900000);
			String mobile="9700"+(n+100000);
			// System.out.println("Mobile ->"+mobile);
			driver.findElement(FetchData.readOR("CRF_enterMobile")).sendKeys(mobile);
			CommonFunctions.pass(child, "Enter Mobile number as "+mobile+" ->Passed");	
			

		} catch (Exception e) {

			CommonFunctions.fail(child, "enter Mobile Failed");
			throw e;
		}
	}

	public void clickSubmit()throws Exception{
		try{
			Variables.elementWait(driver, 0,FetchData.readOR("CRF_clickSubmit"));
			driver.findElement(FetchData.readOR("CRF_clickSubmit")).click();

			CommonFunctions.pass(child, "Click Submit button -> Passed");		
		} catch (Exception e) {

			CommonFunctions.fail(child, "Click Submit Failed");
			throw e;
		}
	}
	public  void verifyThankyou(String fname)throws Exception{
		try{
			//Thread.sleep(10000);
			Variables.elementWait(driver, 0,By.id("userFirstName"));
			if(driver.findElement(By.id("userFirstName")).getText().equals(fname))
			CommonFunctions.pass(child, "Thank You layer Appeared -> Passed");
			else
				CommonFunctions.fail(child, "Thank You layer ->Failed");
				
		} catch (Exception e) {

			CommonFunctions.fail(child, "Thank You layer Failed");
			throw e;
		}
	}


	public void clickNext() throws Exception{
		try{
			Thread.sleep(1000);
			driver.findElement(FetchData.readOR("CRF_clickSubmitMob")).click();


		} catch (Exception e) {

			CommonFunctions.fail(child, "\typeInstituteName Failed");
			throw e;
		}
	}

	public boolean fun_selectListValues(String fieldName, List<WebElement> traverseList, String dataVal,
			WebDriver driver) throws Exception{
		boolean fnselectlistFlag = false;
		try {
			System.out.println(2);
			System.out.println(traverseList.size() );
			if (traverseList.size() != 0)
				for (int i = 0; i < traverseList.size(); i++) {
					System.out.println(3);
					if (dataVal.trim().equalsIgnoreCase(traverseList.get(i).getAttribute("title").trim())) {
						System.out.println(4);
						WebDriverWait wt = new WebDriverWait(driver, 10);
						wt.until(ExpectedConditions.elementToBeClickable(traverseList.get(i)));
						traverseList.get(i).click();
						fnselectlistFlag = true;
						System.out.println(15);
						break;

					}
				}
		} catch (Exception e) {

			CommonFunctions.fail(child, "\typeInstituteName Failed");
			throw e;
		}

		return fnselectlistFlag;
	}


}
