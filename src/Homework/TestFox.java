//Andrew Cramer
//this program computes a Fox Game
package Homework;

import java.util.Scanner;

public class TestFox {

	static FoxGame game = new FoxGame(); // New Fox Game

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);							 // Scanner for user commands
		String item; 													 // String item for variables in FoxGame method

		boolean play = true;
		while (play) {													 // while the game is not lost
			printLocations();
			System.out.println();

			do {

				System.out.print("Enter the item to transport (fox, chicken, grain, none) : ");
				item = scan.nextLine();									//scans the input item to check and see 
				if (game.found(item)) {									//if its a valid item from the other class methods
					game.transport(item);								//if it is it will transport the item over to the
					break;												//other linked list
				} else if (game.southBank.contains(item)
						|| game.northBank.contains(item)) {				//other wise it will tell the user to enter a new item
					System.out.println(item + " does not exist on the "
							+ game.getFarmerBank() + " bank");
					break;
				} else {
					System.out.println(item + " is not a valid item");
				}
			} while (true);												//if the game is won it will close the program

			if (game.won() == true) {
				break;
			} else if (game.lost() == true) {							//if the game is lost it will close the program
				break;
			}

		}

		System.out.println("Game is over\n");							//outputs the game is over
		printLocations();
		if (game.lost())
			System.out.println("You lost");								//if game.lost is true will print this line
		else if (game.won())
			System.out.println("You win!");								//if game.won is true will print this line

		scan.close();
	}

	public static void printLocations() {								//prints the end results of either a winning combination
		System.out.println("Farmer location: " + game.getFarmerBank());	// or a losing combination of the linked list items
		System.out.println("South bank contains: " + game.displaySouthBank());
		System.out.println("North bank contains: " + game.displayNorthBank());
	}
}