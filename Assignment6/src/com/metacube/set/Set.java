package com.metacube.set;

public interface Set {

	public boolean isMember(Integer value);
	public Integer size();
	public boolean isSubSet(IntSet subSet);
	public IntSet getCompliment();
	public  IntSet union(IntSet firstSet, IntSet secondSet);
}
