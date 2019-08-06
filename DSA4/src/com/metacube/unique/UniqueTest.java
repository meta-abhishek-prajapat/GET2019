package com.metacube.unique;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniqueTest {
	
	@Test
	public void checkInputForCheckUniqueTest() {
		String strInput = "Hello";
		Integer expected = 3;
		assertEquals(expected, Unique.checkUnique(strInput));
	}
	
	@Test
	public void NegativeUniqueTest() {
		String strInput = "Hello";
		Integer expected = 4;
		assertNotEquals(expected, Unique.checkUnique(strInput));
	}
	
}
