package Homework;

public class Dog extends Animal {
    
    int ageInDogYears;

    public Dog() {
            super();
            ageInDogYears = 0;
    }
   
    public Dog(String n, int a, int dy){
            super(n, a);
            ageInDogYears = dy;
    }
   
    public void die(){
            System.out.println("bark,bark,*rolls over dead");
    }

    public String toString(){
            return "I am dog";
    }
   
    public static void main(String[] args) {

           
            Animal a = new Animal();
            Animal d = new Dog();
           
            if(a instanceof Dog){
                    System.out.println("yes");
            }
           
            a.die();
            d.die();
    }

}