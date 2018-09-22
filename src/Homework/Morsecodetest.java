//Andrew Cramer
package Homework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Morsecodetest {
	
	public static void main (String[]args) throws FileNotFoundException{
		TreeNode<String> root = new TreeNode<String> (); 
		TreeNode<String> current;
		TreeNode<String> temp;
		
		Scanner filier = new Scanner(new FileReader ("morsecode.txt"));
		Scanner user = new Scanner(System.in);
		
		String letter;												//string for the first char on the morse file
		String line;												//scans the rest of the line
		String morse;												//string morse is for the inside scanner for the array
		
		String [] alphabet = new String[26];						//array alphabet that holds the letters and the commands
			
		while(filier.hasNextLine()){								//while filier has something to scan
			current = root;											//changes the current to be the root to traverse
			String Full = "";										
			line = filier.nextLine();
			Scanner insidescanner = new Scanner(line);				//uses this to scan the morse to each letter
			
			letter = insidescanner.next();							//letter than has a scanner for the command it has on the file						
			temp = new TreeNode<String> (letter);
			
			while(insidescanner.hasNext()){							//while insidescanner has something to scan(creating a tree)
				morse = insidescanner.next();						//the commands are first scanner
				Full += morse + " ";								//than placed to each letter
				
				if (morse.equals("o")){								//decides whether its a left or right command
					if (current.getLeft() == null){					//if its left it sets to it left and equals to null 
						current.setLeft(temp);						//repeats this for all left commands in morse
					}
					else{											
						current = current.getLeft();
					}
				}
				else{												//otherwise it will place the letter to the right to create a tree
					if (current.getRight() == null){
						current.setRight(temp);
					}
					else{
						current = current.getRight();
					}
				}
			}	
			
			insidescanner.close();									//closes the scanner
																	//a tree has now been created
			char charact = letter.charAt(0); 						//each command now corresponds to that letter
			int ascii = (int) charact-97; 							//or series of commands to get to a certain letter
			alphabet[ascii] = Full; 								//the array is now FULL
		}
		
		
		System.out.print("Preorder tree contents: ");				//displays the array in order
		preorder(root);												//starting with the root e than t etc.
		
		System.out.print("\nEnter English message: ");				//asks the user for a input of words
		String message = user.nextLine();
		
		
		String morseoutput = "m = ";								//displays the morse here
		String DONE = "";											
		
		Scanner code = new Scanner(message);						//new scanner for outputting the morse code for each letter
		code.useDelimiter("");										
			
		while(code.hasNext()){										//while it has something to scan
			String value = code.next();								//new variable value is the next item code scans
			
			if (!(value.equals(" "))){								//if the value equals something
				char ltr = value.charAt(0);							//it than looks to the character
				int index = (int) ltr - 97;							//and finds the morse commands to traverse the tree to find it
				String morseCode = alphabet[index];					//and looks through the array for the letter it found
				
				morseoutput += morseCode + "| ";					//breaks the morse code with a | for each letter
				
				Scanner convert = new Scanner(alphabet[index]);		//looks through the array index

				String i = "";									

				current = root;
				while(convert.hasNext()){
					morse = convert.next();
					
					if (morse.equals("o")){					//if its a "o" it scans left next
						current = current.getLeft();
					}
					else{									//otherwise it goes left
						current = current.getRight();
					}
				}	
				i = current.getElement();
				DONE += i + " ";
				convert.close();							//closes the scanner
			}
		}
		System.out.println(morseoutput);
		System.out.println("Message: " + DONE);
		
		code.close();									//closes the scanner
		user.close();									//closes the user input scanner
		filier.close();									//closes the file scanner
		

	}
	
	public static void preorder(TreeNode<String> node){	
		
		if (node.getElement() != null){						//as long as its not empty will output 
			System.out.print(node.getElement() + " ");}
		if(node.getLeft() != null){							//while the tree is not empty to the left will keep going
            preorder(node.getLeft());}
        if(node.getRight() != null){						//while not right is empty will keep going
            preorder(node.getRight());}
	}
	

}