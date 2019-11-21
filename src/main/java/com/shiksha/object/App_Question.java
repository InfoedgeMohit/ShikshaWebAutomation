package com.shiksha.object;
import org.openqa.selenium.*;

import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.Variables;

public class App_Question {
	WebDriver driver;
	public App_Question(WebDriver driver1){
		driver = driver1;
	}
	CommonFunctions CommonFunctions = new CommonFunctions();
	public void questionlayerclick() throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR("questionlayerbtn"));
			driver.findElement(FetchData.readOR("questionlayerbtn")).click();
			CommonFunctions.logPass("Question Box on Homepage Click Successfully");
			}
		catch(Exception e){
			CommonFunctions.logFail("Question Box on Homepage Click Failed");
			throw e;
		}
	}
	
	public void enterquestion(String questiontxt){
		try{
			driver.findElement(FetchData.readOR("questionbox")).clear();
			driver.findElement(FetchData.readOR("questionbox")).sendKeys(questiontxt);
			CommonFunctions.logPass("Question Entered Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Question Entered Failed");
			throw e;
		}
	}
	public void clicknxt() throws Exception{
		try{
			driver.findElement(FetchData.readOR("Nextbtn")).click();
			CommonFunctions.logPass("Click on Next Successfully");
			Variables.elementWait(driver, 20, FetchData.readOR("Nextbtn"));
			Variables.elementWait(driver, 20, FetchData.readOR("questionpostbtn"));
		}
		catch(Exception e){
			CommonFunctions.logFail("Click on Next Failed");
			throw e;
		}
	}
	
	public void clickquestionpost() throws Exception{
		try{
			driver.findElement(FetchData.readOR("questionpostbtn")).click();
			Variables.elementWait(driver, 30, FetchData.readOR("questiontitle"));
			CommonFunctions.logPass("Click on Post Successfully");
			
		}
		
		catch(Exception e){
			CommonFunctions.logFail("Click on post Failed");
			throw e;
		}
	}
	
	public String gettxt(String element) throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR(element));
			String txt = driver.findElement(FetchData.readOR(element)).getText();
			CommonFunctions.logPass("Get Text Succesfully" + element);
			return txt;
		}
		catch(Exception e){
			CommonFunctions.logFail("Get Text Failed: "  + element);
			throw e;
		}
	}
	
	public void questionclick(){
		try{
			driver.findElement(FetchData.readOR("Questionbtn")).click();
			CommonFunctions.logPass("Click on Question is successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Click on Question is Failed");
			throw e;
		}
	}
	
	public void enterquestionid(int questionid){
		boolean test = false;
		try{
			driver.findElement(FetchData.readOR("questionidbox")).clear();
			driver.findElement(FetchData.readOR("questionidbox")).sendKeys(String.valueOf(questionid));
			CommonFunctions.logPass("Question id entered Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Question id entered failed: " +test);
			throw e;
		}
		
	}
	public void clickokbtn(){
		try{
			driver.findElement(FetchData.readOR("Okbtn")).click();
			CommonFunctions.logPass("Ok Btn Click Successfully");
			CommonFunctions.closetour(driver);
		}
		catch(Exception e){
			CommonFunctions.logFail("Ok btn Click Failed");
			throw e;
		}
	}
	public void clickanswer(){
		try{
			driver.findElement(FetchData.readOR("writeanswer")).click();
			CommonFunctions.logPass("Write Answer Btn Click Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Write answer btn click failed");
			throw e;
		}
	}
	public void entertext(String txt){
		try{
			driver.findElement(FetchData.readOR("textbox")).sendKeys(txt);
			CommonFunctions.logPass("Text entered successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Text entered Failed");
			throw e;
		}
	}
	public void clickpost() throws Exception{
		try{
			driver.findElement(FetchData.readOR("postbtn")).click();
			Variables.elementWait(driver, 10, FetchData.readOR("followbtn"));
			CommonFunctions.logPass("Post Answer Btn Click Successfully");
		}
		catch(Exception e)
		{
			CommonFunctions.logFail("Post answer btn click failed");
			throw e;
		}
	}
	public void clickfollow(){
		try{
			driver.findElement(FetchData.readOR("followbtn")).click();
			CommonFunctions.logPass("Click on Follow Successfully");	
		}
		catch(Exception e){
			CommonFunctions.logFail("Click on Follow Failed");
			throw e;
		}
	}
	public void clickcmntbtn(){
		try{
			driver.findElement(FetchData.readOR("commentbtn")).click();
			CommonFunctions.logPass("Click on Comment Button Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Click on Comment Button Failed");
			throw e;
		}
	}	
	public void clickmorebtn() throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR("morebtn"));
			driver.findElement(FetchData.readOR("morebtn")).click();
			CommonFunctions.logPass("Click on more btn Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Click on More btn Failed");
			throw e;
		}
	}
	public void clickedittags() throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR("edittags"));
			driver.findElement(FetchData.readOR("edittags")).click();
			CommonFunctions.logPass("Click on edit Tags successfully");
			CommonFunctions.closetour(driver);
		}
		catch(Exception e){
		CommonFunctions.logFail("Click on edit Tags Failed");	
		throw e;
		}
	}
	public void clicktagbox() throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR("edittag"));
			driver.findElement(FetchData.readOR("edittag")).click();
			CommonFunctions.logPass("Click on edit tags successfully");
		}
		catch(Exception e){
		CommonFunctions.logFail("Click on edit tags Failed");	
		throw e;
		}
	}
	public void entertagname() throws Exception{
		try{
			driver.findElement(FetchData.readOR("tagsearchbox")).clear();
			driver.findElement(FetchData.readOR("tagsearchbox")).sendKeys("mba");
			CommonFunctions.logPass("Tag name entered Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Tag name entered Failed");
			throw e;
		}
	}
	public void clicktag(){
		driver.findElement(FetchData.readOR("clicktagname")).click();
		CommonFunctions.logPass("Tag name click Successfully");
	}
	public void clickaddtagbtn() throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR("addtagbtn"));
			driver.findElement(FetchData.readOR("addtagbtn")).click();
			CommonFunctions.logPass("Click on Done btn successfully");
		}
		catch(Exception e){
		CommonFunctions.logFail("Click on Done btn Failed");	
			throw e;
		}
	}
	public void clickeditquestion() throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR("editquestion"));
			driver.findElement(FetchData.readOR("editquestion")).click();
			CommonFunctions.logPass("Click on edit Question successfully");
		}
		catch(Exception e){
		CommonFunctions.logFail("Click on edit Question Failed");	
		throw e;
		}
	}
	public void clickeditdscn() throws Exception{
		try{
			Variables.elementWait(driver, 10, FetchData.readOR("editdiscussion"));
			driver.findElement(FetchData.readOR("editdiscussion")).click();
			CommonFunctions.logPass("Click on edit Discussion successfully");
		}
		catch(Exception e){
		CommonFunctions.logFail("Click on edit Discussion Failed");	
		throw e;
		}
	}
	public void clickclosequestion() throws Exception{
		try{
			Variables.elementWait(driver, 5, FetchData.readOR("closequestion"));
			driver.findElement(FetchData.readOR("closequestion")).click();
			CommonFunctions.logPass("Close question button click Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Close Question Button Click Failed");
			throw e;
		}
	}
	public void clickyesbtn() throws Exception
	{
		try{
			Variables.elementWait(driver, 5, FetchData.readOR("yesbtn"));
			driver.findElement(FetchData.readOR("yesbtn")).click();
			CommonFunctions.logPass("Click on yes successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Click on Yes failed");
			throw e;
		}
	}
	public void clickdeletequestion() throws Exception{
		try{
			Variables.elementWait(driver, 5, FetchData.readOR("deletequestion"));
			driver.findElement(FetchData.readOR("deletequestion")).click();
			CommonFunctions.logPass("Click on Delete successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Click on Delete failed");
			throw e;
		}
	}
	public void clickdigup(){
		try
		{
			driver.findElement(FetchData.readOR("digup")).click();
			CommonFunctions.logPass("Up down click Successfully");
		}
	catch(Exception e)
		{
		CommonFunctions.logFail("Up down click Failed");
		throw e;
		}
	}	
	public void clickdigdown(){
		try
		{
			driver.findElement(FetchData.readOR("digdown")).click();
			CommonFunctions.logPass("down vote click Successfully");
		}
	catch(Exception e)
		{
		CommonFunctions.logFail("down vote click Failed");
		throw e;
		}
	}	
	public void clickdiscussion(){
		try{
			driver.findElement(FetchData.readOR("hemburger")).click();
			CommonFunctions.logPass("click on hemburger succesfully");
			driver.findElement(FetchData.readOR("discussion")).click();
			CommonFunctions.logPass("click on Discussion successfuly");
			}		
		catch(Exception e){
			CommonFunctions.logFail("click on discussion failed");
		}
	}
	public void enterdiscussion(String text){
		try{
			driver.findElement(FetchData.readOR("additionaltext")).sendKeys(text);
			CommonFunctions.logPass("Additional Text entered Succesfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("Additional text entered Failed");
		}
	}
	public void clickdscncmntbtn(){
		try{
			driver.findElement(FetchData.readOR("dscncommentbtn")).click();
			CommonFunctions.logPass("Click on Comment Successfully");
		}
		catch(Exception e){
			CommonFunctions.logFail("click on comment failed");
		}
	}
	public void clickreplybtn(){
	try{
		driver.findElement(FetchData.readOR("replybtn")).click();
		CommonFunctions.logPass("Click on Reply Button Successfully");
	}
	catch(Exception e){
		CommonFunctions.logFail("Click on Reply Button Failed");
		throw e;
	}
}	
}
