package com.google.login;

import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Loginscreen {

	// global variable
	static WebDriver driver = null;

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");

		// *[@id='identifierId']
//		System.out.println(clickonElement("id", "identifierId"));
		getwebElement("id", "identifierId").sendKeys("gmi.fhb@gmail.com");
//		getwebElement("id", "identifierId").sendKeys(Keys.ENTER);
		System.out.println(clickonElement("xpath", "//*[text()='Next']"));

	}

	public static boolean clickonElement(String locatortype, String locatorValue) {
		boolean flag = false;
		WebElement getwebElement = getwebElement(locatortype, locatorValue);
		if (getwebElement.isDisplayed()) {
			getwebElement.click();
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public static WebElement getwebElement(String locatortype, String locatorValue) {

		if (locatortype.equalsIgnoreCase("xpath")) {
			return driver.findElement(By.xpath(locatorValue));
		} else if (locatortype.equalsIgnoreCase("id")) {
			return driver.findElement(By.id(locatorValue));
		} else {
			System.out.println("locator type not found");
			return null;
		}

	}

}
