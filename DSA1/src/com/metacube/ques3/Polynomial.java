package com.metacube.ques3;

public class Polynomial {

	public static void main(String[] args) {
		MultivariantPolynomial poly = new MultivariantPolynomial(new Integer[] {
				1, 2, 1, -6, 3, 12, 3, 12, 12 });
		poly.showPolynomial();
		System.out.println();
		System.out.println(poly.FindDegree());
	}

}
