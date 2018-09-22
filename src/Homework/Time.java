//Andrew Cramer
package Homework;
import java.util.Scanner;

public class Time {
	
	private int hour;							// hour (0 - 23)
	private int minute;							// minute (0 - 59)
	
	public Time ( )								// POST: empty Time object
	{	hour = 0;
		minute = 0;
	}
	
	public Time (int h, int m)					// PRE: 0 <= h <= 23, 0 <= m <= 59
	{	hour = h;								// POST: Time object set with user hour and minute
		minute = m;
	}
	
	public Time (String s)						// PRE: hh:mm format, "00" <= "hh" <= "23", "00" <= "mm" <= "59"
	{	Scanner scan = new Scanner (s);			// POST: Time object set from string
		scan.useDelimiter(":");
		String strHour = scan.next( );
		String strMinute = scan.next ( );
		hour = Integer.parseInt(strHour);
		minute = Integer.parseInt(strMinute);
		scan.close();
	}
	
	public int getHour() {						// POST: return hour
		return hour;
	}
	public void setHour(int h) {				// PRE: 0 <= h <= 23
		hour = h;								// POST: set hour
	}
	
	public int getMinute() {					// POST: return minute
		return minute;
	}
	
	public void setMinute(int m) {				// PRE: 0 <= m <= 59
		minute = m;								// POST: set minute
	}
	
	public String toString ( )					// POST: return string in hh:mm format
	{	if (minute < 10)
			return hour + ":0" + minute;
		else
			return hour + ":" + minute;
	}
	
	public int subtract (Time other)			// POST: return number of minutes between two times
	{	int min1 = hour * 60 + minute;			// compute number of minutes from midnight to time
		int min2 = other.hour * 60 + other.minute;
		return Math.abs(min1-min2);
	}	

}
