package com.metacube.zoo;

public class Peacock extends Bird{
	
	
	public String type="Peacock";
	public Peacock(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}

	@Override
	public String getSound() {
		return "meeeaaa";
	}

	@Override
	public String getType() {
		return type;
		
	}

}
