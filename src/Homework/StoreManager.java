//Andrew Cramer

package Homework;

import java.text.NumberFormat;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StoreManager {

	public static void main(String [] args) throws IOException{
		Scanner scan = new Scanner(System.in);
		Scanner file = new Scanner(new FileReader("inventory.txt")); //scans the data from a text file to process the variables
		String letter= " ";											 //letter is the users input variable to have a certain action
		
		Inventory invent= new Inventory();			//invent is the new variable abbreviation for the Inventory class
		Product p= null;							// variable p is the product class calling the data
		
	
		while (file.hasNext()){						//while loop used to restart the sequence after the user's action command
			p = new Product(file.next(),file.nextInt(), file.nextDouble());
			invent.insert(p);	
		}
		while (!letter.equals("Q")){								//loop used to display the commands after each input by the user
		System.out.println("Enter choice from menu: (Q to Quit): ");//Asks the user for an input from the list below
		System.out.println("D to Display");							//Tells the user D to Display the data
		System.out.println("I to Insert");							//Tells the user I to insert a new variable
		System.out.println("R to Remove");							//Tells the user R is to remove a variable
		System.out.println("E to Edit amount in Stock");			//Tells the user E to edit a variable on the data

		letter = scan.next();					//Scans the letter chosen by the User
	
		if (letter.equalsIgnoreCase("D")){										//D command displays the data in a formated table
			System.out.println("Name       Amount       Unit Price     Worth");	//Displays the table Names
			for (int k = 0; k < invent.getSize(); k++){							//For loop to scan through the txt.file
				NumberFormat dollar = NumberFormat.getCurrencyInstance();		//And recall each set of data to a different variable name
				String name = invent.getValue(k).getName();						//String name looks for a String to recall it out
				int amount = invent.getValue(k).getAmount();					//Looks for the first integer to follow a string
				double price = invent.getValue(k).getPrice();					//looks for the next float to be called price		
				double worth = (amount*price);									//worth is a new variable of amount times price
				System.out.printf("%-8s    %d   \t%s        \t%s\n", name, amount, dollar.format(price), dollar.format(worth));
			}																	//Out puts all the variables in a table
		}
		
		else if (letter.equalsIgnoreCase("Q")){	
			System.out.println("Thanks you. Good bye");		//If the user presses Q it will close the program
			System.exit(0);									//used to test earlier if the program would quit before starting
															//other else if statements
		}
		else if (letter.equalsIgnoreCase("I")){									//I allows the use to insert a new variable name
			System.out.println("Enter new product name, amount, and unit price:  ");//Asks the user the variable name amount and price
			String name = scan.next();								//scans the first string to be called Name
			int amount = scan.nextInt();							//scans the first integer to be called amount
			double price = scan.nextDouble();						//scans the the next float to be called price
			p = new Product ( name, amount , price);				//calls the class product to insert the new variables
			if (invent.search(p) != -1){							//If name is already found it will tell the user it can't be inserted
				System.out.println("Product " + name + " is already found");
			}
			else { 													//if it isn't found it will then call the product array
				invent.insert(p);
				System.out.println("Product " + name + " is inserted");
			}
		}
		else if (letter.equalsIgnoreCase("R")){					//Same format as insert except when it is found it will 
			System.out.println("Enter product name to remove: ");//it will delete it from the index
			String name = scan.next();
			p = new Product ( name,0,0) ;						//looks for product in the list
			int index = invent.search(p);							
			if (index == -1){									//if it isn't found it will tell the user its not found
				System.out.println("Product " + name + " is not found");
			}
			else { 												//if the index is found it will remove it from the inventory list
				invent.remove(index);
				System.out.println("Product " + name + " is removed");
			}
		}
		else if (letter.equalsIgnoreCase("E")){					//Scans the index for a product name the user wants to find
			System.out.println("Enter product name to edit: ");
			String name = scan.next();
		    p = new Product(name, 0, 0);						//if the name is recognized in the Product class
		    int index = invent.search(p);						//it will go to the else statement giving the option to change
		    if (index == -1)									//the variable amount to a different input the user wants
		     System.out.println("Product " + name
		       + " is not found. ");
		    else {																	
		     System.out.println("Enter change in amount +/-: ");//tells the user to enter a new amount 
		     int change = scan.nextInt();						//scans the new int variable and stated to be change
		     p = invent.getValue(index);						//calls the inventory class to implement a change to the class
		     p.setAmount(p.getAmount() + change);				//out puts the new amount to the inventory array
		     													//as well as doing the calculation for the new worth variable 
		     System.out.println("Product " + name + " is stock is edited.");
		     
		     //wasn't sure if we also wanted them to change the price
		     //but would be another else statement calling the variable price and allow for a change by the user
		    }
		}
		
	
		
		}
	}
}
