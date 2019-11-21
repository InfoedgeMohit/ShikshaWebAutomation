package com.shiksha.test;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.PWA;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.Database;

public class National_CLP_Mobile {
	PWA pwa = null;
	CommonFunctions CommonFunctions = new CommonFunctions();
	Database db = new Database();

	public void CLP(Objects obj) throws Exception {
		int iterationCount = 0;
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		url = url.substring(url.indexOf("//") + 2);
		url = "http://pwa." + url + "fsdf/course/aaa-";
		// driver.get(url);

		ExtentTest clpTopSection = CommonFunctions.createChild(report,
				"CLP Top Section",
				"To Verify Course Listing Page(CLP) TOP Section");

		ExtentTest clpCourseStructureSection = CommonFunctions.createChild(
				report, "CLP Course Structure Section",
				"To Verify Course Listing Page(CLP) Course Structure Section");

		// HashMap<String, String> reportMap = new HashMap<String, String>();

		try {
			ResultSet mailRs = db.GetCourseList(obj);
			while (mailRs.next()) {
				try {
					iterationCount++;
					// // Read Data from excel
					String course_id = mailRs.getString("course_id");
					String city_id = "";
					String locality_id = "";
					String finalUrl = url + course_id + "?city=" + city_id
							+ "&locality=" + locality_id;

					// // Hit Url
					driver.get(finalUrl);

					pwa = new PWA(driver, clpTopSection);
					CommonFunctions.info(clpTopSection, "Runnig Iteration "
							+ (iterationCount) + "For URL : " + finalUrl);
					ResultSet rs = db.courseTopSection(course_id, city_id,
							locality_id, obj);
					int ccc = db.getCountOfResultSet(rs);
					if (pwa.CheckTopSection() || ccc > 1) {
						// //Read Db for courseTopSection
						if (ccc == 1) {
							while (rs.next()) {
								ResultSet tempRs = null;
								String name = rs.getString("insname");
								String cityName = rs.getString("city_name");
								String localityName = rs
										.getString("localityName");
								if (name.toLowerCase().contains(
										cityName.toLowerCase())) {
									cityName = null;
								} else if (localityName != null) {
									if (name.toLowerCase().contains(
											localityName.toLowerCase())) {
										localityName = null;
									}
								}
								if (localityName == null) {
									name = name + ", " + cityName;
								} else {
									name = name + ", " + localityName + ", "
											+ cityName;
								}
								CommonFunctions.info(clpTopSection,
										"Verify Institute Name for course : "
												+ course_id + " Started");
								// // Verify Institute Name
								pwa.VerifyInstituteName(name,
										rs.getString("primary_id"));
								CommonFunctions.info(clpTopSection,
										"Verify Institute Name for course : "
												+ course_id + " Completed");

								// // Verify course Name
								CommonFunctions.info(clpTopSection,
										"Verify Course Name for course : "
												+ course_id + " started");
								pwa.VerifyCourseName(rs.getString("name"));
								CommonFunctions.info(clpTopSection,
										"Verify Course Name for course : "
												+ course_id + " Completed");

								// // Verify course Duration
								CommonFunctions.info(clpTopSection,
										"Verify Course Duration along with unit for course : "
												+ course_id + " Started");
								pwa.VerifyCaption(
										rs.getString("duration_value") + " "
												+ rs.getString("duration_unit"),
										"duration");
								CommonFunctions.info(clpTopSection,
										"Verify Course Duration along with unit for course : "
												+ course_id + " Completed");

								CommonFunctions.info(clpTopSection,
										"Verify Course Credentials and Degree  for course : "
												+ course_id + " Started");
								// // Verify CourseTypeInformation
								String degree = "Degree";
								String credential = "Credential";
								tempRs = db.CourseTypeInformation(course_id,
										obj);
								if (db.getCountOfResultSet(tempRs) > 1) {
									while (tempRs.next()) {
										if (tempRs.getString("attribute_name")
												.equalsIgnoreCase("Credential"))
											credential = tempRs
													.getString("value_name");

										if (tempRs.getString("attribute_name")
												.equalsIgnoreCase(
														"Course Level"))
											degree = tempRs
													.getString("value_name");
									}
								}
								if (!degree.equalsIgnoreCase("none"))
									pwa.VerifyCaption(
											degree + " " + credential,
											"Credetials");
								else
									pwa.VerifyCaption(credential, "Credetials");

								CommonFunctions.info(clpTopSection,
										"Verify Course Credentials and Degree  for course : "
												+ course_id + " Completed");

								CommonFunctions.info(clpTopSection,
										"Verify Course Education Type(Full Time/Part Time) for course : "
												+ course_id + " Started");
								// // Verify Education Type
								if (rs.getString("education_type").equals("21")) {
									tempRs = db.BaseAttributeList(
											rs.getString("delivery_method"),
											obj);
									if (db.getCountOfResultSet(tempRs) == 1) {
										while (tempRs.next()) {
											pwa.VerifyCaption(tempRs
													.getString("value_name"),
													"Education Mode(Full Time/Part Time)");
										}
									}
								} else {
									ResultSet tempRs1 = db
											.BaseAttributeList(
													rs.getString("education_type"),
													obj);
									if (db.getCountOfResultSet(tempRs1) == 1) {
										while (tempRs1.next()) {
											pwa.VerifyCaption(tempRs1
													.getString("value_name"),
													"Education Mode(Full Time/Part Time)");
										}
									}
								}
								CommonFunctions.info(clpTopSection,
										"Verify Course Education Type(Full Time/Part Time) for course : "
												+ course_id + " Completed");

								// // Verify duration_disclaimer
								CommonFunctions.info(clpTopSection,
										"Verify Course Duration Disclamar for course : "
												+ course_id + " Started");
								if (rs.getString("duration_disclaimer") != null) {
									pwa.VerifyDurationDisclamar("Duration may change depending upon course modules and course timing slots.");
									CommonFunctions.info(clpTopSection,
											"Verify Course Duration Disclamar for course : "
													+ course_id + " Completed");
								} else
									CommonFunctions.info(clpTopSection,
											"Verify Course Duration Disclamar for course : "
													+ course_id
													+ " Does not Exists");

								// // Verify recognition
								CommonFunctions.info(clpTopSection,
										"Verify Course Recognition(AICTE/DCE Etc.) for course : "
												+ course_id + " Started");
								String[] acc = null;
								tempRs = db.CourseRecogition(course_id, obj);
								int dbCount = db.getCountOfResultSet(tempRs);
								if (dbCount == 0) {
									CommonFunctions.info(clpTopSection,
											"Verify Course Recognition(AICTE/DCE Etc.) for course : "
													+ course_id
													+ " Doesn't Exist");
								} else {
									int count = 0;
									int datarow = 1;
									int row = 1;
									while (tempRs.next()) {
										String nba = tempRs
												.getString("value_name");
										if (!nba.equalsIgnoreCase("nba")) {
											if (count == 0) {
												row = pwa
														.VerifyData(tempRs
																.getString("value_name"));
											}
											pwa.VerifyDataLayer(dbCount, tempRs
													.getString("value_name"),
													row, "recognition", datarow);
											count++;
											datarow++;
											pwa.LayerClose();
										} else {
											if (rs.getString("accreditation") != null) {
												acc = new String[2];
												acc[0] = "NBA";
												acc[1] = rs
														.getString("accreditation");
											}

											else {
												acc = new String[1];
												acc[0] = "NBA";
											}

										}
									}
								}
								CommonFunctions.info(clpTopSection,
										"Verify Course Recognition(AICTE/DCE Etc.) for course : "
												+ course_id + " Completed");

								// // Verify Grade
								CommonFunctions.info(clpTopSection,
										"Verify Grade(Grade A+ Institute) for course : "
												+ course_id + " Started");
								if (acc == null) {
									String accre = rs
											.getString("accreditation");
									if (accre != null) {
										if (accre.length() > 1) {
											acc = new String[1];
											acc[0] = rs
													.getString("accreditation");
										}
									}
								}
								if (acc == null) {
									CommonFunctions.info(clpTopSection,
											"Verify Grade(Grade A+ Institute) for course : "
													+ course_id
													+ " Doesn't Exist");
								}

								else {
									int count = 0;
									int datarow1 = 1;
									int row1 = 1;
									for (String abc : acc) {
										if (!abc.equalsIgnoreCase("nba")) {
											abc = CommonFunctions
													.StaticData(abc);
										}
										if (count == 0) {
											row1 = pwa.VerifyData(abc);
										}
										pwa.VerifyDataLayer(acc.length, abc,
												row1, "recognition", datarow1);
										count++;
										datarow1++;
										pwa.LayerClose();
									}
								}
								CommonFunctions.info(clpTopSection,
										"Verify Grade(Grade A+ Institute) for course : "
												+ course_id + " Completed");

								// //Verify Medium
								CommonFunctions.info(clpTopSection,
										"Verify Medium(English etc) for course : "
												+ course_id + " Started");
								tempRs = db.CourseMedium(course_id, obj);
								int dbCount1 = db.getCountOfResultSet(tempRs);
								if (dbCount1 == 0) {
									CommonFunctions.info(clpTopSection,
											"Verify Medium(English etc) for course : "
													+ course_id
													+ " Doesn't Exist");
								} else {
									int count = 0;
									int datarow = 1;
									int row = 1;
									while (tempRs.next()) {
										if (count == 0) {
											row = pwa.VerifyData(tempRs
													.getString("value_name"));
										}
										pwa.VerifyDataLayer(dbCount1,
												tempRs.getString("value_name"),
												row, "Medium", datarow);
										count++;
										datarow++;
										pwa.LayerClose();

									}
								}
								CommonFunctions.info(clpTopSection,
										"Verify Medium(English etc) for course : "
												+ course_id + " Completed");

								// // Verify Fees
								CommonFunctions.info(clpTopSection,
										"Verify Fees for course : " + course_id
												+ " Started");
								tempRs = db.CourseFees(course_id, city_id,
										locality_id, obj);
								String fee = "";
								int coursedCount = db
										.getCountOfResultSet(tempRs);
								if (coursedCount > 0) {
									while (tempRs.next()) {
										String overall = tempRs
												.getString("period");
										String category = tempRs
												.getString("category");
										if (overall.equalsIgnoreCase("overall")
												&& category
														.equalsIgnoreCase("general")) {
											fee = tempRs
													.getString("currency_code")
													+ " "
													+ tempRs.getString("fees_value");
											pwa.VerifyFeesAndLevel(fee);

										}
										if (overall.equalsIgnoreCase("overall")
												&& !category
														.equalsIgnoreCase("general")) {
											pwa.VerifyFeesDisclamar(
													fee,
													"The shown fees is for the general category and will vary for other reservation categories. Please refer to the fees section below for category specific fees information.");
											break;
										}
									}
								} else {
									CommonFunctions.info(clpTopSection,
											"Verify Fees for course : "
													+ course_id
													+ " doesn't Exist");
								}
								CommonFunctions.info(clpTopSection,
										"Verify Fees for course : " + course_id
												+ " Completed");

								// // Verify Difficulty Level
								CommonFunctions.info(clpTopSection,
										"Verify Difficulty Level for course : "
												+ course_id + " Completed");

								tempRs = db.DifficultyLevel(course_id, obj);
								if (db.getCountOfResultSet(tempRs) == 1) {
									while (tempRs.next()) {
										pwa.VerifyFeesAndLevel(tempRs
												.getString("value_name"));
									}
								} else {
									CommonFunctions.info(clpTopSection,
											"Verify Difficulty Level for course : "
													+ course_id
													+ " doesn't exist");
								}
								CommonFunctions.info(clpTopSection,
										"Verify Difficulty Level for course : "
												+ course_id + " Completed");

								// // Verify Affiliated university
								/*
								 * 
								 * 
								 * ONE CASE PENDING VERIFICATION FOR FREE TEXT
								 * UNIVERSITY
								 */
								CommonFunctions.info(clpTopSection,
										"Verify Affilitated University for course : "
												+ course_id + " Started");
								String insId = "";
								String listing_type = "";
								String univurl = "";
								if (rs.getString("affiliated_university_id") != null) {
									insId = rs
											.getString("affiliated_university_id");
									tempRs = db.GetLisingUrl(insId, obj);
									if (db.getCountOfResultSet(tempRs) == 1) {
										while (tempRs.next()) {
											univurl = tempRs
													.getString("listing_seo_url");
											listing_type = tempRs
													.getString("listing_type");
										}
									} else {
										CommonFunctions
												.error(clpTopSection,
														"In Affiliated to university section multiple rows returned, please verify manually for course : "
																+ course_id);
									}
								}
								if (rs.getString("affiliated_university_name") != null)
									pwa.VerifyAffiliatedTo(
											rs.getString("affiliated_university_name"),
											insId,
											rs.getString("affiliated_university_scope"),
											univurl, listing_type);
								else
									CommonFunctions.info(clpTopSection,
											"Verify Affilitated University for course : "
													+ course_id
													+ " Doesn't Exist");
								CommonFunctions.info(clpTopSection,
										"Verify Affilitated University for course : "
												+ course_id + " Completed");

								// // Verify Dates
								// // not verifying from db, verified from
								// important
								// // dates section(top date)
								// // just to reduce db queries
								CommonFunctions.info(clpTopSection,
										"Verify Dates for course : "
												+ course_id + " Started");
								pwa.VerifyDateForTopSection();
								CommonFunctions.info(clpTopSection,
										"Verify Dates for course : "
												+ course_id + " Completed");

								// // Check Multi localities
								CommonFunctions.info(clpTopSection,
										"Verify MultiLocations for course : "
												+ course_id + " Started");

								tempRs = db.GetLocalities(course_id, obj);
								int localityCount = db
										.getCountOfResultSet(tempRs);
								if (localityCount == 0) {
									CommonFunctions.error(clpTopSection,
											"Some issue exists for verification of MultiLocations for course : "
													+ course_id);

								} else if (localityCount == 1) {
									CommonFunctions.info(clpTopSection,
											"Course : " + course_id
													+ "is not Multi Location");
								} else {
									String city = "";
									String loclity = "";
									String cityId = "";
									String localityId = "";
									String searchName = "";
									String isMain = "";
									while (tempRs.next()) {

										city = tempRs.getString("city_name");

										loclity = tempRs
												.getString("localityName");
										cityId = tempRs.getString("city_id");
										localityId = tempRs
												.getString("locality_id");
										isMain = tempRs.getString("is_main");
										if (loclity != null) {
											searchName = loclity;
										} else {
											searchName = city;
											localityId = "";
										}

										pwa.VerifyAllML(localityCount,
												searchName, cityId, localityId,
												isMain);
									}

								}
								CommonFunctions.info(clpTopSection,
										"Verify MultiLocations for course : "
												+ course_id + " Completed");

								/*
								 * 
								 * 
								 * THESE SECTIONS WILL BE IMPLEMENTED ONCE DEV
								 * IS DONE Verify Download, Verify Shortlist,
								 */
							}

							// // Course Structure
							try {
								pwa = new PWA(driver, clpCourseStructureSection);
								CommonFunctions.info(clpCourseStructureSection,
										"Runnig Iteration " + (iterationCount)
												+ "For URL : " + finalUrl);
								rs = db.GetCourseStructure(course_id, obj);
								int courseCount = db.getCountOfResultSet(rs);
								if (pwa.CheckCourseStructure()
										|| courseCount > 0) {
									ArrayList<String> mainPage = null;

									if (courseCount > 1) {
										String period = "";
										mainPage = new ArrayList<String>();
										while (rs.next()) {
											period = rs.getString("period");
											mainPage.add(rs
													.getString("courses_offered"));

										} // // Verify Title for program and //
											// // year/Term etc

										CommonFunctions.info(
												clpCourseStructureSection,
												"Verifying Course Heading and Courses on Main Page for course id : "
														+ course_id
														+ " Started");
										pwa.CheckCourseHeading(period);
										pwa.VerifyCoursesOnPage(mainPage);
										CommonFunctions.info(
												clpCourseStructureSection,
												"Verifying Course Heading and Courses on Main Page for course id : "
														+ course_id
														+ " Completed");
										// Verify view all course structure\
										// button
										CommonFunctions.info(
												clpCourseStructureSection,
												"Verifying Course Heading and courses on Layer for course id : "
														+ course_id
														+ " Started");
										Boolean result = pwa
												.CheckViewAllCourseButton();
										// // Verify all courses on layer
										if (result) {
											CommonFunctions.info(
													clpCourseStructureSection,
													"Verifying Course Heading and courses on Layer for course id : "
															+ course_id
															+ "on layer found");
											pwa.VerifyHeadingsOnLayer(period);
											pwa.VerifyCoursesOnLayer(mainPage);

										} else {
											CommonFunctions
													.info(clpCourseStructureSection,
															"Verifying Course Heading and courses on Layer for course id : "
																	+ course_id
																	+ "on layer Doesn't Exists");
										}
										CommonFunctions.info(
												clpCourseStructureSection,
												"Verifying Course Heading and courses on Layer for course id : "
														+ course_id
														+ " Completed");

									} else {
										CommonFunctions.info(
												clpCourseStructureSection,
												"Course Structure didn't returned from db for course id : "
														+ course_id);
									}
								}

								else {
									CommonFunctions.info(
											clpCourseStructureSection,
											"Course Structure doesn't exist for course id :"
													+ course_id);

								}

							} catch (Exception e) { // // Exception block for
													// Course Structure
							} finally {

							}
							// //End of Course Structure

						}

						else {
							CommonFunctions.error(clpTopSection,
									"Multiple rows returned, Please check database and course id :"
											+ course_id);
						}

					} else {
						CommonFunctions.fail(clpTopSection,
								"Top Section doesn't exist for course id :"
										+ course_id);
					}
					// // End of Top Section

				} catch (Exception e) {
					// // Exception block for for loop
					continue;
				}
			}
		} catch (Exception e) {
			// // Exception block for main threaAd to close all child loop
		}

		finally {
			CommonFunctions.closeChild(parent, clpTopSection, report);
			CommonFunctions.closeChild(parent, clpCourseStructureSection,
					report);

		}
	}
}
