package ass2;

public class Triangle extends Shape {
	
	protected int side1, side2, side3;
	
	public Triangle(String c, int x, int y, int s1, int s2, int s3)
	{
		super(c, x, y);
		side1 = s1;
		side2 = s2;
		side3 = s3;
	}
	
	public int getSide1()
	{
		return side1;
	}
	
	public void setSide1(int s1)
	{
		side1 = s1;
	}
	
	public int getSide2()
	{
		return side2;
	}
	
	public void setSide2(int s2)
	{
		side2 = s2;
	}
	public int getSide3()
	{
		return side3;
	}
	
	public void setSide3(int s3)
	{
		side3 = s3;
	}
	
	public double perimeter()
	{
		double perimeter = side1 + side2 + side3;
		return perimeter;
	}
	
	public double area()
	{
		 if((side1+side2)>side3 && (side1+side3)>side2 && (side2+side3)>side1)
         {
           double s=(side1+side2+side3)/2;
           double  area=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
           return area;
         }
		 return -1;
	}
	
	public String toString()
	{
		return super.toString() + ", side1: " + side1 + ", side2: " +  side2  + ", side 3:"+ side3;
	}

}
