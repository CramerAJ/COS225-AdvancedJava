//Andrew Cramer

package Homework;

public class Product {

	private String name;  //variable for data that is a string on the txt.file
	private int amount;	  //looks for the next integer in the txt.file to be an amount variable
	private double price; //looks for the next integer or float variable to be called to price double

	public Product() {	  //states that the Product() contains all the information taken by the txt.file
		name = "";
		amount = 0;
		price = 0;
	}
	public Product(String s, int a, double p) {	//changes the name of the variables
		name = s;								//makes it easier when calling other methods or classes
		amount = a;
		price = p;
	}
	public void setName(String name) {		//Sets the string taken by the txt.file to the name variable
		this.name = name;
	}

	public void setPrice(double price) {	//Sets the integer to the price variable 
		this.price = price;
	}
	public void setAmount(int amount) {		//Sets the integer to the amount variable when scanned previously 
		this.amount = amount;
	}
	public double getPrice() {  //allows the StoreManager to call the price for display
		return price;
	}
	public int getAmount() {  	//Allows the StoreManager class to call the information of the amounts 
		return amount;			//Returns the amount taken from the txt.file 
	}
	public String getName() {	//Returns the Names from the txt.file
		return name;
	}
	

}
