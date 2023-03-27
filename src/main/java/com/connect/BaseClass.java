package com.connect;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import com.beust.jcommander.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static WebDriver driver;
	
	public static WebDriver createDriver() {
	
		WebDriverManager.chromedriver().setup();	
		return driver = new ChromeDriver();
	}
	public void switchToWindowIndex(int index) {
		String parentId = driver.getWindowHandle();
		System.out.print(parentId);
	    Set<String> AllWindowsId = driver.getWindowHandles();
	    System.out.print(AllWindowsId);
	    List <String> ref = new ArrayList();
	    ref.addAll(AllWindowsId);
	    driver.switchTo().window(ref.get(index));
	    
	}
	
	public void CompareEnteredVal(By ele, String val) {
	
		String EnteredText = driver.findElement(ele).getAttribute("value");
		Assert.assertEquals(EnteredText,val);
}

}
