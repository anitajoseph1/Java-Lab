
import java.util.StringTokenizer;
import java.util.Scanner;
public class StringTokendemo {
  public static void main(String args[] ){
	  int sum=0;
	  Scanner sc=new Scanner(System.in);
	  System.out.println("Enter the string");
	  String integers=sc.nextLine();
	  StringTokenizer input=new StringTokenizer(integers);
	  while(input.hasMoreTokens()) {
		  int num=Integer.parseInt(input.nextToken());
		  System.out.println(num);
		  sum=sum+num;
	  }
	  System.out.println("Sum is "+sum);
  }
}