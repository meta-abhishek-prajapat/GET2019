package com.metacube.ques3;

import java.util.ArrayList;
import java.util.List;

public class MultivariantPolynomial {

	// list of temrs in polynomial
	public List<Term> polynomail = new ArrayList<Term>();

	/**
	 * Contructor which take array
	 * 
	 * @param array
	 *            list of elements AS INPUT {1,2,3,4,5,6} 1ST IS COEFF 2ND IS
	 *            POWER OF X AND THIRD IS POWER OF Y
	 */
	public MultivariantPolynomial(Integer array[]) {
		super();
		for (int loop = 0; loop < array.length; loop = loop + 3) {
			Variable var1 = new Variable('x', array[loop + 1]);
			Variable var2 = new Variable('y', array[loop + 2]);
			List<Variable> variable = new ArrayList<Variable>();
			variable.add(var1);
			variable.add(var2);
			Term term = new Term(array[loop], variable);
			polynomail.add(term);
		}

	}

	/**
	 * Show the polynomial equation
	 */
	public void showPolynomial() {
		for (Term term : this.polynomail) {
			if (term.coeff < 0)
				System.out.print(term.coeff);
			else
				System.out.print("+" + term.coeff);
			for (Variable var : term.variables) {
				if (var.var == 'x')
					System.out.print("x^" + var.power);
				if (var.var.equals('y'))
					System.out.print("y^" + var.power);
			}
		}
	}

	/**
	 * Find the maximum degree in the polynomial
	 * 
	 * @return highest degree
	 */
	public Integer FindDegree() {
		Integer degree = 0;
		for (Variable var : this.polynomail.get(0).variables) {
			degree += var.power;
		}

		for (Term term : this.polynomail) {
			Integer sum = 0;
			for (Variable var : term.variables) {
				sum += var.power;
			}
			if (sum > degree)
				degree = sum;
		}
		return degree;
	}

}
