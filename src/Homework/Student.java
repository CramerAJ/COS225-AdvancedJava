//Andrew Cramer
package Homework;

import java.util.ArrayList;

public class Student implements Comparable<Student> {

	String fName;											// first name
	String lName;											// last name
	String studentID;										// student identification number
	int currentCreditHours;									// current credit hours
	double currentQualityPoints;							// current quality points
	ArrayList<Course> courseList;	
	
	public Student ( )										// POST: empty student
	{	fName = "";
		lName = "";
		studentID = "";
		courseList = new ArrayList<Course> ( );
		currentCreditHours = 0;
		currentQualityPoints = 0.0;
	}

	// accessors and mutators
	public String getfName() {	return fName;	}
	public void setfName(String fName) {this.fName = fName;	}
	public String getlName() {	return lName;	}
	public void setlName(String lName) {	this.lName = lName;	}
	public String getStudentID() {	return studentID;	}
	public void setStudentID(String studentID) {	this.studentID = studentID;	}
	public ArrayList<Course> getCourseList() {	return courseList;	}
	public void setCourseList(ArrayList<Course> courseList) {	this.courseList = courseList;	}
	public int getCurrentCreditHours() {	return currentCreditHours;	}
	public void setCurrentCreditHours(int currentCreditHours) {
		this.currentCreditHours = currentCreditHours;	}
	public double getCurrentQualityPoints() {	return currentQualityPoints;	}
	public void setCurrentQualityPoints(double currentQualityPoints) 
	{	this.currentQualityPoints = currentQualityPoints;	}
	
	public String toString ( )								// POST: return string of data
	{	return fName + " " + lName + " " + studentID + "\nCourses: " + courseList.toString();   
	}
	
	public void addCourse (Course c)						// POST: add course list of courses
	{
			courseList.add(c);								// write code
	}
		
	public int compareTo (Student other)					// POST: return 0 if equal, neg # is less, pos # if greater
	{	
		int stid = Integer.parseInt(studentID);                //checks if both stid and stidfile are the same
		int stidfile = Integer.parseInt(other.getStudentID()); //and if yes returns 0
		if( stid==stidfile)
			return 0;	
		else if(stid<stidfile)								//returns -1 if stid is less than the file data
			return -1;
		else
			return 1;										//outputs 1 if stidfile is less than stid
															// write correct code
	}
	
	public double semesterGPA ( )							// POST: return semester GPA
	{
		double creditpoint = 0;									//creditpoint changes based on the letter grade
		int creditHours=0;										//credit hours 0 for now then added onto
		for (int i=0; i < courseList.size(); i++){
			creditHours += courseList.get(i).getCreditHours();	//for creditHours gets it from the file
			creditpoint += courseList.get(i).qualityPoints();	//gets the quality points from the file
		}
		
		return creditpoint/creditHours;											
	}
	
	public double cumulativeGPA ( )							// POST: return new cumulative GPA factoring in this semester
	{
		int semestercredithours = 0;                                        //semester credit hour variable
		double cumulativeGPA;												//cumulative GPA variable as a double
		double currentcumulativequalitypoints = getCurrentQualityPoints();	//current quality point variable
		double currentcumulativecredithours = getCurrentCreditHours();		//current credit hour variable
		double semesterqualitypoints = 0;									//double for semester quality points since each number on the file is different
		for (int i = 0; i < courseList.size(); i++){
			semestercredithours += courseList.get(i).getCreditHours();
			semesterqualitypoints += courseList.get(i).qualityPoints();
		}
		return cumulativeGPA = (currentcumulativequalitypoints+				//takes the quality and semester quality and added together
				semesterqualitypoints)/
				(currentcumulativecredithours+								//takes the credit hours and the semester credit hours added together
				semestercredithours);										//returns the cumulativeGPA variable
	}
}