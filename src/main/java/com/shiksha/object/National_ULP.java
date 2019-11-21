package com.shiksha.object;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.resourses.Database;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.Variables;

public class National_ULP {

	WebDriver driver;
	GenericFunction per;
	// CommonFunctions per = new CommonFunctions();
	Database db = new Database();
	public National_ULP(WebDriver driver) {
		this.driver = driver;
		per = new GenericFunction(driver);
	}

	public void waitFor_Download_Brochure(ExtentTest child) {
		try {
			Variables.elementWait(driver, 30, FetchData.readOR("ULP_PWA_Download_Brochure"));
			per.sleep(1000);
			per.childPass(child, "Page Displayed Successfully");
		}catch(Exception e) {
			per.childFail(child, "Page is not Displayed");
			throw e;
		}
	}

	public HashMap<String, List<String>> TopSection_PWA() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("ULP_PWA_TopSection"));
		if (per.isAvailable(xpath)) {
			String temp = per.findElementByXpath(xpath + "/div").getText();
			List<String> tem = new ArrayList<String>();
			String a[] = temp.split("\n");
			tem.add(a[0]);
			hm.put("TopSection : University/Institute Name", tem);
			tem = new ArrayList<String>();
			String loc[] = a[1].split(",");
			int len = loc.length;

			if (len == 2) {
				tem.add(loc[0].trim());
				hm.put("TopSection : Locality", tem);
				tem = new ArrayList<String>();
				tem.add(loc[1].trim());
				hm.put("TopSection : City", tem);
				tem = new ArrayList<String>();
			} else if (len == 3) {
				tem.add(loc[0].trim());
				hm.put("TopSection : Locality", tem);
				tem = new ArrayList<String>();
				tem.add(loc[1].trim());
				hm.put("TopSection : City", tem);
				tem = new ArrayList<String>();
				tem.add(loc[2].trim());
				hm.put("TopSection : State", tem);
				tem = new ArrayList<String>();

			}
			List<WebElement> wes = per.findElementsByXpath(xpath + "//div[@class='clg-col']");
			for (WebElement we : wes) {
				tem = new ArrayList<String>();
				temp = we.getText();
				a = temp.split("\n");
				String temz = "Yes";
				if (a[0].equalsIgnoreCase("Status")) {
					a[0] = "UGC Approved";
					a[1] = "Yes";
				} else if (a[0].equalsIgnoreCase("Accreditation"))
					a[0] = "NAAC accreditation";
				else if (a[0].equalsIgnoreCase("Institute Type")) {
					a[0] = "Autonomous Institute";
					a[1] = "Yes";
				} else if (a[0].equalsIgnoreCase("National Importance")) {
					a[0] = a[1];
					a[1] = "Yes";
				} else if (a[0].equalsIgnoreCase("AIU Member")) {
					a[0] = "AIU MemberShip";

				}

				a[0] = "TopSection : " + a[0];
				if (a.length > 1)
					tem.add(a[1]);
				else {
					tem.add(temz);
					System.out.println("--------------------------->" + we.getText());
				}
				hm.put(a[0], tem);
				// System.out.println(a[0]+"----->"+a[1]);
			}

		}
		return hm;
	}

	public HashMap<String, List<String>> TopSectionData() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_TOP_Section"));
		if (per.isAvailable(xpath)) {
			String temp = per.findElementByXpath(xpath + "/div[1]//h1").getText();
			List<String> tem = new ArrayList<String>();
			String a[] = temp.split("\n");
			tem.add(a[0]);
			hm.put("TopSection : University/Institute Name", tem);
			tem = new ArrayList<String>();
			String loc[] = a[1].split(",");
			int len = loc.length;

			if (len == 2) {
				tem.add(loc[0].trim());
				hm.put("TopSection : Locality", tem);
				tem = new ArrayList<String>();
				tem.add(loc[1].trim());
				hm.put("TopSection : City", tem);
				tem = new ArrayList<String>();
			} else if (len == 3) {
				tem.add(loc[0].trim());
				hm.put("TopSection : Locality", tem);
				tem = new ArrayList<String>();
				tem.add(loc[1].trim());
				hm.put("TopSection : City", tem);
				tem = new ArrayList<String>();
				tem.add(loc[2].trim());
				hm.put("TopSection : State", tem);
				tem = new ArrayList<String>();

			}

			List<WebElement> wes = per.findElementsByXpath(xpath + "/div[2]//span[@class='font-w6 f12 color-3']");
			for (WebElement we : wes) {
				tem = new ArrayList<String>();
				temp = we.getText();
				if (temp.equalsIgnoreCase("Public/Government") || temp.equalsIgnoreCase("Private")
						|| temp.equalsIgnoreCase("Public-Private")) {
					tem.add(temp);
					hm.put("TopSection : Ownership", tem);

				} else if (temp.contains("Established")) {
					tem.add(temp.replaceAll("Established", "").trim());
					hm.put("TopSection : Established", tem);
				} else if (temp.contains("University")) {
					tem.add(temp.replaceAll("University", "").trim());
					hm.put("TopSection : University Type", tem);
				} else if (temp.equalsIgnoreCase("UGC Approved")) {
					tem.add("Yes");
					hm.put("TopSection : UGC Approved", tem);
				} else if (temp.contains("accredited by NAAC")) {
					tem.add(temp.replace("accredited by NAAC", "").trim());
					hm.put("TopSection : NAAC accreditation", tem);
				} else if (temp.equalsIgnoreCase("Member of AIU")) {
					tem.add("Yes");
					hm.put("TopSection : AIU MemberShip", tem);
				} else if (temp.equalsIgnoreCase("Autonomous Institute")) {
					tem.add("Yes");
					hm.put("TopSection : Autonomous Institute", tem);
				} else if (temp.equalsIgnoreCase("Institute of National Importance")) {
					tem.add("Yes");
					hm.put("TopSection : Institute of National Importance", tem);
				} else
					System.out.println("other-------->" + temp);
				tem = new ArrayList<String>();
			}
		}
		return hm;
	}

	public HashMap<String, List<String>> TopSectionDB(int listing_id, Objects obj) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String query = "select listing_id,listing_type,name,abbreviation,establish_year,establish_university_year,"
				+ " university_specification_type,ownership,student_type,is_open_university,"
				+ " is_ugc_approved,is_aiu_membership,is_national_importance,accreditation,"
				+ " is_autonomous,is_national_importance"
				+ " from shiksha_institutes where status = 'live' and listing_id=" + listing_id + " order by 1 desc;";

		String q2 = "select state.state_name,city.city_name, locality.localityName from"
				+ " shiksha_institutes_locations as ids"
				+ " inner join stateTable as state on ids.state_id = state.state_id"
				+ " inner join countryCityTable as city on ids.city_id = city.city_id"
				+ " inner join localityCityMapping as locality on ids.locality_id= locality.localityId"
				+ " where ids.listing_id=" + listing_id + " and ids.status='live' and ids.is_main=1;";
		
		List<String> tem = new ArrayList<String>();
		try {
			ResultSet rs = db.executeDbQuery(query, obj);
			ResultSet rs2 = db.executeDbQuery(q2, obj);
			if (rs.next()) {
				if (rs.getString("name") != null) {

					tem.add(rs.getString("name"));
					hm.put("TopSection : University/Institute Name", tem);
					tem = new ArrayList<String>();
				}

				if (rs.getString("establish_year") != null) {
					tem.add(rs.getString("establish_year"));
					hm.put("TopSection : Established", tem);
					tem = new ArrayList<String>();
				}
				if (rs.getString("university_specification_type") != null) {
					tem.add(rs.getString("university_specification_type").substring(0, 1).toUpperCase()
							+ rs.getString("university_specification_type").substring(1,
									rs.getString("university_specification_type").length()));
					hm.put("TopSection : University Type", tem);
					tem = new ArrayList<String>();
				}
				if (rs.getString("ownership") != null) {
					if (rs.getString("ownership").equalsIgnoreCase("public"))
						tem.add("Public/Government");
					else
						tem.add(rs.getString("ownership").substring(0, 1).toUpperCase()
								+ rs.getString("ownership").substring(1, rs.getString("ownership").length()));
					hm.put("TopSection : Ownership", tem);
					tem = new ArrayList<String>();
				}
				if (rs.getString("is_ugc_approved") != null && rs.getString("is_ugc_approved").equalsIgnoreCase("1")) {
					tem.add("Yes");
					hm.put("TopSection : UGC Approved", tem);
					tem = new ArrayList<String>();
				}
				if (rs.getString("is_aiu_membership") != null
						&& rs.getString("is_aiu_membership").equalsIgnoreCase("1")) {
					tem.add("Yes");
					hm.put("TopSection : AIU MemberShip", tem);
					tem = new ArrayList<String>();
				}
				if ((rs.getString("listing_type")).equalsIgnoreCase("Institute")
						&& rs.getString("is_national_importance") != null
						&& rs.getString("is_national_importance").equalsIgnoreCase("1")) {
					tem.add("Yes");
					hm.put("TopSection : Institute of National Importance", tem);
					tem = new ArrayList<String>();
				}
				if (rs.getString("accreditation") != null) {
					tem.add("Grade '" + rs.getString("accreditation").replaceAll("grade_", "").toUpperCase() + "'");
					hm.put("TopSection : NAAC accreditation", tem);
					tem = new ArrayList<String>();
				}
				if (rs.getString("is_autonomous") != null && rs.getString("is_autonomous").equalsIgnoreCase("1")) {
					tem.add("Yes");
					hm.put("TopSection : Autonomous Institute", tem);
					tem = new ArrayList<String>();
				}
				if (rs2.next()) {
					if (rs2.getString("city_name") != null) {
						tem.add(rs2.getString("city_name"));
						hm.put("TopSection : City", tem);
						tem = new ArrayList<String>();
					}
					if (rs2.getString("localityName") != null) {
						tem.add(rs2.getString("localityName"));
						hm.put("TopSection : Locality", tem);
						tem = new ArrayList<String>();
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return hm;
	}

	public HashMap<String, List<String>> HighlightSection_PWA() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		List<String> tem = new ArrayList<String>();
		String xpath = per.DynamicXpath("ULP_PWA_Sections", "highlights") + "/div";
		if (per.isAvailable(xpath)) {
			per.scrollTo(xpath);
			if (per.isAvailable(xpath + "//label"))
				per.findElementByXpath(xpath + "//label").click();

			List<WebElement> wes = per.findElementsByXpath(xpath + "//li");
			for (WebElement we : wes)
				tem.add(per.removeExtraSpace(we.getText()));
		}
		if (!tem.isEmpty())
			hm.put("HighLights", tem);
		return hm;
	}

	public HashMap<String, List<String>> HighlightSection() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_Highlights_Section"));
		List<WebElement> wes = per.findElementsByXpath(xpath + "//p");
		if (wes.size() > 0) {
			per.scrollTo(wes.get(0));
			if (per.isAvailable(xpath + "//label"))
				per.findElementByXpath(xpath + "//label").click();
			List<String> tem = new ArrayList<String>();
			for (WebElement we : wes)
				tem.add(per.removeExtraSpace(we.getText()));

			if (!tem.isEmpty())
				hm.put("HighLights", tem);
		}
		return hm;
	}

	public HashMap<String, List<String>> HighlightDB(int listing_id, Objects obj) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String query = "select description from shiksha_institutes_additional_attributes where listing_id=" + listing_id
				+ " and status='live' and description_type='usp';";
		
		// db.dbconnect();
		List<String> tem = new ArrayList<String>();
		try {
			ResultSet rs = db.executeDbQuery(query, obj);
			while (rs.next())
				tem.add(per.removeExtraSpace(rs.getString("description")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!tem.isEmpty())
			hm.put("HighLights", tem);
		db.closeConnection();
		return hm;
	}

	public HashMap<String, List<String>> ScholerShipSection() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_Scholarship_Section"));
		List<WebElement> wes = per.findElementsByXpath(xpath + "//p");
		List<String> tem = new ArrayList<String>();
		if (wes.size() > 0) {
			per.scrollTo(wes.get(0));

			for (WebElement we : wes) {
				String s = per.removeExtraSpace(we.getText());
				if (s.contains("\n"))
					s = s.replaceAll("\n", " ");
				tem.add(s);
			}

			if (per.isAvailable(xpath + "//a[text()='View Scholarships']"))
				tem.add(per.toRelativeURL(
						per.findElementByXpath(xpath + "//a[text()='View Scholarships']").getAttribute("href")));
			if (!tem.isEmpty())
				hm.put("Scholarship", tem);
		}

		return hm;
	}

	public HashMap<String, List<String>> ScholerShipSection_PWA() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.DynamicXpath("ULP_PWA_Sections", "scholarships") + "/div";
		List<String> tem = new ArrayList<String>();
		if (per.isAvailable(xpath)) {
			per.scrollTo(xpath);
			if (per.isAvailable(xpath + "//strong"))
				tem.add(per.removeExtraSpace(per.findElementByXpath(xpath + "//strong").getText()));

			String s = per.removeExtraSpace(per.findElementByXpath(xpath + "//p").getText());
			if (s.contains("\n"))
				s = s.replaceAll("\n", " ");
			tem.add(s);
			if (per.isAvailable(xpath + "//a[text()='View more']"))
				tem.add(per
						.toRelativeURL(per.findElementByXpath(xpath + "//a[text()='View more']").getAttribute("href")));
		}
		if (!tem.isEmpty())
			hm.put("Scholarship", tem);
		return hm;
	}

	public HashMap<String, List<String>> ScholerShipDB(int listing_id, Objects obj, String url) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String query = "select shiksha_institutes_scholarships.description,value_name"
				+ " from shiksha_institutes_scholarships,base_attribute_list"
				+ " where shiksha_institutes_scholarships.listing_id= " + listing_id
				+ " and shiksha_institutes_scholarships.status='live'"
				+ " and shiksha_institutes_scholarships.scholarship_type_id=base_attribute_list.value_id;";

		String q2 = "select count(*) as length" + " from shiksha_institutes_scholarships,base_attribute_list"
				+ " where shiksha_institutes_scholarships.listing_id= " + listing_id
				+ " and shiksha_institutes_scholarships.status='live'"
				+ " and shiksha_institutes_scholarships.scholarship_type_id=base_attribute_list.value_id;";
		
		List<String> tem = new ArrayList<String>();

		try {
			ResultSet count = db.executeDbQuery(q2, obj);
			boolean b = false;
			count.next();
			if (count.getInt("length") == 1) {
				b = true;
			}

			ResultSet rs = db.executeDbQuery(query, obj);
			int i = 1;
			if (b) {
				rs.next();
				String s = per.removeExtraSpace(rs.getString(1));
				if (s.contains("\n"))
					s = s.replaceAll("\n", " ");

				tem.add(s);
			} else {
				while (rs.next() && i == 1) {
					String s = rs.getString(2);
					s = "Scholarship";
					tem.add(s);
					s = rs.getString(1);
					if (s.contains("\n"))
						s = s.replaceAll("\n", " ");

					tem.add(per.removeExtraSpace(s));
					i = 0;
				}
			}
			if (!tem.isEmpty()) {
				tem.add(per.toRelativeURL(url) + "/scholarships");
			}
			if (!tem.isEmpty())
				hm.put("Scholarship", tem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		return hm;
	}

	public HashMap<String, List<String>> AddmissionSection_PWA() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.DynamicXpath("ULP_PWA_Sections", "admission");

		List<String> tem = new ArrayList<String>();
		if (per.isAvailable(xpath)) {
			tem.add("Admission Section");
			per.scrollTo(xpath);
			per.scrollVerticalTo(-200);

			xpath = xpath + "//div[not (@class)]";
			if (per.isAvailable(xpath)) {
				WebElement we = per.findElementByXpath(xpath);
				String t = per.removeExtraSpace(per.removeHTML(we.getText()));

				if (t.contains("\n"))
					t = t.substring(0, t.indexOf("\n"));
				if (t.length() > 500)
					t = t.substring(0, 500);
				tem.add(t);
			}
			xpath = per.DynamicXpath("ULP_PWA_Sections", "admission") + "//div[@class='gradient-col']/a";
			per.scrollTo(xpath);
			per.scrollVerticalTo(-200);
			if (per.isAvailable(xpath)) {
				tem.add(per.toRelativeURL(per.findElementByXpath(xpath).getAttribute("href")));

			}
		}
		if (!tem.isEmpty())
			hm.put("Admission", tem);
		return hm;
	}

	public HashMap<String, List<String>> AdmissionDB_PWA(int listing_id, Objects obj, String url) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String query = "select description" + " from shiksha_institutes_additional_attributes" + " where listing_id="
				+ listing_id + " and status='live'" + " and description_type='admission_info';";

		
		List<String> tem = new ArrayList<String>();
		try {
			ResultSet rs = db.executeDbQuery(query, obj);
			if (rs.next()) {
				tem.add("Admission Section");
				String s = rs.getString("description");

				s = per.removeExtraSpace(s);
				s = per.removeHTML(s);

				if (s.contains("\n"))
					s = s.substring(0, s.indexOf("\n"));

				if (s.length() > 500)
					s = s.substring(0, 500);

				tem.add(s.trim());
				tem.add(per.toRelativeURL(url) + "/admission#admission");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!tem.isEmpty())
			hm.put("Admission", tem);
		db.closeConnection();
		return hm;
	}

	public HashMap<String, List<String>> AddmissionSection() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_Admission_Section_Scroll")) + "/..";
		try {
			List<String> tem = new ArrayList<String>();
			if (driver.findElements(FetchData.readOR("ULP_AMP_Admission_Section_Scroll")).size() == 0)
				return hm;
			else
				tem.add("Admission Section");
			for (int i = 0; i < 70; i++) {
				((JavascriptExecutor) driver).executeScript("window.scrollBy(0,100)");
				Thread.sleep(50);
			}
			per.scrollTo(driver.findElement(FetchData.readOR("ULP_AMP_Admission_Section_Scroll")));
			List<WebElement> wes2 = driver.findElements(FetchData.readOR("ULP_AMP_Admission_Frame"));
			if (wes2.size() > 0) {
				per.scrollTo(wes2.get(0));
				driver.switchTo().frame(wes2.get(0));
				// System.out.println("here");
				// System.out.println(driver.findElement(By.tagName("body")).getText());
			}
			List<WebElement> wes = driver.findElements(FetchData.readOR("ULP_AMP_Admission_Section"));
			if (wes.size() > 0) {

				for (WebElement we : wes) {
					per.scrollTo(we);
					// System.out.println(driver.findElement(By.tagName("body")).getText());
					String s = we.getText();
					s = per.removeExtraSpace(s);

					if (s.contains("\n"))
						s = s.substring(0, s.indexOf("\n"));
					tem.add(s);

				}
				driver.switchTo().defaultContent();

				String s = per
						.toRelativeURL(per.findElementByXpath(xpath + "//a[text()='View more']").getAttribute("href"));
				tem.add(s);
				if (!tem.isEmpty())
					hm.put("Admission", tem);

			}
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return hm;
	}

	public HashMap<String, List<String>> AdmissionDB(int listing_id, Objects obj, String url) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String query = "select description" + " from shiksha_institutes_additional_attributes" + " where listing_id="
				+ listing_id + " and status='live'" + " and description_type='admission_info';";

		
		List<String> tem = new ArrayList<String>();
		try {
			ResultSet rs = db.executeDbQuery(query, obj);
			if (rs.next()) {
				tem.add("Admission Section");
				String s = rs.getString("description");

				s = per.removeHTML(s);
				s = per.removeExtraSpace(s);
				if (s.contains("\n"))
					s = s.substring(0, s.indexOf("\n"));
				tem.add(s.trim());
				if (url.contains("amp/"))
					url = url.replaceAll("amp/", "");
				tem.add(per.toRelativeURL(url) + "/admission#admission");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		db.closeConnection();
		if (!tem.isEmpty())
			hm.put("Admission", tem);
		return hm;
	}

	public HashMap<String, List<String>> GallerySection_PWA() {
		String xpath = per.DynamicXpath("ULP_PWA_Sections", "gallery");
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		List<String> tempi = new ArrayList<String>();
		List<String> tempv = new ArrayList<String>();
		if (per.isAvailable(xpath)) {
			per.scrollTo(xpath);
			per.scrollVerticalTo(-200);
			per.sleep(1000);
			String head = per.findElementByXpath(xpath + "//h2").getText();
			String xpathvi = "";
			if (per.isAvailable(xpath + "//a[@class='viewMoreCount']")) {
				String a[] = head.split("of");
				head = "" + per.findInt(a[1]);
				tempi.add(head);
				hm.put("Gallery : Heading", tempi);
				tempi = new ArrayList<String>();
				per.findElementByXpath(xpath + "//a[@class='viewMoreCount']").click();
				xpathvi = per.byXpath_To_StringXpath(FetchData.readOR("ULP_PWA_Gallery_More_Thumbnale"));

			} else {
				head = "" + per.findInt(head);
				tempi.add(head);
				hm.put("Gallery : Heading", tempi);
				tempi = new ArrayList<String>();
				xpathvi = xpath + "//img";
			}

			List<WebElement> wes = per.findElementsByXpath(xpathvi);
			for (WebElement we : wes) {
				String temp = we.getAttribute("src");
				if (temp.contains("_205x160"))
					temp = temp.replaceAll("_205x160", "");
				if (temp.contains("_100x78"))
					temp = temp.replaceAll("_100x78", "");
				if (temp.contains("https://i.ytimg.com"))
					tempv.add(temp);
				else {
					temp = per.toRelativeURL(temp);
					tempi.add(temp);
				}
			}
		}
		if (!tempi.isEmpty())
			hm.put("Gallery : Photo", tempi);
		if (!tempv.isEmpty())
			hm.put("Gallery : Video", tempv);
		db.closeConnection();
		return hm;
	}

	public HashMap<String, List<String>> GallerySection() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		List<String> tempi = new ArrayList<String>();
		List<String> tempv = new ArrayList<String>();
		String xpath = "(" + per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_Gallery_Section")) + ")";
		if (per.findElementsByXpath(xpath + "/h2").size() > 0) {
			String s = per.findElementByXpath(xpath + "/h2").getText().substring(22, 24).trim();

			tempi.add(s);
			hm.put("Gallery : Heading", tempi);
			tempi = new ArrayList<String>();

			List<WebElement> wes = per.findElementsByXpath(xpath + "//button/amp-img");

			for (WebElement we : wes) {

				s = we.getAttribute("src");
				if (s.contains("infoedge.com") || s.contains("shiksha.com"))
					s = s.substring(s.indexOf(".com") + 4, s.length());

				if (s.contains("_100x78"))
					s = s.replaceAll("_100x78", "");
				if (s.contains("https://i.ytimg.com"))
					tempv.add(s);
				else
					tempi.add(s);
			}
		}

		if (!tempi.isEmpty())
			hm.put("Gallery : Photo", tempi);
		if (!tempv.isEmpty())
			hm.put("Gallery : Video", tempv);
		return hm;
	}

	public HashMap<String, List<String>> GalleryDB(int listing_id, Objects obj) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		List<String> tempi = new ArrayList<String>();
		List<String> tempv = new ArrayList<String>();
		String query = "Select count(*) length from shiksha_institutes_media_tags_mapping where listing_id="
				+ listing_id + " and status='live';";
		String q2 = "Select count(*) length from shiksha_institutes_medias where media_id in (Select media_id from shiksha_institutes_media_tags_mapping where listing_id="
				+ listing_id + " and status='live') and status='live' ;";
		
		try {
			ResultSet rx = db.executeDbQuery(q2, obj);
			ResultSet rs = db.executeDbQuery(query, obj);
			if (rs.next() && rx.next() && rs.getInt("length") > 0 && rx.getInt("length") > 0) {
				tempi.add(rs.getString("length"));

				hm.put("Gallery : Heading", tempi);
				tempi = new ArrayList<String>();
				query = "Select media_id from shiksha_institutes_media_tags_mapping where listing_id=" + listing_id
						+ " and status='live';";
				rs = db.executeDbQuery(query, obj);
				while (rs.next()) {
					query = "Select media_thumb_url from shiksha_institutes_medias where media_id="
							+ rs.getString("media_id") + " and status='live';";

					ResultSet rs2 = db.executeDbQuery(query, obj);
					if (rs2.next()) {
						String s = rs2.getString("media_thumb_url");
						if (s.contains("_68x54"))
							s = s.replaceAll("_68x54", "");

						if (s.contains("https://i.ytimg.com"))
							tempv.add(s);
						else
							tempi.add(s);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!tempi.isEmpty())
			hm.put("Gallery : Photo", tempi);
		if (!tempv.isEmpty())
			hm.put("Gallery : Video", tempv);
		db.closeConnection();
		return hm;
	}

	public HashMap<String, List<String>> CollegeSection() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();

		List<WebElement> wes = driver.findElements(FetchData.readOR("ULP_AMP_College_Section"));
		List<String> s = new ArrayList<String>();
		for (WebElement we : wes) {
			s.add(per.removeExtraSpace(we.getText()));
		}

		if (!s.isEmpty())
			hm.put("College", s);
		return hm;
	}

	public HashMap<String, List<String>> FacilitySectionPWA() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.DynamicXpath("ULP_PWA_Sections", "Facilities") + "//div[@class='_subcontainer']";
		List<String> tem = new ArrayList<String>();
		try {

			if (per.isAvailable(xpath)) {

				if (per.isAvailable(xpath + "//label[text()='View All ']")) {
					per.scrollTo(per.findElementByXpath(xpath + "//label[text()='View All ']"));
					per.scrollVerticalTo(-300);
					Thread.sleep(1000);
					per.findElementByXpath(xpath + "//label[text()='View All ']").click();
				}

				List<WebElement> wes = per.findElementsByXpath(xpath + "//div[@class='fac-info']");
				for (WebElement we : wes) {
					per.scrollTo(per.findElementByXpath(xpath));
					String temp = per.removeExtraSpace(we.findElement(By.tagName("span")).getText());
					tem.add(temp);
					if (we.findElements(By.tagName("a")).size() > 0) {
						per.scrollTo(we);
						per.scrollVerticalTo(-100);
						Thread.sleep(1000);
						we.findElement(By.tagName("a")).click();
						Thread.sleep(1500);
						String dxpath = per.DynamicXpath("UPL_PWA_Highlights_Data", temp);
						List<WebElement> wes2 = per.findElementsByXpath(dxpath + "//strong");
						for (WebElement we2 : wes2)
							tem.add(per.removeExtraSpace(we2.getText()));

						wes2 = per.findElementsByXpath(dxpath + "//p[not(@class='fnt10 avlbl_fact')]");
						for (WebElement we2 : wes2)
							tem.add(per.removeExtraSpace(we2.getText()));

						Thread.sleep(1000);
						driver.findElement(FetchData.readOR("UPL_PWA_Highlights_Data_Close")).click();
						Thread.sleep(1000);
					}
				}
				wes = per.findElementsByXpath(xpath + "//div[@class='fac-bx otherdtls']");
				for (WebElement we : wes)
					tem.add(per.removeExtraSpace(we.getText()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!tem.isEmpty()) {
			if (tem.contains("note : Staying in hostel is mandatory"))
				tem.remove("note : Staying in hostel is mandatory");
			hm.put("Facility", tem);
		}
		return hm;
	}

	public HashMap<String, List<String>> FacilitySection() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_Facility_Section"));
		List<String> tem = new ArrayList<String>();
		try {
			if (per.isAvailable(xpath)) {
				if (per.isAvailable(xpath + "//label")) {
					per.scrollTo(per.findElementByXpath(xpath + "//label"));
					per.findElementByXpath(xpath + "//label").click();
				}

				List<WebElement> wes = per.findElementsByXpath(xpath + "//li/div");
				for (WebElement we : wes) {
					if (we.findElements(By.tagName("a")).size() > 0) {
						String s = per.removeExtraSpace(we.findElement(By.tagName("a")).getText());
						// System.out.println(s);
						tem.add(s);
						if (we.findElements(By.tagName("span")).size() > 0) {
							per.scrollTo(we.findElement(By.tagName("span")));

							Thread.sleep(1000);

							we.findElement(By.tagName("span")).click();
							Thread.sleep(2000);
							String xpath1 = per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_Facility_Detail"))
									.replaceAll("txtid", s);
							if (per.isAvailable(xpath1 + "/p")) {
								String s1 = per.removeExtraSpace(per.findElementByXpath(xpath1 + "/p").getText());
								// System.out.println(s1);
								tem.add(s1);

							}
							List<WebElement> wes3 = per.findElementsByXpath(xpath1 + "/ul/li//strong");
							for (WebElement we3 : wes3) {
								String s1 = per.removeExtraSpace(we3.getText());
								// System.out.println(s1);
								tem.add(s1);
							}
							wes3 = per.findElementsByXpath(xpath1 + "/ul//ul/li");
							for (WebElement we3 : wes3) {
								String s1 = per.removeExtraSpace(we3.getText());
								// System.out.println(s1);
								tem.add(s1);
							}

							String s2 = per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_Facility_Close"))
									.replaceAll("txtid", s);
							per.findElementByXpath(s2).click();
						}
					}

					else {
						List<WebElement> wes2 = we.findElements(By.tagName("span"));
						for (WebElement we2 : wes2)
							tem.add(per.removeExtraSpace(we2.getText()));

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!tem.isEmpty())
			hm.put("Facility", tem);
		return hm;
	}

	public HashMap<String, List<String>> FacilityDB(int listing_id, Objects obj) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();

		String query = "select B.name as Name, A.description,A.additional_info as aditional,B.order"
				+ " from shiksha_institutes_facilities as A, shiksha_institutes_facilities_master as B"
				+ " where A.listing_id =" + listing_id + " and A.facility_id = B.id" + " and A.status='live'"
				+ " and A.has_facility=1;";
		List<String> tem = new ArrayList<String>();
		
		try {
			ResultSet rs = db.executeDbQuery(query, obj);
			while (rs.next()) {
				String name = per.removeExtraSpace(rs.getString("Name"));
				if (!(name.equalsIgnoreCase("others") || name.equalsIgnoreCase("Mandatory Hostel")))
					tem.add(name);
				String t = rs.getString("description");
				if (t != null)
					tem.add(per.removeExtraSpace(t));

				t = rs.getString("aditional");
				if (t != null) {
					t = t.replaceAll("]", "").replaceAll(",", "").replaceAll("\"", "");
					t = t.substring(2, t.length()).replaceAll("[{]", "");
					String s[] = t.split("}");
					for (int i = 0; i < s.length; i++) {
						String x = s[i].substring(s[i].indexOf("name:") + 5, s[i].indexOf("value"));
						String y = s[i].substring(s[i].indexOf("value:") + 6, s[i].length());
						String z = "";
						if (y.equalsIgnoreCase("true"))
							z = x;
						else
							z = x + " - " + y;

						tem.add(per.removeExtraSpace(z));
					}
				}

				if (name.contains(" "))
					name = name.split(" ")[0];
				query = "Select B.value_name " + " from shiksha_institutes_facilities_mappings as A,"
						+ " base_attribute_list as B" + " where A.value_id=B.value_id" + " and A.listing_id="
						+ listing_id + " and A.status='live'" + " and B.attribute_name = '" + name + " Facilities';";

				ResultSet rs2 = db.executeDbQuery(query, obj);
				while (rs2.next()) {
					tem.add(per.removeExtraSpace(rs2.getString(1)));
				}
			}

			query = "select custom_name as A " + "from shiksha_institutes_facilities_mappings" + " where listing_id= "
					+ listing_id + "  and status='live'" + " and custom_name is not null;";
			ResultSet rs3 = db.executeDbQuery(query, obj);
			while (rs3.next())
				tem.add(per.removeExtraSpace(rs3.getString("A")));

		} catch (Exception e) {

			e.printStackTrace();
		}
		if (!tem.isEmpty())
			hm.put("Facility", tem);
		db.closeConnection();
		return hm;
	}

	public HashMap<String, List<String>> EventSection_PWA() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.DynamicXpath("ULP_PWA_Sections", "Events") + "/div";
		List<String> tem = new ArrayList<String>();
		// System.out.println(xpath);
		if (per.isAvailable(xpath)) {
			if (per.isAvailable(xpath + "//div/label")) {
				per.scrollTo(per.findElementByXpath(xpath + "//div/label"));
				per.scrollVerticalTo(-200);
				per.findElementByXpath(xpath + "//div/label").click();
			}
			List<WebElement> wes = per.findElementsByXpath(xpath + "//p/label");
			for (WebElement we : wes) {
				per.scrollTo(we);
				per.scrollVerticalTo(-200);
				we.click();
			}
			wes = per.findElementsByXpath(xpath + "//li");
			for (WebElement we : wes) {
				String temp = we.findElement(By.tagName("img")).getAttribute("src");
				if (temp == null)
					temp = "";
				if (temp.contains(".com"))
					temp = per.toRelativeURL(temp);

				if (!temp.equalsIgnoreCase("") && !temp.equalsIgnoreCase("/pwa/public/images/default-event-image.jpg"))
					tem.add(temp);

				temp = per.removeExtraSpace(we.findElement(By.tagName("strong")).getText());
				tem.add(temp);

				List<WebElement> wes2 = we.findElements(By.tagName("span"));
				WebElement we2 = wes2.get(wes2.size() - 1);
				tem.add(per.removeExtraSpace(we2.getText()));
			}
		}
		if (!tem.isEmpty())
			hm.put("Event", tem);
		return hm;
	}

	public HashMap<String, List<String>> EventSection() {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		String xpath = per.byXpath_To_StringXpath(FetchData.readOR("ULP_AMP_Event_Section"));
		if (per.isAvailable(xpath + "/div/label")) {

			WebElement we = per.findElementByXpath(xpath + "/div/label");
			per.scrollTo(we);
			we.click();
		}
		List<WebElement> wes = per.findElementsByXpath(xpath + "//label[text()='more']");
		for (WebElement we : wes) {
			per.scrollTo(we);
			we.click();
		}

		List<String> tem = new ArrayList<String>();
		wes = per.findElementsByXpath(xpath + "//li");
		for (WebElement we : wes) {
			String temp = per.toRelativeURL(we.findElement(By.tagName("img")).getAttribute("src"));
			if (temp.contains("_68x54"))
				temp = temp.replaceAll("_68x54", "");
			if (!temp.equalsIgnoreCase("/public/images/eventDummyImage.png"))
				tem.add(temp);
			// System.out.println(temp);
			List<WebElement> wes2 = we.findElements(By.tagName("p"));
			for (WebElement we2 : wes2) {
				if (we2.isDisplayed())
					tem.add(per.removeExtraSpace(we2.getText()));
			}
		}
		if (!tem.isEmpty())
			hm.put("Event", tem);
		return hm;
	}

	public HashMap<String, List<String>> EventDB(int listing_id, Objects obj) {
		HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
		List<String> tem = new ArrayList<String>();
		String query = "select id, name, description" + " from shiksha_institutes_events" + " where listing_id="
				+ listing_id + " and status='live';";
		
		try {
			ResultSet rs = db.executeDbQuery(query, obj);
			while (rs.next()) {
				int id = rs.getInt("id");
				String q2 = "select media_url" + " from shiksha_institutes_medias"
						+ " where media_id in (select media_id" + " from shiksha.shiksha_institutes_media_tags_mapping"
						+ " where tag_id=" + id + " and listing_id=" + listing_id + ")" + " and status = 'live';";
				ResultSet rs2 = db.executeDbQuery(q2, obj);
				if (rs2.next()) {
					String temp = rs2.getString("media_url");
					if (temp.contains("jpeg"))
						temp = temp.replaceAll("jpeg", "jpg");
					tem.add(temp);
				}

				tem.add(per.removeExtraSpace(rs.getString("name")));
				tem.add(per.removeExtraSpace(rs.getString("description")));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (!tem.isEmpty())
			hm.put("Event", tem);
		db.closeConnection();
		return hm;
		
	}

	public void click_PWA_Cookie_Button() {
		try {
			Thread.sleep(4000);
			if (per.isAvailable("//a[@class='cookAgr-btn']"))
				per.findElementByXpath("//a[@class='cookAgr-btn']").click();

			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void validation(HashMap<String, List<String>> hm, HashMap<String, List<String>> db,
			HashMap<String, ExtentTest> childs, ExtentTest parent) {
		List<String> keySet = getKeySet();
		ExtentTest child = null;
		for (String widget : keySet) {

			if (db.containsKey(widget) || hm.containsKey(widget)) {
				if (childs.containsKey(widget))
					child = childs.get(widget);
				else {
					child = per.createChild(parent, widget);
					childs.put(widget, child);
				}
				// System.out.println(widget);
				per.childInfo(child, driver.getCurrentUrl());
			}

			if (db.containsKey(widget)) {
				String back = "DataBase Widget Data";

				for (String dbs : db.get(widget))
					back += "<br><br>" + dbs;

				per.childInfo(child, back);
			}
			if (hm.containsKey(widget)) {
				String front = "FrontEnd Widget Data";
				List<String> fe = hm.get(widget);
				if (fe != null)
					for (String fes : fe)
						front += "<br><br>" + fes;

				per.childInfo(child, front);
			}

			if (db.containsKey(widget) && hm.containsKey(widget)) {
				System.out.println(widget);
				List<String> tem = hm.get(widget);
				List<String> temdb = db.get(widget);
				System.out.println("Front Size = " + tem.size());
				System.out.println("BackEnd Size = " + temdb.size());

				per.childInfo(child, "Front Size = " + tem.size() + "<br>BackEnd Size = " + temdb.size());

				if (tem.size() == temdb.size()) {
					boolean b = false;
					int x = 0;
					for (String temp : temdb) {
						temp = per.removeExtraSpace(temp);
						if (!tem.contains(temp)) {

							System.out.println("Db---->" + temp);
							System.out.println("FE---->" + tem.get(x));
							per.childFail(child, "DataSet Mismatch as<br>"
									+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Database<br>"
									+ temp + "<br>"
									+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; FrontEnd<br>"
									+ tem.get(x));
							b = true;
							break;
						} else {
							System.out.println(temp);
						}
						x++;
					}
					if (b) {
						System.out.println(
								"-----------------------------Fail due to String not Match on FE----------------------------");
					} else {
						per.childPass(child, "Validation Successfully");
						System.out.println("Pass");
					}
				} else {
					System.out.println(
							"----------------------------------Fail due to size of FE and BE not Matched ---------------------");

					List<String> thm = hm.get(widget);
					List<String> tdb = db.get(widget);
					String a[] = new String[tdb.size()];
					String fail = "";
					int index = 0;
					if (tdb.size() > thm.size()) {
						for (String s : tdb) {
							if (!thm.contains(s))
								a[index++] = s;
						}
						fail = "DataBase Contain Extra Value than FrontEnd as:";
						System.out.println("Extra in DB---->");
						for (int k = 0; k < index; k++) {
							System.out.println(a[k]);
							fail += "<br>" + a[k];
						}
					} else {
						for (String s : thm) {
							if (!tdb.contains(s))
								a[index++] = s;
						}
						fail = "FrontEnd Contain Extra Value than BackEnd as:";
						for (int k = 0; k < index; k++) {
							System.out.println(a[k]);
							fail += "<br>" + a[k];
						}
					}
					per.childFail(child, fail);
				}

			} else {
				if (db.containsKey(widget)) {
					per.childFail(child, "Fail due to widget not found on FrontEnd But present in DataBase :" + widget);
					System.out.println(
							"-------------------------Fail due to Widget not found on FE But available on BE : "
									+ widget + "---------------------");
				} else if (hm.containsKey(widget)) {
					per.childFail(child, "Fail due to widget not found on Database But present in FrontEnd :" + widget);
					System.out
							.println("-------------------------Fail due to Widget not found on BE But available on FE "
									+ widget + "---------------------");
				}

			}
		}

		// Validation End
	}

	public List<String> getKeySet() {
		List<String> keySet = new ArrayList<String>();
		keySet.add("TopSection : University/Institute Name");
		keySet.add("TopSection : Locality");
		keySet.add("TopSection : City");
		keySet.add("TopSection : State");
		keySet.add("TopSection : Ownership");
		keySet.add("TopSection : Established");
		keySet.add("TopSection : University Type");
		keySet.add("TopSection : UGC Approved");
		keySet.add("TopSection : NAAC accreditation");
		keySet.add("TopSection : AIU MemberShip");
		keySet.add("TopSection : Autonomous Institute");
		keySet.add("TopSection : Institute of National Importance");
		keySet.add("HighLights");
		keySet.add("Scholarship");
		keySet.add("Admission");
		keySet.add("Gallery : Heading");
		keySet.add("Gallery : Photo");
		keySet.add("Gallery : Video");
		keySet.add("Facility");
		keySet.add("Event");
		return keySet;
	}

}
