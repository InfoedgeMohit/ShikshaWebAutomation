package com.shiksha.resourses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import javax.sql.DataSource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Variables {
	public static HashMap<String, HashMap<String, String[]>> driverExcelObject = new HashMap<String, HashMap<String, String[]>>();
	public static Properties prop = new Properties();
	public static InputStream input = null;
	public static HashMap<String, String[]> objects = new HashMap<String, String[]>();
	public static HashMap<String, String> hamburgerSpcilization = new HashMap<String, String>();
	public static String extinctReportsPath = "";
	public static String extinctScreenshotPath = "";
	public static String instituteId = "";
	public static String universityId = "";
	public static String courseId = "";
	public static String instituteIdName = "Automation Testing Institute";
	public static String universityIdName = "Automation Testing University";
	public static String courseIdName = "Shiksha Automation Testing";
	public static DataSource dataSource = null;

	// // Not Used
	static public WebDriver driver;
	public static String browser = "";
	public static Integer stepId = 1;
	public static String device = "";
	public static String fname = "asdf";
	public static String lname = "ghjkl";
	public static String pswrd = "shiksha";

	// public static String reportPath = "";
	// public static String Url = "";
	// public static String screenshots = "";
	// public static StringBuilder reportHTML = new StringBuilder();
	// public static Reports reports = Reports.getInstance();

	public static void createExtinctReportPath() {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String path = new java.io.File(".").getCanonicalPath()
					+ "\\src\\test\\resources" + "\\Reports\\"
					+ sdf.format(timestamp);
			File file = new File(path);
			file.mkdir();
			extinctReportsPath = path;

			String path1 = path + "\\Screenshots";
			File file2 = new File(path1);
			file2.mkdir();
			extinctScreenshotPath = path1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// //
		}
	}

	public static String dummytxt(String typetxt) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String dummytext = "test " + typetxt + " " + randomInt + " " + "test "
				+ typetxt + " " + randomInt + " " + "test " + typetxt + " "
				+ randomInt + " " + "test " + typetxt + " " + randomInt;
		return dummytext;
	}

	public static String randomemailgenrator() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		String email = "testusermobileapp" + randomInt + "@gmail.com";
		return email;
	}

	public static void elementWait(WebDriver driver, int timeinsec, By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeinsec);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			throw e;
		}
	}

	public static void elementWait_old(WebDriver driver, int timeinsec,
			By element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeinsec);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		}

		catch (Exception e) {
			Robot rb = new Robot();
			for (int i = 0; i < 6; i++) {
				rb.keyPress(KeyEvent.VK_DOWN);
				rb.keyRelease(KeyEvent.VK_DOWN);
				if (driver.findElement(element) != null) {
					break;
				}
			}
			throw e;
		}
	}
}
