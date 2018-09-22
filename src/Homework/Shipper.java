//Andrew Cramer

package Homework;

import java.util.Scanner;
import java.io.IOException;

public class Shipper {

	public static void main(String[] args) throws IOException{
		
		//System.out = new PrintStream (new FileOutputStream("snowglove.txt"));
		//would go to a txt file
		
		Scanner scan = new Scanner(System.in);
		
			Box smallbox = new Box(16,12,4);
			Box largebox = new Box(24,16,8);
			Box Globe = new Box();
		
			int smalllen = smallbox.getLength(); //smallbox length from other class
			int smallwid = smallbox.getWidth();  //smallbox width from other class
			int smallhei = smallbox.getHeight(); //smallbox height from other class
			int largelen = largebox.getLength(); //gets the large box length
			int largewid = largebox.getWidth();  //gets the large box width
			int largehei = largebox.getHeight(); //gets the large box height
		    
			boolean lgPartial;       //finds the value of the partial
		    boolean smPartial;       //finds the value of the partial
		    boolean partial;
		
		    int smCt=0;              //smallcount for while loop
		    int lgCt=0;   			 //largecount for while loop
			double numberglobes;     //number of g;lobes
		    double smallboxVol;         //small box volume
			double largeboxVol; 		 //large box volume
			int smnumsize;           //small box size with globes in the box
			int lgnumsize;   		 //large box size with globes in the box
			int lengthglobe;         //length of globe
			int heightglobe;         //height of globe
			int widthglobe;          //width of globe
			double Globevol;            //globe volume
			
	
		
			System.out.println("Andrew Cramer");
			System.out.println("Assg #3 - Compute ship packing costs");
		
			while (true)	{
				System.out.print("\nEnter number of snow globes to ship (0 to quit): ");
				numberglobes = scan.nextInt();
				
				if	(numberglobes == 0){
					System.exit(1);
				}
				System.out.print("Enter length width and height of the globe: ");
				lengthglobe=scan.nextInt();
				heightglobe=scan.nextInt();
				widthglobe=scan.nextInt();
		
				Globe.setLength(lengthglobe);
				Globe.setWidth(widthglobe);
				Globe.setHeight(heightglobe);
		
				smallboxVol = smallbox.getvolume(); //volume of the small box called from the other class
				largeboxVol = largebox.getvolume(); //volume of the large box called from the other class
				Globevol = Globe.getvolume();       //total snow globe volume of one by itself
	
				double smfit = smallboxVol/Globevol;   //finding how many can fit in the small box
				double lgfit = largeboxVol/Globevol;   //finding how many can fit in the large box
				
					
				System.out.println("Number of snow globes: " + numberglobes);
				System.out.println("Dimensions: " + lengthglobe + " " + heightglobe + " " + widthglobe);
				System.out.println("Number that fit in Ship Box 1: " + smfit );
				System.out.println("Number that fit in Ship Box 2: " + lgfit );
				
				if (smfit==numberglobes){      //used for finding the remainder of globes
					 smCt=1;
				}
				
				else if (smfit >=0){           //used for finding the remainder of globes
					 smCt=0;
				}
				
				else{
					while (numberglobes>0){	   //used for finding the remainder of globes in a while 
						numberglobes = numberglobes-smfit;	
						smCt++;
					}
				
				}
				
				if (lgfit==numberglobes){ //used for finding the remainder of globes
					 lgCt=1;
				}
				
				else if (lgfit >=0){      //used for finding the remainder of globes
					 lgCt=0;
				}
				
				else{                     //used for finding the remainder of globes
					while (numberglobes>0){	
						numberglobes = numberglobes-lgfit;	
						lgCt++;
					}
				}
				
				if (lgfit ==0 && smfit==0){ //telling the user that the shipping cant work
					System.out.println("No shipping box is available");
					System.out.println("--------------------------------------");
	
				}
			
				else {
					double space = smfit*smCt;
					double spacelg = lgfit*lgCt;
					if (smfit > 0 || lgfit>0){
						if (smfit > 0){
							double amount = (space - numberglobes)*Globevol;
							System.out.println("\nShipping Box 1:");
							System.out.println("Number Ship Boxes Needed: " + smCt  );
							System.out.println("----------------------------------------");
							//if (partial==true ){
								//System.out.println("Partial Box used: "+ partial);
								//double cost = amount*.0023;
								//System.out.printf("Packing cost for partial box: $"+"%.2f %n",cost);
							}
						else{
							//PLEASE READ
							
							//my idea was to have multiple if and else statements that would tell if a partial box was used
							//ended up screwing myself over on not using methods, and had a few technical difficulties here and there
							//with my computer battery dying on me at the library.
							//this is what i have so better than nothing.
							
							
						}
										
						}
						if (lgfit > 0){     //prints shipping box 2 which is the large shipping box
							System.out.println("\nShipping Box 2:");
							System.out.println("Number Ship Boxes Needed: " + lgCt  );
							System.out.println("----------------------------------------");
				
					}
				}
			}	
		}	
	
//System.out.close(); would close the file to a txt file
}




