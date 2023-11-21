import java.util.Scanner;
public class Exceptionhandling {
	public static void main(String[] args)
	{
		char choice='y';
		while(choice=='y')
		{
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Program to perform Division");
			System.out.println("Enter Number-1:");
			int num1=sc.nextInt();
			System.out.println("Enter Number-2:");
			int num2=sc.nextInt();
			int result;
			try 
			{
				result=num1/num2;
				System.out.println("Result="+result);
			}
			catch(ArithmeticException e)
			{
				System.out.println("/ by zero");
			}
			finally
			{
				System.out.println("End of operation");
				System.out.println("do you want to continue or not(y/n)");
				choice=sc.next().charAt(0);
			}
		}
	}
}
