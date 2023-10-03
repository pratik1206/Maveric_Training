package com.maveric.training.org;

import java.util.ArrayList;

public class Floors {
  private String floorName;
  private ArrayList<Room> rooms;
  
  @Override
public String toString() {
	return "Floors [floorName=" + floorName + ", rooms=" + rooms + "]";
}

public Floors()
{
 System.out.println("DEfault constructor of Floor is called");	 
}

public Floors(String floorName, ArrayList<Room> rooms) {
	
	this.floorName = floorName;
	this.rooms = rooms;
}
  
}
