package com.shiksha.object;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;

public class CTA_Desktop {

	WebDriver driver;
	ExtentTest child;

	public CTA_Desktop(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;
	}

	CommonFunctions CommonFunction = new CommonFunctions();


	public void cityWantToStudy() 
	{
		try 
		{
			System.out.println("Going to Enter City where User Want to Study");
			if(driver.findElements(FetchData.readOR("ResponseForm_City_Xpath1")).size() >0) {
				driver.findElement(FetchData.readOR("ResponseForm_City_Xpath2")).click();
				List<WebElement> PrefcityList = driver.findElements(FetchData.readOR("ResponseForm_City_Xpath3"));
				PrefcityList.get(0).click();
				CommonFunctions.elementWait(driver, 5, FetchData.readOR("ResponseForm_NearestCenter_Xpath1"));
				System.out.println("City has been selected where user want to study");
				CommonFunction.pass(child, "City has been selected");
			}
		}
		catch (Exception e) {
			//CommonFunction.fail(child, "City has not been selected");
		}
	}


	public void selectNearestCenter() {
		try {
			System.out.println("Going to select center");
			if(driver.findElements(FetchData.readOR("ResponseForm_NearestCenter_Xpath1")).size() >0) {
				driver.findElement(FetchData.readOR("ResponseForm_NearestCenter_Xpath2")).click();
				System.out.println("centerDropDown has been opened");

				List<WebElement> centerList = driver.findElements(FetchData.readOR("ResponseForm_NearestCenter_Xpath3"));
				int centerlistSize = centerList.size();
				centerList.get(centerlistSize-2).click();
				CommonFunctions.elementWait(driver, 5, FetchData.readOR("ResponseForm_CourseDropDown_Xpath1"));
				CommonFunction.pass(child, "Center has been selected");
			}
		}
		catch (Exception e) {
			//CommonFunction.fail(child, "Center has not been selected");
		}
	}


	public void selectCourse() 
	{	
		try
		{
			if(driver.findElements(FetchData.readOR("ResponseForm_CourseDropDown_Xpath1")).size() > 0) {
				if (driver.findElement(FetchData.readOR("ResponseForm_CourseDropDown_Xpath1")) != null) {
					System.out.println("Going to select course");
					driver.findElement(FetchData.readOR("ResponseForm_CourseDropDown_Xpath3")).click();
					List<WebElement> allCourses = driver.findElements(FetchData.readOR("ResponseForm_CourseDropDown_Xpath4"));
					// Xpath for course : .//div[@class='cusLayer ctmScroll layerHtml']//ul//li/ul/li/span
					allCourses.get(0).click();
					CommonFunctions.elementWait(driver, 5, FetchData.readOR("ResponseForm_ExperienceField_Xpath1"));
					CommonFunction.pass(child, "Course has been selected");
				}
			}
			else {
				CommonFunction.info(child, "Course Field is not there on the form ");
			}
		}
		catch(Exception e)
		{
			//CommonFunction.fail(child, "Course has not been selected");
		}
	}


	public void selectExperience() 
	{	
		System.out.println("Going to select experience");
		try
		{
			if (driver.findElements(FetchData.readOR("ResponseForm_ExperienceField_Xpath1")).size() >0) {
				driver.findElement(FetchData.readOR("ResponseForm_ExperienceField_Xpath2")).click();
				System.out.println("Experience List has been opened");
				CommonFunctions.elementWait(driver,15,FetchData.readOR("ResponseForm_ExperienceField_Xpath3"));
				List<WebElement>  ExpList = driver.findElements(FetchData.readOR("ResponseForm_ExperienceField_Xpath3"));
				ExpList.get(0).click();
				CommonFunctions.elementWait(driver, 15, FetchData.readOR("ResponseForm_ExamTakenVisibleKey"));
				CommonFunction.pass(child, "Experience Field has been selected");
			}
			else {
				System.out.println("Experience Field is not there");
				CommonFunction.info(child, "Experience Field is not there");
			}
		}
		catch(Exception e)
		{
		}
	}


