//Andrew Cramer
package Homework;

public class InvalidPasswordException extends Exception{
	
	private static final long serialVersionUID = 1L; //stops warnings
	
	public String toString(){			//to string for invalid password and returns as such
		return "**Invalid Password**";
	}
	

}
