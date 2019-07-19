package com.metacube.testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.meta.junit.test.ArrOperation;

@RunWith(Parameterized.class)
public class MaxMirrorTest {

	public Integer array[];
	public Integer positiveTest;
	public Integer negativeTest;
		
	public MaxMirrorTest(Integer[] array, Integer positiveTest,
			Integer negativeTest) {
		super();
		this.array = array;
		this.positiveTest = positiveTest;
		this.negativeTest = negativeTest;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
				{new Integer[]{1, 2, 3, 8, 9, 3, 2, 1},3,6},
				{new Integer[]{7, 1, 4, 9, 7, 4, 1},2,0},
				{new Integer[]{1, 2, 1, 4},3,8},
				{new Integer[]{1, 4, 5, 3, 5, 4, 1},7,4},
				
		});
	 }
		
	@Test
	public void PositiveTestCase(){
		Assert.assertEquals(positiveTest,ArrOperation.MaxMirror(array));
	}
	
	@Test
	public void NegativeTestCase(){
		Assert.assertNotEquals(negativeTest,ArrOperation.MaxMirror(array));
	}
	
	
}
