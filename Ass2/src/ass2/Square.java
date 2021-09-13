package ass2;

public class Square extends Shape {
	
	private int side_length;
	
	public Square(String c, int x, int y, int side)
	{
		super(c, x, y);
		side_length = side;
	}
	
	public float getSideLength()
	{
		return side_length;
	}
	
	public void setSideLength(int side)
	{
		side_length = side;
	}
	
	public String toString()
	{
		return super.toString() + ", sides' length: " + side_length;
	}
	
	public double area()
	{
		double area = side_length * side_length;
		return area;
	}
	
	public double perimeter()
	{
		double perimeter = 4 * side_length;
		return perimeter;
	}

}
