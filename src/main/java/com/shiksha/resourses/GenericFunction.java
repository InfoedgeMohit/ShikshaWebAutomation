package com.shiksha.resourses;

import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.shiksha.main.Objects;

public class GenericFunction {
	WebDriver driver;
	JavascriptExecutor js; 
	public GenericFunction(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public String byXpath_To_StringXpath(By xpath) {
		String a = xpath.toString();

		return a.substring(10, a.length());
	}

	public List<Integer> genrateRandomList(int listLimit) {
		Random rand = new Random();
		int c = rand.nextInt(listLimit) + 1;
		List<Integer> k = new ArrayList<Integer>();
		for (int j = 0; j < c; j++) {
			int temp = rand.nextInt(listLimit) + 1;
			if (!k.contains(temp))
				k.add(temp);
		}
		Collections.sort(k);
		return k;
	}

	public float findFloat(String txt) {
		String s = "";
		boolean b = false;
		for (int i = 0; i < txt.length(); i++) {
			if (Character.isDigit(txt.charAt(i)) || txt.charAt(i) == '.') {
				s += txt.charAt(i);
				b = true;
			} else if (b)
				break;
		}

		try {
			return Float.parseFloat(s);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int findInt(String txt) {
		String s = "";
		boolean b = false;
		for (int i = 0; i < txt.length(); i++) {
			if (Character.isDigit(txt.charAt(i))) {
				s += txt.charAt(i);
				b = true;
			} else if (b)
				break;
		}

		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	public float[] SliderLimitsToFloat(String limits) {
		float leftL;
		float rightL;
		String l1 = limits.substring(0, limits.indexOf("\n"));
		String l2 = limits.substring(limits.indexOf("\n") + 1, limits.length());
		// System.out.println("L1 : "+l1+"\n L2 : "+l2);

		leftL = findFloat(l1);
		rightL = findFloat(l2);

		float[] a = new float[2];
		a[0] = leftL;
		a[1] = rightL;
		return a;
	}

	public void move_Up_Slider_Down(float x, WebElement we) {
		float pos = findFloat(we.getAttribute("style"));
		Actions ac = new Actions(driver);
		ac.clickAndHold(we).build().perform();
		int i = 0;
		while (pos > x) {
			ac.moveByOffset(0, 2).build().perform();
			pos = findFloat(we.getAttribute("style"));
			if (i++ > 20)
				break;
		}
		ac.release().build().perform();
	}

	public void move_Down_Slider_up(float x, WebElement we) {
		float pos = findFloat(we.getAttribute("style"));
		Actions ac = new Actions(driver);
		ac.clickAndHold(we).build().perform();
		int i = 0;
		while (pos < x) {
			ac.moveByOffset(0, -2).build().perform();
			pos = findFloat(we.getAttribute("style"));
			if (i++ > 20)
				break;
		}
		ac.release().build().perform();
	}

	public List<WebElement> findElementsByXpath(String xpath) {

		// TODO Auto-generated method stub
		return driver.findElements(By.xpath(xpath));
	}

	public WebElement findElementByXpath(String xpath) {
		// TODO Auto-generated method stub
		return driver.findElement(By.xpath(xpath));
	}

	public String removeExtraSpace(String txt) {

		while (txt.contains("\n\n"))
			txt = txt.replaceAll("\n\n", "\n");

		while (txt.contains(" \n"))
			txt = txt.replaceAll(" \n", "\n");
		while (txt.contains("  "))
			txt = txt.replaceAll("  ", " ");
		return txt.trim();
	}

	public boolean isAvailable(String xpath) {
		if (findElementsByXpath(xpath).size() > 0
				&& findElementByXpath(xpath).isDisplayed())
			return true;
		return false;
	}

	public String removeHTML(String txt) {
		String z = "";

		for (int i = 0; i < txt.length(); i++) {
			if (txt.charAt(i) == '<') {
				while (txt.charAt(i) != '>' && i < txt.length())
					i++;

			}
			z = z + txt.charAt(i);
		}

		z = z.replaceAll(">", "");
		String xls = "\\Resources\\Entitle List";
		try {
			int row = ExcelReader.getRows(xls);
			for (int i = 1; i < row; i++)
				z = z.replaceAll(
						ExcelReader.genericReadData(xls, i, "Entitle"),
						ExcelReader.genericReadData(xls, i, "Symbol"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return z.trim();
	}

	public void childPass(ExtentTest child, String msg) {
		child.log(Status.PASS, msg);
	}

	public void childFail(ExtentTest child, String msg) {
		String path = "";
		try {
			path = Variables.extinctScreenshotPath;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String format = "png";
			String SS_Path = "SS_" + sdf.format(timestamp) + "." + format;
			String fileName = path + "\\" + SS_Path;
			File DestFile = new File(fileName);
			if (!DestFile.exists())
				DestFile.createNewFile();
			final Screenshot screenshot = new AShot().shootingStrategy(
					new ViewportPastingStrategy(500)).takeScreenshot(driver);
			final BufferedImage image = screenshot.getImage();
			ImageIO.write(image, format, DestFile);

			child.log(Status.FAIL, msg);
			child.addScreenCaptureFromPath(fileName);
		} catch (Exception e) {

			child.log(Status.FAIL, msg);
		}
	}

	public void childInfo(ExtentTest child, String msg) {
		child.log(Status.INFO, msg);
	}

	public static ExtentReports getReport(Objects obj) {
		ExtentReports report = new ExtentReports();
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(
				Variables.extinctReportsPath + "//" + obj.getmoduleName()
						+ "_NewExtentReport.html");
		report.attachReporter(htmlReport);
		return report;
	}

	public static ExtentReports getRepor2t(String path, String moduleName) {

		String reportPath = path + "\\" + moduleName
		// + sdf.format(timestamp)
				+ "_NewExtentReport.html";

		ExtentReports report = new ExtentReports();
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(reportPath);
		report.attachReporter(htmlReport);
		return report;
	}

	public static ExtentTest createParent(ExtentReports report, Objects obj) {

		return report.createTest(obj.getcomponentDescription());
	}

	public static void closeReport(ExtentReports report) {
		report.flush();
	}

	public ExtentTest createChild(ExtentTest parent, String description) {
		return parent.createNode(description);
	}

	public String toRelativeURL(String url) {
		if (url.contains("infoedge.com") || url.contains("shiksha.com")) {
			url = url.substring(url.indexOf(".com") + 4, url.length());

			if (url.contains("/"))
				url = url.substring(url.indexOf("/"), url.length());
		}

		return url;
	}

	public void scrollTo(String xpath) {
		
		js.executeScript("arguments[0].scrollIntoView(true);",
				findElementByXpath(xpath));
		js.executeScript("window.scrollBy(0,-50)");

	}

	public void scrollTo(WebElement we) {
		
		js.executeScript("arguments[0].scrollIntoView(true);", we);
		js.executeScript("window.scrollBy(0,-50)");

	}
	public void scroll_To_Footer(WebElement we) {
		
		js.executeScript("arguments[0].scrollIntoView(true);", we);
	}

	public void scrollVerticalTo(int t) {
		
		// js.executeScript("arguments[0].scrollIntoView(true);", we);
		js.executeScript("window.scrollBy(0," + t + ")");
	}

	public void compareURL(String ExpectedUrl, String ActualUrl,
			ExtentTest child) {
		ExpectedUrl = toRelativeURL(ExpectedUrl);
		ActualUrl = toRelativeURL(ActualUrl);
		childInfo(child, "Expected Url : " + ExpectedUrl + "<br>Actual Url : "
				+ ActualUrl);
		if (ExpectedUrl.equalsIgnoreCase(ActualUrl))
			childPass(child, "URLs Validated Successfully");
		else
			childFail(child, "Fail to validate URLs");
	}

	static WebDriver openChromeInMobile() {
		System.setProperty("webdriver.chrome.driver",
				"C:/Common_Resources/jars/chromedriver.exe");
		HashMap<String, Object> deviceMetrices = new HashMap<String, Object>();
		deviceMetrices.put("width", 400);
		deviceMetrices.put("height", 600);
		// deviceMetrices.put("pixelRatio", 2);

		HashMap<String, Object> mobileEmulation = new HashMap<String, Object>();
		mobileEmulation.put("deviceMetrics", deviceMetrices);
		mobileEmulation.put("userAgent", "Android");
		// mobileEmulation.put("deviceName", "Nexus 5");
		HashMap<String, Object> chromeOptions = new HashMap<String, Object>();
		chromeOptions.put("mobileEmulation", mobileEmulation);

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();

		capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

		return new ChromeDriver(capabilities);
	}

	public void scrollUnTillVisible(String xpath) {
		int x = 0;
		
		js.executeScript("window.scrollBy(0,-2000)");
		while (!isAvailable(xpath) || x < 100) {
			js.executeScript("window.scrollBy(0,50)");
			x++;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		js.executeScript("window.scrollBy(0,200)");
	}

	public void wait_Till_Visible(String xpath) {
		int x = 0;
		while (isAvailable(xpath) && x < 30) {
			x++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void click_Cookie_Ok_Button(String url) {
		try {
			driver.get(url);
			Thread.sleep(3000);
			if (isAvailable("//*[@class='cookAgr-btn']"))
				findElementByXpath("//*[@class='cookAgr-btn']").click();

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public String DynamicXpath(String id, String txt) {
		String[] element = new String[2];
		element = Variables.objects.get(id);
		String xpath = element[1];
		xpath = xpath.replaceAll("txtid", txt);
		return xpath;
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

	public void clickOnXpathJS(String xpath) {
		js.executeScript("arguments[0].click();", findElementByXpath(xpath));
	}
	public void clickOnWEJS(WebElement we) {
		js.executeScript("arguments[0].click();", we);
	}
	public void click_Cookie_Button() {
		try {
			Thread.sleep(4000);
			if (isAvailable("//a[@class='cookAgr-btn']"))
				findElementByXpath("//a[@class='cookAgr-btn']").click();

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sleep(long arg){
		try {
			Thread.sleep(arg);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	/*
	 * public static void main(String[] args) { WebDriver driver =
	 * GenericFunction.openChromeInMobile(); GenericFunction per = new
	 * GenericFunction(driver); String xls = "temp ids"; try { int row =
	 * ExcelReader.getRows(xls); for(int i=1;i<=row;i++) {
	 * driver.get("https://shikshatest01.infoedge.com/university/-"
	 * +per.findInt(ExcelReader.genericReadData(xls, i, "id")));
	 * Thread.sleep(1000); if(per.isAvailable("//section[@id='wrapper-404']"))
	 * ExcelReader.setCellData(xls, "Sheet1", i, 1, "Fail"); else
	 * ExcelReader.setCellData(xls, "Sheet1", i, 1, "Pass");
	 * 
	 * ExcelReader.setCellData(xls, "Sheet1", i, 2,
	 * per.toRelativeURL(driver.getCurrentUrl()));
	 * 
	 * System.out.println(i+"/"+row);
	 * 
	 * } } catch (Exception e) { e.printStackTrace(); }
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}
