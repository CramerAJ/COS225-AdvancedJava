package Homework;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.*;

public class HashTable {

public static void main (String[]args) throws FileNotFoundException{
	
	String output = "";								//string output
	int clus;										//int clus(cluster) for converting the hash to a cluster
		
	PrintStream out = new PrintStream(new FileOutputStream("hashproblem.txt"));		//method for outputting the console to a text file
	HashTable hash = new HashTable();												//Hashtable method equals hash
	Scanner file = new Scanner(new FileReader("jumbledwords.txt"));					//scanner for file reader
	
	while (file.hasNext()){							//while loop for scanning the txt file and 
		output = file.next();						//outputting the data to the hash methods
		hash.insert(output);
	}
	System.setOut(out);
	for (int i=0; i<1009; i++){						//for loop for 1009 hash clusters
		clus = hash.getClusterLength(i);			//cluster = hash from the cluster method
		System.out.println(clus);					//out puts the cluster
	}
	file.close();
	
	}
	
	final int CAPACITY = 1009;						// size of hash table 
	ArrayList<LinkedList<String>> h ;   			// array of  lists
	int size;										// number of items in hash table
	int capacity;									// capacity of hash table

	public HashTable( )								// POST: table of CAPACITY with empty LinkedList objects
	{
		capacity = CAPACITY;
		size = 0;
		h = new ArrayList < LinkedList<String> > () ;
		for (int k=0; k<capacity; k++)
			h.add(new LinkedList<String> ( ));
	}
	
	public HashTable(int cap)						// PRE: cap > 0	
	{												// POST: table of capacity cap with empty LinkedList objects
		capacity = cap;
		size = 0;
		h = new ArrayList < LinkedList<String> > (capacity) ;
		for (int k=0; k<capacity; k++)
			h.add(new LinkedList<String> ( ));
		size = 0;
	}
	
	public boolean isPresent(String target)			// PRE: table is not empty 
	{												// POST: return true if target is in table; else false
		int index = hash(target);						     
		if (h.get(index).contains(target))
			return true;
		else
			return false;
	}
	
	boolean isEmpty ( )								// POST: return true if table is empty
	{
		return size == 0;
	}
	
	public void insert (String word)				// POST: if not found, add word to hash table
	{	
		int index = hash(word);	
		LinkedList<String> temp = h.get(index);
		if (!temp.contains(word))
		{	temp.add(word);
			h.set(index, temp);
			size++;
		}
	}
	
	public String toString ()						// POST: return words as a string
	{
		String result = "";
		for (int k = 0; k < capacity; k++)
		{	int listLength = h.get(k).size();
			result = result + "Index " + k + " : ";
			for (int j = 0; j < listLength; j++)
				result = result + h.get(k).get(j) + " ";
			result = result + "\n";
			}
		return result;
	}
	
	public int getCapacity( )						// POST: return capacity of hash table
	{	
		return capacity;
	}
	
	public int getClusterLength (int index)			// POST return length of cluster at index 
	{
		return h.get(index).size();
	}
	
	//first hash function to use 
	/*private int hash (String word)				// POST: return hash index of word
	{	int sum = 0;
		for (int k = 0; k< word.length(); k++)
			sum = sum + (int)(word.charAt(k));
		return  sum % capacity;   
	}
	*/
	
	//  second hash function to use 
	private int hash (String word)					// POST: return hash index of word
	{  int seed = 131; 
	   long sum = 0;
	   for(int k = 0; k < word.length(); k++)
	         sum = (sum * seed) + (int)(word.charAt(k));
	   return (int)(Math.abs(sum) % capacity);
	}


}
