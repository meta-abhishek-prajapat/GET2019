package com.metacube.ques3;

import java.util.List;

public class Term {

	Integer coeff;
	List<Variable> variables;

	public Term(Integer coeff, List<Variable> variables) {
		super();
		this.coeff = coeff;
		this.variables = variables;
	}

}
