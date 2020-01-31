package com.dataProvider.learn;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test1 {
	
  @Test
  public void f() {
	  System.out.println("Hellooooo");
  }
  @Test(dataProvider = "dp")
  public void f1(Integer n, String s) {
	  
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
