package ass2;

public class EquilateralTriangle extends Triangle {

	public EquilateralTriangle(String c, int x, int y, int s1, int s2, int s3)
	{
		super(c, x, y, s1, s2, s3);
	}
	
	public double area()
	{
		double area = (Math.sqrt(3)/4)*side1*side1;
		return area;
	}
	
	public String toString()
	{
		return "Color: " + color + ", x coordinate: " + x_coordinate + ", y coordinate: " + y_coordinate + ", side:" + side1;
	}
	
}
