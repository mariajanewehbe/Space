package ass2;

public abstract class Shape implements Sortable {

	protected String color;
	protected int x_coordinate;
	protected int y_coordinate;
	
	public Shape(String c, int x, int y)
	{
		color = c;
		x_coordinate = x;
		y_coordinate = y;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setString(String c)
	{
		color = c;
	}
	
	public int getX()
	{
		return x_coordinate;
	}
	
	public void setX(int x)
	{
		x_coordinate = x;
	}
	
	public int getY()
	{
		return y_coordinate;
	}
	
	public void setY(int y)
	{
		y_coordinate = y;
	}
	
	public String toString()
	{
		return "Color: " + color + ", x coordinate: " + x_coordinate + ", y coordinate: " + y_coordinate + "\n";
	}
	
	public int compareTo(Object o)
	{
		int x = ((Shape) o).getX();
		int y = ((Shape) o).getY();
		if(x == x_coordinate)
		{
			if(y_coordinate == y)
				return 0;
			else
				if(y_coordinate > y)
					return 1;
				else 
					return -1;
		}
		else
			if(x_coordinate > x)
				return 1;
			else
				return -1;
	}
	
	public abstract double area();
	public abstract double perimeter();
}
