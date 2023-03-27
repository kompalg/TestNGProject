package com.connect;

import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

//imlements this interface, its run () method will be invoked instead of each @Test method found.
public class FilteringExecution implements IHookable  {

	public List<String> methodsToRun = new ArrayList();
	

	@Factory(dataProvider = "dp")
	public FilteringExecution(List<String> methodsToRun) {
		this.methodsToRun = methodsToRun;
	}

	public void run(IHookCallBack callBack, ITestResult testResult) {
		String testMethodName = testResult.getMethod().getMethodName();
		if (methodsToRun.contains(testMethodName)) {
			System.err.println("About to run " + testResult.getMethod().getMethodName());
			callBack.runTestMethod(testResult);
		} else {
			testResult.setStatus(ITestResult.SKIP);
		}
	}

	@Test
	public void testMethod() {
		System.err.println("testMethod()");
	}

	@Test
	public void anotherTestMethod() {
		System.err.println("anotherTestMethod()");
	}

	@Test
	public void thirdTestMethod() {
		System.err.println("thirdTestMethod()");
	}

	@DataProvider(name = "dp")
	public Object[][] getData() throws FilloException {
		// activatedTest = new ArrayList<String>();
		// createDriver();
		Object[][] object = null;
		// 1. Open Excel file
		Fillo fillo = new Fillo();
		// List<String> list = new ArrayList<String>();
		Connection connection = fillo.getConnection("D:\\TestCases\\ExcelSheet.xlsx");
		Recordset recordset = connection.executeQuery("SELECT * FROM Sheet1 WHERE ToRunStatus='Yes'");
		int numberOfRows = recordset.getCount();
		System.out.println("Size: " + numberOfRows);
		int i = 0;
		object = new Object[numberOfRows][numberOfRows];
		// methodsToRun = new List[numberOfRows];
		// activatedTest = new List[numberOfRows];
		while (recordset.next()) {
			// String abc = recordset.getField("TestCaseId");
			// methodsToRun.add(abc);
			// System.out.println(methodsToRun.get(i));
			object[i][0] = recordset.getField("TestCaseId");
			System.out.println(object[i]);
			// String abc = recordset.getField("TestCaseId");
			// list.add(abc);
			// System.out.println(list);
			i++;
		}

		//recordset.close();
		//connection.close();
		// return list.iterator();
		   return new Object[][]{
               {Arrays.asList(object)}
       };
   
		//return new Object[][] {Arrays.asList(object)};
	}
}