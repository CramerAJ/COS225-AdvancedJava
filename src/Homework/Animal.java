package Homework;

public class Animal {
	
	private String name;
	private int age;
	
	public Animal(String n, int a){
		name = n;
		age = a;
	}
	
	public Animal(){
		name = "";
		age = 0;
	}
	
	public void die(){
		System.out.println("dead");
	}
	
	public String toString(){
		return "I am a animal";
	}

}
