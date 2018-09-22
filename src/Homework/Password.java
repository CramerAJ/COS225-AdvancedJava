//Andrew Cramer

package Homework;

import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;

public class Password {
	
	private String password =" ";	//private password so it can't be changed when stored
	
	public Password(){				//public method for password
		password = " ";
	}

	public String getPassword(){	//gets the password from the file
		return password;
	}
	
	public void setPassword(String password) throws InvalidPasswordException{	//POST:
		if (!isValid(password)) 
			throw new InvalidPasswordException();
		this.password = password;
		
	}

	private boolean isValid(String password) {
		
		if (password.length()<6)
			return false;
		TreeSet<String> upper = new TreeSet<String>();
		TreeSet<String>	lower = new TreeSet<String>();
		TreeSet<String>	digits = new TreeSet<String>();
		
		for (char c='0'; c<= '9'; c++)					//validates all number
			digits.add(String.valueOf(c));
		for (char c='A'; c<= 'Z'; c++)					//validates all upper case letters
			upper.add(String.valueOf(c));
		for (char c='a'; c<= 'z'; c++)					//validates all lower case letters
			lower.add(String.valueOf(c));
		
		digits.add("!");								//as well as the specified ones
		digits.add("_");
		digits.add("%");
		digits.add("#");
		digits.add("?");
		
		boolean lowerlet = false;
		boolean dig = false;
		boolean upperlet = false;
		
		for (int i=0; i<password.length(); i++){		//for loop for checking if the user's entry is valid
			String letter = password.substring(i,i+1);
			
			if(!lower.contains(letter) && (!digits.contains(letter)&& !upper.contains(letter))){
				return false;
			}
			if (upper.contains(letter)){				//returns as long as it is within the correct character list
				upperlet=true;
			}
			if (lower.contains(letter)){
				lowerlet = true;
			}
			if (digits.contains(letter)){
				dig = true;
			}
			if (upperlet == true)
				if (lowerlet ==true)
					if (dig==true)
						return true;
		}
		return false;
	}

	
}
