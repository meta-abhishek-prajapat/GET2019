package com.metacube.testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.meta.junit.test.ArrOperation;

@RunWith(Parameterized.class)
public class FixXYTest {
	
	public Integer array[];
	public Integer result[];
	public Integer x;
	public Integer y;
	
	public FixXYTest(Integer[] array, Integer[] result,Integer x,Integer y) {
		super();
		this.array = array;
		this.result = result;
		this.x=x;
		this.y=y;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
				{new Integer[]{5, 4, 9, 4, 9, 5},new Integer[]{9, 4, 5, 4, 5, 9},4,5},
				{new Integer[]{1, 4, 1, 5},new Integer[]{1, 4, 5, 1},4,5},
				{new Integer[]{1, 4, 1, 5, 5, 4, 1},new Integer[]{1, 4, 5, 1, 1, 4, 5},4,5},
				
		});
	 }
	
	
	@Test
	public void testFixXY(){
		Assert.assertArrayEquals(result,ArrOperation.fixXY(array, x, y));
	}

}
