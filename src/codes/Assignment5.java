package codes;

public class Assignment5 {

	public static final int SIZE = 20;
	public static int[][] manta = new int [SIZE][SIZE];
	public static int sum = 0, dummy = 0;
	public static int greatestX = 0, greatestY = 0;
	
//******************************************************************************************************************
	
	public static void populate()
	{
		for(int x = 0; x < SIZE; x++)
		{
			for(int y = 0; y < SIZE; y++)
			{
				// manta[x][y] = 10*x+y; // populate sequentially
				manta[x][y] = (int)(Math.random()*100); // populate randomly
			}
		}
	}
	
	public static void display()
	{
		for(int x = 0; x < SIZE; x++)
		{
			for(int y = 0; y < SIZE; y++)
			{
				if(manta[x][y] < 10)
					System.out.print(manta[x][y] + "  ");
				else if(manta[x][y] < 100)
					System.out.print(manta[x][y] + " ");
			}
			
			System.out.println();
		}
	}
	
	public static void squareSum()
	{
		sum = 0;
		
		for(int x = 0; x < SIZE-2; x++)	
			for(int y = 0; y < SIZE-2; y++)
			{
				dummy = 0;
				
				for(int counter = 0; counter < 3; counter++)
				{
					dummy += manta[x][y+counter] + manta[x+1][y+counter] + manta[x+2][y+counter];
				}
				
				if(dummy > sum)
				{
					sum = dummy;
					
					greatestX = x;
					greatestY = y;
				}
			}
	}
	
//******************************************************************************************************************
	
	public static void main(String[] args) {
		
		populate();
		
		display();
		
		squareSum();
		
		System.out.println("\nThe greatest sum is: " + sum);
		System.out.println("Beginning index  x: " + greatestX + "  y: " + greatestY);

	}

}