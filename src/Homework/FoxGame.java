//Andrew Cramer

package Homework;

import java.util.LinkedList;
import java.util.Scanner;


public class FoxGame {
	
	String farmerLocation;										//location of farmer: south or north
	LinkedList<String>southBank = new LinkedList<String>();		//list of items on south bank
	LinkedList<String>northBank = new LinkedList<String>();		//list of items on north bank
	
	public FoxGame()											//POST: Add the 3 items to south bank
	{	southBank.add("fox");									//		Place the farmer on south bank
		southBank.add("chicken");		
		southBank.add("grain");
		northBank.clear();										// 		North bank is empty
		farmerLocation = "south";
	}
	public boolean won()										//POST: return true if game won
	{
		if(northBank.contains("fox"))							//all four of the strings must be in the north linked list
			if(northBank.contains("chicken"))
				if(northBank.contains("grain"))
					if(farmerLocation.equals("north"))
						return true;
		return false;
		
	}
	boolean lost(){									//POST: return true if the game lost
		if (farmerLocation.equals("south")){		//Game is lost for certain combinations in certain linked lists
			if (northBank.contains("fox"))		
				if(northBank.contains("chicken"))
					return true;
		}
		if (farmerLocation.equals("south")){		
			if(northBank.contains("chicken"))
				if(northBank.contains("grain"))
					return true;
		}
		if (farmerLocation.equals("north"))
			if(southBank.contains("chicken"))
				if(southBank.contains("grain"))
					return true;
		if (farmerLocation.equalsIgnoreCase("north"))
			if(southBank.contains("chicken"))
				if(southBank.contains("fox"))
					return true;
		
		return false;
	}
	
	public void transport(String item)			//PRE: item is current bank or string"none"
	{								
		if (southBank.contains(item)){			//takes the specified item and moves it to the other linked list
			southBank.remove(item);
			northBank.add(item);
			
		}
		else if(northBank.contains(item)){		//as well as checks the farmer location
			northBank.remove(item);
			southBank.add(item);
		}
		if (farmerLocation.equals("south")){
			farmerLocation = "north";
		}
		else {
			farmerLocation = "south";
		}
		
			
	}									
	
	public String getFarmerBank()		//POST: return bank holding farmer:north/south
	{
		return farmerLocation;
		
	}
	public String getOtherBank()		//POST: return bank not holding farmer
	{
		if(farmerLocation.equals("south"))
			
			return"north";
		
		return "south";
		
	}
	public boolean found(String item)		//POST: return true if item is on current bank or item is "none"
	{
											//returns true for the linked list if it contains that item
		if (item.equals("none"))
			return true;
		if (farmerLocation.equals("south"))
			if (southBank.contains(item))
				return true;
		if (farmerLocation.equals("north"))
			if (northBank.contains(item))
				return true;
		
		return false;
		
	}
	public String displaySouthBank()		//POST: return contents of south bank
	{
		String f = "[";	
		
		for (int i = 0; i<southBank.size();i++){
			
			f +=southBank.get(i) +", ";
		}
		if (f.length()>1)
			f =f.substring( 0, f.length()-2);
		f+="]";
		return f;
		
	}
	public String displayNorthBank()		//POST: return contents of north bank
	{
		String f = "[";
		for (int i = 0; i<northBank.size();i++){
			f +=northBank.get(i) +", ";
		}
		if (f.length()>1)
			f =f.substring(0, f.length()-2);
		f+="]";
		return f;
		
	}
	
}
