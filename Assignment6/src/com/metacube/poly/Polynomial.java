package com.metacube.poly;

import java.util.ArrayList;
import java.util.List;

public class Polynomial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Polynomial poly = new Polynomial(
				new Integer[] { 2, 3, 4, 2, 5, 1, 5, 0 });
		Polynomial poly2 = new Polynomial(new Integer[] { 3, 3, 4, 2, 6, 1, 7,0 });
		// Float val=(float) 2;
		// System.out.println(poly.getPolynomialDegree());
		Polynomial s = new Polynomial();
		s = s.addPoly(poly, poly2);*/
		Polynomial poly1=new Polynomial(new Integer[]{1,1,2,0});
		Polynomial poly2=new Polynomial(new Integer[]{1,1,2,0});
		Polynomial s=new Polynomial();
		s=s.multiplyPoly(poly1, poly2);
		for (Terms t : s.lst) {
			System.out.println(t.coefficient + " " + t.exponent);
		}
	}

	public List<Terms> lst = new ArrayList<Terms>();
	
	public Polynomial(Integer[] data) {
		for (Integer loop = 0; loop < (data.length - 1); loop = loop + 2) {
			Terms term = new Terms(data[loop], data[loop + 1]);
			this.lst.add(term);
		}
	}

	public Polynomial() {

	}
	
	/**
	 * Evaluate polynomial expression
	 * @param value (value of x)
	 * @return evaluation of polynomial
	 */
	public Integer Evaluate(Float value) {
		Integer evaluation = 0;
		
		for (Terms term : this.lst) {
			evaluation = (int) (evaluation + (term.coefficient * (Math.pow(
							value, term.exponent))));
		}
		return evaluation;
	}

	/**
	 * Find Highest Degree of Polynomial
	 * @return degree of polynomial
	 */
	public Integer getPolynomialDegree() {
		Terms term = lst.get(0);
		Integer degree = term.exponent;
		for (Terms loopterm : lst) {
			if (degree < loopterm.exponent)
				degree = loopterm.exponent;
		}
		return degree;
	}

	/**
	 * Add two polynomial expression
	 * @param poly1 first expression
	 * @param poly2 second expression
	 * @return addition of poly1 and poly2
	 */
	public Polynomial addPoly(Polynomial poly1, Polynomial poly2) {
		Integer flag = 0;
		Terms delete = null;
		Polynomial poly = new Polynomial();
		for (Terms t1 : poly1.lst) {
			flag = 0;
			for (Terms t2 : poly2.lst) {
				if (t1.exponent == t2.exponent) {
					Integer sumofcoeff = t1.coefficient + t2.coefficient;
					Terms term = new Terms(sumofcoeff, t2.exponent);
					poly.lst.add(term);
					flag = 1;
					delete = t2;
				}
			}
			if (flag == 0) {
				poly.lst.add(t1);
			} else {
				poly2.lst.remove(delete);
			}
		}
		for (Terms t : poly2.lst) {
			poly.lst.add(new Terms(t.coefficient, t.exponent));
		}
		return poly;
	}
	
	/**
	 * Multiply two polynomial expression
	 * @param poly1 first expression
	 * @param poly2 second expression
	 * @return multiplication of poly1 and poly2
	 */
	public Polynomial multiplyPoly(Polynomial poly1, Polynomial poly2)
	{
		Polynomial poly=new Polynomial();
		Integer coefficient=0;
		Integer exponent=0;
		for(Terms t1:poly1.lst){
			for(Terms t2:poly2.lst){
				coefficient=t1.coefficient*t2.coefficient;
				exponent=t1.exponent+t2.exponent;
				Terms tmp=new Terms(coefficient, exponent);
				poly.lst.add(tmp);
			}
		}
		return poly;
	}
}
                                                                       