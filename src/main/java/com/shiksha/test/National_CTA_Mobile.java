package com.shiksha.test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.CTA_Mobile;
import com.shiksha.object.PWA;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.Database;
import com.shiksha.resourses.ExcelReader;

public class National_CTA_Mobile {
	PWA pwa = null;
	CommonFunctions CommonFunctions = new CommonFunctions();
	Database db = new Database();

	public void CTA_Download(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		CTA_Mobile cta = new CTA_Mobile();
		Boolean flag = false;
		ExtentTest tr = CommonFunctions.createChild(report,
				"In Case any error exists", "");
		CommonFunctions
				.info(tr,
						"this child will consists errors in case of intermittent issue");
		LinkedHashMap<String, ExtentTest> reports = new LinkedHashMap<String, ExtentTest>();

		for (int i = 0; i < ExcelReader.getRows("\\Mobile\\Download_CTA"); i++) {

			String runMode = ExcelReader.getData(i, "RunMode",
					"\\Mobile\\Download_CTA");

			if (runMode.equalsIgnoreCase("y")) {

				String listing_id = ExcelReader.getData(i, "listing_id",
						"\\Mobile\\Download_CTA");
				String CTA_Page = ExcelReader.getData(i, "CTA_Page",
						"\\Mobile\\Download_CTA");
				String CTA_Action = ExcelReader.getData(i, "CTA_Action",
						"\\Mobile\\Download_CTA");
				String Shiksha = ExcelReader.getData(i, "Shiksha",
						"\\Mobile\\Download_CTA");
				String Login = ExcelReader.getData(i, "Login",
						"\\Mobile\\Download_CTA");
				String relative_url = ExcelReader.getData(i, "relative_url",
						"\\Mobile\\Download_CTA");
				String Locator = ExcelReader.getData(i, "Locator",
						"\\Mobile\\Download_CTA");
				String Value = ExcelReader.getData(i, "Value",
						"\\Mobile\\Download_CTA");
				String Tracking_KeyId = ExcelReader.getData(i,
						"Tracking_KeyId", "\\Mobile\\Download_CTA");
				String action_type = ExcelReader.getData(i, "action_type",
						"\\Mobile\\Download_CTA");
				String layer = ExcelReader.getData(i, "layer",
						"\\Mobile\\Download_CTA");

				try {
					driver.manage().deleteAllCookies();
					driver.get(url + relative_url);
					try {
						driver.manage().deleteAllCookies();
					} catch (Exception e) {
						// // Do nothing
					}
					CommonFunctions.acceptCookie(driver);
					// // Click Download Brochure
					ExtentTest t1 = null;
					if (reports.get("clickdownloadBrochure") != null) {
						t1 = reports.get("clickdownloadBrochure");
					} else {
						t1 = CommonFunctions.createChild(report,
								"Download CTA", "");
						reports.put("clickdownloadBrochure", t1);
					}

					CommonFunctions.info(t1, "Iteration " + i + " For URL : "
							+ url + relative_url);

					if (CTA_Action.toLowerCase().contains("sticky")) {
						cta.EnableStickyCTA(driver);
					}

					if (CTA_Page.contains("Career")) {
						cta.careerCta(driver);
					}

					if (CTA_Action.toLowerCase().contains("scroll")) {
						cta.ScrollCTA(driver);
					}

					String CTA = "Action performed on page : " + CTA_Page
							+ " with CTA Action : " + CTA_Action
							+ " For Shiksha : " + Shiksha + " in : " + Login
							+ " Case";

					listing_id = cta.clickdownloadBrochure(t1, driver, Locator,
							Value, CTA, listing_id);

					String email = "";
					String[] xs = new String[2];
					if (Login.equalsIgnoreCase("login")) {
						// // login flow
						email = cta.login(driver, obj);
					} else {
						xs = cta.signup(driver, obj);
						email = xs[0];

						if (!obj.getserver().equalsIgnoreCase("live")
								&& Login.equalsIgnoreCase("signup")) {

							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions.pass(t3,
										"Db verification Before OTP for tuser passed for userid : "
												+ userId + " for :" + CTA
												+ " New row inserted");
							} else {
								CommonFunctions.fail(driver, t3,
										"Db verification Before OTP for tuser passed for userid : "
												+ userId + " for :" + CTA
												+ " no New row inserted");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions.pass(t4,
										"Db verification Before OTP for tUserInterest passed for  "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t4,
										"Db verification Before OTP for tUserInterest failed for  "
												+ CTA + "no New row inserted");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions.pass(t5,
										"Db verification Before OTP for tUserCourseSpecialization passed for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t5,
										"Db verification Before OTP for tUserCourseSpecialization failed for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions.pass(t6,
										"Db verification Before OTP for tUserAttributes passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t6,
										"Db verification Before OTP for tUserAttributes failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions.pass(t7,
										"Db verification Before OTP for tuserflag passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t7,
										"Db verification Before OTP for tuserflag failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions.pass(t8,
										"Db verification  Before OTP for tUserPref passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t8,
										"Db verification for Before OTP tUserPref failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification Before OTP for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted");
								} else {
									CommonFunctions.fail(driver, t9,
											"Db verification Before OTP for tUserEducation failed for cta "
													+ CTA
													+ "no New row inserted");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for  Before OTP tUserEducation doesn't exist for cta "
												+ CTA);

							}

							ExtentTest t10 = null;
							if (reports.get("temp_response_queue") != null) {
								t10 = reports.get("temp_response_queue");

							} else {
								t10 = CommonFunctions
										.createChild(
												report,
												"Verify temp_response_queue  table",
												"");
								reports.put("temp_response_queue", t10);
							}

							CommonFunctions.info(t10, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.temp_response_queue(email,
									Tracking_KeyId, listing_id, "",
									action_type, obj);
							if (!flag) {
								CommonFunctions.pass(t10,
										"Db verification Before OTP for temp_response_queue passed for cta "
												+ CTA + "no New row inserted");
							} else {
								CommonFunctions.fail(driver, t10,
										"Db verification Before OTP for temp_response_queue failed for cta "
												+ CTA + " New row inserted");
							}

							ExtentTest t11 = null;
							if (reports.get("user_response_profile") != null) {
								t11 = reports.get("user_response_profile");

							} else {
								t11 = CommonFunctions.createChild(report,
										"Verify user_response_profile table",
										"");
								reports.put("user_response_profile", t11);
							}

							CommonFunctions.info(t11, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.user_response_profile(email,
									obj);
							if (!flag) {
								CommonFunctions.pass(t11,
										"Db verification Before OTP for user_response_profile passed for cta "
												+ CTA + " no New row inserted");
							} else {
								CommonFunctions.fail(driver, t11,
										"Db verification Before OTP for user_response_profile failed for cta "
												+ CTA + " New row inserted");
							}
						}

						if (obj.getdbUserName() != null)
							CommonFunctions.OTPVerification(driver, xs[2],
									true, obj);
					}

					ExtentTest t2 = null;
					if (reports.get("verifyLayer") != null) {
						t2 = reports.get("verifyLayer");

					} else {
						t2 = CommonFunctions.createChild(report,
								"Verify Layer after action", "");
						reports.put("verifyLayer", t2);
					}

					CommonFunctions.info(t2, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t2,
							"CTA Action performed for email : " + email
									+ " for listing id : " + listing_id);
					if (layer.equalsIgnoreCase("y"))
						CommonFunctions.info(t2,
								"No need to verify Layer for email : " + email
										+ " for listing id : " + listing_id);
					cta.verifyLayer(driver, t2, CTA, CTA_Action, layer);

					// // DB Verification Started
					if (!obj.getserver().equalsIgnoreCase("live")) {
						if (Login.equalsIgnoreCase("signup")) {
							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions
										.pass(t3,
												"Db verification after OTP for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t3,
												"Db verification after OTP for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t4,
												"Db verification after OTP for tUserInterest passed for  "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t4,
												"Db verification  after OTP for tUserInterest failed for  "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions
										.pass(t5,
												"Db verification after OTP for tUserCourseSpecialization passed for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t5,
												"Db verification after OTP for tUserCourseSpecialization failed for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t6,
												"Db verification after OTP for tUserAttributes passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t6,
												"Db verification after OTP for tUserAttributes failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t7,
												"Db verification after OTP for tuserflag passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t7,
												"Db verification after OTP for tuserflag failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t8,
												"Db verification after OTP for tUserPref passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t8,
												"Db verification after OTP for tUserPref failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification after OTP for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted verified after OTP");
								} else {
									CommonFunctions
											.fail(driver,
													t9,
													"Db verification after OTP for tUserEducation failed for cta "
															+ CTA
															+ " no New row inserted verified after OTP");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for after OTP tUserEducation doesn't exist for cta "
												+ CTA);
							}

						}

						ExtentTest t10 = null;
						if (reports.get("temp_response_queue") != null) {
							t10 = reports.get("temp_response_queue");

						} else {
							t10 = CommonFunctions.createChild(report,
									"Verify temp_response_queue  table", "");
							reports.put("temp_response_queue", t10);
						}

						CommonFunctions.info(t10, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions.temp_response_queue(email,
								Tracking_KeyId, listing_id, "", action_type,
								obj);
						if (flag) {
							CommonFunctions
									.pass(t10,
											"Db verification after OTP for temp_response_queue passed for cta "
													+ CTA
													+ " New row inserted verified after OTP");
						} else {
							CommonFunctions
									.fail(driver,
											t10,
											"Db verification after OTP for temp_response_queue failed for cta "
													+ CTA
													+ " no New row inserted verified after OTP");
						}

						ExtentTest t11 = null;
						if (reports.get("user_response_profile") != null) {
							t11 = reports.get("user_response_profile");

						} else {
							t11 = CommonFunctions.createChild(report,
									"Verify user_response_profile table", "");
							reports.put("user_response_profile", t11);
						}

						CommonFunctions.info(t11, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions
								.user_response_profile(email, obj);
						if (flag) {
							CommonFunctions
									.pass(t11,
											"Db verification  after OTP for user_response_profile passed for cta "
													+ CTA
													+ " New row inserted verified after OTP");
						} else {
							CommonFunctions
									.fail(driver,
											t11,
											"Db verification after OTP for user_response_profile failed for cta "
													+ CTA
													+ "no New row inserted verified after OTP");
						}
					}
				}

				catch (Exception e) {
					CommonFunctions.fail(driver, tr, "issue at iteration : "
							+ i + " issue is : " + e.toString());
					continue;
				}
			}
			Thread.sleep(5000);
		}

		for (Entry<String, ExtentTest> entry : reports.entrySet()) {
			ExtentTest t = entry.getValue();
			if (t.getTest().getStatus().toString().equals("fail")) {
				CommonFunctions.closeChild(parent, t, report, "fail");
			} else
				CommonFunctions.closeChild(parent, t, report);
		}

		CommonFunctions.closeChild(parent, tr, report);
	}

	public void CTA_Shortlist(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		CTA_Mobile cta = new CTA_Mobile();
		Boolean flag = false;
		ExtentTest tr = CommonFunctions.createChild(report,
				"In Case any error exists", "");
		LinkedHashMap<String, ExtentTest> reports = new LinkedHashMap<String, ExtentTest>();
		CommonFunctions
				.info(tr,
						"this child will consists errors in case of intermittent issue");
		for (int i = 0; i < ExcelReader.getRows("\\Mobile\\Shortlist_CTA"); i++) {

			String runMode = ExcelReader.getData(i, "RunMode",
					"\\Mobile\\Shortlist_CTA");

			if (runMode.equalsIgnoreCase("y")) {

				String listing_id = ExcelReader.getData(i, "listing_id",
						"\\Mobile\\Shortlist_CTA");
				String CTA_Page = ExcelReader.getData(i, "CTA_Page",
						"\\Mobile\\Shortlist_CTA");
				String CTA_Action = ExcelReader.getData(i, "CTA_Action",
						"\\Mobile\\Shortlist_CTA");
				String Shiksha = ExcelReader.getData(i, "Shiksha",
						"\\Mobile\\Shortlist_CTA");
				String Login = ExcelReader.getData(i, "Login",
						"\\Mobile\\Shortlist_CTA");
				String relative_url = ExcelReader.getData(i, "relative_url",
						"\\Mobile\\Shortlist_CTA");
				String Locator = ExcelReader.getData(i, "Locator",
						"\\Mobile\\Shortlist_CTA");
				String Value = ExcelReader.getData(i, "Value",
						"\\Mobile\\Shortlist_CTA");
				String Tracking_KeyId = ExcelReader.getData(i,
						"Tracking_KeyId", "\\Mobile\\Shortlist_CTA");
				String action_type = ExcelReader.getData(i, "action_type",
						"\\Mobile\\Shortlist_CTA");
				String layer = ExcelReader.getData(i, "layer",
						"\\Mobile\\Shortlist_CTA");
				try {
					driver.manage().deleteAllCookies();
					driver.get(url + relative_url);
					try {
						driver.manage().deleteAllCookies();
					} catch (Exception e) {
						// // Do nothing
					}
					CommonFunctions.acceptCookie(driver);
					// // Click Download Brochure
					ExtentTest t1 = null;
					if (reports.get("clickshortlist") != null) {
						t1 = reports.get("clickshortlist");
					} else {
						t1 = CommonFunctions.createChild(report,
								"Shortlist CTA", "");
						reports.put("clickshortlist", t1);
					}

					CommonFunctions.info(t1, "Iteration " + i + " For URL : "
							+ url + relative_url);

					String CTA = "Action performed on page : " + CTA_Page
							+ " with CTA Action : " + CTA_Action
							+ " For Shiksha : " + Shiksha + " for : " + Login
							+ " Case.";

					listing_id = cta.clickdownloadBrochure(t1, driver, Locator,
							Value, CTA, listing_id);

					String email = "";
					String[] xs = new String[2];
					if (Login.equalsIgnoreCase("login")) {
						// // login flow
						email = cta.login(driver, obj);
					} else {
						xs = cta.signup(driver, obj);
						email = xs[0];

						if (!obj.getserver().equalsIgnoreCase("live")
								&& Login.equalsIgnoreCase("signup")) {

							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions.pass(t3,
										"Db verification Before OTP for tuser passed for userid : "
												+ userId + " for :" + CTA
												+ " New row inserted");
							} else {
								CommonFunctions.fail(driver, t3,
										"Db verification Before OTP for tuser passed for userid : "
												+ userId + " for :" + CTA
												+ " no New row inserted");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions.pass(t4,
										"Db verification Before OTP for tUserInterest passed for  "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t4,
										"Db verification Before OTP for tUserInterest failed for  "
												+ CTA + " no New row inserted");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions.pass(t5,
										"Db verification Before OTP for tUserCourseSpecialization passed for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t5,
										"Db verification Before OTP for tUserCourseSpecialization failed for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions.pass(t6,
										"Db verification Before OTP for tUserAttributes passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t6,
										"Db verification Before OTP for tUserAttributes failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions.pass(t7,
										"Db verification Before OTP for tuserflag passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t7,
										"Db verification Before OTP for tuserflag failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions.pass(t8,
										"Db verification  Before OTP for tUserPref passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t8,
										"Db verification for Before OTP tUserPref failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification Before OTP for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted");
								} else {
									CommonFunctions.fail(driver, t9,
											"Db verification Before OTP for tUserEducation failed for cta "
													+ CTA
													+ " no New row inserted");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for  Before OTP tUserEducation doesn't exist for cta "
												+ CTA);

							}

							ExtentTest t10 = null;
							if (reports.get("temp_response_queue") != null) {
								t10 = reports.get("temp_response_queue");

							} else {
								t10 = CommonFunctions
										.createChild(
												report,
												"Verify temp_response_queue  table",
												"");
								reports.put("temp_response_queue", t10);
							}

							CommonFunctions.info(t10, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.temp_response_queue(email,
									Tracking_KeyId, listing_id, "",
									action_type, obj);
							if (!flag) {
								CommonFunctions.pass(t10,
										"Db verification Before OTP for temp_response_queue passed for cta "
												+ CTA + " no New row inserted");
							} else {
								CommonFunctions.fail(driver, t10,
										"Db verification Before OTP for temp_response_queue failed for cta "
												+ CTA + " New row inserted");
							}

							ExtentTest t11 = null;
							if (reports.get("user_response_profile") != null) {
								t11 = reports.get("user_response_profile");

							} else {
								t11 = CommonFunctions.createChild(report,
										"Verify user_response_profile table",
										"");
								reports.put("user_response_profile", t11);
							}

							CommonFunctions.info(t11, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.user_response_profile(email,
									obj);
							if (!flag) {
								CommonFunctions.pass(t11,
										"Db verification Before OTP for user_response_profile passed for cta "
												+ CTA + " no New row inserted");
							} else {
								CommonFunctions.fail(driver, t11,
										"Db verification Before OTP for user_response_profile failed for cta "
												+ CTA + " New row inserted");
							}
						}

						if (obj.getdbUserName() != null)
							CommonFunctions.OTPVerification(driver, xs[2],
									true, obj);
					}

					ExtentTest t2 = null;
					if (reports.get("verifyLayer") != null) {
						t2 = reports.get("verifyLayer");

					} else {
						t2 = CommonFunctions.createChild(report,
								"Verify Layer after action", "");
						reports.put("verifyLayer", t2);
					}

					CommonFunctions.info(t2, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t2,
							"CTA Action performed for email : " + email
									+ " for listing id : " + listing_id);
					if (layer.equalsIgnoreCase("y"))
						CommonFunctions.info(t2,
								"No need to verify Layer for email : " + email
										+ " for listing id : " + listing_id);
					cta.verifyLayer(driver, t2, CTA, CTA_Action, layer);

					// // DB Verification Started
					if (!obj.getserver().equalsIgnoreCase("live")) {
						if (Login.equalsIgnoreCase("signup")) {
							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions
										.pass(t3,
												"Db verification after OTP for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t3,
												"Db verification after OTP for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t4,
												"Db verification after OTP for tUserInterest passed for  "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t4,
												"Db verification  after OTP for tUserInterest failed for  "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions
										.pass(t5,
												"Db verification after OTP for tUserCourseSpecialization passed for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t5,
												"Db verification after OTP for tUserCourseSpecialization failed for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t6,
												"Db verification after OTP for tUserAttributes passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t6,
												"Db verification after OTP for tUserAttributes failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t7,
												"Db verification after OTP for tuserflag passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t7,
												"Db verification after OTP for tuserflag failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t8,
												"Db verification after OTP for tUserPref passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t8,
												"Db verification after OTP for tUserPref failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification after OTP for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted verified after OTP");
								} else {
									CommonFunctions
											.fail(driver,
													t9,
													"Db verification after OTP for tUserEducation failed for cta "
															+ CTA
															+ " no New row inserted verified after OTP");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for after OTP tUserEducation doesn't exist for cta "
												+ CTA);
							}

						}

						ExtentTest t10 = null;
						if (reports.get("temp_response_queue") != null) {
							t10 = reports.get("temp_response_queue");

						} else {
							t10 = CommonFunctions.createChild(report,
									"Verify temp_response_queue  table", "");
							reports.put("temp_response_queue", t10);
						}

						CommonFunctions.info(t10, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions.temp_response_queue(email,
								Tracking_KeyId, listing_id, "", action_type,
								obj);
						if (flag) {
							CommonFunctions
									.pass(t10,
											"Db verification after OTP for temp_response_queue passed for cta "
													+ CTA
													+ " New row inserted verified after OTP");
						} else {
							CommonFunctions
									.fail(driver,
											t10,
											"Db verification after OTP for temp_response_queue failed for cta "
													+ CTA
													+ " no New row inserted verified after OTP");
						}

						ExtentTest t11 = null;
						if (reports.get("user_response_profile") != null) {
							t11 = reports.get("user_response_profile");

						} else {
							t11 = CommonFunctions.createChild(report,
									"Verify user_response_profile table", "");
							reports.put("user_response_profile", t11);
						}

						CommonFunctions.info(t11, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions
								.user_response_profile(email, obj);
						if (flag) {
							CommonFunctions
									.pass(t11,
											"Db verification  after OTP for user_response_profile passed for cta "
													+ CTA
													+ " New row inserted verified after OTP");
						} else {
							CommonFunctions
									.fail(driver,
											t11,
											"Db verification after OTP for user_response_profile failed for cta "
													+ CTA
													+ " no New row inserted verified after OTP");
						}
					}
				}

				catch (Exception e) {
					CommonFunctions.fail(driver, tr, "issue at iteration : "
							+ i + " issue is : " + e.toString());
					continue;
				}
			}
			Thread.sleep(1000);
		}

		for (Entry<String, ExtentTest> entry : reports.entrySet()) {
			ExtentTest t = entry.getValue();
			if (t.getTest().getStatus().toString().equals("fail")) {
				CommonFunctions.closeChild(parent, t, report, "fail");
			} else
				CommonFunctions.closeChild(parent, t, report);
		}
		CommonFunctions.closeChild(parent, tr, report);
	}

	public void CTA_Compare(Objects obj) throws Exception {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		CTA_Mobile cta = new CTA_Mobile();
		Boolean flag = false;
		ExtentTest tr = CommonFunctions.createChild(report,
				"In Case any error exists", "");
		LinkedHashMap<String, ExtentTest> reports = new LinkedHashMap<String, ExtentTest>();
		CommonFunctions
				.info(tr,
						"this child will consists errors in case of intermittent issue");
		for (int i = 0; i < ExcelReader.getRows("\\Mobile\\Compare_CTA"); i++) {

			String runMode = ExcelReader.getData(i, "RunMode",
					"\\Mobile\\Compare_CTA");

			if (runMode.equalsIgnoreCase("y")) {
				String CTA_Page = ExcelReader.getData(i, "CTA_Page",
						"\\Mobile\\Compare_CTA");
				String CTA_Action = ExcelReader.getData(i, "CTA_Action",
						"\\Mobile\\Compare_CTA");
				String Shiksha = ExcelReader.getData(i, "Shiksha",
						"\\Mobile\\Compare_CTA");
				String Login = ExcelReader.getData(i, "Login",
						"\\Mobile\\Compare_CTA");
				String relative_url = ExcelReader.getData(i, "relative_url",
						"\\Mobile\\Compare_CTA");
				String Locator = ExcelReader.getData(i, "Locator",
						"\\Mobile\\Compare_CTA");
				String Value = ExcelReader.getData(i, "Value",
						"\\Mobile\\Compare_CTA");
				String Tracking_KeyId = ExcelReader.getData(i,
						"Tracking_KeyId", "\\Mobile\\Compare_CTA");
				try {
					driver.manage().deleteAllCookies();
					driver.get(url + relative_url);
					try {
						driver.manage().deleteAllCookies();
					} catch (Exception e) {
						// // Do nothing
					}
					CommonFunctions.acceptCookie(driver);
					// // Click compare Brochure
					ExtentTest t1 = null;
					if (reports.get("clickcompare") != null) {
						t1 = reports.get("clickcompare");
					} else {
						t1 = CommonFunctions.createChild(report, "Compare CTA",
								"");
						reports.put("clickcompare", t1);
					}

					CommonFunctions.info(t1, "Iteration " + i + " For URL : "
							+ url + relative_url);

					String CTA = "Action performed on page : " + CTA_Page
							+ " with CTA Action : " + CTA_Action
							+ " For Shiksha : " + Shiksha + " for : " + Login
							+ " Case.";

					if (CTA_Action.equalsIgnoreCase("compare_sticky"))
						cta.clickcompare_sticky(t1, driver, Locator, Value, CTA);

					else if (CTA_Action.equalsIgnoreCase("compare_amp"))
						cta.clickcompare_AMP(t1, driver, Locator, Value, CTA);

					else if (CTA_Action.equalsIgnoreCase("compare_scroll"))
						cta.clickcompare_scroll(t1, driver, Locator, Value, CTA);

					else
						cta.clickcompare(t1, driver, Locator, Value, CTA);

					String email = "";
					String[] xs = new String[2];
					if (Login.equalsIgnoreCase("login")) {
						// // login flow
						email = cta.login(driver, obj);
					} else {
						xs = cta.signup(driver, obj);
						email = xs[0];

						if (!obj.getserver().equalsIgnoreCase("live")
								&& Login.equalsIgnoreCase("signup")
								&& !CTA_Action.equalsIgnoreCase("compare_amp")) {

							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions.pass(t3,
										"Db verification Before OTP for tuser passed for userid : "
												+ userId + " for :" + CTA
												+ " New row inserted");
							} else {
								CommonFunctions.fail(driver, t3,
										"Db verification Before OTP for tuser passed for userid : "
												+ userId + " for :" + CTA
												+ " no New row inserted");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions.pass(t4,
										"Db verification Before OTP for tUserInterest passed for  "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t4,
										"Db verification Before OTP for tUserInterest failed for  "
												+ CTA + "no New row inserted");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions.pass(t5,
										"Db verification Before OTP for tUserCourseSpecialization passed for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t5,
										"Db verification Before OTP for tUserCourseSpecialization failed for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions.pass(t6,
										"Db verification Before OTP for tUserAttributes passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t6,
										"Db verification Before OTP for tUserAttributes failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions.pass(t7,
										"Db verification Before OTP for tuserflag passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t7,
										"Db verification Before OTP for tuserflag failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions.pass(t8,
										"Db verification  Before OTP for tUserPref passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t8,
										"Db verification for Before OTP tUserPref failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification Before OTP for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted");
								} else {
									CommonFunctions.fail(driver, t9,
											"Db verification Before OTP for tUserEducation failed for cta "
													+ CTA
													+ "no New row inserted");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for  Before OTP tUserEducation doesn't exist for cta "
												+ CTA);

							}

							ExtentTest t10 = null;
							if (reports.get("temp_response_queue") != null) {
								t10 = reports.get("temp_response_queue");

							} else {
								t10 = CommonFunctions
										.createChild(
												report,
												"Verify temp_response_queue  table",
												"");
								reports.put("temp_response_queue", t10);
							}

							CommonFunctions.info(t10, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.temp_response_queue(email,
									Tracking_KeyId, "", "", "", obj);
							if (!flag) {
								CommonFunctions.pass(t10,
										"Db verification Before OTP for temp_response_queue passed for cta "
												+ CTA + "no New row inserted");
							} else {
								CommonFunctions.fail(driver, t10,
										"Db verification Before OTP for temp_response_queue failed for cta "
												+ CTA + " New row inserted");
							}

							ExtentTest t11 = null;
							if (reports.get("user_response_profile") != null) {
								t11 = reports.get("user_response_profile");

							} else {
								t11 = CommonFunctions.createChild(report,
										"Verify user_response_profile table",
										"");
								reports.put("user_response_profile", t11);
							}

							CommonFunctions.info(t11, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.user_response_profile(email,
									obj);
							if (!flag) {
								CommonFunctions.pass(t11,
										"Db verification Before OTP for user_response_profile passed for cta "
												+ CTA + " no New row inserted");
							} else {
								CommonFunctions.fail(driver, t11,
										"Db verification Before OTP for user_response_profile failed for cta "
												+ CTA + " New row inserted");
							}
						}

						if (obj.getdbUserName() != null)
							CommonFunctions.OTPVerification(driver, xs[2],
									true, obj);
					}

					if (CTA_Action.equalsIgnoreCase("compare_amp"))
						cta.afterCompareAmp(driver, "xpath",
								".//*[@id='stickyCompareButton']");

					ExtentTest t2 = null;
					if (reports.get("verifyLayer") != null) {
						t2 = reports.get("verifyLayer");

					} else {
						t2 = CommonFunctions.createChild(report,
								"Verify Layer after action", "");
						reports.put("verifyLayer", t2);
					}

					CommonFunctions.info(t2, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t2,
							"CTA Action performed for email : " + email);

					cta.verifyLayerCompare(driver, t2, CTA, CTA_Action);

					// // DB Verification Started
					if (!obj.getserver().equalsIgnoreCase("live")) {
						if (Login.equalsIgnoreCase("signup")) {
							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions
										.pass(t3,
												"Db verification after OTP for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t3,
												"Db verification after OTP for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t4,
												"Db verification after OTP for tUserInterest passed for  "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t4,
												"Db verification  after OTP for tUserInterest failed for  "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions
										.pass(t5,
												"Db verification after OTP for tUserCourseSpecialization passed for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t5,
												"Db verification after OTP for tUserCourseSpecialization failed for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t6,
												"Db verification after OTP for tUserAttributes passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t6,
												"Db verification after OTP for tUserAttributes failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t7,
												"Db verification after OTP for tuserflag passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t7,
												"Db verification after OTP for tuserflag failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t8,
												"Db verification after OTP for tUserPref passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t8,
												"Db verification after OTP for tUserPref failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification after OTP for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted verified after OTP");
								} else {
									CommonFunctions
											.fail(driver,
													t9,
													"Db verification after OTP for tUserEducation failed for cta "
															+ CTA
															+ " no New row inserted verified after OTP");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for after OTP tUserEducation doesn't exist for cta "
												+ CTA);
							}

						}

						ExtentTest t10 = null;
						if (reports.get("temp_response_queue") != null) {
							t10 = reports.get("temp_response_queue");

						} else {
							t10 = CommonFunctions.createChild(report,
									"Verify temp_response_queue  table", "");
							reports.put("temp_response_queue", t10);
						}

						CommonFunctions.info(t10, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions.temp_response_queue(email,
								Tracking_KeyId, "", "", "", obj);
						if (flag) {
							CommonFunctions
									.pass(t10,
											"Db verification after OTP for temp_response_queue passed for cta "
													+ CTA
													+ " New row inserted verified after OTP");
						} else {
							CommonFunctions
									.fail(driver,
											t10,
											"Db verification after OTP for temp_response_queue failed for cta "
													+ CTA
													+ " no New row inserted verified after OTP");
						}

						ExtentTest t11 = null;
						if (reports.get("user_response_profile") != null) {
							t11 = reports.get("user_response_profile");

						} else {
							t11 = CommonFunctions.createChild(report,
									"Verify user_response_profile table", "");
							reports.put("user_response_profile", t11);
						}

						CommonFunctions.info(t11, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions
								.user_response_profile(email, obj);
						if (flag) {
							CommonFunctions
									.pass(t11,
											"Db verification  after OTP for user_response_profile passed for cta "
													+ CTA
													+ " New row inserted verified after OTP");
						} else {
							CommonFunctions
									.fail(driver,
											t11,
											"Db verification after OTP for user_response_profile failed for cta "
													+ CTA
													+ "no New row inserted verified after OTP");
						}
					}
				}

				catch (Exception e) {
					CommonFunctions.fail(driver, tr, "issue at iteration : "
							+ i + " issue is : " + e.toString());
					continue;
				}
			}
			Thread.sleep(1000);
		}

		for (Entry<String, ExtentTest> entry : reports.entrySet()) {
			ExtentTest t = entry.getValue();
			if (t.getTest().getStatus().toString().equals("fail")) {
				CommonFunctions.closeChild(parent, t, report, "fail");
			} else
				CommonFunctions.closeChild(parent, t, report);
		}
		CommonFunctions.closeChild(parent, tr, report);
	}

	public void CTA_ApplyNow(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		CTA_Mobile cta = new CTA_Mobile();
		Boolean flag = false;
		LinkedHashMap<String, ExtentTest> reports = new LinkedHashMap<String, ExtentTest>();
		ExtentTest tr = CommonFunctions.createChild(report,
				"In Case any error exists", "");
		CommonFunctions
				.info(tr,
						"this child will consists errors in case of intermittent issue");

		for (int i = 0; i < ExcelReader.getRows("\\Mobile\\Apply_CTA"); i++) {

			String runMode = ExcelReader.getData(i, "RunMode",
					"\\Mobile\\Apply_CTA");

			if (runMode.equalsIgnoreCase("y")) {
				String CTA_Page = ExcelReader.getData(i, "CTA_Page",
						"\\Mobile\\Apply_CTA");
				String CTA_Action = ExcelReader.getData(i, "CTA_Action",
						"\\Mobile\\Apply_CTA");
				String Shiksha = ExcelReader.getData(i, "Shiksha",
						"\\Mobile\\Apply_CTA");
				String Login = ExcelReader.getData(i, "Login",
						"\\Mobile\\Apply_CTA");
				String relative_url = ExcelReader.getData(i, "relative_url",
						"\\Mobile\\Apply_CTA");
				String Locator = ExcelReader.getData(i, "Locator",
						"\\Mobile\\Apply_CTA");
				String Value = ExcelReader.getData(i, "Value",
						"\\Mobile\\Apply_CTA");
				try {
					driver.manage().deleteAllCookies();
					driver.get(url + relative_url);
					driver.manage().deleteAllCookies();
					CommonFunctions.acceptCookie(driver);
					// // Click compare Brochure
					ExtentTest t1 = null;
					if (reports.get("clickapply") != null) {
						t1 = reports.get("clickapply");
					} else {
						t1 = CommonFunctions.createChild(report,
								"Apply Now CTA", "");
						reports.put("clickapply", t1);
					}

					CommonFunctions.info(t1, "Iteration " + i + " For URL : "
							+ url + relative_url);

					String CTA = "Action performed on page : " + CTA_Page
							+ " with CTA Action : " + CTA_Action
							+ " For Shiksha : " + Shiksha + " for : " + Login
							+ " Case.";

					cta.clickApply(t1, driver, Locator, Value, CTA);

					String email = "";
					String[] xs = new String[2];
					if (Login.equalsIgnoreCase("login")) {
						// // login flow
						email = cta.login(driver, obj);
					} else {

						// / Pre Steps
						cta.prestepsApply(driver);
						xs = cta.signup(driver, obj);
						email = xs[0];

						if (obj.getdbUserName() != null)
							CommonFunctions.OTPVerification(driver, xs[2],
									true, obj);
					}

					ExtentTest t2 = null;
					if (reports.get("verifyLayer") != null) {
						t2 = reports.get("verifyLayer");

					} else {
						t2 = CommonFunctions.createChild(report,
								"Verify Layer after action", "");
						reports.put("verifyLayer", t2);
					}

					CommonFunctions.info(t2, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t2,
							"CTA Action performed for email : " + email
									+ " for listing id : " + "");

					cta.verifyLayerApply(driver, t2, CTA, CTA_Action);

					// // DB Verification Started
					if (!obj.getserver().equalsIgnoreCase("live")) {
						if (Login.equalsIgnoreCase("signup")) {
							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions
										.pass(t3,
												"Db verification for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t3,
												"Db verification for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " no New row inserted verified  ");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t4,
												"Db verification   for tUserInterest passed for  "
														+ CTA
														+ " New row inserted verified  ");
							} else {
								CommonFunctions
										.fail(driver,
												t4,
												"Db verification    for tUserInterest failed for  "
														+ CTA
														+ " no New row inserted verified  ");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions
										.pass(t5,
												"Db verification   for tUserCourseSpecialization passed for cta "
														+ CTA
														+ " New row inserted verified  ");
							} else {
								CommonFunctions
										.fail(driver,
												t5,
												"Db verification   for tUserCourseSpecialization failed for cta "
														+ CTA
														+ " no New row inserted verified  ");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t6,
												"Db verification   for tUserAttributes passed  for cta "
														+ CTA
														+ " New row inserted verified  ");
							} else {
								CommonFunctions
										.fail(driver,
												t6,
												"Db verification   for tUserAttributes failed  for cta "
														+ CTA
														+ " no New row inserted verified  ");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t7,
												"Db verification   for tuserflag passed  for cta "
														+ CTA
														+ " New row inserted verified  ");
							} else {
								CommonFunctions
										.fail(driver,
												t7,
												"Db verification   for tuserflag failed  for cta "
														+ CTA
														+ " no New row inserted verified  ");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t8,
												"Db verification   for tUserPref passed  for cta "
														+ CTA
														+ " New row inserted verified  ");
							} else {
								CommonFunctions
										.fail(driver,
												t8,
												"Db verification   for tUserPref failed  for cta "
														+ CTA
														+ " no New row inserted verified  ");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification   for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted verified  ");
								} else {
									CommonFunctions
											.fail(driver,
													t9,
													"Db verification   for tUserEducation failed for cta "
															+ CTA
															+ " no New row inserted verified  ");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for   tUserEducation doesn't exist for cta "
												+ CTA);
							}

						}
					}
				}

				catch (Exception e) {
					CommonFunctions.fail(driver, tr, "issue at iteration : "
							+ i + " issue is : " + e.toString());
					continue;
				}
			}
			Thread.sleep(1000);
		}

		for (Entry<String, ExtentTest> entry : reports.entrySet()) {
			ExtentTest t = entry.getValue();
			if (t.getTest().getStatus().toString().equals("fail")) {
				CommonFunctions.closeChild(parent, t, report, "fail");
			} else
				CommonFunctions.closeChild(parent, t, report);
		}
		CommonFunctions.closeChild(parent, tr, report);
	}

	public void CTA_ExamPage(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		CTA_Mobile cta = new CTA_Mobile();
		Boolean flag = false;
		ExtentTest tr = CommonFunctions.createChild(report,
				"In Case any error exists", "");
		CommonFunctions
				.info(tr,
						"this child will consists errors in case of intermittent issue");
		LinkedHashMap<String, ExtentTest> reports = new LinkedHashMap<String, ExtentTest>();
		for (int i = 0; i < ExcelReader.getRows("\\Mobile\\ExamPage_CTA"); i++) {
			String runMode = ExcelReader.getData(i, "RunMode",
					"\\Mobile\\ExamPage_CTA");

			if (runMode.equalsIgnoreCase("y")) {
				String CTA_Action = ExcelReader.getData(i, "CTA_Action",
						"\\Mobile\\ExamPage_CTA");
				String Shiksha = ExcelReader.getData(i, "Shiksha",
						"\\Mobile\\ExamPage_CTA");
				String Login = ExcelReader.getData(i, "Login",
						"\\Mobile\\ExamPage_CTA");
				String relative_url = ExcelReader.getData(i, "relative_url",
						"\\Mobile\\ExamPage_CTA");
				String Locator = ExcelReader.getData(i, "Locator",
						"\\Mobile\\ExamPage_CTA");
				String Value = ExcelReader.getData(i, "Value",
						"\\Mobile\\ExamPage_CTA");
				String Tracking_KeyId = ExcelReader.getData(i,
						"Tracking_KeyId", "\\Mobile\\ExamPage_CTA");
				String action_type = ExcelReader.getData(i, "action_type",
						"\\Mobile\\ExamPage_CTA");

				try {
					driver.manage().deleteAllCookies();
					driver.get(url + relative_url);
					driver.manage().deleteAllCookies();
					CommonFunctions.acceptCookie(driver);
					// // Click compare Brochure
					ExtentTest t1 = null;
					if (reports.get("exampagecta") != null) {
						t1 = reports.get("exampagecta");
					} else {
						t1 = CommonFunctions.createChild(report,
								"Exam Page CTA", "");
						reports.put("exampagecta", t1);
					}

					CommonFunctions.info(t1, "Iteration " + i + " For URL : "
							+ url + relative_url);

					String CTA = "Action performed on Exam page : "
							+ " with CTA Action : " + CTA_Action
							+ " For Shiksha : " + Shiksha + " for : " + Login
							+ " Case.";

					cta.examPage(t1, driver, Locator, Value, CTA);

					String email = "";
					String[] xs = new String[2];
					if (Login.equalsIgnoreCase("login")) {
						// // login flow
						email = cta.login(driver, obj);
					} else {
						// / Pre Steps
						xs = cta.signup(driver, obj);
						email = xs[0];

						if (!obj.getserver().equalsIgnoreCase("live")
								&& Login.equalsIgnoreCase("signup")) {

							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions.pass(t3,
										"Db verification Before OTP for tuser passed for userid : "
												+ userId + " for :" + CTA
												+ " New row inserted");
							} else {
								CommonFunctions.fail(driver, t3,
										"Db verification Before OTP for tuser passed for userid : "
												+ userId + " for :" + CTA
												+ " no New row inserted");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions.pass(t4,
										"Db verification Before OTP for tUserInterest passed for  "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t4,
										"Db verification Before OTP for tUserInterest failed for  "
												+ CTA + "no New row inserted");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions.pass(t5,
										"Db verification Before OTP for tUserCourseSpecialization passed for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t5,
										"Db verification Before OTP for tUserCourseSpecialization failed for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions.pass(t6,
										"Db verification Before OTP for tUserAttributes passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t6,
										"Db verification Before OTP for tUserAttributes failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions.pass(t7,
										"Db verification Before OTP for tuserflag passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t7,
										"Db verification Before OTP for tuserflag failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions.pass(t8,
										"Db verification  Before OTP for tUserPref passed  for cta "
												+ CTA + " New row inserted");
							} else {
								CommonFunctions.fail(driver, t8,
										"Db verification for Before OTP tUserPref failed  for cta "
												+ CTA + " no New row inserted");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification Before OTP for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted");
								} else {
									CommonFunctions.fail(driver, t9,
											"Db verification Before OTP for tUserEducation failed for cta "
													+ CTA
													+ "no New row inserted");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for  Before OTP tUserEducation doesn't exist for cta "
												+ CTA);

							}

							ExtentTest t10 = null;
							if (reports.get("temp_response_queue") != null) {
								t10 = reports.get("temp_response_queue");

							} else {
								t10 = CommonFunctions
										.createChild(
												report,
												"Verify temp_response_queue  table",
												"");
								reports.put("temp_response_queue", t10);
							}

							CommonFunctions.info(t10, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.temp_response_queue(email,
									Tracking_KeyId, "", "", action_type, obj);
							if (!flag) {
								CommonFunctions.pass(t10,
										"Db verification Before OTP for temp_response_queue passed for cta "
												+ CTA + "no New row inserted");
							} else {
								CommonFunctions.fail(driver, t10,
										"Db verification Before OTP for temp_response_queue failed for cta "
												+ CTA + " New row inserted");
							}

							ExtentTest t11 = null;
							if (reports.get("user_response_profile") != null) {
								t11 = reports.get("user_response_profile");

							} else {
								t11 = CommonFunctions.createChild(report,
										"Verify user_response_profile table",
										"");
								reports.put("user_response_profile", t11);
							}

							CommonFunctions.info(t11, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.user_response_profile(email,
									obj);
							if (!flag) {
								CommonFunctions.pass(t11,
										"Db verification Before OTP for user_response_profile passed for cta "
												+ CTA + " no New row inserted");
							} else {
								CommonFunctions.fail(driver, t11,
										"Db verification Before OTP for user_response_profile failed for cta "
												+ CTA + " New row inserted");
							}
						}

						if (obj.getdbUserName() != null)
							CommonFunctions.OTPVerification(driver, xs[2],
									true, obj);
					}

					ExtentTest t2 = null;
					if (reports.get("verifyLayer") != null) {
						t2 = reports.get("verifyLayer");

					} else {
						t2 = CommonFunctions.createChild(report,
								"Verify Layer after action", "");
						reports.put("verifyLayer", t2);
					}

					CommonFunctions.info(t2, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t2,
							"CTA Action performed for email : " + email);
					cta.verifyLayerExamPage(driver, t2, CTA, CTA_Action);

					// // DB Verification Started
					if (!obj.getserver().equalsIgnoreCase("live")) {
						if (Login.equalsIgnoreCase("signup")) {
							ExtentTest t3 = null;
							if (reports.get("tuser") != null) {
								t3 = reports.get("tuser");

							} else {
								t3 = CommonFunctions.createChild(report,
										"Verify tuser table", "");
								reports.put("tuser", t3);
							}

							CommonFunctions.info(t3, "Iteration " + i
									+ " For URL : " + url + relative_url
									+ "for email : " + email);
							String userId = CommonFunctions.tuser(email, obj);
							if (userId.length() > 0) {
								CommonFunctions
										.pass(t3,
												"Db verification after OTP for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t3,
												"Db verification after OTP for tuser passed for userid : "
														+ userId
														+ " for :"
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t4 = null;
							if (reports.get("tUserInterest") != null) {
								t4 = reports.get("tUserInterest");

							} else {
								t4 = CommonFunctions.createChild(report,
										"Verify tUserInterest table", "");
								reports.put("tUserInterest", t4);
							}

							CommonFunctions.info(t4, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserInterest(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t4,
												"Db verification after OTP for tUserInterest passed for  "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t4,
												"Db verification  after OTP for tUserInterest failed for  "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t5 = null;
							if (reports.get("tUserCourseSpecialization") != null) {
								t5 = reports.get("tUserCourseSpecialization");

							} else {
								t5 = CommonFunctions
										.createChild(
												report,
												"Verify tUserCourseSpecialization table",
												"");
								reports.put("tUserCourseSpecialization", t5);
							}

							CommonFunctions.info(t5, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserCourseSpecialization(
									email, obj);
							if (flag) {
								CommonFunctions
										.pass(t5,
												"Db verification after OTP for tUserCourseSpecialization passed for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t5,
												"Db verification after OTP for tUserCourseSpecialization failed for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t6 = null;
							if (reports.get("tUserAttributes") != null) {
								t6 = reports.get("tUserAttributes");

							} else {
								t6 = CommonFunctions.createChild(report,
										"Verify tUserAttributes table", "");
								reports.put("tUserAttributes", t6);
							}

							CommonFunctions.info(t6, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserAttributes(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t6,
												"Db verification after OTP for tUserAttributes passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t6,
												"Db verification after OTP for tUserAttributes failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t7 = null;
							if (reports.get("tuserflag") != null) {
								t7 = reports.get("tuserflag");

							} else {
								t7 = CommonFunctions.createChild(report,
										"Verify tuserflag table", "");
								reports.put("tuserflag", t7);
							}

							CommonFunctions.info(t7, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tuserflag(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t7,
												"Db verification after OTP for tuserflag passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t7,
												"Db verification after OTP for tuserflag failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t8 = null;
							if (reports.get("tUserPref") != null) {
								t8 = reports.get("tUserPref");

							} else {
								t8 = CommonFunctions.createChild(report,
										"Verify tUserPref table", "");
								reports.put("tUserPref", t8);
							}

							CommonFunctions.info(t8, "Iteration " + i
									+ " For URL : " + url + relative_url);
							flag = CommonFunctions.tUserPref(email, obj);
							if (flag) {
								CommonFunctions
										.pass(t8,
												"Db verification after OTP for tUserPref passed  for cta "
														+ CTA
														+ " New row inserted verified after OTP");
							} else {
								CommonFunctions
										.fail(driver,
												t8,
												"Db verification after OTP for tUserPref failed  for cta "
														+ CTA
														+ " no New row inserted verified after OTP");
							}

							ExtentTest t9 = null;
							if (reports.get("tUserEducation") != null) {
								t9 = reports.get("tUserEducation");

							} else {
								t9 = CommonFunctions.createChild(report,
										"Verify tUserEducation table", "");
								reports.put("tUserEducation", t9);
							}

							CommonFunctions.info(t9, "Iteration " + i
									+ " For URL : " + url + relative_url);

							if (xs[1].equalsIgnoreCase("true")) {
								flag = CommonFunctions.tUserEducation(email,
										obj);
								if (flag) {
									CommonFunctions
											.pass(t9,
													"Db verification after OTP for tUserEducation passed for cta "
															+ CTA
															+ " New row inserted verified after OTP");
								} else {
									CommonFunctions
											.fail(driver,
													t9,
													"Db verification after OTP for tUserEducation failed for cta "
															+ CTA
															+ " no New row inserted verified after OTP");
								}
							} else {
								CommonFunctions.info(t9,
										"Db verification for after OTP tUserEducation doesn't exist for cta "
												+ CTA);
							}

						}

						ExtentTest t10 = null;
						if (reports.get("temp_response_queue") != null) {
							t10 = reports.get("temp_response_queue");

						} else {
							t10 = CommonFunctions.createChild(report,
									"Verify temp_response_queue  table", "");
							reports.put("temp_response_queue", t10);
						}

						CommonFunctions.info(t10, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions.temp_response_queue(email,
								Tracking_KeyId, "", "", action_type, obj);
						if (flag) {
							CommonFunctions
									.pass(t10,
											"Db verification after OTP for temp_response_queue passed for cta "
													+ CTA
													+ " New row inserted verified after OTP");
						} else {
							CommonFunctions
									.fail(driver,
											t10,
											"Db verification after OTP for temp_response_queue failed for cta "
													+ CTA
													+ " no New row inserted verified after OTP");
						}

						ExtentTest t11 = null;
						if (reports.get("user_response_profile") != null) {
							t11 = reports.get("user_response_profile");

						} else {
							t11 = CommonFunctions.createChild(report,
									"Verify user_response_profile table", "");
							reports.put("user_response_profile", t11);
						}

						CommonFunctions.info(t11, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions
								.user_response_profile(email, obj);
						if (flag) {
							CommonFunctions
									.pass(t11,
											"Db verification  after OTP for user_response_profile passed for cta "
													+ CTA
													+ " New row inserted verified after OTP");
						} else {
							CommonFunctions
									.fail(driver,
											t11,
											"Db verification after OTP for user_response_profile failed for cta "
													+ CTA
													+ "no New row inserted verified after OTP");
						}
					}
				}

				catch (Exception e) {
					CommonFunctions.fail(driver, tr, "issue at iteration : "
							+ i + " issue is : " + e.toString());
					continue;
				}
			}
			Thread.sleep(1000);
		}

		for (Entry<String, ExtentTest> entry : reports.entrySet()) {
			ExtentTest t = entry.getValue();
			if (t.getTest().getStatus().toString().equals("fail")) {
				CommonFunctions.closeChild(parent, t, report, "fail");
			} else
				CommonFunctions.closeChild(parent, t, report);
		}
		CommonFunctions.closeChild(parent, tr, report);
	}

	public void CTA_RecoLayer(Objects obj) throws Exception {

		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		CTA_Mobile cta = new CTA_Mobile();
		Boolean flag = false;

		LinkedHashMap<String, ExtentTest> reports = new LinkedHashMap<String, ExtentTest>();
		ExtentTest tr = CommonFunctions.createChild(report,
				"In Case any error exists", "");
		CommonFunctions
				.info(tr,
						"this child will consists errors in case of intermittent issue");

		for (int i = 1; i < 4; i++) {
			String runMode = "y";
			if (runMode.equalsIgnoreCase("y")) {
				String CTA_Page = "";
				String CTA_Action = "";
				String downloadTrackingkey = "1073";
				String shortlistTrackingKey = "1075";
				String compareTrackingKey = "1064";
				String relative_url = url;
				String Locator = "xpath";
				String Value = "";
				try {
					driver.manage().deleteAllCookies();
					if (i == 0) {
						relative_url = url
								+ "/college/indian-institute-of-management-vastrapur-ahmedabad-318";
						Value = "(.//*[@id='stickyCTA']//a)[2]";
						CTA_Action = "download";
						CTA_Page = "ILP";
						downloadTrackingkey = "1063";
						shortlistTrackingKey = "1208";
						compareTrackingKey = "1064";

					}

					else if (i == 1) {
						relative_url = url
								+ "/college/amp/indian-institute-of-management-vastrapur-ahmedabad-318";
						Value = ".//*[@data-vars-event-name='DBROCHURE_STICKY']";
						CTA_Action = "download";
						CTA_Page = "ILP";
						downloadTrackingkey = "1229";
						shortlistTrackingKey = "1230";
						compareTrackingKey = "1231";
					}

					else if (i == 2) {
						relative_url = url
								+ "/university/amp/amity-university-gwalior-24642";
						Value = ".//*[@data-vars-event-name='DBROCHURE_STICKY']";
						CTA_Action = "download";
						CTA_Page = "ULP";
						downloadTrackingkey = "1239";
						shortlistTrackingKey = "1240";
						compareTrackingKey = "1241";
					}

					else {
						relative_url = url
								+ "/university/amity-university-gwalior-24642";
						Value = "(.//*[@id='stickyCTA']//a)[2]";
						CTA_Action = "download";
						downloadTrackingkey = "1077";
						shortlistTrackingKey = "1070";
						compareTrackingKey = "1076";
						CTA_Page = "ULP";
					}
					driver.get(relative_url);
					driver.manage().deleteAllCookies();
					CommonFunctions.acceptCookie(driver);
					// // Click compare Brochure
					ExtentTest t1 = null;
					if (reports.get("clickcta") != null) {
						t1 = reports.get("clickcta");
					} else {
						t1 = CommonFunctions.createChild(report,
								"Click Any CTA to open reco Layer", "");
						reports.put("clickcta", t1);
					}

					CommonFunctions.info(t1, "Iteration " + i + " For URL : "
							+ url + relative_url);

					String CTA = "Action performed on page : " + CTA_Page
							+ " with CTA Action : " + CTA_Action
							+ " For Shiksha : " + "National";

					cta.clickrecoCTA(t1, driver, Locator, Value, CTA);

					String email = "";
					// String[] xs = new String[2];
					// if (i == 0) {
					// // login flow
					email = cta.login(driver, obj);
					// } else {
					// xs = cta.signup(driver, obj);
					// email = xs[0];
					// if (obj.getdbUserName() != null)
					// CommonFunctions.OTPVerification(driver, xs[2], true,
					// obj);
					// }

					ExtentTest t2 = null;
					if (reports.get("verifyLayer") != null) {
						t2 = reports.get("verifyLayer");

					} else {
						t2 = CommonFunctions.createChild(report,
								"Verify Layer after action", "");
						reports.put("verifyLayer", t2);
					}

					CommonFunctions.info(t2, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t2,
							"CTA Action performed for email : " + email
									+ " for listing id : " + "");

					cta.verifyLayerCTA(driver, t2, CTA, CTA_Action);

					// // Download CTA
					ExtentTest t3 = null;
					if (reports.get("clickDownloadonRecoLayer") != null) {
						t3 = reports.get("clickDownloadonRecoLayer");

					} else {
						t3 = CommonFunctions.createChild(report,
								"Download After Reco", "");
						reports.put("clickDownloadonRecoLayer", t3);
					}

					CommonFunctions.info(t3, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t3, "Download on Reco Layer for : "
							+ CTA_Page);

					flag = cta.verifyDownloadonCTA(driver, t3);
					if (flag) {
						CommonFunctions
								.pass(t3,
										"Click Download brochure on reco layer verified");
					} else {
						CommonFunctions
								.fail(driver, t3,
										"Click Download brochure on reco layer verification failed");

					}
					if (!obj.getserver().equalsIgnoreCase("live")) {
						ExtentTest t4 = null;
						if (reports.get("temp_response_queue_download") != null) {
							t4 = reports.get("temp_response_queue_download");

						} else {
							t4 = CommonFunctions
									.createChild(
											report,
											"Verify temp_response_queue table after download",
											"");
							reports.put("temp_response_queue_download", t4);
						}

						CommonFunctions.info(t4, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions.temp_response_queue(email,
								downloadTrackingkey, "", "", "", obj);
						if (flag) {
							CommonFunctions.pass(t4,
									"DB verification for download verified");
						} else {
							CommonFunctions.fail(driver, t4,
									"DB verification for download failed");
						}
					}

					// // Shortlist
					ExtentTest t5 = null;
					if (reports.get("clickshortlistRecoLayer") != null) {
						t5 = reports.get("clickshortlistRecoLayer");

					} else {
						t5 = CommonFunctions.createChild(report,
								"Shortlist After Reco", "");
						reports.put("clickshortlistRecoLayer", t5);
					}

					CommonFunctions.info(t5, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t5, "Shortlist on Reco Layer for : "
							+ email);

					flag = cta.verifyShortlistonCTA(driver, t5);
					if (flag) {
						CommonFunctions.pass(t5,
								"Click Shortlist on reco layer verified");
					} else {
						CommonFunctions
								.fail(driver, t5,
										"Click Shortlist on reco layer verification failed");

					}
					if (!obj.getserver().equalsIgnoreCase("live")) {
						ExtentTest t6 = null;
						if (reports.get("temp_response_queue_shtlist") != null) {
							t6 = reports.get("temp_response_queue_shtlist");

						} else {
							t6 = CommonFunctions
									.createChild(
											report,
											"Verify temp_response_queue table after shortlist",
											"");
							reports.put("temp_response_queue_shtlist", t6);
						}

						CommonFunctions.info(t6, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions.temp_response_queue(email,
								shortlistTrackingKey, "", "", "", obj);
						if (flag) {
							CommonFunctions.pass(t6,
									"DB verification for shotlist passed");
						} else {
							CommonFunctions.fail(driver, t6,
									"DB verification for shotlist failed");
						}

					}

					// // Compare
					ExtentTest t7 = null;
					if (reports.get("clickcompareonRecoLayer") != null) {
						t7 = reports.get("clickcompareonRecoLayer");

					} else {
						t7 = CommonFunctions.createChild(report,
								"Compare After Reco", "");
						reports.put("clickcompareonRecoLayer", t7);
					}

					CommonFunctions.info(t7, "Iteration " + i + " For URL : "
							+ url + relative_url);
					CommonFunctions.info(t7, "Compare on Reco Layer for : "
							+ email);

					flag = cta.verifycompareonCTA(driver, t7);
					if (flag) {
						CommonFunctions.pass(t7,
								"Click compare on reco layer verified");
					} else {
						CommonFunctions
								.fail(driver, t7,
										"Click compare on reco layer verification failed");

					}
					if (!obj.getserver().equalsIgnoreCase("live")) {
						ExtentTest t8 = null;
						if (reports.get("temp_response_queue_compare") != null) {
							t8 = reports.get("temp_response_queue_compare");

						} else {
							t8 = CommonFunctions
									.createChild(
											report,
											"Verify temp_response_queue table after compare",
											"");
							reports.put("temp_response_queue_compare", t8);
						}

						CommonFunctions.info(t8, "Iteration " + i
								+ " For URL : " + url + relative_url);
						flag = CommonFunctions.temp_response_queue(email,
								compareTrackingKey, "", "", "", obj);
						if (flag) {
							CommonFunctions.pass(t8,
									"DB verification for compare passed");
						} else {
							CommonFunctions.fail(driver, t8,
									"DB verification for compare passed");
						}

					}

				}

				catch (Exception e) {
					CommonFunctions.fail(driver, tr, "issue at iteration : "
							+ i + " issue is : " + e.toString());
					continue;
				}
			}
			Thread.sleep(1000);
		}

		for (Entry<String, ExtentTest> entry : reports.entrySet()) {
			ExtentTest t = entry.getValue();
			if (t.getTest().getStatus().toString().equals("fail")) {
				CommonFunctions.closeChild(parent, t, report, "fail");
			} else
				CommonFunctions.closeChild(parent, t, report);
		}
		CommonFunctions.closeChild(parent, tr, report);

	}

}