	public void selectExamsTaken() {
		try {
			if(driver.findElements(FetchData.readOR("ResponseForm_ExamTaken_Xpath1")).size() >0) {
				if(driver.findElement(FetchData.readOR("ResponseForm_ExamTaken_Xpath2")) != null) {
					System.out.println("Going to select exam");
					driver.findElement(FetchData.readOR("ResponseForm_ExamTaken_Xpath3")).click();
					List <WebElement> listExams = driver.findElements(FetchData.readOR("ResponseForm_ExamTaken_Xpath4"));
					listExams.get(0).click();
					driver.findElement(FetchData.readOR("ResponseForm_ExamTaken_Xpath5")).click();
					CommonFunctions.elementWait(driver,5,FetchData.readOR("ResponseForm_Email"));
					CommonFunction.pass(child, "Exam has been selected");
				}
			}
			else {
				CommonFunction.info(child, "Exam Field is not there on the form");
			}
		}
		catch(Exception e)
		{
			//CommonFunction.fail(child, "Exam has not been selected");
		}
	}


	public void enterEmailID(String User_email) 
	{

		System.out.println("going to enter email");
		try 
		{
			driver.findElement(FetchData.readOR("ResponseForm_Email")).sendKeys(User_email);
			CommonFunction.pass(child, "Email as " + User_email +  " has been entered");
		}
		catch(Exception e)
		{
			//CommonFunction.fail(child, "Email as " + User_email +  " has not been entered");
		}
	}


	public void enterPassword(String password) 
	{
		try {
			System.out.println("going to enter password");
			driver.findElement(FetchData.readOR("ResponseForm_Password")).sendKeys(password);
			CommonFunctions.elementWait(driver, 2, FetchData.readOR("ResponseForm_FirstName"));
			CommonFunction.pass(child, "Password as " + password + " has been entered");
		}
		catch (Exception e) {
			//CommonFunction.fail(child, "Password as " + password + " has not been entered");
		}
	}


	public void enterFirstName(String firstName) 
	{

		System.out.println("going to enter firstName");
		try 
		{
			driver.findElement(FetchData.readOR("ResponseForm_FirstName")).sendKeys(firstName);
			CommonFunctions.elementWait(driver, 2, FetchData.readOR("ResponseForm_LastName"));
			CommonFunction.pass(child, "FirstName as " + firstName + " has been entered");
		}
		catch(Exception e)
		{
			//CommonFunction.fail(child, "FirstName as " + firstName + " has not been entered");
		}
	}


	public void enterLastName(String lastName) throws Exception
	{

		System.out.println("going to enter lastName");
		try 
		{
			driver.findElement(FetchData.readOR("ResponseForm_LastName")).sendKeys(lastName);
			CommonFunctions.elementWait(driver, 2, FetchData.readOR("ResponseForm_Mobile"));
			CommonFunction.pass(child, "LastName as " + lastName + " has been entered");
		}
		catch(Exception e)
		{
			//CommonFunction.fail(child, "LastName as " + lastName + " has not been entered");
		}
	}


