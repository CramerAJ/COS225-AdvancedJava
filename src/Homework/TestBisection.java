package Homework;

public class TestBisection {

	public static void main(String[] args) {
		
		System.out.println ("Bisection by Andrew Cramer\n");
		System.out.println ("Trace of calls");
		System.out.printf ("%-17s %-17s %-17s%n","a","m","b");

		double root = BisectMethods.bisect(1.0, 2.0, 1.0e-15);		// root of f between 1.0 and 2.0 with tolerance 10^-15
		System.out.println ("\nThe root of x^3 - 2x - 3 between 1 and 2 is approximately " + root);
	}
}


