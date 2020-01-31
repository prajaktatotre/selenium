package com.testng.annotations.practice;

import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestFactory {

	@Factory
	public Object[] getClasses() {
		Object[] test = new Object[2];
		test[0] = new Test1Factory();
		test[1] = new Test2Factory();
		return test;
	}

}
