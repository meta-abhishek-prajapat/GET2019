package com.metacube.zoo;

public class Lion extends Mammal{
	
	public static String type = "Lion";
	
	public Lion(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}
	
	@Override
    public String getSound() {
        return "Roar";
    }
    
    @Override
    public String getType() { 
    	return type; 
    }

}
