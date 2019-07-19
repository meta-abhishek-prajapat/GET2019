package com.metacube.testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.meta.junit.test.ArrOperation;

@RunWith(Parameterized.class)
public class SplitArrayTest {
	
	public Integer array[];
	public Integer positiveTest;
	public Integer negativeTest;
	
	public SplitArrayTest(Integer[] array,  Integer positiveTest,
			Integer negativeTest) {
		super();
		this.array = array;
		this.positiveTest = positiveTest;
		this.negativeTest = negativeTest;
	}
	
	@Parameterized.Parameters
	public static Collection<Object[]> data(){
		return Arrays.asList(new Object[][] {
				{new Integer[]{1, 1, 1, 2, 1},3,7},
				{new Integer[]{2, 1, 1, 2, 1},-1,4},
				{new Integer[]{10, 10},1,9},
			
			});
	 }
	
	@Test
	public void PositiveTestCase(){
		Assert.assertEquals(positiveTest,ArrOperation.splitArray(array));
	}
	
	@Test
	public void NegativeTestCase(){
		Assert.assertNotEquals(negativeTest,ArrOperation.splitArray(array));
	}
	
}
