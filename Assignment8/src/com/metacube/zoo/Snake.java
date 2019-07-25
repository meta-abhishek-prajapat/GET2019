package com.metacube.zoo;

public class Snake  extends Reptile {

	public String type="Snake";
	public Snake(String name, int age, float Weigtht) {
		super(name, age, Weigtht);
	}

	@Override
	public String getSound() {
		return "hiss";
	}

	@Override
	public String getType() {
		return type;
	}

}
