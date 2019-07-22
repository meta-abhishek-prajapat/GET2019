package com.metacube.assignment5;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
@RunWith(Parameterized.class)
public class LCMHCFTest {

	public int number1;
	public int number2;
	public int expectedResult;
	public int negativeresult;

	

	public LCMHCFTest(int number1, int number2, int expectedResult,
			int negativeresult) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.expectedResult = expectedResult;
		this.negativeresult = negativeresult;
	}

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { 34, 24, 408, 2 },
				{ 4, 2, 4, 2 },

		});
	}

	@Test
	public void Test_LCM() {
		Assert.assertEquals((Integer)expectedResult, LCMHCF.CalculateLCM(number1, number2));
	}

	@Test
	public void Test_HCF() {
		Assert.assertEquals((Integer)negativeresult, LCMHCF.CalculateHCF(number1, number2));
	}

	
}
