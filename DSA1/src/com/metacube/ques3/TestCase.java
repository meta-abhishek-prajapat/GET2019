package com.metacube.ques3;

import org.junit.Assert;
import org.junit.Test;

public class TestCase {

	@Test
	public void FindDegreePositive() {
		MultivariantPolynomial poly = new MultivariantPolynomial(new Integer[] {
				1, 2, 1, -6, 3, 12, 3, 12, 12 });
		Assert.assertEquals((Integer) 24, (Integer) poly.FindDegree());
	}

	@Test
	public void FindDegreeNegative() {
		MultivariantPolynomial poly = new MultivariantPolynomial(new Integer[] {
				1, 2, 1, -6, 3, 12, 3, 12, 12 });
		Assert.assertNotEquals((Integer) 13, (Integer) poly.FindDegree());
	}

}
