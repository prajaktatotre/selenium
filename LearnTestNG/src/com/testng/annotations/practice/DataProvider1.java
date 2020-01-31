package com.testng.annotations.practice;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProvider1 {

	@DataProvider
	public static Object[][] getData() {
		return new Object[][] { { "Prajakta", "Totre" }, { "Amrita", "Bias" } };
	}

	@Test(dataProvider = "getData")
	public void printName(String fname, String lname) {
		System.out.println("firstname is " + fname + "\tlast name is: " + lname);
	}

	@Test(dataProvider = "data-provide")
	public void f(Integer n, String s) {
		System.out.println("number is :" + n + "\tvalue is:" + s);
	}

	@DataProvider(name="data-provide",parallel = true)
	public Object[][] dp() {
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }};
		//return new Object[][]{{1,"a"},{2,"b"}};
	}
}
