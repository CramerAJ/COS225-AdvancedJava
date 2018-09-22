//Andrew Cramer

package Homework;

public class Car {
	
	private String license;			//license variable
	private Time time;				//time variable used to record in and out times

	public Car (){					//empty Car constructor 
		license = "";
		time  = new Time();
	}
	public Car (String o , Time t){	//parameterized constructor 
		license = o;
		time = t;
	}
	public String getLicense(){		//POST: returns car license
		return license;
	}
	public Time getTime(){			//returns the time of departure and arrival
		return time;
	}
	public void setLicense(String license){ //sets the name of the license to license
		this.license = license;
		
	}
	public void setTime(Time time){			//sets the time of arrival and departure 
		this.time = time;
	}
	public Car(Car c){						//calls the get license and time class
		license = c.getLicense();			//and equals it to the two variables
		time = c.getTime();
	}
	public String toString(){				
		return "License; " + license + "Time: " + time;
		
	}
	public int compareTo(Car park){			//passes cars to compare them with any other cars in the stack
		if(license.equals(park.getLicense())){
			return 1;
		}
		return -1;
	}
	

}