	public void enterMobile(String mobile) throws Exception
	{
		System.out.println("going to enter mobile");
		try 
		{
			driver.findElement(FetchData.readOR("ResponseForm_Mobile")).sendKeys(mobile);
			CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("cityDropDown")), driver);
			CommonFunctions.elementWait(driver, 2, FetchData.readOR("cityDropDown"));
			CommonFunction.pass(child, "Mobile as " + mobile + " has been entered");
		}
		catch(Exception e)
		{
			//CommonFunction.fail(child, "Mobile as " + mobile + " has not been entered");
		}
	}


	public void selectCity(String city,String locality) throws Exception
	{	
		System.out.println("Going to select city ->" + city);
		try
		{
			// Checking whether city drop-down is there or not :
			if(driver.findElements(FetchData.readOR("cityDropDown")).size() >0) {
				//Clicking City drop-down
				driver.findElement(FetchData.readOR("cityDropDown")).click();
				// Waiting for Drop-down to display
				CommonFunctions.elementWait(driver, 15,By.xpath(".//span[contains(text(),'Popular')]"));
				// Selecting City
				driver.findElement(By.xpath(".//ul[@class='staCty-Sblyr']//span[starts-with(text(),'"+city+"')]")).click();
				// Waiting for city to get selected
				CommonFunctions.elementWait(driver, 15, By.xpath(".//div[@label='City']//div[contains(text(),'"+city+"')]"));
			}
			if (driver.findElements(By.xpath(".//div[@layerfor='residenceLocality']/div[2]")).size()>0) {
				System.out.println("Going to select localityName, if for city =>" + city);
				driver.findElement(By.xpath(".//div[@layerfor='residenceLocality']/div[2]")).click();
				if(driver.findElement(By.xpath(".//div[@layerfor='residenceLocality']/div[2]")) != null) {
					List<WebElement> localityList = driver.findElements(By.xpath(".//ul[@class='staCty-Sblyr']/li"));
					int j =0;
					for (int k=0; k<localityList.size();k++) {
						if(localityList.get(k).getText().equalsIgnoreCase(locality)) {
							localityList.get(k).click();
							CommonFunctions.elementWait(driver, 5, FetchData.readOR("ResponseForm_Mobile"));
							j=0;
							break;
						}else {
							j++;
						}
					}
					if(j>0) {
						System.out.println("Locality list is not there for this city =>" + city);
					}
				}
			}
			CommonFunction.pass(child, "City as " + city + " has been selected ");
		}
		catch(Exception e)
		{
			//CommonFunction.fail(child, "City as " + city + " has not been selected ");
		}
	}

	public void clickSubmit(String CTAtype)
	{
		System.out.println("Going to click submit button for " + CTAtype.toUpperCase());

		try 
		{
			if(CTAtype.equalsIgnoreCase("DEB") || CTAtype.equalsIgnoreCase("AskNow")) {
				if(driver.findElements(FetchData.readOR("ResponseForm_Submit_Xpath1")).size()>0) {
					driver.findElement(FetchData.readOR("ResponseForm_Submit_Xpath2")).click();
					System.out.println("Yieeeeee----- Submit button for " + " " + CTAtype.toUpperCase() + "  " + "has been clicked");
					CommonFunctions.elementWait(driver, 4, FetchData.readOR("ResponseForm_RecoLayer_getText1"));
				}
				else if (driver.findElements(FetchData.readOR("ResponseForm_Submit_Xpath3")).size()>0) {
					driver.findElement(FetchData.readOR("ResponseForm_Submit_Xpath4")).click();
					CommonFunctions.elementWait(driver, 4, FetchData.readOR("ResponseForm_RecoLayer_getText1"));
				}
			}
			else if (CTAtype.equalsIgnoreCase("SCD")) {
				driver.findElement(FetchData.readOR("ResponseForm_Submit_Xpath5")).click();
				System.out.println("Yieeeeee----- Submit button for " + " " + CTAtype.toUpperCase() + "  " + "has been clicked");
				CommonFunctions.elementWait(driver, 4, FetchData.readOR("ResponseForm_RecoLayer_getText1"));
			}

			else if (CTAtype.equalsIgnoreCase("shortlist")) {
				driver.findElement(FetchData.readOR("ResponseForm_Submit_Xpath6")).click();
				System.out.println("Yieeeeee----- Submit button for " + " " + CTAtype.toUpperCase() + "  " + "has been clicked");
				CommonFunctions.elementWait(driver, 4, FetchData.readOR("ResponseForm_RecoLayer_getText1"));
			}

			else {
				driver.findElement(FetchData.readOR("ResponseForm_Submit_Xpath7")).click();
				System.out.println("Yieeeeee----- Submit button for " + " " + CTAtype.toUpperCase() + "  " + "has been clicked");
				CommonFunctions.elementWait(driver, 4, FetchData.readOR("ResponseForm_RecoLayer_getText1"));
			}
			CommonFunction.pass(child, "Form has been submitted");
		}
		catch(Exception e)
		{
			//CommonFunction.fail(child, "Form has not been submitted");
		}
	}


	public void getText(String cta)
	{
		try 
		{
			if (cta.equalsIgnoreCase("DEB")) {
				System.out.println("Reco Layer for DEB is about to come");
				if (driver.findElements(FetchData.readOR("ResponseForm_RecoLayer_getText1")).size()>0) {
					System.out.println("Download Brochure is successful");
				}
				else 
				{
					System.out.println("DOWNLOAD BROCHURE is not succcessful");
				}
			}

			else if (cta.equalsIgnoreCase("shortlist")) {
				System.out.println("Reco Layer for shortlist is about to come");
				if (driver.findElement(FetchData.readOR("ResponseForm_RecoLayer_getText2")) != null) {
					System.out.println("Shortlist is Successful");
				}
				else 
				{
					System.out.println("SHORTLIST is not succcessful");
				}
			}
			CommonFunction.pass(child, "Action as " + cta + " is successfull.");
		}

		catch(Exception e)
		{
			//CommonFunction.fail(child, "Action as " + cta + " is not successfull.");
		}
	}


	public void clickShortlistOnRecoLayer(String page) throws Exception 
	{
		try 
		{
			System.out.println("Going to click on shortlist button");

			driver.findElement(FetchData.readOR("ResponseForm_recoLayer_ShortlistClick")).click();
			Thread.sleep(3000);
			WebElement e1 = driver.findElement(FetchData.readOR("ResponseForm_recoLayer_ShortlistClick2"));
			if (e1 != null) {
				System.out.println("Shortlist on Reco Layer is done");
				CommonFunction.pass(child, "Shortlist on Reco Layer is done");
			}
			else {
				System.out.println("Shortlist on reco layer is not done");
				//CommonFunction.fail(child, "Shortlist on reco layer is not done");
			}
			//			driver.findElement(By.xpath("(.//*[@class='category_shortlist']//span)[1]")).click();
			//			Thread.sleep(3000);
			//			if (driver.findElement(By.xpath(".//a[@class='category_shortlist']//span[contains(text(),'Shortlisted')]")) != null) {
			//				System.out.println("Shortlist on Reco Layer is done");
			//				CommonFunction.pass(child, "Shortlist on Reco Layer is done");
			//			}
			//			else {
			//				System.out.println("SHORTLIST on reco layer is not done");
			//				//CommonFunction.fail(child, "Shortlist on reco layer is not done");
			//			}
			//			}
		}
		catch (Exception e)
		{
			//CommonFunction.fail(child, "Shortlist on reco layer is not done");
		}
	}


	public void clickDownloadBrochureOnRecoLayer(String page) throws Exception 
	{
		try 
		{
			Thread.sleep(2000);

			System.out.println("Going to click on DEB button on reco layer");

			if (page=="CTP") {
				driver.findElement(FetchData.readOR("ResponseForm_recoLayer_ResponseClick1")).click();
				Thread.sleep(3000);
				WebElement el1 = driver.findElement(FetchData.readOR("ResponseForm_recoLayer_ResponseClick2"));
				WebElement el2 = el1.findElement(FetchData.readOR("ResponseForm_recoLayer_ResponseClick3"));

				if(el2 != null) {
					System.out.println("Brochure Downloaded on Reco Layer");
					CommonFunction.pass(child, "Brochure successfully downloaded on Reco Layer");
				}
				else {
					System.out.println("Brochure Not downloaded on reco layer");
					//CommonFunction.fail(child, "Brochure not downloaded on reco layer");
				}
			}

			else {
				driver.findElement(FetchData.readOR("ResponseForm_recoLayer_ResponseClick4")).click();
				Thread.sleep(4000);
				//			waitForElement(driver, "(.//p[@class='success-msg'][contains(text(),'Brochure successfully mailed')])[1]");
				//			WebElement tuple1 = driver.findElement(By.xpath("(.//section[@class='tpl-curse-dtls'])[1]"));
				//			tuple1.findElement(By.xpath(".//p[contains(text(),'Brochure successfully mailed')]"));

				if (driver.findElement(FetchData.readOR("ResponseForm_recoLayer_ResponseClick5")).isDisplayed()) {
					System.out.println("Brochure Downloaded on Reco Layer");
					CommonFunction.pass(child, "Brochure Downloaded on Reco Layer");
				}
				else {
					System.err.println("Download Brochure on Reco Layer is not done");
					//CommonFunction.fail(child, "There is an error while Downloading Brochure on Reco Layer");
				}
			}
		}
		catch (Exception e)
		{
			CommonFunction.pass(child,"DEB on reco layer is not done");
		}
	}



	public void clickCompareOnRecoLayer(String ctaType,String page) 
	{
		try 
		{
			Thread.sleep(2000);
			driver.findElement(FetchData.readOR("ResponseForm_RecoLayer_CompareClick1")).click();
			if(driver.findElement(FetchData.readOR("ResponseForm_RecoLayer_CompareClick2")) != null) {
				System.out.println("Compare checkbox has been checked on Reco Layer");
				CommonFunction.pass(child, "Compare checkbox has been checked on Reco Layer");
			}
			else {
				System.out.println("Compare checkbox has not been checked on Reco Layer");
				//CommonFunction.fail(child, "Compare checkbox has been checked on Reco Layer");
			}
		}
		catch (Exception e)
		{
			//CommonFunction.fail(child, "Click on Compare button on Reco layer is not done");
		}
	}


	public void closeRecoLayer() throws Exception 
	{
		try 
		{
			Thread.sleep(2000);
			System.out.println("Going to close Reco Layer");
			driver.findElement(FetchData.readOR("ResponseForm_recoLayer_Close1")).click();
			Thread.sleep(4000);

			if(driver.findElements(FetchData.readOR("ResponseForm_recoLayer_Close2")).size()>0) {
				System.out.println("Minimizing compare bottom sticky layer");
				Thread.sleep(2000);
				driver.findElement(FetchData.readOR("ResponseForm_recoLayer_Close3")).click();
			}

			List<WebElement> comparedCourses = driver.findElements(FetchData.readOR("ResponseForm_recoLayer_Close4"));
			if(comparedCourses.size()==4) {
				System.out.println("Compare Sticky Tray is full. So, making this tray empty");
				Thread.sleep(2000);
				driver.findElement(FetchData.readOR("ResponseForm_recoLayer_Close5")).click();
			}
			CommonFunction.pass(child, "Reco layer has been closed");
		}
		catch (Exception e)
		{
			//CommonFunction.fail(child, "Reco Layer has not been closed");
		}
	}

	public int Category_Page_More() throws Exception{
		CommonFunction.scrollToElementUsingWebElement(driver.findElement(FetchData.readOR("categoryPage_more_1")), driver);
		Thread.sleep(2000);
		WebElement e1 = driver.findElement(FetchData.readOR("categoryPage_more_2"));
		Thread.sleep(2000);
		String collegeIdOfMoreCourseButton = e1.getAttribute("instid");
		int collegeIdOfMoreCourseButtonUpdated = Integer.parseInt(collegeIdOfMoreCourseButton);
		System.out.println("College Id of tuple for which + more course is being displayed --> " + collegeIdOfMoreCourseButtonUpdated);
		Thread.sleep(2000);
		driver.findElement(FetchData.readOR("categoryPage_more_3")).click();
		return collegeIdOfMoreCourseButtonUpdated;
	}
	
	
}
