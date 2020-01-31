package com.testng.annotations.practice;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListenersTestNG implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase is success: "+ result.getName());		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase is Falied: "+ result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case is skipped: "+ result.getName());		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
