package Homework;

public class Textbook extends Book {

	private String course;		//new variable for course 

	public Textbook(String t, String a, String i, double w, String c) {
		super(t, a, i, w);
		course = c;			    //converts the course to c 
	}

	public double retailPrice() {   
		return getWholesale() * 1.00;
								//returns the wholesale variable as a decimal
								//multiplies the wholesale by .10 
	}
	public String getcourse() { //returns the course name
		return course;
	}
	public void setmajor(String course) {
		this.course = course;   //returns the course when called by Booklist Generator
	}
}
