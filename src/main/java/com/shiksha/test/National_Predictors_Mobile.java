package com.shiksha.test;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.Call_Predictor;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.Database;
import com.shiksha.resourses.ExcelReader;

public class National_Predictors_Mobile {
	CommonFunctions CommonFunctions = new CommonFunctions();
	Database db = new Database();
	Call_Predictor cp = null;

	public void IIM_Call_Predictor(Objects obj) throws Exception {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL() + "/mba/resources/iim-call-predictor";
		WebDriver driver = obj.getDriver();
		Boolean flag5 = false;
		String email = "";
		ExtentTest tr = CommonFunctions.createChild(report,
				"In Case any error exists", "");
		CommonFunctions
				.info(tr,
						"this child will consists errors in case of intermittent issue");
		LinkedHashMap<String, ExtentTest> reports = new LinkedHashMap<String, ExtentTest>();

		for (int i = 0; i < ExcelReader.getRows("\\Mobile\\IIM_Call_Predictor"); i++) {
			String runMode = ExcelReader.getData(i, "RunMode",
					"\\Mobile\\IIM_Call_Predictor");

			if (runMode.equalsIgnoreCase("y")) {
				String case1 = ExcelReader.getData(i, "CAT/Eligibility",
						"\\Mobile\\IIM_Call_Predictor");
				String case2 = ExcelReader.getData(i, "Case",
						"\\Mobile\\IIM_Call_Predictor");

				cp = new Call_Predictor();
				driver.manage().deleteAllCookies();
				driver.get(url);
				driver.manage().deleteAllCookies();
				try {
					ExtentTest t1 = null;
					if (reports.get("page1") != null) {
						t1 = reports.get("page1");
					} else {
						t1 = CommonFunctions.createChild(report,
								"All actions on page 1", "");
						reports.put("page1", t1);
					}
					CommonFunctions
							.info(t1,
									"Iteration : "
											+ i
											+ " For Case : "
											+ case1
											+ " when user is "
											+ case2
											+ " for url : "
											+ url
											+ " On Page 1 Category : General would be selected");
					Boolean flag = cp.Page1(driver);
					if (flag) {
						String Marks_10 = ExcelReader.getData(i, "10th_Marks",
								"\\Mobile\\IIM_Call_Predictor");
						String Marks_12 = ExcelReader.getData(i, "12th_Marks",
								"\\Mobile\\IIM_Call_Predictor");
						String Marks_grad = ExcelReader.getData(i,
								"Grad_Marks", "\\Mobile\\IIM_Call_Predictor");

						CommonFunctions.pass(t1, "Page 1 Validation verified");
						ExtentTest t2 = null;
						if (reports.get("page2") != null) {
							t2 = reports.get("page2");
						} else {
							t2 = CommonFunctions.createChild(report,
									"All actions on page 2", "");
							reports.put("page2", t2);
						}
						CommonFunctions.info(t2, "Iteration : " + i
								+ " For Case : " + case1 + " when user is "
								+ case2 + " for values : with 10th marks : "
								+ Marks_10 + " Marks 12th : " + Marks_12
								+ " Marks grad :" + Marks_grad);
						Boolean flag2 = cp.Page2(driver, Marks_10, Marks_12,
								Marks_grad);
						if (flag2) {
							CommonFunctions.pass(t2,
									"Page 2 Validation verified");
							ExtentTest t3 = null;
							if (reports.get("page3") != null) {
								t3 = reports.get("page3");
							} else {
								t3 = CommonFunctions.createChild(report,
										"All actions on page 3", "");
								reports.put("page3", t3);
							}
							CommonFunctions.info(t3, "Iteration : " + i
									+ " For Case : " + case1 + " when user is "
									+ case2);
							Boolean flag3 = cp.Page3(driver, case1);
							if (flag3) {
								CommonFunctions.pass(t3,
										"Page 3 Validation verified");
								if (case1.equalsIgnoreCase("CAT SCORE")) {

									String vrc = ExcelReader.getData(i, "VRC",
											"\\Mobile\\IIM_Call_Predictor");
									String DIRL = ExcelReader.getData(i,
											"DIRL",
											"\\Mobile\\IIM_Call_Predictor");
									String QA = ExcelReader.getData(i, "QA",
											"\\Mobile\\IIM_Call_Predictor");
									String Tot = ExcelReader.getData(i,
											"Total_Marks",
											"\\Mobile\\IIM_Call_Predictor");
									String toal = ExcelReader.getData(i,
											"Total_CAT",
											"\\Mobile\\IIM_Call_Predictor");
									ExtentTest t4 = null;
									if (reports.get("page4") != null) {
										t4 = reports.get("page4");
									} else {
										t4 = CommonFunctions
												.createChild(
														report,
														"All actions on CAT SCORE PAGE",
														"");
										reports.put("page4", t4);
									}
									CommonFunctions.info(t4, "Iteration : " + i
											+ " For Case : " + case1
											+ " when user is " + case2
											+ "with cat score as VRC : " + vrc
											+ " DIRL : " + DIRL + " QA : " + QA
											+ " Total marks : " + Tot
											+ " Total %ile : " + toal);
									Boolean flag4 = cp.Page_CatScore(driver,
											vrc, DIRL, QA, Tot, toal);
									if (flag4) {
										CommonFunctions.pass(t4,
												"Page 4 Validation verified");
										String login = ExcelReader.getData(i,
												"Login_Signup",
												"\\Mobile\\IIM_Call_Predictor");
										email = "";
										String[] xs = new String[2];
										if (login.contains("login")) {
											email = CommonFunctions.login(
													driver, obj);
										} else {
											xs = CommonFunctions.signup(driver,
													obj);
											email = xs[0];
											if (obj.getdbUserName() != null)
												CommonFunctions
														.OTPVerification(
																driver, xs[2],
																true, obj);
										}
										CommonFunctions.info(t4, "Iteration : "
												+ i + " for email : " + email);

										String result = ExcelReader.getData(i,
												"Result",
												"\\Mobile\\IIM_Call_Predictor");
										ExtentTest t5 = null;
										if (reports.get("cateligible") != null) {
											t5 = reports.get("cateligible");
										} else {
											t5 = CommonFunctions
													.createChild(
															report,
															"Check Whether user is eligible for IIM?",
															"");
											reports.put("cateligible", t5);
										}
										CommonFunctions.info(t5, "Iteration : "
												+ i + " For Case : " + case1
												+ " when user is " + case2
												+ " When user is : " + result);
										flag5 = cp.CheckELigibility(driver,
												result, t5, case1);

									} else {
										CommonFunctions.fail(driver, t4,
												"Page 4 Validation failed");
									}
								} else {
									// // Code for eligibility
									String result = ExcelReader.getData(i,
											"Result",
											"\\Mobile\\IIM_Call_Predictor");
									ExtentTest t4 = null;
									if (reports.get("page4") != null) {
										t4 = reports.get("page4");
									} else {
										t4 = CommonFunctions
												.createChild(
														report,
														"All actions on CAT SCORE PAGE",
														"");
										reports.put("page4", t4);
									}
									CommonFunctions.info(t4, "Iteration : " + i
											+ " For Case : " + case1
											+ " when user is " + case2);
									boolean flag4 = cp.CheckELigibility_ForCAT(
											driver, result, t4);

									if (flag4) {
										CommonFunctions.pass(t4,
												"Page 4 Validation verified");
										String login = ExcelReader.getData(i,
												"Login_Signup",
												"\\Mobile\\IIM_Call_Predictor");
										email = "";
										String[] xs = new String[2];
										if (login.contains("login")) {
											email = CommonFunctions.login(
													driver, obj);
										} else {
											xs = CommonFunctions.signup(driver,
													obj);
											email = xs[0];
											if (obj.getdbUserName() != null)
												CommonFunctions
														.OTPVerification(
																driver, xs[2],
																true, obj);
										}
										CommonFunctions.info(t4, "Iteration : "
												+ i + " for email : " + email);

										ExtentTest t5 = null;
										if (reports.get("cateligible") != null) {
											t5 = reports.get("cateligible");
										} else {
											t5 = CommonFunctions
													.createChild(
															report,
															"Check Whether user is eligible for IIM?",
															"");
											reports.put("cateligible", t5);
										}
										CommonFunctions.info(t5, "Iteration : "
												+ i + " For Case : " + case1
												+ " when user is " + case2
												+ " When user is : " + result);
										flag5 = cp.CheckELigibility(driver,
												result, t5, case1);
									} else {
										CommonFunctions.fail(driver, t4,
												"Page 4 Validation failed");
									}
								}

								ExtentTest t5 = null;
								if (reports.get("cateligible") != null) {
									t5 = reports.get("cateligible");
								} else {
									t5 = CommonFunctions
											.createChild(
													report,
													"Check Whether user is eligible for IIM?",
													"");
									reports.put("cateligible", t5);
								}
								if (flag5) {
									CommonFunctions.pass(t5,
											"IIM Eligibility Check Passed");
									ExtentTest t6 = null;
									if (reports.get("compare") != null) {
										t6 = reports.get("compare");
									} else {
										t6 = CommonFunctions.createChild(
												report,
												"Check Compare functionality",
												"");
										reports.put("compare", t6);
									}
									CommonFunctions.info(t6, "Iteration : " + i
											+ " For Case : " + case1
											+ " when user is " + case2);
									boolean flag6 = cp.compare(driver);
									if (flag6) {
										CommonFunctions.pass(t6,
												"Compare verified");
										ExtentTest t7 = null;
										if (reports.get("compare_track") != null) {
											t7 = reports.get("compare_track");
										} else {
											t7 = CommonFunctions
													.createChild(
															report,
															"Check Compare data in table",
															"");
											reports.put("compare_track", t7);
										}
										CommonFunctions
												.info(t7,
														"Iteration : "
																+ i
																+ " For Case : "
																+ case1
																+ " when user is "
																+ case2
																+ " to verify Compare data in table : temp_response_queue. Verifying tracking id(1358) for compare from IIM Call Predictor");
										boolean flag7 = CommonFunctions
												.temp_response_queue(email,
														"1358", "", "", "", obj);
										if (flag7) {
											CommonFunctions.pass(t7,
													"Compare verified");
										} else {
											CommonFunctions.fail(driver, t7,
													"Compare failed");
										}
									} else {
										CommonFunctions.fail(driver, t6,
												"Compare failed");
									}

									// // Code for banner
									ExtentTest t10 = null;
									if (reports.get("banner") != null) {
										t10 = reports.get("banner");
									} else {
										t10 = CommonFunctions.createChild(
												report, "Check Banner", "");
										reports.put("banner", t10);
									}
									CommonFunctions.info(t10, "Iteration : "
											+ i + " For Case : " + case1
											+ " when user is " + case2);
									boolean flag10 = cp.banner(driver);
									if (flag10) {
										CommonFunctions
												.pass(t10,
														"Featured COllege banner verified");
									} else {
										CommonFunctions
												.fail(driver, t10,
														"Featured College banner failed");
									}
									/*
									 * 
									 * // //Code for CAT Score ExtentTest t9 =
									 * null; if (reports.get("CATSCORE") !=
									 * null) { t9 = reports.get("CATSCORE"); }
									 * else { t9 = CommonFunctions.createChild(
									 * report, "Check Compare functionality",
									 * ""); reports.put("CATSCORE", t9); }
									 * CommonFunctions.info(t9, "Iteration : " +
									 * i + " For Case : " + case1 +
									 * " when user is " + case2); boolean flag9
									 * = cp .clickHere( driver, ExcelReader
									 * .getData(i, "Result",
									 * "\\Mobile\\IIM_Call_Predictor"), t9); if
									 * (flag9) { CommonFunctions.pass(t9,
									 * "Start Here verified"); } else {
									 * CommonFunctions.fail(driver, t9,
									 * "Start Here failed"); }
									 * 
									 * // // Code for start again ExtentTest t8
									 * = null; if (reports.get("StartHere") !=
									 * null) { t8 = reports.get("StartHere"); }
									 * else { t8 = CommonFunctions.createChild(
									 * report, "Start Here functionality", "");
									 * reports.put("StartHere", t8); }
									 * CommonFunctions.info(t8, "Iteration : " +
									 * i + " For Case : " + case1 +
									 * " when user is " + case2); boolean flag8
									 * = cp .StartAgain( driver, ExcelReader
									 * .getData(i, "Result",
									 * "\\Mobile\\IIM_Call_Predictor"), t8); if
									 * (flag8) { CommonFunctions.pass(t8,
									 * "Start Here verified"); } else {
									 * CommonFunctions.fail(driver, t8,
									 * "Start Here failed"); }
									 */

								} else {
									CommonFunctions.fail(driver, t5,
											"IIM Eligility Failed");
								}

							} else {
								CommonFunctions.fail(driver, t3,
										"Page 3 Validation failed");
							}

						} else {
							CommonFunctions.fail(driver, t2,
									"Page 2 Validation failed");
						}

					} else {
						CommonFunctions.fail(driver, t1,
								"Page 1 Validation failed");
					}
				} catch (Exception e) {
					CommonFunctions.fail(driver, tr, "issue at iteration : "
							+ i + " issue is : " + e.toString());
					continue;
				}
			}
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
