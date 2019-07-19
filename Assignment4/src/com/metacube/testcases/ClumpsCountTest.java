package com.metacube.testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.meta.junit.test.ArrOperation;

@RunWith(Parameterized.class)
public class ClumpsCountTest {
	
	public Integer array[];
	public Integer positiveTest;
	public Integer negativeTest;
		
	public ClumpsCountTest(Integer[] array, Integer positiveTest,
			Integer negativeTest) {
		super();
		this.array = array;
		this.positiveTest = positiveTest;
		this.negativeTest = negativeTest;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
				{new Integer[]{1, 2, 2, 3, 4, 4},2,7},
				{new Integer[]{1, 1, 2, 1, 1},2,5},
				{new Integer[]{1, 1, 1, 1, 1},1,0},
				
			});
	 }
	
	@Test
	public void PositiveTestCase(){
		Assert.assertEquals(positiveTest,ArrOperation.CountClumps(array));
	}
	
	@Test
	public void NegativeTestCase(){
		Assert.assertNotEquals(negativeTest,ArrOperation.CountClumps(array));
	}
	
	

}