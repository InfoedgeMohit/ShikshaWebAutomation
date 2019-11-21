package com.shiksha.object;

import org.openqa.selenium.WebDriver;

import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;

public class App_Login {
	WebDriver driver;

	public App_Login(WebDriver driver) {
		this.driver = driver;
	}
	CommonFunctions CommonFunctions = new CommonFunctions();
	public void clicklogin() {
		try {
			driver.findElement(FetchData.readOR("login")).click();
			CommonFunctions.logPass("Login Home button click Successful");
		} catch (Exception e) {
			CommonFunctions.logFail("Login home Button Click Failed");
			throw e;
		}
	}

	public void enteremail(String emailid) {
		try {
			driver.findElement(FetchData.readOR("emailBox")).sendKeys(
					FetchData.readConfig(emailid));
			CommonFunctions.logPass("Email entered Succesfully");
		} catch (Exception e) {
			CommonFunctions.logFail("Email Entered Failed");
			throw e;
		}
	}

	public void enterpaswrd(String pswrd) {
		try {
			driver.findElement(FetchData.readOR("pswrdBox")).sendKeys(
					FetchData.readConfig(pswrd));
			CommonFunctions.logPass("Password entered Successfully");
		} catch (Exception e) {
			CommonFunctions.logFail("Password Entered Failed");
			throw e;
		}
	}

	public void clickloginbtn() {
		try {
			driver.findElement(FetchData.readOR("loginbtn")).click();
			CommonFunctions.logPass("Login Button Click Successfully");
		} catch (Exception e) {
			CommonFunctions.logFail("Login Button Click Failed");
			throw e;
		}
	}
	public void clickhembuger(){
		try {
			driver.findElement(FetchData.readOR("hemburger")).click();
			CommonFunctions.logPass("Hemburger Button Click Successfully");
		} catch (Exception e) {
			CommonFunctions.logFail("Hemburger Button Click Failed");
			throw e;
		}
	}
	public void clicklogout(){
		try {
			driver.findElement(FetchData.readOR("logout")).click();
			CommonFunctions.logPass("Logout Click Successfully");
		} catch (Exception e) {
			CommonFunctions.logFail("Logout Click Failed");
			throw e;
		}
	}
}
