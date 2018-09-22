//Andrew Cramer

package Homework;

public class Inventory {

	final int INITIAL = 7;  //the capacity of the array is 7 slots
	private Product[] array;//counts all the products to be the total number of array slots
	int capacity;			//capacity is the set array amount
	int size;				//size allows the addition of the new slot onto capacity
	
	public Inventory() { // Inventory to hold all the new products
		array = new Product[INITIAL];
		capacity = INITIAL;				//7 total slots of the array
		size = 0;						//no extra slots added onto it
	}
	public int getCapacity() {	//returns the Capacity of the total amount of variables on the txt file
		return capacity;
	}
	public Inventory(int cap) {	//calls the array of the Product the user wants into the array of Inventory
		array = new Product[cap];
		capacity = cap;
		size = 0;
	}
	public int getSize() {		//Used to for the for loop in StoreManager to scan the txt file
		return size;
	}
	public Product getValue(int index) {	//Returns the total value of the product from array
		return array[index];
	}
	public void setValue(Product value, int index) { 
		array[index] = value;
	}
	public void insert(Product value) {	//when a new product is allowed to be entered it will increase the 
		if (capacity == size)			//size of the total array by 1 and allow the new product to be inserted
			resize();
		array[size] = value;
		size++;
	}
	public void resize() {				//changes the size of the array based on the new Product going through or not
		capacity *= 2;
		Product[] temp = new Product[capacity];	
		for (int k = 0; k < size; k++)	//for loop for array of previous k to add a new slot until all the variables
			temp[k] = array[k];			//fit on the new table created
		array = temp;					//redefined name for the array
	}
	public int search(Product value) {	//looks for the Product name to match up with the data on the line
		for (int k = 0; k < size; k++)	//runs this again till all names have 2 extra variable added onto it for amount and price
			if (array[k].getName().equals(value.getName())) 
				return k;				//returns all the products
		return -1;
	}
	public void remove(int index) {		//removes a corresponding Name if the user inputs it correctly
		if (index != -1) {				
			array[index] = array[size - 1];	//removes the name from the array and takes a slot away from the array
			size--;							//-1 for size and goes back to the public Inventory and takes 1 away from capacity
		}
	}

}
