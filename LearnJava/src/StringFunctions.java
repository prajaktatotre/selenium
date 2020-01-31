import java.util.Scanner;

public class StringFunctions {
	
	Scanner in = new Scanner(System.in);
	
	void checkPalindrom(){
		String inputString;
		String reverseString="";
		System.out.println("Enter the string");
		inputString= in.nextLine();
		int length= inputString.length();
		for(int i=length-1; i>=0; i--){
			reverseString= reverseString+ inputString.charAt(i);
		}
		if(inputString.equals(reverseString)){
			System.out.println("String is pallindrom");
		}
		else{
			System.out.println("String not pallindrom");

		}
	}
	
	void convertCharToString(){
		char ch = 'a';
		String str = Character.toString(ch);
		System.out.println(str);
	}
	
	public static void main(String[] args){
		
		StringFunctions obj= new StringFunctions();
		obj.convertCharToString();
		obj.checkPalindrom();
		}
}
