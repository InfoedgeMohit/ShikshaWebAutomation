package com.shiksha.object;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.Database;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.Variables;

public class SA_CTA_Mobile_Object {
	WebDriver driver;
	ExtentTest child;
	CommonFunctions CommonFunctions = new CommonFunctions();
	GenericFunction per;

	public SA_CTA_Mobile_Object(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;
		
	}	

	public SA_CTA_Mobile_Object(WebDriver driver) {
		this.driver = driver;
		
		per=new GenericFunction(driver);
	}	

	public void clickSignUp() throws Exception {
		try {
			Thread.sleep(3000);;
			Variables.elementWait(driver, 50, FetchData.readOR("signup_Mobile"));
			driver.findElement(FetchData.readOR("signup_Mobile")).click();
			CommonFunctions.pass(child, "Click on Signup Widget Passed");
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on Signup Widget Failed");
			throw e;
		}

	}
	
	public void header_Signup() throws Exception {
		try {
			String expectedMessage = "Register to get started";
			String message = driver.findElement(
					FetchData.readOR("Mobileheader_Signup")).getText();
			if (message.contains(expectedMessage)) {
				
				CommonFunctions.pass(child, "header_Signup Passed");
			} else {
				
				CommonFunctions.fail(child, "header_Signup Failed");
			}

		}
		catch (Exception e) {

			throw e;
		}
	}
	
	
		public void PersonalInfo_Section(String fname, String lname, String mobnumber)
				throws Exception {
			try {
				String t = new SimpleDateFormat("yyyyMMddHHmmss")
						.format(new Timestamp(System.currentTimeMillis()));
				String email1 = "test_" + t + "@gmail.com";
				driver.findElement(FetchData.readOR("Mobileemail")).sendKeys(email1);
				Variables.elementWait(driver, 10, FetchData.readOR("Mobilenumber"));
				driver.findElement(FetchData.readOR("Mobilenumber")).sendKeys(mobnumber);
				Variables.elementWait(driver, 10, FetchData.readOR("Mobilefirstname"));
				driver.findElement(FetchData.readOR("Mobilefirstname")).sendKeys(fname);
				Variables.elementWait(driver, 10, FetchData.readOR("Mobilelastname"));
				driver.findElement(FetchData.readOR("Mobilelastname")).sendKeys(lname);
				CommonFunctions.pass(child, "PersonalInfo_Section Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "PersonalInfo_Section Failed");
				throw e;
			}
		}
		
		
		public void PersonalInfo_Section_International(String fname, String lname, String mobnumber)
				throws Exception {
			try {
				String t = new SimpleDateFormat("yyyyMMddHHmmss")
						.format(new Timestamp(System.currentTimeMillis()));
				String email1 = "test_" + t + "@gmail.com";
				driver.findElement(FetchData.readOR("Mobileemail")).sendKeys(email1);
				Variables.elementWait(driver, 10, FetchData.readOR("MobileCountry_dropdown"));
				driver.findElement(FetchData.readOR("MobileCountry_dropdown")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("MobileInternational_country"));
				driver.findElement(FetchData.readOR("MobileInternational_country")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("Mobilenumber"));
				driver.findElement(FetchData.readOR("Mobilenumber")).sendKeys(mobnumber);
				Variables.elementWait(driver, 10, FetchData.readOR("Mobilefirstname"));
				driver.findElement(FetchData.readOR("Mobilefirstname")).sendKeys(fname);
				Variables.elementWait(driver, 10, FetchData.readOR("Mobilelastname"));
				driver.findElement(FetchData.readOR("Mobilelastname")).sendKeys(lname);
				CommonFunctions.pass(child, "PersonalInfo_Section_International Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "PersonalInfo_Section_International Failed");
				throw e;
			}
		}
		
		
		public void planradiobutton() throws Exception {
			try {
				Thread.sleep(2000);
				Variables.elementWait(driver, 10, FetchData.readOR("Mobileplanradiobutton"));
				driver.findElement(FetchData.readOR("Mobileplanradiobutton")).click();
				CommonFunctions.pass(child, "Click on planradiobutton Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "Click on planradiobutton Failed");
				throw e;
			}
		}
		
		
		public void City()
				throws Exception {
			try {
				driver.findElement(FetchData.readOR("Mobilecityfield")).click();
				Thread.sleep(2000);
				Variables.elementWait(driver, 50, FetchData.readOR("Mobilecity"));
				driver.findElement(FetchData.readOR("Mobilecity")).click();
				CommonFunctions.pass(child, "City Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "City Failed");
				throw e;
			}
		}

		public void countries() throws Exception {
			try {
				Variables.elementWait(driver, 10, FetchData.readOR("Mobilecountry"));
				driver.findElement(FetchData.readOR("Mobilecountry")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("Mobilecountryselection1"));
				driver.findElement(FetchData.readOR("Mobilecountryselection1")).click();
				driver.findElement(FetchData.readOR("Mobilecountry")).click();
				CommonFunctions.pass(child, "countries selection Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "countries selection Failed");
				throw e;	
			}
			}
		
		public void Courseselection() throws Exception
		{
			try {
		
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();",
				driver.findElement(FetchData.readOR("MobileMaster_Course")));
		Variables.elementWait(driver, 20, FetchData.readOR("MobileMaster_Course"));
		driver.findElement(FetchData.readOR("MobileMaster_Course")).click();
	
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();",
					driver.findElement(FetchData.readOR("MobileMasterCourse_Selection")));
		Variables.elementWait(driver, 30, FetchData.readOR("MobileMasterCourse_Selection"));
		driver.findElement(FetchData.readOR("MobileMasterCourse_Selection")).click();
		CommonFunctions.pass(child, "Courseselection Passed");
		} catch (Exception e) {

			CommonFunctions.fail(child, "Courseselection Failed");
			throw e;
		}
	}


		public void MasterDetails() throws Exception {
			try {
				
				Variables.elementWait(driver, 20, FetchData.readOR("MobileGraduation_Stream"));
				driver.findElement(FetchData.readOR("MobileGraduation_Stream")).click();
				Variables.elementWait(driver, 20, FetchData.readOR("MobileStreamSelection"));
				driver.findElement(FetchData.readOR("MobileStreamSelection")).click();
				
				Variables.elementWait(driver, 10, FetchData.readOR("MobileGraduation_Percentage"));
				driver.findElement(FetchData.readOR("MobileGraduation_Percentage"))
						.click();
				Variables.elementWait(driver, 10, FetchData.readOR("MobilePercentageSelection"));
				driver.findElement(FetchData.readOR("MobilePercentageSelection")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("Mobileworkexperience"));
				driver.findElement(FetchData.readOR("Mobileworkexperience")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("Mobile_experienceSelection"));
				driver.findElement(FetchData.readOR("Mobile_experienceSelection")).click();

				CommonFunctions.pass(child, "MasterDetails Passed");
			} catch (Exception e) {

				CommonFunctions.fail(child, "MasterDetails Failed");
				throw e;
			}
		}

		public void bookedexamdate() throws Exception {
			try {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView();",
						driver.findElement(FetchData.readOR("bookedExamDate")));
				Variables.elementWait(driver, 10, FetchData.readOR("bookedExamDate"));
				driver.findElement(FetchData.readOR("bookedExamDate")).click();
				CommonFunctions.pass(child, "bookedexamdate Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "bookedexamdate Failed");
				throw e;
			}
		}
		
		public void examselectionNO() throws Exception {
			try {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView();",
						driver.findElement(FetchData.readOR("examselectionNO")));
				Variables.elementWait(driver, 10, FetchData.readOR("examselectionNO"));
				driver.findElement(FetchData.readOR("examselectionNO")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("Validpassport"));
				driver.findElement(FetchData.readOR("Validpassport")).click();
				CommonFunctions.pass(child, "examselectionNO Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "examselectionNO Failed");
				throw e;
			}
		}

		
		public void SignUp() throws Exception {
			try {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView();",
						driver.findElement(FetchData.readOR("Mobile_SignUp")));
				Variables.elementWait(driver, 20, FetchData.readOR("Mobile_SignUp"));
				driver.findElement(FetchData.readOR("Mobile_SignUp")).click();
				CommonFunctions.pass(child, "SignUp Passed");		
			} catch (Exception e) {
				CommonFunctions.fail(child, "SignUp Failed");
				throw e;
			}

		}
		
		public void Mobile_SignUpDB() throws Exception {
			try {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView();",
						driver.findElement(FetchData.readOR("Mobile_SignUpDB")));
				Variables.elementWait(driver, 20, FetchData.readOR("Mobile_SignUpDB"));
				driver.findElement(FetchData.readOR("Mobile_SignUpDB")).click();
				CommonFunctions.pass(child, "Mobile_SignUpDB Passed");		
			} catch (Exception e) {
				CommonFunctions.fail(child, "Mobile_SignUpDB Failed");
				throw e;
			}

		}
		
		
		public void Mobile_SignUpRMC() throws Exception {
			try {
				((JavascriptExecutor) driver).executeScript(
						"arguments[0].scrollIntoView();",
						driver.findElement(FetchData.readOR("Mobile_SignUpRMC")));
				Variables.elementWait(driver, 20, FetchData.readOR("Mobile_SignUpRMC"));
				driver.findElement(FetchData.readOR("Mobile_SignUpRMC")).click();
				CommonFunctions.pass(child, "Mobile_SignUpRMC Passed");		
			} catch (Exception e) {
				CommonFunctions.fail(child, "Mobile_SignUpRMC Failed");
				throw e;
			}

		}

		public void OTPVerification_Abroad(WebDriver driver,  Objects obj,String mobilenumber) throws Exception {
		    try {
		          Variables.elementWait(driver, 10,
		                      FetchData.readOR("MobileSAloginDesktop_OTP"));
		          Database db  = new Database();
		          ResultSet rs = db.executeDbQuery("select OTP from OTPVerification where mobile="+mobilenumber+" order by id desc limit 1;", obj);
		          rs.next();
		     
		          driver.findElement(FetchData.readOR("MobileSAloginDesktop_OTP")).sendKeys(rs.getString("OTP"));

		          Variables.elementWait(driver, 10,
		                      FetchData.readOR("SADesktop_OTPVerifyButton"));
		          WebElement we = driver.findElement(FetchData
		                      .readOR("SADesktop_OTPVerifyButton"));
		          JavascriptExecutor executor = (JavascriptExecutor) driver;
		          executor.executeScript("arguments[0].click();", we);
		          }

		    catch (Exception e) {
		    	e.printStackTrace();
		    }
		}

		public void Logout() throws Exception {
			try {	
				Thread.sleep(3000);
				Variables.elementWait(driver, 90, FetchData.readOR("Mobileuser_button"));
				driver.findElement(FetchData.readOR("Mobileuser_button")).click();
				CommonFunctions.pass(child, "Logout Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "Logout Failed");
				throw e;
			}

		}
		
		public void logIn() throws Exception {
			try {
				
				Variables.elementWait(driver, 10, FetchData.readOR("MobilelogIn"));
				driver.findElement(FetchData.readOR("MobilelogIn")).click();
				CommonFunctions.pass(child, "logIn Passed");

			} catch (Exception e) {

				CommonFunctions.fail(child, "logIn Failed");
				throw e;
			}

		}
		
		public void emailid(String emailid) throws Exception {
			try {
				
				Variables.elementWait(driver, 10, FetchData.readOR("emailid"));
				driver.findElement(FetchData.readOR("emailid")).sendKeys(emailid);
				CommonFunctions.pass(child, "emailid Passed");
			} catch (Exception e) {

				CommonFunctions.fail(child, "emailid Failed");
				throw e;
			}
		}

		public void password(String password) throws Exception {
			try {
				
				Variables.elementWait(driver, 10, FetchData.readOR("password"));
				driver.findElement(FetchData.readOR("password")).sendKeys(password);
				CommonFunctions.pass(child, "password Passed");
			} catch (Exception e) {

				CommonFunctions.fail(child, "password Failed");
				throw e;
			}
		}

		public void login_submit() throws Exception {
			try {
				Variables.elementWait(driver, 60, FetchData.readOR("login_submit"));
				driver.findElement(FetchData.readOR("login_submit")).click();
				CommonFunctions.pass(child,
						"login_submit Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "login_submit Failed");
				throw e;
			}
		}
		
		public void Thankyoulayer() throws Exception {
			try {
				Thread.sleep(3000);
				Variables.elementWait(driver, 60, FetchData.readOR("Thankyoulayer"));
				driver.findElement(FetchData.readOR("Thankyoulayer")).click();
				CommonFunctions.pass(child,
						"Thankyoulayer Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "Thankyoulayer Failed");
				throw e;
			}
		}
		
		public void Thankyoulayer_RMC() throws Exception {
			try {
				Thread.sleep(3000);
				Variables.elementWait(driver, 60, FetchData.readOR("Thankyoulayer_RMC"));
				driver.findElement(FetchData.readOR("Thankyoulayer_RMC")).click();
				CommonFunctions.pass(child,
						"Thankyoulayer_RMC Passed");
			} catch (Exception e) {
				CommonFunctions.fail(child, "Thankyoulayer_RMC Failed");
				throw e;
			}
		}
		
		
		
		public void CategoryPage_DownloadBrochure() throws Exception {
			try {
				Thread.sleep(3000);
				Variables.elementWait(driver, 30, FetchData.readOR("MobileCategoryPage_DownloadBrochure"));
				driver.findElement(
						FetchData.readOR("MobileCategoryPage_DownloadBrochure")).click();
				CommonFunctions.pass(child, "CategoryPage_DownloadBrochure Passed");

			} catch (Exception e) {
				e.printStackTrace();
				CommonFunctions.fail(child, "CategoryPage_DownloadBrochure Failed");
				throw e;
			}
		}
		
		public void header_DownloadBrochure() throws Exception {
			try {
				String expectedMessage = "Register to get brochure";
				String message = driver.findElement(
						FetchData.readOR("MobileheaderDB_Signup")).getText();
				if (message.contains(expectedMessage)) {
					
					CommonFunctions.pass(child, "header_Signup Passed");
				} else {
					
					CommonFunctions.fail(child, "header_Signup Failed");
				}

			}
			catch (Exception e) {

				throw e;
			}
		}
		
		public void header_Shortlist() throws Exception {
			try {
				String expectedMessage = "Please login / signup to save courses";
				String message = driver.findElement(
						FetchData.readOR("MobileheaderShortlist_Signup")).getText();
				if (message.contains(expectedMessage)) {
					
					CommonFunctions.pass(child, "MobileheaderShortlist_Signup Passed");
				} else {
					
					CommonFunctions.fail(child, "MobileheaderShortlist_Signup Failed");
				}

			}
			catch (Exception e) {

				throw e;
			}
		}
		
		public void header_Compare() throws Exception {
			try {
				String expectedMessage = "Please login / signup to compare courses";
				String message = driver.findElement(
						FetchData.readOR("MobileheaderCompare_Signup")).getText();
				if (message.contains(expectedMessage)) {
					
					CommonFunctions.pass(child, "MobileheaderCompare_Signup Passed");
				} else {
					
					CommonFunctions.fail(child, "MobileheaderCompare_Signup Failed");
				}

			}
			catch (Exception e) {

				throw e;
			}
		}
		
		public void CategoryPage_RMC() throws Exception {
			try {
				Thread.sleep(3000);
				Variables.elementWait(driver, 30, FetchData.readOR("MobileCategoryPage_RMC"));
				driver.findElement(
						FetchData.readOR("MobileCategoryPage_RMC")).click();
				CommonFunctions.pass(child, "MobileCategoryPage_RMC Passed");

			} catch (Exception e) {
				e.printStackTrace();
				CommonFunctions.fail(child, "MobileCategoryPage_RMC Failed");
				throw e;
			}
		}
	


public void Categorypage_shortlist() throws Exception {
	try {
		Thread.sleep(3000);
		Variables.elementWait(driver, 30, FetchData.readOR("MobileCategorypage_shortlist"));
		driver.findElement(
				FetchData.readOR("MobileCategorypage_shortlist")).click();
		CommonFunctions.pass(child, "MobileCategoryPage_RMC Passed");

	} catch (Exception e) {
		e.printStackTrace();
		CommonFunctions.fail(child, "MobileCategoryPage_RMC Failed");
		throw e;
	}
}

public void Searchpage_shortlist() throws Exception {
	try {
		Thread.sleep(3000);
		Variables.elementWait(driver, 30, FetchData.readOR("MobileSearchpage_shortlist"));
		driver.findElement(
				FetchData.readOR("MobileSearchpage_shortlist")).click();
		CommonFunctions.pass(child, "MobileSearchpage_shortlist Passed");

	} catch (Exception e) {
		e.printStackTrace();
		CommonFunctions.fail(child, "MobileSearchpage_shortlist Failed");
		throw e;
	}
}


public void Categorypage_compare() throws Exception {
	try {
		Thread.sleep(3000);
		Variables.elementWait(driver, 30, FetchData.readOR("MobileCategorypage_compare"));
		driver.findElement(
				FetchData.readOR("MobileCategorypage_compare")).click();
		CommonFunctions.pass(child, "MobileCategorypage_compare Passed");

	} catch (Exception e) {
		e.printStackTrace();
		CommonFunctions.fail(child, "MobileCategorypage_compare Failed");
		throw e;
	}
}

public void MobileCompare2() throws Exception {
	try {
		Variables.elementWait(driver, 10, FetchData.readOR("Cookie_OK"));
		driver.findElement(FetchData.readOR("Cookie_OK")).click();
		Variables.elementWait(driver, 10, FetchData.readOR("MobileCompare2"));
		driver.findElement(FetchData.readOR("MobileCompare2")).click();
		CommonFunctions.pass(child, "MobileCompare2 Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "MobileCompare2 Failed");
		throw e;
	}

}

public void Cookie_OK() throws Exception {
	try {
        Thread.sleep(2000);
		Variables.elementWait(driver, 10, FetchData.readOR("Cookie_OKK"));
		driver.findElement(FetchData.readOR("Cookie_OKK")).click();
		CommonFunctions.pass(child, "Cookie_OK Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "Cookie_OK Failed");
		throw e;
	}

}

public void coachMarks_OK() throws Exception {
	try {
		Thread.sleep(2000);
		Variables.elementWait(driver, 50, FetchData.readOR("coachMarks"));
		driver.findElement(FetchData.readOR("coachMarks")).click();
		CommonFunctions.pass(child, "Cookie_OK Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "Cookie_OK Failed");
		throw e;
	}

}

public void MobileCompare() throws Exception {
	try {
		Variables.elementWait(driver, 10, FetchData.readOR("MobileCompare"));
		driver.findElement(FetchData.readOR("MobileCompare")).click();
		CommonFunctions.pass(child, "MobileCompare Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "MobileCompare Failed");
		throw e;
	}

}

public void UniversityPage_DownloadBrochure() throws Exception {
	try {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();",
				driver.findElement(FetchData.readOR("MobileUniversitypage_DB")));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
		Thread.sleep(2000);
		Variables.elementWait(driver, 50, FetchData.readOR("MobileUniversitypage_DB"));
		driver.findElement(FetchData.readOR("MobileUniversitypage_DB")).click();
		CommonFunctions.pass(child, "UniversityPage_DownloadBrochure Passed");

	} catch (Exception e) {
		CommonFunctions.fail(child, "UniversityPage_DownloadBrochure Failed");
		throw e;
	}

}

public void Mobileselectcourse() throws Exception {
	try {
		Variables.elementWait(driver, 50, FetchData.readOR("Mobileselectcourse"));
		driver.findElement(FetchData.readOR("Mobileselectcourse")).click();
		Variables.elementWait(driver, 50, FetchData.readOR("MobileselectcourseDropdown"));
		driver.findElement(FetchData.readOR("MobileselectcourseDropdown")).click();
		CommonFunctions.pass(child, "Mobileselectcourse Passed");
	} catch (Exception e) {
		CommonFunctions.fail(child, "Mobileselectcourse Failed");
		throw e;
	}
}

}
