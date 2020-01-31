package com.testng.annotations.practice;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Annotations {

	String message = "Learn Annotations";
	PrintMessage obj = new PrintMessage(message);
	String message1= "Learn Annotations by soft assert";
	
	@Test(groups = {"A"})
	public void testPrintMessage(){
		Assert.assertEquals(message, obj.printOutMessage());
		System.out.println("Test case passed");
	}
	
	@Test(groups={"A"})
	public void testprintMessage2(){
		SoftAssert softAssertobject= new SoftAssert();
		softAssertobject.assertEquals(message1,obj.printOutMessage());
		softAssertobject.assertAll();
	}
	
	@Test(groups={"BasicAnnotations"}, enabled=false)
	public void f1() {
		System.out.println("Executing f1....Inside f1 function");

	}

	@Test(groups={"BasicAnnotations"},dependsOnMethods = {"f3"})
	public void f2() {
		System.out.println("Executing f2...Inside f2 function");
	}
	
	@Test(groups={"BasicAnnotations"})
	public void f3() {
		System.out.println("Executing f3...Inside f3 function");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass: Only once before first test case in the class");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass: Only once after all test case in the class");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest: Execute once for any test case in the class");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest: Execute once after alltest case in the class");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod: will execute before every test method");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod: will execute before every test method");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("in beforeSuite: only once before suite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("in afterSuite: once after suite");
	}

}
