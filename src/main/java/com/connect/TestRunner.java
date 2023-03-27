package com.connect;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.lang.reflect.Constructor;
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
import org.testng.IAnnotationTransformer;
import org.testng.ITest;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRunner extends BaseClass implements IAnnotationTransformer {

	public static Object[] object = null;

	// private final List[] activatedTest = null;
	@Test
	public void TestRunner1() throws FilloException {
		// activatedTest = new ArrayList<String>();
		// createDriver();
		// 1. Open Excel file
		Fillo fillo = new Fillo();

		Connection connection = fillo.getConnection("D:\\TestCases\\ExcelSheet.xlsx");
		Recordset recordset = connection.executeQuery("SELECT * FROM Sheet1 WHERE ToRunStatus='Yes'");
		int numberOfRows = recordset.getCount();
		System.out.println("Size: " + numberOfRows);
		int i = 0;
		object = new Object[numberOfRows];
		// activatedTest = new List[numberOfRows];
		while (recordset.next()) {
			object[i] = recordset.getField("TestCaseId");
			System.out.println(object[i]);
			i++;
		}
		recordset.close();
		connection.close();
	}


}
