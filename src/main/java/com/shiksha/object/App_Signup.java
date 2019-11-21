package com.shiksha.object;

import org.openqa.selenium.WebDriver;

import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;

public class App_Signup {
	WebDriver driver;
	
	public App_Signup(WebDriver driver){
		this.driver = driver;
	}
	
	CommonFunctions CommonFunctions = new CommonFunctions();
	public void signuphome(){
		try{
			driver.findElement(FetchData.readOR("signUp")).click();
			CommonFunctions.logPass("Signup home Button click Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Signup Home Button Click Failed"); 
			throw e;
		}
	}
	
	public void firstname(String fname){
		try{
			driver.findElement(FetchData.readOR("fname")).sendKeys(fname);	  
		CommonFunctions.logPass("First Name enter Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("First Name Entered Failed"); 
			throw e;
		}
	}

	public void lastname(String lname){
		try{
		driver.findElement(FetchData.readOR("lname")).sendKeys(lname);	  
		CommonFunctions.logPass("Last name entered Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Last name entered Failed"); 
			throw e;
		}
	}
	public void email(String email){
		try{
			driver.findElement(FetchData.readOR("emailBox")).sendKeys(email);
			CommonFunctions.logPass("Email Entered Successful");
		}
		catch(Exception e){
			CommonFunctions.logFail("Email Entered Failed"); 
			throw e;
		}
	}
	public void password(String pswrd){
		try{
			driver.findElement(FetchData.readOR("pswrdBox")).sendKeys(pswrd);
			CommonFunctions.logPass("Password entered Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Password Entered Failed"); 
			throw e;
		}
	}
	public void signupbtn(){
		try{
			driver.findElement(FetchData.readOR("signUpbtn")).click();
			CommonFunctions.logPass("Singup Button Click Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Signup Button Click Failed"); 
			throw e;
		}
	}
	public void closeicon(){
		try{
			driver.findElement(FetchData.readOR("closeicon")).click();
			CommonFunctions.logPass("Closed icon Click Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Closed icon Failed"); 
			throw e;
		}
	}
}
