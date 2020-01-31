package com.testng.annotations.practice;

import org.junit.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssert {

	@Test
	public void softAssert() {
		System.out.println("started soft assert");
		SoftAssert softAssertion = new SoftAssert();
		softAssertion.assertTrue(false);
		System.out.println("Executed soft assert");
		//softAssertion.assertAll();
	}

	@Test
	public void HardAssert() {
		System.out.println("Hard Assert started");
		Assert.assertTrue(false);
		System.out.println("Hard assert executed");
	}

	@Test
	public void AnotherMethod() {
		System.out.println("another method without assert");
	}
}
