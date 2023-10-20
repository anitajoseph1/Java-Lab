/************************************************************************************************************
 * File        : Polymorphism.java
 * Description : To find number of sides in a given geometrical structure.
 * Author      : Anita Mary Joseph
 * Version     : 1.0
 * Date        : 20/10/2023
 ************************************************************************************************************/
public class Polymorphism {
	public static void main(String [] args)
	{
		Rectangle rectangle=new Rectangle();
		Triangle triangle=new Triangle();
		Hexagon hexagon=new Hexagon();
		rectangle.numberOfSides();
		triangle.numberOfSides();
		hexagon.numberOfSides();
	}

}

abstract class Shape
{
	abstract public void numberOfSides();
}
class Rectangle extends Shape
{
	public void numberOfSides()
	{
		System.out.println("Number of sides of a Rectangle is 4");
	}
}
class Triangle extends Shape
{
	public void numberOfSides()
	{
		System.out.println("Number of sides of a Triangle is 3");
	}
}
class Hexagon extends Shape
{
	public void numberOfSides()
	{
		System.out.println("Number of sides of a Hexagon is 6");
	}
}