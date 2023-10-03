package com.maveric.training.org;

public class Room {
private double length;
private double width;
private double height;
private String Roomname;


  public Room() {
	  System.out.println("default constructor of Room is called");
	  length = 0;
	  width =0;
	  height = 0;
	  Roomname = "";
	  
  }


public Room(double length, double width, double height, String roomname) {
	System.out.println("Parameterised constructor is called");

	this.length = length;
	this.width = width;
	this.height = height;
	Roomname = roomname;
}


@Override
public String toString() {
	return "Room [length=" + length + ", width=" + width + ", height=" + height + ", Roomname=" + Roomname + "]";
}

}
