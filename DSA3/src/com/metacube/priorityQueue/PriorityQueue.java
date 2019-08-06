package com.metacube.priorityQueue;

public interface PriorityQueue {
	
	public void enqueue(Integer data, Integer priority);
	
	public Integer dequeue();
	
	public Integer peek();
	
	public boolean isEmpty();
	
	public boolean isFull();

}