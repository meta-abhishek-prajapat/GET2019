package com.metacube.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntSet implements Set{

	private final int UPPER_LIMIT = 1000;
	private final int LOWER_LIMIT = 1;
	public final Integer[] set;

	public IntSet(Integer[] set) {
		super();
		this.set = CreatenewSet(set);
	}

	/**
	 * Create new Set
	 * @param input array of inputs
	 * @return array of SET
	 */
	private Integer[] CreatenewSet(Integer[] input) {
		List<Integer> list = new ArrayList<Integer>();
		Integer[] set;
		for (int loop = 0; loop < input.length; loop++) {
			if (input[loop] < LOWER_LIMIT || input[loop] > UPPER_LIMIT) {
				throw new AssertionError();
			}
			if (list.contains(input[loop])) {
				continue;
			} else {
				list.add(input[loop]);
			}
		}
		set = new Integer[list.size()];
		return list.toArray(set);
	}

	/**
	 * Find value is member of set or not
	 * @param value search value
	 * @return true if member else false
	 */
	public boolean isMember(Integer value) {
		if (value < LOWER_LIMIT || value > UPPER_LIMIT) {
			return false;
		}
		for (int loop = 0; loop < this.set.length; loop++) {
			if (value == set[loop]) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Find size of Set
	 * @return size of set
	 */
	public Integer size() {
		return this.set.length;
	}

	/**
	 * Find subset is present in the set or not
	 * @param subSet 
	 * @return true if subset present else return false
	 */
	public boolean isSubSet(IntSet subSet) {
		List<Integer> mainset = new ArrayList<Integer>(Arrays.asList(this.set));
		List<Integer> subset = new ArrayList<Integer>(Arrays.asList(subSet.set));
		if (mainset.containsAll(subset)) {
			return true;
		}
		return false;
	}
	
	/**
	 * Find compliment of set
	 * @return compliment of set
	 */
	public IntSet getCompliment() {
		List<Integer> setList = new ArrayList<Integer>(Arrays.asList(this.set));
		List<Integer> complimentList = new ArrayList<Integer>();
		Integer[] newSet;
		for (int loop = LOWER_LIMIT; loop <= UPPER_LIMIT; loop++) {
			if (setList.contains(loop)) { // if element is in set then
				continue; // don't add it to the complimentSet
			} else {
				complimentList.add(loop);
			}
		}
		Object objarr[] = complimentList.toArray();
		newSet = Arrays.copyOf(objarr, objarr.length, Integer[].class);
		IntSet complimentSet = new IntSet(newSet); 
		return complimentSet;
	}

	/**
	 * Find Union of two sets
	 * @param firstSet
	 * @param secondSet
	 * @return union
	 */
	@Override
	public IntSet union(IntSet firstSet, IntSet secondSet) {
		List<Integer> set1 = new ArrayList<Integer>(Arrays.asList(firstSet.set));
		List<Integer> set2 = new ArrayList<Integer>(Arrays.asList(secondSet.set));
		List<Integer> unionSet = new ArrayList<Integer>();
		unionSet.addAll(set1);
		for (int loop = 0; loop < set2.size(); loop++) {
			if (!unionSet.contains(set2.get(loop))) { 
				unionSet.add(set2.get(loop)); 
			}
		}
		Object objarr[] = unionSet.toArray();
		Integer intarr[] = Arrays.copyOf(objarr, objarr.length, Integer[].class);
		IntSet union = new IntSet(intarr);
		return union;
	}

}
