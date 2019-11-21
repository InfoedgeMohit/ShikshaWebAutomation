package com.shiksha.resourses;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.shiksha.main.Objects;
import com.shiksha.object.App_Login;
import com.shiksha.object.CTA_Desktop;

public class CommonFunctions {
	AppiumDriverLocalService service;
	Database db = new Database();
	Objects obj;

	public CommonFunctions(Objects obh) {
		obj = obh;
	}

	public CommonFunctions() {
	}

	public String OTPDisable = "?disableOTPVerification=e2b22fef40f50e9588431cf86f32406a";
	public String OTPDisableforHomePage = "?disableOTPVerification=e2b22fef40f50e9588431cf86f32406a";

	public void acceptCookie(WebDriver driver) {
		for (int i = 0; i < 2; i++) {
			try {
				if (i == 0) {
					Variables.elementWait(driver, 5,
							FetchData.readOR("cookie_Ok"));
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					executor.executeScript("arguments[0].click();",
							driver.findElement(FetchData.readOR("cookie_Ok")));
					break;
				} else {
					Variables.elementWait(driver, 5,
							FetchData.readOR("cookie_Ok_Desktop"));
					driver.findElement(FetchData.readOR("cookie_Ok_Desktop"))
							.click();
					break;
				}
			} catch (Exception e) {
				continue;
			}
		}

	}

