package com.Test;
import java.util.*;

class Animal {
    public void eat() {
        System.out.println("The animal is eating.");
    }
}

// Child class inheriting from Animal
class Dog1 extends Animal {
    public void bark() {
        System.out.println("The dog is barking.");
    }
}

// Child class inheriting from Animal
class Cat extends Animal {
    public void meow() {
        System.out.println("The cat is meowing.");
    }
}
public class ProgpolyandInher{
	// Parent class
	

	// Main class
	public class InheritanceDemo {
	    public static void main(String[] args) {
	        Dog dog = new Dog();
	        dog.eat(); // Inherited method from Animal class
	        dog.bark(); // Method specific to Dog class

	        Cat cat = new Cat();
	        cat.eat(); // Inherited method from Animal class
	        cat.meow(); // Method specific to Cat class
	    }
	}

}
