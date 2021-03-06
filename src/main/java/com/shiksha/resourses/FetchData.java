package com.shiksha.resourses;

import org.openqa.selenium.By;

public class FetchData {

	public static By readOR(String locatorName) {
		By locator = null;

		String[] element = new String[2];

		element = Variables.objects.get(locatorName);
		switch (element[0].toLowerCase()) {
		case "id":
			locator = By.id(element[1]);
			break;
		case "name":
			locator = By.name(element[1]);
			break;
		case "cssselector":
			locator = By.cssSelector(element[1]);
			break;
		case "linktext":
			locator = By.linkText(element[1]);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(element[1]);
			break;
		case "tagname":
			locator = By.tagName(element[1]);
			break;
		case "xpath":
			locator = By.xpath(element[1]);
			break;
		case "class":
			locator = By.className(element[1]);
			break;
		}
		return locator;
	}

	public static By getData(String locator1, String locatorName) {
		By locator = null;
		switch (locator1.toLowerCase()) {
		case "id":
			locator = By.id(locatorName);
			break;
		case "name":
			locator = By.name(locatorName);
			break;
		case "cssselector":
			locator = By.cssSelector(locatorName);
			break;
		case "linktext":
			locator = By.linkText(locatorName);
			break;
		case "partiallinktext":
			locator = By.partialLinkText(locatorName);
			break;
		case "tagname":
			locator = By.tagName(locatorName);
			break;
		case "xpath":
			locator = By.xpath(locatorName);
			break;
		case "class":
			locator = By.className(locatorName);
			break;
		}
		return locator;
	}

	public static String readConfig(String name) {
		return Variables.prop.getProperty(name);
	}
}
