package com.metacube.zoo;

import java.util.ArrayList;
import java.util.List;

public class Cage {
	
	private static Integer newId=0;
	private Integer zoneId;
	private Integer cageId;
	private Integer capacity;
	private String animalType;
	private Integer totalAnimalPresent;
	private List<Animal> animalPresent=new ArrayList<Animal>();
	public Cage(Integer capacity, String animalType,Integer zoneId) {
		newId++;
		this.cageId=newId;
		this.capacity = capacity;
		this.animalType = animalType;
		this.zoneId=zoneId;
		this.totalAnimalPresent=0;
	}
	
	

}
