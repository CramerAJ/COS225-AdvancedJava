//Andrew Cramer
//This program computes temperature statistics 

package Homework;

import java.util.Scanner;
import java.io.*;

public class Homework2part2{

	public static void main(String[] args) throws IOException{
		
		PrintWriter writer = new PrintWriter(new File("windchill-output.txt"));//scans out a new txt file
		
		 
        //list of all used variables
		
		String gap;             //used to mark a break
		String town;            //town variable or location
		String date;            //date variable
		String direction;       //direction of the wind variable
		String tempType;        //temperature cel and fah combined for while loop
		String month = "";      //used for displaying the avg of months
		String otherMonth = ""; //used in to display the months of avg in while loop					
		
		double windspeed;        //variable for windspeed
		double temp;             //variable for temperature
		double tempfahrenheit;   //variable for fahrenheit
		double tempcelsius;      //variable for celsius
		double avgwindspeed = 0; //variable for average windspeed
		double avgfahrenheit = 0;//variable for average fahrenheit
		double avgcelsius = 0;   //variable for average celsisu
		double othertemp = 0;	 //variable for other temp in the method for avgs
		double otherAverage = 0; //variable for other average in method for showing months avg
		int count = 0;
		
		Scanner scan = new Scanner(new FileReader("weather.txt"));		//scans weather.txt file
		Scanner scan2 = new Scanner(new FileReader("averages.txt"));	//scans average.txt file
		
		writer.println("Andrew Cramer");	
		writer.println("COS225 Assg #2");
		writer.println("This program computes temperature statistics\n");
	    writer.printf("%-10s %10s %16s %22s","Town","Date","Wind Speed","Direction");	
		writer.printf("%18s %18s %19s %n","Temp (F)","Temp (C)","Wind Chill");
		writer.println("--------------------------------------------------"+
		"--------------------------------------------------------------------");
		
			
			while (scan.hasNextLine()){			//while loop to display all the variables 
				town = scan.next();			    //displays the town names under the column Town       
				date = scan.next();             //displays the date under Date
				windspeed = scan.nextDouble();  //displays the windspeed under Wind Speed
				direction = scan.next();		//calls the variable direction and puts it under Direction
				temp = scan.nextDouble();	    //uses temp as a base variable for both Fah and Cel
				tempType = scan.next();			//separates the two types of variables cel and fah
						
				if (tempType.equals("C")){		//if the tempType is a C it will print out the celsius number	
					tempcelsius = temp;					
					tempfahrenheit = convCtoF(tempcelsius);
				}
				else {                          //otherwise it will print out F and go through the convFtoC method
					tempfahrenheit = temp;				
					tempcelsius = convFtoC(tempfahrenheit);
				}
				
				writer.printf("%-10s %12s %11s %20s",town, date, windspeed, direction);
				writer.printf("%20.2f %19.2f %18.2f %n", tempfahrenheit, tempcelsius, windChill
				(windspeed, tempcelsius));
				month = monthName(date.substring(0,2));    
				avgwindspeed += windspeed;				//avg windspeed is counting up all the windspeeds
				avgfahrenheit += tempfahrenheit;	    //stating avgfah is counting them one after the other
				avgcelsius += tempcelsius;				//avgcel is counting up all the celsisus readings	
				count++;								
				gap = scan.nextLine();					
			}
			avgwindspeed = avgwindspeed/count;			
			avgfahrenheit = avgfahrenheit/count;			
			avgcelsius = avgcelsius/count;				
			
			writer.println("");
			writer.println("All readings taken for month: "+ month);		 //displays the month name
			writer.println("Number of readings: "+ count);					 //how many readings it took
			writer.printf("Average wind speed: %.2f %n",avgwindspeed);       //average wind speed
		    writer.printf("Average temperature (F): %.2f %n",avgfahrenheit); //average temp of fahrenheit
			writer.printf("Average temperature (C): %.2f %n %n",avgcelsius); //average temp of celsisus
			
			writer.println("Historical Averages");                           
			writer.printf("%-10s %25s %n", "Month", "Temp Average (F)");	 // having it space out neatly 
			writer.println("------------------------------------------");    
			
		
			
			while (scan2.hasNextLine()){			                 //scanning for the averages category  
				otherMonth = scan2.next();			                 //displays the months for averages
				othertemp = scan2.nextDouble();		                 //displays the avg temperature
				writer.printf("%-10s %18s %n",otherMonth,othertemp); //printing out nicely for the user
				if (otherMonth.equals(month)){		                 
					otherAverage = othertemp;		
			}	
			
			}
			scan.close();  // closes the scanner for the while loop
			writer.println("");
			writer.print("The difference this "+ month+ " from historical average is ");
			writer.printf("%.2f",(avgfahrenheit-otherAverage));
		writer.close();
	}
	
		public static String monthName(String curMonth){ //Used to display the months for average
			String month = "";                                  
			if (curMonth.equals("01") )     //displays January and has it equal to currentMonth
				month = "January";
			else if (curMonth.equals("02")) //since currentMonth has output January 
				month = "February";         //it will go to the next else if statement and print out Feruary
			else if (curMonth.equals("03")) //and repeat for all 12 months until all are displayed and stop
				month = "March";
			else if (curMonth.equals("04"))
				month = "April";
			else if (curMonth.equals("05"))
				month = "May";
			else if (curMonth.equals("06"))
				month = "June";
			else if (curMonth.equals("07"))
				month = "July";
			else if (curMonth.equals("08"))
				month = "August";
			else if (curMonth.equals("09"))
				month = "September";
			else if (curMonth.equals("10"))
				month = "October";
			else if (curMonth.equals("11"))
				month = "November";
			else if (curMonth.equals("12"))
				month = "December";
		
			return month;
			
		}
			public static double convFtoC(double tempfahrenheit){  //method for converting Fah to Cel
			double F = tempfahrenheit;
			double C = 5.0/9.0 * (F - 32.0);               //C=celsius and an equation for the conv is made
			return C;                                      //returns the new conv variable of C=celsius
		}
		public static double convCtoF(double tempcelsius){ //method for converting Fahrenheit to Celsius
			double C = tempcelsius;
			double F = 1.8 * C + 32.0;                             
			return F;
		}
		public static double windChill(double windSpeed, double temp){  
			//method for calling windchill and finding it using temp and windspeed
			double s = windSpeed;						
			double t = temp;						
			double W = (33 - ((((10*Math.sqrt(s)) - s + 10.5)*(33-t))/23.1));										
			return W;
		}
		
}
		

