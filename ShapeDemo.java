/************************************************************************************************************
 * File        : ShapeDemo.java
 * Description : To calculate the area of different shapes using method overloading
 * Author      : Anita Mary Joseph
 * Version     : 1.0
 * Date        : 13/10/2023
 ***********************************************************************************************************/
import java.util.Scanner;
public class ShapeDemo {
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter base of the triangle:");
	    float base=sc.nextFloat();
		System.out.println("Enter height of the triangle:");
		float height=sc.nextFloat();
		System.out.println("Enter length of the rectangle:");
		int length=sc.nextInt();
		System.out.println("Enter breadth of the rectangle:");
		int breadth=sc.nextInt();
		System.out.println("Enter radius of the circle:");
		float radius=sc.nextFloat();
		
		Shapes shapes=new Shapes();
		shapes.area(base,height);
		shapes.area(length,breadth);
		shapes.area(radius);
	}

}
class Shapes
{
	public void area(float base,float height)
	{
		System.out.println("Area of triangle with base "+base+" and height "+height+" is "+(0.5*base*height));
	}
	public void area(int length,int breadth)
	{
		System.out.println("Area of rectangle with length "+length+" and breadth "+breadth+" is "+(length*breadth));
	}
	public void area(float radius)
	{
		System.out.println("Area of circle with radius "+radius+" is "+(3.14*radius*radius));
	}
}
