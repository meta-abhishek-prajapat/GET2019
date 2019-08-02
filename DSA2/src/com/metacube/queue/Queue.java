package com.metacube.queue;

public interface Queue<T> {

	public boolean enqueue(T element)  ;
	public T dequeue() ;
	public boolean isEmpty();
	public boolean isFull() ;

}
