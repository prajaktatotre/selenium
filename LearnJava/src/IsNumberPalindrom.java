import java.util.Scanner;

public class IsNumberPalindrom {

	public boolean isCheck(int number){
		String a = Integer.toString(number);
		StringBuffer rv= new StringBuffer(a);
		rv.reverse();
		String rev= rv.toString();
		
		if(a.equals(rev)){
			return true;
		}
		else{
			return false;
		}
		
	}

	public static void main(String[] args) {
		int number;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number");
		number = in.nextInt();
		System.out.println("Number is "+ number);
		IsNumberPalindrom obj= new IsNumberPalindrom();
		System.out.println("result   "+ obj.isCheck(number));
		
	}

}
