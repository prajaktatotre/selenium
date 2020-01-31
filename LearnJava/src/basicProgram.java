import java.util.Scanner;

public class basicProgram {

	public static void main(String[] args) {
		
		
		int n1=20;
		int n2=50;
		int addition= n1 + n2;
		System.out.println("additon is :"+ addition);

		//using scanner
		int n3;
		int n4;
		
		Scanner in = new Scanner(System.in);
		System.out.println("enter two numbers:");
		n3= in.nextInt();
		n4= in.nextInt();
		int addtion2= n3+n4;
		System.out.println("Addition is :" +addtion2);
		
	}

}


