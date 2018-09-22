package Homework;

import java.text.DecimalFormat;

public class BisectMethods 
{
	public static double f (double x)						// POST: return the y value of equation
	{	
		return x*x*x - 2.0*x  - 3.0;
	}
	
	public static double bisect (double a, double b, double tolerance)		// POST: return root
	{																		//v is equal to m for the output statement
																			//changed the name for me personally to view it easier
		double v = (a+b)/2;													//having a double variable be equal to the equation
		DecimalFormat df = new DecimalFormat("0.000000000000000");			//decimal format for outputting 
		System.out.printf("%-17s %-17s %-17s%n",df.format(a), df.format(v),df.format(b));	//printf for formatting the decimal output
		if (a>b){															
			return -1;
		}
		else if (f(v) > 0 - (2*tolerance) && f(v) < (tolerance)){			//returns the equation (a+b)/2
																			//if the requirements are met
			return v;													
		}
		else if (f(a) * f(v) < 0){											
			return bisect ( a, v, tolerance);
		}
		else {
			return bisect (v,b,tolerance);
		}
	}
}
