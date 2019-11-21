package com.shiksha.test;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.WebDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;



public class PageSource {

	public static String getSOLRCount(String URL,WebDriver driver,String nodeName, String attributeName, String attributeValue) {
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jahangeer.alam\\Desktop\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		driver.get(URL);
		String data = new PageSource().getXmlContent(driver, "int", "name", "ngroups");
		//driver.quit();
		return data;
	}


	public String getXmlContent(WebDriver driver, String nodeName, String attributeName, String attributeValue)
	{
		String pageSource = driver.getPageSource();
		String solrCount = getValueFromXML(pageSource, nodeName, attributeName, attributeValue);
		System.out.println("Solr Count: " + solrCount);
		return solrCount;

	}
	public String getValueFromXML(String xmlInString, String nodeName, String attributeName, String attributeValue)
	{
		String returnName = "";
		Document doc = null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(xmlInString)));
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		NodeList resultNode = doc.getElementsByTagName(nodeName);
		System.out.println(resultNode.getLength());
		for(int j = 0; j < resultNode.getLength(); j++)
		{
			Element count = (Element)resultNode.item(j);
			System.out.println("count is ::" + count);
			System.out.println("attributeName is ::" + attributeName );
			String attributeNameXML = count.getAttribute(attributeName);
			System.out.println("attributeNameXML is :: " +  attributeNameXML);
			System.out.println("attributeValue is :: " + attributeValue );
			if(attributeNameXML.equalsIgnoreCase(attributeValue))
			{
				returnName = count.getTextContent();
				System.out.println("Return Name is : " + returnName);
				break;
			}
		}
		return returnName;
	}


}
