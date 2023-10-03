package com.maveric.training.org;

import java.util.ArrayList;

public class Building {
   private String BuildingName;
   private ArrayList<Floors> floorNumber;
   
   public Building() {
	   System.out.println("Default constructor of building is called");
	   BuildingName = "";
	  
   }

public Building(String buildingName, ArrayList<Floors> floorNumber) {
	super();
	BuildingName = buildingName;
	this.floorNumber = floorNumber;
}

   
 
}
