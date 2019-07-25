package com.metacube.zoo;

public abstract class Animal {
	
	private static Integer newId = 0;
    private Integer animalIid;
    private String animalName;
    private Integer animalAge;
    private float animalWeight;
    
    public Animal(String name,int age, float Weigtht){
        newId++;
        this.animalIid = newId;
        this.animalName = name;
        this.animalAge = age;
        this.animalWeight = Weigtht;
    }
    
    public int getAnimalId(){  
    	return animalIid;  
    }
    
    public String getAnimalname(){ 
    	return animalName; 
    }
    
    public int getAnimalAge(){   
    	return animalAge;
    }
    
    public float getAnimalWeight(){ 
    	return animalWeight;
    }
    
    abstract public String getCategory();
    
    abstract public String getSound();
    
    abstract public String getType();

}
