package ass2;

import java.util.*;

public class SpaceMethods {
	
	Shape[] s;
	static int count = 0;
	

	public SpaceMethods()
	{
		s = new Shape[5];
	}
	
	public Shape[] getArray()
	{
		return s;
	}
	
	public String writeArray()
	{ //this method is for writing in file
		String write = "";
		for(int i = 0; i<count; i++)
			write += s[i].toString() + "\n";
		return write;
	}
	
	public int getCount()
	{
		return count;
	}
	
	public void increaseSize()
	{
		Shape [] temp = new Shape[(s.length)+1];
		for (int i = 0; i<s.length; i++)
			temp[i]=s[i];
		s = temp;
	}
	
	public void addShape(Shape s1)
	{
		if(count==s.length)
			increaseSize();
		s[count] = s1;
		count++;
	}
	
	public Shape getShape(int i)
	{
		return s[i];
	}
	
	public int searchShape(int x, int y)
	{
		int index = -1;
		for (int i =0; i<count; i++)
		{
			if (x == s[i].getX() && y == s[i].getY())
					index = i;
		}
		return index;
	}
	
	public void deleteShape(int x, int y)
	{
		int toDelete = searchShape(x,y);
		if(toDelete == -1)
			System.out.println("Shape not found.");
		else 
		{
		s[toDelete] = s[count - 1];
		count--;
		System.out.println("The shape is deleted.");
		}
	}
	
	
	public int getNumberFromUser() 
	{
		Scanner scan = new Scanner(System.in);
		try {
			String s = scan.next();
			return Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			System.out.println("Incorrect. Please try again.");
			return getNumberFromUser();
			
		}
	}

}
