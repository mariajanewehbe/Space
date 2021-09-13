package ass2;

public class Circle extends Shape{
	
	private int radius;
	
	public Circle(String c, int x, int y, int r)
	{
		super(c, x, y);
		radius = r;
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public void setRadius(int r)
	{
		radius = r;
	}
	
	public String toString()
	{
		return super.toString() + ", radius: " + radius;
	}
	
	public double area()
	{
		double area = 3.14 * radius * radius;
		return area;
	}
	
	public double perimeter()
	{
		double perimeter = 2 * 3.14 * radius;
		return perimeter;
	}

}
