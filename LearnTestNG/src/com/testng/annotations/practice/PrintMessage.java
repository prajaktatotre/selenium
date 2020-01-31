package com.testng.annotations.practice;

public class PrintMessage {

	private String message;
	
	//constructor
	public PrintMessage(String msg){
		this.message=msg;
	}
	
	public String printOutMessage(){
		System.out.println("message is :"+ message);
		return message;
	}
	
}
