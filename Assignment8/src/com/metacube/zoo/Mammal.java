package com.metacube.zoo;

public abstract class Mammal extends Animal{
	
	public String category = "Mammal";

	public Mammal(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}
	 @Override
	    abstract public String getSound();

	    public String getCategory() {   
	    	return category; 
	    }
	    
	    @Override
	    abstract public String getType();

}
