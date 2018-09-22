//Andrew Cramer
package Homework;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

import java.io.FileReader;
import java.io.*;

public class PasswordManager {
public static void main(String[] args) throws IOException, InvalidPasswordException{
		
		TreeMap<String, Queue<String>> info = new TreeMap<String, Queue<String>>();
		
	
		Scanner input = new Scanner(System.in);							//scanner for user input
		Scanner txtfile = new Scanner(new FileReader("userids.txt"));	//scanner for the text file
		String userid = "";												//string for the userid
		String password;												//string for the password
		
		while(txtfile.hasNextLine()){								    //while loop for scaning the text file
			Scanner whilescanner = new Scanner(txtfile.nextLine());		//scanner for the while loop seperate from others
			password = whilescanner.next();								//scans the first entry as the username
			Queue <String> que = new LinkedList<String>();				//uses a linked list connect to a toString
			String newentry = whilescanner.next();						//scans the next entry of passwords
			
			if(whilescanner.hasNext()){ 								//if it has something scans 
				String nextpassword = whilescanner.next();				//scans extra passwords on the line
				if(whilescanner.hasNext()){								//if the whilescanner has something
					String originalPW = whilescanner.next(); 			//looks for the first on the line					
					que.add(originalPW);								//and adds it to the linked list
				}
				que.add(nextpassword);									//and adds the next one scanner
			}
			
			que.add(newentry);
				
			info.put(password, que);									
		}
		
		System.out.println(info.toString());							//out puts the information from the toString
			
		while(!(userid.equals("*"))){									//if the user does not input a quit 
			boolean workingpw = false;									
			System.out.print("userid (* to quit): ");
			userid = input.next();										//it will then scan the linked list for userids
			
			if(info.containsKey(userid)){								//if it finds a match
				System.out.print("current password: ");					//it will ask for the current password
				String userpassword = input.next();						
				
				String listpassword = "";								//if the password is a match
				for(String k : info.get(userid)){
					listpassword = k;
				}
				
				if(listpassword.equals(userpassword)){								
					Password pw = new Password();						//than allow the user to enter a new password
					
					while(workingpw == false){
						System.out.print("new password: ");				
						String newpassword = input.next();				//scans the user input s a new password
						
						try{
							pw.setPassword(newpassword);					
							
							if(info.get(userid).contains(newpassword)){	//if the password was already on the list
								System.out.println("** password already has been used **");
							}											//states its invalid
							else{
								info.get(userid).remove();				//if it is not taken state the password has been changed
								info.get(userid).add(pw.getPassword());
								System.out.println("** password changed! **");
								System.out.println("");	
								
								workingpw = true;					
							}
						}
						catch(InvalidPasswordException e){
							System.out.println(e.toString());
						}
					}
					
					workingpw = true;
				}
				else{													//if the userid was a match but not hte password
					System.out.println("** password incorrect for userid " + userid + " **");
					System.out.println("");								//than output it to the user
				}
			}
			else{
				if(!(userid.equals("*"))){								//if the userid was not true then state it to the user
					System.out.println("** userid not found **");
					System.out.println("");}
			}
		}
		
		System.out.println(info.toString());
		input.close();	 //closes the user input scanner
		txtfile.close(); //closes the file reading scanner
	}
	
	
}