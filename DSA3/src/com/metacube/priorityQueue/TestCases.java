package com.metacube.priorityQueue;

import junit.framework.Assert;

import org.junit.Test;

public class TestCases {

	@Test
	public void testenqueue(){
		Queue queue = new Queue(5);
		queue.enqueue(1, 2);
		queue.enqueue(1, 3);
		queue.enqueue(1, 4);
		queue.enqueue(1, 6);
		Task[] task = queue.getTasks();
		Integer array[] = new Integer[]{6,4,3,2};
		for(int loop=0; loop<5-1;loop++){
			Assert.assertEquals(array[loop],task[loop].priority);
		}
	}
	
	@Test
	public void testdequeue(){
		Queue queue = new Queue(5);
		queue.enqueue(1, 2);
		queue.enqueue(3, 3);
		queue.enqueue(2, 4);
		queue.enqueue(4, 6);
		Assert.assertEquals((Integer)4, queue.dequeue());
	}
}
