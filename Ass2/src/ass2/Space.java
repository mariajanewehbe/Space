package ass2;

import java.util.*;
import java.io.*;

public class Space {
	//question 2 is in the 5th choice of the main menu
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		try
		{
			SpaceMethods shapes = new SpaceMethods();
			int choice = 0;
			
			while(choice!=6)
			{
			System.out.println("1.	Add a shape");
			System.out.println("2.	Delete a shape");
			System.out.println("3.	Compute Area and Perimeter");
			System.out.println("4.	Display all");
			System.out.println("5.	Read from file.");
			System.out.println("6.	Exit");
			System.out.println("-------------------");
			System.out.println("Enter your choice:");
			choice = shapes.getNumberFromUser();
			
			switch(choice)
			{
				case 1:
					int c = 0;
					while(c != 4)
					{
						System.out.println("1. Add a circle.");
						System.out.println("2. Add a square.");
						System.out.println("3. Add a traingle.");
						System.out.println("4. Return to main menu.");
						System.out.println("---------------------");
						System.out.println("Enter shape.");
						c = shapes.getNumberFromUser();
						
						switch(c)
						{
							case 1:
								System.out.println("Enter the circle's color.");
								String circle_color = scan.nextLine();
								
								System.out.println("Enter the circle's radius");
								int radius = shapes.getNumberFromUser();
								
								System.out.println("Enter its x-coordinates.");
								int x_circle = shapes.getNumberFromUser();
								
								System.out.println("Enter its y-coordinates.");
								int y_circle = shapes.getNumberFromUser();
								
								Shape s1 = new Circle(circle_color, x_circle, y_circle, radius);
								shapes.addShape(s1);
								break;
								
							case 2:
								System.out.println("Enter the square's color.");
								String color_square = scan.nextLine();
								
								System.out.println("Enter its sides' lengths.");
								int sidelength = shapes.getNumberFromUser();
								
								System.out.println("Enter its x-coordinates.");
								int x_square = shapes.getNumberFromUser();
								
								System.out.println("Enter its y-coordinates.");
								int y_square = shapes.getNumberFromUser();
								
								Shape s2 = new Square(color_square, x_square, y_square, sidelength);
								shapes.addShape(s2);
								break;
								
							case 3:
								System.out.println("Enter the triangle's color.");
								String color_triangle = scan.nextLine();
								
								System.out.println("Enter its x-coordinates.");
								int x_triangle = shapes.getNumberFromUser();
								
								System.out.println("Enter its y-coordinates.");
								int y_triangle = shapes.getNumberFromUser();
								
								System.out.println("Enter the first side.");
								int side1 = shapes.getNumberFromUser();
								
								System.out.println("Enter the second side.");
								int side2 = shapes.getNumberFromUser();
								
								System.out.println("Enter the third side.");
								int side3 = shapes.getNumberFromUser();
								
								if(side1 == side2 && side2 == side3)
								{
									System.out.println("This is an equilateral triangle");
									Shape s3 = new EquilateralTriangle(color_triangle, x_triangle, y_triangle, side1, side2, side3);
									shapes.addShape(s3);
								}
								else
								{
									Shape s3 = new Triangle(color_triangle, x_triangle, y_triangle, side1, side2, side3);	
									shapes.addShape(s3);
								}
								break;
								
							case 4:
								System.out.println("Returning to main menu.");
								break;
								
							default:
								System.out.println("Invalid.");
								break;
						}
					}
					break;
					
				case 2:
					System.out.println("Enter the x and y coordinates of the shape you would like to delete.");
					int x = shapes.getNumberFromUser();
					int y = shapes.getNumberFromUser();
					shapes.deleteShape(x, y);
					break;
					
				case 3:
					System.out.println("Enter the x and y coordinates of the shape you want their area and perimeter calculated.");
					int x1 = shapes.getNumberFromUser();
					int y2 = shapes.getNumberFromUser();
					int index = shapes.searchShape(x1, y2);
					if(index == -1)
						System.out.println("Shape not found.");
					else
					{
						Shape S = shapes.getShape(index);	
						System.out.println("The area of this shape is: " + S.area());
						System.out.println("The perimeter of this shape is: " + S.perimeter());
					}
					break;
					
				case 4:
					for (int i = 0; i<shapes.getCount(); i++)
						System.out.println((shapes.getShape(i)).toString());
					break;
					
				case 5:
					//added this in the main menu for question 2
					File f = new File("Input.txt");
					FileReader fr;
					BufferedReader br = null;
					try {
						fr = new FileReader(f);
						br = new BufferedReader(fr);
						
						String st = br.readLine();
						
						while(st != null)
						{
							Shape shape = null;
							String[] str = st.split(",");
							String type = str[0];
							String color = str[1];
							int xcoord = Integer.parseInt(str[2]);
							int ycoord = Integer.parseInt(str[3]);
							
							if(type.equalsIgnoreCase("Circle"))
							{
								System.out.println("What is the radius of the cirle?");
								int rad = shapes.getNumberFromUser();
								shape = new Circle(color, xcoord, ycoord, rad);
							}
							else
								if(type.equalsIgnoreCase("square"))
								{
									System.out.println("What is the length of the square sides?");
									int sides_sq = shapes.getNumberFromUser();
									shape = new Square(color, xcoord, ycoord, sides_sq);
								}
								else 
									if(type.equalsIgnoreCase("triangle"))
									{
										System.out.println("What are the length of the three sides of the triangle?");
										int s1 = shapes.getNumberFromUser();
										int s2 = shapes.getNumberFromUser();
										int s3 = shapes.getNumberFromUser();
										shape = new Triangle(color, xcoord, ycoord, s1, s2, s3);
									}
									else
										if(type.equalsIgnoreCase("equilateral triangle"))
										{
											System.out.println("What is the equal side of the traingle?");
											int eq_side = shapes.getNumberFromUser();
											shape = new EquilateralTriangle(color, xcoord, ycoord, eq_side, eq_side, eq_side);
										}
										else
											System.out.println("Not a shape.");
							
							shapes.addShape(shape);
							st = br.readLine();
						}
						br.close();
					
						TestProgram.sort(shapes.getArray());
						TestProgram.show(shapes.getArray());
						
						File f2 = new File("output.txt");
						FileWriter fw = new FileWriter(f2);
						BufferedWriter bw = new BufferedWriter(fw);
						
						bw.write(shapes.writeArray());
						bw.close();

					}
					 catch (FileNotFoundException e)
					{
						 System.out.println("There is an error.");
					} 
					catch (IOException e) 
					{
						System.out.println("There is an error.");
					}
					break;
					
				case 6:
					System.out.println("Exiting the program.");
					break;
					
				default:
					System.out.println("Invalid choice.");
					break;
			}
		}
	}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid choice. Enter Again.");
		}
	}
}
