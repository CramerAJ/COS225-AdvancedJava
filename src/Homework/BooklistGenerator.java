//Andrew Cramer

package Homework;

import java.io.*;
import java.text.DecimalFormat; //decimal formatter
import java.util.Scanner;
import java.io.FileReader;

public class BooklistGenerator {

	public static void main(String[] args) throws IOException {
		DecimalFormat dm = new DecimalFormat("$0.00");	//formats the outputs of the floats
		
		Scanner file = new Scanner(new FileReader("books.txt")); //scans the file
																
		Scanner scan = new Scanner(System.in);	//scans the users input
		Book[] book = new Book[100];	//size of the array
		int k = 0;			
		double wholesale;
		String title;			//variable for title
		String author;			//variable for author
		String ISBNnumber;		//variable for ISBN number
		String type;			//variable for type of book
		String course;			//variable for the course name

		while (file.hasNext()) {	      //while loop that scans the file until all data is taken in
			type = file.nextLine();	      //scans the first line which is identified as the type of book
			title = file.nextLine();      //scans the next line and calls that data the title variable
			author = file.nextLine();     //next line is called as the author variable when scanned
			ISBNnumber = file.nextLine(); //next line is identified to the ISBN number
			wholesale = file.nextDouble();//next line is called as the wholesale price
			String nothing = file.nextLine();//since there is a break in the txt file this scans the line
											 // and returns nothing
			course = file.nextLine();	     //next line is called as a course variable 	

			if (type.equals("Tradebook")) {	//looks at the first variable type
											// and if its Tradebook it outputs all variables that
											// have Tradebook as well as the correct data that go with each
											//Tradebook
				book[k] = new Tradebook(title, author, ISBNnumber, wholesale,
						course);
			} else if (type.equals("Textbook")) {
											//otherwise it will see Textbook and output
											//the data that fits with Textbook
				book[k] = new Textbook(title, author, ISBNnumber, wholesale,
						course);
			}
			k++;							//counter used for Book array to allow the while loop 
											//to hit the maximum number of array slots
		}				
		file.close();						//closes the file scanner for FileReader

		String[] coursename = new String[10];  //coursename is a new variable that relates to the users input
		System.out.print("Enter your major: ");//asks the user major
		String userMajor = scan.next(); 	   //scans the input which will apply to the outputs
		String userCourse = ""; 		       //of Tradebooks
		System.out.println();

		for (int l = 0; l < coursename.length; l++) {//for loop which will keep asking for course name
			System.out.print("Enter course name: (xxx to quit): ");
			userCourse = scan.next();				 //and scans the input used to pop up data textbooks
			if (userCourse.equals("xxx")) {			 //for the course
				break;								 //if the user inputs "xxx" then the loop will break or close	
			}
			coursename[l] = userCourse;				 //course array closing after the loop closes
		}
		
		
		//formats the floats of the txt fill
		System.out.println("\nList of textbooks: ");
		double totalPrice = 0;  //total price is 0 at the start
		for (int j = 0; j < book.length; j++)  //for loop for outputting all the textbooks 
		{
			if (book[j] instanceof Textbook)  //if the array holds this textbook
			{ 
				for (int p = 0; p < coursename.length; p++) //loop that output all data
				{											//that relates to the coursename given by the user
					if (((Textbook) book[j]).getcourse().equals(coursename[p]))
					{
						System.out.printf("%-8s%-50s\t%-15s\t%14s\n", //print f formats it nicely for the user
								((Textbook) book[j]).getcourse(),book[j].getTitle(), book[j].getAuthor(),
								dm.format(((Textbook) book[j]).getWholesale())); //dm.format used for the floats
						totalPrice += book[j].retailPrice();	//adds all the prices to a total price
					}
				}
			}
		}
		System.out.printf("Sum of retail book prices:%68s\n",
				dm.format(totalPrice)); //displays the total price of all the textbooks
		System.out.println("\nList of tradebooks: ");
		for (int j = 0; j < book.length; j++) //for loop that outputs all the trade books
		{									  //that apply to the major the user inputed
			if (book[j] instanceof Tradebook) 
			{
				if (((Tradebook) book[j]).getmajor().equals(userMajor)) 
				{							//displays all the Tradebooks that are applying to the user
											//inputed major variable
					System.out.printf("%-50s\t\t%-20s\t%s\n",book[j].getTitle(), book[j].getAuthor(),
							dm.format(((Tradebook) book[j]).getWholesale()));
				}			//output the 
			}
		}
		scan.close();           //closes the scanner for user input
	}

}