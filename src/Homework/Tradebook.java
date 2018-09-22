package Homework;

public class Tradebook extends Book {

	private String major; //major used as the variable 

	public Tradebook() {  //identifies the variable as a string
		super();
		major = " ";
	}
	public double retailPrice() {
		return getWholesale() * 0;
	}						//multiples the wholesale price of trade books by .15

	public String getmajor() {
		return major;		//returns major when asked by Text and Tradebook
	}
	public void setmajor(String major) {
		this.major = major; //takes the input and sets it to the major variable
	}
	public Tradebook(String t, String a, String i, double w, String m) {
		super(t, a, i, w);
		major = m;		    //major is convert to m for it displaying faster
	}
}
