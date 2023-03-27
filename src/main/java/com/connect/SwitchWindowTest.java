package com.connect;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.Assert;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchWindowTest extends BaseClass {

	//private WebDriver driver;
	By SearchArea = By.xpath("//input[@class='_3704LK']");
	By closebtn = By.xpath("//div[@class='_2QfC02']/button[1]");

	

	@Test
	public void verifySearchButton() throws Throwable {
		createDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
		driver.get("http://www.flipkart.com");

		//String search_text = "Google Search";
		//WebElement search_button = driver.findElement(By.name("btnK"));

		//String text = search_button.getAttribute("value");

		//Assert.assertEquals(text, search_text, "Text not found!");
		
		driver.findElement(closebtn).click();
		Thread.sleep(1000);
		driver.findElement(SearchArea).sendKeys("phone");
		Thread.sleep(1000);
		//CompareEnteredVal(SearchArea,"phone");
		Thread.sleep(100);
		driver.findElement(SearchArea).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[contains(text(),'realme C33')])[1]")).click();
		switchToWindowIndex(1);
		
		driver.findElement(SearchArea).sendKeys("phones");
		Thread.sleep(1000);
		//CompareEnteredVal(SearchArea,"phones");
		Thread.sleep(100);
		driver.findElement(SearchArea).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//div[contains(text(),'MU M370')])[1]")).click();
		Thread.sleep(1000);
		switchToWindowIndex(1);
		switchToWindowIndex(0);
		
		
	}

	

	
}