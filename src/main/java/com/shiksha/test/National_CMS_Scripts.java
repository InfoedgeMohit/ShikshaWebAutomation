package com.shiksha.test;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.main.Objects;
import com.shiksha.object.LF_CLP_Posting;
import com.shiksha.object.LF_ILP_Posting;
import com.shiksha.object.LF_ULP_Posting;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class National_CMS_Scripts {

	LF_ULP_Posting ulp = null;
	LF_ILP_Posting ilp = null;
	LF_CLP_Posting clp = null;
	CommonFunctions CommonFunctions = new CommonFunctions();

	public void LF_UnivPosting(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		ExtentTest child1 = CommonFunctions.createChild(report,
				obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		CommonFunctions.info(child1, "\n University Posting for Url : " + url);

		String universityId = "";
		try {
			// String path;
			// path = new java.io.File(".").getCanonicalPath();
			// String brochurepath = path + "\\src\\test\\resources\\"
			// + "brochure.pdf";
			// String logoPath = path + "\\src\\test\\resources\\" + "Logo.jpg";
			// String media1Path = path + "\\src\\test\\resources\\"
			// + "media1.jpg";
			// String media2Path = path + "\\src\\test\\resources\\"
			// + "media2.jpg";
			// String media3Path = path + "\\src\\test\\resources\\"
			// + "media3.jpg";
			ulp = new LF_ULP_Posting(driver, child1);

			// // Used common code to login cms
			CommonFunctions.loginCMS(driver, url,
					FetchData.readConfig("cmsadminusername"),
					FetchData.readConfig("cmsadminpassword"));

			// // Open course Posting url
			driver.get(url + "/nationalInstitute/UniversityPosting/create");

			// // Enter Univ Name
			ulp.univName(Variables.universityIdName);
			ulp.selectCity("Adipur");
			ulp.univAbbreviation("ATU");

			// // Synonym
			ulp.univSyn1("Automation Testing");
			ulp.univsynAdd();
			ulp.univSyn2("Testing Automation");
			ulp.univsynAdd();
			ulp.univSyn3("ATU");

			ulp.univEstdYear("2000");
			ulp.univUnivYear("2006");

			ulp.univType("deemed");
			ulp.univOwnership();
			ulp.univOpen();
			ulp.univUGC();
			ulp.univAIU();
			ulp.univNationalImp();
			ulp.univAccredation("grade_a++");

			try {
				// // Faculty Information
				// // Click add more to add more faculty information
				ulp.facultyAddMore();
				ulp.faculty1("Director");
				ulp.faculty1Name("Deepak Kumar");
				ulp.faculty1designation("Director");
				ulp.faculty1education("B.Tech, M.Tech");
				ulp.faculty1high("B.Tech from IIT-Delhi, M.Tech from IIT-Bombay");
				ulp.faculty2("VC");
				ulp.faculty2Name("Deepa Kumari");
				ulp.faculty2designation("Vice Chancellor");
				ulp.faculty2education("B.Tech, M.Tech, P.Hd");
				ulp.faculty2high("B.Tech from IIT-Delhi, M.Tech from IIT-Bombay, P.Hd from MIT");
				ulp.facultyHighlights("All Faculty are from Government colleges, having good experience in academics");
			} catch (Exception e) {
				throw e;
			}

			// //Infrastructure Facilities
			ulp.Library();
			ulp.wifi();
			ulp.store();
			ulp.cafe();
			ulp.shuttle();
			ulp.audi();
			ulp.hospital();
			ulp.sports();
			ulp.gym();
			ulp.libHigh("Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library");
			ulp.gymHigh("gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym");
			ulp.ac();
			ulp.labs();

			// // Research Projects details
			ulp.researchText1("Research 1");
			ulp.researchAddMore();
			ulp.researchText2("Research 2");
			ulp.researchAddMore();
			ulp.researchText3("Research 3");

			try {
				// // Add Events
				ulp.eventAddMore();
				ulp.selectevent1("Seminar");
				ulp.Event1Name("Event 1 Name");
				ulp.Event1Description("Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description");
				ulp.selectevent2("Exhibition");
				ulp.Event2Name("Event 2 Name");
				ulp.Event2Description("Event 2  Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description");
			}

			catch (Exception e) {
				throw e;
			}

			// // Enter USP
			ulp.USP1("USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1");
			ulp.uspAddMore();
			ulp.USP2("USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2");
			ulp.uspAddMore();
			ulp.USP3("USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3");
			ulp.uspAddMore();
			ulp.USP4("USP 4 USP 4 USP 4 USP 4 USP 4 USP 4 USP 4 USP 4 USP 4");
			ulp.uspAddMore();
			ulp.USP5("USP 5 USP 5 USP 5 USP 5 USP 5 USP 5 USP 5 USP 5 USP 5");

			// // Upload Brochure
			// ulp.uploadBrochure(brochurepath);

			// // Upload Logo
			// ulp.clickUplaodLogo(logoPath);

			/*
			 * // // Uplaod Media ulp.enterTitle("Media 1");
			 * ulp.uplaodMedia(media1Path); ulp.photoLocation();
			 * ulp.photoLocationSelect(); ulp.clickUpload(1);
			 * 
			 * ulp.enterTitle("Media 2"); ulp.uplaodMedia(media2Path);
			 * ulp.photoLocation(); ulp.photoLocationSelect();
			 * ulp.clickUpload(2);
			 * 
			 * ulp.enterTitle("Media 3"); ulp.uplaodMedia(media3Path);
			 * ulp.photoLocation(); ulp.photoLocationSelect();
			 * ulp.clickUpload(3);
			 * 
			 * // // Upload Videos ulp.entervideoTitle("Video 1");
			 * ulp.entervideourl("https://www.youtube.com/watch?v=Uasya8yiiSE");
			 * ulp.videoLocation(); ulp.videoLocationSelect();
			 * ulp.videoUpload(1);
			 * 
			 * ulp.entervideoTitle("Video 2");
			 * ulp.entervideourl("https://www.youtube.com/watch?v=eKdkAIDMhis");
			 * ulp.videoLocation(); ulp.videoLocationSelect();
			 * ulp.videoUpload(2);
			 * 
			 * ulp.entervideoTitle("Video 3");
			 * ulp.entervideourl("https://www.youtube.com/watch?v=hhxFaXaidvA");
			 * ulp.videoLocation(); ulp.videoLocationSelect();
			 * ulp.videoUpload(3);
			 */

			// // Select Scholarship
			ulp.scholarshipAddMOre();
			ulp.scholarshipAddMOre();
			ulp.scholarship1("Scholarship");
			ulp.scholarshipdesc1("scholarship 1 scholarship 1 scholarship 1 scholarship 1 scholarship 1 scholarship 1 scholarship 1 scholarship 1");
			ulp.scholarship2("Discount");
			ulp.scholarshipdesc2("Discount Discount Discount Discount Discount Discount Discount Discount Discount Discount Discount Discount");
			ulp.scholarship3("Financial Assistance");
			ulp.scholarshipdesc3("Financial Assistance Financial Assistance Financial Assistance Financial Assistance Financial Assistance");

			// // Recruiting companies
			ulp.recruitingcompanies("naukri");
			ulp.selectcompany();

			ulp.recruitingcompanies("HCL");
			ulp.selectcompany();

			ulp.recruitingcompanies("HCL");
			ulp.selectcompany();

			ulp.recruitingcompanies("HCL");
			ulp.selectcompany();

			ulp.recruitingcompanies("HCL");
			ulp.selectcompany();

			ulp.recruitingcompanies("Info Edge");
			ulp.selectcompany();

			ulp.recruitingcompanies("shiksha");
			ulp.selectcompany();

			ulp.recruitingcompanies("TCS");
			ulp.selectcompany();

			ulp.recruitingcompanies("Accenture");
			ulp.selectcompany();

			ulp.recruitingcompanies("infosys");
			ulp.selectcompany();

			ulp.recruitingcompanies("ACC");
			ulp.selectcompany();

			ulp.recruitingcompanies("ACC");
			ulp.selectcompany();

			ulp.recruitingcompanies("ACC");
			ulp.selectcompany();

			ulp.recruitingcompanies("ACC");
			ulp.selectcompany();

			// // Publish university
			ulp.comments("Automation");
			ulp.publishUniversity();
			universityId = ulp.getunivId();
			Variables.universityId = universityId;

			CommonFunctions.info(child1, "\n University Posting For Univ Id : "
					+ universityId);

		}

		catch (Exception e) {
		} finally {
			CommonFunctions.closeChild(parent, child1, report);

		}
	}

	public void LF_InstitutePosting(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();
		ExtentTest child1 = CommonFunctions.createChild(report,
				obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		CommonFunctions.info(child1, "\n Institute Posting for Url : " + url);
		String instituteId = "";
		ilp = new LF_ILP_Posting(driver, child1);
		try {

			if (Variables.universityId.length() > 1) {
				Variables.instituteIdName = "Automation Testing Institute"
						+ Variables.universityId;
			}
			// String path;
			// path = new java.io.File(".").getCanonicalPath();

			// String brochurepath = path + "\\src\\test\\resources\\"
			// + "brochure.pdf";
			// String logoPath = path + "\\src\\test\\resources\\" + "Logo.jpg";
			// String media1Path = path + "\\src\\test\\resources\\"
			// + "media1.jpg";
			// String media2Path = path + "\\src\\test\\resources\\"
			// + "media2.jpg";
			// String media3Path = path + "\\src\\test\\resources\\"
			// + "media3.jpg";

			// // Used common code to login cms
			CommonFunctions.loginCMS(driver, url,
					FetchData.readConfig("cmsadminusername"),
					FetchData.readConfig("cmsadminpassword"));

			// // Open course Posting url
			driver.get(url + "nationalInstitute/InstitutePosting/create");
			// //Select univ in hierarchy
			if (Variables.universityId.length() > 1) {
				ilp.typeUniv(Variables.universityId);
			} else {
				ilp.typeUniv("41334");
			}

			ilp.clickunivgo();
			ilp.selectUniv();
			// //Ins basic information
			ilp.selectinsName(Variables.instituteIdName);
			ilp.selectCity("Ahmedabad");
			ilp.selectshortName("Automation Testing");
			ilp.selectabbreviation("ATI");
			ilp.synonymAddMore();
			ilp.synonym1("Automation");
			ilp.synonym2("Testing");
			ilp.establishment_year("2010");
			ilp.ownership();
			ilp.isAutonomous();
			ilp.isNationalImportance();
			ilp.accreditation("Grade A++");
			try {
				// // Faculty Information
				// // Click add more to add more faculty information
				ilp.facultyAddMore();
				ilp.faculty1("Director");
				ilp.faculty1Name("Deepak Kumar");
				ilp.faculty1designation("Director");
				ilp.faculty1education("B.Tech, M.Tech");
				ilp.faculty1high("B.Tech from IIT-Delhi, M.Tech from IIT-Bombay");
				ilp.faculty2("VC");
				ilp.faculty2Name("Deepa Kumari");
				ilp.faculty2designation("Vice Chancellor");
				ilp.faculty2education("B.Tech, M.Tech, P.Hd");
				ilp.faculty2high("B.Tech from IIT-Delhi, M.Tech from IIT-Bombay, P.Hd from MIT");
				ilp.facultyHighlights("All Faculty are from Government colleges, having good experience in academics");

			} catch (Exception e) {
				throw e;
			}
			// //Infrastructure Facilities
			ilp.Library();
			ilp.wifi();
			ilp.store();
			ilp.cafe();
			ilp.shuttle();
			ilp.audi();
			ilp.hospital();
			ilp.sports();
			ilp.gym();
			ilp.libHigh("Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library Library");
			ilp.gymHigh("gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym gym");
			ilp.ac();
			ilp.labs();
			// // Research Projects details
			ilp.researchText1("Research 1");
			ilp.researchAddMore();
			ilp.researchText2("Research 2");
			ilp.researchAddMore();
			ilp.researchText3("Research 3");

			try {
				// // Add Events
				ilp.eventAddMore();
				ilp.selectevent1("Seminar");
				ilp.Event1Name("Event 1 Name");
				ilp.Event1Description("Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description Event 1 Description");
				ilp.selectevent2("Exhibition");
				ilp.Event2Name("Event 2 Name");
				ilp.Event2Description("Event 2  Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description Event 2 Description");

			}

			catch (Exception e) {
				throw e;
			}
			// // Enter USP
			ilp.USP1("USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1");
			ilp.uspAddMore();
			ilp.USP2("USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2");
			ilp.uspAddMore();
			ilp.USP3("USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3");
			ilp.uspAddMore();
			ilp.USP4("USP 4 USP 4 USP 4 USP 4 USP 4 USP 4 USP 4 USP 4 USP 4");
			ilp.uspAddMore();
			ilp.USP5("USP 5 USP 5 USP 5 USP 5 USP 5 USP 5 USP 5 USP 5 USP 5");

			// ilp.uploadBrochure(brochurepath);
			// // Add Multi Location cities
			ilp.selectMLCity("Adipur");
			ilp.clickAdd();

			ilp.selectMLCity("Bikaner");
			ilp.clickAdd();

			ilp.selectMLCity("Chandigarh");
			ilp.clickAdd();

			ilp.selectMLCity("Dharamsala");
			ilp.clickAdd();

			ilp.selectMLCity("Hyderabad");
			ilp.clickAdd();

			// // Upload Logo
			// //ilp.clickUplaodLogo(logoPath);

			/*
			 * // // Uplaod Media ilp.enterTitle("Media 1");
			 * ilp.uplaodMedia(media1Path); ilp.clickUpload(1);
			 * 
			 * ilp.enterTitle("Media 2"); ilp.uplaodMedia(media2Path);
			 * ilp.clickUpload(2);
			 * 
			 * ilp.enterTitle("Media 3"); ilp.uplaodMedia(media3Path);
			 * ilp.clickUpload(3);
			 * 
			 * // // Upload Videos ilp.entervideoTitle("Video 1");
			 * ilp.entervideourl("https://www.youtube.com/watch?v=Uasya8yiiSE");
			 * ilp.videoUpload(1);
			 * 
			 * ilp.entervideoTitle("Video 2");
			 * ilp.entervideourl("https://www.youtube.com/watch?v=eKdkAIDMhis");
			 * ilp.videoUpload(2);
			 * 
			 * ilp.entervideoTitle("Video 3");
			 * ilp.entervideourl("https://www.youtube.com/watch?v=hhxFaXaidvA");
			 * ilp.videoUpload(3);
			 */

			// // Select Scholarship
			ilp.scholarshipAddMOre();
			ilp.scholarshipAddMOre();
			ilp.scholarship1("Scholarship");
			ilp.scholarshipdesc1("scholarship 1 scholarship 1 scholarship 1 scholarship 1 scholarship 1 scholarship 1 scholarship 1 scholarship 1");
			ilp.scholarship2("Discount");
			ilp.scholarshipdesc2("Discount Discount Discount Discount Discount Discount Discount Discount Discount Discount Discount Discount");
			ilp.scholarship3("Financial Assistance");
			ilp.scholarshipdesc3("Financial Assistance Financial Assistance Financial Assistance Financial Assistance Financial Assistance");

			// // Recruiting companies
			ilp.recruitingcompanies("naukri");
			ilp.selectcompany();

			ilp.recruitingcompanies("HCL");
			ilp.selectcompany();

			ilp.recruitingcompanies("HCL");
			ilp.selectcompany();

			ilp.recruitingcompanies("HCL");
			ilp.selectcompany();

			ilp.recruitingcompanies("HCL");
			ilp.selectcompany();

			ilp.recruitingcompanies("Info Edge");
			ilp.selectcompany();

			ilp.recruitingcompanies("shiksha");
			ilp.selectcompany();

			ilp.recruitingcompanies("TCS");
			ilp.selectcompany();

			ilp.recruitingcompanies("Accenture");
			ilp.selectcompany();

			ilp.recruitingcompanies("infosys");
			ilp.selectcompany();

			ilp.recruitingcompanies("ACC");
			ilp.selectcompany();

			ilp.recruitingcompanies("ACC");
			ilp.selectcompany();

			ilp.recruitingcompanies("ACC");
			ilp.selectcompany();

			ilp.recruitingcompanies("ACC");
			ilp.selectcompany();

			// // Publish institute
			ilp.comments("Automation");
			ilp.publishInstitute();

			instituteId = ilp.getInstituteId();
			Variables.instituteId = instituteId;

			CommonFunctions.info(child1, "\n Institute posted with id : "
					+ instituteId);
		}

		catch (Exception e) {

			// // Do Nothing
		}

		finally {
			CommonFunctions.closeChild(parent, child1, report);
		}
	}

	public void LF_CLPPosting(Objects obj) {
		ExtentReports report = obj.getReport();
		ExtentTest parent = obj.getParent();
		String url = obj.getURL();
		WebDriver driver = obj.getDriver();

		ExtentTest child1 = CommonFunctions.createChild(report,
				obj.getcomponentDescription(),
				obj.getcomponentDetailDescription());

		CommonFunctions.info(child1, "\n Institute posted for Url : " + url);
		try {
			if (Variables.instituteId.length() > 1) {
				Variables.courseIdName = "Shiksha Automation Testing"
						+ Variables.instituteId;
			}
			// String path;
			// path = new java.io.File(".").getCanonicalPath();
			// path = path + "\\src\\test\\resources\\" + "brochure.pdf";
			clp = new LF_CLP_Posting(driver, child1);
			// // Used common code to login cms
			CommonFunctions.loginCMS(driver, url,
					FetchData.readConfig("cmsadminusername"),
					FetchData.readConfig("cmsadminpassword"));

			// // Open course Posting url
			driver.get(url + "nationalCourse/CoursePosting/create");

			// // Add Parent Entity
			if (Variables.instituteId.length() > 1) {
				clp.typeInstituteId(Variables.instituteId);
			} else {
				clp.typeInstituteId("307");
			}

			// // Click Go! button to select institute
			clp.clickGoButton();

			// // Click Select To select Institute
			clp.clickToSelectInstitute();

			// // Select credential as Degree
			clp.selectCredential("Degree");

			// // Select Course Level
			clp.selectCourseLevel("PG");

			// // Select Stream
			clp.selectStream("Business");

			// // Select Course
			clp.selectCourse("MBA");

			// // Type Course Name
			clp.typeCourseName(Variables.courseIdName);

			// // Type Duration
			clp.typeDuration("2");

			// // Click Approving body to select approving bodies
			clp.clickApprovingBodies();

			// // Select Approving Body 1
			clp.selectApprovingBody1();

			// // Select Approving Body 2
			clp.selectApprovingBody2();

			// // select Approving Body 3
			clp.selectApprovingBody3();

			// // Click Affiliation to close Approving Body layer
			clp.clickAffiliation();

			// //Type Univ Id
			clp.selectDomestic();
			if (Variables.universityId.length() > 1) {
				clp.typeUnivId(Variables.universityId);
			} else {
				clp.typeUnivId("41334");
			}
			// // click Go to Select Univ
			clp.clickGoToSelectUniv();

			// //Click Medium
			clp.clickMedium();
			// //Select Medium1
			clp.selectMedium1();
			// //Select Medium 2
			clp.selectMedium2();
			// //Select Medium 3
			clp.selectMedium3();

			// // Click label diff label to close medium layer
			clp.clickLabelDiffLabel();

			// //Select Diff label as begneer
			clp.selectDiffLabelBegneer();

			// //Select Domestic Affiliation

			// // Add USP Data
			clp.typeUSP1("USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1 USP 1");
			clp.clickUSPAddmore();
			clp.typeUSP2("USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2 USP 2");
			clp.clickUSPAddmore();
			clp.typeUSP3("USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3 USP 3");
			CommonFunctions.logCommon("\nAdd USP Completed");

			// // select Event Type
			try {
				clp.clickevent1("Aptitude Test");
				// //Type event desc
				clp.typeeventDesc1("Event Description 1 Event Description 1 Event Description 1");
				// //Click event add more
				clp.clickeventaddmore();
				// //Select event type
				clp.clickevent2("Counselling");
				// //Type event desc
				clp.typeeventDesc2("Event Description 2 Event Description 2 Event Description 2");
			} catch (Exception e) {
				throw e;
			}

			// // Course Structure
			clp.coursestructure1("Course Structure 1");
			clp.coursestructure2("Course Structure 2");

			// //Click upload brochure
			// clp.clickUploadBrochure();
			// / // Path for brochure
			// clp.uploadBrochurePath(path);

			clp.selectCourseFeeYear(1);
			clp.clickAddMoreToAddMoreFees();
			clp.enterDataInFields();
			clp.enterDataInFieldsOTP();
			clp.disclamar();
			clp.clickHostel();
			clp.clicktution();
			clp.clickLibrary();
			clp.hostelFees();
			clp.typeFeeOtherInfo("Any other information Any other information");

			// //Select Eligibility year
			clp.selectEligibilityYear(2);
			// // Enter 10 Eligibility Data
			clp.eligibility_10();
			clp.anyother_10("Any Specific Requirement Any Specific Requirement");
			Thread.sleep(1000);

			// // Enter 12 Eligibility Data
			clp.ScoreType12("CGPA");
			clp.outof_12("10");
			clp.eligibility_12();
			clp.anyother_12("Any Specific Requirement Any Specific Requirement");
			clp.mandatorySelect();
			clp.mandatoryAgriculture();
			clp.mandatoryArts();

			// // Enter Grad Eligibility Data
			clp.ScoreTypeGrad("Marks/Score");
			clp.outof_Grad("600");
			clp.eligibility_Grad();
			clp.anyother_Grad("Any Specific Requirement Any Specific Requirement");
			clp.selectBaseCourse("B.A.");

			// // Add Exams
			clp.clickAddMoreToAddMoreExam();
			clp.selectExam1("CAT");
			clp.selectExam2("XAT");
			clp.selectExamUnit1("Percentage");
			clp.selectExamUnit2("Rank");
			clp.enterExam1();
			clp.enterExam2();

			// // Enter age and work ex
			clp.minEx("1");
			clp.maxEx("10");
			clp.minage("23");
			clp.maxage("35");

			// //International Students Eligibility
			clp.international("International Students Eligibility International Students Eligibility");

			// // Any Any other eligibility?
			clp.anyother_req("Any Specific Requirement Any Specific Requirement");

			try {
				// // Enter Cut off Date
				clp.cutoff_collapse();
				clp.cutoff_science();
				clp.cutoff_Commerce();
				clp.selectCutoffExam(1);
				clp.selectCutoffExamYear(1);

				// // Enter Cut off Data for Exam
				clp.cutoff_allIndia();
				clp.cutoff_homestate();
				clp.cutoff_otherState();
				clp.cutoff_relatedState();

				// // Select Related State
				clp.relatedstatebutton();
				clp.selectState1();
				clp.selectState2();
			}

			catch (Exception e) {
				// // Do nothing
			}

			try {
				// //Seats Breakup
				clp.seats_collapse();
				clp.seats_total("120");
				clp.seats_category();
				clp.seats_exam();
				clp.seats_homestate("40");
				clp.seats_relatedstate("40");
				clp.seats_otherstate("40");
				clp.seats_RelatedStatesSelect();
				clp.seats_RelatedStatesSelect_1();
				clp.seats_RelatedStatesSelect_2();

			} catch (Exception e) {
				// // Do nothing
			}
			try {
				// //Placements
				// //Collpase placements
				clp.placements_collapse();

				// // Select Placement year
				clp.placementExamYear(1);

				// // Select Placement course
				clp.placementcourse(Variables.courseIdName);

				// // % batch places
				clp.placements_batchpercent("98");

				// / Min sal
				clp.placements_minsal("500000");

				// // Median sal
				clp.placements_mediansal("600000");

				// // Average sal
				clp.placements_avgsal("600000");

				// // Max sal
				clp.placements_maxsal("800000");

				// // International offers
				clp.placements_offers("500");

				// // Inernational offers max sal
				clp.placements_offers_sal("1000000");

				// // Upload placement report
				// clp.placements_report();
				// clp.uploadBrochurePath(path);

				// // Select Recruting Companies
				clp.placementsCompanies();
			}

			catch (Exception e) {
				// // DO nothing
			}

			try {
				// // Internship
				// // Expand Internship
				clp.internship_expand();

				// // Select Internship year
				clp.intern_year(1);

				// // Min intersnhip Stipend
				clp.internship_sal_min("100000");

				// // median intersnhip Stipend
				clp.internship_sal_median("200000");

				// // average intersnhip Stipend
				clp.internship_sal_avg("200000");

				// // max intersnhip Stipend
				clp.internship_sal_max("300000");

				// // Upload Internship report
				// clp.uplaodinternship();
				// clp.uploadBrochurePath(path);
			} catch (Exception e) {
				// / Do nothing
			}
			try {
				// //Partner Details
				// // Collapse partner
				clp.partnerCollapse();
				// //Click Yes to select partners
				clp.partnerYes();
				// //Update duration 1 for partner
				clp.partner_duration1("1");
				// //Enter univ as partner
				if (Variables.universityId.length() > 1) {
					clp.partner_univid(Variables.universityId);
				} else {
					clp.partner_univid("41334");
				}
				clp.partner_clickId();
				clp.partner_duration2("1");

			} catch (Exception e) {
				// // Do Nothing
			}

			try {
				// //Important Dates
				// //Collapse Dates
				clp.datescollapse();

				// //Select Date 1
				clp.dates_application_month("Dec");
				clp.dates_application_year(2);

				// //Select Date 2
				clp.dates_submit_month("Nov");
				clp.dates_submit_year(2);

				// //Select Date 3
				clp.dates_Commencement_month("Oct");
				clp.dates_Commencement_year(2);

			}

			catch (Exception e) {
				// // Do nothing
			}
			// //Select All Locations

			clp.courseLocations();
			// // Gallery
			// clp.selectAllGallery();

			// // Comments
			clp.comments("Automation Testing course Posted");

			// // Post course
			clp.publishCourse();

			// //Get CourseId
			// System.out.print(clp.courseId());
			String id = clp.courseId();
			Variables.courseId = id;

			CommonFunctions.info(child1, "\n Institute posted with id : " + id);

		} catch (Exception e) {
		}

		finally {
			CommonFunctions.closeChild(parent, child1, report);
		}
	}

}
