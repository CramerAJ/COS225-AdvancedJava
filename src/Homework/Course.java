//Andrew Cramer
package Homework;

public class Course {
	
	String courseName;									// name of course (ex. COS225)
	String letterGrade;									// letter grade (ex. A)
	int creditHours;									// number of credit hours (ex. 4)
	
	public Course ( )									// POST: construct empty course
	{	courseName = "";
		letterGrade = "";
		creditHours = 0;	}
	
	public Course (String co, String let, int cr )		// PRE: let is A - E, 1 <= cr <= 4
	{	courseName = co;								// POST: construct course from parameters
		letterGrade = let;
		creditHours = cr;	}

	public String getCourseName() {						// POST: return course name
		return courseName;	}

	public void setCourseName(String courseName) {		// POST: set course name
		this.courseName = courseName;	}

	public String getLetterGrade() {					// POST: return letter grade
		return letterGrade;	}

	public void setLetterGrade(String let) {			// PRE: let is A - E
		letterGrade = let;	}							// POST: set letter grade
	
	public int getCreditHours() {						// POST: return credit hours
		return creditHours;	}

	public void setCreditHours(int creditHours) {		// PRE: 1 <= creditHours <= 4 
		this.creditHours = creditHours;					// POST: set credit hours
	}
	
	public String toString ()							// POST: return string on course data
	{	return courseName + " " + letterGrade + " " +  creditHours; }
	
	public double qualityPoints ( )						// POST: return quality points 
	{
		double gpa=0;                                     //gpa credits
		if (letterGrade.equals("A")){
			gpa = 4.0;
		}
		else if(letterGrade.equals("A-")){
			gpa = 3.67;
			} 
		else if(letterGrade.equals("B+")){
			gpa = 3.33;
			} 
		else if(letterGrade.equals("B")){
			gpa = 3.00;
			} 
		else if(letterGrade.equals("B-")){
			gpa = 2.67;
			} 
		else if(letterGrade.equals("C+")){
			gpa = 2.33;
			} 
		else if(letterGrade.equals("C")){
			gpa = 2.00;
			} 
		else if(letterGrade.equals("C-")){
			gpa = 1.67;
			} 
		else if(letterGrade.equals("D+")){
			gpa = 1.33;
			} 
		else if(letterGrade.equals("D")){
			gpa = 1.00;
			} 
		else if(letterGrade.equals("D-")){
			gpa = 0.70;
			} 
		else if(letterGrade.equals("F")){
			gpa = 0.00;
			} 
		
		return creditHours * gpa;		//returns for a number for semester and cumulative methods						
	}
	
	
}
