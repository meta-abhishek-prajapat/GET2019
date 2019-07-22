package com.metacube.search;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class BinaryTest {
	
	private Integer[] array;
	private Integer expected;
	private Integer negative;
	
	public BinaryTest(Integer[] array,Integer expected,Integer negative){
		this.array = array;
		this.expected = expected;
		this.negative=negative;
	}
	
	@Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList((new Object [][] {
			{new Integer[] {1,2,3,4,5},2,6},
			{new Integer[] {26,32,66,83,98},-1,4},
			{new Integer[] {2,3,45,56,65},1,2},
			{new Integer[] {21,45,75,82,98},-1,6}, 
			
		}));
	}
	
	@Test
	public void binaryPositiveTest(){
		assertEquals(expected,Search.linearSearch(array, 3));
	}
	
	@Test
	public void binaryNegativeTest(){
		assertNotEquals(negative,Search.linearSearch(array, 3));
		
	}


}
