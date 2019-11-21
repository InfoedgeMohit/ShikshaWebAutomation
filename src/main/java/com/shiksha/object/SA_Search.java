package com.shiksha.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class SA_Search {
	
	String finalResult;

	
	WebDriver driver;
	ExtentTest child;
	CommonFunctions CommonFunctions = new CommonFunctions();

	public SA_Search(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child = child;
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
				Variables.elementWait(driver, 10, FetchData.readOR("Cookie_OKK"));
				driver.findElement(FetchData.readOR("Cookie_OKK")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("coachMarks"));
				driver.findElement(FetchData.readOR("coachMarks")).click();
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
				Variables.elementWait(driver, 10, FetchData.readOR("Cookie_OKK"));
				driver.findElement(FetchData.readOR("Cookie_OKK")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("coachMarks"));
				driver.findElement(FetchData.readOR("coachMarks")).click();
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
				Variables.elementWait(driver, 10, FetchData.readOR("Cookie_OKK"));
				driver.findElement(FetchData.readOR("Cookie_OKK")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("coachMarks"));
				driver.findElement(FetchData.readOR("coachMarks")).click();
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
				Variables.elementWait(driver, 10, FetchData.readOR("Cookie_OKK"));
				driver.findElement(FetchData.readOR("Cookie_OKK")).click();
				Variables.elementWait(driver, 10, FetchData.readOR("coachMarks"));
				driver.findElement(FetchData.readOR("coachMarks")).click();
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