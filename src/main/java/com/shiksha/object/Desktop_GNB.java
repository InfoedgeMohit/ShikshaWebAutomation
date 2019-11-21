package com.shiksha.object;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentTest;
import com.shiksha.resourses.CommonFunctions;
import com.shiksha.resourses.FetchData;
import com.shiksha.resourses.GenericFunction;
import com.shiksha.resourses.Variables;

public class Desktop_GNB {
	WebDriver driver;
	ExtentTest child1;
	List<Object> child = new ArrayList<Object>();
	String url = "";
	GenericFunction per;
	public Desktop_GNB(WebDriver driver,String Url) {
		this.driver = driver;
		per = new GenericFunction(driver);
		url = Url;
	}
	public Desktop_GNB(WebDriver driver, ExtentTest child) {
		this.driver = driver;
		this.child1 = child;

		this.child.add(this.driver);
		this.child.add(this.child1);
	}

	CommonFunctions CommonFunctions = new CommonFunctions();

	public List<WebElement> GNB_Layer1_List() {
		try {
			List<WebElement> GNB_Layer_1 = driver.findElements(FetchData
					.readOR("GNBLayer1"));
			CommonFunctions.pass(child,
					"\n Fetch List For GNB_Layer1_List Passed");
			return GNB_Layer_1;
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"\n Fetch List For GNB_Layer1_List Failed");
			throw e;
		}
	}

	public List<WebElement> GNB_Layer2_List(int i) {
		try {
			String element = Variables.objects.get("GNBLayer2")[1];
			element = element.replace("layer1i", Integer.toString(i));
			List<WebElement> GNB_Layer_2 = driver.findElements(By
					.xpath(element));
			CommonFunctions.pass(child,
					"\n Fetch List For GNB_Layer2_List Passed");
			return GNB_Layer_2;
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"\n Fetch List For GNB_Layer2_List Failed");
			throw e;
		}
	}

	public List<WebElement> GNB_Layer3_List(int i, int j) {
		try {
			String element = Variables.objects.get("GNBLayer3_2")[1];
			element = element.replace("layer2j", Integer.toString(j));
			element = element.replace("layer1i", Integer.toString(i));
			List<WebElement> GNB_Layer_2 = driver.findElements(By
					.xpath(element));
			CommonFunctions.pass(child,
					"\n Fetch List For GNB_Layer3_List Passed");
			return GNB_Layer_2;
		} catch (Exception e) {
			CommonFunctions.fail(child,
					"\n Fetch List For GNB_Layer3_List Failed");
			throw e;
		}
	}

	public String mouseHoverLevel2Click(int i, int j) {
		try {

			String layer1 = Variables.objects.get("GNBLayer1")[1];
			String source = "(" + layer1 + ")[" + i + "]";
			String layer2 = (Variables.objects.get("GNBLayer2")[1]).replace(
					"layer1i", Integer.toString(i));
			String destination = "(" + layer2 + ")[" + j + "]/a";
			Actions actions = new Actions(driver);
			WebElement mainMenu = driver.findElement(By.xpath(source));
			actions.moveToElement(mainMenu).build().perform();
			//Thread.sleep(1000);
			if (j > 11) {
				String downPath = (Variables.objects.get("GNBLayerDOWN")[1])
						.replace("layer1i", Integer.toString(i));
				driver.findElement(By.xpath(downPath)).click();
			}
			WebElement subMenu = driver.findElement(By.xpath(destination));
			String abc = driver.findElement(By.xpath(destination)).getText();
			if (subMenu.getAttribute("href") != null) {
				actions.moveToElement(subMenu).click().build().perform();
				if (abc.length() == 0) {
					abc = driver.findElement(By.xpath(destination)).getText();
				}
				CommonFunctions.pass(child, "\n click on" + abc + "Passed");

			}
			return abc;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n mouseHoverLevel2Click Failed");
			return "No element found";
		}
	}

	public String mouseHoverLevel3Click(int i, int j, int k) {
		try {

			String layer1 = Variables.objects.get("GNBLayer1")[1];
			String source = "(" + layer1 + ")[" + i + "]";
			String layer2 = (Variables.objects.get("GNBLayer2")[1]).replace(
					"layer1i", Integer.toString(i));
			String destination = "(" + layer2 + ")[" + j + "]";
			String layer3 = (Variables.objects.get("GNBLayer3_2")[1]).replace(
					"layer1i", Integer.toString(i));
			layer3 = layer3.replace("layer2j", Integer.toString(j));
			String finalDestination = "(" + layer3 + ")[" + k + "]/a";
			Actions actions = new Actions(driver);
			WebElement mainMenu = driver.findElement(By.xpath(source));
			actions.moveToElement(mainMenu).build().perform();
			//Thread.sleep(1000);
			if (j > 11) {
				String downPath = (Variables.objects.get("GNBLayerDOWN")[1])
						.replace("layer1i", Integer.toString(i));
				driver.findElement(By.xpath(downPath)).click();
			}
			WebElement subMenu = driver.findElement(By.xpath(destination));
			String abc = driver.findElement(By.xpath(finalDestination))
					.getText();
			actions.moveToElement(subMenu).build().perform();
			//Thread.sleep(1000);
			WebElement finalMenu = driver.findElement(By
					.xpath(finalDestination));
			if (abc.length() < 1) {
				abc = driver.findElement(By.xpath(finalDestination)).getText();
			}
			if (finalMenu.getAttribute("href") != null) {
				actions.moveToElement(finalMenu).click().build().perform();
				if (abc.length() < 1) {
					abc = driver.findElement(By.xpath(finalDestination))
							.getText();
				}
				CommonFunctions.pass(child, "\n click on" + abc + "Passed");
			}

			return abc;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n mouseHoverLevel2Click Failed");
			return "NO element found";
		}
	}

	public String getElement(int i) {
		try {

			String layer1 = Variables.objects.get("GNBLayer1")[1];
			String source = "(" + layer1 + ")[" + i + "]";
			String element = driver.findElement(By.xpath(source)).getText();
			CommonFunctions.pass(child, "\n Fetch List For getElement Passed");
			return element;
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n Fetch List For getElement Failed");
			throw e;
		}
	}

	public String verifyLogo() {
		try {
			if (driver.findElement(FetchData.readOR("VerifyLogo"))
					.isDisplayed()) {
				CommonFunctions.pass(child, "\n verifyLogo Failed");
				return "Pass";

			} else {
				CommonFunctions.fail(child, "\n verifyLogo Failed");
				return "Fail";

			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n verifyLogo Failed");
			return "Fail";
		}
	}

	public String verifyError1() {
		try {
			if (driver.findElement(FetchData.readOR("VerifySorry")).getText()
					.contains("Sorry")) {
				CommonFunctions.pass(child, "\n verifyError1 Failed");
				return "Pass";

			} else {
				CommonFunctions.fail(child, "\n verifyError1 Failed");
				return "Fail";

			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n verifyError1 Failed");
			return "Fail";
		}
	}

	public String verifyError2() {
		try {
			if (driver.findElement(FetchData.readOR("VerifySorry2")).getText()
					.contains("Sorry")) {
				CommonFunctions.pass(child, "\n verifyError2 Failed");
				return "Pass";

			} else {
				CommonFunctions.fail(child, "\n verifyError2 Failed");
				return "Fail";

			}
		} catch (Exception e) {
			CommonFunctions.fail(child, "\n verifyError2 Failed");
			return "Fail";

		}
	}
	
	public void howerLvl1(String txt,com.aventstack.extentreports.ExtentTest child1) {
		try {
			//Thread.sleep(1000);
			String xpath = per.DynamicXpath("GNB_L1", txt);
			//System.out.println(driver);
	
			WebElement we = driver.findElement(By.xpath(xpath));
			Actions ac = new Actions(driver);
			Variables.elementWait(driver, 10, By.xpath(xpath));
			ac.moveToElement(we).build().perform();
			per.childPass(child1, "Hover on "+txt+" Successed");
		}catch(Exception e) {
			try {
				per.childFail(child1, "Hover on "+txt+" Failed");
				//CommonFunctions.fail(child1, "Hover on "+txt+" Failed");
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void Click_GNB_More(com.aventstack.extentreports.ExtentTest child1) {
		try {
			//Thread.sleep(1000);
			Variables.elementWait(driver, 10, FetchData.readOR("GNB_More_Btn"));
			driver.findElement(FetchData.readOR("GNB_More_Btn")).click();
			per.childPass(child1, "Click on More Successed");
			//CommonFunctions.pass(child1, "Click on More Successed");
		}catch(Exception e) {
			per.childFail(child1, "Click on More Failed");
			//CommonFunctions.fail(child1, "Click on More Failed");
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public List<WebElement> Lvl3we()
	{
		return  driver.findElements(FetchData.readOR("Mobile_L3_Element"));
	}
	public String lvl3spl_Url()
	{
		return driver.findElement(FetchData.readOR("Mobile_L3_Element_Spl")).getAttribute("href");
	}
	public boolean is_L2_Visible(String txt) {
		String xpath = per.DynamicXpath("GNB_L2", txt);
		if(driver.findElements(By.xpath(xpath)).size()>0 && driver.findElement(By.xpath(xpath)).isDisplayed())
			return true;
		else
			return false;
	}
	public boolean isLocationAvailable() {
		if(driver.findElements(FetchData.readOR("GNB_Location")).size()>0 && driver.findElement(FetchData.readOR("GNB_Location")).isDisplayed())
			return true;
		else
			return false;
	}
	public void howerLvl2(String L1,String txt,String L3,com.aventstack.extentreports.ExtentTest child1) {
		try {
			Thread.sleep(500);
			String xpath = per.DynamicXpath("GNB_L2", txt);
			//System.out.println(driver);
	
			if(L1.equalsIgnoreCase("More Courses") && !per.isAvailable(xpath)) {
				Click_GNB_More(child1);
			}
			Thread.sleep(1000);
			WebElement we = null;
			
				 we= driver.findElement(By.xpath(xpath));
			
			Variables.elementWait(driver, 10, By.xpath(xpath));
			Thread.sleep(2000);
			//Variables.elementWait(driver, 2, By.xpath(per.DynamicXpath("GNB_L3", L3)));
			Actions ac = new Actions(driver);
			int siz= driver.findElements(FetchData.readOR("GNB_Active_list")).size();
			String s = driver.findElements(FetchData.readOR("GNB_Active_list")).get(siz-1).getText();
			if(s.contains("\n") && !s.substring(0, s.indexOf("\n")).equalsIgnoreCase(txt) ){
				if(driver.getCurrentUrl().equalsIgnoreCase(url)&& !L1.equalsIgnoreCase("Study Abroad"))
					we.click();
				else {
					//System.out.println(L1);
					ac.moveToElement(we).build().perform();
				}
			}
			
			//we.click();
			/*//Thread.sleep(2000);*/
			per.childPass(child1, "Hover on "+txt+" Successed");
			//CommonFunctions.pass(child1, "Hover on "+txt+" Successed");
			/*if(!we.isDisplayed()) {
				
				System.out.println("here");
				}
			System.out.println(we.getText());
			//Thread.sleep(2000);*/
			
		}catch(Exception e) {
			try {
				per.childFail(child1, "Hover on "+txt+" Failed");
				//CommonFunctions.fail(child1, "Hover on "+txt+" Failed");
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void clickLvl2(String txt,com.aventstack.extentreports.ExtentTest child1) {
		try {
			Thread.sleep(500);
			String xpath = per.DynamicXpath("GNB_L2", txt);
			//System.out.println(driver);
	
			if(!per.isAvailable(xpath)) {
				Click_GNB_More(child1);
				
			}
			WebElement we = driver.findElement(By.xpath(xpath));
			
			Variables.elementWait(driver, 10, By.xpath(xpath));
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//CommonFunctions.pass(child1, "Click on "+txt+" Successed");
		}catch(Exception e) {
			try {
				per.childFail(child1, "Click on "+txt+" Failed");
				//CommonFunctions.fail(child1, "Click on "+txt+" Failed");
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public void close_Location() {
		driver.findElement(FetchData.readOR("GNB_Location_Close")).click();
	}
	public boolean isL2Available(String l2) {
		String xpath = per.DynamicXpath("GNB_L2", l2);
		//System.out.println(driver);

		if(per.isAvailable(xpath)) {
			return true;
		}
		return false;
	}
	public void clickLvl3(String l1,String l2,String txt,int loc,com.aventstack.extentreports.ExtentTest child1) {
		try {
			Thread.sleep(500);
			String xpath = per.DynamicXpath("GNB_L3", txt);
			//System.out.println(driver);
			int i=0;
			while(driver.findElements(By.xpath(xpath)).size()==0){
				per.scrollVerticalTo(-2000);
				//Thread.sleep(2000);
				i++;
				if(isLocationAvailable()) {
					close_Location();
				}
					
				howerLvl1(l1, child1);
				if(i>1 && l1.equalsIgnoreCase("More Courses"))
					Click_GNB_More(child1);
			
				howerLvl2(l1,l2,txt, child1);
				
				
				System.out.println("here --->"+i);
				if(i==2)
					break;
			}
			
			Variables.elementWait(driver, 10, By.xpath(xpath));
			WebElement we = driver.findElements(By.xpath(xpath)).get(loc);
	
			
			we.click();
			per.childPass(child1, "Click on "+txt+" Successed");
			//CommonFunctions.pass(child1, "Click on "+txt+" Successed");
		}catch(Exception e) {
			try {
				per.childFail(child1, "Click on "+txt+" Failed");
				//CommonFunctions.fail(child1, "Click on "+txt+" Failed");
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	public boolean footer_Available(com.aventstack.extentreports.ExtentTest child1) {
		try {
			if(driver.findElements(FetchData.readOR("GNB_Footer")).size()>0) {
/*				Variables.elementWait(driver, 10, FetchData.readOR("GNB_Footer"));*/
				//Thread.sleep(1000);
				return driver.findElement(FetchData.readOR("GNB_Footer")).isDisplayed();
			}
			return true;
		}catch(org.openqa.selenium.TimeoutException e) {
			throw e;
		}catch(Exception e)
		{	
			per.childFail(child1, "Footer is not displayed");
			//CommonFunctions.fail(child1, "Footer is not displayed");
			try {
				throw e;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return true;
	}
}
