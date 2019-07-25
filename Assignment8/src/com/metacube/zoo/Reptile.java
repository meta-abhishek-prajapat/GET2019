package com.metacube.zoo;

public abstract class Reptile extends Animal{
	
	public String category = "Reptile";

	public Reptile(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}
	
	 @Override
	 abstract public String getSound();
	    
	 @Override
	 public String getCategory() {   
	    	return category; 
	    }
	    
	 @Override
	  abstract public String getType();
}
