package ass2;

import java.util.*;

public class TestProgram {
	
	final int SIZE=5;

	public static void sort(Sortable[] items)
	{ /*sorts  an array of items in an increasing order as specified in the compareTo() method*/
		for (int i = 1; i < items.length; i++ )
		{
			Sortable key  = items[i];
			int position = i;
			while (position > 0 && items[position-1].compareTo(key) > 0)
				{
					items[position]=items[position-1];
					position--;
				}
			items[position]=key;
		}
	}
	
	public static void show(Sortable[] items)
	{
		for (int i = 0; i < items.length; i++ )
		{
			 if (items[i]!= null)
			 	System.out.print(items[i]);
			}
	}


}
