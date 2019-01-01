package codes;

import java.util.Scanner;

public class Assignment2 {

	public static Scanner input = new Scanner(System.in);
	
	public static final int SIZE = 100;
	public static int[] manta = new int[SIZE];
	public static int choice = 0, check = 0, attempts = 0;
	
//*****************************************************************************************************************
	
	public static int errorTrap()
	{
		int number = 0;
		
		do
		{
			check = 1;
			
			try
			{
				number = input.nextInt();
			}
			catch (Exception e)
			{
				input.next();
				check = 0;
				System.out.println("Invalid input. Please try again");
			}
		} while (check == 0);
		
		return number;
	}
	
	public static void errorTrapRange(int min, int max)
	{
		do
		{	
			check = 1;
			
			try
			{
				choice = input.nextInt();
			}
			catch (Exception e)
			{
				input.next();
				
				check = 0;
			}
			
			if (check == 0 || choice < min || choice > max)
			{
				System.out.println("Invalid input. Please try again");
			}
			
		} while(check == 0 || choice < min || choice > max);
	}
	
	public static void populateSequentially()
	{
		for(int x = 0; x < SIZE; x++)
			manta[x] = x+1;
	}
	
	public static void populateRandomly()
	{
		for(int x = 0; x < SIZE; x++)
			manta[x] = (int)(Math.random()*100)+1;
	}
	
	public static void displayArray()
	{
		System.out.println("\n");
		for(int x = 0; x < SIZE; x++)
		{
			if (manta[x] > 99)
				System.out.print(manta[x] + " ");
			else if (manta[x] > 9)
				System.out.print(manta[x] + "  ");
			else
				System.out.print(manta[x] + "   ");
			
			
			if( (x+1)%10 == 0)
				System.out.println();
		}
	}
	
	public static void shuffleArray()
	{
		//Method 1:
		int randomIndex = 0;
		for(int x = 0; x < SIZE; x++)
		{
			randomIndex = (int)(Math.random()*SIZE);
			int temp = manta[x];
			manta[x] = manta[randomIndex];
			manta[randomIndex] = temp;
		}

		
		
		//Method 2:
		int randomIndex1 = 0;
		int randomIndex2 = 0;
		for(int x = 0; x < 2*SIZE; x++)
		{
			randomIndex1 = (int)(Math.random()*SIZE);
			randomIndex2 = (int)(Math.random()*SIZE);
			
			int temp = manta[randomIndex1];
			manta[randomIndex1] = manta[randomIndex2];
			manta[randomIndex2] = temp;
		}
	}
	
	public static void find()
	{
		int target = 0;
		System.out.print("Please enter a target number: ");
		target = errorTrap();
		int found = 0;
		
		for(int x = 0; x < SIZE; x++)
		{
			if(manta[x] == target)
			{
				System.out.println("Target found at index: " + x);
				found = 1;
				break; // take away break if you want to find every instance of the number
			}
		}
		
		 if(found == 0)
			 System.out.println("The item is not in the list");
	}
	
	public static void checkOrder()
	{
		boolean ascending = true;
		
		for(int x = 0; x < SIZE-1; x++)
		{
			if(manta[x] > manta[x+1])
			{
				ascending = false;
				break;
			}
		}
		if(ascending)
			System.out.println("\nThe list is in ascending order");
		else
			System.out.println("\nThe list is not in ascending order");
	}
	
	public static void shuffleSort()
	{
		boolean ascending = true;
		attempts = 0;
		
		do
		{
			ascending = true;
			
			for(int x = 0; x < SIZE-1; x++)
			{
				if(manta[x] > manta[x+1])
				{
					ascending = false;
					break;
				}
			}
			
			if (!ascending)
			{
				int randomIndex = 0;
				for(int x = 0; x < SIZE; x++)
				{
					randomIndex = (int)(Math.random()*SIZE);
					int temp = manta[x];
					manta[x] = manta[randomIndex];
					manta[randomIndex] = temp;
				}
			}
			
			attempts++;
		} while(!ascending & attempts < 100000);
		
		System.out.println("Attempts = " + attempts);
		
		if (attempts == 100000)
		{
			System.out.println("The array could not be ordered in less than 100000 attempts.");
		}
	}
	
//*****************************************************************************************************************
	
	public static void main(String[] args) throws Exception{
		
		do
		{
			System.out.println("\n\n=================================");
			System.out.println("0. Exit this program.");
			System.out.println("1. Populate the array sequentially.");
			System.out.println("2. Populate the array randomly.");
			System.out.println("3. Display the array.");
			System.out.println("4. Shuffle the array.");
			System.out.println("5. Find an item in the array.");
			System.out.println("6. Check if the array is in ascending order.");
			System.out.println("7. Try to shuffle array back into order.");
			System.out.print("Please enter your choice:");
			
			errorTrapRange(0,7);
			
			if(choice == 1)
				populateSequentially();
			else if(choice == 2)
				populateRandomly();
			else if (choice == 3)
				displayArray();
			else if(choice == 4)
				shuffleArray();
			else if(choice == 5)
				find();
			else if (choice == 6)
				checkOrder();
			else if(choice == 7)
				shuffleSort();
			
		} while(choice != 0);

	}

}