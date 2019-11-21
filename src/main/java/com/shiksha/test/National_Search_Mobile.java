package com.shiksha.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.Mobile_SRP;
import com.shiksha.resourses.ExcelReader;
import com.shiksha.resourses.GenericFunction;

public class National_Search_Mobile {

	public void TestSearchFilters(Objects obj) throws InterruptedException {
		/*
		 * ExtentReports report = obj.getReport(); ExtentTest parent = obj.getParent();
		 */
		ExtentTest parent = obj.getNewParent();

		WebDriver driver = obj.getDriver();
		GenericFunction per = new GenericFunction(driver);
		String xls = "//Mobile//Filter Data";
		Mobile_SRP page = new Mobile_SRP(driver);
		String url = "";
		Random rand = new Random();
		ExtentTest child = null;
		HashMap<String, ExtentTest> childs = new HashMap<String, ExtentTest>();
		driver.get(obj.getURL());
		per.click_Cookie_Button();
		List<ExtentTest> listChild = new ArrayList<ExtentTest>();

		try {

			for (int i = 1; i <= ExcelReader.getRows(xls); i++) {
				if (ExcelReader.genericReadData(xls, i, "case").equalsIgnoreCase("CTP"))
					continue;
				url = obj.getURL() + ExcelReader.genericReadData(xls, i, "url");
				System.out.println(url);
				driver.get(url);
				page.click_Filter_Link();
				List<String> filterTabs = page.getFilterTabs();
				for (String ft : filterTabs) {
					System.out.println(ft);
					try {

						if (childs.containsKey(ft)) {
							// System.out.println("Here if");

							child = childs.get(ft);

						} else {
							/* System.out.println("Here else"); */
							child = per.createChild(parent, ft);
							listChild.add(child);
							childs.put(ft, child);

						}
						per.childInfo(child, "Iteration " + i);
						per.childInfo(child, url);
						/*
						 * genric.info(child, "Itration " + i); genric.info(child, url);
						 */
						List<Integer> fl = new ArrayList<Integer>();
						List<FilterData> filter = new ArrayList<FilterData>();
						// System.out.println("\t"+ft);
						page.setFilter(ft);
						Thread.sleep(2000);
						int c = page.getFilterCount();
						per.childInfo(child, "Total Filters in the Location Tab:" + c);
						// System.out.println("\t\t"+c);
						if (c != 0) {
							int r;
							if (ft.equalsIgnoreCase("Location") || ft.equalsIgnoreCase("SPECIALIZATION"))
								r = 1;
							else
								r = rand.nextInt(c) + 1;

							for (int j = 0; j < r; j++) {
								int p = rand.nextInt(c) + 1;
								if (!fl.contains(p)) {
									fl.add(p);
								}
							}
							per.childInfo(child, "Total filter to be selected from " + ft + " is/are :" + fl.size());
							// genric.info(child, "Total filter to be selected from " + ft + " is/are :" +
							// fl.size());
							// System.out.println("\t\t\t"+fl.size());

							for (int j = 0; j < fl.size(); j++) {
								if (j < 1)
									filter.add(new FilterData(page.selectFilter(fl.get(j), 1, child)));
								else
									filter.add(new FilterData(page.selectFilter(fl.get(j), fl.get(j - 1), child)));
							}
							per.childInfo(child, "---------------Validation----------------");
							// genric.info(child, "---------------Validation----------------");
							int count = 0;
							page.click_FilteredMore();
							Thread.sleep(1000);
							for (int j = 0; j < filter.size(); j++) {
								FilterData f = filter.get(j);
								if (count < f.getCount())
									count = f.getCount();

								if (page.isFilterSelected(f.getName())) {
									// System.out.println("\t\t\t"+f.getName()+"---->"+f.getCount()+" Filter
									// Selected");
									per.childPass(child,
											"The filter " + f.getName() + " is selected and verified successfully");
									/*
									 * genric.pass(child, "The filter " + f.getName() +
									 * " is selected and verified successfully");
									 */
								} else {
									// System.out.println("\t\t\t"+f.getName()+"---->"+f.getCount()+" Filter Not
									// Selected");
									per.childFail(child, "The filter " + f.getName() + " is not selected");
									// genric.fail(child, "The filter " + f.getName() + " is not selected");
								}
							}

							page.click_Apply_Filter();
							if (count >= page.count_College()) {
								per.childPass(child, "Total colleges displayed are <b>" + page.count_College()
										+ "</b> and Total Colleges to be displayed <b>" + count + "</b>");
								/*
								 * genric.pass(child, "Total colleges displayed are <b>" + page.count_College()
								 * + "</b> and Total Colleges to be displayed <b>" + count + "</b>");
								 */
							} else {
								per.childFail(child, "Total colleges displayed are <b>" + page.count_College()
										+ "</b> and Total Colleges to be displayed <b>" + count + "</b>");
								/*
								 * genric.fail(child, "Total colleges displayed are <b>" + page.count_College()
								 * + "</b> and Total Colleges to be displayed <b>" + count + "</b>");
								 */
							}
							// System.out.println("Calculated :-"+count);
							// System.out.println("College :- "+page.count_College());

							Thread.sleep(1000);

							page.click_Filter_Link();

						}
						// if(!childs.containsKey(ft))

					} catch (Exception e) {
						// if(!childs.containsKey(ft))

						e.printStackTrace();
					}
					Thread.sleep(1000);

				}
				ExtentTest chid = null;
				if (childs.containsKey("Clear All")) {
					chid = childs.get("Clear All");
				} else {
					chid = per.createChild(parent, "Clear All");
					childs.put("Clear All", chid);
					listChild.add(chid);
				}

				page.click_Clear_All(chid);
				Thread.sleep(2000);
				page.clearAllVerify(chid);

			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void PwaCtpFilter(Objects obj) throws InterruptedException {
		WebDriver driver = obj.getDriver();
		GenericFunction per = new GenericFunction(driver);
		ExtentTest parent = obj.getNewParent();
		String url = obj.getURL();
		String xls = "//Mobile//Filter Data";
		Mobile_SRP page = new Mobile_SRP(driver);
		Random rand = new Random();
		driver.get(obj.getURL());
		per.click_Cookie_Button();
		String turl = obj.getURL();
		if (obj.getserver().equalsIgnoreCase("live"))
			turl = "https://testpwa.shiksha.com/";
		HashMap<String, ExtentTest> childs = new HashMap<String, ExtentTest>();
		try {
			for (int i = 1; i <= ExcelReader.getRows(xls); i++) {
				try {
					if (ExcelReader.genericReadData(xls, i, "case").equalsIgnoreCase("search"))
						continue;
					url = turl + ExcelReader.genericReadData(xls, i, "url");
					driver.get(url);
					System.out.println(url);
					page.click_CTP_Filter_Btn();
					List<String> filters = page.get_CTP_FilterTabs();
					List<FilterData> filterSelected = new ArrayList<FilterData>();
					for (String filter : filters) {
						Thread.sleep(1000);
						System.out.println(filter);
						if (page.click_CTP_FilterTab(filter)) {
							ExtentTest child = null;
							if (childs.containsKey(filter))
								child = childs.get(filter);
							else {
								child = per.createChild(parent, filter);
								childs.put(filter, child);
							}
							per.childInfo(child, url);

							Thread.sleep(500);
							int count = page.count_CTP_Filters();
							per.childInfo(child, "Total available Filters :" + count);
							System.out.println(count);
							if (count > 0) {

								if (filter.equalsIgnoreCase("Location") || filter.equalsIgnoreCase("Specialization")) {
									int select = rand.nextInt(count);
									per.childInfo(child, "Filter to be selected at :" + select);
									String Selectedfilter = page.selectFilter(select, child);
									FilterData temp = new FilterData(Selectedfilter);
									System.out.println("\t\t" + temp.getName());
									filterSelected.add(temp);
								} else {
									List<Integer> select = per.genrateRandomList(count);
									for (int sel : select) {
										per.childInfo(child, "Filter to be selected at :" + (sel - 1));
										String Selectedfilter = page.selectFilter(sel - 1, child);
										FilterData temp = new FilterData(Selectedfilter);
										System.out.println("\t\t" + temp.getName());
										filterSelected.add(temp);
									}
								}
								page.click_CTP_ApplyFilter_Btn(child);

								//// Validation
								per.childInfo(child, "Validation");
								System.out.println(
										per.findInt(page.getCTP_SelectedFilterCount()) + "/" + filterSelected.size());
								page.click_CTP_Filter_Btn();
								Thread.sleep(2000);
								page.click_AllFilter_CTP();
								for (FilterData temp : filterSelected) {
									if (page.isCTPFilterSelected(temp.getName()))
										per.childPass(child, "Filter Verified successfully : " + temp.getName());
									else
										per.childFail(child, "Fail to verify Filter");
								}

							}
						}
					}
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Mobile_Search(Objects obj) throws InterruptedException {

		WebDriver driver = obj.getDriver();
		GenericFunction per = new GenericFunction(driver);
		// CommonFunctions genric = new CommonFunctions();
		String xls = "//Mobile//Search_Data_Mobile";
		Mobile_SRP page = new Mobile_SRP(driver);
		ExtentTest parent = obj.getNewParent();
		String url = obj.getURL();
		String data = "", stream = "", course = "", lnk = "", type = "", search_For = "", curl = "";
		driver.get(url);
		Thread.sleep(2000);
		driver.get(url);
		try {
			for (int i = 1; i <= ExcelReader.getRows(xls); i++) {
				driver.get(url);
				Thread.sleep(1000);
				driver.get(url);
				data = ExcelReader.genericReadData(xls, i, "Data");
				stream = ExcelReader.genericReadData(xls, i, "Stream");
				course = ExcelReader.genericReadData(xls, i, "Course");
				lnk = ExcelReader.genericReadData(xls, i, "LINK");
				type = ExcelReader.genericReadData(xls, i, "type");
				search_For = ExcelReader.genericReadData(xls, i, "search For");
				ExtentTest child = per.createChild(parent, search_For);
				per.childInfo(child, url);
				System.out.println(data + "---->" + stream + "---->" + course);
				page.click_Homepage_Search(child);
				page.click_Search(data, child);

				if (ExcelReader.genericReadData(xls, i, "Searchtype").equalsIgnoreCase("closed")) {
					page.click_Search_Suggestion(type, child);
					if (type.equalsIgnoreCase("University") || type.equalsIgnoreCase("College")) {
						page.click_Stream(child);
						page.choose_Stream(stream, child);
						if (!course.equalsIgnoreCase("")) {
							page.click_Course(child);
							page.choose_Course(course, child);
						}
						page.click_Search_Btn(child);
					}

				} else {

					page.click_Enter(child);
				}
				curl = driver.getCurrentUrl();
				if (curl.contains("&sa"))
					curl = curl.substring(0, curl.indexOf("&sa")) + curl.substring(curl.indexOf("&rf"), curl.length());
				curl = per.toRelativeURL(curl);
				if (lnk.contains("&sa"))
					lnk = lnk.substring(0, lnk.indexOf("&sa")) + lnk.substring(lnk.indexOf("&rf"), lnk.length());
				System.out.println("current url :   " + curl);
				System.out.println("Expected url:   " + lnk);
				per.childInfo(child, "Expected Url : " + lnk + "<br>Actual Url : " + curl);
				if (lnk.equalsIgnoreCase(curl))
					per.childPass(child, "URLs Validated Successfully");
				else
					per.childFail(child, "Fail to validate URLs");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}