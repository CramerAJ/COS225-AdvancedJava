//Andrew Cramer

package Homework;

import java.text.NumberFormat;
import java.util.Stack;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Parker {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner file = new Scanner(new FileReader("lot.txt"));
		NumberFormat money = NumberFormat.getCurrencyInstance();
		Car c;
		
		Stack<Car> lot = new Stack<Car>();				//stack of the alley as lot
		Stack<Car> street = new Stack<Car>();			//stack of the street
		
		double parking = 0;							    //fee for the allay as parking
		double meter = 0;								//fee for the street meter
		
		int carCount=0;									//counter for how many cars can be in the lot
		System.out.println("Parking Report");			//Name of assignment
		System.out.println("By Programmer: Andrew Cramer\n");

		
		while (file.hasNext()) {						//while loop for scanning the file
			String park = file.next();					//scans the first letter for A or D
			String license = file.next();				//scans the next thing and equals it to license
			String time = file.next();					//scans the next item and equals it to the time
			c = new Car(license, new Time(time));		//c is equal to license and time to equal
			if (park.equals("A")) {						//if A it knows its an arrival
				if(carCount < 5){						//keeps track of how many cars are in the stack
					lot.push(c);						//pushes the car onto the stack
					carCount++;							//and adds 1 onto the counter up to 5 spots
					System.out.println(c.getLicense()+ " parked at " + c.getTime()); //outputs the arrival of the car
				}
				else {									//If the stack is full it will display that the Lot is Full
					System.out.println(c.getLicense() + //if the lot stack is full the car is turned away
							" was turned away at "+c.getTime() + " - LOT IS FULL!");
				}	
			}
			else if (park.equals("D")) {				//If D for departure it will remove a cars from the stack
				while ( c.compareTo(lot.peek())<0){		//counts how many pops are from the lot stack to determine the meter cost
					street.push(lot.pop());
					meter += .25;						//adds .25 cents each pop
				}
				Time preTime = lot.pop().getTime();		//keeps track of the cost of Arrivals overtime to determine a cost
				while(!street.isEmpty()){				//while the stack is not empty it will push cars into the lat and off the street
					lot.push(street.pop());
				}
				carCount--;								//does a minus count to keep track of number of cars in the alley lot stack
				double payment = fees(preTime,c.getTime());	//never variable payment of parking and preTime to have the payments
				parking += payment;							
				System.out.println(c.getLicense()+ " left at " + c.getTime() +
						" paying " + money.format(payment));
			}
		}
		System.out.println("");
		System.out.println("Parking fees generated: " + money.format(parking));//generates the payment of parking in the alley lot
		System.out.println("Street meter fees paid: " + money.format(meter));  //generates the payment of parking on the street meters
	}

	public static double fees(Time in, Time out) {	//method for fees of parking in the lot 	
		int min = out.subtract(in);					
		int hours = min / 60;						//hour equals 60 min
		if (min % 60 > 0)							//if min is greater than 60 than it counts as two hours
			++hours;
		return 4.50 * hours;						//returns the cost of number of hours times 4.5
		
	}

}
