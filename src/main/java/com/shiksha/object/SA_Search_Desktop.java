package com.shiksha.object;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class SA_Search_Desktop {
	
	String finalResult;

	CommonFunctions CommonFunctions = new CommonFunctions();

	WebDriver driver;
	ExtentTest child;
	
	public SA_Search_Desktop(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;

	}
	public void OpenSearchLayer() throws Exception {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("OpenSearchLayer"));
			driver.findElement(FetchData.readOR("OpenSearchLayer")).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			throw e; // // Do nothing
		}
	}
	public void ClickOnSearchTextBox() {
		try {
			Variables.elementWait(driver, 10,
					FetchData.readOR("OpenSearchLayer"));
			driver.findElement(FetchData.readOR("OpenSearchLayer")).click();			
		} catch (Exception e) {
		}
	}
	public void TypeCourseText(String TypeText) throws Exception {
			try {
				Variables.elementWait(driver, 10,FetchData.readOR("ClickOnSearchBox"));
				driver.findElement(FetchData.readOR("ClickOnSearchBox")).sendKeys(
						TypeText);
				
			} catch (Exception e) {
				throw e; // // Do nothing
			}	
	}
	public void selectCourseFromSuggestor(String TypeText) {
		try {
			Variables.elementWait(driver, 10, FetchData.readOR("waitCourseSuggestorLayer"));
			Thread.sleep(2000);
			List<WebElement> courseList =  driver.findElements(By.xpath(".//span[@class='getName']"));
			int NumberOfElements = courseList.size();
			System.out.println("NumberOfElements is :: " + NumberOfElements);
			
			for(int i=0; i<NumberOfElements ; i++) {	
				System.out.println(courseList.get(i).getText());
				System.out.println("TypeText here is :: " + TypeText);
				if(TypeText.equalsIgnoreCase(courseList.get(i).getText())) {
					System.out.println("CourseName matched is :: " + courseList.get(i).getText());
					courseList.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
}
	public void TypeLocationText(String Location) throws Exception {
		try {
			Variables.elementWait(driver, 10,FetchData.readOR("SelectLocation"));
			driver.findElement(FetchData.readOR("SelectLocation")).sendKeys(Location);
		} catch (Exception e) {
			//throw e; // // Do nothing
		}	
}
	
	public void selectLocationFromSuggestor(String Location) {
		try {
		
		Variables.elementWait(driver, 10, FetchData.readOR("waitLocationSuggestorLayer"));
		
		java.util.List<WebElement> allLocations = 
				driver.findElements
				(By.xpath(".//*[@id='locSuggs']/ul/li/div/span[1]")); 
		int sizeOfLocationList = allLocations.size();
		
		for (int loop=0; loop<sizeOfLocationList ; loop++) {
			if(Location.equalsIgnoreCase(allLocations.get(loop).getText())){
				allLocations.get(loop).click();
				break;
			}
		}
		} catch (Exception e) {
			//throw e; // // Do nothing
		}
	}
	
	
	public void SelectFeesLeft() throws Exception {
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("SelectFees"));
			WebElement slider = driver.findElement(By.xpath(".//*[@id='feeSlider']/span[1]"));
			slider.click();
			slider.sendKeys(Keys.ARROW_RIGHT);
			slider.sendKeys(Keys.ARROW_RIGHT);
			slider.sendKeys(Keys.ARROW_RIGHT);
//			Variables.elementWait(driver, 10,
//					FetchData.readOR("SelectFees"));
//			driver.findElement(FetchData.readOR("SelectFees")).sendKeys(
//					SelectFees);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			throw e; // // Do nothing
		}	
}
	
	public void SelectFeesRight() throws Exception {
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("SelectFees"));
			WebElement slider = driver.findElement(By.xpath(".//*[@id='feeSlider']/span[2]"));
			slider.click();
			slider.sendKeys(Keys.ARROW_LEFT);
			slider.sendKeys(Keys.ARROW_LEFT);
			slider.sendKeys(Keys.ARROW_LEFT);
//			Variables.elementWait(driver, 10,
//					FetchData.readOR("SelectFees"));
//			driver.findElement(FetchData.readOR("SelectFees")).sendKeys(
//					SelectFees);
			
		} catch (Exception e) {
			System.out.println(e.toString());
			throw e; // // Do nothing
		}	
}
	//		Get fees details
	public void SelectedFees() throws Exception {
		try {
			String leftslider = driver.findElement(By.xpath("(//span[@class='leftLabel'])[1]")).getText();
			System.out.println("Left slider fees" + leftslider);
			String rightslider = driver.findElement(By.xpath("(//span[@class='rightLabel'])[1]")).getText();
			System.out.print("Right slider fees" + rightslider);
		} catch (Exception e) {
			throw e; // // Do nothing
		}	
}
	public void HitSearch() throws Exception {
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("HitSearch"));
			driver.findElement(FetchData.readOR("HitSearch")).click();
			
		} catch (Exception e) {
			throw e; // // Do nothing
		}	
}
	
	
	//Have to discuss
	public void FeesrightSlider(String rightFees) throws Exception {
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("FeesRightSlider"));
			driver.findElement(FetchData.readOR("FeesRightSlider")).click();
			
		} catch (Exception e) {
			throw e; // // Do nothing
		}	
}
	public void SelectExam(String exam) throws Exception {
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("SelectExam"));
			driver.findElement(FetchData.readOR("SelectExam")).click();
	
			
			List<WebElement> wef = driver.findElements(FetchData.readOR("SelectExamfromlist"));
		
			for (WebElement webElement : wef) {
				//System.out.println(webElement.getText());
				if(webElement.getText().equalsIgnoreCase(exam))
				{
					webElement.click();
					break;
				}
			}
			
			
			
		} catch (Exception e) {
			//throw e; // // Do nothing
		}	
}
	public void SelectExamLeft() throws Exception {
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("SelectFees"));
			WebElement slider = driver.findElement(By.xpath(".//*[@id='examScoreSlider']/span[1]"));
			slider.click();
			slider.sendKeys(Keys.ARROW_RIGHT);
			slider.sendKeys(Keys.ARROW_RIGHT);
			slider.sendKeys(Keys.ARROW_RIGHT);

			
		} catch (Exception e) {
			System.out.println(e.toString());
			throw e; // // Do nothing
		}	
}
	public void SelectExamRight() throws Exception {
		try {
			Variables.elementWait(driver, 5,
					FetchData.readOR("SelectFees"));
			WebElement slider = driver.findElement(By.xpath(".//*[@id='examScoreSlider']/span[2]"));
			slider.click();
			slider.sendKeys(Keys.ARROW_LEFT);
			slider.sendKeys(Keys.ARROW_LEFT);
			slider.sendKeys(Keys.ARROW_LEFT);

			
		} catch (Exception e) {
			System.out.println(e.toString());
			throw e; // // Do nothing
		}	
}
	public void SelectedExamRange() throws Exception {
		try {
			String Examleftslider = driver.findElement(By.xpath("(//span[@class='leftLabel'])[2]")).getText();
			System.out.println("Left slider Exam score" + Examleftslider);
			String Examrightslider = driver.findElement(By.xpath("(//span[@class='leftLabel'])[2]")).getText();
			System.out.println("Right slider Exam score" + Examrightslider);
		} catch (Exception e) {
			throw e; // // Do nothing
		}	
}
	public String getXmlContent(WebDriver driver, String nodeName, String attributeName, String attributeValue)
	{
		String pageSource = driver.getPageSource();
		String solrCount = getValueFromXML(pageSource, nodeName, attributeName, attributeValue);
		System.out.println("Solr Count: " + solrCount);
		return solrCount;

	}
	public String getValueFromXML(String xmlInString, String nodeName, String attributeName, String attributeValue)
	{
		String returnName = "";
		Document doc = null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlInString)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		NodeList resultNode = doc.getElementsByTagName(nodeName);
		System.out.println(resultNode.getLength());
		for(int j = 0; j < resultNode.getLength(); j++)
		{
			Element count = (Element)resultNode.item(j);
			String attributeNameXML = count.getAttribute(attributeName);
			if(attributeNameXML.equalsIgnoreCase(attributeValue))
			{
				returnName = count.getTextContent();
				System.out.println("Return Value: " + returnName);
			}
		}
		return returnName;
	}
	
	public void CategoryPage_LowToHigh_Fees() throws Exception {
		try {
			Thread.sleep(5000);
			Variables
					.elementWait(driver, 10, FetchData.readOR("Sorting_click"));
			Select oSelect = new Select(driver.findElement(FetchData
					.readOR("Sorting_click")));
			oSelect.selectByValue("fees_ASC");
			Thread.sleep(5000);
			Variables.elementWait(driver, 50,
					FetchData.readOR("Categorypage_Tupple"));
			List<WebElement> elements = driver.findElements(FetchData
					.readOR("fees"));
			List<Double> amounts = getAmountFromString(elements);
			boolean isLowToHigh = isAmountLowToHigh(amounts);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Category page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Fees Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Fees Failed");

			throw e;
		}

	}

	private boolean isAmountLowToHigh(List<Double> amounts) {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Double> copyAmounts = new ArrayList(amounts);
		Collections.sort(copyAmounts);

		System.out.println(" Original : "
				+ Arrays.toString(amounts.toArray()));
		System.out.println(" After Sorting : "
				+ Arrays.toString(copyAmounts.toArray()));
		CommonFunctions.info(
				child,
				" Original  : " + Arrays.toString(amounts.toArray())
						+     "  After Sorting : "
						+ Arrays.toString(copyAmounts.toArray()));

		for (int i = 0; i < amounts.size(); i++) {
			if (!amounts.get(i).equals(copyAmounts.get(i))) {
				return false;
			}
		}

		return true;

	}

	private List<Double> getAmountFromString(List<WebElement> elements) {

		List<Double> amountList = new ArrayList<>();

		for (int i = 0; i < elements.size(); i++) {

			WebElement webElement = elements.get(i);
			String[] parts = webElement.getText().trim().split(" ");

			if (parts.length < 3)
				continue;

			Double amount = 0.0;

			if ("Thousand".equalsIgnoreCase(parts[2])) {
				amount = Double.parseDouble(parts[1]) * 1000;
			} else if ("Lakh".equalsIgnoreCase(parts[2])
					|| "Lakhs".equalsIgnoreCase(parts[2])) {
				amount = Double.parseDouble(parts[1]) * 100000;
			} else if ("Crore".equalsIgnoreCase(parts[2])
					|| "Crores".equalsIgnoreCase(parts[2])) {
				amount = Double.parseDouble(parts[1]) * 10000000;
			} else if ("".equalsIgnoreCase(parts[2])) {
				amount = Double.parseDouble(parts[1]) * 1;
			}

			amountList.add(amount);
		}

		return amountList;
	}

	public void CategoryPage_HighToLow_Fees() throws Exception {
		try {
			Thread.sleep(5000);
			Variables
					.elementWait(driver, 10, FetchData.readOR("Sorting_click"));
			Select oSelect = new Select(driver.findElement(FetchData
					.readOR("Sorting_click")));
			oSelect.selectByValue("fees_DESC");
			Thread.sleep(5000);
			Variables.elementWait(driver, 50,
					FetchData.readOR("Categorypage_Tupple"));
			List<WebElement> elements = driver.findElements(FetchData
					.readOR("fees"));
			List<Double> amounts = getAmountFromString(elements);
			boolean isHighToLow = isAmountHighToLow(amounts);
			Assert.assertTrue(isHighToLow);
			System.out.println("Test Pass Category page | Is High to low ? "
					+ isHighToLow);
			if (isHighToLow) {
				CommonFunctions.pass(child, "Click on HighToLow Fees Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on HighToLow Fees Failed");
			throw e;
		}
	}

	private boolean isAmountHighToLow(List<Double> amounts) {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Double> copyAmounts = new ArrayList(amounts);
		Collections.sort(copyAmounts, Collections.reverseOrder());

		System.out.println(" Original  : "
				+ Arrays.toString(amounts.toArray()));
		System.out.println("After Sorting : "
				+ Arrays.toString(copyAmounts.toArray()));
		CommonFunctions.info(
				child,
				" Original  : " + Arrays.toString(amounts.toArray())
						 +     "    After Sorting : "
						+ Arrays.toString(copyAmounts.toArray()));
		for (int i = 0; i < amounts.size(); i++) {
			if (!amounts.get(i).equals(copyAmounts.get(i))) {
				return false;
			}
		}

		return true;
	}

	public void SearchPage_LowToHigh_Fees() throws Exception {
		try {
			Thread.sleep(5000);
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_Sorting_click"));
			Select oSelect = new Select(driver.findElement(FetchData
					.readOR("SP_Sorting_click")));
			oSelect.selectByValue("fees_asc");
			Thread.sleep(5000);
			Variables.elementWait(driver, 50,
					FetchData.readOR("Searchpage_Tupple"));
			List<WebElement> elements = driver.findElements(FetchData
					.readOR("SP_fees"));
			List<Double> amounts = getAmountFromString(elements);
			boolean isLowToHigh = isAmountLowToHigh(amounts);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Search page| Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Fees Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Fees Failed");
			throw e;
		}

	}

	public void SearchPage_HighToLow_Fees() throws Exception {
		try {
			Thread.sleep(5000);
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_Sorting_click"));
			Select oSelect = new Select(driver.findElement(FetchData
					.readOR("SP_Sorting_click")));
			oSelect.selectByValue("fees_desc");
			Thread.sleep(5000);
			Variables.elementWait(driver, 50,
					FetchData.readOR("Searchpage_Tupple"));
			List<WebElement> elements = driver.findElements(FetchData
					.readOR("SP_fees"));
			List<Double> amounts = getAmountFromString(elements);
			boolean isHighToLow = isAmountHighToLow(amounts);
			Assert.assertTrue(isHighToLow);
			System.out.println("Test Pass Search page| Is High to Low ? "
					+ isHighToLow);
			if (isHighToLow) {
				CommonFunctions.pass(child, "Click on HighToLow Fees Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on HighToLow Fees Failed");
			throw e;
		}
	}

	public void CategoryPage_LowToHigh_Exam() throws Exception {
		try {
			Thread.sleep(5000);
			Variables
					.elementWait(driver, 10, FetchData.readOR("Sorting_click"));
			Select oSelect = new Select(driver.findElement(FetchData
					.readOR("Sorting_click")));
			
			String Exam = driver.findElement(FetchData
					.readOR("getexamlowtohigh")).getText();
			 oSelect.selectByIndex(4);
				 Thread.sleep(5000);
				 System.out.println("My Text is :: " + Exam);
				 String[] Examtext = Exam.trim().split(" ");
				 System.out.println("My Text is :: " + Examtext[3]);
				 String amountString = Examtext[3].trim();
				 List<WebElement> elements = null;
				 
				 CommonFunctions.info(child," Exam Name : " +  amountString);
				 
				 if ("SAT".equalsIgnoreCase(amountString)) {
					 elements  = driver.findElements(FetchData
								.readOR("SATExam"));
				 }
				 else if ("GMAT".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GMATExam"));
				 }
				 else if ("GRE".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GREExam"));
				 }
				 else if ("IELTS".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("IELTSExam"));
				 }

				
			Variables.elementWait(driver, 50,
					FetchData.readOR("Categorypage_Tupple"));

			List<Double> amounts = CategorygetAmountFromExam(elements);
			boolean isLowToHigh = isAmountLowToHigh(amounts);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Category page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Exam Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Exam Failed");
			System.out.println(e);
			throw e;
		}

	}

	public void CategoryPage_HighToLow_Exam() throws Exception {
		try {
			Thread.sleep(5000);
			Variables
					.elementWait(driver, 10, FetchData.readOR("Sorting_click"));
			Select oSelect = new Select(driver.findElement(FetchData.readOR("Sorting_click")));
			 
			String Exam = driver.findElement(FetchData
					.readOR("getexamhightolow")).getText();
				oSelect.selectByIndex(5);
				 Thread.sleep(5000);
			 System.out.println("My Text is :: " + Exam);
			 String[] Examtext = Exam.trim().split(" ");
			 System.out.println("My Text is :: " + Examtext[3]);
			 String amountString = Examtext[3].trim();
			 List<WebElement> elements = null;
			 
			 CommonFunctions.info(child," Exam Name : " +  amountString);
			 
			 if ("SAT".equalsIgnoreCase(amountString)) {
				 elements  = driver.findElements(FetchData
							.readOR("SATExam"));
			 }
			 else if ("GMAT".equalsIgnoreCase(amountString)) 
			 {
				 elements  = driver.findElements(FetchData
							.readOR("GMATExam"));
			 }
			 else if ("GRE".equalsIgnoreCase(amountString)) 
			 {
				 elements  = driver.findElements(FetchData
							.readOR("GREExam"));
			 }
			 else if ("IELTS".equalsIgnoreCase(amountString)) 
			 {
				 elements  = driver.findElements(FetchData
							.readOR("IELTSExam"));
			 }
	
			
			 Variables.elementWait(driver, 50,
					FetchData.readOR("Categorypage_Tupple"));
			List<Double> amounts = CategorygetAmountFromExam(elements);
			boolean isHighToLow = isAmountHighToLow(amounts);
			Assert.assertTrue(isHighToLow);
			System.out.println("Test Pass Category page| Is High to Low ? "
					+ isHighToLow);
			if (isHighToLow) {
				CommonFunctions.pass(child, "Click on HighToLow Exam Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on HighToLow Exam Failed");
			throw e;
		}
	}


	private List<Double> CategorygetAmountFromExam(List<WebElement> elements) {

		List<Double> amountList = new ArrayList<>();

		for (int i = 0; i < elements.size(); i++) {
			if (elements.get(i).getText().toLowerCase().contains("sat")||elements.get(i).getText().toLowerCase().contains("gmat")||elements.get(i).getText().toLowerCase().contains("gre")||elements.get(i).getText().toLowerCase().contains("ielts"))
			{
				WebElement webElement = elements.get(i);
				String[] parts = webElement.getText().trim().split(":");
				String amountString = parts[1].trim();
				Double amount = Double.parseDouble(amountString);
				amountList.add(amount);
			}
		}
		return amountList;
	}
	


	public void SearchPage_LowToHigh_Exam() throws Exception {
		try {
			Thread.sleep(5000);
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_Sorting_click"));
			Select oSelect = new Select(driver.findElement(FetchData
					.readOR("SP_Sorting_click"))); 
			
			String Exam = driver.findElement(FetchData
					.readOR("getexamlowtohigh")).getText();
			 oSelect.selectByIndex(3);
				 Thread.sleep(5000);
				 System.out.println("My Text is :: " + Exam);
				 String[] Examtext = Exam.trim().split(" ");
				 String amountString = Examtext[3].trim();
				 System.out.println("My amountString is :: " + amountString);
				 List<WebElement> elements = null;
				 
				 	 
				 CommonFunctions.info(child," Exam Name : " +  amountString);
				 
				 if ("SAT".equalsIgnoreCase(amountString)) {
					 elements  = driver.findElements(FetchData
								.readOR("SATExam"));
				 }
				 else if ("GMAT".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GMATExam"));
				 }
				 else if ("GRE".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GREExam"));
				 }
				 else if ("IELTS".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("IELTSExam"));
				 }
				 
				 System.out.println("My elementall is :: " + elements);
				 String amountString1 = amountString + ":";
				 
				 
					ArrayList<String> myValues = new ArrayList<String>();
				 
				 for (int i = 0; i < elements.size(); i++)
				 {
					 System.out.println("My elementvalue is :: " + elements.get(i).getText());
				 if(elements.get(i).getText().contains(amountString1)) {
					 String temp = elements.get(i).getText().split(amountString1)[1];
					 
					 System.out.println("amount string 1 is ::" + amountString1);
					 System.out.println("My Value after split is ::" + temp );
					 finalResult = "";
					 for(int count=0;count<temp.length();count++) {
						 Character character = temp.charAt(count);
						 if(Character.isDigit(character) || character=='.') {
							 finalResult += character;    
						 }   
						 else {
							 break;
						 }
						 
					 }
					 
					 System.out.println("Name of Exam with colon is ::" + amountString1);
					 System.out.println("Final result is ::" + finalResult);
					 myValues.add(finalResult);
				 }	 
				 }
				 
				 System.out.println("All Values are :" + myValues);
				
			Variables.elementWait(driver, 50,
					FetchData.readOR("Searchpage_Tupple"));

			
			boolean isLowToHigh = isAmountLowToHighExam(myValues);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Category page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Exam Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Exam Failed");
			System.out.println(e);
			throw e;
		}

	}
	
	private boolean isAmountLowToHighExam(ArrayList<String> myValues) {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Double> copyAmounts = new ArrayList(myValues);
		Collections.sort(copyAmounts);

		System.out.println(" Original : "
				+ Arrays.toString(myValues.toArray()));
		System.out.println(" After Sorting : "
				+ Arrays.toString(copyAmounts.toArray()));
		CommonFunctions.info(
				child,
				" Original  : " + Arrays.toString(myValues.toArray())
						+     "  After Sorting : "
						+ Arrays.toString(copyAmounts.toArray()));

		for (int i = 0; i < myValues.size(); i++) {
			if (!myValues.get(i).equals(copyAmounts.get(i))) {
				return false;
			}
		}

		return true;

	}

	public void SearchPage_HighToLow_Exam() throws Exception {
		try {
			Thread.sleep(5000);
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_Sorting_click"));
			Select oSelect = new Select(driver.findElement(FetchData
					.readOR("SP_Sorting_click"))); 
			
			String Exam = driver.findElement(FetchData
					.readOR("getexamhightolow")).getText();
			 oSelect.selectByIndex(4);
				 Thread.sleep(5000);
				 System.out.println("My Text is :: " + Exam);
				 String[] Examtext = Exam.trim().split(" ");
				 String amountString = Examtext[3].trim();
				 System.out.println("My amountString is :: " + amountString);
				 List<WebElement> elements = null;
				 
				 	 
				 CommonFunctions.info(child," Exam Name : " +  amountString);
				 
				 if ("SAT".equalsIgnoreCase(amountString)) {
					 elements  = driver.findElements(FetchData
								.readOR("SATExam"));
				 }
				 else if ("GMAT".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GMATExam"));
				 }
				 else if ("GRE".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GREExam"));
				 }
				 else if ("IELTS".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("IELTSExam"));
				 }
				 
				 System.out.println("My elementall is :: " + elements);
				 String amountString1 = amountString + ":";
				 
				 
					ArrayList<String> myValues = new ArrayList<String>();
				 
				 for (int i = 0; i < elements.size(); i++)
				 {
					 System.out.println("My elementvalue is :: " + elements.get(i).getText());
				 if(elements.get(i).getText().contains(amountString1)) {
					 String temp = elements.get(i).getText().split(amountString1)[1];
					 
					 System.out.println("amount string 1 is ::" + amountString1);
					 System.out.println("My Value after split is ::" + temp );
					 finalResult = "";
					 for(int count=0;count<temp.length();count++) {
						 Character character = temp.charAt(count);
						 if(Character.isDigit(character) || character=='.') {
							 finalResult += character;    
						 }   
						 else {
							 break;
						 }
						 
					 }
					 
					 System.out.println("Name of Exam with colon is ::" + amountString1);
					 System.out.println("Final result is ::" + finalResult);
					 myValues.add(finalResult);
				 }	 
				 }
				 
				 System.out.println("All Values are :" + myValues);
				
			Variables.elementWait(driver, 50,
					FetchData.readOR("Searchpage_Tupple"));

			
			boolean isLowToHigh = isAmountHighToLowExam(myValues);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Category page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Exam Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Exam Failed");
			System.out.println(e);
			throw e;
		}

	}
	
	private boolean isAmountHighToLowExam(ArrayList<String> myValues) {

		@SuppressWarnings({ "rawtypes", "unchecked" })
		List<Double> copyAmounts = new ArrayList(myValues);
		Collections.sort(copyAmounts, Collections.reverseOrder());

		System.out.println(" Original : "
				+ Arrays.toString(myValues.toArray()));
		System.out.println(" After Sorting : "
				+ Arrays.toString(copyAmounts.toArray()));
		CommonFunctions.info(
				child,
				" Original  : " + Arrays.toString(myValues.toArray())
						+     "  After Sorting : "
						+ Arrays.toString(copyAmounts.toArray()));

		for (int i = 0; i < myValues.size(); i++) {
			if (!myValues.get(i).equals(copyAmounts.get(i))) {
				return false;
			}
		}

		return true;

	}

	
	public void CategoryPage_LowToHigh_Fees_Mobile() throws Exception {
		try {
			Thread.sleep(5000);
			Variables.elementWait(driver, 10,
					FetchData.readOR("Sorting_click_mobile"));
			driver.findElement(FetchData.readOR("Sorting_click_mobile"))
					.click();
			Variables.elementWait(driver, 10,
					FetchData.readOR("LowToHigh_mobile"));
			driver.findElement(FetchData.readOR("LowToHigh_mobile")).click();
			Thread.sleep(5000);
			Variables.elementWait(driver, 50,
					FetchData.readOR("Categorypage_TuppleMobile"));
			List<WebElement> elements = driver.findElements(FetchData
					.readOR("fees_mobile"));
			System.out.println("elements value is :" + elements);
			List<Double> amounts = getAmountFromString(elements);
			boolean isLowToHigh = isAmountLowToHigh(amounts);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Category page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Failed");
			throw e;
		}

	}

	public void CategoryPage_HighToLow_Fees_Mobile() throws Exception {
		try {
			Thread.sleep(5000);
			Variables.elementWait(driver, 10,
					FetchData.readOR("Sorting_click_mobile"));
			driver.findElement(FetchData.readOR("Sorting_click_mobile"))
					.click();
			Variables.elementWait(driver, 10,
					FetchData.readOR("HighToLow_mobile"));
			driver.findElement(FetchData.readOR("HighToLow_mobile")).click();
			Thread.sleep(5000);
			Variables.elementWait(driver, 50,
					FetchData.readOR("Categorypage_TuppleMobile"));
			List<WebElement> elements = driver.findElements(FetchData
					.readOR("fees_mobile"));
			List<Double> amounts = getAmountFromString(elements);
			boolean isHighToLow = isAmountHighToLow(amounts);
			Assert.assertTrue(isHighToLow);
			System.out.println("Test Pass Category page | Is High to low ? "
					+ isHighToLow);
			if (isHighToLow) {
				CommonFunctions.pass(child, "Click on HighToLow Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on HighToLow Failed");
			throw e;
		}
	}

	public void SearchPage_LowToHigh_Fees_Mobile() throws Exception {
		try {
			Thread.sleep(5000);
			try {
			driver.findElement(By.xpath(".//*[@id='coachMarks']")).click();
			}
			catch (Exception e) {
				
			}
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_Sorting_click_mobile"));
			driver.findElement(FetchData.readOR("SP_Sorting_click_mobile"))
					.click();
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_LowToHigh_mobile"));
			driver.findElement(FetchData.readOR("SP_LowToHigh_mobile")).click();
			Thread.sleep(5000);
			Variables.elementWait(driver, 50,
					FetchData.readOR("Searchpage_TuppleMobile"));
			List<WebElement> elements = driver.findElements(FetchData
					.readOR("SP_fees_mobile"));
			List<Double> amounts = getAmountFromString(elements);
			boolean isLowToHigh = isAmountLowToHigh(amounts);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Search page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Failed");
			throw e;
		}

	}

	public void SearchPage_HighToLow_Fees_Mobile() throws Exception {
		try {
			Thread.sleep(5000);
			try {
				driver.findElement(By.xpath(".//a[@id='cmarkOkButton']")).click();
				}
				catch (Exception e) {
					
				}
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_Sorting_click_mobile"));
			driver.findElement(FetchData.readOR("SP_Sorting_click_mobile"))
					.click();
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_HighToLow_mobile"));
			driver.findElement(FetchData.readOR("SP_HighToLow_mobile")).click();
			Thread.sleep(5000);
			Variables.elementWait(driver, 50,
					FetchData.readOR("Searchpage_TuppleMobile"));
			List<WebElement> elements = driver.findElements(FetchData
					.readOR("SP_fees_mobile"));
			List<Double> amounts = getAmountFromString(elements);
			boolean isHighToLow = isAmountHighToLow(amounts);
			Assert.assertTrue(isHighToLow);
			System.out.println("Test Pass Search page | Is High to low ? "
					+ isHighToLow);
			if (isHighToLow) {
				CommonFunctions.pass(child, "Click on HighToLow Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on HighToLow Failed");
			throw e;
		}
	}
	
	

	public void CategoryPage_LowToHigh_Exam_Mobile() throws Exception {
		try {
			Thread.sleep(5000);
			Variables.elementWait(driver, 10,
					FetchData.readOR("Sorting_click_mobile"));
			driver.findElement(FetchData.readOR("Sorting_click_mobile")).click();
			
			String Exam = driver.findElement(FetchData
					.readOR("getexamlowtohigh_mobile")).getText();
			
			Variables.elementWait(driver, 10,
					FetchData.readOR("getexamlowtohigh_mobile"));
			driver.findElement(FetchData.readOR("getexamlowtohigh_mobile")).click();
			
				 Thread.sleep(5000);
				 System.out.println("My Text is :: " + Exam);
				 String[] Examtext = Exam.trim().split(" ");
				 System.out.println("My Text is :: " + Examtext[3]);
				 String amountString = Examtext[3].trim();
				 List<WebElement> elements = null;
				 
				 CommonFunctions.info(child," Exam Name : " +  amountString);
				 
				 
				 if ("SAT".equalsIgnoreCase(amountString)) {
					 elements  = driver.findElements(FetchData
								.readOR("SATExam_mobile"));
				 }
				 else if ("GMAT".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GMATExam_mobile"));
				 }
				 else if ("GRE".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GREExam_mobile"));
				 }
				 else if ("IELTS".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("IELTSExam_mobile"));
				 }
		
				

			List<Double> amounts = CategorygetAmountFromExam(elements);
			boolean isLowToHigh = isAmountLowToHigh(amounts);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Category page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Exam Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Exam Failed");
			System.out.println(e);
			throw e;
		}

	}

	public void CategoryPage_HighToLow_Exam_Mobile() throws Exception {
		try {
			Thread.sleep(5000);
			Variables.elementWait(driver, 10,
					FetchData.readOR("Sorting_click_mobile"));
			driver.findElement(FetchData.readOR("Sorting_click_mobile")).click();
			
			String Exam = driver.findElement(FetchData
					.readOR("getexamhightolow_mobile")).getText();
			
			Variables.elementWait(driver, 10,
					FetchData.readOR("getexamhightolow_mobile"));
			driver.findElement(FetchData.readOR("getexamhightolow_mobile")).click();
			
			 Thread.sleep(5000);
			 System.out.println("My Text is :: " + Exam);
			 String[] Examtext = Exam.trim().split(" ");
			 System.out.println("My Text is :: " + Examtext[3]);
			 String amountString = Examtext[3].trim();
			 List<WebElement> elements = null;
			 
			 CommonFunctions.info(child," Exam Name : " +  amountString);
			 
			 if ("SAT".equalsIgnoreCase(amountString)) {
				 elements  = driver.findElements(FetchData
							.readOR("SATExam_mobile"));
			 }
			 else if ("GMAT".equalsIgnoreCase(amountString)) 
			 {
				 elements  = driver.findElements(FetchData
							.readOR("GMATExam_mobile"));
			 }
			 else if ("GRE".equalsIgnoreCase(amountString)) 
			 {
				 elements  = driver.findElements(FetchData
							.readOR("GREExam_mobile"));
			 }
			 else if ("IELTS".equalsIgnoreCase(amountString)) 
			 {
				 elements  = driver.findElements(FetchData
							.readOR("IELTSExam_mobile"));
			 }
	
			

			List<Double> amounts = CategorygetAmountFromExam(elements);
			boolean isHighToLow = isAmountHighToLow(amounts);
			Assert.assertTrue(isHighToLow);
			System.out.println("Test Pass Category page| Is High to Low ? "
					+ isHighToLow);
			if (isHighToLow) {
				CommonFunctions.pass(child, "Click on HighToLow Exam Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on HighToLow Exam Failed");
			throw e;
		}
	}
	
	public void SearchPage_LowToHigh_Exam_mobile() throws Exception {
		try {
			Thread.sleep(5000);
			try {
				driver.findElement(By.xpath(".//a[@id='cmarkOkButton']")).click();
				}
				catch (Exception e) {
					
				}
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_Sorting_click_mobile"));
			driver.findElement(FetchData.readOR("SP_Sorting_click_mobile"))
					.click();
			String Exam = driver.findElement(FetchData
					.readOR("getexamlowtohigh_SPmobile")).getText();
			Variables.elementWait(driver, 10,
					FetchData.readOR("getexamlowtohigh_SPmobile"));
			driver.findElement(FetchData.readOR("getexamlowtohigh_SPmobile")).click();
			Thread.sleep(5000);
			

				 System.out.println("My Text is :: " + Exam);
				 String[] Examtext = Exam.trim().split(" ");
				 String amountString = Examtext[3].trim();
				 System.out.println("My amountString is :: " + amountString);
				 List<WebElement> elements = null;
				 
				 	 
				 CommonFunctions.info(child," Exam Name : " +  amountString);
				 
				 if ("SAT".equalsIgnoreCase(amountString)) {
					 elements  = driver.findElements(FetchData
								.readOR("SATExam_mobileSP"));
				 }
				 else if ("GMAT".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GMATExam_mobileSP"));
				 }
				 else if ("GRE".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GREExam_mobileSP"));
				 }
				 else if ("IELTS".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("IELTSExam_mobileSP"));
				 }
				 
				 System.out.println("My elementall is :: " + elements);
				 String amountString1 = amountString + ":";
				 
				 
					ArrayList<String> myValues = new ArrayList<String>();
				 
				 for (int i = 0; i < elements.size(); i++)
				 {
					 System.out.println("My elementvalue is :: " + elements.get(i).getText());
				 if(elements.get(i).getText().contains(amountString1)) {
					 String temp = elements.get(i).getText().split(amountString1)[1];
					 
					 System.out.println("amount string 1 is ::" + amountString1);
					 System.out.println("My Value after split is ::" + temp );
					 finalResult = "";
					 for(int count=0;count<temp.length();count++) {
						 Character character = temp.charAt(count);
						 if(Character.isDigit(character) || character=='.') {
							 finalResult += character;    
						 }   
						 else {
							 break;
						 }
						 
					 }
					 
					 System.out.println("Name of Exam with colon is ::" + amountString1);
					 System.out.println("Final result is ::" + finalResult);
					 myValues.add(finalResult);
				 }	 
				 }
				 
				 System.out.println("All Values are :" + myValues);
				
			
			boolean isLowToHigh = isAmountLowToHighExam(myValues);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Category page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Exam Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Exam Failed");
			System.out.println(e);
			throw e;
		}

	}
	
	
	public void SearchPage_HighToLow_Exam_mobile() throws Exception {
		try {
			Thread.sleep(5000);
			try {
				driver.findElement(By.xpath(".//a[@id='cmarkOkButton']")).click();
				}
				catch (Exception e) {
					
				}
			Variables.elementWait(driver, 10,
					FetchData.readOR("SP_Sorting_click_mobile"));
			driver.findElement(FetchData.readOR("SP_Sorting_click_mobile"))
					.click();
			String Exam = driver.findElement(FetchData
					.readOR("getexamhightolow_SPmobile")).getText();
			Variables.elementWait(driver, 10,
					FetchData.readOR("getexamhightolow_SPmobile"));
			driver.findElement(FetchData.readOR("getexamhightolow_SPmobile")).click();
			Thread.sleep(5000);
				 System.out.println("My Text is :: " + Exam);
				 String[] Examtext = Exam.trim().split(" ");
				 String amountString = Examtext[3].trim();
				 System.out.println("My amountString is :: " + amountString);
				 List<WebElement> elements = null;
				 
				 	 
				 CommonFunctions.info(child," Exam Name : " +  amountString);
				 
				 if ("SAT".equalsIgnoreCase(amountString)) {
					 elements  = driver.findElements(FetchData
								.readOR("SATExam_mobileSP"));
				 }
				 else if ("GMAT".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GMATExam_mobileSP"));
				 }
				 else if ("GRE".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("GREExam_mobileSP"));
				 }
				 else if ("IELTS".equalsIgnoreCase(amountString)) 
				 {
					 elements  = driver.findElements(FetchData
								.readOR("IELTSExam_mobileSP"));
				 }
				 
				 
				 System.out.println("My elementall is :: " + elements);
				 String amountString1 = amountString + ":";
				 
				 
					ArrayList<String> myValues = new ArrayList<String>();
				 
				 for (int i = 0; i < elements.size(); i++)
				 {
					 System.out.println("My elementvalue is :: " + elements.get(i).getText());
				 if(elements.get(i).getText().contains(amountString1)) {
					 String temp = elements.get(i).getText().split(amountString1)[1];
					 
					 System.out.println("amount string 1 is ::" + amountString1);
					 System.out.println("My Value after split is ::" + temp );
					 finalResult = "";
					 for(int count=0;count<temp.length();count++) {
						 Character character = temp.charAt(count);
						 if(Character.isDigit(character) || character=='.') {
							 finalResult += character;    
						 }   
						 else {
							 break;
						 }
						 
					 }
					 
					 System.out.println("Name of Exam with colon is ::" + amountString1);
					 System.out.println("Final result is ::" + finalResult);
					 myValues.add(finalResult);
				 }	 
				 }
				 
				 System.out.println("All Values are :" + myValues);
				
			
			boolean isLowToHigh = isAmountHighToLowExam(myValues);
			Assert.assertTrue(isLowToHigh);
			System.out.println("Test Pass Category page | Is Low to High ? "
					+ isLowToHigh);
			if (isLowToHigh) {
				CommonFunctions.pass(child, "Click on LowToHigh Exam Passed");
			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "Click on LowToHigh Exam Failed");
			System.out.println(e);
			throw e;
		}

	}
	

}