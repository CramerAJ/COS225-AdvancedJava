//Andrew Cramer

package Homework;

public class Box {

	private int length;
	private int width;
	private int height;
	
	public Box(){ //stateing the box width length and height constants
		width=1;
		length=1;
		height=1;
	}
	
	public int getLength(){ //takes the length that the user gives from the other class
		return length;
	}
	public Box(int len, int wid ,int hei){
		length = len;
		width = wid;
		height = hei;
	}
	public int getWidth(){  //takes the width from the user
		return width;
	}
	public int getHeight(){ // takes the height from the user that was given
		return height;
	}
	public void setLength(int len){ //sets the length for the other class
		length=len;
	}
	public void setHeight(int hei){ //sets the height for the other class
		height=hei;
	}
	public void setWidth(int wid){ //sets the width for the other class
		width=wid;
	}
	public int getvolume(){       //sets the volume for the other class
		int volume;
		volume = length*width*height;
		return volume;	
	}
}
