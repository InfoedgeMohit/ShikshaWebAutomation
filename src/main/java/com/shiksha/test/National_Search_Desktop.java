package com.shiksha.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import org.openqa.selenium.WebDriver;


import com.aventstack.extentreports.ExtentTest;

import com.shiksha.main.Objects;
import com.shiksha.object.CLP;
import com.shiksha.object.Desktop_Keyword_Search;
import com.shiksha.resourses.ExcelReader;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.InputsAndPlaceHolder;

class FilterData {
	private String name;
	private int count;

	public String getName() {
		return name;
	}

	public int getCount() {
		return count;
	}

	public FilterData(String data) {
		try {

			name = data.substring(0, data.indexOf("("));
			name = name.trim();
			count = Integer.parseInt(data.substring(data.lastIndexOf("(") + 1, data.lastIndexOf(")")));

		} catch (Exception ex) {
			System.out.println("Invalid Data :" + data);

			ex.printStackTrace();
		}
	}
}

public class National_Search_Desktop {

	public void AdvanceSearch(Objects obj) throws InterruptedException {

		WebDriver driver = obj.getDriver();

		GenericFunction per=new GenericFunction(driver);
		//com.aventstack.extentreports.ExtentReports report=per.getReport(obj);
		//ExtentReports report = obj.getReport();
		com.aventstack.extentreports.ExtentTest parent=obj.getNewParent();
		//ExtentTest parent = obj.getParent();
		String url =obj.getURL();
		

		driver.get(url);
		//CommonFunctions genric = new CommonFunctions();
		String sheetloc = "//Desktop//Search_Data";
		Desktop_Keyword_Search page = new Desktop_Keyword_Search(driver);
		//ExcelReader xls = new ExcelReader();
		HashMap<String, InputsAndPlaceHolder> columnsdetail = new HashMap<String, InputsAndPlaceHolder>();
		List<String> columns = new ArrayList<String>();
	//	String txt = "";
		//int k = 0;
		//String clsd = "closed";

		int colcount = ExcelReader.getColumn_Count(sheetloc);

		for (int z = 0; z < colcount; z++) {
			String col = ExcelReader.getColumn_Name(sheetloc, z);
			if (col.contains("###")) {
				columnsdetail.put(col, new InputsAndPlaceHolder(col));
				columns.add(col);
			}

		}

		try {
			for (int i = 1; i <= ExcelReader.getRows(sheetloc); i++) {


				ExtentTest child = per.createChild(parent, ExcelReader.genericReadData(sheetloc, i, "Search For"));
				// ExtentTest child = genric.createChild(report, xls.genericReadData(sheetloc,
				// i, "Search For"), xls.genericReadData(sheetloc, i, "Search For"));


				try {
					driver.get(url);
					per.childInfo(child, url);
					// genric.info(child, url);
					InputsAndPlaceHolder current = null;

					page.click_Type(ExcelReader.genericReadData(sheetloc, i, "type"));
					int l = 0;
					for (String s : columns) {

						current = columnsdetail.get(s);
						String data = ExcelReader.genericReadData(sheetloc, i, s);

						if (ExcelReader.genericReadData(sheetloc, i, "type").equalsIgnoreCase("colleges"))
							page.click_Type(ExcelReader.genericReadData(sheetloc, i, "type"));

						// System.out.println(s);
						if (!data.equalsIgnoreCase("")) {
							System.out.println("--->" + data);

							if (current.get_Input_Type().trim().equalsIgnoreCase("text")) {

								page.click_Type_Input(current.get_Placeholder(), data, child);

								Thread.sleep(500);

								if (ExcelReader.genericReadData(sheetloc, i, "searchtype").equalsIgnoreCase("closed")
										&& (l == 0 || l == 10)) {

									Thread.sleep(1000);
									page.select_Type_Input(data, child);

								}
								if (l == 1) {
									page.hoverAt(738, 361);

									page.selectLocation(child);
								}

							} else if (current.get_Input_Type().trim().equalsIgnoreCase("drpdwn")) {

								page.click_Drpdwn(current.get_Placeholder(), data, child);
								Thread.sleep(500);
							} else {
								System.out.println("other");
								System.out.println(current.get_Input_Type());
							}
							if (ExcelReader.genericReadData(sheetloc, i, "searchtype").equalsIgnoreCase("open") && l > 1)
								break;

						}
						l++;

					}
					page.click_Submit_College(ExcelReader.genericReadData(sheetloc, i, "type"));
					Thread.sleep(1000);

					String url1 = ExcelReader.genericReadData(sheetloc, i, "link");
					if (url1.contains("&ts"))
						url1 = url1.substring(0, url1.indexOf("&ts"));

					String url2 = driver.getCurrentUrl();
					if (url2.contains("&sa")) {
						url2 = url2.substring(0, url2.indexOf("&sa"))
								+ url2.substring(url2.indexOf("&rf"), url2.length());

					}
					if (url2.contains("&ts"))
						url2 = url2.substring(0, url2.indexOf("&ts"));
					url2 = url2.replaceAll(obj.getURL(), "");
					url2 = "/" + url2;
					System.out.println("link from excel  " + url1);
					System.out.println("current link  " + url2);

					if (url2.contains("https://ask.shiksha.com/"))
						url2 = url2.replaceAll("https://ask.shiksha.com/", "");
					per.childInfo(child, "Expected url : " + url1 + "<br>Obtained url :" + url2);
					// genric.info(child, "Expected url : "+url1+"<br>Obtained url :"+url2);
					if (url2.equalsIgnoreCase(url1)) {
						System.out.println("\t\t\t Pass");
						per.childInfo(child, "Url has been verified successfully");
						// genric.pass(child,"Url has been verified successfully");
					} else {
						System.out.println("\t\t\t Fail");
						per.childFail(child, "Url failed to be verified");
						// genric.fail(child, "Url failed to be verified");
					}

					// genric.closeChild(parent, child, report);
				} catch (Exception e) {
					// genric.closeChild(parent, child, report);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	//	per.closeReport(report);
	}

	public void TestCTPFilters(Objects obj) throws InterruptedException {
		System.out.println("----------------------------------CTP-----------------------------------------");
		String type = "CTP";
		/*
		 * ExtentReports report = obj.getReport(); ExtentTest parent = obj.getParent();
		 */
		ExtentTest parent = obj.getNewParent();
		WebDriver driver = obj.getDriver();
		GenericFunction per = new GenericFunction(driver);

		String xls = "//Desktop//Filter Data";
		String url = obj.getURL();
		per.click_Cookie_Ok_Button(url);
		CLP page = new CLP(driver);
		Random rand = new Random();
		HashMap<String, ExtentTest> childs = new HashMap<String, ExtentTest>();
		ExtentTest child = null;

		try {
			for (int v = 1; v <= ExcelReader.getRows(xls); v++) {
				List<FilterData> AllSelectedfilters = new ArrayList<FilterData>();
				if (!ExcelReader.genericReadData(xls, v, "case").equalsIgnoreCase("CTP"))
					continue;
				url = obj.getURL() + ExcelReader.genericReadData(xls, v, "url");
				driver.get(url);
				List<String> FilterTabs = page.getFilterTabs();
				for (String ft : FilterTabs) {
					List<FilterData> filters = new ArrayList<FilterData>();
					if (page.setFilter(ft)) {
						if (ft.equalsIgnoreCase("Total Fees") || ft.equalsIgnoreCase("Course Status"))
							continue;
						if (childs.containsKey(ft)) {

							child = childs.get(ft);

						} else {
							child = per.createChild(parent, ft);// genric.createChild(report, ft, "Validation of " +
																// ft);
							childs.put(ft, child);
						}
						per.childInfo(child, url);
						System.out.println(ft);
						page.setFilter(ft);
						int coun = page.getFilterCount();
						per.childInfo(child, "Total Filters in the Location Tab:" + coun);
						System.out.println(coun);
						int x;
						if (coun > 5)
							x = rand.nextInt(5) + 1;
						else
							x = rand.nextInt(coun) + 1;
						int count = 0;
						if ((ft.equalsIgnoreCase("Location") || ft.equalsIgnoreCase("Specialization") )) {
							System.out.println(x);
							per.childInfo(child, "Total filter to be selected :- " + 1);
							// genric.info(child, "Total filter to be selected :- "+1);
							String sel = page.filterSelect(x, 1, child, ft);
							filters.add(new FilterData(sel));

						} else {
							List<Integer> a = new ArrayList<Integer>();
							for (int i = 0; i < x; i++) {

								int temp = rand.nextInt(x) + 1;
								if (!a.contains(temp) && temp != 2)
									a.add(temp);
							}
							System.out.println(a.size());
							for (int i = 0; i < a.size(); i++) {
								try {
									System.out.println(a.get(i));
									per.childInfo(child, "Total filter to be selected :- " + a.size());
									// genric.info(child, "Total filter to be selected :- "+a.size());
									String sel = page.filterSelect(a.get(i), 1, child, ft);
									filters.add(new FilterData(sel));
								} catch (Exception e) {
									per.childFail(child, "Filter Selection Failed");
									// genric.fail(child, "Filter Selection Failed");
								}
							}

							Thread.sleep(2000);
						}
						Thread.sleep(2000);
						per.childInfo(child, "Validation");
						// genric.info(child, "Validation");
						for (FilterData d : filters) {
							System.out.println(d.getName() + "--->" + d.getCount());
							count = d.getCount() > count ? d.getCount() : count;
						}
						if (count <= page.getFilterdCount(type)) {
							per.childPass(child, "Total colleges displayed are <b>" + page.getFilterdCount(type)
									+ "</b> and Total Colleges to be displayed <b>" + count + "</b>");
							// genric.pass(child, "Total colleges displayed are <b>" +
							// page.getFilterdCount(type)
							// + "</b> and Total Colleges to be displayed <b>" + count + "</b>");
							System.out.println("Filter Count Verified of " + ft + " as " + page.getFilterdCount(type)
									+ " displayed and " + count + " calculated");
						} else {
							per.childFail(child, "Total colleges displayed are <b>" + page.getFilterdCount(type)
									+ "</b> and Total Colleges to be displayed <b>" + count + "</b>");
							// genric.fail(child, "Total colleges displayed are <b>" +
							// page.getFilterdCount(type)
							// + "</b> and Total Colleges to be displayed <b>" + count + "</b>");
							System.out.println("Filter Count Not Verified of " + ft + " as "
									+ page.getFilterdCount(type) + " displayed and " + count + " calculated");
						}
						for (int j = 0; j < filters.size(); j++) {
							String name = filters.get(j).getName();
							if (name.equalsIgnoreCase("null"))
								continue;
							page.verifiedSelected(name);
						}
						
					}
					AllSelectedfilters.addAll(filters);
				}
				if(childs.containsKey("Filter Removal"))
					child = childs.get("Filter Removal");
				else {
					child = per.createChild(parent, "Filter Removal");
					childs.put("Filter Removal",child);
				}
				per.childInfo(child, url);
				for (int j = 0; j < AllSelectedfilters.size() / 2; j++) {
					String name = AllSelectedfilters.get(j).getName();
					if (page.removeFilter(name, child))
						per.childPass(child, "Filter " + name + " has been removed Successfully");
					else
						per.childFail(child, "Removal of Filter " + name + " has been failed");
				}

				if (page.removeFilter("Clear All", child)) {
					if (!page.isAnyFilterSelected())
						per.childPass(child, "All Filters has been removed Successfully");
					else
						per.childFail(child, "Fail to Remove All Filters");
				} else
					per.childFail(child, "Fail to Remove All Filters");
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		Thread.sleep(2000);
	}

	public void TestSearchFilters(Objects obj) throws InterruptedException {
		System.out.println("----------------------------------Search-----------------------------------------");
		String type = "Search";
		/*
		 * ExtentReports report = obj.getReport(); ExtentTest parent = obj.getParent();
		 */
		ExtentTest parent = obj.getNewParent();
		WebDriver driver = obj.getDriver();
		String xls = "//Desktop//Filter Data";
		String url = obj.getURL();
		GenericFunction per = new GenericFunction(driver);
		CLP page = new CLP(driver);
		per.click_Cookie_Ok_Button(url);
		Random rand = new Random();
		HashMap<String, ExtentTest> childs = new HashMap<String, ExtentTest>();
		ExtentTest child = null;

		try {
			for (int v = 1; v <= ExcelReader.getRows(xls); v++) {
				if (!ExcelReader.genericReadData(xls, v, "case").equalsIgnoreCase("Search"))
					continue;
				url = obj.getURL() + ExcelReader.genericReadData(xls, v, "url");
				driver.get(url);
				List<String> FilterTabs = page.getFilterTabs();
				List<FilterData> AllSelectedfilters = new ArrayList<FilterData>();
				for (String ft : FilterTabs) {
					List<FilterData> filters = new ArrayList<FilterData>();
					if (page.setFilter(ft)) {
						if (ft.equalsIgnoreCase("Total Fees") || ft.equalsIgnoreCase("Course Status"))
							continue;
						if (childs.containsKey(ft))
							child = childs.get(ft);
						else {
							child = per.createChild(parent, ft);
							// genric.createChild(report, ft, "Validation of " + ft);
							// genric.info(child, url);
							childs.put(ft, child);
						}
						per.childInfo(child, url);
						System.out.println(ft);
						page.setFilter(ft);
						int coun = page.getFilterCount();
						System.out.println(coun);

						int x;
						if (coun > 5)
							x = rand.nextInt(5) + 1;
						else
							x = rand.nextInt(coun) + 1;
						int count = 0;
						if ((ft.equalsIgnoreCase("Location") || ft.equalsIgnoreCase("Specialization"))) {
							System.out.println(x);
							per.childInfo(child, "Total filter to be selected :- " + 1);
							// genric.info(child, "Total filter to be selected :- "+1);
							String sel = page.filterSelect(x, 1, child, ft);
							filters.add(new FilterData(sel));
						} else {
							List<Integer> a = new ArrayList<Integer>();
							for (int i = 0; i < x; i++) {
								int temp = rand.nextInt(x) + 1;
								if (!a.contains(temp))
									a.add(temp);
							}
							System.out.println(a.size());
							for (int i = 0; i < a.size(); i++) {
								System.out.println(a.get(i));
								per.childInfo(child, "Total filter to be selected :- " + a.size());
								// genric.info(child, "Total filter to be selected :- "+a.size());
								String sel = page.filterSelect(a.get(i), 1, child, ft);
								filters.add(new FilterData(sel));
							}

							Thread.sleep(2000);
						}
						Thread.sleep(2000);
						per.childInfo(child, "Validation");
						// genric.info(child, "Validation");
						for (FilterData d : filters) {
							System.out.println(d.getName() + "--->" + d.getCount());
							count = d.getCount() > count ? d.getCount() : count;
						}
						if (count <= page.getFilterdCount(type)) {
							per.childPass(child, "Total colleges displayed are <b>" + page.getFilterdCount(type)
									+ "</b> and Total Colleges to be displayed <b>" + count + "</b>");
							// genric.pass(child, "Total colleges displayed are <b>" +
							// page.getFilterdCount(type)
							// + "</b> and Total Colleges to be displayed <b>" + count + "</b>");
							System.out.println("Filter Count Verified of " + ft + " as " + page.getFilterdCount(type)
									+ " displayed and " + count + " calculated");
						} else {
							per.childFail(child, "Total colleges displayed are <b>" + page.getFilterdCount(type)
									+ "</b> and Total Colleges to be displayed <b>" + count + "</b>");
							// genric.fail(child, "Total colleges displayed are <b>" +
							// page.getFilterdCount(type)
							// + "</b> and Total Colleges to be displayed <b>" + count + "</b>");
							System.out.println("Filter Count Not Verified of " + ft + " as "
									+ page.getFilterdCount(type) + " displayed and " + count + " calculated");
						}
						for (int j = 0; j < filters.size(); j++) {
							String name = filters.get(j).getName();
							if (page.verifiedSelected(name))
								per.childPass(child, "Filter " + name + " has been verified Successfully");
							else
								per.childFail(child, "Verification of Filter " + name + " has been failed");
						}
						AllSelectedfilters.addAll(filters);
					}
					// genric.closeChild(parent, child, report);

				}

				// Clear All Filter Validation
				
				if(childs.containsKey("Filter Removal"))
					child = childs.get("Filter Removal");
				else {
					child = per.createChild(parent, "Filter Removal");
					childs.put("Filter Removal",child);
				}
				per.childInfo(child, url);
				for (int j = 0; j < AllSelectedfilters.size() / 2; j++) {
					String name = AllSelectedfilters.get(j).getName();
					if (page.removeFilter(name, child))
						per.childPass(child, "Filter " + name + " has been removed Successfully");
					else
						per.childFail(child, "Removal of Filter " + name + " has been failed");
				}

				if (page.removeFilter("Clear All", child)) {
					if (!page.isAnyFilterSelected()) {
						per.childPass(child, "All Filters has been removed Successfully");
					} else {
						System.out.println("here1");
						per.childFail(child, "Fail to Remove All Filters");
					}
				} else {
					System.out.println("here2");
					per.childFail(child, "Fail to Remove All Filters");
				}
			}

		} catch (Exception e) {
			// genric.closeChild(parent, child, report);
			e.printStackTrace();
		}
		Thread.sleep(20000);
	}

}
