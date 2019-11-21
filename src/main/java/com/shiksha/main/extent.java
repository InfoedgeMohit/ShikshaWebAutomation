package com.shiksha.main;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class extent {


    public void sdfsdf()
    {

        ExtentHtmlReporter htmlReport = new ExtentHtmlReporter("C:\\Users\\Mohit\\Desktop\\New folder\\ddada.html");
        ExtentReports report = new ExtentReports();
        report.attachReporter(htmlReport);


        ExtentTest parent =  report.createTest("1","fsdf");

        ExtentTest child1 = parent.createNode("1.1","fsfsdfsd");
        ExtentTest child4 = parent.createNode("1.1");
        
        child1.log(Status.PASS, "11");
        child1.log(Status.PASS, "11");
        child1.log(Status.PASS, "11");
        
        child4.log(Status.PASS, "11");
        child4.log(Status.PASS, "11");
        child4.log(Status.FAIL, "11");
        
        ExtentTest parent2 =  report.createTest("2");
        ExtentTest child2 = parent2.createNode("1.1", "1.1111");
        child2.log(Status.PASS, "11");
        child2.log(Status.PASS, "11");
        child2.log(Status.PASS, "11");
       
        
        
        report.flush();
    }
}
