package com.testng.annotations.practice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTestng {

	@Test
	@Parameters({ "BrowserName" })
	public void OpenBrowser(String BrowserName) {
		System.out.println("Open the browser: " + BrowserName);	
	}	
	
	@Test
	@Parameters({"username","password"})
	public void login(String username, String password){
		System.out.println("login using username: "+ username+ "\tand password: "+ password);
	}
}
