package com.metacube.chemistry;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrganicChemistryTest {
	
	@Test
	public void PositiveTest() {
		String formula = "C(OH)";
		Integer expected = 29;
		assertEquals(expected, OrganicChemistry.caluclateMass(formula));
	}
	
	@Test
	public void NegativeTest() {
		String formula = "C(OH)";
		Integer expected = 26;
		assertNotEquals(expected, OrganicChemistry.caluclateMass(formula));
	}
	
		
}