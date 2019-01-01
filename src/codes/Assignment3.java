package codes;

import java.util.Scanner;

public class Assignment3 {

	public static Scanner input = new Scanner(System.in);
	
	public static final int SIZE = 100;
	public static int[] manta = new int[SIZE];
	public static int mainMenuChoice = 0, target = 0, substitute = 0;	// Inputs
	public static int check = 0, attempts = 0, dummy = 0, counter = 0, found = 0, sum = 0, sumX = 0; // Other
	
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
				System.out.println("\nInvalid input. Please try again");
			}
		} while (check == 0);
		
		return number;
	}
	
	public static int errorTrapRange(int min, int max)
	{
		int choice = 0;
		
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
				System.out.println("\nInvalid input. Please try again");
			}
			
		} while(check == 0 || choice < min || choice > max);
		
		return choice;
	}
	
	public static void populateSequentially() //choice = 1 
	{
		for(int x = 0; x < SIZE; x++)
			manta[x] = x+1;
	}
	
	public static void populateRandomly() //choice = 2
	{
		for(int x = 0; x < SIZE; x++)
			manta[x] = (int)(Math.random()*100)+1;
	}
	
	public static void displayArray() //choice = 3
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
	
	public static void shuffleArray() //choice = 4
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
	
	public static int find(int target) //choice = 5
	{
		/*{
		found = 0;
		
		System.out.print("\nPlease enter a target number: ");
		target = errorTrap();
		
		for(int x = 0; x < SIZE; x++)
		{
			if(manta[x] == target)
			{
				System.out.println("\nTarget found at index: " + x);
				found = 1;
				break; // take away break if you want to find every instance of the number
			}
		}
		
		 if(found == 0)
			 System.out.println("\nThe target is not in the list");
		 }*/
		 
		{
			found = -1;
			
			for(int x = 0; x < SIZE; x++)
			{
				if(manta[x] == target)
				{
					
					found = x;
					break; // take away break if you want to find every instance of the number
				}
			}
			
			return found;
		}
	}
	
	public static boolean checkOrder() //choice = 6
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
		
		return ascending;
	}
	
	public static void shuffleSort() //choice = 7
	{
		boolean ascending = true;
		attempts = 0;
		
		do
		{
			ascending = checkOrder();
			
			if (!ascending)
				shuffleArray();
			
			attempts++;
		} while(!ascending & attempts < 100000);
	}
	
	public static int lowestValue() //choice = 8
	{
		int x = 0;
		
		dummy = manta[x];
		
		do
		{
			if(dummy > manta[x+1])
			{
				dummy = manta[x+1];
			}
			
			x++;
		} while(x < SIZE-1);
		
		return dummy;
	}
	
	public static int highestValue() //choice = 9
	{
		int x = 0;
		
		dummy = manta[x];
		
		do
		{
			if(dummy < manta[x+1])
			{
				dummy = manta[x+1];
			}
			
			x++;
		} while(x < SIZE-1);
		
		return dummy;
	}
	
	public static int numberOccurance(int target) //choice = 10
	{
		counter = 0;
		
		for(int x = 0; x < SIZE; x++)
		{
			if(manta[x] == target)
			{
				counter++;
			}
		}
		
		return counter;
	}
	
	public static void replace(int target, int substitute) //choice = 11
	{
		for(int x = 0; x < SIZE; x++)
		{
			if(manta[x] == target)
			{
				manta[x] = substitute;
			}
		}
	}
	
	public static int greatestSum() //choice = 12
	{
		sum = 0;
		
		for(int x = 0; x < SIZE-9; x++)
		{
			dummy = 0;
			
			for(int counter = 0; counter < 10; counter++)
				dummy += manta[x+counter];
			
			if(dummy > sum)
			{
				sum = dummy;
				
				sumX = x;
			}
		}
		
		return sum;
	}
	
//*****************************************************************************************************************
	
	public static void main(String[] args) throws Exception{
		
		do
		{
			System.out.println("\n\n=================================");
			System.out.println("0.  Exit this program.");
			System.out.println("1.  Populate the array sequentially.");
			System.out.println("2.  Populate the array randomly.");
			System.out.println("3.  Display the array.");
			System.out.println("4.  Shuffle the array.");
			System.out.println("5.  Find an item in the array.");
			System.out.println("6.  Check if the array is in ascending order.");
			System.out.println("7.  Try to shuffle array back into order.");
			System.out.println("8.  Print the lowest value from the list.");
			System.out.println("9.  Print the highest value from the list.");
			System.out.println("10. Find the number of occurances of a target item.");
			System.out.println("11. Replace all instances of an item with your choice.");
			System.out.println("12. Find a consecutive section of the array with the greatest sum.");
			System.out.print("\nPlease enter your choice:");
			
			mainMenuChoice = errorTrapRange(0,12);
			
			if(mainMenuChoice == 1)
				populateSequentially();
			else if(mainMenuChoice == 2)
				populateRandomly();
			else if(mainMenuChoice == 3)
				displayArray();
			else if(mainMenuChoice == 4)
				shuffleArray();
			else if(mainMenuChoice == 5)
			{
				System.out.println("\nPlease enter a target number: ");
					target = errorTrap();
				
				System.out.println("\nTarget found at index: " + find(target) );
			}
			else if(mainMenuChoice == 6)
			{
				boolean ascending = checkOrder();
				
				if(ascending)
					System.out.println("\nThe list is in ascending order");
				else
					System.out.println("\nThe list is not in ascending order");
			}
			else if(mainMenuChoice == 7)
			{
				shuffleSort();
				
				System.out.println("\nAttempts = " + attempts);
				
				if (attempts == 100000)
				{
					System.out.println("\nThe array could not be ordered in less than 100000 attempts.");
				}
			}
			else if(mainMenuChoice == 8)
			{
				System.out.println("\nThe lowest value is: " + lowestValue() );
			}
			else if(mainMenuChoice == 9)
			{
				System.out.println("\nThe highest value is: " + highestValue() );
			}
			else if(mainMenuChoice == 10)
			{
				System.out.print("\nPlease enter a target number: ");
					target = errorTrap();
				
				System.out.println("\nNumber of target occurances in the list: " + numberOccurance(target) );
			}
			else if(mainMenuChoice == 11)
			{
				System.out.print("\nPlease enter a target number: ");
					target = errorTrap();
				System.out.print("\nPlease enter a substitute number: ");
					substitute = errorTrap();
				
				replace(target, substitute);
			}
			else if(mainMenuChoice == 12)
			{
				System.out.println("\nThe greatest sum is: " + greatestSum() );
				System.out.println("Beginning index  x: " + sumX);
			}
				
			
		} while(mainMenuChoice != 0);

	}

}