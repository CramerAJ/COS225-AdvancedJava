package Homework;

import java.util.Scanner;
public class questionpractic {
	public static void main(String []args){
		
		int entry;
		Scanner scan=new Scanner(System.in);
		do
		{
			System.out.print("Enter 1 or 2");
			entry=scan.nextInt();
			
		}
		while(entry!=1 && entry!=2);
	}
	
}
