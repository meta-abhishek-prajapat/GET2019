package com.metacube.queue;

public class CircularQueue<T> implements Queue<T> {

	Integer front, rear;
	Integer size;
	Integer array[];

	public CircularQueue(Integer capacity) {
		super();
		this.size=capacity;
		this.front = this.rear =  - 1;
		array = new Integer[capacity];

	}
	
	/**
	 * Insert the element into the queue.
	 * if queue is full throw Assertion Error else true
	 */
	@Override
	public boolean enqueue(T element) {
		if(isFull())
	    {
	       throw new AssertionError("Queue is full");
	    } 
	    else 
	    {
	        if(front == -1)
	        {   
	            front = 0;
	        }
	        rear = (rear + 1) % this.size;   
	        array[rear] = (Integer) element;
	        return true;
	    }
	}

	/**
	 * Delete an element in queue
	 * if queue is empty throw Assertion Error
	 */
	@Override
	public T dequeue() {
		T data;
	    
	    if(isEmpty())
	    {
	    	throw new AssertionError("Queue is empty");
	    } 
	    else 
	    {
	    	data = (T) array[front];
	        if(front == rear)
	        {
	            front = -1;
	            rear = -1;
	        }
	        else 
	        {
	            front = (front+1) % this.size;
	        }
	        return (T)data;
	    }
	}

	/**
	 * Check queue is Empty or not.
	 * return true if empty otherwise false.
	 */
	@Override
	public boolean isEmpty() {
		 if(front == -1) 
	        {
	            return true;
	        }
	        else 
	        {
	            return false;
	        }
	}

	/**
	 * Check queue is Full or not.
	 * return true if full otherwise false.
	 */
	@Override
	public boolean isFull() {
		if(front == 0 && rear == size - 1)
        {
            return true;
        }
        if(front == rear + 1) 
        {
            return true;
        }
        return false;
	}


}
