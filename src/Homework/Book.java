//Andrew Cramer

package Homework;

import java.io.*;
import java.util.Scanner;

public abstract class Book {
	protected String title;		//variable for title
	protected String author;	//variable for author
	protected String ISBNnumber;//variable for ISBN number
	protected double wholesale;	//variable for wholesale

	public Book() {			//identifies what each variable is equal too
		title = "";			//title is a string
		author = "";		//author is a string
		ISBNnumber = "";	//ISBNnumber is a string
		wholesale = 0.0;	//wholesale is a float
	}
	public String getTitle() {				//returns the title variable
		return title;
	}
	public String getAuthor() {				//returns the author variable
		return author;
	}
	public String getISBN() {				//returns the ISBN number
		return ISBNnumber;
	}
	public double getWholesale() {			//returns wholesale when called to 
		return wholesale;					//BooklistGenerator class
	}
	public void setTitle(String title) {	//sets the title from txt file
		this.title = title;
	}
	public void setAuthor(String author) {	//sets the Author variable from txt file
		this.author = author;
	}
	public void setISBN(String iSBN) {	//sets the ISBN number variable taken from the txt file
		ISBNnumber = iSBN;
	}
	public void setWholesale(double wholesale) { //sets the wholesale variable from the txt file
		this.wholesale = wholesale;
	}
	public String toString() {		//returns all the variables in that order
		return (title + " " + author + " " + ISBNnumber + " " + wholesale);
	}									
	public abstract double retailPrice();
	
	public Book(String t, String a, String i, double w) {
		title = t;					//minimizes the variable names		
		author = a;					//used in the Tesbook and Trdaebook class
		ISBNnumber = i;
		wholesale = w;
	}

}
