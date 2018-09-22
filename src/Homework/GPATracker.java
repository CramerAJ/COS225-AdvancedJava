//Andrew Cramer

package Homework;

import java.io.FileNotFoundException;									//imported for catch statement to check the file input by user
import java.io.FileReader;												//import FileReader to scan the file
import java.util.ArrayList;												//imported for the array
import java.util.Collections;											//imported for sorting the output statements
import java.util.Scanner;


public class GPATracker {
	
	public static void main(String[]args){
		Scanner scan = new Scanner(System.in);							//scanner for user input
		Scanner file = null;											//null since the file doesn't exist yet
		ArrayList<Student> student = new ArrayList<Student>();			//ArrayList for the variable student
		String fileuser = ""; 											//file name given by the user
		boolean invalid = true;											//looks at the user input for a valid answer
																		//if it was false it would be a double negative
		System.out.println("Andrew Cramer");
		System.out.println("GPA Tracker\n");
		do{
			System.out.print("Enter the name of student file: ");
			fileuser = scan.nextLine();
			try{
				file = new Scanner (new FileReader(fileuser));			//file scanner for reading the txt.file
			}
			catch (FileNotFoundException e) {							//checks for the input of the Exception
																		//tells the user if the txt.file was valid or not
				System.out.println("File " + fileuser +" is not found");
				
			}
			finally{													//if the input is valid then it will continue
				if (fileuser.equals("students.txt")){					
					invalid = false;									//if invalid input will run again due to while loop at bottom
				}	
			}
		}while(invalid);												//asks the question again until valid input
		scan.close();													//closes the scanner
		while(file.hasNext()){
			Student i = new Student();
			   i.setlName(file.next());						//scans the first string to be called last name
			   i.setfName(file.next());						//scans the second string to be called first name
			   i.setStudentID(file.next());					//scans the next piece to be called to the 
			   i.setCurrentCreditHours(file.nextInt()); 	//scans next to be called to CurrentCreditHours
			   i.setCurrentQualityPoints(file.nextDouble());//scans next to int to qualitypoints
			   file.nextLine();								
			   
			   Scanner line = new Scanner(file.nextLine());	//new scanner for counting the total number of courses for each student
			   while(line.hasNext()){						//while loop used to check the course classes for each student on the file				
			    i.addCourse(new Course(line.next(), line.next(), line.nextInt()));
			   }
			   student.add(i);
		  }
		  
		  Collections.sort(student); 							        //sorts the array list for the user
		  
		  for(Student o: student){                                      //for loop for the outputs scanned off the file
		   System.out.println(" ");
		   System.out.println(o.toString());                            //outputs the string of first name and last name
		   System.out.printf("Current Cumulative GPA: %.2f", o.getCurrentQualityPoints()/o.getCurrentCreditHours());
		   System.out.printf("\nSemester GPA: %.2f" , o.semesterGPA()); //outputs the gpa from the semesterGPA method
		   System.out.printf("\nNew Cumulative GPA: %.2f" , o.cumulativeGPA()); //outputs from cumulativeGPA
		   System.out.println();
		  }
	}
}