	public void scrollToElementUsingWebElement(WebElement webelement,
			WebDriver driver) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", webelement);
		} catch (Exception e) {
			//
		}
	}

	public void acceptterms(WebDriver driver) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		try {
			Variables.elementWait(driver, 20, FetchData.readOR("agree1"));

			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("agree1")));

			Variables.elementWait(driver, 20, FetchData.readOR("agree2"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("agree2")));
		} catch (Exception e) {
			throw e;
		}

	}

	// To scroll above

	public void scroljl_Above(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	public static String getNumericValue(String str) {
		String something = str;
		int length = str.length();
		String result = "";
		for (int i = 0; i < length; i++) {
			Character character = something.charAt(i);
			if (Character.isDigit(character)) {
				result += character;
			} else {
				break;
			}
		}
		System.out.println("result is: " + result);
		return result;
	}

	public String login_iim(WebDriver driver, Objects obj) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			try {
				Variables.elementWait(driver, 10,
						FetchData.readOR("Desktop_login"));
				WebElement we = driver.findElement(FetchData
						.readOR("Desktop_login"));

				executor.executeScript("arguments[0].click();", we);
				login_special(driver, "test1qa@gmail.com", "shiksha", obj);

			} catch (Exception e) {
				// // Do nothing
			}

		} catch (Exception e) {
			throw e;
		}

		return "test1qa@gmail.com";

	}

	public String login(WebDriver driver, Objects obj) throws Exception {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			try {
				Variables.elementWait(driver, 10,
						FetchData.readOR("clickloginText_Mobile"));
				scrollToElement(FetchData.readOR("clickloginText_Mobile"),
						driver);
				WebElement we = driver.findElement(FetchData
						.readOR("clickloginText_Mobile"));

				executor.executeScript("arguments[0].click();", we);

			} catch (Exception e) {
				try {

					Variables.elementWait(driver, 10,
							FetchData.readOR("applylogin"));
					scrollToElement(FetchData.readOR("applylogin"), driver);
					WebElement we1 = driver.findElement(FetchData
							.readOR("applylogin"));
					JavascriptExecutor executor1 = (JavascriptExecutor) driver;
					executor1.executeScript("arguments[0].click();", we1);
				} catch (Exception ex) {
					throw ex;

				}
			}
			login_special(driver, "test1qa@gmail.com", "shiksha", obj);
			try {
				Variables.elementWait(driver, 5,
						FetchData.readOR("clientcourse_deb"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("clientcourse_deb")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("clientcourse_deb_1"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("clientcourse_deb_1")));
				Thread.sleep(2000);
				try {
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_woekExp"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_woekExp")));
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_woekExp_2"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_woekExp_2")));
					Thread.sleep(2000);
				} catch (Exception e) {

				}
				try {
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_prefcity"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_prefcity")));
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_prefcity_2"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_prefcity_2")));
					Thread.sleep(2000);
				} catch (Exception e) {

				}

				try {

					Variables.elementWait(driver, 5,
							FetchData.readOR("login_locality"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_locality")));
					Variables.elementWait(driver, 5,
							FetchData.readOR("login_locality_2"));
					executor.executeScript("arguments[0].click();", driver
							.findElement(FetchData.readOR("login_locality_2")));
					Thread.sleep(2000);
				} catch (Exception e) {

				}
				Variables.elementWait(driver, 5,
						FetchData.readOR("clientcourse_deb_2"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("clientcourse_deb_2")));
				Thread.sleep(2000);

			} catch (Exception e) {
				// // Do nothing
			}

		} catch (Exception e) {
			throw e;
		}

		return "test1qa@gmail.com";

	}

	public WebElement waitForElement(WebDriver driver, String XPath) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			WebElement element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath(XPath)));
			// System.out.println("Checking the visibility of element");
			return element;
		} catch (Exception e) {
		}
		return null;
	}

	public void scroll_Above(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-250)", "");
	}

	public void waitForFixTime(int Time) {
		try {
			Thread.sleep(Time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String[] signup(WebDriver driver, Objects obj) throws Exception {
		String email = "";
		String education = "false";
		String number = "false";
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		acceptterms(driver);
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("clientcourse_deb"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("clientcourse_deb")));

			Variables.elementWait(driver, 5,
					FetchData.readOR("clientcourse_deb_1"));
			executor.executeScript("arguments[0].click();",
					driver.findElement(FetchData.readOR("clientcourse_deb_1")));

		} catch (Exception e) {
			// // Do nothing
		}

		try {
			email = RandomEmail("shikshatest.com");

			Variables.elementWait(driver, 20, FetchData.readOR("signupemail"));
			driver.findElement(FetchData.readOR("signupemail")).sendKeys(email);

			Variables.elementWait(driver, 50, FetchData.readOR("signuppass"));
			driver.findElement(FetchData.readOR("signuppass")).sendKeys(
					"shiksha");

			try {
				// // Optional Fields
				// // Work Ex
				Variables.elementWait(driver, 5,
						FetchData.readOR("signupworkex"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signupworkex")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signupworkexdrop"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("signupworkexdrop")));
			} catch (Exception e) {
			}

			try {
				// // Exams Taken
				Variables
						.elementWait(driver, 5, FetchData.readOR("signupexam"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signupexam")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signupexamdrop"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signupexamdrop")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signupexamselect"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("signupexamselect")));
				education = "true";

			} catch (Exception e) {
			}

			try {
				// // Locality
				Variables.elementWait(driver, 5,
						FetchData.readOR("signuplocality"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signuplocality")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signuplocalitydrop"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("signuplocalitydrop")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signuplocality1"));
				executor.executeScript("arguments[0].click();",
						driver.findElement(FetchData.readOR("signuplocality1")));
				Variables.elementWait(driver, 5,
						FetchData.readOR("signuplocalitydrop1"));
				executor.executeScript("arguments[0].click();", driver
						.findElement(FetchData.readOR("signuplocalitydrop1")));
			} catch (Exception e) {
				// // do nothig
			}

			// //
			Variables.elementWait(driver, 10, FetchData.readOR("signupFName"));
			driver.findElement(FetchData.readOR("signupFName")).sendKeys(
					"Shiksha");

			Variables.elementWait(driver, 10, FetchData.readOR("signupLName"));
			driver.findElement(FetchData.readOR("signupLName"))
					.sendKeys("Test");

			Variables.elementWait(driver, 10, FetchData.readOR("signupmobile"));
			number = RandomNumber('9');
			driver.findElement(FetchData.readOR("signupmobile")).sendKeys(
					number);

			Variables.elementWait(driver, 10,
					FetchData.readOR("signuplocation"));

			WebElement we = driver.findElement(FetchData
					.readOR("signuplocation"));

			executor.executeScript("arguments[0].click();", we);

			Variables.elementWait(driver, 10,
					FetchData.readOR("signuplocation_2"));
			WebElement we1 = driver.findElement(FetchData
					.readOR("signuplocation_2"));
			executor.executeScript("arguments[0].click();", we1);
			try {
				Variables.elementWait(driver, 10,
						FetchData.readOR("signupbutton"));
				WebElement we2 = driver.findElement(FetchData
						.readOR("signupbutton"));
				executor.executeScript("arguments[0].click();", we2);
			} catch (Exception df) {
				try {
					Variables.elementWait(driver, 10,
							FetchData.readOR("signupbutton_2"));
					WebElement we2 = driver.findElement(FetchData
							.readOR("signupbutton_2"));
					executor.executeScript("arguments[0].click();", we2);
				} catch (Exception er) {
					throw er;
				}

			}

			try {
				Variables.elementWait(driver, 50,
						FetchData.readOR("loginDesktop_OTP"));
			}

			catch (Exception e) {

			}

		} catch (Exception e) {
			throw e;
		}

		String[] xs = new String[] { email, education, number };
		return xs;
	}

	public String StaticData(String heading) {
		String data = "";
		switch (heading.trim()) {

		case "download":
			data = "Students who showed interest in this institute also looked at";
			break;

		case "view experts panel":
			data = "/experts";
			break;

		case "community guidelines":
			data = "/shikshaHelp/ShikshaHelp/communityGuideline";
			break;

		case "user points system":
			data = "/shikshaHelp/ShikshaHelp/upsInfo";
			break;

		case "questions":
			data = "/questions";
			break;

		case "discussions":
			data = "/all-discussions";
			break;

		case "tags":
			data = "/tags";
			break;

		case "download_sample_paper":
			data = "Your download should start automatically.\nIf it does not start automatically Click here to manually download it.";
			break;

		case "download_perp_guide":
			data = "Your download should start automatically.\nIf it does not start automatically Click here to manually download it.";
			break;

		case "compare_scroll":
			data = "Compare Courses in Colleges of your choice";
			break;

		case "download_guide_sticky":
			data = "The exam guide has been sent to your email id. The email also includes important information such as Institutes Accepting this Exam, Related Articles, Questions & Answers, Similar Exams & more.";
			break;

		case "download_guide":
			data = "The exam guide has been sent to your email id. The email also includes important information such as Institutes Accepting this Exam, Related Articles, Questions & Answers, Similar Exams & more.";
			break;

		case "apply_now":
			data = "You have successfully started your application. We have sent you an email with the link to your application. Open that link on the desktop/laptop for an easy and smooth process to complete your submission.";
			break;

		case "compare_sticky":
			data = "Compare Courses in Colleges of your choice";
			break;

		case "compare":
			data = "Compare Courses in Colleges of your choice";
			break;

		case "download_scroll":
			data = "Students who showed interest in this institute also looked at";
			break;

		case "shortlist":
			data = "Students who showed interest in this institute also looked at";
			break;

		case "download_sticky":
			data = "Students who showed interest in this institute also looked at";
			break;

		case "grade_a++":
			data = "NAAC A++";
			break;

		case "grade_b++":
			data = "NAAC B++";
			break;

		case "grade_a+":
			data = "NAAC A+";
			break;

		case "grade_b+":
			data = "NAAC B+";
			break;

		case "grade_a":
			data = "NAAC A";
			break;

		case "grade_b":
			data = "NAAC B";
			break;

		case "grade_c":
			data = "NAAC C";
			break;

		case "grade_d":
			data = "NAAC D";
			break;

		case "NAAC A":
			data = "National Assessment and Accreditation Council (NAAC) - An autonomous body established by the UGC to evaluate quality of higher education institutes in India. It grades an institution from A++ (best rating) to C. Rating D indicates that the institution is not accredited.";
			break;

		case "NAAC A+":
			data = "National Assessment and Accreditation Council (NAAC) - An autonomous body established by the UGC to evaluate quality of higher education institutes in India. It grades an institution from A++ (best rating) to C. Rating D indicates that the institution is not accredited.";
			break;

		case "NAAC A++":
			data = "National Assessment and Accreditation Council (NAAC) - An autonomous body established by the UGC to evaluate quality of higher education institutes in India. It grades an institution from A++ (best rating) to C. Rating D indicates that the institution is not accredited.";
			break;

		case "NAAC B":
			data = "National Assessment and Accreditation Council (NAAC) - An autonomous body established by the UGC to evaluate quality of higher education institutes in India. It grades an institution from A++ (best rating) to C. Rating D indicates that the institution is not accredited.";
			break;

		case "NAAC C":
			data = "National Assessment and Accreditation Council (NAAC) - An autonomous body established by the UGC to evaluate quality of higher education institutes in India. It grades an institution from A++ (best rating) to C. Rating D indicates that the institution is not accredited.";
			break;

		case "NAAC D":
			data = "National Assessment and Accreditation Council (NAAC) - An autonomous body established by the UGC to evaluate quality of higher education institutes in India. It grades an institution from A++ (best rating) to C. Rating D indicates that the institution is not accredited.";
			break;

		case "NAAC B+":
			data = "National Assessment and Accreditation Council (NAAC) - An autonomous body established by the UGC to evaluate quality of higher education institutes in India. It grades an institution from A++ (best rating) to C. Rating D indicates that the institution is not accredited.";
			break;

		case "NAAC B++":
			data = "National Assessment and Accreditation Council (NAAC) - An autonomous body established by the UGC to evaluate quality of higher education institutes in India. It grades an institution from A++ (best rating) to C. Rating D indicates that the institution is not accredited.";
			break;

		case "AICTE":
			data = "All India Council for Technical Education (AICTE) is a statutory body and a national level council, set up under the Department of Higher Education under the Ministry of Human Resource Development, responsible for monitoring technical education institutes and accrediting all postgraduate and graduate programs that fall under technical education in India.";
			break;

		case "BCI":
			data = "The Bar Council of India (BCI) is a statutory body created by the Parliament to regulate and represent the Indian bar. It performs the regulatory function by prescribing standards of professional conduct and etiquette and by exercising disciplinary jurisdiction over the bar. The BCI also sets standards for legal education and grants recognition to Indian universities imparting legal education. This is done in consultation with the universities and the State Bar Councils.";
			break;

		case "CCH":
			data = "Central Council of Homeopathy (CCH) is a statutory apex body set up under the Central Council of Homoeopathy Act 1973, by the Government of India to supervise homeopathy education in India. The statutory body is under the Ministry of Health and Family Welfare, Department of AYUSH and is a part of Professional Councils of the UGC. CCH monitors homeopathy institutes, prescribes curriculum and maintains central register of homeopaths in India.";
			break;

		case "CCIM":
			data = "Central Council of Indian Medicine (CCIM) is a statutory body under the Ministry of Health and Family Welfare, Department of AYUSH and a part of Professional Councils under UGC, which monitors and regulates higher education in Indian system of medicines - Ayurved, Siddha, Unani and Sowa Rigpa. The CCIM maintains central register of practitioners of Indian system of medicines.";
			break;

		case "CoA":
			data = "The Council of Architecture (COA), established by the Government of India under the provisions of the Architects Act, 1972 is charged with the responsibility to regulate the education and practice of profession throughout India besides maintaining the register of architects.";
			break;

		case "DCI":
			data = "Dental Council of India (DCI) is a statutory body set under The Dentist Act, 1948 to monitor and regulate the Dental Education and the profession of Dentistry in India. It is financed by the Ministry of Health & Family Welfare (Department of Health) through Grant-in-Aid.";
			break;

		case "DEB-UGC":
			data = "Distance Education Bureau of University Grants Commission (DEB-UGC) works as a regulatory body for distance education in India. The DEB has been vested with the responsibility of regulating distance education at higher level - grant permission to universities to offer distance learning programmes and monitor them.";
			break;

		case "ICAR":
			data = "The Indian Council of Agricultural Research (ICAR) is an autonomous organisation set up by the Government of India, under the Department of Agricultural Research and Education (DARE). The apex body has been vested with the responsibility of co-ordinating, guiding and managing research and education in agriculture including horticulture, fisheries and animal sciences in India.";
			break;

		case "INC":
			data = "Indian Nursing Council is an autonomous body set up by the Government of India under the Indian nursing Council Act, 1947 to monitor and regulate and maintain training standards for nurses, midwives and health visitors. INC is vested with the responsibility to prescribe minimum standards of education and training in various nursing programmes and prescribe the syllabus & regulations for Nursing programms.";
			break;

		case "MCI":
			data = "Medical Council of India (MCI) is a statutory body set up by the Government of India to establish and maintain uniform standard of medical education at UG and PG level. MCI is vested with the responsibility to recommend for recognition/de-recognition of medical qualifications of medical institutions of India or foreign countries and registration of recognised doctors in the country.";
			break;

		case "NCRI":
			data = "National Council of Rural Institutes (NCRI) under the Ministry of Human Resource Development, Government of India, designs, develops and promotes curriculum inputs for higher education programmes offered by Indian Universities and Autonomous Institutions in Rural Studies, Rural Development, Rural Management, Social Work and Education.";
			break;

		case "NCTE":
			data = "National Council for Teacher Education (NCTE) is a statutory body established by the Government of India under National Council of Teacher Education Act, 1993. NCTE was set up with the aim of regulating and maintaining norms and standards in the teacher education system, including training of personnel and development of teacher education programmes.";
			break;

		case "PCI":
			data = "Pharmacy Council of India (PCI) is a statutory body under the Ministry of Health & Family Welfare, Government of India, established to regulate pharmacy education in India as well as its practice and the profession. PCI is vested with the power to ensure a uniform educational standard and its implementation in all the pharmacy institutes across India.";
			break;

		case "RCI":
			data = "Rehabilitation Council of India (RCI) is a statutory body established by the Government of India to maintain and regulate standard training programmes and policies in the field of rehabilitation of persons with disabilities. RCI has also been vested with the power to formulate training courses for professionals and institutes and award recognition to them.";
			break;

		case "SIRO":
			data = "Scientific and Industrial Research Organizations (SIRO) are organizations recognized by the Department of Scientific and Industrial Research, which undertake and promote scientific and industrial research and development work across the country.";
			break;

		case "VCI":
			data = "Veterinary Council of India (VCI) is a statutory body established by the Government of India under the Indian Veterinary Council Act, 1984 to regulate veterinary practice and maintenance of registers of veterinary practitioners and for matters connected therewith.";
			break;

		case "NBA":
			data = "The National Board of Accreditation (NBA), is an autonomous body set up with the objective of Assurance of Quality and Relevance of Education, in disciplines like, Engineering and Technology, Management, Architecture, Pharmacy and Hospitality, through accredidation of programmes offered by technical institutions, in line with international practices.";
			break;

		default:
			data = "no data found";
		}

		return data;
	}

	public void uploadFile(String filePath) {
		try {
			String text = filePath;
			StringSelection stringSelection = new StringSelection(text);
			Clipboard clipboard = Toolkit.getDefaultToolkit()
					.getSystemClipboard();
			clipboard.setContents(stringSelection, stringSelection);
			Robot robot = new Robot();
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(5000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {

		}
	}

	public void loginCMS(WebDriver driver, String url, String userName,
			String password) throws Exception {
		try {

			// CommonFunctions.logPass("Login to cms");
			// // Open url
			driver.get(url + "/enterprise/Enterprise/loginEnterprise");

			// // Type UserName
			// CommonFunctions.logPass("Type UserName");
			Variables.elementWait(driver, 10, FetchData.readOR("CMS_Email"));
			driver.findElement(FetchData.readOR("CMS_Email"))
					.sendKeys(userName);

			// // Type password
			// CommonFunctions.logPass("Type Password");
			Variables.elementWait(driver, 10, FetchData.readOR("CMS_Password"));
			driver.findElement(FetchData.readOR("CMS_Password")).sendKeys(
					password);

			// // Click Login Button to login
			// CommonFunctions.logPass("Hit Login");
			Variables.elementWait(driver, 10, FetchData.readOR("CMS_Login"));
			driver.findElement(FetchData.readOR("CMS_Login")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("CMS_Logo"));

			// CommonFunctions.logPass("Login Completed");
		}

		catch (Exception e) {
			// CommonFunctions.logFail("Login Completed");
			throw e;
		}
	}

	public void login(WebDriver driver, String userName, String password,
			Objects obj) throws Exception {
		try {
			// CommonFunctions.logPass("Login to cms");
			// // Type UserName
			// CommonFunctions.logPass("Type UserName");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_username"));
			driver.findElement(FetchData.readOR("loginDesktop_username"))
					.sendKeys(userName);

			// // Type password
			// CommonFunctions.logPass("Type Password");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_password"));
			driver.findElement(FetchData.readOR("loginDesktop_password"))
					.sendKeys(password);

			// // Click Login Button to login
			// CommonFunctions.logPass("Hit Login");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_loginbutton"));
			WebElement we = driver.findElement(FetchData
					.readOR("loginDesktop_loginbutton"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", we);

			if (obj.getdevice().equalsIgnoreCase("desktop"))
				Variables.elementWait(driver, 10,
						FetchData.readOR("loginDesktop_logo"));
			else {
				if (driver.getCurrentUrl().toLowerCase().contains("amp")) {
					Variables.elementWait(driver, 10,
							FetchData.readOR("Amp_Bell"));
					driver.findElement(FetchData.readOR("Amp_Bell")).click();
					Variables.elementWait(driver, 10,
							FetchData.readOR("Amp_noti"));
				} else {
					Variables.elementWait(driver, 10,
							FetchData.readOR("Mobile_Bell"));
					driver.findElement(FetchData.readOR("Mobile_Bell")).click();
					Variables.elementWait(driver, 10,
							FetchData.readOR("Mobile_noti"));
				}
			}

			// CommonFunctions.logPass("Login Completed");
		}

		catch (Exception e) {
			// CommonFunctions.logFail("Login Completed");
			throw e;
		}
	}

	public void login_special(WebDriver driver, String userName,
			String password, Objects obj) throws Exception {
		try {
			// CommonFunctions.logPass("Login to cms");
			// // Type UserName
			// CommonFunctions.logPass("Type UserName");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_username"));
			driver.findElement(FetchData.readOR("loginDesktop_username"))
					.sendKeys(userName);

			// // Type password
			// CommonFunctions.logPass("Type Password");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_password"));
			driver.findElement(FetchData.readOR("loginDesktop_password"))
					.sendKeys(password);

			// // Click Login Button to login
			// CommonFunctions.logPass("Hit Login");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_loginbutton"));
			WebElement we = driver.findElement(FetchData
					.readOR("loginDesktop_loginbutton"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", we);

			// CommonFunctions.logPass("Login Completed");
		}

		catch (Exception e) {
			// CommonFunctions.logFail("Login Completed");
			throw e;
		}
	}

	public void login_special_desktop(WebDriver driver, String userName,
			String password, Objects obj) throws Exception {
		try {
			// CommonFunctions.logPass("Login to cms");
			// // Type UserName
			// CommonFunctions.logPass("Type UserName");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_username"));
			driver.findElement(FetchData.readOR("loginDesktop_username"))
					.sendKeys(userName);

			// // Type password
			// CommonFunctions.logPass("Type Password");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_password"));
			driver.findElement(FetchData.readOR("loginDesktop_password"))
					.sendKeys(password);

			// // Click Login Button to login
			// CommonFunctions.logPass("Hit Login");
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_loginbutton"));
			WebElement we = driver.findElement(FetchData
					.readOR("loginDesktop_loginbutton"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", we);

			// CommonFunctions.logPass("Login Completed");
		}

		catch (Exception e) {
			// CommonFunctions.logFail("Login Completed");
			throw e;
		}
	}

	public void OTPVerification(WebDriver driver, String mobNumber,
			Boolean layer, Objects obj) throws Exception {
		try {
			// // Get OTP from DB
			// // Type OTP
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_OTP"));
			String OTP = db.OTPVerification(mobNumber, obj);
			driver.findElement(FetchData.readOR("loginDesktop_OTP")).sendKeys(
					OTP);

			// // Click Verify OTP
			Variables.elementWait(driver, 10,
					FetchData.readOR("loginDesktop_OTPVerifyButton"));
			WebElement we = driver.findElement(FetchData
					.readOR("loginDesktop_OTPVerifyButton"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", we);
			if (!layer) {
				if (obj.getdevice().equalsIgnoreCase("desktop"))
					Variables.elementWait(driver, 10,
							FetchData.readOR("loginDesktop_logo"));

				else {
					if (driver.getCurrentUrl().toLowerCase().contains("amp")) {
						Variables.elementWait(driver, 10,
								FetchData.readOR("Amp_Bell"));
						driver.findElement(FetchData.readOR("Amp_Bell"))
								.click();
						Variables.elementWait(driver, 10,
								FetchData.readOR("Amp_noti"));
					} else {
						Variables.elementWait(driver, 10,
								FetchData.readOR("Mobile_Bell"));
						driver.findElement(FetchData.readOR("Mobile_Bell"))
								.click();
						Variables.elementWait(driver, 10,
								FetchData.readOR("Mobile_noti"));
					}

				}
			}

			// CommonFunctions.logPass("Login Completed");
		}

		catch (Exception e) {
			// CommonFunctions.logFail("Login Completed");
			// throw e;
		}
	}

	public void appiumsetup() {
		// intialize Appium Service
		service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder().withIPAddress(
						Variables.prop.getProperty("ip")).usingPort(
						Integer.parseInt(Variables.prop.getProperty("port"))));
		// Start Appium Service
		service.start();
	}

	// Stop Appium Service
	public void appiumstop() {
		service.stop();
	}

	// Enter url in mobile app on launch
	public void urlSetup(WebDriver driver) {
		try {
			driver.findElement(FetchData.readOR("URLtxtBox")).clear();
			driver.findElement(FetchData.readOR("URLtxtBox")).sendKeys(
					FetchData.readConfig("url"));
			driver.findElement(FetchData.readOR("URLDone")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("askheader"));
			driver.findElement(FetchData.readOR("askheader")).isDisplayed();
			// CommonFunctions.logFail("Login Homepage open Successfully");
		} catch (Exception e) {
			// CommonFunctions.logFail("Login Homepage not launch Successfully, URL entered successfully");
		}
	}

	// Scroll to function
	public void scrollToElement(By path, WebDriver driver) {
		try {
			((JavascriptExecutor) driver).executeScript(
					"arguments[0].scrollIntoView();", driver.findElement(path));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,-200)", "");
		} catch (Exception e) {

		}
	}

	public String createXpath(WebElement xpath) {
		String myXpath = xpath.toString();
		myXpath = myXpath.substring(myXpath.indexOf("xpath: ") + 7,
				myXpath.length() - 1);
		return myXpath;
	}

	public void logPass(String pass) {
		// reports.reportBody(pass, "pass");
		// Reporter.log(pass);

	}

	public ExtentReports createExtinctReport(String path, String moduleName) {
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String reportPath = path + "\\" + moduleName
		// + sdf.format(timestamp)
				+ ".html";
		ExtentReports extent = new ExtentReports(reportPath, true);
		return extent;
	}

	public int getFirstIntegerValueFromString(String yourString) {

		String str = yourString;
		String result = "";

		for (int i = 0; i < str.length(); i++) {
			Character chars = str.charAt(i);
			if (Character.isDigit(chars)) {
				result += chars;
			} else {
				break;
			}
		}
		int finalResult = Integer.parseInt(result);
		return finalResult;
	}

	public static void elementWait(WebDriver driver, int timeinsec, By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeinsec);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			throw e;
		}
	}

	public void clickCTA(WebDriver driver, String CTA, String page,
			ExtentTest child) throws Exception {
		// checkUserStateLoginLogOut(driver);

		System.out.println("Going to click ->>>>>>>>>>>>>>" + " "
				+ CTA.toUpperCase() + " " + "CTA On" + " " + page.toUpperCase()
				+ " " + "Page");

		if (CTA.equalsIgnoreCase("shortlist")
				&& ((page.equalsIgnoreCase("ILP")) || (page
						.equalsIgnoreCase("ULP")))) {
			try {
				driver.findElement(FetchData.readOR("UILP_shortlist")).click();
				pass(child, "Shortlist CTA has been clicked on " + page
						+ " Page");
			} catch (Exception e) {
				fail(child,
						"There is an error while clicking shortlist CTA on "
								+ page + " Page.");
			}
		}

		else if (CTA.equalsIgnoreCase("DEB")
				&& ((page.equalsIgnoreCase("ILP")) || (page
						.equalsIgnoreCase("ULP")))) {
			try {
				driver.findElement(FetchData.readOR("UILP_DEB")).click();
				pass(child, "Download EBrochure CTA has been clicked on "
						+ page + " Page");
			} catch (Exception e) {
				fail(child,
						"There is an error while clicking on Download Ebrochure CTA on "
								+ page + " Page.");
			}
		}

		else if (CTA.equalsIgnoreCase("SCD")
				&& ((page.equalsIgnoreCase("ILP")) || (page
						.equalsIgnoreCase("ULP")))) {
			try {
				System.out.println("I am here to scroll");
				scrollToElementUsingWebElement(driver.findElement(FetchData
						.readOR("scrollToContactDetailss")), driver);
				elementWait(driver, 30, FetchData.readOR("UILP_SCD"));
				driver.findElement(FetchData.readOR("UILP_SCD")).click();
				pass(child, "Show Contact Detail CTA has been clicked on "
						+ page + " Page.");
			} catch (Exception e) {
				fail(child,
						"There is an error while clicking on Show Contact Detail button on "
								+ page + " Page");
			}
		}

		else if (CTA.equalsIgnoreCase("deb_AlsoViewed")
				&& ((page.equalsIgnoreCase("ILP")) || (page
						.equalsIgnoreCase("ULP")))) {
			try {
				scrollToElementUsingWebElement(
						driver.findElement(FetchData.readOR("Student_View")),
						driver);
				elementWait(driver, 30, FetchData.readOR("UILP_alsoViewed"));
				driver.findElement(FetchData.readOR("UILP_alsoViewed")).click();
				pass(child, "Clicked on DEB CTA under also viewed widget on "
						+ page + " Page.");
			} catch (Exception e) {
				fail(child,
						"There is an error while we are clicking on DEB CTA under also viewed widget on "
								+ page + " Page");
			}
		}

		else if (CTA.equalsIgnoreCase("similarDEB")
				&& ((page.equalsIgnoreCase("ILP")) || (page
						.equalsIgnoreCase("ULP")))) {
			try {
				scrollToElementUsingWebElement(driver.findElement(FetchData
						.readOR("clickShowContactDetail")), driver);
				elementWait(driver, 30, FetchData.readOR("UILP_similarDEB"));
				driver.findElement(FetchData.readOR("UILP_similarDEB")).click();
				pass(child,
						"Clicked on DEB CTA under similar inistitutes widget on "
								+ page + " Page.");
			} catch (Exception e) {
				fail(child,
						"There is an error while we are clicking on DEB CTA under similar institutes widget on "
								+ page + " Page");
			}
		}

		if (CTA.equalsIgnoreCase("shortlist")
				&& (page.equalsIgnoreCase("rankingPage"))) {
			try {
				scrollToElementUsingWebElement(
						driver.findElement(FetchData.readOR("rank_By")), driver);
				elementWait(driver, 30,
						FetchData.readOR("rankingPageShortlist"));
				driver.findElement(FetchData.readOR("rankingPageShortlist"))
						.click();
				pass(child, "Shortlist CTA has been clicked on Ranking Page");
			} catch (Exception e) {
				fail(child,
						"There is an error while clicking on Shortlist CTA on Ranking Page");
			}
		}

		else if (CTA.equalsIgnoreCase("deb")
				&& (page.equalsIgnoreCase("rankingPage"))) {
			try {
				scrollToElementUsingWebElement(
						driver.findElement(FetchData.readOR("rankedBy")),
						driver);
				elementWait(driver, 30, FetchData.readOR("rankingPageDEB"));
				driver.findElement(FetchData.readOR("rankingPageDEB")).click();
				pass(child, "DEB CTA has been clicked on Ranking Page");
			} catch (Exception e) {
				fail(child,
						"There is an error while clicking on DEB CTA on Ranking Page.");
			}
		}

		if (CTA.equalsIgnoreCase("DEB") && (page.equalsIgnoreCase("CLP"))) {
			try {
				driver.findElement(FetchData.readOR("CLP_DEB")).click();
				pass(child, "DEB CTA has been clicked");
			} catch (Exception e) {
				fail(child, "DEB CTA has not been clicked");
			}
		}

		else if (CTA.equalsIgnoreCase("shortlist")
				&& (page.equalsIgnoreCase("CLP"))) {
			try {
				driver.findElement(FetchData.readOR("CLP_Shortlist")).click();
				pass(child, "Shortlist CTA has been clicked");
			} catch (Exception e) {
				fail(child, "Shortlist CTA has not been clicked");
			}
		}

		else if (CTA.equalsIgnoreCase("scd") && (page.equalsIgnoreCase("CLP"))) {
			try {
				driver.findElement(FetchData.readOR("scrollToSCD_CLP")).click();
				elementWait(driver, 30, FetchData.readOR("SCD_CLP"));
				driver.findElement(FetchData.readOR("SCD_CLP")).click();
				pass(child, "Show contact detail has been clicked");
			} catch (Exception e) {
				fail(child, "Show contact detail has not been clicked");
			}
		}

		else if (CTA.equalsIgnoreCase("deb_AlsoViewed")
				&& (page.equalsIgnoreCase("CLP"))) {
			try {
				scrollToElementUsingWebElement(driver.findElement(FetchData
						.readOR("scrollStudentView")), driver);
				elementWait(driver, 30, FetchData.readOR("CLP_DEB_AlsoViewed"));
				driver.findElement(FetchData.readOR("CLP_DEB_AlsoViewed"))
						.click();
				pass(child, "DEB has been clicked under also viewed widget");
			} catch (Exception e) {
				fail(child, "DEB has not been clicked under also viewed widget");
			}
		}

		if (CTA.equalsIgnoreCase("DEB") && (page.equalsIgnoreCase("CTP"))) {
			try {
				scrollToElementUsingWebElement(
						driver.findElement(FetchData.readOR("tplDetails")),
						driver);
				elementWait(driver, 30, FetchData.readOR("CTP_DEB"));
				driver.findElement(FetchData.readOR("CTP_DEB")).click();
				pass(child, "Clicked on Download Brochure CTA on Category Page");
			} catch (Exception e) {
			}
		}

		else if (CTA.equalsIgnoreCase("shortlist")
				&& (page.equalsIgnoreCase("CTP"))) {
			try {
				scrollToElementUsingWebElement(
						driver.findElement(FetchData.readOR("tupleDetails")),
						driver);
				elementWait(driver, 30, FetchData.readOR("CTP_Shortlist"));
				driver.findElement(FetchData.readOR("CTP_Shortlist")).click();
				pass(child, "Clicked on Download Brochure CTA on Category Page");
			} catch (Exception e) {
			}
		}

		if (CTA.equalsIgnoreCase("deb")
				&& ((page.equalsIgnoreCase("ILP-ReviewPage"))
						|| page.equalsIgnoreCase("ULP-ReviewPage")
						|| page.equalsIgnoreCase("ilp-admissionPage")
						|| page.equalsIgnoreCase("ulp-admissionPage")
						|| page.equalsIgnoreCase("ulp-scholarshipPage")
						|| page.equalsIgnoreCase("ilp-scholarshipPage")
						|| page.equalsIgnoreCase("ulp-ArticlesPage")
						|| page.equalsIgnoreCase("ilp-ArticlesPage")
						|| page.equalsIgnoreCase("ulp-questionsPage") || page
							.equalsIgnoreCase("ilp-questionsPage"))) {
			try {
				driver.findElement(FetchData.readOR("DEB_ILP_ReviewPage"))
						.click();
				pass(child, "Clicked on Download Ebochure CTA on " + page
						+ " page.");
			} catch (Exception e) {
				fail(child,
						"There is an error while clicking on Download EBrochure CTA on "
								+ page + " page.");
			}
		}

		if (CTA.equalsIgnoreCase("shortlist")
				&& ((page.equalsIgnoreCase("ILP-ReviewPage"))
						|| page.equalsIgnoreCase("ULP-ReviewPage")
						|| page.equalsIgnoreCase("ilp-admissionPage")
						|| page.equalsIgnoreCase("ulp-admissionPage")
						|| page.equalsIgnoreCase("ulp-scholarshipPage")
						|| page.equalsIgnoreCase("ilp-scholarshipPage")
						|| page.equalsIgnoreCase("ulp-ArticlesPage")
						|| page.equalsIgnoreCase("ilp-ArticlesPage")
						|| page.equalsIgnoreCase("ilp-questionsPage") || page
							.equalsIgnoreCase("ulp-questionsPage"))) {
			try {
				driver.findElement(FetchData.readOR("Shortlist_ILP_ReviewPage"))
						.click();
				pass(child, "Clicked on Shortlist CTA on " + page + " Page.");
			} catch (Exception e) {
				fail(child,
						"There is an error while clicking on shortlist CTA on "
								+ page + " Page.");
			}
		}

		// if(CTA.equalsIgnoreCase("SCD") &&
		// ((page.equalsIgnoreCase("ILP-ReviewPage")) ||
		// page.equalsIgnoreCase("ULP-ReviewPage")))
		// {
		// try {
		// waitForFixTime(2000);
		// System.out.println("I am here SCD CTA on " + page);
		// driver.findElement(By.xpath("(.//*[@class='dot-c'])[1]")).click();
		// waitForFixTime(2000);
		// driver.findElement(By.xpath("(.//a[contains(text(),'Get Contact Details')])[2]")).click();
		// pass(child, "Clicked on Show Contact Detail CTA on " + page +
		// " Page.");
		// }
		// catch (Exception e) {
		// fail(child,
		// "There is an error while clicking on Show Contact Detail CTA on " +
		// page + " Page.");
		// }
		// }
	}

	public void layerCheck(WebDriver driver, ExtentTest child) {
		try {
			elementWait(driver, 15, FetchData.readOR("courseLayer"));
			if (driver.findElements(FetchData.readOR("courseLayer")).size() > 0) {
				driver.findElement(FetchData.readOR("cList")).click();
				List<WebElement> courseList = driver.findElements(FetchData
						.readOR("courseList"));
				courseList.get(0).click();
				waitForFixTime(1000);
				driver.findElement(FetchData.readOR("clickCourseLayer"))
						.click();
				System.out
						.println("Course Layer has been selected from compare layer");
				pass(child, "Course has been selected from compare layer");
			} else {
				System.out
						.println("Compare Course layer was not displayed as it's a course type Ranking Page");
				info(child,
						"Compare Course layer was not displayed as it's a course type Ranking Page");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CTALoggedOut(WebDriver driver, String city, String locality,
			String CTAtype, String page, ExtentTest child1) {
		try {
			CTA_Desktop cta_Desktop = new CTA_Desktop(driver, child1);
			// Filling Response Form
			clickCTA(driver, CTAtype, page, child1);

			if (page.equalsIgnoreCase("rankingPage")) {
				layerCheck(driver, child1);
			}

			elementWait(driver, 15,
					FetchData.readOR("responseFormIdentificationKey"));
			// waitForElement(driver, ".//i[@class='icons bl-logo']");
			cta_Desktop.cityWantToStudy();
			cta_Desktop.selectNearestCenter();
			cta_Desktop.selectCourse();
			cta_Desktop.selectExperience();
			cta_Desktop.selectExamsTaken();
			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss")
					.format(new Timestamp(System.currentTimeMillis()));
			cta_Desktop.enterEmailID("GuptaNewUser" + timeStamp
					+ "@shikshatest.com");
			cta_Desktop.enterPassword("shiksha");
			cta_Desktop.enterFirstName("GuptaFName" + timeStamp);
			cta_Desktop.enterLastName("GuptaLName" + timeStamp);
			cta_Desktop.enterMobile("9999999999");
			cta_Desktop.selectCity(city, locality);
			// ExtentTest child2 = CommonFunctions.createChild(ij.report, "",
			// obj.getcomponentDetailDescription());
			cta_Desktop.clickSubmit(CTAtype);
			if (!page.equalsIgnoreCase("AdmissionPage_Shortlistbellybutton")) {
				if ((!CTAtype.equalsIgnoreCase("scd"))
						&& (driver.findElements(
								FetchData.readOR("studentWhoShowedInterest"))
								.size() > 0)
						&& (!page
								.equalsIgnoreCase("CollegePredictorLaunchPage"))
						&& (!page.equalsIgnoreCase("CutOffPage"))
						&& (!page.equalsIgnoreCase("ComparePage"))) {
					cta_Desktop.getText(CTAtype);
					cta_Desktop.clickShortlistOnRecoLayer(page);
					cta_Desktop.clickDownloadBrochureOnRecoLayer(page);
					cta_Desktop.clickCompareOnRecoLayer(CTAtype, page);
					cta_Desktop.closeRecoLayer();
				} else if ((!CTAtype.equalsIgnoreCase("scd"))
						&& (driver.findElements(
								FetchData.readOR("studentWhoShowedInterest"))
								.size() == 0)
						&& (!page
								.equalsIgnoreCase("CollegePredictorLaunchPage"))
						&& (!page.equalsIgnoreCase("CutOffPage"))
						&& (!page.equalsIgnoreCase("ComparePage"))) {
					// info(child1,
					// "Reco Layer has been displayed but it does not have any recommended course");
					cta_Desktop.getText(CTAtype);
					cta_Desktop.closeRecoLayer();
				} else if (CTAtype.equalsIgnoreCase("scd")
						&& (!page
								.equalsIgnoreCase("CollegePredictorLaunchPage"))) {
					try {
						if (driver.findElement(FetchData
								.readOR("contactDetailToastMsg")) != null) {
							System.out
									.println("Contact Details have been mailed");
							pass(child1,
									"Contact Details have been mailed successfully");
						} else {
							System.out
									.println("CONTACT DETAILS have not been mailed");
							fail(child1,
									"Contact Details have not been mailed succefully");
						}
					} catch (Exception e) {
						fail(child1,
								"Contact Details have not been mailed succefully");
					}
				} else if (page.equalsIgnoreCase("CollegePredictorLaunchPage")
						|| page.equalsIgnoreCase("CutOffPage")) {
					if (CTAtype.equalsIgnoreCase("DEB")) {
						WebElement e1 = driver.findElement(FetchData
								.readOR("debDisableCutOffPage"));
						if (e1 != null) {
							System.out
									.println("Brochure has been downloaded on College Predictor Launch Page");
							pass(child1,
									"Brochure has been downloaded on College Predictor Launch Page");
						} else {
							System.out
									.println("Brochure has not been downloaded on College Predictor Launch Page");
							fail(child1,
									"Brochure has not been downloaded on College Predictor Launch Page");
						}
					}
					if (CTAtype.equalsIgnoreCase("Shortlist")) {
						try {
							WebElement e2 = driver.findElement(FetchData
									.readOR("shortlistedCutOffPage"));
							if (e2 != null) {
								System.out
										.println("Course has been shortlisted on College Predictor Launch Page");
								pass(child1,
										"Course has been shortlisted on College Predictor Launch Page");
							}
						} catch (Exception e) {
							fail(child1,
									"There is an error while shortlisting a Course.");
						}
					}
				} else if (page.equalsIgnoreCase("ComparePage")) {
					if (CTAtype.equalsIgnoreCase("DEB")) {
						if (driver.findElements(FetchData
								.readOR("comparePageDEBDone")) != null) {
							pass(child1,
									"Brochure has been downloaded on Compare Page");
						} else {
							fail(child1,
									"There is an issue while downloading brochure on Compare Page");
						}
					} else if (CTAtype.equalsIgnoreCase("shortlist")) {
						if (driver.findElement(FetchData
								.readOR("comparePageShortlistDone")) != null) {
							pass(child1,
									"Course has been successfully shortlisted");
						} else {
							fail(child1, "Course has not been shortlisted");
						}
					} else if (CTAtype.equalsIgnoreCase("AskNow")) {
						if (driver.findElements(
								FetchData.readOR("questionVerify")).size() > 0) {
							pass(child1,
									"Question has been posted successfully.");
						} else {
							fail(child1,
									"There is an issue while posting a question.");
						}
					}
				}
			} else {
				elementWait(driver, 30, FetchData.readOR("shortlstTxt"));
				if (driver.findElements(FetchData.readOR("shortlstTxt")).size() > 0) {
					pass(child1,
							"Course has been shortlisted successfully on Admission Page from shortlist belly button");
				} else {
					fail(child1,
							"Course has not been shortlisted on Admission Page from shortlist belly button");
				}
			}

			signOut(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void CTALogIn(WebDriver driver, String city, String locality,
			String CTAtype, String page, ExtentTest child1) {
		try {
			CTA_Desktop cta_Desktop = new CTA_Desktop(driver, child1);
			// Filling Response Form
			clickCTA(driver, CTAtype, page, child1);

			if (page.equalsIgnoreCase("rankingPage")) {
				layerCheck(driver, child1);
			}

			System.out.println("Waiting here for login");
			waitForFixTime(5000);

			// If login cases :

			// Login button
			driver.findElement(By.xpath("(.//a[contains(text(),'Login')])[2]"))
					.click();
			waitForFixTime(2000);
			// Email text box
			driver.findElement(By.xpath(".//input[@regfieldid='email']"))
					.sendKeys("cmsadmin@shiksha.com");
			waitForFixTime(2000);
			// Password text box
			driver.findElement(By.xpath(".//input[@regfieldid='password']"))
					.sendKeys("ShkCm$");
			waitForFixTime(2000);
			// Login button click
			driver.findElement(By.xpath(".//a[@type='submit']")).click();
			waitForFixTime(2000);

			// elementWait(driver, 15,
			// FetchData.readOR("responseFormIdentificationKey"));
			// waitForElement(driver, ".//i[@class='icons bl-logo']");
			// cta_Desktop.cityWantToStudy();
			// cta_Desktop.selectNearestCenter();
			// cta_Desktop.selectCourse();
			// cta_Desktop.selectExperience();
			// cta_Desktop.selectExamsTaken();
			// String timeStamp = new
			// SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new
			// Timestamp(System.currentTimeMillis()));
			// cta_Desktop.enterEmailID("GuptaNewUser" + timeStamp +
			// "@shikshatest.com");
			// cta_Desktop.enterPassword("shiksha");
			// cta_Desktop.enterFirstName("GuptaFName" + timeStamp);
			// cta_Desktop.enterLastName("GuptaLName" + timeStamp);
			// cta_Desktop.enterMobile("9999999999");
			// cta_Desktop.selectCity(city, locality);
			// ExtentTest child2 = CommonFunctions.createChild(ij.report, "",
			// obj.getcomponentDetailDescription());
			// cta_Desktop.clickSubmit(CTAtype);
			if (!page.equalsIgnoreCase("AdmissionPage_Shortlistbellybutton")) {
				if ((!CTAtype.equalsIgnoreCase("scd"))
						&& (driver.findElements(
								FetchData.readOR("studentWhoShowedInterest"))
								.size() > 0)
						&& (!page
								.equalsIgnoreCase("CollegePredictorLaunchPage"))
						&& (!page.equalsIgnoreCase("CutOffPage"))
						&& (!page.equalsIgnoreCase("ComparePage"))) {
					cta_Desktop.getText(CTAtype);
					cta_Desktop.clickShortlistOnRecoLayer(page);
					cta_Desktop.clickDownloadBrochureOnRecoLayer(page);
					cta_Desktop.clickCompareOnRecoLayer(CTAtype, page);
					cta_Desktop.closeRecoLayer();
				} else if ((!CTAtype.equalsIgnoreCase("scd"))
						&& (driver.findElements(
								FetchData.readOR("studentWhoShowedInterest"))
								.size() == 0)
						&& (!page
								.equalsIgnoreCase("CollegePredictorLaunchPage"))
						&& (!page.equalsIgnoreCase("CutOffPage"))
						&& (!page.equalsIgnoreCase("ComparePage"))) {
					// info(child1,
					// "Reco Layer has been displayed but it does not have any recommended course");
					cta_Desktop.getText(CTAtype);
					cta_Desktop.closeRecoLayer();
				} else if (CTAtype.equalsIgnoreCase("scd")
						&& (!page
								.equalsIgnoreCase("CollegePredictorLaunchPage"))) {
					try {
						if (driver.findElement(FetchData
								.readOR("contactDetailToastMsg")) != null) {
							System.out
									.println("Contact Details have been mailed");
							pass(child1,
									"Contact Details have been mailed successfully");
						} else {
							System.out
									.println("CONTACT DETAILS have not been mailed");
							fail(child1,
									"Contact Details have not been mailed succefully");
						}
					} catch (Exception e) {
						fail(child1,
								"Contact Details have not been mailed succefully");
					}
				} else if (page.equalsIgnoreCase("CollegePredictorLaunchPage")
						|| page.equalsIgnoreCase("CutOffPage")) {
					if (CTAtype.equalsIgnoreCase("DEB")) {
						WebElement e1 = driver.findElement(FetchData
								.readOR("debDisableCutOffPage"));
						if (e1 != null) {
							System.out
									.println("Brochure has been downloaded on College Predictor Launch Page");
							pass(child1,
									"Brochure has been downloaded on College Predictor Launch Page");
						} else {
							System.out
									.println("Brochure has not been downloaded on College Predictor Launch Page");
							fail(child1,
									"Brochure has not been downloaded on College Predictor Launch Page");
						}
					}
					if (CTAtype.equalsIgnoreCase("Shortlist")) {
						try {
							WebElement e2 = driver.findElement(FetchData
									.readOR("shortlistedCutOffPage"));
							if (e2 != null) {
								System.out
										.println("Course has been shortlisted on College Predictor Launch Page");
								pass(child1,
										"Course has been shortlisted on College Predictor Launch Page");
							}
						} catch (Exception e) {
							fail(child1,
									"There is an error while shortlisting a Course.");
						}
					}
				} else if (page.equalsIgnoreCase("ComparePage")) {
					if (CTAtype.equalsIgnoreCase("DEB")) {
						if (driver.findElements(FetchData
								.readOR("comparePageDEBDone")) != null) {
							pass(child1,
									"Brochure has been downloaded on Compare Page");
						} else {
							fail(child1,
									"There is an issue while downloading brochure on Compare Page");
						}
					} else if (CTAtype.equalsIgnoreCase("shortlist")) {
						if (driver.findElement(FetchData
								.readOR("comparePageShortlistDone")) != null) {
							pass(child1,
									"Course has been successfully shortlisted");
						} else {
							fail(child1, "Course has not been shortlisted");
						}
					} else if (CTAtype.equalsIgnoreCase("AskNow")) {
						if (driver.findElements(
								FetchData.readOR("questionVerify")).size() > 0) {
							pass(child1,
									"Question has been posted successfully.");
						} else {
							fail(child1,
									"There is an issue while posting a question.");
						}
					}
				}
			} else {
				elementWait(driver, 30, FetchData.readOR("shortlstTxt"));
				if (driver.findElements(FetchData.readOR("shortlstTxt")).size() > 0) {
					pass(child1,
							"Course has been shortlisted successfully on Admission Page from shortlist belly button");
				} else {
					fail(child1,
							"Course has not been shortlisted on Admission Page from shortlist belly button");
				}
			}

			signOut(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mouseHoverToUserIcon(WebDriver driver) throws Exception {
		elementWait(driver, 30, FetchData.readOR("userIcon"));
		System.out.println("Mouse hover to UserIcon");

		WebElement userIcon = driver.findElement(FetchData
				.readOR("userNameIcon"));
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView();", userIcon);
		Actions action = new Actions(driver);
		action.moveToElement(userIcon).build().perform();
	}

	public void clickSignOutButton(WebDriver driver) {
		try {
			elementWait(driver, 30, FetchData.readOR("logOutBtn"));
			if (driver.findElement(FetchData.readOR("logOutBtn")) != null) {
				System.out.println("");
				System.out.println("Clicking SignOut");
				driver.findElement(FetchData.readOR("logOutBtn")).click();
				waitForElement(driver, ".//div//a[@action='login']");
				if (driver.findElement(FetchData.readOR("loginBttn"))
						.isDisplayed()) {
					System.out.println("SignOut of user is done successfully");
					System.out.println("");
				} else {
					System.err
							.println("SignOut of user is not done successfully");
				}
			} else {
				System.out.println("Error -> Sign Out button is not there");
			}
		} catch (Exception e) {

		}
	}

	public void signOut(WebDriver driver) throws Exception {
		try {
			mouseHoverToUserIcon(driver);
			clickSignOutButton(driver);
		} catch (Exception e) {
			// Do nothing
		}
	}

	public void closeChild(ExtentTest parent, ExtentTest child,
			ExtentReports report) {
		// Date dd = child.getStartedTime();
		parent.appendChild(child);
		closeExtinctReport(parent, report);
	}

	public void closeChild(ExtentTest parent, ExtentTest child,
			ExtentReports report, String fail) {
		// Date dd = child.getStartedTime();
		parent.appendChild(child);
		closeExtinctReport(parent, report, fail);
	}

	public void closeExtinctReport(ExtentTest parent, ExtentReports report) {
		report.endTest(parent);
		report.flush();
		// report.close();
	}

	public void closeExtinctReport(ExtentTest parent, ExtentReports report,
			String fail) {
		if (fail.equalsIgnoreCase("fail"))
			parent.getTest().setStatus(LogStatus.FAIL);
		report.endTest(parent);
		if (fail.equalsIgnoreCase("fail"))
			parent.getTest().setStatus(LogStatus.FAIL);
		report.flush();
		// report.close();
	}

	public ExtentTest createParent(ExtentReports extent, String title,
			String description) {
		ExtentTest parent = extent.startTest(title, description);
		return parent;
	}

	public ExtentTest createChild(ExtentReports extent, String title,
			String description) {
		ExtentTest child = extent.startTest(title, description);
		return child;
	}

	public void pass(ExtentTest child, String description) {
		child.log(LogStatus.PASS, description);
	}

	public void pass(List<Object> child, String description) {
		try {
			((ExtentTest) child.get(1)).log(LogStatus.PASS, description);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void fail(WebDriver driver, ExtentTest child, String description) {
		String path = "";
		try {
			path = obj.getpath();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String format = "jpg";
			String SS_Path = "SS_" + sdf.format(timestamp) + "." + format;
			String fileName = path + "\\" + SS_Path;

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(fileName));
			child.log(
					LogStatus.FAIL,
					description
							+ child.addScreenCapture("./Screenshots/" + SS_Path));

		} catch (Exception e) {
			child.log(LogStatus.FAIL, description);
		}

	}

	public void fail(List<Object> child1, String description) {
		String path = "";
		ExtentTest child = (ExtentTest) child1.get(1);
		WebDriver driver = (WebDriver) child1.get(0);

		System.out.println(driver.getClass());

		try {
			path = obj.getpath();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String format = "jpg";
			String SS_Path = "SS_" + sdf.format(timestamp) + "." + format;
			String fileName = path + "\\" + SS_Path;

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(scrFile, new File(fileName));
			child.log(
					LogStatus.FAIL,
					description
							+ child.addScreenCapture("./Screenshots/" + SS_Path));

		} catch (Exception e) {
			child.log(LogStatus.FAIL, description);
		}

	}

	public void fail(ExtentTest child, String description) {
		String path = "";
		try {
			path = obj.getpath();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			Robot robot = new Robot();
			String format = "jpg";
			String SS_Path = "SS_" + sdf.format(timestamp) + "." + format;
			String fileName = path + "\\" + SS_Path;

			Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit()
					.getScreenSize());
			BufferedImage screenFullImage = robot
					.createScreenCapture(screenRect);
			ImageIO.write(screenFullImage, format, new File(fileName));
			child.log(
					LogStatus.FAIL,
					description
							+ child.addScreenCapture("./Screenshots/" + SS_Path));

		} catch (Exception e) {
			child.log(LogStatus.FAIL, description);
		}

	}

	public void info(List<Object> child1, String description) {
		ExtentTest child = (ExtentTest) child1.get(1);
		child.log(LogStatus.INFO, description);
	}

	public void info(ExtentTest child, String description) {
		child.log(LogStatus.INFO, description);
	}

	public void error(List<Object> child1, String description) {
		ExtentTest child = (ExtentTest) child1.get(1);
		child.log(LogStatus.ERROR, description);
	}

	public void error(ExtentTest child, String description) {
		child.log(LogStatus.ERROR, description);
	}

	public void warning(List<Object> child1, String description) {
		ExtentTest child = (ExtentTest) child1.get(1);
		child.log(LogStatus.WARNING, description);
	}

	public void warning(ExtentTest child, String description) {
		child.log(LogStatus.WARNING, description);
	}

	public void skip(List<Object> child1, String description) {
		ExtentTest child = (ExtentTest) child1.get(1);
		child.log(LogStatus.SKIP, description);
	}

	public void skip(ExtentTest child, String description) {
		child.log(LogStatus.SKIP, description);
	}

	public void logFail(String fail) {
		// reports.reportBody(fail, "fail");
		// Reporter.log(fail);
	}

	public void logCommon(String common) {
		// reports.reportBody(common, "common");
		// Reporter.log(common);
	}

	public void Loginapp(WebDriver driver, String email, String password)
			throws InterruptedException {
		driver.findElement(FetchData.readOR("login")).click();
		driver.findElement(FetchData.readOR("emailBox")).sendKeys(
				FetchData.readConfig(email));
		driver.findElement(FetchData.readOR("pswrdBox")).sendKeys(
				FetchData.readConfig(password));
		System.out.println(driver.findElement(FetchData.readOR("loginbtn"))
				.isDisplayed());
		driver.findElement(FetchData.readOR("loginbtn")).click();
		Thread.sleep(10000);
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("askheader"));
			boolean elementstatus = driver.findElement(
					FetchData.readOR("askheader")).isDisplayed();
			System.out.println("Login Successful" + elementstatus);
		} catch (Exception e) {
			System.out.println("Login Failed");
		}

	}

	public void closetour(WebDriver driver) {
		try {
			boolean elementstatus = driver.findElement(
					FetchData.readOR("closetour")).isDisplayed();
			if (elementstatus == true)
				driver.findElement(FetchData.readOR("closetour")).click();
			System.out.println("Tour close Successful");
		} catch (Exception e) {

			System.out.print("Tour close Failed or not available");
		}
	}

	public void logout(WebDriver driver) {
		App_Login login = new App_Login(driver);
		// CommonFunctions.closetour(driver);
		login.clickhembuger();
		login.clicklogout();
		// boolean checklogout=false;
		try {
			// checklogout =
			// driver.findElement(FetchData.readOR("emailBox")).isDisplayed();
			// //CommonFunctions.logPass("Logout Successfully:"
			// +String.valueOf(checklogout));
		} catch (Exception e) {
			// //CommonFunctions.logPass("Logout Failed:"
			// +String.valueOf(checklogout));
		}
	}

	public String RandomEmail(String domain) {
		String email = "shiksharandomemail@shiksha.com";
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());

			if (domain.contains(".")) {
				email = "Shiksha_" + sdf.format(timestamp) + "@" + domain;
			} else {
				email = "Shiksha_" + sdf.format(timestamp) + "@" + domain
						+ ".com";
			}
		} catch (Exception e) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			if (domain.contains(".")) {
				email = "Shiksha_" + sdf.format(timestamp) + "@" + domain;
			} else {
				email = "Shiksha_" + sdf.format(timestamp) + "@" + domain
						+ ".com";
			}
		}
		return email;
	}

	public String RandomNumber(char starts) {
		String number = "";
		try {
			String s1 = "x3333";
			s1 = s1.replace('x', starts);
			double d = Math.random();
			d = d * 100000.0;
			int i = (int) d;
			String s2 = String.valueOf(i);
			if (s2.contains("0")) {
				s2 = s2.replaceAll("0", "9");
			}
			String s3 = s1 + s2;
			if (s3.length() < 10) {
				s3 = s3 + "8989687";
			}
			if (s3.length() > 10) {
				number = s3.substring(0, 10);
			} else {
				number = s3;
			}
		} catch (Exception e) {
			number = "9333398787".replace('9', starts);
		}
		return number;
	}

	public String tuser(String email, Objects obj) {
		String userId = "";
		try {
			ResultSet rs = db.getInfotuser(email, obj);
			if (db.getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					userId = rs.getString("userid");
				}
			}

		} catch (Exception e) {

		}
		return userId;
	}

	public Boolean userResponseLocationAffinity(String email, String city_id,
			Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfouserResponseLocationAffinity(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("cityId");
					if (date.contains(city_id)) {
						flag = true;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean ComparePage_Tracking(String email, String trackId,
			Objects obj) {
		// System.out.println("Ffgf");
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfoComparePage_Tracking(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("creationTime");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd kk:mm");
					LocalDateTime now = LocalDateTime.now();
					String trackId1 = rs.getString("pageKeyId_1");
					String trackId2 = rs.getString("pageKeyId_2");
					now = now.plusMinutes(2);
					String datenow = dtf.format(now);
					now = now.minusMinutes(7);
					String datenow2 = dtf.format(now);
					Date actualDate = new SimpleDateFormat("yyyy-MM-dd kk:mm",
							Locale.ENGLISH).parse(date);
					Date timenow = new SimpleDateFormat("yyyy-MM-dd kk:mm",
							Locale.ENGLISH).parse(datenow);
					Date timelater = new SimpleDateFormat("yyyy-MM-dd kk:mm",
							Locale.ENGLISH).parse(datenow2);

					if ((actualDate.before(timenow) && actualDate
							.after(timelater))
							&& (trackId1.equalsIgnoreCase(trackId) || trackId2
									.equalsIgnoreCase(trackId))) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tresponsedata(String email, Objects obj) {
		Boolean flag = false;
		try {
			flag = db.getInfotresponsedata(email, obj);

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tUserInterest(String email, Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfotUserInterest(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("time");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tUserCourseSpecialization(String email, Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfotUserCourseSpecialization(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("time");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean responseLocationTable(String email, String institute_id,
			Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInforesponseLocationTable(email, obj);
			if (db.getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					String date = rs.getString("instituteLocationId");
					if (date.contains(institute_id)) {
						flag = true;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tUserAttributes(String email, Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfotUserAttributes(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("time");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tuserflag(String email, Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfotuserflag(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("lastModifiedOn");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tUserPref(String email, Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfotUserPref(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("SubmitDate");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tUserEducation(String email, Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfotUserPref(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("SubmitDate");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean user_response_profile(String email, Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfouser_response_profile(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					String date = rs.getString("submit_date");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						flag = true;
						break;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean latestUserResponseData(String email, Objects obj) {
		Boolean flag = false;
		try {
			ResultSet rs = db.getInfouser_response_profile(email, obj);
			if (db.getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					String date = rs.getString("modified_at");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy/MM/dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						flag = true;
					}
				}
			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean temp_response_queue(String email, String tracking_key,
			String listing_id, String listing_type, String action_type,
			Objects obj) {
		Boolean flag = false;
		System.out.println("");
		int count = 0;
		int actcount = 0;
		try {
			ResultSet rs = db.getInfotemp_response_queue(email, obj);
			if (db.getCountOfResultSet(rs) > 0) {
				while (rs.next()) {
					count = 0;
					actcount = 0;
					String date = rs.getString("submit_time");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy-MM-dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						if (tracking_key.length() > 0) {
							actcount++;
							if (rs.getString("tracking_key").equals(
									tracking_key))
								count++;
						}

						if (listing_id.length() > 1) {
							actcount++;
							if (rs.getString("listing_id").equals(listing_id))
								count++;
						}

						if (listing_type.length() > 1) {
							actcount++;
							if (rs.getString("listing_type").equals(
									listing_type))
								count++;
						}

						if (action_type.length() > 1) {
							actcount++;
							if (rs.getString("action_type").equals(action_type))
								count++;
						}
					}
					if (actcount == count) {
						flag = true;
						break;
					}
				}

			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tempLMSTable(String email, String tracking_key,
			String listing_id, String listing_type, Objects obj) {
		Boolean flag = false;
		int count = 0;
		int actcount = 0;
		try {
			ResultSet rs = db.getInfotempLMSTable(email, obj);
			if (db.getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					String date = rs.getString("submit_time");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy/MM/dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						if (tracking_key.length() > 0) {
							actcount++;
							if (rs.getString("tracking_key").equals(
									tracking_key))
								count++;
						}

						if (listing_id.length() > 1) {
							actcount++;
							if (rs.getString("listing_id").equals(listing_id))
								count++;
						}

						if (listing_type.length() > 1) {
							actcount++;
							if (rs.getString("listing_type").equals(
									listing_type))
								count++;
						}
					}
				}
				if (actcount == count) {
					flag = true;
				}

			}

		} catch (Exception e) {

		}
		return flag;
	}

	public Boolean tempLmsRequest(String email, String listing_id,
			String listing_type, Objects obj) {
		Boolean flag = false;
		int count = 0;
		int actcount = 0;
		try {
			ResultSet rs = db.getInfotempLmsRequest(email, obj);
			if (db.getCountOfResultSet(rs) == 1) {
				while (rs.next()) {
					String date = rs.getString("submit_time");
					DateTimeFormatter dtf = DateTimeFormatter
							.ofPattern("yyyy/MM/dd");
					LocalDateTime now = LocalDateTime.now();
					if (date.contains(dtf.format(now))) {
						if (listing_id.length() > 1) {
							actcount++;
							if (rs.getString("listing_id").equals(listing_id))
								count++;
						}

						if (listing_type.length() > 1) {
							actcount++;
							if (rs.getString("listing_type").equals(
									listing_type))
								count++;
						}
					}
				}
				if (actcount == count) {
					flag = true;
				}

			}

		} catch (Exception e) {

		}
		return flag;
	}

	public void clickhembuger(WebDriver driver) {
		try {
			driver.findElement(FetchData.readOR("hemburger")).click();
			// //CommonFunctions.logPass("Hemburger Button Click Successfully");
		} catch (Exception e) {
			// //CommonFunctions.logFail("Hemburger Button Click Failed");
			throw e;
		}
	}

	// TODO updated
	public String DynamicXpath(String id, String txt) {
		String[] element = new String[2];
		element = Variables.objects.get(id);
		String xpath = element[1];
		xpath = xpath.replaceAll("txtid", txt);
		return xpath;
	}

	public void scrollTo(WebDriver driver, WebElement we) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", we);
		js.executeScript("window.scrollBy(0,-50)");

	}

	public String studyAbroadUrl(String url) {
		if (!url.contains("studyabroad.")) {
			if (url.contains("www."))
				url = url.replaceAll("www.", "studyabroad.");
			else
				url = url.substring(0, 8) + "studyabroad."
						+ url.substring(8, url.length());
		}
		return url;
	}

	public String xpath_Dynamic(String id, String txt) {
		String[] webelement = new String[2];

		webelement = Variables.objects.get(id);

		String xpath = webelement[1];
		xpath = xpath.replaceAll("mohitlvl1", txt);
		return xpath;
	}

	public void OTPVerification_Abroad(WebDriver driver, String mobNumber,
			Objects obj) throws Exception {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("SAloginDesktop_OTP"));
			String OTP = db.OTPVerification(mobNumber, obj);
			driver.findElement(FetchData.readOR("SAloginDesktop_OTP"))
					.sendKeys(OTP);

			// // Click Verify OTP
			Variables.elementWait(driver, 10,
					FetchData.readOR("SAloginDesktop_OTPVerifyButton"));
			WebElement we = driver.findElement(FetchData
					.readOR("SAloginDesktop_OTPVerifyButton"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", we);
		}

		catch (Exception e) {
		}
	}

}
