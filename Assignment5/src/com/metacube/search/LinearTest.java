package com.metacube.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LinearTest {
	
	private Integer[] array;
	private Integer expected;
	private Integer negative;
	
	public LinearTest(Integer[] array,Integer expected,Integer negative){
		this.array = array;
		this.expected = expected;
		this.negative=negative;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList((new Object [][] {
			{new Integer[] {1,2,3,4,5},2,6},
			{new Integer[] {56,32,66,83,78},-1,4},
			{new Integer[] {2,3,45,23,56,65},1,2},
			{new Integer[] {43,21,45,75,32},-1,6}, 
			
		}));
	}
	
	@Test
	public void linearPositiveTest(){
		assertEquals(expected,Search.linearSearch(array, 3));
	}
	
	@Test
	public void linearNegativeTest(){
		assertNotEquals(negative,Search.linearSearch(array, 3));
		
	}

}
